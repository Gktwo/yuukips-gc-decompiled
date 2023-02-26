package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/MessageTooLargeException.class */
public class MessageTooLargeException extends CloseException {
    public MessageTooLargeException(String message) {
        super(1009, message);
    }

    public MessageTooLargeException(String message, Throwable t) {
        super(1009, message, t);
    }

    public MessageTooLargeException(Throwable t) {
        super(1009, t);
    }
}
