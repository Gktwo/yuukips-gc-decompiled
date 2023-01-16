package p013io.netty.channel.epoll;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.ServerChannel;
import p013io.netty.channel.epoll.AbstractEpollChannel;

/* renamed from: io.netty.channel.epoll.AbstractEpollServerChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollServerChannel.class */
public abstract class AbstractEpollServerChannel extends AbstractEpollChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    abstract Channel newChildChannel(int i, byte[] bArr, int i2, int i3) throws Exception;

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return isOpen();
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return isActive();
    }

    /* access modifiers changed from: protected */
    public AbstractEpollServerChannel(int fd) {
        this(new LinuxSocket(fd), false);
    }

    /* access modifiers changed from: package-private */
    public AbstractEpollServerChannel(LinuxSocket fd) {
        this(fd, isSoErrorZero(fd));
    }

    /* access modifiers changed from: package-private */
    public AbstractEpollServerChannel(LinuxSocket fd, boolean active) {
        super((Channel) null, fd, active);
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof EpollEventLoop;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public InetSocketAddress remoteAddress0() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollServerSocketUnsafe();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object msg) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.epoll.AbstractEpollServerChannel$EpollServerSocketUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/AbstractEpollServerChannel$EpollServerSocketUnsafe.class */
    public final class EpollServerSocketUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        private final byte[] acceptedAddress = new byte[26];
        static final /* synthetic */ boolean $assertionsDisabled;

        EpollServerSocketUnsafe() {
            super();
        }

        static {
            $assertionsDisabled = !AbstractEpollServerChannel.class.desiredAssertionStatus();
        }

        @Override // p013io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe, p013io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:19:0x00af
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // p013io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        void epollInReady() {
            /*
            // Method dump skipped, instructions count: 225
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.epoll.AbstractEpollServerChannel.EpollServerSocketUnsafe.epollInReady():void");
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel
    public boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        throw new UnsupportedOperationException();
    }
}
