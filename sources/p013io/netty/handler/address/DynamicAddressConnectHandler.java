package p013io.netty.handler.address;

import java.net.SocketAddress;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundHandlerAdapter;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;

/* renamed from: io.netty.handler.address.DynamicAddressConnectHandler */
/* loaded from: grasscutter.jar:io/netty/handler/address/DynamicAddressConnectHandler.class */
public abstract class DynamicAddressConnectHandler extends ChannelOutboundHandlerAdapter {
    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public final void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        try {
            ctx.connect(remoteAddress(remoteAddress, localAddress), localAddress(remoteAddress, localAddress), promise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.address.DynamicAddressConnectHandler.1
                public void operationComplete(ChannelFuture future) {
                    if (future.isSuccess()) {
                        future.channel().pipeline().remove(DynamicAddressConnectHandler.this);
                    }
                }
            });
        } catch (Exception e) {
            promise.setFailure((Throwable) e);
        }
    }

    protected SocketAddress localAddress(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        return localAddress;
    }

    protected SocketAddress remoteAddress(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        return remoteAddress;
    }
}
