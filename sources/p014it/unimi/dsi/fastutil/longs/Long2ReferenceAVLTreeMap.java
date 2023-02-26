package p014it.unimi.dsi.fastutil.longs;

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
import p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap.class */
public class Long2ReferenceAVLTreeMap<V> extends AbstractLong2ReferenceSortedMap<V> implements Serializable, Cloneable {
    protected transient Entry<V> tree;
    protected int count;
    protected transient Entry<V> firstEntry;
    protected transient Entry<V> lastEntry;
    protected transient ObjectSortedSet<Long2ReferenceMap.Entry<V>> entries;
    protected transient LongSortedSet keys;
    protected transient ReferenceCollection<V> values;
    protected transient boolean modified;
    protected Comparator<? super Long> storedComparator;
    protected transient LongComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Long2ReferenceAVLTreeMap.class.desiredAssertionStatus();
    }

    public Long2ReferenceAVLTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = LongComparators.asLongComparator(this.storedComparator);
    }

    public Long2ReferenceAVLTreeMap(Comparator<? super Long> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Long2ReferenceAVLTreeMap(Map<? extends Long, ? extends V> m) {
        this();
        putAll(m);
    }

    public Long2ReferenceAVLTreeMap(SortedMap<Long, V> m) {
        this(m.comparator());
        putAll(m);
    }

    public Long2ReferenceAVLTreeMap(Long2ReferenceMap<? extends V> m) {
        this();
        putAll(m);
    }

    public Long2ReferenceAVLTreeMap(Long2ReferenceSortedMap<V> m) {
        this(m.comparator());
        putAll(m);
    }

    public Long2ReferenceAVLTreeMap(long[] k, V[] v, Comparator<? super Long> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (long) v[i]);
        }
    }

    public Long2ReferenceAVLTreeMap(long[] k, V[] v) {
        this(k, v, null);
    }

    final int compare(long k1, long k2) {
        return this.actualComparator == null ? Long.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    final Entry<V> findKey(long k) {
        int cmp;
        Entry<V> e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry<V> locateKey(long k) {
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
        this.dirPath = new boolean[48];
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V put(long k, V v) {
        Entry<V> e = add(k);
        V oldValue = (V) e.value;
        e.value = v;
        return oldValue;
    }

    private Entry<V> add(long k) {
        Entry<V> e;
        Entry<V> w;
        this.modified = false;
        if (this.tree == null) {
            this.count++;
            Entry<V> entry = new Entry<>(k, this.defRetValue);
            this.firstEntry = entry;
            this.lastEntry = entry;
            this.tree = entry;
            e = entry;
            this.modified = true;
        } else {
            Entry<V> p = this.tree;
            Entry<V> q = null;
            Entry<V> y = this.tree;
            Entry<V> z = null;
            int i = 0;
            while (true) {
                int cmp = compare(k, p.key);
                if (cmp == 0) {
                    return p;
                }
                if (p.balance() != 0) {
                    i = 0;
                    z = q;
                    y = p;
                }
                boolean[] zArr = this.dirPath;
                i++;
                boolean z2 = cmp > 0;
                zArr[i] = z2;
                if (z2) {
                    if (p.succ()) {
                        this.count++;
                        e = new Entry<>(k, this.defRetValue);
                        this.modified = true;
                        if (p.right == null) {
                            this.lastEntry = e;
                        }
                        e.left = p;
                        e.right = p.right;
                        p.right(e);
                    } else {
                        q = p;
                        p = p.right;
                    }
                } else if (p.pred()) {
                    this.count++;
                    e = new Entry<>(k, this.defRetValue);
                    this.modified = true;
                    if (p.left == null) {
                        this.firstEntry = e;
                    }
                    e.right = p;
                    e.left = p.left;
                    p.left(e);
                } else {
                    q = p;
                    p = p.left;
                }
            }
            Entry<V> p2 = y;
            int i2 = 0;
            while (p2 != e) {
                if (this.dirPath[i2]) {
                    p2.incBalance();
                } else {
                    p2.decBalance();
                }
                i2++;
                p2 = this.dirPath[i2] ? p2.right : p2.left;
            }
            if (y.balance() == -2) {
                Entry<V> x = y.left;
                if (x.balance() == -1) {
                    w = x;
                    if (x.succ()) {
                        x.succ(false);
                        y.pred(x);
                    } else {
                        y.left = x.right;
                    }
                    x.right = y;
                    x.balance(0);
                    y.balance(0);
                } else if ($assertionsDisabled || x.balance() == 1) {
                    w = x.right;
                    x.right = w.left;
                    w.left = x;
                    y.left = w.right;
                    w.right = y;
                    if (w.balance() == -1) {
                        x.balance(0);
                        y.balance(1);
                    } else if (w.balance() == 0) {
                        x.balance(0);
                        y.balance(0);
                    } else {
                        x.balance(-1);
                        y.balance(0);
                    }
                    w.balance(0);
                    if (w.pred()) {
                        x.succ(w);
                        w.pred(false);
                    }
                    if (w.succ()) {
                        y.pred(w);
                        w.succ(false);
                    }
                } else {
                    throw new AssertionError();
                }
            } else if (y.balance() != 2) {
                return e;
            } else {
                Entry<V> x2 = y.right;
                if (x2.balance() == 1) {
                    w = x2;
                    if (x2.pred()) {
                        x2.pred(false);
                        y.succ(x2);
                    } else {
                        y.right = x2.left;
                    }
                    x2.left = y;
                    x2.balance(0);
                    y.balance(0);
                } else if ($assertionsDisabled || x2.balance() == -1) {
                    w = x2.left;
                    x2.left = w.right;
                    w.right = x2;
                    y.right = w.left;
                    w.left = y;
                    if (w.balance() == 1) {
                        x2.balance(0);
                        y.balance(-1);
                    } else if (w.balance() == 0) {
                        x2.balance(0);
                        y.balance(0);
                    } else {
                        x2.balance(1);
                        y.balance(0);
                    }
                    w.balance(0);
                    if (w.pred()) {
                        y.succ(w);
                        w.pred(false);
                    }
                    if (w.succ()) {
                        x2.pred(w);
                        w.succ(false);
                    }
                } else {
                    throw new AssertionError();
                }
            }
            if (z == null) {
                this.tree = w;
            } else if (z.left == y) {
                z.left = w;
            } else {
                z.right = w;
            }
        }
        return e;
    }

    private Entry<V> parent(Entry<V> e) {
        if (e == this.tree) {
            return null;
        }
        Entry<V> y = e;
        Entry<V> x = e;
        while (!y.succ()) {
            if (x.pred()) {
                Entry<V> p = x.left;
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
        Entry<V> p2 = y.right;
        if (p2 == null || p2.left != e) {
            while (!x.pred()) {
                x = x.left;
            }
            p2 = x.left;
        }
        return p2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05e2, code lost:
        r6.modified = true;
        r6.count--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05f6, code lost:
        return (V) r10.value;
     */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V remove(long r7) {
        /*
        // Method dump skipped, instructions count: 1527
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap.remove(long):java.lang.Object");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        Long2ReferenceAVLTreeMap<V>.ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (i.next() != v);
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$Entry.class */
    public static final class Entry<V> extends AbstractLong2ReferenceMap.BasicEntry<V> implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        Entry<V> left;
        Entry<V> right;
        int info;

        Entry() {
            super(0, (Object) null);
        }

        Entry(long k, V v) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap.BasicEntry, java.util.Map.Entry
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Long, V> e = (Map.Entry) o;
            return this.key == e.getKey().longValue() && this.value == e.getValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ (this.value == null ? 0 : System.identityHashCode(this.value));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
    public boolean containsKey(long k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V get(long k) {
        Entry<V> e = findKey(k);
        return e == null ? (V) this.defRetValue : (V) e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public long firstLongKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public long lastLongKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry<V> prev;
        Entry<V> next;
        Entry<V> curr;
        int index = 0;

        TreeIterator() {
            this.next = Long2ReferenceAVLTreeMap.this.firstEntry;
        }

        TreeIterator(long k) {
            Entry<V> locateKey = Long2ReferenceAVLTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Long2ReferenceAVLTreeMap.this.compare(this.next.key, k) <= 0) {
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
            Long2ReferenceAVLTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$EntryIterator.class */
    public class EntryIterator extends Long2ReferenceAVLTreeMap<V>.TreeIterator implements ObjectListIterator<Long2ReferenceMap.Entry<V>> {
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
        }

        EntryIterator() {
            super();
        }

        EntryIterator(long k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Long2ReferenceMap.Entry<V> next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Long2ReferenceMap.Entry<V> previous() {
            return previousEntry();
        }

        public void set(Long2ReferenceMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Long2ReferenceMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public ObjectSortedSet<Long2ReferenceMap.Entry<V>> long2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Long2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap.1
                final Comparator<? super Long2ReferenceMap.Entry<V>> comparator;

                {
                    this.comparator = Long2ReferenceAVLTreeMap.this.actualComparator == null ? x, y -> {
                        return Long.compare(x.getLongKey(), y.getLongKey());
                    } : x, y -> {
                        return Long2ReferenceAVLTreeMap.this.actualComparator.compare(x.getLongKey(), y.getLongKey());
                    };
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                    return iterator((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
                }

                @Override // java.util.SortedSet
                public Comparator<? super Long2ReferenceMap.Entry<V>> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> iterator(Long2ReferenceMap.Entry<V> from) {
                    return new EntryIterator(from.getLongKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Long)) {
                        return e.equals(Long2ReferenceAVLTreeMap.this.findKey(((Long) e.getKey()).longValue()));
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
                    if (e.getKey() == null || e.getKey() == null || !(e.getKey() instanceof Long) || (f = Long2ReferenceAVLTreeMap.this.findKey(((Long) e.getKey()).longValue())) == null || f.getValue() != e.getValue()) {
                        return false;
                    }
                    Long2ReferenceAVLTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Long2ReferenceAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Long2ReferenceAVLTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Long2ReferenceMap.Entry<V> first() {
                    return Long2ReferenceAVLTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Long2ReferenceMap.Entry<V> last() {
                    return Long2ReferenceAVLTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Long2ReferenceMap.Entry<V>> subSet(Long2ReferenceMap.Entry<V> from, Long2ReferenceMap.Entry<V> to) {
                    return Long2ReferenceAVLTreeMap.this.subMap(from.getLongKey(), to.getLongKey()).long2ReferenceEntrySet();
                }

                public ObjectSortedSet<Long2ReferenceMap.Entry<V>> headSet(Long2ReferenceMap.Entry<V> to) {
                    return Long2ReferenceAVLTreeMap.this.headMap(to.getLongKey()).long2ReferenceEntrySet();
                }

                public ObjectSortedSet<Long2ReferenceMap.Entry<V>> tailSet(Long2ReferenceMap.Entry<V> from) {
                    return Long2ReferenceAVLTreeMap.this.tailMap(from.getLongKey()).long2ReferenceEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$KeyIterator.class */
    public final class KeyIterator extends Long2ReferenceAVLTreeMap<V>.TreeIterator implements LongListIterator {
        public KeyIterator() {
            super();
        }

        public KeyIterator(long k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return previousEntry().key;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$KeySet.class */
    public class KeySet extends AbstractLong2ReferenceSortedMap<V>.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    public LongSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$ValueIterator.class */
    public final class ValueIterator extends Long2ReferenceAVLTreeMap<V>.TreeIterator implements ObjectListIterator<V> {
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object k) {
                    return Long2ReferenceAVLTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Long2ReferenceAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Long2ReferenceAVLTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap, java.util.SortedMap
    public Comparator<? super Long> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public Long2ReferenceSortedMap<V> headMap(long to) {
        return new Submap(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public Long2ReferenceSortedMap<V> tailMap(long from) {
        return new Submap(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
    public Long2ReferenceSortedMap<V> subMap(long from, long to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$Submap.class */
    public final class Submap extends AbstractLong2ReferenceSortedMap<V> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        long from;

        /* renamed from: to */
        long f2323to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Long2ReferenceMap.Entry<V>> entries;
        protected transient LongSortedSet keys;
        protected transient ReferenceCollection<V> values;

        public Submap(long from, boolean bottom, long to, boolean top) {
            if (bottom || top || Long2ReferenceAVLTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2323to = to;
                this.top = top;
                this.defRetValue = Long2ReferenceAVLTreeMap.this.defRetValue;
                return;
            }
            throw new IllegalArgumentException("Start key (" + from + ") is larger than end key (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            Long2ReferenceAVLTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                i.nextEntry();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m675in(long k) {
            return (this.bottom || Long2ReferenceAVLTreeMap.this.compare(k, this.from) >= 0) && (this.top || Long2ReferenceAVLTreeMap.this.compare(k, this.f2323to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public ObjectSortedSet<Long2ReferenceMap.Entry<V>> long2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Long2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                    public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                        return iterator((Long2ReferenceMap.Entry) ((Long2ReferenceMap.Entry) obj));
                    }

                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Long2ReferenceMap.Entry<V>> iterator(Long2ReferenceMap.Entry<V> from) {
                        return new SubmapEntryIterator(from.getLongKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Long2ReferenceMap.Entry<V>> comparator() {
                        return Long2ReferenceAVLTreeMap.this.long2ReferenceEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry<V> f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Long) && (f = Long2ReferenceAVLTreeMap.this.findKey(((Long) e.getKey()).longValue())) != null && Submap.this.m675in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Long)) {
                            return false;
                        }
                        Entry<V> f = Long2ReferenceAVLTreeMap.this.findKey(((Long) e.getKey()).longValue());
                        if (f != null && Submap.this.m675in(f.key)) {
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
                    public Long2ReferenceMap.Entry<V> first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Long2ReferenceMap.Entry<V> last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Long2ReferenceMap.Entry<V>> subSet(Long2ReferenceMap.Entry<V> from, Long2ReferenceMap.Entry<V> to) {
                        return Submap.this.subMap(from.getLongKey(), to.getLongKey()).long2ReferenceEntrySet();
                    }

                    public ObjectSortedSet<Long2ReferenceMap.Entry<V>> headSet(Long2ReferenceMap.Entry<V> to) {
                        return Submap.this.headMap(to.getLongKey()).long2ReferenceEntrySet();
                    }

                    public ObjectSortedSet<Long2ReferenceMap.Entry<V>> tailSet(Long2ReferenceMap.Entry<V> from) {
                        return Submap.this.tailMap(from.getLongKey()).long2ReferenceEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractLong2ReferenceSortedMap<V>.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.LongSortedSet
            public LongBidirectionalIterator iterator(long from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            if (this.values == null) {
                this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction, p014it.unimi.dsi.fastutil.longs.Long2ReferenceMap
        public boolean containsKey(long k) {
            return m675in(k) && Long2ReferenceAVLTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
        public boolean containsValue(Object v) {
            Long2ReferenceAVLTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
        public V get(long k) {
            Entry<V> e;
            return (!m675in(k) || (e = Long2ReferenceAVLTreeMap.this.findKey(k)) == null) ? (V) this.defRetValue : (V) e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
        public V put(long k, V v) {
            Long2ReferenceAVLTreeMap.this.modified = false;
            if (!m675in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2323to)) + ")");
            }
            return Long2ReferenceAVLTreeMap.this.modified ? (V) this.defRetValue : (V) Long2ReferenceAVLTreeMap.this.put(k, (long) v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
        public V remove(long k) {
            Long2ReferenceAVLTreeMap.this.modified = false;
            if (!m675in(k)) {
                return (V) this.defRetValue;
            }
            return Long2ReferenceAVLTreeMap.this.modified ? (V) Long2ReferenceAVLTreeMap.this.remove(k) : (V) this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            Long2ReferenceAVLTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextEntry();
            }
            return n;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return Long2ReferenceAVLTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public Long2ReferenceSortedMap<V> headMap(long to) {
            if (!this.top && Long2ReferenceAVLTreeMap.this.compare(to, this.f2323to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public Long2ReferenceSortedMap<V> tailMap(long from) {
            if (!this.bottom && Long2ReferenceAVLTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2323to, this.top);
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
        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public Long2ReferenceSortedMap<V> subMap(long j, long j2) {
            if (this.top && this.bottom) {
                return new Submap(j, false, j2, false);
            }
            long to = j2;
            if (!this.top) {
                to = Long2ReferenceAVLTreeMap.this.compare(j2, this.f2323to) < 0 ? j2 : this.f2323to;
            }
            long from = j;
            if (!this.bottom) {
                from = Long2ReferenceAVLTreeMap.this.compare(j, this.from) > 0 ? j : this.from;
            }
            if (!this.top && !this.bottom) {
                if ((from == 1 ? 1 : 0) == this.from) {
                    if ((to == 1 ? 1 : 0) == this.f2323to) {
                        return this;
                    }
                }
            }
            return new Submap(from, false, to, false);
        }

        public Entry<V> firstEntry() {
            Entry<V> e;
            if (Long2ReferenceAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Long2ReferenceAVLTreeMap.this.firstEntry;
            } else {
                e = Long2ReferenceAVLTreeMap.this.locateKey(this.from);
                if (Long2ReferenceAVLTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Long2ReferenceAVLTreeMap.this.compare(e.key, this.f2323to) < 0) {
                return e;
            }
            return null;
        }

        public Entry<V> lastEntry() {
            Entry<V> e;
            if (Long2ReferenceAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Long2ReferenceAVLTreeMap.this.lastEntry;
            } else {
                e = Long2ReferenceAVLTreeMap.this.locateKey(this.f2323to);
                if (Long2ReferenceAVLTreeMap.this.compare(e.key, this.f2323to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Long2ReferenceAVLTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public long firstLongKey() {
            Entry<V> e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceSortedMap
        public long lastLongKey() {
            Entry<V> e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends Long2ReferenceAVLTreeMap<V>.TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            SubmapIterator(Submap submap, long k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Long2ReferenceAVLTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Long2ReferenceAVLTreeMap long2ReferenceAVLTreeMap = Long2ReferenceAVLTreeMap.this;
                        Entry<V> lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (long2ReferenceAVLTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Long2ReferenceAVLTreeMap.this.locateKey(k);
                    if (Long2ReferenceAVLTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Long2ReferenceAVLTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Long2ReferenceAVLTreeMap.this.compare(this.next.key, Submap.this.f2323to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends Long2ReferenceAVLTreeMap<V>.Submap.SubmapIterator implements ObjectListIterator<Long2ReferenceMap.Entry<V>> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(long k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Long2ReferenceMap.Entry<V> next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Long2ReferenceMap.Entry<V> previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends Long2ReferenceAVLTreeMap<V>.Submap.SubmapIterator implements LongListIterator {
            public SubmapKeyIterator() {
                super();
            }

            public SubmapKeyIterator(long from) {
                super(Submap.this, from);
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                return nextEntry().key;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
            public long previousLong() {
                return previousEntry().key;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2ReferenceAVLTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ReferenceAVLTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends Long2ReferenceAVLTreeMap<V>.Submap.SubmapIterator implements ObjectListIterator<V> {
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
    public Long2ReferenceAVLTreeMap<V> clone() {
        try {
            Long2ReferenceAVLTreeMap<V> c = (Long2ReferenceAVLTreeMap) clone();
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
        Long2ReferenceAVLTreeMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                Entry<V> e = i.nextEntry();
                s.writeLong(e.key);
                s.writeObject(e.value);
            } else {
                return;
            }
        }
    }

    private Entry<V> readTree(ObjectInputStream s, int n, Entry<V> pred, Entry<V> succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry<V> top = new Entry<>(s.readLong(), s.readObject());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry<V> top2 = new Entry<>(s.readLong(), s.readObject());
            top2.right(new Entry<>(s.readLong(), s.readObject()));
            top2.right.pred(top2);
            top2.balance(1);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry<V> top3 = new Entry<>();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readLong();
            top3.value = s.readObject();
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
