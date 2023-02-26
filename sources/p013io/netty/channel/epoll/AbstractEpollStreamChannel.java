package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.Queue;
import java.util.concurrent.Executor;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultFileRegion;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.FileRegion;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.epoll.AbstractEpollChannel;
import p013io.netty.channel.socket.DuplexChannel;
import p013io.netty.channel.unix.FileDescriptor;
import p013io.netty.channel.unix.IovArray;
import p013io.netty.channel.unix.SocketWritableByteChannel;
import p013io.netty.channel.unix.UnixChannelUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.epoll.AbstractEpollStreamChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollStreamChannel.class */
public abstract class AbstractEpollStreamChannel extends AbstractEpollChannel implements DuplexChannel {
    private static final ChannelMetadata METADATA;
    private static final String EXPECTED_TYPES;
    private static final InternalLogger logger;
    private final Runnable flushTask;
    private volatile Queue<SpliceInTask> spliceQueue;
    private FileDescriptor pipeIn;
    private FileDescriptor pipeOut;
    private WritableByteChannel byteChannel;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return isOpen();
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return isActive();
    }

    static {
        $assertionsDisabled = !AbstractEpollStreamChannel.class.desiredAssertionStatus();
        METADATA = new ChannelMetadata(false, 16);
        EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')';
        logger = InternalLoggerFactory.getInstance(AbstractEpollStreamChannel.class);
    }

    protected AbstractEpollStreamChannel(Channel parent, int fd) {
        this(parent, new LinuxSocket(fd));
    }

    /* access modifiers changed from: protected */
    public AbstractEpollStreamChannel(int fd) {
        this(new LinuxSocket(fd));
    }

    AbstractEpollStreamChannel(LinuxSocket fd) {
        this(fd, isSoErrorZero(fd));
    }

    /* access modifiers changed from: package-private */
    public AbstractEpollStreamChannel(Channel parent, LinuxSocket fd) {
        super(parent, fd, true);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    /* access modifiers changed from: package-private */
    public AbstractEpollStreamChannel(Channel parent, LinuxSocket fd, SocketAddress remote) {
        super(parent, fd, remote);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    /* access modifiers changed from: protected */
    public AbstractEpollStreamChannel(LinuxSocket fd, boolean active) {
        super((Channel) null, fd, active);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollStreamUnsafe();
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel ch, int len) {
        return spliceTo(ch, len, newPromise());
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel ch, int len, ChannelPromise promise) {
        if (ch.eventLoop() != eventLoop()) {
            throw new IllegalArgumentException("EventLoops are not the same.");
        }
        ObjectUtil.checkPositiveOrZero(len, "len");
        if (ch.config().getEpollMode() == EpollMode.LEVEL_TRIGGERED && config().getEpollMode() == EpollMode.LEVEL_TRIGGERED) {
            ObjectUtil.checkNotNull(promise, "promise");
            if (!isOpen()) {
                promise.tryFailure(new ClosedChannelException());
            } else {
                addToSpliceQueue(new SpliceInChannelTask(ch, len, promise));
                failSpliceIfClosed(promise);
            }
            return promise;
        }
        throw new IllegalStateException("spliceTo() supported only when using " + EpollMode.LEVEL_TRIGGERED);
    }

    public final ChannelFuture spliceTo(FileDescriptor ch, int offset, int len) {
        return spliceTo(ch, offset, len, newPromise());
    }

    public final ChannelFuture spliceTo(FileDescriptor ch, int offset, int len, ChannelPromise promise) {
        ObjectUtil.checkPositiveOrZero(len, "len");
        ObjectUtil.checkPositiveOrZero(offset, "offset");
        if (config().getEpollMode() != EpollMode.LEVEL_TRIGGERED) {
            throw new IllegalStateException("spliceTo() supported only when using " + EpollMode.LEVEL_TRIGGERED);
        }
        ObjectUtil.checkNotNull(promise, "promise");
        if (!isOpen()) {
            promise.tryFailure(new ClosedChannelException());
        } else {
            addToSpliceQueue(new SpliceFdTask(ch, offset, len, promise));
            failSpliceIfClosed(promise);
        }
        return promise;
    }

    private void failSpliceIfClosed(ChannelPromise promise) {
        if (!isOpen() && promise.tryFailure(new ClosedChannelException())) {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.clearSpliceQueue();
                }
            });
        }
    }

    private int writeBytes(ChannelOutboundBuffer in, ByteBuf buf) throws Exception {
        int readableBytes = buf.readableBytes();
        if (readableBytes == 0) {
            in.remove();
            return 0;
        } else if (buf.hasMemoryAddress() || buf.nioBufferCount() == 1) {
            return doWriteBytes(in, buf);
        } else {
            ByteBuffer[] nioBuffers = buf.nioBuffers();
            return writeBytesMultiple(in, nioBuffers, nioBuffers.length, (long) readableBytes, config().getMaxBytesPerGatheringWrite());
        }
    }

    private void adjustMaxBytesPerGatheringWrite(long attempted, long written, long oldMaxBytesPerGatheringWrite) {
        if (attempted == written) {
            if ((attempted << 1) > oldMaxBytesPerGatheringWrite) {
                config().setMaxBytesPerGatheringWrite(attempted << 1);
            }
        } else if (attempted > 4096 && written < (attempted >>> 1)) {
            config().setMaxBytesPerGatheringWrite(attempted >>> 1);
        }
    }

    private int writeBytesMultiple(ChannelOutboundBuffer in, IovArray array) throws IOException {
        long expectedWrittenBytes = array.size();
        if ($assertionsDisabled || expectedWrittenBytes != 0) {
            int cnt = array.count();
            if ($assertionsDisabled || cnt != 0) {
                long localWrittenBytes = this.socket.writevAddresses(array.memoryAddress(0), cnt);
                if (localWrittenBytes <= 0) {
                    return Integer.MAX_VALUE;
                }
                adjustMaxBytesPerGatheringWrite(expectedWrittenBytes, localWrittenBytes, array.maxBytes());
                in.removeBytes(localWrittenBytes);
                return 1;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [io.netty.channel.epoll.AbstractEpollStreamChannel] */
    /* JADX WARN: Type inference failed for: r14v0, types: [long] */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int writeBytesMultiple(p013io.netty.channel.ChannelOutboundBuffer r9, java.nio.ByteBuffer[] r10, int r11, long r12, long r14) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = p013io.netty.channel.epoll.AbstractEpollStreamChannel.$assertionsDisabled
            if (r0 != 0) goto L_0x0015
            r0 = r12
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0015
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0015:
            r0 = r12
            r1 = r14
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0021
            r0 = r14
            r12 = r0
        L_0x0021:
            r0 = r8
            io.netty.channel.epoll.LinuxSocket r0 = r0.socket
            r1 = r10
            r2 = 0
            r3 = r11
            r4 = r12
            long r0 = r0.writev(r1, r2, r3, r4)
            r16 = r0
            r0 = r16
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0048
            r0 = r8
            r1 = r12
            r2 = r16
            r3 = r14
            r0.adjustMaxBytesPerGatheringWrite(r1, r2, r3)
            r0 = r9
            r1 = r16
            r0.removeBytes(r1)
            r0 = 1
            return r0
        L_0x0048:
            r0 = 2147483647(0x7fffffff, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.epoll.AbstractEpollStreamChannel.writeBytesMultiple(io.netty.channel.ChannelOutboundBuffer, java.nio.ByteBuffer[], int, long, long):int");
    }

    private int writeDefaultFileRegion(ChannelOutboundBuffer in, DefaultFileRegion region) throws Exception {
        long offset = region.transferred();
        long regionCount = region.count();
        if (offset >= regionCount) {
            in.remove();
            return 0;
        }
        long flushedAmount = this.socket.sendFile(region, region.position(), offset, regionCount - offset);
        if (flushedAmount > 0) {
            in.progress(flushedAmount);
            if (region.transferred() < regionCount) {
                return 1;
            }
            in.remove();
            return 1;
        } else if (flushedAmount != 0) {
            return Integer.MAX_VALUE;
        } else {
            validateFileRegion(region, offset);
            return Integer.MAX_VALUE;
        }
    }

    private int writeFileRegion(ChannelOutboundBuffer in, FileRegion region) throws Exception {
        if (region.transferred() >= region.count()) {
            in.remove();
            return 0;
        }
        if (this.byteChannel == null) {
            this.byteChannel = new EpollSocketWritableByteChannel();
        }
        long flushedAmount = region.transferTo(this.byteChannel, region.transferred());
        if (flushedAmount <= 0) {
            return Integer.MAX_VALUE;
        }
        in.progress(flushedAmount);
        if (region.transferred() < region.count()) {
            return 1;
        }
        in.remove();
        return 1;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        int writeSpinCount = config().getWriteSpinCount();
        do {
            int msgCount = in.size();
            if (msgCount > 1 && (in.current() instanceof ByteBuf)) {
                writeSpinCount -= doWriteMultiple(in);
            } else if (msgCount == 0) {
                clearFlag(Native.EPOLLOUT);
                return;
            } else {
                writeSpinCount -= doWriteSingle(in);
            }
        } while (writeSpinCount > 0);
        if (writeSpinCount == 0) {
            clearFlag(Native.EPOLLOUT);
            eventLoop().execute(this.flushTask);
            return;
        }
        setFlag(Native.EPOLLOUT);
    }

    /* access modifiers changed from: protected */
    public int doWriteSingle(ChannelOutboundBuffer in) throws Exception {
        Object msg = in.current();
        if (msg instanceof ByteBuf) {
            return writeBytes(in, (ByteBuf) msg);
        }
        if (msg instanceof DefaultFileRegion) {
            return writeDefaultFileRegion(in, (DefaultFileRegion) msg);
        }
        if (msg instanceof FileRegion) {
            return writeFileRegion(in, (FileRegion) msg);
        }
        if (!(msg instanceof SpliceOutTask)) {
            throw new Error();
        } else if (!((SpliceOutTask) msg).spliceOut()) {
            return Integer.MAX_VALUE;
        } else {
            in.remove();
            return 1;
        }
    }

    private int doWriteMultiple(ChannelOutboundBuffer in) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray array = ((EpollEventLoop) eventLoop()).cleanIovArray();
        array.maxBytes(maxBytesPerGatheringWrite);
        in.forEachFlushedMessage(array);
        if (array.count() >= 1) {
            return writeBytesMultiple(in, array);
        }
        in.removeBytes(0);
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object msg) {
        if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            return UnixChannelUtil.isBufferCopyNeededForWrite(buf) ? newDirectBuffer(buf) : buf;
        } else if ((msg instanceof FileRegion) || (msg instanceof SpliceOutTask)) {
            return msg;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final void doShutdownOutput() throws Exception {
        this.socket.shutdown(false, true);
    }

    /* access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise promise) {
        try {
            this.socket.shutdown(true, false);
            promise.setSuccess();
        } catch (Throwable cause) {
            promise.setFailure(cause);
        }
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        return this.socket.isShutdown();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise promise) {
        EventLoop loop = eventLoop();
        if (loop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(promise);
        } else {
            loop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    ((AbstractChannel.AbstractUnsafe) AbstractEpollStreamChannel.this.unsafe()).shutdownOutput(promise);
                }
            });
        }
        return promise;
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise promise) {
        Executor closeExecutor = ((EpollStreamUnsafe) unsafe()).prepareToClose();
        if (closeExecutor != null) {
            closeExecutor.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.shutdownInput0(promise);
                }
            });
        } else {
            EventLoop loop = eventLoop();
            if (loop.inEventLoop()) {
                shutdownInput0(promise);
            } else {
                loop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractEpollStreamChannel.this.shutdownInput0(promise);
                    }
                });
            }
        }
        return promise;
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise promise) {
        ChannelFuture shutdownOutputFuture = shutdownOutput();
        if (shutdownOutputFuture.isDone()) {
            shutdownOutputDone(shutdownOutputFuture, promise);
        } else {
            shutdownOutputFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.6
                public void operationComplete(ChannelFuture shutdownOutputFuture2) throws Exception {
                    AbstractEpollStreamChannel.this.shutdownOutputDone(shutdownOutputFuture2, promise);
                }
            });
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture shutdownOutputFuture, final ChannelPromise promise) {
        ChannelFuture shutdownInputFuture = shutdownInput();
        if (shutdownInputFuture.isDone()) {
            shutdownDone(shutdownOutputFuture, shutdownInputFuture, promise);
        } else {
            shutdownInputFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.7
                public void operationComplete(ChannelFuture shutdownInputFuture2) throws Exception {
                    AbstractEpollStreamChannel.shutdownDone(shutdownOutputFuture, shutdownInputFuture2, promise);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture shutdownOutputFuture, ChannelFuture shutdownInputFuture, ChannelPromise promise) {
        Throwable shutdownOutputCause = shutdownOutputFuture.cause();
        Throwable shutdownInputCause = shutdownInputFuture.cause();
        if (shutdownOutputCause != null) {
            if (shutdownInputCause != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", shutdownInputCause);
            }
            promise.setFailure(shutdownOutputCause);
        } else if (shutdownInputCause != null) {
            promise.setFailure(shutdownInputCause);
        } else {
            promise.setSuccess();
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        try {
            doClose();
        } finally {
            safeClosePipe(this.pipeIn);
            safeClosePipe(this.pipeOut);
            clearSpliceQueue();
        }
    }

    /* access modifiers changed from: private */
    public void clearSpliceQueue() {
        Queue<SpliceInTask> sQueue = this.spliceQueue;
        if (sQueue != null) {
            ClosedChannelException exception = null;
            while (true) {
                SpliceInTask task = sQueue.poll();
                if (task != null) {
                    if (exception == null) {
                        exception = new ClosedChannelException();
                    }
                    task.promise.tryFailure(exception);
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void safeClosePipe(FileDescriptor fd) {
        if (fd != null) {
            try {
                fd.close();
            } catch (IOException e) {
                logger.warn("Error while closing a pipe", (Throwable) e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.epoll.AbstractEpollStreamChannel$EpollStreamUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollStreamChannel$EpollStreamUnsafe.class */
    public class EpollStreamUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        /* access modifiers changed from: package-private */
        public EpollStreamUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            return prepareToClose();
        }

        private void handleReadException(ChannelPipeline pipeline, ByteBuf byteBuf, Throwable cause, boolean close, EpollRecvByteAllocatorHandle allocHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    pipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            allocHandle.readComplete();
            pipeline.fireChannelReadComplete();
            pipeline.fireExceptionCaught(cause);
            if (close || (cause instanceof OutOfMemoryError) || (cause instanceof IOException)) {
                shutdownInput(false);
            }
        }

        @Override // p013io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle handle) {
            return new EpollRecvByteAllocatorStreamingHandle(handle);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x005c, code lost:
            if (r0 != null) goto L_0x005f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0109 A[EDGE_INSN: B:56:0x0109->B:35:0x0109 ?: BREAK  , SYNTHETIC] */
        @Override // p013io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void epollInReady() {
            /*
            // Method dump skipped, instructions count: 399
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe.epollInReady():void");
        }
    }

    private void addToSpliceQueue(SpliceInTask task) {
        Queue<SpliceInTask> sQueue = this.spliceQueue;
        if (sQueue == null) {
            synchronized (this) {
                sQueue = this.spliceQueue;
                if (sQueue == null) {
                    Queue<SpliceInTask> newMpscQueue = PlatformDependent.newMpscQueue();
                    sQueue = newMpscQueue;
                    this.spliceQueue = newMpscQueue;
                }
            }
        }
        sQueue.add(task);
    }

    /* access modifiers changed from: protected */
    /* renamed from: io.netty.channel.epoll.AbstractEpollStreamChannel$SpliceInTask */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollStreamChannel$SpliceInTask.class */
    public abstract class SpliceInTask {
        final ChannelPromise promise;
        int len;

        abstract boolean spliceIn(RecvByteBufAllocator.Handle handle);

        protected SpliceInTask(int len, ChannelPromise promise) {
            this.promise = promise;
            this.len = len;
        }

        protected final int spliceIn(FileDescriptor pipeOut, RecvByteBufAllocator.Handle handle) throws IOException {
            int length = Math.min(handle.guess(), this.len);
            int splicedIn = 0;
            while (true) {
                int localSplicedIn = Native.splice(AbstractEpollStreamChannel.this.socket.intValue(), -1, pipeOut.intValue(), -1, (long) length);
                handle.lastBytesRead(localSplicedIn);
                if (localSplicedIn == 0) {
                    return splicedIn;
                }
                splicedIn += localSplicedIn;
                length -= localSplicedIn;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.epoll.AbstractEpollStreamChannel$SpliceInChannelTask */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollStreamChannel$SpliceInChannelTask.class */
    public final class SpliceInChannelTask extends SpliceInTask implements ChannelFutureListener {

        /* renamed from: ch */
        private final AbstractEpollStreamChannel f945ch;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !AbstractEpollStreamChannel.class.desiredAssertionStatus();
        }

        SpliceInChannelTask(AbstractEpollStreamChannel ch, int len, ChannelPromise promise) {
            super(len, promise);
            this.f945ch = ch;
        }

        public void operationComplete(ChannelFuture future) throws Exception {
            if (!future.isSuccess()) {
                this.promise.setFailure(future.cause());
            }
        }

        @Override // p013io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            ChannelPromise splicePromise;
            if (!$assertionsDisabled && !this.f945ch.eventLoop().inEventLoop()) {
                throw new AssertionError();
            } else if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            } else {
                try {
                    FileDescriptor pipeOut = this.f945ch.pipeOut;
                    if (pipeOut == null) {
                        FileDescriptor[] pipe = FileDescriptor.pipe();
                        this.f945ch.pipeIn = pipe[0];
                        pipeOut = this.f945ch.pipeOut = pipe[1];
                    }
                    int splicedIn = spliceIn(pipeOut, handle);
                    if (splicedIn > 0) {
                        if (this.len != Integer.MAX_VALUE) {
                            this.len -= splicedIn;
                        }
                        if (this.len == 0) {
                            splicePromise = this.promise;
                        } else {
                            splicePromise = this.f945ch.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
                        }
                        boolean autoRead = AbstractEpollStreamChannel.this.config().isAutoRead();
                        this.f945ch.unsafe().write(new SpliceOutTask(this.f945ch, splicedIn, autoRead), splicePromise);
                        this.f945ch.unsafe().flush();
                        if (autoRead && !splicePromise.isDone()) {
                            AbstractEpollStreamChannel.this.config().setAutoRead(false);
                        }
                    }
                    return this.len == 0;
                } catch (Throwable cause) {
                    this.promise.setFailure(cause);
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.epoll.AbstractEpollStreamChannel$SpliceOutTask */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollStreamChannel$SpliceOutTask.class */
    public final class SpliceOutTask {

        /* renamed from: ch */
        private final AbstractEpollStreamChannel f946ch;
        private final boolean autoRead;
        private int len;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !AbstractEpollStreamChannel.class.desiredAssertionStatus();
        }

        SpliceOutTask(AbstractEpollStreamChannel ch, int len, boolean autoRead) {
            this.f946ch = ch;
            this.len = len;
            this.autoRead = autoRead;
        }

        public boolean spliceOut() throws Exception {
            if ($assertionsDisabled || this.f946ch.eventLoop().inEventLoop()) {
                try {
                    this.len -= Native.splice(this.f946ch.pipeIn.intValue(), -1, this.f946ch.socket.intValue(), -1, (long) this.len);
                    if (this.len != 0) {
                        return false;
                    }
                    if (!this.autoRead) {
                        return true;
                    }
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                    return true;
                } catch (IOException e) {
                    if (this.autoRead) {
                        AbstractEpollStreamChannel.this.config().setAutoRead(true);
                    }
                    throw e;
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.epoll.AbstractEpollStreamChannel$SpliceFdTask */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollStreamChannel$SpliceFdTask.class */
    public final class SpliceFdTask extends SpliceInTask {

        /* renamed from: fd */
        private final FileDescriptor f944fd;
        private final ChannelPromise promise;
        private int offset;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !AbstractEpollStreamChannel.class.desiredAssertionStatus();
        }

        SpliceFdTask(FileDescriptor fd, int offset, int len, ChannelPromise promise) {
            super(len, promise);
            this.f944fd = fd;
            this.promise = promise;
            this.offset = offset;
        }

        @Override // p013io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            if (!$assertionsDisabled && !AbstractEpollStreamChannel.this.eventLoop().inEventLoop()) {
                throw new AssertionError();
            } else if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            } else {
                try {
                    FileDescriptor[] pipe = FileDescriptor.pipe();
                    FileDescriptor pipeIn = pipe[0];
                    FileDescriptor pipeOut = pipe[1];
                    int splicedIn = spliceIn(pipeOut, handle);
                    if (splicedIn > 0) {
                        if (this.len != Integer.MAX_VALUE) {
                            this.len -= splicedIn;
                        }
                        do {
                            int splicedOut = Native.splice(pipeIn.intValue(), -1, this.f944fd.intValue(), (long) this.offset, (long) splicedIn);
                            this.offset += splicedOut;
                            splicedIn -= splicedOut;
                        } while (splicedIn > 0);
                        if (this.len == 0) {
                            this.promise.setSuccess();
                            AbstractEpollStreamChannel.safeClosePipe(pipeIn);
                            AbstractEpollStreamChannel.safeClosePipe(pipeOut);
                            return true;
                        }
                    }
                    AbstractEpollStreamChannel.safeClosePipe(pipeIn);
                    AbstractEpollStreamChannel.safeClosePipe(pipeOut);
                    return false;
                } catch (Throwable cause) {
                    this.promise.setFailure(cause);
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.epoll.AbstractEpollStreamChannel$EpollSocketWritableByteChannel */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollStreamChannel$EpollSocketWritableByteChannel.class */
    public final class EpollSocketWritableByteChannel extends SocketWritableByteChannel {
        EpollSocketWritableByteChannel() {
            super(AbstractEpollStreamChannel.this.socket);
        }

        @Override // p013io.netty.channel.unix.SocketWritableByteChannel
        protected ByteBufAllocator alloc() {
            return AbstractEpollStreamChannel.this.alloc();
        }
    }
}
