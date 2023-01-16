package p013io.netty.resolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.resolver.RoundRobinInetAddressResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/RoundRobinInetAddressResolver.class */
public class RoundRobinInetAddressResolver extends InetNameResolver {
    private final NameResolver<InetAddress> nameResolver;

    public RoundRobinInetAddressResolver(EventExecutor executor, NameResolver<InetAddress> nameResolver) {
        super(executor);
        this.nameResolver = nameResolver;
    }

    @Override // p013io.netty.resolver.SimpleNameResolver
    protected void doResolve(final String inetHost, final Promise<InetAddress> promise) throws Exception {
        this.nameResolver.resolveAll(inetHost).addListener(new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.RoundRobinInetAddressResolver.1
            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) throws Exception {
                if (future.isSuccess()) {
                    List<InetAddress> inetAddresses = future.getNow();
                    int numAddresses = inetAddresses.size();
                    if (numAddresses > 0) {
                        promise.setSuccess(inetAddresses.get(RoundRobinInetAddressResolver.randomIndex(numAddresses)));
                    } else {
                        promise.setFailure(new UnknownHostException(inetHost));
                    }
                } else {
                    promise.setFailure(future.cause());
                }
            }
        });
    }

    @Override // p013io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String inetHost, final Promise<List<InetAddress>> promise) throws Exception {
        this.nameResolver.resolveAll(inetHost).addListener(new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.RoundRobinInetAddressResolver.2
            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) throws Exception {
                if (future.isSuccess()) {
                    List<InetAddress> inetAddresses = future.getNow();
                    if (!inetAddresses.isEmpty()) {
                        ArrayList arrayList = new ArrayList(inetAddresses);
                        Collections.rotate(arrayList, RoundRobinInetAddressResolver.randomIndex(inetAddresses.size()));
                        promise.setSuccess(arrayList);
                        return;
                    }
                    promise.setSuccess(inetAddresses);
                    return;
                }
                promise.setFailure(future.cause());
            }
        });
    }

    /* access modifiers changed from: private */
    public static int randomIndex(int numAddresses) {
        if (numAddresses == 1) {
            return 0;
        }
        return PlatformDependent.threadLocalRandom().nextInt(numAddresses);
    }

    @Override // p013io.netty.resolver.SimpleNameResolver, p013io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.nameResolver.close();
    }
}
