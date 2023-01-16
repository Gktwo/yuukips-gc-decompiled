package org.eclipse.jetty.websocket.common.p025io;

import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.websocket.common.LogicalConnection;

/* renamed from: org.eclipse.jetty.websocket.common.io.DisconnectCallback */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/DisconnectCallback.class */
public class DisconnectCallback implements Callback {
    private final LogicalConnection connection;

    public DisconnectCallback(LogicalConnection connection) {
        this.connection = connection;
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable x) {
        this.connection.disconnect();
    }

    @Override // org.eclipse.jetty.util.Callback
    public void succeeded() {
        this.connection.disconnect();
    }
}
