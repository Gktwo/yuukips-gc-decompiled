package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleBinaryOperator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2DoubleMap.class */
public abstract class AbstractByte2DoubleMap extends AbstractByte2DoubleFunction implements Byte2DoubleMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction, p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap
    public boolean containsKey(byte k) {
        ObjectIterator<Byte2DoubleMap.Entry> i = byte2DoubleEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getByteKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap
    public boolean containsValue(double v) {
        ObjectIterator<Byte2DoubleMap.Entry> i = byte2DoubleEntrySet().iterator();
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

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap
    public final double mergeDouble(byte key, double value, DoubleBinaryOperator remappingFunction) {
        return mergeDouble(key, value, (java.util.function.DoubleBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2DoubleMap$BasicEntry.class */
    public static class BasicEntry implements Byte2DoubleMap.Entry {
        protected byte key;
        protected double value;

        public BasicEntry() {
        }

        public BasicEntry(Byte key, Double value) {
            this.key = key.byteValue();
            this.value = value.doubleValue();
        }

        public BasicEntry(byte key, double value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap.Entry
        public byte getByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap.Entry
        public double getDoubleValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap.Entry
        public double setValue(double value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2DoubleMap.Entry) {
                Byte2DoubleMap.Entry e = (Byte2DoubleMap.Entry) o;
                return this.key == e.getByteKey() && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Byte) && (value = e2.getValue()) != null && (value instanceof Double) && this.key == ((Byte) key).byteValue() && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(((Double) value).doubleValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ HashCommon.double2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) this.key) + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2DoubleMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Byte2DoubleMap.Entry> {
        protected final Byte2DoubleMap map;

        public BasicEntrySet(Byte2DoubleMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2DoubleMap.Entry) {
                Byte2DoubleMap.Entry e = (Byte2DoubleMap.Entry) o;
                byte k = e.getByteKey();
                return this.map.containsKey(k) && Double.doubleToLongBits(this.map.get(k)) == Double.doubleToLongBits(e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k2 = ((Byte) key).byteValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Double) && this.map.containsKey(k2) && Double.doubleToLongBits(this.map.get(k2)) == Double.doubleToLongBits(((Double) value).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2DoubleMap.Entry) {
                Byte2DoubleMap.Entry e = (Byte2DoubleMap.Entry) o;
                return this.map.remove(e.getByteKey(), e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) key).byteValue();
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
        public ObjectSpliterator<Byte2DoubleMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
    public Set<Byte> keySet() {
        return new AbstractByteSet() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleMap.1
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractByte2DoubleMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractByte2DoubleMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractByte2DoubleMap.this.clear();
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Iterator<Byte> iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2DoubleMap.Entry> f1055i;

                    {
                        this.f1055i = Byte2DoubleMaps.fastIterator(AbstractByte2DoubleMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f1055i.next().getByteKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1055i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1055i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f1055i.forEachRemaining(entry -> {
                            action.accept(entry.getByteKey());
                        });
                    }
                };
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
            /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteIterator] */
            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Spliterator<Byte> spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2DoubleMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap, java.util.Map
    public Collection<Double> values() {
        return new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleMap.2
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractByte2DoubleMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractByte2DoubleMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractByte2DoubleMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2DoubleMap.Entry> f1056i;

                    {
                        this.f1056i = Byte2DoubleMaps.fastIterator(AbstractByte2DoubleMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f1056i.next().getDoubleValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1056i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1056i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f1056i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2DoubleMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Byte, ? extends Double> m) {
        if (m instanceof Byte2DoubleMap) {
            ObjectIterator<Byte2DoubleMap.Entry> i = Byte2DoubleMaps.fastIterator((Byte2DoubleMap) m);
            while (i.hasNext()) {
                Byte2DoubleMap.Entry e = i.next();
                put(e.getByteKey(), e.getDoubleValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Byte, ? extends Double>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Byte, ? extends Double> e2 = i2.next();
                put((Byte) e2.getKey(), (Double) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Byte2DoubleMap.Entry> i = Byte2DoubleMaps.fastIterator(this);
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
        return byte2DoubleEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Byte2DoubleMap.Entry> i = Byte2DoubleMaps.fastIterator(this);
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
                Byte2DoubleMap.Entry e = i.next();
                s.append(String.valueOf((int) e.getByteKey()));
                s.append("=>");
                s.append(String.valueOf(e.getDoubleValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
