package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonInvalidOperationException.class */
public class BsonInvalidOperationException extends BSONException {
    private static final long serialVersionUID = 7684248076818601418L;

    public BsonInvalidOperationException(String message) {
        super(message);
    }

    public BsonInvalidOperationException(String message, Throwable t) {
        super(message, t);
    }
}
