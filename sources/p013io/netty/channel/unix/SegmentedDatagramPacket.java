package p013io.netty.channel.unix;

import java.net.InetSocketAddress;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.unix.SegmentedDatagramPacket */
/* loaded from: grasscutter.jar:io/netty/channel/unix/SegmentedDatagramPacket.class */
public class SegmentedDatagramPacket extends DatagramPacket {
    private final int segmentSize;

    public SegmentedDatagramPacket(ByteBuf data, int segmentSize, InetSocketAddress recipient) {
        super(data, recipient);
        this.segmentSize = ObjectUtil.checkPositive(segmentSize, "segmentSize");
    }

    public SegmentedDatagramPacket(ByteBuf data, int segmentSize, InetSocketAddress recipient, InetSocketAddress sender) {
        super(data, recipient, sender);
        this.segmentSize = ObjectUtil.checkPositive(segmentSize, "segmentSize");
    }

    public int segmentSize() {
        return this.segmentSize;
    }

    @Override // p013io.netty.channel.socket.DatagramPacket, p013io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket copy() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).copy(), this.segmentSize, recipient(), sender());
    }

    @Override // p013io.netty.channel.socket.DatagramPacket, p013io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket duplicate() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).duplicate(), this.segmentSize, recipient(), sender());
    }

    @Override // p013io.netty.channel.socket.DatagramPacket, p013io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket retainedDuplicate() {
        return new SegmentedDatagramPacket(((ByteBuf) content()).retainedDuplicate(), this.segmentSize, recipient(), sender());
    }

    @Override // p013io.netty.channel.socket.DatagramPacket, p013io.netty.buffer.ByteBufHolder
    public SegmentedDatagramPacket replace(ByteBuf content) {
        return new SegmentedDatagramPacket(content, this.segmentSize, recipient(), sender());
    }

    @Override // p013io.netty.channel.socket.DatagramPacket, p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket retain() {
        retain();
        return this;
    }

    @Override // p013io.netty.channel.socket.DatagramPacket, p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket retain(int increment) {
        retain(increment);
        return this;
    }

    @Override // p013io.netty.channel.socket.DatagramPacket, p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket touch() {
        touch();
        return this;
    }

    @Override // p013io.netty.channel.socket.DatagramPacket, p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public SegmentedDatagramPacket touch(Object hint) {
        touch(hint);
        return this;
    }
}
