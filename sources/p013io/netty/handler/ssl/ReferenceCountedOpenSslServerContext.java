package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SniHostNameMatcher;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslServerContext */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslServerContext.class */
public final class ReferenceCountedOpenSslServerContext extends ReferenceCountedOpenSslContext {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslServerContext.class);

    /* renamed from: ID */
    private static final byte[] f1026ID = {110, 101, 116, 116, 121};
    private final OpenSslServerSessionContext sessionContext;

    /* access modifiers changed from: package-private */
    public ReferenceCountedOpenSslServerContext(X509Certificate[] trustCertCollection, TrustManagerFactory trustManagerFactory, X509Certificate[] keyCertChain, PrivateKey key, String keyPassword, KeyManagerFactory keyManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout, ClientAuth clientAuth, String[] protocols, boolean startTls, boolean enableOcsp, String keyStore, Map.Entry<SslContextOption<?>, Object>... options) throws SSLException {
        this(trustCertCollection, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, ciphers, cipherFilter, toNegotiator(apn), sessionCacheSize, sessionTimeout, clientAuth, protocols, startTls, enableOcsp, keyStore, options);
    }

    ReferenceCountedOpenSslServerContext(X509Certificate[] trustCertCollection, TrustManagerFactory trustManagerFactory, X509Certificate[] keyCertChain, PrivateKey key, String keyPassword, KeyManagerFactory keyManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, OpenSslApplicationProtocolNegotiator apn, long sessionCacheSize, long sessionTimeout, ClientAuth clientAuth, String[] protocols, boolean startTls, boolean enableOcsp, String keyStore, Map.Entry<SslContextOption<?>, Object>... options) throws SSLException {
        super(ciphers, cipherFilter, apn, 1, keyCertChain, clientAuth, protocols, startTls, enableOcsp, true, options);
        try {
            this.sessionContext = newSessionContext(this, this.ctx, this.engineMap, trustCertCollection, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, keyStore, sessionCacheSize, sessionTimeout);
            if (SERVER_ENABLE_SESSION_TICKET) {
                this.sessionContext.setTicketKeys(new OpenSslSessionTicketKey[0]);
            }
            if (1 == 0) {
                release();
            }
        } catch (Throwable th) {
            if (0 == 0) {
                release();
            }
            throw th;
        }
    }

    @Override // p013io.netty.handler.ssl.ReferenceCountedOpenSslContext, p013io.netty.handler.ssl.SslContext
    public OpenSslServerSessionContext sessionContext() {
        return this.sessionContext;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public static OpenSslServerSessionContext newSessionContext(ReferenceCountedOpenSslContext thiz, long ctx, OpenSslEngineMap engineMap, X509Certificate[] trustCertCollection, TrustManagerFactory trustManagerFactory, X509Certificate[] keyCertChain, PrivateKey key, String keyPassword, KeyManagerFactory keyManagerFactory, String keyStore, long sessionCacheSize, long sessionTimeout) throws SSLException {
        OpenSslKeyMaterialProvider keyMaterialProvider;
        try {
            keyMaterialProvider = null;
            SSLContext.setVerify(ctx, 0, 10);
            try {
                if (OpenSsl.useKeyManagerFactory()) {
                    if (keyManagerFactory == null) {
                        char[] keyPasswordChars = keyStorePassword(keyPassword);
                        KeyStore ks = buildKeyStore(keyCertChain, key, keyPasswordChars, keyStore);
                        if (ks.aliases().hasMoreElements()) {
                            keyManagerFactory = new OpenSslX509KeyManagerFactory();
                        } else {
                            keyManagerFactory = new OpenSslCachingX509KeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
                        }
                        keyManagerFactory.init(ks, keyPasswordChars);
                    }
                    keyMaterialProvider = providerFor(keyManagerFactory, keyPassword);
                    SSLContext.setCertificateCallback(ctx, new OpenSslServerCertificateCallback(engineMap, new OpenSslKeyMaterialManager(keyMaterialProvider)));
                } else if (keyManagerFactory != null) {
                    throw new IllegalArgumentException("KeyManagerFactory not supported");
                } else {
                    ObjectUtil.checkNotNull(keyCertChain, "keyCertChain");
                    setKeyMaterial(ctx, keyCertChain, key, keyPassword);
                }
                if (trustCertCollection != null) {
                    try {
                        trustManagerFactory = buildTrustManagerFactory(trustCertCollection, trustManagerFactory, keyStore);
                    } catch (SSLException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new SSLException("unable to setup trustmanager", e2);
                    }
                } else if (trustManagerFactory == null) {
                    trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init((KeyStore) null);
                }
                X509TrustManager manager = chooseTrustManager(trustManagerFactory.getTrustManagers());
                setVerifyCallback(ctx, engineMap, manager);
                X509Certificate[] issuers = manager.getAcceptedIssuers();
                if (issuers != null && issuers.length > 0) {
                    long bio = toBIO(ByteBufAllocator.DEFAULT, issuers);
                    if (!SSLContext.setCACertificateBio(ctx, bio)) {
                        try {
                            throw new SSLException("unable to setup accepted issuers for trustmanager " + manager);
                        } catch (Throwable th) {
                            freeBio(bio);
                            throw th;
                        }
                    } else {
                        freeBio(bio);
                    }
                }
                if (PlatformDependent.javaVersion() >= 8) {
                    SSLContext.setSniHostnameMatcher(ctx, new OpenSslSniHostnameMatcher(engineMap));
                }
                OpenSslServerSessionContext sessionContext = new OpenSslServerSessionContext(thiz, keyMaterialProvider);
                sessionContext.setSessionIdContext(f1026ID);
                sessionContext.setSessionCacheEnabled(SERVER_ENABLE_SESSION_CACHE);
                if (sessionCacheSize > 0) {
                    sessionContext.setSessionCacheSize((int) Math.min(sessionCacheSize, 2147483647L));
                }
                if (sessionTimeout > 0) {
                    sessionContext.setSessionTimeout((int) Math.min(sessionTimeout, 2147483647L));
                }
                keyMaterialProvider = null;
                return sessionContext;
            } catch (Exception e3) {
                throw new SSLException("failed to set certificate and key", e3);
            }
        } finally {
            if (keyMaterialProvider != null) {
                keyMaterialProvider.destroy();
            }
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

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslServerContext$OpenSslServerCertificateCallback */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$OpenSslServerCertificateCallback.class */
    public static final class OpenSslServerCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        OpenSslServerCertificateCallback(OpenSslEngineMap engineMap, OpenSslKeyMaterialManager keyManagerHolder) {
            this.engineMap = engineMap;
            this.keyManagerHolder = keyManagerHolder;
        }

        public void handle(long ssl, byte[] keyTypeBytes, byte[][] asn1DerEncodedPrincipals) throws Exception {
            ReferenceCountedOpenSslEngine engine = this.engineMap.get(ssl);
            if (engine != null) {
                try {
                    this.keyManagerHolder.setKeyMaterialServerSide(engine);
                } catch (Throwable cause) {
                    engine.initHandshakeException(cause);
                    if (cause instanceof Exception) {
                        throw ((Exception) cause);
                    }
                    throw new SSLException(cause);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslServerContext$TrustManagerVerifyCallback */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$TrustManagerVerifyCallback.class */
    public static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        TrustManagerVerifyCallback(OpenSslEngineMap engineMap, X509TrustManager manager) {
            super(engineMap);
            this.manager = manager;
        }

        @Override // p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine engine, X509Certificate[] peerCerts, String auth) throws Exception {
            this.manager.checkClientTrusted(peerCerts, auth);
        }
    }

    /* access modifiers changed from: private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslServerContext$ExtendedTrustManagerVerifyCallback */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$ExtendedTrustManagerVerifyCallback.class */
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        ExtendedTrustManagerVerifyCallback(OpenSslEngineMap engineMap, X509ExtendedTrustManager manager) {
            super(engineMap);
            this.manager = manager;
        }

        @Override // p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine engine, X509Certificate[] peerCerts, String auth) throws Exception {
            this.manager.checkClientTrusted(peerCerts, auth, engine);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslServerContext$OpenSslSniHostnameMatcher */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslServerContext$OpenSslSniHostnameMatcher.class */
    public static final class OpenSslSniHostnameMatcher implements SniHostNameMatcher {
        private final OpenSslEngineMap engineMap;

        OpenSslSniHostnameMatcher(OpenSslEngineMap engineMap) {
            this.engineMap = engineMap;
        }

        public boolean match(long ssl, String hostname) {
            ReferenceCountedOpenSslEngine engine = this.engineMap.get(ssl);
            if (engine != null) {
                return engine.checkSniHostnameMatch(hostname.getBytes(CharsetUtil.UTF_8));
            }
            ReferenceCountedOpenSslServerContext.logger.warn("No ReferenceCountedOpenSslEngine found for SSL pointer: {}", Long.valueOf(ssl));
            return false;
        }
    }
}
