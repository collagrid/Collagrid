package io.github.collagid.core.api.dtos;

import io.github.collagid.core.api.dtos.builder.RowDTOBuilder;

public class RowDTO {
    private String id;
    private String chunkId;

    public RowDTO(RowDTOBuilder rowDTOBuilder) {
        this.id = rowDTOBuilder.getId();
        this.chunkId = rowDTOBuilder.getChunkId();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChunkId() {
        return chunkId;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }
}
