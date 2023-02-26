package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectMap.class */
public abstract class AbstractFloat2ObjectMap<V> extends AbstractFloat2ObjectFunction<V> implements Float2ObjectMap<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction, p014it.unimi.dsi.fastutil.floats.Float2ObjectMap
    public boolean containsKey(float k) {
        ObjectIterator<Float2ObjectMap.Entry<V>> i = float2ObjectEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getFloatKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object v) {
        ObjectIterator<Float2ObjectMap.Entry<V>> i = float2ObjectEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectMap$BasicEntry.class */
    public static class BasicEntry<V> implements Float2ObjectMap.Entry<V> {
        protected float key;
        protected V value;

        public BasicEntry() {
        }

        public BasicEntry(Float key, V value) {
            this.key = key.floatValue();
            this.value = value;
        }

        public BasicEntry(float key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap.Entry
        public float getFloatKey() {
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
            if (o instanceof Float2ObjectMap.Entry) {
                Float2ObjectMap.Entry<V> e = (Float2ObjectMap.Entry) o;
                return Float.floatToIntBits(this.key) == Float.floatToIntBits(e.getFloatKey()) && Objects.equals(this.value, e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(((Float) key).floatValue()) && Objects.equals(this.value, e2.getValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ (this.value == null ? 0 : this.value.hashCode());
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<V> extends AbstractObjectSet<Float2ObjectMap.Entry<V>> {
        protected final Float2ObjectMap<V> map;

        public BasicEntrySet(Float2ObjectMap<V> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2ObjectMap.Entry) {
                Float2ObjectMap.Entry<V> e = (Float2ObjectMap.Entry) o;
                float k = e.getFloatKey();
                return this.map.containsKey(k) && Objects.equals(this.map.get(k), e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k2 = ((Float) key).floatValue();
            return this.map.containsKey(k2) && Objects.equals(this.map.get(k2), e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2ObjectMap.Entry) {
                Float2ObjectMap.Entry<V> e = (Float2ObjectMap.Entry) o;
                return this.map.remove(e.getFloatKey(), e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            return this.map.remove(((Float) key).floatValue(), e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Float2ObjectMap.Entry<V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
    public Set<Float> keySet() {
        return new AbstractFloatSet() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap.1
            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
            public boolean contains(float k) {
                return AbstractFloat2ObjectMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractFloat2ObjectMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractFloat2ObjectMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatIterator iterator() {
                return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2ObjectMap.Entry<V>> f1746i;

                    {
                        this.f1746i = Float2ObjectMaps.fastIterator(AbstractFloat2ObjectMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public float nextFloat() {
                        return this.f1746i.next().getFloatKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1746i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1746i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public void forEachRemaining(FloatConsumer action) {
                        this.f1746i.forEachRemaining(entry -> {
                            action.accept(entry.getFloatKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatSpliterator spliterator() {
                return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2ObjectMap.this), 321);
            }
        };
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        return new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap.2
            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object k) {
                return AbstractFloat2ObjectMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractFloat2ObjectMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractFloat2ObjectMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2ObjectMap.Entry<V>> f1747i;

                    {
                        this.f1747i = Float2ObjectMaps.fastIterator(AbstractFloat2ObjectMap.this);
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.f1747i.next().getValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1747i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1747i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super V> action) {
                        this.f1747i.forEachRemaining(entry -> {
                            action.accept(entry.getValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<V> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2ObjectMap.this), 64);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectMap<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends Float, ? extends V> m) {
        if (m instanceof Float2ObjectMap) {
            ObjectIterator<Float2ObjectMap.Entry<V>> i = Float2ObjectMaps.fastIterator((Float2ObjectMap) m);
            while (i.hasNext()) {
                Float2ObjectMap.Entry<? extends V> e = (Float2ObjectMap.Entry) i.next();
                put(e.getFloatKey(), (float) e.getValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Float, ? extends V>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Float, ? extends V> e2 = i2.next();
                put((Float) e2.getKey(), (Float) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Float2ObjectMap.Entry<V>> i = Float2ObjectMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Float2ObjectMap.Entry) i.next()).hashCode();
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
        return float2ObjectEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Float2ObjectMap.Entry<V>> i = Float2ObjectMaps.fastIterator(this);
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
                Float2ObjectMap.Entry<V> e = i.next();
                s.append(String.valueOf(e.getFloatKey()));
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
