package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WriteCallback.class */
public interface WriteCallback {
    void writeFailed(Throwable th);

    void writeSuccess();
}
