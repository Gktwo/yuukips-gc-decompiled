package p013io.netty.handler.ipfilter;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Set;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ConcurrentSet;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.ipfilter.UniqueIpFilter */
/* loaded from: grasscutter.jar:io/netty/handler/ipfilter/UniqueIpFilter.class */
public class UniqueIpFilter extends AbstractRemoteAddressFilter<InetSocketAddress> {
    private final Set<InetAddress> connected = new ConcurrentSet();

    /* access modifiers changed from: protected */
    public boolean accept(ChannelHandlerContext ctx, InetSocketAddress remoteAddress) throws Exception {
        final InetAddress remoteIp = remoteAddress.getAddress();
        if (!this.connected.add(remoteIp)) {
            return false;
        }
        ctx.channel().closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.ipfilter.UniqueIpFilter.1
            public void operationComplete(ChannelFuture future) throws Exception {
                UniqueIpFilter.this.connected.remove(remoteIp);
            }
        });
        return true;
    }
}
