package p013io.netty.channel.unix;

import p013io.netty.util.CharsetUtil;

/* renamed from: io.netty.channel.unix.DomainDatagramSocketAddress */
/* loaded from: grasscutter.jar:io/netty/channel/unix/DomainDatagramSocketAddress.class */
public final class DomainDatagramSocketAddress extends DomainSocketAddress {
    private static final long serialVersionUID = -5925732678737768223L;
    private final DomainDatagramSocketAddress localAddress;
    private final int receivedAmount;

    public DomainDatagramSocketAddress(byte[] socketPath, int receivedAmount, DomainDatagramSocketAddress localAddress) {
        super(new String(socketPath, CharsetUtil.UTF_8));
        this.localAddress = localAddress;
        this.receivedAmount = receivedAmount;
    }

    public DomainDatagramSocketAddress localAddress() {
        return this.localAddress;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }
}
