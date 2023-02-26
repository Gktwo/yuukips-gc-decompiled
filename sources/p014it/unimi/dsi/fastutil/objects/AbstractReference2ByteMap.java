package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection;
import p014it.unimi.dsi.fastutil.bytes.ByteConsumer;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterators;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteMap;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ByteMap.class */
public abstract class AbstractReference2ByteMap<K> extends AbstractReference2ByteFunction<K> implements Reference2ByteMap<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        ObjectIterator<Reference2ByteMap.Entry<K>> i = reference2ByteEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap
    public boolean containsValue(byte v) {
        ObjectIterator<Reference2ByteMap.Entry<K>> i = reference2ByteEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ByteMap$BasicEntry.class */
    public static class BasicEntry<K> implements Reference2ByteMap.Entry<K> {
        protected K key;
        protected byte value;

        public BasicEntry() {
        }

        public BasicEntry(K key, Byte value) {
            this.key = key;
            this.value = value.byteValue();
        }

        public BasicEntry(K key, byte value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap.Entry
        public byte getByteValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap.Entry
        public byte setValue(byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2ByteMap.Entry) {
                Reference2ByteMap.Entry<K> e = (Reference2ByteMap.Entry) o;
                return this.key == e.getKey() && this.value == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Byte) && this.key == key && this.value == ((Byte) value).byteValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this.key) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + ((int) this.value);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ByteMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet<K> extends AbstractObjectSet<Reference2ByteMap.Entry<K>> {
        protected final Reference2ByteMap<K> map;

        public BasicEntrySet(Reference2ByteMap<K> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2ByteMap.Entry) {
                Reference2ByteMap.Entry<K> e = (Reference2ByteMap.Entry) o;
                K k = e.getKey();
                return this.map.containsKey(k) && this.map.getByte(k) == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k2 = e2.getKey();
            Object value = e2.getValue();
            return value != null && (value instanceof Byte) && this.map.containsKey(k2) && this.map.getByte(k2) == ((Byte) value).byteValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Reference2ByteMap.Entry) {
                Reference2ByteMap.Entry<K> e = (Reference2ByteMap.Entry) o;
                return this.map.remove(e.getKey(), e.getByteValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object k = e2.getKey();
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
        public ObjectSpliterator<Reference2ByteMap.Entry<K>> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap, java.util.Map
    public ReferenceSet<K> keySet() {
        return new AbstractReferenceSet<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object k) {
                return AbstractReference2ByteMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractReference2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractReference2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Reference2ByteMap.Entry<K>> f2462i;

                    {
                        this.f2462i = Reference2ByteMaps.fastIterator(AbstractReference2ByteMap.this);
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        return this.f2462i.next().getKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2462i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2462i.remove();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.f2462i.forEachRemaining(entry -> {
                            action.accept(entry.getKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractReference2ByteMap.this), 65);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteMap, java.util.Map
    public Collection<Byte> values() {
        return new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap.2
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractReference2ByteMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractReference2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractReference2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteIterator iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Reference2ByteMap.Entry<K>> f2463i;

                    {
                        this.f2463i = Reference2ByteMaps.fastIterator(AbstractReference2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f2463i.next().getByteValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2463i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2463i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f2463i.forEachRemaining(entry -> {
                            action.accept(entry.getByteValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteSpliterator spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractReference2ByteMap.this), 320);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.AbstractReference2ByteMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Byte> m) {
        if (m instanceof Reference2ByteMap) {
            ObjectIterator<Reference2ByteMap.Entry<K>> i = Reference2ByteMaps.fastIterator((Reference2ByteMap) m);
            while (i.hasNext()) {
                Reference2ByteMap.Entry<? extends K> e = (Reference2ByteMap.Entry) i.next();
                put((AbstractReference2ByteMap<K>) e.getKey(), e.getByteValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends K, ? extends Byte>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends K, ? extends Byte> e2 = i2.next();
                put((AbstractReference2ByteMap<K>) e2.getKey(), (Byte) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Reference2ByteMap.Entry<K>> i = Reference2ByteMaps.fastIterator(this);
        while (true) {
            n--;
            if (n == 0) {
                return h;
            }
            h += ((Reference2ByteMap.Entry) i.next()).hashCode();
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
        return reference2ByteEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Reference2ByteMap.Entry<K>> i = Reference2ByteMaps.fastIterator(this);
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
                Reference2ByteMap.Entry<K> e = i.next();
                if (this == e.getKey()) {
                    s.append("(this map)");
                } else {
                    s.append(String.valueOf(e.getKey()));
                }
                s.append("=>");
                s.append(String.valueOf((int) e.getByteValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
