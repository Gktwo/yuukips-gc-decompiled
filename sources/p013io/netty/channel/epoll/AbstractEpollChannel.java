package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
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
import p013io.netty.channel.unix.IovArray;
import p013io.netty.channel.unix.Socket;
import p013io.netty.channel.unix.UnixChannel;
import p013io.netty.channel.unix.UnixChannelUtil;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.epoll.AbstractEpollChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollChannel.class */
public abstract class AbstractEpollChannel extends AbstractChannel implements UnixChannel {
    private static final ChannelMetadata METADATA;
    final LinuxSocket socket;
    private ChannelPromise connectPromise;
    private Future<?> connectTimeoutFuture;
    private SocketAddress requestedRemoteAddress;
    private volatile SocketAddress local;
    private volatile SocketAddress remote;
    protected int flags;
    boolean inputClosedSeenErrorOnRead;
    boolean epollInReadyRunnablePending;
    protected volatile boolean active;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Override // p013io.netty.channel.Channel
    public abstract EpollChannelConfig config();

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.AbstractChannel
    public abstract AbstractEpollUnsafe newUnsafe();

    static {
        $assertionsDisabled = !AbstractEpollChannel.class.desiredAssertionStatus();
        METADATA = new ChannelMetadata(false);
    }

    AbstractEpollChannel(LinuxSocket fd) {
        this((Channel) null, fd, false);
    }

    /* access modifiers changed from: package-private */
    public AbstractEpollChannel(Channel parent, LinuxSocket fd, boolean active) {
        super(parent);
        this.flags = Native.EPOLLET;
        this.socket = (LinuxSocket) ObjectUtil.checkNotNull(fd, "fd");
        this.active = active;
        if (active) {
            this.local = fd.localAddress();
            this.remote = fd.remoteAddress();
        }
    }

    /* access modifiers changed from: package-private */
    public AbstractEpollChannel(Channel parent, LinuxSocket fd, SocketAddress remote) {
        super(parent);
        this.flags = Native.EPOLLET;
        this.socket = (LinuxSocket) ObjectUtil.checkNotNull(fd, "fd");
        this.active = true;
        this.remote = remote;
        this.local = fd.localAddress();
    }

    static boolean isSoErrorZero(Socket fd) {
        try {
            return fd.getSoError() == 0;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void setFlag(int flag) throws IOException {
        if (!isFlagSet(flag)) {
            this.flags |= flag;
            modifyEvents();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearFlag(int flag) throws IOException {
        if (isFlagSet(flag)) {
            this.flags &= flag ^ -1;
            modifyEvents();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isFlagSet(int flag) {
        return (this.flags & flag) != 0;
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

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        this.active = false;
        this.inputClosedSeenErrorOnRead = true;
        try {
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
            if (isRegistered()) {
                EventLoop loop = eventLoop();
                if (loop.inEventLoop()) {
                    doDeregister();
                } else {
                    loop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AbstractEpollChannel.this.doDeregister();
                            } catch (Throwable cause) {
                                AbstractEpollChannel.this.pipeline().fireExceptionCaught(cause);
                            }
                        }
                    });
                }
            }
        } finally {
            this.socket.close();
        }
    }

    void resetCachedAddresses() {
        this.local = this.socket.localAddress();
        this.remote = this.socket.remoteAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof EpollEventLoop;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return this.socket.isOpen();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        ((EpollEventLoop) eventLoop()).remove(this);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final void doBeginRead() throws Exception {
        AbstractEpollUnsafe unsafe = (AbstractEpollUnsafe) unsafe();
        unsafe.readPending = true;
        setFlag(Native.EPOLLIN);
        if (unsafe.maybeMoreDataToRead) {
            unsafe.executeEpollInReadyRunnable(config());
        }
    }

    final boolean shouldBreakEpollInReady(ChannelConfig config) {
        return this.socket.isInputShutdown() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(config));
    }

    /* access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig config) {
        if (config instanceof EpollDomainSocketChannelConfig) {
            return ((EpollDomainSocketChannelConfig) config).isAllowHalfClosure();
        }
        return (config instanceof SocketChannelConfig) && ((SocketChannelConfig) config).isAllowHalfClosure();
    }

    /* access modifiers changed from: package-private */
    public final void clearEpollIn() {
        if (isRegistered()) {
            EventLoop loop = eventLoop();
            final AbstractEpollUnsafe unsafe = (AbstractEpollUnsafe) unsafe();
            if (loop.inEventLoop()) {
                unsafe.clearEpollIn0();
            } else {
                loop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!unsafe.readPending && !AbstractEpollChannel.this.config().isAutoRead()) {
                            unsafe.clearEpollIn0();
                        }
                    }
                });
            }
        } else {
            this.flags &= Native.EPOLLIN ^ -1;
        }
    }

    private void modifyEvents() throws IOException {
        if (isOpen() && isRegistered()) {
            ((EpollEventLoop) eventLoop()).modify(this);
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        this.epollInReadyRunnablePending = false;
        ((EpollEventLoop) eventLoop()).add(this);
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

    final long doWriteOrSendBytes(ByteBuf data, InetSocketAddress remoteAddress, boolean fastOpen) throws IOException {
        if (!$assertionsDisabled && fastOpen && remoteAddress == null) {
            throw new AssertionError("fastOpen requires a remote address");
        } else if (data.hasMemoryAddress()) {
            long memoryAddress = data.memoryAddress();
            if (remoteAddress == null) {
                return (long) this.socket.writeAddress(memoryAddress, data.readerIndex(), data.writerIndex());
            }
            return (long) this.socket.sendToAddress(memoryAddress, data.readerIndex(), data.writerIndex(), remoteAddress.getAddress(), remoteAddress.getPort(), fastOpen);
        } else if (data.nioBufferCount() > 1) {
            IovArray array = ((EpollEventLoop) eventLoop()).cleanIovArray();
            array.add(data, data.readerIndex(), data.readableBytes());
            int cnt = array.count();
            if (!$assertionsDisabled && cnt == 0) {
                throw new AssertionError();
            } else if (remoteAddress == null) {
                return this.socket.writevAddresses(array.memoryAddress(0), cnt);
            } else {
                return (long) this.socket.sendToAddresses(array.memoryAddress(0), cnt, remoteAddress.getAddress(), remoteAddress.getPort(), fastOpen);
            }
        } else {
            ByteBuffer nioData = data.internalNioBuffer(data.readerIndex(), data.readableBytes());
            if (remoteAddress == null) {
                return (long) this.socket.write(nioData, nioData.position(), nioData.limit());
            }
            return (long) this.socket.sendTo(nioData, nioData.position(), nioData.limit(), remoteAddress.getAddress(), remoteAddress.getPort(), fastOpen);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: io.netty.channel.epoll.AbstractEpollChannel$AbstractEpollUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe.class */
    public abstract class AbstractEpollUnsafe extends AbstractChannel.AbstractUnsafe {
        boolean readPending;
        boolean maybeMoreDataToRead;
        private EpollRecvByteAllocatorHandle allocHandle;
        private final Runnable epollInReadyRunnable = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractEpollChannel.this.epollInReadyRunnablePending = false;
                AbstractEpollUnsafe.this.epollInReady();
            }
        };
        static final /* synthetic */ boolean $assertionsDisabled;

        /* access modifiers changed from: package-private */
        public abstract void epollInReady();

        /* access modifiers changed from: protected */
        public AbstractEpollUnsafe() {
            super();
        }

        static {
            $assertionsDisabled = !AbstractEpollChannel.class.desiredAssertionStatus();
        }

        final void epollInBefore() {
            this.maybeMoreDataToRead = false;
        }

        final void epollInFinally(ChannelConfig config) {
            this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
            if (this.allocHandle.isReceivedRdHup() || (this.readPending && this.maybeMoreDataToRead)) {
                executeEpollInReadyRunnable(config);
            } else if (!this.readPending && !config.isAutoRead()) {
                AbstractEpollChannel.this.clearEpollIn();
            }
        }

        final void executeEpollInReadyRunnable(ChannelConfig config) {
            if (!AbstractEpollChannel.this.epollInReadyRunnablePending && AbstractEpollChannel.this.isActive() && !AbstractEpollChannel.this.shouldBreakEpollInReady(config)) {
                AbstractEpollChannel.this.epollInReadyRunnablePending = true;
                AbstractEpollChannel.this.eventLoop().execute(this.epollInReadyRunnable);
            }
        }

        /* access modifiers changed from: package-private */
        public final void epollRdHupReady() {
            recvBufAllocHandle().receivedRdHup();
            if (AbstractEpollChannel.this.isActive()) {
                epollInReady();
            } else {
                shutdownInput(true);
            }
            clearEpollRdHup();
        }

        private void clearEpollRdHup() {
            try {
                AbstractEpollChannel.this.clearFlag(Native.EPOLLRDHUP);
            } catch (IOException e) {
                AbstractEpollChannel.this.pipeline().fireExceptionCaught((Throwable) e);
                close(voidPromise());
            }
        }

        void shutdownInput(boolean rdHup) {
            if (!AbstractEpollChannel.this.socket.isInputShutdown()) {
                if (AbstractEpollChannel.isAllowHalfClosure(AbstractEpollChannel.this.config())) {
                    try {
                        AbstractEpollChannel.this.socket.shutdown(true, false);
                    } catch (IOException e) {
                        fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
                        return;
                    } catch (NotYetConnectedException e2) {
                    }
                    AbstractEpollChannel.this.clearEpollIn();
                    AbstractEpollChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
                    return;
                }
                close(voidPromise());
            } else if (!rdHup) {
                AbstractEpollChannel.this.inputClosedSeenErrorOnRead = true;
                AbstractEpollChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
            }
        }

        private void fireEventAndClose(Object evt) {
            AbstractEpollChannel.this.pipeline().fireUserEventTriggered(evt);
            close(voidPromise());
        }

        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe, p013io.netty.channel.Channel.Unsafe
        public EpollRecvByteAllocatorHandle recvBufAllocHandle() {
            if (this.allocHandle == null) {
                this.allocHandle = newEpollHandle((RecvByteBufAllocator.ExtendedHandle) recvBufAllocHandle());
            }
            return this.allocHandle;
        }

        EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle handle) {
            return new EpollRecvByteAllocatorHandle(handle);
        }

        /* access modifiers changed from: protected */
        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe
        public final void flush0() {
            if (!AbstractEpollChannel.this.isFlagSet(Native.EPOLLOUT)) {
                flush0();
            }
        }

        /* access modifiers changed from: package-private */
        public final void epollOutReady() {
            if (AbstractEpollChannel.this.connectPromise != null) {
                finishConnect();
            } else if (!AbstractEpollChannel.this.socket.isOutputShutdown()) {
                flush0();
            }
        }

        protected final void clearEpollIn0() {
            if ($assertionsDisabled || AbstractEpollChannel.this.eventLoop().inEventLoop()) {
                try {
                    this.readPending = false;
                    AbstractEpollChannel.this.clearFlag(Native.EPOLLIN);
                } catch (IOException e) {
                    AbstractEpollChannel.this.pipeline().fireExceptionCaught((Throwable) e);
                    AbstractEpollChannel.this.unsafe().close(AbstractEpollChannel.this.unsafe().voidPromise());
                }
            } else {
                throw new AssertionError();
            }
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public void connect(final SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            if (promise.setUncancellable() && ensureOpen(promise)) {
                try {
                    if (AbstractEpollChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean wasActive = AbstractEpollChannel.this.isActive();
                    if (AbstractEpollChannel.this.doConnect(remoteAddress, localAddress)) {
                        fulfillConnectPromise(promise, wasActive);
                    } else {
                        AbstractEpollChannel.this.connectPromise = promise;
                        AbstractEpollChannel.this.requestedRemoteAddress = remoteAddress;
                        int connectTimeoutMillis = AbstractEpollChannel.this.config().getConnectTimeoutMillis();
                        if (connectTimeoutMillis > 0) {
                            AbstractEpollChannel.this.connectTimeoutFuture = AbstractEpollChannel.this.eventLoop().schedule((Runnable) new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChannelPromise connectPromise = AbstractEpollChannel.this.connectPromise;
                                    if (connectPromise != null && !connectPromise.isDone() && connectPromise.tryFailure(new ConnectTimeoutException("connection timed out: " + remoteAddress))) {
                                        AbstractEpollUnsafe.this.close(AbstractEpollUnsafe.this.voidPromise());
                                    }
                                }
                            }, (long) connectTimeoutMillis, TimeUnit.MILLISECONDS);
                        }
                        promise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.3
                            public void operationComplete(ChannelFuture future) throws Exception {
                                if (future.isCancelled()) {
                                    if (AbstractEpollChannel.this.connectTimeoutFuture != null) {
                                        AbstractEpollChannel.this.connectTimeoutFuture.cancel(false);
                                    }
                                    AbstractEpollChannel.this.connectPromise = null;
                                    AbstractEpollUnsafe.this.close(AbstractEpollUnsafe.this.voidPromise());
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
                AbstractEpollChannel.this.active = true;
                boolean active = AbstractEpollChannel.this.isActive();
                boolean promiseSet = promise.trySuccess();
                if (!wasActive && active) {
                    AbstractEpollChannel.this.pipeline().fireChannelActive();
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
            if ($assertionsDisabled || AbstractEpollChannel.this.eventLoop().inEventLoop()) {
                try {
                    boolean wasActive = AbstractEpollChannel.this.isActive();
                    if (doFinishConnect()) {
                        fulfillConnectPromise(AbstractEpollChannel.this.connectPromise, wasActive);
                        if (0 == 0) {
                            if (AbstractEpollChannel.this.connectTimeoutFuture != null) {
                                AbstractEpollChannel.this.connectTimeoutFuture.cancel(false);
                            }
                            AbstractEpollChannel.this.connectPromise = null;
                        }
                    } else if (1 == 0) {
                        if (AbstractEpollChannel.this.connectTimeoutFuture != null) {
                            AbstractEpollChannel.this.connectTimeoutFuture.cancel(false);
                        }
                        AbstractEpollChannel.this.connectPromise = null;
                    }
                } catch (Throwable th) {
                    if (0 == 0) {
                        if (AbstractEpollChannel.this.connectTimeoutFuture != null) {
                            AbstractEpollChannel.this.connectTimeoutFuture.cancel(false);
                        }
                        AbstractEpollChannel.this.connectPromise = null;
                    }
                    throw th;
                }
            } else {
                throw new AssertionError();
            }
        }

        private boolean doFinishConnect() throws Exception {
            if (AbstractEpollChannel.this.socket.finishConnect()) {
                AbstractEpollChannel.this.clearFlag(Native.EPOLLOUT);
                if (AbstractEpollChannel.this.requestedRemoteAddress instanceof InetSocketAddress) {
                    AbstractEpollChannel.this.remote = UnixChannelUtil.computeRemoteAddr((InetSocketAddress) AbstractEpollChannel.this.requestedRemoteAddress, AbstractEpollChannel.this.socket.remoteAddress());
                }
                AbstractEpollChannel.this.requestedRemoteAddress = null;
                return true;
            }
            AbstractEpollChannel.this.setFlag(Native.EPOLLOUT);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.AbstractChannel
    public void doBind(SocketAddress local) throws Exception {
        if (local instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) local);
        }
        this.socket.bind(local);
        this.local = this.socket.localAddress();
    }

    /* access modifiers changed from: protected */
    public boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
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
        boolean connected = doConnect0(remoteAddress);
        if (connected) {
            this.remote = remoteSocketAddr == null ? remoteAddress : UnixChannelUtil.computeRemoteAddr(remoteSocketAddr, this.socket.remoteAddress());
        }
        this.local = this.socket.localAddress();
        return connected;
    }

    boolean doConnect0(SocketAddress remote) throws Exception {
        boolean success = false;
        try {
            boolean connected = this.socket.connect(remote);
            if (!connected) {
                setFlag(Native.EPOLLOUT);
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
