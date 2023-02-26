package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ReferenceMap.class */
public abstract class AbstractReference2ReferenceMap<K, V> extends AbstractReference2ReferenceFunction<K, V> implements Reference2ReferenceMap<K, V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        ObjectIterator<Reference2ReferenceMap.Entry<K, V>> i = reference2ReferenceEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object v) {
        ObjectIterator<Reference2ReferenceMap.Entry<K, V>> i = reference2ReferenceEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ReferenceMap$BasicEntry.class */
    public static class BasicEntry<K, V> implements Reference2ReferenceMap.Entry<K, V> {
        protected K key;
        protected V value;

        public BasicEntry() {
        }

        public BasicEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2ReferenceMap.Entry) {
                Reference2ReferenceMap.Entry<K, V> e = (Reference2ReferenceMap.Entry) o;
                return this.key == e.getKey() && this.value == e.getValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            return this.key == e2.getKey() && this.value == e2.getValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this.key) ^ (this.value == null ? 0 : System.identityHashCode(this.value));
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ReferenceMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<K, V> extends AbstractObjectSet<Reference2ReferenceMap.Entry<K, V>> {
        protected final Reference2ReferenceMap<K, V> map;

        public BasicEntrySet(Reference2ReferenceMap<K, V> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2ReferenceMap.Entry) {
                Reference2ReferenceMap.Entry<K, V> e = (Reference2ReferenceMap.Entry) o;
                K k = e.getKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k2 = e2.getKey();
            return this.map.containsKey(k2) && this.map.get(k2) == e2.getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2ReferenceMap.Entry) {
                Reference2ReferenceMap.Entry<K, V> e = (Reference2ReferenceMap.Entry) o;
                return this.map.remove(e.getKey(), e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            return this.map.remove(e2.getKey(), e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Reference2ReferenceMap.Entry<K, V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public ReferenceSet<K> keySet() {
        return new AbstractReferenceSet<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return AbstractReference2ReferenceMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractReference2ReferenceMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractReference2ReferenceMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Reference2ReferenceMap.Entry<K, V>> f2490i;

                    {
                        this.f2490i = Reference2ReferenceMaps.fastIterator(AbstractReference2ReferenceMap.this);
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return this.f2490i.next().getKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2490i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2490i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.f2490i.forEachRemaining(entry -> {
                            action.accept(entry.getKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractReference2ReferenceMap.this), 65);
            }
        };
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        return new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap.2
            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object k) {
                return AbstractReference2ReferenceMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractReference2ReferenceMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractReference2ReferenceMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Reference2ReferenceMap.Entry<K, V>> f2491i;

                    {
                        this.f2491i = Reference2ReferenceMaps.fastIterator(AbstractReference2ReferenceMap.this);
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.f2491i.next().getValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2491i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2491i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super V> action) {
                        this.f2491i.forEachRemaining(entry -> {
                            action.accept(entry.getValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<V> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractReference2ReferenceMap.this), 64);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractReference2ReferenceMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        if (m instanceof Reference2ReferenceMap) {
            ObjectIterator<Reference2ReferenceMap.Entry<K, V>> i = Reference2ReferenceMaps.fastIterator((Reference2ReferenceMap) m);
            while (i.hasNext()) {
                Reference2ReferenceMap.Entry<? extends K, ? extends V> e = (Reference2ReferenceMap.Entry) i.next();
                put(e.getKey(), e.getValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends K, ? extends V> e2 = i2.next();
                put(e2.getKey(), e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Reference2ReferenceMap.Entry<K, V>> i = Reference2ReferenceMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Reference2ReferenceMap.Entry) i.next()).hashCode();
        }
    }

    @Override // java.lang.Object, java.util.Map
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map)) {
            return false;
        }
        Map<?, ?> m = (Map) o;
        if (m.size() != size()) {
            return false;
        }
        return reference2ReferenceEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Reference2ReferenceMap.Entry<K, V>> i = Reference2ReferenceMaps.fastIterator(this);
        int n = size();
        boolean first = true;
        s.append("{");
        while (true) {
            n--;
            if (n != 0) {
                if (first) {
                    first = false;
                } else {
                    s.append(", ");
                }
                Reference2ReferenceMap.Entry<K, V> e = i.next();
                if (this == e.getKey()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getKey()));
                }
                s.append("=>");
                if (this == e.getValue()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getValue()));
                }
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
