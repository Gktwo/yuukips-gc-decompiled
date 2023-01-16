package com.mongodb;

/* loaded from: grasscutter.jar:com/mongodb/MongoConfigurationException.class */
public class MongoConfigurationException extends MongoClientException {
    private static final long serialVersionUID = -2343119787572079323L;

    public MongoConfigurationException(String message) {
        super(message);
    }

    public MongoConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
