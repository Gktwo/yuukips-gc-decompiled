package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.AddressedEnvelope;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.DefaultAddressedEnvelope;
import p013io.netty.channel.epoll.AbstractEpollChannel;
import p013io.netty.channel.epoll.NativeDatagramPacketArray;
import p013io.netty.channel.socket.DatagramChannel;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.channel.unix.Errors;
import p013io.netty.channel.unix.SegmentedDatagramPacket;
import p013io.netty.channel.unix.UnixChannelUtil;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.UncheckedBooleanSupplier;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.RecyclableArrayList;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.channel.epoll.EpollDatagramChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollDatagramChannel.class */
public final class EpollDatagramChannel extends AbstractEpollChannel implements DatagramChannel {
    private static final ChannelMetadata METADATA;
    private static final String EXPECTED_TYPES;
    private final EpollDatagramChannelConfig config;
    private volatile boolean connected;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return isOpen();
    }

    static {
        $assertionsDisabled = !EpollDatagramChannel.class.desiredAssertionStatus();
        METADATA = new ChannelMetadata(true);
        EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + '<' + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) InetSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';
    }

    public static boolean isSegmentedDatagramPacketSupported() {
        return Epoll.isAvailable() && Native.IS_SUPPORTING_SENDMMSG && Native.IS_SUPPORTING_UDP_SEGMENT;
    }

    public EpollDatagramChannel() {
        this((InternetProtocolFamily) null);
    }

    public EpollDatagramChannel(InternetProtocolFamily family) {
        this(LinuxSocket.newSocketDgram(family), false);
    }

    public EpollDatagramChannel(int fd) {
        this(new LinuxSocket(fd), true);
    }

    private EpollDatagramChannel(LinuxSocket fd, boolean active) {
        super((Channel) null, fd, active);
        this.config = new EpollDatagramChannelConfig(this);
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) localAddress();
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress) {
        return joinGroup(multicastAddress, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress multicastAddress, ChannelPromise promise) {
        try {
            NetworkInterface iface = config().getNetworkInterface();
            if (iface == null) {
                iface = NetworkInterface.getByInetAddress(localAddress().getAddress());
            }
            return joinGroup(multicastAddress, iface, null, promise);
        } catch (IOException e) {
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
    public ChannelFuture joinGroup(final InetAddress multicastAddress, final NetworkInterface networkInterface, final InetAddress source, final ChannelPromise promise) {
        ObjectUtil.checkNotNull(multicastAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        if (eventLoop().inEventLoop()) {
            joinGroup0(multicastAddress, networkInterface, source, promise);
        } else {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.epoll.EpollDatagramChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    EpollDatagramChannel.this.joinGroup0(multicastAddress, networkInterface, source, promise);
                }
            });
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void joinGroup0(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source, ChannelPromise promise) {
        if ($assertionsDisabled || eventLoop().inEventLoop()) {
            try {
                this.socket.joinGroup(multicastAddress, networkInterface, source);
                promise.setSuccess();
            } catch (IOException e) {
                promise.setFailure((Throwable) e);
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress) {
        return leaveGroup(multicastAddress, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress multicastAddress, ChannelPromise promise) {
        try {
            return leaveGroup(multicastAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, promise);
        } catch (IOException e) {
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
    public ChannelFuture leaveGroup(final InetAddress multicastAddress, final NetworkInterface networkInterface, final InetAddress source, final ChannelPromise promise) {
        ObjectUtil.checkNotNull(multicastAddress, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        if (eventLoop().inEventLoop()) {
            leaveGroup0(multicastAddress, networkInterface, source, promise);
        } else {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.epoll.EpollDatagramChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    EpollDatagramChannel.this.leaveGroup0(multicastAddress, networkInterface, source, promise);
                }
            });
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void leaveGroup0(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress source, ChannelPromise promise) {
        if ($assertionsDisabled || eventLoop().inEventLoop()) {
            try {
                this.socket.leaveGroup(multicastAddress, networkInterface, source);
                promise.setSuccess();
            } catch (IOException e) {
                promise.setFailure((Throwable) e);
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress sourceToBlock) {
        return block(multicastAddress, networkInterface, sourceToBlock, newPromise());
    }

    @Override // p013io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress multicastAddress, NetworkInterface networkInterface, InetAddress sourceToBlock, ChannelPromise promise) {
        ObjectUtil.checkNotNull(multicastAddress, "multicastAddress");
        ObjectUtil.checkNotNull(sourceToBlock, "sourceToBlock");
        ObjectUtil.checkNotNull(networkInterface, "networkInterface");
        promise.setFailure((Throwable) new UnsupportedOperationException("Multicast block not supported"));
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
        } catch (Throwable e) {
            promise.setFailure(e);
            return promise;
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDatagramChannelUnsafe();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doBind(SocketAddress localAddress) throws Exception {
        if (localAddress instanceof InetSocketAddress) {
            InetSocketAddress socketAddress = (InetSocketAddress) localAddress;
            if (socketAddress.getAddress().isAnyLocalAddress() && (socketAddress.getAddress() instanceof Inet4Address) && this.socket.family() == InternetProtocolFamily.IPv6) {
                localAddress = new InetSocketAddress(LinuxSocket.INET6_ANY, socketAddress.getPort());
            }
        }
        doBind(localAddress);
        this.active = true;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        Object msg;
        int maxMessagesPerWrite = maxMessagesPerWrite();
        while (maxMessagesPerWrite > 0 && (msg = in.current()) != null) {
            try {
            } catch (IOException e) {
                maxMessagesPerWrite--;
                in.remove(e);
            }
            if ((Native.IS_SUPPORTING_SENDMMSG && in.size() > 1) || (in.current() instanceof SegmentedDatagramPacket)) {
                NativeDatagramPacketArray array = cleanDatagramPacketArray();
                array.add(in, isConnected(), maxMessagesPerWrite);
                int cnt = array.count();
                if (cnt >= 1) {
                    int send = this.socket.sendmmsg(array.packets(), 0, cnt);
                    if (send == 0) {
                        break;
                    }
                    for (int i = 0; i < send; i++) {
                        in.remove();
                    }
                    maxMessagesPerWrite -= send;
                }
            }
            boolean done = false;
            int i2 = config().getWriteSpinCount();
            while (true) {
                if (i2 <= 0) {
                    break;
                } else if (doWriteMessage(msg)) {
                    done = true;
                    break;
                } else {
                    i2--;
                }
            }
            if (!done) {
                break;
            }
            in.remove();
            maxMessagesPerWrite--;
        }
        if (in.isEmpty()) {
            clearFlag(Native.EPOLLOUT);
        } else {
            setFlag(Native.EPOLLOUT);
        }
    }

    private boolean doWriteMessage(Object msg) throws Exception {
        InetSocketAddress remoteAddress;
        ByteBuf data;
        if (msg instanceof AddressedEnvelope) {
            AddressedEnvelope<ByteBuf, InetSocketAddress> envelope = (AddressedEnvelope) msg;
            data = envelope.content();
            remoteAddress = envelope.recipient();
        } else {
            data = (ByteBuf) msg;
            remoteAddress = null;
        }
        return data.readableBytes() == 0 || doWriteOrSendBytes(data, remoteAddress, false) > 0;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object msg) {
        if (msg instanceof SegmentedDatagramPacket) {
            if (!Native.IS_SUPPORTING_UDP_SEGMENT) {
                throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
            }
            SegmentedDatagramPacket packet = (SegmentedDatagramPacket) msg;
            ByteBuf content = (ByteBuf) packet.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(content) ? packet.replace(newDirectBuffer(packet, content)) : msg;
        } else if (msg instanceof DatagramPacket) {
            DatagramPacket packet2 = (DatagramPacket) msg;
            ByteBuf content2 = (ByteBuf) packet2.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(content2) ? new DatagramPacket(newDirectBuffer(packet2, content2), packet2.recipient()) : msg;
        } else if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            return UnixChannelUtil.isBufferCopyNeededForWrite(buf) ? newDirectBuffer(buf) : buf;
        } else {
            if (msg instanceof AddressedEnvelope) {
                AddressedEnvelope<Object, SocketAddress> e = (AddressedEnvelope) msg;
                if ((e.content() instanceof ByteBuf) && (e.recipient() == null || (e.recipient() instanceof InetSocketAddress))) {
                    ByteBuf content3 = (ByteBuf) e.content();
                    return UnixChannelUtil.isBufferCopyNeededForWrite(content3) ? new DefaultAddressedEnvelope(newDirectBuffer(e, content3), (InetSocketAddress) e.recipient()) : e;
                }
            }
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
        }
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public EpollDatagramChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.socket.disconnect();
        this.active = false;
        this.connected = false;
        resetCachedAddresses();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel
    public boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (!doConnect(remoteAddress, localAddress)) {
            return false;
        }
        this.connected = true;
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        doClose();
        this.connected = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.epoll.EpollDatagramChannel$EpollDatagramChannelUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollDatagramChannel$EpollDatagramChannelUnsafe.class */
    public final class EpollDatagramChannelUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled;

        EpollDatagramChannelUnsafe() {
            super();
        }

        static {
            $assertionsDisabled = !EpollDatagramChannel.class.desiredAssertionStatus();
        }

        /* access modifiers changed from: package-private */
        @Override // p013io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        public void epollInReady() {
            int numDatagram;
            boolean read;
            if ($assertionsDisabled || EpollDatagramChannel.this.eventLoop().inEventLoop()) {
                EpollDatagramChannelConfig config = EpollDatagramChannel.this.config();
                if (EpollDatagramChannel.this.shouldBreakEpollInReady(config)) {
                    clearEpollIn0();
                    return;
                }
                EpollRecvByteAllocatorHandle allocHandle = recvBufAllocHandle();
                allocHandle.edgeTriggered(EpollDatagramChannel.this.isFlagSet(Native.EPOLLET));
                ChannelPipeline pipeline = EpollDatagramChannel.this.pipeline();
                ByteBufAllocator allocator = config.getAllocator();
                allocHandle.reset(config);
                epollInBefore();
                Throwable exception = null;
                boolean connected = EpollDatagramChannel.this.isConnected();
                do {
                    int datagramSize = EpollDatagramChannel.this.config().getMaxDatagramPayloadSize();
                    ByteBuf byteBuf = allocHandle.allocate(allocator);
                    if (Native.IS_SUPPORTING_RECVMMSG) {
                        numDatagram = datagramSize == 0 ? 1 : byteBuf.writableBytes() / datagramSize;
                    } else {
                        numDatagram = 0;
                    }
                    if (numDatagram <= 1) {
                        if (connected) {
                            try {
                                try {
                                    try {
                                        if (!config.isUdpGro()) {
                                            read = EpollDatagramChannel.this.connectedRead(allocHandle, byteBuf, datagramSize);
                                        }
                                    } catch (Throwable t) {
                                        exception = t;
                                    }
                                } finally {
                                    epollInFinally(config);
                                }
                            } catch (Errors.NativeIoException e) {
                                if (connected) {
                                    throw EpollDatagramChannel.this.translateForConnected(e);
                                }
                                throw e;
                            }
                        }
                        read = EpollDatagramChannel.this.recvmsg(allocHandle, EpollDatagramChannel.this.cleanDatagramPacketArray(), byteBuf);
                    } else {
                        read = EpollDatagramChannel.this.scatteringRead(allocHandle, EpollDatagramChannel.this.cleanDatagramPacketArray(), byteBuf, datagramSize, numDatagram);
                    }
                    if (!read) {
                        break;
                    }
                    this.readPending = false;
                } while (allocHandle.continueReading(UncheckedBooleanSupplier.TRUE_SUPPLIER));
                allocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (exception != null) {
                    pipeline.fireExceptionCaught(exception);
                }
                return;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public boolean connectedRead(EpollRecvByteAllocatorHandle allocHandle, ByteBuf byteBuf, int maxDatagramPacketSize) throws Exception {
        int localReadAmount;
        try {
            int writable = maxDatagramPacketSize != 0 ? Math.min(byteBuf.writableBytes(), maxDatagramPacketSize) : byteBuf.writableBytes();
            allocHandle.attemptedBytesRead(writable);
            int writerIndex = byteBuf.writerIndex();
            if (byteBuf.hasMemoryAddress()) {
                localReadAmount = this.socket.readAddress(byteBuf.memoryAddress(), writerIndex, writerIndex + writable);
            } else {
                ByteBuffer buf = byteBuf.internalNioBuffer(writerIndex, writable);
                localReadAmount = this.socket.read(buf, buf.position(), buf.limit());
            }
            if (localReadAmount <= 0) {
                allocHandle.lastBytesRead(localReadAmount);
                if (byteBuf != null) {
                    byteBuf.release();
                }
                return false;
            }
            byteBuf.writerIndex(writerIndex + localReadAmount);
            allocHandle.lastBytesRead(maxDatagramPacketSize <= 0 ? localReadAmount : writable);
            DatagramPacket packet = new DatagramPacket(byteBuf, localAddress(), remoteAddress());
            allocHandle.incMessagesRead(1);
            pipeline().fireChannelRead((Object) packet);
            ByteBuf byteBuf2 = null;
            if (0 != 0) {
                byteBuf2.release();
            }
            return true;
        } catch (Throwable th) {
            if (byteBuf != null) {
                byteBuf.release();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public IOException translateForConnected(Errors.NativeIoException e) {
        if (e.expectedErr() != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return e;
        }
        PortUnreachableException error = new PortUnreachableException(e.getMessage());
        error.initCause(e);
        return error;
    }

    private static void addDatagramPacketToOut(DatagramPacket packet, RecyclableArrayList out) {
        if (packet instanceof SegmentedDatagramPacket) {
            SegmentedDatagramPacket segmentedDatagramPacket = (SegmentedDatagramPacket) packet;
            ByteBuf content = (ByteBuf) segmentedDatagramPacket.content();
            InetSocketAddress recipient = segmentedDatagramPacket.recipient();
            InetSocketAddress sender = segmentedDatagramPacket.sender();
            int segmentSize = segmentedDatagramPacket.segmentSize();
            do {
                out.add(new DatagramPacket(content.readRetainedSlice(Math.min(content.readableBytes(), segmentSize)), recipient, sender));
            } while (content.isReadable());
            segmentedDatagramPacket.release();
            return;
        }
        out.add(packet);
    }

    private static void releaseAndRecycle(ByteBuf byteBuf, RecyclableArrayList packetList) {
        if (byteBuf != null) {
            byteBuf.release();
        }
        if (packetList != null) {
            for (int i = 0; i < packetList.size(); i++) {
                ReferenceCountUtil.release(packetList.get(i));
            }
            packetList.recycle();
        }
    }

    private static void processPacket(ChannelPipeline pipeline, EpollRecvByteAllocatorHandle handle, int bytesRead, DatagramPacket packet) {
        handle.lastBytesRead(bytesRead);
        handle.incMessagesRead(1);
        pipeline.fireChannelRead((Object) packet);
    }

    private static void processPacketList(ChannelPipeline pipeline, EpollRecvByteAllocatorHandle handle, int bytesRead, RecyclableArrayList packetList) {
        int messagesRead = packetList.size();
        handle.lastBytesRead(bytesRead);
        handle.incMessagesRead(messagesRead);
        for (int i = 0; i < messagesRead; i++) {
            pipeline.fireChannelRead(packetList.set(i, Unpooled.EMPTY_BUFFER));
        }
    }

    /* access modifiers changed from: private */
    public boolean recvmsg(EpollRecvByteAllocatorHandle allocHandle, NativeDatagramPacketArray array, ByteBuf byteBuf) throws IOException {
        ByteBuf byteBuf2;
        RecyclableArrayList datagramPackets = null;
        try {
            int writable = byteBuf.writableBytes();
            boolean added = array.addWritable(byteBuf, byteBuf.writerIndex(), writable);
            if ($assertionsDisabled || added) {
                allocHandle.attemptedBytesRead(writable);
                NativeDatagramPacketArray.NativeDatagramPacket msg = array.packets()[0];
                int bytesReceived = this.socket.recvmsg(msg);
                if (bytesReceived == 0) {
                    allocHandle.lastBytesRead(-1);
                    releaseAndRecycle(byteBuf, null);
                    return false;
                }
                byteBuf.writerIndex(bytesReceived);
                DatagramPacket packet = msg.newDatagramPacket(byteBuf, localAddress());
                if (!(packet instanceof SegmentedDatagramPacket)) {
                    processPacket(pipeline(), allocHandle, bytesReceived, packet);
                    byteBuf2 = null;
                } else {
                    RecyclableArrayList datagramPackets2 = RecyclableArrayList.newInstance();
                    addDatagramPacketToOut(packet, datagramPackets2);
                    byteBuf2 = null;
                    processPacketList(pipeline(), allocHandle, bytesReceived, datagramPackets2);
                    datagramPackets2.recycle();
                    datagramPackets = null;
                }
                return true;
            }
            throw new AssertionError();
        } finally {
            releaseAndRecycle(byteBuf, null);
        }
    }

    /* access modifiers changed from: private */
    public boolean scatteringRead(EpollRecvByteAllocatorHandle allocHandle, NativeDatagramPacketArray array, ByteBuf byteBuf, int datagramSize, int numDatagram) throws IOException {
        try {
            int offset = byteBuf.writerIndex();
            int i = 0;
            while (i < numDatagram && array.addWritable(byteBuf, offset, datagramSize)) {
                i++;
                offset += datagramSize;
            }
            allocHandle.attemptedBytesRead(offset - byteBuf.writerIndex());
            NativeDatagramPacketArray.NativeDatagramPacket[] packets = array.packets();
            int received = this.socket.recvmmsg(packets, 0, array.count());
            if (received == 0) {
                allocHandle.lastBytesRead(-1);
                releaseAndRecycle(byteBuf, null);
                return false;
            }
            int bytesReceived = received * datagramSize;
            byteBuf.writerIndex(bytesReceived);
            InetSocketAddress local = localAddress();
            if (received == 1) {
                DatagramPacket packet = packets[0].newDatagramPacket(byteBuf, local);
                if (!(packet instanceof SegmentedDatagramPacket)) {
                    processPacket(pipeline(), allocHandle, datagramSize, packet);
                    releaseAndRecycle(null, null);
                    return true;
                }
            }
            RecyclableArrayList datagramPackets = RecyclableArrayList.newInstance();
            for (int i2 = 0; i2 < received; i2++) {
                addDatagramPacketToOut(packets[i2].newDatagramPacket(byteBuf.readRetainedSlice(datagramSize), local), datagramPackets);
            }
            byteBuf.release();
            processPacketList(pipeline(), allocHandle, bytesReceived, datagramPackets);
            datagramPackets.recycle();
            releaseAndRecycle(null, null);
            return true;
        } catch (Throwable th) {
            releaseAndRecycle(byteBuf, null);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public NativeDatagramPacketArray cleanDatagramPacketArray() {
        return ((EpollEventLoop) eventLoop()).cleanDatagramPacketArray();
    }
}
