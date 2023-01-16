package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketAdapter.class */
public class WebSocketAdapter implements WebSocketListener {
    private volatile Session session;
    private RemoteEndpoint remote;

    public RemoteEndpoint getRemote() {
        return this.remote;
    }

    public Session getSession() {
        return this.session;
    }

    public boolean isConnected() {
        Session sess = this.session;
        return sess != null && sess.isOpen();
    }

    public boolean isNotConnected() {
        Session sess = this.session;
        return sess == null || !sess.isOpen();
    }

    @Override // org.eclipse.jetty.websocket.api.WebSocketListener
    public void onWebSocketBinary(byte[] payload, int offset, int len) {
    }

    @Override // org.eclipse.jetty.websocket.api.WebSocketConnectionListener
    public void onWebSocketClose(int statusCode, String reason) {
        this.session = null;
        this.remote = null;
    }

    @Override // org.eclipse.jetty.websocket.api.WebSocketConnectionListener
    public void onWebSocketConnect(Session sess) {
        this.session = sess;
        this.remote = sess.getRemote();
    }

    @Override // org.eclipse.jetty.websocket.api.WebSocketConnectionListener
    public void onWebSocketError(Throwable cause) {
    }

    @Override // org.eclipse.jetty.websocket.api.WebSocketListener
    public void onWebSocketText(String message) {
    }
}
