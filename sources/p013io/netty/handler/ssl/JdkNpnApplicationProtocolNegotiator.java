package p013io.netty.handler.ssl;

import java.util.List;
import javax.net.ssl.SSLEngine;
import p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator;

@Deprecated
/* renamed from: io.netty.handler.ssl.JdkNpnApplicationProtocolNegotiator */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkNpnApplicationProtocolNegotiator.class */
public final class JdkNpnApplicationProtocolNegotiator extends JdkBaseApplicationProtocolNegotiator {
    private static final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory NPN_WRAPPER = new JdkApplicationProtocolNegotiator.SslEngineWrapperFactory() { // from class: io.netty.handler.ssl.JdkNpnApplicationProtocolNegotiator.1
        {
            if (!JettyNpnSslEngine.isAvailable()) {
                throw new RuntimeException("NPN unsupported. Is your classpath configured correctly? See https://wiki.eclipse.org/Jetty/Feature/NPN");
            }
        }

        @Override // p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator.SslEngineWrapperFactory
        public SSLEngine wrapSslEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator, boolean isServer) {
            return new JettyNpnSslEngine(engine, applicationNegotiator, isServer);
        }
    };

    @Override // p013io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator, p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public /* bridge */ /* synthetic */ JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory() {
        return wrapperFactory();
    }

    @Override // p013io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator, p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public /* bridge */ /* synthetic */ JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolListenerFactory() {
        return protocolListenerFactory();
    }

    @Override // p013io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator, p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public /* bridge */ /* synthetic */ JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory() {
        return protocolSelectorFactory();
    }

    @Override // p013io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator, p013io.netty.handler.ssl.ApplicationProtocolNegotiator
    public /* bridge */ /* synthetic */ List protocols() {
        return protocols();
    }

    public JdkNpnApplicationProtocolNegotiator(Iterable<String> protocols) {
        this(false, protocols);
    }

    public JdkNpnApplicationProtocolNegotiator(String... protocols) {
        this(false, protocols);
    }

    public JdkNpnApplicationProtocolNegotiator(boolean failIfNoCommonProtocols, Iterable<String> protocols) {
        this(failIfNoCommonProtocols, failIfNoCommonProtocols, protocols);
    }

    public JdkNpnApplicationProtocolNegotiator(boolean failIfNoCommonProtocols, String... protocols) {
        this(failIfNoCommonProtocols, failIfNoCommonProtocols, protocols);
    }

    public JdkNpnApplicationProtocolNegotiator(boolean clientFailIfNoCommonProtocols, boolean serverFailIfNoCommonProtocols, Iterable<String> protocols) {
        this(clientFailIfNoCommonProtocols ? FAIL_SELECTOR_FACTORY : NO_FAIL_SELECTOR_FACTORY, serverFailIfNoCommonProtocols ? FAIL_SELECTION_LISTENER_FACTORY : NO_FAIL_SELECTION_LISTENER_FACTORY, protocols);
    }

    public JdkNpnApplicationProtocolNegotiator(boolean clientFailIfNoCommonProtocols, boolean serverFailIfNoCommonProtocols, String... protocols) {
        this(clientFailIfNoCommonProtocols ? FAIL_SELECTOR_FACTORY : NO_FAIL_SELECTOR_FACTORY, serverFailIfNoCommonProtocols ? FAIL_SELECTION_LISTENER_FACTORY : NO_FAIL_SELECTION_LISTENER_FACTORY, protocols);
    }

    public JdkNpnApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.ProtocolSelectorFactory selectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory listenerFactory, Iterable<String> protocols) {
        super(NPN_WRAPPER, selectorFactory, listenerFactory, protocols);
    }

    public JdkNpnApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.ProtocolSelectorFactory selectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory listenerFactory, String... protocols) {
        super(NPN_WRAPPER, selectorFactory, listenerFactory, protocols);
    }
}
