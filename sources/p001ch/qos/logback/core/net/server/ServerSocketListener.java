package p001ch.qos.logback.core.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import p001ch.qos.logback.core.net.server.Client;
import p001ch.qos.logback.core.util.CloseUtil;

/* renamed from: ch.qos.logback.core.net.server.ServerSocketListener */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/ServerSocketListener.class */
public abstract class ServerSocketListener<T extends Client> implements ServerListener<T> {
    private final ServerSocket serverSocket;

    protected abstract T createClient(String str, Socket socket) throws IOException;

    public ServerSocketListener(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override // p001ch.qos.logback.core.net.server.ServerListener
    public T acceptClient() throws IOException {
        Socket socket = this.serverSocket.accept();
        return createClient(socketAddressToString(socket.getRemoteSocketAddress()), socket);
    }

    @Override // p001ch.qos.logback.core.net.server.ServerListener, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseUtil.closeQuietly(this.serverSocket);
    }

    @Override // java.lang.Object
    public String toString() {
        return socketAddressToString(this.serverSocket.getLocalSocketAddress());
    }

    private String socketAddressToString(SocketAddress address) {
        String addr = address.toString();
        int i = addr.indexOf("/");
        if (i >= 0) {
            addr = addr.substring(i + 1);
        }
        return addr;
    }
}
