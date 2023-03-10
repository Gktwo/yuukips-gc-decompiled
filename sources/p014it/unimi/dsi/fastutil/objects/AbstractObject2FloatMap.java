package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatConsumer;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterator;
import p014it.unimi.dsi.fastutil.floats.FloatSpliterators;
import p014it.unimi.dsi.fastutil.objects.Object2FloatMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatMap.class */
public abstract class AbstractObject2FloatMap<K> extends AbstractObject2FloatFunction<K> implements Object2FloatMap<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        ObjectIterator<Object2FloatMap.Entry<K>> i = object2FloatEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap
    public boolean containsValue(float v) {
        ObjectIterator<Object2FloatMap.Entry<K>> i = object2FloatEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getFloatValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatMap$BasicEntry.class */
    public static class BasicEntry<K> implements Object2FloatMap.Entry<K> {
        protected K key;
        protected float value;

        public BasicEntry() {
        }

        public BasicEntry(K key, Float value) {
            this.key = key;
            this.value = value.floatValue();
        }

        public BasicEntry(K key, float value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap.Entry
        public float getFloatValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap.Entry
        public float setValue(float value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2FloatMap.Entry) {
                Object2FloatMap.Entry<K> e = (Object2FloatMap.Entry) o;
                return Objects.equals(this.key, e.getKey()) && Float.floatToIntBits(this.value) == Float.floatToIntBits(e.getFloatValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Float) && Objects.equals(this.key, key) && Float.floatToIntBits(this.value) == Float.floatToIntBits(((Float) value).floatValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ HashCommon.float2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<K> extends AbstractObjectSet<Object2FloatMap.Entry<K>> {
        protected final Object2FloatMap<K> map;

        public BasicEntrySet(Object2FloatMap<K> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2FloatMap.Entry) {
                Object2FloatMap.Entry<K> e = (Object2FloatMap.Entry) o;
                K k = e.getKey();
                return this.map.containsKey(k) && Float.floatToIntBits(this.map.getFloat(k)) == Float.floatToIntBits(e.getFloatValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k2 = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Float) && this.map.containsKey(k2) && Float.floatToIntBits(this.map.getFloat(k2)) == Float.floatToIntBits(((Float) value).floatValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2FloatMap.Entry) {
                Object2FloatMap.Entry<K> e = (Object2FloatMap.Entry) o;
                return this.map.remove(e.getKey(), e.getFloatValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k = e2.getKey();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Float)) {
                return false;
            }
            return this.map.remove(k, ((Float) value).floatValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2FloatMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
    public ObjectSet<K> keySet() {
        return new AbstractObjectSet<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return AbstractObject2FloatMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractObject2FloatMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractObject2FloatMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Object2FloatMap.Entry<K>> f2428i;

                    {
                        this.f2428i = Object2FloatMaps.fastIterator(AbstractObject2FloatMap.this);
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return this.f2428i.next().getKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2428i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2428i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.f2428i.forEachRemaining(entry -> {
                            action.accept(entry.getKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractObject2FloatMap.this), 65);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatMap, java.util.Map
    public Collection<Float> values() {
        return new AbstractFloatCollection() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap.2
            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
            public boolean contains(float k) {
                return AbstractObject2FloatMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractObject2FloatMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractObject2FloatMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatIterator iterator() {
                return new FloatIterator() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Object2FloatMap.Entry<K>> f2429i;

                    {
                        this.f2429i = Object2FloatMaps.fastIterator(AbstractObject2FloatMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public float nextFloat() {
                        return this.f2429i.next().getFloatValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2429i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2429i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public void forEachRemaining(FloatConsumer action) {
                        this.f2429i.forEachRemaining(entry -> {
                            action.accept(entry.getFloatValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatSpliterator spliterator() {
                return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractObject2FloatMap.this), 320);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractObject2FloatMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Float> m) {
        if (m instanceof Object2FloatMap) {
            ObjectIterator<Object2FloatMap.Entry<K>> i = Object2FloatMaps.fastIterator((Object2FloatMap) m);
            while (i.hasNext()) {
                Object2FloatMap.Entry<? extends K> e = (Object2FloatMap.Entry) i.next();
                put((AbstractObject2FloatMap<K>) e.getKey(), e.getFloatValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends K, ? extends Float>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends K, ? extends Float> e2 = i2.next();
                put((AbstractObject2FloatMap<K>) e2.getKey(), (Float) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Object2FloatMap.Entry<K>> i = Object2FloatMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Object2FloatMap.Entry) i.next()).hashCode();
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
        return object2FloatEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Object2FloatMap.Entry<K>> i = Object2FloatMaps.fastIterator(this);
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
                Object2FloatMap.Entry<K> e = i.next();
                if (this == e.getKey()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getKey()));
                }
                s.append("=>");
                s.append(String.valueOf(e.getFloatValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
