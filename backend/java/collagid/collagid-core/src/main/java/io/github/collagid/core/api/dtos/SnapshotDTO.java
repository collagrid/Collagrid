package io.github.collagid.core.api.dtos;

import io.github.collagid.core.api.dtos.builder.RecordDTOBuilder;
import io.github.collagid.core.api.dtos.builder.SnapshotDTOBuilder;
import io.github.collagid.core.api.event.CollaGridEventPublisher;
import io.github.collagid.core.api.field.FieldDTO;
import io.github.collagid.core.api.record.event.RecordCreatedEvent;
import io.github.collagid.core.api.record.event.RecordQueryEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SnapshotDTO{
    private String dstId;
    private List<ViewDTO> views;
    private Map<String, FieldDTO> fieldMap;
    private Map<String, RecordDTO> recordMap;
    private int v;

    public SnapshotDTO(SnapshotDTOBuilder snapshotDTOBuilder){
        this.dstId = snapshotDTOBuilder.getDstId();
        this.views = snapshotDTOBuilder.getViews();
        this.fieldMap = snapshotDTOBuilder.getFieldMap();
        this.recordMap = snapshotDTOBuilder.getRecordMap();
        this.v = snapshotDTOBuilder.getV();
    }

    public Integer recordCount(){
        return this.recordMap.size();
    }

    public static class SnapshotDTOLoader {
        private String dstId;
        
        public SnapshotDTOLoader dstId(String dstId){
            this.dstId = dstId;
            return this;
        }

        public SnapshotDTO load(){
            // load records
            SnapshotDTO snapshotDTO = new SnapshotDTOBuilder().setDstId(this.dstId).build();
            snapshotDTO.addRecords(this.loadRecords());
            return snapshotDTO;
        }

        private List<RecordDTO> loadRecords() {
            List<RecordDTO> recordDTOS = new ArrayList<>();
            RecordDTOBuilder recordDTOBuilder = new RecordDTOBuilder();
            for (int i = 0; i < 100; i++) {
                RecordDTO recordDTO = recordDTOBuilder.setId("" + i).build();
                recordDTOS.add(recordDTO);
                CollaGridEventPublisher.publishEvent(new RecordQueryEvent(recordDTO));
            }
            return recordDTOS;
        }
    }

    private void addRecords(List<RecordDTO> recordDTOS) {
        for (RecordDTO recordDTO : recordDTOS) {
            this.addRecord(recordDTO);
        }
    }

    public String getDstId() {
        return dstId;
    }

    public void setDstId(String dstId) {
        this.dstId = dstId;
    }

    public RecordDTO addRecord(RecordDTO recordDTO){
        CollaGridEventPublisher.publishEvent(
            new RecordCreatedEvent(this, recordDTO)
        );
        this.recordMap.put(recordDTO.getId(), recordDTO);
        return recordDTO;
    }
    
    public FieldDTO addField(){
        return null;
    }

}