package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import p013io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslClientContext */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslClientContext.class */
public final class ReferenceCountedOpenSslClientContext extends ReferenceCountedOpenSslContext {
    private static final Set<String> SUPPORTED_KEY_TYPES = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList("RSA", "DH_RSA", "EC", "EC_RSA", "EC_EC")));
    private final OpenSslSessionContext sessionContext;

    /* access modifiers changed from: package-private */
    public ReferenceCountedOpenSslClientContext(X509Certificate[] trustCertCollection, TrustManagerFactory trustManagerFactory, X509Certificate[] keyCertChain, PrivateKey key, String keyPassword, KeyManagerFactory keyManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, String[] protocols, long sessionCacheSize, long sessionTimeout, boolean enableOcsp, String keyStore, Map.Entry<SslContextOption<?>, Object>... options) throws SSLException {
        super(ciphers, cipherFilter, toNegotiator(apn), 0, keyCertChain, ClientAuth.NONE, protocols, false, enableOcsp, true, options);
        boolean success = false;
        try {
            this.sessionContext = newSessionContext(this, this.ctx, this.engineMap, trustCertCollection, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, keyStore, sessionCacheSize, sessionTimeout);
            success = true;
            if (1 == 0) {
                release();
            }
        } catch (Throwable th) {
            if (!success) {
                release();
            }
            throw th;
        }
    }

    @Override // p013io.netty.handler.ssl.ReferenceCountedOpenSslContext, p013io.netty.handler.ssl.SslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }

    /* access modifiers changed from: package-private */
    public static OpenSslSessionContext newSessionContext(ReferenceCountedOpenSslContext thiz, long ctx, OpenSslEngineMap engineMap, X509Certificate[] trustCertCollection, TrustManagerFactory trustManagerFactory, X509Certificate[] keyCertChain, PrivateKey key, String keyPassword, KeyManagerFactory keyManagerFactory, String keyStore, long sessionCacheSize, long sessionTimeout) throws SSLException {
        OpenSslKeyMaterialProvider keyMaterialProvider;
        KeyManagerFactory keyManagerFactory2;
        if ((key != null || keyCertChain == null) && (key == null || keyCertChain != null)) {
            try {
                keyMaterialProvider = null;
                try {
                    if (OpenSsl.useKeyManagerFactory()) {
                        if (keyManagerFactory == null && keyCertChain != null) {
                            char[] keyPasswordChars = keyStorePassword(keyPassword);
                            KeyStore ks = buildKeyStore(keyCertChain, key, keyPasswordChars, keyStore);
                            if (ks.aliases().hasMoreElements()) {
                                keyManagerFactory2 = new OpenSslX509KeyManagerFactory();
                            } else {
                                keyManagerFactory2 = new OpenSslCachingX509KeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
                            }
                            keyManagerFactory2.init(ks, keyPasswordChars);
                            keyMaterialProvider = providerFor(keyManagerFactory2, keyPassword);
                        } else if (keyManagerFactory != null) {
                            keyMaterialProvider = providerFor(keyManagerFactory, keyPassword);
                        }
                        if (keyMaterialProvider != null) {
                            SSLContext.setCertificateCallback(ctx, new OpenSslClientCertificateCallback(engineMap, new OpenSslKeyMaterialManager(keyMaterialProvider)));
                        }
                    } else if (keyManagerFactory != null) {
                        throw new IllegalArgumentException("KeyManagerFactory not supported");
                    } else if (keyCertChain != null) {
                        setKeyMaterial(ctx, keyCertChain, key, keyPassword);
                    }
                    SSLContext.setVerify(ctx, 1, 10);
                    if (trustCertCollection != null) {
                        try {
                            trustManagerFactory = buildTrustManagerFactory(trustCertCollection, trustManagerFactory, keyStore);
                        } catch (Exception e) {
                            if (keyMaterialProvider != null) {
                                keyMaterialProvider.destroy();
                            }
                            throw new SSLException("unable to setup trustmanager", e);
                        }
                    } else if (trustManagerFactory == null) {
                        trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                    }
                    setVerifyCallback(ctx, engineMap, chooseTrustManager(trustManagerFactory.getTrustManagers()));
                    OpenSslClientSessionContext context = new OpenSslClientSessionContext(thiz, keyMaterialProvider);
                    context.setSessionCacheEnabled(CLIENT_ENABLE_SESSION_CACHE);
                    if (sessionCacheSize > 0) {
                        context.setSessionCacheSize((int) Math.min(sessionCacheSize, 2147483647L));
                    }
                    if (sessionTimeout > 0) {
                        context.setSessionTimeout((int) Math.min(sessionTimeout, 2147483647L));
                    }
                    if (CLIENT_ENABLE_SESSION_TICKET) {
                        context.setTicketKeys(new OpenSslSessionTicketKey[0]);
                    }
                    keyMaterialProvider = null;
                    return context;
                } catch (Exception e2) {
                    throw new SSLException("failed to set certificate and key", e2);
                }
            } finally {
                if (keyMaterialProvider != null) {
                    keyMaterialProvider.destroy();
                }
            }
        } else {
            throw new IllegalArgumentException("Either both keyCertChain and key needs to be null or none of them");
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private static void setVerifyCallback(long ctx, OpenSslEngineMap engineMap, X509TrustManager manager) {
        if (useExtendedTrustManager(manager)) {
            SSLContext.setCertVerifyCallback(ctx, new ExtendedTrustManagerVerifyCallback(engineMap, (X509ExtendedTrustManager) manager));
        } else {
            SSLContext.setCertVerifyCallback(ctx, new TrustManagerVerifyCallback(engineMap, manager));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$OpenSslClientSessionContext */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslClientContext$OpenSslClientSessionContext.class */
    public static final class OpenSslClientSessionContext extends OpenSslSessionContext {
        OpenSslClientSessionContext(ReferenceCountedOpenSslContext context, OpenSslKeyMaterialProvider provider) {
            super(context, provider, SSL.SSL_SESS_CACHE_CLIENT, new OpenSslClientSessionCache(context.engineMap));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$TrustManagerVerifyCallback */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslClientContext$TrustManagerVerifyCallback.class */
    public static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        TrustManagerVerifyCallback(OpenSslEngineMap engineMap, X509TrustManager manager) {
            super(engineMap);
            this.manager = manager;
        }

        @Override // p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine engine, X509Certificate[] peerCerts, String auth) throws Exception {
            this.manager.checkServerTrusted(peerCerts, auth);
        }
    }

    /* access modifiers changed from: private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$ExtendedTrustManagerVerifyCallback */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslClientContext$ExtendedTrustManagerVerifyCallback.class */
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        ExtendedTrustManagerVerifyCallback(OpenSslEngineMap engineMap, X509ExtendedTrustManager manager) {
            super(engineMap);
            this.manager = manager;
        }

        @Override // p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine engine, X509Certificate[] peerCerts, String auth) throws Exception {
            this.manager.checkServerTrusted(peerCerts, auth, engine);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$OpenSslClientCertificateCallback */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslClientContext$OpenSslClientCertificateCallback.class */
    public static final class OpenSslClientCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        OpenSslClientCertificateCallback(OpenSslEngineMap engineMap, OpenSslKeyMaterialManager keyManagerHolder) {
            this.engineMap = engineMap;
            this.keyManagerHolder = keyManagerHolder;
        }

        public void handle(long ssl, byte[] keyTypeBytes, byte[][] asn1DerEncodedPrincipals) throws Exception {
            X500Principal[] issuers;
            ReferenceCountedOpenSslEngine engine = this.engineMap.get(ssl);
            if (engine != null) {
                try {
                    String[] keyTypes = (String[]) supportedClientKeyTypes(keyTypeBytes).toArray(new String[0]);
                    if (asn1DerEncodedPrincipals == null) {
                        issuers = null;
                    } else {
                        issuers = new X500Principal[asn1DerEncodedPrincipals.length];
                        for (int i = 0; i < asn1DerEncodedPrincipals.length; i++) {
                            issuers[i] = new X500Principal(asn1DerEncodedPrincipals[i]);
                        }
                    }
                    this.keyManagerHolder.setKeyMaterialClientSide(engine, keyTypes, issuers);
                } catch (Throwable cause) {
                    engine.initHandshakeException(cause);
                    if (cause instanceof Exception) {
                        throw ((Exception) cause);
                    }
                    throw new SSLException(cause);
                }
            }
        }

        private static Set<String> supportedClientKeyTypes(byte[] clientCertificateTypes) {
            if (clientCertificateTypes == null) {
                return ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES;
            }
            Set<String> result = new HashSet<>(clientCertificateTypes.length);
            for (byte keyTypeCode : clientCertificateTypes) {
                String keyType = clientKeyType(keyTypeCode);
                if (keyType != null) {
                    result.add(keyType);
                }
            }
            return result;
        }

        private static String clientKeyType(byte clientCertificateType) {
            switch (clientCertificateType) {
                case 1:
                    return "RSA";
                case 3:
                    return "DH_RSA";
                case 64:
                    return "EC";
                case 65:
                    return "EC_RSA";
                case 66:
                    return "EC_EC";
                default:
                    return null;
            }
        }
    }
}
