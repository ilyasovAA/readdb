package com.rosregistry.readofsndb.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DataTypeInfo {
    private String tableName;
    private String identifier;
    private DataTypeName dataTypeName;
    private boolean isArray;
    private String vocTypeSysName;
    private List<String> keys;
}
