package p013io.netty.handler.codec;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.CompositeByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.channel.socket.ChannelInputShutdownEvent;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.handler.codec.ByteToMessageDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/ByteToMessageDecoder.class */
public abstract class ByteToMessageDecoder extends ChannelInboundHandlerAdapter {
    public static final Cumulator MERGE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.1
        @Override // p013io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator alloc, ByteBuf cumulation, ByteBuf in) {
            if (cumulation.isReadable() || !in.isContiguous()) {
                try {
                    int required = in.readableBytes();
                    if (required > cumulation.maxWritableBytes() || ((required > cumulation.maxFastWritableBytes() && cumulation.refCnt() > 1) || cumulation.isReadOnly())) {
                        ByteBuf expandCumulation = ByteToMessageDecoder.expandCumulation(alloc, cumulation, in);
                        in.release();
                        return expandCumulation;
                    }
                    cumulation.writeBytes(in, in.readerIndex(), required);
                    in.readerIndex(in.writerIndex());
                    in.release();
                    return cumulation;
                } catch (Throwable th) {
                    in.release();
                    throw th;
                }
            } else {
                cumulation.release();
                return in;
            }
        }
    };
    public static final Cumulator COMPOSITE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.2
        @Override // p013io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator alloc, ByteBuf cumulation, ByteBuf in) {
            if (!cumulation.isReadable()) {
                cumulation.release();
                return in;
            }
            CompositeByteBuf composite = null;
            try {
                if (!(cumulation instanceof CompositeByteBuf) || cumulation.refCnt() != 1) {
                    composite = alloc.compositeBuffer(Integer.MAX_VALUE).addFlattenedComponents(true, cumulation);
                } else {
                    composite = (CompositeByteBuf) cumulation;
                    if (composite.writerIndex() != composite.capacity()) {
                        composite.capacity(composite.writerIndex());
                    }
                }
                composite.addFlattenedComponents(true, in);
                in = null;
                if (0 != 0) {
                    in.release();
                    if (!(composite == null || composite == cumulation)) {
                        composite.release();
                    }
                }
                return composite;
            } catch (Throwable th) {
                if (in != null) {
                    in.release();
                    if (!(composite == null || composite == cumulation)) {
                        composite.release();
                    }
                }
                throw th;
            }
        }
    };
    private static final byte STATE_INIT = 0;
    private static final byte STATE_CALLING_CHILD_DECODE = 1;
    private static final byte STATE_HANDLER_REMOVED_PENDING = 2;
    ByteBuf cumulation;
    private boolean singleDecode;
    private boolean first;
    private boolean firedChannelRead;
    private boolean selfFiredChannelRead;
    private int numReads;
    private Cumulator cumulator = MERGE_CUMULATOR;
    private byte decodeState = 0;
    private int discardAfterReads = 16;

    /* renamed from: io.netty.handler.codec.ByteToMessageDecoder$Cumulator */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/ByteToMessageDecoder$Cumulator.class */
    public interface Cumulator {
        ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);
    }

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

    /* access modifiers changed from: protected */
    public ByteToMessageDecoder() {
        ensureNotSharable();
    }

    public void setSingleDecode(boolean singleDecode) {
        this.singleDecode = singleDecode;
    }

    public boolean isSingleDecode() {
        return this.singleDecode;
    }

    public void setCumulator(Cumulator cumulator) {
        this.cumulator = (Cumulator) ObjectUtil.checkNotNull(cumulator, "cumulator");
    }

    public void setDiscardAfterReads(int discardAfterReads) {
        ObjectUtil.checkPositive(discardAfterReads, "discardAfterReads");
        this.discardAfterReads = discardAfterReads;
    }

    protected int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    protected ByteBuf internalBuffer() {
        if (this.cumulation != null) {
            return this.cumulation;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public final void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if (this.decodeState == 1) {
            this.decodeState = 2;
            return;
        }
        ByteBuf buf = this.cumulation;
        if (buf != null) {
            this.cumulation = null;
            this.numReads = 0;
            if (buf.readableBytes() > 0) {
                ctx.fireChannelRead((Object) buf);
                ctx.fireChannelReadComplete();
            } else {
                buf.release();
            }
        }
        handlerRemoved0(ctx);
    }

    /* access modifiers changed from: protected */
    public void handlerRemoved0(ChannelHandlerContext ctx) throws Exception {
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        CodecOutputList out;
        if (msg instanceof ByteBuf) {
            try {
                this.selfFiredChannelRead = true;
                out = CodecOutputList.newInstance();
                try {
                    try {
                        this.first = this.cumulation == null;
                        this.cumulation = this.cumulator.cumulate(ctx.alloc(), this.first ? Unpooled.EMPTY_BUFFER : this.cumulation, (ByteBuf) msg);
                        callDecode(ctx, this.cumulation, out);
                        try {
                            if (this.cumulation == null || this.cumulation.isReadable()) {
                                int i = this.numReads + 1;
                                this.numReads = i;
                                if (i >= this.discardAfterReads) {
                                    this.numReads = 0;
                                    discardSomeReadBytes();
                                }
                            } else {
                                this.numReads = 0;
                                this.cumulation.release();
                                this.cumulation = null;
                            }
                            int size = out.size();
                            this.firedChannelRead |= out.insertSinceRecycled();
                            fireChannelRead(ctx, out, size);
                            out.recycle();
                        } catch (Throwable th) {
                            out.recycle();
                            throw th;
                        }
                    } catch (DecoderException e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw new DecoderException(e2);
                }
            } catch (Throwable th2) {
                try {
                    if (this.cumulation == null || this.cumulation.isReadable()) {
                        int i2 = this.numReads + 1;
                        this.numReads = i2;
                        if (i2 >= this.discardAfterReads) {
                            this.numReads = 0;
                            discardSomeReadBytes();
                        }
                    } else {
                        this.numReads = 0;
                        this.cumulation.release();
                        this.cumulation = null;
                    }
                    int size2 = out.size();
                    this.firedChannelRead |= out.insertSinceRecycled();
                    fireChannelRead(ctx, out, size2);
                    out.recycle();
                    throw th2;
                } catch (Throwable th3) {
                    out.recycle();
                    throw th3;
                }
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    static void fireChannelRead(ChannelHandlerContext ctx, List<Object> msgs, int numElements) {
        if (msgs instanceof CodecOutputList) {
            fireChannelRead(ctx, (CodecOutputList) msgs, numElements);
            return;
        }
        for (int i = 0; i < numElements; i++) {
            ctx.fireChannelRead(msgs.get(i));
        }
    }

    static void fireChannelRead(ChannelHandlerContext ctx, CodecOutputList msgs, int numElements) {
        for (int i = 0; i < numElements; i++) {
            ctx.fireChannelRead(msgs.getUnsafe(i));
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        this.numReads = 0;
        discardSomeReadBytes();
        if (this.selfFiredChannelRead && !this.firedChannelRead && !ctx.channel().config().isAutoRead()) {
            ctx.read();
        }
        this.firedChannelRead = false;
        ctx.fireChannelReadComplete();
    }

    protected final void discardSomeReadBytes() {
        if (this.cumulation != null && !this.first && this.cumulation.refCnt() == 1) {
            this.cumulation.discardSomeReadBytes();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        channelInputClosed(ctx, true);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof ChannelInputShutdownEvent) {
            channelInputClosed(ctx, false);
        }
        userEventTriggered(ctx, evt);
    }

    private void channelInputClosed(ChannelHandlerContext ctx, boolean callChannelInactive) {
        CodecOutputList out;
        try {
            out = CodecOutputList.newInstance();
            try {
                try {
                    channelInputClosed(ctx, out);
                    try {
                        if (this.cumulation != null) {
                            this.cumulation.release();
                            this.cumulation = null;
                        }
                        int size = out.size();
                        fireChannelRead(ctx, out, size);
                        if (size > 0) {
                            ctx.fireChannelReadComplete();
                        }
                        if (callChannelInactive) {
                            ctx.fireChannelInactive();
                        }
                        out.recycle();
                    } catch (Throwable th) {
                        out.recycle();
                        throw th;
                    }
                } catch (Exception e) {
                    throw new DecoderException(e);
                }
            } catch (DecoderException e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            try {
                if (this.cumulation != null) {
                    this.cumulation.release();
                    this.cumulation = null;
                }
                int size2 = out.size();
                fireChannelRead(ctx, out, size2);
                if (size2 > 0) {
                    ctx.fireChannelReadComplete();
                }
                if (callChannelInactive) {
                    ctx.fireChannelInactive();
                }
                out.recycle();
                throw th2;
            } catch (Throwable th3) {
                out.recycle();
                throw th3;
            }
        }
    }

    void channelInputClosed(ChannelHandlerContext ctx, List<Object> out) throws Exception {
        if (this.cumulation != null) {
            callDecode(ctx, this.cumulation, out);
            if (!ctx.isRemoved()) {
                decodeLast(ctx, this.cumulation == null ? Unpooled.EMPTY_BUFFER : this.cumulation, out);
                return;
            }
            return;
        }
        decodeLast(ctx, Unpooled.EMPTY_BUFFER, out);
    }

    protected void callDecode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        while (in.isReadable()) {
            try {
                int outSize = out.size();
                if (outSize > 0) {
                    fireChannelRead(ctx, out, outSize);
                    out.clear();
                    if (ctx.isRemoved()) {
                        break;
                    }
                }
                int oldInputLength = in.readableBytes();
                decodeRemovalReentryProtection(ctx, in, out);
                if (ctx.isRemoved()) {
                    break;
                } else if (out.isEmpty()) {
                    if (oldInputLength == in.readableBytes()) {
                        break;
                    }
                } else if (oldInputLength == in.readableBytes()) {
                    throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() did not read anything but decoded a message.");
                } else if (isSingleDecode()) {
                    break;
                }
            } catch (DecoderException e) {
                throw e;
            } catch (Exception cause) {
                throw new DecoderException(cause);
            }
        }
    }

    final void decodeRemovalReentryProtection(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        this.decodeState = 1;
        try {
            decode(ctx, in, out);
            boolean removePending = this.decodeState == 2;
            this.decodeState = 0;
            if (removePending) {
                fireChannelRead(ctx, out, out.size());
                out.clear();
                handlerRemoved(ctx);
            }
        } catch (Throwable th) {
            boolean removePending2 = this.decodeState == 2;
            this.decodeState = 0;
            if (removePending2) {
                fireChannelRead(ctx, out, out.size());
                out.clear();
                handlerRemoved(ctx);
            }
            throw th;
        }
    }

    protected void decodeLast(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.isReadable()) {
            decodeRemovalReentryProtection(ctx, in, out);
        }
    }

    static ByteBuf expandCumulation(ByteBufAllocator alloc, ByteBuf oldCumulation, ByteBuf in) {
        int oldBytes = oldCumulation.readableBytes();
        int newBytes = in.readableBytes();
        int totalBytes = oldBytes + newBytes;
        ByteBuf newCumulation = alloc.buffer(alloc.calculateNewCapacity(totalBytes, Integer.MAX_VALUE));
        ByteBuf toRelease = newCumulation;
        try {
            newCumulation.setBytes(0, oldCumulation, oldCumulation.readerIndex(), oldBytes).setBytes(oldBytes, in, in.readerIndex(), newBytes).writerIndex(totalBytes);
            in.readerIndex(in.writerIndex());
            toRelease = oldCumulation;
            toRelease.release();
            return newCumulation;
        } catch (Throwable th) {
            toRelease.release();
            throw th;
        }
    }
}
