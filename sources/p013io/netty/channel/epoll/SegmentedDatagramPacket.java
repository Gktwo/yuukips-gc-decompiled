package p013io.netty.channel.epoll;

import java.net.InetSocketAddress;
import p013io.netty.buffer.ByteBuf;

@Deprecated
/* renamed from: io.netty.channel.epoll.SegmentedDatagramPacket */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/SegmentedDatagramPacket.class */
public final class SegmentedDatagramPacket extends p013io.netty.channel.unix.SegmentedDatagramPacket {
    public SegmentedDatagramPacket(ByteBuf data, int segmentSize, InetSocketAddress recipient) {
        super(data, segmentSize, recipient);
        checkIsSupported();
    }

    public SegmentedDatagramPacket(ByteBuf data, int segmentSize, InetSocketAddress recipient, InetSocketAddress sender) {
        super(data, segmentSize, recipient, sender);
        checkIsSupported();
    }

    public static boolean isSupported() {
        return Epoll.isAvailable() && Native.IS_SUPPORTING_SENDMMSG && Native.IS_SUPPORTING_UDP_SEGMENT;
    }

    @Override // p013io.netty.channel.unix.SegmentedDatagramPacket, p013io.netty.channel.socket.DatagramPacket, p013io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket copy() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).copy(), segmentSize(), recipient(), sender());
    }

    @Override // p013io.netty.channel.unix.SegmentedDatagramPacket, p013io.netty.channel.socket.DatagramPacket, p013io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket duplicate() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).duplicate(), segmentSize(), recipient(), sender());
    }

    @Override // p013io.netty.channel.unix.SegmentedDatagramPacket, p013io.netty.channel.socket.DatagramPacket, p013io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket retainedDuplicate() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).retainedDuplicate(), segmentSize(), recipient(), sender());
    }

    @Override // p013io.netty.channel.unix.SegmentedDatagramPacket, p013io.netty.channel.socket.DatagramPacket, p013io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket replace(ByteBuf content) {
        return new SegmentedDatagramPacket(content, segmentSize(), recipient(), sender());
    }

    @Override // p013io.netty.channel.unix.SegmentedDatagramPacket, p013io.netty.channel.socket.DatagramPacket, p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket retain() {
        retain();
        return this;
    }

    @Override // p013io.netty.channel.unix.SegmentedDatagramPacket, p013io.netty.channel.socket.DatagramPacket, p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket retain(int increment) {
        retain(increment);
        return this;
    }

    @Override // p013io.netty.channel.unix.SegmentedDatagramPacket, p013io.netty.channel.socket.DatagramPacket, p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket touch() {
        touch();
        return this;
    }

    @Override // p013io.netty.channel.unix.SegmentedDatagramPacket, p013io.netty.channel.socket.DatagramPacket, p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket touch(Object hint) {
        touch(hint);
        return this;
    }

    private static void checkIsSupported() {
        if (!isSupported()) {
            throw new IllegalStateException();
        }
    }
}
