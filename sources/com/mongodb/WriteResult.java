package com.mongodb;

import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/WriteResult.class */
public class WriteResult {
    private final boolean acknowledged;

    /* renamed from: n */
    private final int f438n;
    private final boolean updateOfExisting;
    private final Object upsertedId;

    public static WriteResult unacknowledged() {
        return new WriteResult();
    }

    public WriteResult(int n, boolean updateOfExisting, @Nullable Object upsertedId) {
        this.acknowledged = true;
        this.f438n = n;
        this.updateOfExisting = updateOfExisting;
        this.upsertedId = upsertedId;
    }

    WriteResult() {
        this.acknowledged = false;
        this.f438n = 0;
        this.updateOfExisting = false;
        this.upsertedId = null;
    }

    public boolean wasAcknowledged() {
        return this.acknowledged;
    }

    public int getN() {
        throwIfUnacknowledged("n");
        return this.f438n;
    }

    @Nullable
    public Object getUpsertedId() {
        throwIfUnacknowledged("upsertedId");
        return this.upsertedId;
    }

    public boolean isUpdateOfExisting() {
        throwIfUnacknowledged("updateOfExisting");
        return this.updateOfExisting;
    }

    public String toString() {
        if (this.acknowledged) {
            return "WriteResult{n=" + this.f438n + ", updateOfExisting=" + this.updateOfExisting + ", upsertedId=" + this.upsertedId + '}';
        }
        return "WriteResult{acknowledged=false}";
    }

    private void throwIfUnacknowledged(String property) {
        if (!this.acknowledged) {
            throw new UnsupportedOperationException("Cannot get " + property + " property for an unacknowledged write");
        }
    }
}
