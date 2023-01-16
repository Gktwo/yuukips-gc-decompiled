package p013io.netty.channel.kqueue;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.kqueue.AbstractKQueueChannel;
import p013io.netty.channel.kqueue.AbstractKQueueStreamChannel;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.channel.socket.SocketChannel;
import p013io.netty.channel.unix.IovArray;
import p013io.netty.util.concurrent.GlobalEventExecutor;

/* renamed from: io.netty.channel.kqueue.KQueueSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueSocketChannel.class */
public final class KQueueSocketChannel extends AbstractKQueueStreamChannel implements SocketChannel {
    private final KQueueSocketChannelConfig config = new KQueueSocketChannelConfig(this);

    public KQueueSocketChannel() {
        super((Channel) null, BsdSocket.newSocketStream(), false);
    }

    public KQueueSocketChannel(InternetProtocolFamily protocol) {
        super((Channel) null, BsdSocket.newSocketStream(protocol), false);
    }

    public KQueueSocketChannel(int fd) {
        super(new BsdSocket(fd));
    }

    /* access modifiers changed from: package-private */
    public KQueueSocketChannel(Channel parent, BsdSocket fd, InetSocketAddress remoteAddress) {
        super(parent, fd, remoteAddress);
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
    public KQueueSocketChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) parent();
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel
    protected boolean doConnect0(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (this.config.isTcpFastOpenConnect()) {
            ChannelOutboundBuffer outbound = unsafe().outboundBuffer();
            outbound.addFlush();
            Object curr = outbound.current();
            if (curr instanceof ByteBuf) {
                ByteBuf initialData = (ByteBuf) curr;
                if (initialData.isReadable()) {
                    IovArray iov = new IovArray(this.config.getAllocator().directBuffer());
                    try {
                        iov.add(initialData, initialData.readerIndex(), initialData.readableBytes());
                        int bytesSent = this.socket.connectx((InetSocketAddress) localAddress, (InetSocketAddress) remoteAddress, iov, true);
                        writeFilter(true);
                        outbound.removeBytes((long) Math.abs(bytesSent));
                        return bytesSent > 0;
                    } finally {
                        iov.release();
                    }
                }
            }
        }
        return doConnect0(remoteAddress, localAddress);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.kqueue.AbstractKQueueStreamChannel, p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueSocketChannelUnsafe();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.kqueue.KQueueSocketChannel$KQueueSocketChannelUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueSocketChannel$KQueueSocketChannelUnsafe.class */
    public final class KQueueSocketChannelUnsafe extends AbstractKQueueStreamChannel.KQueueStreamUnsafe {
        private KQueueSocketChannelUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe, p013io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            try {
                if (!KQueueSocketChannel.this.isOpen() || KQueueSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                ((KQueueEventLoop) KQueueSocketChannel.this.eventLoop()).remove(KQueueSocketChannel.this);
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable th) {
                return null;
            }
        }
    }
}
