package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.objects.Object2ShortMap;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortConsumer;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ShortMap.class */
public abstract class AbstractObject2ShortMap<K> extends AbstractObject2ShortFunction<K> implements Object2ShortMap<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        ObjectIterator<Object2ShortMap.Entry<K>> i = object2ShortEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap
    public boolean containsValue(short v) {
        ObjectIterator<Object2ShortMap.Entry<K>> i = object2ShortEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getShortValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ShortMap$BasicEntry.class */
    public static class BasicEntry<K> implements Object2ShortMap.Entry<K> {
        protected K key;
        protected short value;

        public BasicEntry() {
        }

        public BasicEntry(K key, Short value) {
            this.key = key;
            this.value = value.shortValue();
        }

        public BasicEntry(K key, short value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap.Entry
        public short getShortValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap.Entry
        public short setValue(short value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2ShortMap.Entry) {
                Object2ShortMap.Entry<K> e = (Object2ShortMap.Entry) o;
                return Objects.equals(this.key, e.getKey()) && this.value == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Short) && Objects.equals(this.key, key) && this.value == ((Short) value).shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + ((int) this.value);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ShortMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<K> extends AbstractObjectSet<Object2ShortMap.Entry<K>> {
        protected final Object2ShortMap<K> map;

        public BasicEntrySet(Object2ShortMap<K> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2ShortMap.Entry) {
                Object2ShortMap.Entry<K> e = (Object2ShortMap.Entry) o;
                K k = e.getKey();
                return this.map.containsKey(k) && this.map.getShort(k) == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k2 = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Short) && this.map.containsKey(k2) && this.map.getShort(k2) == ((Short) value).shortValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Object2ShortMap.Entry) {
                Object2ShortMap.Entry<K> e = (Object2ShortMap.Entry) o;
                return this.map.remove(e.getKey(), e.getShortValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k = e2.getKey();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Short)) {
                return false;
            }
            return this.map.remove(k, ((Short) value).shortValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Object2ShortMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
    public ObjectSet<K> keySet() {
        return new AbstractObjectSet<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return AbstractObject2ShortMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractObject2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractObject2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Object2ShortMap.Entry<K>> f2448i;

                    {
                        this.f2448i = Object2ShortMaps.fastIterator(AbstractObject2ShortMap.this);
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return this.f2448i.next().getKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2448i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2448i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.f2448i.forEachRemaining(entry -> {
                            action.accept(entry.getKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractObject2ShortMap.this), 65);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortMap, java.util.Map
    public Collection<Short> values() {
        return new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap.2
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractObject2ShortMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractObject2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractObject2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Object2ShortMap.Entry<K>> f2449i;

                    {
                        this.f2449i = Object2ShortMaps.fastIterator(AbstractObject2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f2449i.next().getShortValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2449i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2449i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f2449i.forEachRemaining(entry -> {
                            action.accept(entry.getShortValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractObject2ShortMap.this), 320);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractObject2ShortMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Short> m) {
        if (m instanceof Object2ShortMap) {
            ObjectIterator<Object2ShortMap.Entry<K>> i = Object2ShortMaps.fastIterator((Object2ShortMap) m);
            while (i.hasNext()) {
                Object2ShortMap.Entry<? extends K> e = (Object2ShortMap.Entry) i.next();
                put((AbstractObject2ShortMap<K>) e.getKey(), e.getShortValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends K, ? extends Short>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends K, ? extends Short> e2 = i2.next();
                put((AbstractObject2ShortMap<K>) e2.getKey(), (Short) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Object2ShortMap.Entry<K>> i = Object2ShortMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Object2ShortMap.Entry) i.next()).hashCode();
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
        return object2ShortEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Object2ShortMap.Entry<K>> i = Object2ShortMaps.fastIterator(this);
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
                Object2ShortMap.Entry<K> e = i.next();
                if (this == e.getKey()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getKey()));
                }
                s.append("=>");
                s.append(String.valueOf((int) e.getShortValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
