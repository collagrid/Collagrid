package io.github.collagid.core.api.dtos;

import io.github.collagid.core.api.event.CollaGridEventPublisher;
import io.github.collagid.core.api.record.event.RecordUpdatedEvent;
import io.github.collagid.core.api.snapshot.event.SnapshotCreateEvent;
import io.github.collagid.core.api.utils.CopyOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordDTO implements CopyOne<RecordDTO> {
    private String id;
    private int v;
    private Map<String, List<FieldDataDTO>> data;
    private List<String> oph;
    private long ca;
    private long ua;
    private List<Integer> rh;

    public RecordDTO() {
        this.data = new HashMap<>();
    }

    public void applyFieldData(String id, FieldDataDTO fieldDataDTO) {
        this.data.computeIfAbsent(id, k -> new ArrayList<>()).add(fieldDataDTO);

        CollaGridEventPublisher.publishEvent(new RecordUpdatedEvent(this));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Map<String, List<FieldDataDTO>> getData() {
        return data;
    }

    public List<String> getOph() {
        return oph;
    }

    public void setOph(List<String> oph) {
        this.oph = oph;
    }

    public long getCa() {
        return ca;
    }

    public void setCa(long ca) {
        this.ca = ca;
    }

    public long getUa() {
        return ua;
    }

    public void setUa(long ua) {
        this.ua = ua;
    }

    public List<Integer> getRh() {
        return rh;
    }

    public void setRh(List<Integer> rh) {
        this.rh = rh;
    }

    public List<FieldDataDTO> getFieldData(String fieldColumnId) {
        return this.data.get(fieldColumnId);
    }

    @Override
    public RecordDTO doCopy() {
        RecordDTO copy = new RecordDTO();
        copy.id = id;
        copy.v = v;
        copy.data = data;
        copy.oph = oph;
        copy.ca = ca;
        copy.ua = ua;
        copy.rh = rh;
        return copy;
    }
}
