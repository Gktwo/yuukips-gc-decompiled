package p013io.netty.handler.codec;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.FixedLengthFrameDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/FixedLengthFrameDecoder.class */
public class FixedLengthFrameDecoder extends ByteToMessageDecoder {
    private final int frameLength;

    public FixedLengthFrameDecoder(int frameLength) {
        ObjectUtil.checkPositive(frameLength, "frameLength");
        this.frameLength = frameLength;
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Object decoded = decode(ctx, in);
        if (decoded != null) {
            out.add(decoded);
        }
    }

    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if (in.readableBytes() < this.frameLength) {
            return null;
        }
        return in.readRetainedSlice(this.frameLength);
    }
}
