package com.mongodb.internal.session;

import com.mongodb.ReadConcern;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:com/mongodb/internal/session/SessionContext.class */
public interface SessionContext {
    boolean hasSession();

    boolean isImplicitSession();

    BsonDocument getSessionId();

    boolean isCausallyConsistent();

    long getTransactionNumber();

    long advanceTransactionNumber();

    boolean notifyMessageSent();

    BsonTimestamp getOperationTime();

    void advanceOperationTime(BsonTimestamp bsonTimestamp);

    BsonDocument getClusterTime();

    void advanceClusterTime(BsonDocument bsonDocument);

    boolean hasActiveTransaction();

    ReadConcern getReadConcern();

    void setRecoveryToken(BsonDocument bsonDocument);

    void unpinServerAddress();

    void markSessionDirty();

    boolean isSessionMarkedDirty();
}
