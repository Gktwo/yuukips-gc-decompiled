package p013io.netty.resolver;

import java.net.SocketAddress;
import p013io.netty.util.concurrent.EventExecutor;

/* renamed from: io.netty.resolver.NoopAddressResolverGroup */
/* loaded from: grasscutter.jar:io/netty/resolver/NoopAddressResolverGroup.class */
public final class NoopAddressResolverGroup extends AddressResolverGroup<SocketAddress> {
    public static final NoopAddressResolverGroup INSTANCE = new NoopAddressResolverGroup();

    private NoopAddressResolverGroup() {
    }

    @Override // p013io.netty.resolver.AddressResolverGroup
    protected AddressResolver<SocketAddress> newResolver(EventExecutor executor) throws Exception {
        return new NoopAddressResolver(executor);
    }
}
