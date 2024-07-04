package io.github.collagid.core.api.dtos.builder;

import io.github.collagid.core.api.dtos.ColumnDTO;

public class ColumnDTOBuilder {
    private String columnId;
    private boolean hidden;

    public ColumnDTO build(){
        return new ColumnDTO(this);
    }

    public ColumnDTOBuilder() {
    }

    public ColumnDTOBuilder(String columnId, boolean hidden) {
        this.columnId = columnId;
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }
}
