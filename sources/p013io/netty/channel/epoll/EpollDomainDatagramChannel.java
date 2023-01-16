package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.AddressedEnvelope;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.DefaultAddressedEnvelope;
import p013io.netty.channel.epoll.AbstractEpollChannel;
import p013io.netty.channel.unix.DomainDatagramChannel;
import p013io.netty.channel.unix.DomainDatagramPacket;
import p013io.netty.channel.unix.DomainSocketAddress;
import p013io.netty.channel.unix.IovArray;
import p013io.netty.channel.unix.PeerCredentials;
import p013io.netty.channel.unix.UnixChannelUtil;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.channel.epoll.EpollDomainDatagramChannel */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollDomainDatagramChannel.class */
public final class EpollDomainDatagramChannel extends AbstractEpollChannel implements DomainDatagramChannel {
    private static final ChannelMetadata METADATA;
    private static final String EXPECTED_TYPES;
    private volatile boolean connected;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;
    private final EpollDomainDatagramChannelConfig config;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return isOpen();
    }

    static {
        $assertionsDisabled = !EpollDomainDatagramChannel.class.desiredAssertionStatus();
        METADATA = new ChannelMetadata(true);
        EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DomainDatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + '<' + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DomainSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';
    }

    public EpollDomainDatagramChannel() {
        this(LinuxSocket.newSocketDomainDgram(), false);
    }

    public EpollDomainDatagramChannel(int fd) {
        this(new LinuxSocket(fd), true);
    }

    private EpollDomainDatagramChannel(LinuxSocket socket, boolean active) {
        super((Channel) null, socket, active);
        this.config = new EpollDomainDatagramChannelConfig(this);
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public EpollDomainDatagramChannelConfig config() {
        return this.config;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doBind(SocketAddress localAddress) throws Exception {
        doBind(localAddress);
        this.local = (DomainSocketAddress) localAddress;
        this.active = true;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        doClose();
        this.active = false;
        this.connected = false;
        this.local = null;
        this.remote = null;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel
    public boolean doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (!doConnect(remoteAddress, localAddress)) {
            return false;
        }
        if (localAddress != null) {
            this.local = (DomainSocketAddress) localAddress;
        }
        this.remote = (DomainSocketAddress) remoteAddress;
        this.connected = true;
        return true;
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        Object msg;
        boolean done;
        int maxMessagesPerWrite = maxMessagesPerWrite();
        while (maxMessagesPerWrite > 0 && (msg = in.current()) != null) {
            try {
                done = false;
                int i = config().getWriteSpinCount();
                while (true) {
                    if (i <= 0) {
                        break;
                    } else if (doWriteMessage(msg)) {
                        done = true;
                        break;
                    } else {
                        i--;
                    }
                }
            } catch (IOException e) {
                maxMessagesPerWrite--;
                in.remove(e);
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
        DomainSocketAddress remoteAddress;
        ByteBuf data;
        long writtenBytes;
        if (msg instanceof AddressedEnvelope) {
            AddressedEnvelope<ByteBuf, DomainSocketAddress> envelope = (AddressedEnvelope) msg;
            data = envelope.content();
            remoteAddress = envelope.recipient();
        } else {
            data = (ByteBuf) msg;
            remoteAddress = null;
        }
        if (data.readableBytes() == 0) {
            return true;
        }
        if (data.hasMemoryAddress()) {
            long memoryAddress = data.memoryAddress();
            if (remoteAddress == null) {
                writtenBytes = (long) this.socket.writeAddress(memoryAddress, data.readerIndex(), data.writerIndex());
            } else {
                writtenBytes = (long) this.socket.sendToAddressDomainSocket(memoryAddress, data.readerIndex(), data.writerIndex(), remoteAddress.path().getBytes(CharsetUtil.UTF_8));
            }
        } else if (data.nioBufferCount() > 1) {
            IovArray array = ((EpollEventLoop) eventLoop()).cleanIovArray();
            array.add(data, data.readerIndex(), data.readableBytes());
            int cnt = array.count();
            if (!$assertionsDisabled && cnt == 0) {
                throw new AssertionError();
            } else if (remoteAddress == null) {
                writtenBytes = this.socket.writevAddresses(array.memoryAddress(0), cnt);
            } else {
                writtenBytes = (long) this.socket.sendToAddressesDomainSocket(array.memoryAddress(0), cnt, remoteAddress.path().getBytes(CharsetUtil.UTF_8));
            }
        } else {
            ByteBuffer nioData = data.internalNioBuffer(data.readerIndex(), data.readableBytes());
            if (remoteAddress == null) {
                writtenBytes = (long) this.socket.write(nioData, nioData.position(), nioData.limit());
            } else {
                writtenBytes = (long) this.socket.sendToDomainSocket(nioData, nioData.position(), nioData.limit(), remoteAddress.path().getBytes(CharsetUtil.UTF_8));
            }
        }
        return writtenBytes > 0;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object msg) {
        if (msg instanceof DomainDatagramPacket) {
            DomainDatagramPacket packet = (DomainDatagramPacket) msg;
            ByteBuf content = (ByteBuf) packet.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(content) ? new DomainDatagramPacket(newDirectBuffer(packet, content), packet.recipient()) : msg;
        } else if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            return UnixChannelUtil.isBufferCopyNeededForWrite(buf) ? newDirectBuffer(buf) : buf;
        } else {
            if (msg instanceof AddressedEnvelope) {
                AddressedEnvelope<Object, SocketAddress> e = (AddressedEnvelope) msg;
                if ((e.content() instanceof ByteBuf) && (e.recipient() == null || (e.recipient() instanceof DomainSocketAddress))) {
                    ByteBuf content2 = (ByteBuf) e.content();
                    return UnixChannelUtil.isBufferCopyNeededForWrite(content2) ? new DefaultAddressedEnvelope(newDirectBuffer(e, content2), (DomainSocketAddress) e.recipient()) : e;
                }
            }
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(msg) + EXPECTED_TYPES);
        }
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    @Override // p013io.netty.channel.unix.DomainDatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) localAddress();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDomainDatagramChannelUnsafe();
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) remoteAddress();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.epoll.AbstractEpollChannel, p013io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.epoll.EpollDomainDatagramChannel$EpollDomainDatagramChannelUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollDomainDatagramChannel$EpollDomainDatagramChannelUnsafe.class */
    public final class EpollDomainDatagramChannelUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled;

        EpollDomainDatagramChannelUnsafe() {
            super();
        }

        static {
            $assertionsDisabled = !EpollDomainDatagramChannel.class.desiredAssertionStatus();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x017e A[EDGE_INSN: B:49:0x017e->B:34:0x017e ?: BREAK  , SYNTHETIC] */
        @Override // p013io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void epollInReady() {
            /*
            // Method dump skipped, instructions count: 446
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.epoll.EpollDomainDatagramChannel.EpollDomainDatagramChannelUnsafe.epollInReady():void");
        }
    }
}
