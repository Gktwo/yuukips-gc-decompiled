package p013io.netty.channel.oio;

import java.net.SocketAddress;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.ThreadPerChannelEventLoop;

@Deprecated
/* renamed from: io.netty.channel.oio.AbstractOioChannel */
/* loaded from: grasscutter.jar:io/netty/channel/oio/AbstractOioChannel.class */
public abstract class AbstractOioChannel extends AbstractChannel {
    protected static final int SO_TIMEOUT = 1000;
    boolean readPending;
    boolean readWhenInactive;
    final Runnable readTask = new Runnable() { // from class: io.netty.channel.oio.AbstractOioChannel.1
        @Override // java.lang.Runnable
        public void run() {
            AbstractOioChannel.this.doRead();
        }
    };
    private final Runnable clearReadPendingRunnable = new Runnable() { // from class: io.netty.channel.oio.AbstractOioChannel.2
        @Override // java.lang.Runnable
        public void run() {
            AbstractOioChannel.this.readPending = false;
        }
    };

    protected abstract void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception;

    protected abstract void doRead();

    /* access modifiers changed from: protected */
    public AbstractOioChannel(Channel parent) {
        super(parent);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new DefaultOioUnsafe();
    }

    /* renamed from: io.netty.channel.oio.AbstractOioChannel$DefaultOioUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/oio/AbstractOioChannel$DefaultOioUnsafe.class */
    private final class DefaultOioUnsafe extends AbstractChannel.AbstractUnsafe {
        private DefaultOioUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            if (promise.setUncancellable() && ensureOpen(promise)) {
                try {
                    boolean wasActive = AbstractOioChannel.this.isActive();
                    AbstractOioChannel.this.doConnect(remoteAddress, localAddress);
                    boolean active = AbstractOioChannel.this.isActive();
                    safeSetSuccess(promise);
                    if (!wasActive && active) {
                        AbstractOioChannel.this.pipeline().fireChannelActive();
                    }
                } catch (Throwable t) {
                    safeSetFailure(promise, annotateConnectException(t, remoteAddress));
                    closeIfClosed();
                }
            }
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof ThreadPerChannelEventLoop;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
        if (!this.readPending) {
            if (!isActive()) {
                this.readWhenInactive = true;
                return;
            }
            this.readPending = true;
            eventLoop().execute(this.readTask);
        }
    }

    @Deprecated
    protected boolean isReadPending() {
        return this.readPending;
    }

    @Deprecated
    protected void setReadPending(final boolean readPending) {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                this.readPending = readPending;
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.oio.AbstractOioChannel.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractOioChannel.this.readPending = readPending;
                    }
                });
            }
        } else {
            this.readPending = readPending;
        }
    }

    protected final void clearReadPending() {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                this.readPending = false;
            } else {
                eventLoop.execute(this.clearReadPendingRunnable);
            }
        } else {
            this.readPending = false;
        }
    }
}
