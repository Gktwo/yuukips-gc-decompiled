package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.Short2IntMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntMap.class */
public abstract class AbstractShort2IntMap extends AbstractShort2IntFunction implements Short2IntMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public boolean containsKey(short k) {
        ObjectIterator<Short2IntMap.Entry> i = short2IntEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getShortKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public boolean containsValue(int v) {
        ObjectIterator<Short2IntMap.Entry> i = short2IntEntrySet().iterator();
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

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap
    public final int mergeInt(short key, int value, IntBinaryOperator remappingFunction) {
        return mergeInt(key, value, (java.util.function.IntBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntMap$BasicEntry.class */
    public static class BasicEntry implements Short2IntMap.Entry {
        protected short key;
        protected int value;

        public BasicEntry() {
        }

        public BasicEntry(Short key, Integer value) {
            this.key = key.shortValue();
            this.value = value.intValue();
        }

        public BasicEntry(short key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry
        public short getShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry
        public int getIntValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap.Entry
        public int setValue(int value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2IntMap.Entry) {
                Short2IntMap.Entry e = (Short2IntMap.Entry) o;
                return this.key == e.getShortKey() && this.value == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Short) && (value = e2.getValue()) != null && (value instanceof Integer) && this.key == ((Short) key).shortValue() && this.value == ((Integer) value).intValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) this.key) + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Short2IntMap.Entry> {
        protected final Short2IntMap map;

        public BasicEntrySet(Short2IntMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2IntMap.Entry) {
                Short2IntMap.Entry e = (Short2IntMap.Entry) o;
                short k = e.getShortKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Short)) {
                return false;
            }
            short k2 = ((Short) key).shortValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Integer) && this.map.containsKey(k2) && this.map.get(k2) == ((Integer) value).intValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2IntMap.Entry) {
                Short2IntMap.Entry e = (Short2IntMap.Entry) o;
                return this.map.remove(e.getShortKey(), e.getIntValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Short)) {
                return false;
            }
            short k = ((Short) key).shortValue();
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
        public ObjectSpliterator<Short2IntMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    public Set<Short> keySet() {
        return new AbstractShortSet() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap.1
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractShort2IntMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractShort2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractShort2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Short2IntMap.Entry> f2831i;

                    {
                        this.f2831i = Short2IntMaps.fastIterator(AbstractShort2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f2831i.next().getShortKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2831i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2831i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f2831i.forEachRemaining(entry -> {
                            action.accept(entry.getShortKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractShort2IntMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntMap, java.util.Map
    public Collection<Integer> values() {
        return new AbstractIntCollection() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap.2
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractShort2IntMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractShort2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractShort2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2IntMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Short2IntMap.Entry> f2832i;

                    {
                        this.f2832i = Short2IntMaps.fastIterator(AbstractShort2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f2832i.next().getIntValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2832i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2832i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f2832i.forEachRemaining(entry -> {
                            action.accept(entry.getIntValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractShort2IntMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Short, ? extends Integer> m) {
        if (m instanceof Short2IntMap) {
            ObjectIterator<Short2IntMap.Entry> i = Short2IntMaps.fastIterator((Short2IntMap) m);
            while (i.hasNext()) {
                Short2IntMap.Entry e = i.next();
                put(e.getShortKey(), e.getIntValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Short, ? extends Integer>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Short, ? extends Integer> e2 = i2.next();
                put((Short) e2.getKey(), (Integer) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Short2IntMap.Entry> i = Short2IntMaps.fastIterator(this);
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
        return short2IntEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Short2IntMap.Entry> i = Short2IntMaps.fastIterator(this);
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
                Short2IntMap.Entry e = i.next();
                s.append(String.valueOf((int) e.getShortKey()));
                s.append("=>");
                s.append(String.valueOf(e.getIntValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
