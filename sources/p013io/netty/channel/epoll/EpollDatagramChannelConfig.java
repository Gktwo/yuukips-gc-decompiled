package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.FixedRecvByteBufAllocator;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.socket.DatagramChannelConfig;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.epoll.EpollDatagramChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollDatagramChannelConfig.class */
public final class EpollDatagramChannelConfig extends EpollChannelConfig implements DatagramChannelConfig {
    private static final RecvByteBufAllocator DEFAULT_RCVBUF_ALLOCATOR = new FixedRecvByteBufAllocator(2048);
    private boolean activeOnOpen;
    private volatile int maxDatagramSize;
    private volatile boolean gro;

    /* access modifiers changed from: package-private */
    public EpollDatagramChannelConfig(EpollDatagramChannel channel) {
        super(channel);
        setRecvByteBufAllocator(DEFAULT_RCVBUF_ALLOCATOR);
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, EpollChannelOption.SO_REUSEPORT, EpollChannelOption.IP_FREEBIND, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.IP_RECVORIGDSTADDR, EpollChannelOption.MAX_DATAGRAM_PAYLOAD_SIZE, EpollChannelOption.UDP_GRO);
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == ChannelOption.SO_BROADCAST) {
            return (T) Boolean.valueOf(isBroadcast());
        }
        if (option == ChannelOption.SO_RCVBUF) {
            return (T) Integer.valueOf(getReceiveBufferSize());
        }
        if (option == ChannelOption.SO_SNDBUF) {
            return (T) Integer.valueOf(getSendBufferSize());
        }
        if (option == ChannelOption.SO_REUSEADDR) {
            return (T) Boolean.valueOf(isReuseAddress());
        }
        if (option == ChannelOption.IP_MULTICAST_LOOP_DISABLED) {
            return (T) Boolean.valueOf(isLoopbackModeDisabled());
        }
        if (option == ChannelOption.IP_MULTICAST_ADDR) {
            return (T) getInterface();
        }
        if (option == ChannelOption.IP_MULTICAST_IF) {
            return (T) getNetworkInterface();
        }
        if (option == ChannelOption.IP_MULTICAST_TTL) {
            return (T) Integer.valueOf(getTimeToLive());
        }
        if (option == ChannelOption.IP_TOS) {
            return (T) Integer.valueOf(getTrafficClass());
        }
        if (option == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
            return (T) Boolean.valueOf(this.activeOnOpen);
        }
        if (option == EpollChannelOption.SO_REUSEPORT) {
            return (T) Boolean.valueOf(isReusePort());
        }
        if (option == EpollChannelOption.IP_TRANSPARENT) {
            return (T) Boolean.valueOf(isIpTransparent());
        }
        if (option == EpollChannelOption.IP_FREEBIND) {
            return (T) Boolean.valueOf(isFreeBind());
        }
        if (option == EpollChannelOption.IP_RECVORIGDSTADDR) {
            return (T) Boolean.valueOf(isIpRecvOrigDestAddr());
        }
        if (option == EpollChannelOption.MAX_DATAGRAM_PAYLOAD_SIZE) {
            return (T) Integer.valueOf(getMaxDatagramPayloadSize());
        }
        if (option == EpollChannelOption.UDP_GRO) {
            return (T) Boolean.valueOf(isUdpGro());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == ChannelOption.SO_BROADCAST) {
            setBroadcast(((Boolean) value).booleanValue());
            return true;
        } else if (option == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) value).booleanValue());
            return true;
        } else if (option == ChannelOption.IP_MULTICAST_LOOP_DISABLED) {
            setLoopbackModeDisabled(((Boolean) value).booleanValue());
            return true;
        } else if (option == ChannelOption.IP_MULTICAST_ADDR) {
            setInterface((InetAddress) value);
            return true;
        } else if (option == ChannelOption.IP_MULTICAST_IF) {
            setNetworkInterface((NetworkInterface) value);
            return true;
        } else if (option == ChannelOption.IP_MULTICAST_TTL) {
            setTimeToLive(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.IP_TOS) {
            setTrafficClass(((Integer) value).intValue());
            return true;
        } else if (option == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
            setActiveOnOpen(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.SO_REUSEPORT) {
            setReusePort(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.IP_FREEBIND) {
            setFreeBind(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.IP_TRANSPARENT) {
            setIpTransparent(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.IP_RECVORIGDSTADDR) {
            setIpRecvOrigDestAddr(((Boolean) value).booleanValue());
            return true;
        } else if (option == EpollChannelOption.MAX_DATAGRAM_PAYLOAD_SIZE) {
            setMaxDatagramPayloadSize(((Integer) value).intValue());
            return true;
        } else if (option != EpollChannelOption.UDP_GRO) {
            return setOption(option, value);
        } else {
            setUdpGro(((Boolean) value).booleanValue());
            return true;
        }
    }

    private void setActiveOnOpen(boolean activeOnOpen) {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("Can only changed before channel was registered");
        }
        this.activeOnOpen = activeOnOpen;
    }

    /* access modifiers changed from: package-private */
    public boolean getActiveOnOpen() {
        return this.activeOnOpen;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDatagramChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDatagramChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setAutoClose(boolean autoClose) {
        setAutoClose(autoClose);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDatagramChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public int getSendBufferSize() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setSendBufferSize(int sendBufferSize) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setSendBufferSize(sendBufferSize);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setReceiveBufferSize(receiveBufferSize);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public int getTrafficClass() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getTrafficClass();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setTrafficClass(int trafficClass) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setTrafficClass(trafficClass);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setReuseAddress(boolean reuseAddress) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setReuseAddress(reuseAddress);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public boolean isBroadcast() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isBroadcast();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setBroadcast(boolean broadcast) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setBroadcast(broadcast);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public boolean isLoopbackModeDisabled() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isLoopbackModeDisabled();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean loopbackModeDisabled) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setLoopbackModeDisabled(loopbackModeDisabled);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public int getTimeToLive() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getTimeToLive();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setTimeToLive(int ttl) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setTimeToLive(ttl);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public InetAddress getInterface() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getInterface();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setInterface(InetAddress interfaceAddress) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setInterface(interfaceAddress);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public NetworkInterface getNetworkInterface() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getNetworkInterface();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setNetworkInterface(networkInterface);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.epoll.EpollChannelConfig
    public EpollDatagramChannelConfig setEpollMode(EpollMode mode) {
        setEpollMode(mode);
        return this;
    }

    public boolean isReusePort() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isReusePort();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollDatagramChannelConfig setReusePort(boolean reusePort) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setReusePort(reusePort);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isIpTransparent() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isIpTransparent();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollDatagramChannelConfig setIpTransparent(boolean ipTransparent) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setIpTransparent(ipTransparent);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isFreeBind() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isIpFreeBind();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollDatagramChannelConfig setFreeBind(boolean freeBind) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setIpFreeBind(freeBind);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isIpRecvOrigDestAddr() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isIpRecvOrigDestAddr();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollDatagramChannelConfig setIpRecvOrigDestAddr(boolean ipTransparent) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setIpRecvOrigDestAddr(ipTransparent);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollDatagramChannelConfig setMaxDatagramPayloadSize(int maxDatagramSize) {
        this.maxDatagramSize = ObjectUtil.checkPositiveOrZero(maxDatagramSize, "maxDatagramSize");
        return this;
    }

    public int getMaxDatagramPayloadSize() {
        return this.maxDatagramSize;
    }

    public EpollDatagramChannelConfig setUdpGro(boolean gro) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setUdpGro(gro);
            this.gro = gro;
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isUdpGro() {
        return this.gro;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig
    public EpollDatagramChannelConfig setMaxMessagesPerWrite(int maxMessagesPerWrite) {
        setMaxMessagesPerWrite(maxMessagesPerWrite);
        return this;
    }
}
