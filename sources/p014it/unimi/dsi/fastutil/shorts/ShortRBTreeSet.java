package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortRBTreeSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortRBTreeSet.class */
public class ShortRBTreeSet extends AbstractShortSortedSet implements Serializable, Cloneable, ShortSortedSet {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected Comparator<? super Short> storedComparator;
    protected transient ShortComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353130L;
    private transient boolean[] dirPath;
    private transient Entry[] nodePath;

    public ShortRBTreeSet() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = ShortComparators.asShortComparator(this.storedComparator);
    }

    public ShortRBTreeSet(Comparator<? super Short> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public ShortRBTreeSet(Collection<? extends Short> c) {
        this();
        addAll(c);
    }

    public ShortRBTreeSet(SortedSet<Short> s) {
        this(s.comparator());
        addAll(s);
    }

    public ShortRBTreeSet(ShortCollection c) {
        this();
        addAll(c);
    }

    public ShortRBTreeSet(ShortSortedSet s) {
        this(s.comparator());
        addAll((ShortCollection) s);
    }

    public ShortRBTreeSet(ShortIterator i) {
        allocatePaths();
        while (i.hasNext()) {
            add(i.nextShort());
        }
    }

    public ShortRBTreeSet(Iterator<?> i) {
        this(ShortIterators.asShortIterator(i));
    }

    public ShortRBTreeSet(short[] a, int offset, int length, Comparator<? super Short> c) {
        this(c);
        ShortArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ShortRBTreeSet(short[] a, int offset, int length) {
        this(a, offset, length, null);
    }

    public ShortRBTreeSet(short[] a) {
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

    public ShortRBTreeSet(short[] a, Comparator<? super Short> c) {
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

    final int compare(short k1, short k2) {
        return this.actualComparator == null ? Short.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    private Entry findKey(short k) {
        int cmp;
        Entry e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry locateKey(short k) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        r7.nodePath[r13] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0043, code lost:
        r13 = r13 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0048, code lost:
        if (r13 == 0) goto L_0x0056;
     */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(short r8) {
        /*
        // Method dump skipped, instructions count: 903
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortRBTreeSet.add(short):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0432, code lost:
        if (r13.succ() != false) goto L_0x0440;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x043d, code lost:
        if (r13.right.black() == false) goto L_0x048d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0440, code lost:
        r0 = r13.left;
        r0.black(true);
        r13.black(false);
        r13.left = r0.right;
        r0.right = r13;
        r6.nodePath[r10 - 1].right = r0;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x047a, code lost:
        if (r13.succ() == false) goto L_0x048d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x047d, code lost:
        r13.succ(false);
        r13.right.pred(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x048d, code lost:
        r13.black(r6.nodePath[r10 - 1].black());
        r6.nodePath[r10 - 1].black(true);
        r13.right.black(true);
        r6.nodePath[r10 - 1].right = r13.left;
        r13.left = r6.nodePath[r10 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x04d6, code lost:
        if (r10 >= 2) goto L_0x04e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x04d9, code lost:
        r6.tree = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x04eb, code lost:
        if (r6.dirPath[r10 - 2] == false) goto L_0x04ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x04ee, code lost:
        r6.nodePath[r10 - 2].right = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x04ff, code lost:
        r6.nodePath[r10 - 2].left = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0512, code lost:
        if (r13.pred() == false) goto L_0x0723;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0515, code lost:
        r13.pred(false);
        r6.nodePath[r10 - 1].succ(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        r10 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        if (r10 == 0) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        r6.nodePath[r10] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        r10 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (r10 == 0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r6.nodePath[r10] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        return false;
     */
    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(short r7) {
        /*
        // Method dump skipped, instructions count: 1873
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortRBTreeSet.remove(short):boolean");
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
    public boolean contains(short k) {
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortRBTreeSet$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortRBTreeSet$Entry.class */
    public static final class Entry implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        short key;
        Entry left;
        Entry right;
        int info;

        Entry() {
        }

        Entry(short k) {
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
            return (o instanceof Entry) && this.key == ((Entry) o).key;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.key;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.valueOf((int) this.key);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public short firstShort() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public short lastShort() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortRBTreeSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortRBTreeSet$SetIterator.class */
    public class SetIterator implements ShortListIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        SetIterator() {
            this.next = ShortRBTreeSet.this.firstEntry;
        }

        SetIterator(short k) {
            Entry locateKey = ShortRBTreeSet.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (ShortRBTreeSet.this.compare(this.next.key, k) <= 0) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.Iterator, java.util.ListIterator
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
            ShortRBTreeSet.this.remove(this.curr.key);
            this.curr = null;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
    public ShortBidirectionalIterator iterator() {
        return new SetIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public ShortBidirectionalIterator iterator(short from) {
        return new SetIterator(from);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
    public Comparator<? super Short> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public ShortSortedSet headSet(short to) {
        return new Subset(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public ShortSortedSet tailSet(short from) {
        return new Subset(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
    public ShortSortedSet subSet(short from, short to) {
        return new Subset(from, false, to, false);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortRBTreeSet$Subset */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortRBTreeSet$Subset.class */
    private final class Subset extends AbstractShortSortedSet implements Serializable, ShortSortedSet {
        private static final long serialVersionUID = -7046029254386353129L;
        short from;

        /* renamed from: to */
        short f3033to;
        boolean bottom;
        boolean top;

        public Subset(short from, boolean bottom, short to, boolean top) {
            if (bottom || top || ShortRBTreeSet.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f3033to = to;
                this.top = top;
                return;
            }
            throw new IllegalArgumentException("Start element (" + ((int) from) + ") is larger than end element (" + ((int) to) + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SubsetIterator i = new SubsetIterator();
            while (i.hasNext()) {
                i.nextShort();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m396in(short k) {
            return (this.bottom || ShortRBTreeSet.this.compare(k, this.from) >= 0) && (this.top || ShortRBTreeSet.this.compare(k, this.f3033to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return m396in(k) && ShortRBTreeSet.this.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean add(short k) {
            if (m396in(k)) {
                return ShortRBTreeSet.this.add(k);
            }
            throw new IllegalArgumentException("Element (" + ((int) k) + ") out of range [" + (this.bottom ? "-" : String.valueOf((int) this.from)) + ", " + (this.top ? "-" : String.valueOf((int) this.f3033to)) + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.ShortSet
        public boolean remove(short k) {
            if (!m396in(k)) {
                return false;
            }
            return ShortRBTreeSet.this.remove(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            SubsetIterator i = new SubsetIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextShort();
            }
            return n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !new SubsetIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return ShortRBTreeSet.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return new SubsetIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return new SubsetIterator(this, from);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            if (!this.top && ShortRBTreeSet.this.compare(to, this.f3033to) >= 0) {
                return this;
            }
            return new Subset(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            if (!this.bottom && ShortRBTreeSet.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Subset(from, false, this.f3033to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            if (this.top && this.bottom) {
                return new Subset(from, false, to, false);
            }
            if (!this.top) {
                to = ShortRBTreeSet.this.compare(to, this.f3033to) < 0 ? to : this.f3033to;
            }
            if (!this.bottom) {
                from = ShortRBTreeSet.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f3033to) ? new Subset(from, false, to, false) : this;
        }

        public Entry firstEntry() {
            Entry e;
            if (ShortRBTreeSet.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = ShortRBTreeSet.this.firstEntry;
            } else {
                e = ShortRBTreeSet.this.locateKey(this.from);
                if (ShortRBTreeSet.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || ShortRBTreeSet.this.compare(e.key, this.f3033to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (ShortRBTreeSet.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = ShortRBTreeSet.this.lastEntry;
            } else {
                e = ShortRBTreeSet.this.locateKey(this.f3033to);
                if (ShortRBTreeSet.this.compare(e.key, this.f3033to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || ShortRBTreeSet.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.shorts.ShortRBTreeSet$Subset$SubsetIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortRBTreeSet$Subset$SubsetIterator.class */
        public final class SubsetIterator extends SetIterator {
            SubsetIterator() {
                super();
                this.next = Subset.this.firstEntry();
            }

            SubsetIterator(Subset subset, short k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (subset.bottom || ShortRBTreeSet.this.compare(k, this.next.key) >= 0) {
                    if (!subset.top) {
                        ShortRBTreeSet shortRBTreeSet = ShortRBTreeSet.this;
                        Entry lastEntry = subset.lastEntry();
                        this.prev = lastEntry;
                        if (shortRBTreeSet.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = ShortRBTreeSet.this.locateKey(k);
                    if (ShortRBTreeSet.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortRBTreeSet.SetIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Subset.this.bottom && this.prev != null && ShortRBTreeSet.this.compare(this.prev.key, Subset.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortRBTreeSet.SetIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Subset.this.top && this.next != null && ShortRBTreeSet.this.compare(this.next.key, Subset.this.f3033to) >= 0) {
                    this.next = null;
                }
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            ShortRBTreeSet c = (ShortRBTreeSet) clone();
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
                s.writeShort(i.nextShort());
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readShort());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readShort());
            top2.black(true);
            top2.right(new Entry(s.readShort()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry top3 = new Entry();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readShort();
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
