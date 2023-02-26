package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongBinaryOperator;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.Object2LongMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2LongMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2LongMap.class */
public abstract class AbstractObject2LongMap<K> extends AbstractObject2LongFunction<K> implements Object2LongMap<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        ObjectIterator<Object2LongMap.Entry<K>> i = object2LongEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public boolean containsValue(long v) {
        ObjectIterator<Object2LongMap.Entry<K>> i = object2LongEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getLongValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap
    public final long mergeLong(K key, long value, LongBinaryOperator remappingFunction) {
        return mergeLong((AbstractObject2LongMap<K>) key, value, (java.util.function.LongBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2LongMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2LongMap$BasicEntry.class */
    public static class BasicEntry<K> implements Object2LongMap.Entry<K> {
        protected K key;
        protected long value;

        public BasicEntry() {
        }

        public BasicEntry(K key, Long value) {
            this.key = key;
            this.value = value.longValue();
        }

        public BasicEntry(K key, long value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap.Entry
        public long getLongValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap.Entry
        public long setValue(long value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2LongMap.Entry) {
                Object2LongMap.Entry<K> e = (Object2LongMap.Entry) o;
                return Objects.equals(this.key, e.getKey()) && this.value == e.getLongValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Long) && Objects.equals(this.key, key) && this.value == ((Long) value).longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ HashCommon.long2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2LongMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2LongMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<K> extends AbstractObjectSet<Object2LongMap.Entry<K>> {
        protected final Object2LongMap<K> map;

        public BasicEntrySet(Object2LongMap<K> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2LongMap.Entry) {
                Object2LongMap.Entry<K> e = (Object2LongMap.Entry) o;
                K k = e.getKey();
                return this.map.containsKey(k) && this.map.getLong(k) == e.getLongValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k2 = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Long) && this.map.containsKey(k2) && this.map.getLong(k2) == ((Long) value).longValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2LongMap.Entry) {
                Object2LongMap.Entry<K> e = (Object2LongMap.Entry) o;
                return this.map.remove(e.getKey(), e.getLongValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k = e2.getKey();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Long)) {
                return false;
            }
            return this.map.remove(k, ((Long) value).longValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2LongMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
    public ObjectSet<K> keySet() {
        return new AbstractObjectSet<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2LongMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return AbstractObject2LongMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractObject2LongMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractObject2LongMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2LongMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Object2LongMap.Entry<K>> f2436i;

                    {
                        this.f2436i = Object2LongMaps.fastIterator(AbstractObject2LongMap.this);
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return this.f2436i.next().getKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2436i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2436i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.f2436i.forEachRemaining(entry -> {
                            action.accept(entry.getKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractObject2LongMap.this), 65);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongMap, java.util.Map
    public Collection<Long> values() {
        return new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2LongMap.2
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long k) {
                return AbstractObject2LongMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractObject2LongMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractObject2LongMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return new LongIterator() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2LongMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Object2LongMap.Entry<K>> f2437i;

                    {
                        this.f2437i = Object2LongMaps.fastIterator(AbstractObject2LongMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                    public long nextLong() {
                        return this.f2437i.next().getLongValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2437i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2437i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfLong
                    public void forEachRemaining(LongConsumer action) {
                        this.f2437i.forEachRemaining(entry -> {
                            action.accept(entry.getLongValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongSpliterator spliterator() {
                return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractObject2LongMap.this), 320);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractObject2LongMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Long> m) {
        if (m instanceof Object2LongMap) {
            ObjectIterator<Object2LongMap.Entry<K>> i = Object2LongMaps.fastIterator((Object2LongMap) m);
            while (i.hasNext()) {
                Object2LongMap.Entry<? extends K> e = (Object2LongMap.Entry) i.next();
                put((AbstractObject2LongMap<K>) e.getKey(), e.getLongValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends K, ? extends Long>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends K, ? extends Long> e2 = i2.next();
                put((AbstractObject2LongMap<K>) e2.getKey(), (Long) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Object2LongMap.Entry<K>> i = Object2LongMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Object2LongMap.Entry) i.next()).hashCode();
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
        return object2LongEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Object2LongMap.Entry<K>> i = Object2LongMaps.fastIterator(this);
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
                Object2LongMap.Entry<K> e = i.next();
                if (this == e.getKey()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getKey()));
                }
                s.append("=>");
                s.append(String.valueOf(e.getLongValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
