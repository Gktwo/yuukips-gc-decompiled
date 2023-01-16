package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.Unmarshaller;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/* renamed from: io.netty.handler.codec.marshalling.MarshallingDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/MarshallingDecoder.class */
public class MarshallingDecoder extends LengthFieldBasedFrameDecoder {
    private final UnmarshallerProvider provider;

    public MarshallingDecoder(UnmarshallerProvider provider) {
        this(provider, 1048576);
    }

    public MarshallingDecoder(UnmarshallerProvider provider, int maxObjectSize) {
        super(maxObjectSize, 0, 4, 0, 4);
        this.provider = provider;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.LengthFieldBasedFrameDecoder
    public Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = (ByteBuf) decode(ctx, in);
        if (frame == null) {
            return null;
        }
        Unmarshaller unmarshaller = this.provider.getUnmarshaller(ctx);
        try {
            unmarshaller.start(new ChannelBufferByteInput(frame));
            Object obj = unmarshaller.readObject();
            unmarshaller.finish();
            unmarshaller.close();
            return obj;
        } catch (Throwable th) {
            unmarshaller.close();
            throw th;
        }
    }

    @Override // p013io.netty.handler.codec.LengthFieldBasedFrameDecoder
    protected ByteBuf extractFrame(ChannelHandlerContext ctx, ByteBuf buffer, int index, int length) {
        return buffer.slice(index, length);
    }
}
