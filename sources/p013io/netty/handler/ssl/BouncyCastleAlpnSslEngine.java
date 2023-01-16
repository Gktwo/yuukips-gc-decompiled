package p013io.netty.handler.ssl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import p013io.netty.handler.ssl.JdkAlpnSslEngine;
import p013io.netty.util.internal.SuppressJava6Requirement;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.handler.ssl.BouncyCastleAlpnSslEngine */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/BouncyCastleAlpnSslEngine.class */
final class BouncyCastleAlpnSslEngine extends JdkAlpnSslEngine {
    /* access modifiers changed from: package-private */
    public BouncyCastleAlpnSslEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator, boolean isServer) {
        super(engine, applicationNegotiator, isServer, new BiConsumer<SSLEngine, JdkAlpnSslEngine.AlpnSelector>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslEngine.1
            public void accept(SSLEngine e, JdkAlpnSslEngine.AlpnSelector s) {
                BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(e, s);
            }
        }, new BiConsumer<SSLEngine, List<String>>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslEngine.2
            public void accept(SSLEngine e, List<String> p) {
                BouncyCastleAlpnSslUtils.setApplicationProtocols(e, p);
            }
        });
    }

    @Override // p013io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getApplicationProtocol(getWrappedEngine());
    }

    @Override // p013io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
    }

    @Override // p013io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> selector) {
        BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), selector);
    }

    @Override // p013io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
    }
}
