package p013io.netty.resolver;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import p013io.netty.util.concurrent.EventExecutor;

/* renamed from: io.netty.resolver.InetNameResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/InetNameResolver.class */
public abstract class InetNameResolver extends SimpleNameResolver<InetAddress> {
    private volatile AddressResolver<InetSocketAddress> addressResolver;

    /* access modifiers changed from: protected */
    public InetNameResolver(EventExecutor executor) {
        super(executor);
    }

    public AddressResolver<InetSocketAddress> asAddressResolver() {
        AddressResolver<InetSocketAddress> result = this.addressResolver;
        if (result == null) {
            synchronized (this) {
                result = this.addressResolver;
                if (result == null) {
                    AddressResolver<InetSocketAddress> inetSocketAddressResolver = new InetSocketAddressResolver(executor(), this);
                    result = inetSocketAddressResolver;
                    this.addressResolver = inetSocketAddressResolver;
                }
            }
        }
        return result;
    }
}
