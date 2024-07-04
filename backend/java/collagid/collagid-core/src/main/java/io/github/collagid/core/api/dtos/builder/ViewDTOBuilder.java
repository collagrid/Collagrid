package io.github.collagid.core.api.dtos.builder;

import io.github.collagid.core.api.dtos.ChunkDTO;
import io.github.collagid.core.api.dtos.ColumnDTO;
import io.github.collagid.core.api.dtos.RowDTO;
import io.github.collagid.core.api.dtos.ViewDTO;

import java.util.List;

public class ViewDTOBuilder {
    private String viewId;
    private List<RowDTO> rows;
    private List<ChunkDTO> chunks;
    private List<ColumnDTO> columns;
    private long ca;
    private long ua;

    public ViewDTO build(){
        return new ViewDTO(this);
    }

    public ViewDTOBuilder() {
    }

    public ViewDTOBuilder(String viewId, List<RowDTO> rows, List<ChunkDTO> chunks, List<ColumnDTO> columns, long ca, long ua) {
        this.viewId = viewId;
        this.rows = rows;
        this.chunks = chunks;
        this.columns = columns;
        this.ca = ca;
        this.ua = ua;
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

