package p013io.netty.channel;

import java.util.Map;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerMask;
import p013io.netty.util.internal.InternalThreadLocalMap;

/* renamed from: io.netty.channel.ChannelHandlerAdapter */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelHandlerAdapter.class */
public abstract class ChannelHandlerAdapter implements ChannelHandler {
    boolean added;

    protected void ensureNotSharable() {
        if (isSharable()) {
            throw new IllegalStateException("ChannelHandler " + getClass().getName() + " is not allowed to be shared");
        }
    }

    public boolean isSharable() {
        Class<?> clazz = getClass();
        Map<Class<?>, Boolean> cache = InternalThreadLocalMap.get().handlerSharableCache();
        Boolean sharable = cache.get(clazz);
        if (sharable == null) {
            sharable = Boolean.valueOf(clazz.isAnnotationPresent(ChannelHandler.Sharable.class));
            cache.put(clazz, sharable);
        }
        return sharable.booleanValue();
    }

    @Override // p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    }

    @Override // p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    }

    @Override // p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    @Deprecated
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }
}
