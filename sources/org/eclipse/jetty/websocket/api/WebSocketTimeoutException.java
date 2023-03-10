package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketTimeoutException.class */
public class WebSocketTimeoutException extends WebSocketException {
    private static final long serialVersionUID = -6145098200250676673L;

    public WebSocketTimeoutException(String message) {
        super(message);
    }

    public WebSocketTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebSocketTimeoutException(Throwable cause) {
        super(cause);
    }
}
