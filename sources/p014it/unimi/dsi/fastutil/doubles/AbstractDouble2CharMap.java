package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.doubles.Double2CharMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharMap.class */
public abstract class AbstractDouble2CharMap extends AbstractDouble2CharFunction implements Double2CharMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction, p014it.unimi.dsi.fastutil.doubles.Double2CharMap
    public boolean containsKey(double k) {
        ObjectIterator<Double2CharMap.Entry> i = double2CharEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getDoubleKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap
    public boolean containsValue(char v) {
        ObjectIterator<Double2CharMap.Entry> i = double2CharEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getCharValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharMap$BasicEntry.class */
    public static class BasicEntry implements Double2CharMap.Entry {
        protected double key;
        protected char value;

        public BasicEntry() {
        }

        public BasicEntry(Double key, Character value) {
            this.key = key.doubleValue();
            this.value = value.charValue();
        }

        public BasicEntry(double key, char value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap.Entry
        public double getDoubleKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap.Entry
        public char getCharValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap.Entry
        public char setValue(char value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2CharMap.Entry) {
                Double2CharMap.Entry e = (Double2CharMap.Entry) o;
                return Double.doubleToLongBits(this.key) == Double.doubleToLongBits(e.getDoubleKey()) && this.value == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Double) && (value = e2.getValue()) != null && (value instanceof Character) && Double.doubleToLongBits(this.key) == Double.doubleToLongBits(((Double) key).doubleValue()) && this.value == ((Character) value).charValue();
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

    /* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Double2CharMap.Entry> {
        protected final Double2CharMap map;

        public BasicEntrySet(Double2CharMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2CharMap.Entry) {
                Double2CharMap.Entry e = (Double2CharMap.Entry) o;
                double k = e.getDoubleKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k2 = ((Double) key).doubleValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Character) && this.map.containsKey(k2) && this.map.get(k2) == ((Character) value).charValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Double2CharMap.Entry) {
                Double2CharMap.Entry e = (Double2CharMap.Entry) o;
                return this.map.remove(e.getDoubleKey(), e.getCharValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Double)) {
                return false;
            }
            double k = ((Double) key).doubleValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Character)) {
                return false;
            }
            return this.map.remove(k, ((Character) value).charValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Double2CharMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
    public Set<Double> keySet() {
        return new AbstractDoubleSet() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap.1
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractDouble2CharMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractDouble2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractDouble2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2CharMap.Entry> f1505i;

                    {
                        this.f1505i = Double2CharMaps.fastIterator(AbstractDouble2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f1505i.next().getDoubleKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1505i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1505i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f1505i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2CharMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharMap, java.util.Map
    public Collection<Character> values() {
        return new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap.2
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractDouble2CharMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractDouble2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractDouble2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Double2CharMap.Entry> f1506i;

                    {
                        this.f1506i = Double2CharMaps.fastIterator(AbstractDouble2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f1506i.next().getCharValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1506i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1506i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f1506i.forEachRemaining(entry -> {
                            action.accept(entry.getCharValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractDouble2CharMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Double, ? extends Character> m) {
        if (m instanceof Double2CharMap) {
            ObjectIterator<Double2CharMap.Entry> i = Double2CharMaps.fastIterator((Double2CharMap) m);
            while (i.hasNext()) {
                Double2CharMap.Entry e = i.next();
                put(e.getDoubleKey(), e.getCharValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Double, ? extends Character>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Double, ? extends Character> e2 = i2.next();
                put((Double) e2.getKey(), (Character) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Double2CharMap.Entry> i = Double2CharMaps.fastIterator(this);
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
        return double2CharEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Double2CharMap.Entry> i = Double2CharMaps.fastIterator(this);
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
                Double2CharMap.Entry e = i.next();
                s.append(String.valueOf(e.getDoubleKey()));
                s.append("=>");
                s.append(String.valueOf(e.getCharValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
