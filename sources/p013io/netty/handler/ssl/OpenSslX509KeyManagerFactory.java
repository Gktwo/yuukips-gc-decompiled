package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509KeyManager;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.OpenSslX509KeyManagerFactory */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslX509KeyManagerFactory.class */
public final class OpenSslX509KeyManagerFactory extends KeyManagerFactory {
    private final OpenSslKeyManagerFactorySpi spi;

    public OpenSslX509KeyManagerFactory() {
        this(newOpenSslKeyManagerFactorySpi(null));
    }

    public OpenSslX509KeyManagerFactory(Provider provider) {
        this(newOpenSslKeyManagerFactorySpi(provider));
    }

    public OpenSslX509KeyManagerFactory(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        this(newOpenSslKeyManagerFactorySpi(algorithm, provider));
    }

    private OpenSslX509KeyManagerFactory(OpenSslKeyManagerFactorySpi spi) {
        super(spi, spi.kmf.getProvider(), spi.kmf.getAlgorithm());
        this.spi = spi;
    }

    private static OpenSslKeyManagerFactorySpi newOpenSslKeyManagerFactorySpi(Provider provider) {
        try {
            return newOpenSslKeyManagerFactorySpi(null, provider);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private static OpenSslKeyManagerFactorySpi newOpenSslKeyManagerFactorySpi(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        KeyManagerFactory keyManagerFactory;
        if (algorithm == null) {
            algorithm = KeyManagerFactory.getDefaultAlgorithm();
        }
        if (provider == null) {
            keyManagerFactory = KeyManagerFactory.getInstance(algorithm);
        } else {
            keyManagerFactory = KeyManagerFactory.getInstance(algorithm, provider);
        }
        return new OpenSslKeyManagerFactorySpi(keyManagerFactory);
    }

    /* access modifiers changed from: package-private */
    public OpenSslKeyMaterialProvider newProvider() {
        return this.spi.newProvider();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.OpenSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi.class */
    public static final class OpenSslKeyManagerFactorySpi extends KeyManagerFactorySpi {
        final KeyManagerFactory kmf;
        private volatile ProviderFactory providerFactory;

        OpenSslKeyManagerFactorySpi(KeyManagerFactory kmf) {
            this.kmf = (KeyManagerFactory) ObjectUtil.checkNotNull(kmf, "kmf");
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected synchronized void engineInit(KeyStore keyStore, char[] chars) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
            if (this.providerFactory != null) {
                throw new KeyStoreException("Already initialized");
            } else if (!keyStore.aliases().hasMoreElements()) {
                throw new KeyStoreException("No aliases found");
            } else {
                this.kmf.init(keyStore, chars);
                this.providerFactory = new ProviderFactory(ReferenceCountedOpenSslContext.chooseX509KeyManager(this.kmf.getKeyManagers()), password(chars), Collections.list(keyStore.aliases()));
            }
        }

        private static String password(char[] password) {
            if (password == null || password.length == 0) {
                return null;
            }
            return new String(password);
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("Not supported");
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        protected KeyManager[] engineGetKeyManagers() {
            ProviderFactory providerFactory = this.providerFactory;
            if (providerFactory != null) {
                return new KeyManager[]{providerFactory.keyManager};
            }
            throw new IllegalStateException("engineInit(...) not called yet");
        }

        OpenSslKeyMaterialProvider newProvider() {
            ProviderFactory providerFactory = this.providerFactory;
            if (providerFactory != null) {
                return providerFactory.newProvider();
            }
            throw new IllegalStateException("engineInit(...) not called yet");
        }

        /* access modifiers changed from: private */
        /* renamed from: io.netty.handler.ssl.OpenSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory */
        /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory.class */
        public static final class ProviderFactory {
            private final X509KeyManager keyManager;
            private final String password;
            private final Iterable<String> aliases;

            ProviderFactory(X509KeyManager keyManager, String password, Iterable<String> aliases) {
                this.keyManager = keyManager;
                this.password = password;
                this.aliases = aliases;
            }

            OpenSslKeyMaterialProvider newProvider() {
                return new OpenSslPopulatedKeyMaterialProvider(this.keyManager, this.password, this.aliases);
            }

            /* access modifiers changed from: private */
            /* renamed from: io.netty.handler.ssl.OpenSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory$OpenSslPopulatedKeyMaterialProvider */
            /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory$OpenSslPopulatedKeyMaterialProvider.class */
            public static final class OpenSslPopulatedKeyMaterialProvider extends OpenSslKeyMaterialProvider {
                private final Map<String, Object> materialMap;

                /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                    jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:11:0x005d
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                    */
                OpenSslPopulatedKeyMaterialProvider(javax.net.ssl.X509KeyManager r7, java.lang.String r8, java.lang.Iterable<java.lang.String> r9) {
                    /*
                        r6 = this;
                        r0 = r6
                        r1 = r7
                        r2 = r8
                        r0.<init>(r1, r2)
                        r0 = r6
                        java.util.HashMap r1 = new java.util.HashMap
                        r2 = r1
                        r2.<init>()
                        r0.materialMap = r1
                        r0 = 0
                        r10 = r0
                        r0 = r9
                        java.util.Iterator r0 = r0.iterator()     // Catch: all -> 0x007f
                        r11 = r0
                    L_0x001c:
                        r0 = r11
                        boolean r0 = r0.hasNext()     // Catch: all -> 0x007f
                        if (r0 == 0) goto L_0x0070
                        r0 = r11
                        java.lang.Object r0 = r0.next()     // Catch: all -> 0x007f
                        java.lang.String r0 = (java.lang.String) r0     // Catch: all -> 0x007f
                        r12 = r0
                        r0 = r12
                        if (r0 == 0) goto L_0x006d
                        r0 = r6
                        java.util.Map<java.lang.String, java.lang.Object> r0 = r0.materialMap     // Catch: all -> 0x007f
                        r1 = r12
                        boolean r0 = r0.containsKey(r1)     // Catch: all -> 0x007f
                        if (r0 != 0) goto L_0x006d
                        r0 = r6
                        java.util.Map<java.lang.String, java.lang.Object> r0 = r0.materialMap     // Catch: all -> 0x007f, Exception -> 0x005d
                        r1 = r12
                        r2 = r6
                        io.netty.buffer.UnpooledByteBufAllocator r3 = p013io.netty.buffer.UnpooledByteBufAllocator.DEFAULT     // Catch: all -> 0x007f, Exception -> 0x005d
                        r4 = r12
                        io.netty.handler.ssl.OpenSslKeyMaterial r2 = r2.chooseKeyMaterial(r3, r4)     // Catch: all -> 0x007f, Exception -> 0x005d
                        java.lang.Object r0 = r0.put(r1, r2)     // Catch: all -> 0x007f, Exception -> 0x005d
                        goto L_0x006d
                    L_0x005d:
                        r13 = move-exception
                        r0 = r6
                        java.util.Map<java.lang.String, java.lang.Object> r0 = r0.materialMap     // Catch: all -> 0x007f
                        r1 = r12
                        r2 = r13
                        java.lang.Object r0 = r0.put(r1, r2)     // Catch: all -> 0x007f
                    L_0x006d:
                        goto L_0x001c
                    L_0x0070:
                        r0 = 1
                        r10 = r0
                        r0 = r10
                        if (r0 != 0) goto L_0x008d
                        r0 = r6
                        r0.destroy()
                        goto L_0x008d
                    L_0x007f:
                        r14 = move-exception
                        r0 = r10
                        if (r0 != 0) goto L_0x008a
                        r0 = r6
                        r0.destroy()
                    L_0x008a:
                        r0 = r14
                        throw r0
                    L_0x008d:
                        r0 = r6
                        java.util.Map<java.lang.String, java.lang.Object> r0 = r0.materialMap
                        java.lang.String r1 = "materialMap"
                        java.util.Map r0 = p013io.netty.util.internal.ObjectUtil.checkNonEmpty(r0, r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.OpenSslX509KeyManagerFactory.OpenSslKeyManagerFactorySpi.ProviderFactory.OpenSslPopulatedKeyMaterialProvider.<init>(javax.net.ssl.X509KeyManager, java.lang.String, java.lang.Iterable):void");
                }

                /* access modifiers changed from: package-private */
                @Override // p013io.netty.handler.ssl.OpenSslKeyMaterialProvider
                public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator allocator, String alias) throws Exception {
                    Object value = this.materialMap.get(alias);
                    if (value == null) {
                        return null;
                    }
                    if (value instanceof OpenSslKeyMaterial) {
                        return ((OpenSslKeyMaterial) value).retain();
                    }
                    throw ((Exception) value);
                }

                /* access modifiers changed from: package-private */
                @Override // p013io.netty.handler.ssl.OpenSslKeyMaterialProvider
                public void destroy() {
                    for (Object material : this.materialMap.values()) {
                        ReferenceCountUtil.release(material);
                    }
                    this.materialMap.clear();
                }
            }
        }
    }

    public static OpenSslX509KeyManagerFactory newEngineBased(File certificateChain, String password) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        return newEngineBased(SslContext.toX509Certificates(certificateChain), password);
    }

    public static OpenSslX509KeyManagerFactory newEngineBased(X509Certificate[] certificateChain, String password) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        ObjectUtil.checkNotNull(certificateChain, "certificateChain");
        KeyStore store = new OpenSslKeyStore((X509Certificate[]) certificateChain.clone(), false);
        store.load(null, null);
        OpenSslX509KeyManagerFactory factory = new OpenSslX509KeyManagerFactory();
        factory.init(store, password == null ? null : password.toCharArray());
        return factory;
    }

    public static OpenSslX509KeyManagerFactory newKeyless(File chain) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        return newKeyless(SslContext.toX509Certificates(chain));
    }

    public static OpenSslX509KeyManagerFactory newKeyless(InputStream chain) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        return newKeyless(SslContext.toX509Certificates(chain));
    }

    public static OpenSslX509KeyManagerFactory newKeyless(X509Certificate... certificateChain) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        ObjectUtil.checkNotNull(certificateChain, "certificateChain");
        KeyStore store = new OpenSslKeyStore((X509Certificate[]) certificateChain.clone(), true);
        store.load(null, null);
        OpenSslX509KeyManagerFactory factory = new OpenSslX509KeyManagerFactory();
        factory.init(store, null);
        return factory;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.OpenSslX509KeyManagerFactory$OpenSslKeyStore */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslX509KeyManagerFactory$OpenSslKeyStore.class */
    public static final class OpenSslKeyStore extends KeyStore {
        private OpenSslKeyStore(final X509Certificate[] certificateChain, final boolean keyless) {
            super(new KeyStoreSpi() { // from class: io.netty.handler.ssl.OpenSslX509KeyManagerFactory.OpenSslKeyStore.1
                private final Date creationDate = new Date();

                /* JADX WARN: Type inference failed for: r0v11, types: [long] */
                @Override // java.security.KeyStoreSpi
                public Key engineGetKey(String alias, char[] password) throws UnrecoverableKeyException {
                    char c;
                    String str;
                    if (!engineContainsAlias(alias)) {
                        return null;
                    }
                    if (keyless) {
                        c = 0;
                    } else {
                        if (password == null) {
                            str = null;
                        } else {
                            try {
                                str = new String(password);
                            } catch (Exception e) {
                                UnrecoverableKeyException keyException = new UnrecoverableKeyException("Unable to load key from engine");
                                keyException.initCause(e);
                                throw keyException;
                            }
                        }
                        c = SSL.loadPrivateKeyFromEngine(alias, str);
                    }
                    return new OpenSslPrivateKey(c);
                }

                @Override // java.security.KeyStoreSpi
                public Certificate[] engineGetCertificateChain(String alias) {
                    if (engineContainsAlias(alias)) {
                        return (X509Certificate[]) certificateChain.clone();
                    }
                    return null;
                }

                @Override // java.security.KeyStoreSpi
                public Certificate engineGetCertificate(String alias) {
                    if (engineContainsAlias(alias)) {
                        return certificateChain[0];
                    }
                    return null;
                }

                @Override // java.security.KeyStoreSpi
                public Date engineGetCreationDate(String alias) {
                    if (engineContainsAlias(alias)) {
                        return this.creationDate;
                    }
                    return null;
                }

                @Override // java.security.KeyStoreSpi
                public void engineSetKeyEntry(String alias, Key key, char[] password, Certificate[] chain) throws KeyStoreException {
                    throw new KeyStoreException("Not supported");
                }

                @Override // java.security.KeyStoreSpi
                public void engineSetKeyEntry(String alias, byte[] key, Certificate[] chain) throws KeyStoreException {
                    throw new KeyStoreException("Not supported");
                }

                @Override // java.security.KeyStoreSpi
                public void engineSetCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
                    throw new KeyStoreException("Not supported");
                }

                @Override // java.security.KeyStoreSpi
                public void engineDeleteEntry(String alias) throws KeyStoreException {
                    throw new KeyStoreException("Not supported");
                }

                @Override // java.security.KeyStoreSpi
                public Enumeration<String> engineAliases() {
                    return Collections.enumeration(Collections.singleton(Action.KEY_ATTRIBUTE));
                }

                @Override // java.security.KeyStoreSpi
                public boolean engineContainsAlias(String alias) {
                    return Action.KEY_ATTRIBUTE.equals(alias);
                }

                @Override // java.security.KeyStoreSpi
                public int engineSize() {
                    return 1;
                }

                @Override // java.security.KeyStoreSpi
                public boolean engineIsKeyEntry(String alias) {
                    return engineContainsAlias(alias);
                }

                @Override // java.security.KeyStoreSpi
                public boolean engineIsCertificateEntry(String alias) {
                    return engineContainsAlias(alias);
                }

                @Override // java.security.KeyStoreSpi
                public String engineGetCertificateAlias(Certificate cert) {
                    if (!(cert instanceof X509Certificate)) {
                        return null;
                    }
                    for (X509Certificate x509Certificate : certificateChain) {
                        if (x509Certificate.equals(cert)) {
                            return Action.KEY_ATTRIBUTE;
                        }
                    }
                    return null;
                }

                @Override // java.security.KeyStoreSpi
                public void engineStore(OutputStream stream, char[] password) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.security.KeyStoreSpi
                public void engineLoad(InputStream stream, char[] password) {
                    if (stream != null && password != null) {
                        throw new UnsupportedOperationException();
                    }
                }
            }, null, "native");
            OpenSsl.ensureAvailability();
        }
    }
}
