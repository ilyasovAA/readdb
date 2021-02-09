package com.rosregistry.readofsndb.dto.metadata;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@JsonAutoDetect
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class OperationalColumnGroupForm {
    private String name;
    private UUID executiveAuthorityUuid;
    private Boolean isPrimary;
    private UUID observationObjectTypeUuid;
    private String tableName;
}
