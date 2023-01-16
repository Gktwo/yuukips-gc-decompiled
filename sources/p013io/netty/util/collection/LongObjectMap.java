package p013io.netty.util.collection;

import java.util.Map;

/* renamed from: io.netty.util.collection.LongObjectMap */
/* loaded from: grasscutter.jar:io/netty/util/collection/LongObjectMap.class */
public interface LongObjectMap<V> extends Map<Long, V> {

    /* renamed from: io.netty.util.collection.LongObjectMap$PrimitiveEntry */
    /* loaded from: grasscutter.jar:io/netty/util/collection/LongObjectMap$PrimitiveEntry.class */
    public interface PrimitiveEntry<V> {
        long key();

        V value();

        void setValue(V v);
    }

    V get(long j);

    V put(long j, V v);

    V remove(long j);

    Iterable<PrimitiveEntry<V>> entries();

    boolean containsKey(long j);
}
