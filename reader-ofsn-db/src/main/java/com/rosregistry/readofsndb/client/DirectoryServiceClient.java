package com.rosregistry.readofsndb.client;

import com.rosregistry.readofsndb.dto.Pageable;
import com.rosregistry.readofsndb.dto.directory.DirRecord;
import com.rosregistry.readofsndb.dto.directory.DirectoryAttribute;
import com.rosregistry.readofsndb.dto.directory.DirectoryDto;
import com.rosregistry.readofsndb.dto.directory.DirectoryRecordDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Map;

public interface DirectoryServiceClient {

    @RequestLine("GET /directory-service/records/{sysName}?withExpired=true&size=50")
    Pageable<DirRecord> getDirectoryRecords(@Param("sysName") String sysName);

    @RequestLine("GET /directory-service/records/{sysName}?withExpired=true&pageToken={nextPageToken}&size=50")
    Pageable<DirRecord> getDirectoryRecords(@Param("sysName") String sysName, @Param("nextPageToken") String nextPageToken);

    @RequestLine("GET /directory-service/records/{sysName}?filtering={filter}&withExpired=true&size=1000")
    Pageable<DirRecord> findRecords(@Param("sysName") String sysName, @Param("filter") String filter);

}