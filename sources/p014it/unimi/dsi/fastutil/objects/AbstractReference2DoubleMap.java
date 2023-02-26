package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleBinaryOperator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleMap.class */
public abstract class AbstractReference2DoubleMap<K> extends AbstractReference2DoubleFunction<K> implements Reference2DoubleMap<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        ObjectIterator<Reference2DoubleMap.Entry<K>> i = reference2DoubleEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public boolean containsValue(double v) {
        ObjectIterator<Reference2DoubleMap.Entry<K>> i = reference2DoubleEntrySet().iterator();
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

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap
    public final double mergeDouble(K key, double value, DoubleBinaryOperator remappingFunction) {
        return mergeDouble((AbstractReference2DoubleMap<K>) key, value, (java.util.function.DoubleBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleMap$BasicEntry.class */
    public static class BasicEntry<K> implements Reference2DoubleMap.Entry<K> {
        protected K key;
        protected double value;

        public BasicEntry() {
        }

        public BasicEntry(K key, Double value) {
            this.key = key;
            this.value = value.doubleValue();
        }

        public BasicEntry(K key, double value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.Entry
        public double getDoubleValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap.Entry
        public double setValue(double value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2DoubleMap.Entry) {
                Reference2DoubleMap.Entry<K> e = (Reference2DoubleMap.Entry) o;
                return this.key == e.getKey() && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Double) && this.key == key && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(((Double) value).doubleValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this.key) ^ HashCommon.double2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<K> extends AbstractObjectSet<Reference2DoubleMap.Entry<K>> {
        protected final Reference2DoubleMap<K> map;

        public BasicEntrySet(Reference2DoubleMap<K> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2DoubleMap.Entry) {
                Reference2DoubleMap.Entry<K> e = (Reference2DoubleMap.Entry) o;
                K k = e.getKey();
                return this.map.containsKey(k) && Double.doubleToLongBits(this.map.getDouble(k)) == Double.doubleToLongBits(e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k2 = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Double) && this.map.containsKey(k2) && Double.doubleToLongBits(this.map.getDouble(k2)) == Double.doubleToLongBits(((Double) value).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2DoubleMap.Entry) {
                Reference2DoubleMap.Entry<K> e = (Reference2DoubleMap.Entry) o;
                return this.map.remove(e.getKey(), e.getDoubleValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k = e2.getKey();
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
        public ObjectSpliterator<Reference2DoubleMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    public ReferenceSet<K> keySet() {
        return new AbstractReferenceSet<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return AbstractReference2DoubleMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractReference2DoubleMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractReference2DoubleMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Reference2DoubleMap.Entry<K>> f2470i;

                    {
                        this.f2470i = Reference2DoubleMaps.fastIterator(AbstractReference2DoubleMap.this);
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return this.f2470i.next().getKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2470i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2470i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.f2470i.forEachRemaining(entry -> {
                            action.accept(entry.getKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractReference2DoubleMap.this), 65);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleMap, java.util.Map
    public Collection<Double> values() {
        return new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap.2
            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
            public boolean contains(double k) {
                return AbstractReference2DoubleMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractReference2DoubleMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractReference2DoubleMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleIterator iterator() {
                return new DoubleIterator() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Reference2DoubleMap.Entry<K>> f2471i;

                    {
                        this.f2471i = Reference2DoubleMaps.fastIterator(AbstractReference2DoubleMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
                    public double nextDouble() {
                        return this.f2471i.next().getDoubleValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2471i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2471i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfDouble
                    public void forEachRemaining(DoubleConsumer action) {
                        this.f2471i.forEachRemaining(entry -> {
                            action.accept(entry.getDoubleValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
            public DoubleSpliterator spliterator() {
                return DoubleSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractReference2DoubleMap.this), 320);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Double> m) {
        if (m instanceof Reference2DoubleMap) {
            ObjectIterator<Reference2DoubleMap.Entry<K>> i = Reference2DoubleMaps.fastIterator((Reference2DoubleMap) m);
            while (i.hasNext()) {
                Reference2DoubleMap.Entry<? extends K> e = (Reference2DoubleMap.Entry) i.next();
                put((AbstractReference2DoubleMap<K>) e.getKey(), e.getDoubleValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends K, ? extends Double>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends K, ? extends Double> e2 = i2.next();
                put((AbstractReference2DoubleMap<K>) e2.getKey(), (Double) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Reference2DoubleMap.Entry<K>> i = Reference2DoubleMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Reference2DoubleMap.Entry) i.next()).hashCode();
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
        return reference2DoubleEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Reference2DoubleMap.Entry<K>> i = Reference2DoubleMaps.fastIterator(this);
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
                Reference2DoubleMap.Entry<K> e = i.next();
                if (this == e.getKey()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getKey()));
                }
                s.append("=>");
                s.append(String.valueOf(e.getDoubleValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
