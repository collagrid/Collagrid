package io.github.collagid.core.api.dtos;

public class RowDTO {
    private String id;
    private String chunkId;

    public RowDTO(String id, String chunkId) {
        this.id = id;
        this.chunkId = chunkId;
    }

    public RowDTO() {
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
