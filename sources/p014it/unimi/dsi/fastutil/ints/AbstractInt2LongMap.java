package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.Int2LongMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongBinaryOperator;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongMap.class */
public abstract class AbstractInt2LongMap extends AbstractInt2LongFunction implements Int2LongMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction, p014it.unimi.dsi.fastutil.ints.Int2LongMap
    public boolean containsKey(int k) {
        ObjectIterator<Int2LongMap.Entry> i = int2LongEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getIntKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap
    public boolean containsValue(long v) {
        ObjectIterator<Int2LongMap.Entry> i = int2LongEntrySet().iterator();
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap
    public final long mergeLong(int key, long value, LongBinaryOperator remappingFunction) {
        return mergeLong(key, value, (java.util.function.LongBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongMap$BasicEntry.class */
    public static class BasicEntry implements Int2LongMap.Entry {
        protected int key;
        protected long value;

        public BasicEntry() {
        }

        public BasicEntry(Integer key, Long value) {
            this.key = key.intValue();
            this.value = value.longValue();
        }

        public BasicEntry(int key, long value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap.Entry
        public int getIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap.Entry
        public long getLongValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap.Entry
        public long setValue(long value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2LongMap.Entry) {
                Int2LongMap.Entry e = (Int2LongMap.Entry) o;
                return this.key == e.getIntKey() && this.value == e.getLongValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Integer) && (value = e2.getValue()) != null && (value instanceof Long) && this.key == ((Integer) key).intValue() && this.value == ((Long) value).longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ HashCommon.long2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Int2LongMap.Entry> {
        protected final Int2LongMap map;

        public BasicEntrySet(Int2LongMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2LongMap.Entry) {
                Int2LongMap.Entry e = (Int2LongMap.Entry) o;
                int k = e.getIntKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getLongValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Integer)) {
                return false;
            }
            int k2 = ((Integer) key).intValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Long) && this.map.containsKey(k2) && this.map.get(k2) == ((Long) value).longValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2LongMap.Entry) {
                Int2LongMap.Entry e = (Int2LongMap.Entry) o;
                return this.map.remove(e.getIntKey(), e.getLongValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Integer)) {
                return false;
            }
            int k = ((Integer) key).intValue();
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
        public ObjectSpliterator<Int2LongMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    public Set<Integer> keySet() {
        return new AbstractIntSet() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2LongMap.1
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractInt2LongMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractInt2LongMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractInt2LongMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2LongMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Int2LongMap.Entry> f1963i;

                    {
                        this.f1963i = Int2LongMaps.fastIterator(AbstractInt2LongMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f1963i.next().getIntKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1963i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1963i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f1963i.forEachRemaining(entry -> {
                            action.accept(entry.getIntKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractInt2LongMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongMap, java.util.Map
    public Collection<Long> values() {
        return new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2LongMap.2
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long k) {
                return AbstractInt2LongMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractInt2LongMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractInt2LongMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return new LongIterator() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2LongMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Int2LongMap.Entry> f1964i;

                    {
                        this.f1964i = Int2LongMaps.fastIterator(AbstractInt2LongMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                    public long nextLong() {
                        return this.f1964i.next().getLongValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1964i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1964i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfLong
                    public void forEachRemaining(LongConsumer action) {
                        this.f1964i.forEachRemaining(entry -> {
                            action.accept(entry.getLongValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongSpliterator spliterator() {
                return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractInt2LongMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends Long> m) {
        if (m instanceof Int2LongMap) {
            ObjectIterator<Int2LongMap.Entry> i = Int2LongMaps.fastIterator((Int2LongMap) m);
            while (i.hasNext()) {
                Int2LongMap.Entry e = i.next();
                put(e.getIntKey(), e.getLongValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Integer, ? extends Long>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Integer, ? extends Long> e2 = i2.next();
                put((Integer) e2.getKey(), (Long) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Int2LongMap.Entry> i = Int2LongMaps.fastIterator(this);
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
        return int2LongEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Int2LongMap.Entry> i = Int2LongMaps.fastIterator(this);
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
                Int2LongMap.Entry e = i.next();
                s.append(String.valueOf(e.getIntKey()));
                s.append("=>");
                s.append(String.valueOf(e.getLongValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
