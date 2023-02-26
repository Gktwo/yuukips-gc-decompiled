package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteConsumer;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ByteMap.class */
public abstract class AbstractShort2ByteMap extends AbstractShort2ByteFunction implements Short2ByteMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap
    public boolean containsKey(short k) {
        ObjectIterator<Short2ByteMap.Entry> i = short2ByteEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getShortKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap
    public boolean containsValue(byte v) {
        ObjectIterator<Short2ByteMap.Entry> i = short2ByteEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ByteMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ByteMap$BasicEntry.class */
    public static class BasicEntry implements Short2ByteMap.Entry {
        protected short key;
        protected byte value;

        public BasicEntry() {
        }

        public BasicEntry(Short key, Byte value) {
            this.key = key.shortValue();
            this.value = value.byteValue();
        }

        public BasicEntry(short key, byte value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap.Entry
        public short getShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap.Entry
        public byte getByteValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap.Entry
        public byte setValue(byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2ByteMap.Entry) {
                Short2ByteMap.Entry e = (Short2ByteMap.Entry) o;
                return this.key == e.getShortKey() && this.value == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Short) && (value = e2.getValue()) != null && (value instanceof Byte) && this.key == ((Short) key).shortValue() && this.value == ((Byte) value).byteValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) this.key) + "->" + ((int) this.value);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ByteMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ByteMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Short2ByteMap.Entry> {
        protected final Short2ByteMap map;

        public BasicEntrySet(Short2ByteMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2ByteMap.Entry) {
                Short2ByteMap.Entry e = (Short2ByteMap.Entry) o;
                short k = e.getShortKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Short)) {
                return false;
            }
            short k2 = ((Short) key).shortValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Byte) && this.map.containsKey(k2) && this.map.get(k2) == ((Byte) value).byteValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2ByteMap.Entry) {
                Short2ByteMap.Entry e = (Short2ByteMap.Entry) o;
                return this.map.remove(e.getShortKey(), e.getByteValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Short)) {
                return false;
            }
            short k = ((Short) key).shortValue();
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
        public ObjectSpliterator<Short2ByteMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
    public Set<Short> keySet() {
        return new AbstractShortSet() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2ByteMap.1
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractShort2ByteMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractShort2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractShort2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2ByteMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Short2ByteMap.Entry> f2815i;

                    {
                        this.f2815i = Short2ByteMaps.fastIterator(AbstractShort2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f2815i.next().getShortKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2815i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2815i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f2815i.forEachRemaining(entry -> {
                            action.accept(entry.getShortKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractShort2ByteMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteMap, java.util.Map
    public Collection<Byte> values() {
        return new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2ByteMap.2
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractShort2ByteMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractShort2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractShort2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteIterator iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2ByteMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Short2ByteMap.Entry> f2816i;

                    {
                        this.f2816i = Short2ByteMaps.fastIterator(AbstractShort2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f2816i.next().getByteValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2816i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2816i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f2816i.forEachRemaining(entry -> {
                            action.accept(entry.getByteValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteSpliterator spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractShort2ByteMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Short, ? extends Byte> m) {
        if (m instanceof Short2ByteMap) {
            ObjectIterator<Short2ByteMap.Entry> i = Short2ByteMaps.fastIterator((Short2ByteMap) m);
            while (i.hasNext()) {
                Short2ByteMap.Entry e = i.next();
                put(e.getShortKey(), e.getByteValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Short, ? extends Byte>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Short, ? extends Byte> e2 = i2.next();
                put((Short) e2.getKey(), (Byte) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Short2ByteMap.Entry> i = Short2ByteMaps.fastIterator(this);
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
        return short2ByteEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Short2ByteMap.Entry> i = Short2ByteMaps.fastIterator(this);
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
                Short2ByteMap.Entry e = i.next();
                s.append(String.valueOf((int) e.getShortKey()));
                s.append("=>");
                s.append(String.valueOf((int) e.getByteValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
