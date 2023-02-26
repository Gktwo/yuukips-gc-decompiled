package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanMap.class */
public abstract class AbstractShort2BooleanMap extends AbstractShort2BooleanFunction implements Short2BooleanMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap
    public boolean containsKey(short k) {
        ObjectIterator<Short2BooleanMap.Entry> i = short2BooleanEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getShortKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap
    public boolean containsValue(boolean v) {
        ObjectIterator<Short2BooleanMap.Entry> i = short2BooleanEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getBooleanValue() == v) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanMap$BasicEntry.class */
    public static class BasicEntry implements Short2BooleanMap.Entry {
        protected short key;
        protected boolean value;

        public BasicEntry() {
        }

        public BasicEntry(Short key, Boolean value) {
            this.key = key.shortValue();
            this.value = value.booleanValue();
        }

        public BasicEntry(short key, boolean value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap.Entry
        public short getShortKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap.Entry
        public boolean getBooleanValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap.Entry
        public boolean setValue(boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2BooleanMap.Entry) {
                Short2BooleanMap.Entry e = (Short2BooleanMap.Entry) o;
                return this.key == e.getShortKey() && this.value == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Short) && (value = e2.getValue()) != null && (value instanceof Boolean) && this.key == ((Short) key).shortValue() && this.value == ((Boolean) value).booleanValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ (this.value ? (short) 1231 : 1237);
        }

        @Override // java.lang.Object
        public String toString() {
            return ((int) this.key) + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Short2BooleanMap.Entry> {
        protected final Short2BooleanMap map;

        public BasicEntrySet(Short2BooleanMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2BooleanMap.Entry) {
                Short2BooleanMap.Entry e = (Short2BooleanMap.Entry) o;
                short k = e.getShortKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Short)) {
                return false;
            }
            short k2 = ((Short) key).shortValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Boolean) && this.map.containsKey(k2) && this.map.get(k2) == ((Boolean) value).booleanValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Short2BooleanMap.Entry) {
                Short2BooleanMap.Entry e = (Short2BooleanMap.Entry) o;
                return this.map.remove(e.getShortKey(), e.getBooleanValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Short)) {
                return false;
            }
            short k = ((Short) key).shortValue();
            Object value = e2.getValue();
            if (value == null || !(value instanceof Boolean)) {
                return false;
            }
            return this.map.remove(k, ((Boolean) value).booleanValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
        public ObjectSpliterator<Short2BooleanMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
    public Set<Short> keySet() {
        return new AbstractShortSet() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap.1
            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
            public boolean contains(short k) {
                return AbstractShort2BooleanMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractShort2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractShort2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortIterator iterator() {
                return new ShortIterator() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Short2BooleanMap.Entry> f2811i;

                    {
                        this.f2811i = Short2BooleanMaps.fastIterator(AbstractShort2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public short nextShort() {
                        return this.f2811i.next().getShortKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2811i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2811i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
                    public void forEachRemaining(ShortConsumer action) {
                        this.f2811i.forEachRemaining(entry -> {
                            action.accept(entry.getShortKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortSpliterator spliterator() {
                return ShortSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractShort2BooleanMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
    public Collection<Boolean> values() {
        return new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap.2
            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
            public boolean contains(boolean k) {
                return AbstractShort2BooleanMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractShort2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractShort2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanIterator iterator() {
                return new BooleanIterator() { // from class: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Short2BooleanMap.Entry> f2812i;

                    {
                        this.f2812i = Short2BooleanMaps.fastIterator(AbstractShort2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public boolean nextBoolean() {
                        return this.f2812i.next().getBooleanValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f2812i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f2812i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public void forEachRemaining(BooleanConsumer action) {
                        this.f2812i.forEachRemaining(entry -> {
                            action.accept(entry.getBooleanValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanSpliterator spliterator() {
                return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractShort2BooleanMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Short, ? extends Boolean> m) {
        if (m instanceof Short2BooleanMap) {
            ObjectIterator<Short2BooleanMap.Entry> i = Short2BooleanMaps.fastIterator((Short2BooleanMap) m);
            while (i.hasNext()) {
                Short2BooleanMap.Entry e = i.next();
                put(e.getShortKey(), e.getBooleanValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Short, ? extends Boolean>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Short, ? extends Boolean> e2 = i2.next();
                put((Short) e2.getKey(), (Boolean) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Short2BooleanMap.Entry> i = Short2BooleanMaps.fastIterator(this);
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
        return short2BooleanEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Short2BooleanMap.Entry> i = Short2BooleanMaps.fastIterator(this);
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
                Short2BooleanMap.Entry e = i.next();
                s.append(String.valueOf((int) e.getShortKey()));
                s.append("=>");
                s.append(String.valueOf(e.getBooleanValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
