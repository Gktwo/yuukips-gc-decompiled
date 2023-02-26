package p014it.unimi.dsi.fastutil.longs;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2BooleanMap.class */
public abstract class AbstractLong2BooleanMap extends AbstractLong2BooleanFunction implements Long2BooleanMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction, p014it.unimi.dsi.fastutil.longs.Long2BooleanMap
    public boolean containsKey(long k) {
        ObjectIterator<Long2BooleanMap.Entry> i = long2BooleanEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getLongKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap
    public boolean containsValue(boolean v) {
        ObjectIterator<Long2BooleanMap.Entry> i = long2BooleanEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getBooleanValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2BooleanMap$BasicEntry.class */
    public static class BasicEntry implements Long2BooleanMap.Entry {
        protected long key;
        protected boolean value;

        public BasicEntry() {
        }

        public BasicEntry(Long key, Boolean value) {
            this.key = key.longValue();
            this.value = value.booleanValue();
        }

        public BasicEntry(long key, boolean value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap.Entry
        public long getLongKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap.Entry
        public boolean getBooleanValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap.Entry
        public boolean setValue(boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2BooleanMap.Entry) {
                Long2BooleanMap.Entry e = (Long2BooleanMap.Entry) o;
                return this.key == e.getLongKey() && this.value == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Long) && (value = e2.getValue()) != null && (value instanceof Boolean) && this.key == ((Long) key).longValue() && this.value == ((Boolean) value).booleanValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ (this.value ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2BooleanMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Long2BooleanMap.Entry> {
        protected final Long2BooleanMap map;

        public BasicEntrySet(Long2BooleanMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2BooleanMap.Entry) {
                Long2BooleanMap.Entry e = (Long2BooleanMap.Entry) o;
                long k = e.getLongKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Long)) {
                return false;
            }
            long k2 = ((Long) key).longValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Boolean) && this.map.containsKey(k2) && this.map.get(k2) == ((Boolean) value).booleanValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Long2BooleanMap.Entry) {
                Long2BooleanMap.Entry e = (Long2BooleanMap.Entry) o;
                return this.map.remove(e.getLongKey(), e.getBooleanValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Long)) {
                return false;
            }
            long k = ((Long) key).longValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Boolean)) {
                return false;
            }
            return this.map.remove(k, ((Boolean) value).booleanValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Long2BooleanMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
    public Set<Long> keySet() {
        return new AbstractLongSet() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap.1
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long k) {
                return AbstractLong2BooleanMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractLong2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractLong2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return new LongIterator() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Long2BooleanMap.Entry> f2181i;

                    {
                        this.f2181i = Long2BooleanMaps.fastIterator(AbstractLong2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                    public long nextLong() {
                        return this.f2181i.next().getLongKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2181i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2181i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfLong
                    public void forEachRemaining(LongConsumer action) {
                        this.f2181i.forEachRemaining(entry -> {
                            action.accept(entry.getLongKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongSpliterator spliterator() {
                return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractLong2BooleanMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2BooleanMap, java.util.Map
    public Collection<Boolean> values() {
        return new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap.2
            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
            public boolean contains(boolean k) {
                return AbstractLong2BooleanMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractLong2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractLong2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanIterator iterator() {
                return new BooleanIterator() { // from class: it.unimi.dsi.fastutil.longs.AbstractLong2BooleanMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Long2BooleanMap.Entry> f2182i;

                    {
                        this.f2182i = Long2BooleanMaps.fastIterator(AbstractLong2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public boolean nextBoolean() {
                        return this.f2182i.next().getBooleanValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2182i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2182i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public void forEachRemaining(BooleanConsumer action) {
                        this.f2182i.forEachRemaining(entry -> {
                            action.accept(entry.getBooleanValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanSpliterator spliterator() {
                return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractLong2BooleanMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Long, ? extends Boolean> m) {
        if (m instanceof Long2BooleanMap) {
            ObjectIterator<Long2BooleanMap.Entry> i = Long2BooleanMaps.fastIterator((Long2BooleanMap) m);
            while (i.hasNext()) {
                Long2BooleanMap.Entry e = i.next();
                put(e.getLongKey(), e.getBooleanValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Long, ? extends Boolean>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Long, ? extends Boolean> e2 = i2.next();
                put((Long) e2.getKey(), (Boolean) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Long2BooleanMap.Entry> i = Long2BooleanMaps.fastIterator(this);
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
        return long2BooleanEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Long2BooleanMap.Entry> i = Long2BooleanMaps.fastIterator(this);
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
                Long2BooleanMap.Entry e = i.next();
                s.append(String.valueOf(e.getLongKey()));
                s.append("=>");
                s.append(String.valueOf(e.getBooleanValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
