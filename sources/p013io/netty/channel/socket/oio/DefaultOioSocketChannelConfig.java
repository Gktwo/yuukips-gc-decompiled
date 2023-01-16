package p013io.netty.channel.socket.oio;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.PreferHeapByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.DefaultSocketChannelConfig;
import p013io.netty.channel.socket.SocketChannel;

@Deprecated
/* renamed from: io.netty.channel.socket.oio.DefaultOioSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/DefaultOioSocketChannelConfig.class */
public class DefaultOioSocketChannelConfig extends DefaultSocketChannelConfig implements OioSocketChannelConfig {
    @Deprecated
    public DefaultOioSocketChannelConfig(SocketChannel channel, Socket javaSocket) {
        super(channel, javaSocket);
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    /* access modifiers changed from: package-private */
    public DefaultOioSocketChannelConfig(OioSocketChannel channel, Socket javaSocket) {
        super(channel, javaSocket);
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_TIMEOUT);
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == ChannelOption.SO_TIMEOUT) {
            return (T) Integer.valueOf(getSoTimeout());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option != ChannelOption.SO_TIMEOUT) {
            return setOption(option, value);
        }
        setSoTimeout(((Integer) value).intValue());
        return true;
    }

    @Override // p013io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setSoTimeout(int timeout) {
        try {
            this.javaSocket.setSoTimeout(timeout);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.oio.OioSocketChannelConfig
    public int getSoTimeout() {
        try {
            return this.javaSocket.getSoTimeout();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setTcpNoDelay(boolean tcpNoDelay) {
        setTcpNoDelay(tcpNoDelay);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setSoLinger(int soLinger) {
        setSoLinger(soLinger);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setSendBufferSize(int sendBufferSize) {
        setSendBufferSize(sendBufferSize);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        setReceiveBufferSize(receiveBufferSize);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setKeepAlive(boolean keepAlive) {
        setKeepAlive(keepAlive);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setTrafficClass(int trafficClass) {
        setTrafficClass(trafficClass);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setReuseAddress(boolean reuseAddress) {
        setReuseAddress(reuseAddress);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig
    public OioSocketChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        setPerformancePreferences(connectionTime, latency, bandwidth);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig
    public OioSocketChannelConfig setAllowHalfClosure(boolean allowHalfClosure) {
        setAllowHalfClosure(allowHalfClosure);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public OioSocketChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig
    protected void autoReadCleared() {
        if (this.channel instanceof OioSocketChannel) {
            ((OioSocketChannel) this.channel).clearReadPending0();
        }
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setAutoClose(boolean autoClose) {
        setAutoClose(autoClose);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultSocketChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }
}
