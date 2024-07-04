package io.github.collagid.core.api;

import io.github.collagid.core.api.event.CollaGridEventListener;
import io.github.collagid.core.api.event.CollaGridEventPublisher;
import io.github.collagid.core.api.event.CollaGridEventType;
import io.github.collagid.core.api.record.event.RecordCreatedEvent;
import io.github.collagid.core.api.record.event.RecordOption;
import io.github.collagid.core.api.record.event.RecordQueryEvent;
import io.github.collagid.core.api.record.listener.RecordCreated;
import io.github.collagid.core.api.record.listener.RecordQueried;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnapshotDTOTest {
    @Test
    public void  testAddRecord(){
        AtomicInteger recordCounter = new AtomicInteger();
        AtomicInteger recordLoadedCounter = new AtomicInteger();
        CollaGridEventListener<RecordCreatedEvent> customListener = new RecordCreated() {
            @Override
            public void onRecordCreated(RecordCreatedEvent event) {
                recordCounter.incrementAndGet();
            }
        };

        CollaGridEventPublisher.addListener(CollaGridEventType.CREATE_RECORD, customListener);
        CollaGridEventPublisher.addListener(CollaGridEventType.QUERY_RECORD, new RecordQueried(){
            @Override
            public void onRecordQueried(RecordQueryEvent option) {
                recordLoadedCounter.incrementAndGet();
            }
        });
        SnapshotDTO dto = new SnapshotDTO.SnapshotDTOLoader().dstId("x").load();
        int c = 3;
        for (int i = 0; i < c; i++) {
            dto.addRecord();
        }
        assertEquals(c, recordCounter.get(), "add record listener works");
        assertEquals(dto.recordCount(), recordLoadedCounter.get(), "load record listener works");
    }
}