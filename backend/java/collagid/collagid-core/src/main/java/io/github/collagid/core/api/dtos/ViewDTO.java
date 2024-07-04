package io.github.collagid.core.api.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewDTO {
    private String viewId;
    private List<ChunkDTO> chunks;
    private List<ColumnDTO> columns;
    private long ca;
    private long ua;

    public ViewDTO() {
        this.chunks = new ArrayList<>();
        this.columns = new ArrayList<>();
    }

    // Getters and Setters
    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public List<ChunkDTO> getChunks() {
        return chunks;
    }

    public List<ColumnDTO> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnDTO> columns) {
        this.columns = columns;
    }

    public long getCa() {
        return ca;
    }

    public void setCa(long ca) {
        this.ca = ca;
    }

    public long getUa() {
        return ua;
    }

    public void setUa(long ua) {
        this.ua = ua;
    }

    public void addChunk(ChunkDTO chunkDTO) {
        this.chunks.add(chunkDTO);
    }
}

