package p001ch.qos.logback.core.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.net.server.RemoteReceiverServerListener */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/RemoteReceiverServerListener.class */
public class RemoteReceiverServerListener extends ServerSocketListener<RemoteReceiverClient> {
    public RemoteReceiverServerListener(ServerSocket serverSocket) {
        super(serverSocket);
    }

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.net.server.ServerSocketListener
    public RemoteReceiverClient createClient(String id, Socket socket) throws IOException {
        return new RemoteReceiverStreamClient(id, socket);
    }
}
