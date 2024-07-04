package io.github.collagid.core.api.dtos;

import io.github.collagid.core.api.dtos.builder.ViewDTOBuilder;

import java.util.List;

public class ViewDTO {
    private String viewId;
    private List<RowDTO> rows;
    private List<ChunkDTO> chunks;
    private List<ColumnDTO> columns;
    private long ca;
    private long ua;

    public ViewDTO(ViewDTOBuilder viewDTOBuilder) {
        this.viewId = viewDTOBuilder.getViewId();
        this.rows = viewDTOBuilder.getRows();
        this.chunks = viewDTOBuilder.getChunks();
        this.columns = viewDTOBuilder.getColumns();
        this.ca = viewDTOBuilder.getCa();
        this.ua = viewDTOBuilder.getUa();
    }

    // Getters and Setters
    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public List<RowDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowDTO> rows) {
        this.rows = rows;
    }

    public List<ChunkDTO> getChunks() {
        return chunks;
    }

    public void setChunks(List<ChunkDTO> chunks) {
        this.chunks = chunks;
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
}

