package io.github.collagid.core.api.dtos.builder;

import io.github.collagid.core.api.dtos.DataDTO;
import io.github.collagid.core.api.dtos.FieldDataDTO;

public class FieldDataDTOBuilder {
    private String t;
    private DataDTO data;
    private int v;

    public FieldDataDTOBuilder setT(String t) {
        this.t = t;
        return this;
    }

    public FieldDataDTOBuilder setData(DataDTO data) {
        this.data = data;
        return this;
    }

    public FieldDataDTOBuilder setV(int v) {
        this.v = v;
        return this;
    }

    // 构建方法
    public FieldDataDTO build() {
        return new FieldDataDTO(this);
    }

    public String getT() {
        return t;
    }

    public DataDTO getData() {
        return data;
    }

    public int getV() {
        return v;
    }
}
