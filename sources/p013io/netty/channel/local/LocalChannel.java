package p013io.netty.channel.local;

import java.net.ConnectException;
import java.net.SocketAddress;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultChannelConfig;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.PreferHeapByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.SingleThreadEventLoop;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.SingleThreadEventExecutor;
import p013io.netty.util.internal.InternalThreadLocalMap;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.local.LocalChannel */
/* loaded from: grasscutter.jar:io/netty/channel/local/LocalChannel.class */
public class LocalChannel extends AbstractChannel {
    private static final InternalLogger logger;
    private static final AtomicReferenceFieldUpdater<LocalChannel, Future> FINISH_READ_FUTURE_UPDATER;
    private static final ChannelMetadata METADATA;
    private static final int MAX_READER_STACK_DEPTH = 8;
    private final ChannelConfig config = new DefaultChannelConfig(this);
    final Queue<Object> inboundBuffer = PlatformDependent.newSpscQueue();
    private final Runnable readTask = new Runnable() { // from class: io.netty.channel.local.LocalChannel.1
        @Override // java.lang.Runnable
        public void run() {
            if (!LocalChannel.this.inboundBuffer.isEmpty()) {
                LocalChannel.this.readInbound();
            }
        }
    };
    private final Runnable shutdownHook = new Runnable() { // from class: io.netty.channel.local.LocalChannel.2
        @Override // java.lang.Runnable
        public void run() {
            LocalChannel.this.unsafe().close(LocalChannel.this.unsafe().voidPromise());
        }
    };
    private volatile State state;
    private volatile LocalChannel peer;
    private volatile LocalAddress localAddress;
    private volatile LocalAddress remoteAddress;
    private volatile ChannelPromise connectPromise;
    private volatile boolean readInProgress;
    private volatile boolean writeInProgress;
    private volatile Future<?> finishReadFuture;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.local.LocalChannel$State */
    /* loaded from: grasscutter.jar:io/netty/channel/local/LocalChannel$State.class */
    public enum State {
        OPEN,
        BOUND,
        CONNECTED,
        CLOSED
    }

    static {
        $assertionsDisabled = !LocalChannel.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(LocalChannel.class);
        FINISH_READ_FUTURE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(LocalChannel.class, Future.class, "finishReadFuture");
        METADATA = new ChannelMetadata(false);
    }

    public LocalChannel() {
        super(null);
        config().setAllocator(new PreferHeapByteBufAllocator(this.config.getAllocator()));
    }

    /* access modifiers changed from: protected */
    public LocalChannel(LocalServerChannel parent, LocalChannel peer) {
        super(parent);
        config().setAllocator(new PreferHeapByteBufAllocator(this.config.getAllocator()));
        this.peer = peer;
        this.localAddress = parent.localAddress();
        this.remoteAddress = peer.localAddress();
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public LocalServerChannel parent() {
        return (LocalServerChannel) parent();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public LocalAddress localAddress() {
        return (LocalAddress) localAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public LocalAddress remoteAddress() {
        return (LocalAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return this.state != State.CLOSED;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        return this.state == State.CONNECTED;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new LocalUnsafe();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof SingleThreadEventLoop;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.localAddress;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.remoteAddress;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        if (!(this.peer == null || parent() == null)) {
            final LocalChannel peer = this.peer;
            this.state = State.CONNECTED;
            peer.remoteAddress = parent() == null ? null : parent().localAddress();
            peer.state = State.CONNECTED;
            peer.eventLoop().execute(new Runnable() { // from class: io.netty.channel.local.LocalChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelPromise promise = peer.connectPromise;
                    if (promise != null && promise.trySuccess()) {
                        peer.pipeline().fireChannelActive();
                    }
                }
            });
        }
        ((SingleThreadEventExecutor) eventLoop()).addShutdownHook(this.shutdownHook);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, localAddress);
        this.state = State.BOUND;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:23:0x0086
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 228
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.local.LocalChannel.doClose():void");
    }

    /* access modifiers changed from: private */
    public void tryClose(boolean isActive) {
        if (isActive) {
            unsafe().close(unsafe().voidPromise());
        } else {
            releaseInboundBuffers();
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).removeShutdownHook(this.shutdownHook);
    }

    /* access modifiers changed from: private */
    public void readInbound() {
        RecvByteBufAllocator.Handle handle = unsafe().recvBufAllocHandle();
        handle.reset(config());
        ChannelPipeline pipeline = pipeline();
        do {
            Object received = this.inboundBuffer.poll();
            if (received == null) {
                break;
            }
            pipeline.fireChannelRead(received);
        } while (handle.continueReading());
        pipeline.fireChannelReadComplete();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
        if (!this.readInProgress) {
            if (this.inboundBuffer.isEmpty()) {
                this.readInProgress = true;
                return;
            }
            InternalThreadLocalMap threadLocals = InternalThreadLocalMap.get();
            Integer stackDepth = Integer.valueOf(threadLocals.localChannelReaderStackDepth());
            if (stackDepth.intValue() < 8) {
                threadLocals.setLocalChannelReaderStackDepth(stackDepth.intValue() + 1);
                try {
                    readInbound();
                    threadLocals.setLocalChannelReaderStackDepth(stackDepth.intValue());
                } catch (Throwable th) {
                    threadLocals.setLocalChannelReaderStackDepth(stackDepth.intValue());
                    throw th;
                }
            } else {
                try {
                    eventLoop().execute(this.readTask);
                } catch (Throwable cause) {
                    logger.warn("Closing Local channels {}-{} because exception occurred!", this, this.peer, cause);
                    close();
                    this.peer.close();
                    PlatformDependent.throwException(cause);
                }
            }
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        switch (this.state) {
            case OPEN:
            case BOUND:
                throw new NotYetConnectedException();
            case CLOSED:
                throw new ClosedChannelException();
            case CONNECTED:
            default:
                LocalChannel peer = this.peer;
                this.writeInProgress = true;
                ClosedChannelException exception = null;
                while (true) {
                    try {
                        Object msg = in.current();
                        if (msg == null) {
                            finishPeerRead(peer);
                            return;
                        } else if (peer.state == State.CONNECTED) {
                            peer.inboundBuffer.add(ReferenceCountUtil.retain(msg));
                            in.remove();
                        } else {
                            if (exception == null) {
                                exception = new ClosedChannelException();
                            }
                            in.remove(exception);
                        }
                    } finally {
                        this.writeInProgress = false;
                    }
                }
        }
    }

    private void finishPeerRead(LocalChannel peer) {
        if (peer.eventLoop() != eventLoop() || peer.writeInProgress) {
            runFinishPeerReadTask(peer);
        } else {
            finishPeerRead0(peer);
        }
    }

    private void runFinishPeerReadTask(final LocalChannel peer) {
        Runnable finishPeerReadTask = new Runnable() { // from class: io.netty.channel.local.LocalChannel.5
            @Override // java.lang.Runnable
            public void run() {
                LocalChannel.this.finishPeerRead0(peer);
            }
        };
        try {
            if (peer.writeInProgress) {
                peer.finishReadFuture = peer.eventLoop().submit(finishPeerReadTask);
            } else {
                peer.eventLoop().execute(finishPeerReadTask);
            }
        } catch (Throwable cause) {
            logger.warn("Closing Local channels {}-{} because exception occurred!", this, peer, cause);
            close();
            peer.close();
            PlatformDependent.throwException(cause);
        }
    }

    private void releaseInboundBuffers() {
        if ($assertionsDisabled || eventLoop() == null || eventLoop().inEventLoop()) {
            this.readInProgress = false;
            Queue<Object> inboundBuffer = this.inboundBuffer;
            while (true) {
                Object msg = inboundBuffer.poll();
                if (msg != null) {
                    ReferenceCountUtil.release(msg);
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public void finishPeerRead0(LocalChannel peer) {
        Future<?> peerFinishReadFuture = peer.finishReadFuture;
        if (peerFinishReadFuture != null) {
            if (!peerFinishReadFuture.isDone()) {
                runFinishPeerReadTask(peer);
                return;
            }
            FINISH_READ_FUTURE_UPDATER.compareAndSet(peer, peerFinishReadFuture, null);
        }
        if (peer.readInProgress && !peer.inboundBuffer.isEmpty()) {
            peer.readInProgress = false;
            peer.readInbound();
        }
    }

    /* renamed from: io.netty.channel.local.LocalChannel$LocalUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/local/LocalChannel$LocalUnsafe.class */
    private class LocalUnsafe extends AbstractChannel.AbstractUnsafe {
        private LocalUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            if (promise.setUncancellable() && ensureOpen(promise)) {
                if (LocalChannel.this.state == State.CONNECTED) {
                    Exception cause = new AlreadyConnectedException();
                    safeSetFailure(promise, cause);
                    LocalChannel.this.pipeline().fireExceptionCaught((Throwable) cause);
                } else if (LocalChannel.this.connectPromise != null) {
                    throw new ConnectionPendingException();
                } else {
                    LocalChannel.this.connectPromise = promise;
                    if (LocalChannel.this.state != State.BOUND && localAddress == null) {
                        localAddress = new LocalAddress(LocalChannel.this);
                    }
                    if (localAddress != null) {
                        try {
                            LocalChannel.this.doBind(localAddress);
                        } catch (Throwable t) {
                            safeSetFailure(promise, t);
                            close(voidPromise());
                            return;
                        }
                    }
                    Channel boundChannel = LocalChannelRegistry.get(remoteAddress);
                    if (!(boundChannel instanceof LocalServerChannel)) {
                        safeSetFailure(promise, new ConnectException("connection refused: " + remoteAddress));
                        close(voidPromise());
                        return;
                    }
                    LocalServerChannel serverChannel = (LocalServerChannel) boundChannel;
                    LocalChannel.this.peer = serverChannel.serve(LocalChannel.this);
                }
            }
        }
    }
}
