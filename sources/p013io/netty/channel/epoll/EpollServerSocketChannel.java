package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import p013io.netty.channel.Channel;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.channel.unix.NativeInetAddress;

/* renamed from: io.netty.channel.epoll.EpollServerSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollServerSocketChannel.class */
public final class EpollServerSocketChannel extends AbstractEpollServerChannel implements ServerSocketChannel {
    private final EpollServerSocketChannelConfig config;
    private volatile Collection<InetAddress> tcpMd5SigAddresses;

    public EpollServerSocketChannel() {
        this((InternetProtocolFamily) null);
    }

    public EpollServerSocketChannel(InternetProtocolFamily protocol) {
        super(LinuxSocket.newSocketStream(protocol), false);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollServerSocketChannelConfig(this);
    }

    public EpollServerSocketChannel(int fd) {
        this(new LinuxSocket(fd));
    }

    EpollServerSocketChannel(LinuxSocket fd) {
        super(fd);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollServerSocketChannelConfig(this);
    }

    EpollServerSocketChannel(LinuxSocket fd, boolean active) {
        super(fd, active);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollServerSocketChannelConfig(this);
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollServerChannel, p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof EpollEventLoop;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doBind(SocketAddress localAddress) throws Exception {
        int tcpFastopen;
        doBind(localAddress);
        if (Native.IS_SUPPORTING_TCP_FASTOPEN_SERVER && (tcpFastopen = this.config.getTcpFastopen()) > 0) {
            this.socket.setTcpFastOpen(tcpFastopen);
        }
        this.socket.listen(this.config.getBacklog());
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

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public EpollServerSocketChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollServerChannel
    protected Channel newChildChannel(int fd, byte[] address, int offset, int len) throws Exception {
        return new EpollSocketChannel(this, new LinuxSocket(fd), NativeInetAddress.address(address, offset, len));
    }

    /* access modifiers changed from: package-private */
    public Collection<InetAddress> tcpMd5SigAddresses() {
        return this.tcpMd5SigAddresses;
    }

    /* access modifiers changed from: package-private */
    public void setTcpMd5Sig(Map<InetAddress, byte[]> keys) throws IOException {
        this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, keys);
    }
}
