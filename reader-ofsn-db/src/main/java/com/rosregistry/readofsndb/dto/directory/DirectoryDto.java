package com.rosregistry.readofsndb.dto.directory;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class DirectoryDto {

    private UUID uuid;

    private String description;
    private String directoryType;
    private String externalIdentifier;
    private String externalSourceName;
    private String name;
    private String systemName;
    private Map<String, String> validityPeriod;
    private List<DirectoryAttribute> attributes;

}
