package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortConsumer;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ShortMap.class */
public abstract class AbstractDouble2ShortMap extends AbstractDouble2ShortFunction implements Double2ShortMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction, p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public boolean containsKey(double k) {
        ObjectIterator<Double2ShortMap.Entry> i = double2ShortEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getDoubleKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap
    public boolean containsValue(short v) {
        ObjectIterator<Double2ShortMap.Entry> i = double2ShortEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ShortMap$BasicEntry.class */
    public static class BasicEntry implements Double2ShortMap.Entry {
        protected double key;
        protected short value;

        public BasicEntry() {
        }

        public BasicEntry(Double key, Short value) {
            this.key = key.doubleValue();
            this.value = value.shortValue();
        }

        public BasicEntry(double key, short value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry
        public double getDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry
        public short getShortValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap.Entry
        public short setValue(short value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2ShortMap.Entry) {
                Double2ShortMap.Entry e = (Double2ShortMap.Entry) o;
                return Double.doubleToLongBits(this.key) == Double.doubleToLongBits(e.getDoubleKey()) && this.value == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Double) && (value = e2.getValue()) != null && (value instanceof Short) && Double.doubleToLongBits(this.key) == Double.doubleToLongBits(((Double) key).doubleValue()) && this.value == ((Short) value).shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.double2int(this.key) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + ((int) this.value);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ShortMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Double2ShortMap.Entry> {
        protected final Double2ShortMap map;

        public BasicEntrySet(Double2ShortMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2ShortMap.Entry) {
                Double2ShortMap.Entry e = (Double2ShortMap.Entry) o;
                double k = e.getDoubleKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k2 = ((Double) key).doubleValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Short) && this.map.containsKey(k2) && this.map.get(k2) == ((Short) value).shortValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2ShortMap.Entry) {
                Double2ShortMap.Entry e = (Double2ShortMap.Entry) o;
                return this.map.remove(e.getDoubleKey(), e.getShortValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k = ((Double) key).doubleValue();
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
        public ObjectSpliterator<Double2ShortMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
    public Set<Double> keySet() {
        return new AbstractDoubleSet() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap.1
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractDouble2ShortMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractDouble2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractDouble2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2ShortMap.Entry> f1533i;

                    {
                        this.f1533i = Double2ShortMaps.fastIterator(AbstractDouble2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f1533i.next().getDoubleKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1533i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1533i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f1533i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2ShortMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ShortMap, java.util.Map
    public Collection<Short> values() {
        return new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap.2
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractDouble2ShortMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractDouble2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractDouble2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2ShortMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2ShortMap.Entry> f1534i;

                    {
                        this.f1534i = Double2ShortMaps.fastIterator(AbstractDouble2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f1534i.next().getShortValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1534i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1534i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f1534i.forEachRemaining(entry -> {
                            action.accept(entry.getShortValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2ShortMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Double, ? extends Short> m) {
        if (m instanceof Double2ShortMap) {
            ObjectIterator<Double2ShortMap.Entry> i = Double2ShortMaps.fastIterator((Double2ShortMap) m);
            while (i.hasNext()) {
                Double2ShortMap.Entry e = i.next();
                put(e.getDoubleKey(), e.getShortValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Double, ? extends Short>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Double, ? extends Short> e2 = i2.next();
                put((Double) e2.getKey(), (Short) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Double2ShortMap.Entry> i = Double2ShortMaps.fastIterator(this);
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
        return double2ShortEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Double2ShortMap.Entry> i = Double2ShortMaps.fastIterator(this);
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
                Double2ShortMap.Entry e = i.next();
                s.append(String.valueOf(e.getDoubleKey()));
                s.append("=>");
                s.append(String.valueOf((int) e.getShortValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
