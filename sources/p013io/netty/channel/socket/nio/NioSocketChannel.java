package p013io.netty.channel.socket.nio;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.SelectorProvider;
import java.util.Map;
import java.util.concurrent.Executor;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.FileRegion;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.nio.AbstractNioByteChannel;
import p013io.netty.channel.nio.AbstractNioChannel;
import p013io.netty.channel.socket.DefaultSocketChannelConfig;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.channel.socket.SocketChannel;
import p013io.netty.channel.socket.SocketChannelConfig;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.concurrent.GlobalEventExecutor;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SocketUtils;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.socket.nio.NioSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/nio/NioSocketChannel.class */
public class NioSocketChannel extends AbstractNioByteChannel implements SocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioSocketChannel.class);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private static final Method OPEN_SOCKET_CHANNEL_WITH_FAMILY = SelectorProviderUtil.findOpenMethod("openSocketChannel");
    private final SocketChannelConfig config;

    private static java.nio.channels.SocketChannel newChannel(SelectorProvider provider, InternetProtocolFamily family) {
        try {
            java.nio.channels.SocketChannel channel = (java.nio.channels.SocketChannel) SelectorProviderUtil.newChannel(OPEN_SOCKET_CHANNEL_WITH_FAMILY, provider, family);
            return channel == null ? provider.openSocketChannel() : channel;
        } catch (IOException e) {
            throw new ChannelException("Failed to open a socket.", e);
        }
    }

    public NioSocketChannel() {
        this(DEFAULT_SELECTOR_PROVIDER);
    }

    public NioSocketChannel(SelectorProvider provider) {
        this(provider, (InternetProtocolFamily) null);
    }

    public NioSocketChannel(SelectorProvider provider, InternetProtocolFamily family) {
        this(newChannel(provider, family));
    }

    public NioSocketChannel(java.nio.channels.SocketChannel socket) {
        this((Channel) null, socket);
    }

    public NioSocketChannel(Channel parent, java.nio.channels.SocketChannel socket) {
        super(parent, socket);
        this.config = new NioSocketChannelConfig(this, socket.socket());
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) parent();
    }

    @Override // p013io.netty.channel.Channel
    public SocketChannelConfig config() {
        return this.config;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.nio.AbstractNioChannel
    public java.nio.channels.SocketChannel javaChannel() {
        return (java.nio.channels.SocketChannel) javaChannel();
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.SocketChannel ch = javaChannel();
        return ch.isOpen() && ch.isConnected();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return javaChannel().socket().isOutputShutdown() || !isActive();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return javaChannel().socket().isInputShutdown() || !isActive();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        Socket socket = javaChannel().socket();
        return (socket.isInputShutdown() && socket.isOutputShutdown()) || !isActive();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) localAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    protected final void doShutdownOutput() throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            javaChannel().shutdownOutput();
        } else {
            javaChannel().socket().shutdownOutput();
        }
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise promise) {
        EventLoop loop = eventLoop();
        if (loop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(promise);
        } else {
            loop.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    ((AbstractChannel.AbstractUnsafe) NioSocketChannel.this.unsafe()).shutdownOutput(promise);
                }
            });
        }
        return promise;
    }

    @Override // p013io.netty.channel.nio.AbstractNioByteChannel, p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // p013io.netty.channel.nio.AbstractNioByteChannel
    protected boolean isInputShutdown0() {
        return isInputShutdown();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise promise) {
        EventLoop loop = eventLoop();
        if (loop.inEventLoop()) {
            shutdownInput0(promise);
        } else {
            loop.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    NioSocketChannel.this.shutdownInput0(promise);
                }
            });
        }
        return promise;
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise promise) {
        ChannelFuture shutdownOutputFuture = shutdownOutput();
        if (shutdownOutputFuture.isDone()) {
            shutdownOutputDone(shutdownOutputFuture, promise);
        } else {
            shutdownOutputFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.socket.nio.NioSocketChannel.3
                public void operationComplete(ChannelFuture shutdownOutputFuture2) throws Exception {
                    NioSocketChannel.this.shutdownOutputDone(shutdownOutputFuture2, promise);
                }
            });
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture shutdownOutputFuture, final ChannelPromise promise) {
        ChannelFuture shutdownInputFuture = shutdownInput();
        if (shutdownInputFuture.isDone()) {
            shutdownDone(shutdownOutputFuture, shutdownInputFuture, promise);
        } else {
            shutdownInputFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.socket.nio.NioSocketChannel.4
                public void operationComplete(ChannelFuture shutdownInputFuture2) throws Exception {
                    NioSocketChannel.shutdownDone(shutdownOutputFuture, shutdownInputFuture2, promise);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture shutdownOutputFuture, ChannelFuture shutdownInputFuture, ChannelPromise promise) {
        Throwable shutdownOutputCause = shutdownOutputFuture.cause();
        Throwable shutdownInputCause = shutdownInputFuture.cause();
        if (shutdownOutputCause != null) {
            if (shutdownInputCause != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", shutdownInputCause);
            }
            promise.setFailure(shutdownOutputCause);
        } else if (shutdownInputCause != null) {
            promise.setFailure(shutdownInputCause);
        } else {
            promise.setSuccess();
        }
    }

    /* access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise promise) {
        try {
            shutdownInput0();
            promise.setSuccess();
        } catch (Throwable t) {
            promise.setFailure(t);
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    private void shutdownInput0() throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            javaChannel().shutdownInput();
        } else {
            javaChannel().socket().shutdownInput();
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return javaChannel().socket().getLocalSocketAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return javaChannel().socket().getRemoteSocketAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        doBind0(localAddress);
    }

    private void doBind0(SocketAddress localAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            SocketUtils.bind(javaChannel(), localAddress);
        } else {
            SocketUtils.bind(javaChannel().socket(), localAddress);
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (localAddress != null) {
            doBind0(localAddress);
        }
        boolean success = false;
        try {
            boolean connected = SocketUtils.connect(javaChannel(), remoteAddress);
            if (!connected) {
                selectionKey().interestOps(8);
            }
            success = true;
            return connected;
        } finally {
            if (!success) {
                doClose();
            }
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        if (!javaChannel().finishConnect()) {
            throw new Error();
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel, p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        doClose();
        javaChannel().close();
    }

    @Override // p013io.netty.channel.nio.AbstractNioByteChannel
    protected int doReadBytes(ByteBuf byteBuf) throws Exception {
        RecvByteBufAllocator.Handle allocHandle = unsafe().recvBufAllocHandle();
        allocHandle.attemptedBytesRead(byteBuf.writableBytes());
        return byteBuf.writeBytes(javaChannel(), allocHandle.attemptedBytesRead());
    }

    @Override // p013io.netty.channel.nio.AbstractNioByteChannel
    protected int doWriteBytes(ByteBuf buf) throws Exception {
        return buf.readBytes(javaChannel(), buf.readableBytes());
    }

    @Override // p013io.netty.channel.nio.AbstractNioByteChannel
    protected long doWriteFileRegion(FileRegion region) throws Exception {
        return region.transferTo(javaChannel(), region.transferred());
    }

    private void adjustMaxBytesPerGatheringWrite(int attempted, int written, int oldMaxBytesPerGatheringWrite) {
        if (attempted == written) {
            if ((attempted << 1) > oldMaxBytesPerGatheringWrite) {
                ((NioSocketChannelConfig) this.config).setMaxBytesPerGatheringWrite(attempted << 1);
            }
        } else if (attempted > 4096 && written < (attempted >>> 1)) {
            ((NioSocketChannelConfig) this.config).setMaxBytesPerGatheringWrite(attempted >>> 1);
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioByteChannel, p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        java.nio.channels.SocketChannel ch = javaChannel();
        int writeSpinCount = config().getWriteSpinCount();
        while (!in.isEmpty()) {
            int maxBytesPerGatheringWrite = ((NioSocketChannelConfig) this.config).getMaxBytesPerGatheringWrite();
            ByteBuffer[] nioBuffers = in.nioBuffers(1024, (long) maxBytesPerGatheringWrite);
            int nioBufferCnt = in.nioBufferCount();
            switch (nioBufferCnt) {
                case 0:
                    writeSpinCount -= doWrite0(in);
                    break;
                case 1:
                    ByteBuffer buffer = nioBuffers[0];
                    int attemptedBytes = buffer.remaining();
                    int localWrittenBytes = ch.write(buffer);
                    if (localWrittenBytes > 0) {
                        adjustMaxBytesPerGatheringWrite(attemptedBytes, localWrittenBytes, maxBytesPerGatheringWrite);
                        in.removeBytes((long) localWrittenBytes);
                        writeSpinCount--;
                        break;
                    } else {
                        incompleteWrite(true);
                        return;
                    }
                default:
                    long attemptedBytes2 = in.nioBufferSize();
                    long localWrittenBytes2 = ch.write(nioBuffers, 0, nioBufferCnt);
                    if (localWrittenBytes2 > 0) {
                        adjustMaxBytesPerGatheringWrite((int) attemptedBytes2, (int) localWrittenBytes2, maxBytesPerGatheringWrite);
                        in.removeBytes(localWrittenBytes2);
                        writeSpinCount--;
                        break;
                    } else {
                        incompleteWrite(true);
                        return;
                    }
            }
            if (writeSpinCount <= 0) {
                incompleteWrite(writeSpinCount < 0);
                return;
            }
        }
        clearOpWrite();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.nio.AbstractNioByteChannel, p013io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioSocketChannelUnsafe();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.socket.nio.NioSocketChannel$NioSocketChannelUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/socket/nio/NioSocketChannel$NioSocketChannelUnsafe.class */
    public final class NioSocketChannelUnsafe extends AbstractNioByteChannel.NioByteUnsafe {
        private NioSocketChannelUnsafe() {
            super();
        }

        @Override // p013io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            try {
                if (!NioSocketChannel.this.javaChannel().isOpen() || NioSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                NioSocketChannel.this.doDeregister();
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable th) {
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.socket.nio.NioSocketChannel$NioSocketChannelConfig */
    /* loaded from: grasscutter.jar:io/netty/channel/socket/nio/NioSocketChannel$NioSocketChannelConfig.class */
    public final class NioSocketChannelConfig extends DefaultSocketChannelConfig {
        private volatile int maxBytesPerGatheringWrite;

        private NioSocketChannelConfig(NioSocketChannel channel, Socket javaSocket) {
            super(channel, javaSocket);
            this.maxBytesPerGatheringWrite = Integer.MAX_VALUE;
            calculateMaxBytesPerGatheringWrite();
        }

        @Override // p013io.netty.channel.DefaultChannelConfig
        protected void autoReadCleared() {
            NioSocketChannel.this.clearReadPending();
        }

        @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
        public NioSocketChannelConfig setSendBufferSize(int sendBufferSize) {
            setSendBufferSize(sendBufferSize);
            calculateMaxBytesPerGatheringWrite();
            return this;
        }

        @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
        public <T> boolean setOption(ChannelOption<T> option, T value) {
            if (PlatformDependent.javaVersion() < 7 || !(option instanceof NioChannelOption)) {
                return setOption(option, value);
            }
            return NioChannelOption.setOption(jdkChannel(), (NioChannelOption) option, value);
        }

        @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
        public <T> T getOption(ChannelOption<T> option) {
            if (PlatformDependent.javaVersion() < 7 || !(option instanceof NioChannelOption)) {
                return (T) getOption(option);
            }
            return (T) NioChannelOption.getOption(jdkChannel(), (NioChannelOption) option);
        }

        @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
        public Map<ChannelOption<?>, Object> getOptions() {
            if (PlatformDependent.javaVersion() >= 7) {
                return getOptions(getOptions(), NioChannelOption.getOptions(jdkChannel()));
            }
            return getOptions();
        }

        void setMaxBytesPerGatheringWrite(int maxBytesPerGatheringWrite) {
            this.maxBytesPerGatheringWrite = maxBytesPerGatheringWrite;
        }

        int getMaxBytesPerGatheringWrite() {
            return this.maxBytesPerGatheringWrite;
        }

        private void calculateMaxBytesPerGatheringWrite() {
            int newSendBufferSize = getSendBufferSize() << 1;
            if (newSendBufferSize > 0) {
                setMaxBytesPerGatheringWrite(newSendBufferSize);
            }
        }

        private java.nio.channels.SocketChannel jdkChannel() {
            return ((NioSocketChannel) this.channel).javaChannel();
        }
    }
}
