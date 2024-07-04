package io.github.collagid.core.api.vos;

import java.util.List;

public class ViewVO {
    private String viewId;
    private List<RowVO> rows;
    private List<ChunkVO> chunks;
    private List<ColumnVO> columns;
    private long ca;
    private long ua;

    // Getters and Setters
    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public List<RowVO> getRows() {
        return rows;
    }

    public void setRows(List<RowVO> rows) {
        this.rows = rows;
    }

    public List<ChunkVO> getChunks() {
        return chunks;
    }

    public void setChunks(List<ChunkVO> chunks) {
        this.chunks = chunks;
    }

    public List<ColumnVO> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnVO> columns) {
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

