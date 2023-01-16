package p013io.netty.channel;

import p013io.netty.channel.ChannelHandlerMask;

/* renamed from: io.netty.channel.ChannelInboundHandlerAdapter */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelInboundHandlerAdapter.class */
public class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler {
    @Override // p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelRegistered();
    }

    @Override // p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelUnregistered();
    }

    @Override // p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }

    @Override // p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelInactive();
    }

    @Override // p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(msg);
    }

    @Override // p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelReadComplete();
    }

    @Override // p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        ctx.fireUserEventTriggered(evt);
    }

    @Override // p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelWritabilityChanged();
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }
}
