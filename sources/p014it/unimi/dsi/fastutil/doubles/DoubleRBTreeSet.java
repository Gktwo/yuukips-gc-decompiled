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

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleRBTreeSet.class */
public class DoubleRBTreeSet extends AbstractDoubleSortedSet implements Serializable, Cloneable, DoubleSortedSet {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected Comparator<? super Double> storedComparator;
    protected transient DoubleComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353130L;
    private transient boolean[] dirPath;
    private transient Entry[] nodePath;

    public DoubleRBTreeSet() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = DoubleComparators.asDoubleComparator(this.storedComparator);
    }

    public DoubleRBTreeSet(Comparator<? super Double> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public DoubleRBTreeSet(Collection<? extends Double> c) {
        this();
        addAll(c);
    }

    public DoubleRBTreeSet(SortedSet<Double> s) {
        this(s.comparator());
        addAll(s);
    }

    public DoubleRBTreeSet(DoubleCollection c) {
        this();
        addAll(c);
    }

    public DoubleRBTreeSet(DoubleSortedSet s) {
        this(s.comparator());
        addAll((DoubleCollection) s);
    }

    public DoubleRBTreeSet(DoubleIterator i) {
        allocatePaths();
        while (i.hasNext()) {
            add(i.nextDouble());
        }
    }

    public DoubleRBTreeSet(Iterator<?> i) {
        this(DoubleIterators.asDoubleIterator(i));
    }

    public DoubleRBTreeSet(double[] a, int offset, int length, Comparator<? super Double> c) {
        this(c);
        DoubleArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public DoubleRBTreeSet(double[] a, int offset, int length) {
        this(a, offset, length, null);
    }

    public DoubleRBTreeSet(double[] a) {
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

    public DoubleRBTreeSet(double[] a, Comparator<? super Double> c) {
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
        this.dirPath = new boolean[64];
        this.nodePath = new Entry[64];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004d, code lost:
        r8.nodePath[r15] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
        r15 = r15 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
        if (r15 == 0) goto L_0x0058;
     */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(double r9) {
        /*
        // Method dump skipped, instructions count: 920
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet.add(double):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0434, code lost:
        if (r15.succ() != false) goto L_0x0442;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x043f, code lost:
        if (r15.right.black() == false) goto L_0x048f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0442, code lost:
        r0 = r15.left;
        r0.black(true);
        r15.black(false);
        r15.left = r0.right;
        r0.right = r15;
        r6.nodePath[r11 - 1].right = r0;
        r15 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x047c, code lost:
        if (r15.succ() == false) goto L_0x048f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x047f, code lost:
        r15.succ(false);
        r15.right.pred(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x048f, code lost:
        r15.black(r6.nodePath[r11 - 1].black());
        r6.nodePath[r11 - 1].black(true);
        r15.right.black(true);
        r6.nodePath[r11 - 1].right = r15.left;
        r15.left = r6.nodePath[r11 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x04d8, code lost:
        if (r11 >= 2) goto L_0x04e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x04db, code lost:
        r6.tree = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x04ed, code lost:
        if (r6.dirPath[r11 - 2] == false) goto L_0x0501;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x04f0, code lost:
        r6.nodePath[r11 - 2].right = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0501, code lost:
        r6.nodePath[r11 - 2].left = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0514, code lost:
        if (r15.pred() == false) goto L_0x0725;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0517, code lost:
        r15.pred(false);
        r6.nodePath[r11 - 1].succ(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0625, code lost:
        if (r15.pred() != false) goto L_0x0633;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0630, code lost:
        if (r15.left.black() == false) goto L_0x0680;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0633, code lost:
        r0 = r15.right;
        r0.black(true);
        r15.black(false);
        r15.right = r0.left;
        r0.left = r15;
        r6.nodePath[r11 - 1].left = r0;
        r15 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x066d, code lost:
        if (r15.pred() == false) goto L_0x0680;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0670, code lost:
        r15.pred(false);
        r15.left.succ(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        r11 = r11 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0680, code lost:
        r15.black(r6.nodePath[r11 - 1].black());
        r6.nodePath[r11 - 1].black(true);
        r15.left.black(true);
        r6.nodePath[r11 - 1].left = r15.right;
        r15.right = r6.nodePath[r11 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x06c9, code lost:
        if (r11 >= 2) goto L_0x06d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x06cc, code lost:
        r6.tree = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x06de, code lost:
        if (r6.dirPath[r11 - 2] == false) goto L_0x06f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x06e1, code lost:
        r6.nodePath[r11 - 2].right = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x06f2, code lost:
        r6.nodePath[r11 - 2].left = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0705, code lost:
        if (r15.succ() == false) goto L_0x0725;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0708, code lost:
        r15.succ(false);
        r6.nodePath[r11 - 1].pred(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        if (r11 == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005e, code lost:
        r6.nodePath[r11] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        r11 = r11 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0079, code lost:
        if (r11 == 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        r6.nodePath[r11] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
        return false;
     */
    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(double r7) {
        /*
        // Method dump skipped, instructions count: 1875
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet.remove(double):boolean");
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
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleRBTreeSet$Entry.class */
    public static final class Entry implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
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
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleRBTreeSet$SetIterator.class */
    public class SetIterator implements DoubleListIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        SetIterator() {
            this.next = DoubleRBTreeSet.this.firstEntry;
        }

        SetIterator(double k) {
            Entry locateKey = DoubleRBTreeSet.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (DoubleRBTreeSet.this.compare(this.next.key, k) <= 0) {
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

        void updatePrevious() {
            this.prev = this.prev.prev();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return previousEntry().key;
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
            DoubleRBTreeSet.this.remove(this.curr.key);
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

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet$Subset */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleRBTreeSet$Subset.class */
    private final class Subset extends AbstractDoubleSortedSet implements Serializable, DoubleSortedSet {
        private static final long serialVersionUID = -7046029254386353129L;
        double from;

        /* renamed from: to */
        double f1714to;
        boolean bottom;
        boolean top;

        public Subset(double from, boolean bottom, double to, boolean top) {
            if (bottom || top || DoubleRBTreeSet.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f1714to = to;
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
        final boolean m872in(double k) {
            return (this.bottom || DoubleRBTreeSet.this.compare(k, this.from) >= 0) && (this.top || DoubleRBTreeSet.this.compare(k, this.f1714to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean contains(double k) {
            return m872in(k) && DoubleRBTreeSet.this.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleCollection, p014it.unimi.dsi.fastutil.doubles.DoubleCollection
        public boolean add(double k) {
            if (m872in(k)) {
                return DoubleRBTreeSet.this.add(k);
            }
            throw new IllegalArgumentException("Element (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f1714to)) + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleSet, p014it.unimi.dsi.fastutil.doubles.DoubleSet
        public boolean remove(double k) {
            if (!m872in(k)) {
                return false;
            }
            return DoubleRBTreeSet.this.remove(k);
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
            return DoubleRBTreeSet.this.actualComparator;
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
            if (!this.top && DoubleRBTreeSet.this.compare(to, this.f1714to) >= 0) {
                return this;
            }
            return new Subset(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSortedSet
        public DoubleSortedSet tailSet(double from) {
            if (!this.bottom && DoubleRBTreeSet.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Subset(from, false, this.f1714to, this.top);
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
                to = DoubleRBTreeSet.this.compare(d2, this.f1714to) < 0 ? d2 : this.f1714to;
            }
            double from = d;
            if (!this.bottom) {
                from = DoubleRBTreeSet.this.compare(d, this.from) > 0 ? d : this.from;
            }
            if (!this.top && !this.bottom) {
                if ((from == Double.MIN_VALUE ? 1.0d : 0.0d) == this.from) {
                    if ((to == Double.MIN_VALUE ? 1.0d : 0.0d) == this.f1714to) {
                        return this;
                    }
                }
            }
            return new Subset(from, false, to, false);
        }

        public Entry firstEntry() {
            Entry e;
            if (DoubleRBTreeSet.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = DoubleRBTreeSet.this.firstEntry;
            } else {
                e = DoubleRBTreeSet.this.locateKey(this.from);
                if (DoubleRBTreeSet.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || DoubleRBTreeSet.this.compare(e.key, this.f1714to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (DoubleRBTreeSet.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = DoubleRBTreeSet.this.lastEntry;
            } else {
                e = DoubleRBTreeSet.this.locateKey(this.f1714to);
                if (DoubleRBTreeSet.this.compare(e.key, this.f1714to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || DoubleRBTreeSet.this.compare(e.key, this.from) >= 0) {
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
        /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet$Subset$SubsetIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleRBTreeSet$Subset$SubsetIterator.class */
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
                if (subset.bottom || DoubleRBTreeSet.this.compare(k, this.next.key) >= 0) {
                    if (!subset.top) {
                        DoubleRBTreeSet doubleRBTreeSet = DoubleRBTreeSet.this;
                        Entry lastEntry = subset.lastEntry();
                        this.prev = lastEntry;
                        if (doubleRBTreeSet.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = DoubleRBTreeSet.this.locateKey(k);
                    if (DoubleRBTreeSet.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet.SetIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Subset.this.bottom && this.prev != null && DoubleRBTreeSet.this.compare(this.prev.key, Subset.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleRBTreeSet.SetIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Subset.this.top && this.next != null && DoubleRBTreeSet.this.compare(this.next.key, Subset.this.f1714to) >= 0) {
                    this.next = null;
                }
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            DoubleRBTreeSet c = (DoubleRBTreeSet) clone();
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
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readDouble());
            top2.black(true);
            top2.right(new Entry(s.readDouble()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry top3 = new Entry();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readDouble();
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
