package p013io.netty.channel.kqueue;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.ServerChannel;
import p013io.netty.channel.kqueue.AbstractKQueueChannel;

/* renamed from: io.netty.channel.kqueue.AbstractKQueueServerChannel */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/AbstractKQueueServerChannel.class */
public abstract class AbstractKQueueServerChannel extends AbstractKQueueChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    abstract Channel newChildChannel(int i, byte[] bArr, int i2, int i3) throws Exception;

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return isOpen();
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return isActive();
    }

    /* access modifiers changed from: package-private */
    public AbstractKQueueServerChannel(BsdSocket fd) {
        this(fd, isSoErrorZero(fd));
    }

    /* access modifiers changed from: package-private */
    public AbstractKQueueServerChannel(BsdSocket fd, boolean active) {
        super((Channel) null, fd, active);
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof KQueueEventLoop;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    public InetSocketAddress remoteAddress0() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel, p013io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueServerSocketUnsafe();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object msg) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel
    protected boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.kqueue.AbstractKQueueServerChannel$KQueueServerSocketUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/kqueue/AbstractKQueueServerChannel$KQueueServerSocketUnsafe.class */
    public final class KQueueServerSocketUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        private final byte[] acceptedAddress = new byte[26];
        static final /* synthetic */ boolean $assertionsDisabled;

        KQueueServerSocketUnsafe() {
            super();
        }

        static {
            $assertionsDisabled = !AbstractKQueueServerChannel.class.desiredAssertionStatus();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
            r9.lastBytesRead(-1);
         */
        @Override // p013io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void readReady(p013io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r9) {
            /*
                r8 = this;
                boolean r0 = p013io.netty.channel.kqueue.AbstractKQueueServerChannel.KQueueServerSocketUnsafe.$assertionsDisabled
                if (r0 != 0) goto L_0x001d
                r0 = r8
                io.netty.channel.kqueue.AbstractKQueueServerChannel r0 = p013io.netty.channel.kqueue.AbstractKQueueServerChannel.this
                io.netty.channel.EventLoop r0 = r0.eventLoop()
                boolean r0 = r0.inEventLoop()
                if (r0 != 0) goto L_0x001d
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r1 = r0
                r1.<init>()
                throw r0
            L_0x001d:
                r0 = r8
                io.netty.channel.kqueue.AbstractKQueueServerChannel r0 = p013io.netty.channel.kqueue.AbstractKQueueServerChannel.this
                io.netty.channel.kqueue.KQueueChannelConfig r0 = r0.config()
                r10 = r0
                r0 = r8
                io.netty.channel.kqueue.AbstractKQueueServerChannel r0 = p013io.netty.channel.kqueue.AbstractKQueueServerChannel.this
                r1 = r10
                boolean r0 = r0.shouldBreakReadReady(r1)
                if (r0 == 0) goto L_0x0035
                r0 = r8
                r0.clearReadFilter0()
                return
            L_0x0035:
                r0 = r8
                io.netty.channel.kqueue.AbstractKQueueServerChannel r0 = p013io.netty.channel.kqueue.AbstractKQueueServerChannel.this
                io.netty.channel.ChannelPipeline r0 = r0.pipeline()
                r11 = r0
                r0 = r9
                r1 = r10
                r0.reset(r1)
                r0 = r9
                r1 = 1
                r0.attemptedBytesRead(r1)
                r0 = r8
                r0.readReadyBefore()
                r0 = 0
                r12 = r0
            L_0x004e:
                r0 = r8
                io.netty.channel.kqueue.AbstractKQueueServerChannel r0 = p013io.netty.channel.kqueue.AbstractKQueueServerChannel.this     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                io.netty.channel.kqueue.BsdSocket r0 = r0.socket     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r1 = r8
                byte[] r1 = r1.acceptedAddress     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                int r0 = r0.accept(r1)     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r13 = r0
                r0 = r13
                r1 = -1
                if (r0 != r1) goto L_0x006c
                r0 = r9
                r1 = -1
                r0.lastBytesRead(r1)     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                goto L_0x009d
            L_0x006c:
                r0 = r9
                r1 = 1
                r0.lastBytesRead(r1)     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r0 = r9
                r1 = 1
                r0.incMessagesRead(r1)     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r0 = r8
                r1 = 0
                r0.readPending = r1     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r0 = r11
                r1 = r8
                io.netty.channel.kqueue.AbstractKQueueServerChannel r1 = p013io.netty.channel.kqueue.AbstractKQueueServerChannel.this     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r2 = r13
                r3 = r8
                byte[] r3 = r3.acceptedAddress     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r4 = 1
                r5 = r8
                byte[] r5 = r5.acceptedAddress     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r6 = 0
                r5 = r5[r6]     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                io.netty.channel.Channel r1 = r1.newChildChannel(r2, r3, r4, r5)     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                io.netty.channel.ChannelPipeline r0 = r0.fireChannelRead(r1)     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                r0 = r9
                boolean r0 = r0.continueReading()     // Catch: Throwable -> 0x00a0, all -> 0x00c7
                if (r0 != 0) goto L_0x004e
            L_0x009d:
                goto L_0x00a6
            L_0x00a0:
                r13 = move-exception
                r0 = r13
                r12 = r0
            L_0x00a6:
                r0 = r9
                r0.readComplete()     // Catch: all -> 0x00c7
                r0 = r11
                io.netty.channel.ChannelPipeline r0 = r0.fireChannelReadComplete()     // Catch: all -> 0x00c7
                r0 = r12
                if (r0 == 0) goto L_0x00bf
                r0 = r11
                r1 = r12
                io.netty.channel.ChannelPipeline r0 = r0.fireExceptionCaught(r1)     // Catch: all -> 0x00c7
            L_0x00bf:
                r0 = r8
                r1 = r10
                r0.readReadyFinally(r1)
                goto L_0x00d1
            L_0x00c7:
                r14 = move-exception
                r0 = r8
                r1 = r10
                r0.readReadyFinally(r1)
                r0 = r14
                throw r0
            L_0x00d1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.kqueue.AbstractKQueueServerChannel.KQueueServerSocketUnsafe.readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle):void");
        }
    }
}
