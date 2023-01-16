package p013io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;

/* renamed from: io.netty.handler.codec.serialization.SoftReferenceMap */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/SoftReferenceMap.class */
final class SoftReferenceMap<K, V> extends ReferenceMap<K, V> {
    /* access modifiers changed from: package-private */
    public SoftReferenceMap(Map<K, Reference<V>> delegate) {
        super(delegate);
    }

    @Override // p013io.netty.handler.codec.serialization.ReferenceMap
    Reference<V> fold(V value) {
        return new SoftReference(value);
    }
}
