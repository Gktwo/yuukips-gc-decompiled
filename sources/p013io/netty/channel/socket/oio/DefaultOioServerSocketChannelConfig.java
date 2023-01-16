package p013io.netty.channel.socket.oio;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.PreferHeapByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.DefaultServerSocketChannelConfig;
import p013io.netty.channel.socket.ServerSocketChannel;

@Deprecated
/* renamed from: io.netty.channel.socket.oio.DefaultOioServerSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/DefaultOioServerSocketChannelConfig.class */
public class DefaultOioServerSocketChannelConfig extends DefaultServerSocketChannelConfig implements OioServerSocketChannelConfig {
    @Deprecated
    public DefaultOioServerSocketChannelConfig(ServerSocketChannel channel, ServerSocket javaSocket) {
        super(channel, javaSocket);
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    /* access modifiers changed from: package-private */
    public DefaultOioServerSocketChannelConfig(OioServerSocketChannel channel, ServerSocket javaSocket) {
        super(channel, javaSocket);
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_TIMEOUT);
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == ChannelOption.SO_TIMEOUT) {
            return (T) Integer.valueOf(getSoTimeout());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option != ChannelOption.SO_TIMEOUT) {
            return setOption(option, value);
        }
        setSoTimeout(((Integer) value).intValue());
        return true;
    }

    @Override // p013io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setSoTimeout(int timeout) {
        try {
            this.javaSocket.setSoTimeout(timeout);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public int getSoTimeout() {
        try {
            return this.javaSocket.getSoTimeout();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public OioServerSocketChannelConfig setBacklog(int backlog) {
        setBacklog(backlog);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public OioServerSocketChannelConfig setReuseAddress(boolean reuseAddress) {
        setReuseAddress(reuseAddress);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public OioServerSocketChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        setReceiveBufferSize(receiveBufferSize);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public OioServerSocketChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        setPerformancePreferences(connectionTime, latency, bandwidth);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public OioServerSocketChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig
    protected void autoReadCleared() {
        if (this.channel instanceof OioServerSocketChannel) {
            ((OioServerSocketChannel) this.channel).clearReadPending0();
        }
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setAutoClose(boolean autoClose) {
        setAutoClose(autoClose);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultServerSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }
}
