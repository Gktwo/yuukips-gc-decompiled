package com.mongodb;

/* loaded from: grasscutter.jar:com/mongodb/MongoSocketOpenException.class */
public class MongoSocketOpenException extends MongoSocketException {
    private static final long serialVersionUID = 4176754100200191238L;

    public MongoSocketOpenException(String message, ServerAddress address, Throwable cause) {
        super(message, address, cause);
    }

    public MongoSocketOpenException(String message, ServerAddress address) {
        super(message, address);
    }
}
