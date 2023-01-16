package p013io.netty.handler.codec.bytes;

import java.util.List;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToMessageEncoder;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.codec.bytes.ByteArrayEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/bytes/ByteArrayEncoder.class */
public class ByteArrayEncoder extends MessageToMessageEncoder<byte[]> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, byte[] bArr, List list) throws Exception {
        encode(channelHandlerContext, bArr, (List<Object>) list);
    }

    protected void encode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
        out.add(Unpooled.wrappedBuffer(msg));
    }
}
