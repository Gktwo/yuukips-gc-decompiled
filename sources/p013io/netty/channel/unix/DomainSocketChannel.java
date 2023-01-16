package p013io.netty.channel.unix;

import p013io.netty.channel.socket.DuplexChannel;

/* renamed from: io.netty.channel.unix.DomainSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/unix/DomainSocketChannel.class */
public interface DomainSocketChannel extends UnixChannel, DuplexChannel {
    @Override // p013io.netty.channel.Channel
    DomainSocketAddress remoteAddress();

    @Override // p013io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // p013io.netty.channel.Channel
    DomainSocketChannelConfig config();
}
