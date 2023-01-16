package p013io.netty.channel;

/* renamed from: io.netty.channel.ChannelInboundHandler */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelInboundHandler.class */
public interface ChannelInboundHandler extends ChannelHandler {
    void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception;

    void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception;

    void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception;

    void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception;

    void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception;
}
