package p013io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.codec.serialization.ReferenceMap */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/ReferenceMap.class */
public abstract class ReferenceMap<K, V> implements Map<K, V> {
    private final Map<K, Reference<V>> delegate;

    abstract Reference<V> fold(V v);

    /* access modifiers changed from: protected */
    public ReferenceMap(Map<K, Reference<V>> delegate) {
        this.delegate = delegate;
    }

    private V unfold(Reference<V> ref) {
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V get(Object key) {
        return unfold(this.delegate.get(key));
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        return unfold(this.delegate.put(key, fold(value)));
    }

    @Override // java.util.Map
    public V remove(Object key) {
        return unfold(this.delegate.remove(key));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.netty.handler.codec.serialization.ReferenceMap<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.util.Map<K, java.lang.ref.Reference<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            this.delegate.put(entry.getKey(), fold(entry.getValue()));
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.delegate.keySet();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
