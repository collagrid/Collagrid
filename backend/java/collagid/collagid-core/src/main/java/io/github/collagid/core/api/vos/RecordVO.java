package io.github.collagid.core.api.vos;

import java.util.List;
import java.util.Map;

public class RecordVO {
    private String id;
    private int v;
    private Map<String, List<FieldDataVO>> data;
    private List<String> oph;
    private long ca;
    private long ua;
    private List<Integer> rh;

    // Getters and Setters
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

    public Map<String, List<FieldDataVO>> getData() {
        return data;
    }

    public void setData(Map<String, List<FieldDataVO>> data) {
        this.data = data;
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
}

