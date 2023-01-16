package p013io.netty.handler.ssl;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.buffer.CompositeByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.AbstractCoalescingBufferQueue;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelOutboundHandler;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.unix.UnixChannel;
import p013io.netty.handler.codec.ByteToMessageDecoder;
import p013io.netty.handler.codec.DecoderException;
import p013io.netty.handler.codec.UnsupportedMessageTypeException;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.DefaultPromise;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.ImmediateExecutor;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.concurrent.PromiseNotifier;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.SslHandler */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandler.class */
public class SslHandler extends ByteToMessageDecoder implements ChannelOutboundHandler {
    private static final InternalLogger logger;
    private static final Pattern IGNORABLE_CLASS_IN_STACK;
    private static final Pattern IGNORABLE_ERROR_MESSAGE;
    private static final int STATE_SENT_FIRST_MESSAGE = 1;
    private static final int STATE_FLUSHED_BEFORE_HANDSHAKE = 2;
    private static final int STATE_READ_DURING_HANDSHAKE = 4;
    private static final int STATE_HANDSHAKE_STARTED = 8;
    private static final int STATE_NEEDS_FLUSH = 16;
    private static final int STATE_OUTBOUND_CLOSED = 32;
    private static final int STATE_CLOSE_NOTIFY = 64;
    private static final int STATE_PROCESS_TASK = 128;
    private static final int STATE_FIRE_CHANNEL_READ = 256;
    private static final int STATE_UNWRAP_REENTRY = 512;
    private static final int MAX_PLAINTEXT_LENGTH = 16384;
    private volatile ChannelHandlerContext ctx;
    private final SSLEngine engine;
    private final SslEngineType engineType;
    private final Executor delegatedTaskExecutor;
    private final boolean jdkCompatibilityMode;
    private final ByteBuffer[] singleBuffer;
    private final boolean startTls;
    private final SslTasksRunner sslTaskRunnerForUnwrap;
    private final SslTasksRunner sslTaskRunner;
    private SslHandlerCoalescingBufferQueue pendingUnencryptedWrites;
    private Promise<Channel> handshakePromise;
    private final LazyChannelPromise sslClosePromise;
    private int packetLength;
    private short state;
    private volatile long handshakeTimeoutMillis;
    private volatile long closeNotifyFlushTimeoutMillis;
    private volatile long closeNotifyReadTimeoutMillis;
    volatile int wrapDataSize;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SslHandler.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(SslHandler.class);
        IGNORABLE_CLASS_IN_STACK = Pattern.compile("^.*(?:Socket|Datagram|Sctp|Udt)Channel.*$");
        IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*(?:reset|closed|abort|broken)|broken.*pipe).*$", 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.SslHandler$SslEngineType */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandler$SslEngineType.class */
    public enum SslEngineType {
        TCNATIVE(true, ByteToMessageDecoder.COMPOSITE_CUMULATOR) {
            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            SSLEngineResult unwrap(SslHandler handler, ByteBuf in, int len, ByteBuf out) throws SSLException {
                SSLEngineResult result;
                int nioBufferCount = in.nioBufferCount();
                int writerIndex = out.writerIndex();
                if (nioBufferCount > 1) {
                    ReferenceCountedOpenSslEngine opensslEngine = (ReferenceCountedOpenSslEngine) handler.engine;
                    try {
                        handler.singleBuffer[0] = SslHandler.toByteBuffer(out, writerIndex, out.writableBytes());
                        result = opensslEngine.unwrap(in.nioBuffers(in.readerIndex(), len), handler.singleBuffer);
                        handler.singleBuffer[0] = null;
                    } catch (Throwable th) {
                        handler.singleBuffer[0] = null;
                        throw th;
                    }
                } else {
                    result = handler.engine.unwrap(SslHandler.toByteBuffer(in, in.readerIndex(), len), SslHandler.toByteBuffer(out, writerIndex, out.writableBytes()));
                }
                out.writerIndex(writerIndex + result.bytesProduced());
                return result;
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            ByteBuf allocateWrapBuffer(SslHandler handler, ByteBufAllocator allocator, int pendingBytes, int numComponents) {
                return allocator.directBuffer(((ReferenceCountedOpenSslEngine) handler.engine).calculateMaxLengthForWrap(pendingBytes, numComponents));
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            int calculatePendingData(SslHandler handler, int guess) {
                int sslPending = ((ReferenceCountedOpenSslEngine) handler.engine).sslPending();
                return sslPending > 0 ? sslPending : guess;
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            boolean jdkCompatibilityMode(SSLEngine engine) {
                return ((ReferenceCountedOpenSslEngine) engine).jdkCompatibilityMode;
            }
        },
        CONSCRYPT(true, ByteToMessageDecoder.COMPOSITE_CUMULATOR) {
            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            SSLEngineResult unwrap(SslHandler handler, ByteBuf in, int len, ByteBuf out) throws SSLException {
                SSLEngineResult result;
                int nioBufferCount = in.nioBufferCount();
                int writerIndex = out.writerIndex();
                if (nioBufferCount > 1) {
                    try {
                        handler.singleBuffer[0] = SslHandler.toByteBuffer(out, writerIndex, out.writableBytes());
                        result = ((ConscryptAlpnSslEngine) handler.engine).unwrap(in.nioBuffers(in.readerIndex(), len), handler.singleBuffer);
                        handler.singleBuffer[0] = null;
                    } catch (Throwable th) {
                        handler.singleBuffer[0] = null;
                        throw th;
                    }
                } else {
                    result = handler.engine.unwrap(SslHandler.toByteBuffer(in, in.readerIndex(), len), SslHandler.toByteBuffer(out, writerIndex, out.writableBytes()));
                }
                out.writerIndex(writerIndex + result.bytesProduced());
                return result;
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            ByteBuf allocateWrapBuffer(SslHandler handler, ByteBufAllocator allocator, int pendingBytes, int numComponents) {
                return allocator.directBuffer(((ConscryptAlpnSslEngine) handler.engine).calculateOutNetBufSize(pendingBytes, numComponents));
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            int calculatePendingData(SslHandler handler, int guess) {
                return guess;
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            boolean jdkCompatibilityMode(SSLEngine engine) {
                return true;
            }
        },
        JDK(false, ByteToMessageDecoder.MERGE_CUMULATOR) {
            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            SSLEngineResult unwrap(SslHandler handler, ByteBuf in, int len, ByteBuf out) throws SSLException {
                int consumed;
                int writerIndex = out.writerIndex();
                ByteBuffer inNioBuffer = SslHandler.toByteBuffer(in, in.readerIndex(), len);
                int position = inNioBuffer.position();
                SSLEngineResult result = handler.engine.unwrap(inNioBuffer, SslHandler.toByteBuffer(out, writerIndex, out.writableBytes()));
                out.writerIndex(writerIndex + result.bytesProduced());
                if (result.bytesConsumed() != 0 || (consumed = inNioBuffer.position() - position) == result.bytesConsumed()) {
                    return result;
                }
                return new SSLEngineResult(result.getStatus(), result.getHandshakeStatus(), consumed, result.bytesProduced());
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            ByteBuf allocateWrapBuffer(SslHandler handler, ByteBufAllocator allocator, int pendingBytes, int numComponents) {
                return allocator.heapBuffer(handler.engine.getSession().getPacketBufferSize());
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            int calculatePendingData(SslHandler handler, int guess) {
                return guess;
            }

            @Override // p013io.netty.handler.ssl.SslHandler.SslEngineType
            boolean jdkCompatibilityMode(SSLEngine engine) {
                return true;
            }
        };
        
        final boolean wantsDirectBuffer;
        final ByteToMessageDecoder.Cumulator cumulator;

        abstract SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i, ByteBuf byteBuf2) throws SSLException;

        abstract int calculatePendingData(SslHandler sslHandler, int i);

        abstract boolean jdkCompatibilityMode(SSLEngine sSLEngine);

        abstract ByteBuf allocateWrapBuffer(SslHandler sslHandler, ByteBufAllocator byteBufAllocator, int i, int i2);

        static SslEngineType forEngine(SSLEngine engine) {
            return engine instanceof ReferenceCountedOpenSslEngine ? TCNATIVE : engine instanceof ConscryptAlpnSslEngine ? CONSCRYPT : JDK;
        }

        SslEngineType(boolean wantsDirectBuffer, ByteToMessageDecoder.Cumulator cumulator) {
            this.wantsDirectBuffer = wantsDirectBuffer;
            this.cumulator = cumulator;
        }
    }

    public SslHandler(SSLEngine engine) {
        this(engine, false);
    }

    public SslHandler(SSLEngine engine, boolean startTls) {
        this(engine, startTls, ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine engine, Executor delegatedTaskExecutor) {
        this(engine, false, delegatedTaskExecutor);
    }

    public SslHandler(SSLEngine engine, boolean startTls, Executor delegatedTaskExecutor) {
        this.singleBuffer = new ByteBuffer[1];
        this.sslTaskRunnerForUnwrap = new SslTasksRunner(true);
        this.sslTaskRunner = new SslTasksRunner(false);
        this.handshakePromise = new LazyChannelPromise();
        this.sslClosePromise = new LazyChannelPromise();
        this.handshakeTimeoutMillis = AbstractComponentTracker.LINGERING_TIMEOUT;
        this.closeNotifyFlushTimeoutMillis = 3000;
        this.wrapDataSize = 16384;
        this.engine = (SSLEngine) ObjectUtil.checkNotNull(engine, "engine");
        this.delegatedTaskExecutor = (Executor) ObjectUtil.checkNotNull(delegatedTaskExecutor, "delegatedTaskExecutor");
        this.engineType = SslEngineType.forEngine(engine);
        this.startTls = startTls;
        this.jdkCompatibilityMode = this.engineType.jdkCompatibilityMode(engine);
        setCumulator(this.engineType.cumulator);
    }

    public long getHandshakeTimeoutMillis() {
        return this.handshakeTimeoutMillis;
    }

    public void setHandshakeTimeout(long handshakeTimeout, TimeUnit unit) {
        ObjectUtil.checkNotNull(unit, "unit");
        setHandshakeTimeoutMillis(unit.toMillis(handshakeTimeout));
    }

    public void setHandshakeTimeoutMillis(long handshakeTimeoutMillis) {
        this.handshakeTimeoutMillis = ObjectUtil.checkPositiveOrZero(handshakeTimeoutMillis, "handshakeTimeoutMillis");
    }

    public final void setWrapDataSize(int wrapDataSize) {
        this.wrapDataSize = wrapDataSize;
    }

    @Deprecated
    public long getCloseNotifyTimeoutMillis() {
        return getCloseNotifyFlushTimeoutMillis();
    }

    @Deprecated
    public void setCloseNotifyTimeout(long closeNotifyTimeout, TimeUnit unit) {
        setCloseNotifyFlushTimeout(closeNotifyTimeout, unit);
    }

    @Deprecated
    public void setCloseNotifyTimeoutMillis(long closeNotifyFlushTimeoutMillis) {
        setCloseNotifyFlushTimeoutMillis(closeNotifyFlushTimeoutMillis);
    }

    public final long getCloseNotifyFlushTimeoutMillis() {
        return this.closeNotifyFlushTimeoutMillis;
    }

    public final void setCloseNotifyFlushTimeout(long closeNotifyFlushTimeout, TimeUnit unit) {
        setCloseNotifyFlushTimeoutMillis(unit.toMillis(closeNotifyFlushTimeout));
    }

    public final void setCloseNotifyFlushTimeoutMillis(long closeNotifyFlushTimeoutMillis) {
        this.closeNotifyFlushTimeoutMillis = ObjectUtil.checkPositiveOrZero(closeNotifyFlushTimeoutMillis, "closeNotifyFlushTimeoutMillis");
    }

    public final long getCloseNotifyReadTimeoutMillis() {
        return this.closeNotifyReadTimeoutMillis;
    }

    public final void setCloseNotifyReadTimeout(long closeNotifyReadTimeout, TimeUnit unit) {
        setCloseNotifyReadTimeoutMillis(unit.toMillis(closeNotifyReadTimeout));
    }

    public final void setCloseNotifyReadTimeoutMillis(long closeNotifyReadTimeoutMillis) {
        this.closeNotifyReadTimeoutMillis = ObjectUtil.checkPositiveOrZero(closeNotifyReadTimeoutMillis, "closeNotifyReadTimeoutMillis");
    }

    public SSLEngine engine() {
        return this.engine;
    }

    public String applicationProtocol() {
        SSLEngine engine = engine();
        if (!(engine instanceof ApplicationProtocolAccessor)) {
            return null;
        }
        return ((ApplicationProtocolAccessor) engine).getNegotiatedApplicationProtocol();
    }

    public Future<Channel> handshakeFuture() {
        return this.handshakePromise;
    }

    @Deprecated
    public ChannelFuture close() {
        return closeOutbound();
    }

    @Deprecated
    public ChannelFuture close(ChannelPromise promise) {
        return closeOutbound(promise);
    }

    public ChannelFuture closeOutbound() {
        return closeOutbound(this.ctx.newPromise());
    }

    public ChannelFuture closeOutbound(final ChannelPromise promise) {
        ChannelHandlerContext ctx = this.ctx;
        if (ctx.executor().inEventLoop()) {
            closeOutbound0(promise);
        } else {
            ctx.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    SslHandler.this.closeOutbound0(promise);
                }
            });
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void closeOutbound0(ChannelPromise promise) {
        setState(32);
        this.engine.closeOutbound();
        try {
            flush(this.ctx, promise);
        } catch (Exception e) {
            if (!promise.tryFailure(e)) {
                logger.warn("{} flush() raised a masked exception.", this.ctx.channel(), e);
            }
        }
    }

    public Future<Channel> sslCloseFuture() {
        return this.sslClosePromise;
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext ctx) throws Exception {
        try {
            if (this.pendingUnencryptedWrites != null && !this.pendingUnencryptedWrites.isEmpty()) {
                this.pendingUnencryptedWrites.releaseAndFailAll(ctx, new ChannelException("Pending write on removal of SslHandler"));
            }
            this.pendingUnencryptedWrites = null;
            SSLException cause = null;
            if (!this.handshakePromise.isDone()) {
                cause = new SSLHandshakeException("SslHandler removed before handshake completed");
                if (this.handshakePromise.tryFailure(cause)) {
                    ctx.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(cause));
                }
            }
            if (!this.sslClosePromise.isDone()) {
                if (cause == null) {
                    cause = new SSLException("SslHandler removed before SSLEngine was closed");
                }
                notifyClosePromise(cause);
            }
        } finally {
            ReferenceCountUtil.release(this.engine);
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.bind(localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.connect(remoteAddress, localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.deregister(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        closeOutboundAndChannel(ctx, promise, true);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        closeOutboundAndChannel(ctx, promise, false);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext ctx) throws Exception {
        if (!this.handshakePromise.isDone()) {
            setState(4);
        }
        ctx.read();
    }

    private static IllegalStateException newPendingWritesNullException() {
        return new IllegalStateException("pendingUnencryptedWrites is null, handlerRemoved0 called?");
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (!(msg instanceof ByteBuf)) {
            UnsupportedMessageTypeException exception = new UnsupportedMessageTypeException(msg, ByteBuf.class);
            ReferenceCountUtil.safeRelease(msg);
            promise.setFailure((Throwable) exception);
        } else if (this.pendingUnencryptedWrites == null) {
            ReferenceCountUtil.safeRelease(msg);
            promise.setFailure((Throwable) newPendingWritesNullException());
        } else {
            this.pendingUnencryptedWrites.add((ByteBuf) msg, promise);
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext ctx) throws Exception {
        if (this.startTls && !isStateSet(1)) {
            setState(1);
            this.pendingUnencryptedWrites.writeAndRemoveAll(ctx);
            forceFlush(ctx);
            startHandshakeProcessing(true);
        } else if (!isStateSet(128)) {
            try {
                wrapAndFlush(ctx);
            } catch (Throwable cause) {
                setHandshakeFailure(ctx, cause);
                PlatformDependent.throwException(cause);
            }
        }
    }

    private void wrapAndFlush(ChannelHandlerContext ctx) throws SSLException {
        if (this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.add(Unpooled.EMPTY_BUFFER, ctx.newPromise());
        }
        if (!this.handshakePromise.isDone()) {
            setState(2);
        }
        try {
            wrap(ctx, false);
        } finally {
            forceFlush(ctx);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01e3 A[ORIG_RETURN, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void wrap(p013io.netty.channel.ChannelHandlerContext r7, boolean r8) throws javax.net.ssl.SSLException {
        /*
        // Method dump skipped, instructions count: 484
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.SslHandler.wrap(io.netty.channel.ChannelHandlerContext, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.SslHandler$11 */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandler$11.class */
    public static /* synthetic */ class C304911 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = new int[SSLEngineResult.HandshakeStatus.values().length];

        static {
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0178 A[ORIG_RETURN, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean wrapNonAppData(final p013io.netty.channel.ChannelHandlerContext r7, boolean r8) throws javax.net.ssl.SSLException {
        /*
        // Method dump skipped, instructions count: 378
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.SslHandler.wrapNonAppData(io.netty.channel.ChannelHandlerContext, boolean):boolean");
    }

    private SSLEngineResult wrap(ByteBufAllocator alloc, SSLEngine engine, ByteBuf in, ByteBuf out) throws SSLException {
        ByteBuffer[] in0;
        SSLEngineResult result;
        ByteBuf newDirectIn = null;
        try {
            int readerIndex = in.readerIndex();
            int readableBytes = in.readableBytes();
            if (!in.isDirect() && this.engineType.wantsDirectBuffer) {
                newDirectIn = alloc.directBuffer(readableBytes);
                newDirectIn.writeBytes(in, readerIndex, readableBytes);
                in0 = this.singleBuffer;
                in0[0] = newDirectIn.internalNioBuffer(newDirectIn.readerIndex(), readableBytes);
            } else if ((in instanceof CompositeByteBuf) || in.nioBufferCount() != 1) {
                in0 = in.nioBuffers();
            } else {
                in0 = this.singleBuffer;
                in0[0] = in.internalNioBuffer(readerIndex, readableBytes);
            }
            while (true) {
                result = engine.wrap(in0, out.nioBuffer(out.writerIndex(), out.writableBytes()));
                in.skipBytes(result.bytesConsumed());
                out.writerIndex(out.writerIndex() + result.bytesProduced());
                if (result.getStatus() != SSLEngineResult.Status.BUFFER_OVERFLOW) {
                    break;
                }
                out.ensureWritable(engine.getSession().getPacketBufferSize());
            }
            return result;
        } finally {
            this.singleBuffer[0] = null;
            if (newDirectIn != null) {
                newDirectIn.release();
            }
        }
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder, p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        boolean handshakeFailed = this.handshakePromise.cause() != null;
        ClosedChannelException exception = new ClosedChannelException();
        setHandshakeFailure(ctx, exception, !isStateSet(32), isStateSet(8), false);
        notifyClosePromise(exception);
        try {
            channelInactive(ctx);
        } catch (DecoderException e) {
            if (!handshakeFailed || !(e.getCause() instanceof SSLException)) {
                throw e;
            }
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (ignoreException(cause)) {
            if (logger.isDebugEnabled()) {
                logger.debug("{} Swallowing a harmless 'connection reset by peer / broken pipe' error that occurred while writing close_notify in response to the peer's close_notify", ctx.channel(), cause);
            }
            if (ctx.channel().isActive()) {
                ctx.close();
                return;
            }
            return;
        }
        ctx.fireExceptionCaught(cause);
    }

    private boolean ignoreException(Throwable t) {
        if ((t instanceof SSLException) || !(t instanceof IOException) || !this.sslClosePromise.isDone()) {
            return false;
        }
        String message = t.getMessage();
        if (message != null && IGNORABLE_ERROR_MESSAGE.matcher(message).matches()) {
            return true;
        }
        StackTraceElement[] elements = t.getStackTrace();
        for (StackTraceElement element : elements) {
            String classname = element.getClassName();
            String methodname = element.getMethodName();
            if (!classname.startsWith("io.netty.") && "read".equals(methodname)) {
                if (IGNORABLE_CLASS_IN_STACK.matcher(classname).matches()) {
                    return true;
                }
                try {
                    Class<?> clazz = PlatformDependent.getClassLoader(getClass()).loadClass(classname);
                    if (SocketChannel.class.isAssignableFrom(clazz) || DatagramChannel.class.isAssignableFrom(clazz)) {
                        return true;
                    }
                    if (PlatformDependent.javaVersion() >= 7 && "com.sun.nio.sctp.SctpChannel".equals(clazz.getSuperclass().getName())) {
                        return true;
                    }
                } catch (Throwable cause) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Unexpected exception while loading class {} classname {}", getClass(), classname, cause);
                    }
                }
            }
        }
        return false;
    }

    public static boolean isEncrypted(ByteBuf buffer) {
        if (buffer.readableBytes() >= 5) {
            return SslUtils.getEncryptedPacketLength(buffer, buffer.readerIndex()) != -2;
        }
        throw new IllegalArgumentException("buffer must have at least 5 readable bytes");
    }

    private void decodeJdkCompatible(ChannelHandlerContext ctx, ByteBuf in) throws NotSslRecordException {
        int packetLength = this.packetLength;
        if (packetLength <= 0) {
            int readableBytes = in.readableBytes();
            if (readableBytes >= 5) {
                packetLength = SslUtils.getEncryptedPacketLength(in, in.readerIndex());
                if (packetLength == -2) {
                    NotSslRecordException e = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(in));
                    in.skipBytes(in.readableBytes());
                    setHandshakeFailure(ctx, e);
                    throw e;
                } else if (!$assertionsDisabled && packetLength <= 0) {
                    throw new AssertionError();
                } else if (packetLength > readableBytes) {
                    this.packetLength = packetLength;
                    return;
                }
            } else {
                return;
            }
        } else if (in.readableBytes() < packetLength) {
            return;
        }
        this.packetLength = 0;
        try {
            int bytesConsumed = unwrap(ctx, in, packetLength);
            if (!$assertionsDisabled && bytesConsumed != packetLength && !this.engine.isInboundDone()) {
                throw new AssertionError("we feed the SSLEngine a packets worth of data: " + packetLength + " but it only consumed: " + bytesConsumed);
            }
        } catch (Throwable cause) {
            handleUnwrapThrowable(ctx, cause);
        }
    }

    private void decodeNonJdkCompatible(ChannelHandlerContext ctx, ByteBuf in) {
        try {
            unwrap(ctx, in, in.readableBytes());
        } catch (Throwable cause) {
            handleUnwrapThrowable(ctx, cause);
        }
    }

    /* access modifiers changed from: private */
    public void handleUnwrapThrowable(ChannelHandlerContext ctx, Throwable cause) {
        try {
            try {
                if (this.handshakePromise.tryFailure(cause)) {
                    ctx.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(cause));
                }
                if (this.pendingUnencryptedWrites != null) {
                    wrapAndFlush(ctx);
                }
            } catch (SSLException ex) {
                logger.debug("SSLException during trying to call SSLEngine.wrap(...) because of an previous SSLException, ignoring...", (Throwable) ex);
                setHandshakeFailure(ctx, cause, true, false, true);
            }
            PlatformDependent.throwException(cause);
        } finally {
            setHandshakeFailure(ctx, cause, true, false, true);
        }
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws SSLException {
        if (!isStateSet(128)) {
            if (this.jdkCompatibilityMode) {
                decodeJdkCompatible(ctx, in);
            } else {
                decodeNonJdkCompatible(ctx, in);
            }
        }
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder, p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        channelReadComplete0(ctx);
    }

    /* access modifiers changed from: private */
    public void channelReadComplete0(ChannelHandlerContext ctx) {
        discardSomeReadBytes();
        flushIfNeeded(ctx);
        readIfNeeded(ctx);
        clearState(256);
        ctx.fireChannelReadComplete();
    }

    private void readIfNeeded(ChannelHandlerContext ctx) {
        if (ctx.channel().config().isAutoRead()) {
            return;
        }
        if (!isStateSet(256) || !this.handshakePromise.isDone()) {
            ctx.read();
        }
    }

    private void flushIfNeeded(ChannelHandlerContext ctx) {
        if (isStateSet(16)) {
            forceFlush(ctx);
        }
    }

    /* access modifiers changed from: private */
    public int unwrapNonAppData(ChannelHandlerContext ctx) throws SSLException {
        return unwrap(ctx, Unpooled.EMPTY_BUFFER, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0072, code lost:
        if (setHandshakeSuccess() == false) goto L_0x0075;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x018a A[EDGE_INSN: B:105:0x018a->B:72:0x018a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int unwrap(p013io.netty.channel.ChannelHandlerContext r8, p013io.netty.buffer.ByteBuf r9, int r10) throws javax.net.ssl.SSLException {
        /*
        // Method dump skipped, instructions count: 514
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.SslHandler.unwrap(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, int):int");
    }

    private boolean setHandshakeSuccessUnwrapMarkReentry() {
        boolean setReentryState = !isStateSet(512);
        if (setReentryState) {
            setState(512);
        }
        try {
            boolean handshakeSuccess = setHandshakeSuccess();
            if (setReentryState) {
                clearState(512);
            }
            return handshakeSuccess;
        } catch (Throwable th) {
            if (setReentryState) {
                clearState(512);
            }
            throw th;
        }
    }

    private void executeNotifyClosePromise(ChannelHandlerContext ctx) {
        try {
            ctx.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    SslHandler.this.notifyClosePromise(null);
                }
            });
        } catch (RejectedExecutionException e) {
            notifyClosePromise(e);
        }
    }

    private void executeChannelRead(final ChannelHandlerContext ctx, final ByteBuf decodedOut) {
        try {
            ctx.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    ctx.fireChannelRead((Object) decodedOut);
                }
            });
        } catch (RejectedExecutionException e) {
            decodedOut.release();
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public static ByteBuffer toByteBuffer(ByteBuf out, int index, int len) {
        return out.nioBufferCount() == 1 ? out.internalNioBuffer(index, len) : out.nioBuffer(index, len);
    }

    private static boolean inEventLoop(Executor executor) {
        return (executor instanceof EventExecutor) && ((EventExecutor) executor).inEventLoop();
    }

    private boolean runDelegatedTasks(boolean inUnwrap) {
        if (this.delegatedTaskExecutor == ImmediateExecutor.INSTANCE || inEventLoop(this.delegatedTaskExecutor)) {
            while (true) {
                Runnable task = this.engine.getDelegatedTask();
                if (task == null) {
                    return true;
                }
                setState(128);
                if (task instanceof AsyncRunnable) {
                    boolean pending = false;
                    try {
                        AsyncRunnable asyncTask = (AsyncRunnable) task;
                        AsyncTaskCompletionHandler completionHandler = new AsyncTaskCompletionHandler(inUnwrap);
                        asyncTask.run(completionHandler);
                        pending = completionHandler.resumeLater();
                        if (pending) {
                            return false;
                        }
                        if (!pending) {
                        }
                    } finally {
                        if (!pending) {
                            clearState(128);
                        }
                    }
                } else {
                    try {
                        task.run();
                        clearState(128);
                    } finally {
                        clearState(128);
                    }
                }
            }
        } else {
            executeDelegatedTask(inUnwrap);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public SslTasksRunner getTaskRunner(boolean inUnwrap) {
        return inUnwrap ? this.sslTaskRunnerForUnwrap : this.sslTaskRunner;
    }

    private void executeDelegatedTask(boolean inUnwrap) {
        executeDelegatedTask(getTaskRunner(inUnwrap));
    }

    /* access modifiers changed from: private */
    public void executeDelegatedTask(SslTasksRunner task) {
        setState(128);
        try {
            this.delegatedTaskExecutor.execute(task);
        } catch (RejectedExecutionException e) {
            clearState(128);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.SslHandler$AsyncTaskCompletionHandler */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandler$AsyncTaskCompletionHandler.class */
    public final class AsyncTaskCompletionHandler implements Runnable {
        private final boolean inUnwrap;
        boolean didRun;
        boolean resumeLater;

        AsyncTaskCompletionHandler(boolean inUnwrap) {
            this.inUnwrap = inUnwrap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.didRun = true;
            if (this.resumeLater) {
                SslHandler.this.getTaskRunner(this.inUnwrap).runComplete();
            }
        }

        boolean resumeLater() {
            if (this.didRun) {
                return false;
            }
            this.resumeLater = true;
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.SslHandler$SslTasksRunner */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandler$SslTasksRunner.class */
    public final class SslTasksRunner implements Runnable {
        private final boolean inUnwrap;
        private final Runnable runCompleteTask = new Runnable() { // from class: io.netty.handler.ssl.SslHandler.SslTasksRunner.1
            @Override // java.lang.Runnable
            public void run() {
                SslTasksRunner.this.runComplete();
            }
        };
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !SslHandler.class.desiredAssertionStatus();
        }

        SslTasksRunner(boolean inUnwrap) {
            this.inUnwrap = inUnwrap;
        }

        private void taskError(Throwable e) {
            if (this.inUnwrap) {
                try {
                    SslHandler.this.handleUnwrapThrowable(SslHandler.this.ctx, e);
                } catch (Throwable cause) {
                    safeExceptionCaught(cause);
                }
            } else {
                SslHandler.this.setHandshakeFailure(SslHandler.this.ctx, e);
                SslHandler.this.forceFlush(SslHandler.this.ctx);
            }
        }

        /* access modifiers changed from: private */
        public void safeExceptionCaught(Throwable cause) {
            try {
                SslHandler.this.exceptionCaught(SslHandler.this.ctx, wrapIfNeeded(cause));
            } catch (Throwable error) {
                SslHandler.this.ctx.fireExceptionCaught(error);
            }
        }

        private Throwable wrapIfNeeded(Throwable cause) {
            if (!this.inUnwrap) {
                return cause;
            }
            return cause instanceof DecoderException ? cause : new DecoderException(cause);
        }

        private void tryDecodeAgain() {
            try {
                SslHandler.this.channelRead(SslHandler.this.ctx, Unpooled.EMPTY_BUFFER);
            } finally {
                SslHandler.this.channelReadComplete0(SslHandler.this.ctx);
            }
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0088
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        public void resumeOnEventExecutor() {
            /*
            // Method dump skipped, instructions count: 317
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.SslHandler.SslTasksRunner.resumeOnEventExecutor():void");
        }

        void runComplete() {
            SslHandler.this.ctx.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.SslTasksRunner.2
                @Override // java.lang.Runnable
                public void run() {
                    SslTasksRunner.this.resumeOnEventExecutor();
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable task = SslHandler.this.engine.getDelegatedTask();
                if (task != null) {
                    if (task instanceof AsyncRunnable) {
                        ((AsyncRunnable) task).run(this.runCompleteTask);
                    } else {
                        task.run();
                        runComplete();
                    }
                }
            } catch (Throwable cause) {
                handleException(cause);
            }
        }

        private void handleException(final Throwable cause) {
            EventExecutor executor = SslHandler.this.ctx.executor();
            if (executor.inEventLoop()) {
                SslHandler.this.clearState(128);
                safeExceptionCaught(cause);
                return;
            }
            try {
                executor.execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.SslTasksRunner.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SslHandler.this.clearState(128);
                        SslTasksRunner.this.safeExceptionCaught(cause);
                    }
                });
            } catch (RejectedExecutionException e) {
                SslHandler.this.clearState(128);
                SslHandler.this.ctx.fireExceptionCaught(cause);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean setHandshakeSuccess() {
        boolean notified = !this.handshakePromise.isDone() && this.handshakePromise.trySuccess(this.ctx.channel());
        if (notified) {
            if (logger.isDebugEnabled()) {
                SSLSession session = this.engine.getSession();
                logger.debug("{} HANDSHAKEN: protocol:{} cipher suite:{}", this.ctx.channel(), session.getProtocol(), session.getCipherSuite());
            }
            this.ctx.fireUserEventTriggered((Object) SslHandshakeCompletionEvent.SUCCESS);
        }
        if (isStateSet(4)) {
            clearState(4);
            if (!this.ctx.channel().config().isAutoRead()) {
                this.ctx.read();
            }
        }
        return notified;
    }

    /* access modifiers changed from: private */
    public void setHandshakeFailure(ChannelHandlerContext ctx, Throwable cause) {
        setHandshakeFailure(ctx, cause, true, true, false);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x001b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void setHandshakeFailure(p013io.netty.channel.ChannelHandlerContext r6, java.lang.Throwable r7, boolean r8, boolean r9, boolean r10) {
        /*
            r5 = this;
            r0 = r5
            r1 = 32
            r0.setState(r1)     // Catch: all -> 0x007f
            r0 = r5
            javax.net.ssl.SSLEngine r0 = r0.engine     // Catch: all -> 0x007f
            r0.closeOutbound()     // Catch: all -> 0x007f
            r0 = r8
            if (r0 == 0) goto L_0x005d
            r0 = r5
            javax.net.ssl.SSLEngine r0 = r0.engine     // Catch: SSLException -> 0x001b, all -> 0x007f
            r0.closeInbound()     // Catch: SSLException -> 0x001b, all -> 0x007f
            goto L_0x005d
        L_0x001b:
            r11 = move-exception
            io.netty.util.internal.logging.InternalLogger r0 = p013io.netty.handler.ssl.SslHandler.logger     // Catch: all -> 0x007f
            boolean r0 = r0.isDebugEnabled()     // Catch: all -> 0x007f
            if (r0 == 0) goto L_0x005d
            r0 = r11
            java.lang.String r0 = r0.getMessage()     // Catch: all -> 0x007f
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L_0x004a
            r0 = r12
            java.lang.String r1 = "possible truncation attack"
            boolean r0 = r0.contains(r1)     // Catch: all -> 0x007f
            if (r0 != 0) goto L_0x005d
            r0 = r12
            java.lang.String r1 = "closing inbound before receiving peer's close_notify"
            boolean r0 = r0.contains(r1)     // Catch: all -> 0x007f
            if (r0 != 0) goto L_0x005d
        L_0x004a:
            io.netty.util.internal.logging.InternalLogger r0 = p013io.netty.handler.ssl.SslHandler.logger     // Catch: all -> 0x007f
            java.lang.String r1 = "{} SSLEngine.closeInbound() raised an exception."
            r2 = r6
            io.netty.channel.Channel r2 = r2.channel()     // Catch: all -> 0x007f
            r3 = r11
            r0.debug(r1, r2, r3)     // Catch: all -> 0x007f
        L_0x005d:
            r0 = r5
            io.netty.util.concurrent.Promise<io.netty.channel.Channel> r0 = r0.handshakePromise     // Catch: all -> 0x007f
            r1 = r7
            boolean r0 = r0.tryFailure(r1)     // Catch: all -> 0x007f
            if (r0 != 0) goto L_0x006f
            r0 = r10
            if (r0 == 0) goto L_0x0076
        L_0x006f:
            r0 = r6
            r1 = r7
            r2 = r9
            p013io.netty.handler.ssl.SslUtils.handleHandshakeFailure(r0, r1, r2)     // Catch: all -> 0x007f
        L_0x0076:
            r0 = r5
            r1 = r6
            r2 = r7
            r0.releaseAndFailAll(r1, r2)
            goto L_0x008a
        L_0x007f:
            r13 = move-exception
            r0 = r5
            r1 = r6
            r2 = r7
            r0.releaseAndFailAll(r1, r2)
            r0 = r13
            throw r0
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.SslHandler.setHandshakeFailure(io.netty.channel.ChannelHandlerContext, java.lang.Throwable, boolean, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    public void setHandshakeFailureTransportFailure(ChannelHandlerContext ctx, Throwable cause) {
        try {
            SSLException transportFailure = new SSLException("failure when writing TLS control frames", cause);
            releaseAndFailAll(ctx, transportFailure);
            if (this.handshakePromise.tryFailure(transportFailure)) {
                ctx.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(transportFailure));
            }
        } finally {
            ctx.close();
        }
    }

    /* access modifiers changed from: private */
    public void releaseAndFailAll(ChannelHandlerContext ctx, Throwable cause) {
        if (this.pendingUnencryptedWrites != null) {
            this.pendingUnencryptedWrites.releaseAndFailAll(ctx, cause);
        }
    }

    /* access modifiers changed from: private */
    public void notifyClosePromise(Throwable cause) {
        if (cause == null) {
            if (this.sslClosePromise.trySuccess(this.ctx.channel())) {
                this.ctx.fireUserEventTriggered((Object) SslCloseCompletionEvent.SUCCESS);
            }
        } else if (this.sslClosePromise.tryFailure(cause)) {
            this.ctx.fireUserEventTriggered((Object) new SslCloseCompletionEvent(cause));
        }
    }

    private void closeOutboundAndChannel(ChannelHandlerContext ctx, final ChannelPromise promise, boolean disconnect) throws Exception {
        setState(32);
        this.engine.closeOutbound();
        if (ctx.channel().isActive()) {
            ChannelPromise closeNotifyPromise = ctx.newPromise();
            try {
                flush(ctx, closeNotifyPromise);
                if (!isStateSet(64)) {
                    setState(64);
                    safeClose(ctx, closeNotifyPromise, (ChannelPromise) PromiseNotifier.cascade(false, ctx.newPromise(), promise));
                    return;
                }
                this.sslClosePromise.addListener((GenericFutureListener) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.5
                    @Override // p013io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Channel> future) {
                        promise.setSuccess();
                    }
                });
            } catch (Throwable th) {
                if (!isStateSet(64)) {
                    setState(64);
                    safeClose(ctx, closeNotifyPromise, (ChannelPromise) PromiseNotifier.cascade(false, ctx.newPromise(), promise));
                } else {
                    this.sslClosePromise.addListener((GenericFutureListener) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.5
                        @Override // p013io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future<Channel> future) {
                            promise.setSuccess();
                        }
                    });
                }
                throw th;
            }
        } else if (disconnect) {
            ctx.disconnect(promise);
        } else {
            ctx.close(promise);
        }
    }

    private void flush(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        if (this.pendingUnencryptedWrites != null) {
            this.pendingUnencryptedWrites.add(Unpooled.EMPTY_BUFFER, promise);
        } else {
            promise.setFailure((Throwable) newPendingWritesNullException());
        }
        flush(ctx);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
        Channel channel = ctx.channel();
        this.pendingUnencryptedWrites = new SslHandlerCoalescingBufferQueue(channel, 16);
        setOpensslEngineSocketFd(channel);
        boolean fastOpen = Boolean.TRUE.equals(channel.config().getOption(ChannelOption.TCP_FASTOPEN_CONNECT));
        boolean active = channel.isActive();
        if (active || fastOpen) {
            startHandshakeProcessing(active);
            if (fastOpen) {
                ChannelOutboundBuffer outboundBuffer = channel.unsafe().outboundBuffer();
                if (outboundBuffer == null || outboundBuffer.totalPendingWriteBytes() > 0) {
                    setState(16);
                }
            }
        }
    }

    private void startHandshakeProcessing(boolean flushAtEnd) {
        if (!isStateSet(8)) {
            setState(8);
            if (this.engine.getUseClientMode()) {
                handshake(flushAtEnd);
            }
            applyHandshakeTimeout();
        } else if (isStateSet(16)) {
            forceFlush(this.ctx);
        }
    }

    public Future<Channel> renegotiate() {
        ChannelHandlerContext ctx = this.ctx;
        if (ctx != null) {
            return renegotiate(ctx.executor().newPromise());
        }
        throw new IllegalStateException();
    }

    public Future<Channel> renegotiate(final Promise<Channel> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        ChannelHandlerContext ctx = this.ctx;
        if (ctx == null) {
            throw new IllegalStateException();
        }
        EventExecutor executor = ctx.executor();
        if (!executor.inEventLoop()) {
            executor.execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.6
                @Override // java.lang.Runnable
                public void run() {
                    SslHandler.this.renegotiateOnEventLoop(promise);
                }
            });
            return promise;
        }
        renegotiateOnEventLoop(promise);
        return promise;
    }

    /* access modifiers changed from: private */
    public void renegotiateOnEventLoop(Promise<Channel> newHandshakePromise) {
        Promise<Channel> oldHandshakePromise = this.handshakePromise;
        if (!oldHandshakePromise.isDone()) {
            PromiseNotifier.cascade(oldHandshakePromise, newHandshakePromise);
            return;
        }
        this.handshakePromise = newHandshakePromise;
        handshake(true);
        applyHandshakeTimeout();
    }

    private void handshake(boolean flushAtEnd) {
        if (this.engine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING && !this.handshakePromise.isDone()) {
            ChannelHandlerContext ctx = this.ctx;
            try {
                this.engine.beginHandshake();
                wrapNonAppData(ctx, false);
                if (flushAtEnd) {
                    forceFlush(ctx);
                }
            } catch (Throwable th) {
                if (flushAtEnd) {
                    forceFlush(ctx);
                }
                throw th;
            }
        }
    }

    private void applyHandshakeTimeout() {
        final Promise<Channel> localHandshakePromise = this.handshakePromise;
        final long handshakeTimeoutMillis = this.handshakeTimeoutMillis;
        if (handshakeTimeoutMillis > 0 && !localHandshakePromise.isDone()) {
            final Future<?> timeoutFuture = this.ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.ssl.SslHandler.7
                @Override // java.lang.Runnable
                public void run() {
                    if (!localHandshakePromise.isDone()) {
                        SSLException exception = new SslHandshakeTimeoutException("handshake timed out after " + handshakeTimeoutMillis + "ms");
                        try {
                            if (localHandshakePromise.tryFailure(exception)) {
                                SslUtils.handleHandshakeFailure(SslHandler.this.ctx, exception, true);
                            }
                        } finally {
                            SslHandler.this.releaseAndFailAll(SslHandler.this.ctx, exception);
                        }
                    }
                }
            }, handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
            localHandshakePromise.addListener((GenericFutureListener<? extends Future<? super Channel>>) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.8
                @Override // p013io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<Channel> f) throws Exception {
                    timeoutFuture.cancel(false);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void forceFlush(ChannelHandlerContext ctx) {
        clearState(16);
        ctx.flush();
    }

    private void setOpensslEngineSocketFd(Channel c) {
        if ((c instanceof UnixChannel) && (this.engine instanceof ReferenceCountedOpenSslEngine)) {
            ((ReferenceCountedOpenSslEngine) this.engine).bioSetFd(((UnixChannel) c).mo1175fd().intValue());
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        setOpensslEngineSocketFd(ctx.channel());
        if (!this.startTls) {
            startHandshakeProcessing(true);
        }
        ctx.fireChannelActive();
    }

    private void safeClose(final ChannelHandlerContext ctx, final ChannelFuture flushFuture, final ChannelPromise promise) {
        final Future<?> timeoutFuture;
        if (!ctx.channel().isActive()) {
            ctx.close(promise);
            return;
        }
        if (!flushFuture.isDone()) {
            long closeNotifyTimeout = this.closeNotifyFlushTimeoutMillis;
            if (closeNotifyTimeout > 0) {
                timeoutFuture = ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.ssl.SslHandler.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!flushFuture.isDone()) {
                            SslHandler.logger.warn("{} Last write attempt timed out; force-closing the connection.", ctx.channel());
                            SslHandler.addCloseListener(ctx.close(ctx.newPromise()), promise);
                        }
                    }
                }, closeNotifyTimeout, TimeUnit.MILLISECONDS);
            } else {
                timeoutFuture = null;
            }
        } else {
            timeoutFuture = null;
        }
        flushFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.ssl.SslHandler.10
            public void operationComplete(ChannelFuture f) {
                final Future<?> closeNotifyReadTimeoutFuture;
                if (timeoutFuture != null) {
                    timeoutFuture.cancel(false);
                }
                final long closeNotifyReadTimeout = SslHandler.this.closeNotifyReadTimeoutMillis;
                if (closeNotifyReadTimeout <= 0) {
                    SslHandler.addCloseListener(ctx.close(ctx.newPromise()), promise);
                    return;
                }
                if (!SslHandler.this.sslClosePromise.isDone()) {
                    closeNotifyReadTimeoutFuture = ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.ssl.SslHandler.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!SslHandler.this.sslClosePromise.isDone()) {
                                SslHandler.logger.debug("{} did not receive close_notify in {}ms; force-closing the connection.", ctx.channel(), Long.valueOf(closeNotifyReadTimeout));
                                SslHandler.addCloseListener(ctx.close(ctx.newPromise()), promise);
                            }
                        }
                    }, closeNotifyReadTimeout, TimeUnit.MILLISECONDS);
                } else {
                    closeNotifyReadTimeoutFuture = null;
                }
                SslHandler.this.sslClosePromise.addListener((GenericFutureListener) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.10.2
                    @Override // p013io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Channel> future) throws Exception {
                        if (closeNotifyReadTimeoutFuture != null) {
                            closeNotifyReadTimeoutFuture.cancel(false);
                        }
                        SslHandler.addCloseListener(ctx.close(ctx.newPromise()), promise);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public static void addCloseListener(ChannelFuture future, ChannelPromise promise) {
        PromiseNotifier.cascade(false, future, promise);
    }

    private ByteBuf allocate(ChannelHandlerContext ctx, int capacity) {
        ByteBufAllocator alloc = ctx.alloc();
        if (this.engineType.wantsDirectBuffer) {
            return alloc.directBuffer(capacity);
        }
        return alloc.buffer(capacity);
    }

    private ByteBuf allocateOutNetBuf(ChannelHandlerContext ctx, int pendingBytes, int numComponents) {
        return this.engineType.allocateWrapBuffer(this, ctx.alloc(), pendingBytes, numComponents);
    }

    private boolean isStateSet(int bit) {
        return (this.state & bit) == bit;
    }

    private void setState(int bit) {
        this.state = (short) (this.state | bit);
    }

    /* access modifiers changed from: private */
    public void clearState(int bit) {
        this.state = (short) (this.state & (bit ^ -1));
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.SslHandler$SslHandlerCoalescingBufferQueue */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandler$SslHandlerCoalescingBufferQueue.class */
    public final class SslHandlerCoalescingBufferQueue extends AbstractCoalescingBufferQueue {
        SslHandlerCoalescingBufferQueue(Channel channel, int initSize) {
            super(channel, initSize);
        }

        @Override // p013io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf compose(ByteBufAllocator alloc, ByteBuf cumulation, ByteBuf next) {
            int wrapDataSize = SslHandler.this.wrapDataSize;
            if (!(cumulation instanceof CompositeByteBuf)) {
                return SslHandler.attemptCopyToCumulation(cumulation, next, wrapDataSize) ? cumulation : copyAndCompose(alloc, cumulation, next);
            }
            CompositeByteBuf composite = (CompositeByteBuf) cumulation;
            int numComponents = composite.numComponents();
            if (numComponents == 0 || !SslHandler.attemptCopyToCumulation(composite.internalComponent(numComponents - 1), next, wrapDataSize)) {
                composite.addComponent(true, next);
            }
            return composite;
        }

        @Override // p013io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf composeFirst(ByteBufAllocator allocator, ByteBuf first) {
            if (first instanceof CompositeByteBuf) {
                CompositeByteBuf composite = (CompositeByteBuf) first;
                if (SslHandler.this.engineType.wantsDirectBuffer) {
                    first = allocator.directBuffer(composite.readableBytes());
                } else {
                    first = allocator.heapBuffer(composite.readableBytes());
                }
                try {
                    first.writeBytes(composite);
                } catch (Throwable cause) {
                    first.release();
                    PlatformDependent.throwException(cause);
                }
                composite.release();
            }
            return first;
        }

        @Override // p013io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf removeEmptyValue() {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static boolean attemptCopyToCumulation(ByteBuf cumulation, ByteBuf next, int wrapDataSize) {
        int inReadableBytes = next.readableBytes();
        int cumulationCapacity = cumulation.capacity();
        if (wrapDataSize - cumulation.readableBytes() < inReadableBytes) {
            return false;
        }
        if ((!cumulation.isWritable(inReadableBytes) || cumulationCapacity < wrapDataSize) && (cumulationCapacity >= wrapDataSize || !ByteBufUtil.ensureWritableSuccess(cumulation.ensureWritable(inReadableBytes, false)))) {
            return false;
        }
        cumulation.writeBytes(next);
        next.release();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.SslHandler$LazyChannelPromise */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SslHandler$LazyChannelPromise.class */
    public final class LazyChannelPromise extends DefaultPromise<Channel> {
        private LazyChannelPromise() {
        }

        @Override // p013io.netty.util.concurrent.DefaultPromise
        protected EventExecutor executor() {
            if (SslHandler.this.ctx != null) {
                return SslHandler.this.ctx.executor();
            }
            throw new IllegalStateException();
        }

        @Override // p013io.netty.util.concurrent.DefaultPromise
        protected void checkDeadLock() {
            if (SslHandler.this.ctx != null) {
                checkDeadLock();
            }
        }
    }
}
