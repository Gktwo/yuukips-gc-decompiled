package p014it.unimi.dsi.fastutil.longs;

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

/* renamed from: it.unimi.dsi.fastutil.longs.LongAVLTreeSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongAVLTreeSet.class */
public class LongAVLTreeSet extends AbstractLongSortedSet implements Serializable, Cloneable, LongSortedSet {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected Comparator<? super Long> storedComparator;
    protected transient LongComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353130L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LongAVLTreeSet.class.desiredAssertionStatus();
    }

    public LongAVLTreeSet() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = LongComparators.asLongComparator(this.storedComparator);
    }

    public LongAVLTreeSet(Comparator<? super Long> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public LongAVLTreeSet(Collection<? extends Long> c) {
        this();
        addAll(c);
    }

    public LongAVLTreeSet(SortedSet<Long> s) {
        this(s.comparator());
        addAll(s);
    }

    public LongAVLTreeSet(LongCollection c) {
        this();
        addAll(c);
    }

    public LongAVLTreeSet(LongSortedSet s) {
        this(s.comparator());
        addAll((LongCollection) s);
    }

    public LongAVLTreeSet(LongIterator i) {
        allocatePaths();
        while (i.hasNext()) {
            add(i.nextLong());
        }
    }

    public LongAVLTreeSet(Iterator<?> i) {
        this(LongIterators.asLongIterator(i));
    }

    public LongAVLTreeSet(long[] a, int offset, int length, Comparator<? super Long> c) {
        this(c);
        LongArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public LongAVLTreeSet(long[] a, int offset, int length) {
        this(a, offset, length, null);
    }

    public LongAVLTreeSet(long[] a) {
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

    public LongAVLTreeSet(long[] a, Comparator<? super Long> c) {
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

    final int compare(long k1, long k2) {
        return this.actualComparator == null ? Long.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    private Entry findKey(long k) {
        int cmp;
        Entry e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry locateKey(long k) {
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
        if (p014it.unimi.dsi.fastutil.longs.LongAVLTreeSet.$assertionsDisabled != false) goto L_0x01be;
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
        if (p014it.unimi.dsi.fastutil.longs.LongAVLTreeSet.$assertionsDisabled != false) goto L_0x02c1;
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
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(long r9) {
        /*
        // Method dump skipped, instructions count: 901
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongAVLTreeSet.add(long):boolean");
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
    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(long r7) {
        /*
        // Method dump skipped, instructions count: 1504
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongAVLTreeSet.remove(long):boolean");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
    public boolean contains(long k) {
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
    /* renamed from: it.unimi.dsi.fastutil.longs.LongAVLTreeSet$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongAVLTreeSet$Entry.class */
    public static final class Entry implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        long key;
        Entry left;
        Entry right;
        int info;

        Entry() {
        }

        Entry(long k) {
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
            return (o instanceof Entry) && this.key == ((Entry) o).key;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key);
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

    @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
    public long firstLong() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
    public long lastLong() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongAVLTreeSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongAVLTreeSet$SetIterator.class */
    public class SetIterator implements LongListIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        SetIterator() {
            this.next = LongAVLTreeSet.this.firstEntry;
        }

        SetIterator(long k) {
            Entry locateKey = LongAVLTreeSet.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (LongAVLTreeSet.this.compare(this.next.key, k) <= 0) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator, java.util.Iterator, java.util.ListIterator
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
            LongAVLTreeSet.this.remove(this.curr.key);
            this.curr = null;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
    public LongBidirectionalIterator iterator() {
        return new SetIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
    public LongBidirectionalIterator iterator(long from) {
        return new SetIterator(from);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
    public Comparator<? super Long> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
    public LongSortedSet headSet(long to) {
        return new Subset(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
    public LongSortedSet tailSet(long from) {
        return new Subset(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
    public LongSortedSet subSet(long from, long to) {
        return new Subset(from, false, to, false);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongAVLTreeSet$Subset */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongAVLTreeSet$Subset.class */
    private final class Subset extends AbstractLongSortedSet implements Serializable, LongSortedSet {
        private static final long serialVersionUID = -7046029254386353129L;
        long from;

        /* renamed from: to */
        long f2347to;
        boolean bottom;
        boolean top;

        public Subset(long from, boolean bottom, long to, boolean top) {
            if (bottom || top || LongAVLTreeSet.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2347to = to;
                this.top = top;
                return;
            }
            throw new IllegalArgumentException("Start element (" + from + ") is larger than end element (" + to + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SubsetIterator i = new SubsetIterator();
            while (i.hasNext()) {
                i.nextLong();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m671in(long k) {
            return (this.bottom || LongAVLTreeSet.this.compare(k, this.from) >= 0) && (this.top || LongAVLTreeSet.this.compare(k, this.f2347to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean contains(long k) {
            return m671in(k) && LongAVLTreeSet.this.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
        public boolean add(long k) {
            if (m671in(k)) {
                return LongAVLTreeSet.this.add(k);
            }
            throw new IllegalArgumentException("Element (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2347to)) + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.LongSet
        public boolean remove(long k) {
            if (!m671in(k)) {
                return false;
            }
            return LongAVLTreeSet.this.remove(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            SubsetIterator i = new SubsetIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextLong();
            }
            return n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !new SubsetIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet, java.util.SortedSet
        public Comparator<? super Long> comparator() {
            return LongAVLTreeSet.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new SubsetIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new SubsetIterator(this, from);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet headSet(long to) {
            if (!this.top && LongAVLTreeSet.this.compare(to, this.f2347to) >= 0) {
                return this;
            }
            return new Subset(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet tailSet(long from) {
            if (!this.bottom && LongAVLTreeSet.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Subset(from, false, this.f2347to, this.top);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [long] */
        /* JADX WARN: Type inference failed for: r13v0, types: [long] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r0v29 */
        /* JADX WARN: Type inference failed for: r0v33 */
        /* JADX WARN: Type inference failed for: r0v34 */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongSortedSet subSet(long j, long j2) {
            if (this.top && this.bottom) {
                return new Subset(j, false, j2, false);
            }
            long to = j2;
            if (!this.top) {
                to = LongAVLTreeSet.this.compare(j2, this.f2347to) < 0 ? j2 : this.f2347to;
            }
            long from = j;
            if (!this.bottom) {
                from = LongAVLTreeSet.this.compare(j, this.from) > 0 ? j : this.from;
            }
            if (!this.top && !this.bottom) {
                if ((from == 1 ? 1 : 0) == this.from) {
                    if ((to == 1 ? 1 : 0) == this.f2347to) {
                        return this;
                    }
                }
            }
            return new Subset(from, false, to, false);
        }

        public Entry firstEntry() {
            Entry e;
            if (LongAVLTreeSet.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = LongAVLTreeSet.this.firstEntry;
            } else {
                e = LongAVLTreeSet.this.locateKey(this.from);
                if (LongAVLTreeSet.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || LongAVLTreeSet.this.compare(e.key, this.f2347to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (LongAVLTreeSet.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = LongAVLTreeSet.this.lastEntry;
            } else {
                e = LongAVLTreeSet.this.locateKey(this.f2347to);
                if (LongAVLTreeSet.this.compare(e.key, this.f2347to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || LongAVLTreeSet.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long firstLong() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public long lastLong() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.LongAVLTreeSet$Subset$SubsetIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongAVLTreeSet$Subset$SubsetIterator.class */
        public final class SubsetIterator extends SetIterator {
            SubsetIterator() {
                super();
                this.next = Subset.this.firstEntry();
            }

            SubsetIterator(Subset subset, long k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (subset.bottom || LongAVLTreeSet.this.compare(k, this.next.key) >= 0) {
                    if (!subset.top) {
                        LongAVLTreeSet longAVLTreeSet = LongAVLTreeSet.this;
                        Entry lastEntry = subset.lastEntry();
                        this.prev = lastEntry;
                        if (longAVLTreeSet.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = LongAVLTreeSet.this.locateKey(k);
                    if (LongAVLTreeSet.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongAVLTreeSet.SetIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Subset.this.bottom && this.prev != null && LongAVLTreeSet.this.compare(this.prev.key, Subset.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongAVLTreeSet.SetIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Subset.this.top && this.next != null && LongAVLTreeSet.this.compare(this.next.key, Subset.this.f2347to) >= 0) {
                    this.next = null;
                }
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            LongAVLTreeSet c = (LongAVLTreeSet) clone();
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
                s.writeLong(i.nextLong());
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readLong());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readLong());
            top2.right(new Entry(s.readLong()));
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
            top3.key = s.readLong();
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
