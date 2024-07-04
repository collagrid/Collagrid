package io.github.collagid.core.api.vos;

public class ColumnVO {
    private String columnId;
    private boolean hidden;

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
