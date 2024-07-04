package io.github.collagid.core.api.dtos;


import io.github.collagid.core.api.event.CollaGridEventPublisher;
import io.github.collagid.core.api.record.event.RecordQueryEvent;
import io.github.collagid.core.api.record.event.async.RecordQueryEventAsync;

import java.util.ArrayList;
import java.util.List;

public class ChunkDTO {
    private String chunkId;
    private String dstId;
    private List<RowDTO> rows;
    private int count;
    private String firstId;
    private RecordDTO first;
    private String lastId;
    private RecordDTO last;
    private List<RecordDTO> records;

    public List<RecordDTO> getRecords() {
        return records;
    }

    public List<RowDTO> getRows() {
        return rows;
    }

    public ChunkDTO() {
        this.records = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public void addRecordIndex(RecordDTO record, boolean triggerReadEvent) {
        if (record == null) {
            return;
        }
        if (triggerReadEvent) {
            RecordQueryEventAsync recordQueryEvent = new RecordQueryEventAsync(record.doCopy());
            CollaGridEventPublisher.publishEventAsync(recordQueryEvent);
        }
        if (this.first == null) {
            this.first = record;
            this.firstId = record.getId();
        } else {
            this.last = record;
            this.lastId = record.getId();
        }
        this.rows.add(new RowDTO(chunkId, record.getId()));
        this.count++;
        this.records.add(record);
    }

    public String getChunkId() {
        return chunkId;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFirstId() {
        return firstId;
    }

    public void setFirstId(String firstId) {
        this.firstId = firstId;
    }

    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }

    public String getDstId() {
        return dstId;
    }

    public void setDstId(String dstId) {
        this.dstId = dstId;
    }
}
