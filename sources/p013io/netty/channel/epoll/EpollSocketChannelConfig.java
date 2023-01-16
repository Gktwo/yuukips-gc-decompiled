package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.SocketChannelConfig;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.channel.epoll.EpollSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollSocketChannelConfig.class */
public final class EpollSocketChannelConfig extends EpollChannelConfig implements SocketChannelConfig {
    private volatile boolean allowHalfClosure;
    private volatile boolean tcpFastopen;

    /* access modifiers changed from: package-private */
    public EpollSocketChannelConfig(EpollSocketChannel channel) {
        super(channel);
        if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
            setTcpNoDelay(true);
        }
        calculateMaxBytesPerGatheringWrite();
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE, EpollChannelOption.TCP_CORK, EpollChannelOption.TCP_NOTSENT_LOWAT, EpollChannelOption.TCP_KEEPCNT, EpollChannelOption.TCP_KEEPIDLE, EpollChannelOption.TCP_KEEPINTVL, EpollChannelOption.TCP_MD5SIG, EpollChannelOption.TCP_QUICKACK, EpollChannelOption.IP_TRANSPARENT, ChannelOption.TCP_FASTOPEN_CONNECT, EpollChannelOption.SO_BUSY_POLL);
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
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
        if (option == EpollChannelOption.TCP_CORK) {
            return (T) Boolean.valueOf(isTcpCork());
        }
        if (option == EpollChannelOption.TCP_NOTSENT_LOWAT) {
            return (T) Long.valueOf(getTcpNotSentLowAt());
        }
        if (option == EpollChannelOption.TCP_KEEPIDLE) {
            return (T) Integer.valueOf(getTcpKeepIdle());
        }
        if (option == EpollChannelOption.TCP_KEEPINTVL) {
            return (T) Integer.valueOf(getTcpKeepIntvl());
        }
        if (option == EpollChannelOption.TCP_KEEPCNT) {
            return (T) Integer.valueOf(getTcpKeepCnt());
        }
        if (option == EpollChannelOption.TCP_USER_TIMEOUT) {
            return (T) Integer.valueOf(getTcpUserTimeout());
        }
        if (option == EpollChannelOption.TCP_QUICKACK) {
            return (T) Boolean.valueOf(isTcpQuickAck());
        }
        if (option == EpollChannelOption.IP_TRANSPARENT) {
            return (T) Boolean.valueOf(isIpTransparent());
        }
        if (option == ChannelOption.TCP_FASTOPEN_CONNECT) {
            return (T) Boolean.valueOf(isTcpFastOpenConnect());
        }
        if (option == EpollChannelOption.SO_BUSY_POLL) {
            return (T) Integer.valueOf(getSoBusyPoll());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
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
        } else if (option == EpollChannelOption.TCP_CORK) {
            setTcpCork(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.TCP_NOTSENT_LOWAT) {
            setTcpNotSentLowAt(((Long) value).longValue());
            return true;
        } else if (option == EpollChannelOption.TCP_KEEPIDLE) {
            setTcpKeepIdle(((Integer) value).intValue());
            return true;
        } else if (option == EpollChannelOption.TCP_KEEPCNT) {
            setTcpKeepCnt(((Integer) value).intValue());
            return true;
        } else if (option == EpollChannelOption.TCP_KEEPINTVL) {
            setTcpKeepIntvl(((Integer) value).intValue());
            return true;
        } else if (option == EpollChannelOption.TCP_USER_TIMEOUT) {
            setTcpUserTimeout(((Integer) value).intValue());
            return true;
        } else if (option == EpollChannelOption.IP_TRANSPARENT) {
            setIpTransparent(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.TCP_MD5SIG) {
            setTcpMd5Sig((Map) value);
            return true;
        } else if (option == EpollChannelOption.TCP_QUICKACK) {
            setTcpQuickAck(((Boolean) value).booleanValue());
            return true;
        } else if (option == ChannelOption.TCP_FASTOPEN_CONNECT) {
            setTcpFastOpenConnect(((Boolean) value).booleanValue());
            return true;
        } else if (option != EpollChannelOption.SO_BUSY_POLL) {
            return setOption(option, value);
        } else {
            setSoBusyPoll(((Integer) value).intValue());
            return true;
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public int getSendBufferSize() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getSoLinger();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public int getTrafficClass() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTrafficClass();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public boolean isKeepAlive() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isKeepAlive();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public boolean isTcpNoDelay() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isTcpNoDelay();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isTcpCork() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isTcpCork();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getSoBusyPoll() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getSoBusyPoll();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public long getTcpNotSentLowAt() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpNotSentLowAt();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpKeepIdle() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpKeepIdle();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpKeepIntvl() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpKeepIntvl();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpKeepCnt() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpKeepCnt();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpUserTimeout() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpUserTimeout();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setKeepAlive(boolean keepAlive) {
        try {
            ((EpollSocketChannel) this.channel).socket.setKeepAlive(keepAlive);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        return this;
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        try {
            ((EpollSocketChannel) this.channel).socket.setReceiveBufferSize(receiveBufferSize);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setReuseAddress(boolean reuseAddress) {
        try {
            ((EpollSocketChannel) this.channel).socket.setReuseAddress(reuseAddress);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setSendBufferSize(int sendBufferSize) {
        try {
            ((EpollSocketChannel) this.channel).socket.setSendBufferSize(sendBufferSize);
            calculateMaxBytesPerGatheringWrite();
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setSoLinger(int soLinger) {
        try {
            ((EpollSocketChannel) this.channel).socket.setSoLinger(soLinger);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setTcpNoDelay(boolean tcpNoDelay) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpNoDelay(tcpNoDelay);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpCork(boolean tcpCork) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpCork(tcpCork);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setSoBusyPoll(int loopMicros) {
        try {
            ((EpollSocketChannel) this.channel).socket.setSoBusyPoll(loopMicros);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpNotSentLowAt(long tcpNotSentLowAt) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpNotSentLowAt(tcpNotSentLowAt);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setTrafficClass(int trafficClass) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTrafficClass(trafficClass);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpKeepIdle(int seconds) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpKeepIdle(seconds);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpKeepIntvl(int seconds) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpKeepIntvl(seconds);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Deprecated
    public EpollSocketChannelConfig setTcpKeepCntl(int probes) {
        return setTcpKeepCnt(probes);
    }

    public EpollSocketChannelConfig setTcpKeepCnt(int probes) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpKeepCnt(probes);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpUserTimeout(int milliseconds) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpUserTimeout(milliseconds);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isIpTransparent() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isIpTransparent();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setIpTransparent(boolean transparent) {
        try {
            ((EpollSocketChannel) this.channel).socket.setIpTransparent(transparent);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpMd5Sig(Map<InetAddress, byte[]> keys) {
        try {
            ((EpollSocketChannel) this.channel).setTcpMd5Sig(keys);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpQuickAck(boolean quickAck) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpQuickAck(quickAck);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isTcpQuickAck() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isTcpQuickAck();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpFastOpenConnect(boolean fastOpenConnect) {
        this.tcpFastopen = fastOpenConnect;
        return this;
    }

    public boolean isTcpFastOpenConnect() {
        return this.tcpFastopen;
    }

    @Override // p013io.netty.channel.socket.DuplexChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    @Override // p013io.netty.channel.socket.SocketChannelConfig, p013io.netty.channel.socket.DuplexChannelConfig
    public EpollSocketChannelConfig setAllowHalfClosure(boolean allowHalfClosure) {
        this.allowHalfClosure = allowHalfClosure;
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAutoClose(boolean autoClose) {
        setAutoClose(autoClose);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig
    public EpollSocketChannelConfig setEpollMode(EpollMode mode) {
        setEpollMode(mode);
        return this;
    }

    private void calculateMaxBytesPerGatheringWrite() {
        if ((getSendBufferSize() << 1) > 0) {
            setMaxBytesPerGatheringWrite((long) (getSendBufferSize() << 1));
        }
    }
}
