package p013io.netty.handler.codec;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.DatagramPacketDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/DatagramPacketDecoder.class */
public class DatagramPacketDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final MessageToMessageDecoder<ByteBuf> decoder;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List list) throws Exception {
        decode(channelHandlerContext, datagramPacket, (List<Object>) list);
    }

    public DatagramPacketDecoder(MessageToMessageDecoder<ByteBuf> decoder) {
        this.decoder = (MessageToMessageDecoder) ObjectUtil.checkNotNull(decoder, "decoder");
    }

    @Override // p013io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object msg) throws Exception {
        if (msg instanceof DatagramPacket) {
            return this.decoder.acceptInboundMessage(((DatagramPacket) msg).content());
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.netty.handler.codec.MessageToMessageDecoder<io.netty.buffer.ByteBuf> */
    /* JADX WARN: Multi-variable type inference failed */
    protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
        this.decoder.decode(ctx, msg.content(), out);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        this.decoder.channelRegistered(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        this.decoder.channelUnregistered(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.decoder.channelActive(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        this.decoder.channelInactive(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        this.decoder.channelReadComplete(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        this.decoder.userEventTriggered(ctx, evt);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        this.decoder.channelWritabilityChanged(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        this.decoder.exceptionCaught(ctx, cause);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.decoder.handlerAdded(ctx);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        this.decoder.handlerRemoved(ctx);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return this.decoder.isSharable();
    }
}
