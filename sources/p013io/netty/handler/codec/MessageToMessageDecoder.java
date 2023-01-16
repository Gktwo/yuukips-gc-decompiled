package p013io.netty.handler.codec;

import java.util.List;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.internal.TypeParameterMatcher;

/* renamed from: io.netty.handler.codec.MessageToMessageDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/MessageToMessageDecoder.class */
public abstract class MessageToMessageDecoder<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    /* access modifiers changed from: protected */
    public abstract void decode(ChannelHandlerContext channelHandlerContext, I i, List<Object> list) throws Exception;

    /* access modifiers changed from: protected */
    public MessageToMessageDecoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");
    }

    /* access modifiers changed from: protected */
    public MessageToMessageDecoder(Class<? extends I> inboundMessageType) {
        this.matcher = TypeParameterMatcher.get(inboundMessageType);
    }

    public boolean acceptInboundMessage(Object msg) throws Exception {
        return this.matcher.match(msg);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        CodecOutputList out;
        try {
            out = CodecOutputList.newInstance();
            try {
                if (acceptInboundMessage(msg)) {
                    try {
                        decode(ctx, msg, out);
                        ReferenceCountUtil.release(msg);
                    } catch (Throwable th) {
                        ReferenceCountUtil.release(msg);
                        throw th;
                    }
                } else {
                    out.add(msg);
                }
                try {
                    int size = out.size();
                    for (int i = 0; i < size; i++) {
                        ctx.fireChannelRead(out.getUnsafe(i));
                    }
                    out.recycle();
                } catch (Throwable th2) {
                    out.recycle();
                    throw th2;
                }
            } catch (DecoderException e) {
                throw e;
            } catch (Exception e2) {
                throw new DecoderException(e2);
            }
        } catch (Throwable th3) {
            try {
                int size2 = out.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ctx.fireChannelRead(out.getUnsafe(i2));
                }
                out.recycle();
                throw th3;
            } catch (Throwable th4) {
                out.recycle();
                throw th4;
            }
        }
    }
}
