package p013io.netty.resolver;

import java.net.InetSocketAddress;
import p013io.netty.util.concurrent.EventExecutor;

/* renamed from: io.netty.resolver.DefaultAddressResolverGroup */
/* loaded from: grasscutter.jar:io/netty/resolver/DefaultAddressResolverGroup.class */
public final class DefaultAddressResolverGroup extends AddressResolverGroup<InetSocketAddress> {
    public static final DefaultAddressResolverGroup INSTANCE = new DefaultAddressResolverGroup();

    private DefaultAddressResolverGroup() {
    }

    @Override // p013io.netty.resolver.AddressResolverGroup
    protected AddressResolver<InetSocketAddress> newResolver(EventExecutor executor) throws Exception {
        return new DefaultNameResolver(executor).asAddressResolver();
    }
}
