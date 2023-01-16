package p013io.netty.bootstrap;

import java.net.SocketAddress;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultChannelConfig;
import p013io.netty.channel.EventLoop;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.bootstrap.FailedChannel */
/* loaded from: grasscutter.jar:io/netty/bootstrap/FailedChannel.class */
public final class FailedChannel extends AbstractChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private final ChannelConfig config = new DefaultChannelConfig(this);

    /* access modifiers changed from: package-private */
    public FailedChannel() {
        super(null);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new FailedChannelUnsafe();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return false;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return null;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBeginRead() {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return false;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        return false;
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* renamed from: io.netty.bootstrap.FailedChannel$FailedChannelUnsafe */
    /* loaded from: grasscutter.jar:io/netty/bootstrap/FailedChannel$FailedChannelUnsafe.class */
    private final class FailedChannelUnsafe extends AbstractChannel.AbstractUnsafe {
        private FailedChannelUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            promise.setFailure((Throwable) new UnsupportedOperationException());
        }
    }
}
