package p013io.netty.handler.codec.compression;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.handler.codec.EncoderException;
import p013io.netty.handler.codec.MessageToByteEncoder;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.PromiseNotifier;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.compression.Lz4FrameEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Lz4FrameEncoder.class */
public class Lz4FrameEncoder extends MessageToByteEncoder<ByteBuf> {
    static final int DEFAULT_MAX_ENCODE_SIZE = Integer.MAX_VALUE;
    private final int blockSize;
    private final LZ4Compressor compressor;
    private final ByteBufChecksum checksum;
    private final int compressionLevel;
    private ByteBuf buffer;
    private final int maxEncodeSize;
    private volatile boolean finished;
    private volatile ChannelHandlerContext ctx;

    public Lz4FrameEncoder() {
        this(false);
    }

    public Lz4FrameEncoder(boolean highCompressor) {
        this(LZ4Factory.fastestInstance(), highCompressor, 65536, new Lz4XXHash32(-1756908916));
    }

    public Lz4FrameEncoder(LZ4Factory factory, boolean highCompressor, int blockSize, Checksum checksum) {
        this(factory, highCompressor, blockSize, checksum, Integer.MAX_VALUE);
    }

    public Lz4FrameEncoder(LZ4Factory factory, boolean highCompressor, int blockSize, Checksum checksum, int maxEncodeSize) {
        ObjectUtil.checkNotNull(factory, "factory");
        ObjectUtil.checkNotNull(checksum, "checksum");
        this.compressor = highCompressor ? factory.highCompressor() : factory.fastCompressor();
        this.checksum = ByteBufChecksum.wrapChecksum(checksum);
        this.compressionLevel = compressionLevel(blockSize);
        this.blockSize = blockSize;
        this.maxEncodeSize = ObjectUtil.checkPositive(maxEncodeSize, "maxEncodeSize");
        this.finished = false;
    }

    private static int compressionLevel(int blockSize) {
        if (blockSize >= 64 && blockSize <= 33554432) {
            return Math.max(0, (32 - Integer.numberOfLeadingZeros(blockSize - 1)) - 10);
        }
        throw new IllegalArgumentException(String.format("blockSize: %d (expected: %d-%d)", Integer.valueOf(blockSize), 64, 33554432));
    }

    /* access modifiers changed from: protected */
    public ByteBuf allocateBuffer(ChannelHandlerContext ctx, ByteBuf msg, boolean preferDirect) {
        return allocateBuffer(ctx, msg, preferDirect, true);
    }

    private ByteBuf allocateBuffer(ChannelHandlerContext ctx, ByteBuf msg, boolean preferDirect, boolean allowEmptyReturn) {
        int targetBufSize = 0;
        int remaining = msg.readableBytes() + this.buffer.readableBytes();
        if (remaining < 0) {
            throw new EncoderException("too much data to allocate a buffer for compression");
        }
        while (remaining > 0) {
            int curSize = Math.min(this.blockSize, remaining);
            remaining -= curSize;
            targetBufSize += this.compressor.maxCompressedLength(curSize) + 21;
        }
        if (targetBufSize > this.maxEncodeSize || 0 > targetBufSize) {
            throw new EncoderException(String.format("requested encode buffer size (%d bytes) exceeds the maximum allowable size (%d bytes)", Integer.valueOf(targetBufSize), Integer.valueOf(this.maxEncodeSize)));
        } else if (allowEmptyReturn && targetBufSize < this.blockSize) {
            return Unpooled.EMPTY_BUFFER;
        } else {
            if (preferDirect) {
                return ctx.alloc().ioBuffer(targetBufSize, targetBufSize);
            }
            return ctx.alloc().heapBuffer(targetBufSize, targetBufSize);
        }
    }

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
        if (!this.finished) {
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
        } else if (!out.isWritable(in.readableBytes())) {
            throw new IllegalStateException("encode finished and not enough space to write remaining data");
        } else {
            out.writeBytes(in);
        }
    }

    private void flushBufferedData(ByteBuf out) {
        int blockType;
        int flushableBytes = this.buffer.readableBytes();
        if (flushableBytes != 0) {
            this.checksum.reset();
            this.checksum.update(this.buffer, this.buffer.readerIndex(), flushableBytes);
            int check = (int) this.checksum.getValue();
            out.ensureWritable(this.compressor.maxCompressedLength(flushableBytes) + 21);
            int idx = out.writerIndex();
            try {
                ByteBuffer outNioBuffer = out.internalNioBuffer(idx + 21, out.writableBytes() - 21);
                int pos = outNioBuffer.position();
                this.compressor.compress(this.buffer.internalNioBuffer(this.buffer.readerIndex(), flushableBytes), outNioBuffer);
                int compressedLength = outNioBuffer.position() - pos;
                if (compressedLength >= flushableBytes) {
                    blockType = 16;
                    compressedLength = flushableBytes;
                    out.setBytes(idx + 21, this.buffer, this.buffer.readerIndex(), flushableBytes);
                } else {
                    blockType = 32;
                }
                out.setLong(idx, 5501767354678207339L);
                out.setByte(idx + 8, (byte) (blockType | this.compressionLevel));
                out.setIntLE(idx + 9, compressedLength);
                out.setIntLE(idx + 13, flushableBytes);
                out.setIntLE(idx + 17, check);
                out.writerIndex(idx + 21 + compressedLength);
                this.buffer.clear();
            } catch (LZ4Exception e) {
                throw new CompressionException((Throwable) e);
            }
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext ctx) throws Exception {
        if (this.buffer != null && this.buffer.isReadable()) {
            ByteBuf buf = allocateBuffer(ctx, Unpooled.EMPTY_BUFFER, isPreferDirect(), false);
            flushBufferedData(buf);
            ctx.write(buf);
        }
        ctx.flush();
    }

    /* access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext ctx, ChannelPromise promise) {
        if (this.finished) {
            promise.setSuccess();
            return promise;
        }
        this.finished = true;
        ByteBuf footer = ctx.alloc().heapBuffer(this.compressor.maxCompressedLength(this.buffer.readableBytes()) + 21);
        flushBufferedData(footer);
        footer.ensureWritable(21);
        int idx = footer.writerIndex();
        footer.setLong(idx, 5501767354678207339L);
        footer.setByte(idx + 8, (byte) (16 | this.compressionLevel));
        footer.setInt(idx + 9, 0);
        footer.setInt(idx + 13, 0);
        footer.setInt(idx + 17, 0);
        footer.writerIndex(idx + 21);
        return ctx.writeAndFlush(footer, promise);
    }

    public boolean isClosed() {
        return this.finished;
    }

    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    public ChannelFuture close(final ChannelPromise promise) {
        ChannelHandlerContext ctx = ctx();
        EventExecutor executor = ctx.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx, promise);
        }
        executor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                PromiseNotifier.cascade(Lz4FrameEncoder.this.finishEncode(Lz4FrameEncoder.this.ctx(), promise), promise);
            }
        });
        return promise;
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext ctx, final ChannelPromise promise) throws Exception {
        ChannelFuture f = finishEncode(ctx, ctx.newPromise());
        f.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.2
            public void operationComplete(ChannelFuture f2) throws Exception {
                ctx.close(promise);
            }
        });
        if (!f.isDone()) {
            ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.3
                @Override // java.lang.Runnable
                public void run() {
                    ctx.close(promise);
                }
            }, 10L, TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext ctx = this.ctx;
        if (ctx != null) {
            return ctx;
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) {
        this.ctx = ctx;
        this.buffer = Unpooled.wrappedBuffer(new byte[this.blockSize]);
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

    final ByteBuf getBackingBuffer() {
        return this.buffer;
    }
}
