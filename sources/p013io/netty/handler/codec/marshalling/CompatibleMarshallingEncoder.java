package p013io.netty.handler.codec.marshalling;

import org.jboss.marshalling.Marshaller;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.marshalling.CompatibleMarshallingEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/CompatibleMarshallingEncoder.class */
public class CompatibleMarshallingEncoder extends MessageToByteEncoder<Object> {
    private final MarshallerProvider provider;

    public CompatibleMarshallingEncoder(MarshallerProvider provider) {
        this.provider = provider;
    }

    @Override // p013io.netty.handler.codec.MessageToByteEncoder
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        Marshaller marshaller = this.provider.getMarshaller(ctx);
        marshaller.start(new ChannelBufferByteOutput(out));
        marshaller.writeObject(msg);
        marshaller.finish();
        marshaller.close();
    }
}
