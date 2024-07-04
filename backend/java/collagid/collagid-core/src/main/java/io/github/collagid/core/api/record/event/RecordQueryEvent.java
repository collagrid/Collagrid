package io.github.collagid.core.api.record.event;

import io.github.collagid.core.api.event.CollaGridEvent;
import io.github.collagid.core.api.event.CollaGridEventType;
import io.github.collagid.core.api.dtos.RecordDTO;

public class RecordQueryEvent implements CollaGridEvent {
    private RecordDTO dto;
    
    public RecordQueryEvent(RecordDTO dto){
        this.dto = dto;
    }

    public RecordDTO getDto() {
        return dto;
    }

    public void setDto(RecordDTO dto) {
        this.dto = dto;
    }

    @Override
    public CollaGridEventType getType() {
        return CollaGridEventType.QUERY_RECORD;
    }
}