package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.AsyncTask;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.SSL;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.security.cert.X509Certificate;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.handler.ssl.ApplicationProtocolConfig;
import p013io.netty.handler.ssl.util.LazyJavaxX509Certificate;
import p013io.netty.handler.ssl.util.LazyX509Certificate;
import p013io.netty.util.AbstractReferenceCounted;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.ReferenceCounted;
import p013io.netty.util.ResourceLeakDetector;
import p013io.netty.util.ResourceLeakDetectorFactory;
import p013io.netty.util.ResourceLeakTracker;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.ThrowableUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslEngine.class */
public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted, ApplicationProtocolAccessor {
    private static final InternalLogger logger;
    private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_3 = 5;
    private static final int[] OPENSSL_OP_NO_PROTOCOLS;
    static final int MAX_PLAINTEXT_LENGTH;
    static final int MAX_RECORD_SIZE;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    private long ssl;
    private long networkBIO;
    private boolean receivedShutdown;
    private volatile boolean destroyed;
    private volatile String applicationProtocol;
    private volatile boolean needTask;
    private String[] explicitlyEnabledProtocols;
    private boolean sessionSet;
    private final ResourceLeakTracker<ReferenceCountedOpenSslEngine> leak;
    private String endPointIdentificationAlgorithm;
    private Object algorithmConstraints;
    private List<String> sniHostNames;
    private volatile Collection<?> matchers;
    private boolean isInboundDone;
    private boolean outboundClosed;
    final boolean jdkCompatibilityMode;
    private final boolean clientMode;
    final ByteBufAllocator alloc;
    private final OpenSslEngineMap engineMap;
    private final OpenSslApplicationProtocolNegotiator apn;
    private final ReferenceCountedOpenSslContext parentContext;
    private final OpenSslSession session;
    private final boolean enableOcsp;
    private int maxWrapOverhead;
    private int maxWrapBufferSize;
    private Throwable pendingException;
    static final /* synthetic */ boolean $assertionsDisabled;
    private HandshakeState handshakeState = HandshakeState.NOT_STARTED;
    private final AbstractReferenceCounted refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.1
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ReferenceCountedOpenSslEngine.class.desiredAssertionStatus();
        }

        @Override // p013io.netty.util.ReferenceCounted
        public ReferenceCounted touch(Object hint) {
            if (ReferenceCountedOpenSslEngine.this.leak != null) {
                ReferenceCountedOpenSslEngine.this.leak.record(hint);
            }
            return ReferenceCountedOpenSslEngine.this;
        }

        @Override // p013io.netty.util.AbstractReferenceCounted
        protected void deallocate() {
            ReferenceCountedOpenSslEngine.this.shutdown();
            if (ReferenceCountedOpenSslEngine.this.leak != null) {
                boolean closed = ReferenceCountedOpenSslEngine.this.leak.close(ReferenceCountedOpenSslEngine.this);
                if (!$assertionsDisabled && !closed) {
                    throw new AssertionError();
                }
            }
            ReferenceCountedOpenSslEngine.this.parentContext.release();
        }
    };
    private volatile ClientAuth clientAuth = ClientAuth.NONE;
    private volatile long lastAccessed = -1;
    private final ByteBuffer[] singleSrcBuffer = new ByteBuffer[1];
    private final ByteBuffer[] singleDstBuffer = new ByteBuffer[1];

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslEngine$HandshakeState.class */
    public enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED
    }

    static {
        $assertionsDisabled = !ReferenceCountedOpenSslEngine.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslEngine.class);
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);
        OPENSSL_OP_NO_PROTOCOLS = new int[]{SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2, SSL.SSL_OP_NO_TLSv1_3};
        MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
        MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;
        NEED_UNWRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
        NEED_UNWRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
        NEED_WRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
        NEED_WRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
        CLOSED_NOT_HANDSHAKING = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
    }

    /* access modifiers changed from: package-private */
    public ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext context, ByteBufAllocator alloc, String peerHost, int peerPort, boolean jdkCompatibilityMode, boolean leakDetection) {
        super(peerHost, peerPort);
        OpenSsl.ensureAvailability();
        this.engineMap = context.engineMap;
        this.enableOcsp = context.enableOcsp;
        this.jdkCompatibilityMode = jdkCompatibilityMode;
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(alloc, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator) context.applicationProtocolNegotiator();
        this.clientMode = context.isClient();
        if (PlatformDependent.javaVersion() >= 7) {
            this.session = new ExtendedOpenSslSession(new DefaultOpenSslSession(context.sessionContext())) { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.2
                private String[] peerSupportedSignatureAlgorithms;
                private List requestedServerNames;

                @Override // p013io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                public List getRequestedServerNames() {
                    List list;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        return Java8SslUtils.getSniHostNames(ReferenceCountedOpenSslEngine.this.sniHostNames);
                    }
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        if (this.requestedServerNames == null) {
                            if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                this.requestedServerNames = Collections.emptyList();
                            } else if (SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl) == null) {
                                this.requestedServerNames = Collections.emptyList();
                            } else {
                                this.requestedServerNames = Java8SslUtils.getSniHostName(SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl).getBytes(CharsetUtil.UTF_8));
                            }
                        }
                        list = this.requestedServerNames;
                    }
                    return list;
                }

                @Override // p013io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                public String[] getPeerSupportedSignatureAlgorithms() {
                    String[] strArr;
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        if (this.peerSupportedSignatureAlgorithms == null) {
                            if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                            } else {
                                String[] algs = SSL.getSigAlgs(ReferenceCountedOpenSslEngine.this.ssl);
                                if (algs == null) {
                                    this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                                } else {
                                    Set<String> algorithmList = new LinkedHashSet<>(algs.length);
                                    for (String alg : algs) {
                                        String converted = SignatureAlgorithmConverter.toJavaName(alg);
                                        if (converted != null) {
                                            algorithmList.add(converted);
                                        }
                                    }
                                    this.peerSupportedSignatureAlgorithms = (String[]) algorithmList.toArray(new String[0]);
                                }
                            }
                        }
                        strArr = (String[]) this.peerSupportedSignatureAlgorithms.clone();
                    }
                    return strArr;
                }

                @Override // p013io.netty.handler.ssl.ExtendedOpenSslSession
                public List<byte[]> getStatusResponses() {
                    byte[] ocspResponse = null;
                    if (ReferenceCountedOpenSslEngine.this.enableOcsp && ReferenceCountedOpenSslEngine.this.clientMode) {
                        synchronized (ReferenceCountedOpenSslEngine.this) {
                            if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                ocspResponse = SSL.getOcspResponse(ReferenceCountedOpenSslEngine.this.ssl);
                            }
                        }
                    }
                    return ocspResponse == null ? Collections.emptyList() : Collections.singletonList(ocspResponse);
                }
            };
        } else {
            this.session = new DefaultOpenSslSession(context.sessionContext());
        }
        if (!context.sessionContext().useKeyManager()) {
            this.session.setLocalCertificate(context.keyCertChain);
        }
        Lock readerLock = context.ctxLock.readLock();
        readerLock.lock();
        try {
            long finalSsl = SSL.newSSL(context.ctx, !context.isClient());
            readerLock.unlock();
            synchronized (this) {
                this.ssl = finalSsl;
                this.networkBIO = SSL.bioNewByteBuffer(this.ssl, context.getBioNonApplicationBufferSize());
                setClientAuth(this.clientMode ? ClientAuth.NONE : context.clientAuth);
                if (context.protocols != null) {
                    setEnabledProtocols0(context.protocols, true);
                } else {
                    this.explicitlyEnabledProtocols = getEnabledProtocols();
                }
                if (this.clientMode && SslUtils.isValidHostNameForSNI(peerHost)) {
                    if (PlatformDependent.javaVersion() < 8) {
                        SSL.setTlsExtHostName(this.ssl, peerHost);
                        this.sniHostNames = Collections.singletonList(peerHost);
                    } else if (Java8SslUtils.isValidHostNameForSNI(peerHost)) {
                        SSL.setTlsExtHostName(this.ssl, peerHost);
                        this.sniHostNames = Collections.singletonList(peerHost);
                    }
                }
                if (this.enableOcsp) {
                    SSL.enableOcsp(this.ssl);
                }
                if (!jdkCompatibilityMode) {
                    SSL.setMode(this.ssl, SSL.getMode(this.ssl) | SSL.SSL_MODE_ENABLE_PARTIAL_WRITE);
                }
                if (isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                    if (this.clientMode ? ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET_TLSV13 : ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET_TLSV13) {
                        SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_TICKET);
                    }
                }
                if (OpenSsl.isBoringSSL() && this.clientMode) {
                    SSL.setRenegotiateMode(this.ssl, SSL.SSL_RENEGOTIATE_ONCE);
                }
                calculateMaxWrapOverhead();
            }
            this.parentContext = context;
            this.parentContext.retain();
            this.leak = leakDetection ? leakDetector.track(this) : null;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized String[] authMethods() {
        if (isDestroyed()) {
            return EmptyArrays.EMPTY_STRINGS;
        }
        return SSL.authenticationMethods(this.ssl);
    }

    /* access modifiers changed from: package-private */
    public final boolean setKeyMaterial(OpenSslKeyMaterial keyMaterial) throws Exception {
        synchronized (this) {
            if (isDestroyed()) {
                return false;
            }
            SSL.setKeyMaterial(this.ssl, keyMaterial.certificateChainAddress(), keyMaterial.privateKeyAddress());
            this.session.setLocalCertificate(keyMaterial.certificateChain());
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized SecretKeySpec masterKey() {
        if (isDestroyed()) {
            return null;
        }
        return new SecretKeySpec(SSL.getMasterKey(this.ssl), "AES");
    }

    synchronized boolean isSessionReused() {
        if (isDestroyed()) {
            return false;
        }
        return SSL.isSessionReused(this.ssl);
    }

    public void setOcspResponse(byte[] response) {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        } else if (this.clientMode) {
            throw new IllegalStateException("Not a server SSLEngine");
        } else {
            synchronized (this) {
                if (!isDestroyed()) {
                    SSL.setOcspResponse(this.ssl, response);
                }
            }
        }
    }

    public byte[] getOcspResponse() {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        } else if (!this.clientMode) {
            throw new IllegalStateException("Not a client SSLEngine");
        } else {
            synchronized (this) {
                if (isDestroyed()) {
                    return EmptyArrays.EMPTY_BYTES;
                }
                return SSL.getOcspResponse(this.ssl);
            }
        }
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

    @Override // javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLSession getHandshakeSession() {
        switch (this.handshakeState) {
            case NOT_STARTED:
            case FINISHED:
                return null;
            default:
                return this.session;
        }
    }

    public final synchronized long sslPointer() {
        return this.ssl;
    }

    public final synchronized void shutdown() {
        if (!this.destroyed) {
            this.destroyed = true;
            if (this.engineMap != null) {
                this.engineMap.remove(this.ssl);
            }
            SSL.freeSSL(this.ssl);
            this.networkBIO = 0;
            this.ssl = 0;
            this.outboundClosed = true;
            this.isInboundDone = true;
        }
        SSL.clearError();
    }

    private int writePlaintextData(ByteBuffer src, int len) {
        int sslWrote;
        int pos = src.position();
        int limit = src.limit();
        if (src.isDirect()) {
            sslWrote = SSL.writeToSSL(this.ssl, bufferAddress(src) + ((long) pos), len);
            if (sslWrote > 0) {
                src.position(pos + sslWrote);
            }
        } else {
            ByteBuf buf = this.alloc.directBuffer(len);
            try {
                src.limit(pos + len);
                buf.setBytes(0, src);
                src.limit(limit);
                sslWrote = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(buf), len);
                if (sslWrote > 0) {
                    src.position(pos + sslWrote);
                } else {
                    src.position(pos);
                }
            } finally {
                buf.release();
            }
        }
        return sslWrote;
    }

    /* access modifiers changed from: package-private */
    public synchronized void bioSetFd(int fd) {
        if (!isDestroyed()) {
            SSL.bioSetFd(this.ssl, fd);
        }
    }

    private ByteBuf writeEncryptedData(ByteBuffer src, int len) throws SSLException {
        int pos = src.position();
        if (src.isDirect()) {
            SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(src) + ((long) pos), len, false);
            return null;
        }
        ByteBuf buf = this.alloc.directBuffer(len);
        try {
            int limit = src.limit();
            src.limit(pos + len);
            buf.writeBytes(src);
            src.position(pos);
            src.limit(limit);
            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(buf), len, false);
            return buf;
        } catch (Throwable cause) {
            buf.release();
            PlatformDependent.throwException(cause);
            return null;
        }
    }

    private int readPlaintextData(ByteBuffer dst) throws SSLException {
        int sslRead;
        int pos = dst.position();
        if (dst.isDirect()) {
            sslRead = SSL.readFromSSL(this.ssl, bufferAddress(dst) + ((long) pos), dst.limit() - pos);
            if (sslRead > 0) {
                dst.position(pos + sslRead);
            }
        } else {
            int limit = dst.limit();
            int len = Math.min(maxEncryptedPacketLength0(), limit - pos);
            ByteBuf buf = this.alloc.directBuffer(len);
            try {
                sslRead = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(buf), len);
                if (sslRead > 0) {
                    dst.limit(pos + sslRead);
                    buf.getBytes(buf.readerIndex(), dst);
                    dst.limit(limit);
                }
            } finally {
                buf.release();
            }
        }
        return sslRead;
    }

    final synchronized int maxWrapOverhead() {
        return this.maxWrapOverhead;
    }

    final synchronized int maxEncryptedPacketLength() {
        return maxEncryptedPacketLength0();
    }

    final int maxEncryptedPacketLength0() {
        return this.maxWrapOverhead + MAX_PLAINTEXT_LENGTH;
    }

    /* access modifiers changed from: package-private */
    public final int calculateMaxLengthForWrap(int plaintextLength, int numComponents) {
        return (int) Math.min((long) this.maxWrapBufferSize, ((long) plaintextLength) + (((long) this.maxWrapOverhead) * ((long) numComponents)));
    }

    /* access modifiers changed from: package-private */
    public final synchronized int sslPending() {
        return sslPending0();
    }

    /* access modifiers changed from: private */
    public void calculateMaxWrapOverhead() {
        this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
        this.maxWrapBufferSize = this.jdkCompatibilityMode ? maxEncryptedPacketLength0() : maxEncryptedPacketLength0() << 4;
    }

    private int sslPending0() {
        if (this.handshakeState != HandshakeState.FINISHED) {
            return 0;
        }
        return SSL.sslPending(this.ssl);
    }

    private boolean isBytesAvailableEnoughForWrap(int bytesAvailable, int plaintextLength, int numComponents) {
        return ((long) bytesAvailable) - (((long) this.maxWrapOverhead) * ((long) numComponents)) >= ((long) plaintextLength);
    }

    @Override // javax.net.ssl.SSLEngine
    public final SSLEngineResult wrap(ByteBuffer[] srcs, int offset, int length, ByteBuffer dst) throws SSLException {
        int bytesWritten;
        SSLEngineResult.HandshakeStatus handshakeStatus;
        SSLEngineResult.HandshakeStatus handshakeStatus2;
        ObjectUtil.checkNotNullWithIAE(srcs, "srcs");
        ObjectUtil.checkNotNullWithIAE(dst, "dst");
        if (offset >= srcs.length || offset + length > srcs.length) {
            throw new IndexOutOfBoundsException("offset: " + offset + ", length: " + length + " (expected: offset <= offset + length <= srcs.length (" + srcs.length + "))");
        } else if (dst.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else {
            synchronized (this) {
                if (isOutboundDone()) {
                    return (isInboundDone() || isDestroyed()) ? CLOSED_NOT_HANDSHAKING : NEED_UNWRAP_CLOSED;
                }
                int bytesProduced = 0;
                ByteBuf bioReadCopyBuf = null;
                if (dst.isDirect()) {
                    SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(dst) + ((long) dst.position()), dst.remaining(), true);
                } else {
                    bioReadCopyBuf = this.alloc.directBuffer(dst.remaining());
                    SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(bioReadCopyBuf), bioReadCopyBuf.writableBytes(), true);
                }
                int bioLengthBefore = SSL.bioLengthByteBuffer(this.networkBIO);
                if (!this.outboundClosed) {
                    SSLEngineResult.HandshakeStatus status = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                    if (this.handshakeState != HandshakeState.FINISHED) {
                        if (this.handshakeState != HandshakeState.STARTED_EXPLICITLY) {
                            this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                        }
                        int bytesProduced2 = SSL.bioFlushByteBuffer(this.networkBIO);
                        if (this.pendingException == null) {
                            status = handshake();
                            bytesProduced = bioLengthBefore - SSL.bioLengthByteBuffer(this.networkBIO);
                            if (status == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                                SSLEngineResult newResult = newResult(status, 0, bytesProduced);
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (bioReadCopyBuf == null) {
                                    dst.position(dst.position() + bytesProduced);
                                } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                    dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced));
                                    bioReadCopyBuf.release();
                                } else {
                                    throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                }
                                return newResult;
                            } else if (bytesProduced > 0) {
                                if (status != SSLEngineResult.HandshakeStatus.FINISHED) {
                                    handshakeStatus2 = bytesProduced == bioLengthBefore ? SSLEngineResult.HandshakeStatus.NEED_WRAP : getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                                } else {
                                    handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
                                }
                                SSLEngineResult newResult2 = newResult(mayFinishHandshake(handshakeStatus2), 0, bytesProduced);
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (bioReadCopyBuf == null) {
                                    dst.position(dst.position() + bytesProduced);
                                } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                    dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced));
                                    bioReadCopyBuf.release();
                                } else {
                                    throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                }
                                return newResult2;
                            } else if (status == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                                SSLEngineResult sSLEngineResult = isOutboundDone() ? NEED_UNWRAP_CLOSED : NEED_UNWRAP_OK;
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (bioReadCopyBuf == null) {
                                    dst.position(dst.position() + bytesProduced);
                                } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                    dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced));
                                    bioReadCopyBuf.release();
                                } else {
                                    throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                }
                                return sSLEngineResult;
                            } else if (this.outboundClosed) {
                                int bytesProduced3 = SSL.bioFlushByteBuffer(this.networkBIO);
                                SSLEngineResult newResultMayFinishHandshake = newResultMayFinishHandshake(status, 0, bytesProduced3);
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (bioReadCopyBuf == null) {
                                    dst.position(dst.position() + bytesProduced3);
                                } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                    dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced3));
                                    bioReadCopyBuf.release();
                                } else {
                                    throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                }
                                return newResultMayFinishHandshake;
                            }
                        } else if (bytesProduced2 > 0) {
                            SSLEngineResult newResult3 = newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, bytesProduced2);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (bioReadCopyBuf == null) {
                                dst.position(dst.position() + bytesProduced2);
                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced2));
                                bioReadCopyBuf.release();
                            } else {
                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                            }
                            return newResult3;
                        } else {
                            SSLEngineResult newResult4 = newResult(handshakeException(), 0, 0);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (bioReadCopyBuf == null) {
                                dst.position(dst.position() + bytesProduced2);
                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced2));
                                bioReadCopyBuf.release();
                            } else {
                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                            }
                            return newResult4;
                        }
                    }
                    int endOffset = offset + length;
                    if (this.jdkCompatibilityMode) {
                        int srcsLen = 0;
                        for (int i = offset; i < endOffset; i++) {
                            ByteBuffer src = srcs[i];
                            if (src == null) {
                                throw new IllegalArgumentException("srcs[" + i + "] is null");
                            }
                            if (srcsLen != MAX_PLAINTEXT_LENGTH) {
                                srcsLen += src.remaining();
                                if (srcsLen > MAX_PLAINTEXT_LENGTH || srcsLen < 0) {
                                    srcsLen = MAX_PLAINTEXT_LENGTH;
                                }
                            }
                        }
                        if (!isBytesAvailableEnoughForWrap(dst.remaining(), srcsLen, 1)) {
                            SSLEngineResult sSLEngineResult2 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (bioReadCopyBuf == null) {
                                dst.position(dst.position() + bytesProduced);
                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced));
                                bioReadCopyBuf.release();
                            } else {
                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                            }
                            return sSLEngineResult2;
                        }
                    }
                    int bytesConsumed = 0;
                    if ($assertionsDisabled || bytesProduced == 0) {
                        int bytesProduced4 = SSL.bioFlushByteBuffer(this.networkBIO);
                        if (bytesProduced4 > 0) {
                            SSLEngineResult newResultMayFinishHandshake2 = newResultMayFinishHandshake(status, 0, bytesProduced4);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (bioReadCopyBuf == null) {
                                dst.position(dst.position() + bytesProduced4);
                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                bioReadCopyBuf.release();
                            } else {
                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                            }
                            return newResultMayFinishHandshake2;
                        } else if (this.pendingException != null) {
                            Throwable error = this.pendingException;
                            this.pendingException = null;
                            shutdown();
                            throw new SSLException(error);
                        } else {
                            while (offset < endOffset) {
                                ByteBuffer src2 = srcs[offset];
                                int remaining = src2.remaining();
                                if (remaining != 0) {
                                    if (this.jdkCompatibilityMode) {
                                        bytesWritten = writePlaintextData(src2, Math.min(remaining, MAX_PLAINTEXT_LENGTH - bytesConsumed));
                                    } else {
                                        int availableCapacityForWrap = (dst.remaining() - bytesProduced4) - this.maxWrapOverhead;
                                        if (availableCapacityForWrap <= 0) {
                                            SSLEngineResult sSLEngineResult3 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), bytesConsumed, bytesProduced4);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (bioReadCopyBuf == null) {
                                                dst.position(dst.position() + bytesProduced4);
                                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                                bioReadCopyBuf.release();
                                            } else {
                                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                            }
                                            return sSLEngineResult3;
                                        }
                                        bytesWritten = writePlaintextData(src2, Math.min(remaining, availableCapacityForWrap));
                                    }
                                    int pendingNow = SSL.bioLengthByteBuffer(this.networkBIO);
                                    bytesProduced4 += bioLengthBefore - pendingNow;
                                    bioLengthBefore = pendingNow;
                                    if (bytesWritten > 0) {
                                        bytesConsumed += bytesWritten;
                                        if (this.jdkCompatibilityMode || bytesProduced4 == dst.remaining()) {
                                            SSLEngineResult newResultMayFinishHandshake3 = newResultMayFinishHandshake(status, bytesConsumed, bytesProduced4);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (bioReadCopyBuf == null) {
                                                dst.position(dst.position() + bytesProduced4);
                                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                                bioReadCopyBuf.release();
                                            } else {
                                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                            }
                                            return newResultMayFinishHandshake3;
                                        }
                                    } else {
                                        int sslError = SSL.getError(this.ssl, bytesWritten);
                                        if (sslError == SSL.SSL_ERROR_ZERO_RETURN) {
                                            if (!this.receivedShutdown) {
                                                closeAll();
                                                int bytesProduced5 = bytesProduced4 + (bioLengthBefore - SSL.bioLengthByteBuffer(this.networkBIO));
                                                if (status != SSLEngineResult.HandshakeStatus.FINISHED) {
                                                    handshakeStatus = bytesProduced5 == dst.remaining() ? SSLEngineResult.HandshakeStatus.NEED_WRAP : getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                                                } else {
                                                    handshakeStatus = SSLEngineResult.HandshakeStatus.FINISHED;
                                                }
                                                SSLEngineResult newResult5 = newResult(mayFinishHandshake(handshakeStatus), bytesConsumed, bytesProduced5);
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                if (bioReadCopyBuf == null) {
                                                    dst.position(dst.position() + bytesProduced5);
                                                } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                                    dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced5));
                                                    bioReadCopyBuf.release();
                                                } else {
                                                    throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                                }
                                                return newResult5;
                                            }
                                            SSLEngineResult newResult6 = newResult(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, bytesConsumed, bytesProduced4);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (bioReadCopyBuf == null) {
                                                dst.position(dst.position() + bytesProduced4);
                                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                                bioReadCopyBuf.release();
                                            } else {
                                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                            }
                                            return newResult6;
                                        } else if (sslError == SSL.SSL_ERROR_WANT_READ) {
                                            SSLEngineResult newResult7 = newResult(SSLEngineResult.HandshakeStatus.NEED_UNWRAP, bytesConsumed, bytesProduced4);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (bioReadCopyBuf == null) {
                                                dst.position(dst.position() + bytesProduced4);
                                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                                bioReadCopyBuf.release();
                                            } else {
                                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                            }
                                            return newResult7;
                                        } else if (sslError == SSL.SSL_ERROR_WANT_WRITE) {
                                            if (bytesProduced4 > 0) {
                                                SSLEngineResult newResult8 = newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, bytesConsumed, bytesProduced4);
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                if (bioReadCopyBuf == null) {
                                                    dst.position(dst.position() + bytesProduced4);
                                                } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                                    dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                                    bioReadCopyBuf.release();
                                                } else {
                                                    throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                                }
                                                return newResult8;
                                            }
                                            SSLEngineResult newResult9 = newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, status, bytesConsumed, bytesProduced4);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (bioReadCopyBuf == null) {
                                                dst.position(dst.position() + bytesProduced4);
                                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                                bioReadCopyBuf.release();
                                            } else {
                                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                            }
                                            return newResult9;
                                        } else if (sslError == SSL.SSL_ERROR_WANT_X509_LOOKUP || sslError == SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY || sslError == SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                                            SSLEngineResult newResult10 = newResult(SSLEngineResult.HandshakeStatus.NEED_TASK, bytesConsumed, bytesProduced4);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (bioReadCopyBuf == null) {
                                                dst.position(dst.position() + bytesProduced4);
                                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                                bioReadCopyBuf.release();
                                            } else {
                                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                                            }
                                            return newResult10;
                                        } else {
                                            throw shutdownWithError("SSL_write", sslError);
                                        }
                                    }
                                }
                                offset++;
                            }
                            SSLEngineResult newResultMayFinishHandshake4 = newResultMayFinishHandshake(status, bytesConsumed, bytesProduced4);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (bioReadCopyBuf == null) {
                                dst.position(dst.position() + bytesProduced4);
                            } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                                dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced4));
                                bioReadCopyBuf.release();
                            } else {
                                throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                            }
                            return newResultMayFinishHandshake4;
                        }
                    } else {
                        throw new AssertionError();
                    }
                } else if (!isBytesAvailableEnoughForWrap(dst.remaining(), 2, 1)) {
                    SSLEngineResult sSLEngineResult4 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                    SSL.bioClearByteBuffer(this.networkBIO);
                    if (bioReadCopyBuf == null) {
                        dst.position(dst.position() + 0);
                    } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                        dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), 0));
                        bioReadCopyBuf.release();
                    } else {
                        throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                    }
                    return sSLEngineResult4;
                } else {
                    int bytesProduced6 = SSL.bioFlushByteBuffer(this.networkBIO);
                    if (bytesProduced6 <= 0) {
                        SSLEngineResult newResultMayFinishHandshake5 = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (bioReadCopyBuf == null) {
                            dst.position(dst.position() + bytesProduced6);
                        } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                            dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced6));
                            bioReadCopyBuf.release();
                        } else {
                            throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                        }
                        return newResultMayFinishHandshake5;
                    } else if (!doSSLShutdown()) {
                        SSLEngineResult newResultMayFinishHandshake6 = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, bytesProduced6);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (bioReadCopyBuf == null) {
                            dst.position(dst.position() + bytesProduced6);
                        } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                            dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced6));
                            bioReadCopyBuf.release();
                        } else {
                            throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                        }
                        return newResultMayFinishHandshake6;
                    } else {
                        int bytesProduced7 = bioLengthBefore - SSL.bioLengthByteBuffer(this.networkBIO);
                        SSLEngineResult newResultMayFinishHandshake7 = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, bytesProduced7);
                        SSL.bioClearByteBuffer(this.networkBIO);
                        if (bioReadCopyBuf == null) {
                            dst.position(dst.position() + bytesProduced7);
                        } else if ($assertionsDisabled || bioReadCopyBuf.readableBytes() <= dst.remaining()) {
                            dst.put(bioReadCopyBuf.internalNioBuffer(bioReadCopyBuf.readerIndex(), bytesProduced7));
                            bioReadCopyBuf.release();
                        } else {
                            throw new AssertionError("The destination buffer " + dst + " didn't have enough remaining space to hold the encrypted content in " + bioReadCopyBuf);
                        }
                        return newResultMayFinishHandshake7;
                    }
                }
            }
        }
    }

    private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus hs, int bytesConsumed, int bytesProduced) {
        return newResult(SSLEngineResult.Status.OK, hs, bytesConsumed, bytesProduced);
    }

    private SSLEngineResult newResult(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus hs, int bytesConsumed, int bytesProduced) {
        if (isOutboundDone()) {
            if (isInboundDone()) {
                hs = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                shutdown();
            }
            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, hs, bytesConsumed, bytesProduced);
        }
        if (hs == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.needTask = true;
        }
        return new SSLEngineResult(status, hs, bytesConsumed, bytesProduced);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus hs, int bytesConsumed, int bytesProduced) throws SSLException {
        return newResult(mayFinishHandshake(hs, bytesConsumed, bytesProduced), bytesConsumed, bytesProduced);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus hs, int bytesConsumed, int bytesProduced) throws SSLException {
        return newResult(status, mayFinishHandshake(hs, bytesConsumed, bytesProduced), bytesConsumed, bytesProduced);
    }

    private SSLException shutdownWithError(String operations, int sslError) {
        return shutdownWithError(operations, sslError, SSL.getLastErrorNumber());
    }

    private SSLException shutdownWithError(String operation, int sslError, int error) {
        String errorString = SSL.getErrorString((long) error);
        if (logger.isDebugEnabled()) {
            logger.debug("{} failed with {}: OpenSSL error: {} {}", operation, Integer.valueOf(sslError), Integer.valueOf(error), errorString);
        }
        shutdown();
        if (this.handshakeState == HandshakeState.FINISHED) {
            return new SSLException(errorString);
        }
        SSLHandshakeException exception = new SSLHandshakeException(errorString);
        if (this.pendingException != null) {
            exception.initCause(this.pendingException);
            this.pendingException = null;
        }
        return exception;
    }

    private SSLEngineResult handleUnwrapException(int bytesConsumed, int bytesProduced, SSLException e) throws SSLException {
        int lastError = SSL.getLastErrorNumber();
        if (lastError != 0) {
            return sslReadErrorResult(SSL.SSL_ERROR_SSL, lastError, bytesConsumed, bytesProduced);
        }
        throw e;
    }

    /* JADX WARN: Type inference failed for: r0v248, types: [long] */
    /* JADX WARN: Type inference failed for: r0v257, types: [long] */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0425, code lost:
        if (r27 == null) goto L_0x0551;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0428, code lost:
        r27.release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final javax.net.ssl.SSLEngineResult unwrap(java.nio.ByteBuffer[] r7, int r8, int r9, java.nio.ByteBuffer[] r10, int r11, int r12) throws javax.net.ssl.SSLException {
        /*
        // Method dump skipped, instructions count: 1457
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.ReferenceCountedOpenSslEngine.unwrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer[], int, int):javax.net.ssl.SSLEngineResult");
    }

    private boolean needWrapAgain(int stackError) {
        if (SSL.bioLengthNonApplication(this.networkBIO) <= 0) {
            return false;
        }
        String message = SSL.getErrorString((long) stackError);
        SSLException exception = this.handshakeState == HandshakeState.FINISHED ? new SSLException(message) : new SSLHandshakeException(message);
        if (this.pendingException == null) {
            this.pendingException = exception;
        } else {
            ThrowableUtil.addSuppressed(this.pendingException, exception);
        }
        SSL.clearError();
        return true;
    }

    private SSLEngineResult sslReadErrorResult(int error, int stackError, int bytesConsumed, int bytesProduced) throws SSLException {
        if (needWrapAgain(stackError)) {
            return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, bytesConsumed, bytesProduced);
        }
        throw shutdownWithError("SSL_read", error, stackError);
    }

    private void closeAll() throws SSLException {
        this.receivedShutdown = true;
        closeOutbound();
        closeInbound();
    }

    private void rejectRemoteInitiatedRenegotiation() throws SSLHandshakeException {
        if (isDestroyed()) {
            return;
        }
        if (((!this.clientMode && SSL.getHandshakeCount(this.ssl) > 1) || (this.clientMode && SSL.getHandshakeCount(this.ssl) > 2)) && !SslProtocols.TLS_v1_3.equals(this.session.getProtocol()) && this.handshakeState == HandshakeState.FINISHED) {
            shutdown();
            throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
        }
    }

    public final SSLEngineResult unwrap(ByteBuffer[] srcs, ByteBuffer[] dsts) throws SSLException {
        return unwrap(srcs, 0, srcs.length, dsts, 0, dsts.length);
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer src) {
        this.singleSrcBuffer[0] = src;
        return this.singleSrcBuffer;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer src) {
        this.singleDstBuffer[0] = src;
        return this.singleDstBuffer;
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts, int offset, int length) throws SSLException {
        try {
            SSLEngineResult unwrap = unwrap(singleSrcBuffer(src), 0, 1, dsts, offset, length);
            resetSingleSrcBuffer();
            return unwrap;
        } catch (Throwable th) {
            resetSingleSrcBuffer();
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult wrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        try {
            SSLEngineResult wrap = wrap(singleSrcBuffer(src), dst);
            resetSingleSrcBuffer();
            return wrap;
        } catch (Throwable th) {
            resetSingleSrcBuffer();
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        try {
            SSLEngineResult unwrap = unwrap(singleSrcBuffer(src), singleDstBuffer(dst));
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
            return unwrap;
        } catch (Throwable th) {
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts) throws SSLException {
        try {
            SSLEngineResult unwrap = unwrap(singleSrcBuffer(src), dsts);
            resetSingleSrcBuffer();
            return unwrap;
        } catch (Throwable th) {
            resetSingleSrcBuffer();
            throw th;
        }
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$TaskDecorator */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslEngine$TaskDecorator.class */
    private class TaskDecorator<R extends Runnable> implements Runnable {
        protected final R task;

        TaskDecorator(R task) {
            this.task = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            ReferenceCountedOpenSslEngine.this.runAndResetNeedTask(this.task);
        }
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$AsyncTaskDecorator */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslEngine$AsyncTaskDecorator.class */
    private final class AsyncTaskDecorator extends TaskDecorator<AsyncTask> implements AsyncRunnable {
        AsyncTaskDecorator(AsyncTask task) {
            super(task);
        }

        @Override // p013io.netty.handler.ssl.AsyncRunnable
        public void run(Runnable runnable) {
            if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                this.task.runAsync(new TaskDecorator(runnable));
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void runAndResetNeedTask(Runnable task) {
        try {
            if (!isDestroyed()) {
                task.run();
            }
        } finally {
            this.needTask = false;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized Runnable getDelegatedTask() {
        Runnable task;
        if (isDestroyed() || (task = SSL.getTask(this.ssl)) == null) {
            return null;
        }
        if (task instanceof AsyncTask) {
            return new AsyncTaskDecorator((AsyncTask) task);
        }
        return new TaskDecorator(task);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeInbound() throws SSLException {
        if (!this.isInboundDone) {
            this.isInboundDone = true;
            if (isOutboundDone()) {
                shutdown();
            }
            if (this.handshakeState != HandshakeState.NOT_STARTED && !this.receivedShutdown) {
                throw new SSLException("Inbound closed before receiving peer's close_notify: possible truncation attack?");
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isInboundDone() {
        return this.isInboundDone;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeOutbound() {
        if (!this.outboundClosed) {
            this.outboundClosed = true;
            if (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed()) {
                shutdown();
            } else if ((SSL.getShutdown(this.ssl) & SSL.SSL_SENT_SHUTDOWN) != SSL.SSL_SENT_SHUTDOWN) {
                doSSLShutdown();
            }
        }
    }

    private boolean doSSLShutdown() {
        if (SSL.isInInit(this.ssl) != 0) {
            return false;
        }
        int err = SSL.shutdownSSL(this.ssl);
        if (err >= 0) {
            return true;
        }
        int sslErr = SSL.getError(this.ssl, err);
        if (sslErr == SSL.SSL_ERROR_SYSCALL || sslErr == SSL.SSL_ERROR_SSL) {
            if (logger.isDebugEnabled()) {
                int error = SSL.getLastErrorNumber();
                logger.debug("SSL_shutdown failed: OpenSSL error: {} {}", Integer.valueOf(error), SSL.getErrorString((long) error));
            }
            shutdown();
            return false;
        }
        SSL.clearError();
        return true;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isOutboundDone() {
        return this.outboundClosed && (this.networkBIO == 0 || SSL.bioLengthNonApplication(this.networkBIO) == 0);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedCipherSuites() {
        return (String[]) OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledCipherSuites() {
        boolean tls13Enabled;
        String[] extraCiphers;
        synchronized (this) {
            if (!isDestroyed()) {
                String[] enabled = SSL.getCiphers(this.ssl);
                if (isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                    extraCiphers = OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
                    tls13Enabled = true;
                } else {
                    extraCiphers = EmptyArrays.EMPTY_STRINGS;
                    tls13Enabled = false;
                }
                if (enabled == null) {
                    return EmptyArrays.EMPTY_STRINGS;
                }
                Set<String> enabledSet = new LinkedHashSet<>(enabled.length + extraCiphers.length);
                synchronized (this) {
                    for (int i = 0; i < enabled.length; i++) {
                        String mapped = toJavaCipherSuite(enabled[i]);
                        String cipher = mapped == null ? enabled[i] : mapped;
                        if ((tls13Enabled && OpenSsl.isTlsv13Supported()) || !SslUtils.isTLSv13Cipher(cipher)) {
                            enabledSet.add(cipher);
                        }
                    }
                    Collections.addAll(enabledSet, extraCiphers);
                }
                return (String[]) enabledSet.toArray(new String[0]);
            }
            return EmptyArrays.EMPTY_STRINGS;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledCipherSuites(String[] cipherSuites) {
        ObjectUtil.checkNotNull(cipherSuites, "cipherSuites");
        StringBuilder buf = new StringBuilder();
        StringBuilder bufTLSv13 = new StringBuilder();
        CipherSuiteConverter.convertToCipherStrings(Arrays.asList(cipherSuites), buf, bufTLSv13, OpenSsl.isBoringSSL());
        String cipherSuiteSpec = buf.toString();
        String cipherSuiteSpecTLSv13 = bufTLSv13.toString();
        if (OpenSsl.isTlsv13Supported() || cipherSuiteSpecTLSv13.isEmpty()) {
            synchronized (this) {
                if (!isDestroyed()) {
                    SSL.setCipherSuites(this.ssl, cipherSuiteSpec, false);
                    if (OpenSsl.isTlsv13Supported()) {
                        SSL.setCipherSuites(this.ssl, OpenSsl.checkTls13Ciphers(logger, cipherSuiteSpecTLSv13), true);
                    }
                    Set<String> protocols = new HashSet<>(this.explicitlyEnabledProtocols.length);
                    Collections.addAll(protocols, this.explicitlyEnabledProtocols);
                    if (cipherSuiteSpec.isEmpty()) {
                        protocols.remove(SslProtocols.TLS_v1);
                        protocols.remove(SslProtocols.TLS_v1_1);
                        protocols.remove(SslProtocols.TLS_v1_2);
                        protocols.remove(SslProtocols.SSL_v3);
                        protocols.remove(SslProtocols.SSL_v2);
                        protocols.remove(SslProtocols.SSL_v2_HELLO);
                    }
                    try {
                        if (cipherSuiteSpecTLSv13.isEmpty()) {
                            protocols.remove(SslProtocols.TLS_v1_3);
                        }
                        setEnabledProtocols0((String[]) protocols.toArray(EmptyArrays.EMPTY_STRINGS), false);
                    } catch (Exception e) {
                        throw new IllegalStateException("failed to enable cipher suites: " + cipherSuiteSpec, e);
                    }
                } else {
                    throw new IllegalStateException("failed to enable cipher suites: " + cipherSuiteSpec);
                }
            }
            return;
        }
        throw new IllegalArgumentException("TLSv1.3 is not supported by this java version.");
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedProtocols() {
        return (String[]) OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledProtocols() {
        List<String> enabled = new ArrayList<>(6);
        enabled.add(SslProtocols.SSL_v2_HELLO);
        synchronized (this) {
            if (!isDestroyed()) {
                int opts = SSL.getOptions(this.ssl);
                if (isProtocolEnabled(opts, SSL.SSL_OP_NO_TLSv1, SslProtocols.TLS_v1)) {
                    enabled.add(SslProtocols.TLS_v1);
                }
                if (isProtocolEnabled(opts, SSL.SSL_OP_NO_TLSv1_1, SslProtocols.TLS_v1_1)) {
                    enabled.add(SslProtocols.TLS_v1_1);
                }
                if (isProtocolEnabled(opts, SSL.SSL_OP_NO_TLSv1_2, SslProtocols.TLS_v1_2)) {
                    enabled.add(SslProtocols.TLS_v1_2);
                }
                if (isProtocolEnabled(opts, SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                    enabled.add(SslProtocols.TLS_v1_3);
                }
                if (isProtocolEnabled(opts, SSL.SSL_OP_NO_SSLv2, SslProtocols.SSL_v2)) {
                    enabled.add(SslProtocols.SSL_v2);
                }
                if (isProtocolEnabled(opts, SSL.SSL_OP_NO_SSLv3, SslProtocols.SSL_v3)) {
                    enabled.add(SslProtocols.SSL_v3);
                }
                return (String[]) enabled.toArray(new String[0]);
            }
            return (String[]) enabled.toArray(new String[0]);
        }
    }

    private static boolean isProtocolEnabled(int opts, int disableMask, String protocolString) {
        return (opts & disableMask) == 0 && OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(protocolString);
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledProtocols(String[] protocols) {
        setEnabledProtocols0(protocols, true);
    }

    private void setEnabledProtocols0(String[] protocols, boolean cache) {
        ObjectUtil.checkNotNullWithIAE(protocols, "protocols");
        int minProtocolIndex = OPENSSL_OP_NO_PROTOCOLS.length;
        int maxProtocolIndex = 0;
        for (String p : protocols) {
            if (!OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(p)) {
                throw new IllegalArgumentException("Protocol " + p + " is not supported.");
            }
            if (p.equals(SslProtocols.SSL_v2)) {
                if (minProtocolIndex > 0) {
                    minProtocolIndex = 0;
                }
                if (maxProtocolIndex < 0) {
                    maxProtocolIndex = 0;
                }
            } else if (p.equals(SslProtocols.SSL_v3)) {
                if (minProtocolIndex > 1) {
                    minProtocolIndex = 1;
                }
                if (maxProtocolIndex < 1) {
                    maxProtocolIndex = 1;
                }
            } else if (p.equals(SslProtocols.TLS_v1)) {
                if (minProtocolIndex > 2) {
                    minProtocolIndex = 2;
                }
                if (maxProtocolIndex < 2) {
                    maxProtocolIndex = 2;
                }
            } else if (p.equals(SslProtocols.TLS_v1_1)) {
                if (minProtocolIndex > 3) {
                    minProtocolIndex = 3;
                }
                if (maxProtocolIndex < 3) {
                    maxProtocolIndex = 3;
                }
            } else if (p.equals(SslProtocols.TLS_v1_2)) {
                if (minProtocolIndex > 4) {
                    minProtocolIndex = 4;
                }
                if (maxProtocolIndex < 4) {
                    maxProtocolIndex = 4;
                }
            } else if (p.equals(SslProtocols.TLS_v1_3)) {
                if (minProtocolIndex > 5) {
                    minProtocolIndex = 5;
                }
                if (maxProtocolIndex < 5) {
                    maxProtocolIndex = 5;
                }
            }
        }
        synchronized (this) {
            if (cache) {
                this.explicitlyEnabledProtocols = protocols;
            }
            if (!isDestroyed()) {
                SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 | SSL.SSL_OP_NO_TLSv1_3);
                int opts = 0;
                for (int i = 0; i < minProtocolIndex; i++) {
                    opts |= OPENSSL_OP_NO_PROTOCOLS[i];
                }
                if ($assertionsDisabled || maxProtocolIndex != Integer.MAX_VALUE) {
                    for (int i2 = maxProtocolIndex + 1; i2 < OPENSSL_OP_NO_PROTOCOLS.length; i2++) {
                        opts |= OPENSSL_OP_NO_PROTOCOLS[i2];
                    }
                    SSL.setOptions(this.ssl, opts);
                } else {
                    throw new AssertionError();
                }
            } else {
                throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(protocols));
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final SSLSession getSession() {
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void beginHandshake() throws SSLException {
        switch (this.handshakeState) {
            case NOT_STARTED:
                this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                if (handshake() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                    this.needTask = true;
                }
                calculateMaxWrapOverhead();
                return;
            case FINISHED:
                throw new SSLException("renegotiation unsupported");
            case STARTED_IMPLICITLY:
                checkEngineClosed();
                this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                calculateMaxWrapOverhead();
                return;
            case STARTED_EXPLICITLY:
                return;
            default:
                throw new Error();
        }
    }

    private void checkEngineClosed() throws SSLException {
        if (isDestroyed()) {
            throw new SSLException("engine closed");
        }
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int pendingStatus) {
        return pendingStatus > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    /* access modifiers changed from: private */
    public static boolean isEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }

    /* access modifiers changed from: private */
    public static boolean isEmpty(byte[] cert) {
        return cert == null || cert.length == 0;
    }

    private SSLEngineResult.HandshakeStatus handshakeException() throws SSLException {
        if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        Throwable exception = this.pendingException;
        if ($assertionsDisabled || exception != null) {
            this.pendingException = null;
            shutdown();
            if (exception instanceof SSLHandshakeException) {
                throw ((SSLHandshakeException) exception);
            }
            SSLHandshakeException e = new SSLHandshakeException("General OpenSslEngine problem");
            e.initCause(exception);
            throw e;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final void initHandshakeException(Throwable cause) {
        if (this.pendingException == null) {
            this.pendingException = cause;
        } else {
            ThrowableUtil.addSuppressed(this.pendingException, cause);
        }
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        checkEngineClosed();
        if (this.pendingException != null) {
            if (SSL.doHandshake(this.ssl) <= 0) {
                SSL.clearError();
            }
            return handshakeException();
        }
        this.engineMap.add(this);
        if (!this.sessionSet) {
            this.parentContext.sessionContext().setSessionFromCache(getPeerHost(), getPeerPort(), this.ssl);
            this.sessionSet = true;
        }
        if (this.lastAccessed == -1) {
            this.lastAccessed = System.currentTimeMillis();
        }
        int code = SSL.doHandshake(this.ssl);
        if (code <= 0) {
            int sslError = SSL.getError(this.ssl, code);
            if (sslError == SSL.SSL_ERROR_WANT_READ || sslError == SSL.SSL_ERROR_WANT_WRITE) {
                return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
            }
            if (sslError == SSL.SSL_ERROR_WANT_X509_LOOKUP || sslError == SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY || sslError == SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            if (needWrapAgain(SSL.getLastErrorNumber())) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            if (this.pendingException != null) {
                return handshakeException();
            }
            throw shutdownWithError("SSL_do_handshake", sslError);
        } else if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        } else {
            this.session.handshakeFinished(SSL.getSessionId(this.ssl), SSL.getCipherForSSL(this.ssl), SSL.getVersion(this.ssl), SSL.getPeerCertificate(this.ssl), SSL.getPeerCertChain(this.ssl), SSL.getTime(this.ssl) * 1000, this.parentContext.sessionTimeout() * 1000);
            selectApplicationProtocol();
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus hs, int bytesConsumed, int bytesProduced) throws SSLException {
        if ((hs == SSLEngineResult.HandshakeStatus.NEED_UNWRAP && bytesProduced > 0) || (hs == SSLEngineResult.HandshakeStatus.NEED_WRAP && bytesConsumed > 0)) {
            return handshake();
        }
        return mayFinishHandshake(hs != SSLEngineResult.HandshakeStatus.FINISHED ? getHandshakeStatus() : SSLEngineResult.HandshakeStatus.FINISHED);
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus status) throws SSLException {
        if (status == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            if (this.handshakeState != HandshakeState.FINISHED) {
                return handshake();
            }
            if (!isDestroyed() && SSL.bioLengthNonApplication(this.networkBIO) > 0) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
        }
        return status;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        if (!needPendingStatus()) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int pending) {
        if (!needPendingStatus()) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        return pendingStatus(pending);
    }

    private boolean needPendingStatus() {
        return this.handshakeState != HandshakeState.NOT_STARTED && !isDestroyed() && (this.handshakeState != HandshakeState.FINISHED || isInboundDone() || isOutboundDone());
    }

    /* access modifiers changed from: private */
    public String toJavaCipherSuite(String openSslCipherSuite) {
        if (openSslCipherSuite == null) {
            return null;
        }
        return CipherSuiteConverter.toJava(openSslCipherSuite, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    private static String toJavaCipherSuitePrefix(String protocolVersion) {
        char c;
        if (protocolVersion == null || protocolVersion.isEmpty()) {
            c = 0;
        } else {
            c = protocolVersion.charAt(0);
        }
        switch (c) {
            case 'S':
                return p001ch.qos.logback.core.net.ssl.SSL.DEFAULT_PROTOCOL;
            case 'T':
                return "TLS";
            default:
                return "UNKNOWN";
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setUseClientMode(boolean clientMode) {
        if (clientMode != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setNeedClientAuth(boolean b) {
        setClientAuth(b ? ClientAuth.REQUIRE : ClientAuth.NONE);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setWantClientAuth(boolean b) {
        setClientAuth(b ? ClientAuth.OPTIONAL : ClientAuth.NONE);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    public final synchronized void setVerify(int verifyMode, int depth) {
        if (!isDestroyed()) {
            SSL.setVerify(this.ssl, verifyMode, depth);
        }
    }

    private void setClientAuth(ClientAuth mode) {
        if (!this.clientMode) {
            synchronized (this) {
                if (this.clientAuth != mode) {
                    if (!isDestroyed()) {
                        switch (mode) {
                            case NONE:
                                SSL.setVerify(this.ssl, 0, 10);
                                break;
                            case REQUIRE:
                                SSL.setVerify(this.ssl, 2, 10);
                                break;
                            case OPTIONAL:
                                SSL.setVerify(this.ssl, 1, 10);
                                break;
                            default:
                                throw new Error(mode.toString());
                        }
                    }
                    this.clientAuth = mode;
                }
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnableSessionCreation(boolean b) {
        if (b) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getEnableSessionCreation() {
        return false;
    }

    @Override // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final synchronized SSLParameters getSSLParameters() {
        SSLParameters sslParameters = getSSLParameters();
        int version = PlatformDependent.javaVersion();
        if (version >= 7) {
            sslParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
            Java7SslParametersUtils.setAlgorithmConstraints(sslParameters, this.algorithmConstraints);
            if (version >= 8) {
                if (this.sniHostNames != null) {
                    Java8SslUtils.setSniHostNames(sslParameters, this.sniHostNames);
                }
                if (!isDestroyed()) {
                    Java8SslUtils.setUseCipherSuitesOrder(sslParameters, (SSL.getOptions(this.ssl) & SSL.SSL_OP_CIPHER_SERVER_PREFERENCE) != 0);
                }
                Java8SslUtils.setSNIMatchers(sslParameters, this.matchers);
            }
        }
        return sslParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final synchronized void setSSLParameters(SSLParameters sslParameters) {
        int version = PlatformDependent.javaVersion();
        if (version >= 7) {
            if (sslParameters.getAlgorithmConstraints() != null) {
                throw new IllegalArgumentException("AlgorithmConstraints are not supported.");
            }
            boolean isDestroyed = isDestroyed();
            if (version >= 8) {
                if (!isDestroyed) {
                    if (this.clientMode) {
                        List<String> sniHostNames = Java8SslUtils.getSniHostNames(sslParameters);
                        for (String name : sniHostNames) {
                            SSL.setTlsExtHostName(this.ssl, name);
                        }
                        this.sniHostNames = sniHostNames;
                    }
                    if (Java8SslUtils.getUseCipherSuitesOrder(sslParameters)) {
                        SSL.setOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                    } else {
                        SSL.clearOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                    }
                }
                this.matchers = sslParameters.getSNIMatchers();
            }
            String endPointIdentificationAlgorithm = sslParameters.getEndpointIdentificationAlgorithm();
            if (!isDestroyed && this.clientMode && isEndPointVerificationEnabled(endPointIdentificationAlgorithm)) {
                SSL.setVerify(this.ssl, 2, -1);
            }
            this.endPointIdentificationAlgorithm = endPointIdentificationAlgorithm;
            this.algorithmConstraints = sslParameters.getAlgorithmConstraints();
        }
        setSSLParameters(sslParameters);
    }

    private static boolean isEndPointVerificationEnabled(String endPointIdentificationAlgorithm) {
        return endPointIdentificationAlgorithm != null && !endPointIdentificationAlgorithm.isEmpty();
    }

    /* access modifiers changed from: private */
    public boolean isDestroyed() {
        return this.destroyed;
    }

    /* access modifiers changed from: package-private */
    public final boolean checkSniHostnameMatch(byte[] hostname) {
        return Java8SslUtils.checkSniHostnameMatch(this.matchers, hostname);
    }

    @Override // p013io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    private static long bufferAddress(ByteBuffer b) {
        if (!$assertionsDisabled && !b.isDirect()) {
            throw new AssertionError();
        } else if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.directBufferAddress(b);
        } else {
            return Buffer.address(b);
        }
    }

    private void selectApplicationProtocol() throws SSLException {
        ApplicationProtocolConfig.SelectedListenerFailureBehavior behavior = this.apn.selectedListenerFailureBehavior();
        List<String> protocols = this.apn.protocols();
        switch (this.apn.protocol()) {
            case NONE:
                return;
            case ALPN:
                String applicationProtocol = SSL.getAlpnSelected(this.ssl);
                if (applicationProtocol != null) {
                    this.applicationProtocol = selectApplicationProtocol(protocols, behavior, applicationProtocol);
                    return;
                }
                return;
            case NPN:
                String applicationProtocol2 = SSL.getNextProtoNegotiated(this.ssl);
                if (applicationProtocol2 != null) {
                    this.applicationProtocol = selectApplicationProtocol(protocols, behavior, applicationProtocol2);
                    return;
                }
                return;
            case NPN_AND_ALPN:
                String applicationProtocol3 = SSL.getAlpnSelected(this.ssl);
                if (applicationProtocol3 == null) {
                    applicationProtocol3 = SSL.getNextProtoNegotiated(this.ssl);
                }
                if (applicationProtocol3 != null) {
                    this.applicationProtocol = selectApplicationProtocol(protocols, behavior, applicationProtocol3);
                    return;
                }
                return;
            default:
                throw new Error();
        }
    }

    private String selectApplicationProtocol(List<String> protocols, ApplicationProtocolConfig.SelectedListenerFailureBehavior behavior, String applicationProtocol) throws SSLException {
        if (behavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
            return applicationProtocol;
        }
        int size = protocols.size();
        if (!$assertionsDisabled && size <= 0) {
            throw new AssertionError();
        } else if (protocols.contains(applicationProtocol)) {
            return applicationProtocol;
        } else {
            if (behavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
                return protocols.get(size - 1);
            }
            throw new SSLException("unknown protocol " + applicationProtocol);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setSessionId(OpenSslSessionId id) {
        this.session.setSessionId(id);
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$DefaultOpenSslSession */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/ReferenceCountedOpenSslEngine$DefaultOpenSslSession.class */
    private final class DefaultOpenSslSession implements OpenSslSession {
        private final OpenSslSessionContext sessionContext;
        private X509Certificate[] x509PeerCerts;
        private Certificate[] peerCerts;
        private String protocol;
        private String cipher;
        private volatile long creationTime;
        private volatile Certificate[] localCertificateChain;
        private Map<String, Object> values;
        private boolean valid = true;

        /* renamed from: id */
        private OpenSslSessionId f1025id = OpenSslSessionId.NULL_ID;
        private volatile int applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;

        DefaultOpenSslSession(OpenSslSessionContext sessionContext) {
            this.sessionContext = sessionContext;
        }

        private SSLSessionBindingEvent newSSLSessionBindingEvent(String name) {
            return new SSLSessionBindingEvent(ReferenceCountedOpenSslEngine.this.session, name);
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public void setSessionId(OpenSslSessionId sessionId) {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (this.f1025id == OpenSslSessionId.NULL_ID) {
                    this.f1025id = sessionId;
                    this.creationTime = System.currentTimeMillis();
                }
            }
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionId sessionId() {
            OpenSslSessionId openSslSessionId;
            byte[] sessionId;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (this.f1025id == OpenSslSessionId.NULL_ID && !ReferenceCountedOpenSslEngine.this.isDestroyed() && (sessionId = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl)) != null) {
                    this.f1025id = new OpenSslSessionId(sessionId);
                }
                openSslSessionId = this.f1025id;
            }
            return openSslSessionId;
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public void setLocalCertificate(Certificate[] localCertificate) {
            this.localCertificateChain = localCertificate;
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            return sessionId().cloneBytes();
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionContext getSessionContext() {
            return this.sessionContext;
        }

        @Override // javax.net.ssl.SSLSession
        public long getCreationTime() {
            long j;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                j = this.creationTime;
            }
            return j;
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long lastAccessed = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return lastAccessed == -1 ? getCreationTime() : lastAccessed;
        }

        @Override // javax.net.ssl.SSLSession
        public void invalidate() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                this.valid = false;
                this.sessionContext.removeFromCache(this.f1025id);
            }
        }

        @Override // javax.net.ssl.SSLSession
        public boolean isValid() {
            boolean z;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                z = this.valid || this.sessionContext.isInCache(this.f1025id);
            }
            return z;
        }

        @Override // javax.net.ssl.SSLSession
        public void putValue(String name, Object value) {
            Object old;
            ObjectUtil.checkNotNull(name, "name");
            ObjectUtil.checkNotNull(value, "value");
            synchronized (this) {
                Map<String, Object> values = this.values;
                if (values == null) {
                    Map<String, Object> hashMap = new HashMap<>(2);
                    this.values = hashMap;
                    values = hashMap;
                }
                old = values.put(name, value);
            }
            if (value instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) value).valueBound(newSSLSessionBindingEvent(name));
            }
            notifyUnbound(old, name);
        }

        @Override // javax.net.ssl.SSLSession
        public Object getValue(String name) {
            ObjectUtil.checkNotNull(name, "name");
            synchronized (this) {
                if (this.values == null) {
                    return null;
                }
                return this.values.get(name);
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void removeValue(String name) {
            ObjectUtil.checkNotNull(name, "name");
            synchronized (this) {
                Map<String, Object> values = this.values;
                if (values != null) {
                    notifyUnbound(values.remove(name), name);
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            synchronized (this) {
                Map<String, Object> values = this.values;
                if (values == null || values.isEmpty()) {
                    return EmptyArrays.EMPTY_STRINGS;
                }
                return (String[]) values.keySet().toArray(new String[0]);
            }
        }

        private void notifyUnbound(Object value, String name) {
            if (value instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) value).valueUnbound(newSSLSessionBindingEvent(name));
            }
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public void handshakeFinished(byte[] id, String cipher, String protocol, byte[] peerCertificate, byte[][] peerCertificateChain, long creationTime, long timeout) throws SSLException {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    this.creationTime = creationTime;
                    if (this.f1025id == OpenSslSessionId.NULL_ID) {
                        this.f1025id = id == null ? OpenSslSessionId.NULL_ID : new OpenSslSessionId(id);
                    }
                    this.cipher = ReferenceCountedOpenSslEngine.this.toJavaCipherSuite(cipher);
                    this.protocol = protocol;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        if (ReferenceCountedOpenSslEngine.isEmpty(peerCertificateChain)) {
                            this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                            this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                        } else {
                            this.peerCerts = new Certificate[peerCertificateChain.length];
                            this.x509PeerCerts = new X509Certificate[peerCertificateChain.length];
                            initCerts(peerCertificateChain, 0);
                        }
                    } else if (ReferenceCountedOpenSslEngine.isEmpty(peerCertificate)) {
                        this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                        this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                    } else if (ReferenceCountedOpenSslEngine.isEmpty(peerCertificateChain)) {
                        this.peerCerts = new Certificate[]{new LazyX509Certificate(peerCertificate)};
                        this.x509PeerCerts = new X509Certificate[]{new LazyJavaxX509Certificate(peerCertificate)};
                    } else {
                        this.peerCerts = new Certificate[peerCertificateChain.length + 1];
                        this.x509PeerCerts = new X509Certificate[peerCertificateChain.length + 1];
                        this.peerCerts[0] = new LazyX509Certificate(peerCertificate);
                        this.x509PeerCerts[0] = new LazyJavaxX509Certificate(peerCertificate);
                        initCerts(peerCertificateChain, 1);
                    }
                    ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
                    ReferenceCountedOpenSslEngine.this.handshakeState = HandshakeState.FINISHED;
                } else {
                    throw new SSLException("Already closed");
                }
            }
        }

        private void initCerts(byte[][] chain, int startPos) {
            for (int i = 0; i < chain.length; i++) {
                int certPos = startPos + i;
                this.peerCerts[certPos] = new LazyX509Certificate(chain[i]);
                this.x509PeerCerts[certPos] = new LazyJavaxX509Certificate(chain[i]);
            }
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            Certificate[] certificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (ReferenceCountedOpenSslEngine.isEmpty(this.peerCerts)) {
                    throw new SSLPeerUnverifiedException("peer not verified");
                }
                certificateArr = (Certificate[]) this.peerCerts.clone();
            }
            return certificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            Certificate[] localCerts = this.localCertificateChain;
            if (localCerts == null) {
                return null;
            }
            return (Certificate[]) localCerts.clone();
        }

        @Override // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
            X509Certificate[] x509CertificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (ReferenceCountedOpenSslEngine.isEmpty(this.x509PeerCerts)) {
                    throw new SSLPeerUnverifiedException("peer not verified");
                }
                x509CertificateArr = (X509Certificate[]) this.x509PeerCerts.clone();
            }
            return x509CertificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            return ((java.security.cert.X509Certificate) getPeerCertificates()[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] local = this.localCertificateChain;
            if (local == null || local.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) local[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (this.cipher == null) {
                    return "SSL_NULL_WITH_NULL_NULL";
                }
                return this.cipher;
            }
        }

        @Override // javax.net.ssl.SSLSession
        public String getProtocol() {
            String protocol = this.protocol;
            if (protocol == null) {
                synchronized (ReferenceCountedOpenSslEngine.this) {
                    if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        protocol = SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl);
                    } else {
                        protocol = "";
                    }
                }
            }
            return protocol;
        }

        @Override // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return ReferenceCountedOpenSslEngine.this.maxEncryptedPacketLength();
        }

        @Override // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return this.applicationBufferSize;
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public void tryExpandApplicationBufferSize(int packetLengthDataOnly) {
            if (packetLengthDataOnly > ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH && this.applicationBufferSize != ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE) {
                this.applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return "DefaultOpenSslSession{sessionContext=" + this.sessionContext + ", id=" + this.f1025id + '}';
        }
    }
}
