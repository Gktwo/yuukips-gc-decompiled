package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.HashCommon;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleAVLTreeSet.class */
public class DoubleAVLTreeSet extends AbstractDoubleSortedSet implements Serializable, Cloneable, DoubleSortedSet {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected Comparator<? super Double> storedComparator;
    protected transient DoubleComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353130L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DoubleAVLTreeSet.class.desiredAssertionStatus();
    }

    public DoubleAVLTreeSet() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = DoubleComparators.asDoubleComparator(this.storedComparator);
    }

    public DoubleAVLTreeSet(Comparator<? super Double> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public DoubleAVLTreeSet(Collection<? extends Double> c) {
        this();
        addAll(c);
    }

    public DoubleAVLTreeSet(SortedSet<Double> s) {
        this(s.comparator());
        addAll(s);
    }

    public DoubleAVLTreeSet(DoubleCollection c) {
        this();
        addAll(c);
    }

    public DoubleAVLTreeSet(DoubleSortedSet s) {
        this(s.comparator());
        addAll((DoubleCollection) s);
    }

    public DoubleAVLTreeSet(DoubleIterator i) {
        allocatePaths();
        while (i.hasNext()) {
            add(i.nextDouble());
        }
    }

    public DoubleAVLTreeSet(Iterator<?> i) {
        this(DoubleIterators.asDoubleIterator(i));
    }

    public DoubleAVLTreeSet(double[] a, int offset, int length, Comparator<? super Double> c) {
        this(c);
        DoubleArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public DoubleAVLTreeSet(double[] a, int offset, int length) {
        this(a, offset, length, null);
    }

    public DoubleAVLTreeSet(double[] a) {
        this();
        int i = a.length;
        while (true) {
            i--;
            if (i != 0) {
                add(a[i]);
            } else {
                return;
            }
        }
    }

    public DoubleAVLTreeSet(double[] a, Comparator<? super Double> c) {
        this(c);
        int i = a.length;
        while (true) {
            i--;
            if (i != 0) {
                add(a[i]);
            } else {
                return;
            }
        }
    }

    final int compare(double k1, double k2) {
        return this.actualComparator == null ? Double.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    private Entry findKey(double k) {
        int cmp;
        Entry e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry locateKey(double k) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0358, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x035c, code lost:
        if (r14 != null) goto L_0x0368;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x035f, code lost:
        r8.tree = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x036f, code lost:
        if (r14.left != r13) goto L_0x037c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0372, code lost:
        r14.left = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x037c, code lost:
        r14.right = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0383, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0114, code lost:
        r11 = r13;
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x011d, code lost:
        if (r11 == r15) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0127, code lost:
        if (r8.dirPath[r18] == false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x012a, code lost:
        r11.incBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0131, code lost:
        r11.decBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0135, code lost:
        r18 = r18 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x013f, code lost:
        if (r8.dirPath[r18] == false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0142, code lost:
        r0 = r11.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0149, code lost:
        r0 = r11.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0158, code lost:
        if (r13.balance() != -2) goto L_0x0255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015b, code lost:
        r0 = r13.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0168, code lost:
        if (r0.balance() != -1) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016b, code lost:
        r16 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0174, code lost:
        if (r0.succ() == false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0177, code lost:
        r0.succ(false);
        r13.pred(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0187, code lost:
        r13.left = r0.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0191, code lost:
        r0.right = r13;
        r0.balance(0);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01aa, code lost:
        if (p014it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet.$assertionsDisabled != false) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b3, code lost:
        if (r0.balance() == 1) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01bd, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01be, code lost:
        r16 = r0.right;
        r0.right = r16.left;
        r16.left = r0;
        r13.left = r16.right;
        r16.right = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01ed, code lost:
        if (r16.balance() != -1) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f0, code lost:
        r0.balance(0);
        r13.balance(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0204, code lost:
        if (r16.balance() != 0) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0207, code lost:
        r0.balance(0);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0216, code lost:
        r0.balance(-1);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0222, code lost:
        r16.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x022d, code lost:
        if (r16.pred() == false) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0230, code lost:
        r0.succ(r16);
        r16.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0242, code lost:
        if (r16.succ() == false) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0245, code lost:
        r13.pred(r16);
        r16.succ(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x025b, code lost:
        if (r13.balance() != 2) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025e, code lost:
        r0 = r13.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x026b, code lost:
        if (r0.balance() != 1) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x026e, code lost:
        r16 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0277, code lost:
        if (r0.pred() == false) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027a, code lost:
        r0.pred(false);
        r13.succ(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x028a, code lost:
        r13.right = r0.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0294, code lost:
        r0.left = r13;
        r0.balance(0);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02ad, code lost:
        if (p014it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet.$assertionsDisabled != false) goto L_0x02c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b6, code lost:
        if (r0.balance() == -1) goto L_0x02c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c0, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c1, code lost:
        r16 = r0.left;
        r0.left = r16.right;
        r16.right = r0;
        r13.right = r16.left;
        r16.left = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02f0, code lost:
        if (r16.balance() != 1) goto L_0x0302;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02f3, code lost:
        r0.balance(0);
        r13.balance(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0307, code lost:
        if (r16.balance() != 0) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x030a, code lost:
        r0.balance(0);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0319, code lost:
        r0.balance(1);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0325, code lost:
        r16.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0330, code lost:
        if (r16.pred() == false) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0333, code lost:
        r13.succ(r16);
        r16.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0345, code lost:
        if (r16.succ() == false) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0348, code lost:
        r0.pred(r16);
        r16.succ(false);
     */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(double r9) {
        /*
        // Method dump skipped, instructions count: 901
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet.add(double):boolean");
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

    /* JADX WARNING: Code restructure failed: missing block: B:225:0x05d4, code lost:
        r6.count--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x05df, code lost:
        return true;
     */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(double r7) {
        /*
        // Method dump skipped, instructions count: 1504
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet.remove(double):boolean");
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    public boolean contains(double k) {
        return findKey(k) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.count = 0;
        this.tree = null;
        this.lastEntry = null;
        this.firstEntry = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleAVLTreeSet$Entry.class */
    public static final class Entry implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        double key;
        Entry left;
        Entry right;
        int info;

        Entry() {
        }

        Entry(double k) {
            this.key = k;
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

        @Override // java.lang.Object
        public Entry clone() {
            try {
                Entry c = (Entry) clone();
                c.key = this.key;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Entry) && Double.doubleToLongBits(this.key) == Double.doubleToLongBits(((Entry) o).key);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return HashCommon.double2int(this.key);
        }

        @Override // java.lang.Object
        public String toString() {
            return String.valueOf(this.key);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.count;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public double firstDouble() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public double lastDouble() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleAVLTreeSet$SetIterator.class */
    public class SetIterator implements DoubleListIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        SetIterator() {
            this.next = DoubleAVLTreeSet.this.firstEntry;
        }

        SetIterator(double k) {
            Entry locateKey = DoubleAVLTreeSet.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (DoubleAVLTreeSet.this.compare(this.next.key, k) <= 0) {
                this.prev = this.next;
                this.next = this.next.next();
                return;
            }
            this.prev = this.next.prev();
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return previousEntry().key;
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

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.Iterator, java.util.ListIterator
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
            DoubleAVLTreeSet.this.remove(this.curr.key);
            this.curr = null;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSortedSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
    public DoubleBidirectionalIterator iterator() {
        return new SetIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public DoubleBidirectionalIterator iterator(double from) {
        return new SetIterator(from);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
    public Comparator<? super Double> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public DoubleSortedSet headSet(double to) {
        return new Subset(0.0d, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public DoubleSortedSet tailSet(double from) {
        return new Subset(from, false, 0.0d, true);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
    public DoubleSortedSet subSet(double from, double to) {
        return new Subset(from, false, to, false);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet$Subset */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleAVLTreeSet$Subset.class */
    private final class Subset extends AbstractDoubleSortedSet implements Serializable, DoubleSortedSet {
        private static final long serialVersionUID = -7046029254386353129L;
        double from;

        /* renamed from: to */
        double f1699to;
        boolean bottom;
        boolean top;

        public Subset(double from, boolean bottom, double to, boolean top) {
            if (bottom || top || DoubleAVLTreeSet.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f1699to = to;
                this.top = top;
                return;
            }
            throw new IllegalArgumentException("Start element (" + from + ") is larger than end element (" + to + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SubsetIterator i = new SubsetIterator();
            while (i.hasNext()) {
                i.nextDouble();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m924in(double k) {
            return (this.bottom || DoubleAVLTreeSet.this.compare(k, this.from) >= 0) && (this.top || DoubleAVLTreeSet.this.compare(k, this.f1699to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return m924in(k) && DoubleAVLTreeSet.this.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean add(double k) {
            if (m924in(k)) {
                return DoubleAVLTreeSet.this.add(k);
            }
            throw new IllegalArgumentException("Element (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f1699to)) + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            if (!m924in(k)) {
                return false;
            }
            return DoubleAVLTreeSet.this.remove(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            SubsetIterator i = new SubsetIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextDouble();
            }
            return n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !new SubsetIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet, java.util.SortedSet
        public Comparator<? super Double> comparator() {
            return DoubleAVLTreeSet.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSortedSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.doubles.DoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleIterable
        public DoubleBidirectionalIterator iterator() {
            return new SubsetIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleBidirectionalIterator iterator(double from) {
            return new SubsetIterator(this, from);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet headSet(double to) {
            if (!this.top && DoubleAVLTreeSet.this.compare(to, this.f1699to) >= 0) {
                return this;
            }
            return new Subset(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            if (!this.bottom && DoubleAVLTreeSet.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Subset(from, false, this.f1699to, this.top);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [double] */
        /* JADX WARN: Type inference failed for: r13v0, types: [double] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r0v29 */
        /* JADX WARN: Type inference failed for: r0v33 */
        /* JADX WARN: Type inference failed for: r0v34 */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet subSet(double d, double d2) {
            if (this.top && this.bottom) {
                return new Subset(d, false, d2, false);
            }
            double to = d2;
            if (!this.top) {
                to = DoubleAVLTreeSet.this.compare(d2, this.f1699to) < 0 ? d2 : this.f1699to;
            }
            double from = d;
            if (!this.bottom) {
                from = DoubleAVLTreeSet.this.compare(d, this.from) > 0 ? d : this.from;
            }
            if (!this.top && !this.bottom) {
                if ((from == Double.MIN_VALUE ? 1.0d : 0.0d) == this.from) {
                    if ((to == Double.MIN_VALUE ? 1.0d : 0.0d) == this.f1699to) {
                        return this;
                    }
                }
            }
            return new Subset(from, false, to, false);
        }

        public Entry firstEntry() {
            Entry e;
            if (DoubleAVLTreeSet.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = DoubleAVLTreeSet.this.firstEntry;
            } else {
                e = DoubleAVLTreeSet.this.locateKey(this.from);
                if (DoubleAVLTreeSet.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || DoubleAVLTreeSet.this.compare(e.key, this.f1699to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (DoubleAVLTreeSet.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = DoubleAVLTreeSet.this.lastEntry;
            } else {
                e = DoubleAVLTreeSet.this.locateKey(this.f1699to);
                if (DoubleAVLTreeSet.this.compare(e.key, this.f1699to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || DoubleAVLTreeSet.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double firstDouble() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public double lastDouble() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet$Subset$SubsetIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleAVLTreeSet$Subset$SubsetIterator.class */
        public final class SubsetIterator extends SetIterator {
            SubsetIterator() {
                super();
                this.next = Subset.this.firstEntry();
            }

            SubsetIterator(Subset subset, double k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (subset.bottom || DoubleAVLTreeSet.this.compare(k, this.next.key) >= 0) {
                    if (!subset.top) {
                        DoubleAVLTreeSet doubleAVLTreeSet = DoubleAVLTreeSet.this;
                        Entry lastEntry = subset.lastEntry();
                        this.prev = lastEntry;
                        if (doubleAVLTreeSet.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = DoubleAVLTreeSet.this.locateKey(k);
                    if (DoubleAVLTreeSet.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet.SetIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Subset.this.bottom && this.prev != null && DoubleAVLTreeSet.this.compare(this.prev.key, Subset.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleAVLTreeSet.SetIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Subset.this.top && this.next != null && DoubleAVLTreeSet.this.compare(this.next.key, Subset.this.f1699to) >= 0) {
                    this.next = null;
                }
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            DoubleAVLTreeSet c = (DoubleAVLTreeSet) clone();
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
        SetIterator i = new SetIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                s.writeDouble(i.nextDouble());
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readDouble());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readDouble());
            top2.right(new Entry(s.readDouble()));
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
            top3.key = s.readDouble();
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
