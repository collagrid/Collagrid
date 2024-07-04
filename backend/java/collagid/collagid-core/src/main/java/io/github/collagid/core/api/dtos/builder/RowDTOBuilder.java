package io.github.collagid.core.api.dtos.builder;

import io.github.collagid.core.api.dtos.RowDTO;

public class RowDTOBuilder {
    private String id;
    private String chunkId;

    public RowDTO build(){
        return new RowDTO(this);
    }

    public RowDTOBuilder() {
    }

    public RowDTOBuilder(String id, String chunkId) {
        this.id = id;
        this.chunkId = chunkId;
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
