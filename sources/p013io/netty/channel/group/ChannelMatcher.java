package p013io.netty.channel.group;

import p013io.netty.channel.Channel;

/* renamed from: io.netty.channel.group.ChannelMatcher */
/* loaded from: grasscutter.jar:io/netty/channel/group/ChannelMatcher.class */
public interface ChannelMatcher {
    boolean matches(Channel channel);
}
