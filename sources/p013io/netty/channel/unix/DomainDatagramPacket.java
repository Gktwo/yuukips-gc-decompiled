package p013io.netty.channel.unix;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufHolder;
import p013io.netty.channel.DefaultAddressedEnvelope;

/* renamed from: io.netty.channel.unix.DomainDatagramPacket */
/* loaded from: grasscutter.jar:io/netty/channel/unix/DomainDatagramPacket.class */
public final class DomainDatagramPacket extends DefaultAddressedEnvelope<ByteBuf, DomainSocketAddress> implements ByteBufHolder {
    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope
    public /* bridge */ /* synthetic */ ByteBuf content() {
        return content();
    }

    public DomainDatagramPacket(ByteBuf data, DomainSocketAddress recipient) {
        super(data, recipient);
    }

    public DomainDatagramPacket(ByteBuf data, DomainSocketAddress recipient, DomainSocketAddress sender) {
        super(data, recipient, sender);
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public DomainDatagramPacket copy() {
        return replace(((ByteBuf) content()).copy());
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public DomainDatagramPacket duplicate() {
        return replace(((ByteBuf) content()).duplicate());
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public DomainDatagramPacket replace(ByteBuf content) {
        return new DomainDatagramPacket(content, recipient(), sender());
    }

    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public DomainDatagramPacket retain() {
        retain();
        return this;
    }

    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public DomainDatagramPacket retain(int increment) {
        retain(increment);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public DomainDatagramPacket retainedDuplicate() {
        return replace(((ByteBuf) content()).retainedDuplicate());
    }

    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public DomainDatagramPacket touch() {
        touch();
        return this;
    }

    @Override // p013io.netty.channel.DefaultAddressedEnvelope, p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public DomainDatagramPacket touch(Object hint) {
        touch(hint);
        return this;
    }
}
