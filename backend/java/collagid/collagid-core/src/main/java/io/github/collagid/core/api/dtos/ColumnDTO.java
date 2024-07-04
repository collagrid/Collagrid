package io.github.collagid.core.api.dtos;

public class ColumnDTO {
    private String columnId;
    private boolean hidden;

    public ColumnDTO(String columnId, boolean hidden) {
        this.columnId = columnId;
        this.hidden = hidden;
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
