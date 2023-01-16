package p013io.netty.handler.codec;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufHolder;
import p013io.netty.buffer.CompositeByteBuf;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.MessageAggregator */
/* loaded from: grasscutter.jar:io/netty/handler/codec/MessageAggregator.class */
public abstract class MessageAggregator<I, S, C extends ByteBufHolder, O extends ByteBufHolder> extends MessageToMessageDecoder<I> {
    private static final int DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS = 1024;
    private final int maxContentLength;
    private O currentMessage;
    private boolean handlingOversizedMessage;
    private int maxCumulationBufferComponents = 1024;
    private ChannelHandlerContext ctx;
    private ChannelFutureListener continueResponseWriteListener;
    private boolean aggregating;
    static final /* synthetic */ boolean $assertionsDisabled;

    protected abstract boolean isStartMessage(I i) throws Exception;

    protected abstract boolean isContentMessage(I i) throws Exception;

    protected abstract boolean isLastContentMessage(C c) throws Exception;

    protected abstract boolean isAggregated(I i) throws Exception;

    protected abstract boolean isContentLengthInvalid(S s, int i) throws Exception;

    protected abstract Object newContinueResponse(S s, int i, ChannelPipeline channelPipeline) throws Exception;

    protected abstract boolean closeAfterContinueResponse(Object obj) throws Exception;

    protected abstract boolean ignoreContentAfterContinueResponse(Object obj) throws Exception;

    protected abstract O beginAggregation(S s, ByteBuf byteBuf) throws Exception;

    static {
        $assertionsDisabled = !MessageAggregator.class.desiredAssertionStatus();
    }

    protected MessageAggregator(int maxContentLength) {
        validateMaxContentLength(maxContentLength);
        this.maxContentLength = maxContentLength;
    }

    protected MessageAggregator(int maxContentLength, Class<? extends I> inboundMessageType) {
        super(inboundMessageType);
        validateMaxContentLength(maxContentLength);
        this.maxContentLength = maxContentLength;
    }

    private static void validateMaxContentLength(int maxContentLength) {
        ObjectUtil.checkPositiveOrZero(maxContentLength, "maxContentLength");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object msg) throws Exception {
        if (!acceptInboundMessage(msg) || isAggregated(msg)) {
            return false;
        }
        if (!isStartMessage(msg)) {
            return this.aggregating && isContentMessage(msg);
        }
        this.aggregating = true;
        return true;
    }

    public final int maxContentLength() {
        return this.maxContentLength;
    }

    public final int maxCumulationBufferComponents() {
        return this.maxCumulationBufferComponents;
    }

    public final void setMaxCumulationBufferComponents(int maxCumulationBufferComponents) {
        if (maxCumulationBufferComponents < 2) {
            throw new IllegalArgumentException("maxCumulationBufferComponents: " + maxCumulationBufferComponents + " (expected: >= 2)");
        } else if (this.ctx == null) {
            this.maxCumulationBufferComponents = maxCumulationBufferComponents;
        } else {
            throw new IllegalStateException("decoder properties cannot be changed once the decoder is added to a pipeline.");
        }
    }

    @Deprecated
    public final boolean isHandlingOversizedMessage() {
        return this.handlingOversizedMessage;
    }

    protected final ChannelHandlerContext ctx() {
        if (this.ctx != null) {
            return this.ctx;
        }
        throw new IllegalStateException("not added to a pipeline yet");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.handler.codec.MessageAggregator<I, S, C extends io.netty.buffer.ByteBufHolder, O extends io.netty.buffer.ByteBufHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v84, types: [io.netty.channel.ChannelFuture] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(final p013io.netty.channel.ChannelHandlerContext r7, I r8, java.util.List<java.lang.Object> r9) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 558
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.MessageAggregator.decode(io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List):void");
    }

    private static void appendPartialContent(CompositeByteBuf content, ByteBuf partialContent) {
        if (partialContent.isReadable()) {
            content.addComponent(true, partialContent.retain());
        }
    }

    protected void aggregate(O aggregated, C content) throws Exception {
    }

    private void finishAggregation0(O aggregated) throws Exception {
        this.aggregating = false;
        finishAggregation(aggregated);
    }

    protected void finishAggregation(O aggregated) throws Exception {
    }

    private void invokeHandleOversizedMessage(ChannelHandlerContext ctx, S oversized) throws Exception {
        this.handlingOversizedMessage = true;
        this.currentMessage = null;
        try {
            handleOversizedMessage(ctx, oversized);
        } finally {
            ReferenceCountUtil.release(oversized);
        }
    }

    protected void handleOversizedMessage(ChannelHandlerContext ctx, S oversized) throws Exception {
        ctx.fireExceptionCaught((Throwable) new TooLongFrameException("content length exceeded " + maxContentLength() + " bytes."));
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        if (this.currentMessage != null && !ctx.channel().config().isAutoRead()) {
            ctx.read();
        }
        ctx.fireChannelReadComplete();
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        try {
            channelInactive(ctx);
        } finally {
            releaseCurrentMessage();
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        try {
            handlerRemoved(ctx);
        } finally {
            releaseCurrentMessage();
        }
    }

    private void releaseCurrentMessage() {
        if (this.currentMessage != null) {
            this.currentMessage.release();
            this.currentMessage = null;
            this.handlingOversizedMessage = false;
            this.aggregating = false;
        }
    }
}
