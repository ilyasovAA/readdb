package com.rosregistry.readofsndb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosregistry.readofsndb.Constants;
import com.rosregistry.readofsndb.client.DirectoryServiceClient;
import com.rosregistry.readofsndb.domain.DataTypeInfo;
import com.rosregistry.readofsndb.dto.directory.DirRecord;
import com.rosregistry.readofsndb.dto.directory.FilterDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class DirCacheService {

    private final DirectoryServiceClient directoryServiceClient;

    private final Map<String, Map<String, DirRecord>> dirRecords = new ConcurrentHashMap<>();

    private final DSLContext dslContext;

    @PostConstruct
    public void init() {

    }

    public void load(String atteName) {
//        log.info("Загрузка справочника для атрибута: " + atteName);
        var dataTypeInfo = Constants.DATA_TYPE_INFO.get(atteName);
        if (dataTypeInfo == null) {
            final var tableAttr = Constants.TABLE_MAPPINGS.get(atteName);
            dataTypeInfo = Constants.DATA_TYPE_INFO.get(tableAttr);
        }
        load(dataTypeInfo, dataTypeInfo.getIdentifier());
    }

    private void load(DataTypeInfo dataTypeInfo, String systemName) {
        synchronized (this) {
            dirRecords.computeIfAbsent(systemName, sysName -> {

                log.info("Загрузка справочника: " + dataTypeInfo.getIdentifier());

                if (dataTypeInfo.getIdentifier().equals("OKTMO_alfa") || dataTypeInfo.getIdentifier().equals("s_OKATO_alfa")) {
                    return new HashMap<>();
                }

                var directoryRecords = directoryServiceClient.getDirectoryRecords(systemName);
                var items = directoryRecords.getItems();
                var nextPageToken = directoryRecords.getPaging().getNextPageToken();
                while (nextPageToken != null) {
                    try {
                        directoryRecords = directoryServiceClient.getDirectoryRecords(systemName, nextPageToken);
                        items.addAll(directoryRecords.getItems());
                        nextPageToken = directoryRecords.getPaging().getNextPageToken();
                        log.info(String.format("systemName: %s size: %d", systemName, items.size()));
                    } catch (Exception ex) {
                        log.error(String.format("systemName: %s size: %d, error: %s", systemName, items.size(), ex.getMessage()));
                    }
                }

                Map<String, DirRecord> res = new HashMap<>();
                //TODO !!!
                items.forEach(item -> res.put(getKey(item, dataTypeInfo), item));
                return res;
            });
        }
    }

    private String getKey(DirRecord record, DataTypeInfo dataTypeInfo) {

        if (dataTypeInfo.getIdentifier().equals("on_type") || dataTypeInfo.getIdentifier().equals("update_type")) {
            return String.valueOf(record.getAttributes().get("value"));
        }

        String sDate = record.getStartDate() == null ? ""
                : LocalDateTime.parse(record.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

        String eDate = record.getEndDate() == null ? ""
                : LocalDateTime.parse(record.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

        return record.getAttributes().get(dataTypeInfo.getKeys().get(0)) + "_" + record.getAttributes().get(dataTypeInfo.getKeys().get(1)) + "_" + sDate + "_" + eDate;
    }

    private String getKey(Record record, DataTypeInfo dataTypeInfo) {
        String sDate = record.getValue("s_date") == null ? "" :
                ((Timestamp) record.getValue("s_date")).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        String eDate = record.getValue("e_date") == null ? "" :
                ((Timestamp) record.getValue("e_date")).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

        return record.getValue(dataTypeInfo.getKeys().get(0)) + "_" + record.getValue(dataTypeInfo.getKeys().get(1)) + "_" + sDate + "_" + eDate;
    }

    public UUID getUuid(DataTypeInfo dataTypeInfo, Long idFromDump) {

            if (dataTypeInfo.getIdentifier().equals("on_type") || dataTypeInfo.getIdentifier().equals("update_type")) {
                return dirRecords.get(dataTypeInfo.getIdentifier()).get(String.valueOf(idFromDump)).getUuid();
            }

            final var record = dslContext.selectFrom(dataTypeInfo.getTableName())
                    .where(DSL.condition("id = ?", idFromDump)).fetchOne();

            var existRecord = dirRecords.get(dataTypeInfo.getIdentifier()).get(getKey(record, dataTypeInfo));
            if (existRecord == null) {
                if (dataTypeInfo.getIdentifier().equals("OKTMO_alfa") || dataTypeInfo.getIdentifier().equals("s_OKATO_alfa")) {
                    synchronized (this) {
                        final var records = findRecord(dataTypeInfo, record);
                        for (DirRecord dirRecord : records) {
                            dirRecords.get(dataTypeInfo.getIdentifier()).put(getKey(dirRecord, dataTypeInfo), dirRecord);
                        }

                        existRecord = dirRecords.get(dataTypeInfo.getIdentifier()).get(getKey(record, dataTypeInfo));
                    }
                }
            }

            return existRecord.getUuid();
    }

    @SneakyThrows
    private List<DirRecord> findRecord(DataTypeInfo dataTypeInfo, Record record) {
        List<FilterDto> filterDtos = List.of(FilterDto.builder()
                        .fieldName(dataTypeInfo.getKeys().get(0))
                        .operatorType("EQUALS")
                        .value(String.valueOf(record.getValue(dataTypeInfo.getKeys().get(0)))).build(),
                FilterDto.builder()
                        .fieldName(dataTypeInfo.getKeys().get(1))
                        .operatorType("EQUALS")
                        .value(String.valueOf(record.getValue(dataTypeInfo.getKeys().get(1)))).build()
        );

        return directoryServiceClient.findRecords(dataTypeInfo.getIdentifier(), new ObjectMapper().writeValueAsString(filterDtos)).getItems();

    }
}

