package p013io.netty.resolver;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.List;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.Promise;

/* renamed from: io.netty.resolver.AddressResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/AddressResolver.class */
public interface AddressResolver<T extends SocketAddress> extends Closeable {
    boolean isSupported(SocketAddress socketAddress);

    boolean isResolved(SocketAddress socketAddress);

    Future<T> resolve(SocketAddress socketAddress);

    Future<T> resolve(SocketAddress socketAddress, Promise<T> promise);

    Future<List<T>> resolveAll(SocketAddress socketAddress);

    Future<List<T>> resolveAll(SocketAddress socketAddress, Promise<List<T>> promise);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
