package com.rosregistry.readofsndb.rest;

import com.rosregistry.readofsndb.service.ObjectsTableCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/object")
@RequiredArgsConstructor
public class RecordController {

    private final ObjectsTableCursor objectsTableCursor;

    @Value("${sizePacket:100}")
    private int sizePacket;

    @GetMapping
    public List<Map<String, Object>> getNextObject() {
        var result = new ArrayList<Map<String, Object>>();

        synchronized (this) {
            for (int i = 0; i < sizePacket; i++) {
                if (objectsTableCursor.hasNext()) {
                    result.add(objectsTableCursor.fetchNext());
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
