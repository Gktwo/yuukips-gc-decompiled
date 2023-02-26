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
import p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap.class */
public class Object2ReferenceRBTreeMap<K, V> extends AbstractObject2ReferenceSortedMap<K, V> implements Serializable, Cloneable {
    protected transient Entry<K, V> tree;
    protected int count;
    protected transient Entry<K, V> firstEntry;
    protected transient Entry<K, V> lastEntry;
    protected transient ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> entries;
    protected transient ObjectSortedSet<K> keys;
    protected transient ReferenceCollection<V> values;
    protected transient boolean modified;
    protected Comparator<? super K> storedComparator;
    protected transient Comparator<? super K> actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    private transient Entry<K, V>[] nodePath;

    public Object2ReferenceRBTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = this.storedComparator;
    }

    public Object2ReferenceRBTreeMap(Comparator<? super K> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Object2ReferenceRBTreeMap(Map<? extends K, ? extends V> m) {
        this();
        putAll(m);
    }

    public Object2ReferenceRBTreeMap(SortedMap<K, V> m) {
        this(m.comparator());
        putAll(m);
    }

    public Object2ReferenceRBTreeMap(Object2ReferenceMap<? extends K, ? extends V> m) {
        this();
        putAll(m);
    }

    public Object2ReferenceRBTreeMap(Object2ReferenceSortedMap<K, V> m) {
        this(m.comparator());
        putAll(m);
    }

    public Object2ReferenceRBTreeMap(K[] k, V[] v, Comparator<? super K> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Object2ReferenceRBTreeMap(K[] k, V[] v) {
        this(k, v, null);
    }

    final int compare(K k1, K k2) {
        return this.actualComparator == null ? ((Comparable) k1).compareTo(k2) : this.actualComparator.compare(k1, k2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    final Entry<K, V> findKey(K k) {
        int cmp;
        Entry<K, V> e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    final Entry<K, V> locateKey(K k) {
        Entry<K, V> e = this.tree;
        Entry<K, V> last = this.tree;
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

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V put(K k, V v) {
        Entry<K, V> e = add(k);
        V oldValue = (V) e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005d, code lost:
        r8.nodePath[r14] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006a, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0055, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005a, code lost:
        if (r14 == 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.Entry<K, V> add(K r9) {
        /*
        // Method dump skipped, instructions count: 940
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.add(java.lang.Object):it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Entry");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0440, code lost:
        if (r13.succ() != false) goto L_0x044e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x044b, code lost:
        if (r13.right.black() == false) goto L_0x049b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x044e, code lost:
        r0 = r13.left;
        r0.black(true);
        r13.black(false);
        r13.left = r0.right;
        r0.right = r13;
        r6.nodePath[r10 - 1].right = r0;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0488, code lost:
        if (r13.succ() == false) goto L_0x049b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x048b, code lost:
        r13.succ(false);
        r13.right.pred(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x049b, code lost:
        r13.black(r6.nodePath[r10 - 1].black());
        r6.nodePath[r10 - 1].black(true);
        r13.right.black(true);
        r6.nodePath[r10 - 1].right = r13.left;
        r13.left = r6.nodePath[r10 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x04e4, code lost:
        if (r10 >= 2) goto L_0x04f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x04e7, code lost:
        r6.tree = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x04f9, code lost:
        if (r6.dirPath[r10 - 2] == false) goto L_0x050d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x04fc, code lost:
        r6.nodePath[r10 - 2].right = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x050d, code lost:
        r6.nodePath[r10 - 2].left = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0520, code lost:
        if (r13.pred() == false) goto L_0x0731;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0523, code lost:
        r13.pred(false);
        r6.nodePath[r10 - 1].succ(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0631, code lost:
        if (r13.pred() != false) goto L_0x063f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x063c, code lost:
        if (r13.left.black() == false) goto L_0x068c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x063f, code lost:
        r0 = r13.right;
        r0.black(true);
        r13.black(false);
        r13.right = r0.left;
        r0.left = r13;
        r6.nodePath[r10 - 1].left = r0;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0679, code lost:
        if (r13.pred() == false) goto L_0x068c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x067c, code lost:
        r13.pred(false);
        r13.left.succ(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x068c, code lost:
        r13.black(r6.nodePath[r10 - 1].black());
        r6.nodePath[r10 - 1].black(true);
        r13.left.black(true);
        r6.nodePath[r10 - 1].left = r13.right;
        r13.right = r6.nodePath[r10 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x06d5, code lost:
        if (r10 >= 2) goto L_0x06e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x06d8, code lost:
        r6.tree = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x06ea, code lost:
        if (r6.dirPath[r10 - 2] == false) goto L_0x06fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x06ed, code lost:
        r6.nodePath[r10 - 2].right = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x06fe, code lost:
        r6.nodePath[r10 - 2].left = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
        r10 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0711, code lost:
        if (r13.succ() == false) goto L_0x0731;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0714, code lost:
        r13.succ(false);
        r6.nodePath[r10 - 1].pred(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        if (r10 == 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        r6.nodePath[r10] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        return (V) r6.defRetValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        r10 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
        if (r10 == 0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        r6.nodePath[r10] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        return (V) r6.defRetValue;
     */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V remove(java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 1895
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.remove(java.lang.Object):java.lang.Object");
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        Object2ReferenceRBTreeMap<K, V>.ValueIterator i = new ValueIterator();
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$Entry.class */
    public static final class Entry<K, V> extends AbstractObject2ReferenceMap.BasicEntry<K, V> implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        Entry<K, V> left;
        Entry<K, V> right;
        int info;

        Entry() {
            super(null, null);
        }

        Entry(K k, V v) {
            super(k, v);
            this.info = -1073741824;
        }

        Entry<K, V> left() {
            if ((this.info & 1073741824) != 0) {
                return null;
            }
            return this.left;
        }

        Entry<K, V> right() {
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

        void pred(Entry<K, V> pred) {
            this.info |= 1073741824;
            this.left = pred;
        }

        void succ(Entry<K, V> succ) {
            this.info |= Integer.MIN_VALUE;
            this.right = succ;
        }

        void left(Entry<K, V> left) {
            this.info &= -1073741825;
            this.left = left;
        }

        void right(Entry<K, V> right) {
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

        Entry<K, V> next() {
            Entry<K, V> next = this.right;
            if ((this.info & Integer.MIN_VALUE) == 0) {
                while ((next.info & 1073741824) == 0) {
                    next = next.left;
                }
            }
            return next;
        }

        Entry<K, V> prev() {
            Entry<K, V> prev = this.left;
            if ((this.info & 1073741824) == 0) {
                while ((prev.info & Integer.MIN_VALUE) == 0) {
                    prev = prev.right;
                }
            }
            return prev;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap.BasicEntry, java.util.Map.Entry
        public V setValue(V value) {
            V oldValue = (V) this.value;
            this.value = value;
            return oldValue;
        }

        @Override // java.lang.Object
        public Entry<K, V> clone() {
            try {
                Entry<K, V> c = (Entry) clone();
                c.key = this.key;
                c.value = this.value;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, V> e = (Map.Entry) o;
            return Objects.equals(this.key, e.getKey()) && this.value == e.getValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key.hashCode() ^ (this.value == null ? 0 : System.identityHashCode(this.value));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.Function
    public boolean containsKey(Object k) {
        return (k == 0 || findKey(k) == null) ? false : true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    public V get(Object k) {
        Entry<K, V> e = findKey(k);
        return e == null ? (V) this.defRetValue : (V) e.value;
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

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry<K, V> prev;
        Entry<K, V> next;
        Entry<K, V> curr;
        int index = 0;

        TreeIterator() {
            this.next = Object2ReferenceRBTreeMap.this.firstEntry;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        TreeIterator(K k) {
            Entry<K, V> locateKey = Object2ReferenceRBTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Object2ReferenceRBTreeMap.this.compare(this.next.key, k) <= 0) {
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

        Entry<K, V> nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Entry<K, V> entry = this.next;
            this.prev = entry;
            this.curr = entry;
            this.index++;
            updateNext();
            return this.curr;
        }

        void updatePrevious() {
            this.prev = this.prev.prev();
        }

        Entry<K, V> previousEntry() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Entry<K, V> entry = this.prev;
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
            Entry<K, V> entry = this.curr;
            this.prev = entry;
            this.next = entry;
            updatePrevious();
            updateNext();
            Object2ReferenceRBTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$EntryIterator.class */
    public class EntryIterator extends Object2ReferenceRBTreeMap<K, V>.TreeIterator implements ObjectListIterator<Object2ReferenceMap.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        EntryIterator(K k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object2ReferenceMap.Entry<K, V> next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Object2ReferenceMap.Entry<K, V> previous() {
            return previousEntry();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap
    public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> object2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Object2ReferenceMap.Entry<K, V>>() { // from class: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.1
                final Comparator<? super Object2ReferenceMap.Entry<K, V>> comparator;

                {
                    this.comparator = Object2ReferenceRBTreeMap.this.actualComparator == null ? x, y -> {
                        return ((Comparable) x.getKey()).compareTo(y.getKey());
                    } : x, y -> {
                        return Object2ReferenceRBTreeMap.this.actualComparator.compare(x.getKey(), y.getKey());
                    };
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                    return iterator((Object2ReferenceMap.Entry) ((Object2ReferenceMap.Entry) obj));
                }

                @Override // java.util.SortedSet
                public Comparator<? super Object2ReferenceMap.Entry<K, V>> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> iterator(Object2ReferenceMap.Entry<K, V> from) {
                    return new EntryIterator(from.getKey());
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() == null) {
                        return false;
                    }
                    return e.equals(Object2ReferenceRBTreeMap.this.findKey(e.getKey()));
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object o) {
                    Entry<K, V> f;
                    if (!(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() == null || (f = Object2ReferenceRBTreeMap.this.findKey(e.getKey())) == null || f.getValue() != e.getValue()) {
                        return false;
                    }
                    Object2ReferenceRBTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Object2ReferenceRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Object2ReferenceRBTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Object2ReferenceMap.Entry<K, V> first() {
                    return Object2ReferenceRBTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Object2ReferenceMap.Entry<K, V> last() {
                    return Object2ReferenceRBTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> subSet(Object2ReferenceMap.Entry<K, V> from, Object2ReferenceMap.Entry<K, V> to) {
                    return Object2ReferenceRBTreeMap.this.subMap((Object) from.getKey(), (Object) to.getKey()).object2ReferenceEntrySet();
                }

                public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> headSet(Object2ReferenceMap.Entry<K, V> to) {
                    return Object2ReferenceRBTreeMap.this.headMap((Object2ReferenceRBTreeMap) to.getKey()).object2ReferenceEntrySet();
                }

                public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> tailSet(Object2ReferenceMap.Entry<K, V> from) {
                    return Object2ReferenceRBTreeMap.this.tailMap((Object2ReferenceRBTreeMap) from.getKey()).object2ReferenceEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$KeyIterator.class */
    public final class KeyIterator extends Object2ReferenceRBTreeMap<K, V>.TreeIterator implements ObjectListIterator<K> {
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
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$KeySet.class */
    public class KeySet extends AbstractObject2ReferenceSortedMap<K, V>.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$ValueIterator.class */
    public final class ValueIterator extends Object2ReferenceRBTreeMap<K, V>.TreeIterator implements ObjectListIterator<V> {
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

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object k) {
                    return Object2ReferenceRBTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Object2ReferenceRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Object2ReferenceRBTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
    public Object2ReferenceSortedMap<K, V> headMap(K to) {
        return new Submap(null, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
    public Object2ReferenceSortedMap<K, V> tailMap(K from) {
        return new Submap(from, false, null, true);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
    public Object2ReferenceSortedMap<K, V> subMap(K from, K to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$Submap.class */
    public final class Submap extends AbstractObject2ReferenceSortedMap<K, V> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        K from;

        /* renamed from: to */
        K f2629to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> entries;
        protected transient ObjectSortedSet<K> keys;
        protected transient ReferenceCollection<V> values;

        public Submap(K from, boolean bottom, K to, boolean top) {
            if (bottom || top || Object2ReferenceRBTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2629to = to;
                this.top = top;
                this.defRetValue = Object2ReferenceRBTreeMap.this.defRetValue;
                return;
            }
            throw new IllegalArgumentException("Start key (" + from + ") is larger than end key (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            Object2ReferenceRBTreeMap<K, V>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                i.nextEntry();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m589in(K k) {
            return (this.bottom || Object2ReferenceRBTreeMap.this.compare(k, this.from) >= 0) && (this.top || Object2ReferenceRBTreeMap.this.compare(k, this.f2629to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap
        public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> object2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Object2ReferenceMap.Entry<K, V>>() { // from class: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                    public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                        return iterator((Object2ReferenceMap.Entry) ((Object2ReferenceMap.Entry) obj));
                    }

                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Object2ReferenceMap.Entry<K, V>> iterator(Object2ReferenceMap.Entry<K, V> from) {
                        return new SubmapEntryIterator(from.getKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Object2ReferenceMap.Entry<K, V>> comparator() {
                        return Object2ReferenceRBTreeMap.this.object2ReferenceEntrySet().comparator();
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
                    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Submap */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        Entry<K, V> f = Object2ReferenceRBTreeMap.this.findKey(e.getKey());
                        return f != null && Submap.this.m589in(f.key) && e.equals(f);
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
                    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Submap */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Entry<K, V> f = Object2ReferenceRBTreeMap.this.findKey(((Map.Entry) o).getKey());
                        if (f != null && Submap.this.m589in(f.key)) {
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
                    public Object2ReferenceMap.Entry<K, V> first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Object2ReferenceMap.Entry<K, V> last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> subSet(Object2ReferenceMap.Entry<K, V> from, Object2ReferenceMap.Entry<K, V> to) {
                        return Submap.this.subMap((Object) from.getKey(), (Object) to.getKey()).object2ReferenceEntrySet();
                    }

                    public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> headSet(Object2ReferenceMap.Entry<K, V> to) {
                        return Submap.this.headMap((Submap) to.getKey()).object2ReferenceEntrySet();
                    }

                    public ObjectSortedSet<Object2ReferenceMap.Entry<K, V>> tailSet(Object2ReferenceMap.Entry<K, V> from) {
                        return Submap.this.tailMap((Submap) from.getKey()).object2ReferenceEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractObject2ReferenceSortedMap<K, V>.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
            public ObjectBidirectionalIterator<K> iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
            public ObjectBidirectionalIterator<K> iterator(K from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceSortedMap, p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.objects.Object2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            if (this.values == null) {
                this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.Submap.2
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

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return k != null && m589in(k) && Object2ReferenceRBTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, java.util.Map
        public boolean containsValue(Object v) {
            Object2ReferenceRBTreeMap<K, V>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        public V get(Object k) {
            Entry<K, V> e;
            return (!m589in(k) || (e = Object2ReferenceRBTreeMap.this.findKey(k)) == null) ? (V) this.defRetValue : (V) e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        public V put(K k, V v) {
            Object2ReferenceRBTreeMap.this.modified = false;
            if (!m589in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2629to)) + ")");
            }
            return Object2ReferenceRBTreeMap.this.modified ? (V) this.defRetValue : (V) Object2ReferenceRBTreeMap.this.put(k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        public V remove(Object k) {
            Object2ReferenceRBTreeMap.this.modified = false;
            if (!m589in(k)) {
                return (V) this.defRetValue;
            }
            return Object2ReferenceRBTreeMap.this.modified ? (V) Object2ReferenceRBTreeMap.this.remove(k) : (V) this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            Object2ReferenceRBTreeMap<K, V>.Submap.SubmapIterator i = new SubmapIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextEntry();
            }
            return n;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ReferenceMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return Object2ReferenceRBTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> headMap(K to) {
            if (!this.top && Object2ReferenceRBTreeMap.this.compare(to, this.f2629to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> tailMap(K from) {
            if (!this.bottom && Object2ReferenceRBTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2629to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceSortedMap, java.util.SortedMap
        public Object2ReferenceSortedMap<K, V> subMap(K from, K to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Object2ReferenceRBTreeMap.this.compare(to, this.f2629to) < 0 ? to : this.f2629to;
            }
            if (!this.bottom) {
                from = Object2ReferenceRBTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f2629to) ? new Submap(from, false, to, false) : this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
        /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        public Entry<K, V> firstEntry() {
            Entry<K, V> e;
            if (Object2ReferenceRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Object2ReferenceRBTreeMap.this.firstEntry;
            } else {
                e = Object2ReferenceRBTreeMap.this.locateKey(this.from);
                if (Object2ReferenceRBTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Object2ReferenceRBTreeMap.this.compare(e.key, this.f2629to) < 0) {
                return e;
            }
            return null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
        /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        public Entry<K, V> lastEntry() {
            Entry<K, V> e;
            if (Object2ReferenceRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Object2ReferenceRBTreeMap.this.lastEntry;
            } else {
                e = Object2ReferenceRBTreeMap.this.locateKey(this.f2629to);
                if (Object2ReferenceRBTreeMap.this.compare(e.key, this.f2629to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Object2ReferenceRBTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            Entry<K, V> e = firstEntry();
            if (e != null) {
                return (K) e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            Entry<K, V> e = lastEntry();
            if (e != null) {
                return (K) e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends Object2ReferenceRBTreeMap<K, V>.TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
            /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
            /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            SubmapIterator(Submap submap, K k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Object2ReferenceRBTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Object2ReferenceRBTreeMap object2ReferenceRBTreeMap = Object2ReferenceRBTreeMap.this;
                        Entry<K, V> lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (object2ReferenceRBTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Object2ReferenceRBTreeMap.this.locateKey(k);
                    if (Object2ReferenceRBTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Object2ReferenceRBTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p014it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Object2ReferenceRBTreeMap.this.compare(this.next.key, Submap.this.f2629to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends Object2ReferenceRBTreeMap<K, V>.Submap.SubmapIterator implements ObjectListIterator<Object2ReferenceMap.Entry<K, V>> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(K k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Object2ReferenceMap.Entry<K, V> next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Object2ReferenceMap.Entry<K, V> previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends Object2ReferenceRBTreeMap<K, V>.Submap.SubmapIterator implements ObjectListIterator<K> {
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
        /* renamed from: it.unimi.dsi.fastutil.objects.Object2ReferenceRBTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ReferenceRBTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends Object2ReferenceRBTreeMap<K, V>.Submap.SubmapIterator implements ObjectListIterator<V> {
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
    public Object2ReferenceRBTreeMap<K, V> clone() {
        try {
            Object2ReferenceRBTreeMap<K, V> c = (Object2ReferenceRBTreeMap) clone();
            c.keys = null;
            c.values = null;
            c.entries = null;
            c.allocatePaths();
            if (this.count == 0) {
                return c;
            }
            Entry<K, V> rp = new Entry<>();
            Entry<K, V> rq = new Entry<>();
            Entry<K, V> p = rp;
            rp.left(this.tree);
            Entry<K, V> q = rq;
            rq.pred((Entry) null);
            loop0: while (true) {
                if (!p.pred()) {
                    Entry<K, V> e = p.left.clone();
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
                    Entry<K, V> e2 = p.right.clone();
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
        Object2ReferenceRBTreeMap<K, V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                Entry<K, V> e = i.nextEntry();
                s.writeObject(e.key);
                s.writeObject(e.value);
            } else {
                return;
            }
        }
    }

    private Entry<K, V> readTree(ObjectInputStream s, int n, Entry<K, V> pred, Entry<K, V> succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry<K, V> top = new Entry<>(s.readObject(), s.readObject());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry<K, V> top2 = new Entry<>(s.readObject(), s.readObject());
            top2.black(true);
            top2.right(new Entry<>(s.readObject(), s.readObject()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry<K, V> top3 = new Entry<>();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readObject();
            top3.value = s.readObject();
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
            Entry<K, V> e = this.tree;
            while (e.left() != null) {
                e = e.left();
            }
            this.firstEntry = e;
            Entry<K, V> e2 = this.tree;
            while (e2.right() != null) {
                e2 = e2.right();
            }
            this.lastEntry = e2;
        }
    }
}
