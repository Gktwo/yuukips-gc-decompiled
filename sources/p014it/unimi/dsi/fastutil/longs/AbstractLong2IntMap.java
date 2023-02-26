package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.longs.Long2IntMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2IntMap.class */
public abstract class AbstractLong2IntMap extends AbstractLong2IntFunction implements Long2IntMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction, p014it.unimi.dsi.fastutil.longs.Long2IntMap
    public boolean containsKey(long k) {
        ObjectIterator<Long2IntMap.Entry> i = long2IntEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getLongKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap
    public boolean containsValue(int v) {
        ObjectIterator<Long2IntMap.Entry> i = long2IntEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getIntValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap
    public final int mergeInt(long key, int value, IntBinaryOperator remappingFunction) {
        return mergeInt(key, value, (java.util.function.IntBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2IntMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2IntMap$BasicEntry.class */
    public static class BasicEntry implements Long2IntMap.Entry {
        protected long key;
        protected int value;

        public BasicEntry() {
        }

        public BasicEntry(Long key, Integer value) {
            this.key = key.longValue();
            this.value = value.intValue();
        }

        public BasicEntry(long key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap.Entry
        public long getLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap.Entry
        public int getIntValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap.Entry
        public int setValue(int value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2IntMap.Entry) {
                Long2IntMap.Entry e = (Long2IntMap.Entry) o;
                return this.key == e.getLongKey() && this.value == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Long) && (value = e2.getValue()) != null && (value instanceof Integer) && this.key == ((Long) key).longValue() && this.value == ((Integer) value).intValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2IntMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2IntMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Long2IntMap.Entry> {
        protected final Long2IntMap map;

        public BasicEntrySet(Long2IntMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2IntMap.Entry) {
                Long2IntMap.Entry e = (Long2IntMap.Entry) o;
                long k = e.getLongKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Long)) {
                return false;
            }
            long k2 = ((Long) key).longValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Integer) && this.map.containsKey(k2) && this.map.get(k2) == ((Integer) value).intValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2IntMap.Entry) {
                Long2IntMap.Entry e = (Long2IntMap.Entry) o;
                return this.map.remove(e.getLongKey(), e.getIntValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Long)) {
                return false;
            }
            long k = ((Long) key).longValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Integer)) {
                return false;
            }
            return this.map.remove(k, ((Integer) value).intValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Long2IntMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap, java.util.Map
    public Set<Long> keySet() {
        return new AbstractLongSet() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2IntMap.1
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long k) {
                return AbstractLong2IntMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractLong2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractLong2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return new LongIterator() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2IntMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Long2IntMap.Entry> f2201i;

                    {
                        this.f2201i = Long2IntMaps.fastIterator(AbstractLong2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                    public long nextLong() {
                        return this.f2201i.next().getLongKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2201i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2201i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfLong
                    public void forEachRemaining(LongConsumer action) {
                        this.f2201i.forEachRemaining(entry -> {
                            action.accept(entry.getLongKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongSpliterator spliterator() {
                return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractLong2IntMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap, java.util.Map
    public Collection<Integer> values() {
        return new AbstractIntCollection() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2IntMap.2
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractLong2IntMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractLong2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractLong2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2IntMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Long2IntMap.Entry> f2202i;

                    {
                        this.f2202i = Long2IntMaps.fastIterator(AbstractLong2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f2202i.next().getIntValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2202i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2202i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f2202i.forEachRemaining(entry -> {
                            action.accept(entry.getIntValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractLong2IntMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Long, ? extends Integer> m) {
        if (m instanceof Long2IntMap) {
            ObjectIterator<Long2IntMap.Entry> i = Long2IntMaps.fastIterator((Long2IntMap) m);
            while (i.hasNext()) {
                Long2IntMap.Entry e = i.next();
                put(e.getLongKey(), e.getIntValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Long, ? extends Integer>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Long, ? extends Integer> e2 = i2.next();
                put((Long) e2.getKey(), (Integer) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Long2IntMap.Entry> i = Long2IntMaps.fastIterator(this);
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
        return long2IntEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Long2IntMap.Entry> i = Long2IntMaps.fastIterator(this);
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
                Long2IntMap.Entry e = i.next();
                s.append(String.valueOf(e.getLongKey()));
                s.append("=>");
                s.append(String.valueOf(e.getIntValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
