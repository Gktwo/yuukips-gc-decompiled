package com.mongodb;

import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/BulkWriteResult.class */
public abstract class BulkWriteResult {
    public abstract boolean isAcknowledged();

    public abstract int getInsertedCount();

    public abstract int getMatchedCount();

    public abstract int getRemovedCount();

    public abstract int getModifiedCount();

    public abstract List<BulkWriteUpsert> getUpserts();
}
