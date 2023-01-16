package p013io.netty.channel;

import p013io.netty.util.concurrent.AbstractEventExecutor;

/* renamed from: io.netty.channel.AbstractEventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/AbstractEventLoop.class */
public abstract class AbstractEventLoop extends AbstractEventExecutor implements EventLoop {
    protected AbstractEventLoop() {
    }

    protected AbstractEventLoop(EventLoopGroup parent) {
        super(parent);
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor, p013io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup) parent();
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) next();
    }
}
