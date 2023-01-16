package p013io.netty.handler.codec.base64;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageDecoder;
import p013io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.base64.Base64Decoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/base64/Base64Decoder.class */
public class Base64Decoder extends MessageToMessageDecoder<ByteBuf> {
    private final Base64Dialect dialect;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public Base64Decoder() {
        this(Base64Dialect.STANDARD);
    }

    public Base64Decoder(Base64Dialect dialect) {
        this.dialect = (Base64Dialect) ObjectUtil.checkNotNull(dialect, "dialect");
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(Base64.decode(msg, msg.readerIndex(), msg.readableBytes(), this.dialect));
    }
}
