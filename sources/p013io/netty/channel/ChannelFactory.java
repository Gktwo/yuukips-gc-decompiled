package p013io.netty.channel;

import p013io.netty.channel.Channel;

/* renamed from: io.netty.channel.ChannelFactory */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelFactory.class */
public interface ChannelFactory<T extends Channel> extends p013io.netty.bootstrap.ChannelFactory<T> {
    @Override // p013io.netty.bootstrap.ChannelFactory
    T newChannel();
}
