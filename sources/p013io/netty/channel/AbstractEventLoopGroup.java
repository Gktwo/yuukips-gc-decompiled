package p013io.netty.channel;

import p013io.netty.util.concurrent.AbstractEventExecutorGroup;

/* renamed from: io.netty.channel.AbstractEventLoopGroup */
/* loaded from: grasscutter.jar:io/netty/channel/AbstractEventLoopGroup.class */
public abstract class AbstractEventLoopGroup extends AbstractEventExecutorGroup implements EventLoopGroup {
    @Override // p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    public abstract EventLoop next();
}
