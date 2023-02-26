package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharConsumer;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;
import p014it.unimi.dsi.fastutil.floats.Float2CharMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2CharMap.class */
public abstract class AbstractFloat2CharMap extends AbstractFloat2CharFunction implements Float2CharMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharFunction, p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public boolean containsKey(float k) {
        ObjectIterator<Float2CharMap.Entry> i = float2CharEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getFloatKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap
    public boolean containsValue(char v) {
        ObjectIterator<Float2CharMap.Entry> i = float2CharEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2CharMap$BasicEntry.class */
    public static class BasicEntry implements Float2CharMap.Entry {
        protected float key;
        protected char value;

        public BasicEntry() {
        }

        public BasicEntry(Float key, Character value) {
            this.key = key.floatValue();
            this.value = value.charValue();
        }

        public BasicEntry(float key, char value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry
        public float getFloatKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry
        public char getCharValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap.Entry
        public char setValue(char value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2CharMap.Entry) {
                Float2CharMap.Entry e = (Float2CharMap.Entry) o;
                return Float.floatToIntBits(this.key) == Float.floatToIntBits(e.getFloatKey()) && this.value == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Float) && (value = e2.getValue()) != null && (value instanceof Character) && Float.floatToIntBits(this.key) == Float.floatToIntBits(((Float) key).floatValue()) && this.value == ((Character) value).charValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2CharMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Float2CharMap.Entry> {
        protected final Float2CharMap map;

        public BasicEntrySet(Float2CharMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2CharMap.Entry) {
                Float2CharMap.Entry e = (Float2CharMap.Entry) o;
                float k = e.getFloatKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getCharValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k2 = ((Float) key).floatValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Character) && this.map.containsKey(k2) && this.map.get(k2) == ((Character) value).charValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Float2CharMap.Entry) {
                Float2CharMap.Entry e = (Float2CharMap.Entry) o;
                return this.map.remove(e.getFloatKey(), e.getCharValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Float)) {
                return false;
            }
            float k = ((Float) key).floatValue();
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
        public ObjectSpliterator<Float2CharMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    public Set<Float> keySet() {
        return new AbstractFloatSet() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap.1
            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
            public boolean contains(float k) {
                return AbstractFloat2CharMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractFloat2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractFloat2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatIterator iterator() {
                return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2CharMap.Entry> f1726i;

                    {
                        this.f1726i = Float2CharMaps.fastIterator(AbstractFloat2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public float nextFloat() {
                        return this.f1726i.next().getFloatKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1726i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1726i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
                    public void forEachRemaining(FloatConsumer action) {
                        this.f1726i.forEachRemaining(entry -> {
                            action.accept(entry.getFloatKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatSpliterator spliterator() {
                return FloatSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2CharMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2CharMap, java.util.Map
    public Collection<Character> values() {
        return new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap.2
            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
            public boolean contains(char k) {
                return AbstractFloat2CharMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractFloat2CharMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractFloat2CharMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharIterator iterator() {
                return new CharIterator() { // from class: it.unimi.dsi.fastutil.floats.AbstractFloat2CharMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Float2CharMap.Entry> f1727i;

                    {
                        this.f1727i = Float2CharMaps.fastIterator(AbstractFloat2CharMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public char nextChar() {
                        return this.f1727i.next().getCharValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1727i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1727i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
                    public void forEachRemaining(CharConsumer action) {
                        this.f1727i.forEachRemaining(entry -> {
                            action.accept(entry.getCharValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharSpliterator spliterator() {
                return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractFloat2CharMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Float, ? extends Character> m) {
        if (m instanceof Float2CharMap) {
            ObjectIterator<Float2CharMap.Entry> i = Float2CharMaps.fastIterator((Float2CharMap) m);
            while (i.hasNext()) {
                Float2CharMap.Entry e = i.next();
                put(e.getFloatKey(), e.getCharValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Float, ? extends Character>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Float, ? extends Character> e2 = i2.next();
                put((Float) e2.getKey(), (Character) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Float2CharMap.Entry> i = Float2CharMaps.fastIterator(this);
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
        return float2CharEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Float2CharMap.Entry> i = Float2CharMaps.fastIterator(this);
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
                Float2CharMap.Entry e = i.next();
                s.append(String.valueOf(e.getFloatKey()));
                s.append("=>");
                s.append(String.valueOf(e.getCharValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
