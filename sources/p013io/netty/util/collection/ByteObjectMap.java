package p013io.netty.util.collection;

import java.util.Map;

/* renamed from: io.netty.util.collection.ByteObjectMap */
/* loaded from: grasscutter.jar:io/netty/util/collection/ByteObjectMap.class */
public interface ByteObjectMap<V> extends Map<Byte, V> {

    /* renamed from: io.netty.util.collection.ByteObjectMap$PrimitiveEntry */
    /* loaded from: grasscutter.jar:io/netty/util/collection/ByteObjectMap$PrimitiveEntry.class */
    public interface PrimitiveEntry<V> {
        byte key();

        V value();

        void setValue(V v);
    }

    V get(byte b);

    V put(byte b, V v);

    V remove(byte b);

    Iterable<PrimitiveEntry<V>> entries();

    boolean containsKey(byte b);
}
