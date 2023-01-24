package p013io.netty.channel.epoll;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.channel.unix.IovArray;
import p013io.netty.channel.unix.Limits;
import p013io.netty.channel.unix.NativeInetAddress;
import p013io.netty.channel.unix.SegmentedDatagramPacket;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.epoll.NativeDatagramPacketArray */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/NativeDatagramPacketArray.class */
public final class NativeDatagramPacketArray {
    private final NativeDatagramPacket[] packets = new NativeDatagramPacket[Limits.UIO_MAX_IOV];
    private final IovArray iovArray = new IovArray();
    private final byte[] ipv4Bytes = new byte[4];
    private final MyMessageProcessor processor = new MyMessageProcessor();
    private int count;

    /* access modifiers changed from: package-private */
    public NativeDatagramPacketArray() {
        for (int i = 0; i < this.packets.length; i++) {
            this.packets[i] = new NativeDatagramPacket();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean addWritable(ByteBuf buf, int index, int len) {
        return add0(buf, index, len, 0, null);
    }

    /* access modifiers changed from: private */
    public boolean add0(ByteBuf buf, int index, int len, int segmentLen, InetSocketAddress recipient) {
        if (this.count == this.packets.length) {
            return false;
        }
        if (len == 0) {
            return true;
        }
        int offset = this.iovArray.count();
        if (offset == Limits.IOV_MAX || !this.iovArray.add(buf, index, len)) {
            return false;
        }
        this.packets[this.count].init(this.iovArray.memoryAddress(offset), this.iovArray.count() - offset, segmentLen, recipient);
        this.count++;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void add(ChannelOutboundBuffer buffer, boolean connected, int maxMessagesPerWrite) throws Exception {
        this.processor.connected = connected;
        this.processor.maxMessagesPerWrite = maxMessagesPerWrite;
        buffer.forEachFlushedMessage(this.processor);
    }

    /* access modifiers changed from: package-private */
    public int count() {
        return this.count;
    }

    /* access modifiers changed from: package-private */
    public NativeDatagramPacket[] packets() {
        return this.packets;
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.count = 0;
        this.iovArray.clear();
    }

    /* access modifiers changed from: package-private */
    public void release() {
        this.iovArray.release();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.epoll.NativeDatagramPacketArray$MyMessageProcessor */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/NativeDatagramPacketArray$MyMessageProcessor.class */
    public final class MyMessageProcessor implements ChannelOutboundBuffer.MessageProcessor {
        private boolean connected;
        private int maxMessagesPerWrite;

        private MyMessageProcessor() {
        }

        @Override // p013io.netty.channel.ChannelOutboundBuffer.MessageProcessor
        public boolean processMessage(Object msg) {
            boolean added;
            int seg;
            if (msg instanceof DatagramPacket) {
                DatagramPacket packet = (DatagramPacket) msg;
                ByteBuf buf = (ByteBuf) packet.content();
                int segmentSize = 0;
                if ((packet instanceof SegmentedDatagramPacket) && buf.readableBytes() > (seg = ((SegmentedDatagramPacket) packet).segmentSize())) {
                    segmentSize = seg;
                }
                added = NativeDatagramPacketArray.this.add0(buf, buf.readerIndex(), buf.readableBytes(), segmentSize, packet.recipient());
            } else if (!(msg instanceof ByteBuf) || !this.connected) {
                added = false;
            } else {
                ByteBuf buf2 = (ByteBuf) msg;
                added = NativeDatagramPacketArray.this.add0(buf2, buf2.readerIndex(), buf2.readableBytes(), 0, null);
            }
            if (!added) {
                return false;
            }
            this.maxMessagesPerWrite--;
            return this.maxMessagesPerWrite > 0;
        }
    }

    /* access modifiers changed from: private */
    public static InetSocketAddress newAddress(byte[] addr, int addrLen, int port, int scopeId, byte[] ipv4Bytes) throws UnknownHostException {
        InetAddress address;
        if (addrLen == ipv4Bytes.length) {
            System.arraycopy(addr, 0, ipv4Bytes, 0, addrLen);
            address = InetAddress.getByAddress(ipv4Bytes);
        } else {
            address = Inet6Address.getByAddress((String) null, addr, scopeId);
        }
        return new InetSocketAddress(address, port);
    }

    /* renamed from: io.netty.channel.epoll.NativeDatagramPacketArray$NativeDatagramPacket */
    /* loaded from: grasscutter.jar:io/netty/channel/epoll/NativeDatagramPacketArray$NativeDatagramPacket.class */
    public final class NativeDatagramPacket {
        private long memoryAddress;
        private int count;
        private int senderAddrLen;
        private int senderScopeId;
        private int senderPort;
        private int recipientAddrLen;
        private int recipientScopeId;
        private int recipientPort;
        private int segmentSize;
        private final byte[] senderAddr = new byte[16];
        private final byte[] recipientAddr = new byte[16];

        public NativeDatagramPacket() {
        }

        /* access modifiers changed from: private */
        public void init(long memoryAddress, int count, int segmentSize, InetSocketAddress recipient) {
            this.memoryAddress = memoryAddress;
            this.count = count;
            this.segmentSize = segmentSize;
            this.senderScopeId = 0;
            this.senderPort = 0;
            this.senderAddrLen = 0;
            if (recipient == null) {
                this.recipientScopeId = 0;
                this.recipientPort = 0;
                this.recipientAddrLen = 0;
                return;
            }
            InetAddress address = recipient.getAddress();
            if (address instanceof Inet6Address) {
                System.arraycopy(address.getAddress(), 0, this.recipientAddr, 0, this.recipientAddr.length);
                this.recipientScopeId = ((Inet6Address) address).getScopeId();
            } else {
                NativeInetAddress.copyIpv4MappedIpv6Address(address.getAddress(), this.recipientAddr);
                this.recipientScopeId = 0;
            }
            this.recipientAddrLen = this.recipientAddr.length;
            this.recipientPort = recipient.getPort();
        }

        /* access modifiers changed from: package-private */
        public DatagramPacket newDatagramPacket(ByteBuf buffer, InetSocketAddress recipient) throws UnknownHostException {
            InetSocketAddress sender = NativeDatagramPacketArray.newAddress(this.senderAddr, this.senderAddrLen, this.senderPort, this.senderScopeId, NativeDatagramPacketArray.this.ipv4Bytes);
            if (this.recipientAddrLen != 0) {
                recipient = NativeDatagramPacketArray.newAddress(this.recipientAddr, this.recipientAddrLen, this.recipientPort, this.recipientScopeId, NativeDatagramPacketArray.this.ipv4Bytes);
            }
            if (this.segmentSize > 0) {
                return new SegmentedDatagramPacket(buffer, this.segmentSize, recipient, sender);
            }
            return new DatagramPacket(buffer, recipient, sender);
        }
    }
}
