package p013io.netty.channel;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

@ChannelHandler.Sharable
/* renamed from: io.netty.channel.ChannelInitializer */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelInitializer.class */
public abstract class ChannelInitializer<C extends Channel> extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelInitializer.class);
    private final Set<ChannelHandlerContext> initMap = Collections.newSetFromMap(new ConcurrentHashMap());

    protected abstract void initChannel(C c) throws Exception;

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public final void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        if (initChannel(ctx)) {
            ctx.pipeline().fireChannelRegistered();
            removeState(ctx);
            return;
        }
        ctx.fireChannelRegistered();
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (logger.isWarnEnabled()) {
            logger.warn("Failed to initialize a channel. Closing: " + ctx.channel(), cause);
        }
        ctx.close();
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().isRegistered() && initChannel(ctx)) {
            removeState(ctx);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        this.initMap.remove(ctx);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.channel.ChannelInitializer<C extends io.netty.channel.Channel> */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean initChannel(ChannelHandlerContext ctx) throws Exception {
        if (!this.initMap.add(ctx)) {
            return false;
        }
        try {
            initChannel((ChannelInitializer<C>) ctx.channel());
            if (ctx.isRemoved()) {
                return true;
            }
            ctx.pipeline().remove(this);
            return true;
        } catch (Throwable th) {
            if (!ctx.isRemoved()) {
                ctx.pipeline().remove(this);
            }
            throw th;
        }
    }

    private void removeState(final ChannelHandlerContext ctx) {
        if (ctx.isRemoved()) {
            this.initMap.remove(ctx);
        } else {
            ctx.executor().execute(new Runnable() { // from class: io.netty.channel.ChannelInitializer.1
                @Override // java.lang.Runnable
                public void run() {
                    ChannelInitializer.this.initMap.remove(ctx);
                }
            });
        }
    }
}
