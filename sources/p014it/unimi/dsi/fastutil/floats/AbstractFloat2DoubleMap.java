package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleBinaryOperator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2DoubleMap.class */
public abstract class AbstractFloat2DoubleMap extends AbstractFloat2DoubleFunction implements Float2DoubleMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
    public boolean containsKey(float k) {
        ObjectIterator<Float2DoubleMap.Entry> i = float2DoubleEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getFloatKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
    public boolean containsValue(double v) {
        ObjectIterator<Float2DoubleMap.Entry> i = float2DoubleEntrySet().iterator();
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
    public final double mergeDouble(float key, double value, DoubleBinaryOperator remappingFunction) {
        return mergeDouble(key, value, (java.util.function.DoubleBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2DoubleMap$BasicEntry.class */
    public static class BasicEntry implements Float2DoubleMap.Entry {
        protected float key;
        protected double value;

        public BasicEntry() {
        }

        public BasicEntry(Float key, Double value) {
            this.key = key.floatValue();
            this.value = value.doubleValue();
        }

        public BasicEntry(float key, double value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap.Entry
        public float getFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap.Entry
        public double getDoubleValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap.Entry
        public double setValue(double value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2DoubleMap.Entry) {
                Float2DoubleMap.Entry e = (Float2DoubleMap.Entry) o;
                return Float.floatToIntBits(this.key) == Float.floatToIntBits(e.getFloatKey()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Float) && (value = e2.getValue()) != null && (value instanceof Double) && Float.floatToIntBits(this.key) == Float.floatToIntBits(((Float) key).floatValue()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(((Double) value).doubleValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ HashCommon.double2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2DoubleMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Float2DoubleMap.Entry> {
        protected final Float2DoubleMap map;

        public BasicEntrySet(Float2DoubleMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2DoubleMap.Entry) {
                Float2DoubleMap.Entry e = (Float2DoubleMap.Entry) o;
                float k = e.getFloatKey();
                return this.map.containsKey(k) && Double.doubleToLongBits(this.map.get(k)) == Double.doubleToLongBits(e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k2 = ((Float) key).floatValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Double) && this.map.containsKey(k2) && Double.doubleToLongBits(this.map.get(k2)) == Double.doubleToLongBits(((Double) value).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2DoubleMap.Entry) {
                Float2DoubleMap.Entry e = (Float2DoubleMap.Entry) o;
                return this.map.remove(e.getFloatKey(), e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k = ((Float) key).floatValue();
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
        public ObjectSpliterator<Float2DoubleMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
    public Set<Float> keySet() {
        return new AbstractFloatSet() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap.1
            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
            public boolean contains(float k) {
                return AbstractFloat2DoubleMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractFloat2DoubleMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractFloat2DoubleMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatIterator iterator() {
                return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2DoubleMap.Entry> f1730i;

                    {
                        this.f1730i = Float2DoubleMaps.fastIterator(AbstractFloat2DoubleMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public float nextFloat() {
                        return this.f1730i.next().getFloatKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1730i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1730i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public void forEachRemaining(FloatConsumer action) {
                        this.f1730i.forEachRemaining(entry -> {
                            action.accept(entry.getFloatKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatSpliterator spliterator() {
                return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2DoubleMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleMap, java.util.Map
    public Collection<Double> values() {
        return new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap.2
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractFloat2DoubleMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractFloat2DoubleMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractFloat2DoubleMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2DoubleMap.Entry> f1731i;

                    {
                        this.f1731i = Float2DoubleMaps.fastIterator(AbstractFloat2DoubleMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f1731i.next().getDoubleValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1731i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1731i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f1731i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2DoubleMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Float, ? extends Double> m) {
        if (m instanceof Float2DoubleMap) {
            ObjectIterator<Float2DoubleMap.Entry> i = Float2DoubleMaps.fastIterator((Float2DoubleMap) m);
            while (i.hasNext()) {
                Float2DoubleMap.Entry e = i.next();
                put(e.getFloatKey(), e.getDoubleValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Float, ? extends Double>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Float, ? extends Double> e2 = i2.next();
                put((Float) e2.getKey(), (Double) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Float2DoubleMap.Entry> i = Float2DoubleMaps.fastIterator(this);
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
        return float2DoubleEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Float2DoubleMap.Entry> i = Float2DoubleMaps.fastIterator(this);
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
                Float2DoubleMap.Entry e = i.next();
                s.append(String.valueOf(e.getFloatKey()));
                s.append("=>");
                s.append(String.valueOf(e.getDoubleValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
