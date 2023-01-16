package p013io.netty.channel.socket.oio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Locale;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.AddressedEnvelope;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.oio.AbstractOioMessageChannel;
import p013io.netty.channel.socket.DatagramChannel;
import p013io.netty.channel.socket.DatagramChannelConfig;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

@Deprecated
/* renamed from: io.netty.channel.socket.oio.OioDatagramChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/OioDatagramChannel.class */
public class OioDatagramChannel extends AbstractOioMessageChannel implements DatagramChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioDatagramChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + '<' + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) SocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';
    private final MulticastSocket socket;
    private final OioDatagramChannelConfig config;
    private final java.net.DatagramPacket tmpPacket;

    private static MulticastSocket newSocket() {
        try {
            return new MulticastSocket((SocketAddress) null);
        } catch (Exception e) {
            throw new ChannelException("failed to create a new socket", e);
        }
    }

    public OioDatagramChannel() {
        this(newSocket());
    }

    public OioDatagramChannel(MulticastSocket socket) {
        super(null);
        this.tmpPacket = new java.net.DatagramPacket(EmptyArrays.EMPTY_BYTES, 0);
        boolean success = false;
        try {
            try {
                socket.setSoTimeout(1000);
                socket.setBroadcast(false);
                success = true;
                if (1 == 0) {
                    socket.close();
                }
                this.socket = socket;
                this.config = new DefaultOioDatagramChannelConfig(this, socket);
            } catch (SocketException e) {
                throw new ChannelException("Failed to configure the datagram socket timeout.", e);
            }
        } catch (Throwable th) {
            if (!success) {
                socket.close();
            }
            throw th;
        }
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
    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        return isOpen() && ((((Boolean) this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && isRegistered()) || this.socket.isBound());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.socket.isConnected();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.socket.getRemoteSocketAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        this.socket.bind(localAddress);
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) localAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.oio.AbstractOioChannel
    protected void doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (localAddress != null) {
            this.socket.bind(localAddress);
        }
        boolean success = false;
        try {
            this.socket.connect(remoteAddress);
            success = true;
            if (1 == 0) {
                try {
                    this.socket.close();
                } catch (Throwable t) {
                    logger.warn("Failed to close a socket.", t);
                }
            }
        } catch (Throwable th) {
            if (!success) {
                try {
                    this.socket.close();
                } catch (Throwable t2) {
                    logger.warn("Failed to close a socket.", t2);
                }
            }
            throw th;
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.socket.disconnect();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.socket.close();
    }

    @Override // p013io.netty.channel.oio.AbstractOioMessageChannel
    protected int doReadMessages(List<Object> buf) throws Exception {
        boolean free;
        ByteBuf data;
        try {
            DatagramChannelConfig config = config();
            RecvByteBufAllocator.Handle allocHandle = unsafe().recvBufAllocHandle();
            data = config.getAllocator().heapBuffer(allocHandle.guess());
            free = true;
            try {
                this.tmpPacket.setAddress(null);
                this.tmpPacket.setData(data.array(), data.arrayOffset(), data.capacity());
                this.socket.receive(this.tmpPacket);
                allocHandle.lastBytesRead(this.tmpPacket.getLength());
                buf.add(new DatagramPacket(data.writerIndex(allocHandle.lastBytesRead()), localAddress(), (InetSocketAddress) this.tmpPacket.getSocketAddress()));
                free = false;
                if (0 != 0) {
                    data.release();
                }
                return 1;
            } catch (SocketException e) {
                if (!e.getMessage().toLowerCase(Locale.US).contains("socket closed")) {
                    throw e;
                }
                if (free) {
                    data.release();
                }
                return -1;
            } catch (SocketTimeoutException e2) {
                if (free) {
                    data.release();
                }
                return 0;
            } catch (Throwable cause) {
                PlatformDependent.throwException(cause);
                if (free) {
                    data.release();
                }
                return -1;
            }
        } catch (Throwable th) {
            if (free) {
                data.release();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d A[Catch: Exception -> 0x00aa, TryCatch #0 {Exception -> 0x00aa, blocks: (B:11:0x0043, B:12:0x004f, B:14:0x0056, B:15:0x005d, B:16:0x005e, B:17:0x0066, B:19:0x006d, B:20:0x0086, B:21:0x0097), top: B:25:0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086 A[Catch: Exception -> 0x00aa, TryCatch #0 {Exception -> 0x00aa, blocks: (B:11:0x0043, B:12:0x004f, B:14:0x0056, B:15:0x005d, B:16:0x005e, B:17:0x0066, B:19:0x006d, B:20:0x0086, B:21:0x0097), top: B:25:0x0043 }] */
    @Override // p013io.netty.channel.AbstractChannel
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void doWrite(p013io.netty.channel.ChannelOutboundBuffer r6) throws java.lang.Exception {
        /*
            r5 = this;
        L_0x0000:
            r0 = r6
            java.lang.Object r0 = r0.current()
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L_0x000c
            goto L_0x00b6
        L_0x000c:
            r0 = r7
            boolean r0 = r0 instanceof p013io.netty.channel.AddressedEnvelope
            if (r0 == 0) goto L_0x0030
            r0 = r7
            io.netty.channel.AddressedEnvelope r0 = (p013io.netty.channel.AddressedEnvelope) r0
            r10 = r0
            r0 = r10
            java.net.SocketAddress r0 = r0.recipient()
            r9 = r0
            r0 = r10
            java.lang.Object r0 = r0.content()
            io.netty.buffer.ByteBuf r0 = (p013io.netty.buffer.ByteBuf) r0
            r8 = r0
            goto L_0x0038
        L_0x0030:
            r0 = r7
            io.netty.buffer.ByteBuf r0 = (p013io.netty.buffer.ByteBuf) r0
            r8 = r0
            r0 = 0
            r9 = r0
        L_0x0038:
            r0 = r8
            int r0 = r0.readableBytes()
            r10 = r0
            r0 = r9
            if (r0 == 0) goto L_0x004f
            r0 = r5
            java.net.DatagramPacket r0 = r0.tmpPacket     // Catch: Exception -> 0x00aa
            r1 = r9
            r0.setSocketAddress(r1)     // Catch: Exception -> 0x00aa
            goto L_0x0066
        L_0x004f:
            r0 = r5
            boolean r0 = r0.isConnected()     // Catch: Exception -> 0x00aa
            if (r0 != 0) goto L_0x005e
            java.nio.channels.NotYetConnectedException r0 = new java.nio.channels.NotYetConnectedException     // Catch: Exception -> 0x00aa
            r1 = r0
            r1.<init>()     // Catch: Exception -> 0x00aa
            throw r0     // Catch: Exception -> 0x00aa
        L_0x005e:
            r0 = r5
            java.net.DatagramPacket r0 = r0.tmpPacket     // Catch: Exception -> 0x00aa
            r1 = 0
            r0.setAddress(r1)     // Catch: Exception -> 0x00aa
        L_0x0066:
            r0 = r8
            boolean r0 = r0.hasArray()     // Catch: Exception -> 0x00aa
            if (r0 == 0) goto L_0x0086
            r0 = r5
            java.net.DatagramPacket r0 = r0.tmpPacket     // Catch: Exception -> 0x00aa
            r1 = r8
            byte[] r1 = r1.array()     // Catch: Exception -> 0x00aa
            r2 = r8
            int r2 = r2.arrayOffset()     // Catch: Exception -> 0x00aa
            r3 = r8
            int r3 = r3.readerIndex()     // Catch: Exception -> 0x00aa
            int r2 = r2 + r3
            r3 = r10
            r0.setData(r1, r2, r3)     // Catch: Exception -> 0x00aa
            goto L_0x0097
        L_0x0086:
            r0 = r5
            java.net.DatagramPacket r0 = r0.tmpPacket     // Catch: Exception -> 0x00aa
            r1 = r8
            r2 = r8
            int r2 = r2.readerIndex()     // Catch: Exception -> 0x00aa
            r3 = r10
            byte[] r1 = p013io.netty.buffer.ByteBufUtil.getBytes(r1, r2, r3)     // Catch: Exception -> 0x00aa
            r0.setData(r1)     // Catch: Exception -> 0x00aa
        L_0x0097:
            r0 = r5
            java.net.MulticastSocket r0 = r0.socket     // Catch: Exception -> 0x00aa
            r1 = r5
            java.net.DatagramPacket r1 = r1.tmpPacket     // Catch: Exception -> 0x00aa
            r0.send(r1)     // Catch: Exception -> 0x00aa
            r0 = r6
            boolean r0 = r0.remove()     // Catch: Exception -> 0x00aa
            goto L_0x00b3
        L_0x00aa:
            r11 = move-exception
            r0 = r6
            r1 = r11
            boolean r0 = r0.remove(r1)
        L_0x00b3:
            goto L_0x0000
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.socket.oio.OioDatagramChannel.doWrite(io.netty.channel.ChannelOutboundBuffer):void");
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object msg) {
        if ((msg instanceof DatagramPacket) || (msg instanceof ByteBuf)) {
            return msg;
        }
        if ((msg instanceof AddressedEnvelope) && (((AddressedEnvelope) msg).content() instanceof ByteBuf)) {
            return msg;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress) {
        return joinGroup(multicastAddress, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress, ChannelPromise promise) {
        ensureBound();
        try {
            this.socket.joinGroup(multicastAddress);
            promise.setSuccess();
        } catch (IOException e) {
            promise.setFailure((Throwable) e);
        }
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress multicastAddress, NetworkInterface networkInterface) {
        return joinGroup(multicastAddress, networkInterface, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress multicastAddress, NetworkInterface networkInterface, ChannelPromise promise) {
        ensureBound();
        try {
            this.socket.joinGroup(multicastAddress, networkInterface);
            promise.setSuccess();
        } catch (IOException e) {
            promise.setFailure((Throwable) e);
        }
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source, ChannelPromise promise) {
        promise.setFailure((Throwable) new UnsupportedOperationException());
        return promise;
    }

    private void ensureBound() {
        if (!isActive()) {
            throw new IllegalStateException(DatagramChannel.class.getName() + " must be bound to join a group.");
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress) {
        return leaveGroup(multicastAddress, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress, ChannelPromise promise) {
        try {
            this.socket.leaveGroup(multicastAddress);
            promise.setSuccess();
        } catch (IOException e) {
            promise.setFailure((Throwable) e);
        }
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress multicastAddress, NetworkInterface networkInterface) {
        return leaveGroup(multicastAddress, networkInterface, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress multicastAddress, NetworkInterface networkInterface, ChannelPromise promise) {
        try {
            this.socket.leaveGroup(multicastAddress, networkInterface);
            promise.setSuccess();
        } catch (IOException e) {
            promise.setFailure((Throwable) e);
        }
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source, ChannelPromise promise) {
        promise.setFailure((Throwable) new UnsupportedOperationException());
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress sourceToBlock) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress sourceToBlock, ChannelPromise promise) {
        promise.setFailure((Throwable) new UnsupportedOperationException());
        return promise;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, InetAddress sourceToBlock) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, InetAddress sourceToBlock, ChannelPromise promise) {
        promise.setFailure((Throwable) new UnsupportedOperationException());
        return promise;
    }
}
