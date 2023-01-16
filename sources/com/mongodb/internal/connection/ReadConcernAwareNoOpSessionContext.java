package com.mongodb.internal.connection;

import com.mongodb.ReadConcern;
import com.mongodb.assertions.Assertions;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ReadConcernAwareNoOpSessionContext.class */
public final class ReadConcernAwareNoOpSessionContext extends NoOpSessionContext {
    private final ReadConcern readConcern;

    public ReadConcernAwareNoOpSessionContext(ReadConcern readConcern) {
        this.readConcern = (ReadConcern) Assertions.notNull("readConcern", readConcern);
    }

    @Override // com.mongodb.internal.connection.NoOpSessionContext, com.mongodb.internal.session.SessionContext
    public ReadConcern getReadConcern() {
        return this.readConcern;
    }
}
