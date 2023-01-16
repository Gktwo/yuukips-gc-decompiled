package p013io.netty.util.collection;

import java.util.Map;

/* renamed from: io.netty.util.collection.ShortObjectMap */
/* loaded from: grasscutter.jar:io/netty/util/collection/ShortObjectMap.class */
public interface ShortObjectMap<V> extends Map<Short, V> {

    /* renamed from: io.netty.util.collection.ShortObjectMap$PrimitiveEntry */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ShortObjectMap$PrimitiveEntry.class */
    public interface PrimitiveEntry<V> {
        short key();

        V value();

        void setValue(V v);
    }

    V get(short s);

    V put(short s, V v);

    V remove(short s);

    Iterable<PrimitiveEntry<V>> entries();

    boolean containsKey(short s);
}
