package p013io.netty.handler.codec.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageEncoder;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.protobuf.ProtobufEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/protobuf/ProtobufEncoder.class */
public class ProtobufEncoder extends MessageToMessageEncoder<MessageLiteOrBuilder> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, MessageLiteOrBuilder messageLiteOrBuilder, List list) throws Exception {
        encode(channelHandlerContext, messageLiteOrBuilder, (List<Object>) list);
    }

    protected void encode(ChannelHandlerContext ctx, MessageLiteOrBuilder msg, List<Object> out) throws Exception {
        if (msg instanceof MessageLite) {
            out.add(Unpooled.wrappedBuffer(((MessageLite) msg).toByteArray()));
        } else if (msg instanceof MessageLite.Builder) {
            out.add(Unpooled.wrappedBuffer(((MessageLite.Builder) msg).build().toByteArray()));
        }
    }
}
