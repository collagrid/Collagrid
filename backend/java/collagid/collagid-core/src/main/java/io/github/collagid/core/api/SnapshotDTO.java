package io.github.collagid.core.api;

import io.github.collagid.core.api.event.CollaGridEventPublisher;
import io.github.collagid.core.api.field.FieldDTO;
import io.github.collagid.core.api.record.RecordDTO;
import io.github.collagid.core.api.record.event.RecordCreatedEvent;
import io.github.collagid.core.api.record.event.RecordQueryEvent;

import java.util.ArrayList;
import java.util.List;

public class SnapshotDTO{
    private String dstId;

    private List<RecordDTO> recordDTOS;

    private SnapshotDTO(){}

    public Integer recordCount(){
        return this.recordDTOS.size();
    }

    public static class SnapshotDTOLoader {
        private String dstId;
        
        public SnapshotDTOLoader dstId(String dstId){
            this.dstId = dstId;
            return this;
        }
        
        public SnapshotDTO load(){
            System.out.println("load dstId: " + dstId);
            // load records
            SnapshotDTO snapshotDTO = new SnapshotDTO();
            snapshotDTO.recordDTOS = this.loadRecords();
            return snapshotDTO;
        }

        private List<RecordDTO> loadRecords() {
            List<RecordDTO> recordDTOS = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                RecordDTO recordDTO = new RecordDTO();
                recordDTOS.add(recordDTO);
                CollaGridEventPublisher.publishEvent(new RecordQueryEvent(recordDTO));
            }
            return recordDTOS;
        }
    }

    public String getDstId() {
        return dstId;
    }

    public void setDstId(String dstId) {
        this.dstId = dstId;
    }

    public RecordDTO addRecord(){
        RecordDTO recordDTO = new RecordDTO();
        recordDTO.setRecordId("" + System.currentTimeMillis());
        CollaGridEventPublisher.publishEvent(
            new RecordCreatedEvent(this, recordDTO)
        );
        return recordDTO;
    }
    
    public FieldDTO addField(){
        return null;
    }

}