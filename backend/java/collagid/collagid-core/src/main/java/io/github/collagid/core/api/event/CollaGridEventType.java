package io.github.collagid.core.api.event;

public enum CollaGridEventType {
    CREATE_RECORD(false),
    CREATE_RECORD_ASYNC(true),
    UPDATE_RECORD(false),
    DELETE_RECORD(false),
    QUERY_RECORD(false),
    DATA_CREATE(true),
    DATA_UPDATE(true);

    private final boolean async;

    CollaGridEventType(boolean async) {
        this.async = async;
    }

    public boolean isAsync() {
        return async;
    }
}
