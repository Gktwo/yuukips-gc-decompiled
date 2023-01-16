package p001ch.qos.logback.core.net.server;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import javax.net.ServerSocketFactory;
import p001ch.qos.logback.core.AppenderBase;
import p001ch.qos.logback.core.net.AbstractSocketAppender;
import p001ch.qos.logback.core.spi.PreSerializationTransformer;

/* renamed from: ch.qos.logback.core.net.server.AbstractServerSocketAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/AbstractServerSocketAppender.class */
public abstract class AbstractServerSocketAppender<E> extends AppenderBase<E> {
    public static final int DEFAULT_BACKLOG = 50;
    public static final int DEFAULT_CLIENT_QUEUE_SIZE = 100;
    private int port = AbstractSocketAppender.DEFAULT_PORT;
    private int backlog = 50;
    private int clientQueueSize = 100;
    private String address;
    private ServerRunner<RemoteReceiverClient> runner;

    protected abstract void postProcessEvent(E e);

    protected abstract PreSerializationTransformer<E> getPST();

    @Override // p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (!isStarted()) {
            try {
                this.runner = createServerRunner(createServerListener(getServerSocketFactory().createServerSocket(getPort(), getBacklog(), getInetAddress())), getContext().getExecutorService());
                this.runner.setContext(getContext());
                getContext().getExecutorService().execute(this.runner);
                start();
            } catch (Exception ex) {
                addError("server startup error: " + ex, ex);
            }
        }
    }

    protected ServerListener<RemoteReceiverClient> createServerListener(ServerSocket socket) {
        return new RemoteReceiverServerListener(socket);
    }

    protected ServerRunner<RemoteReceiverClient> createServerRunner(ServerListener<RemoteReceiverClient> listener, Executor executor) {
        return new RemoteReceiverServerRunner(listener, executor, getClientQueueSize());
    }

    @Override // p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        if (isStarted()) {
            try {
                this.runner.stop();
                stop();
            } catch (IOException ex) {
                addError("server shutdown error: " + ex, ex);
            }
        }
    }

    @Override // p001ch.qos.logback.core.AppenderBase
    protected void append(E event) {
        if (event != null) {
            postProcessEvent(event);
            final Serializable serEvent = getPST().transform(event);
            this.runner.accept(new ClientVisitor<RemoteReceiverClient>() { // from class: ch.qos.logback.core.net.server.AbstractServerSocketAppender.1
                public void visit(RemoteReceiverClient client) {
                    client.offer(serEvent);
                }
            });
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

    public int getClientQueueSize() {
        return this.clientQueueSize;
    }

    public void setClientQueueSize(int clientQueueSize) {
        this.clientQueueSize = clientQueueSize;
    }
}
