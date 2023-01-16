package p013io.netty.resolver;

import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Promise;

/* renamed from: io.netty.resolver.NoopAddressResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/NoopAddressResolver.class */
public class NoopAddressResolver extends AbstractAddressResolver<SocketAddress> {
    public NoopAddressResolver(EventExecutor executor) {
        super(executor);
    }

    @Override // p013io.netty.resolver.AbstractAddressResolver
    protected boolean doIsResolved(SocketAddress address) {
        return true;
    }

    @Override // p013io.netty.resolver.AbstractAddressResolver
    protected void doResolve(SocketAddress unresolvedAddress, Promise<SocketAddress> promise) throws Exception {
        promise.setSuccess(unresolvedAddress);
    }

    @Override // p013io.netty.resolver.AbstractAddressResolver
    protected void doResolveAll(SocketAddress unresolvedAddress, Promise<List<SocketAddress>> promise) throws Exception {
        promise.setSuccess(Collections.singletonList(unresolvedAddress));
    }
}
