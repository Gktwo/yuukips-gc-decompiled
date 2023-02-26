package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ByteMap.class */
public abstract class AbstractByte2ByteMap extends AbstractByte2ByteFunction implements Byte2ByteMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public boolean containsKey(byte k) {
        ObjectIterator<Byte2ByteMap.Entry> i = byte2ByteEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getByteKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
    public boolean containsValue(byte v) {
        ObjectIterator<Byte2ByteMap.Entry> i = byte2ByteEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ByteMap$BasicEntry.class */
    public static class BasicEntry implements Byte2ByteMap.Entry {
        protected byte key;
        protected byte value;

        public BasicEntry() {
        }

        public BasicEntry(Byte key, Byte value) {
            this.key = key.byteValue();
            this.value = value.byteValue();
        }

        public BasicEntry(byte key, byte value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry
        public byte getByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry
        public byte getByteValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap.Entry
        public byte setValue(byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2ByteMap.Entry) {
                Byte2ByteMap.Entry e = (Byte2ByteMap.Entry) o;
                return this.key == e.getByteKey() && this.value == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Byte) && (value = e2.getValue()) != null && (value instanceof Byte) && this.key == ((Byte) key).byteValue() && this.value == ((Byte) value).byteValue();
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

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ByteMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Byte2ByteMap.Entry> {
        protected final Byte2ByteMap map;

        public BasicEntrySet(Byte2ByteMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2ByteMap.Entry) {
                Byte2ByteMap.Entry e = (Byte2ByteMap.Entry) o;
                byte k = e.getByteKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k2 = ((Byte) key).byteValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Byte) && this.map.containsKey(k2) && this.map.get(k2) == ((Byte) value).byteValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2ByteMap.Entry) {
                Byte2ByteMap.Entry e = (Byte2ByteMap.Entry) o;
                return this.map.remove(e.getByteKey(), e.getByteValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) key).byteValue();
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
        public ObjectSpliterator<Byte2ByteMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
    public Set<Byte> keySet() {
        return new AbstractByteSet() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap.1
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractByte2ByteMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractByte2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractByte2ByteMap.this.clear();
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Iterator<Byte> iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2ByteMap.Entry> f1047i;

                    {
                        this.f1047i = Byte2ByteMaps.fastIterator(AbstractByte2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f1047i.next().getByteKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1047i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1047i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f1047i.forEachRemaining(entry -> {
                            action.accept(entry.getByteKey());
                        });
                    }
                };
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
            /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteIterator] */
            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Spliterator<Byte> spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2ByteMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap, java.util.Map
    public Collection<Byte> values() {
        return new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap.2
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractByte2ByteMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractByte2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractByte2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteIterator iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2ByteMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2ByteMap.Entry> f1048i;

                    {
                        this.f1048i = Byte2ByteMaps.fastIterator(AbstractByte2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f1048i.next().getByteValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1048i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1048i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f1048i.forEachRemaining(entry -> {
                            action.accept(entry.getByteValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteSpliterator spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2ByteMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Byte, ? extends Byte> m) {
        if (m instanceof Byte2ByteMap) {
            ObjectIterator<Byte2ByteMap.Entry> i = Byte2ByteMaps.fastIterator((Byte2ByteMap) m);
            while (i.hasNext()) {
                Byte2ByteMap.Entry e = i.next();
                put(e.getByteKey(), e.getByteValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Byte, ? extends Byte>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Byte, ? extends Byte> e2 = i2.next();
                put((Byte) e2.getKey(), (Byte) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Byte2ByteMap.Entry> i = Byte2ByteMaps.fastIterator(this);
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
        return byte2ByteEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Byte2ByteMap.Entry> i = Byte2ByteMaps.fastIterator(this);
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
                Byte2ByteMap.Entry e = i.next();
                s.append(String.valueOf((int) e.getByteKey()));
                s.append("=>");
                s.append(String.valueOf((int) e.getByteValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
