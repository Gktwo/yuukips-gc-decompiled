package p013io.netty.handler.ipfilter;

import java.net.SocketAddress;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;

/* renamed from: io.netty.handler.ipfilter.AbstractRemoteAddressFilter */
/* loaded from: grasscutter.jar:io/netty/handler/ipfilter/AbstractRemoteAddressFilter.class */
public abstract class AbstractRemoteAddressFilter<T extends SocketAddress> extends ChannelInboundHandlerAdapter {
    protected abstract boolean accept(ChannelHandlerContext channelHandlerContext, T t) throws Exception;

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        handleNewChannel(ctx);
        ctx.fireChannelRegistered();
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (!handleNewChannel(ctx)) {
            throw new IllegalStateException("cannot determine to accept or reject a channel: " + ctx.channel());
        }
        ctx.fireChannelActive();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.handler.ipfilter.AbstractRemoteAddressFilter<T extends java.net.SocketAddress> */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean handleNewChannel(ChannelHandlerContext ctx) throws Exception {
        SocketAddress remoteAddress = ctx.channel().remoteAddress();
        if (remoteAddress == null) {
            return false;
        }
        ctx.pipeline().remove(this);
        if (accept(ctx, remoteAddress)) {
            channelAccepted(ctx, remoteAddress);
            return true;
        }
        ChannelFuture rejectedFuture = channelRejected(ctx, remoteAddress);
        if (rejectedFuture != null) {
            rejectedFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            return true;
        }
        ctx.close();
        return true;
    }

    protected void channelAccepted(ChannelHandlerContext ctx, T remoteAddress) {
    }

    protected ChannelFuture channelRejected(ChannelHandlerContext ctx, T remoteAddress) {
        return null;
    }
}
