package com.mongodb.internal.bulk;

/* loaded from: grasscutter.jar:com/mongodb/internal/bulk/WriteRequest.class */
public abstract class WriteRequest {

    /* loaded from: grasscutter.jar:com/mongodb/internal/bulk/WriteRequest$Type.class */
    public enum Type {
        INSERT,
        UPDATE,
        REPLACE,
        DELETE
    }

    public abstract Type getType();
}
