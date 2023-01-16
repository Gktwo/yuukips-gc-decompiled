package p013io.netty.channel.socket;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.DefaultChannelConfig;
import p013io.netty.channel.FixedRecvByteBufAllocator;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.socket.DefaultDatagramChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/DefaultDatagramChannelConfig.class */
public class DefaultDatagramChannelConfig extends DefaultChannelConfig implements DatagramChannelConfig {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultDatagramChannelConfig.class);
    private final DatagramSocket javaSocket;
    private volatile boolean activeOnOpen;

    public DefaultDatagramChannelConfig(DatagramChannel channel, DatagramSocket javaSocket) {
        super(channel, new FixedRecvByteBufAllocator(2048));
        this.javaSocket = (DatagramSocket) ObjectUtil.checkNotNull(javaSocket, "javaSocket");
    }

    protected final DatagramSocket javaSocket() {
        return this.javaSocket;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION);
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
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
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
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
        } else if (option != ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
            return setOption(option, value);
        } else {
            setActiveOnOpen(((Boolean) value).booleanValue());
            return true;
        }
    }

    private void setActiveOnOpen(boolean activeOnOpen) {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("Can only changed before channel was registered");
        }
        this.activeOnOpen = activeOnOpen;
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public boolean isBroadcast() {
        try {
            return this.javaSocket.getBroadcast();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setBroadcast(boolean broadcast) {
        if (broadcast) {
            try {
                if (!this.javaSocket.getLocalAddress().isAnyLocalAddress() && !PlatformDependent.isWindows() && !PlatformDependent.maybeSuperUser()) {
                    logger.warn("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; setting the SO_BROADCAST flag anyway as requested on the socket which is bound to " + this.javaSocket.getLocalSocketAddress() + '.');
                }
            } catch (SocketException e) {
                throw new ChannelException(e);
            }
        }
        this.javaSocket.setBroadcast(broadcast);
        return this;
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public InetAddress getInterface() {
        if (this.javaSocket instanceof MulticastSocket) {
            try {
                return ((MulticastSocket) this.javaSocket).getInterface();
            } catch (SocketException e) {
                throw new ChannelException(e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setInterface(InetAddress interfaceAddress) {
        if (this.javaSocket instanceof MulticastSocket) {
            try {
                ((MulticastSocket) this.javaSocket).setInterface(interfaceAddress);
                return this;
            } catch (SocketException e) {
                throw new ChannelException(e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public boolean isLoopbackModeDisabled() {
        if (this.javaSocket instanceof MulticastSocket) {
            try {
                return ((MulticastSocket) this.javaSocket).getLoopbackMode();
            } catch (SocketException e) {
                throw new ChannelException(e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean loopbackModeDisabled) {
        if (this.javaSocket instanceof MulticastSocket) {
            try {
                ((MulticastSocket) this.javaSocket).setLoopbackMode(loopbackModeDisabled);
                return this;
            } catch (SocketException e) {
                throw new ChannelException(e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public NetworkInterface getNetworkInterface() {
        if (this.javaSocket instanceof MulticastSocket) {
            try {
                return ((MulticastSocket) this.javaSocket).getNetworkInterface();
            } catch (SocketException e) {
                throw new ChannelException(e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface) {
        if (this.javaSocket instanceof MulticastSocket) {
            try {
                ((MulticastSocket) this.javaSocket).setNetworkInterface(networkInterface);
                return this;
            } catch (SocketException e) {
                throw new ChannelException(e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setReuseAddress(boolean reuseAddress) {
        try {
            this.javaSocket.setReuseAddress(reuseAddress);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setReceiveBufferSize(int receiveBufferSize) {
        try {
            this.javaSocket.setReceiveBufferSize(receiveBufferSize);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public int getSendBufferSize() {
        try {
            return this.javaSocket.getSendBufferSize();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setSendBufferSize(int sendBufferSize) {
        try {
            this.javaSocket.setSendBufferSize(sendBufferSize);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public int getTimeToLive() {
        if (this.javaSocket instanceof MulticastSocket) {
            try {
                return ((MulticastSocket) this.javaSocket).getTimeToLive();
            } catch (IOException e) {
                throw new ChannelException(e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setTimeToLive(int ttl) {
        if (this.javaSocket instanceof MulticastSocket) {
            try {
                ((MulticastSocket) this.javaSocket).setTimeToLive(ttl);
                return this;
            } catch (IOException e) {
                throw new ChannelException(e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public int getTrafficClass() {
        try {
            return this.javaSocket.getTrafficClass();
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setTrafficClass(int trafficClass) {
        try {
            this.javaSocket.setTrafficClass(trafficClass);
            return this;
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public DatagramChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setAutoClose(boolean autoClose) {
        setAutoClose(autoClose);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig
    public DatagramChannelConfig setMaxMessagesPerWrite(int maxMessagesPerWrite) {
        setMaxMessagesPerWrite(maxMessagesPerWrite);
        return this;
    }
}
