package p013io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: io.netty.handler.codec.serialization.WeakReferenceMap */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/WeakReferenceMap.class */
final class WeakReferenceMap<K, V> extends ReferenceMap<K, V> {
    /* access modifiers changed from: package-private */
    public WeakReferenceMap(Map<K, Reference<V>> delegate) {
        super(delegate);
    }

    @Override // p013io.netty.handler.codec.serialization.ReferenceMap
    Reference<V> fold(V value) {
        return new WeakReference(value);
    }
}
