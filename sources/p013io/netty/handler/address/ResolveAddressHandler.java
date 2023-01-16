package p013io.netty.handler.address;

import java.net.SocketAddress;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundHandlerAdapter;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.resolver.AddressResolver;
import p013io.netty.resolver.AddressResolverGroup;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.address.ResolveAddressHandler */
/* loaded from: grasscutter.jar:io/netty/handler/address/ResolveAddressHandler.class */
public class ResolveAddressHandler extends ChannelOutboundHandlerAdapter {
    private final AddressResolverGroup<? extends SocketAddress> resolverGroup;

    public ResolveAddressHandler(AddressResolverGroup<? extends SocketAddress> resolverGroup) {
        this.resolverGroup = (AddressResolverGroup) ObjectUtil.checkNotNull(resolverGroup, "resolverGroup");
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void connect(final ChannelHandlerContext ctx, SocketAddress remoteAddress, final SocketAddress localAddress, final ChannelPromise promise) {
        AddressResolver<? extends SocketAddress> resolver = this.resolverGroup.getResolver(ctx.executor());
        if (!resolver.isSupported(remoteAddress) || resolver.isResolved(remoteAddress)) {
            ctx.connect(remoteAddress, localAddress, promise);
            ctx.pipeline().remove(this);
            return;
        }
        resolver.resolve(remoteAddress).addListener(new FutureListener<SocketAddress>() { // from class: io.netty.handler.address.ResolveAddressHandler.1
            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<SocketAddress> future) {
                Throwable cause = future.cause();
                if (cause != null) {
                    promise.setFailure(cause);
                } else {
                    ctx.connect(future.getNow(), localAddress, promise);
                }
                ctx.pipeline().remove(ResolveAddressHandler.this);
            }
        });
    }
}
