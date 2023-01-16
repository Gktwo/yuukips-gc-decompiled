package com.mongodb.internal.connection;

import com.mongodb.ReadConcern;
import com.mongodb.internal.session.SessionContext;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ClusterClockAdvancingSessionContext.class */
public final class ClusterClockAdvancingSessionContext implements SessionContext {
    private final SessionContext wrapped;
    private final ClusterClock clusterClock;

    public ClusterClockAdvancingSessionContext(SessionContext wrapped, ClusterClock clusterClock) {
        this.wrapped = wrapped;
        this.clusterClock = clusterClock;
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean hasSession() {
        return this.wrapped.hasSession();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean isImplicitSession() {
        return this.wrapped.isImplicitSession();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public BsonDocument getSessionId() {
        return this.wrapped.getSessionId();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean isCausallyConsistent() {
        return this.wrapped.isCausallyConsistent();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public long getTransactionNumber() {
        return this.wrapped.getTransactionNumber();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public long advanceTransactionNumber() {
        return this.wrapped.advanceTransactionNumber();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean notifyMessageSent() {
        return this.wrapped.notifyMessageSent();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public BsonTimestamp getOperationTime() {
        return this.wrapped.getOperationTime();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void advanceOperationTime(BsonTimestamp operationTime) {
        this.wrapped.advanceOperationTime(operationTime);
    }

    @Override // com.mongodb.internal.session.SessionContext
    public BsonDocument getClusterTime() {
        return this.clusterClock.greaterOf(this.wrapped.getClusterTime());
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void advanceClusterTime(BsonDocument clusterTime) {
        this.wrapped.advanceClusterTime(clusterTime);
        this.clusterClock.advance(clusterTime);
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean hasActiveTransaction() {
        return this.wrapped.hasActiveTransaction();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public ReadConcern getReadConcern() {
        return this.wrapped.getReadConcern();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void setRecoveryToken(BsonDocument recoveryToken) {
        this.wrapped.setRecoveryToken(recoveryToken);
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void unpinServerAddress() {
        this.wrapped.unpinServerAddress();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public void markSessionDirty() {
        this.wrapped.markSessionDirty();
    }

    @Override // com.mongodb.internal.session.SessionContext
    public boolean isSessionMarkedDirty() {
        return this.wrapped.isSessionMarkedDirty();
    }
}
