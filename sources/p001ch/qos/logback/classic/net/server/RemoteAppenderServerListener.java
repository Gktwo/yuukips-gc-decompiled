package p001ch.qos.logback.classic.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import p001ch.qos.logback.core.net.server.ServerSocketListener;

/* renamed from: ch.qos.logback.classic.net.server.RemoteAppenderServerListener */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/server/RemoteAppenderServerListener.class */
class RemoteAppenderServerListener extends ServerSocketListener<RemoteAppenderClient> {
    public RemoteAppenderServerListener(ServerSocket serverSocket) {
        super(serverSocket);
    }

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.net.server.ServerSocketListener
    public RemoteAppenderClient createClient(String id, Socket socket) throws IOException {
        return new RemoteAppenderStreamClient(id, socket);
    }
}
