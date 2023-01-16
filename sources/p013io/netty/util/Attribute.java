package p013io.netty.util;

/* renamed from: io.netty.util.Attribute */
/* loaded from: grasscutter.jar:io/netty/util/Attribute.class */
public interface Attribute<T> {
    AttributeKey<T> key();

    T get();

    void set(T t);

    T getAndSet(T t);

    T setIfAbsent(T t);

    @Deprecated
    T getAndRemove();

    boolean compareAndSet(T t, T t2);

    @Deprecated
    void remove();
}
