package io.github.collagid.core.api.dtos.builder;

import io.github.collagid.core.api.dtos.ChunkDTO;

public class ChunkDTOBuilder {
    private String chunkId;
    private int count;
    private String firstId;
    private String lastId;

    public ChunkDTO build(){
        return new ChunkDTO(this);
    }


    public ChunkDTOBuilder() {
    }

    public ChunkDTOBuilder(String chunkId, int count, String firstId, String lastId) {
        this.chunkId = chunkId;
        this.count = count;
        this.firstId = firstId;
        this.lastId = lastId;
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
