package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.ints.Int2IntMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2IntMap.class */
public abstract class AbstractInt2IntMap extends AbstractInt2IntFunction implements Int2IntMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntFunction, p014it.unimi.dsi.fastutil.ints.Int2IntMap
    public boolean containsKey(int k) {
        ObjectIterator<Int2IntMap.Entry> i = int2IntEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getIntKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap
    public boolean containsValue(int v) {
        ObjectIterator<Int2IntMap.Entry> i = int2IntEntrySet().iterator();
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

    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap
    public final int mergeInt(int key, int value, IntBinaryOperator remappingFunction) {
        return mergeInt(key, value, (IntBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2IntMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2IntMap$BasicEntry.class */
    public static class BasicEntry implements Int2IntMap.Entry {
        protected int key;
        protected int value;

        public BasicEntry() {
        }

        public BasicEntry(Integer key, Integer value) {
            this.key = key.intValue();
            this.value = value.intValue();
        }

        public BasicEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap.Entry
        public int getIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap.Entry
        public int getIntValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap.Entry
        public int setValue(int value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2IntMap.Entry) {
                Int2IntMap.Entry e = (Int2IntMap.Entry) o;
                return this.key == e.getIntKey() && this.value == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Integer) && (value = e2.getValue()) != null && (value instanceof Integer) && this.key == ((Integer) key).intValue() && this.value == ((Integer) value).intValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2IntMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2IntMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Int2IntMap.Entry> {
        protected final Int2IntMap map;

        public BasicEntrySet(Int2IntMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2IntMap.Entry) {
                Int2IntMap.Entry e = (Int2IntMap.Entry) o;
                int k = e.getIntKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Integer)) {
                return false;
            }
            int k2 = ((Integer) key).intValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Integer) && this.map.containsKey(k2) && this.map.get(k2) == ((Integer) value).intValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2IntMap.Entry) {
                Int2IntMap.Entry e = (Int2IntMap.Entry) o;
                return this.map.remove(e.getIntKey(), e.getIntValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Integer)) {
                return false;
            }
            int k = ((Integer) key).intValue();
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
        public ObjectSpliterator<Int2IntMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
    public Set<Integer> keySet() {
        return new AbstractIntSet() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2IntMap.1
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractInt2IntMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractInt2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractInt2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2IntMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Int2IntMap.Entry> f1959i;

                    {
                        this.f1959i = Int2IntMaps.fastIterator(AbstractInt2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f1959i.next().getIntKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1959i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1959i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f1959i.forEachRemaining(entry -> {
                            action.accept(entry.getIntKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractInt2IntMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap, java.util.Map
    public Collection<Integer> values() {
        return new AbstractIntCollection() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2IntMap.2
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractInt2IntMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractInt2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractInt2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2IntMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Int2IntMap.Entry> f1960i;

                    {
                        this.f1960i = Int2IntMaps.fastIterator(AbstractInt2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f1960i.next().getIntValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1960i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1960i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f1960i.forEachRemaining(entry -> {
                            action.accept(entry.getIntValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractInt2IntMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends Integer> m) {
        if (m instanceof Int2IntMap) {
            ObjectIterator<Int2IntMap.Entry> i = Int2IntMaps.fastIterator((Int2IntMap) m);
            while (i.hasNext()) {
                Int2IntMap.Entry e = i.next();
                put(e.getIntKey(), e.getIntValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Integer, ? extends Integer>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Integer, ? extends Integer> e2 = i2.next();
                put((Integer) e2.getKey(), (Integer) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Int2IntMap.Entry> i = Int2IntMaps.fastIterator(this);
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
        return int2IntEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Int2IntMap.Entry> i = Int2IntMaps.fastIterator(this);
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
                Int2IntMap.Entry e = i.next();
                s.append(String.valueOf(e.getIntKey()));
                s.append("=>");
                s.append(String.valueOf(e.getIntValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
