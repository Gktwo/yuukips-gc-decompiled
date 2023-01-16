package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/ProtocolException.class */
public class ProtocolException extends CloseException {
    public ProtocolException(String message) {
        super(1002, message);
    }

    public ProtocolException(String message, Throwable t) {
        super(1002, message, t);
    }

    public ProtocolException(Throwable t) {
        super(1002, t);
    }
}
