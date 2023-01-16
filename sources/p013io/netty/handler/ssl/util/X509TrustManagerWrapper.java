package p013io.netty.handler.ssl.util;

import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import net.bytebuddy.implementation.MethodDelegation;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* access modifiers changed from: package-private */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.handler.ssl.util.X509TrustManagerWrapper */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/X509TrustManagerWrapper.class */
public final class X509TrustManagerWrapper extends X509ExtendedTrustManager {
    private final X509TrustManager delegate;

    /* access modifiers changed from: package-private */
    public X509TrustManagerWrapper(X509TrustManager delegate) {
        this.delegate = (X509TrustManager) ObjectUtil.checkNotNull(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] chain, String s) throws CertificateException {
        this.delegate.checkClientTrusted(chain, s);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] chain, String s, Socket socket) throws CertificateException {
        this.delegate.checkClientTrusted(chain, s);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] chain, String s, SSLEngine sslEngine) throws CertificateException {
        this.delegate.checkClientTrusted(chain, s);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] chain, String s) throws CertificateException {
        this.delegate.checkServerTrusted(chain, s);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] chain, String s, Socket socket) throws CertificateException {
        this.delegate.checkServerTrusted(chain, s);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] chain, String s, SSLEngine sslEngine) throws CertificateException {
        this.delegate.checkServerTrusted(chain, s);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.delegate.getAcceptedIssuers();
    }
}
