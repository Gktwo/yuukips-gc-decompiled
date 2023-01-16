package p014it.unimi.dsi.fastutil.ints;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntConsumer;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSpliterators;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanMap.class */
public abstract class AbstractInt2BooleanMap extends AbstractInt2BooleanFunction implements Int2BooleanMap, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap
    public boolean containsKey(int k) {
        ObjectIterator<Int2BooleanMap.Entry> i = int2BooleanEntrySet().iterator();
        while (i.hasNext()) {
            if (i.next().getIntKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap
    public boolean containsValue(boolean v) {
        ObjectIterator<Int2BooleanMap.Entry> i = int2BooleanEntrySet().iterator();
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

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap$BasicEntry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanMap$BasicEntry.class */
    public static class BasicEntry implements Int2BooleanMap.Entry {
        protected int key;
        protected boolean value;

        public BasicEntry() {
        }

        public BasicEntry(Integer key, Boolean value) {
            this.key = key.intValue();
            this.value = value.booleanValue();
        }

        public BasicEntry(int key, boolean value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap.Entry
        public int getIntKey() {
            return this.key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap.Entry
        public boolean getBooleanValue() {
            return this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap.Entry
        public boolean setValue(boolean value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            Object value;
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2BooleanMap.Entry) {
                Int2BooleanMap.Entry e = (Int2BooleanMap.Entry) o;
                return this.key == e.getIntKey() && this.value == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            return key != null && (key instanceof Integer) && (value = e2.getValue()) != null && (value instanceof Boolean) && this.key == ((Integer) key).intValue() && this.value == ((Boolean) value).booleanValue();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ (this.value ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "->" + this.value;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap$BasicEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanMap$BasicEntrySet.class */
    public static abstract class BasicEntrySet extends AbstractObjectSet<Int2BooleanMap.Entry> {
        protected final Int2BooleanMap map;

        public BasicEntrySet(Int2BooleanMap map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2BooleanMap.Entry) {
                Int2BooleanMap.Entry e = (Int2BooleanMap.Entry) o;
                int k = e.getIntKey();
                return this.map.containsKey(k) && this.map.get(k) == e.getBooleanValue();
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Integer)) {
                return false;
            }
            int k2 = ((Integer) key).intValue();
            Object value = e2.getValue();
            return value != null && (value instanceof Boolean) && this.map.containsKey(k2) && this.map.get(k2) == ((Boolean) value).booleanValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            if (o instanceof Int2BooleanMap.Entry) {
                Int2BooleanMap.Entry e = (Int2BooleanMap.Entry) o;
                return this.map.remove(e.getIntKey(), e.getBooleanValue());
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o;
            Object key = e2.getKey();
            if (key == null || !(key instanceof Integer)) {
                return false;
            }
            int k = ((Integer) key).intValue();
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
        public ObjectSpliterator<Int2BooleanMap.Entry> spliterator() {
            return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
    public Set<Integer> keySet() {
        return new AbstractIntSet() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap.1
            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
            public boolean contains(int k) {
                return AbstractInt2BooleanMap.this.containsKey(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractInt2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AbstractInt2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntIterator iterator() {
                return new IntIterator() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap.1.1

                    /* renamed from: i */
                    private final ObjectIterator<Int2BooleanMap.Entry> f1975i;

                    {
                        this.f1975i = Int2BooleanMaps.fastIterator(AbstractInt2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
                    public int nextInt() {
                        return this.f1975i.next().getIntKey();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1975i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1975i.remove();
                    }

                    @Override // java.util.PrimitiveIterator.OfInt
                    public void forEachRemaining(IntConsumer action) {
                        this.f1975i.forEachRemaining(entry -> {
                            action.accept(entry.getIntKey());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntSpliterator spliterator() {
                return IntSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractInt2BooleanMap.this), 321);
            }
        };
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanMap, java.util.Map
    public Collection<Boolean> values() {
        return new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap.2
            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
            public boolean contains(boolean k) {
                return AbstractInt2BooleanMap.this.containsValue(k);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return AbstractInt2BooleanMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                AbstractInt2BooleanMap.this.clear();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanIterator iterator() {
                return new BooleanIterator() { // from class: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanMap.2.1

                    /* renamed from: i */
                    private final ObjectIterator<Int2BooleanMap.Entry> f1976i;

                    {
                        this.f1976i = Int2BooleanMaps.fastIterator(AbstractInt2BooleanMap.this);
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public boolean nextBoolean() {
                        return this.f1976i.next().getBooleanValue();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f1976i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f1976i.remove();
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
                    public void forEachRemaining(BooleanConsumer action) {
                        this.f1976i.forEachRemaining(entry -> {
                            action.accept(entry.getBooleanValue());
                        });
                    }
                };
            }

            @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
            public BooleanSpliterator spliterator() {
                return BooleanSpliterators.asSpliterator(iterator(), Size64.sizeOf(AbstractInt2BooleanMap.this), 320);
            }
        };
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends Boolean> m) {
        if (m instanceof Int2BooleanMap) {
            ObjectIterator<Int2BooleanMap.Entry> i = Int2BooleanMaps.fastIterator((Int2BooleanMap) m);
            while (i.hasNext()) {
                Int2BooleanMap.Entry e = i.next();
                put(e.getIntKey(), e.getBooleanValue());
            }
            return;
        }
        int n = m.size();
        Iterator<? extends Map.Entry<? extends Integer, ? extends Boolean>> i2 = m.entrySet().iterator();
        while (true) {
            n--;
            if (n != 0) {
                Map.Entry<? extends Integer, ? extends Boolean> e2 = i2.next();
                put((Integer) e2.getKey(), (Boolean) e2.getValue());
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int h = 0;
        int n = size();
        ObjectIterator<Int2BooleanMap.Entry> i = Int2BooleanMaps.fastIterator(this);
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
        return int2BooleanEntrySet().containsAll(m.entrySet());
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ObjectIterator<Int2BooleanMap.Entry> i = Int2BooleanMaps.fastIterator(this);
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
                Int2BooleanMap.Entry e = i.next();
                s.append(String.valueOf(e.getIntKey()));
                s.append("=>");
                s.append(String.valueOf(e.getBooleanValue()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
