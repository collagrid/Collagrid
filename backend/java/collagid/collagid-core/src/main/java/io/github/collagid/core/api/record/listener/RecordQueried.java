package io.github.collagid.core.api.record.listener;

import io.github.collagid.core.api.event.CollaGridEventListener;
import io.github.collagid.core.api.record.event.RecordOption;
import io.github.collagid.core.api.record.event.RecordQueryEvent;

public interface RecordQueried extends CollaGridEventListener<RecordQueryEvent> {

    void onRecordQueried(RecordQueryEvent option);

    @Override
    default void handle(RecordQueryEvent event) {
        System.out.println("xxxx");
        this.onRecordQueried(event);
    }

}
