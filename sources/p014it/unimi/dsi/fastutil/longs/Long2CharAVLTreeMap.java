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
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharListIterator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap;
import p014it.unimi.dsi.fastutil.longs.Long2CharMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap.class */
public class Long2CharAVLTreeMap extends AbstractLong2CharSortedMap implements Serializable, Cloneable {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected transient ObjectSortedSet<Long2CharMap.Entry> entries;
    protected transient LongSortedSet keys;
    protected transient CharCollection values;
    protected transient boolean modified;
    protected Comparator<? super Long> storedComparator;
    protected transient LongComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Long2CharAVLTreeMap.class.desiredAssertionStatus();
    }

    public Long2CharAVLTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = LongComparators.asLongComparator(this.storedComparator);
    }

    public Long2CharAVLTreeMap(Comparator<? super Long> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Long2CharAVLTreeMap(Map<? extends Long, ? extends Character> m) {
        this();
        putAll(m);
    }

    public Long2CharAVLTreeMap(SortedMap<Long, Character> m) {
        this(m.comparator());
        putAll(m);
    }

    public Long2CharAVLTreeMap(Long2CharMap m) {
        this();
        putAll(m);
    }

    public Long2CharAVLTreeMap(Long2CharSortedMap m) {
        this(m.comparator());
        putAll(m);
    }

    public Long2CharAVLTreeMap(long[] k, char[] v, Comparator<? super Long> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Long2CharAVLTreeMap(long[] k, char[] v) {
        this(k, v, null);
    }

    final int compare(long k1, long k2) {
        return this.actualComparator == null ? Long.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    final Entry findKey(long k) {
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

    public char addTo(long k, char incr) {
        Entry e = add(k);
        char oldValue = e.value;
        e.value = (char) (e.value + incr);
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    public char put(long k, char v) {
        Entry e = add(k);
        char oldValue = e.value;
        e.value = v;
        return oldValue;
    }

    private Entry add(long k) {
        Entry e;
        Entry w;
        this.modified = false;
        if (this.tree == null) {
            this.count++;
            Entry entry = new Entry(k, this.defRetValue);
            this.firstEntry = entry;
            this.lastEntry = entry;
            this.tree = entry;
            e = entry;
            this.modified = true;
        } else {
            Entry p = this.tree;
            Entry q = null;
            Entry y = this.tree;
            Entry z = null;
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
                        e = new Entry(k, this.defRetValue);
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
                    e = new Entry(k, this.defRetValue);
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
            Entry p2 = y;
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
                Entry x = y.left;
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
                Entry x2 = y.right;
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

    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05e2, code lost:
        r6.modified = true;
        r6.count--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05f6, code lost:
        return r10.value;
     */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char remove(long r7) {
        /*
        // Method dump skipped, instructions count: 1527
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap.remove(long):char");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public boolean containsValue(char v) {
        ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (i.nextChar() != v);
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$Entry.class */
    public static final class Entry extends AbstractLong2CharMap.BasicEntry implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        Entry left;
        Entry right;
        int info;

        Entry() {
            super(0L, (char) 0);
        }

        Entry(long k, char v) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap.BasicEntry, p014it.unimi.dsi.fastutil.longs.Long2CharMap.Entry
        public char setValue(char value) {
            char oldValue = this.value;
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Long, Character> e = (Map.Entry) o;
            return this.key == e.getKey().longValue() && this.value == e.getValue().charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharMap
    public boolean containsKey(long k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    public char get(long k) {
        Entry e = findKey(k);
        return e == null ? this.defRetValue : e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
    public long firstLongKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
    public long lastLongKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        TreeIterator() {
            this.next = Long2CharAVLTreeMap.this.firstEntry;
        }

        TreeIterator(long k) {
            Entry locateKey = Long2CharAVLTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Long2CharAVLTreeMap.this.compare(this.next.key, k) <= 0) {
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
            Long2CharAVLTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$EntryIterator.class */
    public class EntryIterator extends TreeIterator implements ObjectListIterator<Long2CharMap.Entry> {
        EntryIterator() {
            super();
        }

        EntryIterator(long k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Long2CharMap.Entry next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Long2CharMap.Entry previous() {
            return previousEntry();
        }

        public void set(Long2CharMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Long2CharMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
    public ObjectSortedSet<Long2CharMap.Entry> long2CharEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Long2CharMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap.1
                final Comparator<? super Long2CharMap.Entry> comparator;

                {
                    this.comparator = Long2CharAVLTreeMap.this.actualComparator == null ? x, y -> {
                        return Long.compare(x.getLongKey(), y.getLongKey());
                    } : x, y -> {
                        return Long2CharAVLTreeMap.this.actualComparator.compare(x.getLongKey(), y.getLongKey());
                    };
                }

                @Override // java.util.SortedSet
                public Comparator<? super Long2CharMap.Entry> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Long2CharMap.Entry> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Long2CharMap.Entry> iterator(Long2CharMap.Entry from) {
                    return new EntryIterator(from.getLongKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Long) && e.getValue() != null && (e.getValue() instanceof Character)) {
                        return e.equals(Long2CharAVLTreeMap.this.findKey(((Long) e.getKey()).longValue()));
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
                    if (e.getKey() == null || e.getKey() == null || !(e.getKey() instanceof Long) || !(e.getValue() instanceof Character) || (f = Long2CharAVLTreeMap.this.findKey(((Long) e.getKey()).longValue())) == null || f.getCharValue() != ((Character) e.getValue()).charValue()) {
                        return false;
                    }
                    Long2CharAVLTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Long2CharAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Long2CharAVLTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Long2CharMap.Entry first() {
                    return Long2CharAVLTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Long2CharMap.Entry last() {
                    return Long2CharAVLTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Long2CharMap.Entry> subSet(Long2CharMap.Entry from, Long2CharMap.Entry to) {
                    return Long2CharAVLTreeMap.this.subMap(from.getLongKey(), to.getLongKey()).long2CharEntrySet();
                }

                public ObjectSortedSet<Long2CharMap.Entry> headSet(Long2CharMap.Entry to) {
                    return Long2CharAVLTreeMap.this.headMap(to.getLongKey()).long2CharEntrySet();
                }

                public ObjectSortedSet<Long2CharMap.Entry> tailSet(Long2CharMap.Entry from) {
                    return Long2CharAVLTreeMap.this.tailMap(from.getLongKey()).long2CharEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$KeyIterator.class */
    public final class KeyIterator extends TreeIterator implements LongListIterator {
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$KeySet.class */
    public class KeySet extends AbstractLong2CharSortedMap.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
    public LongSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$ValueIterator.class */
    public final class ValueIterator extends TreeIterator implements CharListIterator {
        private ValueIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return nextEntry().value;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return previousEntry().value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
    public CharCollection values() {
        if (this.values == null) {
            this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
                public CharIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
                public boolean contains(char k) {
                    return Long2CharAVLTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Long2CharAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Long2CharAVLTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap, java.util.SortedMap
    public Comparator<? super Long> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
    public Long2CharSortedMap headMap(long to) {
        return new Submap(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
    public Long2CharSortedMap tailMap(long from) {
        return new Submap(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
    public Long2CharSortedMap subMap(long from, long to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$Submap.class */
    public final class Submap extends AbstractLong2CharSortedMap implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        long from;

        /* renamed from: to */
        long f2251to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Long2CharMap.Entry> entries;
        protected transient LongSortedSet keys;
        protected transient CharCollection values;

        public Submap(long from, boolean bottom, long to, boolean top) {
            if (bottom || top || Long2CharAVLTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2251to = to;
                this.top = top;
                this.defRetValue = Long2CharAVLTreeMap.this.defRetValue;
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
        final boolean m687in(long k) {
            return (this.bottom || Long2CharAVLTreeMap.this.compare(k, this.from) >= 0) && (this.top || Long2CharAVLTreeMap.this.compare(k, this.f2251to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
        public ObjectSortedSet<Long2CharMap.Entry> long2CharEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Long2CharMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Long2CharMap.Entry> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Long2CharMap.Entry> iterator(Long2CharMap.Entry from) {
                        return new SubmapEntryIterator(from.getLongKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Long2CharMap.Entry> comparator() {
                        return Long2CharAVLTreeMap.this.long2CharEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Long) && e.getValue() != null && (e.getValue() instanceof Character) && (f = Long2CharAVLTreeMap.this.findKey(((Long) e.getKey()).longValue())) != null && Submap.this.m687in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Character)) {
                            return false;
                        }
                        Entry f = Long2CharAVLTreeMap.this.findKey(((Long) e.getKey()).longValue());
                        if (f != null && Submap.this.m687in(f.key)) {
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
                    public Long2CharMap.Entry first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Long2CharMap.Entry last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Long2CharMap.Entry> subSet(Long2CharMap.Entry from, Long2CharMap.Entry to) {
                        return Submap.this.subMap(from.getLongKey(), to.getLongKey()).long2CharEntrySet();
                    }

                    public ObjectSortedSet<Long2CharMap.Entry> headSet(Long2CharMap.Entry to) {
                        return Submap.this.headMap(to.getLongKey()).long2CharEntrySet();
                    }

                    public ObjectSortedSet<Long2CharMap.Entry> tailSet(Long2CharMap.Entry from) {
                        return Submap.this.tailMap(from.getLongKey()).long2CharEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractLong2CharSortedMap.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.LongSortedSet
            public LongBidirectionalIterator iterator(long from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap, java.util.Map
        public CharCollection values() {
            if (this.values == null) {
                this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
                    public CharIterator iterator() {
                        return new SubmapValueIterator();
                    }

                    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
                    public boolean contains(char k) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharMap
        public boolean containsKey(long k) {
            return m687in(k) && Long2CharAVLTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, p014it.unimi.dsi.fastutil.longs.Long2CharMap
        public boolean containsValue(char v) {
            SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char get(long k) {
            Entry e;
            return (!m687in(k) || (e = Long2CharAVLTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char put(long k, char v) {
            Long2CharAVLTreeMap.this.modified = false;
            if (!m687in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2251to)) + ")");
            }
            return Long2CharAVLTreeMap.this.modified ? this.defRetValue : Long2CharAVLTreeMap.this.put(k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char remove(long k) {
            Long2CharAVLTreeMap.this.modified = false;
            if (!m687in(k)) {
                return this.defRetValue;
            }
            return Long2CharAVLTreeMap.this.modified ? Long2CharAVLTreeMap.this.remove(k) : this.defRetValue;
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return Long2CharAVLTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
        public Long2CharSortedMap headMap(long to) {
            if (!this.top && Long2CharAVLTreeMap.this.compare(to, this.f2251to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
        public Long2CharSortedMap tailMap(long from) {
            if (!this.bottom && Long2CharAVLTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2251to, this.top);
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
        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
        public Long2CharSortedMap subMap(long j, long j2) {
            if (this.top && this.bottom) {
                return new Submap(j, false, j2, false);
            }
            long to = j2;
            if (!this.top) {
                to = Long2CharAVLTreeMap.this.compare(j2, this.f2251to) < 0 ? j2 : this.f2251to;
            }
            long from = j;
            if (!this.bottom) {
                from = Long2CharAVLTreeMap.this.compare(j, this.from) > 0 ? j : this.from;
            }
            if (!this.top && !this.bottom) {
                if ((from == 1 ? 1 : 0) == this.from) {
                    if ((to == 1 ? 1 : 0) == this.f2251to) {
                        return this;
                    }
                }
            }
            return new Submap(from, false, to, false);
        }

        public Entry firstEntry() {
            Entry e;
            if (Long2CharAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Long2CharAVLTreeMap.this.firstEntry;
            } else {
                e = Long2CharAVLTreeMap.this.locateKey(this.from);
                if (Long2CharAVLTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Long2CharAVLTreeMap.this.compare(e.key, this.f2251to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (Long2CharAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Long2CharAVLTreeMap.this.lastEntry;
            } else {
                e = Long2CharAVLTreeMap.this.locateKey(this.f2251to);
                if (Long2CharAVLTreeMap.this.compare(e.key, this.f2251to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Long2CharAVLTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
        public long firstLongKey() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharSortedMap
        public long lastLongKey() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            SubmapIterator(Submap submap, long k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Long2CharAVLTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Long2CharAVLTreeMap long2CharAVLTreeMap = Long2CharAVLTreeMap.this;
                        Entry lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (long2CharAVLTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Long2CharAVLTreeMap.this.locateKey(k);
                    if (Long2CharAVLTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Long2CharAVLTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Long2CharAVLTreeMap.this.compare(this.next.key, Submap.this.f2251to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends SubmapIterator implements ObjectListIterator<Long2CharMap.Entry> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(long k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Long2CharMap.Entry next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Long2CharMap.Entry previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends SubmapIterator implements LongListIterator {
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
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharAVLTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharAVLTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends SubmapIterator implements CharListIterator {
            private SubmapValueIterator() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
            public char nextChar() {
                return nextEntry().value;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
            public char previousChar() {
                return previousEntry().value;
            }
        }
    }

    @Override // java.lang.Object
    public Long2CharAVLTreeMap clone() {
        try {
            Long2CharAVLTreeMap c = (Long2CharAVLTreeMap) clone();
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
                s.writeLong(e.key);
                s.writeChar(e.value);
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readLong(), s.readChar());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readLong(), s.readChar());
            top2.right(new Entry(s.readLong(), s.readChar()));
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
            top3.value = s.readChar();
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
