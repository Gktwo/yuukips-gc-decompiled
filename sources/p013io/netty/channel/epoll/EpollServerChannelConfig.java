package p013io.netty.channel.epoll;

import java.io.IOException;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.ServerChannelRecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.ServerSocketChannelConfig;
import p013io.netty.util.NetUtil;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.epoll.EpollServerChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollServerChannelConfig.class */
public class EpollServerChannelConfig extends EpollChannelConfig implements ServerSocketChannelConfig {
    private volatile int backlog = NetUtil.SOMAXCONN;
    private volatile int pendingFastOpenRequestsThreshold;

    /* access modifiers changed from: package-private */
    public EpollServerChannelConfig(AbstractEpollChannel channel) {
        super(channel, new ServerChannelRecvByteBufAllocator());
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_BACKLOG, ChannelOption.TCP_FASTOPEN);
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
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
        if (option == ChannelOption.TCP_FASTOPEN) {
            return (T) Integer.valueOf(getTcpFastopen());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) value).booleanValue());
            return true;
        } else if (option == ChannelOption.SO_BACKLOG) {
            setBacklog(((Integer) value).intValue());
            return true;
        } else if (option != ChannelOption.TCP_FASTOPEN) {
            return setOption(option, value);
        } else {
            setTcpFastopen(((Integer) value).intValue());
            return true;
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((AbstractEpollChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerChannelConfig setReuseAddress(boolean reuseAddress) {
        try {
            ((AbstractEpollChannel) this.channel).socket.setReuseAddress(reuseAddress);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((AbstractEpollChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        try {
            ((AbstractEpollChannel) this.channel).socket.setReceiveBufferSize(receiveBufferSize);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public int getBacklog() {
        return this.backlog;
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerChannelConfig setBacklog(int backlog) {
        ObjectUtil.checkPositiveOrZero(backlog, "backlog");
        this.backlog = backlog;
        return this;
    }

    public int getTcpFastopen() {
        return this.pendingFastOpenRequestsThreshold;
    }

    public EpollServerChannelConfig setTcpFastopen(int pendingFastOpenRequestsThreshold) {
        ObjectUtil.checkPositiveOrZero(this.pendingFastOpenRequestsThreshold, "pendingFastOpenRequestsThreshold");
        this.pendingFastOpenRequestsThreshold = pendingFastOpenRequestsThreshold;
        return this;
    }

    @Override // p013io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig
    public EpollServerChannelConfig setEpollMode(EpollMode mode) {
        setEpollMode(mode);
        return this;
    }
}
