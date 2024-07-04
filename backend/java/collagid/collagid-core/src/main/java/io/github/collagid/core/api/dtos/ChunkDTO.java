package io.github.collagid.core.api.dtos;

import io.github.collagid.core.api.dtos.builder.ChunkDTOBuilder;

public class ChunkDTO {
    private String chunkId;
    private int count;
    private String firstId;
    private String lastId;

    public ChunkDTO(ChunkDTOBuilder chunkDTOBuilder) {
        this.chunkId = chunkDTOBuilder.getChunkId();
        this.count = chunkDTOBuilder.getCount();
        this.firstId = chunkDTOBuilder.getFirstId();
        this.lastId = chunkDTOBuilder.getLastId();
    }

    // Getters and Setters
    public String getChunkId() {
        return chunkId;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFirstId() {
        return firstId;
    }

    public void setFirstId(String firstId) {
        this.firstId = firstId;
    }

    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }
}
