package org.eclipse.jetty.p023io.ssl;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.ClientConnectionFactory;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.ssl.SslHandshakeListener;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.ssl.SslContextFactory;

/* renamed from: org.eclipse.jetty.io.ssl.SslClientConnectionFactory */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslClientConnectionFactory.class */
public class SslClientConnectionFactory implements ClientConnectionFactory {
    public static final String SSL_CONTEXT_FACTORY_CONTEXT_KEY = "ssl.context.factory";
    public static final String SSL_PEER_HOST_CONTEXT_KEY = "ssl.peer.host";
    public static final String SSL_PEER_PORT_CONTEXT_KEY = "ssl.peer.port";
    public static final String SSL_ENGINE_CONTEXT_KEY = "ssl.engine";
    private final SslContextFactory sslContextFactory;
    private final ByteBufferPool byteBufferPool;
    private final Executor executor;
    private final ClientConnectionFactory connectionFactory;
    private boolean _directBuffersForEncryption = true;
    private boolean _directBuffersForDecryption = true;
    private boolean _requireCloseMessage;

    /* renamed from: org.eclipse.jetty.io.ssl.SslClientConnectionFactory$SslEngineFactory */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslClientConnectionFactory$SslEngineFactory.class */
    public interface SslEngineFactory {
        SSLEngine newSslEngine(String str, int i, Map<String, Object> map);
    }

    public SslClientConnectionFactory(SslContextFactory sslContextFactory, ByteBufferPool byteBufferPool, Executor executor, ClientConnectionFactory connectionFactory) {
        this.sslContextFactory = (SslContextFactory) Objects.requireNonNull(sslContextFactory, "Missing SslContextFactory");
        this.byteBufferPool = byteBufferPool;
        this.executor = executor;
        this.connectionFactory = connectionFactory;
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

    @Deprecated
    public boolean isAllowMissingCloseMessage() {
        return !isRequireCloseMessage();
    }

    @Deprecated
    public void setAllowMissingCloseMessage(boolean allowMissingCloseMessage) {
        setRequireCloseMessage(!allowMissingCloseMessage);
    }

    public boolean isRequireCloseMessage() {
        return this._requireCloseMessage;
    }

    public void setRequireCloseMessage(boolean requireCloseMessage) {
        this._requireCloseMessage = requireCloseMessage;
    }

    @Override // org.eclipse.jetty.p023io.ClientConnectionFactory
    public Connection newConnection(EndPoint endPoint, Map<String, Object> context) throws IOException {
        SSLEngine engine;
        String host = (String) context.get(SSL_PEER_HOST_CONTEXT_KEY);
        int port = ((Integer) context.get(SSL_PEER_PORT_CONTEXT_KEY)).intValue();
        if (this.sslContextFactory instanceof SslEngineFactory) {
            engine = ((SslEngineFactory) this.sslContextFactory).newSslEngine(host, port, context);
        } else {
            engine = this.sslContextFactory.newSSLEngine(host, port);
        }
        engine.setUseClientMode(true);
        context.put(SSL_ENGINE_CONTEXT_KEY, engine);
        SslConnection sslConnection = newSslConnection(this.byteBufferPool, this.executor, endPoint, engine);
        EndPoint appEndPoint = sslConnection.getDecryptedEndPoint();
        appEndPoint.setConnection(this.connectionFactory.newConnection(appEndPoint, context));
        sslConnection.addHandshakeListener(new HTTPSHandshakeListener(context));
        customize(sslConnection, context);
        return sslConnection;
    }

    protected SslConnection newSslConnection(ByteBufferPool byteBufferPool, Executor executor, EndPoint endPoint, SSLEngine engine) {
        return new SslConnection(byteBufferPool, executor, endPoint, engine, isDirectBuffersForEncryption(), isDirectBuffersForDecryption());
    }

    @Override // org.eclipse.jetty.p023io.ClientConnectionFactory
    public Connection customize(Connection connection, Map<String, Object> context) {
        if (connection instanceof SslConnection) {
            SslConnection sslConnection = (SslConnection) connection;
            sslConnection.setRenegotiationAllowed(this.sslContextFactory.isRenegotiationAllowed());
            sslConnection.setRenegotiationLimit(this.sslContextFactory.getRenegotiationLimit());
            sslConnection.setRequireCloseMessage(isRequireCloseMessage());
            Collection beans = ((ContainerLifeCycle) context.get(ClientConnectionFactory.CONNECTOR_CONTEXT_KEY)).getBeans(SslHandshakeListener.class);
            Objects.requireNonNull(sslConnection);
            beans.forEach(this::addHandshakeListener);
        }
        return customize(connection, context);
    }

    /* renamed from: org.eclipse.jetty.io.ssl.SslClientConnectionFactory$HTTPSHandshakeListener */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslClientConnectionFactory$HTTPSHandshakeListener.class */
    private class HTTPSHandshakeListener implements SslHandshakeListener {
        private final Map<String, Object> context;

        private HTTPSHandshakeListener(Map<String, Object> context) {
            this.context = context;
        }

        @Override // org.eclipse.jetty.p023io.ssl.SslHandshakeListener
        public void handshakeSucceeded(SslHandshakeListener.Event event) throws SSLException {
            HostnameVerifier verifier = SslClientConnectionFactory.this.sslContextFactory.getHostnameVerifier();
            if (verifier != null) {
                String host = (String) this.context.get(SslClientConnectionFactory.SSL_PEER_HOST_CONTEXT_KEY);
                try {
                    if (!verifier.verify(host, event.getSSLEngine().getSession())) {
                        throw new SSLPeerUnverifiedException("Host name verification failed for host: " + host);
                    }
                } catch (SSLException x) {
                    throw x;
                } catch (Throwable x2) {
                    throw ((SSLException) new SSLPeerUnverifiedException("Host name verification failed for host: " + host).initCause(x2));
                }
            }
        }
    }
}
