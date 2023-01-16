package p013io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import java.util.concurrent.TimeUnit;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.PromiseNotifier;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.compression.JZlibEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/JZlibEncoder.class */
public class JZlibEncoder extends ZlibEncoder {
    private final int wrapperOverhead;

    /* renamed from: z */
    private final Deflater f1007z;
    private volatile boolean finished;
    private volatile ChannelHandlerContext ctx;
    private static final int THREAD_POOL_DELAY_SECONDS = 10;

    public JZlibEncoder() {
        this(6);
    }

    public JZlibEncoder(int compressionLevel) {
        this(ZlibWrapper.ZLIB, compressionLevel);
    }

    public JZlibEncoder(ZlibWrapper wrapper) {
        this(wrapper, 6);
    }

    public JZlibEncoder(ZlibWrapper wrapper, int compressionLevel) {
        this(wrapper, compressionLevel, 15, 8);
    }

    public JZlibEncoder(ZlibWrapper wrapper, int compressionLevel, int windowBits, int memLevel) {
        this.f1007z = new Deflater();
        ObjectUtil.checkInRange(compressionLevel, 0, 9, "compressionLevel");
        ObjectUtil.checkInRange(windowBits, 9, 15, "windowBits");
        ObjectUtil.checkInRange(memLevel, 1, 9, "memLevel");
        ObjectUtil.checkNotNull(wrapper, "wrapper");
        if (wrapper == ZlibWrapper.ZLIB_OR_NONE) {
            throw new IllegalArgumentException("wrapper '" + ZlibWrapper.ZLIB_OR_NONE + "' is not allowed for compression.");
        }
        int resultCode = this.f1007z.init(compressionLevel, windowBits, memLevel, ZlibUtil.convertWrapperType(wrapper));
        if (resultCode != 0) {
            ZlibUtil.fail(this.f1007z, "initialization failure", resultCode);
        }
        this.wrapperOverhead = ZlibUtil.wrapperOverhead(wrapper);
    }

    public JZlibEncoder(byte[] dictionary) {
        this(6, dictionary);
    }

    public JZlibEncoder(int compressionLevel, byte[] dictionary) {
        this(compressionLevel, 15, 8, dictionary);
    }

    public JZlibEncoder(int compressionLevel, int windowBits, int memLevel, byte[] dictionary) {
        this.f1007z = new Deflater();
        ObjectUtil.checkInRange(compressionLevel, 0, 9, "compressionLevel");
        ObjectUtil.checkInRange(windowBits, 9, 15, "windowBits");
        ObjectUtil.checkInRange(memLevel, 1, 9, "memLevel");
        ObjectUtil.checkNotNull(dictionary, "dictionary");
        int resultCode = this.f1007z.deflateInit(compressionLevel, windowBits, memLevel, JZlib.W_ZLIB);
        if (resultCode != 0) {
            ZlibUtil.fail(this.f1007z, "initialization failure", resultCode);
        } else {
            int resultCode2 = this.f1007z.deflateSetDictionary(dictionary, dictionary.length);
            if (resultCode2 != 0) {
                ZlibUtil.fail(this.f1007z, "failed to set the dictionary", resultCode2);
            }
        }
        this.wrapperOverhead = ZlibUtil.wrapperOverhead(ZlibWrapper.ZLIB);
    }

    @Override // p013io.netty.handler.codec.compression.ZlibEncoder
    public ChannelFuture close() {
        return close(ctx().channel().newPromise());
    }

    @Override // p013io.netty.handler.codec.compression.ZlibEncoder
    public ChannelFuture close(final ChannelPromise promise) {
        ChannelHandlerContext ctx = ctx();
        EventExecutor executor = ctx.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx, promise);
        }
        final ChannelPromise p = ctx.newPromise();
        executor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.JZlibEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                PromiseNotifier.cascade(JZlibEncoder.this.finishEncode(JZlibEncoder.this.ctx(), p), promise);
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
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x00dc
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void encode(p013io.netty.channel.ChannelHandlerContext r6, p013io.netty.buffer.ByteBuf r7, p013io.netty.buffer.ByteBuf r8) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 326
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.JZlibEncoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext ctx, final ChannelPromise promise) {
        ChannelFuture f = finishEncode(ctx, ctx.newPromise());
        f.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.JZlibEncoder.2
            public void operationComplete(ChannelFuture f2) throws Exception {
                ctx.close(promise);
            }
        });
        if (!f.isDone()) {
            ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.codec.compression.JZlibEncoder.3
                @Override // java.lang.Runnable
                public void run() {
                    ctx.close(promise);
                }
            }, 10L, TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext ctx, ChannelPromise promise) {
        ByteBuf footer;
        if (this.finished) {
            promise.setSuccess();
            return promise;
        }
        this.finished = true;
        try {
            this.f1007z.next_in = EmptyArrays.EMPTY_BYTES;
            this.f1007z.next_in_index = 0;
            this.f1007z.avail_in = 0;
            byte[] out = new byte[32];
            this.f1007z.next_out = out;
            this.f1007z.next_out_index = 0;
            this.f1007z.avail_out = out.length;
            int resultCode = this.f1007z.deflate(4);
            if (resultCode == 0 || resultCode == 1) {
                if (this.f1007z.next_out_index != 0) {
                    footer = Unpooled.wrappedBuffer(out, 0, this.f1007z.next_out_index);
                } else {
                    footer = Unpooled.EMPTY_BUFFER;
                }
                return ctx.writeAndFlush(footer, promise);
            }
            promise.setFailure((Throwable) ZlibUtil.deflaterException(this.f1007z, "compression failure", resultCode));
            this.f1007z.deflateEnd();
            this.f1007z.next_in = null;
            this.f1007z.next_out = null;
            return promise;
        } finally {
            this.f1007z.deflateEnd();
            this.f1007z.next_in = null;
            this.f1007z.next_out = null;
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }
}
