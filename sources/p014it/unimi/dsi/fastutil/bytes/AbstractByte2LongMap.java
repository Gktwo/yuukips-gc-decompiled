package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.LongConsumer;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLongCollection;
import p014it.unimi.dsi.fastutil.longs.LongBinaryOperator;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterator;
import p014it.unimi.dsi.fastutil.longs.LongSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2LongMap.class */
public abstract class AbstractByte2LongMap extends AbstractByte2LongFunction implements Byte2LongMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
    public boolean containsKey(byte k) {
        ObjectIterator<Byte2LongMap.Entry> i = byte2LongEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getByteKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
    public boolean containsValue(long v) {
        ObjectIterator<Byte2LongMap.Entry> i = byte2LongEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getLongValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
    public final long mergeLong(byte key, long value, LongBinaryOperator remappingFunction) {
        return mergeLong(key, value, (java.util.function.LongBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2LongMap$BasicEntry.class */
    public static class BasicEntry implements Byte2LongMap.Entry {
        protected byte key;
        protected long value;

        public BasicEntry() {
        }

        public BasicEntry(Byte key, Long value) {
            this.key = key.byteValue();
            this.value = value.longValue();
        }

        public BasicEntry(byte key, long value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap.Entry
        public byte getByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap.Entry
        public long getLongValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap.Entry
        public long setValue(long value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2LongMap.Entry) {
                Byte2LongMap.Entry e = (Byte2LongMap.Entry) o;
                return this.key == e.getByteKey() && this.value == e.getLongValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Byte) && (value = e2.getValue()) != null && (value instanceof Long) && this.key == ((Byte) key).byteValue() && this.value == ((Long) value).longValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ HashCommon.long2int(this.value);
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) this.key) + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2LongMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Byte2LongMap.Entry> {
        protected final Byte2LongMap map;

        public BasicEntrySet(Byte2LongMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2LongMap.Entry) {
                Byte2LongMap.Entry e = (Byte2LongMap.Entry) o;
                byte k = e.getByteKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getLongValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k2 = ((Byte) key).byteValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Long) && this.map.containsKey(k2) && this.map.get(k2) == ((Long) value).longValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2LongMap.Entry) {
                Byte2LongMap.Entry e = (Byte2LongMap.Entry) o;
                return this.map.remove(e.getByteKey(), e.getLongValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) key).byteValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Long)) {
                return false;
            }
            return this.map.remove(k, ((Long) value).longValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2LongMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
    public Set<Byte> keySet() {
        return new AbstractByteSet() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap.1
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractByte2LongMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractByte2LongMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractByte2LongMap.this.clear();
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Iterator<Byte> iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2LongMap.Entry> f1067i;

                    {
                        this.f1067i = Byte2LongMaps.fastIterator(AbstractByte2LongMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f1067i.next().getByteKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1067i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1067i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f1067i.forEachRemaining(entry -> {
                            action.accept(entry.getByteKey());
                        });
                    }
                };
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
            /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteIterator] */
            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Spliterator<Byte> spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2LongMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongMap, java.util.Map
    public Collection<Long> values() {
        return new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap.2
            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
            public boolean contains(long k) {
                return AbstractByte2LongMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractByte2LongMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractByte2LongMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongIterator iterator() {
                return new LongIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2LongMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2LongMap.Entry> f1068i;

                    {
                        this.f1068i = Byte2LongMaps.fastIterator(AbstractByte2LongMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
                    public long nextLong() {
                        return this.f1068i.next().getLongValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1068i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1068i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfLong
                    public void forEachRemaining(LongConsumer action) {
                        this.f1068i.forEachRemaining(entry -> {
                            action.accept(entry.getLongValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongSpliterator spliterator() {
                return LongSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2LongMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Byte, ? extends Long> m) {
        if (m instanceof Byte2LongMap) {
            ObjectIterator<Byte2LongMap.Entry> i = Byte2LongMaps.fastIterator((Byte2LongMap) m);
            while (i.hasNext()) {
                Byte2LongMap.Entry e = i.next();
                put(e.getByteKey(), e.getLongValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Byte, ? extends Long>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Byte, ? extends Long> e2 = i2.next();
                put((Byte) e2.getKey(), (Long) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Byte2LongMap.Entry> i = Byte2LongMaps.fastIterator(this);
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
        return byte2LongEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Byte2LongMap.Entry> i = Byte2LongMaps.fastIterator(this);
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
                Byte2LongMap.Entry e = i.next();
                s.append(String.valueOf((int) e.getByteKey()));
                s.append("=>");
                s.append(String.valueOf(e.getLongValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
