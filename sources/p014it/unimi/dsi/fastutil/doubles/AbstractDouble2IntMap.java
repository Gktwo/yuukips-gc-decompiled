package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.Double2IntMap;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2IntMap.class */
public abstract class AbstractDouble2IntMap extends AbstractDouble2IntFunction implements Double2IntMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntFunction, p014it.unimi.dsi.fastutil.doubles.Double2IntMap
    public boolean containsKey(double k) {
        ObjectIterator<Double2IntMap.Entry> i = double2IntEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getDoubleKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap
    public boolean containsValue(int v) {
        ObjectIterator<Double2IntMap.Entry> i = double2IntEntrySet().iterator();
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

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap
    public final int mergeInt(double key, int value, IntBinaryOperator remappingFunction) {
        return mergeInt(key, value, (java.util.function.IntBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2IntMap$BasicEntry.class */
    public static class BasicEntry implements Double2IntMap.Entry {
        protected double key;
        protected int value;

        public BasicEntry() {
        }

        public BasicEntry(Double key, Integer value) {
            this.key = key.doubleValue();
            this.value = value.intValue();
        }

        public BasicEntry(double key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap.Entry
        public double getDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap.Entry
        public int getIntValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap.Entry
        public int setValue(int value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2IntMap.Entry) {
                Double2IntMap.Entry e = (Double2IntMap.Entry) o;
                return Double.doubleToLongBits(this.key) == Double.doubleToLongBits(e.getDoubleKey()) && this.value == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Double) && (value = e2.getValue()) != null && (value instanceof Integer) && Double.doubleToLongBits(this.key) == Double.doubleToLongBits(((Double) key).doubleValue()) && this.value == ((Integer) value).intValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.double2int(this.key) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2IntMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Double2IntMap.Entry> {
        protected final Double2IntMap map;

        public BasicEntrySet(Double2IntMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2IntMap.Entry) {
                Double2IntMap.Entry e = (Double2IntMap.Entry) o;
                double k = e.getDoubleKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k2 = ((Double) key).doubleValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Integer) && this.map.containsKey(k2) && this.map.get(k2) == ((Integer) value).intValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2IntMap.Entry) {
                Double2IntMap.Entry e = (Double2IntMap.Entry) o;
                return this.map.remove(e.getDoubleKey(), e.getIntValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k = ((Double) key).doubleValue();
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
        public ObjectSpliterator<Double2IntMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
    public Set<Double> keySet() {
        return new AbstractDoubleSet() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap.1
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractDouble2IntMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractDouble2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractDouble2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2IntMap.Entry> f1517i;

                    {
                        this.f1517i = Double2IntMaps.fastIterator(AbstractDouble2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f1517i.next().getDoubleKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1517i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1517i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f1517i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2IntMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntMap, java.util.Map
    public Collection<Integer> values() {
        return new AbstractIntCollection() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap.2
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractDouble2IntMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractDouble2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractDouble2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2IntMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2IntMap.Entry> f1518i;

                    {
                        this.f1518i = Double2IntMaps.fastIterator(AbstractDouble2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f1518i.next().getIntValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1518i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1518i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f1518i.forEachRemaining(entry -> {
                            action.accept(entry.getIntValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2IntMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Double, ? extends Integer> m) {
        if (m instanceof Double2IntMap) {
            ObjectIterator<Double2IntMap.Entry> i = Double2IntMaps.fastIterator((Double2IntMap) m);
            while (i.hasNext()) {
                Double2IntMap.Entry e = i.next();
                put(e.getDoubleKey(), e.getIntValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Double, ? extends Integer>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Double, ? extends Integer> e2 = i2.next();
                put((Double) e2.getKey(), (Integer) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Double2IntMap.Entry> i = Double2IntMaps.fastIterator(this);
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
        return double2IntEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Double2IntMap.Entry> i = Double2IntMaps.fastIterator(this);
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
                Double2IntMap.Entry e = i.next();
                s.append(String.valueOf(e.getDoubleKey()));
                s.append("=>");
                s.append(String.valueOf(e.getIntValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
