package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.longs.Long2ShortMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortConsumer;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ShortMap.class */
public abstract class AbstractLong2ShortMap extends AbstractLong2ShortFunction implements Long2ShortMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortFunction, p014it.unimi.dsi.fastutil.longs.Long2ShortMap
    public boolean containsKey(long k) {
        ObjectIterator<Long2ShortMap.Entry> i = long2ShortEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getLongKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap
    public boolean containsValue(short v) {
        ObjectIterator<Long2ShortMap.Entry> i = long2ShortEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ShortMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ShortMap$BasicEntry.class */
    public static class BasicEntry implements Long2ShortMap.Entry {
        protected long key;
        protected short value;

        public BasicEntry() {
        }

        public BasicEntry(Long key, Short value) {
            this.key = key.longValue();
            this.value = value.shortValue();
        }

        public BasicEntry(long key, short value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap.Entry
        public long getLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap.Entry
        public short getShortValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap.Entry
        public short setValue(short value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2ShortMap.Entry) {
                Long2ShortMap.Entry e = (Long2ShortMap.Entry) o;
                return this.key == e.getLongKey() && this.value == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Long) && (value = e2.getValue()) != null && (value instanceof Short) && this.key == ((Long) key).longValue() && this.value == ((Short) value).shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + ((int) this.value);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ShortMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ShortMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Long2ShortMap.Entry> {
        protected final Long2ShortMap map;

        public BasicEntrySet(Long2ShortMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2ShortMap.Entry) {
                Long2ShortMap.Entry e = (Long2ShortMap.Entry) o;
                long k = e.getLongKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Long)) {
                return false;
            }
            long k2 = ((Long) key).longValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Short) && this.map.containsKey(k2) && this.map.get(k2) == ((Short) value).shortValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2ShortMap.Entry) {
                Long2ShortMap.Entry e = (Long2ShortMap.Entry) o;
                return this.map.remove(e.getLongKey(), e.getShortValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Long)) {
                return false;
            }
            long k = ((Long) key).longValue();
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
        public ObjectSpliterator<Long2ShortMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
    public Set<Long> keySet() {
        return new AbstractLongSet() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2ShortMap.1
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long k) {
                return AbstractLong2ShortMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractLong2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractLong2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return new LongIterator() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2ShortMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Long2ShortMap.Entry> f2217i;

                    {
                        this.f2217i = Long2ShortMaps.fastIterator(AbstractLong2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                    public long nextLong() {
                        return this.f2217i.next().getLongKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2217i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2217i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfLong
                    public void forEachRemaining(LongConsumer action) {
                        this.f2217i.forEachRemaining(entry -> {
                            action.accept(entry.getLongKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongSpliterator spliterator() {
                return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractLong2ShortMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2ShortMap, java.util.Map
    public Collection<Short> values() {
        return new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2ShortMap.2
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractLong2ShortMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractLong2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractLong2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2ShortMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Long2ShortMap.Entry> f2218i;

                    {
                        this.f2218i = Long2ShortMaps.fastIterator(AbstractLong2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f2218i.next().getShortValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2218i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2218i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f2218i.forEachRemaining(entry -> {
                            action.accept(entry.getShortValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractLong2ShortMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Long, ? extends Short> m) {
        if (m instanceof Long2ShortMap) {
            ObjectIterator<Long2ShortMap.Entry> i = Long2ShortMaps.fastIterator((Long2ShortMap) m);
            while (i.hasNext()) {
                Long2ShortMap.Entry e = i.next();
                put(e.getLongKey(), e.getShortValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Long, ? extends Short>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Long, ? extends Short> e2 = i2.next();
                put((Long) e2.getKey(), (Short) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Long2ShortMap.Entry> i = Long2ShortMaps.fastIterator(this);
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
        return long2ShortEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Long2ShortMap.Entry> i = Long2ShortMaps.fastIterator(this);
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
                Long2ShortMap.Entry e = i.next();
                s.append(String.valueOf(e.getLongKey()));
                s.append("=>");
                s.append(String.valueOf((int) e.getShortValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
