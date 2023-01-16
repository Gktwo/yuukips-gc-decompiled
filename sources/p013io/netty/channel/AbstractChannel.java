package p013io.netty.channel;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.internal.LongCompanionObject;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.Channel;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.socket.ChannelOutputShutdownEvent;
import p013io.netty.channel.socket.ChannelOutputShutdownException;
import p013io.netty.util.DefaultAttributeMap;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.AbstractChannel */
/* loaded from: grasscutter.jar:io/netty/channel/AbstractChannel.class */
public abstract class AbstractChannel extends DefaultAttributeMap implements Channel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractChannel.class);
    private final Channel parent;

    /* renamed from: id */
    private final ChannelId f977id;
    private final Channel.Unsafe unsafe;
    private final DefaultChannelPipeline pipeline;
    private final VoidChannelPromise unsafeVoidPromise;
    private final CloseFuture closeFuture;
    private volatile SocketAddress localAddress;
    private volatile SocketAddress remoteAddress;
    private volatile EventLoop eventLoop;
    private volatile boolean registered;
    private boolean closeInitiated;
    private Throwable initialCloseCause;
    private boolean strValActive;
    private String strVal;

    protected abstract AbstractUnsafe newUnsafe();

    protected abstract boolean isCompatible(EventLoop eventLoop);

    protected abstract SocketAddress localAddress0();

    protected abstract SocketAddress remoteAddress0();

    protected abstract void doBind(SocketAddress socketAddress) throws Exception;

    protected abstract void doDisconnect() throws Exception;

    protected abstract void doClose() throws Exception;

    protected abstract void doBeginRead() throws Exception;

    protected abstract void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception;

    /* access modifiers changed from: protected */
    public AbstractChannel(Channel parent) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = parent;
        this.f977id = newId();
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }

    /* access modifiers changed from: protected */
    public AbstractChannel(Channel parent, ChannelId id) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = parent;
        this.f977id = id;
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }

    protected final int maxMessagesPerWrite() {
        ChannelConfig config = config();
        if (config instanceof DefaultChannelConfig) {
            return ((DefaultChannelConfig) config).getMaxMessagesPerWrite();
        }
        Integer value = (Integer) config.getOption(ChannelOption.MAX_MESSAGES_PER_WRITE);
        if (value == null) {
            return Integer.MAX_VALUE;
        }
        return value.intValue();
    }

    @Override // p013io.netty.channel.Channel
    /* renamed from: id */
    public final ChannelId mo1183id() {
        return this.f977id;
    }

    protected ChannelId newId() {
        return DefaultChannelId.newInstance();
    }

    protected DefaultChannelPipeline newChannelPipeline() {
        return new DefaultChannelPipeline(this);
    }

    @Override // p013io.netty.channel.Channel
    public boolean isWritable() {
        ChannelOutboundBuffer buf = this.unsafe.outboundBuffer();
        return buf != null && buf.isWritable();
    }

    @Override // p013io.netty.channel.Channel
    public long bytesBeforeUnwritable() {
        ChannelOutboundBuffer buf = this.unsafe.outboundBuffer();
        if (buf != null) {
            return buf.bytesBeforeUnwritable();
        }
        return 0;
    }

    @Override // p013io.netty.channel.Channel
    public long bytesBeforeWritable() {
        ChannelOutboundBuffer buf = this.unsafe.outboundBuffer();
        return buf != null ? buf.bytesBeforeWritable() : LongCompanionObject.MAX_VALUE;
    }

    @Override // p013io.netty.channel.Channel
    public Channel parent() {
        return this.parent;
    }

    @Override // p013io.netty.channel.Channel
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // p013io.netty.channel.Channel
    public ByteBufAllocator alloc() {
        return config().getAllocator();
    }

    @Override // p013io.netty.channel.Channel
    public EventLoop eventLoop() {
        EventLoop eventLoop = this.eventLoop;
        if (eventLoop != null) {
            return eventLoop;
        }
        throw new IllegalStateException("channel not registered to an event loop");
    }

    @Override // p013io.netty.channel.Channel
    public SocketAddress localAddress() {
        SocketAddress localAddress = this.localAddress;
        if (localAddress == null) {
            try {
                SocketAddress localAddress2 = unsafe().localAddress();
                localAddress = localAddress2;
                this.localAddress = localAddress2;
            } catch (Error e) {
                throw e;
            } catch (Throwable th) {
                return null;
            }
        }
        return localAddress;
    }

    @Deprecated
    protected void invalidateLocalAddress() {
        this.localAddress = null;
    }

    @Override // p013io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        SocketAddress remoteAddress = this.remoteAddress;
        if (remoteAddress == null) {
            try {
                SocketAddress remoteAddress2 = unsafe().remoteAddress();
                remoteAddress = remoteAddress2;
                this.remoteAddress = remoteAddress2;
            } catch (Error e) {
                throw e;
            } catch (Throwable th) {
                return null;
            }
        }
        return remoteAddress;
    }

    @Deprecated
    protected void invalidateRemoteAddress() {
        this.remoteAddress = null;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isRegistered() {
        return this.registered;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress localAddress) {
        return this.pipeline.bind(localAddress);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress remoteAddress) {
        return this.pipeline.connect(remoteAddress);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
        return this.pipeline.connect(remoteAddress, localAddress);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return this.pipeline.disconnect();
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return this.pipeline.close();
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return this.pipeline.deregister();
    }

    @Override // p013io.netty.channel.Channel, p013io.netty.channel.ChannelOutboundInvoker
    public Channel flush() {
        this.pipeline.flush();
        return this;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise) {
        return this.pipeline.bind(localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
        return this.pipeline.connect(remoteAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        return this.pipeline.connect(remoteAddress, localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(ChannelPromise promise) {
        return this.pipeline.disconnect(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(ChannelPromise promise) {
        return this.pipeline.close(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(ChannelPromise promise) {
        return this.pipeline.deregister(promise);
    }

    @Override // p013io.netty.channel.Channel, p013io.netty.channel.ChannelOutboundInvoker
    public Channel read() {
        this.pipeline.read();
        return this;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object msg) {
        return this.pipeline.write(msg);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object msg, ChannelPromise promise) {
        return this.pipeline.write(msg, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object msg) {
        return this.pipeline.writeAndFlush(msg);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
        return this.pipeline.writeAndFlush(msg, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return this.pipeline.newPromise();
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return this.pipeline.newProgressivePromise();
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        return this.pipeline.newSucceededFuture();
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable cause) {
        return this.pipeline.newFailedFuture(cause);
    }

    @Override // p013io.netty.channel.Channel
    public ChannelFuture closeFuture() {
        return this.closeFuture;
    }

    @Override // p013io.netty.channel.Channel
    public Channel.Unsafe unsafe() {
        return this.unsafe;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.f977id.hashCode();
    }

    @Override // java.lang.Object
    public final boolean equals(Object o) {
        return this == o;
    }

    public final int compareTo(Channel o) {
        if (this == o) {
            return 0;
        }
        return mo1183id().compareTo(o.mo1183id());
    }

    @Override // java.lang.Object
    public String toString() {
        boolean active = isActive();
        if (this.strValActive == active && this.strVal != null) {
            return this.strVal;
        }
        SocketAddress remoteAddr = remoteAddress();
        SocketAddress localAddr = localAddress();
        if (remoteAddr != null) {
            this.strVal = new StringBuilder(96).append("[id: 0x").append(this.f977id.asShortText()).append(", L:").append(localAddr).append(active ? " - " : " ! ").append("R:").append(remoteAddr).append(']').toString();
        } else if (localAddr != null) {
            this.strVal = new StringBuilder(64).append("[id: 0x").append(this.f977id.asShortText()).append(", L:").append(localAddr).append(']').toString();
        } else {
            this.strVal = new StringBuilder(16).append("[id: 0x").append(this.f977id.asShortText()).append(']').toString();
        }
        this.strValActive = active;
        return this.strVal;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.pipeline.voidPromise();
    }

    /* access modifiers changed from: protected */
    /* renamed from: io.netty.channel.AbstractChannel$AbstractUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/AbstractChannel$AbstractUnsafe.class */
    public abstract class AbstractUnsafe implements Channel.Unsafe {
        private volatile ChannelOutboundBuffer outboundBuffer;
        private RecvByteBufAllocator.Handle recvHandle;
        private boolean inFlush0;
        private boolean neverRegistered = true;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* access modifiers changed from: protected */
        public AbstractUnsafe() {
            this.outboundBuffer = new ChannelOutboundBuffer(AbstractChannel.this);
        }

        static {
            $assertionsDisabled = !AbstractChannel.class.desiredAssertionStatus();
        }

        private void assertEventLoop() {
            if (!$assertionsDisabled && AbstractChannel.this.registered && !AbstractChannel.this.eventLoop.inEventLoop()) {
                throw new AssertionError();
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (this.recvHandle == null) {
                this.recvHandle = AbstractChannel.this.config().getRecvByteBufAllocator().newHandle();
            }
            return this.recvHandle;
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final ChannelOutboundBuffer outboundBuffer() {
            return this.outboundBuffer;
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final SocketAddress localAddress() {
            return AbstractChannel.this.localAddress0();
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final SocketAddress remoteAddress() {
            return AbstractChannel.this.remoteAddress0();
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void register(EventLoop eventLoop, final ChannelPromise promise) {
            ObjectUtil.checkNotNull(eventLoop, "eventLoop");
            if (AbstractChannel.this.isRegistered()) {
                promise.setFailure((Throwable) new IllegalStateException("registered to an event loop already"));
            } else if (!AbstractChannel.this.isCompatible(eventLoop)) {
                promise.setFailure((Throwable) new IllegalStateException("incompatible event loop type: " + eventLoop.getClass().getName()));
            } else {
                AbstractChannel.this.eventLoop = eventLoop;
                if (eventLoop.inEventLoop()) {
                    register0(promise);
                    return;
                }
                try {
                    eventLoop.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractUnsafe.this.register0(promise);
                        }
                    });
                } catch (Throwable t) {
                    AbstractChannel.logger.warn("Force-closing a channel whose registration task was not accepted by an event loop: {}", AbstractChannel.this, t);
                    closeForcibly();
                    AbstractChannel.this.closeFuture.setClosed();
                    safeSetFailure(promise, t);
                }
            }
        }

        /* access modifiers changed from: private */
        public void register0(ChannelPromise promise) {
            try {
                if (promise.setUncancellable() && ensureOpen(promise)) {
                    boolean firstRegistration = this.neverRegistered;
                    AbstractChannel.this.doRegister();
                    this.neverRegistered = false;
                    AbstractChannel.this.registered = true;
                    AbstractChannel.this.pipeline.invokeHandlerAddedIfNeeded();
                    safeSetSuccess(promise);
                    AbstractChannel.this.pipeline.fireChannelRegistered();
                    if (AbstractChannel.this.isActive()) {
                        if (firstRegistration) {
                            AbstractChannel.this.pipeline.fireChannelActive();
                        } else if (AbstractChannel.this.config().isAutoRead()) {
                            beginRead();
                        }
                    }
                }
            } catch (Throwable t) {
                closeForcibly();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(promise, t);
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void bind(SocketAddress localAddress, ChannelPromise promise) {
            assertEventLoop();
            if (promise.setUncancellable() && ensureOpen(promise)) {
                if (Boolean.TRUE.equals(AbstractChannel.this.config().getOption(ChannelOption.SO_BROADCAST)) && (localAddress instanceof InetSocketAddress) && !((InetSocketAddress) localAddress).getAddress().isAnyLocalAddress() && !PlatformDependent.isWindows() && !PlatformDependent.maybeSuperUser()) {
                    AbstractChannel.logger.warn("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; binding to a non-wildcard address (" + localAddress + ") anyway as requested.");
                }
                boolean wasActive = AbstractChannel.this.isActive();
                try {
                    AbstractChannel.this.doBind(localAddress);
                    if (!wasActive && AbstractChannel.this.isActive()) {
                        invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractChannel.this.pipeline.fireChannelActive();
                            }
                        });
                    }
                    safeSetSuccess(promise);
                } catch (Throwable t) {
                    safeSetFailure(promise, t);
                    closeIfClosed();
                }
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void disconnect(ChannelPromise promise) {
            assertEventLoop();
            if (promise.setUncancellable()) {
                boolean wasActive = AbstractChannel.this.isActive();
                try {
                    AbstractChannel.this.doDisconnect();
                    AbstractChannel.this.remoteAddress = null;
                    AbstractChannel.this.localAddress = null;
                    if (wasActive && !AbstractChannel.this.isActive()) {
                        invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.3
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractChannel.this.pipeline.fireChannelInactive();
                            }
                        });
                    }
                    safeSetSuccess(promise);
                    closeIfClosed();
                } catch (Throwable t) {
                    safeSetFailure(promise, t);
                    closeIfClosed();
                }
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public void close(ChannelPromise promise) {
            assertEventLoop();
            ClosedChannelException closedChannelException = StacklessClosedChannelException.newInstance(AbstractChannel.class, "close(ChannelPromise)");
            close(promise, closedChannelException, closedChannelException, false);
        }

        public final void shutdownOutput(ChannelPromise promise) {
            assertEventLoop();
            shutdownOutput(promise, null);
        }

        private void shutdownOutput(ChannelPromise promise, Throwable cause) {
            if (promise.setUncancellable()) {
                ChannelOutboundBuffer outboundBuffer = this.outboundBuffer;
                if (outboundBuffer == null) {
                    promise.setFailure((Throwable) new ClosedChannelException());
                    return;
                }
                this.outboundBuffer = null;
                Throwable shutdownCause = cause == null ? new ChannelOutputShutdownException("Channel output shutdown") : new ChannelOutputShutdownException("Channel output shutdown", cause);
                try {
                    AbstractChannel.this.doShutdownOutput();
                    promise.setSuccess();
                    closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, outboundBuffer, shutdownCause);
                } catch (Throwable th) {
                    closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, outboundBuffer, shutdownCause);
                    throw th;
                }
            }
        }

        private void closeOutboundBufferForShutdown(ChannelPipeline pipeline, ChannelOutboundBuffer buffer, Throwable cause) {
            buffer.failFlushed(cause, false);
            buffer.close(cause, true);
            pipeline.fireUserEventTriggered((Object) ChannelOutputShutdownEvent.INSTANCE);
        }

        private void close(final ChannelPromise promise, final Throwable cause, final ClosedChannelException closeCause, final boolean notify) {
            if (promise.setUncancellable()) {
                if (!AbstractChannel.this.closeInitiated) {
                    AbstractChannel.this.closeInitiated = true;
                    final boolean wasActive = AbstractChannel.this.isActive();
                    final ChannelOutboundBuffer outboundBuffer = this.outboundBuffer;
                    this.outboundBuffer = null;
                    Executor closeExecutor = prepareToClose();
                    if (closeExecutor != null) {
                        closeExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.5
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AbstractUnsafe.this.doClose0(promise);
                                } finally {
                                    AbstractUnsafe.this.invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.5.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (outboundBuffer != null) {
                                                outboundBuffer.failFlushed(cause, notify);
                                                outboundBuffer.close(closeCause);
                                            }
                                            AbstractUnsafe.this.fireChannelInactiveAndDeregister(wasActive);
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    }
                    try {
                        doClose0(promise);
                        if (outboundBuffer != null) {
                            outboundBuffer.failFlushed(cause, notify);
                            outboundBuffer.close(closeCause);
                        }
                        if (this.inFlush0) {
                            invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    AbstractUnsafe.this.fireChannelInactiveAndDeregister(wasActive);
                                }
                            });
                        } else {
                            fireChannelInactiveAndDeregister(wasActive);
                        }
                    } catch (Throwable th) {
                        if (outboundBuffer != null) {
                            outboundBuffer.failFlushed(cause, notify);
                            outboundBuffer.close(closeCause);
                        }
                        throw th;
                    }
                } else if (AbstractChannel.this.closeFuture.isDone()) {
                    safeSetSuccess(promise);
                } else if (!(promise instanceof VoidChannelPromise)) {
                    AbstractChannel.this.closeFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4
                        public void operationComplete(ChannelFuture future) throws Exception {
                            promise.setSuccess();
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public void doClose0(ChannelPromise promise) {
            try {
                AbstractChannel.this.doClose();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetSuccess(promise);
            } catch (Throwable t) {
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(promise, t);
            }
        }

        /* access modifiers changed from: private */
        public void fireChannelInactiveAndDeregister(boolean wasActive) {
            deregister(voidPromise(), wasActive && !AbstractChannel.this.isActive());
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void closeForcibly() {
            assertEventLoop();
            try {
                AbstractChannel.this.doClose();
            } catch (Exception e) {
                AbstractChannel.logger.warn("Failed to close a channel.", (Throwable) e);
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void deregister(ChannelPromise promise) {
            assertEventLoop();
            deregister(promise, false);
        }

        private void deregister(final ChannelPromise promise, final boolean fireChannelInactive) {
            if (promise.setUncancellable()) {
                if (!AbstractChannel.this.registered) {
                    safeSetSuccess(promise);
                } else {
                    invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AbstractChannel.this.doDeregister();
                            } finally {
                                if (fireChannelInactive) {
                                    AbstractChannel.this.pipeline.fireChannelInactive();
                                }
                                if (AbstractChannel.this.registered) {
                                    AbstractChannel.this.registered = false;
                                    AbstractChannel.this.pipeline.fireChannelUnregistered();
                                }
                                AbstractUnsafe.this.safeSetSuccess(promise);
                            }
                        }
                    });
                }
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void beginRead() {
            assertEventLoop();
            try {
                AbstractChannel.this.doBeginRead();
            } catch (Exception e) {
                invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.8
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractChannel.this.pipeline.fireExceptionCaught((Throwable) e);
                    }
                });
                close(voidPromise());
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void write(Object msg, ChannelPromise promise) {
            assertEventLoop();
            ChannelOutboundBuffer outboundBuffer = this.outboundBuffer;
            if (outboundBuffer == null) {
                try {
                    ReferenceCountUtil.release(msg);
                    safeSetFailure(promise, newClosedChannelException(AbstractChannel.this.initialCloseCause, "write(Object, ChannelPromise)"));
                } catch (Throwable th) {
                    safeSetFailure(promise, newClosedChannelException(AbstractChannel.this.initialCloseCause, "write(Object, ChannelPromise)"));
                    throw th;
                }
            } else {
                try {
                    msg = AbstractChannel.this.filterOutboundMessage(msg);
                    int size = AbstractChannel.this.pipeline.estimatorHandle().size(msg);
                    if (size < 0) {
                        size = 0;
                    }
                    outboundBuffer.addMessage(msg, size, promise);
                } catch (Throwable t) {
                    try {
                        ReferenceCountUtil.release(msg);
                        safeSetFailure(promise, t);
                    } catch (Throwable th2) {
                        safeSetFailure(promise, t);
                        throw th2;
                    }
                }
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final void flush() {
            assertEventLoop();
            ChannelOutboundBuffer outboundBuffer = this.outboundBuffer;
            if (outboundBuffer != null) {
                outboundBuffer.addFlush();
                flush0();
            }
        }

        /* access modifiers changed from: protected */
        public void flush0() {
            ChannelOutboundBuffer outboundBuffer;
            if (!this.inFlush0 && (outboundBuffer = this.outboundBuffer) != null && !outboundBuffer.isEmpty()) {
                this.inFlush0 = true;
                if (!AbstractChannel.this.isActive()) {
                    try {
                        if (!outboundBuffer.isEmpty()) {
                            if (AbstractChannel.this.isOpen()) {
                                outboundBuffer.failFlushed(new NotYetConnectedException(), true);
                            } else {
                                outboundBuffer.failFlushed(newClosedChannelException(AbstractChannel.this.initialCloseCause, "flush0()"), false);
                            }
                        }
                    } finally {
                    }
                } else {
                    try {
                        AbstractChannel.this.doWrite(outboundBuffer);
                    } finally {
                    }
                }
            }
        }

        protected final void handleWriteError(Throwable t) {
            if (!(t instanceof IOException) || !AbstractChannel.this.config().isAutoClose()) {
                try {
                    shutdownOutput(voidPromise(), t);
                } catch (Throwable t2) {
                    AbstractChannel.this.initialCloseCause = t;
                    close(voidPromise(), t2, newClosedChannelException(t, "flush0()"), false);
                }
            } else {
                AbstractChannel.this.initialCloseCause = t;
                close(voidPromise(), t, newClosedChannelException(t, "flush0()"), false);
            }
        }

        private ClosedChannelException newClosedChannelException(Throwable cause, String method) {
            ClosedChannelException exception = StacklessClosedChannelException.newInstance(AbstractUnsafe.class, method);
            if (cause != null) {
                exception.initCause(cause);
            }
            return exception;
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public final ChannelPromise voidPromise() {
            assertEventLoop();
            return AbstractChannel.this.unsafeVoidPromise;
        }

        protected final boolean ensureOpen(ChannelPromise promise) {
            if (AbstractChannel.this.isOpen()) {
                return true;
            }
            safeSetFailure(promise, newClosedChannelException(AbstractChannel.this.initialCloseCause, "ensureOpen(ChannelPromise)"));
            return false;
        }

        protected final void safeSetSuccess(ChannelPromise promise) {
            if (!(promise instanceof VoidChannelPromise) && !promise.trySuccess()) {
                AbstractChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", promise);
            }
        }

        protected final void safeSetFailure(ChannelPromise promise, Throwable cause) {
            if (!(promise instanceof VoidChannelPromise) && !promise.tryFailure(cause)) {
                AbstractChannel.logger.warn("Failed to mark a promise as failure because it's done already: {}", promise, cause);
            }
        }

        protected final void closeIfClosed() {
            if (!AbstractChannel.this.isOpen()) {
                close(voidPromise());
            }
        }

        /* access modifiers changed from: private */
        public void invokeLater(Runnable task) {
            try {
                AbstractChannel.this.eventLoop().execute(task);
            } catch (RejectedExecutionException e) {
                AbstractChannel.logger.warn("Can't invoke task later as EventLoop rejected it", (Throwable) e);
            }
        }

        protected final Throwable annotateConnectException(Throwable cause, SocketAddress remoteAddress) {
            if (cause instanceof ConnectException) {
                return new AnnotatedConnectException((ConnectException) cause, remoteAddress);
            }
            if (cause instanceof NoRouteToHostException) {
                return new AnnotatedNoRouteToHostException((NoRouteToHostException) cause, remoteAddress);
            }
            if (cause instanceof SocketException) {
                return new AnnotatedSocketException((SocketException) cause, remoteAddress);
            }
            return cause;
        }

        protected Executor prepareToClose() {
            return null;
        }
    }

    protected void doRegister() throws Exception {
    }

    protected void doShutdownOutput() throws Exception {
        doClose();
    }

    protected void doDeregister() throws Exception {
    }

    protected Object filterOutboundMessage(Object msg) throws Exception {
        return msg;
    }

    protected void validateFileRegion(DefaultFileRegion region, long position) throws IOException {
        DefaultFileRegion.validate(region, position);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.AbstractChannel$CloseFuture */
    /* loaded from: grasscutter.jar:io/netty/channel/AbstractChannel$CloseFuture.class */
    public static final class CloseFuture extends DefaultChannelPromise {
        CloseFuture(AbstractChannel ch) {
            super(ch);
        }

        @Override // p013io.netty.channel.DefaultChannelPromise, p013io.netty.channel.ChannelPromise
        public ChannelPromise setSuccess() {
            throw new IllegalStateException();
        }

        @Override // p013io.netty.channel.DefaultChannelPromise, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise, p013io.netty.channel.ChannelPromise
        public ChannelPromise setFailure(Throwable cause) {
            throw new IllegalStateException();
        }

        @Override // p013io.netty.channel.DefaultChannelPromise, p013io.netty.channel.ChannelPromise
        public boolean trySuccess() {
            throw new IllegalStateException();
        }

        @Override // p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Promise
        public boolean tryFailure(Throwable cause) {
            throw new IllegalStateException();
        }

        boolean setClosed() {
            return trySuccess();
        }
    }

    /* renamed from: io.netty.channel.AbstractChannel$AnnotatedConnectException */
    /* loaded from: grasscutter.jar:io/netty/channel/AbstractChannel$AnnotatedConnectException.class */
    private static final class AnnotatedConnectException extends ConnectException {
        private static final long serialVersionUID = 3901958112696433556L;

        AnnotatedConnectException(ConnectException exception, SocketAddress remoteAddress) {
            super(exception.getMessage() + ": " + remoteAddress);
            initCause(exception);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: io.netty.channel.AbstractChannel$AnnotatedNoRouteToHostException */
    /* loaded from: grasscutter.jar:io/netty/channel/AbstractChannel$AnnotatedNoRouteToHostException.class */
    private static final class AnnotatedNoRouteToHostException extends NoRouteToHostException {
        private static final long serialVersionUID = -6801433937592080623L;

        AnnotatedNoRouteToHostException(NoRouteToHostException exception, SocketAddress remoteAddress) {
            super(exception.getMessage() + ": " + remoteAddress);
            initCause(exception);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: io.netty.channel.AbstractChannel$AnnotatedSocketException */
    /* loaded from: grasscutter.jar:io/netty/channel/AbstractChannel$AnnotatedSocketException.class */
    private static final class AnnotatedSocketException extends SocketException {
        private static final long serialVersionUID = 3896743275010454039L;

        AnnotatedSocketException(SocketException exception, SocketAddress remoteAddress) {
            super(exception.getMessage() + ": " + remoteAddress);
            initCause(exception);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
