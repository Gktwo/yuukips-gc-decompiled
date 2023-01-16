package p013io.netty.channel.oio;

import java.io.IOException;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.FileRegion;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.socket.ChannelInputShutdownEvent;
import p013io.netty.channel.socket.ChannelInputShutdownReadComplete;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.channel.oio.AbstractOioByteChannel */
/* loaded from: grasscutter.jar:io/netty/channel/oio/AbstractOioByteChannel.class */
public abstract class AbstractOioByteChannel extends AbstractOioChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.socket.DuplexChannel
    public abstract boolean isInputShutdown();

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.socket.DuplexChannel
    public abstract ChannelFuture shutdownInput();

    protected abstract int available();

    protected abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    protected abstract void doWriteBytes(ByteBuf byteBuf) throws Exception;

    protected abstract void doWriteFileRegion(FileRegion fileRegion) throws Exception;

    /* access modifiers changed from: protected */
    public AbstractOioByteChannel(Channel parent) {
        super(parent);
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    private void closeOnRead(ChannelPipeline pipeline) {
        if (isOpen()) {
            if (Boolean.TRUE.equals(config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                shutdownInput();
                pipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            } else {
                unsafe().close(unsafe().voidPromise());
            }
            pipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
        }
    }

    private void handleReadException(ChannelPipeline pipeline, ByteBuf byteBuf, Throwable cause, boolean close, RecvByteBufAllocator.Handle allocHandle) {
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
            closeOnRead(pipeline);
        }
    }

    @Override // p013io.netty.channel.oio.AbstractOioChannel
    protected void doRead() {
        ChannelConfig config = config();
        if (!isInputShutdown() && this.readPending) {
            this.readPending = false;
            ChannelPipeline pipeline = pipeline();
            ByteBufAllocator allocator = config.getAllocator();
            RecvByteBufAllocator.Handle allocHandle = unsafe().recvBufAllocHandle();
            allocHandle.reset(config);
            boolean close = false;
            boolean readData = false;
            try {
                ByteBuf byteBuf = allocHandle.allocate(allocator);
                while (true) {
                    allocHandle.lastBytesRead(doReadBytes(byteBuf));
                    if (allocHandle.lastBytesRead() > 0) {
                        readData = true;
                        int available = available();
                        if (available <= 0) {
                            break;
                        }
                        if (!byteBuf.isWritable()) {
                            int capacity = byteBuf.capacity();
                            int maxCapacity = byteBuf.maxCapacity();
                            if (capacity == maxCapacity) {
                                allocHandle.incMessagesRead(1);
                                this.readPending = false;
                                pipeline.fireChannelRead((Object) byteBuf);
                                byteBuf = allocHandle.allocate(allocator);
                            } else if (byteBuf.writerIndex() + available > maxCapacity) {
                                byteBuf.capacity(maxCapacity);
                            } else {
                                byteBuf.ensureWritable(available);
                            }
                        }
                        if (!allocHandle.continueReading()) {
                            break;
                        }
                    } else if (!byteBuf.isReadable()) {
                        byteBuf.release();
                        byteBuf = null;
                        close = allocHandle.lastBytesRead() < 0;
                        if (close) {
                            this.readPending = false;
                        }
                    }
                }
                if (byteBuf != null) {
                    if (byteBuf.isReadable()) {
                        this.readPending = false;
                        pipeline.fireChannelRead((Object) byteBuf);
                    } else {
                        byteBuf.release();
                    }
                }
                if (readData) {
                    allocHandle.readComplete();
                    pipeline.fireChannelReadComplete();
                }
                if (close) {
                    closeOnRead(pipeline);
                }
                if (this.readPending || config.isAutoRead() || (!readData && isActive())) {
                    read();
                }
            } catch (Throwable th) {
                if (this.readPending || config.isAutoRead() || (!readData && isActive())) {
                    read();
                }
                throw th;
            }
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        while (true) {
            Object msg = in.current();
            if (msg != null) {
                if (msg instanceof ByteBuf) {
                    ByteBuf buf = (ByteBuf) msg;
                    int readableBytes = buf.readableBytes();
                    while (readableBytes > 0) {
                        doWriteBytes(buf);
                        int newReadableBytes = buf.readableBytes();
                        in.progress((long) (readableBytes - newReadableBytes));
                        readableBytes = newReadableBytes;
                    }
                    in.remove();
                } else if (msg instanceof FileRegion) {
                    FileRegion region = (FileRegion) msg;
                    long transferred = region.transferred();
                    doWriteFileRegion(region);
                    in.progress(region.transferred() - transferred);
                    in.remove();
                } else {
                    in.remove(new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg)));
                }
            } else {
                return;
            }
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object msg) throws Exception {
        if ((msg instanceof ByteBuf) || (msg instanceof FileRegion)) {
            return msg;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
    }
}
