package p013io.netty.handler.codec.protobuf;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageEncoder;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.protobuf.ProtobufEncoderNano */
/* loaded from: grasscutter.jar:io/netty/handler/codec/protobuf/ProtobufEncoderNano.class */
public class ProtobufEncoderNano extends MessageToMessageEncoder<MessageNano> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, MessageNano messageNano, List list) throws Exception {
        encode(channelHandlerContext, messageNano, (List<Object>) list);
    }

    protected void encode(ChannelHandlerContext ctx, MessageNano msg, List<Object> out) throws Exception {
        int size = msg.getSerializedSize();
        ByteBuf buffer = ctx.alloc().heapBuffer(size, size);
        msg.writeTo(CodedOutputByteBufferNano.newInstance(buffer.array(), buffer.arrayOffset(), buffer.capacity()));
        buffer.writerIndex(size);
        out.add(buffer);
    }
}
