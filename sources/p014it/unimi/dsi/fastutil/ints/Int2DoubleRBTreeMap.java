package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleListIterator;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap.class */
public class Int2DoubleRBTreeMap extends AbstractInt2DoubleSortedMap implements Serializable, Cloneable {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected transient ObjectSortedSet<Int2DoubleMap.Entry> entries;
    protected transient IntSortedSet keys;
    protected transient DoubleCollection values;
    protected transient boolean modified;
    protected Comparator<? super Integer> storedComparator;
    protected transient IntComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    private transient Entry[] nodePath;

    public Int2DoubleRBTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = IntComparators.asIntComparator(this.storedComparator);
    }

    public Int2DoubleRBTreeMap(Comparator<? super Integer> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Int2DoubleRBTreeMap(Map<? extends Integer, ? extends Double> m) {
        this();
        putAll(m);
    }

    public Int2DoubleRBTreeMap(SortedMap<Integer, Double> m) {
        this(m.comparator());
        putAll(m);
    }

    public Int2DoubleRBTreeMap(Int2DoubleMap m) {
        this();
        putAll(m);
    }

    public Int2DoubleRBTreeMap(Int2DoubleSortedMap m) {
        this(m.comparator());
        putAll(m);
    }

    public Int2DoubleRBTreeMap(int[] k, double[] v, Comparator<? super Integer> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Int2DoubleRBTreeMap(int[] k, double[] v) {
        this(k, v, null);
    }

    final int compare(int k1, int k2) {
        return this.actualComparator == null ? Integer.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    final Entry findKey(int k) {
        int cmp;
        Entry e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry locateKey(int k) {
        Entry e = this.tree;
        Entry last = this.tree;
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

    public double addTo(int k, double incr) {
        Entry e = add(k);
        double oldValue = e.value;
        e.value += incr;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    public double put(int k, double v) {
        Entry e = add(k);
        double oldValue = e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
        r9.nodePath[r15] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0050, code lost:
        r15 = r15 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0055, code lost:
        if (r15 == 0) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.Entry add(int r10) {
        /*
        // Method dump skipped, instructions count: 935
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.add(int):it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$Entry");
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
    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double remove(int r7) {
        /*
        // Method dump skipped, instructions count: 1895
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.remove(int):double");
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
    public boolean containsValue(double v) {
        ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (Double.doubleToLongBits(i.nextDouble()) != Double.doubleToLongBits(v));
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$Entry.class */
    public static final class Entry extends AbstractInt2DoubleMap.BasicEntry implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        Entry left;
        Entry right;
        int info;

        Entry() {
            super(0, 0.0d);
        }

        Entry(int k, double v) {
            super(k, v);
            this.info = -1073741824;
        }

        Entry left() {
            if ((this.info & 1073741824) != 0) {
                return null;
            }
            return this.left;
        }

        Entry right() {
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

        void pred(Entry pred) {
            this.info |= 1073741824;
            this.left = pred;
        }

        void succ(Entry succ) {
            this.info |= Integer.MIN_VALUE;
            this.right = succ;
        }

        void left(Entry left) {
            this.info &= -1073741825;
            this.left = left;
        }

        void right(Entry right) {
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

        Entry next() {
            Entry next = this.right;
            if ((this.info & Integer.MIN_VALUE) == 0) {
                while ((next.info & 1073741824) == 0) {
                    next = next.left;
                }
            }
            return next;
        }

        Entry prev() {
            Entry prev = this.left;
            if ((this.info & 1073741824) == 0) {
                while ((prev.info & Integer.MIN_VALUE) == 0) {
                    prev = prev.right;
                }
            }
            return prev;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap.BasicEntry, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap.Entry
        public double setValue(double value) {
            double oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override // java.lang.Object
        public Entry clone() {
            try {
                Entry c = (Entry) clone();
                c.key = this.key;
                c.value = this.value;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Integer, Double> e = (Map.Entry) o;
            return this.key == e.getKey().intValue() && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(e.getValue().doubleValue());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ HashCommon.double2int(this.value);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
    public boolean containsKey(int k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    public double get(int k) {
        Entry e = findKey(k);
        return e == null ? this.defRetValue : e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    public int firstIntKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    public int lastIntKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        TreeIterator() {
            this.next = Int2DoubleRBTreeMap.this.firstEntry;
        }

        TreeIterator(int k) {
            Entry locateKey = Int2DoubleRBTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Int2DoubleRBTreeMap.this.compare(this.next.key, k) <= 0) {
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

        Entry nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Entry entry = this.next;
            this.prev = entry;
            this.curr = entry;
            this.index++;
            updateNext();
            return this.curr;
        }

        void updatePrevious() {
            this.prev = this.prev.prev();
        }

        Entry previousEntry() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Entry entry = this.prev;
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
            Entry entry = this.curr;
            this.prev = entry;
            this.next = entry;
            updatePrevious();
            updateNext();
            Int2DoubleRBTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$EntryIterator.class */
    public class EntryIterator extends TreeIterator implements ObjectListIterator<Int2DoubleMap.Entry> {
        EntryIterator() {
            super();
        }

        EntryIterator(int k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Int2DoubleMap.Entry next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Int2DoubleMap.Entry previous() {
            return previousEntry();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    public ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Int2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.1
                final Comparator<? super Int2DoubleMap.Entry> comparator;

                {
                    this.comparator = Int2DoubleRBTreeMap.this.actualComparator == null ? x, y -> {
                        return Integer.compare(x.getIntKey(), y.getIntKey());
                    } : x, y -> {
                        return Int2DoubleRBTreeMap.this.actualComparator.compare(x.getIntKey(), y.getIntKey());
                    };
                }

                @Override // java.util.SortedSet
                public Comparator<? super Int2DoubleMap.Entry> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Int2DoubleMap.Entry> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Int2DoubleMap.Entry> iterator(Int2DoubleMap.Entry from) {
                    return new EntryIterator(from.getIntKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Integer) && e.getValue() != null && (e.getValue() instanceof Double)) {
                        return e.equals(Int2DoubleRBTreeMap.this.findKey(((Integer) e.getKey()).intValue()));
                    }
                    return false;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object o) {
                    Entry f;
                    if (!(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Double) || (f = Int2DoubleRBTreeMap.this.findKey(((Integer) e.getKey()).intValue())) == null || Double.doubleToLongBits(f.getDoubleValue()) != Double.doubleToLongBits(((Double) e.getValue()).doubleValue())) {
                        return false;
                    }
                    Int2DoubleRBTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Int2DoubleRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Int2DoubleRBTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Int2DoubleMap.Entry first() {
                    return Int2DoubleRBTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Int2DoubleMap.Entry last() {
                    return Int2DoubleRBTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Int2DoubleMap.Entry> subSet(Int2DoubleMap.Entry from, Int2DoubleMap.Entry to) {
                    return Int2DoubleRBTreeMap.this.subMap(from.getIntKey(), to.getIntKey()).int2DoubleEntrySet();
                }

                public ObjectSortedSet<Int2DoubleMap.Entry> headSet(Int2DoubleMap.Entry to) {
                    return Int2DoubleRBTreeMap.this.headMap(to.getIntKey()).int2DoubleEntrySet();
                }

                public ObjectSortedSet<Int2DoubleMap.Entry> tailSet(Int2DoubleMap.Entry from) {
                    return Int2DoubleRBTreeMap.this.tailMap(from.getIntKey()).int2DoubleEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$KeyIterator.class */
    public final class KeyIterator extends TreeIterator implements IntListIterator {
        public KeyIterator() {
            super();
        }

        public KeyIterator(int k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return previousEntry().key;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$KeySet.class */
    public class KeySet extends AbstractInt2DoubleSortedMap.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap.KeySet, p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
        public IntBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap.KeySet, p014it.unimi.dsi.fastutil.ints.IntSortedSet
        public IntBidirectionalIterator iterator(int from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
    public IntSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$ValueIterator.class */
    public final class ValueIterator extends TreeIterator implements DoubleListIterator {
        private ValueIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return nextEntry().value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return previousEntry().value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
    public DoubleCollection values() {
        if (this.values == null) {
            this.values = new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                public DoubleIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
                public boolean contains(double k) {
                    return Int2DoubleRBTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Int2DoubleRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Int2DoubleRBTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
    public Comparator<? super Integer> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    public Int2DoubleSortedMap headMap(int to) {
        return new Submap(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    public Int2DoubleSortedMap tailMap(int from) {
        return new Submap(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    public Int2DoubleSortedMap subMap(int from, int to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$Submap.class */
    public final class Submap extends AbstractInt2DoubleSortedMap implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        int from;

        /* renamed from: to */
        int f2032to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Int2DoubleMap.Entry> entries;
        protected transient IntSortedSet keys;
        protected transient DoubleCollection values;

        public Submap(int from, boolean bottom, int to, boolean top) {
            if (bottom || top || Int2DoubleRBTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2032to = to;
                this.top = top;
                this.defRetValue = Int2DoubleRBTreeMap.this.defRetValue;
                return;
            }
            throw new IllegalArgumentException("Start key (" + from + ") is larger than end key (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                i.nextEntry();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m769in(int k) {
            return (this.bottom || Int2DoubleRBTreeMap.this.compare(k, this.from) >= 0) && (this.top || Int2DoubleRBTreeMap.this.compare(k, this.f2032to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Int2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Int2DoubleMap.Entry> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Int2DoubleMap.Entry> iterator(Int2DoubleMap.Entry from) {
                        return new SubmapEntryIterator(from.getIntKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Int2DoubleMap.Entry> comparator() {
                        return Int2DoubleRBTreeMap.this.int2DoubleEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Integer) && e.getValue() != null && (e.getValue() instanceof Double) && (f = Int2DoubleRBTreeMap.this.findKey(((Integer) e.getKey()).intValue())) != null && Submap.this.m769in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Integer) || e.getValue() == null || !(e.getValue() instanceof Double)) {
                            return false;
                        }
                        Entry f = Int2DoubleRBTreeMap.this.findKey(((Integer) e.getKey()).intValue());
                        if (f != null && Submap.this.m769in(f.key)) {
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
                    public Int2DoubleMap.Entry first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Int2DoubleMap.Entry last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Int2DoubleMap.Entry> subSet(Int2DoubleMap.Entry from, Int2DoubleMap.Entry to) {
                        return Submap.this.subMap(from.getIntKey(), to.getIntKey()).int2DoubleEntrySet();
                    }

                    public ObjectSortedSet<Int2DoubleMap.Entry> headSet(Int2DoubleMap.Entry to) {
                        return Submap.this.headMap(to.getIntKey()).int2DoubleEntrySet();
                    }

                    public ObjectSortedSet<Int2DoubleMap.Entry> tailSet(Int2DoubleMap.Entry from) {
                        return Submap.this.tailMap(from.getIntKey()).int2DoubleEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractInt2DoubleSortedMap.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap.KeySet, p014it.unimi.dsi.fastutil.ints.AbstractIntSortedSet, p014it.unimi.dsi.fastutil.ints.AbstractIntSet, p014it.unimi.dsi.fastutil.ints.AbstractIntCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.ints.IntCollection, p014it.unimi.dsi.fastutil.ints.IntIterable
            public IntBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap.KeySet, p014it.unimi.dsi.fastutil.ints.IntSortedSet
            public IntBidirectionalIterator iterator(int from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleSortedMap, p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, java.util.Map
        public DoubleCollection values() {
            if (this.values == null) {
                this.values = new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                    public DoubleIterator iterator() {
                        return new SubmapValueIterator();
                    }

                    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
                    public boolean contains(double k) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
        public boolean containsKey(int k) {
            return m769in(k) && Int2DoubleRBTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
        public boolean containsValue(double v) {
            SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (Double.doubleToLongBits(i.nextEntry().value) == Double.doubleToLongBits(v)) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double get(int k) {
            Entry e;
            return (!m769in(k) || (e = Int2DoubleRBTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double put(int k, double v) {
            Int2DoubleRBTreeMap.this.modified = false;
            if (!m769in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2032to)) + ")");
            }
            return Int2DoubleRBTreeMap.this.modified ? this.defRetValue : Int2DoubleRBTreeMap.this.put(k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double remove(int k) {
            Int2DoubleRBTreeMap.this.modified = false;
            if (!m769in(k)) {
                return this.defRetValue;
            }
            return Int2DoubleRBTreeMap.this.modified ? Int2DoubleRBTreeMap.this.remove(k) : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            SubmapIterator i = new SubmapIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextEntry();
            }
            return n;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap, java.util.SortedMap
        public Comparator<? super Integer> comparator() {
            return Int2DoubleRBTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap headMap(int to) {
            if (!this.top && Int2DoubleRBTreeMap.this.compare(to, this.f2032to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap tailMap(int from) {
            if (!this.bottom && Int2DoubleRBTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2032to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap subMap(int from, int to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Int2DoubleRBTreeMap.this.compare(to, this.f2032to) < 0 ? to : this.f2032to;
            }
            if (!this.bottom) {
                from = Int2DoubleRBTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f2032to) ? new Submap(from, false, to, false) : this;
        }

        public Entry firstEntry() {
            Entry e;
            if (Int2DoubleRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Int2DoubleRBTreeMap.this.firstEntry;
            } else {
                e = Int2DoubleRBTreeMap.this.locateKey(this.from);
                if (Int2DoubleRBTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Int2DoubleRBTreeMap.this.compare(e.key, this.f2032to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (Int2DoubleRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Int2DoubleRBTreeMap.this.lastEntry;
            } else {
                e = Int2DoubleRBTreeMap.this.locateKey(this.f2032to);
                if (Int2DoubleRBTreeMap.this.compare(e.key, this.f2032to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Int2DoubleRBTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int firstIntKey() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public int lastIntKey() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            SubmapIterator(Submap submap, int k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Int2DoubleRBTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Int2DoubleRBTreeMap int2DoubleRBTreeMap = Int2DoubleRBTreeMap.this;
                        Entry lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (int2DoubleRBTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Int2DoubleRBTreeMap.this.locateKey(k);
                    if (Int2DoubleRBTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Int2DoubleRBTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Int2DoubleRBTreeMap.this.compare(this.next.key, Submap.this.f2032to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends SubmapIterator implements ObjectListIterator<Int2DoubleMap.Entry> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(int k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Int2DoubleMap.Entry next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Int2DoubleMap.Entry previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends SubmapIterator implements IntListIterator {
            public SubmapKeyIterator() {
                super();
            }

            public SubmapKeyIterator(int from) {
                super(Submap.this, from);
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                return nextEntry().key;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
            public int previousInt() {
                return previousEntry().key;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleRBTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleRBTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends SubmapIterator implements DoubleListIterator {
            private SubmapValueIterator() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
            public double nextDouble() {
                return nextEntry().value;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
            public double previousDouble() {
                return previousEntry().value;
            }
        }
    }

    @Override // java.lang.Object
    public Int2DoubleRBTreeMap clone() {
        try {
            Int2DoubleRBTreeMap c = (Int2DoubleRBTreeMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.allocatePaths();
            if (this.count == 0) {
                return c;
            }
            Entry rp = new Entry();
            Entry rq = new Entry();
            Entry p = rp;
            rp.left(this.tree);
            Entry q = rq;
            rq.pred((Entry) null);
            loop0: while (true) {
                if (!p.pred()) {
                    Entry e = p.left.clone();
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
                    Entry e2 = p.right.clone();
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
        EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                Entry e = i.nextEntry();
                s.writeInt(e.key);
                s.writeDouble(e.value);
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readInt(), s.readDouble());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readInt(), s.readDouble());
            top2.black(true);
            top2.right(new Entry(s.readInt(), s.readDouble()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry top3 = new Entry();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readInt();
            top3.value = s.readDouble();
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
            Entry e = this.tree;
            while (e.left() != null) {
                e = e.left();
            }
            this.firstEntry = e;
            Entry e2 = this.tree;
            while (e2.right() != null) {
                e2 = e2.right();
            }
            this.lastEntry = e2;
        }
    }
}
