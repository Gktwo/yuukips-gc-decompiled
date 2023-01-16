package p013io.netty.channel.socket;

import java.net.InetSocketAddress;

/* renamed from: io.netty.channel.socket.SocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/SocketChannel.class */
public interface SocketChannel extends DuplexChannel {
    @Override // p013io.netty.channel.Channel
    ServerSocketChannel parent();

    @Override // p013io.netty.channel.Channel
    SocketChannelConfig config();

    @Override // p013io.netty.channel.Channel
    InetSocketAddress localAddress();

    @Override // p013io.netty.channel.Channel
    InetSocketAddress remoteAddress();
}
