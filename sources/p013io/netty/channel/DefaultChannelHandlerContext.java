package p013io.netty.channel;

import p013io.netty.util.concurrent.EventExecutor;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.DefaultChannelHandlerContext */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelHandlerContext.class */
public final class DefaultChannelHandlerContext extends AbstractChannelHandlerContext {
    private final ChannelHandler handler;

    /* access modifiers changed from: package-private */
    public DefaultChannelHandlerContext(DefaultChannelPipeline pipeline, EventExecutor executor, String name, ChannelHandler handler) {
        super(pipeline, executor, name, handler.getClass());
        this.handler = handler;
    }

    @Override // p013io.netty.channel.ChannelHandlerContext
    public ChannelHandler handler() {
        return this.handler;
    }
}
