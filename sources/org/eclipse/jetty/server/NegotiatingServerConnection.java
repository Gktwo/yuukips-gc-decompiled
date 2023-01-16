package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/NegotiatingServerConnection.class */
public abstract class NegotiatingServerConnection extends AbstractConnection {
    private static final Logger LOG = Log.getLogger(NegotiatingServerConnection.class);
    private final Connector connector;
    private final SSLEngine engine;
    private final List<String> protocols;
    private final String defaultProtocol;
    private String protocol;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/NegotiatingServerConnection$CipherDiscriminator.class */
    public interface CipherDiscriminator {
        boolean isAcceptable(String str, String str2, String str3);
    }

    protected NegotiatingServerConnection(Connector connector, EndPoint endPoint, SSLEngine engine, List<String> protocols, String defaultProtocol) {
        super(endPoint, connector.getExecutor());
        this.connector = connector;
        this.protocols = protocols;
        this.defaultProtocol = defaultProtocol;
        this.engine = engine;
    }

    public List<String> getProtocols() {
        return this.protocols;
    }

    public String getDefaultProtocol() {
        return this.defaultProtocol;
    }

    public Connector getConnector() {
        return this.connector;
    }

    public SSLEngine getSSLEngine() {
        return this.engine;
    }

    public String getProtocol() {
        return this.protocol;
    }

    protected void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public void onOpen() {
        onOpen();
        fillInterested();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void onFillable() {
        int filled = fill();
        if (filled == 0) {
            if (this.protocol != null) {
                ConnectionFactory connectionFactory = this.connector.getConnectionFactory(this.protocol);
                if (connectionFactory == null) {
                    LOG.info("{} application selected protocol '{}', but no correspondent {} has been configured", this, this.protocol, ConnectionFactory.class.getName());
                    close();
                    return;
                }
                EndPoint endPoint = getEndPoint();
                endPoint.upgrade(connectionFactory.newConnection(this.connector, endPoint));
            } else if (this.engine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("{} could not negotiate protocol, SSLEngine: {}", this, this.engine);
                }
                close();
            } else {
                fillInterested();
            }
        } else if (filled < 0) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} detected close on client side", this);
            }
            close();
        } else {
            throw new IllegalStateException();
        }
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

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection, java.io.Closeable, java.lang.AutoCloseable, org.eclipse.jetty.client.api.Connection
    public void close() {
        getEndPoint().shutdownOutput();
        close();
    }
}
