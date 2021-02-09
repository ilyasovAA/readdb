package com.rosregistry.readofsndb.dto.directory;

import com.rosregistry.readofsndb.domain.DataTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DirectoryUuidForm {

    String systemName;
    DataTypeInfo dataTypeInfo;
    Long id;
}
