package p013io.netty.handler.codec.bytes;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageDecoder;

/* renamed from: io.netty.handler.codec.bytes.ByteArrayDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/bytes/ByteArrayDecoder.class */
public class ByteArrayDecoder extends MessageToMessageDecoder<ByteBuf> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(ByteBufUtil.getBytes(msg));
    }
}
