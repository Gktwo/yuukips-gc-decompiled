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

/* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap.class */
public class Int2DoubleAVLTreeMap extends AbstractInt2DoubleSortedMap implements Serializable, Cloneable {
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
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Int2DoubleAVLTreeMap.class.desiredAssertionStatus();
    }

    public Int2DoubleAVLTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = IntComparators.asIntComparator(this.storedComparator);
    }

    public Int2DoubleAVLTreeMap(Comparator<? super Integer> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Int2DoubleAVLTreeMap(Map<? extends Integer, ? extends Double> m) {
        this();
        putAll(m);
    }

    public Int2DoubleAVLTreeMap(SortedMap<Integer, Double> m) {
        this(m.comparator());
        putAll(m);
    }

    public Int2DoubleAVLTreeMap(Int2DoubleMap m) {
        this();
        putAll(m);
    }

    public Int2DoubleAVLTreeMap(Int2DoubleSortedMap m) {
        this(m.comparator());
        putAll(m);
    }

    public Int2DoubleAVLTreeMap(int[] k, double[] v, Comparator<? super Integer> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Int2DoubleAVLTreeMap(int[] k, double[] v) {
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
        this.dirPath = new boolean[48];
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

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x035e, code lost:
        r0.pred(r16);
        r16.succ(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x036f, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0372, code lost:
        if (r15 != null) goto L_0x037e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0375, code lost:
        r9.tree = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0385, code lost:
        if (r15.left != r14) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0388, code lost:
        r15.left = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0392, code lost:
        r15.right = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x012b, code lost:
        r12 = r14;
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0133, code lost:
        if (r12 == r11) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x013d, code lost:
        if (r9.dirPath[r18] == false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0140, code lost:
        r12.incBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0147, code lost:
        r12.decBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014b, code lost:
        r18 = r18 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0155, code lost:
        if (r9.dirPath[r18] == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0158, code lost:
        r0 = r12.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x015f, code lost:
        r0 = r12.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x016e, code lost:
        if (r14.balance() != -2) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0171, code lost:
        r0 = r14.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x017e, code lost:
        if (r0.balance() != -1) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0181, code lost:
        r16 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x018a, code lost:
        if (r0.succ() == false) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x018d, code lost:
        r0.succ(false);
        r14.pred(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x019d, code lost:
        r14.left = r0.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a7, code lost:
        r0.right = r14;
        r0.balance(0);
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01c0, code lost:
        if (p014it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.$assertionsDisabled != false) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01c9, code lost:
        if (r0.balance() == 1) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d3, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d4, code lost:
        r16 = r0.right;
        r0.right = r16.left;
        r16.left = r0;
        r14.left = r16.right;
        r16.right = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0203, code lost:
        if (r16.balance() != -1) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0206, code lost:
        r0.balance(0);
        r14.balance(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x021a, code lost:
        if (r16.balance() != 0) goto L_0x022c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x021d, code lost:
        r0.balance(0);
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022c, code lost:
        r0.balance(-1);
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0238, code lost:
        r16.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0243, code lost:
        if (r16.pred() == false) goto L_0x0253;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0246, code lost:
        r0.succ(r16);
        r16.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0258, code lost:
        if (r16.succ() == false) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x025b, code lost:
        r14.pred(r16);
        r16.succ(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0271, code lost:
        if (r14.balance() != 2) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0274, code lost:
        r0 = r14.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0281, code lost:
        if (r0.balance() != 1) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0284, code lost:
        r16 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x028d, code lost:
        if (r0.pred() == false) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0290, code lost:
        r0.pred(false);
        r14.succ(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02a0, code lost:
        r14.right = r0.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02aa, code lost:
        r0.left = r14;
        r0.balance(0);
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02c3, code lost:
        if (p014it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.$assertionsDisabled != false) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02cc, code lost:
        if (r0.balance() == -1) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02d6, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02d7, code lost:
        r16 = r0.left;
        r0.left = r16.right;
        r16.right = r0;
        r14.right = r16.left;
        r16.left = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0306, code lost:
        if (r16.balance() != 1) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0309, code lost:
        r0.balance(0);
        r14.balance(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x031d, code lost:
        if (r16.balance() != 0) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0320, code lost:
        r0.balance(0);
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x032f, code lost:
        r0.balance(1);
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x033b, code lost:
        r16.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0346, code lost:
        if (r16.pred() == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0349, code lost:
        r14.succ(r16);
        r16.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x035b, code lost:
        if (r16.succ() == false) goto L_0x0370;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.Entry add(int r10) {
        /*
        // Method dump skipped, instructions count: 923
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.add(int):it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$Entry");
    }

    private Entry parent(Entry e) {
        if (e == this.tree) {
            return null;
        }
        Entry y = e;
        Entry x = e;
        while (!y.succ()) {
            if (x.pred()) {
                Entry p = x.left;
                if (p == null || p.right != e) {
                    while (!y.succ()) {
                        y = y.right;
                    }
                    p = y.right;
                }
                return p;
            }
            x = x.left;
            y = y.right;
        }
        Entry p2 = y.right;
        if (p2 == null || p2.left != e) {
            while (!x.pred()) {
                x = x.left;
            }
            p2 = x.left;
        }
        return p2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05c2, code lost:
        r4.modified = true;
        r4.count--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05d5, code lost:
        return r7.value;
     */
    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double remove(int r5) {
        /*
        // Method dump skipped, instructions count: 1494
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.remove(int):double");
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$Entry.class */
    public static final class Entry extends AbstractInt2DoubleMap.BasicEntry implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
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

        int balance() {
            return (byte) this.info;
        }

        void balance(int level) {
            this.info &= -256;
            this.info |= level & 255;
        }

        void incBalance() {
            this.info = (this.info & -256) | ((((byte) this.info) + 1) & 255);
        }

        protected void decBalance() {
            this.info = (this.info & -256) | ((((byte) this.info) - 1) & 255);
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

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        TreeIterator() {
            this.next = Int2DoubleAVLTreeMap.this.firstEntry;
        }

        TreeIterator(int k) {
            Entry locateKey = Int2DoubleAVLTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Int2DoubleAVLTreeMap.this.compare(this.next.key, k) <= 0) {
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
            Int2DoubleAVLTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$EntryIterator.class */
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

        public void set(Int2DoubleMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Int2DoubleMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
    public ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Int2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.1
                final Comparator<? super Int2DoubleMap.Entry> comparator;

                {
                    this.comparator = Int2DoubleAVLTreeMap.this.actualComparator == null ? x, y -> {
                        return Integer.compare(x.getIntKey(), y.getIntKey());
                    } : x, y -> {
                        return Int2DoubleAVLTreeMap.this.actualComparator.compare(x.getIntKey(), y.getIntKey());
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
                        return e.equals(Int2DoubleAVLTreeMap.this.findKey(((Integer) e.getKey()).intValue()));
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
                    if (e.getKey() == null || e.getKey() == null || !(e.getKey() instanceof Integer) || !(e.getValue() instanceof Double) || (f = Int2DoubleAVLTreeMap.this.findKey(((Integer) e.getKey()).intValue())) == null || Double.doubleToLongBits(f.getDoubleValue()) != Double.doubleToLongBits(((Double) e.getValue()).doubleValue())) {
                        return false;
                    }
                    Int2DoubleAVLTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Int2DoubleAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Int2DoubleAVLTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Int2DoubleMap.Entry first() {
                    return Int2DoubleAVLTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Int2DoubleMap.Entry last() {
                    return Int2DoubleAVLTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Int2DoubleMap.Entry> subSet(Int2DoubleMap.Entry from, Int2DoubleMap.Entry to) {
                    return Int2DoubleAVLTreeMap.this.subMap(from.getIntKey(), to.getIntKey()).int2DoubleEntrySet();
                }

                public ObjectSortedSet<Int2DoubleMap.Entry> headSet(Int2DoubleMap.Entry to) {
                    return Int2DoubleAVLTreeMap.this.headMap(to.getIntKey()).int2DoubleEntrySet();
                }

                public ObjectSortedSet<Int2DoubleMap.Entry> tailSet(Int2DoubleMap.Entry from) {
                    return Int2DoubleAVLTreeMap.this.tailMap(from.getIntKey()).int2DoubleEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$KeyIterator.class */
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$KeySet.class */
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$ValueIterator.class */
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
            this.values = new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
                public DoubleIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
                public boolean contains(double k) {
                    return Int2DoubleAVLTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Int2DoubleAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Int2DoubleAVLTreeMap.this.clear();
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
    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$Submap.class */
    public final class Submap extends AbstractInt2DoubleSortedMap implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        int from;

        /* renamed from: to */
        int f2021to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Int2DoubleMap.Entry> entries;
        protected transient IntSortedSet keys;
        protected transient DoubleCollection values;

        public Submap(int from, boolean bottom, int to, boolean top) {
            if (bottom || top || Int2DoubleAVLTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2021to = to;
                this.top = top;
                this.defRetValue = Int2DoubleAVLTreeMap.this.defRetValue;
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
        final boolean m770in(int k) {
            return (this.bottom || Int2DoubleAVLTreeMap.this.compare(k, this.from) >= 0) && (this.top || Int2DoubleAVLTreeMap.this.compare(k, this.f2021to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleMap, p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public ObjectSortedSet<Int2DoubleMap.Entry> int2DoubleEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Int2DoubleMap.Entry>() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Int2DoubleMap.Entry> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Int2DoubleMap.Entry> iterator(Int2DoubleMap.Entry from) {
                        return new SubmapEntryIterator(from.getIntKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Int2DoubleMap.Entry> comparator() {
                        return Int2DoubleAVLTreeMap.this.int2DoubleEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Integer) && e.getValue() != null && (e.getValue() instanceof Double) && (f = Int2DoubleAVLTreeMap.this.findKey(((Integer) e.getKey()).intValue())) != null && Submap.this.m770in(f.key) && e.equals(f);
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
                        Entry f = Int2DoubleAVLTreeMap.this.findKey(((Integer) e.getKey()).intValue());
                        if (f != null && Submap.this.m770in(f.key)) {
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
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$Submap$KeySet.class */
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
                this.values = new AbstractDoubleCollection() { // from class: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.Submap.2
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
            return m770in(k) && Int2DoubleAVLTreeMap.this.containsKey(k);
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
            return (!m770in(k) || (e = Int2DoubleAVLTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double put(int k, double v) {
            Int2DoubleAVLTreeMap.this.modified = false;
            if (!m770in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2021to)) + ")");
            }
            return Int2DoubleAVLTreeMap.this.modified ? this.defRetValue : Int2DoubleAVLTreeMap.this.put(k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double remove(int k) {
            Int2DoubleAVLTreeMap.this.modified = false;
            if (!m770in(k)) {
                return this.defRetValue;
            }
            return Int2DoubleAVLTreeMap.this.modified ? Int2DoubleAVLTreeMap.this.remove(k) : this.defRetValue;
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
            return Int2DoubleAVLTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap headMap(int to) {
            if (!this.top && Int2DoubleAVLTreeMap.this.compare(to, this.f2021to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap tailMap(int from) {
            if (!this.bottom && Int2DoubleAVLTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2021to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleSortedMap
        public Int2DoubleSortedMap subMap(int from, int to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Int2DoubleAVLTreeMap.this.compare(to, this.f2021to) < 0 ? to : this.f2021to;
            }
            if (!this.bottom) {
                from = Int2DoubleAVLTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f2021to) ? new Submap(from, false, to, false) : this;
        }

        public Entry firstEntry() {
            Entry e;
            if (Int2DoubleAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Int2DoubleAVLTreeMap.this.firstEntry;
            } else {
                e = Int2DoubleAVLTreeMap.this.locateKey(this.from);
                if (Int2DoubleAVLTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Int2DoubleAVLTreeMap.this.compare(e.key, this.f2021to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (Int2DoubleAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Int2DoubleAVLTreeMap.this.lastEntry;
            } else {
                e = Int2DoubleAVLTreeMap.this.locateKey(this.f2021to);
                if (Int2DoubleAVLTreeMap.this.compare(e.key, this.f2021to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Int2DoubleAVLTreeMap.this.compare(e.key, this.from) >= 0) {
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
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$Submap$SubmapIterator.class */
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
                if (submap.bottom || Int2DoubleAVLTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Int2DoubleAVLTreeMap int2DoubleAVLTreeMap = Int2DoubleAVLTreeMap.this;
                        Entry lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (int2DoubleAVLTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Int2DoubleAVLTreeMap.this.locateKey(k);
                    if (Int2DoubleAVLTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Int2DoubleAVLTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Int2DoubleAVLTreeMap.this.compare(this.next.key, Submap.this.f2021to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$Submap$SubmapEntryIterator.class */
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
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$Submap$SubmapKeyIterator.class */
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
        /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleAVLTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleAVLTreeMap$Submap$SubmapValueIterator.class */
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
    public Int2DoubleAVLTreeMap clone() {
        try {
            Int2DoubleAVLTreeMap c = (Int2DoubleAVLTreeMap) clone();
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
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readInt(), s.readDouble());
            top2.right(new Entry(s.readInt(), s.readDouble()));
            top2.right.pred(top2);
            top2.balance(1);
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
            top3.right(readTree(s, rightN, top3, succ));
            if (n == (n & (-n))) {
                top3.balance(1);
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
