package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/BadPayloadException.class */
public class BadPayloadException extends CloseException {
    public BadPayloadException(String message) {
        super(1007, message);
    }

    public BadPayloadException(String message, Throwable t) {
        super(1007, message, t);
    }

    public BadPayloadException(Throwable t) {
        super(1007, t);
    }
}
