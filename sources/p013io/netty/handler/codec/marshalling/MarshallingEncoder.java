package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.Marshaller;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.marshalling.MarshallingEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/MarshallingEncoder.class */
public class MarshallingEncoder extends MessageToByteEncoder<Object> {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    private final MarshallerProvider provider;

    public MarshallingEncoder(MarshallerProvider provider) {
        this.provider = provider;
    }

    @Override // p013io.netty.handler.codec.MessageToByteEncoder
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        Marshaller marshaller = this.provider.getMarshaller(ctx);
        int lengthPos = out.writerIndex();
        out.writeBytes(LENGTH_PLACEHOLDER);
        marshaller.start(new ChannelBufferByteOutput(out));
        marshaller.writeObject(msg);
        marshaller.finish();
        marshaller.close();
        out.setInt(lengthPos, (out.writerIndex() - lengthPos) - 4);
    }
}
