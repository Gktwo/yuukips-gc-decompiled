package p013io.netty.handler.codec.string;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageEncoder;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.string.LineEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/string/LineEncoder.class */
public class LineEncoder extends MessageToMessageEncoder<CharSequence> {
    private final Charset charset;
    private final byte[] lineSeparator;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, CharSequence charSequence, List list) throws Exception {
        encode(channelHandlerContext, charSequence, (List<Object>) list);
    }

    public LineEncoder() {
        this(LineSeparator.DEFAULT, CharsetUtil.UTF_8);
    }

    public LineEncoder(LineSeparator lineSeparator) {
        this(lineSeparator, CharsetUtil.UTF_8);
    }

    public LineEncoder(Charset charset) {
        this(LineSeparator.DEFAULT, charset);
    }

    public LineEncoder(LineSeparator lineSeparator, Charset charset) {
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.lineSeparator = ((LineSeparator) ObjectUtil.checkNotNull(lineSeparator, "lineSeparator")).value().getBytes(charset);
    }

    protected void encode(ChannelHandlerContext ctx, CharSequence msg, List<Object> out) throws Exception {
        ByteBuf buffer = ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(msg), this.charset, this.lineSeparator.length);
        buffer.writeBytes(this.lineSeparator);
        out.add(buffer);
    }
}
