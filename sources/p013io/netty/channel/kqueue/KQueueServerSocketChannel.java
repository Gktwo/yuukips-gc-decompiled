package p013io.netty.channel.kqueue;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.channel.unix.NativeInetAddress;

/* renamed from: io.netty.channel.kqueue.KQueueServerSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueServerSocketChannel.class */
public final class KQueueServerSocketChannel extends AbstractKQueueServerChannel implements ServerSocketChannel {
    private final KQueueServerSocketChannelConfig config;

    public KQueueServerSocketChannel() {
        super(BsdSocket.newSocketStream(), false);
        this.config = new KQueueServerSocketChannelConfig(this);
    }

    public KQueueServerSocketChannel(int fd) {
        this(new BsdSocket(fd));
    }

    KQueueServerSocketChannel(BsdSocket fd) {
        super(fd);
        this.config = new KQueueServerSocketChannelConfig(this);
    }

    KQueueServerSocketChannel(BsdSocket fd, boolean active) {
        super(fd, active);
        this.config = new KQueueServerSocketChannelConfig(this);
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueServerChannel, p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof KQueueEventLoop;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        doBind(localAddress);
        this.socket.listen(this.config.getBacklog());
        if (this.config.isTcpFastOpen()) {
            this.socket.setTcpFastOpen(true);
        }
        this.active = true;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) localAddress();
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public KQueueServerSocketChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueServerChannel
    protected Channel newChildChannel(int fd, byte[] address, int offset, int len) throws Exception {
        return new KQueueSocketChannel(this, new BsdSocket(fd), NativeInetAddress.address(address, offset, len));
    }
}
