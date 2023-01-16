package com.mongodb.session;

import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/session/ServerSession.class */
public interface ServerSession {
    BsonDocument getIdentifier();

    long getTransactionNumber();

    long advanceTransactionNumber();

    boolean isClosed();

    void markDirty();

    boolean isMarkedDirty();
}
