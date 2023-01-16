package p013io.netty.util.collection;

import java.util.Map;

/* renamed from: io.netty.util.collection.IntObjectMap */
/* loaded from: grasscutter.jar:io/netty/util/collection/IntObjectMap.class */
public interface IntObjectMap<V> extends Map<Integer, V> {

    /* renamed from: io.netty.util.collection.IntObjectMap$PrimitiveEntry */
    /* loaded from: grasscutter.jar:io/netty/util/collection/IntObjectMap$PrimitiveEntry.class */
    public interface PrimitiveEntry<V> {
        int key();

        V value();

        void setValue(V v);
    }

    V get(int i);

    V put(int i, V v);

    V remove(int i);

    Iterable<PrimitiveEntry<V>> entries();

    boolean containsKey(int i);
}
