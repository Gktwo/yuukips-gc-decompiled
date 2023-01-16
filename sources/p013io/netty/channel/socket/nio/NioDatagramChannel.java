package p013io.netty.channel.socket.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.MembershipKey;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.AddressedEnvelope;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultAddressedEnvelope;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.nio.AbstractNioMessageChannel;
import p013io.netty.channel.socket.DatagramChannel;
import p013io.netty.channel.socket.DatagramChannelConfig;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.util.UncheckedBooleanSupplier;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SocketUtils;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* renamed from: io.netty.channel.socket.nio.NioDatagramChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/nio/NioDatagramChannel.class */
public final class NioDatagramChannel extends AbstractNioMessageChannel implements DatagramChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + '<' + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) SocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';
    private final DatagramChannelConfig config;
    private Map<InetAddress, List<MembershipKey>> memberships;

    private static java.nio.channels.DatagramChannel newSocket(SelectorProvider provider) {
        try {
            return provider.openDatagramChannel();
        } catch (IOException e) {
            throw new ChannelException("Failed to open a socket.", e);
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    private static java.nio.channels.DatagramChannel newSocket(SelectorProvider provider, InternetProtocolFamily ipFamily) {
        if (ipFamily == null) {
            return newSocket(provider);
        }
        checkJavaVersion();
        try {
            return provider.openDatagramChannel(ProtocolFamilyConverter.convert(ipFamily));
        } catch (IOException e) {
            throw new ChannelException("Failed to open a socket.", e);
        }
    }

    private static void checkJavaVersion() {
        if (PlatformDependent.javaVersion() < 7) {
            throw new UnsupportedOperationException("Only supported on java 7+.");
        }
    }

    public NioDatagramChannel() {
        this(newSocket(DEFAULT_SELECTOR_PROVIDER));
    }

    public NioDatagramChannel(SelectorProvider provider) {
        this(newSocket(provider));
    }

    public NioDatagramChannel(InternetProtocolFamily ipFamily) {
        this(newSocket(DEFAULT_SELECTOR_PROVIDER, ipFamily));
    }

    public NioDatagramChannel(SelectorProvider provider, InternetProtocolFamily ipFamily) {
        this(newSocket(provider, ipFamily));
    }

    public NioDatagramChannel(java.nio.channels.DatagramChannel socket) {
        super(null, socket, 1);
        this.config = new NioDatagramChannelConfig(this, socket);
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.Channel
    public DatagramChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.DatagramChannel ch = javaChannel();
        return ch.isOpen() && ((((Boolean) this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && isRegistered()) || ch.socket().isBound());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return javaChannel().isConnected();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.nio.AbstractNioChannel
    public java.nio.channels.DatagramChannel javaChannel() {
        return (java.nio.channels.DatagramChannel) javaChannel();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return javaChannel().socket().getLocalSocketAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return javaChannel().socket().getRemoteSocketAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        doBind0(localAddress);
    }

    private void doBind0(SocketAddress localAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            SocketUtils.bind(javaChannel(), localAddress);
        } else {
            javaChannel().socket().bind(localAddress);
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (localAddress != null) {
            doBind0(localAddress);
        }
        boolean success = false;
        try {
            javaChannel().connect(remoteAddress);
            success = true;
            if (1 == 0) {
                doClose();
            }
            return true;
        } catch (Throwable th) {
            if (!success) {
                doClose();
            }
            throw th;
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        throw new Error();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        javaChannel().disconnect();
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel, p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        javaChannel().close();
    }

    @Override // p013io.netty.channel.nio.AbstractNioMessageChannel
    protected int doReadMessages(List<Object> buf) throws Exception {
        java.nio.channels.DatagramChannel ch = javaChannel();
        DatagramChannelConfig config = config();
        RecvByteBufAllocator.Handle allocHandle = unsafe().recvBufAllocHandle();
        ByteBuf data = allocHandle.allocate(config.getAllocator());
        allocHandle.attemptedBytesRead(data.writableBytes());
        boolean free = true;
        try {
            ByteBuffer nioData = data.internalNioBuffer(data.writerIndex(), data.writableBytes());
            int pos = nioData.position();
            InetSocketAddress remoteAddress = (InetSocketAddress) ch.receive(nioData);
            if (remoteAddress == null) {
                return 0;
            }
            allocHandle.lastBytesRead(nioData.position() - pos);
            buf.add(new DatagramPacket(data.writerIndex(data.writerIndex() + allocHandle.lastBytesRead()), localAddress(), remoteAddress));
            free = false;
            if (0 != 0) {
                data.release();
            }
            return 1;
        } finally {
            if (free) {
                data.release();
            }
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean doWriteMessage(Object msg, ChannelOutboundBuffer in) throws Exception {
        ByteBuf data;
        SocketAddress remoteAddress;
        int writtenBytes;
        if (msg instanceof AddressedEnvelope) {
            AddressedEnvelope<ByteBuf, SocketAddress> envelope = (AddressedEnvelope) msg;
            remoteAddress = envelope.recipient();
            data = envelope.content();
        } else {
            data = (ByteBuf) msg;
            remoteAddress = null;
        }
        int dataLen = data.readableBytes();
        if (dataLen == 0) {
            return true;
        }
        ByteBuffer nioData = data.nioBufferCount() == 1 ? data.internalNioBuffer(data.readerIndex(), dataLen) : data.nioBuffer(data.readerIndex(), dataLen);
        if (remoteAddress != null) {
            writtenBytes = javaChannel().send(nioData, remoteAddress);
        } else {
            writtenBytes = javaChannel().write(nioData);
        }
        return writtenBytes > 0;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object msg) {
        if (msg instanceof DatagramPacket) {
            DatagramPacket p = (DatagramPacket) msg;
            ByteBuf content = (ByteBuf) p.content();
            if (isSingleDirectBuffer(content)) {
                return p;
            }
            return new DatagramPacket(newDirectBuffer(p, content), p.recipient());
        } else if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            if (isSingleDirectBuffer(buf)) {
                return buf;
            }
            return newDirectBuffer(buf);
        } else {
            if (msg instanceof AddressedEnvelope) {
                AddressedEnvelope<Object, SocketAddress> e = (AddressedEnvelope) msg;
                if (e.content() instanceof ByteBuf) {
                    ByteBuf content2 = (ByteBuf) e.content();
                    if (isSingleDirectBuffer(content2)) {
                        return e;
                    }
                    return new DefaultAddressedEnvelope(newDirectBuffer(e, content2), e.recipient());
                }
            }
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
        }
    }

    private static boolean isSingleDirectBuffer(ByteBuf buf) {
        return buf.isDirect() && buf.nioBufferCount() == 1;
    }

    @Override // p013io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean continueOnWriteError() {
        return true;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) localAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress) {
        return joinGroup(multicastAddress, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress, ChannelPromise promise) {
        try {
            NetworkInterface iface = this.config.getNetworkInterface();
            if (iface == null) {
                iface = NetworkInterface.getByInetAddress(localAddress().getAddress());
            }
            return joinGroup(multicastAddress, iface, null, promise);
        } catch (SocketException e) {
            promise.setFailure((Throwable) e);
            return promise;
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress multicastAddress, NetworkInterface networkInterface) {
        return joinGroup(multicastAddress, networkInterface, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress multicastAddress, NetworkInterface networkInterface, ChannelPromise promise) {
        return joinGroup(multicastAddress.getAddress(), networkInterface, null, promise);
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source) {
        return joinGroup(multicastAddress, networkInterface, source, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public ChannelFuture joinGroup(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source, ChannelPromise promise) {
        MembershipKey key;
        checkJavaVersion();
        ObjectUtil.checkNotNull(multicastAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        try {
            if (source == null) {
                key = javaChannel().join(multicastAddress, networkInterface);
            } else {
                key = javaChannel().join(multicastAddress, networkInterface, source);
            }
            synchronized (this) {
                List<MembershipKey> keys = null;
                if (this.memberships == null) {
                    this.memberships = new HashMap();
                } else {
                    keys = this.memberships.get(multicastAddress);
                }
                if (keys == null) {
                    keys = new ArrayList<>();
                    this.memberships.put(multicastAddress, keys);
                }
                keys.add(key);
            }
            promise.setSuccess();
        } catch (Throwable e) {
            promise.setFailure(e);
        }
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress) {
        return leaveGroup(multicastAddress, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress, ChannelPromise promise) {
        try {
            return leaveGroup(multicastAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, promise);
        } catch (SocketException e) {
            promise.setFailure((Throwable) e);
            return promise;
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress multicastAddress, NetworkInterface networkInterface) {
        return leaveGroup(multicastAddress, networkInterface, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress multicastAddress, NetworkInterface networkInterface, ChannelPromise promise) {
        return leaveGroup(multicastAddress.getAddress(), networkInterface, null, promise);
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source) {
        return leaveGroup(multicastAddress, networkInterface, source, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public ChannelFuture leaveGroup(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source, ChannelPromise promise) {
        List<MembershipKey> keys;
        checkJavaVersion();
        ObjectUtil.checkNotNull(multicastAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        synchronized (this) {
            if (!(this.memberships == null || (keys = this.memberships.get(multicastAddress)) == null)) {
                Iterator<MembershipKey> keyIt = keys.iterator();
                while (keyIt.hasNext()) {
                    MembershipKey key = keyIt.next();
                    if (networkInterface.equals(key.networkInterface()) && ((source == null && key.sourceAddress() == null) || (source != null && source.equals(key.sourceAddress())))) {
                        key.drop();
                        keyIt.remove();
                    }
                }
                if (keys.isEmpty()) {
                    this.memberships.remove(multicastAddress);
                }
            }
        }
        promise.setSuccess();
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress sourceToBlock) {
        return block(multicastAddress, networkInterface, sourceToBlock, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public ChannelFuture block(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress sourceToBlock, ChannelPromise promise) {
        checkJavaVersion();
        ObjectUtil.checkNotNull(multicastAddress, "multicastAddress");
        ObjectUtil.checkNotNull(sourceToBlock, "sourceToBlock");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        synchronized (this) {
            if (this.memberships != null) {
                for (MembershipKey key : this.memberships.get(multicastAddress)) {
                    if (networkInterface.equals(key.networkInterface())) {
                        try {
                            key.block(sourceToBlock);
                        } catch (IOException e) {
                            promise.setFailure((Throwable) e);
                        }
                    }
                }
            }
        }
        promise.setSuccess();
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, InetAddress sourceToBlock) {
        return block(multicastAddress, sourceToBlock, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, InetAddress sourceToBlock, ChannelPromise promise) {
        try {
            return block(multicastAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), sourceToBlock, promise);
        } catch (SocketException e) {
            promise.setFailure((Throwable) e);
            return promise;
        }
    }

    @Override // p013io.netty.channel.nio.AbstractNioChannel
    @Deprecated
    protected void setReadPending(boolean readPending) {
        setReadPending(readPending);
    }

    /* access modifiers changed from: package-private */
    public void clearReadPending0() {
        clearReadPending();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.nio.AbstractNioMessageChannel
    public boolean closeOnReadError(Throwable cause) {
        if (cause instanceof SocketException) {
            return false;
        }
        return closeOnReadError(cause);
    }

    @Override // p013io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean continueReading(RecvByteBufAllocator.Handle allocHandle) {
        if (allocHandle instanceof RecvByteBufAllocator.ExtendedHandle) {
            return ((RecvByteBufAllocator.ExtendedHandle) allocHandle).continueReading(UncheckedBooleanSupplier.TRUE_SUPPLIER);
        }
        return allocHandle.continueReading();
    }
}
