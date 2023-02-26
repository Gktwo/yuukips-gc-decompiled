package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.longs.Long2LongMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2LongMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2LongMap.class */
public abstract class AbstractLong2LongMap extends AbstractLong2LongFunction implements Long2LongMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction, p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public boolean containsKey(long k) {
        ObjectIterator<Long2LongMap.Entry> i = long2LongEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getLongKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public boolean containsValue(long v) {
        ObjectIterator<Long2LongMap.Entry> i = long2LongEntrySet().iterator();
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

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public final long mergeLong(long key, long value, LongBinaryOperator remappingFunction) {
        return mergeLong(key, value, (LongBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2LongMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2LongMap$BasicEntry.class */
    public static class BasicEntry implements Long2LongMap.Entry {
        protected long key;
        protected long value;

        public BasicEntry() {
        }

        public BasicEntry(Long key, Long value) {
            this.key = key.longValue();
            this.value = value.longValue();
        }

        public BasicEntry(long key, long value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry
        public long getLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry
        public long getLongValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry
        public long setValue(long value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2LongMap.Entry) {
                Long2LongMap.Entry e = (Long2LongMap.Entry) o;
                return this.key == e.getLongKey() && this.value == e.getLongValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Long) && (value = e2.getValue()) != null && (value instanceof Long) && this.key == ((Long) key).longValue() && this.value == ((Long) value).longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ HashCommon.long2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2LongMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2LongMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Long2LongMap.Entry> {
        protected final Long2LongMap map;

        public BasicEntrySet(Long2LongMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2LongMap.Entry) {
                Long2LongMap.Entry e = (Long2LongMap.Entry) o;
                long k = e.getLongKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getLongValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Long)) {
                return false;
            }
            long k2 = ((Long) key).longValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Long) && this.map.containsKey(k2) && this.map.get(k2) == ((Long) value).longValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2LongMap.Entry) {
                Long2LongMap.Entry e = (Long2LongMap.Entry) o;
                return this.map.remove(e.getLongKey(), e.getLongValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Long)) {
                return false;
            }
            long k = ((Long) key).longValue();
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
        public ObjectSpliterator<Long2LongMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    public Set<Long> keySet() {
        return new AbstractLongSet() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2LongMap.1
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long k) {
                return AbstractLong2LongMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractLong2LongMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractLong2LongMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return new LongIterator() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2LongMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Long2LongMap.Entry> f2205i;

                    {
                        this.f2205i = Long2LongMaps.fastIterator(AbstractLong2LongMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                    public long nextLong() {
                        return this.f2205i.next().getLongKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2205i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2205i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfLong
                    public void forEachRemaining(LongConsumer action) {
                        this.f2205i.forEachRemaining(entry -> {
                            action.accept(entry.getLongKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongSpliterator spliterator() {
                return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractLong2LongMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    public Collection<Long> values() {
        return new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2LongMap.2
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long k) {
                return AbstractLong2LongMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractLong2LongMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractLong2LongMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return new LongIterator() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2LongMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Long2LongMap.Entry> f2206i;

                    {
                        this.f2206i = Long2LongMaps.fastIterator(AbstractLong2LongMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                    public long nextLong() {
                        return this.f2206i.next().getLongValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2206i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2206i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfLong
                    public void forEachRemaining(LongConsumer action) {
                        this.f2206i.forEachRemaining(entry -> {
                            action.accept(entry.getLongValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongSpliterator spliterator() {
                return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractLong2LongMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Long, ? extends Long> m) {
        if (m instanceof Long2LongMap) {
            ObjectIterator<Long2LongMap.Entry> i = Long2LongMaps.fastIterator((Long2LongMap) m);
            while (i.hasNext()) {
                Long2LongMap.Entry e = i.next();
                put(e.getLongKey(), e.getLongValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Long, ? extends Long>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Long, ? extends Long> e2 = i2.next();
                put((Long) e2.getKey(), (Long) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Long2LongMap.Entry> i = Long2LongMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += i.next().hashCode();
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
        return long2LongEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Long2LongMap.Entry> i = Long2LongMaps.fastIterator(this);
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
                Long2LongMap.Entry e = i.next();
                s.append(String.valueOf(e.getLongKey()));
                s.append("=>");
                s.append(String.valueOf(e.getLongValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
