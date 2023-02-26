package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.Char2IntMap;
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2IntMap.class */
public abstract class AbstractChar2IntMap extends AbstractChar2IntFunction implements Char2IntMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntMap
    public boolean containsKey(char k) {
        ObjectIterator<Char2IntMap.Entry> i = char2IntEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getCharKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap
    public boolean containsValue(int v) {
        ObjectIterator<Char2IntMap.Entry> i = char2IntEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getIntValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap
    public final int mergeInt(char key, int value, IntBinaryOperator remappingFunction) {
        return mergeInt(key, value, (java.util.function.IntBinaryOperator) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2IntMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2IntMap$BasicEntry.class */
    public static class BasicEntry implements Char2IntMap.Entry {
        protected char key;
        protected int value;

        public BasicEntry() {
        }

        public BasicEntry(Character key, Integer value) {
            this.key = key.charValue();
            this.value = value.intValue();
        }

        public BasicEntry(char key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap.Entry
        public char getCharKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap.Entry
        public int getIntValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap.Entry
        public int setValue(int value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2IntMap.Entry) {
                Char2IntMap.Entry e = (Char2IntMap.Entry) o;
                return this.key == e.getCharKey() && this.value == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Character) && (value = e2.getValue()) != null && (value instanceof Integer) && this.key == ((Character) key).charValue() && this.value == ((Integer) value).intValue();
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

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2IntMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2IntMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Char2IntMap.Entry> {
        protected final Char2IntMap map;

        public BasicEntrySet(Char2IntMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2IntMap.Entry) {
                Char2IntMap.Entry e = (Char2IntMap.Entry) o;
                char k = e.getCharKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getIntValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            char k2 = ((Character) key).charValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Integer) && this.map.containsKey(k2) && this.map.get(k2) == ((Integer) value).intValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Char2IntMap.Entry) {
                Char2IntMap.Entry e = (Char2IntMap.Entry) o;
                return this.map.remove(e.getCharKey(), e.getIntValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Character)) {
                return false;
            }
            char k = ((Character) key).charValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Integer)) {
                return false;
            }
            return this.map.remove(k, ((Integer) value).intValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Char2IntMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap, java.util.Map
    public Set<Character> keySet() {
        return new AbstractCharSet() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2IntMap.1
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractChar2IntMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractChar2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractChar2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2IntMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Char2IntMap.Entry> f1290i;

                    {
                        this.f1290i = Char2IntMaps.fastIterator(AbstractChar2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f1290i.next().getCharKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1290i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1290i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f1290i.forEachRemaining(entry -> {
                            action.accept(entry.getCharKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractChar2IntMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap, java.util.Map
    public Collection<Integer> values() {
        return new AbstractIntCollection() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2IntMap.2
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractChar2IntMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractChar2IntMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractChar2IntMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.chars.AbstractChar2IntMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Char2IntMap.Entry> f1291i;

                    {
                        this.f1291i = Char2IntMaps.fastIterator(AbstractChar2IntMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f1291i.next().getIntValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1291i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1291i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f1291i.forEachRemaining(entry -> {
                            action.accept(entry.getIntValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractChar2IntMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Character, ? extends Integer> m) {
        if (m instanceof Char2IntMap) {
            ObjectIterator<Char2IntMap.Entry> i = Char2IntMaps.fastIterator((Char2IntMap) m);
            while (i.hasNext()) {
                Char2IntMap.Entry e = i.next();
                put(e.getCharKey(), e.getIntValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Character, ? extends Integer>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Character, ? extends Integer> e2 = i2.next();
                put((Character) e2.getKey(), (Integer) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Char2IntMap.Entry> i = Char2IntMaps.fastIterator(this);
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
        return char2IntEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Char2IntMap.Entry> i = Char2IntMaps.fastIterator(this);
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
                Char2IntMap.Entry e = i.next();
                s.append(String.valueOf(e.getCharKey()));
                s.append("=>");
                s.append(String.valueOf(e.getIntValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
