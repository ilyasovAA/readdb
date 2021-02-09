package com.rosregistry.readofsndb.dto.directory;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class DirectoryUuidDto {

    List<UUID> uuidList;
    UUID uuid;
}
