package p013io.netty.handler.codec.compression;

import java.util.concurrent.TimeUnit;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.handler.codec.MessageToByteEncoder;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.PromiseNotifier;

/* renamed from: io.netty.handler.codec.compression.Bzip2Encoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2Encoder.class */
public class Bzip2Encoder extends MessageToByteEncoder<ByteBuf> {
    private State currentState;
    private final Bzip2BitWriter writer;
    private final int streamBlockSize;
    private int streamCRC;
    private Bzip2BlockCompressor blockCompressor;
    private volatile boolean finished;
    private volatile ChannelHandlerContext ctx;

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.codec.compression.Bzip2Encoder$State */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2Encoder$State.class */
    public enum State {
        INIT,
        INIT_BLOCK,
        WRITE_DATA,
        CLOSE_BLOCK
    }

    public Bzip2Encoder() {
        this(9);
    }

    public Bzip2Encoder(int blockSizeMultiplier) {
        this.currentState = State.INIT;
        this.writer = new Bzip2BitWriter();
        if (blockSizeMultiplier < 1 || blockSizeMultiplier > 9) {
            throw new IllegalArgumentException("blockSizeMultiplier: " + blockSizeMultiplier + " (expected: 1-9)");
        }
        this.streamBlockSize = blockSizeMultiplier * 100000;
    }

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
        if (this.finished) {
            out.writeBytes(in);
            return;
        }
        while (true) {
            switch (this.currentState) {
                case INIT:
                    out.ensureWritable(4);
                    out.writeMedium(4348520);
                    out.writeByte(48 + (this.streamBlockSize / 100000));
                    this.currentState = State.INIT_BLOCK;
                case INIT_BLOCK:
                    this.blockCompressor = new Bzip2BlockCompressor(this.writer, this.streamBlockSize);
                    this.currentState = State.WRITE_DATA;
                case WRITE_DATA:
                    if (in.isReadable()) {
                        Bzip2BlockCompressor blockCompressor = this.blockCompressor;
                        in.skipBytes(blockCompressor.write(in, in.readerIndex(), Math.min(in.readableBytes(), blockCompressor.availableSize())));
                        if (blockCompressor.isFull()) {
                            this.currentState = State.CLOSE_BLOCK;
                            closeBlock(out);
                            this.currentState = State.INIT_BLOCK;
                            break;
                        } else if (in.isReadable()) {
                            break;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case CLOSE_BLOCK:
                    closeBlock(out);
                    this.currentState = State.INIT_BLOCK;
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    private void closeBlock(ByteBuf out) {
        Bzip2BlockCompressor blockCompressor = this.blockCompressor;
        if (!blockCompressor.isEmpty()) {
            blockCompressor.close(out);
            this.streamCRC = ((this.streamCRC << 1) | (this.streamCRC >>> 31)) ^ blockCompressor.crc();
        }
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
        executor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.1
            @Override // java.lang.Runnable
            public void run() {
                PromiseNotifier.cascade(Bzip2Encoder.this.finishEncode(Bzip2Encoder.this.ctx(), promise), promise);
            }
        });
        return promise;
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext ctx, final ChannelPromise promise) throws Exception {
        ChannelFuture f = finishEncode(ctx, ctx.newPromise());
        f.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.2
            public void operationComplete(ChannelFuture f2) throws Exception {
                ctx.close(promise);
            }
        });
        if (!f.isDone()) {
            ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.3
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
        ByteBuf footer = ctx.alloc().buffer();
        closeBlock(footer);
        int streamCRC = this.streamCRC;
        Bzip2BitWriter writer = this.writer;
        try {
            writer.writeBits(footer, 24, 1536581);
            writer.writeBits(footer, 24, 3690640);
            writer.writeInt(footer, streamCRC);
            writer.flush(footer);
            this.blockCompressor = null;
            return ctx.writeAndFlush(footer, promise);
        } catch (Throwable th) {
            this.blockCompressor = null;
            throw th;
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
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }
}
