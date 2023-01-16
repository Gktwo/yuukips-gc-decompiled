package p013io.netty.channel;

import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.internal.TypeParameterMatcher;

/* renamed from: io.netty.channel.SimpleUserEventChannelHandler */
/* loaded from: grasscutter.jar:io/netty/channel/SimpleUserEventChannelHandler.class */
public abstract class SimpleUserEventChannelHandler<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean autoRelease;

    protected abstract void eventReceived(ChannelHandlerContext channelHandlerContext, I i) throws Exception;

    protected SimpleUserEventChannelHandler() {
        this(true);
    }

    protected SimpleUserEventChannelHandler(boolean autoRelease) {
        this.matcher = TypeParameterMatcher.find(this, SimpleUserEventChannelHandler.class, "I");
        this.autoRelease = autoRelease;
    }

    protected SimpleUserEventChannelHandler(Class<? extends I> eventType) {
        this(eventType, true);
    }

    protected SimpleUserEventChannelHandler(Class<? extends I> eventType, boolean autoRelease) {
        this.matcher = TypeParameterMatcher.get(eventType);
        this.autoRelease = autoRelease;
    }

    protected boolean acceptEvent(Object evt) throws Exception {
        return this.matcher.match(evt);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public final void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        boolean release = true;
        try {
            if (acceptEvent(evt)) {
                eventReceived(ctx, evt);
            } else {
                release = false;
                ctx.fireUserEventTriggered(evt);
            }
            if (this.autoRelease && release) {
                ReferenceCountUtil.release(evt);
            }
        } catch (Throwable th) {
            if (this.autoRelease && 1 != 0) {
                ReferenceCountUtil.release(evt);
            }
            throw th;
        }
    }
}
