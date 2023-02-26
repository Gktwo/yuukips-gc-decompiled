package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/BadPayloadException.class */
public class BadPayloadException extends CloseException {
    public BadPayloadException(String message) {
        super((int) StatusCode.BAD_PAYLOAD, message);
    }

    public BadPayloadException(String message, Throwable t) {
        super(StatusCode.BAD_PAYLOAD, message, t);
    }

    public BadPayloadException(Throwable t) {
        super((int) StatusCode.BAD_PAYLOAD, t);
    }
}
