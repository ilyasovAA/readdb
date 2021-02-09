package com.rosregistry.readofsndb.rest;

import com.rosregistry.readofsndb.dto.directory.DirectoryUuidForm;
import com.rosregistry.readofsndb.service.DirCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/directory/")
public class DirectoryController {

    private final DirCacheService dirCacheService;

    @PostMapping
    public UUID getUUID(@RequestBody DirectoryUuidForm request) {
        return dirCacheService.getUuid(request.getDataTypeInfo(), request.getId());
    }

    @GetMapping("/{systemName}/{targetDirAttributeName}")
    public void load(@PathVariable String systemName, @PathVariable String targetDirAttributeName) {
        dirCacheService.load(systemName);
    }
}
