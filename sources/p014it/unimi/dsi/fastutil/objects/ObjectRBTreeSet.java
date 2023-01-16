package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectRBTreeSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectRBTreeSet.class */
public class ObjectRBTreeSet<K> extends AbstractObjectSortedSet<K> implements Serializable, Cloneable, ObjectSortedSet<K> {
    protected transient Entry<K> tree;
    protected int count;
    protected transient Entry<K> firstEntry;
    protected transient Entry<K> lastEntry;
    protected Comparator<? super K> storedComparator;
    protected transient Comparator<? super K> actualComparator;
    private static final long serialVersionUID = -7046029254386353130L;
    private transient boolean[] dirPath;
    private transient Entry<K>[] nodePath;

    public ObjectRBTreeSet() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = this.storedComparator;
    }

    public ObjectRBTreeSet(Comparator<? super K> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public ObjectRBTreeSet(Collection<? extends K> c) {
        this();
        addAll(c);
    }

    public ObjectRBTreeSet(SortedSet<K> s) {
        this(s.comparator());
        addAll(s);
    }

    public ObjectRBTreeSet(ObjectCollection<? extends K> c) {
        this();
        addAll(c);
    }

    public ObjectRBTreeSet(ObjectSortedSet<K> s) {
        this(s.comparator());
        addAll(s);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectRBTreeSet<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectRBTreeSet(Iterator<? extends K> i) {
        allocatePaths();
        while (i.hasNext()) {
            add(i.next());
        }
    }

    public ObjectRBTreeSet(K[] a, int offset, int length, Comparator<? super K> c) {
        this(c);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ObjectRBTreeSet(K[] a, int offset, int length) {
        this(a, offset, length, null);
    }

    public ObjectRBTreeSet(K[] a) {
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

    public ObjectRBTreeSet(K[] a, Comparator<? super K> c) {
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

    final int compare(K k1, K k2) {
        return this.actualComparator == null ? ((Comparable) k1).compareTo(k2) : this.actualComparator.compare(k1, k2);
    }

    private Entry<K> findKey(K k) {
        int cmp;
        Entry<K> e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0050, code lost:
        r7.nodePath[r13] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0048, code lost:
        r13 = r13 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004d, code lost:
        if (r13 == 0) goto L_0x005b;
     */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(K r8) {
        /*
        // Method dump skipped, instructions count: 908
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectRBTreeSet.add(java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 1873
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectRBTreeSet.remove(java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object k) {
        return findKey(k) != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public K get(Object k) {
        Entry<K> entry = findKey(k);
        if (entry == null) {
            return null;
        }
        return entry.key;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.count = 0;
        this.tree = null;
        this.lastEntry = null;
        this.firstEntry = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectRBTreeSet$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectRBTreeSet$Entry.class */
    public static final class Entry<K> implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        K key;
        Entry<K> left;
        Entry<K> right;
        int info;

        Entry() {
        }

        Entry(K k) {
            this.key = k;
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

        @Override // java.lang.Object
        public Entry<K> clone() {
            try {
                Entry<K> c = (Entry) clone();
                c.key = this.key;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            return Objects.equals(this.key, ((Entry) o).key);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.key.hashCode();
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

    @Override // java.util.SortedSet
    public K first() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public K last() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectRBTreeSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectRBTreeSet$SetIterator.class */
    public class SetIterator implements ObjectListIterator<K> {
        Entry<K> prev;
        Entry<K> next;
        Entry<K> curr;
        int index = 0;

        SetIterator() {
            this.next = ObjectRBTreeSet.this.firstEntry;
        }

        SetIterator(K k) {
            Entry<K> locateKey = ObjectRBTreeSet.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (ObjectRBTreeSet.this.compare(this.next.key, k) <= 0) {
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

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return previousEntry().key;
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

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
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
            ObjectRBTreeSet.this.remove(this.curr.key);
            this.curr = null;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    public ObjectBidirectionalIterator<K> iterator() {
        return new SetIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
    public ObjectBidirectionalIterator<K> iterator(K from) {
        return new SetIterator(from);
    }

    @Override // java.util.SortedSet
    public Comparator<? super K> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
    public ObjectSortedSet<K> headSet(K to) {
        return new Subset(null, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
    public ObjectSortedSet<K> tailSet(K from) {
        return new Subset(from, false, null, true);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
    public ObjectSortedSet<K> subSet(K from, K to) {
        return new Subset(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectRBTreeSet$Subset */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectRBTreeSet$Subset.class */
    public final class Subset extends AbstractObjectSortedSet<K> implements Serializable, ObjectSortedSet<K> {
        private static final long serialVersionUID = -7046029254386353129L;
        K from;

        /* renamed from: to */
        K f2728to;
        boolean bottom;
        boolean top;

        public Subset(K from, boolean bottom, K to, boolean top) {
            if (bottom || top || ObjectRBTreeSet.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2728to = to;
                this.top = top;
                return;
            }
            throw new IllegalArgumentException("Start element (" + from + ") is larger than end element (" + to + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ObjectRBTreeSet<K>.Subset.SubsetIterator i = new SubsetIterator();
            while (i.hasNext()) {
                i.next();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m537in(K k) {
            return (this.bottom || ObjectRBTreeSet.this.compare(k, this.from) >= 0) && (this.top || ObjectRBTreeSet.this.compare(k, this.f2728to) < 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return m537in(k) && ObjectRBTreeSet.this.contains(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(K k) {
            if (m537in(k)) {
                return ObjectRBTreeSet.this.add(k);
            }
            throw new IllegalArgumentException("Element (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2728to)) + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            if (!m537in(k)) {
                return false;
            }
            return ObjectRBTreeSet.this.remove(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            ObjectRBTreeSet<K>.Subset.SubsetIterator i = new SubsetIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.next();
            }
            return n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !new SubsetIterator().hasNext();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return ObjectRBTreeSet.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return new SubsetIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new SubsetIterator(this, from);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            if (!this.top && ObjectRBTreeSet.this.compare(to, this.f2728to) >= 0) {
                return this;
            }
            return new Subset(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            if (!this.bottom && ObjectRBTreeSet.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Subset(from, false, this.f2728to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            if (this.top && this.bottom) {
                return new Subset(from, false, to, false);
            }
            if (!this.top) {
                to = ObjectRBTreeSet.this.compare(to, this.f2728to) < 0 ? to : this.f2728to;
            }
            if (!this.bottom) {
                from = ObjectRBTreeSet.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f2728to) ? new Subset(from, false, to, false) : this;
        }

        public Entry<K> firstEntry() {
            Entry<K> e;
            if (ObjectRBTreeSet.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = ObjectRBTreeSet.this.firstEntry;
            } else {
                e = ObjectRBTreeSet.this.locateKey(this.from);
                if (ObjectRBTreeSet.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || ObjectRBTreeSet.this.compare(e.key, this.f2728to) < 0) {
                return e;
            }
            return null;
        }

        public Entry<K> lastEntry() {
            Entry<K> e;
            if (ObjectRBTreeSet.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = ObjectRBTreeSet.this.lastEntry;
            } else {
                e = ObjectRBTreeSet.this.locateKey(this.f2728to);
                if (ObjectRBTreeSet.this.compare(e.key, this.f2728to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || ObjectRBTreeSet.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // java.util.SortedSet
        public K first() {
            Entry<K> e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            Entry<K> e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.ObjectRBTreeSet$Subset$SubsetIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectRBTreeSet$Subset$SubsetIterator.class */
        public final class SubsetIterator extends ObjectRBTreeSet<K>.SetIterator {
            SubsetIterator() {
                super();
                this.next = Subset.this.firstEntry();
            }

            SubsetIterator(Subset subset, K k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (subset.bottom || ObjectRBTreeSet.this.compare(k, this.next.key) >= 0) {
                    if (!subset.top) {
                        ObjectRBTreeSet objectRBTreeSet = ObjectRBTreeSet.this;
                        Entry<K> lastEntry = subset.lastEntry();
                        this.prev = lastEntry;
                        if (objectRBTreeSet.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = ObjectRBTreeSet.this.locateKey(k);
                    if (ObjectRBTreeSet.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectRBTreeSet.SetIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Subset.this.bottom && this.prev != null && ObjectRBTreeSet.this.compare(this.prev.key, Subset.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectRBTreeSet.SetIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Subset.this.top && this.next != null && ObjectRBTreeSet.this.compare(this.next.key, Subset.this.f2728to) >= 0) {
                    this.next = null;
                }
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            ObjectRBTreeSet<K> c = (ObjectRBTreeSet) clone();
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
        ObjectRBTreeSet<K>.SetIterator i = new SetIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                s.writeObject(i.next());
            } else {
                return;
            }
        }
    }

    private Entry<K> readTree(ObjectInputStream s, int n, Entry<K> pred, Entry<K> succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry<K> top = new Entry<>(s.readObject());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry<K> top2 = new Entry<>(s.readObject());
            top2.black(true);
            top2.right(new Entry<>(s.readObject()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry<K> top3 = new Entry<>();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = (K) s.readObject();
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
