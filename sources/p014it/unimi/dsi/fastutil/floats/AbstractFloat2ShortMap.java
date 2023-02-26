package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.floats.Float2ShortMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortConsumer;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortMap.class */
public abstract class AbstractFloat2ShortMap extends AbstractFloat2ShortFunction implements Float2ShortMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction, p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public boolean containsKey(float k) {
        ObjectIterator<Float2ShortMap.Entry> i = float2ShortEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getFloatKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap
    public boolean containsValue(short v) {
        ObjectIterator<Float2ShortMap.Entry> i = float2ShortEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortMap$BasicEntry.class */
    public static class BasicEntry implements Float2ShortMap.Entry {
        protected float key;
        protected short value;

        public BasicEntry() {
        }

        public BasicEntry(Float key, Short value) {
            this.key = key.floatValue();
            this.value = value.shortValue();
        }

        public BasicEntry(float key, short value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry
        public float getFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry
        public short getShortValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap.Entry
        public short setValue(short value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2ShortMap.Entry) {
                Float2ShortMap.Entry e = (Float2ShortMap.Entry) o;
                return Float.floatToIntBits(this.key) == Float.floatToIntBits(e.getFloatKey()) && this.value == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Float) && (value = e2.getValue()) != null && (value instanceof Short) && Float.floatToIntBits(this.key) == Float.floatToIntBits(((Float) key).floatValue()) && this.value == ((Short) value).shortValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + ((int) this.value);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Float2ShortMap.Entry> {
        protected final Float2ShortMap map;

        public BasicEntrySet(Float2ShortMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2ShortMap.Entry) {
                Float2ShortMap.Entry e = (Float2ShortMap.Entry) o;
                float k = e.getFloatKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getShortValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k2 = ((Float) key).floatValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Short) && this.map.containsKey(k2) && this.map.get(k2) == ((Short) value).shortValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2ShortMap.Entry) {
                Float2ShortMap.Entry e = (Float2ShortMap.Entry) o;
                return this.map.remove(e.getFloatKey(), e.getShortValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k = ((Float) key).floatValue();
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
        public ObjectSpliterator<Float2ShortMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    public Set<Float> keySet() {
        return new AbstractFloatSet() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap.1
            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
            public boolean contains(float k) {
                return AbstractFloat2ShortMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractFloat2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractFloat2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatIterator iterator() {
                return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2ShortMap.Entry> f1754i;

                    {
                        this.f1754i = Float2ShortMaps.fastIterator(AbstractFloat2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public float nextFloat() {
                        return this.f1754i.next().getFloatKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1754i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1754i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public void forEachRemaining(FloatConsumer action) {
                        this.f1754i.forEachRemaining(entry -> {
                            action.accept(entry.getFloatKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatSpliterator spliterator() {
                return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2ShortMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortMap, java.util.Map
    public Collection<Short> values() {
        return new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap.2
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractFloat2ShortMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractFloat2ShortMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractFloat2ShortMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2ShortMap.Entry> f1755i;

                    {
                        this.f1755i = Float2ShortMaps.fastIterator(AbstractFloat2ShortMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f1755i.next().getShortValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1755i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1755i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f1755i.forEachRemaining(entry -> {
                            action.accept(entry.getShortValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2ShortMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Float, ? extends Short> m) {
        if (m instanceof Float2ShortMap) {
            ObjectIterator<Float2ShortMap.Entry> i = Float2ShortMaps.fastIterator((Float2ShortMap) m);
            while (i.hasNext()) {
                Float2ShortMap.Entry e = i.next();
                put(e.getFloatKey(), e.getShortValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Float, ? extends Short>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Float, ? extends Short> e2 = i2.next();
                put((Float) e2.getKey(), (Short) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Float2ShortMap.Entry> i = Float2ShortMaps.fastIterator(this);
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
        return float2ShortEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Float2ShortMap.Entry> i = Float2ShortMaps.fastIterator(this);
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
                Float2ShortMap.Entry e = i.next();
                s.append(String.valueOf(e.getFloatKey()));
                s.append("=>");
                s.append(String.valueOf((int) e.getShortValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
