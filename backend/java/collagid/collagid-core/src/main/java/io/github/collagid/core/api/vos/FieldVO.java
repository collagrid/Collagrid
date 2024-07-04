package io.github.collagid.core.api.vos;

import java.util.List;
import java.util.Map;

public class FieldVO {
    private String id;
    private String name;
    private int type;
    private PropertyVO property;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public PropertyVO getProperty() {
        return property;
    }

    public void setProperty(PropertyVO property) {
        this.property = property;
    }
}
