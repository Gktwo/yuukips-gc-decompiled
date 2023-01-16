package p001ch.qos.logback.classic.net;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import javax.net.SocketFactory;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.net.server.HardenedLoggingEventInputStream;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.net.DefaultSocketConnector;
import p001ch.qos.logback.core.net.SocketConnector;
import p001ch.qos.logback.core.util.CloseUtil;
import p013io.javalin.http.sse.EmitterKt;

/* renamed from: ch.qos.logback.classic.net.SocketReceiver */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/SocketReceiver.class */
public class SocketReceiver extends ReceiverBase implements Runnable, SocketConnector.ExceptionHandler {
    private static final int DEFAULT_ACCEPT_CONNECTION_DELAY = 5000;
    private String remoteHost;
    private InetAddress address;
    private int port;
    private int reconnectionDelay;
    private int acceptConnectionTimeout = 5000;
    private String receiverId;
    private volatile Socket socket;
    private Future<Socket> connectorTask;

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.classic.net.ReceiverBase
    public boolean shouldStart() {
        int errorCount = 0;
        if (this.port == 0) {
            errorCount = 0 + 1;
            addError("No port was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_port");
        }
        if (this.remoteHost == null) {
            errorCount++;
            addError("No host name or address was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_host");
        }
        if (this.reconnectionDelay == 0) {
            this.reconnectionDelay = 30000;
        }
        if (errorCount == 0) {
            try {
                this.address = InetAddress.getByName(this.remoteHost);
            } catch (UnknownHostException e) {
                addError("unknown host: " + this.remoteHost);
                errorCount++;
            }
        }
        if (errorCount == 0) {
            this.receiverId = "receiver " + this.remoteHost + EmitterKt.COMMENT_PREFIX + this.port + ": ";
        }
        return errorCount == 0;
    }

    @Override // p001ch.qos.logback.classic.net.ReceiverBase
    protected void onStop() {
        if (this.socket != null) {
            CloseUtil.closeQuietly(this.socket);
        }
    }

    @Override // p001ch.qos.logback.classic.net.ReceiverBase
    protected Runnable getRunnableTask() {
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            LoggerContext lc = (LoggerContext) getContext();
            while (!Thread.currentThread().isInterrupted()) {
                this.connectorTask = activateConnector(createConnector(this.address, this.port, 0, this.reconnectionDelay));
                if (this.connectorTask == null) {
                    break;
                }
                this.socket = waitForConnectorToReturnASocket();
                if (this.socket == null) {
                    break;
                }
                dispatchEvents(lc);
            }
        } catch (InterruptedException e) {
        }
        addInfo("shutting down");
    }

    private SocketConnector createConnector(InetAddress address, int port, int initialDelay, int retryDelay) {
        SocketConnector connector = newConnector(address, port, initialDelay, retryDelay);
        connector.setExceptionHandler(this);
        connector.setSocketFactory(getSocketFactory());
        return connector;
    }

    private Future<Socket> activateConnector(SocketConnector connector) {
        try {
            return getContext().getScheduledExecutorService().submit(connector);
        } catch (RejectedExecutionException e) {
            return null;
        }
    }

    private Socket waitForConnectorToReturnASocket() throws InterruptedException {
        try {
            Socket s = this.connectorTask.get();
            this.connectorTask = null;
            return s;
        } catch (ExecutionException e) {
            return null;
        }
    }

    private void dispatchEvents(LoggerContext lc) {
        ObjectInputStream ois;
        try {
            this.socket.setSoTimeout(this.acceptConnectionTimeout);
            ois = new HardenedLoggingEventInputStream(this.socket.getInputStream());
            this.socket.setSoTimeout(0);
            addInfo(this.receiverId + "connection established");
            while (true) {
                ILoggingEvent event = (ILoggingEvent) ois.readObject();
                Logger remoteLogger = lc.getLogger(event.getLoggerName());
                if (remoteLogger.isEnabledFor(event.getLevel())) {
                    try {
                        try {
                            remoteLogger.callAppenders(event);
                        } catch (ClassNotFoundException ex) {
                            addInfo(this.receiverId + "unknown event class: " + ex);
                            CloseUtil.closeQuietly(ois);
                            CloseUtil.closeQuietly(this.socket);
                            this.socket = null;
                            addInfo(this.receiverId + "connection closed");
                            return;
                        }
                    } catch (EOFException e) {
                        addInfo(this.receiverId + "end-of-stream detected");
                        CloseUtil.closeQuietly(ois);
                        CloseUtil.closeQuietly(this.socket);
                        this.socket = null;
                        addInfo(this.receiverId + "connection closed");
                        return;
                    } catch (IOException ex2) {
                        addInfo(this.receiverId + "connection failed: " + ex2);
                        CloseUtil.closeQuietly(ois);
                        CloseUtil.closeQuietly(this.socket);
                        this.socket = null;
                        addInfo(this.receiverId + "connection closed");
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            CloseUtil.closeQuietly(ois);
            CloseUtil.closeQuietly(this.socket);
            this.socket = null;
            addInfo(this.receiverId + "connection closed");
            throw th;
        }
    }

    @Override // p001ch.qos.logback.core.net.SocketConnector.ExceptionHandler
    public void connectionFailed(SocketConnector connector, Exception ex) {
        if (ex instanceof InterruptedException) {
            addInfo("connector interrupted");
        } else if (ex instanceof ConnectException) {
            addInfo(this.receiverId + "connection refused");
        } else {
            addInfo(this.receiverId + ex);
        }
    }

    protected SocketConnector newConnector(InetAddress address, int port, int initialDelay, int retryDelay) {
        return new DefaultSocketConnector(address, port, (long) initialDelay, (long) retryDelay);
    }

    protected SocketFactory getSocketFactory() {
        return SocketFactory.getDefault();
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setReconnectionDelay(int reconnectionDelay) {
        this.reconnectionDelay = reconnectionDelay;
    }

    public void setAcceptConnectionTimeout(int acceptConnectionTimeout) {
        this.acceptConnectionTimeout = acceptConnectionTimeout;
    }
}
