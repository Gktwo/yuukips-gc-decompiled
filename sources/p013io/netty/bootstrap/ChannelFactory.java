package p013io.netty.bootstrap;

import p013io.netty.channel.Channel;

@Deprecated
/* renamed from: io.netty.bootstrap.ChannelFactory */
/* loaded from: grasscutter.jar:io/netty/bootstrap/ChannelFactory.class */
public interface ChannelFactory<T extends Channel> {
    T newChannel();
}
