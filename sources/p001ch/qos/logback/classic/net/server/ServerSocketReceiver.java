package p001ch.qos.logback.classic.net.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import javax.net.ServerSocketFactory;
import p001ch.qos.logback.classic.net.ReceiverBase;
import p001ch.qos.logback.core.net.AbstractSocketAppender;
import p001ch.qos.logback.core.net.server.ServerListener;
import p001ch.qos.logback.core.net.server.ServerRunner;
import p001ch.qos.logback.core.util.CloseUtil;

/* renamed from: ch.qos.logback.classic.net.server.ServerSocketReceiver */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/server/ServerSocketReceiver.class */
public class ServerSocketReceiver extends ReceiverBase {
    public static final int DEFAULT_BACKLOG = 50;
    private int port = AbstractSocketAppender.DEFAULT_PORT;
    private int backlog = 50;
    private String address;
    private ServerSocket serverSocket;
    private ServerRunner runner;

    @Override // p001ch.qos.logback.classic.net.ReceiverBase
    protected boolean shouldStart() {
        try {
            this.runner = createServerRunner(createServerListener(getServerSocketFactory().createServerSocket(getPort(), getBacklog(), getInetAddress())), getContext().getExecutorService());
            this.runner.setContext(getContext());
            return true;
        } catch (Exception ex) {
            addError("server startup error: " + ex, ex);
            CloseUtil.closeQuietly(this.serverSocket);
            return false;
        }
    }

    protected ServerListener<RemoteAppenderClient> createServerListener(ServerSocket socket) {
        return new RemoteAppenderServerListener(socket);
    }

    protected ServerRunner createServerRunner(ServerListener<RemoteAppenderClient> listener, Executor executor) {
        return new RemoteAppenderServerRunner(listener, executor);
    }

    @Override // p001ch.qos.logback.classic.net.ReceiverBase
    protected Runnable getRunnableTask() {
        return this.runner;
    }

    @Override // p001ch.qos.logback.classic.net.ReceiverBase
    protected void onStop() {
        try {
            if (this.runner != null) {
                this.runner.stop();
            }
        } catch (IOException ex) {
            addError("server shutdown error: " + ex, ex);
        }
    }

    protected ServerSocketFactory getServerSocketFactory() throws Exception {
        return ServerSocketFactory.getDefault();
    }

    protected InetAddress getInetAddress() throws UnknownHostException {
        if (getAddress() == null) {
            return null;
        }
        return InetAddress.getByName(getAddress());
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBacklog() {
        return this.backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
