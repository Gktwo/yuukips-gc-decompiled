package com.mongodb;

import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/MongoNotPrimaryException.class */
public class MongoNotPrimaryException extends MongoCommandException {
    private static final long serialVersionUID = 694876345217027108L;

    public MongoNotPrimaryException(BsonDocument response, ServerAddress serverAddress) {
        super(response, serverAddress);
    }
}
