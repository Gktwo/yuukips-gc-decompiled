package p013io.netty.channel.nio;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.FileRegion;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.nio.AbstractNioChannel;
import p013io.netty.channel.socket.ChannelInputShutdownEvent;
import p013io.netty.channel.socket.ChannelInputShutdownReadComplete;
import p013io.netty.channel.socket.SocketChannelConfig;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.channel.nio.AbstractNioByteChannel */
/* loaded from: grasscutter.jar:io/netty/channel/nio/AbstractNioByteChannel.class */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';
    private final Runnable flushTask = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
        @Override // java.lang.Runnable
        public void run() {
            ((AbstractNioChannel.AbstractNioUnsafe) AbstractNioByteChannel.this.unsafe()).flush0();
        }
    };
    private boolean inputClosedSeenErrorOnRead;

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.socket.DuplexChannel
    public abstract ChannelFuture shutdownInput();

    protected abstract long doWriteFileRegion(FileRegion fileRegion) throws Exception;

    protected abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    protected abstract int doWriteBytes(ByteBuf byteBuf) throws Exception;

    /* access modifiers changed from: protected */
    public AbstractNioByteChannel(Channel parent, SelectableChannel ch) {
        super(parent, ch, 1);
    }

    protected boolean isInputShutdown0() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    final boolean shouldBreakReadReady(ChannelConfig config) {
        return isInputShutdown0() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(config));
    }

    /* access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig config) {
        return (config instanceof SocketChannelConfig) && ((SocketChannelConfig) config).isAllowHalfClosure();
    }

    /* access modifiers changed from: protected */
    /* renamed from: io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe.class */
    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        /* access modifiers changed from: protected */
        public NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline pipeline) {
            if (AbstractNioByteChannel.this.isInputShutdown0()) {
                AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                pipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
            } else if (AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config())) {
                AbstractNioByteChannel.this.shutdownInput();
                pipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            } else {
                close(voidPromise());
            }
        }

        private void handleReadException(ChannelPipeline pipeline, ByteBuf byteBuf, Throwable cause, boolean close, RecvByteBufAllocator.Handle allocHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    pipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            allocHandle.readComplete();
            pipeline.fireChannelReadComplete();
            pipeline.fireExceptionCaught(cause);
            if (close || (cause instanceof OutOfMemoryError) || (cause instanceof IOException)) {
                closeOnRead(pipeline);
            }
        }

        @Override // p013io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void read() {
            ChannelConfig config = AbstractNioByteChannel.this.config();
            if (AbstractNioByteChannel.this.shouldBreakReadReady(config)) {
                AbstractNioByteChannel.this.clearReadPending();
                return;
            }
            ChannelPipeline pipeline = AbstractNioByteChannel.this.pipeline();
            ByteBufAllocator allocator = config.getAllocator();
            RecvByteBufAllocator.Handle allocHandle = recvBufAllocHandle();
            allocHandle.reset(config);
            boolean close = false;
            while (true) {
                try {
                    ByteBuf byteBuf = allocHandle.allocate(allocator);
                    allocHandle.lastBytesRead(AbstractNioByteChannel.this.doReadBytes(byteBuf));
                    if (allocHandle.lastBytesRead() > 0) {
                        allocHandle.incMessagesRead(1);
                        AbstractNioByteChannel.this.readPending = false;
                        pipeline.fireChannelRead((Object) byteBuf);
                        if (!allocHandle.continueReading()) {
                            break;
                        }
                    } else {
                        byteBuf.release();
                        close = allocHandle.lastBytesRead() < 0;
                        if (close) {
                            AbstractNioByteChannel.this.readPending = false;
                        }
                    }
                } catch (Throwable th) {
                    if (!AbstractNioByteChannel.this.readPending && !config.isAutoRead()) {
                        removeReadOp();
                    }
                    throw th;
                }
            }
            allocHandle.readComplete();
            pipeline.fireChannelReadComplete();
            if (close) {
                closeOnRead(pipeline);
            }
            if (!AbstractNioByteChannel.this.readPending && !config.isAutoRead()) {
                removeReadOp();
            }
        }
    }

    protected final int doWrite0(ChannelOutboundBuffer in) throws Exception {
        if (in.current() == null) {
            return 0;
        }
        return doWriteInternal(in, in.current());
    }

    private int doWriteInternal(ChannelOutboundBuffer in, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            if (!buf.isReadable()) {
                in.remove();
                return 0;
            }
            int localFlushedAmount = doWriteBytes(buf);
            if (localFlushedAmount <= 0) {
                return Integer.MAX_VALUE;
            }
            in.progress((long) localFlushedAmount);
            if (buf.isReadable()) {
                return 1;
            }
            in.remove();
            return 1;
        } else if (msg instanceof FileRegion) {
            FileRegion region = (FileRegion) msg;
            if (region.transferred() >= region.count()) {
                in.remove();
                return 0;
            }
            long localFlushedAmount2 = doWriteFileRegion(region);
            if (localFlushedAmount2 <= 0) {
                return Integer.MAX_VALUE;
            }
            in.progress(localFlushedAmount2);
            if (region.transferred() < region.count()) {
                return 1;
            }
            in.remove();
            return 1;
        } else {
            throw new Error();
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        int writeSpinCount = config().getWriteSpinCount();
        do {
            Object msg = in.current();
            if (msg == null) {
                clearOpWrite();
                return;
            }
            writeSpinCount -= doWriteInternal(in, msg);
        } while (writeSpinCount > 0);
        incompleteWrite(writeSpinCount < 0);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object msg) {
        if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            if (buf.isDirect()) {
                return msg;
            }
            return newDirectBuffer(buf);
        } else if (msg instanceof FileRegion) {
            return msg;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
        }
    }

    protected final void incompleteWrite(boolean setOpWrite) {
        if (setOpWrite) {
            setOpWrite();
            return;
        }
        clearOpWrite();
        eventLoop().execute(this.flushTask);
    }

    protected final void setOpWrite() {
        SelectionKey key = selectionKey();
        if (key.isValid()) {
            int interestOps = key.interestOps();
            if ((interestOps & 4) == 0) {
                key.interestOps(interestOps | 4);
            }
        }
    }

    protected final void clearOpWrite() {
        SelectionKey key = selectionKey();
        if (key.isValid()) {
            int interestOps = key.interestOps();
            if ((interestOps & 4) != 0) {
                key.interestOps(interestOps & -5);
            }
        }
    }
}
