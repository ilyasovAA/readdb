package com.rosregistry.readofsndb.dto.directory;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterDto {
    private String fieldName;
    private String operatorType = "EQUALS";
    private String value;
}
