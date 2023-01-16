package p013io.netty.channel.socket;

import java.net.InetSocketAddress;
import p013io.netty.channel.ServerChannel;

/* renamed from: io.netty.channel.socket.ServerSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/ServerSocketChannel.class */
public interface ServerSocketChannel extends ServerChannel {
    @Override // p013io.netty.channel.Channel
    ServerSocketChannelConfig config();

    @Override // p013io.netty.channel.Channel
    InetSocketAddress localAddress();

    @Override // p013io.netty.channel.Channel
    InetSocketAddress remoteAddress();
}
