package com.rosregistry.readofsndb.service;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Cursor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import static org.jooq.impl.DSL.asterisk;
import static org.jooq.impl.DSL.condition;
import static org.jooq.impl.DSL.one;

@Getter
@Slf4j
@Component
@Scope("singleton")
public class ObjectsTableCursor {
    private Cursor cursor;
    private DSLContext dslContext;

    @Value("${sql-condition:(1 = 1)}")
    private String condition = "(1 = 1)";

    public ObjectsTableCursor(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @PostConstruct
    public void init() {
        this.cursor = dslContext.select(asterisk())
                .from("entity")
                .where(condition(condition))
                .orderBy(one())
                .fetchLazy();

        this.count = dslContext.selectCount().from("entity").fetchOne(0, int.class);
    }

    int i = 0;
    int count = 0;

    @SneakyThrows
    public Map<String, Object> fetchNext() {
        Map<String, Object> entity = cursor.fetchNext().intoMap();
        var entityId = (Long) entity.get("id");
        Record entityValues = dslContext.selectFrom("entity_value")
                .where(condition("id = (select value_id from entity_index where entity_record_id = ?)", entityId))
                .fetchAny();
        if (entityValues != null) {
            entity.putAll(entityValues.intoMap());
        }

        Record entityIndex = dslContext.selectFrom("entity_index").where(condition("entity_record_id = ?", entityId)).fetchAny();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        var value = entityIndex.getValue("record_period_from");
        if (value instanceof Timestamp)
            value = dateFormat.format(value);
        value = dateFormat.format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(String.valueOf(value)));

        entity.put("ron_start_date", value);

        log.info(String.format("Получение обьекта ID = %s, обработано  %s из %s", entity.get("id"), ++i, count ));
        return entity;
    }

    public boolean hasNext() {
        return cursor.hasNext();
    }

}
