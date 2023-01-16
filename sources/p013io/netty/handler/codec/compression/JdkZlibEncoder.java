package p013io.netty.handler.codec.compression;

import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.PromiseNotifier;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* renamed from: io.netty.handler.codec.compression.JdkZlibEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/JdkZlibEncoder.class */
public class JdkZlibEncoder extends ZlibEncoder {
    private final ZlibWrapper wrapper;
    private final Deflater deflater;
    private volatile boolean finished;
    private volatile ChannelHandlerContext ctx;
    private final CRC32 crc;
    private static final byte[] gzipHeader = {31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
    private boolean writeHeader;
    private static final int THREAD_POOL_DELAY_SECONDS = 10;

    public JdkZlibEncoder() {
        this(6);
    }

    public JdkZlibEncoder(int compressionLevel) {
        this(ZlibWrapper.ZLIB, compressionLevel);
    }

    public JdkZlibEncoder(ZlibWrapper wrapper) {
        this(wrapper, 6);
    }

    public JdkZlibEncoder(ZlibWrapper wrapper, int compressionLevel) {
        this.crc = new CRC32();
        this.writeHeader = true;
        ObjectUtil.checkInRange(compressionLevel, 0, 9, "compressionLevel");
        ObjectUtil.checkNotNull(wrapper, "wrapper");
        if (wrapper == ZlibWrapper.ZLIB_OR_NONE) {
            throw new IllegalArgumentException("wrapper '" + ZlibWrapper.ZLIB_OR_NONE + "' is not allowed for compression.");
        }
        this.wrapper = wrapper;
        this.deflater = new Deflater(compressionLevel, wrapper != ZlibWrapper.ZLIB);
    }

    public JdkZlibEncoder(byte[] dictionary) {
        this(6, dictionary);
    }

    public JdkZlibEncoder(int compressionLevel, byte[] dictionary) {
        this.crc = new CRC32();
        this.writeHeader = true;
        ObjectUtil.checkInRange(compressionLevel, 0, 9, "compressionLevel");
        ObjectUtil.checkNotNull(dictionary, "dictionary");
        this.wrapper = ZlibWrapper.ZLIB;
        this.deflater = new Deflater(compressionLevel);
        this.deflater.setDictionary(dictionary);
    }

    @Override // p013io.netty.handler.codec.compression.ZlibEncoder
    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    @Override // p013io.netty.handler.codec.compression.ZlibEncoder
    public ChannelFuture close(final ChannelPromise promise) {
        ChannelHandlerContext ctx = ctx();
        EventExecutor executor = ctx.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx, promise);
        }
        final ChannelPromise p = ctx.newPromise();
        executor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.JdkZlibEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                PromiseNotifier.cascade(JdkZlibEncoder.this.finishEncode(JdkZlibEncoder.this.ctx(), p), promise);
            }
        });
        return p;
    }

    /* access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext ctx = this.ctx;
        if (ctx != null) {
            return ctx;
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    @Override // p013io.netty.handler.codec.compression.ZlibEncoder
    public boolean isClosed() {
        return this.finished;
    }

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf uncompressed, ByteBuf out) throws Exception {
        byte[] inAry;
        int offset;
        if (this.finished) {
            out.writeBytes(uncompressed);
            return;
        }
        int len = uncompressed.readableBytes();
        if (len != 0) {
            ByteBuf heapBuf = null;
            try {
                if (uncompressed.hasArray()) {
                    inAry = uncompressed.array();
                    offset = uncompressed.arrayOffset() + uncompressed.readerIndex();
                    uncompressed.skipBytes(len);
                } else {
                    heapBuf = ctx.alloc().heapBuffer(len, len);
                    uncompressed.readBytes(heapBuf, len);
                    inAry = heapBuf.array();
                    offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
                }
                if (this.writeHeader) {
                    this.writeHeader = false;
                    if (this.wrapper == ZlibWrapper.GZIP) {
                        out.writeBytes(gzipHeader);
                    }
                }
                if (this.wrapper == ZlibWrapper.GZIP) {
                    this.crc.update(inAry, offset, len);
                }
                this.deflater.setInput(inAry, offset, len);
                while (true) {
                    deflate(out);
                    if (this.deflater.needsInput()) {
                        break;
                    } else if (!out.isWritable()) {
                        out.ensureWritable(out.writerIndex());
                    }
                }
                if (heapBuf != null) {
                    heapBuf.release();
                }
            } catch (Throwable th) {
                if (heapBuf != null) {
                    heapBuf.release();
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final ByteBuf allocateBuffer(ChannelHandlerContext ctx, ByteBuf msg, boolean preferDirect) throws Exception {
        int sizeEstimate = ((int) Math.ceil(((double) msg.readableBytes()) * 1.001d)) + 12;
        if (this.writeHeader) {
            switch (this.wrapper) {
                case GZIP:
                    sizeEstimate += gzipHeader.length;
                    break;
                case ZLIB:
                    sizeEstimate += 2;
                    break;
            }
        }
        return ctx.alloc().heapBuffer(sizeEstimate);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext ctx, final ChannelPromise promise) throws Exception {
        ChannelFuture f = finishEncode(ctx, ctx.newPromise());
        f.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.JdkZlibEncoder.2
            public void operationComplete(ChannelFuture f2) throws Exception {
                ctx.close(promise);
            }
        });
        if (!f.isDone()) {
            ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.codec.compression.JdkZlibEncoder.3
                @Override // java.lang.Runnable
                public void run() {
                    ctx.close(promise);
                }
            }, 10L, TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext ctx, ChannelPromise promise) {
        if (this.finished) {
            promise.setSuccess();
            return promise;
        }
        this.finished = true;
        ByteBuf footer = ctx.alloc().heapBuffer();
        if (this.writeHeader && this.wrapper == ZlibWrapper.GZIP) {
            this.writeHeader = false;
            footer.writeBytes(gzipHeader);
        }
        this.deflater.finish();
        while (!this.deflater.finished()) {
            deflate(footer);
            if (!footer.isWritable()) {
                ctx.write(footer);
                footer = ctx.alloc().heapBuffer();
            }
        }
        if (this.wrapper == ZlibWrapper.GZIP) {
            int crcValue = (int) this.crc.getValue();
            int uncBytes = this.deflater.getTotalIn();
            footer.writeByte(crcValue);
            footer.writeByte(crcValue >>> 8);
            footer.writeByte(crcValue >>> 16);
            footer.writeByte(crcValue >>> 24);
            footer.writeByte(uncBytes);
            footer.writeByte(uncBytes >>> 8);
            footer.writeByte(uncBytes >>> 16);
            footer.writeByte(uncBytes >>> 24);
        }
        this.deflater.end();
        return ctx.writeAndFlush(footer, promise);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    private void deflate(ByteBuf out) {
        int numBytes;
        if (PlatformDependent.javaVersion() < 7) {
            deflateJdk6(out);
        }
        do {
            int writerIndex = out.writerIndex();
            numBytes = this.deflater.deflate(out.array(), out.arrayOffset() + writerIndex, out.writableBytes(), 2);
            out.writerIndex(writerIndex + numBytes);
        } while (numBytes > 0);
    }

    private void deflateJdk6(ByteBuf out) {
        int numBytes;
        do {
            int writerIndex = out.writerIndex();
            numBytes = this.deflater.deflate(out.array(), out.arrayOffset() + writerIndex, out.writableBytes());
            out.writerIndex(writerIndex + numBytes);
        } while (numBytes > 0);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }
}
