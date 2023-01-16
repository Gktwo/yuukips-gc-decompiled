package p013io.netty.channel;

import p013io.netty.util.concurrent.OrderedEventExecutor;

/* renamed from: io.netty.channel.EventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/EventLoop.class */
public interface EventLoop extends OrderedEventExecutor, EventLoopGroup {
    EventLoopGroup parent();
}
