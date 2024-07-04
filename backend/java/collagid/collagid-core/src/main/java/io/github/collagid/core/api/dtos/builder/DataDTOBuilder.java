package io.github.collagid.core.api.dtos.builder;

import io.github.collagid.core.api.dtos.DataDTO;

public class DataDTOBuilder {

    public DataDTOBuilder(){}

    public DataDTO build(){
        return new DataDTO(this);
    }
}
