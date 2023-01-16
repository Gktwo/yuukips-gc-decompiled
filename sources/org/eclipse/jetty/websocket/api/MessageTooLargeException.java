package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/MessageTooLargeException.class */
public class MessageTooLargeException extends CloseException {
    public MessageTooLargeException(String message) {
        super((int) StatusCode.MESSAGE_TOO_LARGE, message);
    }

    public MessageTooLargeException(String message, Throwable t) {
        super(StatusCode.MESSAGE_TOO_LARGE, message, t);
    }

    public MessageTooLargeException(Throwable t) {
        super((int) StatusCode.MESSAGE_TOO_LARGE, t);
    }
}
