package com.mongodb.internal.connection;

import com.mongodb.ReadConcern;
import com.mongodb.internal.session.SessionContext;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/NoOpSessionContext.class */
public class NoOpSessionContext implements SessionContext {
    public static final NoOpSessionContext INSTANCE = new NoOpSessionContext();

    @Override // com.mongodb.internal.session.SessionContext
    public boolean hasSession() {
        return false;
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean isImplicitSession() {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public BsonDocument getSessionId() {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean isCausallyConsistent() {
        return false;
    }

    @Override // com.mongodb.internal.session.SessionContext
    public long getTransactionNumber() {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public long advanceTransactionNumber() {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean notifyMessageSent() {
        return false;
    }

    @Override // com.mongodb.internal.session.SessionContext
    public BsonTimestamp getOperationTime() {
        return null;
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void advanceOperationTime(BsonTimestamp operationTime) {
    }

    @Override // com.mongodb.internal.session.SessionContext
    public BsonDocument getClusterTime() {
        return null;
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void advanceClusterTime(BsonDocument clusterTime) {
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean hasActiveTransaction() {
        return false;
    }

    @Override // com.mongodb.internal.session.SessionContext
    public ReadConcern getReadConcern() {
        return ReadConcern.DEFAULT;
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void setRecoveryToken(BsonDocument recoveryToken) {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void unpinServerAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void markSessionDirty() {
        throw new UnsupportedOperationException();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean isSessionMarkedDirty() {
        return false;
    }
}
