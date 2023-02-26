package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap.class */
public class Short2ObjectRBTreeMap<V> extends AbstractShort2ObjectSortedMap<V> implements Serializable, Cloneable {
    protected transient Entry<V> tree;
    protected int count;
    protected transient Entry<V> firstEntry;
    protected transient Entry<V> lastEntry;
    protected transient ObjectSortedSet<Short2ObjectMap.Entry<V>> entries;
    protected transient ShortSortedSet keys;
    protected transient ObjectCollection<V> values;
    protected transient boolean modified;
    protected Comparator<? super Short> storedComparator;
    protected transient ShortComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    private transient Entry<V>[] nodePath;

    public Short2ObjectRBTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = ShortComparators.asShortComparator(this.storedComparator);
    }

    public Short2ObjectRBTreeMap(Comparator<? super Short> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Short2ObjectRBTreeMap(Map<? extends Short, ? extends V> m) {
        this();
        putAll(m);
    }

    public Short2ObjectRBTreeMap(SortedMap<Short, V> m) {
        this(m.comparator());
        putAll(m);
    }

    public Short2ObjectRBTreeMap(Short2ObjectMap<? extends V> m) {
        this();
        putAll(m);
    }

    public Short2ObjectRBTreeMap(Short2ObjectSortedMap<V> m) {
        this(m.comparator());
        putAll(m);
    }

    public Short2ObjectRBTreeMap(short[] k, V[] v, Comparator<? super Short> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (short) v[i]);
        }
    }

    public Short2ObjectRBTreeMap(short[] k, V[] v) {
        this(k, v, null);
    }

    final int compare(short k1, short k2) {
        return this.actualComparator == null ? Short.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    final Entry<V> findKey(short k) {
        int cmp;
        Entry<V> e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry<V> locateKey(short k) {
        Entry<V> e = this.tree;
        Entry<V> last = this.tree;
        int cmp = 0;
        while (e != null) {
            int compare = compare(k, e.key);
            cmp = compare;
            if (compare == 0) {
                break;
            }
            last = e;
            e = cmp < 0 ? e.left() : e.right();
        }
        return cmp == 0 ? e : last;
    }

    private void allocatePaths() {
        this.dirPath = new boolean[64];
        this.nodePath = new Entry[64];
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
    public V put(short k, V v) {
        Entry<V> e = add(k);
        V oldValue = (V) e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
        r8.nodePath[r14] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0050, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0055, code lost:
        if (r14 == 0) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.Entry<V> add(short r9) {
        /*
        // Method dump skipped, instructions count: 935
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.add(short):it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$Entry");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0440, code lost:
        if (r13.succ() != false) goto L_0x044e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x044b, code lost:
        if (r13.right.black() == false) goto L_0x049b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x044e, code lost:
        r0 = r13.left;
        r0.black(true);
        r13.black(false);
        r13.left = r0.right;
        r0.right = r13;
        r6.nodePath[r10 - 1].right = r0;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0488, code lost:
        if (r13.succ() == false) goto L_0x049b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x048b, code lost:
        r13.succ(false);
        r13.right.pred(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x049b, code lost:
        r13.black(r6.nodePath[r10 - 1].black());
        r6.nodePath[r10 - 1].black(true);
        r13.right.black(true);
        r6.nodePath[r10 - 1].right = r13.left;
        r13.left = r6.nodePath[r10 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x04e4, code lost:
        if (r10 >= 2) goto L_0x04f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x04e7, code lost:
        r6.tree = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x04f9, code lost:
        if (r6.dirPath[r10 - 2] == false) goto L_0x050d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x04fc, code lost:
        r6.nodePath[r10 - 2].right = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x050d, code lost:
        r6.nodePath[r10 - 2].left = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0520, code lost:
        if (r13.pred() == false) goto L_0x0731;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0523, code lost:
        r13.pred(false);
        r6.nodePath[r10 - 1].succ(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0631, code lost:
        if (r13.pred() != false) goto L_0x063f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x063c, code lost:
        if (r13.left.black() == false) goto L_0x068c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x063f, code lost:
        r0 = r13.right;
        r0.black(true);
        r13.black(false);
        r13.right = r0.left;
        r0.left = r13;
        r6.nodePath[r10 - 1].left = r0;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0679, code lost:
        if (r13.pred() == false) goto L_0x068c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x067c, code lost:
        r13.pred(false);
        r13.left.succ(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x068c, code lost:
        r13.black(r6.nodePath[r10 - 1].black());
        r6.nodePath[r10 - 1].black(true);
        r13.left.black(true);
        r6.nodePath[r10 - 1].left = r13.right;
        r13.right = r6.nodePath[r10 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x06d5, code lost:
        if (r10 >= 2) goto L_0x06e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x06d8, code lost:
        r6.tree = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x06ea, code lost:
        if (r6.dirPath[r10 - 2] == false) goto L_0x06fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x06ed, code lost:
        r6.nodePath[r10 - 2].right = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x06fe, code lost:
        r6.nodePath[r10 - 2].left = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
        r10 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0711, code lost:
        if (r13.succ() == false) goto L_0x0731;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0714, code lost:
        r13.succ(false);
        r6.nodePath[r10 - 1].pred(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        if (r10 == 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        r6.nodePath[r10] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        return (V) r6.defRetValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        r10 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
        if (r10 == 0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        r6.nodePath[r10] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        return (V) r6.defRetValue;
     */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V remove(short r7) {
        /*
        // Method dump skipped, instructions count: 1895
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.remove(short):java.lang.Object");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, java.util.Map
    public boolean containsValue(Object v) {
        Short2ObjectRBTreeMap<V>.ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (!Objects.equals(i.next(), v));
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public void clear() {
        this.count = 0;
        this.tree = null;
        this.entries = null;
        this.values = null;
        this.keys = null;
        this.lastEntry = null;
        this.firstEntry = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$Entry.class */
    public static final class Entry<V> extends AbstractShort2ObjectMap.BasicEntry<V> implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        Entry<V> left;
        Entry<V> right;
        int info;

        Entry() {
            super((short) 0, (Object) null);
        }

        Entry(short k, V v) {
            super(k, v);
            this.info = -1073741824;
        }

        Entry<V> left() {
            if ((this.info & 1073741824) != 0) {
                return null;
            }
            return this.left;
        }

        Entry<V> right() {
            if ((this.info & Integer.MIN_VALUE) != 0) {
                return null;
            }
            return this.right;
        }

        boolean pred() {
            return (this.info & 1073741824) != 0;
        }

        boolean succ() {
            return (this.info & Integer.MIN_VALUE) != 0;
        }

        void pred(boolean pred) {
            if (pred) {
                this.info |= 1073741824;
            } else {
                this.info &= -1073741825;
            }
        }

        void succ(boolean succ) {
            if (succ) {
                this.info |= Integer.MIN_VALUE;
            } else {
                this.info &= Integer.MAX_VALUE;
            }
        }

        void pred(Entry<V> pred) {
            this.info |= 1073741824;
            this.left = pred;
        }

        void succ(Entry<V> succ) {
            this.info |= Integer.MIN_VALUE;
            this.right = succ;
        }

        void left(Entry<V> left) {
            this.info &= -1073741825;
            this.left = left;
        }

        void right(Entry<V> right) {
            this.info &= Integer.MAX_VALUE;
            this.right = right;
        }

        boolean black() {
            return (this.info & 1) != 0;
        }

        void black(boolean black) {
            if (black) {
                this.info |= 1;
            } else {
                this.info &= -2;
            }
        }

        Entry<V> next() {
            Entry<V> next = this.right;
            if ((this.info & Integer.MIN_VALUE) == 0) {
                while ((next.info & 1073741824) == 0) {
                    next = next.left;
                }
            }
            return next;
        }

        Entry<V> prev() {
            Entry<V> prev = this.left;
            if ((this.info & 1073741824) == 0) {
                while ((prev.info & Integer.MIN_VALUE) == 0) {
                    prev = prev.right;
                }
            }
            return prev;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap.BasicEntry, java.util.Map.Entry
        public V setValue(V value) {
            V oldValue = (V) this.value;
            this.value = value;
            return oldValue;
        }

        @Override // java.lang.Object
        public Entry<V> clone() {
            try {
                Entry<V> c = (Entry) clone();
                c.key = this.key;
                c.value = this.value;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Short, V> e = (Map.Entry) o;
            return this.key == e.getKey().shortValue() && Objects.equals(this.value, e.getValue());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ (this.value == null ? 0 : this.value.hashCode());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap.BasicEntry, java.lang.Object
        public String toString() {
            return ((int) this.key) + "=>" + this.value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
    public boolean containsKey(short k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
    public V get(short k) {
        Entry<V> e = findKey(k);
        return e == null ? (V) this.defRetValue : (V) e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
    public short firstShortKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
    public short lastShortKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry<V> prev;
        Entry<V> next;
        Entry<V> curr;
        int index = 0;

        TreeIterator() {
            this.next = Short2ObjectRBTreeMap.this.firstEntry;
        }

        TreeIterator(short k) {
            Entry<V> locateKey = Short2ObjectRBTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Short2ObjectRBTreeMap.this.compare(this.next.key, k) <= 0) {
                this.prev = this.next;
                this.next = this.next.next();
                return;
            }
            this.prev = this.next.prev();
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public boolean hasPrevious() {
            return this.prev != null;
        }

        void updateNext() {
            this.next = this.next.next();
        }

        Entry<V> nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Entry<V> entry = this.next;
            this.prev = entry;
            this.curr = entry;
            this.index++;
            updateNext();
            return this.curr;
        }

        void updatePrevious() {
            this.prev = this.prev.prev();
        }

        Entry<V> previousEntry() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Entry<V> entry = this.prev;
            this.next = entry;
            this.curr = entry;
            this.index--;
            updatePrevious();
            return this.curr;
        }

        public int nextIndex() {
            return this.index;
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void remove() {
            if (this.curr == null) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                this.index--;
            }
            Entry<V> entry = this.curr;
            this.prev = entry;
            this.next = entry;
            updatePrevious();
            updateNext();
            Short2ObjectRBTreeMap.this.remove(this.curr.key);
            this.curr = null;
        }

        public int skip(int n) {
            int i = n;
            while (true) {
                i--;
                if (i == 0 || !hasNext()) {
                    break;
                }
                nextEntry();
            }
            return (n - i) - 1;
        }

        public int back(int n) {
            int i = n;
            while (true) {
                i--;
                if (i == 0 || !hasPrevious()) {
                    break;
                }
                previousEntry();
            }
            return (n - i) - 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$EntryIterator.class */
    public class EntryIterator extends Short2ObjectRBTreeMap<V>.TreeIterator implements ObjectListIterator<Short2ObjectMap.Entry<V>> {
        EntryIterator() {
            super();
        }

        EntryIterator(short k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Short2ObjectMap.Entry<V> next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Short2ObjectMap.Entry<V> previous() {
            return previousEntry();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
    public ObjectSortedSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Short2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.1
                final Comparator<? super Short2ObjectMap.Entry<V>> comparator;

                {
                    this.comparator = Short2ObjectRBTreeMap.this.actualComparator == null ? x, y -> {
                        return Short.compare(x.getShortKey(), y.getShortKey());
                    } : x, y -> {
                        return Short2ObjectRBTreeMap.this.actualComparator.compare(x.getShortKey(), y.getShortKey());
                    };
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                    return iterator((Short2ObjectMap.Entry) ((Short2ObjectMap.Entry) obj));
                }

                @Override // java.util.SortedSet
                public Comparator<? super Short2ObjectMap.Entry<V>> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> iterator(Short2ObjectMap.Entry<V> from) {
                    return new EntryIterator(from.getShortKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Short)) {
                        return e.equals(Short2ObjectRBTreeMap.this.findKey(((Short) e.getKey()).shortValue()));
                    }
                    return false;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object o) {
                    Entry<V> f;
                    if (!(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() == null || !(e.getKey() instanceof Short) || (f = Short2ObjectRBTreeMap.this.findKey(((Short) e.getKey()).shortValue())) == null || !Objects.equals(f.getValue(), e.getValue())) {
                        return false;
                    }
                    Short2ObjectRBTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Short2ObjectRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Short2ObjectRBTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Short2ObjectMap.Entry<V> first() {
                    return Short2ObjectRBTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Short2ObjectMap.Entry<V> last() {
                    return Short2ObjectRBTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Short2ObjectMap.Entry<V>> subSet(Short2ObjectMap.Entry<V> from, Short2ObjectMap.Entry<V> to) {
                    return Short2ObjectRBTreeMap.this.subMap(from.getShortKey(), to.getShortKey()).short2ObjectEntrySet();
                }

                public ObjectSortedSet<Short2ObjectMap.Entry<V>> headSet(Short2ObjectMap.Entry<V> to) {
                    return Short2ObjectRBTreeMap.this.headMap(to.getShortKey()).short2ObjectEntrySet();
                }

                public ObjectSortedSet<Short2ObjectMap.Entry<V>> tailSet(Short2ObjectMap.Entry<V> from) {
                    return Short2ObjectRBTreeMap.this.tailMap(from.getShortKey()).short2ObjectEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$KeyIterator.class */
    public final class KeyIterator extends Short2ObjectRBTreeMap<V>.TreeIterator implements ShortListIterator {
        public KeyIterator() {
            super();
        }

        public KeyIterator(short k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return previousEntry().key;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$KeySet.class */
    public class KeySet extends AbstractShort2ObjectSortedMap<V>.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap.KeySet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap.KeySet, p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap, p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    public ShortSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$ValueIterator.class */
    public final class ValueIterator extends Short2ObjectRBTreeMap<V>.TreeIterator implements ObjectListIterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public V next() {
            return (V) nextEntry().value;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public V previous() {
            return (V) previousEntry().value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap, p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object k) {
                    return Short2ObjectRBTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Short2ObjectRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Short2ObjectRBTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
    public Comparator<? super Short> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
    public Short2ObjectSortedMap<V> headMap(short to) {
        return new Submap(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
    public Short2ObjectSortedMap<V> tailMap(short from) {
        return new Submap(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
    public Short2ObjectSortedMap<V> subMap(short from, short to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$Submap.class */
    public final class Submap extends AbstractShort2ObjectSortedMap<V> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        short from;

        /* renamed from: to */
        short f2952to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Short2ObjectMap.Entry<V>> entries;
        protected transient ShortSortedSet keys;
        protected transient ObjectCollection<V> values;

        public Submap(short from, boolean bottom, short to, boolean top) {
            if (bottom || top || Short2ObjectRBTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2952to = to;
                this.top = top;
                this.defRetValue = Short2ObjectRBTreeMap.this.defRetValue;
                return;
            }
            throw new IllegalArgumentException("Start key (" + ((int) from) + ") is larger than end key (" + ((int) to) + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            Short2ObjectRBTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                i.nextEntry();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m451in(short k) {
            return (this.bottom || Short2ObjectRBTreeMap.this.compare(k, this.from) >= 0) && (this.top || Short2ObjectRBTreeMap.this.compare(k, this.f2952to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public ObjectSortedSet<Short2ObjectMap.Entry<V>> short2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Short2ObjectMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                    public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                        return iterator((Short2ObjectMap.Entry) ((Short2ObjectMap.Entry) obj));
                    }

                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Short2ObjectMap.Entry<V>> iterator(Short2ObjectMap.Entry<V> from) {
                        return new SubmapEntryIterator(from.getShortKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Short2ObjectMap.Entry<V>> comparator() {
                        return Short2ObjectRBTreeMap.this.short2ObjectEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry<V> f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Short) && (f = Short2ObjectRBTreeMap.this.findKey(((Short) e.getKey()).shortValue())) != null && Submap.this.m451in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Short)) {
                            return false;
                        }
                        Entry<V> f = Short2ObjectRBTreeMap.this.findKey(((Short) e.getKey()).shortValue());
                        if (f != null && Submap.this.m451in(f.key)) {
                            Submap.this.remove(f.key);
                        }
                        return f != null;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public int size() {
                        int c = 0;
                        Iterator<?> i = iterator();
                        while (i.hasNext()) {
                            c++;
                            i.next();
                        }
                        return c;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean isEmpty() {
                        return !new SubmapIterator().hasNext();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public void clear() {
                        Submap.this.clear();
                    }

                    @Override // java.util.SortedSet
                    public Short2ObjectMap.Entry<V> first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Short2ObjectMap.Entry<V> last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Short2ObjectMap.Entry<V>> subSet(Short2ObjectMap.Entry<V> from, Short2ObjectMap.Entry<V> to) {
                        return Submap.this.subMap(from.getShortKey(), to.getShortKey()).short2ObjectEntrySet();
                    }

                    public ObjectSortedSet<Short2ObjectMap.Entry<V>> headSet(Short2ObjectMap.Entry<V> to) {
                        return Submap.this.headMap(to.getShortKey()).short2ObjectEntrySet();
                    }

                    public ObjectSortedSet<Short2ObjectMap.Entry<V>> tailSet(Short2ObjectMap.Entry<V> from) {
                        return Submap.this.tailMap(from.getShortKey()).short2ObjectEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractShort2ObjectSortedMap<V>.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap.KeySet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
            public ShortBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap.KeySet, p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
            public ShortBidirectionalIterator iterator(short from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap, p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public ShortSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectSortedMap, p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap, java.util.Map
        public ObjectCollection<V> values() {
            if (this.values == null) {
                this.values = new AbstractObjectCollection<V>() { // from class: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectIterator<V> iterator() {
                        return new SubmapValueIterator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection
                    public boolean contains(Object k) {
                        return Submap.this.containsValue(k);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection
                    public int size() {
                        return Submap.this.size();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection
                    public void clear() {
                        Submap.this.clear();
                    }
                };
            }
            return this.values;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean containsKey(short k) {
            return m451in(k) && Short2ObjectRBTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, java.util.Map
        public boolean containsValue(Object v) {
            Short2ObjectRBTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (Objects.equals(i.nextEntry().value, v)) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V get(short k) {
            Entry<V> e;
            return (!m451in(k) || (e = Short2ObjectRBTreeMap.this.findKey(k)) == null) ? (V) this.defRetValue : (V) e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V put(short k, V v) {
            Short2ObjectRBTreeMap.this.modified = false;
            if (!m451in(k)) {
                throw new IllegalArgumentException("Key (" + ((int) k) + ") out of range [" + (this.bottom ? "-" : String.valueOf((int) this.from)) + ", " + (this.top ? "-" : String.valueOf((int) this.f2952to)) + ")");
            }
            return Short2ObjectRBTreeMap.this.modified ? (V) this.defRetValue : (V) Short2ObjectRBTreeMap.this.put(k, (short) v);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V remove(short k) {
            Short2ObjectRBTreeMap.this.modified = false;
            if (!m451in(k)) {
                return (V) this.defRetValue;
            }
            return Short2ObjectRBTreeMap.this.modified ? (V) Short2ObjectRBTreeMap.this.remove(k) : (V) this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            Short2ObjectRBTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextEntry();
            }
            return n;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap, java.util.SortedMap
        public Comparator<? super Short> comparator() {
            return Short2ObjectRBTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> headMap(short to) {
            if (!this.top && Short2ObjectRBTreeMap.this.compare(to, this.f2952to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> tailMap(short from) {
            if (!this.bottom && Short2ObjectRBTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2952to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public Short2ObjectSortedMap<V> subMap(short from, short to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Short2ObjectRBTreeMap.this.compare(to, this.f2952to) < 0 ? to : this.f2952to;
            }
            if (!this.bottom) {
                from = Short2ObjectRBTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f2952to) ? new Submap(from, false, to, false) : this;
        }

        public Entry<V> firstEntry() {
            Entry<V> e;
            if (Short2ObjectRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Short2ObjectRBTreeMap.this.firstEntry;
            } else {
                e = Short2ObjectRBTreeMap.this.locateKey(this.from);
                if (Short2ObjectRBTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Short2ObjectRBTreeMap.this.compare(e.key, this.f2952to) < 0) {
                return e;
            }
            return null;
        }

        public Entry<V> lastEntry() {
            Entry<V> e;
            if (Short2ObjectRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Short2ObjectRBTreeMap.this.lastEntry;
            } else {
                e = Short2ObjectRBTreeMap.this.locateKey(this.f2952to);
                if (Short2ObjectRBTreeMap.this.compare(e.key, this.f2952to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Short2ObjectRBTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short firstShortKey() {
            Entry<V> e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectSortedMap
        public short lastShortKey() {
            Entry<V> e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends Short2ObjectRBTreeMap<V>.TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            SubmapIterator(Submap submap, short k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Short2ObjectRBTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Short2ObjectRBTreeMap short2ObjectRBTreeMap = Short2ObjectRBTreeMap.this;
                        Entry<V> lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (short2ObjectRBTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Short2ObjectRBTreeMap.this.locateKey(k);
                    if (Short2ObjectRBTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Short2ObjectRBTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Short2ObjectRBTreeMap.this.compare(this.next.key, Submap.this.f2952to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends Short2ObjectRBTreeMap<V>.Submap.SubmapIterator implements ObjectListIterator<Short2ObjectMap.Entry<V>> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(short k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Short2ObjectMap.Entry<V> next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Short2ObjectMap.Entry<V> previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends Short2ObjectRBTreeMap<V>.Submap.SubmapIterator implements ShortListIterator {
            public SubmapKeyIterator() {
                super();
            }

            public SubmapKeyIterator(short from) {
                super(Submap.this, from);
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public short nextShort() {
                return nextEntry().key;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
            public short previousShort() {
                return previousEntry().key;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectRBTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectRBTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends Short2ObjectRBTreeMap<V>.Submap.SubmapIterator implements ObjectListIterator<V> {
            private SubmapValueIterator() {
                super();
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public V next() {
                return (V) nextEntry().value;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public V previous() {
                return (V) previousEntry().value;
            }
        }
    }

    @Override // java.lang.Object
    public Short2ObjectRBTreeMap<V> clone() {
        try {
            Short2ObjectRBTreeMap<V> c = (Short2ObjectRBTreeMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.allocatePaths();
            if (this.count == 0) {
                return c;
            }
            Entry<V> rp = new Entry<>();
            Entry<V> rq = new Entry<>();
            Entry<V> p = rp;
            rp.left(this.tree);
            Entry<V> q = rq;
            rq.pred((Entry) null);
            loop0: while (true) {
                if (!p.pred()) {
                    Entry<V> e = p.left.clone();
                    e.pred(q.left);
                    e.succ(q);
                    q.left(e);
                    p = p.left;
                    q = q.left;
                } else {
                    while (p.succ()) {
                        p = p.right;
                        if (p == null) {
                            break loop0;
                        }
                        q = q.right;
                    }
                    p = p.right;
                    q = q.right;
                }
                if (!p.succ()) {
                    Entry<V> e2 = p.right.clone();
                    e2.succ(q.right);
                    e2.pred(q);
                    q.right(e2);
                }
            }
            q.right = null;
            c.tree = rq.left;
            c.firstEntry = c.tree;
            while (c.firstEntry.left != null) {
                c.firstEntry = c.firstEntry.left;
            }
            c.lastEntry = c.tree;
            while (c.lastEntry.right != null) {
                c.lastEntry = c.lastEntry.right;
            }
            return c;
        } catch (CloneNotSupportedException e3) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        int n = this.count;
        Short2ObjectRBTreeMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                Entry<V> e = i.nextEntry();
                s.writeShort(e.key);
                s.writeObject(e.value);
            } else {
                return;
            }
        }
    }

    private Entry<V> readTree(ObjectInputStream s, int n, Entry<V> pred, Entry<V> succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry<V> top = new Entry<>(s.readShort(), s.readObject());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry<V> top2 = new Entry<>(s.readShort(), s.readObject());
            top2.black(true);
            top2.right(new Entry<>(s.readShort(), s.readObject()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry<V> top3 = new Entry<>();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readShort();
            top3.value = s.readObject();
            top3.black(true);
            top3.right(readTree(s, rightN, top3, succ));
            if (n + 2 == ((n + 2) & (-(n + 2)))) {
                top3.right.black(false);
            }
            return top3;
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        setActualComparator();
        allocatePaths();
        if (this.count != 0) {
            this.tree = readTree(s, this.count, null, null);
            Entry<V> e = this.tree;
            while (e.left() != null) {
                e = e.left();
            }
            this.firstEntry = e;
            Entry<V> e2 = this.tree;
            while (e2.right() != null) {
                e2 = e2.right();
            }
            this.lastEntry = e2;
        }
    }
}
