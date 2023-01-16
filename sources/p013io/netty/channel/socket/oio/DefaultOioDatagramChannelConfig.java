package p013io.netty.channel.socket.oio;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.PreferHeapByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.DatagramChannel;
import p013io.netty.channel.socket.DefaultDatagramChannelConfig;

/* renamed from: io.netty.channel.socket.oio.DefaultOioDatagramChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/DefaultOioDatagramChannelConfig.class */
final class DefaultOioDatagramChannelConfig extends DefaultDatagramChannelConfig implements OioDatagramChannelConfig {
    /* access modifiers changed from: package-private */
    public DefaultOioDatagramChannelConfig(DatagramChannel channel, DatagramSocket javaSocket) {
        super(channel, javaSocket);
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_TIMEOUT);
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == ChannelOption.SO_TIMEOUT) {
            return (T) Integer.valueOf(getSoTimeout());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option != ChannelOption.SO_TIMEOUT) {
            return setOption(option, value);
        }
        setSoTimeout(((Integer) value).intValue());
        return true;
    }

    @Override // p013io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setSoTimeout(int timeout) {
        try {
            javaSocket().setSoTimeout(timeout);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.oio.OioDatagramChannelConfig
    public int getSoTimeout() {
        try {
            return javaSocket().getSoTimeout();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setBroadcast(boolean broadcast) {
        setBroadcast(broadcast);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setInterface(InetAddress interfaceAddress) {
        setInterface(interfaceAddress);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setLoopbackModeDisabled(boolean loopbackModeDisabled) {
        setLoopbackModeDisabled(loopbackModeDisabled);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface) {
        setNetworkInterface(networkInterface);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setReuseAddress(boolean reuseAddress) {
        setReuseAddress(reuseAddress);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        setReceiveBufferSize(receiveBufferSize);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setSendBufferSize(int sendBufferSize) {
        setSendBufferSize(sendBufferSize);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setTimeToLive(int ttl) {
        setTimeToLive(ttl);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.socket.DatagramChannelConfig
    public OioDatagramChannelConfig setTrafficClass(int trafficClass) {
        setTrafficClass(trafficClass);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setAutoClose(boolean autoClose) {
        setAutoClose(autoClose);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.socket.DefaultDatagramChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public OioDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }
}
