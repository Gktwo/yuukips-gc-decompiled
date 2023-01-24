package p013io.netty.channel.kqueue;

import java.io.IOException;
import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.kqueue.AbstractKQueueChannel;
import p013io.netty.channel.kqueue.AbstractKQueueStreamChannel;
import p013io.netty.channel.unix.DomainSocketAddress;
import p013io.netty.channel.unix.DomainSocketChannel;
import p013io.netty.channel.unix.FileDescriptor;
import p013io.netty.channel.unix.PeerCredentials;

/* renamed from: io.netty.channel.kqueue.KQueueDomainSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueDomainSocketChannel.class */
public final class KQueueDomainSocketChannel extends AbstractKQueueStreamChannel implements DomainSocketChannel {
    private final KQueueDomainSocketChannelConfig config;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;

    public KQueueDomainSocketChannel() {
        super((Channel) null, BsdSocket.newSocketDomain(), false);
        this.config = new KQueueDomainSocketChannelConfig(this);
    }

    public KQueueDomainSocketChannel(int fd) {
        this(null, new BsdSocket(fd));
    }

    /* access modifiers changed from: package-private */
    public KQueueDomainSocketChannel(Channel parent, BsdSocket fd) {
        super(parent, fd, true);
        this.config = new KQueueDomainSocketChannelConfig(this);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.kqueue.AbstractKQueueStreamChannel, p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDomainUnsafe();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        this.socket.bind(localAddress);
        this.local = (DomainSocketAddress) localAddress;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public KQueueDomainSocketChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel
    protected boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
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

    @Override // p013io.netty.channel.kqueue.AbstractKQueueStreamChannel
    protected int doWriteSingle(ChannelOutboundBuffer in) throws Exception {
        Object msg = in.current();
        if (!(msg instanceof FileDescriptor) || this.socket.sendFd(((FileDescriptor) msg).intValue()) <= 0) {
            return doWriteSingle(in);
        }
        in.remove();
        return 1;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueStreamChannel, p013io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object msg) {
        if (msg instanceof FileDescriptor) {
            return msg;
        }
        return filterOutboundMessage(msg);
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.kqueue.KQueueDomainSocketChannel$KQueueDomainUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueDomainSocketChannel$KQueueDomainUnsafe.class */
    public final class KQueueDomainUnsafe extends AbstractKQueueStreamChannel.KQueueStreamUnsafe {
        private KQueueDomainUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe, p013io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        void readReady(KQueueRecvByteAllocatorHandle allocHandle) {
            switch (KQueueDomainSocketChannel.this.config().getReadMode()) {
                case BYTES:
                    readReady(allocHandle);
                    return;
                case FILE_DESCRIPTORS:
                    readReadyFd();
                    return;
                default:
                    throw new Error();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0099, code lost:
            r0.readComplete();
            r0.fireChannelReadComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a5, code lost:
            readReadyFinally(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d4, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void readReadyFd() {
            /*
                r5 = this;
                r0 = r5
                io.netty.channel.kqueue.KQueueDomainSocketChannel r0 = p013io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.kqueue.BsdSocket r0 = r0.socket
                boolean r0 = r0.isInputShutdown()
                if (r0 == 0) goto L_0x0012
                r0 = r5
                r0.clearReadFilter0()
                return
            L_0x0012:
                r0 = r5
                io.netty.channel.kqueue.KQueueDomainSocketChannel r0 = p013io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.kqueue.KQueueDomainSocketChannelConfig r0 = r0.config()
                r6 = r0
                r0 = r5
                io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r0 = r0.recvBufAllocHandle()
                r7 = r0
                r0 = r5
                io.netty.channel.kqueue.KQueueDomainSocketChannel r0 = p013io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.ChannelPipeline r0 = r0.pipeline()
                r8 = r0
                r0 = r7
                r1 = r6
                r0.reset(r1)
                r0 = r5
                r0.readReadyBefore()
            L_0x0030:
                r0 = r5
                io.netty.channel.kqueue.KQueueDomainSocketChannel r0 = p013io.netty.channel.kqueue.KQueueDomainSocketChannel.this     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                io.netty.channel.kqueue.BsdSocket r0 = r0.socket     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                int r0 = r0.recvFd()     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r9 = r0
                r0 = r9
                switch(r0) {
                    case -1: goto L_0x0060;
                    case 0: goto L_0x0058;
                    default: goto L_0x0073;
                }     // Catch: Throwable -> 0x00ac, all -> 0x00ca
            L_0x0058:
                r0 = r7
                r1 = 0
                r0.lastBytesRead(r1)     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                goto L_0x0099
            L_0x0060:
                r0 = r7
                r1 = -1
                r0.lastBytesRead(r1)     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0 = r5
                r1 = r5
                io.netty.channel.ChannelPromise r1 = r1.voidPromise()     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0.close(r1)     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0 = r5
                r1 = r6
                r0.readReadyFinally(r1)
                return
            L_0x0073:
                r0 = r7
                r1 = 1
                r0.lastBytesRead(r1)     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0 = r7
                r1 = 1
                r0.incMessagesRead(r1)     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0 = r5
                r1 = 0
                r0.readPending = r1     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0 = r8
                io.netty.channel.unix.FileDescriptor r1 = new io.netty.channel.unix.FileDescriptor     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r2 = r1
                r3 = r9
                r2.<init>(r3)     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                io.netty.channel.ChannelPipeline r0 = r0.fireChannelRead(r1)     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0 = r7
                boolean r0 = r0.continueReading()     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                if (r0 != 0) goto L_0x0030
            L_0x0099:
                r0 = r7
                r0.readComplete()     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0 = r8
                io.netty.channel.ChannelPipeline r0 = r0.fireChannelReadComplete()     // Catch: Throwable -> 0x00ac, all -> 0x00ca
                r0 = r5
                r1 = r6
                r0.readReadyFinally(r1)
                goto L_0x00d4
            L_0x00ac:
                r9 = move-exception
                r0 = r7
                r0.readComplete()     // Catch: all -> 0x00ca
                r0 = r8
                io.netty.channel.ChannelPipeline r0 = r0.fireChannelReadComplete()     // Catch: all -> 0x00ca
                r0 = r8
                r1 = r9
                io.netty.channel.ChannelPipeline r0 = r0.fireExceptionCaught(r1)     // Catch: all -> 0x00ca
                r0 = r5
                r1 = r6
                r0.readReadyFinally(r1)
                goto L_0x00d4
            L_0x00ca:
                r10 = move-exception
                r0 = r5
                r1 = r6
                r0.readReadyFinally(r1)
                r0 = r10
                throw r0
            L_0x00d4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.kqueue.KQueueDomainSocketChannel.KQueueDomainUnsafe.readReadyFd():void");
        }
    }
}
