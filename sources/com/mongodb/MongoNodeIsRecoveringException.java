package com.mongodb;

import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/MongoNodeIsRecoveringException.class */
public class MongoNodeIsRecoveringException extends MongoCommandException {
    private static final long serialVersionUID = 6062524147327071635L;

    public MongoNodeIsRecoveringException(BsonDocument response, ServerAddress serverAddress) {
        super(response, serverAddress);
    }
}
