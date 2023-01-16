package p013io.netty.handler.ssl;

import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import org.eclipse.jetty.npn.NextProtoNego;
import p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.ssl.JettyNpnSslEngine */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/JettyNpnSslEngine.class */
final class JettyNpnSslEngine extends JdkSslEngine {
    private static boolean available;

    /* access modifiers changed from: package-private */
    public static boolean isAvailable() {
        updateAvailability();
        return available;
    }

    private static void updateAvailability() {
        if (!available) {
            try {
                Class.forName("sun.security.ssl.NextProtoNegoExtension", true, null);
                available = true;
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JettyNpnSslEngine(SSLEngine engine, final JdkApplicationProtocolNegotiator applicationNegotiator, boolean server) {
        super(engine);
        ObjectUtil.checkNotNull(applicationNegotiator, "applicationNegotiator");
        if (server) {
            final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(applicationNegotiator.protocolListenerFactory().newListener(this, applicationNegotiator.protocols()), "protocolListener");
            NextProtoNego.put(engine, new NextProtoNego.ServerProvider() { // from class: io.netty.handler.ssl.JettyNpnSslEngine.1
                public void unsupported() {
                    protocolListener.unsupported();
                }

                public List<String> protocols() {
                    return applicationNegotiator.protocols();
                }

                public void protocolSelected(String protocol) {
                    try {
                        protocolListener.selected(protocol);
                    } catch (Throwable t) {
                        PlatformDependent.throwException(t);
                    }
                }
            });
            return;
        }
        final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(applicationNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(applicationNegotiator.protocols())), "protocolSelector");
        NextProtoNego.put(engine, new NextProtoNego.ClientProvider() { // from class: io.netty.handler.ssl.JettyNpnSslEngine.2
            public boolean supports() {
                return true;
            }

            public void unsupported() {
                protocolSelector.unsupported();
            }

            public String selectProtocol(List<String> protocols) {
                try {
                    return protocolSelector.select(protocols);
                } catch (Throwable t) {
                    PlatformDependent.throwException(t);
                    return null;
                }
            }
        });
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        NextProtoNego.remove(getWrappedEngine());
        closeInbound();
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public void closeOutbound() {
        NextProtoNego.remove(getWrappedEngine());
        closeOutbound();
    }
}
