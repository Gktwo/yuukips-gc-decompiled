package dev.morphia.query;

/* loaded from: grasscutter.jar:dev/morphia/query/ValidationException.class */
public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
