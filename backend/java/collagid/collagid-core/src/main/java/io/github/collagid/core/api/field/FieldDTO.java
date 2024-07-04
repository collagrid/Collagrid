package io.github.collagid.core.api.field;

import io.github.collagid.core.api.dtos.PropertyDTO;
import io.github.collagid.core.api.vos.dst.PropertyVO;

public class FieldDTO {
    private String id;
    private String name;
    private int type;
    private PropertyDTO property;

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

    public PropertyDTO getProperty() {
        return property;
    }

    public void setProperty(PropertyDTO property) {
        this.property = property;
    }
}
