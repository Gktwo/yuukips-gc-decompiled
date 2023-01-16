package p013io.netty.channel.socket.nio;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.List;
import java.util.Map;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.nio.AbstractNioMessageChannel;
import p013io.netty.channel.socket.DefaultServerSocketChannelConfig;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.channel.socket.ServerSocketChannelConfig;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SocketUtils;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.socket.nio.NioServerSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/nio/NioServerSocketChannel.class */
public class NioServerSocketChannel extends AbstractNioMessageChannel implements ServerSocketChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioServerSocketChannel.class);
    private static final Method OPEN_SERVER_SOCKET_CHANNEL_WITH_FAMILY = SelectorProviderUtil.findOpenMethod("openServerSocketChannel");
    private final ServerSocketChannelConfig config;

    private static java.nio.channels.ServerSocketChannel newChannel(SelectorProvider provider, InternetProtocolFamily family) {
        try {
            java.nio.channels.ServerSocketChannel channel = (java.nio.channels.ServerSocketChannel) SelectorProviderUtil.newChannel(OPEN_SERVER_SOCKET_CHANNEL_WITH_FAMILY, provider, family);
            return channel == null ? provider.openServerSocketChannel() : channel;
        } catch (IOException e) {
            throw new ChannelException("Failed to open a socket.", e);
        }
    }

    public NioServerSocketChannel() {
        this(DEFAULT_SELECTOR_PROVIDER);
    }

    public NioServerSocketChannel(SelectorProvider provider) {
        this(provider, null);
    }

    public NioServerSocketChannel(SelectorProvider provider, InternetProtocolFamily family) {
        this(newChannel(provider, family));
    }

    public NioServerSocketChannel(java.nio.channels.ServerSocketChannel channel) {
        super(null, channel, 16);
        this.config = new NioServerSocketChannelConfig(this, javaChannel().socket());
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) localAddress();
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.Channel
    public ServerSocketChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        return isOpen() && javaChannel().socket().isBound();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.nio.AbstractNioChannel
    public java.nio.channels.ServerSocketChannel javaChannel() {
        return (java.nio.channels.ServerSocketChannel) javaChannel();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return SocketUtils.localSocketAddress(javaChannel().socket());
    }

    @Override // p013io.netty.channel.AbstractChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    protected void doBind(SocketAddress localAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            javaChannel().bind(localAddress, this.config.getBacklog());
        } else {
            javaChannel().socket().bind(localAddress, this.config.getBacklog());
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel, p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        javaChannel().close();
    }

    @Override // p013io.netty.channel.nio.AbstractNioMessageChannel
    protected int doReadMessages(List<Object> buf) throws Exception {
        SocketChannel ch = SocketUtils.accept(javaChannel());
        if (ch == null) {
            return 0;
        }
        try {
            buf.add(new NioSocketChannel(this, ch));
            return 1;
        } catch (Throwable t) {
            logger.warn("Failed to create a new channel from an accepted socket.", t);
            try {
                ch.close();
                return 0;
            } catch (Throwable t2) {
                logger.warn("Failed to close a socket.", t2);
                return 0;
            }
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean doWriteMessage(Object msg, ChannelOutboundBuffer in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object msg) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* renamed from: io.netty.channel.socket.nio.NioServerSocketChannel$NioServerSocketChannelConfig */
    /* loaded from: grasscutter.jar:io/netty/channel/socket/nio/NioServerSocketChannel$NioServerSocketChannelConfig.class */
    private final class NioServerSocketChannelConfig extends DefaultServerSocketChannelConfig {
        private NioServerSocketChannelConfig(NioServerSocketChannel channel, ServerSocket javaSocket) {
            super(channel, javaSocket);
        }

        @Override // p013io.netty.channel.DefaultChannelConfig
        protected void autoReadCleared() {
            NioServerSocketChannel.this.clearReadPending();
        }

        @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
        public <T> boolean setOption(ChannelOption<T> option, T value) {
            if (PlatformDependent.javaVersion() < 7 || !(option instanceof NioChannelOption)) {
                return setOption(option, value);
            }
            return NioChannelOption.setOption(jdkChannel(), (NioChannelOption) option, value);
        }

        @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
        public <T> T getOption(ChannelOption<T> option) {
            if (PlatformDependent.javaVersion() < 7 || !(option instanceof NioChannelOption)) {
                return (T) getOption(option);
            }
            return (T) NioChannelOption.getOption(jdkChannel(), (NioChannelOption) option);
        }

        @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
        public Map<ChannelOption<?>, Object> getOptions() {
            if (PlatformDependent.javaVersion() >= 7) {
                return getOptions(getOptions(), NioChannelOption.getOptions(jdkChannel()));
            }
            return getOptions();
        }

        private java.nio.channels.ServerSocketChannel jdkChannel() {
            return ((NioServerSocketChannel) this.channel).javaChannel();
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.nio.AbstractNioMessageChannel
    public boolean closeOnReadError(Throwable cause) {
        return closeOnReadError(cause);
    }
}
