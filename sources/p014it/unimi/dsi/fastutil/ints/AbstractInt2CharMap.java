package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.ints.Int2CharMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharMap.class */
public abstract class AbstractInt2CharMap extends AbstractInt2CharFunction implements Int2CharMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction, p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public boolean containsKey(int k) {
        ObjectIterator<Int2CharMap.Entry> i = int2CharEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getIntKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap
    public boolean containsValue(char v) {
        ObjectIterator<Int2CharMap.Entry> i = int2CharEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharMap$BasicEntry.class */
    public static class BasicEntry implements Int2CharMap.Entry {
        protected int key;
        protected char value;

        public BasicEntry() {
        }

        public BasicEntry(Integer key, Character value) {
            this.key = key.intValue();
            this.value = value.charValue();
        }

        public BasicEntry(int key, char value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry
        public int getIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry
        public char getCharValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap.Entry
        public char setValue(char value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2CharMap.Entry) {
                Int2CharMap.Entry e = (Int2CharMap.Entry) o;
                return this.key == e.getIntKey() && this.value == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Integer) && (value = e2.getValue()) != null && (value instanceof Character) && this.key == ((Integer) key).intValue() && this.value == ((Character) value).charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Int2CharMap.Entry> {
        protected final Int2CharMap map;

        public BasicEntrySet(Int2CharMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2CharMap.Entry) {
                Int2CharMap.Entry e = (Int2CharMap.Entry) o;
                int k = e.getIntKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Integer)) {
                return false;
            }
            int k2 = ((Integer) key).intValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Character) && this.map.containsKey(k2) && this.map.get(k2) == ((Character) value).charValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2CharMap.Entry) {
                Int2CharMap.Entry e = (Int2CharMap.Entry) o;
                return this.map.remove(e.getIntKey(), e.getCharValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Integer)) {
                return false;
            }
            int k = ((Integer) key).intValue();
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
        public ObjectSpliterator<Int2CharMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    public Set<Integer> keySet() {
        return new AbstractIntSet() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2CharMap.1
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractInt2CharMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractInt2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractInt2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2CharMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Int2CharMap.Entry> f1947i;

                    {
                        this.f1947i = Int2CharMaps.fastIterator(AbstractInt2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f1947i.next().getIntKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1947i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1947i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f1947i.forEachRemaining(entry -> {
                            action.accept(entry.getIntKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractInt2CharMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharMap, java.util.Map
    public Collection<Character> values() {
        return new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2CharMap.2
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractInt2CharMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractInt2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractInt2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2CharMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Int2CharMap.Entry> f1948i;

                    {
                        this.f1948i = Int2CharMaps.fastIterator(AbstractInt2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f1948i.next().getCharValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1948i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1948i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f1948i.forEachRemaining(entry -> {
                            action.accept(entry.getCharValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractInt2CharMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends Character> m) {
        if (m instanceof Int2CharMap) {
            ObjectIterator<Int2CharMap.Entry> i = Int2CharMaps.fastIterator((Int2CharMap) m);
            while (i.hasNext()) {
                Int2CharMap.Entry e = i.next();
                put(e.getIntKey(), e.getCharValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Integer, ? extends Character>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Integer, ? extends Character> e2 = i2.next();
                put((Integer) e2.getKey(), (Character) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Int2CharMap.Entry> i = Int2CharMaps.fastIterator(this);
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
        return int2CharEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Int2CharMap.Entry> i = Int2CharMaps.fastIterator(this);
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
                Int2CharMap.Entry e = i.next();
                s.append(String.valueOf(e.getIntKey()));
                s.append("=>");
                s.append(String.valueOf(e.getCharValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
