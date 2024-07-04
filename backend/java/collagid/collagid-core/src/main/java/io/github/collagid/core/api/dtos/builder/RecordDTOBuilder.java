package io.github.collagid.core.api.dtos.builder;

import io.github.collagid.core.api.dtos.RecordDTO;
import io.github.collagid.core.api.dtos.FieldDataDTO;

import java.util.List;
import java.util.Map;

public class RecordDTOBuilder {
    private String id;
    private int v;
    private Map<String, List<FieldDataDTO>> data;
    private List<String> oph;
    private long ca;
    private long ua;
    private List<Integer> rh;

    public RecordDTO build() {
        return new RecordDTO(this);
    }

    public RecordDTOBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public RecordDTOBuilder setV(int v) {
        this.v = v;
        return this;
    }

    public RecordDTOBuilder setData(Map<String, List<FieldDataDTO>> data) {
        this.data = data;
        return this;
    }

    public RecordDTOBuilder setOph(List<String> oph) {
        this.oph = oph;
        return this;
    }

    public RecordDTOBuilder setCa(long ca) {
        this.ca = ca;
        return this;
    }

    public RecordDTOBuilder setUa(long ua) {
        this.ua = ua;
        return this;
    }

    public RecordDTOBuilder setRh(List<Integer> rh) {
        this.rh = rh;
        return this;
    }

    public String getId() {
        return id;
    }

    public int getV() {
        return v;
    }

    public Map<String, List<FieldDataDTO>> getData() {
        return data;
    }

    public List<String> getOph() {
        return oph;
    }

    public long getCa() {
        return ca;
    }

    public long getUa() {
        return ua;
    }

    public List<Integer> getRh() {
        return rh;
    }
}
