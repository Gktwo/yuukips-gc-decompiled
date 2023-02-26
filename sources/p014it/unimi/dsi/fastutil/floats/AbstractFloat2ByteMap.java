package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteConsumer;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.floats.Float2ByteMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ByteMap.class */
public abstract class AbstractFloat2ByteMap extends AbstractFloat2ByteFunction implements Float2ByteMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteMap
    public boolean containsKey(float k) {
        ObjectIterator<Float2ByteMap.Entry> i = float2ByteEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getFloatKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap
    public boolean containsValue(byte v) {
        ObjectIterator<Float2ByteMap.Entry> i = float2ByteEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getByteValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ByteMap$BasicEntry.class */
    public static class BasicEntry implements Float2ByteMap.Entry {
        protected float key;
        protected byte value;

        public BasicEntry() {
        }

        public BasicEntry(Float key, Byte value) {
            this.key = key.floatValue();
            this.value = value.byteValue();
        }

        public BasicEntry(float key, byte value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap.Entry
        public float getFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap.Entry
        public byte getByteValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap.Entry
        public byte setValue(byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2ByteMap.Entry) {
                Float2ByteMap.Entry e = (Float2ByteMap.Entry) o;
                return Float.floatToIntBits(this.key) == Float.floatToIntBits(e.getFloatKey()) && this.value == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Float) && (value = e2.getValue()) != null && (value instanceof Byte) && Float.floatToIntBits(this.key) == Float.floatToIntBits(((Float) key).floatValue()) && this.value == ((Byte) value).byteValue();
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

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ByteMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Float2ByteMap.Entry> {
        protected final Float2ByteMap map;

        public BasicEntrySet(Float2ByteMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2ByteMap.Entry) {
                Float2ByteMap.Entry e = (Float2ByteMap.Entry) o;
                float k = e.getFloatKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k2 = ((Float) key).floatValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Byte) && this.map.containsKey(k2) && this.map.get(k2) == ((Byte) value).byteValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2ByteMap.Entry) {
                Float2ByteMap.Entry e = (Float2ByteMap.Entry) o;
                return this.map.remove(e.getFloatKey(), e.getByteValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k = ((Float) key).floatValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Byte)) {
                return false;
            }
            return this.map.remove(k, ((Byte) value).byteValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Float2ByteMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
    public Set<Float> keySet() {
        return new AbstractFloatSet() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap.1
            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
            public boolean contains(float k) {
                return AbstractFloat2ByteMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractFloat2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractFloat2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatIterator iterator() {
                return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2ByteMap.Entry> f1722i;

                    {
                        this.f1722i = Float2ByteMaps.fastIterator(AbstractFloat2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public float nextFloat() {
                        return this.f1722i.next().getFloatKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1722i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1722i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public void forEachRemaining(FloatConsumer action) {
                        this.f1722i.forEachRemaining(entry -> {
                            action.accept(entry.getFloatKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatSpliterator spliterator() {
                return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2ByteMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteMap, java.util.Map
    public Collection<Byte> values() {
        return new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap.2
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractFloat2ByteMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractFloat2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractFloat2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteIterator iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2ByteMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2ByteMap.Entry> f1723i;

                    {
                        this.f1723i = Float2ByteMaps.fastIterator(AbstractFloat2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f1723i.next().getByteValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1723i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1723i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f1723i.forEachRemaining(entry -> {
                            action.accept(entry.getByteValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteSpliterator spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2ByteMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Float, ? extends Byte> m) {
        if (m instanceof Float2ByteMap) {
            ObjectIterator<Float2ByteMap.Entry> i = Float2ByteMaps.fastIterator((Float2ByteMap) m);
            while (i.hasNext()) {
                Float2ByteMap.Entry e = i.next();
                put(e.getFloatKey(), e.getByteValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Float, ? extends Byte>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Float, ? extends Byte> e2 = i2.next();
                put((Float) e2.getKey(), (Byte) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Float2ByteMap.Entry> i = Float2ByteMaps.fastIterator(this);
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
        return float2ByteEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Float2ByteMap.Entry> i = Float2ByteMaps.fastIterator(this);
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
                Float2ByteMap.Entry e = i.next();
                s.append(String.valueOf(e.getFloatKey()));
                s.append("=>");
                s.append(String.valueOf((int) e.getByteValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
