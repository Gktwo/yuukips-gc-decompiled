package p014it.unimi.dsi.fastutil.chars;

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
import p014it.unimi.dsi.fastutil.chars.Char2ByteMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteMap.class */
public abstract class AbstractChar2ByteMap extends AbstractChar2ByteFunction implements Char2ByteMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteFunction, p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public boolean containsKey(char k) {
        ObjectIterator<Char2ByteMap.Entry> i = char2ByteEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getCharKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
    public boolean containsValue(byte v) {
        ObjectIterator<Char2ByteMap.Entry> i = char2ByteEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteMap$BasicEntry.class */
    public static class BasicEntry implements Char2ByteMap.Entry {
        protected char key;
        protected byte value;

        public BasicEntry() {
        }

        public BasicEntry(Character key, Byte value) {
            this.key = key.charValue();
            this.value = value.byteValue();
        }

        public BasicEntry(char key, byte value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry
        public char getCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry
        public byte getByteValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.Entry
        public byte setValue(byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2ByteMap.Entry) {
                Char2ByteMap.Entry e = (Char2ByteMap.Entry) o;
                return this.key == e.getCharKey() && this.value == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Character) && (value = e2.getValue()) != null && (value instanceof Byte) && this.key == ((Character) key).charValue() && this.value == ((Byte) value).byteValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + ((int) this.value);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Char2ByteMap.Entry> {
        protected final Char2ByteMap map;

        public BasicEntrySet(Char2ByteMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2ByteMap.Entry) {
                Char2ByteMap.Entry e = (Char2ByteMap.Entry) o;
                char k = e.getCharKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getByteValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            char k2 = ((Character) key).charValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Byte) && this.map.containsKey(k2) && this.map.get(k2) == ((Byte) value).byteValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2ByteMap.Entry) {
                Char2ByteMap.Entry e = (Char2ByteMap.Entry) o;
                return this.map.remove(e.getCharKey(), e.getByteValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            char k = ((Character) key).charValue();
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
        public ObjectSpliterator<Char2ByteMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    public Set<Character> keySet() {
        return new AbstractCharSet() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap.1
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractChar2ByteMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractChar2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractChar2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Char2ByteMap.Entry> f1274i;

                    {
                        this.f1274i = Char2ByteMaps.fastIterator(AbstractChar2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f1274i.next().getCharKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1274i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1274i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f1274i.forEachRemaining(entry -> {
                            action.accept(entry.getCharKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractChar2ByteMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    public Collection<Byte> values() {
        return new AbstractByteCollection() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap.2
            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
            public boolean contains(byte k) {
                return AbstractChar2ByteMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractChar2ByteMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractChar2ByteMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteIterator iterator() {
                return new ByteIterator() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2ByteMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Char2ByteMap.Entry> f1275i;

                    {
                        this.f1275i = Char2ByteMaps.fastIterator(AbstractChar2ByteMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public byte nextByte() {
                        return this.f1275i.next().getByteValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1275i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1275i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
                    public void forEachRemaining(ByteConsumer action) {
                        this.f1275i.forEachRemaining(entry -> {
                            action.accept(entry.getByteValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteSpliterator spliterator() {
                return ByteSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractChar2ByteMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Character, ? extends Byte> m) {
        if (m instanceof Char2ByteMap) {
            ObjectIterator<Char2ByteMap.Entry> i = Char2ByteMaps.fastIterator((Char2ByteMap) m);
            while (i.hasNext()) {
                Char2ByteMap.Entry e = i.next();
                put(e.getCharKey(), e.getByteValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Character, ? extends Byte>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Character, ? extends Byte> e2 = i2.next();
                put((Character) e2.getKey(), (Byte) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Char2ByteMap.Entry> i = Char2ByteMaps.fastIterator(this);
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
        return char2ByteEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Char2ByteMap.Entry> i = Char2ByteMaps.fastIterator(this);
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
                Char2ByteMap.Entry e = i.next();
                s.append(String.valueOf(e.getCharKey()));
                s.append("=>");
                s.append(String.valueOf((int) e.getByteValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
