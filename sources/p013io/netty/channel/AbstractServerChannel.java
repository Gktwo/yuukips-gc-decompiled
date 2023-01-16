package p013io.netty.channel;

import java.net.SocketAddress;
import p013io.netty.channel.AbstractChannel;

/* renamed from: io.netty.channel.AbstractServerChannel */
/* loaded from: grasscutter.jar:io/netty/channel/AbstractServerChannel.class */
public abstract class AbstractServerChannel extends AbstractChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    /* access modifiers changed from: protected */
    public AbstractServerChannel() {
        super(null);
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        return null;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new DefaultServerUnsafe();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object msg) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: io.netty.channel.AbstractServerChannel$DefaultServerUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/AbstractServerChannel$DefaultServerUnsafe.class */
    private final class DefaultServerUnsafe extends AbstractChannel.AbstractUnsafe {
        private DefaultServerUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            safeSetFailure(promise, new UnsupportedOperationException());
        }
    }
}
