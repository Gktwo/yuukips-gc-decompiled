package com.mongodb;

/* loaded from: grasscutter.jar:com/mongodb/MongoSocketClosedException.class */
public class MongoSocketClosedException extends MongoSocketException {
    private static final long serialVersionUID = -6855036625330867705L;

    public MongoSocketClosedException(String message, ServerAddress address) {
        super(message, address);
    }
}
