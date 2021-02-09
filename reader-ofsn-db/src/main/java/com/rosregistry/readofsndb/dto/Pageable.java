package com.rosregistry.readofsndb.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonAutoDetect
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pageable<T> {
    private List<T> items;
    private int size;

    private Paging paging;

    @Data
    public static final class Paging {
        @JsonProperty
        private String previousPageToken;
        @JsonProperty
        private String nextPageToken;
    }

}