package p013io.netty.channel.embedded;

import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelId;
import p013io.netty.channel.ChannelInitializer;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultChannelConfig;
import p013io.netty.channel.DefaultChannelPipeline;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.RecyclableArrayList;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.embedded.EmbeddedChannel */
/* loaded from: grasscutter.jar:io/netty/channel/embedded/EmbeddedChannel.class */
public class EmbeddedChannel extends AbstractChannel {
    private static final SocketAddress LOCAL_ADDRESS;
    private static final SocketAddress REMOTE_ADDRESS;
    private static final ChannelHandler[] EMPTY_HANDLERS;
    private static final InternalLogger logger;
    private static final ChannelMetadata METADATA_NO_DISCONNECT;
    private static final ChannelMetadata METADATA_DISCONNECT;
    private final EmbeddedEventLoop loop;
    private final ChannelFutureListener recordExceptionListener;
    private final ChannelMetadata metadata;
    private final ChannelConfig config;
    private Queue<Object> inboundMessages;
    private Queue<Object> outboundMessages;
    private Throwable lastException;
    private State state;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.embedded.EmbeddedChannel$State */
    /* loaded from: grasscutter.jar:io/netty/channel/embedded/EmbeddedChannel$State.class */
    public enum State {
        OPEN,
        ACTIVE,
        CLOSED
    }

    static {
        $assertionsDisabled = !EmbeddedChannel.class.desiredAssertionStatus();
        LOCAL_ADDRESS = new EmbeddedSocketAddress();
        REMOTE_ADDRESS = new EmbeddedSocketAddress();
        EMPTY_HANDLERS = new ChannelHandler[0];
        logger = InternalLoggerFactory.getInstance(EmbeddedChannel.class);
        METADATA_NO_DISCONNECT = new ChannelMetadata(false);
        METADATA_DISCONNECT = new ChannelMetadata(true);
    }

    public EmbeddedChannel() {
        this(EMPTY_HANDLERS);
    }

    public EmbeddedChannel(ChannelId channelId) {
        this(channelId, EMPTY_HANDLERS);
    }

    public EmbeddedChannel(ChannelHandler... handlers) {
        this(EmbeddedChannelId.INSTANCE, handlers);
    }

    public EmbeddedChannel(boolean hasDisconnect, ChannelHandler... handlers) {
        this(EmbeddedChannelId.INSTANCE, hasDisconnect, handlers);
    }

    public EmbeddedChannel(boolean register, boolean hasDisconnect, ChannelHandler... handlers) {
        this(EmbeddedChannelId.INSTANCE, register, hasDisconnect, handlers);
    }

    public EmbeddedChannel(ChannelId channelId, ChannelHandler... handlers) {
        this(channelId, false, handlers);
    }

    public EmbeddedChannel(ChannelId channelId, boolean hasDisconnect, ChannelHandler... handlers) {
        this(channelId, true, hasDisconnect, handlers);
    }

    public EmbeddedChannel(ChannelId channelId, boolean register, boolean hasDisconnect, ChannelHandler... handlers) {
        this(null, channelId, register, hasDisconnect, handlers);
    }

    public EmbeddedChannel(Channel parent, ChannelId channelId, boolean register, boolean hasDisconnect, ChannelHandler... handlers) {
        super(parent, channelId);
        this.loop = new EmbeddedEventLoop();
        this.recordExceptionListener = new ChannelFutureListener() { // from class: io.netty.channel.embedded.EmbeddedChannel.1
            public void operationComplete(ChannelFuture future) throws Exception {
                EmbeddedChannel.this.recordException(future);
            }
        };
        this.metadata = metadata(hasDisconnect);
        this.config = new DefaultChannelConfig(this);
        setup(register, handlers);
    }

    public EmbeddedChannel(ChannelId channelId, boolean hasDisconnect, ChannelConfig config, ChannelHandler... handlers) {
        super(null, channelId);
        this.loop = new EmbeddedEventLoop();
        this.recordExceptionListener = new ChannelFutureListener() { // from class: io.netty.channel.embedded.EmbeddedChannel.1
            public void operationComplete(ChannelFuture future) throws Exception {
                EmbeddedChannel.this.recordException(future);
            }
        };
        this.metadata = metadata(hasDisconnect);
        this.config = (ChannelConfig) ObjectUtil.checkNotNull(config, "config");
        setup(true, handlers);
    }

    private static ChannelMetadata metadata(boolean hasDisconnect) {
        return hasDisconnect ? METADATA_DISCONNECT : METADATA_NO_DISCONNECT;
    }

    private void setup(boolean register, final ChannelHandler... handlers) {
        ObjectUtil.checkNotNull(handlers, "handlers");
        pipeline().addLast(new ChannelInitializer<Channel>() { // from class: io.netty.channel.embedded.EmbeddedChannel.2
            @Override // p013io.netty.channel.ChannelInitializer
            protected void initChannel(Channel ch) throws Exception {
                ChannelHandler h;
                ChannelPipeline pipeline = ch.pipeline();
                ChannelHandler[] channelHandlerArr = handlers;
                int length = channelHandlerArr.length;
                int i = 0;
                while (i < length && (h = channelHandlerArr[i]) != null) {
                    pipeline.addLast(h);
                    i++;
                }
            }
        });
        if (register) {
            ChannelFuture future = this.loop.register(this);
            if (!$assertionsDisabled && !future.isDone()) {
                throw new AssertionError();
            }
        }
    }

    public void register() throws Exception {
        ChannelFuture future = this.loop.register(this);
        if ($assertionsDisabled || future.isDone()) {
            Throwable cause = future.cause();
            if (cause != null) {
                PlatformDependent.throwException(cause);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final DefaultChannelPipeline newChannelPipeline() {
        return new EmbeddedChannelPipeline(this);
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return this.metadata;
    }

    @Override // p013io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return this.state != State.CLOSED;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public Queue<Object> inboundMessages() {
        if (this.inboundMessages == null) {
            this.inboundMessages = new ArrayDeque();
        }
        return this.inboundMessages;
    }

    @Deprecated
    public Queue<Object> lastInboundBuffer() {
        return inboundMessages();
    }

    public Queue<Object> outboundMessages() {
        if (this.outboundMessages == null) {
            this.outboundMessages = new ArrayDeque();
        }
        return this.outboundMessages;
    }

    @Deprecated
    public Queue<Object> lastOutboundBuffer() {
        return outboundMessages();
    }

    public <T> T readInbound() {
        T message = (T) poll(this.inboundMessages);
        if (message != null) {
            ReferenceCountUtil.touch(message, "Caller of readInbound() will handle the message from this point");
        }
        return message;
    }

    public <T> T readOutbound() {
        T message = (T) poll(this.outboundMessages);
        if (message != null) {
            ReferenceCountUtil.touch(message, "Caller of readOutbound() will handle the message from this point.");
        }
        return message;
    }

    public boolean writeInbound(Object... msgs) {
        ensureOpen();
        if (msgs.length == 0) {
            return isNotEmpty(this.inboundMessages);
        }
        ChannelPipeline p = pipeline();
        for (Object m : msgs) {
            p.fireChannelRead(m);
        }
        flushInbound(false, voidPromise());
        return isNotEmpty(this.inboundMessages);
    }

    public ChannelFuture writeOneInbound(Object msg) {
        return writeOneInbound(msg, newPromise());
    }

    public ChannelFuture writeOneInbound(Object msg, ChannelPromise promise) {
        if (checkOpen(true)) {
            pipeline().fireChannelRead(msg);
        }
        return checkException(promise);
    }

    public EmbeddedChannel flushInbound() {
        flushInbound(true, voidPromise());
        return this;
    }

    private ChannelFuture flushInbound(boolean recordException, ChannelPromise promise) {
        if (checkOpen(recordException)) {
            pipeline().fireChannelReadComplete();
            runPendingTasks();
        }
        return checkException(promise);
    }

    public boolean writeOutbound(Object... msgs) {
        Object m;
        ensureOpen();
        if (msgs.length == 0) {
            return isNotEmpty(this.outboundMessages);
        }
        RecyclableArrayList futures = RecyclableArrayList.newInstance(msgs.length);
        try {
            int length = msgs.length;
            int i = 0;
            while (i < length && (m = msgs[i]) != null) {
                futures.add(write(m));
                i++;
            }
            flushOutbound0();
            int size = futures.size();
            for (int i2 = 0; i2 < size; i2++) {
                ChannelFuture future = (ChannelFuture) futures.get(i2);
                if (future.isDone()) {
                    recordException(future);
                } else {
                    future.addListener((GenericFutureListener<? extends Future<? super Void>>) this.recordExceptionListener);
                }
            }
            checkException();
            boolean isNotEmpty = isNotEmpty(this.outboundMessages);
            futures.recycle();
            return isNotEmpty;
        } catch (Throwable th) {
            futures.recycle();
            throw th;
        }
    }

    public ChannelFuture writeOneOutbound(Object msg) {
        return writeOneOutbound(msg, newPromise());
    }

    public ChannelFuture writeOneOutbound(Object msg, ChannelPromise promise) {
        if (checkOpen(true)) {
            return write(msg, promise);
        }
        return checkException(promise);
    }

    public EmbeddedChannel flushOutbound() {
        if (checkOpen(true)) {
            flushOutbound0();
        }
        checkException(voidPromise());
        return this;
    }

    private void flushOutbound0() {
        runPendingTasks();
        flush();
    }

    public boolean finish() {
        return finish(false);
    }

    public boolean finishAndReleaseAll() {
        return finish(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean finish(boolean r3) {
        /*
            r2 = this;
            r0 = r2
            io.netty.channel.ChannelFuture r0 = r0.close()
            r0 = r2
            r0.checkException()     // Catch: all -> 0x0039
            r0 = r2
            java.util.Queue<java.lang.Object> r0 = r0.inboundMessages     // Catch: all -> 0x0039
            boolean r0 = isNotEmpty(r0)     // Catch: all -> 0x0039
            if (r0 != 0) goto L_0x001d
            r0 = r2
            java.util.Queue<java.lang.Object> r0 = r0.outboundMessages     // Catch: all -> 0x0039
            boolean r0 = isNotEmpty(r0)     // Catch: all -> 0x0039
            if (r0 == 0) goto L_0x0021
        L_0x001d:
            r0 = 1
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L_0x0037
            r0 = r2
            java.util.Queue<java.lang.Object> r0 = r0.inboundMessages
            boolean r0 = releaseAll(r0)
            r0 = r2
            java.util.Queue<java.lang.Object> r0 = r0.outboundMessages
            boolean r0 = releaseAll(r0)
        L_0x0037:
            r0 = r4
            return r0
        L_0x0039:
            r5 = move-exception
            r0 = r3
            if (r0 == 0) goto L_0x004e
            r0 = r2
            java.util.Queue<java.lang.Object> r0 = r0.inboundMessages
            boolean r0 = releaseAll(r0)
            r0 = r2
            java.util.Queue<java.lang.Object> r0 = r0.outboundMessages
            boolean r0 = releaseAll(r0)
        L_0x004e:
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.embedded.EmbeddedChannel.finish(boolean):boolean");
    }

    public boolean releaseInbound() {
        return releaseAll(this.inboundMessages);
    }

    public boolean releaseOutbound() {
        return releaseAll(this.outboundMessages);
    }

    private static boolean releaseAll(Queue<Object> queue) {
        if (!isNotEmpty(queue)) {
            return false;
        }
        while (true) {
            Object msg = queue.poll();
            if (msg == null) {
                return true;
            }
            ReferenceCountUtil.release(msg);
        }
    }

    private void finishPendingTasks(boolean cancel) {
        runPendingTasks();
        if (cancel) {
            embeddedEventLoop().cancelScheduledTasks();
        }
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close() {
        return close(newPromise());
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close(ChannelPromise promise) {
        runPendingTasks();
        ChannelFuture future = close(promise);
        finishPendingTasks(true);
        return future;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect(ChannelPromise promise) {
        ChannelFuture future = disconnect(promise);
        finishPendingTasks(!this.metadata.hasDisconnect());
        return future;
    }

    private static boolean isNotEmpty(Queue<Object> queue) {
        return queue != null && !queue.isEmpty();
    }

    private static Object poll(Queue<Object> queue) {
        if (queue != null) {
            return queue.poll();
        }
        return null;
    }

    public void runPendingTasks() {
        try {
            embeddedEventLoop().runTasks();
        } catch (Exception e) {
            recordException(e);
        }
        try {
            embeddedEventLoop().runScheduledTasks();
        } catch (Exception e2) {
            recordException(e2);
        }
    }

    public boolean hasPendingTasks() {
        return embeddedEventLoop().hasPendingNormalTasks() || embeddedEventLoop().nextScheduledTask() == 0;
    }

    public long runScheduledPendingTasks() {
        try {
            return embeddedEventLoop().runScheduledTasks();
        } catch (Exception e) {
            recordException(e);
            return embeddedEventLoop().nextScheduledTask();
        }
    }

    /* access modifiers changed from: private */
    public void recordException(ChannelFuture future) {
        if (!future.isSuccess()) {
            recordException(future.cause());
        }
    }

    /* access modifiers changed from: private */
    public void recordException(Throwable cause) {
        if (this.lastException == null) {
            this.lastException = cause;
        } else {
            logger.warn("More than one exception was raised. Will report only the first one and log others.", cause);
        }
    }

    public void advanceTimeBy(long duration, TimeUnit unit) {
        embeddedEventLoop().advanceTimeBy(unit.toNanos(duration));
    }

    public void freezeTime() {
        embeddedEventLoop().freezeTime();
    }

    public void unfreezeTime() {
        embeddedEventLoop().unfreezeTime();
    }

    private ChannelFuture checkException(ChannelPromise promise) {
        Throwable t = this.lastException;
        if (t == null) {
            return promise.setSuccess();
        }
        this.lastException = null;
        if (promise.isVoid()) {
            PlatformDependent.throwException(t);
        }
        return promise.setFailure(t);
    }

    public void checkException() {
        checkException(voidPromise());
    }

    private boolean checkOpen(boolean recordException) {
        if (isOpen()) {
            return true;
        }
        if (!recordException) {
            return false;
        }
        recordException(new ClosedChannelException());
        return false;
    }

    private EmbeddedEventLoop embeddedEventLoop() {
        if (isRegistered()) {
            return (EmbeddedEventLoop) eventLoop();
        }
        return this.loop;
    }

    protected final void ensureOpen() {
        if (!checkOpen(true)) {
            checkException();
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof EmbeddedEventLoop;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        if (isActive()) {
            return LOCAL_ADDRESS;
        }
        return null;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        if (isActive()) {
            return REMOTE_ADDRESS;
        }
        return null;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        this.state = State.ACTIVE;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        if (!this.metadata.hasDisconnect()) {
            doClose();
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.state = State.CLOSED;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new EmbeddedUnsafe();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public Channel.Unsafe unsafe() {
        return ((EmbeddedUnsafe) unsafe()).wrapped;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        while (true) {
            Object msg = in.current();
            if (msg != null) {
                ReferenceCountUtil.retain(msg);
                handleOutboundMessage(msg);
                in.remove();
            } else {
                return;
            }
        }
    }

    protected void handleOutboundMessage(Object msg) {
        outboundMessages().add(msg);
    }

    protected void handleInboundMessage(Object msg) {
        inboundMessages().add(msg);
    }

    /* renamed from: io.netty.channel.embedded.EmbeddedChannel$EmbeddedUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/embedded/EmbeddedChannel$EmbeddedUnsafe.class */
    private final class EmbeddedUnsafe extends AbstractChannel.AbstractUnsafe {
        final Channel.Unsafe wrapped;

        private EmbeddedUnsafe() {
            super();
            this.wrapped = new Channel.Unsafe() { // from class: io.netty.channel.embedded.EmbeddedChannel.EmbeddedUnsafe.1
                @Override // p013io.netty.channel.Channel.Unsafe
                public RecvByteBufAllocator.Handle recvBufAllocHandle() {
                    return EmbeddedUnsafe.this.recvBufAllocHandle();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public SocketAddress localAddress() {
                    return EmbeddedUnsafe.this.localAddress();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public SocketAddress remoteAddress() {
                    return EmbeddedUnsafe.this.remoteAddress();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void register(EventLoop eventLoop, ChannelPromise promise) {
                    EmbeddedUnsafe.this.register(eventLoop, promise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void bind(SocketAddress localAddress, ChannelPromise promise) {
                    EmbeddedUnsafe.this.bind(localAddress, promise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
                    EmbeddedUnsafe.this.connect(remoteAddress, localAddress, promise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void disconnect(ChannelPromise promise) {
                    EmbeddedUnsafe.this.disconnect(promise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void close(ChannelPromise promise) {
                    EmbeddedUnsafe.this.close(promise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void closeForcibly() {
                    EmbeddedUnsafe.this.closeForcibly();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void deregister(ChannelPromise promise) {
                    EmbeddedUnsafe.this.deregister(promise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void beginRead() {
                    EmbeddedUnsafe.this.beginRead();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void write(Object msg, ChannelPromise promise) {
                    EmbeddedUnsafe.this.write(msg, promise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public void flush() {
                    EmbeddedUnsafe.this.flush();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public ChannelPromise voidPromise() {
                    return EmbeddedUnsafe.this.voidPromise();
                }

                @Override // p013io.netty.channel.Channel.Unsafe
                public ChannelOutboundBuffer outboundBuffer() {
                    return EmbeddedUnsafe.this.outboundBuffer();
                }
            };
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            safeSetSuccess(promise);
        }
    }

    /* renamed from: io.netty.channel.embedded.EmbeddedChannel$EmbeddedChannelPipeline */
    /* loaded from: grasscutter.jar:io/netty/channel/embedded/EmbeddedChannel$EmbeddedChannelPipeline.class */
    private final class EmbeddedChannelPipeline extends DefaultChannelPipeline {
        EmbeddedChannelPipeline(EmbeddedChannel channel) {
            super(channel);
        }

        @Override // p013io.netty.channel.DefaultChannelPipeline
        protected void onUnhandledInboundException(Throwable cause) {
            EmbeddedChannel.this.recordException(cause);
        }

        @Override // p013io.netty.channel.DefaultChannelPipeline
        protected void onUnhandledInboundMessage(ChannelHandlerContext ctx, Object msg) {
            EmbeddedChannel.this.handleInboundMessage(msg);
        }
    }
}
