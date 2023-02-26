package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteRBTreeSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteRBTreeSet.class */
public class ByteRBTreeSet extends AbstractByteSortedSet implements Serializable, Cloneable, ByteSortedSet {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected Comparator<? super Byte> storedComparator;
    protected transient ByteComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353130L;
    private transient boolean[] dirPath;
    private transient Entry[] nodePath;

    public ByteRBTreeSet() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = ByteComparators.asByteComparator(this.storedComparator);
    }

    public ByteRBTreeSet(Comparator<? super Byte> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public ByteRBTreeSet(Collection<? extends Byte> c) {
        this();
        addAll(c);
    }

    public ByteRBTreeSet(SortedSet<Byte> s) {
        this(s.comparator());
        addAll(s);
    }

    public ByteRBTreeSet(ByteCollection c) {
        this();
        addAll(c);
    }

    public ByteRBTreeSet(ByteSortedSet s) {
        this(s.comparator());
        addAll((ByteCollection) s);
    }

    public ByteRBTreeSet(ByteIterator i) {
        allocatePaths();
        while (i.hasNext()) {
            add(i.nextByte());
        }
    }

    public ByteRBTreeSet(Iterator<?> i) {
        this(ByteIterators.asByteIterator(i));
    }

    public ByteRBTreeSet(byte[] a, int offset, int length, Comparator<? super Byte> c) {
        this(c);
        ByteArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ByteRBTreeSet(byte[] a, int offset, int length) {
        this(a, offset, length, null);
    }

    public ByteRBTreeSet(byte[] a) {
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

    public ByteRBTreeSet(byte[] a, Comparator<? super Byte> c) {
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

    final int compare(byte k1, byte k2) {
        return this.actualComparator == null ? Byte.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    private Entry findKey(byte k) {
        int cmp;
        Entry e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry locateKey(byte k) {
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
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(byte r8) {
        /*
        // Method dump skipped, instructions count: 903
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteRBTreeSet.add(byte):boolean");
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
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(byte r7) {
        /*
        // Method dump skipped, instructions count: 1873
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteRBTreeSet.remove(byte):boolean");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean contains(byte k) {
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteRBTreeSet$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteRBTreeSet$Entry.class */
    public static final class Entry implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        byte key;
        Entry left;
        Entry right;
        int info;

        Entry() {
        }

        Entry(byte k) {
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

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
    public byte firstByte() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
    public byte lastByte() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteRBTreeSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteRBTreeSet$SetIterator.class */
    public class SetIterator implements ByteListIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        SetIterator() {
            this.next = ByteRBTreeSet.this.firstEntry;
        }

        SetIterator(byte k) {
            Entry locateKey = ByteRBTreeSet.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (ByteRBTreeSet.this.compare(this.next.key, k) <= 0) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator, java.util.Iterator, java.util.ListIterator
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
            ByteRBTreeSet.this.remove(this.curr.key);
            this.curr = null;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public ByteBidirectionalIterator iterator() {
        return new SetIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
    public ByteBidirectionalIterator iterator(byte from) {
        return new SetIterator(from);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
    public Comparator<? super Byte> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
    public ByteSortedSet headSet(byte to) {
        return new Subset((byte) 0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
    public ByteSortedSet tailSet(byte from) {
        return new Subset(from, false, (byte) 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
    public ByteSortedSet subSet(byte from, byte to) {
        return new Subset(from, false, to, false);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteRBTreeSet$Subset */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteRBTreeSet$Subset.class */
    private final class Subset extends AbstractByteSortedSet implements Serializable, ByteSortedSet {
        private static final long serialVersionUID = -7046029254386353129L;
        byte from;

        /* renamed from: to */
        byte f1265to;
        boolean bottom;
        boolean top;

        public Subset(byte from, boolean bottom, byte to, boolean top) {
            if (bottom || top || ByteRBTreeSet.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f1265to = to;
                this.top = top;
                return;
            }
            throw new IllegalArgumentException("Start element (" + ((int) from) + ") is larger than end element (" + ((int) to) + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SubsetIterator i = new SubsetIterator();
            while (i.hasNext()) {
                i.nextByte();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m1042in(byte k) {
            return (this.bottom || ByteRBTreeSet.this.compare(k, this.from) >= 0) && (this.top || ByteRBTreeSet.this.compare(k, this.f1265to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean contains(byte k) {
            return m1042in(k) && ByteRBTreeSet.this.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
        public boolean add(byte k) {
            if (m1042in(k)) {
                return ByteRBTreeSet.this.add(k);
            }
            throw new IllegalArgumentException("Element (" + ((int) k) + ") out of range [" + (this.bottom ? "-" : String.valueOf((int) this.from)) + ", " + (this.top ? "-" : String.valueOf((int) this.f1265to)) + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
        public boolean remove(byte k) {
            if (!m1042in(k)) {
                return false;
            }
            return ByteRBTreeSet.this.remove(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            SubsetIterator i = new SubsetIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextByte();
            }
            return n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !new SubsetIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet, java.util.SortedSet
        public Comparator<? super Byte> comparator() {
            return ByteRBTreeSet.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return new SubsetIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return new SubsetIterator(this, from);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet headSet(byte to) {
            if (!this.top && ByteRBTreeSet.this.compare(to, this.f1265to) >= 0) {
                return this;
            }
            return new Subset(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet tailSet(byte from) {
            if (!this.bottom && ByteRBTreeSet.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Subset(from, false, this.f1265to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteSortedSet subSet(byte from, byte to) {
            if (this.top && this.bottom) {
                return new Subset(from, false, to, false);
            }
            if (!this.top) {
                to = ByteRBTreeSet.this.compare(to, this.f1265to) < 0 ? to : this.f1265to;
            }
            if (!this.bottom) {
                from = ByteRBTreeSet.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f1265to) ? new Subset(from, false, to, false) : this;
        }

        public Entry firstEntry() {
            Entry e;
            if (ByteRBTreeSet.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = ByteRBTreeSet.this.firstEntry;
            } else {
                e = ByteRBTreeSet.this.locateKey(this.from);
                if (ByteRBTreeSet.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || ByteRBTreeSet.this.compare(e.key, this.f1265to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (ByteRBTreeSet.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = ByteRBTreeSet.this.lastEntry;
            } else {
                e = ByteRBTreeSet.this.locateKey(this.f1265to);
                if (ByteRBTreeSet.this.compare(e.key, this.f1265to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || ByteRBTreeSet.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte firstByte() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public byte lastByte() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.ByteRBTreeSet$Subset$SubsetIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteRBTreeSet$Subset$SubsetIterator.class */
        public final class SubsetIterator extends SetIterator {
            SubsetIterator() {
                super();
                this.next = Subset.this.firstEntry();
            }

            SubsetIterator(Subset subset, byte k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (subset.bottom || ByteRBTreeSet.this.compare(k, this.next.key) >= 0) {
                    if (!subset.top) {
                        ByteRBTreeSet byteRBTreeSet = ByteRBTreeSet.this;
                        Entry lastEntry = subset.lastEntry();
                        this.prev = lastEntry;
                        if (byteRBTreeSet.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = ByteRBTreeSet.this.locateKey(k);
                    if (ByteRBTreeSet.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteRBTreeSet.SetIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Subset.this.bottom && this.prev != null && ByteRBTreeSet.this.compare(this.prev.key, Subset.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteRBTreeSet.SetIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Subset.this.top && this.next != null && ByteRBTreeSet.this.compare(this.next.key, Subset.this.f1265to) >= 0) {
                    this.next = null;
                }
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            ByteRBTreeSet c = (ByteRBTreeSet) clone();
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
                s.writeByte(i.nextByte());
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readByte());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readByte());
            top2.black(true);
            top2.right(new Entry(s.readByte()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry top3 = new Entry();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readByte();
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
