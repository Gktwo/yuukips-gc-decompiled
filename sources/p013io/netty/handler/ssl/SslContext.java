package p013io.netty.handler.ssl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.handler.ssl.ApplicationProtocolConfig;
import p013io.netty.util.AttributeMap;
import p013io.netty.util.DefaultAttributeMap;
import p013io.netty.util.internal.EmptyArrays;

/* renamed from: io.netty.handler.ssl.SslContext */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslContext.class */
public abstract class SslContext {
    static final String ALIAS = "key";
    static final CertificateFactory X509_CERT_FACTORY;
    private final boolean startTls;
    private final AttributeMap attributes;

    public abstract boolean isClient();

    public abstract List<String> cipherSuites();

    public abstract ApplicationProtocolNegotiator applicationProtocolNegotiator();

    public abstract SSLEngine newEngine(ByteBufAllocator byteBufAllocator);

    public abstract SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i);

    public abstract SSLSessionContext sessionContext();

    static {
        try {
            X509_CERT_FACTORY = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new IllegalStateException("unable to instance X.509 CertificateFactory", e);
        }
    }

    public static SslProvider defaultServerProvider() {
        return defaultProvider();
    }

    public static SslProvider defaultClientProvider() {
        return defaultProvider();
    }

    private static SslProvider defaultProvider() {
        if (OpenSsl.isAvailable()) {
            return SslProvider.OPENSSL;
        }
        return SslProvider.JDK;
    }

    @Deprecated
    public static SslContext newServerContext(File certChainFile, File keyFile) throws SSLException {
        return newServerContext(certChainFile, keyFile, (String) null);
    }

    @Deprecated
    public static SslContext newServerContext(File certChainFile, File keyFile, String keyPassword) throws SSLException {
        return newServerContext(null, certChainFile, keyFile, keyPassword);
    }

    @Deprecated
    public static SslContext newServerContext(File certChainFile, File keyFile, String keyPassword, Iterable<String> ciphers, Iterable<String> nextProtocols, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newServerContext((SslProvider) null, certChainFile, keyFile, keyPassword, ciphers, nextProtocols, sessionCacheSize, sessionTimeout);
    }

    @Deprecated
    public static SslContext newServerContext(File certChainFile, File keyFile, String keyPassword, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newServerContext((SslProvider) null, certChainFile, keyFile, keyPassword, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider provider, File certChainFile, File keyFile) throws SSLException {
        return newServerContext(provider, certChainFile, keyFile, null);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider provider, File certChainFile, File keyFile, String keyPassword) throws SSLException {
        return newServerContext(provider, certChainFile, keyFile, keyPassword, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, (ApplicationProtocolConfig) null, 0, 0);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider provider, File certChainFile, File keyFile, String keyPassword, Iterable<String> ciphers, Iterable<String> nextProtocols, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newServerContext(provider, certChainFile, keyFile, keyPassword, ciphers, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(nextProtocols), sessionCacheSize, sessionTimeout);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider provider, File certChainFile, File keyFile, String keyPassword, TrustManagerFactory trustManagerFactory, Iterable<String> ciphers, Iterable<String> nextProtocols, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newServerContext(provider, null, trustManagerFactory, certChainFile, keyFile, keyPassword, null, ciphers, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(nextProtocols), sessionCacheSize, sessionTimeout);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider provider, File certChainFile, File keyFile, String keyPassword, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newServerContext(provider, null, null, certChainFile, keyFile, keyPassword, null, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout, KeyStore.getDefaultType());
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider provider, File trustCertCollectionFile, TrustManagerFactory trustManagerFactory, File keyCertChainFile, File keyFile, String keyPassword, KeyManagerFactory keyManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newServerContext(provider, trustCertCollectionFile, trustManagerFactory, keyCertChainFile, keyFile, keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout, KeyStore.getDefaultType());
    }

    static SslContext newServerContext(SslProvider provider, File trustCertCollectionFile, TrustManagerFactory trustManagerFactory, File keyCertChainFile, File keyFile, String keyPassword, KeyManagerFactory keyManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout, String keyStore) throws SSLException {
        try {
            return newServerContextInternal(provider, null, toX509Certificates(trustCertCollectionFile), trustManagerFactory, toX509Certificates(keyCertChainFile), toPrivateKey(keyFile, keyPassword), keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout, ClientAuth.NONE, null, false, false, keyStore, new Map.Entry[0]);
        } catch (Exception e) {
            if (e instanceof SSLException) {
                throw ((SSLException) e);
            }
            throw new SSLException("failed to initialize the server-side SSL context", e);
        }
    }

    /* access modifiers changed from: package-private */
    public static SslContext newServerContextInternal(SslProvider provider, Provider sslContextProvider, X509Certificate[] trustCertCollection, TrustManagerFactory trustManagerFactory, X509Certificate[] keyCertChain, PrivateKey key, String keyPassword, KeyManagerFactory keyManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout, ClientAuth clientAuth, String[] protocols, boolean startTls, boolean enableOcsp, String keyStoreType, Map.Entry<SslContextOption<?>, Object>... ctxOptions) throws SSLException {
        if (provider == null) {
            provider = defaultServerProvider();
        }
        switch (provider) {
            case JDK:
                if (!enableOcsp) {
                    return new JdkSslServerContext(sslContextProvider, trustCertCollection, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout, clientAuth, protocols, startTls, keyStoreType);
                }
                throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + provider);
            case OPENSSL:
                verifyNullSslContextProvider(provider, sslContextProvider);
                return new OpenSslServerContext(trustCertCollection, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout, clientAuth, protocols, startTls, enableOcsp, keyStoreType, ctxOptions);
            case OPENSSL_REFCNT:
                verifyNullSslContextProvider(provider, sslContextProvider);
                return new ReferenceCountedOpenSslServerContext(trustCertCollection, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout, clientAuth, protocols, startTls, enableOcsp, keyStoreType, ctxOptions);
            default:
                throw new Error(provider.toString());
        }
    }

    private static void verifyNullSslContextProvider(SslProvider provider, Provider sslContextProvider) {
        if (sslContextProvider != null) {
            throw new IllegalArgumentException("Java Security Provider unsupported for SslProvider: " + provider);
        }
    }

    @Deprecated
    public static SslContext newClientContext() throws SSLException {
        return newClientContext(null, null, null);
    }

    @Deprecated
    public static SslContext newClientContext(File certChainFile) throws SSLException {
        return newClientContext((SslProvider) null, certChainFile);
    }

    @Deprecated
    public static SslContext newClientContext(TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(null, null, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newClientContext(File certChainFile, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(null, certChainFile, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newClientContext(File certChainFile, TrustManagerFactory trustManagerFactory, Iterable<String> ciphers, Iterable<String> nextProtocols, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newClientContext((SslProvider) null, certChainFile, trustManagerFactory, ciphers, nextProtocols, sessionCacheSize, sessionTimeout);
    }

    @Deprecated
    public static SslContext newClientContext(File certChainFile, TrustManagerFactory trustManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newClientContext(null, certChainFile, trustManagerFactory, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider provider) throws SSLException {
        return newClientContext(provider, null, null);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider provider, File certChainFile) throws SSLException {
        return newClientContext(provider, certChainFile, null);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider provider, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(provider, null, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider provider, File certChainFile, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(provider, certChainFile, trustManagerFactory, null, IdentityCipherSuiteFilter.INSTANCE, null, 0, 0);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider provider, File certChainFile, TrustManagerFactory trustManagerFactory, Iterable<String> ciphers, Iterable<String> nextProtocols, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newClientContext(provider, certChainFile, trustManagerFactory, null, null, null, null, ciphers, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(nextProtocols), sessionCacheSize, sessionTimeout);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider provider, File certChainFile, TrustManagerFactory trustManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout) throws SSLException {
        return newClientContext(provider, certChainFile, trustManagerFactory, null, null, null, null, ciphers, cipherFilter, apn, sessionCacheSize, sessionTimeout);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider provider, File trustCertCollectionFile, TrustManagerFactory trustManagerFactory, File keyCertChainFile, File keyFile, String keyPassword, KeyManagerFactory keyManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, long sessionCacheSize, long sessionTimeout) throws SSLException {
        try {
            return newClientContextInternal(provider, null, toX509Certificates(trustCertCollectionFile), trustManagerFactory, toX509Certificates(keyCertChainFile), toPrivateKey(keyFile, keyPassword), keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, null, sessionCacheSize, sessionTimeout, false, KeyStore.getDefaultType(), new Map.Entry[0]);
        } catch (Exception e) {
            if (e instanceof SSLException) {
                throw ((SSLException) e);
            }
            throw new SSLException("failed to initialize the client-side SSL context", e);
        }
    }

    /* access modifiers changed from: package-private */
    public static SslContext newClientContextInternal(SslProvider provider, Provider sslContextProvider, X509Certificate[] trustCert, TrustManagerFactory trustManagerFactory, X509Certificate[] keyCertChain, PrivateKey key, String keyPassword, KeyManagerFactory keyManagerFactory, Iterable<String> ciphers, CipherSuiteFilter cipherFilter, ApplicationProtocolConfig apn, String[] protocols, long sessionCacheSize, long sessionTimeout, boolean enableOcsp, String keyStoreType, Map.Entry<SslContextOption<?>, Object>... options) throws SSLException {
        if (provider == null) {
            provider = defaultClientProvider();
        }
        switch (provider) {
            case JDK:
                if (!enableOcsp) {
                    return new JdkSslClientContext(sslContextProvider, trustCert, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, protocols, sessionCacheSize, sessionTimeout, keyStoreType);
                }
                throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + provider);
            case OPENSSL:
                verifyNullSslContextProvider(provider, sslContextProvider);
                OpenSsl.ensureAvailability();
                return new OpenSslClientContext(trustCert, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, protocols, sessionCacheSize, sessionTimeout, enableOcsp, keyStoreType, options);
            case OPENSSL_REFCNT:
                verifyNullSslContextProvider(provider, sslContextProvider);
                OpenSsl.ensureAvailability();
                return new ReferenceCountedOpenSslClientContext(trustCert, trustManagerFactory, keyCertChain, key, keyPassword, keyManagerFactory, ciphers, cipherFilter, apn, protocols, sessionCacheSize, sessionTimeout, enableOcsp, keyStoreType, options);
            default:
                throw new Error(provider.toString());
        }
    }

    static ApplicationProtocolConfig toApplicationProtocolConfig(Iterable<String> nextProtocols) {
        ApplicationProtocolConfig apn;
        if (nextProtocols == null) {
            apn = ApplicationProtocolConfig.DISABLED;
        } else {
            apn = new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.NPN_AND_ALPN, ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL, ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT, nextProtocols);
        }
        return apn;
    }

    /* access modifiers changed from: protected */
    public SslContext() {
        this(false);
    }

    /* access modifiers changed from: protected */
    public SslContext(boolean startTls) {
        this.attributes = new DefaultAttributeMap();
        this.startTls = startTls;
    }

    public final AttributeMap attributes() {
        return this.attributes;
    }

    public final boolean isServer() {
        return !isClient();
    }

    public long sessionCacheSize() {
        return (long) sessionContext().getSessionCacheSize();
    }

    public long sessionTimeout() {
        return (long) sessionContext().getSessionTimeout();
    }

    @Deprecated
    public final List<String> nextProtocols() {
        return applicationProtocolNegotiator().protocols();
    }

    public final SslHandler newHandler(ByteBufAllocator alloc) {
        return newHandler(alloc, this.startTls);
    }

    /* access modifiers changed from: protected */
    public SslHandler newHandler(ByteBufAllocator alloc, boolean startTls) {
        return new SslHandler(newEngine(alloc), startTls);
    }

    public SslHandler newHandler(ByteBufAllocator alloc, Executor delegatedTaskExecutor) {
        return newHandler(alloc, this.startTls, delegatedTaskExecutor);
    }

    /* access modifiers changed from: protected */
    public SslHandler newHandler(ByteBufAllocator alloc, boolean startTls, Executor executor) {
        return new SslHandler(newEngine(alloc), startTls, executor);
    }

    public final SslHandler newHandler(ByteBufAllocator alloc, String peerHost, int peerPort) {
        return newHandler(alloc, peerHost, peerPort, this.startTls);
    }

    /* access modifiers changed from: protected */
    public SslHandler newHandler(ByteBufAllocator alloc, String peerHost, int peerPort, boolean startTls) {
        return new SslHandler(newEngine(alloc, peerHost, peerPort), startTls);
    }

    public SslHandler newHandler(ByteBufAllocator alloc, String peerHost, int peerPort, Executor delegatedTaskExecutor) {
        return newHandler(alloc, peerHost, peerPort, this.startTls, delegatedTaskExecutor);
    }

    /* access modifiers changed from: protected */
    public SslHandler newHandler(ByteBufAllocator alloc, String peerHost, int peerPort, boolean startTls, Executor delegatedTaskExecutor) {
        return new SslHandler(newEngine(alloc, peerHost, peerPort), startTls, delegatedTaskExecutor);
    }

    @Deprecated
    protected static PKCS8EncodedKeySpec generateKeySpec(char[] password, byte[] key) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (password == null) {
            return new PKCS8EncodedKeySpec(key);
        }
        EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(key);
        SecretKey pbeKey = SecretKeyFactory.getInstance(encryptedPrivateKeyInfo.getAlgName()).generateSecret(new PBEKeySpec(password));
        Cipher cipher = Cipher.getInstance(encryptedPrivateKeyInfo.getAlgName());
        cipher.init(2, pbeKey, encryptedPrivateKeyInfo.getAlgParameters());
        return encryptedPrivateKeyInfo.getKeySpec(cipher);
    }

    protected static KeyStore buildKeyStore(X509Certificate[] certChain, PrivateKey key, char[] keyPasswordChars, String keyStoreType) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        if (keyStoreType == null) {
            keyStoreType = KeyStore.getDefaultType();
        }
        KeyStore ks = KeyStore.getInstance(keyStoreType);
        ks.load(null, null);
        ks.setKeyEntry("key", key, keyPasswordChars, certChain);
        return ks;
    }

    /* access modifiers changed from: protected */
    public static PrivateKey toPrivateKey(File keyFile, String keyPassword) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException {
        if (keyFile == null) {
            return null;
        }
        return getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(keyFile), keyPassword);
    }

    /* access modifiers changed from: protected */
    public static PrivateKey toPrivateKey(InputStream keyInputStream, String keyPassword) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException {
        if (keyInputStream == null) {
            return null;
        }
        return getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(keyInputStream), keyPassword);
    }

    private static PrivateKey getPrivateKeyFromByteBuffer(ByteBuf encodedKeyBuf, String keyPassword) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException {
        byte[] encodedKey = new byte[encodedKeyBuf.readableBytes()];
        encodedKeyBuf.readBytes(encodedKey).release();
        PKCS8EncodedKeySpec encodedKeySpec = generateKeySpec(keyPassword == null ? null : keyPassword.toCharArray(), encodedKey);
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(encodedKeySpec);
        } catch (InvalidKeySpecException e) {
            try {
                return KeyFactory.getInstance("DSA").generatePrivate(encodedKeySpec);
            } catch (InvalidKeySpecException e2) {
                try {
                    return KeyFactory.getInstance("EC").generatePrivate(encodedKeySpec);
                } catch (InvalidKeySpecException e3) {
                    throw new InvalidKeySpecException("Neither RSA, DSA nor EC worked", e3);
                }
            }
        }
    }

    @Deprecated
    protected static TrustManagerFactory buildTrustManagerFactory(File certChainFile, TrustManagerFactory trustManagerFactory) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException {
        return buildTrustManagerFactory(certChainFile, trustManagerFactory, (String) null);
    }

    protected static TrustManagerFactory buildTrustManagerFactory(File certChainFile, TrustManagerFactory trustManagerFactory, String keyType) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException {
        return buildTrustManagerFactory(toX509Certificates(certChainFile), trustManagerFactory, keyType);
    }

    /* access modifiers changed from: protected */
    public static X509Certificate[] toX509Certificates(File file) throws CertificateException {
        if (file == null) {
            return null;
        }
        return getCertificatesFromBuffers(PemReader.readCertificates(file));
    }

    /* access modifiers changed from: protected */
    public static X509Certificate[] toX509Certificates(InputStream in) throws CertificateException {
        if (in == null) {
            return null;
        }
        return getCertificatesFromBuffers(PemReader.readCertificates(in));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0041
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.security.cert.X509Certificate[] getCertificatesFromBuffers(p013io.netty.buffer.ByteBuf[] r5) throws java.security.cert.CertificateException {
        /*
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)
            r6 = r0
            r0 = r5
            int r0 = r0.length
            java.security.cert.X509Certificate[] r0 = new java.security.cert.X509Certificate[r0]
            r7 = r0
            r0 = 0
            r8 = r0
        L_0x000e:
            r0 = r8
            r1 = r5
            int r1 = r1.length     // Catch: all -> 0x0085
            if (r0 >= r1) goto L_0x0060
            io.netty.buffer.ByteBufInputStream r0 = new io.netty.buffer.ByteBufInputStream     // Catch: all -> 0x0085
            r1 = r0
            r2 = r5
            r3 = r8
            r2 = r2[r3]     // Catch: all -> 0x0085
            r3 = 0
            r1.<init>(r2, r3)     // Catch: all -> 0x0085
            r9 = r0
            r0 = r7
            r1 = r8
            r2 = r6
            r3 = r9
            java.security.cert.Certificate r2 = r2.generateCertificate(r3)     // Catch: all -> 0x0085, all -> 0x0041
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2     // Catch: all -> 0x0085, all -> 0x0041
            r0[r1] = r2     // Catch: all -> 0x0085, all -> 0x0041
            r0 = r9
            r0.close()     // Catch: IOException -> 0x0035, all -> 0x0085
            goto L_0x005a
        L_0x0035:
            r10 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: all -> 0x0085
            r1 = r0
            r2 = r10
            r1.<init>(r2)     // Catch: all -> 0x0085
            throw r0     // Catch: all -> 0x0085
        L_0x0041:
            r11 = move-exception
            r0 = r9
            r0.close()     // Catch: IOException -> 0x004b, all -> 0x0085
            goto L_0x0057
        L_0x004b:
            r12 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: all -> 0x0085
            r1 = r0
            r2 = r12
            r1.<init>(r2)     // Catch: all -> 0x0085
            throw r0     // Catch: all -> 0x0085
        L_0x0057:
            r0 = r11
            throw r0     // Catch: all -> 0x0085
        L_0x005a:
            int r8 = r8 + 1
            goto L_0x000e
        L_0x0060:
            r0 = r5
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r10 = r0
        L_0x0069:
            r0 = r10
            r1 = r9
            if (r0 >= r1) goto L_0x0082
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            boolean r0 = r0.release()
            int r10 = r10 + 1
            goto L_0x0069
        L_0x0082:
            goto L_0x00af
        L_0x0085:
            r13 = move-exception
            r0 = r5
            r14 = r0
            r0 = r14
            int r0 = r0.length
            r15 = r0
            r0 = 0
            r16 = r0
        L_0x0092:
            r0 = r16
            r1 = r15
            if (r0 >= r1) goto L_0x00ac
            r0 = r14
            r1 = r16
            r0 = r0[r1]
            r17 = r0
            r0 = r17
            boolean r0 = r0.release()
            int r16 = r16 + 1
            goto L_0x0092
        L_0x00ac:
            r0 = r13
            throw r0
        L_0x00af:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.SslContext.getCertificatesFromBuffers(io.netty.buffer.ByteBuf[]):java.security.cert.X509Certificate[]");
    }

    protected static TrustManagerFactory buildTrustManagerFactory(X509Certificate[] certCollection, TrustManagerFactory trustManagerFactory, String keyStoreType) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException {
        if (keyStoreType == null) {
            keyStoreType = KeyStore.getDefaultType();
        }
        KeyStore ks = KeyStore.getInstance(keyStoreType);
        ks.load(null, null);
        int i = 1;
        for (X509Certificate cert : certCollection) {
            ks.setCertificateEntry(Integer.toString(i), cert);
            i++;
        }
        if (trustManagerFactory == null) {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        }
        trustManagerFactory.init(ks);
        return trustManagerFactory;
    }

    static PrivateKey toPrivateKeyInternal(File keyFile, String keyPassword) throws SSLException {
        try {
            return toPrivateKey(keyFile, keyPassword);
        } catch (Exception e) {
            throw new SSLException(e);
        }
    }

    static X509Certificate[] toX509CertificatesInternal(File file) throws SSLException {
        try {
            return toX509Certificates(file);
        } catch (CertificateException e) {
            throw new SSLException(e);
        }
    }

    protected static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] certChainFile, String keyAlgorithm, PrivateKey key, String keyPassword, KeyManagerFactory kmf, String keyStore) throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException, UnrecoverableKeyException {
        if (keyAlgorithm == null) {
            keyAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        }
        char[] keyPasswordChars = keyStorePassword(keyPassword);
        return buildKeyManagerFactory(buildKeyStore(certChainFile, key, keyPasswordChars, keyStore), keyAlgorithm, keyPasswordChars, kmf);
    }

    static KeyManagerFactory buildKeyManagerFactory(KeyStore ks, String keyAlgorithm, char[] keyPasswordChars, KeyManagerFactory kmf) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (kmf == null) {
            if (keyAlgorithm == null) {
                keyAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
            }
            kmf = KeyManagerFactory.getInstance(keyAlgorithm);
        }
        kmf.init(ks, keyPasswordChars);
        return kmf;
    }

    static char[] keyStorePassword(String keyPassword) {
        return keyPassword == null ? EmptyArrays.EMPTY_CHARS : keyPassword.toCharArray();
    }
}
