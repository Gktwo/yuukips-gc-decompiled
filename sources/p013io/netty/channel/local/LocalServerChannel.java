package p013io.netty.channel.local;

import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Queue;
import p013io.netty.channel.AbstractServerChannel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.DefaultChannelConfig;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.PreferHeapByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.ServerChannelRecvByteBufAllocator;
import p013io.netty.channel.SingleThreadEventLoop;
import p013io.netty.util.concurrent.SingleThreadEventExecutor;

/* renamed from: io.netty.channel.local.LocalServerChannel */
/* loaded from: grasscutter.jar:io/netty/channel/local/LocalServerChannel.class */
public class LocalServerChannel extends AbstractServerChannel {
    private final ChannelConfig config = new DefaultChannelConfig(this, new ServerChannelRecvByteBufAllocator()) { // from class: io.netty.channel.local.LocalServerChannel.1
    };
    private final Queue<Object> inboundBuffer = new ArrayDeque();
    private final Runnable shutdownHook = new Runnable() { // from class: io.netty.channel.local.LocalServerChannel.2
        @Override // java.lang.Runnable
        public void run() {
            LocalServerChannel.this.unsafe().close(LocalServerChannel.this.unsafe().voidPromise());
        }
    };
    private volatile int state;
    private volatile LocalAddress localAddress;
    private volatile boolean acceptInProgress;

    public LocalServerChannel() {
        config().setAllocator(new PreferHeapByteBufAllocator(this.config.getAllocator()));
    }

    @Override // p013io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public LocalAddress localAddress() {
        return (LocalAddress) localAddress();
    }

    @Override // p013io.netty.channel.AbstractServerChannel, p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public LocalAddress remoteAddress() {
        return (LocalAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return this.state < 2;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        return this.state == 1;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop loop) {
        return loop instanceof SingleThreadEventLoop;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.localAddress;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).addShutdownHook(this.shutdownHook);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, localAddress);
        this.state = 1;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        if (this.state <= 1) {
            if (this.localAddress != null) {
                LocalChannelRegistry.unregister(this.localAddress);
                this.localAddress = null;
            }
            this.state = 2;
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).removeShutdownHook(this.shutdownHook);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
        if (!this.acceptInProgress) {
            if (this.inboundBuffer.isEmpty()) {
                this.acceptInProgress = true;
            } else {
                readInbound();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public LocalChannel serve(LocalChannel peer) {
        final LocalChannel child = newLocalChannel(peer);
        if (eventLoop().inEventLoop()) {
            serve0(child);
        } else {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.local.LocalServerChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    LocalServerChannel.this.serve0(child);
                }
            });
        }
        return child;
    }

    private void readInbound() {
        RecvByteBufAllocator.Handle handle = unsafe().recvBufAllocHandle();
        handle.reset(config());
        ChannelPipeline pipeline = pipeline();
        do {
            Object m = this.inboundBuffer.poll();
            if (m == null) {
                break;
            }
            pipeline.fireChannelRead(m);
        } while (handle.continueReading());
        pipeline.fireChannelReadComplete();
    }

    protected LocalChannel newLocalChannel(LocalChannel peer) {
        return new LocalChannel(this, peer);
    }

    /* access modifiers changed from: private */
    public void serve0(LocalChannel child) {
        this.inboundBuffer.add(child);
        if (this.acceptInProgress) {
            this.acceptInProgress = false;
            readInbound();
        }
    }
}
