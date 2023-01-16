package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.epoll.AbstractEpollChannel;
import p013io.netty.channel.epoll.AbstractEpollStreamChannel;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.channel.socket.SocketChannel;
import p013io.netty.util.concurrent.GlobalEventExecutor;

/* renamed from: io.netty.channel.epoll.EpollSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollSocketChannel.class */
public final class EpollSocketChannel extends AbstractEpollStreamChannel implements SocketChannel {
    private final EpollSocketChannelConfig config;
    private volatile Collection<InetAddress> tcpMd5SigAddresses;

    public EpollSocketChannel() {
        super(LinuxSocket.newSocketStream(), false);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollSocketChannelConfig(this);
    }

    public EpollSocketChannel(InternetProtocolFamily protocol) {
        super(LinuxSocket.newSocketStream(protocol), false);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollSocketChannelConfig(this);
    }

    public EpollSocketChannel(int fd) {
        super(fd);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollSocketChannelConfig(this);
    }

    EpollSocketChannel(LinuxSocket fd, boolean active) {
        super(fd, active);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollSocketChannelConfig(this);
    }

    /* access modifiers changed from: package-private */
    public EpollSocketChannel(Channel parent, LinuxSocket fd, InetSocketAddress remoteAddress) {
        super(parent, fd, remoteAddress);
        this.tcpMd5SigAddresses = Collections.emptyList();
        this.config = new EpollSocketChannelConfig(this);
        if (parent instanceof EpollServerSocketChannel) {
            this.tcpMd5SigAddresses = ((EpollServerSocketChannel) parent).tcpMd5SigAddresses();
        }
    }

    public EpollTcpInfo tcpInfo() {
        return tcpInfo(new EpollTcpInfo());
    }

    public EpollTcpInfo tcpInfo(EpollTcpInfo info) {
        try {
            this.socket.getTcpInfo(info);
            return info;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
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
    public EpollSocketChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) parent();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollStreamChannel, p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollSocketChannelUnsafe();
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel
    boolean doConnect0(SocketAddress remote) throws Exception {
        if (Native.IS_SUPPORTING_TCP_FASTOPEN_CLIENT && this.config.isTcpFastOpenConnect()) {
            ChannelOutboundBuffer outbound = unsafe().outboundBuffer();
            outbound.addFlush();
            Object curr = outbound.current();
            if (curr instanceof ByteBuf) {
                long localFlushedAmount = doWriteOrSendBytes((ByteBuf) curr, (InetSocketAddress) remote, true);
                if (localFlushedAmount > 0) {
                    outbound.removeBytes(localFlushedAmount);
                    return true;
                }
            }
        }
        return doConnect0(remote);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.epoll.EpollSocketChannel$EpollSocketChannelUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollSocketChannel$EpollSocketChannelUnsafe.class */
    public final class EpollSocketChannelUnsafe extends AbstractEpollStreamChannel.EpollStreamUnsafe {
        private EpollSocketChannelUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe, p013io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            try {
                if (!EpollSocketChannel.this.isOpen() || EpollSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                ((EpollEventLoop) EpollSocketChannel.this.eventLoop()).remove(EpollSocketChannel.this);
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable th) {
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setTcpMd5Sig(Map<InetAddress, byte[]> keys) throws IOException {
        this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, keys);
    }
}
