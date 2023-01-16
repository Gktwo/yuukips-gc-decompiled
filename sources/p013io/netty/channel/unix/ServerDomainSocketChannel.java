package p013io.netty.channel.unix;

import p013io.netty.channel.ServerChannel;

/* renamed from: io.netty.channel.unix.ServerDomainSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/unix/ServerDomainSocketChannel.class */
public interface ServerDomainSocketChannel extends ServerChannel, UnixChannel {
    @Override // p013io.netty.channel.Channel
    DomainSocketAddress remoteAddress();

    @Override // p013io.netty.channel.Channel
    DomainSocketAddress localAddress();
}
