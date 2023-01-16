package p013io.netty.channel.group;

import java.util.Set;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelId;

/* renamed from: io.netty.channel.group.ChannelGroup */
/* loaded from: grasscutter.jar:io/netty/channel/group/ChannelGroup.class */
public interface ChannelGroup extends Set<Channel>, Comparable<ChannelGroup> {
    String name();

    Channel find(ChannelId channelId);

    ChannelGroupFuture write(Object obj);

    ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher);

    ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher, boolean z);

    ChannelGroup flush();

    ChannelGroup flush(ChannelMatcher channelMatcher);

    ChannelGroupFuture writeAndFlush(Object obj);

    @Deprecated
    ChannelGroupFuture flushAndWrite(Object obj);

    ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher);

    ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher, boolean z);

    @Deprecated
    ChannelGroupFuture flushAndWrite(Object obj, ChannelMatcher channelMatcher);

    ChannelGroupFuture disconnect();

    ChannelGroupFuture disconnect(ChannelMatcher channelMatcher);

    ChannelGroupFuture close();

    ChannelGroupFuture close(ChannelMatcher channelMatcher);

    @Deprecated
    ChannelGroupFuture deregister();

    @Deprecated
    ChannelGroupFuture deregister(ChannelMatcher channelMatcher);

    ChannelGroupFuture newCloseFuture();

    ChannelGroupFuture newCloseFuture(ChannelMatcher channelMatcher);
}
