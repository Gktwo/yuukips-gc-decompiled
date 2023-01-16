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
import p013io.netty.channel.socket.ServerSocketChannelConfig;

/* renamed from: io.netty.channel.epoll.EpollServerSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollServerSocketChannelConfig.class */
public final class EpollServerSocketChannelConfig extends EpollServerChannelConfig implements ServerSocketChannelConfig {
    /* access modifiers changed from: package-private */
    public EpollServerSocketChannelConfig(EpollServerSocketChannel channel) {
        super(channel);
        setReuseAddress(true);
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), EpollChannelOption.SO_REUSEPORT, EpollChannelOption.IP_FREEBIND, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.TCP_DEFER_ACCEPT);
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == EpollChannelOption.SO_REUSEPORT) {
            return (T) Boolean.valueOf(isReusePort());
        }
        if (option == EpollChannelOption.IP_FREEBIND) {
            return (T) Boolean.valueOf(isFreeBind());
        }
        if (option == EpollChannelOption.IP_TRANSPARENT) {
            return (T) Boolean.valueOf(isIpTransparent());
        }
        if (option == EpollChannelOption.TCP_DEFER_ACCEPT) {
            return (T) Integer.valueOf(getTcpDeferAccept());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == EpollChannelOption.SO_REUSEPORT) {
            setReusePort(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.IP_FREEBIND) {
            setFreeBind(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.IP_TRANSPARENT) {
            setIpTransparent(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.TCP_MD5SIG) {
            setTcpMd5Sig((Map) value);
            return true;
        } else if (option != EpollChannelOption.TCP_DEFER_ACCEPT) {
            return setOption(option, value);
        } else {
            setTcpDeferAccept(((Integer) value).intValue());
            return true;
        }
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setReuseAddress(boolean reuseAddress) {
        setReuseAddress(reuseAddress);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        setReceiveBufferSize(receiveBufferSize);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerSocketChannelConfig setBacklog(int backlog) {
        setBacklog(backlog);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerSocketChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollServerChannelConfig, p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    public EpollServerSocketChannelConfig setTcpMd5Sig(Map<InetAddress, byte[]> keys) {
        try {
            ((EpollServerSocketChannel) this.channel).setTcpMd5Sig(keys);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isReusePort() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isReusePort();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollServerSocketChannelConfig setReusePort(boolean reusePort) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setReusePort(reusePort);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isFreeBind() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isIpFreeBind();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollServerSocketChannelConfig setFreeBind(boolean freeBind) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setIpFreeBind(freeBind);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isIpTransparent() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.isIpTransparent();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollServerSocketChannelConfig setIpTransparent(boolean transparent) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setIpTransparent(transparent);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollServerSocketChannelConfig setTcpDeferAccept(int deferAccept) {
        try {
            ((EpollServerSocketChannel) this.channel).socket.setTcpDeferAccept(deferAccept);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpDeferAccept() {
        try {
            return ((EpollServerSocketChannel) this.channel).socket.getTcpDeferAccept();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }
}
