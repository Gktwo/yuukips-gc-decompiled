package p013io.netty.channel;

import java.net.SocketAddress;
import p013io.netty.channel.ChannelHandlerMask;

/* renamed from: io.netty.channel.ChannelDuplexHandler */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelDuplexHandler.class */
public class ChannelDuplexHandler extends ChannelInboundHandlerAdapter implements ChannelOutboundHandler {
    @Override // p013io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.bind(localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.connect(remoteAddress, localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.disconnect(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.close(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.deregister(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void read(ChannelHandlerContext ctx) throws Exception {
        ctx.read();
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.write(msg, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void flush(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
