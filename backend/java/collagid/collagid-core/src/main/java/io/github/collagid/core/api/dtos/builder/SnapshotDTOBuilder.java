package io.github.collagid.core.api.dtos.builder;

import io.github.collagid.core.api.dtos.RecordDTO;
import io.github.collagid.core.api.dtos.SnapshotDTO;
import io.github.collagid.core.api.dtos.ViewDTO;
import io.github.collagid.core.api.field.FieldDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotDTOBuilder {
    private String dstId;
    private List<ViewDTO> views;
    private Map<String, FieldDTO> fieldMap;
    private Map<String, RecordDTO> recordMap;
    private int v;

    public SnapshotDTOBuilder() {
        this.recordMap = new HashMap<>();
        this.fieldMap = new HashMap<>();
        this.views = new ArrayList<>();
    }

    public SnapshotDTOBuilder setDstId(String dstId) {
        this.dstId = dstId;
        return this;
    }

    public SnapshotDTOBuilder setViews(List<ViewDTO> views) {
        this.views = views;
        return this;
    }

    public SnapshotDTOBuilder setFieldMap(Map<String, FieldDTO> fieldMap) {
        this.fieldMap = fieldMap;
        return this;
    }

    public SnapshotDTOBuilder setRecordMap(Map<String, RecordDTO> recordMap) {
        this.recordMap = recordMap;
        return this;
    }

    public SnapshotDTOBuilder setV(int v) {
        this.v = v;
        return this;
    }

    // 构建方法
    public SnapshotDTO build() {
        return new SnapshotDTO(this);
    }

    public String getDstId() {
        return dstId;
    }

    public List<ViewDTO> getViews() {
        return views;
    }

    public Map<String, FieldDTO> getFieldMap() {
        return fieldMap;
    }

    public Map<String, RecordDTO> getRecordMap() {
        return recordMap;
    }

    public int getV() {
        return v;
    }
}
