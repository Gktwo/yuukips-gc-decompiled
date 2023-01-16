package com.mongodb;

/* loaded from: grasscutter.jar:com/mongodb/MongoClientException.class */
public class MongoClientException extends MongoException {
    private static final long serialVersionUID = -5127414714432646066L;

    public MongoClientException(String message) {
        super(message);
    }

    public MongoClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
