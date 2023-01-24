package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.epoll.AbstractEpollChannel;
import p013io.netty.channel.epoll.AbstractEpollStreamChannel;
import p013io.netty.channel.unix.DomainSocketAddress;
import p013io.netty.channel.unix.DomainSocketChannel;
import p013io.netty.channel.unix.FileDescriptor;
import p013io.netty.channel.unix.PeerCredentials;

/* renamed from: io.netty.channel.epoll.EpollDomainSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollDomainSocketChannel.class */
public final class EpollDomainSocketChannel extends AbstractEpollStreamChannel implements DomainSocketChannel {
    private final EpollDomainSocketChannelConfig config = new EpollDomainSocketChannelConfig(this);
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;

    public EpollDomainSocketChannel() {
        super(LinuxSocket.newSocketDomain(), false);
    }

    /* access modifiers changed from: package-private */
    public EpollDomainSocketChannel(Channel parent, FileDescriptor fd) {
        super(parent, new LinuxSocket(fd.intValue()));
    }

    public EpollDomainSocketChannel(int fd) {
        super(fd);
    }

    public EpollDomainSocketChannel(Channel parent, LinuxSocket fd) {
        super(parent, fd);
    }

    public EpollDomainSocketChannel(int fd, boolean active) {
        super(new LinuxSocket(fd), active);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollStreamChannel, p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDomainUnsafe();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doBind(SocketAddress localAddress) throws Exception {
        this.socket.bind(localAddress);
        this.local = (DomainSocketAddress) localAddress;
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public EpollDomainSocketChannelConfig config() {
        return this.config;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel
    public boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (!doConnect(remoteAddress, localAddress)) {
            return false;
        }
        this.local = (DomainSocketAddress) localAddress;
        this.remote = (DomainSocketAddress) remoteAddress;
        return true;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) localAddress();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollStreamChannel
    public int doWriteSingle(ChannelOutboundBuffer in) throws Exception {
        Object msg = in.current();
        if (!(msg instanceof FileDescriptor) || this.socket.sendFd(((FileDescriptor) msg).intValue()) <= 0) {
            return doWriteSingle(in);
        }
        in.remove();
        return 1;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollStreamChannel, p013io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object msg) {
        if (msg instanceof FileDescriptor) {
            return msg;
        }
        return filterOutboundMessage(msg);
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.epoll.EpollDomainSocketChannel$EpollDomainUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollDomainSocketChannel$EpollDomainUnsafe.class */
    public final class EpollDomainUnsafe extends AbstractEpollStreamChannel.EpollStreamUnsafe {
        private EpollDomainUnsafe() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // p013io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe, p013io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        public void epollInReady() {
            switch (EpollDomainSocketChannel.this.config().getReadMode()) {
                case BYTES:
                    epollInReady();
                    return;
                case FILE_DESCRIPTORS:
                    epollInReadFd();
                    return;
                default:
                    throw new Error();
            }
        }

        private void epollInReadFd() {
            if (EpollDomainSocketChannel.this.socket.isInputShutdown()) {
                clearEpollIn0();
                return;
            }
            ChannelConfig config = EpollDomainSocketChannel.this.config();
            EpollRecvByteAllocatorHandle allocHandle = recvBufAllocHandle();
            allocHandle.edgeTriggered(EpollDomainSocketChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline pipeline = EpollDomainSocketChannel.this.pipeline();
            allocHandle.reset(config);
            epollInBefore();
            do {
                try {
                    allocHandle.lastBytesRead(EpollDomainSocketChannel.this.socket.recvFd());
                    switch (allocHandle.lastBytesRead()) {
                        case -1:
                            close(voidPromise());
                            epollInFinally(config);
                            return;
                        case 0:
                            allocHandle.readComplete();
                            pipeline.fireChannelReadComplete();
                            epollInFinally(config);
                        default:
                            allocHandle.incMessagesRead(1);
                            this.readPending = false;
                            pipeline.fireChannelRead((Object) new FileDescriptor(allocHandle.lastBytesRead()));
                            break;
                    }
                } catch (Throwable th) {
                    epollInFinally(config);
                    throw th;
                }
            } while (allocHandle.continueReading());
            allocHandle.readComplete();
            pipeline.fireChannelReadComplete();
            epollInFinally(config);
        }
    }
}
