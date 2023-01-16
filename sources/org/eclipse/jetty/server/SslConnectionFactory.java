package org.eclipse.jetty.server;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Objects;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.ssl.SslConnection;
import org.eclipse.jetty.p023io.ssl.SslHandshakeListener;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import p001ch.qos.logback.core.net.ssl.SSL;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/SslConnectionFactory.class */
public class SslConnectionFactory extends AbstractConnectionFactory implements ConnectionFactory.Detecting {
    private static final int TLS_ALERT_FRAME_TYPE = 21;
    private static final int TLS_HANDSHAKE_FRAME_TYPE = 22;
    private static final int TLS_MAJOR_VERSION = 3;
    private final SslContextFactory _sslContextFactory;
    private final String _nextProtocol;
    private boolean _directBuffersForEncryption;
    private boolean _directBuffersForDecryption;

    public SslConnectionFactory() {
        this(HttpVersion.HTTP_1_1.asString());
    }

    public SslConnectionFactory(@Name("next") String nextProtocol) {
        this(null, nextProtocol);
    }

    public SslConnectionFactory(@Name("sslContextFactory") SslContextFactory factory, @Name("next") String nextProtocol) {
        super(SSL.DEFAULT_PROTOCOL);
        this._directBuffersForEncryption = false;
        this._directBuffersForDecryption = false;
        this._sslContextFactory = factory == null ? new SslContextFactory.Server() : factory;
        this._nextProtocol = nextProtocol;
        addBean(this._sslContextFactory);
    }

    public SslContextFactory getSslContextFactory() {
        return this._sslContextFactory;
    }

    public void setDirectBuffersForEncryption(boolean useDirectBuffers) {
        this._directBuffersForEncryption = useDirectBuffers;
    }

    public void setDirectBuffersForDecryption(boolean useDirectBuffers) {
        this._directBuffersForDecryption = useDirectBuffers;
    }

    public boolean isDirectBuffersForDecryption() {
        return this._directBuffersForDecryption;
    }

    public boolean isDirectBuffersForEncryption() {
        return this._directBuffersForEncryption;
    }

    public String getNextProtocol() {
        return this._nextProtocol;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        SSLEngine engine = this._sslContextFactory.newSSLEngine();
        engine.setUseClientMode(false);
        SSLSession session = engine.getSession();
        if (session.getPacketBufferSize() > getInputBufferSize()) {
            setInputBufferSize(session.getPacketBufferSize());
        }
    }

    @Override // org.eclipse.jetty.server.ConnectionFactory.Detecting
    public ConnectionFactory.Detecting.Detection detect(ByteBuffer buffer) {
        if (buffer.remaining() < 2) {
            return ConnectionFactory.Detecting.Detection.NEED_MORE_BYTES;
        }
        int tlsFrameType = buffer.get(0) & 255;
        return (tlsFrameType == 22 || tlsFrameType == 21) && (buffer.get(1) & 255) == 3 ? ConnectionFactory.Detecting.Detection.RECOGNIZED : ConnectionFactory.Detecting.Detection.NOT_RECOGNIZED;
    }

    @Override // org.eclipse.jetty.server.ConnectionFactory
    public Connection newConnection(Connector connector, EndPoint endPoint) {
        SSLEngine engine = this._sslContextFactory.newSSLEngine(endPoint.getRemoteAddress());
        engine.setUseClientMode(false);
        SslConnection sslConnection = newSslConnection(connector, endPoint, engine);
        sslConnection.setRenegotiationAllowed(this._sslContextFactory.isRenegotiationAllowed());
        sslConnection.setRenegotiationLimit(this._sslContextFactory.getRenegotiationLimit());
        configure(sslConnection, connector, endPoint);
        ConnectionFactory next = connector.getConnectionFactory(this._nextProtocol);
        EndPoint decryptedEndPoint = sslConnection.getDecryptedEndPoint();
        decryptedEndPoint.setConnection(next.newConnection(connector, decryptedEndPoint));
        return sslConnection;
    }

    protected SslConnection newSslConnection(Connector connector, EndPoint endPoint, SSLEngine engine) {
        return new SslConnection(connector.getByteBufferPool(), connector.getExecutor(), endPoint, engine, isDirectBuffersForEncryption(), isDirectBuffersForDecryption());
    }

    @Override // org.eclipse.jetty.server.AbstractConnectionFactory
    protected AbstractConnection configure(AbstractConnection connection, Connector connector, EndPoint endPoint) {
        if (connection instanceof SslConnection) {
            SslConnection sslConnection = (SslConnection) connection;
            if (connector instanceof ContainerLifeCycle) {
                Collection beans = ((ContainerLifeCycle) connector).getBeans(SslHandshakeListener.class);
                Objects.requireNonNull(sslConnection);
                beans.forEach(this::addHandshakeListener);
            }
            Collection beans2 = getBeans(SslHandshakeListener.class);
            Objects.requireNonNull(sslConnection);
            beans2.forEach(this::addHandshakeListener);
        }
        return configure(connection, connector, endPoint);
    }

    @Override // org.eclipse.jetty.server.AbstractConnectionFactory, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x{%s->%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), getProtocol(), this._nextProtocol);
    }
}
