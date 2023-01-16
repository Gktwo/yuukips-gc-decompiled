package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketException.class */
public class WebSocketException extends RuntimeException {
    public WebSocketException() {
    }

    public WebSocketException(String message) {
        super(message);
    }

    public WebSocketException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebSocketException(Throwable cause) {
        super(cause);
    }
}
