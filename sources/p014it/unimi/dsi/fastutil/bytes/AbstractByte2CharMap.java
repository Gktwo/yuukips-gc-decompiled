package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharMap;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharMap.class */
public abstract class AbstractByte2CharMap extends AbstractByte2CharFunction implements Byte2CharMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap
    public boolean containsKey(byte k) {
        ObjectIterator<Byte2CharMap.Entry> i = byte2CharEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getByteKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMap
    public boolean containsValue(char v) {
        ObjectIterator<Byte2CharMap.Entry> i = byte2CharEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharMap$BasicEntry.class */
    public static class BasicEntry implements Byte2CharMap.Entry {
        protected byte key;
        protected char value;

        public BasicEntry() {
        }

        public BasicEntry(Byte key, Character value) {
            this.key = key.byteValue();
            this.value = value.charValue();
        }

        public BasicEntry(byte key, char value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMap.Entry
        public byte getByteKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMap.Entry
        public char getCharValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMap.Entry
        public char setValue(char value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2CharMap.Entry) {
                Byte2CharMap.Entry e = (Byte2CharMap.Entry) o;
                return this.key == e.getByteKey() && this.value == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Byte) && (value = e2.getValue()) != null && (value instanceof Character) && this.key == ((Byte) key).byteValue() && this.value == ((Character) value).charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) this.key) + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Byte2CharMap.Entry> {
        protected final Byte2CharMap map;

        public BasicEntrySet(Byte2CharMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2CharMap.Entry) {
                Byte2CharMap.Entry e = (Byte2CharMap.Entry) o;
                byte k = e.getByteKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k2 = ((Byte) key).byteValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Character) && this.map.containsKey(k2) && this.map.get(k2) == ((Character) value).charValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Byte2CharMap.Entry) {
                Byte2CharMap.Entry e = (Byte2CharMap.Entry) o;
                return this.map.remove(e.getByteKey(), e.getCharValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Byte)) {
                return false;
            }
            byte k = ((Byte) key).byteValue();
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
        public ObjectSpliterator<Byte2CharMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
    public Set<Byte> keySet() {
        return new AbstractByteSet() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap.1
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractByte2CharMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractByte2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractByte2CharMap.this.clear();
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Iterator<Byte> iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2CharMap.Entry> f1051i;

                    {
                        this.f1051i = Byte2CharMaps.fastIterator(AbstractByte2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f1051i.next().getByteKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1051i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1051i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f1051i.forEachRemaining(entry -> {
                            action.accept(entry.getByteKey());
                        });
                    }
                };
            }

            /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
            /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteIterator] */
            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public Spliterator<Byte> spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2CharMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharMap, java.util.Map
    public Collection<Character> values() {
        return new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap.2
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractByte2CharMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractByte2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractByte2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.bytes.AbstractByte2CharMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Byte2CharMap.Entry> f1052i;

                    {
                        this.f1052i = Byte2CharMaps.fastIterator(AbstractByte2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f1052i.next().getCharValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1052i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1052i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f1052i.forEachRemaining(entry -> {
                            action.accept(entry.getCharValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractByte2CharMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Byte, ? extends Character> m) {
        if (m instanceof Byte2CharMap) {
            ObjectIterator<Byte2CharMap.Entry> i = Byte2CharMaps.fastIterator((Byte2CharMap) m);
            while (i.hasNext()) {
                Byte2CharMap.Entry e = i.next();
                put(e.getByteKey(), e.getCharValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Byte, ? extends Character>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Byte, ? extends Character> e2 = i2.next();
                put((Byte) e2.getKey(), (Character) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Byte2CharMap.Entry> i = Byte2CharMaps.fastIterator(this);
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
        return byte2CharEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Byte2CharMap.Entry> i = Byte2CharMaps.fastIterator(this);
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
                Byte2CharMap.Entry e = i.next();
                s.append(String.valueOf((int) e.getByteKey()));
                s.append("=>");
                s.append(String.valueOf(e.getCharValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
