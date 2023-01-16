package p001ch.qos.logback.core.net.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.BlockingQueue;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.util.CloseUtil;

/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.net.server.RemoteReceiverStreamClient */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/RemoteReceiverStreamClient.class */
public class RemoteReceiverStreamClient extends ContextAwareBase implements RemoteReceiverClient {
    private final String clientId;
    private final Socket socket;
    private final OutputStream outputStream;
    private BlockingQueue<Serializable> queue;

    public RemoteReceiverStreamClient(String id, Socket socket) {
        this.clientId = "client " + id + ": ";
        this.socket = socket;
        this.outputStream = null;
    }

    RemoteReceiverStreamClient(String id, OutputStream outputStream) {
        this.clientId = "client " + id + ": ";
        this.socket = null;
        this.outputStream = outputStream;
    }

    @Override // p001ch.qos.logback.core.net.server.RemoteReceiverClient
    public void setQueue(BlockingQueue<Serializable> queue) {
        this.queue = queue;
    }

    @Override // p001ch.qos.logback.core.net.server.RemoteReceiverClient
    public boolean offer(Serializable event) {
        if (this.queue != null) {
            return this.queue.offer(event);
        }
        throw new IllegalStateException("client has no event queue");
    }

    @Override // p001ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.socket != null) {
            CloseUtil.closeQuietly(this.socket);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ObjectOutputStream oos;
        try {
            addInfo(this.clientId + "connected");
            oos = null;
            try {
                try {
                    try {
                        int counter = 0;
                        oos = createObjectOutputStream();
                        while (!Thread.currentThread().isInterrupted()) {
                            oos.writeObject(this.queue.take());
                            oos.flush();
                            counter++;
                            if (counter >= 70) {
                                try {
                                    counter = 0;
                                    oos.reset();
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                        if (oos != null) {
                            CloseUtil.closeQuietly(oos);
                        }
                        close();
                        addInfo(this.clientId + "connection closed");
                    } catch (IOException ex) {
                        addError(this.clientId + ex);
                        if (oos != null) {
                            CloseUtil.closeQuietly(oos);
                        }
                        close();
                        addInfo(this.clientId + "connection closed");
                    }
                } catch (SocketException ex2) {
                    addInfo(this.clientId + ex2);
                    if (oos != null) {
                        CloseUtil.closeQuietly(oos);
                    }
                    close();
                    addInfo(this.clientId + "connection closed");
                }
            } catch (RuntimeException ex3) {
                addError(this.clientId + ex3);
                if (oos != null) {
                    CloseUtil.closeQuietly(oos);
                }
                close();
                addInfo(this.clientId + "connection closed");
            }
        } catch (Throwable th) {
            if (oos != null) {
                CloseUtil.closeQuietly(oos);
            }
            close();
            addInfo(this.clientId + "connection closed");
            throw th;
        }
    }

    private ObjectOutputStream createObjectOutputStream() throws IOException {
        if (this.socket == null) {
            return new ObjectOutputStream(this.outputStream);
        }
        return new ObjectOutputStream(this.socket.getOutputStream());
    }
}
