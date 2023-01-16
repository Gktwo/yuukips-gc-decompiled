package p013io.netty.channel;

import p013io.netty.util.concurrent.EventExecutorGroup;

/* renamed from: io.netty.channel.EventLoopGroup */
/* loaded from: grasscutter.jar:io/netty/channel/EventLoopGroup.class */
public interface EventLoopGroup extends EventExecutorGroup {
    EventLoop next();

    ChannelFuture register(Channel channel);

    ChannelFuture register(ChannelPromise channelPromise);

    @Deprecated
    ChannelFuture register(Channel channel, ChannelPromise channelPromise);
}
