package p013io.netty.channel.embedded;

import java.net.SocketAddress;

/* renamed from: io.netty.channel.embedded.EmbeddedSocketAddress */
/* loaded from: grasscutter.jar:io/netty/channel/embedded/EmbeddedSocketAddress.class */
final class EmbeddedSocketAddress extends SocketAddress {
    private static final long serialVersionUID = 1400788804624980619L;

    @Override // java.lang.Object
    public String toString() {
        return "embedded";
    }
}
