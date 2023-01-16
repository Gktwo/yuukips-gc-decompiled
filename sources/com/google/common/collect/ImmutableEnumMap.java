package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableEnumMap.class */
public final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final transient EnumMap<K, V> delegate;

    /* access modifiers changed from: package-private */
    public static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> map) {
        switch (map.size()) {
            case 0:
                return ImmutableMap.m1419of();
            case 1:
                Map.Entry<K, V> entry = (Map.Entry) Iterables.getOnlyElement(map.entrySet());
                return ImmutableMap.m1418of(entry.getKey(), (Object) entry.getValue());
            default:
                return new ImmutableEnumMap(map);
        }
    }

    private ImmutableEnumMap(EnumMap<K, V> delegate) {
        this.delegate = delegate;
        Preconditions.checkArgument(!delegate.isEmpty());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public UnmodifiableIterator<K> keyIterator() {
        return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public Spliterator<K> keySpliterator() {
        return this.delegate.keySet().spliterator();
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object key) {
        return this.delegate.get(key);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.lang.Object
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ImmutableEnumMap) {
            object = ((ImmutableEnumMap) object).delegate;
        }
        return this.delegate.equals(object);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return CollectSpliterators.map(this.delegate.entrySet().spliterator(), Maps::unmodifiableEntry);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> action) {
        this.delegate.forEach(action);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableEnumMap$EnumSerializedForm.class */
    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        final EnumMap<K, V> delegate;
        private static final long serialVersionUID = 0;

        EnumSerializedForm(EnumMap<K, V> delegate) {
            this.delegate = delegate;
        }

        Object readResolve() {
            return new ImmutableEnumMap(this.delegate);
        }
    }
}
