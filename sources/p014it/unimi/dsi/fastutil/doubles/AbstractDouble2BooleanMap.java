package p014it.unimi.dsi.fastutil.doubles;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2BooleanMap.class */
public abstract class AbstractDouble2BooleanMap extends AbstractDouble2BooleanFunction implements Double2BooleanMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction, p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap
    public boolean containsKey(double k) {
        ObjectIterator<Double2BooleanMap.Entry> i = double2BooleanEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getDoubleKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap
    public boolean containsValue(boolean v) {
        ObjectIterator<Double2BooleanMap.Entry> i = double2BooleanEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2BooleanMap$BasicEntry.class */
    public static class BasicEntry implements Double2BooleanMap.Entry {
        protected double key;
        protected boolean value;

        public BasicEntry() {
        }

        public BasicEntry(Double key, Boolean value) {
            this.key = key.doubleValue();
            this.value = value.booleanValue();
        }

        public BasicEntry(double key, boolean value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap.Entry
        public double getDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap.Entry
        public boolean getBooleanValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap.Entry
        public boolean setValue(boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2BooleanMap.Entry) {
                Double2BooleanMap.Entry e = (Double2BooleanMap.Entry) o;
                return Double.doubleToLongBits(this.key) == Double.doubleToLongBits(e.getDoubleKey()) && this.value == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Double) && (value = e2.getValue()) != null && (value instanceof Boolean) && Double.doubleToLongBits(this.key) == Double.doubleToLongBits(((Double) key).doubleValue()) && this.value == ((Boolean) value).booleanValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.double2int(this.key) ^ (this.value ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2BooleanMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Double2BooleanMap.Entry> {
        protected final Double2BooleanMap map;

        public BasicEntrySet(Double2BooleanMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2BooleanMap.Entry) {
                Double2BooleanMap.Entry e = (Double2BooleanMap.Entry) o;
                double k = e.getDoubleKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k2 = ((Double) key).doubleValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Boolean) && this.map.containsKey(k2) && this.map.get(k2) == ((Boolean) value).booleanValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2BooleanMap.Entry) {
                Double2BooleanMap.Entry e = (Double2BooleanMap.Entry) o;
                return this.map.remove(e.getDoubleKey(), e.getBooleanValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k = ((Double) key).doubleValue();
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
        public ObjectSpliterator<Double2BooleanMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
    public Set<Double> keySet() {
        return new AbstractDoubleSet() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap.1
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractDouble2BooleanMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractDouble2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractDouble2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2BooleanMap.Entry> f1497i;

                    {
                        this.f1497i = Double2BooleanMaps.fastIterator(AbstractDouble2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f1497i.next().getDoubleKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1497i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1497i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f1497i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2BooleanMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2BooleanMap, java.util.Map
    public Collection<Boolean> values() {
        return new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap.2
            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
            public boolean contains(boolean k) {
                return AbstractDouble2BooleanMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractDouble2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractDouble2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanIterator iterator() {
                return new BooleanIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2BooleanMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2BooleanMap.Entry> f1498i;

                    {
                        this.f1498i = Double2BooleanMaps.fastIterator(AbstractDouble2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public boolean nextBoolean() {
                        return this.f1498i.next().getBooleanValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1498i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1498i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public void forEachRemaining(BooleanConsumer action) {
                        this.f1498i.forEachRemaining(entry -> {
                            action.accept(entry.getBooleanValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanSpliterator spliterator() {
                return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2BooleanMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Double, ? extends Boolean> m) {
        if (m instanceof Double2BooleanMap) {
            ObjectIterator<Double2BooleanMap.Entry> i = Double2BooleanMaps.fastIterator((Double2BooleanMap) m);
            while (i.hasNext()) {
                Double2BooleanMap.Entry e = i.next();
                put(e.getDoubleKey(), e.getBooleanValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Double, ? extends Boolean>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Double, ? extends Boolean> e2 = i2.next();
                put((Double) e2.getKey(), (Boolean) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Double2BooleanMap.Entry> i = Double2BooleanMaps.fastIterator(this);
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
        return double2BooleanEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Double2BooleanMap.Entry> i = Double2BooleanMaps.fastIterator(this);
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
                Double2BooleanMap.Entry e = i.next();
                s.append(String.valueOf(e.getDoubleKey()));
                s.append("=>");
                s.append(String.valueOf(e.getBooleanValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
