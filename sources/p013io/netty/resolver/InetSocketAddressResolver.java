package p013io.netty.resolver;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.concurrent.Promise;

/* renamed from: io.netty.resolver.InetSocketAddressResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/InetSocketAddressResolver.class */
public class InetSocketAddressResolver extends AbstractAddressResolver<InetSocketAddress> {
    final NameResolver<InetAddress> nameResolver;

    public InetSocketAddressResolver(EventExecutor executor, NameResolver<InetAddress> nameResolver) {
        super(executor, InetSocketAddress.class);
        this.nameResolver = nameResolver;
    }

    /* access modifiers changed from: protected */
    public boolean doIsResolved(InetSocketAddress address) {
        return !address.isUnresolved();
    }

    /* access modifiers changed from: protected */
    public void doResolve(final InetSocketAddress unresolvedAddress, final Promise<InetSocketAddress> promise) throws Exception {
        this.nameResolver.resolve(unresolvedAddress.getHostName()).addListener(new FutureListener<InetAddress>() { // from class: io.netty.resolver.InetSocketAddressResolver.1
            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<InetAddress> future) throws Exception {
                if (future.isSuccess()) {
                    promise.setSuccess(new InetSocketAddress(future.getNow(), unresolvedAddress.getPort()));
                } else {
                    promise.setFailure(future.cause());
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void doResolveAll(final InetSocketAddress unresolvedAddress, final Promise<List<InetSocketAddress>> promise) throws Exception {
        this.nameResolver.resolveAll(unresolvedAddress.getHostName()).addListener(new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.InetSocketAddressResolver.2
            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) throws Exception {
                if (future.isSuccess()) {
                    List<InetAddress> inetAddresses = future.getNow();
                    ArrayList arrayList = new ArrayList(inetAddresses.size());
                    for (InetAddress inetAddress : inetAddresses) {
                        arrayList.add(new InetSocketAddress(inetAddress, unresolvedAddress.getPort()));
                    }
                    promise.setSuccess(arrayList);
                    return;
                }
                promise.setFailure(future.cause());
            }
        });
    }

    @Override // p013io.netty.resolver.AbstractAddressResolver, p013io.netty.resolver.AddressResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.nameResolver.close();
    }
}
