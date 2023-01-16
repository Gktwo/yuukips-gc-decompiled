package p013io.netty.handler.codec;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundHandlerAdapter;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.internal.TypeParameterMatcher;

/* renamed from: io.netty.handler.codec.MessageToByteEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/MessageToByteEncoder.class */
public abstract class MessageToByteEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean preferDirect;

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, I i, ByteBuf byteBuf) throws Exception;

    /* access modifiers changed from: protected */
    public MessageToByteEncoder() {
        this(true);
    }

    protected MessageToByteEncoder(Class<? extends I> outboundMessageType) {
        this(outboundMessageType, true);
    }

    /* access modifiers changed from: protected */
    public MessageToByteEncoder(boolean preferDirect) {
        this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
        this.preferDirect = preferDirect;
    }

    protected MessageToByteEncoder(Class<? extends I> outboundMessageType, boolean preferDirect) {
        this.matcher = TypeParameterMatcher.get(outboundMessageType);
        this.preferDirect = preferDirect;
    }

    public boolean acceptOutboundMessage(Object msg) throws Exception {
        return this.matcher.match(msg);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ByteBuf buf;
        try {
            buf = null;
            try {
                if (acceptOutboundMessage(msg)) {
                    ByteBuf buf2 = allocateBuffer(ctx, msg, this.preferDirect);
                    try {
                        encode(ctx, msg, buf2);
                        ReferenceCountUtil.release(msg);
                        if (buf2.isReadable()) {
                            ctx.write(buf2, promise);
                        } else {
                            buf2.release();
                            ctx.write(Unpooled.EMPTY_BUFFER, promise);
                        }
                        buf = null;
                    } catch (Throwable th) {
                        ReferenceCountUtil.release(msg);
                        throw th;
                    }
                } else {
                    ctx.write(msg, promise);
                }
                if (buf != null) {
                    buf.release();
                }
            } catch (EncoderException e) {
                throw e;
            } catch (Throwable e2) {
                throw new EncoderException(e2);
            }
        } catch (Throwable th2) {
            if (buf != null) {
                buf.release();
            }
            throw th2;
        }
    }

    protected ByteBuf allocateBuffer(ChannelHandlerContext ctx, I msg, boolean preferDirect) throws Exception {
        if (preferDirect) {
            return ctx.alloc().ioBuffer();
        }
        return ctx.alloc().heapBuffer();
    }

    protected boolean isPreferDirect() {
        return this.preferDirect;
    }
}
