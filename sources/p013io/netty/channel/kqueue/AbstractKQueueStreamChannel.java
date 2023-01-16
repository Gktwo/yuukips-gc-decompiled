package p013io.netty.channel.kqueue;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.Executor;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultFileRegion;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.FileRegion;
import p013io.netty.channel.kqueue.AbstractKQueueChannel;
import p013io.netty.channel.socket.DuplexChannel;
import p013io.netty.channel.unix.IovArray;
import p013io.netty.channel.unix.SocketWritableByteChannel;
import p013io.netty.channel.unix.UnixChannelUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.kqueue.AbstractKQueueStreamChannel */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/AbstractKQueueStreamChannel.class */
public abstract class AbstractKQueueStreamChannel extends AbstractKQueueChannel implements DuplexChannel {
    private static final InternalLogger logger;
    private static final ChannelMetadata METADATA;
    private static final String EXPECTED_TYPES;
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return isOpen();
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return isActive();
    }

    static {
        $assertionsDisabled = !AbstractKQueueStreamChannel.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(AbstractKQueueStreamChannel.class);
        METADATA = new ChannelMetadata(false, 16);
        EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')';
    }

    /* access modifiers changed from: package-private */
    public AbstractKQueueStreamChannel(Channel parent, BsdSocket fd, boolean active) {
        super(parent, fd, active);
        this.flushTask = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public AbstractKQueueStreamChannel(Channel parent, BsdSocket fd, SocketAddress remote) {
        super(parent, fd, remote);
        this.flushTask = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public AbstractKQueueStreamChannel(BsdSocket fd) {
        this((Channel) null, fd, isSoErrorZero(fd));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueStreamUnsafe();
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
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
    /* JADX WARN: Type inference failed for: r8v0, types: [io.netty.channel.kqueue.AbstractKQueueStreamChannel] */
    /* JADX WARN: Type inference failed for: r14v0, types: [long] */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int writeBytesMultiple(p013io.netty.channel.ChannelOutboundBuffer r9, java.nio.ByteBuffer[] r10, int r11, long r12, long r14) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = p013io.netty.channel.kqueue.AbstractKQueueStreamChannel.$assertionsDisabled
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
            io.netty.channel.kqueue.BsdSocket r0 = r0.socket
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
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.kqueue.AbstractKQueueStreamChannel.writeBytesMultiple(io.netty.channel.ChannelOutboundBuffer, java.nio.ByteBuffer[], int, long, long):int");
    }

    private int writeDefaultFileRegion(ChannelOutboundBuffer in, DefaultFileRegion region) throws Exception {
        long regionCount = region.count();
        long offset = region.transferred();
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
            this.byteChannel = new KQueueSocketWritableByteChannel();
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
                writeFilter(false);
                return;
            } else {
                writeSpinCount -= doWriteSingle(in);
            }
        } while (writeSpinCount > 0);
        if (writeSpinCount == 0) {
            writeFilter(false);
            eventLoop().execute(this.flushTask);
            return;
        }
        writeFilter(true);
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
        throw new Error();
    }

    private int doWriteMultiple(ChannelOutboundBuffer in) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray array = ((KQueueEventLoop) eventLoop()).cleanArray();
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
        } else if (msg instanceof FileRegion) {
            return msg;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final void doShutdownOutput() throws Exception {
        this.socket.shutdown(false, true);
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
            loop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    ((AbstractChannel.AbstractUnsafe) AbstractKQueueStreamChannel.this.unsafe()).shutdownOutput(promise);
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
        EventLoop loop = eventLoop();
        if (loop.inEventLoop()) {
            shutdownInput0(promise);
        } else {
            loop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractKQueueStreamChannel.this.shutdownInput0(promise);
                }
            });
        }
        return promise;
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
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise promise) {
        ChannelFuture shutdownOutputFuture = shutdownOutput();
        if (shutdownOutputFuture.isDone()) {
            shutdownOutputDone(shutdownOutputFuture, promise);
        } else {
            shutdownOutputFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.4
                public void operationComplete(ChannelFuture shutdownOutputFuture2) throws Exception {
                    AbstractKQueueStreamChannel.this.shutdownOutputDone(shutdownOutputFuture2, promise);
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
            shutdownInputFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.5
                public void operationComplete(ChannelFuture shutdownInputFuture2) throws Exception {
                    AbstractKQueueStreamChannel.shutdownDone(shutdownOutputFuture, shutdownInputFuture2, promise);
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

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.kqueue.AbstractKQueueStreamChannel$KQueueStreamUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/kqueue/AbstractKQueueStreamChannel$KQueueStreamUnsafe.class */
    public class KQueueStreamUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        /* access modifiers changed from: package-private */
        public KQueueStreamUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            return prepareToClose();
        }

        /* access modifiers changed from: package-private */
        @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        public void readReady(KQueueRecvByteAllocatorHandle allocHandle) {
            ChannelConfig config = AbstractKQueueStreamChannel.this.config();
            if (AbstractKQueueStreamChannel.this.shouldBreakReadReady(config)) {
                clearReadFilter0();
                return;
            }
            ChannelPipeline pipeline = AbstractKQueueStreamChannel.this.pipeline();
            ByteBufAllocator allocator = config.getAllocator();
            allocHandle.reset(config);
            readReadyBefore();
            boolean close = false;
            while (true) {
                try {
                    ByteBuf byteBuf = allocHandle.allocate(allocator);
                    allocHandle.lastBytesRead(AbstractKQueueStreamChannel.this.doReadBytes(byteBuf));
                    if (allocHandle.lastBytesRead() > 0) {
                        allocHandle.incMessagesRead(1);
                        this.readPending = false;
                        pipeline.fireChannelRead((Object) byteBuf);
                        if (!AbstractKQueueStreamChannel.this.shouldBreakReadReady(config)) {
                            if (!allocHandle.continueReading()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        byteBuf.release();
                        close = allocHandle.lastBytesRead() < 0;
                        if (close) {
                            this.readPending = false;
                        }
                    }
                } finally {
                    readReadyFinally(config);
                }
            }
            allocHandle.readComplete();
            pipeline.fireChannelReadComplete();
            if (close) {
                shutdownInput(false);
            }
        }

        private void handleReadException(ChannelPipeline pipeline, ByteBuf byteBuf, Throwable cause, boolean close, KQueueRecvByteAllocatorHandle allocHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    pipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            if (!failConnectPromise(cause)) {
                allocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                pipeline.fireExceptionCaught(cause);
                if (close || (cause instanceof OutOfMemoryError) || (cause instanceof IOException)) {
                    shutdownInput(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.kqueue.AbstractKQueueStreamChannel$KQueueSocketWritableByteChannel */
    /* loaded from: grasscutter.jar:io/netty/channel/kqueue/AbstractKQueueStreamChannel$KQueueSocketWritableByteChannel.class */
    public final class KQueueSocketWritableByteChannel extends SocketWritableByteChannel {
        KQueueSocketWritableByteChannel() {
            super(AbstractKQueueStreamChannel.this.socket);
        }

        @Override // p013io.netty.channel.unix.SocketWritableByteChannel
        protected ByteBufAllocator alloc() {
            return AbstractKQueueStreamChannel.this.alloc();
        }
    }
}
