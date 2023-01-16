package com.mongodb;

import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/MongoExecutionTimeoutException.class */
public class MongoExecutionTimeoutException extends MongoException {
    private static final long serialVersionUID = 5955669123800274594L;

    public MongoExecutionTimeoutException(int code, String message) {
        super(code, message);
    }

    public MongoExecutionTimeoutException(int code, String message, BsonDocument response) {
        super(code, message, response);
    }
}
