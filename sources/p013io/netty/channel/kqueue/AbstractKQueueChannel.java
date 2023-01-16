package p013io.netty.channel.kqueue;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.util.concurrent.TimeUnit;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.ConnectTimeoutException;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.socket.ChannelInputShutdownEvent;
import p013io.netty.channel.socket.ChannelInputShutdownReadComplete;
import p013io.netty.channel.socket.SocketChannelConfig;
import p013io.netty.channel.unix.FileDescriptor;
import p013io.netty.channel.unix.UnixChannel;
import p013io.netty.channel.unix.UnixChannelUtil;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.kqueue.AbstractKQueueChannel */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/AbstractKQueueChannel.class */
public abstract class AbstractKQueueChannel extends AbstractChannel implements UnixChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private ChannelPromise connectPromise;
    private Future<?> connectTimeoutFuture;
    private SocketAddress requestedRemoteAddress;
    final BsdSocket socket;
    private boolean readFilterEnabled;
    private boolean writeFilterEnabled;
    boolean readReadyRunnablePending;
    boolean inputClosedSeenErrorOnRead;
    protected volatile boolean active;
    private volatile SocketAddress local;
    private volatile SocketAddress remote;

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.AbstractChannel
    public abstract AbstractKQueueUnsafe newUnsafe();

    @Override // p013io.netty.channel.Channel
    public abstract KQueueChannelConfig config();

    /* access modifiers changed from: package-private */
    public AbstractKQueueChannel(Channel parent, BsdSocket fd, boolean active) {
        super(parent);
        this.socket = (BsdSocket) ObjectUtil.checkNotNull(fd, "fd");
        this.active = active;
        if (active) {
            this.local = fd.localAddress();
            this.remote = fd.remoteAddress();
        }
    }

    /* access modifiers changed from: package-private */
    public AbstractKQueueChannel(Channel parent, BsdSocket fd, SocketAddress remote) {
        super(parent);
        this.socket = (BsdSocket) ObjectUtil.checkNotNull(fd, "fd");
        this.active = true;
        this.remote = remote;
        this.local = fd.localAddress();
    }

    static boolean isSoErrorZero(BsdSocket fd) {
        try {
            return fd.getSoError() == 0;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.unix.UnixChannel
    /* renamed from: fd */
    public final FileDescriptor mo1175fd() {
        return this.socket;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        return this.active;
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.active = false;
        this.inputClosedSeenErrorOnRead = true;
        this.socket.close();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    void resetCachedAddresses() {
        this.local = this.socket.localAddress();
        this.remote = this.socket.remoteAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof KQueueEventLoop;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return this.socket.isOpen();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        ((KQueueEventLoop) eventLoop()).remove(this);
        this.readFilterEnabled = false;
        this.writeFilterEnabled = false;
    }

    /* access modifiers changed from: package-private */
    public void unregisterFilters() throws Exception {
        readFilter(false);
        writeFilter(false);
        evSet0(Native.EVFILT_SOCK, Native.EV_DELETE, 0);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final void doBeginRead() throws Exception {
        AbstractKQueueUnsafe unsafe = (AbstractKQueueUnsafe) unsafe();
        unsafe.readPending = true;
        readFilter(true);
        if (unsafe.maybeMoreDataToRead) {
            unsafe.executeReadReadyRunnable(config());
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        this.readReadyRunnablePending = false;
        ((KQueueEventLoop) eventLoop()).add(this);
        if (this.writeFilterEnabled) {
            evSet0(Native.EVFILT_WRITE, Native.EV_ADD_CLEAR_ENABLE);
        }
        if (this.readFilterEnabled) {
            evSet0(Native.EVFILT_READ, Native.EV_ADD_CLEAR_ENABLE);
        }
        evSet0(Native.EVFILT_SOCK, Native.EV_ADD, Native.NOTE_RDHUP);
    }

    protected final ByteBuf newDirectBuffer(ByteBuf buf) {
        return newDirectBuffer(buf, buf);
    }

    protected final ByteBuf newDirectBuffer(Object holder, ByteBuf buf) {
        int readableBytes = buf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.release(holder);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            return newDirectBuffer0(holder, buf, alloc, readableBytes);
        }
        ByteBuf directBuf = ByteBufUtil.threadLocalDirectBuffer();
        if (directBuf == null) {
            return newDirectBuffer0(holder, buf, alloc, readableBytes);
        }
        directBuf.writeBytes(buf, buf.readerIndex(), readableBytes);
        ReferenceCountUtil.safeRelease(holder);
        return directBuf;
    }

    private static ByteBuf newDirectBuffer0(Object holder, ByteBuf buf, ByteBufAllocator alloc, int capacity) {
        ByteBuf directBuf = alloc.directBuffer(capacity);
        directBuf.writeBytes(buf, buf.readerIndex(), capacity);
        ReferenceCountUtil.safeRelease(holder);
        return directBuf;
    }

    protected static void checkResolvable(InetSocketAddress addr) {
        if (addr.isUnresolved()) {
            throw new UnresolvedAddressException();
        }
    }

    protected final int doReadBytes(ByteBuf byteBuf) throws Exception {
        int localReadAmount;
        int writerIndex = byteBuf.writerIndex();
        unsafe().recvBufAllocHandle().attemptedBytesRead(byteBuf.writableBytes());
        if (byteBuf.hasMemoryAddress()) {
            localReadAmount = this.socket.readAddress(byteBuf.memoryAddress(), writerIndex, byteBuf.capacity());
        } else {
            ByteBuffer buf = byteBuf.internalNioBuffer(writerIndex, byteBuf.writableBytes());
            localReadAmount = this.socket.read(buf, buf.position(), buf.limit());
        }
        if (localReadAmount > 0) {
            byteBuf.writerIndex(writerIndex + localReadAmount);
        }
        return localReadAmount;
    }

    protected final int doWriteBytes(ChannelOutboundBuffer in, ByteBuf buf) throws Exception {
        if (buf.hasMemoryAddress()) {
            int localFlushedAmount = this.socket.writeAddress(buf.memoryAddress(), buf.readerIndex(), buf.writerIndex());
            if (localFlushedAmount <= 0) {
                return Integer.MAX_VALUE;
            }
            in.removeBytes((long) localFlushedAmount);
            return 1;
        }
        ByteBuffer nioBuf = buf.nioBufferCount() == 1 ? buf.internalNioBuffer(buf.readerIndex(), buf.readableBytes()) : buf.nioBuffer();
        int localFlushedAmount2 = this.socket.write(nioBuf, nioBuf.position(), nioBuf.limit());
        if (localFlushedAmount2 <= 0) {
            return Integer.MAX_VALUE;
        }
        nioBuf.position(nioBuf.position() + localFlushedAmount2);
        in.removeBytes((long) localFlushedAmount2);
        return 1;
    }

    final boolean shouldBreakReadReady(ChannelConfig config) {
        return this.socket.isInputShutdown() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(config));
    }

    /* access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig config) {
        if (config instanceof KQueueDomainSocketChannelConfig) {
            return ((KQueueDomainSocketChannelConfig) config).isAllowHalfClosure();
        }
        return (config instanceof SocketChannelConfig) && ((SocketChannelConfig) config).isAllowHalfClosure();
    }

    /* access modifiers changed from: package-private */
    public final void clearReadFilter() {
        if (isRegistered()) {
            EventLoop loop = eventLoop();
            final AbstractKQueueUnsafe unsafe = (AbstractKQueueUnsafe) unsafe();
            if (loop.inEventLoop()) {
                unsafe.clearReadFilter0();
            } else {
                loop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!unsafe.readPending && !AbstractKQueueChannel.this.config().isAutoRead()) {
                            unsafe.clearReadFilter0();
                        }
                    }
                });
            }
        } else {
            this.readFilterEnabled = false;
        }
    }

    void readFilter(boolean readFilterEnabled) throws IOException {
        if (this.readFilterEnabled != readFilterEnabled) {
            this.readFilterEnabled = readFilterEnabled;
            evSet(Native.EVFILT_READ, readFilterEnabled ? Native.EV_ADD_CLEAR_ENABLE : Native.EV_DELETE_DISABLE);
        }
    }

    void writeFilter(boolean writeFilterEnabled) throws IOException {
        if (this.writeFilterEnabled != writeFilterEnabled) {
            this.writeFilterEnabled = writeFilterEnabled;
            evSet(Native.EVFILT_WRITE, writeFilterEnabled ? Native.EV_ADD_CLEAR_ENABLE : Native.EV_DELETE_DISABLE);
        }
    }

    private void evSet(short filter, short flags) {
        if (isRegistered()) {
            evSet0(filter, flags);
        }
    }

    private void evSet0(short filter, short flags) {
        evSet0(filter, flags, 0);
    }

    private void evSet0(short filter, short flags, int fflags) {
        if (isOpen()) {
            ((KQueueEventLoop) eventLoop()).evSet(this, filter, flags, fflags);
        }
    }

    /* renamed from: io.netty.channel.kqueue.AbstractKQueueChannel$AbstractKQueueUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/kqueue/AbstractKQueueChannel$AbstractKQueueUnsafe.class */
    public abstract class AbstractKQueueUnsafe extends AbstractChannel.AbstractUnsafe {
        boolean readPending;
        boolean maybeMoreDataToRead;
        private KQueueRecvByteAllocatorHandle allocHandle;
        private final Runnable readReadyRunnable = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractKQueueChannel.this.readReadyRunnablePending = false;
                AbstractKQueueUnsafe.this.readReady(AbstractKQueueUnsafe.this.recvBufAllocHandle());
            }
        };
        static final /* synthetic */ boolean $assertionsDisabled;

        abstract void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle);

        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe, p013io.netty.channel.Channel.Unsafe
        public /* bridge */ /* synthetic */ void close(ChannelPromise x0) {
            close(x0);
        }

        static {
            $assertionsDisabled = !AbstractKQueueChannel.class.desiredAssertionStatus();
        }

        public AbstractKQueueUnsafe() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void readReady(long numberBytesPending) {
            KQueueRecvByteAllocatorHandle allocHandle = recvBufAllocHandle();
            allocHandle.numberBytesPending(numberBytesPending);
            readReady(allocHandle);
        }

        final void readReadyBefore() {
            this.maybeMoreDataToRead = false;
        }

        final void readReadyFinally(ChannelConfig config) {
            this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
            if (this.allocHandle.isReadEOF() || (this.readPending && this.maybeMoreDataToRead)) {
                executeReadReadyRunnable(config);
            } else if (!this.readPending && !config.isAutoRead()) {
                clearReadFilter0();
            }
        }

        final boolean failConnectPromise(Throwable cause) {
            if (AbstractKQueueChannel.this.connectPromise == null) {
                return false;
            }
            ChannelPromise connectPromise = AbstractKQueueChannel.this.connectPromise;
            AbstractKQueueChannel.this.connectPromise = null;
            if (!connectPromise.tryFailure(cause instanceof ConnectException ? cause : new ConnectException("failed to connect").initCause(cause))) {
                return false;
            }
            closeIfClosed();
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void writeReady() {
            if (AbstractKQueueChannel.this.connectPromise != null) {
                finishConnect();
            } else if (!AbstractKQueueChannel.this.socket.isOutputShutdown()) {
                flush0();
            }
        }

        void shutdownInput(boolean readEOF) {
            if (readEOF && AbstractKQueueChannel.this.connectPromise != null) {
                finishConnect();
            }
            if (!AbstractKQueueChannel.this.socket.isInputShutdown()) {
                if (AbstractKQueueChannel.isAllowHalfClosure(AbstractKQueueChannel.this.config())) {
                    try {
                        AbstractKQueueChannel.this.socket.shutdown(true, false);
                    } catch (IOException e) {
                        fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
                        return;
                    } catch (NotYetConnectedException e2) {
                    }
                    AbstractKQueueChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
                    return;
                }
                close(voidPromise());
            } else if (!readEOF) {
                AbstractKQueueChannel.this.inputClosedSeenErrorOnRead = true;
                AbstractKQueueChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
            }
        }

        /* access modifiers changed from: package-private */
        public final void readEOF() {
            KQueueRecvByteAllocatorHandle allocHandle = recvBufAllocHandle();
            allocHandle.readEOF();
            if (AbstractKQueueChannel.this.isActive()) {
                readReady(allocHandle);
            } else {
                shutdownInput(true);
            }
        }

        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe, p013io.netty.channel.Channel.Unsafe
        public KQueueRecvByteAllocatorHandle recvBufAllocHandle() {
            if (this.allocHandle == null) {
                this.allocHandle = new KQueueRecvByteAllocatorHandle((RecvByteBufAllocator.ExtendedHandle) recvBufAllocHandle());
            }
            return this.allocHandle;
        }

        /* access modifiers changed from: protected */
        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe
        public final void flush0() {
            if (!AbstractKQueueChannel.this.writeFilterEnabled) {
                flush0();
            }
        }

        final void executeReadReadyRunnable(ChannelConfig config) {
            if (!AbstractKQueueChannel.this.readReadyRunnablePending && AbstractKQueueChannel.this.isActive() && !AbstractKQueueChannel.this.shouldBreakReadReady(config)) {
                AbstractKQueueChannel.this.readReadyRunnablePending = true;
                AbstractKQueueChannel.this.eventLoop().execute(this.readReadyRunnable);
            }
        }

        protected final void clearReadFilter0() {
            if ($assertionsDisabled || AbstractKQueueChannel.this.eventLoop().inEventLoop()) {
                try {
                    this.readPending = false;
                    AbstractKQueueChannel.this.readFilter(false);
                } catch (IOException e) {
                    AbstractKQueueChannel.this.pipeline().fireExceptionCaught((Throwable) e);
                    AbstractKQueueChannel.this.unsafe().close(AbstractKQueueChannel.this.unsafe().voidPromise());
                }
            } else {
                throw new AssertionError();
            }
        }

        private void fireEventAndClose(Object evt) {
            AbstractKQueueChannel.this.pipeline().fireUserEventTriggered(evt);
            close(voidPromise());
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public void connect(final SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            if (promise.setUncancellable() && ensureOpen(promise)) {
                try {
                    if (AbstractKQueueChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean wasActive = AbstractKQueueChannel.this.isActive();
                    if (AbstractKQueueChannel.this.doConnect(remoteAddress, localAddress)) {
                        fulfillConnectPromise(promise, wasActive);
                    } else {
                        AbstractKQueueChannel.this.connectPromise = promise;
                        AbstractKQueueChannel.this.requestedRemoteAddress = remoteAddress;
                        int connectTimeoutMillis = AbstractKQueueChannel.this.config().getConnectTimeoutMillis();
                        if (connectTimeoutMillis > 0) {
                            AbstractKQueueChannel.this.connectTimeoutFuture = AbstractKQueueChannel.this.eventLoop().schedule((Runnable) new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChannelPromise connectPromise = AbstractKQueueChannel.this.connectPromise;
                                    if (connectPromise != null && !connectPromise.isDone() && connectPromise.tryFailure(new ConnectTimeoutException("connection timed out: " + remoteAddress))) {
                                        AbstractKQueueUnsafe.this.close(AbstractKQueueUnsafe.this.voidPromise());
                                    }
                                }
                            }, (long) connectTimeoutMillis, TimeUnit.MILLISECONDS);
                        }
                        promise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe.3
                            public void operationComplete(ChannelFuture future) throws Exception {
                                if (future.isCancelled()) {
                                    if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
                                        AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
                                    }
                                    AbstractKQueueChannel.this.connectPromise = null;
                                    AbstractKQueueUnsafe.this.close(AbstractKQueueUnsafe.this.voidPromise());
                                }
                            }
                        });
                    }
                } catch (Throwable t) {
                    closeIfClosed();
                    promise.tryFailure(annotateConnectException(t, remoteAddress));
                }
            }
        }

        private void fulfillConnectPromise(ChannelPromise promise, boolean wasActive) {
            if (promise != null) {
                AbstractKQueueChannel.this.active = true;
                boolean active = AbstractKQueueChannel.this.isActive();
                boolean promiseSet = promise.trySuccess();
                if (!wasActive && active) {
                    AbstractKQueueChannel.this.pipeline().fireChannelActive();
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

        private void finishConnect() {
            if ($assertionsDisabled || AbstractKQueueChannel.this.eventLoop().inEventLoop()) {
                try {
                    boolean wasActive = AbstractKQueueChannel.this.isActive();
                    if (doFinishConnect()) {
                        fulfillConnectPromise(AbstractKQueueChannel.this.connectPromise, wasActive);
                        if (0 == 0) {
                            if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
                                AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
                            }
                            AbstractKQueueChannel.this.connectPromise = null;
                        }
                    } else if (1 == 0) {
                        if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
                            AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
                        }
                        AbstractKQueueChannel.this.connectPromise = null;
                    }
                } catch (Throwable th) {
                    if (0 == 0) {
                        if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
                            AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
                        }
                        AbstractKQueueChannel.this.connectPromise = null;
                    }
                    throw th;
                }
            } else {
                throw new AssertionError();
            }
        }

        private boolean doFinishConnect() throws Exception {
            if (AbstractKQueueChannel.this.socket.finishConnect()) {
                AbstractKQueueChannel.this.writeFilter(false);
                if (AbstractKQueueChannel.this.requestedRemoteAddress instanceof InetSocketAddress) {
                    AbstractKQueueChannel.this.remote = UnixChannelUtil.computeRemoteAddr((InetSocketAddress) AbstractKQueueChannel.this.requestedRemoteAddress, AbstractKQueueChannel.this.socket.remoteAddress());
                }
                AbstractKQueueChannel.this.requestedRemoteAddress = null;
                return true;
            }
            AbstractKQueueChannel.this.writeFilter(true);
            return false;
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress local) throws Exception {
        if (local instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) local);
        }
        this.socket.bind(local);
        this.local = this.socket.localAddress();
    }

    protected boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (localAddress instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) localAddress);
        }
        InetSocketAddress remoteSocketAddr = remoteAddress instanceof InetSocketAddress ? (InetSocketAddress) remoteAddress : null;
        if (remoteSocketAddr != null) {
            checkResolvable(remoteSocketAddr);
        }
        if (this.remote != null) {
            throw new AlreadyConnectedException();
        }
        if (localAddress != null) {
            this.socket.bind(localAddress);
        }
        boolean connected = doConnect0(remoteAddress, localAddress);
        if (connected) {
            this.remote = remoteSocketAddr == null ? remoteAddress : UnixChannelUtil.computeRemoteAddr(remoteSocketAddr, this.socket.remoteAddress());
        }
        this.local = this.socket.localAddress();
        return connected;
    }

    protected boolean doConnect0(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        boolean success = false;
        try {
            boolean connected = this.socket.connect(remoteAddress);
            if (!connected) {
                writeFilter(true);
            }
            success = true;
            return connected;
        } finally {
            if (!success) {
                doClose();
            }
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.local;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.remote;
    }
}
