package p013io.netty.handler.ssl.util;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import net.bytebuddy.implementation.MethodDelegation;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* access modifiers changed from: package-private */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.handler.ssl.util.X509KeyManagerWrapper */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/X509KeyManagerWrapper.class */
public final class X509KeyManagerWrapper extends X509ExtendedKeyManager {
    private final X509KeyManager delegate;

    /* access modifiers changed from: package-private */
    public X509KeyManagerWrapper(X509KeyManager delegate) {
        this.delegate = (X509KeyManager) ObjectUtil.checkNotNull(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String var1, Principal[] var2) {
        return this.delegate.getClientAliases(var1, var2);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] var1, Principal[] var2, Socket var3) {
        return this.delegate.chooseClientAlias(var1, var2, var3);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String var1, Principal[] var2) {
        return this.delegate.getServerAliases(var1, var2);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String var1, Principal[] var2, Socket var3) {
        return this.delegate.chooseServerAlias(var1, var2, var3);
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String var1) {
        return this.delegate.getCertificateChain(var1);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String var1) {
        return this.delegate.getPrivateKey(var1);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] keyType, Principal[] issuers, SSLEngine engine) {
        return this.delegate.chooseClientAlias(keyType, issuers, null);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine engine) {
        return this.delegate.chooseServerAlias(keyType, issuers, null);
    }
}
