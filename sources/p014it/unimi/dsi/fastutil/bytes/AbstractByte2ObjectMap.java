package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectMap.class */
public abstract class AbstractByte2ObjectMap<V> extends AbstractByte2ObjectFunction<V> implements Byte2ObjectMap<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap
    public boolean containsKey(byte k) {
        ObjectIterator<Byte2ObjectMap.Entry<V>> i = byte2ObjectEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getByteKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object v) {
        ObjectIterator<Byte2ObjectMap.Entry<V>> i = byte2ObjectEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectMap$BasicEntry.class */
    public static class BasicEntry<V> implements Byte2ObjectMap.Entry<V> {
        protected byte key;
        protected V value;

        public BasicEntry() {
        }

        public BasicEntry(Byte key, V value) {
            this.key = key.byteValue();
            this.value = value;
        }

        public BasicEntry(byte key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap.Entry
        public byte getByteKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2ObjectMap.Entry) {
                Byte2ObjectMap.Entry<V> e = (Byte2ObjectMap.Entry) o;
                return this.key == e.getByteKey() && Objects.equals(this.value, e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            return this.key == ((Byte) key).byteValue() && Objects.equals(this.value, e2.getValue());
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ (this.value == null ? 0 : this.value.hashCode());
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) this.key) + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<V> extends AbstractObjectSet<Byte2ObjectMap.Entry<V>> {
        protected final Byte2ObjectMap<V> map;

        public BasicEntrySet(Byte2ObjectMap<V> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2ObjectMap.Entry) {
                Byte2ObjectMap.Entry<V> e = (Byte2ObjectMap.Entry) o;
                byte k = e.getByteKey();
                return this.map.containsKey(k) && Objects.equals(this.map.get(k), e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k2 = ((Byte) key).byteValue();
            return this.map.containsKey(k2) && Objects.equals(this.map.get(k2), e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2ObjectMap.Entry) {
                Byte2ObjectMap.Entry<V> e = (Byte2ObjectMap.Entry) o;
                return this.map.remove(e.getByteKey(), e.getValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            return this.map.remove(((Byte) key).byteValue(), e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Byte2ObjectMap.Entry<V>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    public Set<Byte> keySet() {
        return new AbstractByteSet() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap.1
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractByte2ObjectMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractByte2ObjectMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractByte2ObjectMap.this.clear();
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Iterator<Byte> iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2ObjectMap.Entry<V>> f1071i;

                    {
                        this.f1071i = Byte2ObjectMaps.fastIterator(AbstractByte2ObjectMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f1071i.next().getByteKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1071i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1071i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f1071i.forEachRemaining(entry -> {
                            action.accept(entry.getByteKey());
                        });
                    }
                };
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
            /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteIterator] */
            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Spliterator<Byte> spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2ObjectMap.this), 321);
            }
        };
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        return new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap.2
            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object k) {
                return AbstractByte2ObjectMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractByte2ObjectMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractByte2ObjectMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2ObjectMap.Entry<V>> f1072i;

                    {
                        this.f1072i = Byte2ObjectMaps.fastIterator(AbstractByte2ObjectMap.this);
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.f1072i.next().getValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1072i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1072i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super V> action) {
                        this.f1072i.forEachRemaining(entry -> {
                            action.accept(entry.getValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<V> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2ObjectMap.this), 64);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectMap<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends Byte, ? extends V> m) {
        if (m instanceof Byte2ObjectMap) {
            ObjectIterator<Byte2ObjectMap.Entry<V>> i = Byte2ObjectMaps.fastIterator((Byte2ObjectMap) m);
            while (i.hasNext()) {
                Byte2ObjectMap.Entry<? extends V> e = (Byte2ObjectMap.Entry) i.next();
                put(e.getByteKey(), (byte) e.getValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Byte, ? extends V>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Byte, ? extends V> e2 = i2.next();
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
        ObjectIterator<Byte2ObjectMap.Entry<V>> i = Byte2ObjectMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Byte2ObjectMap.Entry) i.next()).hashCode();
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
        return byte2ObjectEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Byte2ObjectMap.Entry<V>> i = Byte2ObjectMaps.fastIterator(this);
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
                Byte2ObjectMap.Entry<V> e = i.next();
                s.append(String.valueOf((int) e.getByteKey()));
                s.append("=>");
                if (this == e.getValue()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getValue()));
                }
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
