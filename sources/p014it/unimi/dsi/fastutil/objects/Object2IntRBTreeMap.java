package p014it.unimi.dsi.fastutil.objects;

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
import p014it.unimi.dsi.fastutil.ints.AbstractIntCollection;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntListIterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap;
import p014it.unimi.dsi.fastutil.objects.Object2IntMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap.class */
public class Object2IntRBTreeMap<K> extends AbstractObject2IntSortedMap<K> implements Serializable, Cloneable {
    protected transient Entry<K> tree;
    protected int count;
    protected transient Entry<K> firstEntry;
    protected transient Entry<K> lastEntry;
    protected transient ObjectSortedSet<Object2IntMap.Entry<K>> entries;
    protected transient ObjectSortedSet<K> keys;
    protected transient IntCollection values;
    protected transient boolean modified;
    protected Comparator<? super K> storedComparator;
    protected transient Comparator<? super K> actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    private transient Entry<K>[] nodePath;

    public Object2IntRBTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = this.storedComparator;
    }

    public Object2IntRBTreeMap(Comparator<? super K> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Object2IntRBTreeMap(Map<? extends K, ? extends Integer> m) {
        this();
        putAll(m);
    }

    public Object2IntRBTreeMap(SortedMap<K, Integer> m) {
        this(m.comparator());
        putAll(m);
    }

    public Object2IntRBTreeMap(Object2IntMap<? extends K> m) {
        this();
        putAll(m);
    }

    public Object2IntRBTreeMap(Object2IntSortedMap<K> m) {
        this(m.comparator());
        putAll(m);
    }

    public Object2IntRBTreeMap(K[] k, int[] v, Comparator<? super K> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Object2IntRBTreeMap<K>) k[i], v[i]);
        }
    }

    public Object2IntRBTreeMap(K[] k, int[] v) {
        this(k, v, null);
    }

    final int compare(K k1, K k2) {
        return this.actualComparator == null ? ((Comparable) k1).compareTo(k2) : this.actualComparator.compare(k1, k2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    final Entry<K> findKey(K k) {
        int cmp;
        Entry<K> e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    final Entry<K> locateKey(K k) {
        Entry<K> e = this.tree;
        Entry<K> last = this.tree;
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

    public int addTo(K k, int incr) {
        Entry<K> e = add(k);
        int oldValue = e.value;
        e.value += incr;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
    public int put(K k, int v) {
        Entry<K> e = add(k);
        int oldValue = e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005d, code lost:
        r8.nodePath[r14] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006a, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0055, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005a, code lost:
        if (r14 == 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.Entry<K> add(K r9) {
        /*
        // Method dump skipped, instructions count: 940
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.add(java.lang.Object):it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Entry");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
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
        return r6.defRetValue;
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
        return r6.defRetValue;
     */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int removeInt(java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 1895
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.removeInt(java.lang.Object):int");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntMap
    public boolean containsValue(int v) {
        Object2IntRBTreeMap<K>.ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (i.nextInt() != v);
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$Entry.class */
    public static final class Entry<K> extends AbstractObject2IntMap.BasicEntry<K> implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        Entry<K> left;
        Entry<K> right;
        int info;

        Entry() {
            super((Object) null, 0);
        }

        Entry(K k, int v) {
            super(k, v);
            this.info = -1073741824;
        }

        Entry<K> left() {
            if ((this.info & 1073741824) != 0) {
                return null;
            }
            return this.left;
        }

        Entry<K> right() {
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

        void pred(Entry<K> pred) {
            this.info |= 1073741824;
            this.left = pred;
        }

        void succ(Entry<K> succ) {
            this.info |= Integer.MIN_VALUE;
            this.right = succ;
        }

        void left(Entry<K> left) {
            this.info &= -1073741825;
            this.left = left;
        }

        void right(Entry<K> right) {
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

        Entry<K> next() {
            Entry<K> next = this.right;
            if ((this.info & Integer.MIN_VALUE) == 0) {
                while ((next.info & 1073741824) == 0) {
                    next = next.left;
                }
            }
            return next;
        }

        Entry<K> prev() {
            Entry<K> prev = this.left;
            if ((this.info & 1073741824) == 0) {
                while ((prev.info & Integer.MIN_VALUE) == 0) {
                    prev = prev.right;
                }
            }
            return prev;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap.BasicEntry, p014it.unimi.dsi.fastutil.objects.Object2IntMap.Entry
        public int setValue(int value) {
            int oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override // java.lang.Object
        public Entry<K> clone() {
            try {
                Entry<K> c = (Entry) clone();
                c.key = this.key;
                c.value = this.value;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, Integer> e = (Map.Entry) o;
            return Objects.equals(this.key, e.getKey()) && this.value == e.getValue().intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key.hashCode() ^ this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        return (k == 0 || findKey(k) == null) ? false : true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
    public int getInt(Object k) {
        Entry<K> e = findKey(k);
        return e == null ? this.defRetValue : e.value;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        if (this.tree != null) {
            return (K) this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        if (this.tree != null) {
            return (K) this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry<K> prev;
        Entry<K> next;
        Entry<K> curr;
        int index = 0;

        TreeIterator() {
            this.next = Object2IntRBTreeMap.this.firstEntry;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        TreeIterator(K k) {
            Entry<K> locateKey = Object2IntRBTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Object2IntRBTreeMap.this.compare(this.next.key, k) <= 0) {
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

        Entry<K> nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Entry<K> entry = this.next;
            this.prev = entry;
            this.curr = entry;
            this.index++;
            updateNext();
            return this.curr;
        }

        void updatePrevious() {
            this.prev = this.prev.prev();
        }

        Entry<K> previousEntry() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Entry<K> entry = this.prev;
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
            Entry<K> entry = this.curr;
            this.prev = entry;
            this.next = entry;
            updatePrevious();
            updateNext();
            Object2IntRBTreeMap.this.removeInt(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$EntryIterator.class */
    public class EntryIterator extends Object2IntRBTreeMap<K>.TreeIterator implements ObjectListIterator<Object2IntMap.Entry<K>> {
        EntryIterator() {
            super();
        }

        EntryIterator(K k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2IntMap.Entry<K> next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2IntMap.Entry<K> previous() {
            return previousEntry();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap
    public ObjectSortedSet<Object2IntMap.Entry<K>> object2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Object2IntMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.1
                final Comparator<? super Object2IntMap.Entry<K>> comparator;

                {
                    this.comparator = Object2IntRBTreeMap.this.actualComparator == null ? x, y -> {
                        return ((Comparable) x.getKey()).compareTo(y.getKey());
                    } : x, y -> {
                        return Object2IntRBTreeMap.this.actualComparator.compare(x.getKey(), y.getKey());
                    };
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                    return iterator((Object2IntMap.Entry) ((Object2IntMap.Entry) obj));
                }

                @Override // java.util.SortedSet
                public Comparator<? super Object2IntMap.Entry<K>> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Object2IntMap.Entry<K>> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Object2IntMap.Entry<K>> iterator(Object2IntMap.Entry<K> from) {
                    return new EntryIterator(from.getKey());
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() == null || e.getValue() == null || !(e.getValue() instanceof Integer)) {
                        return false;
                    }
                    return e.equals(Object2IntRBTreeMap.this.findKey(e.getKey()));
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object o) {
                    Entry<K> f;
                    if (!(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() == null || e.getValue() == null || !(e.getValue() instanceof Integer) || (f = Object2IntRBTreeMap.this.findKey(e.getKey())) == null || f.getIntValue() != ((Integer) e.getValue()).intValue()) {
                        return false;
                    }
                    Object2IntRBTreeMap.this.removeInt(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Object2IntRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Object2IntRBTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Object2IntMap.Entry<K> first() {
                    return Object2IntRBTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Object2IntMap.Entry<K> last() {
                    return Object2IntRBTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Object2IntMap.Entry<K>> subSet(Object2IntMap.Entry<K> from, Object2IntMap.Entry<K> to) {
                    return Object2IntRBTreeMap.this.subMap((Object) from.getKey(), (Object) to.getKey()).object2IntEntrySet();
                }

                public ObjectSortedSet<Object2IntMap.Entry<K>> headSet(Object2IntMap.Entry<K> to) {
                    return Object2IntRBTreeMap.this.headMap((Object2IntRBTreeMap) to.getKey()).object2IntEntrySet();
                }

                public ObjectSortedSet<Object2IntMap.Entry<K>> tailSet(Object2IntMap.Entry<K> from) {
                    return Object2IntRBTreeMap.this.tailMap((Object2IntRBTreeMap) from.getKey()).object2IntEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$KeyIterator.class */
    public final class KeyIterator extends Object2IntRBTreeMap<K>.TreeIterator implements ObjectListIterator<K> {
        public KeyIterator() {
            super();
        }

        public KeyIterator(K k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return (K) nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return (K) previousEntry().key;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$KeySet.class */
    public class KeySet extends AbstractObject2IntSortedMap<K>.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$ValueIterator.class */
    public final class ValueIterator extends Object2IntRBTreeMap<K>.TreeIterator implements IntListIterator {
        private ValueIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return nextEntry().value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return previousEntry().value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
    public IntCollection values() {
        if (this.values == null) {
            this.values = new AbstractIntCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
                public IntIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
                public boolean contains(int k) {
                    return Object2IntRBTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2IntRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2IntRBTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap, java.util.SortedMap
    public Object2IntSortedMap<K> headMap(K to) {
        return new Submap(null, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap, java.util.SortedMap
    public Object2IntSortedMap<K> tailMap(K from) {
        return new Submap(from, false, null, true);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap, java.util.SortedMap
    public Object2IntSortedMap<K> subMap(K from, K to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$Submap.class */
    public final class Submap extends AbstractObject2IntSortedMap<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        K from;

        /* renamed from: to */
        K f2587to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Object2IntMap.Entry<K>> entries;
        protected transient ObjectSortedSet<K> keys;
        protected transient IntCollection values;

        public Submap(K from, boolean bottom, K to, boolean top) {
            if (bottom || top || Object2IntRBTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2587to = to;
                this.top = top;
                this.defRetValue = Object2IntRBTreeMap.this.defRetValue;
                return;
            }
            throw new IllegalArgumentException("Start key (" + from + ") is larger than end key (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            Object2IntRBTreeMap<K>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                i.nextEntry();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m595in(K k) {
            return (this.bottom || Object2IntRBTreeMap.this.compare(k, this.from) >= 0) && (this.top || Object2IntRBTreeMap.this.compare(k, this.f2587to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap
        public ObjectSortedSet<Object2IntMap.Entry<K>> object2IntEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Object2IntMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                    public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                        return iterator((Object2IntMap.Entry) ((Object2IntMap.Entry) obj));
                    }

                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Object2IntMap.Entry<K>> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Object2IntMap.Entry<K>> iterator(Object2IntMap.Entry<K> from) {
                        return new SubmapEntryIterator(from.getKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Object2IntMap.Entry<K>> comparator() {
                        return Object2IntRBTreeMap.this.object2IntEntrySet().comparator();
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
                    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Submap */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry<K> f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getValue() != null && (e.getValue() instanceof Integer) && (f = Object2IntRBTreeMap.this.findKey(e.getKey())) != null && Submap.this.m595in(f.key) && e.equals(f);
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
                    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Submap */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getValue() == null || !(e.getValue() instanceof Integer)) {
                            return false;
                        }
                        Entry<K> f = Object2IntRBTreeMap.this.findKey(e.getKey());
                        if (f != null && Submap.this.m595in(f.key)) {
                            Submap.this.removeInt(f.key);
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
                    public Object2IntMap.Entry<K> first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Object2IntMap.Entry<K> last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Object2IntMap.Entry<K>> subSet(Object2IntMap.Entry<K> from, Object2IntMap.Entry<K> to) {
                        return Submap.this.subMap((Object) from.getKey(), (Object) to.getKey()).object2IntEntrySet();
                    }

                    public ObjectSortedSet<Object2IntMap.Entry<K>> headSet(Object2IntMap.Entry<K> to) {
                        return Submap.this.headMap((Submap) to.getKey()).object2IntEntrySet();
                    }

                    public ObjectSortedSet<Object2IntMap.Entry<K>> tailSet(Object2IntMap.Entry<K> from) {
                        return Submap.this.tailMap((Submap) from.getKey()).object2IntEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractObject2IntSortedMap<K>.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectBidirectionalIterator<K> iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
            public ObjectBidirectionalIterator<K> iterator(K from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntMap, java.util.Map
        public IntCollection values() {
            if (this.values == null) {
                this.values = new AbstractIntCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
                    public IntIterator iterator() {
                        return new SubmapValueIterator();
                    }

                    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, p014it.unimi.dsi.fastutil.ints.IntCollection
                    public boolean contains(int k) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return k != null && m595in(k) && Object2IntRBTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, p014it.unimi.dsi.fastutil.objects.Object2IntMap
        public boolean containsValue(int v) {
            Object2IntRBTreeMap<K>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getInt(Object k) {
            Entry<K> e;
            return (!m595in(k) || (e = Object2IntRBTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int put(K k, int v) {
            Object2IntRBTreeMap.this.modified = false;
            if (!m595in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2587to)) + ")");
            }
            return Object2IntRBTreeMap.this.modified ? this.defRetValue : Object2IntRBTreeMap.this.put((Object2IntRBTreeMap) k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int removeInt(Object k) {
            Object2IntRBTreeMap.this.modified = false;
            if (!m595in(k)) {
                return this.defRetValue;
            }
            return Object2IntRBTreeMap.this.modified ? Object2IntRBTreeMap.this.removeInt(k) : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            Object2IntRBTreeMap<K>.Submap.SubmapIterator i = new SubmapIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextEntry();
            }
            return n;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return Object2IntRBTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap, java.util.SortedMap
        public Object2IntSortedMap<K> headMap(K to) {
            if (!this.top && Object2IntRBTreeMap.this.compare(to, this.f2587to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap, java.util.SortedMap
        public Object2IntSortedMap<K> tailMap(K from) {
            if (!this.bottom && Object2IntRBTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2587to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntSortedMap, java.util.SortedMap
        public Object2IntSortedMap<K> subMap(K from, K to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Object2IntRBTreeMap.this.compare(to, this.f2587to) < 0 ? to : this.f2587to;
            }
            if (!this.bottom) {
                from = Object2IntRBTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f2587to) ? new Submap(from, false, to, false) : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
        /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        public Entry<K> firstEntry() {
            Entry<K> e;
            if (Object2IntRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Object2IntRBTreeMap.this.firstEntry;
            } else {
                e = Object2IntRBTreeMap.this.locateKey(this.from);
                if (Object2IntRBTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Object2IntRBTreeMap.this.compare(e.key, this.f2587to) < 0) {
                return e;
            }
            return null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
        /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        public Entry<K> lastEntry() {
            Entry<K> e;
            if (Object2IntRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Object2IntRBTreeMap.this.lastEntry;
            } else {
                e = Object2IntRBTreeMap.this.locateKey(this.f2587to);
                if (Object2IntRBTreeMap.this.compare(e.key, this.f2587to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Object2IntRBTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            Entry<K> e = firstEntry();
            if (e != null) {
                return (K) e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            Entry<K> e = lastEntry();
            if (e != null) {
                return (K) e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends Object2IntRBTreeMap<K>.TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
            /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
            /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            SubmapIterator(Submap submap, K k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Object2IntRBTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Object2IntRBTreeMap object2IntRBTreeMap = Object2IntRBTreeMap.this;
                        Entry<K> lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (object2IntRBTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Object2IntRBTreeMap.this.locateKey(k);
                    if (Object2IntRBTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Object2IntRBTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Object2IntRBTreeMap.this.compare(this.next.key, Submap.this.f2587to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends Object2IntRBTreeMap<K>.Submap.SubmapIterator implements ObjectListIterator<Object2IntMap.Entry<K>> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(K k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Object2IntMap.Entry<K> next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Object2IntMap.Entry<K> previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends Object2IntRBTreeMap<K>.Submap.SubmapIterator implements ObjectListIterator<K> {
            public SubmapKeyIterator() {
                super();
            }

            public SubmapKeyIterator(K from) {
                super(Submap.this, from);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public K next() {
                return (K) nextEntry().key;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public K previous() {
                return (K) previousEntry().key;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntRBTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends Object2IntRBTreeMap<K>.Submap.SubmapIterator implements IntListIterator {
            private SubmapValueIterator() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                return nextEntry().value;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
            public int previousInt() {
                return previousEntry().value;
            }
        }
    }

    @Override // java.lang.Object
    public Object2IntRBTreeMap<K> clone() {
        try {
            Object2IntRBTreeMap<K> c = (Object2IntRBTreeMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.allocatePaths();
            if (this.count == 0) {
                return c;
            }
            Entry<K> rp = new Entry<>();
            Entry<K> rq = new Entry<>();
            Entry<K> p = rp;
            rp.left(this.tree);
            Entry<K> q = rq;
            rq.pred((Entry) null);
            loop0: while (true) {
                if (!p.pred()) {
                    Entry<K> e = p.left.clone();
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
                    Entry<K> e2 = p.right.clone();
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
        Object2IntRBTreeMap<K>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                Entry<K> e = i.nextEntry();
                s.writeObject(e.key);
                s.writeInt(e.value);
            } else {
                return;
            }
        }
    }

    private Entry<K> readTree(ObjectInputStream s, int n, Entry<K> pred, Entry<K> succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry<K> top = new Entry<>(s.readObject(), s.readInt());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry<K> top2 = new Entry<>(s.readObject(), s.readInt());
            top2.black(true);
            top2.right(new Entry<>(s.readObject(), s.readInt()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry<K> top3 = new Entry<>();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readObject();
            top3.value = s.readInt();
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
            Entry<K> e = this.tree;
            while (e.left() != null) {
                e = e.left();
            }
            this.firstEntry = e;
            Entry<K> e2 = this.tree;
            while (e2.right() != null) {
                e2 = e2.right();
            }
            this.lastEntry = e2;
        }
    }
}
