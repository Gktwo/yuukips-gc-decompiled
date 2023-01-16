package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLEngine;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* renamed from: org.eclipse.jetty.io.NegotiatingClientConnection */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/NegotiatingClientConnection.class */
public abstract class NegotiatingClientConnection extends AbstractConnection {
    private static final Logger LOG = Log.getLogger(NegotiatingClientConnection.class);
    private final SSLEngine engine;
    private final ClientConnectionFactory connectionFactory;
    private final Map<String, Object> context;
    private volatile boolean completed;

    protected NegotiatingClientConnection(EndPoint endp, Executor executor, SSLEngine sslEngine, ClientConnectionFactory connectionFactory, Map<String, Object> context) {
        super(endp, executor);
        this.engine = sslEngine;
        this.connectionFactory = connectionFactory;
        this.context = context;
    }

    public SSLEngine getSSLEngine() {
        return this.engine;
    }

    protected void completed() {
        this.completed = true;
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public void onOpen() {
        onOpen();
        try {
            getEndPoint().flush(BufferUtil.EMPTY_BUFFER);
            if (this.completed) {
                replaceConnection();
            } else {
                fillInterested();
            }
        } catch (IOException x) {
            close();
            throw new RuntimeIOException(x);
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void onFillable() {
        int filled;
        do {
            filled = fill();
            if (this.completed || filled < 0) {
                replaceConnection();
                return;
            }
        } while (filled != 0);
        fillInterested();
    }

    private int fill() {
        try {
            return getEndPoint().fill(BufferUtil.EMPTY_BUFFER);
        } catch (IOException x) {
            LOG.debug(x);
            close();
            return -1;
        }
    }

    private void replaceConnection() {
        EndPoint endPoint = getEndPoint();
        try {
            endPoint.upgrade(this.connectionFactory.newConnection(endPoint, this.context));
        } catch (Throwable x) {
            LOG.debug(x);
            close();
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection, java.io.Closeable, java.lang.AutoCloseable, org.eclipse.jetty.client.api.Connection
    public void close() {
        getEndPoint().shutdownOutput();
        close();
    }
}
