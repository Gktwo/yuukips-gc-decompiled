package p013io.netty.resolver;

import java.io.Closeable;
import java.util.List;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.Promise;

/* renamed from: io.netty.resolver.NameResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/NameResolver.class */
public interface NameResolver<T> extends Closeable {
    Future<T> resolve(String str);

    Future<T> resolve(String str, Promise<T> promise);

    Future<List<T>> resolveAll(String str);

    Future<List<T>> resolveAll(String str, Promise<List<T>> promise);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
