package io.github.collagid.core.api.dtos;

import io.github.collagid.core.api.dtos.builder.FieldDataDTOBuilder;

public class FieldDataDTO {
    private String t;
    private DataDTO data;
    private int v;

    public FieldDataDTO(FieldDataDTOBuilder fieldDataDTOBuilder) {
        this.t = fieldDataDTOBuilder.getT();
        this.data = fieldDataDTOBuilder.getData();
        this.v = fieldDataDTOBuilder.getV();
    }
}
