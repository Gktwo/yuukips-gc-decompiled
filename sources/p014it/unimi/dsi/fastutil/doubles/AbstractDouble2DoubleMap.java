package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2DoubleMap.class */
public abstract class AbstractDouble2DoubleMap extends AbstractDouble2DoubleFunction implements Double2DoubleMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleFunction, p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap
    public boolean containsKey(double k) {
        ObjectIterator<Double2DoubleMap.Entry> i = double2DoubleEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getDoubleKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap
    public boolean containsValue(double v) {
        ObjectIterator<Double2DoubleMap.Entry> i = double2DoubleEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getDoubleValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap
    public final double mergeDouble(double key, double value, DoubleBinaryOperator remappingFunction) {
        return mergeDouble(key, value, (DoubleBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2DoubleMap$BasicEntry.class */
    public static class BasicEntry implements Double2DoubleMap.Entry {
        protected double key;
        protected double value;

        public BasicEntry() {
        }

        public BasicEntry(Double key, Double value) {
            this.key = key.doubleValue();
            this.value = value.doubleValue();
        }

        public BasicEntry(double key, double value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap.Entry
        public double getDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap.Entry
        public double getDoubleValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap.Entry
        public double setValue(double value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2DoubleMap.Entry) {
                Double2DoubleMap.Entry e = (Double2DoubleMap.Entry) o;
                return Double.doubleToLongBits(this.key) == Double.doubleToLongBits(e.getDoubleKey()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Double) && (value = e2.getValue()) != null && (value instanceof Double) && Double.doubleToLongBits(this.key) == Double.doubleToLongBits(((Double) key).doubleValue()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(((Double) value).doubleValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.double2int(this.key) ^ HashCommon.double2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2DoubleMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Double2DoubleMap.Entry> {
        protected final Double2DoubleMap map;

        public BasicEntrySet(Double2DoubleMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2DoubleMap.Entry) {
                Double2DoubleMap.Entry e = (Double2DoubleMap.Entry) o;
                double k = e.getDoubleKey();
                return this.map.containsKey(k) && Double.doubleToLongBits(this.map.get(k)) == Double.doubleToLongBits(e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k2 = ((Double) key).doubleValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Double) && this.map.containsKey(k2) && Double.doubleToLongBits(this.map.get(k2)) == Double.doubleToLongBits(((Double) value).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2DoubleMap.Entry) {
                Double2DoubleMap.Entry e = (Double2DoubleMap.Entry) o;
                return this.map.remove(e.getDoubleKey(), e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k = ((Double) key).doubleValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Double)) {
                return false;
            }
            return this.map.remove(k, ((Double) value).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Double2DoubleMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
    public Set<Double> keySet() {
        return new AbstractDoubleSet() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleMap.1
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractDouble2DoubleMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractDouble2DoubleMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractDouble2DoubleMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2DoubleMap.Entry> f1509i;

                    {
                        this.f1509i = Double2DoubleMaps.fastIterator(AbstractDouble2DoubleMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f1509i.next().getDoubleKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1509i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1509i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f1509i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2DoubleMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleMap, java.util.Map
    public Collection<Double> values() {
        return new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleMap.2
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractDouble2DoubleMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractDouble2DoubleMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractDouble2DoubleMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2DoubleMap.Entry> f1510i;

                    {
                        this.f1510i = Double2DoubleMaps.fastIterator(AbstractDouble2DoubleMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f1510i.next().getDoubleValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1510i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1510i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f1510i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2DoubleMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Double, ? extends Double> m) {
        if (m instanceof Double2DoubleMap) {
            ObjectIterator<Double2DoubleMap.Entry> i = Double2DoubleMaps.fastIterator((Double2DoubleMap) m);
            while (i.hasNext()) {
                Double2DoubleMap.Entry e = i.next();
                put(e.getDoubleKey(), e.getDoubleValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Double, ? extends Double>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Double, ? extends Double> e2 = i2.next();
                put((Double) e2.getKey(), (Double) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Double2DoubleMap.Entry> i = Double2DoubleMaps.fastIterator(this);
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
        return double2DoubleEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Double2DoubleMap.Entry> i = Double2DoubleMaps.fastIterator(this);
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
                Double2DoubleMap.Entry e = i.next();
                s.append(String.valueOf(e.getDoubleKey()));
                s.append("=>");
                s.append(String.valueOf(e.getDoubleValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
