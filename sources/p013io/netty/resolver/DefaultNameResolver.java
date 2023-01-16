package p013io.netty.resolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.SocketUtils;

/* renamed from: io.netty.resolver.DefaultNameResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/DefaultNameResolver.class */
public class DefaultNameResolver extends InetNameResolver {
    public DefaultNameResolver(EventExecutor executor) {
        super(executor);
    }

    @Override // p013io.netty.resolver.SimpleNameResolver
    protected void doResolve(String inetHost, Promise<InetAddress> promise) throws Exception {
        try {
            promise.setSuccess(SocketUtils.addressByName(inetHost));
        } catch (UnknownHostException e) {
            promise.setFailure(e);
        }
    }

    @Override // p013io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String inetHost, Promise<List<InetAddress>> promise) throws Exception {
        try {
            promise.setSuccess(Arrays.asList(SocketUtils.allAddressesByName(inetHost)));
        } catch (UnknownHostException e) {
            promise.setFailure(e);
        }
    }
}
