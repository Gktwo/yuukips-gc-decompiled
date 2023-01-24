package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.AsyncSSLPrivateKeyMethod;
import io.netty.internal.tcnative.CertificateCompressionAlgo;
import io.netty.internal.tcnative.CertificateVerifier;
import io.netty.internal.tcnative.ResultCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.handler.ssl.ApplicationProtocolConfig;
import p013io.netty.handler.ssl.OpenSslCertificateCompressionConfig;
import p013io.netty.handler.ssl.util.LazyX509Certificate;
import p013io.netty.util.AbstractReferenceCounted;
import p013io.netty.util.ReferenceCounted;
import p013io.netty.util.ResourceLeakDetector;
import p013io.netty.util.ResourceLeakDetectorFactory;
import p013io.netty.util.ResourceLeakTracker;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslContext.class */
public abstract class ReferenceCountedOpenSslContext extends SslContext implements ReferenceCounted {
    private static final Integer DH_KEY_LENGTH;
    protected static final int VERIFY_DEPTH = 10;
    protected long ctx;
    private final List<String> unmodifiableCiphers;
    private final OpenSslApplicationProtocolNegotiator apn;
    private final int mode;
    private final ResourceLeakTracker<ReferenceCountedOpenSslContext> leak;
    private final AbstractReferenceCounted refCnt;
    final Certificate[] keyCertChain;
    final ClientAuth clientAuth;
    final String[] protocols;
    final boolean enableOcsp;
    final OpenSslEngineMap engineMap;
    final ReadWriteLock ctxLock;
    private volatile int bioNonApplicationBufferSize;
    final boolean tlsFalseStart;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslContext.class);
    private static final int DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.handler.ssl.openssl.bioNonApplicationBufferSize", 2048));
    static final boolean USE_TASKS = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useTasks", true);
    private static final ResourceLeakDetector<ReferenceCountedOpenSslContext> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslContext.class);
    static final boolean CLIENT_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", false);
    static final boolean CLIENT_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", true);
    static final boolean SERVER_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", false);
    static final boolean SERVER_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", true);
    static final boolean SERVER_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheServer", true);
    static final boolean CLIENT_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheClient", false);
    static final OpenSslApplicationProtocolNegotiator NONE_PROTOCOL_NEGOTIATOR = new OpenSslApplicationProtocolNegotiator() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.2
        @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.Protocol protocol() {
            return ApplicationProtocolConfig.Protocol.NONE;
        }

        @Override // p013io.netty.handler.ssl.ApplicationProtocolNegotiator
        public List<String> protocols() {
            return Collections.emptyList();
        }

        @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
            return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
        }

        @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
            return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
        }
    };

    @Override // p013io.netty.handler.ssl.SslContext
    public abstract OpenSslSessionContext sessionContext();

    static {
        Integer dhLen = null;
        try {
            String dhKeySize = SystemPropertyUtil.get("jdk.tls.ephemeralDHKeySize");
            if (dhKeySize != null) {
                try {
                    dhLen = Integer.valueOf(dhKeySize);
                } catch (NumberFormatException e) {
                    logger.debug("ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: " + dhKeySize);
                }
            }
        } catch (Throwable th) {
        }
        DH_KEY_LENGTH = dhLen;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:73:0x02c5
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    ReferenceCountedOpenSslContext(java.lang.Iterable<java.lang.String> r8, p013io.netty.handler.ssl.CipherSuiteFilter r9, p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator r10, int r11, java.security.cert.Certificate[] r12, p013io.netty.handler.ssl.ClientAuth r13, java.lang.String[] r14, boolean r15, boolean r16, boolean r17, java.util.Map.Entry<p013io.netty.handler.ssl.SslContextOption<?>, java.lang.Object>... r18) throws javax.net.ssl.SSLException {
        /*
        // Method dump skipped, instructions count: 1278
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.<init>(java.lang.Iterable, io.netty.handler.ssl.CipherSuiteFilter, io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator, int, java.security.cert.Certificate[], io.netty.handler.ssl.ClientAuth, java.lang.String[], boolean, boolean, boolean, java.util.Map$Entry[]):void");
    }

    private static int opensslSelectorFailureBehavior(ApplicationProtocolConfig.SelectorFailureBehavior behavior) {
        switch (behavior) {
            case NO_ADVERTISE:
                return 0;
            case CHOOSE_MY_LAST_PROTOCOL:
                return 1;
            default:
                throw new Error();
        }
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.unmodifiableCiphers;
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.mode == 0;
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator alloc, String peerHost, int peerPort) {
        return newEngine0(alloc, peerHost, peerPort, true);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator alloc, boolean startTls) {
        return new SslHandler(newEngine0(alloc, null, -1, false), startTls);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator alloc, String peerHost, int peerPort, boolean startTls) {
        return new SslHandler(newEngine0(alloc, peerHost, peerPort, false), startTls);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator alloc, boolean startTls, Executor executor) {
        return new SslHandler(newEngine0(alloc, null, -1, false), startTls, executor);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator alloc, String peerHost, int peerPort, boolean startTls, Executor executor) {
        return new SslHandler(newEngine0(alloc, peerHost, peerPort, false), executor);
    }

    SSLEngine newEngine0(ByteBufAllocator alloc, String peerHost, int peerPort, boolean jdkCompatibilityMode) {
        return new ReferenceCountedOpenSslEngine(this, alloc, peerHost, peerPort, jdkCompatibilityMode, true);
    }

    @Override // p013io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator alloc) {
        return newEngine(alloc, null, -1);
    }

    @Deprecated
    public final long context() {
        return sslCtxPointer();
    }

    @Deprecated
    public final OpenSslSessionStats stats() {
        return sessionContext().stats();
    }

    @Deprecated
    public void setRejectRemoteInitiatedRenegotiation(boolean rejectRemoteInitiatedRenegotiation) {
        if (!rejectRemoteInitiatedRenegotiation) {
            throw new UnsupportedOperationException("Renegotiation is not supported");
        }
    }

    @Deprecated
    public boolean getRejectRemoteInitiatedRenegotiation() {
        return true;
    }

    public void setBioNonApplicationBufferSize(int bioNonApplicationBufferSize) {
        this.bioNonApplicationBufferSize = ObjectUtil.checkPositiveOrZero(bioNonApplicationBufferSize, "bioNonApplicationBufferSize");
    }

    public int getBioNonApplicationBufferSize() {
        return this.bioNonApplicationBufferSize;
    }

    @Deprecated
    public final void setTicketKeys(byte[] keys) {
        sessionContext().setTicketKeys(keys);
    }

    @Deprecated
    public final long sslCtxPointer() {
        Lock readerLock = this.ctxLock.readLock();
        readerLock.lock();
        try {
            long sslCtx = SSLContext.getSslCtx(this.ctx);
            readerLock.unlock();
            return sslCtx;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    @Deprecated
    public final void setPrivateKeyMethod(OpenSslPrivateKeyMethod method) {
        ObjectUtil.checkNotNull(method, EJBInvokerJob.EJB_METHOD_KEY);
        Lock writerLock = this.ctxLock.writeLock();
        writerLock.lock();
        try {
            SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, method));
        } finally {
            writerLock.unlock();
        }
    }

    @Deprecated
    public final void setUseTasks(boolean useTasks) {
        Lock writerLock = this.ctxLock.writeLock();
        writerLock.lock();
        try {
            SSLContext.setUseTasks(this.ctx, useTasks);
        } finally {
            writerLock.unlock();
        }
    }

    /* access modifiers changed from: private */
    public void destroy() {
        Lock writerLock = this.ctxLock.writeLock();
        writerLock.lock();
        try {
            if (this.ctx != 0) {
                if (this.enableOcsp) {
                    SSLContext.disableOcsp(this.ctx);
                }
                SSLContext.free(this.ctx);
                this.ctx = 0;
                OpenSslSessionContext context = sessionContext();
                if (context != null) {
                    context.destroy();
                }
            }
        } finally {
            writerLock.unlock();
        }
    }

    protected static X509Certificate[] certificates(byte[][] chain) {
        X509Certificate[] peerCerts = new X509Certificate[chain.length];
        for (int i = 0; i < peerCerts.length; i++) {
            peerCerts[i] = new LazyX509Certificate(chain[i]);
        }
        return peerCerts;
    }

    protected static X509TrustManager chooseTrustManager(TrustManager[] managers) {
        for (TrustManager m : managers) {
            if (m instanceof X509TrustManager) {
                if (PlatformDependent.javaVersion() >= 7) {
                    return OpenSslX509TrustManagerWrapper.wrapIfNeeded((X509TrustManager) m);
                } else {
                    return (X509TrustManager) m;
                }
            }
        }
        throw new IllegalStateException("no X509TrustManager found");
    }

    /* access modifiers changed from: protected */
    public static X509KeyManager chooseX509KeyManager(KeyManager[] kms) {
        for (KeyManager km : kms) {
            if (km instanceof X509KeyManager) {
                return (X509KeyManager) km;
            }
        }
        throw new IllegalStateException("no X509KeyManager found");
    }

    static OpenSslApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig config) {
        if (config == null) {
            return NONE_PROTOCOL_NEGOTIATOR;
        }
        switch (config.protocol()) {
            case NPN:
            case ALPN:
            case NPN_AND_ALPN:
                switch (config.selectedListenerFailureBehavior()) {
                    case CHOOSE_MY_LAST_PROTOCOL:
                    case ACCEPT:
                        switch (config.selectorFailureBehavior()) {
                            case NO_ADVERTISE:
                            case CHOOSE_MY_LAST_PROTOCOL:
                                return new OpenSslDefaultApplicationProtocolNegotiator(config);
                            default:
                                throw new UnsupportedOperationException("OpenSSL provider does not support " + config.selectorFailureBehavior() + " behavior");
                        }
                    default:
                        throw new UnsupportedOperationException("OpenSSL provider does not support " + config.selectedListenerFailureBehavior() + " behavior");
                }
            case NONE:
                return NONE_PROTOCOL_NEGOTIATOR;
            default:
                throw new Error();
        }
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$3 */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslContext$3.class */
    static /* synthetic */ class C30373 {

        /* renamed from: $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode */
        static final /* synthetic */ int[] f1020xca5a932f;

        static {
            try {
                f1022xcbdfafc1[ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1022xcbdfafc1[ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f1021xb32e3251 = new int[ApplicationProtocolConfig.SelectorFailureBehavior.values().length];
            try {
                f1021xb32e3251[ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1021xb32e3251[ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            f1020xca5a932f = new int[OpenSslCertificateCompressionConfig.AlgorithmMode.values().length];
            try {
                f1020xca5a932f[OpenSslCertificateCompressionConfig.AlgorithmMode.Decompress.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1020xca5a932f[OpenSslCertificateCompressionConfig.AlgorithmMode.Compress.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1020xca5a932f[OpenSslCertificateCompressionConfig.AlgorithmMode.Both.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            f1019xc16482e4 = new int[ApplicationProtocolConfig.Protocol.values().length];
            try {
                f1019xc16482e4[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f1019xc16482e4[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f1019xc16482e4[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f1019xc16482e4[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    static boolean useExtendedTrustManager(X509TrustManager trustManager) {
        return PlatformDependent.javaVersion() >= 7 && (trustManager instanceof X509ExtendedTrustManager);
    }

    @Override // p013io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    @Override // p013io.netty.util.ReferenceCounted
    public final ReferenceCounted retain() {
        this.refCnt.retain();
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public final ReferenceCounted retain(int increment) {
        this.refCnt.retain(increment);
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object hint) {
        this.refCnt.touch(hint);
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.refCnt.release();
    }

    @Override // p013io.netty.util.ReferenceCounted
    public final boolean release(int decrement) {
        return this.refCnt.release(decrement);
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$AbstractCertificateVerifier */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslContext$AbstractCertificateVerifier.class */
    static abstract class AbstractCertificateVerifier extends CertificateVerifier {
        private final OpenSslEngineMap engineMap;

        abstract void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception;

        /* access modifiers changed from: package-private */
        public AbstractCertificateVerifier(OpenSslEngineMap engineMap) {
            this.engineMap = engineMap;
        }

        public final int verify(long ssl, byte[][] chain, String auth) {
            ReferenceCountedOpenSslEngine engine = this.engineMap.get(ssl);
            if (engine == null) {
                return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
            try {
                verify(engine, ReferenceCountedOpenSslContext.certificates(chain), auth);
                return CertificateVerifier.X509_V_OK;
            } catch (Throwable cause) {
                ReferenceCountedOpenSslContext.logger.debug("verification of certificate failed", cause);
                engine.initHandshakeException(cause);
                if (cause instanceof OpenSslCertificateException) {
                    return ((OpenSslCertificateException) cause).errorCode();
                }
                if (cause instanceof CertificateExpiredException) {
                    return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                }
                if (cause instanceof CertificateNotYetValidException) {
                    return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                }
                if (PlatformDependent.javaVersion() >= 7) {
                    return translateToError(cause);
                }
                return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static int translateToError(Throwable cause) {
            if (cause instanceof CertificateRevokedException) {
                return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
            }
            for (Throwable wrapped = cause.getCause(); wrapped != null; wrapped = wrapped.getCause()) {
                if (wrapped instanceof CertPathValidatorException) {
                    CertPathValidatorException.Reason reason = ((CertPathValidatorException) wrapped).getReason();
                    if (reason == CertPathValidatorException.BasicReason.EXPIRED) {
                        return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                    }
                    if (reason == CertPathValidatorException.BasicReason.NOT_YET_VALID) {
                        return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                    }
                    if (reason == CertPathValidatorException.BasicReason.REVOKED) {
                        return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
                    }
                }
            }
            return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
        }
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$DefaultOpenSslEngineMap */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslContext$DefaultOpenSslEngineMap.class */
    private static final class DefaultOpenSslEngineMap implements OpenSslEngineMap {
        private final Map<Long, ReferenceCountedOpenSslEngine> engines;

        private DefaultOpenSslEngineMap() {
            this.engines = PlatformDependent.newConcurrentHashMap();
        }

        @Override // p013io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine remove(long ssl) {
            return this.engines.remove(Long.valueOf(ssl));
        }

        @Override // p013io.netty.handler.ssl.OpenSslEngineMap
        public void add(ReferenceCountedOpenSslEngine engine) {
            this.engines.put(Long.valueOf(engine.sslPointer()), engine);
        }

        @Override // p013io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine get(long ssl) {
            return this.engines.get(Long.valueOf(ssl));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x000c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [long] */
    /* JADX WARN: Type inference failed for: r17v2, types: [long] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void setKeyMaterial(long r8, java.security.cert.X509Certificate[] r10, java.security.PrivateKey r11, java.lang.String r12) throws javax.net.ssl.SSLException {
        /*
            r0 = 0
            r13 = r0
            r0 = 0
            r15 = r0
            r0 = 0
            r17 = r0
            r0 = 0
            r19 = r0
            io.netty.buffer.ByteBufAllocator r0 = p013io.netty.buffer.ByteBufAllocator.DEFAULT     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r1 = 1
            r2 = r10
            io.netty.handler.ssl.PemEncoded r0 = p013io.netty.handler.ssl.PemX509Certificate.toPEM(r0, r1, r2)     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r19 = r0
            io.netty.buffer.ByteBufAllocator r0 = p013io.netty.buffer.ByteBufAllocator.DEFAULT     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r1 = r19
            io.netty.handler.ssl.PemEncoded r1 = r1.retain()     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            long r0 = toBIO(r0, r1)     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r15 = r0
            io.netty.buffer.ByteBufAllocator r0 = p013io.netty.buffer.ByteBufAllocator.DEFAULT     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r1 = r19
            io.netty.handler.ssl.PemEncoded r1 = r1.retain()     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            long r0 = toBIO(r0, r1)     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r17 = r0
            r0 = r11
            if (r0 == 0) goto L_0x0041
            io.netty.buffer.ByteBufAllocator r0 = p013io.netty.buffer.ByteBufAllocator.DEFAULT     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r1 = r11
            long r0 = toBIO(r0, r1)     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r13 = r0
        L_0x0041:
            r0 = r8
            r1 = r15
            r2 = r13
            r3 = r12
            if (r3 != 0) goto L_0x0050
            java.lang.String r3 = ""
            goto L_0x0052
        L_0x0050:
            r3 = r12
        L_0x0052:
            boolean r0 = io.netty.internal.tcnative.SSLContext.setCertificateBio(r0, r1, r2, r3)     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r0 = r8
            r1 = r17
            r2 = 1
            boolean r0 = io.netty.internal.tcnative.SSLContext.setCertificateChainBio(r0, r1, r2)     // Catch: SSLException -> 0x007d, Exception -> 0x0082, all -> 0x0090
            r0 = r13
            freeBio(r0)
            r0 = r15
            freeBio(r0)
            r0 = r17
            freeBio(r0)
            r0 = r19
            if (r0 == 0) goto L_0x00b1
            r0 = r19
            boolean r0 = r0.release()
            goto L_0x00b1
        L_0x007d:
            r20 = move-exception
            r0 = r20
            throw r0     // Catch: all -> 0x0090
        L_0x0082:
            r20 = move-exception
            javax.net.ssl.SSLException r0 = new javax.net.ssl.SSLException     // Catch: all -> 0x0090
            r1 = r0
            java.lang.String r2 = "failed to set certificate and key"
            r3 = r20
            r1.<init>(r2, r3)     // Catch: all -> 0x0090
            throw r0     // Catch: all -> 0x0090
        L_0x0090:
            r21 = move-exception
            r0 = r13
            freeBio(r0)
            r0 = r15
            freeBio(r0)
            r0 = r17
            freeBio(r0)
            r0 = r19
            if (r0 == 0) goto L_0x00ae
            r0 = r19
            boolean r0 = r0.release()
        L_0x00ae:
            r0 = r21
            throw r0
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.setKeyMaterial(long, java.security.cert.X509Certificate[], java.security.PrivateKey, java.lang.String):void");
    }

    static void freeBio(long bio) {
        if (bio != 0) {
            SSL.freeBIO(bio);
        }
    }

    /* access modifiers changed from: package-private */
    public static long toBIO(ByteBufAllocator allocator, PrivateKey key) throws Exception {
        if (key == null) {
            return 0;
        }
        PemEncoded pem = PemPrivateKey.toPEM(allocator, true, key);
        try {
            long bio = toBIO(allocator, pem.retain());
            pem.release();
            return bio;
        } catch (Throwable th) {
            pem.release();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static long toBIO(ByteBufAllocator allocator, X509Certificate... certChain) throws Exception {
        if (certChain == null) {
            return 0;
        }
        ObjectUtil.checkNonEmpty(certChain, "certChain");
        PemEncoded pem = PemX509Certificate.toPEM(allocator, true, certChain);
        try {
            long bio = toBIO(allocator, pem.retain());
            pem.release();
            return bio;
        } catch (Throwable th) {
            pem.release();
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x006a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static long toBIO(p013io.netty.buffer.ByteBufAllocator r5, p013io.netty.handler.ssl.PemEncoded r6) throws java.lang.Exception {
        /*
            r0 = r6
            io.netty.buffer.ByteBuf r0 = r0.content()     // Catch: all -> 0x008e
            r7 = r0
            r0 = r7
            boolean r0 = r0.isDirect()     // Catch: all -> 0x008e
            if (r0 == 0) goto L_0x001f
            r0 = r7
            io.netty.buffer.ByteBuf r0 = r0.retainedSlice()     // Catch: all -> 0x008e
            long r0 = newBIO(r0)     // Catch: all -> 0x008e
            r8 = r0
            r0 = r6
            boolean r0 = r0.release()
            r0 = r8
            return r0
        L_0x001f:
            r0 = r5
            r1 = r7
            int r1 = r1.readableBytes()     // Catch: all -> 0x008e
            io.netty.buffer.ByteBuf r0 = r0.directBuffer(r1)     // Catch: all -> 0x008e
            r8 = r0
            r0 = r8
            r1 = r7
            r2 = r7
            int r2 = r2.readerIndex()     // Catch: all -> 0x006a, all -> 0x008e
            r3 = r7
            int r3 = r3.readableBytes()     // Catch: all -> 0x006a, all -> 0x008e
            io.netty.buffer.ByteBuf r0 = r0.writeBytes(r1, r2, r3)     // Catch: all -> 0x006a, all -> 0x008e
            r0 = r8
            io.netty.buffer.ByteBuf r0 = r0.retainedSlice()     // Catch: all -> 0x006a, all -> 0x008e
            long r0 = newBIO(r0)     // Catch: all -> 0x006a, all -> 0x008e
            r9 = r0
            r0 = r6
            boolean r0 = r0.isSensitive()     // Catch: all -> 0x0056, all -> 0x008e
            if (r0 == 0) goto L_0x004e
            r0 = r8
            p013io.netty.handler.ssl.SslUtils.zeroout(r0)     // Catch: all -> 0x0056, all -> 0x008e
        L_0x004e:
            r0 = r8
            boolean r0 = r0.release()     // Catch: all -> 0x008e
            goto L_0x0060
        L_0x0056:
            r11 = move-exception
            r0 = r8
            boolean r0 = r0.release()     // Catch: all -> 0x008e
            r0 = r11
            throw r0     // Catch: all -> 0x008e
        L_0x0060:
            r0 = r6
            boolean r0 = r0.release()
            r0 = r9
            return r0
        L_0x006a:
            r12 = move-exception
            r0 = r6
            boolean r0 = r0.isSensitive()     // Catch: all -> 0x0081, all -> 0x008e
            if (r0 == 0) goto L_0x0079
            r0 = r8
            p013io.netty.handler.ssl.SslUtils.zeroout(r0)     // Catch: all -> 0x0081, all -> 0x008e
        L_0x0079:
            r0 = r8
            boolean r0 = r0.release()     // Catch: all -> 0x008e
            goto L_0x008b
        L_0x0081:
            r13 = move-exception
            r0 = r8
            boolean r0 = r0.release()     // Catch: all -> 0x008e
            r0 = r13
            throw r0     // Catch: all -> 0x008e
        L_0x008b:
            r0 = r12
            throw r0     // Catch: all -> 0x008e
        L_0x008e:
            r14 = move-exception
            r0 = r6
            boolean r0 = r0.release()
            r0 = r14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(io.netty.buffer.ByteBufAllocator, io.netty.handler.ssl.PemEncoded):long");
    }

    private static long newBIO(ByteBuf buffer) throws Exception {
        try {
            long bio = SSL.newMemBIO();
            int readable = buffer.readableBytes();
            if (SSL.bioWrite(bio, OpenSsl.memoryAddress(buffer) + ((long) buffer.readerIndex()), readable) == readable) {
                return bio;
            }
            SSL.freeBIO(bio);
            throw new IllegalStateException("Could not write data to memory BIO");
        } finally {
            buffer.release();
        }
    }

    static OpenSslKeyMaterialProvider providerFor(KeyManagerFactory factory, String password) {
        if (factory instanceof OpenSslX509KeyManagerFactory) {
            return ((OpenSslX509KeyManagerFactory) factory).newProvider();
        }
        if (factory instanceof OpenSslCachingX509KeyManagerFactory) {
            return ((OpenSslCachingX509KeyManagerFactory) factory).newProvider(password);
        }
        return new OpenSslKeyMaterialProvider(chooseX509KeyManager(factory.getKeyManagers()), password);
    }

    /* access modifiers changed from: private */
    public static ReferenceCountedOpenSslEngine retrieveEngine(OpenSslEngineMap engineMap, long ssl) throws SSLException {
        ReferenceCountedOpenSslEngine engine = engineMap.get(ssl);
        if (engine != null) {
            return engine;
        }
        throw new SSLException("Could not find a " + StringUtil.simpleClassName((Class<?>) ReferenceCountedOpenSslEngine.class) + " for sslPointer " + ssl);
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$PrivateKeyMethod */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslContext$PrivateKeyMethod.class */
    private static final class PrivateKeyMethod implements SSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslPrivateKeyMethod keyMethod;

        PrivateKeyMethod(OpenSslEngineMap engineMap, OpenSslPrivateKeyMethod keyMethod) {
            this.engineMap = engineMap;
            this.keyMethod = keyMethod;
        }

        public byte[] sign(long ssl, int signatureAlgorithm, byte[] digest) throws Exception {
            ReferenceCountedOpenSslEngine engine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, ssl);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.sign(engine, signatureAlgorithm, digest));
            } catch (Exception e) {
                engine.initHandshakeException(e);
                throw e;
            }
        }

        public byte[] decrypt(long ssl, byte[] input) throws Exception {
            ReferenceCountedOpenSslEngine engine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, ssl);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.decrypt(engine, input));
            } catch (Exception e) {
                engine.initHandshakeException(e);
                throw e;
            }
        }
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$AsyncPrivateKeyMethod */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslContext$AsyncPrivateKeyMethod.class */
    private static final class AsyncPrivateKeyMethod implements AsyncSSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslAsyncPrivateKeyMethod keyMethod;

        AsyncPrivateKeyMethod(OpenSslEngineMap engineMap, OpenSslAsyncPrivateKeyMethod keyMethod) {
            this.engineMap = engineMap;
            this.keyMethod = keyMethod;
        }

        public void sign(long ssl, int signatureAlgorithm, byte[] bytes, ResultCallback<byte[]> resultCallback) {
            try {
                ReferenceCountedOpenSslEngine engine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, ssl);
                this.keyMethod.sign(engine, signatureAlgorithm, bytes).addListener(new ResultCallbackListener(engine, ssl, resultCallback));
            } catch (SSLException e) {
                resultCallback.onError(ssl, e);
            }
        }

        public void decrypt(long ssl, byte[] bytes, ResultCallback<byte[]> resultCallback) {
            try {
                ReferenceCountedOpenSslEngine engine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, ssl);
                this.keyMethod.decrypt(engine, bytes).addListener(new ResultCallbackListener(engine, ssl, resultCallback));
            } catch (SSLException e) {
                resultCallback.onError(ssl, e);
            }
        }

        /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$AsyncPrivateKeyMethod$ResultCallbackListener */
        /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslContext$AsyncPrivateKeyMethod$ResultCallbackListener.class */
        private static final class ResultCallbackListener implements FutureListener<byte[]> {
            private final ReferenceCountedOpenSslEngine engine;
            private final long ssl;
            private final ResultCallback<byte[]> resultCallback;

            ResultCallbackListener(ReferenceCountedOpenSslEngine engine, long ssl, ResultCallback<byte[]> resultCallback) {
                this.engine = engine;
                this.ssl = ssl;
                this.resultCallback = resultCallback;
            }

            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<byte[]> future) {
                Throwable cause = future.cause();
                if (cause == null) {
                    try {
                        this.resultCallback.onSuccess(this.ssl, ReferenceCountedOpenSslContext.verifyResult(future.getNow()));
                        return;
                    } catch (SignatureException e) {
                        cause = e;
                        this.engine.initHandshakeException(e);
                    }
                }
                this.resultCallback.onError(this.ssl, cause);
            }
        }
    }

    /* access modifiers changed from: private */
    public static byte[] verifyResult(byte[] result) throws SignatureException {
        if (result != null) {
            return result;
        }
        throw new SignatureException();
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$CompressionAlgorithm */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslContext$CompressionAlgorithm.class */
    private static final class CompressionAlgorithm implements CertificateCompressionAlgo {
        private final OpenSslEngineMap engineMap;
        private final OpenSslCertificateCompressionAlgorithm compressionAlgorithm;

        CompressionAlgorithm(OpenSslEngineMap engineMap, OpenSslCertificateCompressionAlgorithm compressionAlgorithm) {
            this.engineMap = engineMap;
            this.compressionAlgorithm = compressionAlgorithm;
        }

        public byte[] compress(long ssl, byte[] bytes) throws Exception {
            return this.compressionAlgorithm.compress(ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, ssl), bytes);
        }

        public byte[] decompress(long ssl, int len, byte[] bytes) throws Exception {
            return this.compressionAlgorithm.decompress(ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, ssl), len, bytes);
        }

        public int algorithmId() {
            return this.compressionAlgorithm.algorithmId();
        }
    }
}
