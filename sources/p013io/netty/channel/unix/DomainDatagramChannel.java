package p013io.netty.channel.unix;

import p013io.netty.channel.Channel;

/* renamed from: io.netty.channel.unix.DomainDatagramChannel */
/* loaded from: grasscutter.jar:io/netty/channel/unix/DomainDatagramChannel.class */
public interface DomainDatagramChannel extends UnixChannel, Channel {
    @Override // p013io.netty.channel.Channel
    DomainDatagramChannelConfig config();

    boolean isConnected();

    @Override // p013io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // p013io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
