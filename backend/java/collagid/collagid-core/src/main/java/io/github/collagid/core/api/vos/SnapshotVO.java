package io.github.collagid.core.api.vos;

import java.util.List;
import java.util.Map;

public class SnapshotVO {
    private String dstId;
    private List<ViewVO> views;
    private Map<String, FieldVO> fieldMap;
    private Map<String, RecordVO> recordMap;
    private int v;

    // Getters and Setters
    public String getDstId() {
        return dstId;
    }

    public void setDstId(String dstId) {
        this.dstId = dstId;
    }

    public List<ViewVO> getViews() {
        return views;
    }

    public void setViews(List<ViewVO> views) {
        this.views = views;
    }

    public Map<String, FieldVO> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, FieldVO> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public Map<String, RecordVO> getRecordMap() {
        return recordMap;
    }

    public void setRecordMap(Map<String, RecordVO> recordMap) {
        this.recordMap = recordMap;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}

