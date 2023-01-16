package com.mongodb;

/* loaded from: grasscutter.jar:com/mongodb/MongoQueryException.class */
public class MongoQueryException extends MongoServerException {
    private static final long serialVersionUID = -5113350133297015801L;
    private final String errorMessage;

    public MongoQueryException(ServerAddress address, int errorCode, String errorMessage) {
        super(errorCode, String.format("Query failed with error code %d and error message '%s' on server %s", Integer.valueOf(errorCode), errorMessage, address), address);
        this.errorMessage = errorMessage;
    }

    public MongoQueryException(MongoCommandException commandException) {
        this(commandException.getServerAddress(), commandException.getErrorCode(), commandException.getErrorMessage());
        addLabels(commandException.getErrorLabels());
    }

    public int getErrorCode() {
        return getCode();
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
