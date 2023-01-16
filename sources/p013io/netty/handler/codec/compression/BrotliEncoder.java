package p013io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;
import com.aayushatharva.brotli4j.encoder.Encoders;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.compression.BrotliEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/BrotliEncoder.class */
public final class BrotliEncoder extends MessageToByteEncoder<ByteBuf> {
    private final Encoder.Parameters parameters;

    public BrotliEncoder() {
        this(BrotliOptions.DEFAULT);
    }

    public BrotliEncoder(Encoder.Parameters parameters) {
        this.parameters = (Encoder.Parameters) ObjectUtil.checkNotNull(parameters, "Parameters");
    }

    public BrotliEncoder(BrotliOptions brotliOptions) {
        this(brotliOptions.parameters());
    }

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
    }

    /* access modifiers changed from: protected */
    public ByteBuf allocateBuffer(ChannelHandlerContext ctx, ByteBuf msg, boolean preferDirect) throws Exception {
        ByteBuf out;
        if (!msg.isReadable()) {
            return Unpooled.EMPTY_BUFFER;
        }
        try {
            if (preferDirect) {
                out = ctx.alloc().ioBuffer();
            } else {
                out = ctx.alloc().buffer();
            }
            Encoders.compress(msg, out, this.parameters);
            return out;
        } catch (Exception e) {
            ReferenceCountUtil.release(msg);
            throw e;
        }
    }
}
