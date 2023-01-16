package p013io.netty.bootstrap;

import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.resolver.AddressResolverGroup;

/* renamed from: io.netty.bootstrap.BootstrapConfig */
/* loaded from: grasscutter.jar:io/netty/bootstrap/BootstrapConfig.class */
public final class BootstrapConfig extends AbstractBootstrapConfig<Bootstrap, Channel> {
    /* access modifiers changed from: package-private */
    public BootstrapConfig(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public SocketAddress remoteAddress() {
        return ((Bootstrap) this.bootstrap).remoteAddress();
    }

    public AddressResolverGroup<?> resolver() {
        return ((Bootstrap) this.bootstrap).resolver();
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder buf = new StringBuilder(toString());
        buf.setLength(buf.length() - 1);
        buf.append(", resolver: ").append(resolver());
        SocketAddress remoteAddress = remoteAddress();
        if (remoteAddress != null) {
            buf.append(", remoteAddress: ").append(remoteAddress);
        }
        return buf.append(')').toString();
    }
}
