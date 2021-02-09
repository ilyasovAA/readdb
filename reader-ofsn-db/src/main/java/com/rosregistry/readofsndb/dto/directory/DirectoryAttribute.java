package com.rosregistry.readofsndb.dto.directory;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryAttribute {
    private DirectoryAttributeType attributeType;
    private String description;
    private String directorySystemName;
    private String name;
    private String systemName;
}
