package p013io.netty.handler.codec.compression;

import com.github.luben.zstd.Zstd;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.EncoderException;
import p013io.netty.handler.codec.MessageToByteEncoder;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.compression.ZstdEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/ZstdEncoder.class */
public final class ZstdEncoder extends MessageToByteEncoder<ByteBuf> {
    private final int blockSize;
    private final int compressionLevel;
    private final int maxEncodeSize;
    private ByteBuf buffer;

    public ZstdEncoder() {
        this(3, 65536, 33554432);
    }

    public ZstdEncoder(int compressionLevel) {
        this(compressionLevel, 65536, 33554432);
    }

    public ZstdEncoder(int blockSize, int maxEncodeSize) {
        this(3, blockSize, maxEncodeSize);
    }

    public ZstdEncoder(int compressionLevel, int blockSize, int maxEncodeSize) {
        super(true);
        this.compressionLevel = ObjectUtil.checkInRange(compressionLevel, 0, 22, "compressionLevel");
        this.blockSize = ObjectUtil.checkPositive(blockSize, "blockSize");
        this.maxEncodeSize = ObjectUtil.checkPositive(maxEncodeSize, "maxEncodeSize");
    }

    /* access modifiers changed from: protected */
    public ByteBuf allocateBuffer(ChannelHandlerContext ctx, ByteBuf msg, boolean preferDirect) {
        if (this.buffer == null) {
            throw new IllegalStateException("not added to a pipeline,or has been removed,buffer is null");
        }
        int remaining = msg.readableBytes() + this.buffer.readableBytes();
        if (remaining < 0) {
            throw new EncoderException("too much data to allocate a buffer for compression");
        }
        long bufferSize = 0;
        while (remaining > 0) {
            int curSize = Math.min(this.blockSize, remaining);
            remaining -= curSize;
            bufferSize += Zstd.compressBound((long) curSize);
        }
        if (bufferSize <= ((long) this.maxEncodeSize) && 0 <= bufferSize) {
            return ctx.alloc().directBuffer((int) bufferSize);
        }
        throw new EncoderException("requested encode buffer size (" + bufferSize + " bytes) exceeds the maximum allowable size (" + this.maxEncodeSize + " bytes)");
    }

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) {
        if (this.buffer == null) {
            throw new IllegalStateException("not added to a pipeline,or has been removed,buffer is null");
        }
        ByteBuf buffer = this.buffer;
        while (true) {
            int length = in.readableBytes();
            if (length > 0) {
                in.readBytes(buffer, Math.min(length, buffer.writableBytes()));
                if (!buffer.isWritable()) {
                    flushBufferedData(out);
                }
            } else {
                return;
            }
        }
    }

    private void flushBufferedData(ByteBuf out) {
        int flushableBytes = this.buffer.readableBytes();
        if (flushableBytes != 0) {
            out.ensureWritable((int) Zstd.compressBound((long) flushableBytes));
            int idx = out.writerIndex();
            try {
                out.writerIndex(idx + Zstd.compress(out.internalNioBuffer(idx, out.writableBytes()), this.buffer.internalNioBuffer(this.buffer.readerIndex(), flushableBytes), this.compressionLevel));
                this.buffer.clear();
            } catch (Exception e) {
                throw new CompressionException(e);
            }
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext ctx) {
        if (this.buffer != null && this.buffer.isReadable()) {
            ByteBuf buf = allocateBuffer(ctx, Unpooled.EMPTY_BUFFER, isPreferDirect());
            flushBufferedData(buf);
            ctx.write(buf);
        }
        ctx.flush();
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) {
        this.buffer = ctx.alloc().directBuffer(this.blockSize);
        this.buffer.clear();
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        handlerRemoved(ctx);
        if (this.buffer != null) {
            this.buffer.release();
            this.buffer = null;
        }
    }
}
