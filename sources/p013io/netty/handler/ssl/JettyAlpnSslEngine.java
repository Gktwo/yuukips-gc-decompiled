package p013io.netty.handler.ssl;

import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import org.eclipse.jetty.alpn.ALPN;
import p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.ssl.JettyAlpnSslEngine */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/JettyAlpnSslEngine.class */
abstract class JettyAlpnSslEngine extends JdkSslEngine {
    private static final boolean available = initAvailable();

    /* access modifiers changed from: package-private */
    public static boolean isAvailable() {
        return available;
    }

    private static boolean initAvailable() {
        if (PlatformDependent.javaVersion() > 8) {
            return false;
        }
        try {
            Class.forName("sun.security.ssl.ALPNExtension", true, null);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static JettyAlpnSslEngine newClientEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator) {
        return new ClientEngine(engine, applicationNegotiator);
    }

    /* access modifiers changed from: package-private */
    public static JettyAlpnSslEngine newServerEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator) {
        return new ServerEngine(engine, applicationNegotiator);
    }

    private JettyAlpnSslEngine(SSLEngine engine) {
        super(engine);
    }

    /* renamed from: io.netty.handler.ssl.JettyAlpnSslEngine$ClientEngine */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JettyAlpnSslEngine$ClientEngine.class */
    private static final class ClientEngine extends JettyAlpnSslEngine {
        ClientEngine(SSLEngine engine, final JdkApplicationProtocolNegotiator applicationNegotiator) {
            super(engine);
            ObjectUtil.checkNotNull(applicationNegotiator, "applicationNegotiator");
            final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(applicationNegotiator.protocolListenerFactory().newListener(this, applicationNegotiator.protocols()), "protocolListener");
            ALPN.put(engine, new ALPN.ClientProvider() { // from class: io.netty.handler.ssl.JettyAlpnSslEngine.ClientEngine.1
                public List<String> protocols() {
                    return applicationNegotiator.protocols();
                }

                public void selected(String protocol) throws SSLException {
                    try {
                        protocolListener.selected(protocol);
                    } catch (Throwable t) {
                        throw SslUtils.toSSLHandshakeException(t);
                    }
                }

                public void unsupported() {
                    protocolListener.unsupported();
                }
            });
        }

        @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeInbound() throws SSLException {
            try {
                ALPN.remove(getWrappedEngine());
            } finally {
                closeInbound();
            }
        }

        @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeOutbound() {
            try {
                ALPN.remove(getWrappedEngine());
            } finally {
                closeOutbound();
            }
        }
    }

    /* renamed from: io.netty.handler.ssl.JettyAlpnSslEngine$ServerEngine */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JettyAlpnSslEngine$ServerEngine.class */
    private static final class ServerEngine extends JettyAlpnSslEngine {
        ServerEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator) {
            super(engine);
            ObjectUtil.checkNotNull(applicationNegotiator, "applicationNegotiator");
            final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(applicationNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(applicationNegotiator.protocols())), "protocolSelector");
            ALPN.put(engine, new ALPN.ServerProvider() { // from class: io.netty.handler.ssl.JettyAlpnSslEngine.ServerEngine.1
                public String select(List<String> protocols) throws SSLException {
                    try {
                        return protocolSelector.select(protocols);
                    } catch (Throwable t) {
                        throw SslUtils.toSSLHandshakeException(t);
                    }
                }

                public void unsupported() {
                    protocolSelector.unsupported();
                }
            });
        }

        @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeInbound() throws SSLException {
            try {
                ALPN.remove(getWrappedEngine());
            } finally {
                closeInbound();
            }
        }

        @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeOutbound() {
            try {
                ALPN.remove(getWrappedEngine());
            } finally {
                closeOutbound();
            }
        }
    }
}
