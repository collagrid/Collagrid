package io.github.collagid.core.api.dtos;

import io.github.collagid.core.api.dtos.builder.ColumnDTOBuilder;

public class ColumnDTO {
    private String columnId;
    private boolean hidden;

    public ColumnDTO(ColumnDTOBuilder columnDTOBuilder) {
        this.columnId = columnDTOBuilder.getColumnId();
        this.hidden = columnDTOBuilder.isHidden();
    }

    // Getters and Setters
    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
