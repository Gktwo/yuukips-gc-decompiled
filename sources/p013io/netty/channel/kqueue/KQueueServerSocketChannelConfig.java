package p013io.netty.channel.kqueue;

import java.io.IOException;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.unix.UnixChannelOption;

/* renamed from: io.netty.channel.kqueue.KQueueServerSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueServerSocketChannelConfig.class */
public class KQueueServerSocketChannelConfig extends KQueueServerChannelConfig {
    /* access modifiers changed from: package-private */
    public KQueueServerSocketChannelConfig(KQueueServerSocketChannel channel) {
        super(channel);
        setReuseAddress(true);
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), UnixChannelOption.SO_REUSEPORT, KQueueChannelOption.SO_ACCEPTFILTER);
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == UnixChannelOption.SO_REUSEPORT) {
            return (T) Boolean.valueOf(isReusePort());
        }
        if (option == KQueueChannelOption.SO_ACCEPTFILTER) {
            return (T) getAcceptFilter();
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == UnixChannelOption.SO_REUSEPORT) {
            setReusePort(((Boolean) value).booleanValue());
            return true;
        } else if (option != KQueueChannelOption.SO_ACCEPTFILTER) {
            return setOption(option, value);
        } else {
            setAcceptFilter((AcceptFilter) value);
            return true;
        }
    }

    public KQueueServerSocketChannelConfig setReusePort(boolean reusePort) {
        try {
            ((KQueueServerSocketChannel) this.channel).socket.setReusePort(reusePort);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isReusePort() {
        try {
            return ((KQueueServerSocketChannel) this.channel).socket.isReusePort();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public KQueueServerSocketChannelConfig setAcceptFilter(AcceptFilter acceptFilter) {
        try {
            ((KQueueServerSocketChannel) this.channel).socket.setAcceptFilter(acceptFilter);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public AcceptFilter getAcceptFilter() {
        try {
            return ((KQueueServerSocketChannel) this.channel).socket.getAcceptFilter();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig
    public KQueueServerSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean transportProvidesGuess) {
        setRcvAllocTransportProvidesGuess(transportProvidesGuess);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setReuseAddress(boolean reuseAddress) {
        setReuseAddress(reuseAddress);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        setReceiveBufferSize(receiveBufferSize);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setBacklog(int backlog) {
        setBacklog(backlog);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig
    public KQueueServerSocketChannelConfig setTcpFastOpen(boolean enableTcpFastOpen) {
        setTcpFastOpen(enableTcpFastOpen);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueServerChannelConfig, p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }
}
