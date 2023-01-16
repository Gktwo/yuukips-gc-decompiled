package p013io.netty.handler.codec;

import java.util.List;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundHandlerAdapter;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.PromiseCombiner;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.TypeParameterMatcher;

/* renamed from: io.netty.handler.codec.MessageToMessageEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/MessageToMessageEncoder.class */
public abstract class MessageToMessageEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    /* access modifiers changed from: protected */
    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i, List<Object> list) throws Exception;

    /* access modifiers changed from: protected */
    public MessageToMessageEncoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");
    }

    protected MessageToMessageEncoder(Class<? extends I> outboundMessageType) {
        this.matcher = TypeParameterMatcher.get(outboundMessageType);
    }

    public boolean acceptOutboundMessage(Object msg) throws Exception {
        return this.matcher.match(msg);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        CodecOutputList out;
        try {
            out = null;
            try {
                if (acceptOutboundMessage(msg)) {
                    out = CodecOutputList.newInstance();
                    try {
                        encode(ctx, msg, out);
                    } catch (Throwable th) {
                        ReferenceCountUtil.safeRelease(msg);
                        PlatformDependent.throwException(th);
                    }
                    ReferenceCountUtil.release(msg);
                    if (out.isEmpty()) {
                        throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                    }
                } else {
                    ctx.write(msg, promise);
                }
                if (out != null) {
                    try {
                        int sizeMinusOne = out.size() - 1;
                        if (sizeMinusOne == 0) {
                            ctx.write(out.getUnsafe(0), promise);
                        } else if (sizeMinusOne > 0) {
                            if (promise == ctx.voidPromise()) {
                                writeVoidPromise(ctx, out);
                            } else {
                                writePromiseCombiner(ctx, out, promise);
                            }
                        }
                        out.recycle();
                    } catch (Throwable th2) {
                        out.recycle();
                        throw th2;
                    }
                }
            } catch (EncoderException e) {
                throw e;
            } catch (Throwable t) {
                throw new EncoderException(t);
            }
        } catch (Throwable th3) {
            if (out != null) {
                try {
                    int sizeMinusOne2 = out.size() - 1;
                    if (sizeMinusOne2 == 0) {
                        ctx.write(out.getUnsafe(0), promise);
                    } else if (sizeMinusOne2 > 0) {
                        if (promise == ctx.voidPromise()) {
                            writeVoidPromise(ctx, out);
                        } else {
                            writePromiseCombiner(ctx, out, promise);
                        }
                    }
                    out.recycle();
                } catch (Throwable th4) {
                    out.recycle();
                    throw th4;
                }
            }
            throw th3;
        }
    }

    private static void writeVoidPromise(ChannelHandlerContext ctx, CodecOutputList out) {
        ChannelPromise voidPromise = ctx.voidPromise();
        for (int i = 0; i < out.size(); i++) {
            ctx.write(out.getUnsafe(i), voidPromise);
        }
    }

    private static void writePromiseCombiner(ChannelHandlerContext ctx, CodecOutputList out, ChannelPromise promise) {
        PromiseCombiner combiner = new PromiseCombiner(ctx.executor());
        for (int i = 0; i < out.size(); i++) {
            combiner.add(ctx.write(out.getUnsafe(i)));
        }
        combiner.finish(promise);
    }
}
