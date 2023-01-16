package p013io.netty.handler.codec.string;

import java.nio.charset.Charset;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageDecoder;
import p013io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.string.StringDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/string/StringDecoder.class */
public class StringDecoder extends MessageToMessageDecoder<ByteBuf> {
    private final Charset charset;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public StringDecoder() {
        this(Charset.defaultCharset());
    }

    public StringDecoder(Charset charset) {
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(msg.toString(this.charset));
    }
}
