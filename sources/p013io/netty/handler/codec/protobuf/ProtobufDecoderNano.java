package p013io.netty.handler.codec.protobuf;

import com.google.protobuf.nano.MessageNano;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageDecoder;
import p013io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.protobuf.ProtobufDecoderNano */
/* loaded from: grasscutter.jar:io/netty/handler/codec/protobuf/ProtobufDecoderNano.class */
public class ProtobufDecoderNano extends MessageToMessageDecoder<ByteBuf> {
    private final Class<? extends MessageNano> clazz;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public ProtobufDecoderNano(Class<? extends MessageNano> clazz) {
        this.clazz = (Class) ObjectUtil.checkNotNull(clazz, "You must provide a Class");
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        int offset;
        byte[] array;
        int length = msg.readableBytes();
        if (msg.hasArray()) {
            array = msg.array();
            offset = msg.arrayOffset() + msg.readerIndex();
        } else {
            array = ByteBufUtil.getBytes(msg, msg.readerIndex(), length, false);
            offset = 0;
        }
        out.add(MessageNano.mergeFrom((MessageNano) this.clazz.getConstructor(new Class[0]).newInstance(new Object[0]), array, offset, length));
    }
}
