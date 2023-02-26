package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.AbstractCharCollection;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharListIterator;
import p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap;
import p014it.unimi.dsi.fastutil.objects.Object2CharMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap.class */
public class Object2CharAVLTreeMap<K> extends AbstractObject2CharSortedMap<K> implements Serializable, Cloneable {
    protected transient Entry<K> tree;
    protected int count;
    protected transient Entry<K> firstEntry;
    protected transient Entry<K> lastEntry;
    protected transient ObjectSortedSet<Object2CharMap.Entry<K>> entries;
    protected transient ObjectSortedSet<K> keys;
    protected transient CharCollection values;
    protected transient boolean modified;
    protected Comparator<? super K> storedComparator;
    protected transient Comparator<? super K> actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Object2CharAVLTreeMap.class.desiredAssertionStatus();
    }

    public Object2CharAVLTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = this.storedComparator;
    }

    public Object2CharAVLTreeMap(Comparator<? super K> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Object2CharAVLTreeMap(Map<? extends K, ? extends Character> m) {
        this();
        putAll(m);
    }

    public Object2CharAVLTreeMap(SortedMap<K, Character> m) {
        this(m.comparator());
        putAll(m);
    }

    public Object2CharAVLTreeMap(Object2CharMap<? extends K> m) {
        this();
        putAll(m);
    }

    public Object2CharAVLTreeMap(Object2CharSortedMap<K> m) {
        this(m.comparator());
        putAll(m);
    }

    public Object2CharAVLTreeMap(K[] k, char[] v, Comparator<? super K> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put((Object2CharAVLTreeMap<K>) k[i], v[i]);
        }
    }

    public Object2CharAVLTreeMap(K[] k, char[] v) {
        this(k, v, null);
    }

    final int compare(K k1, K k2) {
        return this.actualComparator == null ? ((Comparable) k1).compareTo(k2) : this.actualComparator.compare(k1, k2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    final Entry<K> findKey(K k) {
        int cmp;
        Entry<K> e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
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
        this.dirPath = new boolean[48];
    }

    public char addTo(K k, char incr) {
        Entry<K> e = add(k);
        char oldValue = e.value;
        e.value = (char) (e.value + incr);
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    public char put(K k, char v) {
        Entry<K> e = add(k);
        char oldValue = e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    private Entry<K> add(K k) {
        Entry<K> e;
        Entry<K> w;
        Objects.requireNonNull(k);
        this.modified = false;
        if (this.tree == null) {
            this.count++;
            Entry<K> entry = new Entry<>(k, this.defRetValue);
            this.firstEntry = entry;
            this.lastEntry = entry;
            this.tree = entry;
            e = entry;
            this.modified = true;
        } else {
            Entry<K> p = this.tree;
            Entry<K> q = null;
            Entry<K> y = this.tree;
            Entry<K> z = null;
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
            Entry<K> p2 = y;
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
                Entry<K> x = y.left;
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
                Entry<K> x2 = y.right;
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

    private Entry<K> parent(Entry<K> e) {
        if (e == this.tree) {
            return null;
        }
        Entry<K> y = e;
        Entry<K> x = e;
        while (!y.succ()) {
            if (x.pred()) {
                Entry<K> p = x.left;
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
        Entry<K> p2 = y.right;
        if (p2 == null || p2.left != e) {
            while (!x.pred()) {
                x = x.left;
            }
            p2 = x.left;
        }
        return p2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap<K> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05c2, code lost:
        r4.modified = true;
        r4.count--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05d5, code lost:
        return r7.value;
     */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char removeChar(java.lang.Object r5) {
        /*
        // Method dump skipped, instructions count: 1494
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap.removeChar(java.lang.Object):char");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap
    public boolean containsValue(char v) {
        Object2CharAVLTreeMap<K>.ValueIterator i = new ValueIterator();
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$Entry.class */
    public static final class Entry<K> extends AbstractObject2CharMap.BasicEntry<K> implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        Entry<K> left;
        Entry<K> right;
        int info;

        Entry() {
            super((Object) null, (char) 0);
        }

        Entry(K k, char v) {
            super(k, v);
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

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap.BasicEntry, p014it.unimi.dsi.fastutil.objects.Object2CharMap.Entry
        public char setValue(char value) {
            char oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override // java.lang.Object
        public Entry<K> clone() {
            try {
                Entry<K> c = (Entry) clone();
                c.key = this.key;
                c.value = this.value;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, Character> e = (Map.Entry) o;
            return Objects.equals(this.key, e.getKey()) && this.value == e.getValue().charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key.hashCode() ^ this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        return (k == 0 || findKey(k) == null) ? false : true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    public char getChar(Object k) {
        Entry<K> e = findKey(k);
        return e == null ? this.defRetValue : e.value;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        if (this.tree != null) {
            return (K) this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        if (this.tree != null) {
            return (K) this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry<K> prev;
        Entry<K> next;
        Entry<K> curr;
        int index = 0;

        TreeIterator() {
            this.next = Object2CharAVLTreeMap.this.firstEntry;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        TreeIterator(K k) {
            Entry<K> locateKey = Object2CharAVLTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Object2CharAVLTreeMap.this.compare(this.next.key, k) <= 0) {
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

        void updatePrevious() {
            this.prev = this.prev.prev();
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
            Entry<K> entry = this.curr;
            this.prev = entry;
            this.next = entry;
            updatePrevious();
            updateNext();
            Object2CharAVLTreeMap.this.removeChar(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$EntryIterator.class */
    public class EntryIterator extends Object2CharAVLTreeMap<K>.TreeIterator implements ObjectListIterator<Object2CharMap.Entry<K>> {
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Object2CharMap.Entry) ((Object2CharMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Object2CharMap.Entry) ((Object2CharMap.Entry) obj));
        }

        EntryIterator() {
            super();
        }

        EntryIterator(K k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2CharMap.Entry<K> next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2CharMap.Entry<K> previous() {
            return previousEntry();
        }

        public void set(Object2CharMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Object2CharMap.Entry<K> ok) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
    public ObjectSortedSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Object2CharMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap.1
                final Comparator<? super Object2CharMap.Entry<K>> comparator;

                {
                    this.comparator = Object2CharAVLTreeMap.this.actualComparator == null ? x, y -> {
                        return ((Comparable) x.getKey()).compareTo(y.getKey());
                    } : x, y -> {
                        return Object2CharAVLTreeMap.this.actualComparator.compare(x.getKey(), y.getKey());
                    };
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                    return iterator((Object2CharMap.Entry) ((Object2CharMap.Entry) obj));
                }

                @Override // java.util.SortedSet
                public Comparator<? super Object2CharMap.Entry<K>> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Object2CharMap.Entry<K>> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Object2CharMap.Entry<K>> iterator(Object2CharMap.Entry<K> from) {
                    return new EntryIterator(from.getKey());
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() == null || e.getValue() == null || !(e.getValue() instanceof Character)) {
                        return false;
                    }
                    return e.equals(Object2CharAVLTreeMap.this.findKey(e.getKey()));
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object o) {
                    Entry<K> f;
                    if (!(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() == null || !(e.getValue() instanceof Character) || (f = Object2CharAVLTreeMap.this.findKey(e.getKey())) == null || f.getCharValue() != ((Character) e.getValue()).charValue()) {
                        return false;
                    }
                    Object2CharAVLTreeMap.this.removeChar(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Object2CharAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Object2CharAVLTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Object2CharMap.Entry<K> first() {
                    return Object2CharAVLTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Object2CharMap.Entry<K> last() {
                    return Object2CharAVLTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Object2CharMap.Entry<K>> subSet(Object2CharMap.Entry<K> from, Object2CharMap.Entry<K> to) {
                    return Object2CharAVLTreeMap.this.subMap((Object) from.getKey(), (Object) to.getKey()).object2CharEntrySet();
                }

                public ObjectSortedSet<Object2CharMap.Entry<K>> headSet(Object2CharMap.Entry<K> to) {
                    return Object2CharAVLTreeMap.this.headMap((Object2CharAVLTreeMap) to.getKey()).object2CharEntrySet();
                }

                public ObjectSortedSet<Object2CharMap.Entry<K>> tailSet(Object2CharMap.Entry<K> from) {
                    return Object2CharAVLTreeMap.this.tailMap((Object2CharAVLTreeMap) from.getKey()).object2CharEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$KeyIterator.class */
    public final class KeyIterator extends Object2CharAVLTreeMap<K>.TreeIterator implements ObjectListIterator<K> {
        public KeyIterator() {
            super();
        }

        public KeyIterator(K k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return (K) nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return (K) previousEntry().key;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$KeySet.class */
    public class KeySet extends AbstractObject2CharSortedMap<K>.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$ValueIterator.class */
    public final class ValueIterator extends Object2CharAVLTreeMap<K>.TreeIterator implements CharListIterator {
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
    public CharCollection values() {
        if (this.values == null) {
            this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
                public CharIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
                public boolean contains(char k) {
                    return Object2CharAVLTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2CharAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2CharAVLTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
    public Object2CharSortedMap<K> headMap(K to) {
        return new Submap(null, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
    public Object2CharSortedMap<K> tailMap(K from) {
        return new Submap(from, false, null, true);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
    public Object2CharSortedMap<K> subMap(K from, K to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$Submap.class */
    public final class Submap extends AbstractObject2CharSortedMap<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        K from;

        /* renamed from: to */
        K f2532to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Object2CharMap.Entry<K>> entries;
        protected transient ObjectSortedSet<K> keys;
        protected transient CharCollection values;

        public Submap(K from, boolean bottom, K to, boolean top) {
            if (bottom || top || Object2CharAVLTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2532to = to;
                this.top = top;
                this.defRetValue = Object2CharAVLTreeMap.this.defRetValue;
                return;
            }
            throw new IllegalArgumentException("Start key (" + from + ") is larger than end key (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            Object2CharAVLTreeMap<K>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                i.nextEntry();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m602in(K k) {
            return (this.bottom || Object2CharAVLTreeMap.this.compare(k, this.from) >= 0) && (this.top || Object2CharAVLTreeMap.this.compare(k, this.f2532to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap
        public ObjectSortedSet<Object2CharMap.Entry<K>> object2CharEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Object2CharMap.Entry<K>>() { // from class: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                    public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                        return iterator((Object2CharMap.Entry) ((Object2CharMap.Entry) obj));
                    }

                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Object2CharMap.Entry<K>> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Object2CharMap.Entry<K>> iterator(Object2CharMap.Entry<K> from) {
                        return new SubmapEntryIterator(from.getKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Object2CharMap.Entry<K>> comparator() {
                        return Object2CharAVLTreeMap.this.object2CharEntrySet().comparator();
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
                    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Submap */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry<K> f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getValue() != null && (e.getValue() instanceof Character) && (f = Object2CharAVLTreeMap.this.findKey(e.getKey())) != null && Submap.this.m602in(f.key) && e.equals(f);
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
                    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Submap */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getValue() == null || !(e.getValue() instanceof Character)) {
                            return false;
                        }
                        Entry<K> f = Object2CharAVLTreeMap.this.findKey(e.getKey());
                        if (f != null && Submap.this.m602in(f.key)) {
                            Submap.this.removeChar(f.key);
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
                    public Object2CharMap.Entry<K> first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Object2CharMap.Entry<K> last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Object2CharMap.Entry<K>> subSet(Object2CharMap.Entry<K> from, Object2CharMap.Entry<K> to) {
                        return Submap.this.subMap((Object) from.getKey(), (Object) to.getKey()).object2CharEntrySet();
                    }

                    public ObjectSortedSet<Object2CharMap.Entry<K>> headSet(Object2CharMap.Entry<K> to) {
                        return Submap.this.headMap((Submap) to.getKey()).object2CharEntrySet();
                    }

                    public ObjectSortedSet<Object2CharMap.Entry<K>> tailSet(Object2CharMap.Entry<K> from) {
                        return Submap.this.tailMap((Submap) from.getKey()).object2CharEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractObject2CharSortedMap<K>.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectBidirectionalIterator<K> iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
            public ObjectBidirectionalIterator<K> iterator(K from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap, java.util.Map
        public CharCollection values() {
            if (this.values == null) {
                this.values = new AbstractCharCollection() { // from class: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap.Submap.2
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

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return k != null && m602in(k) && Object2CharAVLTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, p014it.unimi.dsi.fastutil.objects.Object2CharMap
        public boolean containsValue(char v) {
            Object2CharAVLTreeMap<K>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        public char getChar(Object k) {
            Entry<K> e;
            return (!m602in(k) || (e = Object2CharAVLTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        public char put(K k, char v) {
            Object2CharAVLTreeMap.this.modified = false;
            if (!m602in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2532to)) + ")");
            }
            return Object2CharAVLTreeMap.this.modified ? this.defRetValue : Object2CharAVLTreeMap.this.put((Object2CharAVLTreeMap) k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
        public char removeChar(Object k) {
            Object2CharAVLTreeMap.this.modified = false;
            if (!m602in(k)) {
                return this.defRetValue;
            }
            return Object2CharAVLTreeMap.this.modified ? Object2CharAVLTreeMap.this.removeChar(k) : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            Object2CharAVLTreeMap<K>.Submap.SubmapIterator i = new SubmapIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextEntry();
            }
            return n;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2CharMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return Object2CharAVLTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> headMap(K to) {
            if (!this.top && Object2CharAVLTreeMap.this.compare(to, this.f2532to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> tailMap(K from) {
            if (!this.bottom && Object2CharAVLTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2532to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2CharSortedMap, java.util.SortedMap
        public Object2CharSortedMap<K> subMap(K from, K to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Object2CharAVLTreeMap.this.compare(to, this.f2532to) < 0 ? to : this.f2532to;
            }
            if (!this.bottom) {
                from = Object2CharAVLTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f2532to) ? new Submap(from, false, to, false) : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
        /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        public Entry<K> firstEntry() {
            Entry<K> e;
            if (Object2CharAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Object2CharAVLTreeMap.this.firstEntry;
            } else {
                e = Object2CharAVLTreeMap.this.locateKey(this.from);
                if (Object2CharAVLTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Object2CharAVLTreeMap.this.compare(e.key, this.f2532to) < 0) {
                return e;
            }
            return null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
        /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        public Entry<K> lastEntry() {
            Entry<K> e;
            if (Object2CharAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Object2CharAVLTreeMap.this.lastEntry;
            } else {
                e = Object2CharAVLTreeMap.this.locateKey(this.f2532to);
                if (Object2CharAVLTreeMap.this.compare(e.key, this.f2532to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Object2CharAVLTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            Entry<K> e = firstEntry();
            if (e != null) {
                return (K) e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            Entry<K> e = lastEntry();
            if (e != null) {
                return (K) e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends Object2CharAVLTreeMap<K>.TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
            /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
            /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            SubmapIterator(Submap submap, K k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Object2CharAVLTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Object2CharAVLTreeMap object2CharAVLTreeMap = Object2CharAVLTreeMap.this;
                        Entry<K> lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (object2CharAVLTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Object2CharAVLTreeMap.this.locateKey(k);
                    if (Object2CharAVLTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Object2CharAVLTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Object2CharAVLTreeMap.this.compare(this.next.key, Submap.this.f2532to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends Object2CharAVLTreeMap<K>.Submap.SubmapIterator implements ObjectListIterator<Object2CharMap.Entry<K>> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(K k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Object2CharMap.Entry<K> next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Object2CharMap.Entry<K> previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends Object2CharAVLTreeMap<K>.Submap.SubmapIterator implements ObjectListIterator<K> {
            public SubmapKeyIterator() {
                super();
            }

            public SubmapKeyIterator(K from) {
                super(Submap.this, from);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public K next() {
                return (K) nextEntry().key;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public K previous() {
                return (K) previousEntry().key;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2CharAVLTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharAVLTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends Object2CharAVLTreeMap<K>.Submap.SubmapIterator implements CharListIterator {
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
    public Object2CharAVLTreeMap<K> clone() {
        try {
            Object2CharAVLTreeMap<K> c = (Object2CharAVLTreeMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
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
        Object2CharAVLTreeMap<K>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                Entry<K> e = i.nextEntry();
                s.writeObject(e.key);
                s.writeChar(e.value);
            } else {
                return;
            }
        }
    }

    private Entry<K> readTree(ObjectInputStream s, int n, Entry<K> pred, Entry<K> succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry<K> top = new Entry<>(s.readObject(), s.readChar());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry<K> top2 = new Entry<>(s.readObject(), s.readChar());
            top2.right(new Entry<>(s.readObject(), s.readChar()));
            top2.right.pred(top2);
            top2.balance(1);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry<K> top3 = new Entry<>();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readObject();
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
