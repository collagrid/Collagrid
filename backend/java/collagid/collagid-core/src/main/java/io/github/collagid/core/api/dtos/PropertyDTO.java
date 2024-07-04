package io.github.collagid.core.api.dtos;

public class PropertyDTO {
    private String defaultValue;

    public PropertyDTO() {
        this.defaultValue = "";
    }

    // Getters and Setters
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
