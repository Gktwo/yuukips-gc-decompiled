package p014it.unimi.dsi.fastutil.floats;

import emu.grasscutter.net.proto.RetcodeOuterClass;
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
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.booleans.BooleanListIterator;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap;
import p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap.class */
public class Float2BooleanRBTreeMap extends AbstractFloat2BooleanSortedMap implements Serializable, Cloneable {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected transient ObjectSortedSet<Float2BooleanMap.Entry> entries;
    protected transient FloatSortedSet keys;
    protected transient BooleanCollection values;
    protected transient boolean modified;
    protected Comparator<? super Float> storedComparator;
    protected transient FloatComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    private transient Entry[] nodePath;

    public Float2BooleanRBTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = FloatComparators.asFloatComparator(this.storedComparator);
    }

    public Float2BooleanRBTreeMap(Comparator<? super Float> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Float2BooleanRBTreeMap(Map<? extends Float, ? extends Boolean> m) {
        this();
        putAll(m);
    }

    public Float2BooleanRBTreeMap(SortedMap<Float, Boolean> m) {
        this(m.comparator());
        putAll(m);
    }

    public Float2BooleanRBTreeMap(Float2BooleanMap m) {
        this();
        putAll(m);
    }

    public Float2BooleanRBTreeMap(Float2BooleanSortedMap m) {
        this(m.comparator());
        putAll(m);
    }

    public Float2BooleanRBTreeMap(float[] k, boolean[] v, Comparator<? super Float> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Float2BooleanRBTreeMap(float[] k, boolean[] v) {
        this(k, v, null);
    }

    final int compare(float k1, float k2) {
        return this.actualComparator == null ? Float.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    final Entry findKey(float k) {
        int cmp;
        Entry e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry locateKey(float k) {
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

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction
    public boolean put(float k, boolean v) {
        Entry e = add(k);
        boolean oldValue = e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
        r8.nodePath[r14] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0050, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0055, code lost:
        if (r14 == 0) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.Entry add(float r9) {
        /*
        // Method dump skipped, instructions count: 935
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.add(float):it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$Entry");
    }

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
        return r6.defRetValue;
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
        return r6.defRetValue;
     */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(float r7) {
        /*
        // Method dump skipped, instructions count: 1895
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.remove(float):boolean");
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap
    public boolean containsValue(boolean v) {
        ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (i.nextBoolean() != v);
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$Entry.class */
    public static final class Entry extends AbstractFloat2BooleanMap.BasicEntry implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        Entry left;
        Entry right;
        int info;

        Entry() {
            super(0.0f, false);
        }

        Entry(float k, boolean v) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap.BasicEntry, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap.Entry
        public boolean setValue(boolean value) {
            boolean oldValue = this.value;
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

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Float, Boolean> e = (Map.Entry) o;
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(e.getKey().floatValue()) && this.value == e.getValue().booleanValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.float2int(this.key) ^ (this.value ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap
    public boolean containsKey(float k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction
    public boolean get(float k) {
        Entry e = findKey(k);
        return e == null ? this.defRetValue : e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
    public float firstFloatKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
    public float lastFloatKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        TreeIterator() {
            this.next = Float2BooleanRBTreeMap.this.firstEntry;
        }

        TreeIterator(float k) {
            Entry locateKey = Float2BooleanRBTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Float2BooleanRBTreeMap.this.compare(this.next.key, k) <= 0) {
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
            Float2BooleanRBTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$EntryIterator.class */
    public class EntryIterator extends TreeIterator implements ObjectListIterator<Float2BooleanMap.Entry> {
        EntryIterator() {
            super();
        }

        EntryIterator(float k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Float2BooleanMap.Entry next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Float2BooleanMap.Entry previous() {
            return previousEntry();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
    public ObjectSortedSet<Float2BooleanMap.Entry> float2BooleanEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Float2BooleanMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.1
                final Comparator<? super Float2BooleanMap.Entry> comparator;

                {
                    this.comparator = Float2BooleanRBTreeMap.this.actualComparator == null ? x, y -> {
                        return Float.compare(x.getFloatKey(), y.getFloatKey());
                    } : x, y -> {
                        return Float2BooleanRBTreeMap.this.actualComparator.compare(x.getFloatKey(), y.getFloatKey());
                    };
                }

                @Override // java.util.SortedSet
                public Comparator<? super Float2BooleanMap.Entry> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Float2BooleanMap.Entry> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Float2BooleanMap.Entry> iterator(Float2BooleanMap.Entry from) {
                    return new EntryIterator(from.getFloatKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Float) && e.getValue() != null && (e.getValue() instanceof Boolean)) {
                        return e.equals(Float2BooleanRBTreeMap.this.findKey(((Float) e.getKey()).floatValue()));
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
                    if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Boolean) || (f = Float2BooleanRBTreeMap.this.findKey(((Float) e.getKey()).floatValue())) == null || f.getBooleanValue() != ((Boolean) e.getValue()).booleanValue()) {
                        return false;
                    }
                    Float2BooleanRBTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Float2BooleanRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Float2BooleanRBTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Float2BooleanMap.Entry first() {
                    return Float2BooleanRBTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Float2BooleanMap.Entry last() {
                    return Float2BooleanRBTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Float2BooleanMap.Entry> subSet(Float2BooleanMap.Entry from, Float2BooleanMap.Entry to) {
                    return Float2BooleanRBTreeMap.this.subMap(from.getFloatKey(), to.getFloatKey()).float2BooleanEntrySet();
                }

                public ObjectSortedSet<Float2BooleanMap.Entry> headSet(Float2BooleanMap.Entry to) {
                    return Float2BooleanRBTreeMap.this.headMap(to.getFloatKey()).float2BooleanEntrySet();
                }

                public ObjectSortedSet<Float2BooleanMap.Entry> tailSet(Float2BooleanMap.Entry from) {
                    return Float2BooleanRBTreeMap.this.tailMap(from.getFloatKey()).float2BooleanEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$KeyIterator.class */
    public final class KeyIterator extends TreeIterator implements FloatListIterator {
        public KeyIterator() {
            super();
        }

        public KeyIterator(float k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return previousEntry().key;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$KeySet.class */
    public class KeySet extends AbstractFloat2BooleanSortedMap.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap.KeySet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap.KeySet, p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap, p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
    public FloatSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$ValueIterator.class */
    public final class ValueIterator extends TreeIterator implements BooleanListIterator {
        private ValueIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return nextEntry().value;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
            return previousEntry().value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap, p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
    public BooleanCollection values() {
        if (this.values == null) {
            this.values = new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
                public BooleanIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
                public boolean contains(boolean k) {
                    return Float2BooleanRBTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Float2BooleanRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Float2BooleanRBTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
    public Comparator<? super Float> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
    public Float2BooleanSortedMap headMap(float to) {
        return new Submap(0.0f, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
    public Float2BooleanSortedMap tailMap(float from) {
        return new Submap(from, false, 0.0f, true);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
    public Float2BooleanSortedMap subMap(float from, float to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$Submap.class */
    public final class Submap extends AbstractFloat2BooleanSortedMap implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        float from;

        /* renamed from: to */
        float f1811to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Float2BooleanMap.Entry> entries;
        protected transient FloatSortedSet keys;
        protected transient BooleanCollection values;

        public Submap(float from, boolean bottom, float to, boolean top) {
            if (bottom || top || Float2BooleanRBTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f1811to = to;
                this.top = top;
                this.defRetValue = Float2BooleanRBTreeMap.this.defRetValue;
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
        final boolean m859in(float k) {
            return (this.bottom || Float2BooleanRBTreeMap.this.compare(k, this.from) >= 0) && (this.top || Float2BooleanRBTreeMap.this.compare(k, this.f1811to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public ObjectSortedSet<Float2BooleanMap.Entry> float2BooleanEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Float2BooleanMap.Entry>() { // from class: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Float2BooleanMap.Entry> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Float2BooleanMap.Entry> iterator(Float2BooleanMap.Entry from) {
                        return new SubmapEntryIterator(from.getFloatKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Float2BooleanMap.Entry> comparator() {
                        return Float2BooleanRBTreeMap.this.float2BooleanEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Float) && e.getValue() != null && (e.getValue() instanceof Boolean) && (f = Float2BooleanRBTreeMap.this.findKey(((Float) e.getKey()).floatValue())) != null && Submap.this.m859in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Float) || e.getValue() == null || !(e.getValue() instanceof Boolean)) {
                            return false;
                        }
                        Entry f = Float2BooleanRBTreeMap.this.findKey(((Float) e.getKey()).floatValue());
                        if (f != null && Submap.this.m859in(f.key)) {
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
                    public Float2BooleanMap.Entry first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Float2BooleanMap.Entry last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Float2BooleanMap.Entry> subSet(Float2BooleanMap.Entry from, Float2BooleanMap.Entry to) {
                        return Submap.this.subMap(from.getFloatKey(), to.getFloatKey()).float2BooleanEntrySet();
                    }

                    public ObjectSortedSet<Float2BooleanMap.Entry> headSet(Float2BooleanMap.Entry to) {
                        return Submap.this.headMap(to.getFloatKey()).float2BooleanEntrySet();
                    }

                    public ObjectSortedSet<Float2BooleanMap.Entry> tailSet(Float2BooleanMap.Entry from) {
                        return Submap.this.tailMap(from.getFloatKey()).float2BooleanEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractFloat2BooleanSortedMap.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap.KeySet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
            public FloatBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap.KeySet, p014it.unimi.dsi.fastutil.floats.FloatSortedSet
            public FloatBidirectionalIterator iterator(float from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap, p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        public FloatSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanSortedMap, p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap, java.util.Map
        public BooleanCollection values() {
            if (this.values == null) {
                this.values = new AbstractBooleanCollection() { // from class: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
                    public BooleanIterator iterator() {
                        return new SubmapValueIterator();
                    }

                    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
                    public boolean contains(boolean k) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap
        public boolean containsKey(float k) {
            return m859in(k) && Float2BooleanRBTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, p014it.unimi.dsi.fastutil.floats.Float2BooleanMap
        public boolean containsValue(boolean v) {
            SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction
        public boolean get(float k) {
            Entry e;
            return (!m859in(k) || (e = Float2BooleanRBTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction
        public boolean put(float k, boolean v) {
            Float2BooleanRBTreeMap.this.modified = false;
            if (!m859in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f1811to)) + ")");
            }
            return Float2BooleanRBTreeMap.this.modified ? this.defRetValue : Float2BooleanRBTreeMap.this.put(k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction
        public boolean remove(float k) {
            Float2BooleanRBTreeMap.this.modified = false;
            if (!m859in(k)) {
                return this.defRetValue;
            }
            return Float2BooleanRBTreeMap.this.modified ? Float2BooleanRBTreeMap.this.remove(k) : this.defRetValue;
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

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2BooleanMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap, java.util.SortedMap
        public Comparator<? super Float> comparator() {
            return Float2BooleanRBTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap headMap(float to) {
            if (!this.top && Float2BooleanRBTreeMap.this.compare(to, this.f1811to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap tailMap(float from) {
            if (!this.bottom && Float2BooleanRBTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f1811to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public Float2BooleanSortedMap subMap(float from, float to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Float2BooleanRBTreeMap.this.compare(to, this.f1811to) < 0 ? to : this.f1811to;
            }
            if (!this.bottom) {
                from = Float2BooleanRBTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f1811to) ? new Submap(from, false, to, false) : this;
        }

        public Entry firstEntry() {
            Entry e;
            if (Float2BooleanRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Float2BooleanRBTreeMap.this.firstEntry;
            } else {
                e = Float2BooleanRBTreeMap.this.locateKey(this.from);
                if (Float2BooleanRBTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Float2BooleanRBTreeMap.this.compare(e.key, this.f1811to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (Float2BooleanRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Float2BooleanRBTreeMap.this.lastEntry;
            } else {
                e = Float2BooleanRBTreeMap.this.locateKey(this.f1811to);
                if (Float2BooleanRBTreeMap.this.compare(e.key, this.f1811to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Float2BooleanRBTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float firstFloatKey() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanSortedMap
        public float lastFloatKey() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            SubmapIterator(Submap submap, float k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Float2BooleanRBTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Float2BooleanRBTreeMap float2BooleanRBTreeMap = Float2BooleanRBTreeMap.this;
                        Entry lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (float2BooleanRBTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Float2BooleanRBTreeMap.this.locateKey(k);
                    if (Float2BooleanRBTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Float2BooleanRBTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Float2BooleanRBTreeMap.this.compare(this.next.key, Submap.this.f1811to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends SubmapIterator implements ObjectListIterator<Float2BooleanMap.Entry> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(float k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Float2BooleanMap.Entry next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Float2BooleanMap.Entry previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends SubmapIterator implements FloatListIterator {
            public SubmapKeyIterator() {
                super();
            }

            public SubmapKeyIterator(float from) {
                super(Submap.this, from);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            public float nextFloat() {
                return nextEntry().key;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
            public float previousFloat() {
                return previousEntry().key;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.Float2BooleanRBTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2BooleanRBTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends SubmapIterator implements BooleanListIterator {
            private SubmapValueIterator() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
            public boolean nextBoolean() {
                return nextEntry().value;
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
            public boolean previousBoolean() {
                return previousEntry().value;
            }
        }
    }

    @Override // java.lang.Object
    public Float2BooleanRBTreeMap clone() {
        try {
            Float2BooleanRBTreeMap c = (Float2BooleanRBTreeMap) clone();
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
                s.writeFloat(e.key);
                s.writeBoolean(e.value);
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readFloat(), s.readBoolean());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readFloat(), s.readBoolean());
            top2.black(true);
            top2.right(new Entry(s.readFloat(), s.readBoolean()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry top3 = new Entry();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readFloat();
            top3.value = s.readBoolean();
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
