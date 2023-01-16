package p013io.netty.handler.ssl;

import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import p013io.netty.buffer.ByteBufAllocator;

/* renamed from: io.netty.handler.ssl.OpenSslContext */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslContext.class */
public abstract class OpenSslContext extends ReferenceCountedOpenSslContext {
    /* access modifiers changed from: package-private */
    public OpenSslContext(Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apnCfg, int mode, Certificate[] keyCertChain, ClientAuth clientAuth, String[] protocols, boolean startTls, boolean enableOcsp, Map.Entry<SslContextOption<?>, Object>... options) throws SSLException {
        super(ciphers, cipherFilter, toNegotiator(apnCfg), mode, keyCertChain, clientAuth, protocols, startTls, enableOcsp, false, options);
    }

    /* access modifiers changed from: package-private */
    public OpenSslContext(Iterable<String> ciphers, CipherSuiteFilter cipherFilter, OpenSslApplicationProtocolNegotiator apn, int mode, Certificate[] keyCertChain, ClientAuth clientAuth, String[] protocols, boolean startTls, boolean enableOcsp, Map.Entry<SslContextOption<?>, Object>... options) throws SSLException {
        super(ciphers, cipherFilter, apn, mode, keyCertChain, clientAuth, protocols, startTls, enableOcsp, false, options);
    }

    @Override // p013io.netty.handler.ssl.ReferenceCountedOpenSslContext
    final SSLEngine newEngine0(ByteBufAllocator alloc, String peerHost, int peerPort, boolean jdkCompatibilityMode) {
        return new OpenSslEngine(this, alloc, peerHost, peerPort, jdkCompatibilityMode);
    }

    protected final void finalize() throws Throwable {
        finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
