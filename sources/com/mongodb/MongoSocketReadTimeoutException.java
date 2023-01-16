package com.mongodb;

/* loaded from: grasscutter.jar:com/mongodb/MongoSocketReadTimeoutException.class */
public class MongoSocketReadTimeoutException extends MongoSocketException {
    private static final long serialVersionUID = -7237059971254608960L;

    public MongoSocketReadTimeoutException(String message, ServerAddress address, Throwable cause) {
        super(message, address, cause);
    }
}
