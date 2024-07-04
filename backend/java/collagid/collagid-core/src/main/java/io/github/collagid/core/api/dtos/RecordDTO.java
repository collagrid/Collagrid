package io.github.collagid.core.api.dtos;

import io.github.collagid.core.api.dtos.builder.RecordDTOBuilder;

import java.util.List;
import java.util.Map;

public class RecordDTO {
    private String id;
    private int v;
    private Map<String, List<FieldDataDTO>> data;
    private List<String> oph;
    private long ca;
    private long ua;
    private List<Integer> rh;

    public RecordDTO(RecordDTOBuilder builder) {
        this.id = builder.getId();
        this.v = builder.getV();
        this.data = builder.getData();
        this.oph = builder.getOph();
        this.ca = builder.getCa();
        this.ua = builder.getUa();
        this.rh = builder.getRh();
    }

    public String getId() {
        return id;
    }
}
