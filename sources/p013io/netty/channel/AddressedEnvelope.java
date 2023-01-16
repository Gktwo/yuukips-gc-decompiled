package p013io.netty.channel;

import java.net.SocketAddress;
import p013io.netty.util.ReferenceCounted;

/* renamed from: io.netty.channel.AddressedEnvelope */
/* loaded from: grasscutter.jar:io/netty/channel/AddressedEnvelope.class */
public interface AddressedEnvelope<M, A extends SocketAddress> extends ReferenceCounted {
    M content();

    A sender();

    A recipient();

    @Override // p013io.netty.util.ReferenceCounted
    AddressedEnvelope<M, A> retain();

    @Override // p013io.netty.util.ReferenceCounted
    AddressedEnvelope<M, A> retain(int i);

    @Override // p013io.netty.util.ReferenceCounted
    AddressedEnvelope<M, A> touch();

    @Override // p013io.netty.util.ReferenceCounted
    AddressedEnvelope<M, A> touch(Object obj);
}
