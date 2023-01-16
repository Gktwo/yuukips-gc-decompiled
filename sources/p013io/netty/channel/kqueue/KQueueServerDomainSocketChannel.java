package p013io.netty.channel.kqueue;

import java.io.File;
import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.channel.unix.DomainSocketAddress;
import p013io.netty.channel.unix.ServerDomainSocketChannel;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.kqueue.KQueueServerDomainSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueServerDomainSocketChannel.class */
public final class KQueueServerDomainSocketChannel extends AbstractKQueueServerChannel implements ServerDomainSocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(KQueueServerDomainSocketChannel.class);
    private final KQueueServerChannelConfig config;
    private volatile DomainSocketAddress local;

    public KQueueServerDomainSocketChannel() {
        super(BsdSocket.newSocketDomain(), false);
        this.config = new KQueueServerChannelConfig(this);
    }

    public KQueueServerDomainSocketChannel(int fd) {
        this(new BsdSocket(fd), false);
    }

    KQueueServerDomainSocketChannel(BsdSocket socket, boolean active) {
        super(socket, active);
        this.config = new KQueueServerChannelConfig(this);
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueServerChannel
    protected Channel newChildChannel(int fd, byte[] addr, int offset, int len) throws Exception {
        return new KQueueDomainSocketChannel(this, new BsdSocket(fd));
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        this.socket.bind(localAddress);
        this.socket.listen(this.config.getBacklog());
        this.local = (DomainSocketAddress) localAddress;
        this.active = true;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
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

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public KQueueServerChannelConfig config() {
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
