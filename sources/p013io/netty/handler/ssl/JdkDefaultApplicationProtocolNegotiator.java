package p013io.netty.handler.ssl;

import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLEngine;
import p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator;

/* renamed from: io.netty.handler.ssl.JdkDefaultApplicationProtocolNegotiator */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkDefaultApplicationProtocolNegotiator.class */
final class JdkDefaultApplicationProtocolNegotiator implements JdkApplicationProtocolNegotiator {
    public static final JdkDefaultApplicationProtocolNegotiator INSTANCE = new JdkDefaultApplicationProtocolNegotiator();
    private static final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory DEFAULT_SSL_ENGINE_WRAPPER_FACTORY = new JdkApplicationProtocolNegotiator.SslEngineWrapperFactory() { // from class: io.netty.handler.ssl.JdkDefaultApplicationProtocolNegotiator.1
        @Override // p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator.SslEngineWrapperFactory
        public SSLEngine wrapSslEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator, boolean isServer) {
            return engine;
        }
    };

    private JdkDefaultApplicationProtocolNegotiator() {
    }

    @Override // p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory() {
        return DEFAULT_SSL_ENGINE_WRAPPER_FACTORY;
    }

    @Override // p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory() {
        throw new UnsupportedOperationException("Application protocol negotiation unsupported");
    }

    @Override // p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolListenerFactory() {
        throw new UnsupportedOperationException("Application protocol negotiation unsupported");
    }

    @Override // p013io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List<String> protocols() {
        return Collections.emptyList();
    }
}
