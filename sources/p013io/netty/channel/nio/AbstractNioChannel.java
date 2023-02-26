package p013io.netty.channel.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.TimeUnit;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.ConnectTimeoutException;
import p013io.netty.channel.EventLoop;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.ReferenceCounted;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.nio.AbstractNioChannel */
/* loaded from: grasscutter.jar:io/netty/channel/nio/AbstractNioChannel.class */
public abstract class AbstractNioChannel extends AbstractChannel {
    private static final InternalLogger logger;

    /* renamed from: ch */
    private final SelectableChannel f950ch;
    protected final int readInterestOp;
    volatile SelectionKey selectionKey;
    boolean readPending;
    private final Runnable clearReadPendingRunnable = new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.1
        @Override // java.lang.Runnable
        public void run() {
            AbstractNioChannel.this.clearReadPending0();
        }
    };
    private ChannelPromise connectPromise;
    private Future<?> connectTimeoutFuture;
    private SocketAddress requestedRemoteAddress;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* renamed from: io.netty.channel.nio.AbstractNioChannel$NioUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/nio/AbstractNioChannel$NioUnsafe.class */
    public interface NioUnsafe extends Channel.Unsafe {
        /* renamed from: ch */
        SelectableChannel mo1178ch();

        void finishConnect();

        void read();

        void forceFlush();
    }

    protected abstract boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception;

    protected abstract void doFinishConnect() throws Exception;

    static {
        $assertionsDisabled = !AbstractNioChannel.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(AbstractNioChannel.class);
    }

    /* access modifiers changed from: protected */
    public AbstractNioChannel(Channel parent, SelectableChannel ch, int readInterestOp) {
        super(parent);
        this.f950ch = ch;
        this.readInterestOp = readInterestOp;
        try {
            ch.configureBlocking(false);
        } catch (IOException e) {
            try {
                ch.close();
            } catch (IOException e2) {
                logger.warn("Failed to close a partially initialized socket.", (Throwable) e2);
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e);
        }
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return this.f950ch.isOpen();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public NioUnsafe unsafe() {
        return (NioUnsafe) unsafe();
    }

    protected SelectableChannel javaChannel() {
        return this.f950ch;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public NioEventLoop eventLoop() {
        return (NioEventLoop) eventLoop();
    }

    protected SelectionKey selectionKey() {
        if ($assertionsDisabled || this.selectionKey != null) {
            return this.selectionKey;
        }
        throw new AssertionError();
    }

    @Deprecated
    protected boolean isReadPending() {
        return this.readPending;
    }

    @Deprecated
    protected void setReadPending(final boolean readPending) {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                setReadPending0(readPending);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractNioChannel.this.setReadPending0(readPending);
                    }
                });
            }
        } else {
            this.readPending = readPending;
        }
    }

    protected final void clearReadPending() {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                clearReadPending0();
            } else {
                eventLoop.execute(this.clearReadPendingRunnable);
            }
        } else {
            this.readPending = false;
        }
    }

    /* access modifiers changed from: private */
    public void setReadPending0(boolean readPending) {
        this.readPending = readPending;
        if (!readPending) {
            ((AbstractNioUnsafe) unsafe()).removeReadOp();
        }
    }

    /* access modifiers changed from: private */
    public void clearReadPending0() {
        this.readPending = false;
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    /* access modifiers changed from: protected */
    /* renamed from: io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe.class */
    public abstract class AbstractNioUnsafe extends AbstractChannel.AbstractUnsafe implements NioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled;

        /* access modifiers changed from: protected */
        public AbstractNioUnsafe() {
            super();
        }

        static {
            $assertionsDisabled = !AbstractNioChannel.class.desiredAssertionStatus();
        }

        protected final void removeReadOp() {
            SelectionKey key = AbstractNioChannel.this.selectionKey();
            if (key.isValid()) {
                int interestOps = key.interestOps();
                if ((interestOps & AbstractNioChannel.this.readInterestOp) != 0) {
                    key.interestOps(interestOps & (AbstractNioChannel.this.readInterestOp ^ -1));
                }
            }
        }

        @Override // p013io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /* renamed from: ch */
        public final SelectableChannel mo1178ch() {
            return AbstractNioChannel.this.javaChannel();
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void connect(final SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            if (promise.setUncancellable() && ensureOpen(promise)) {
                try {
                    if (AbstractNioChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean wasActive = AbstractNioChannel.this.isActive();
                    if (AbstractNioChannel.this.doConnect(remoteAddress, localAddress)) {
                        fulfillConnectPromise(promise, wasActive);
                    } else {
                        AbstractNioChannel.this.connectPromise = promise;
                        AbstractNioChannel.this.requestedRemoteAddress = remoteAddress;
                        int connectTimeoutMillis = AbstractNioChannel.this.config().getConnectTimeoutMillis();
                        if (connectTimeoutMillis > 0) {
                            AbstractNioChannel.this.connectTimeoutFuture = AbstractNioChannel.this.eventLoop().schedule((Runnable) new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChannelPromise connectPromise = AbstractNioChannel.this.connectPromise;
                                    if (connectPromise != null && !connectPromise.isDone() && connectPromise.tryFailure(new ConnectTimeoutException("connection timed out: " + remoteAddress))) {
                                        AbstractNioUnsafe.this.close(AbstractNioUnsafe.this.voidPromise());
                                    }
                                }
                            }, (long) connectTimeoutMillis, TimeUnit.MILLISECONDS);
                        }
                        promise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.2
                            public void operationComplete(ChannelFuture future) throws Exception {
                                if (future.isCancelled()) {
                                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                                    }
                                    AbstractNioChannel.this.connectPromise = null;
                                    AbstractNioUnsafe.this.close(AbstractNioUnsafe.this.voidPromise());
                                }
                            }
                        });
                    }
                } catch (Throwable t) {
                    promise.tryFailure(annotateConnectException(t, remoteAddress));
                    closeIfClosed();
                }
            }
        }

        private void fulfillConnectPromise(ChannelPromise promise, boolean wasActive) {
            if (promise != null) {
                boolean active = AbstractNioChannel.this.isActive();
                boolean promiseSet = promise.trySuccess();
                if (!wasActive && active) {
                    AbstractNioChannel.this.pipeline().fireChannelActive();
                }
                if (!promiseSet) {
                    close(voidPromise());
                }
            }
        }

        private void fulfillConnectPromise(ChannelPromise promise, Throwable cause) {
            if (promise != null) {
                promise.tryFailure(cause);
                closeIfClosed();
            }
        }

        /* JADX INFO: finally extract failed */
        @Override // p013io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void finishConnect() {
            if ($assertionsDisabled || AbstractNioChannel.this.eventLoop().inEventLoop()) {
                try {
                    boolean wasActive = AbstractNioChannel.this.isActive();
                    AbstractNioChannel.this.doFinishConnect();
                    fulfillConnectPromise(AbstractNioChannel.this.connectPromise, wasActive);
                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                    }
                    AbstractNioChannel.this.connectPromise = null;
                } catch (Throwable th) {
                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                    }
                    AbstractNioChannel.this.connectPromise = null;
                    throw th;
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: protected */
        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe
        public final void flush0() {
            if (!isFlushPending()) {
                flush0();
            }
        }

        @Override // p013io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void forceFlush() {
            flush0();
        }

        private boolean isFlushPending() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            return selectionKey.isValid() && (selectionKey.interestOps() & 4) != 0;
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof NioEventLoop;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        boolean selected = false;
        while (true) {
            try {
                this.selectionKey = javaChannel().register(eventLoop().unwrappedSelector(), 0, this);
                return;
            } catch (CancelledKeyException e) {
                if (!selected) {
                    eventLoop().selectNow();
                    selected = true;
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        eventLoop().cancel(selectionKey());
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.AbstractChannel
    public void doBeginRead() throws Exception {
        SelectionKey selectionKey = this.selectionKey;
        if (selectionKey.isValid()) {
            this.readPending = true;
            int interestOps = selectionKey.interestOps();
            if ((interestOps & this.readInterestOp) == 0) {
                selectionKey.interestOps(interestOps | this.readInterestOp);
            }
        }
    }

    protected final ByteBuf newDirectBuffer(ByteBuf buf) {
        int readableBytes = buf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(buf);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            ByteBuf directBuf = alloc.directBuffer(readableBytes);
            directBuf.writeBytes(buf, buf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(buf);
            return directBuf;
        }
        ByteBuf directBuf2 = ByteBufUtil.threadLocalDirectBuffer();
        if (directBuf2 == null) {
            return buf;
        }
        directBuf2.writeBytes(buf, buf.readerIndex(), readableBytes);
        ReferenceCountUtil.safeRelease(buf);
        return directBuf2;
    }

    protected final ByteBuf newDirectBuffer(ReferenceCounted holder, ByteBuf buf) {
        int readableBytes = buf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(holder);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            ByteBuf directBuf = alloc.directBuffer(readableBytes);
            directBuf.writeBytes(buf, buf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(holder);
            return directBuf;
        }
        ByteBuf directBuf2 = ByteBufUtil.threadLocalDirectBuffer();
        if (directBuf2 != null) {
            directBuf2.writeBytes(buf, buf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(holder);
            return directBuf2;
        }
        if (holder != buf) {
            buf.retain();
            ReferenceCountUtil.safeRelease(holder);
        }
        return buf;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        ChannelPromise promise = this.connectPromise;
        if (promise != null) {
            promise.tryFailure(new ClosedChannelException());
            this.connectPromise = null;
        }
        Future<?> future = this.connectTimeoutFuture;
        if (future != null) {
            future.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }
}
