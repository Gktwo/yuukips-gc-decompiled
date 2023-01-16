package p013io.netty.channel.socket;

import java.net.InetSocketAddress;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufHolder;
import p013io.netty.channel.DefaultAddressedEnvelope;

/* renamed from: io.netty.channel.socket.DatagramPacket */
/* loaded from: grasscutter.jar:io/netty/channel/socket/DatagramPacket.class */
public class DatagramPacket extends DefaultAddressedEnvelope<ByteBuf, InetSocketAddress> implements ByteBufHolder {
    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope
    public /* bridge */ /* synthetic */ ByteBuf content() {
        return content();
    }

    public DatagramPacket(ByteBuf data, InetSocketAddress recipient) {
        super(data, recipient);
    }

    public DatagramPacket(ByteBuf data, InetSocketAddress recipient, InetSocketAddress sender) {
        super(data, recipient, sender);
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public DatagramPacket copy() {
        return replace(((ByteBuf) content()).copy());
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public DatagramPacket duplicate() {
        return replace(((ByteBuf) content()).duplicate());
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public DatagramPacket retainedDuplicate() {
        return replace(((ByteBuf) content()).retainedDuplicate());
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public DatagramPacket replace(ByteBuf content) {
        return new DatagramPacket(content, recipient(), sender());
    }

    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public DatagramPacket retain() {
        retain();
        return this;
    }

    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public DatagramPacket retain(int increment) {
        retain(increment);
        return this;
    }

    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public DatagramPacket touch() {
        touch();
        return this;
    }

    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public DatagramPacket touch(Object hint) {
        touch(hint);
        return this;
    }
}
