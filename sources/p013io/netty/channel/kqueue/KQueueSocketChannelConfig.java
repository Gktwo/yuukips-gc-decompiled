package p013io.netty.channel.kqueue;

import java.io.IOException;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.SocketChannelConfig;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.channel.kqueue.KQueueSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueSocketChannelConfig.class */
public final class KQueueSocketChannelConfig extends KQueueChannelConfig implements SocketChannelConfig {
    private volatile boolean allowHalfClosure;
    private volatile boolean tcpFastopen;

    /* access modifiers changed from: package-private */
    public KQueueSocketChannelConfig(KQueueSocketChannel channel) {
        super(channel);
        if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
            setTcpNoDelay(true);
        }
        calculateMaxBytesPerGatheringWrite();
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE, KQueueChannelOption.SO_SNDLOWAT, KQueueChannelOption.TCP_NOPUSH);
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == ChannelOption.SO_RCVBUF) {
            return (T) Integer.valueOf(getReceiveBufferSize());
        }
        if (option == ChannelOption.SO_SNDBUF) {
            return (T) Integer.valueOf(getSendBufferSize());
        }
        if (option == ChannelOption.TCP_NODELAY) {
            return (T) Boolean.valueOf(isTcpNoDelay());
        }
        if (option == ChannelOption.SO_KEEPALIVE) {
            return (T) Boolean.valueOf(isKeepAlive());
        }
        if (option == ChannelOption.SO_REUSEADDR) {
            return (T) Boolean.valueOf(isReuseAddress());
        }
        if (option == ChannelOption.SO_LINGER) {
            return (T) Integer.valueOf(getSoLinger());
        }
        if (option == ChannelOption.IP_TOS) {
            return (T) Integer.valueOf(getTrafficClass());
        }
        if (option == ChannelOption.ALLOW_HALF_CLOSURE) {
            return (T) Boolean.valueOf(isAllowHalfClosure());
        }
        if (option == KQueueChannelOption.SO_SNDLOWAT) {
            return (T) Integer.valueOf(getSndLowAt());
        }
        if (option == KQueueChannelOption.TCP_NOPUSH) {
            return (T) Boolean.valueOf(isTcpNoPush());
        }
        if (option == ChannelOption.TCP_FASTOPEN_CONNECT) {
            return (T) Boolean.valueOf(isTcpFastOpenConnect());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.TCP_NODELAY) {
            setTcpNoDelay(((Boolean) value).booleanValue());
            return true;
        } else if (option == ChannelOption.SO_KEEPALIVE) {
            setKeepAlive(((Boolean) value).booleanValue());
            return true;
        } else if (option == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) value).booleanValue());
            return true;
        } else if (option == ChannelOption.SO_LINGER) {
            setSoLinger(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.IP_TOS) {
            setTrafficClass(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.ALLOW_HALF_CLOSURE) {
            setAllowHalfClosure(((Boolean) value).booleanValue());
            return true;
        } else if (option == KQueueChannelOption.SO_SNDLOWAT) {
            setSndLowAt(((Integer) value).intValue());
            return true;
        } else if (option == KQueueChannelOption.TCP_NOPUSH) {
            setTcpNoPush(((Boolean) value).booleanValue());
            return true;
        } else if (option != ChannelOption.TCP_FASTOPEN_CONNECT) {
            return setOption(option, value);
        } else {
            setTcpFastOpenConnect(((Boolean) value).booleanValue());
            return true;
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public int getSendBufferSize() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getSoLinger();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public int getTrafficClass() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getTrafficClass();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public boolean isKeepAlive() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.isKeepAlive();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public boolean isTcpNoDelay() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.isTcpNoDelay();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getSndLowAt() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getSndLowAt();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public void setSndLowAt(int sndLowAt) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setSndLowAt(sndLowAt);
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isTcpNoPush() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.isTcpNoPush();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public void setTcpNoPush(boolean tcpNoPush) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setTcpNoPush(tcpNoPush);
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setKeepAlive(boolean keepAlive) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setKeepAlive(keepAlive);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setReceiveBufferSize(receiveBufferSize);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setReuseAddress(boolean reuseAddress) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setReuseAddress(reuseAddress);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setSendBufferSize(int sendBufferSize) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setSendBufferSize(sendBufferSize);
            calculateMaxBytesPerGatheringWrite();
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setSoLinger(int soLinger) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setSoLinger(soLinger);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setTcpNoDelay(boolean tcpNoDelay) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setTcpNoDelay(tcpNoDelay);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setTrafficClass(int trafficClass) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setTrafficClass(trafficClass);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DuplexChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    public KQueueSocketChannelConfig setTcpFastOpenConnect(boolean fastOpenConnect) {
        this.tcpFastopen = fastOpenConnect;
        return this;
    }

    public boolean isTcpFastOpenConnect() {
        return this.tcpFastopen;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig
    public KQueueSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean transportProvidesGuess) {
        setRcvAllocTransportProvidesGuess(transportProvidesGuess);
        return this;
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        return this;
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig
    public KQueueSocketChannelConfig setAllowHalfClosure(boolean allowHalfClosure) {
        this.allowHalfClosure = allowHalfClosure;
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueSocketChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setAutoClose(boolean autoClose) {
        setAutoClose(autoClose);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueSocketChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueSocketChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    private void calculateMaxBytesPerGatheringWrite() {
        if ((getSendBufferSize() << 1) > 0) {
            setMaxBytesPerGatheringWrite((long) (getSendBufferSize() << 1));
        }
    }
}
