package p013io.netty.channel.socket;

import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.DefaultChannelConfig;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.ServerChannelRecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.util.NetUtil;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.socket.DefaultServerSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/DefaultServerSocketChannelConfig.class */
public class DefaultServerSocketChannelConfig extends DefaultChannelConfig implements ServerSocketChannelConfig {
    protected final ServerSocket javaSocket;
    private volatile int backlog = NetUtil.SOMAXCONN;

    public DefaultServerSocketChannelConfig(ServerSocketChannel channel, ServerSocket javaSocket) {
        super(channel, new ServerChannelRecvByteBufAllocator());
        this.javaSocket = (ServerSocket) ObjectUtil.checkNotNull(javaSocket, "javaSocket");
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_BACKLOG);
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == ChannelOption.SO_RCVBUF) {
            return (T) Integer.valueOf(getReceiveBufferSize());
        }
        if (option == ChannelOption.SO_REUSEADDR) {
            return (T) Boolean.valueOf(isReuseAddress());
        }
        if (option == ChannelOption.SO_BACKLOG) {
            return (T) Integer.valueOf(getBacklog());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) value).booleanValue());
            return true;
        } else if (option != ChannelOption.SO_BACKLOG) {
            return setOption(option, value);
        } else {
            setBacklog(((Integer) value).intValue());
            return true;
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setReuseAddress(boolean reuseAddress) {
        try {
            this.javaSocket.setReuseAddress(reuseAddress);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        try {
            this.javaSocket.setReceiveBufferSize(receiveBufferSize);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        this.javaSocket.setPerformancePreferences(connectionTime, latency, bandwidth);
        return this;
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public int getBacklog() {
        return this.backlog;
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setBacklog(int backlog) {
        ObjectUtil.checkPositiveOrZero(backlog, "backlog");
        this.backlog = backlog;
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public ServerSocketChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }
}
