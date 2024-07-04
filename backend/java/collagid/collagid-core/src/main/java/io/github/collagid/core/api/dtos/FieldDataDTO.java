package io.github.collagid.core.api.dtos;


public class FieldDataDTO {
    private String t;
    private DataDTO data;
    private int v;

    public FieldDataDTO(String t, DataDTO data, int v) {}

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
