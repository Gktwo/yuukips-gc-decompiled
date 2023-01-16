package p013io.netty.channel.epoll;

import java.io.File;
import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.channel.unix.DomainSocketAddress;
import p013io.netty.channel.unix.ServerDomainSocketChannel;
import p013io.netty.channel.unix.Socket;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.epoll.EpollServerDomainSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollServerDomainSocketChannel.class */
public final class EpollServerDomainSocketChannel extends AbstractEpollServerChannel implements ServerDomainSocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(EpollServerDomainSocketChannel.class);
    private final EpollServerChannelConfig config = new EpollServerChannelConfig(this);
    private volatile DomainSocketAddress local;

    public EpollServerDomainSocketChannel() {
        super(LinuxSocket.newSocketDomain(), false);
    }

    public EpollServerDomainSocketChannel(int fd) {
        super(fd);
    }

    EpollServerDomainSocketChannel(LinuxSocket fd) {
        super(fd);
    }

    EpollServerDomainSocketChannel(LinuxSocket fd, boolean active) {
        super(fd, active);
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollServerChannel
    protected Channel newChildChannel(int fd, byte[] addr, int offset, int len) throws Exception {
        return new EpollDomainSocketChannel(this, new Socket(fd));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doBind(SocketAddress localAddress) throws Exception {
        this.socket.bind(localAddress);
        this.socket.listen(this.config.getBacklog());
        this.local = (DomainSocketAddress) localAddress;
        this.active = true;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        try {
            doClose();
            DomainSocketAddress local = this.local;
            if (local != null && !new File(local.path()).delete() && logger.isDebugEnabled()) {
                logger.debug("Failed to delete a domain socket file: {}", local.path());
            }
        } catch (Throwable th) {
            DomainSocketAddress local2 = this.local;
            if (local2 != null && !new File(local2.path()).delete() && logger.isDebugEnabled()) {
                logger.debug("Failed to delete a domain socket file: {}", local2.path());
            }
            throw th;
        }
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public EpollServerChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) localAddress();
    }
}
