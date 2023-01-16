package org.eclipse.jetty.server;

import java.net.Socket;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.SocketChannelEndPoint;
import org.eclipse.jetty.p023io.ssl.SslConnection;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/SocketCustomizationListener.class */
public class SocketCustomizationListener implements Connection.Listener {
    private final boolean _ssl;

    public SocketCustomizationListener() {
        this(true);
    }

    public SocketCustomizationListener(boolean ssl) {
        this._ssl = ssl;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: org.eclipse.jetty.server.SocketCustomizationListener */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onOpened(Connection connection) {
        EndPoint endp = connection.getEndPoint();
        boolean ssl = false;
        if (this._ssl && (endp instanceof SslConnection.DecryptedEndPoint)) {
            endp = ((SslConnection.DecryptedEndPoint) endp).getSslConnection().getEndPoint();
            ssl = true;
        }
        if (endp instanceof SocketChannelEndPoint) {
            customize(((SocketChannelEndPoint) endp).getSocket(), connection.getClass(), ssl);
        }
    }

    protected void customize(Socket socket, Class<? extends Connection> connection, boolean ssl) {
    }

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onClosed(Connection connection) {
    }
}
