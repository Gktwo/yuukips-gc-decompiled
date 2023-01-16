package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/InvalidWebSocketException.class */
public class InvalidWebSocketException extends WebSocketException {
    public InvalidWebSocketException(String message) {
        super(message);
    }

    public InvalidWebSocketException(String message, Throwable cause) {
        super(message, cause);
    }
}
