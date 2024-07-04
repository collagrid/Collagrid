package io.github.collagid.core.api;

import io.github.collagid.core.api.event.CollaGridEventPublisher;
import io.github.collagid.core.api.field.FieldDTO;
import io.github.collagid.core.api.record.RecordDTO;
import io.github.collagid.core.api.record.event.RecordCreatedEvent;

import java.util.List;

public class SnapshotDTO{
    private String dstId;
    
    private SnapshotDTO(){}

    public static class SnapshotDTOLoader {
        private String dstId;
        
        public SnapshotDTOLoader dstId(String dstId){
            this.dstId = dstId;
            return this;
        }
        
        public SnapshotDTO load(){
            System.out.println("load dstId: " + dstId);
            // load records
            List<RecordDTO> reocrds = this.loadRecords();
            return new SnapshotDTO();
        }

        private List<RecordDTO> loadRecords() {
            List<>
            return null;
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