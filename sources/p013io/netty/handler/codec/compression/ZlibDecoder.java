package p013io.netty.handler.codec.compression;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.ByteToMessageDecoder;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.compression.ZlibDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/ZlibDecoder.class */
public abstract class ZlibDecoder extends ByteToMessageDecoder {
    protected final int maxAllocation;

    public abstract boolean isClosed();

    public ZlibDecoder() {
        this(0);
    }

    public ZlibDecoder(int maxAllocation) {
        this.maxAllocation = ObjectUtil.checkPositiveOrZero(maxAllocation, "maxAllocation");
    }

    protected ByteBuf prepareDecompressBuffer(ChannelHandlerContext ctx, ByteBuf buffer, int preferredSize) {
        if (buffer == null) {
            if (this.maxAllocation == 0) {
                return ctx.alloc().heapBuffer(preferredSize);
            }
            return ctx.alloc().heapBuffer(Math.min(preferredSize, this.maxAllocation), this.maxAllocation);
        } else if (buffer.ensureWritable(preferredSize, true) != 1) {
            return buffer;
        } else {
            decompressionBufferExhausted(buffer.duplicate());
            buffer.skipBytes(buffer.readableBytes());
            throw new DecompressionException("Decompression buffer has reached maximum size: " + buffer.maxCapacity());
        }
    }

    protected void decompressionBufferExhausted(ByteBuf buffer) {
    }
}
