package com.mongodb.internal.connection;

import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SpeculativeAuthenticator.class */
interface SpeculativeAuthenticator {
    default BsonDocument createSpeculativeAuthenticateCommand(InternalConnection connection) {
        return null;
    }

    default BsonDocument getSpeculativeAuthenticateResponse() {
        return null;
    }

    default void setSpeculativeAuthenticateResponse(BsonDocument response) {
    }
}
