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
import p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap;
import p014it.unimi.dsi.fastutil.longs.Long2LongMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap.class */
public class Long2LongRBTreeMap extends AbstractLong2LongSortedMap implements Serializable, Cloneable {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected transient ObjectSortedSet<Long2LongMap.Entry> entries;
    protected transient LongSortedSet keys;
    protected transient LongCollection values;
    protected transient boolean modified;
    protected Comparator<? super Long> storedComparator;
    protected transient LongComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    private transient Entry[] nodePath;

    public Long2LongRBTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = LongComparators.asLongComparator(this.storedComparator);
    }

    public Long2LongRBTreeMap(Comparator<? super Long> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Long2LongRBTreeMap(Map<? extends Long, ? extends Long> m) {
        this();
        putAll(m);
    }

    public Long2LongRBTreeMap(SortedMap<Long, Long> m) {
        this(m.comparator());
        putAll(m);
    }

    public Long2LongRBTreeMap(Long2LongMap m) {
        this();
        putAll(m);
    }

    public Long2LongRBTreeMap(Long2LongSortedMap m) {
        this(m.comparator());
        putAll(m);
    }

    public Long2LongRBTreeMap(long[] k, long[] v, Comparator<? super Long> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Long2LongRBTreeMap(long[] k, long[] v) {
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
        this.dirPath = new boolean[64];
        this.nodePath = new Entry[64];
    }

    public long addTo(long k, long incr) {
        Entry e = add(k);
        long oldValue = e.value;
        e.value += incr;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    public long put(long k, long v) {
        Entry e = add(k);
        long oldValue = e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0059, code lost:
        r10.nodePath[r17] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0066, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x012e, code lost:
        r10.modified = true;
        r17 = r17 - 1;
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x013b, code lost:
        if (r17 <= 0) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0148, code lost:
        if (r10.nodePath[r17].black() != false) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0154, code lost:
        if (r10.dirPath[r17 - 1] != false) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0157, code lost:
        r0 = r10.nodePath[r17 - 1].right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0171, code lost:
        if (r10.nodePath[r17 - 1].succ() != false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0179, code lost:
        if (r0.black() != false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x017c, code lost:
        r10.nodePath[r17].black(true);
        r0.black(true);
        r10.nodePath[r17 - 1].black(false);
        r17 = r17 - 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01a7, code lost:
        if (r10.dirPath[r17] != false) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01aa, code lost:
        r18 = r10.nodePath[r17];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01b6, code lost:
        r0 = r10.nodePath[r17];
        r18 = r0.right;
        r0.right = r18.left;
        r18.left = r0;
        r10.nodePath[r17 - 1].left = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01ea, code lost:
        if (r18.pred() == false) goto L_0x01fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01ed, code lost:
        r18.pred(false);
        r0.succ(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01fa, code lost:
        r0 = r10.nodePath[r17 - 1];
        r0.black(false);
        r18.black(true);
        r0.left = r18.right;
        r18.right = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0225, code lost:
        if (r17 >= 2) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0228, code lost:
        r10.tree = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x023a, code lost:
        if (r10.dirPath[r17 - 2] == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x023d, code lost:
        r10.nodePath[r17 - 2].right = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x024e, code lost:
        r10.nodePath[r17 - 2].left = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0261, code lost:
        if (r18.succ() == false) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0264, code lost:
        r18.succ(false);
        r0.pred(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0277, code lost:
        r0 = r10.nodePath[r17 - 1].left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0291, code lost:
        if (r10.nodePath[r17 - 1].pred() != false) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0299, code lost:
        if (r0.black() != false) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x029c, code lost:
        r10.nodePath[r17].black(true);
        r0.black(true);
        r10.nodePath[r17 - 1].black(false);
        r17 = r17 - 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02c7, code lost:
        if (r10.dirPath[r17] == false) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02ca, code lost:
        r18 = r10.nodePath[r17];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02d6, code lost:
        r0 = r10.nodePath[r17];
        r18 = r0.left;
        r0.left = r18.right;
        r18.right = r0;
        r10.nodePath[r17 - 1].right = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x030a, code lost:
        if (r18.succ() == false) goto L_0x031a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x030d, code lost:
        r18.succ(false);
        r0.pred(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x031a, code lost:
        r0 = r10.nodePath[r17 - 1];
        r0.black(false);
        r18.black(true);
        r0.right = r18.left;
        r18.left = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0345, code lost:
        if (r17 >= 2) goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0348, code lost:
        r10.tree = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x035a, code lost:
        if (r10.dirPath[r17 - 2] == false) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x035d, code lost:
        r10.nodePath[r17 - 2].right = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x036e, code lost:
        r10.nodePath[r17 - 2].left = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0381, code lost:
        if (r18.pred() == false) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0384, code lost:
        r18.pred(false);
        r0.succ(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0051, code lost:
        r17 = r17 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0056, code lost:
        if (r17 == 0) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.Entry add(long r11) {
        /*
        // Method dump skipped, instructions count: 947
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.add(long):it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$Entry");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0442, code lost:
        if (r15.succ() != false) goto L_0x0450;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x044d, code lost:
        if (r15.right.black() == false) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0450, code lost:
        r0 = r15.left;
        r0.black(true);
        r15.black(false);
        r15.left = r0.right;
        r0.right = r15;
        r6.nodePath[r11 - 1].right = r0;
        r15 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x048a, code lost:
        if (r15.succ() == false) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x048d, code lost:
        r15.succ(false);
        r15.right.pred(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x049d, code lost:
        r15.black(r6.nodePath[r11 - 1].black());
        r6.nodePath[r11 - 1].black(true);
        r15.right.black(true);
        r6.nodePath[r11 - 1].right = r15.left;
        r15.left = r6.nodePath[r11 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x04e6, code lost:
        if (r11 >= 2) goto L_0x04f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x04e9, code lost:
        r6.tree = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x04fb, code lost:
        if (r6.dirPath[r11 - 2] == false) goto L_0x050f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x04fe, code lost:
        r6.nodePath[r11 - 2].right = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x050f, code lost:
        r6.nodePath[r11 - 2].left = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0522, code lost:
        if (r15.pred() == false) goto L_0x0733;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0525, code lost:
        r15.pred(false);
        r6.nodePath[r11 - 1].succ(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0633, code lost:
        if (r15.pred() != false) goto L_0x0641;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x063e, code lost:
        if (r15.left.black() == false) goto L_0x068e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0641, code lost:
        r0 = r15.right;
        r0.black(true);
        r15.black(false);
        r15.right = r0.left;
        r0.left = r15;
        r6.nodePath[r11 - 1].left = r0;
        r15 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x067b, code lost:
        if (r15.pred() == false) goto L_0x068e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x067e, code lost:
        r15.pred(false);
        r15.left.succ(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x068e, code lost:
        r15.black(r6.nodePath[r11 - 1].black());
        r6.nodePath[r11 - 1].black(true);
        r15.left.black(true);
        r6.nodePath[r11 - 1].left = r15.right;
        r15.right = r6.nodePath[r11 - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x06d7, code lost:
        if (r11 >= 2) goto L_0x06e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x06da, code lost:
        r6.tree = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x06ec, code lost:
        if (r6.dirPath[r11 - 2] == false) goto L_0x0700;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x06ef, code lost:
        r6.nodePath[r11 - 2].right = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0700, code lost:
        r6.nodePath[r11 - 2].left = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        r11 = r11 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0713, code lost:
        if (r15.succ() == false) goto L_0x0733;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0716, code lost:
        r15.succ(false);
        r6.nodePath[r11 - 1].pred(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        if (r11 == 0) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        r6.nodePath[r11] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        return r6.defRetValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
        r11 = r11 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        if (r11 == 0) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
        r6.nodePath[r11] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0096, code lost:
        return r6.defRetValue;
     */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long remove(long r7) {
        /*
        // Method dump skipped, instructions count: 1897
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.remove(long):long");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public boolean containsValue(long v) {
        ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (i.nextLong() != v);
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$Entry.class */
    public static final class Entry extends AbstractLong2LongMap.BasicEntry implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        Entry left;
        Entry right;
        int info;

        Entry() {
            super(0, 0);
        }

        Entry(long k, long v) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap.BasicEntry, p014it.unimi.dsi.fastutil.longs.Long2LongMap.Entry
        public long setValue(long value) {
            long oldValue = this.value;
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Long, Long> e = (Map.Entry) o;
            return this.key == e.getKey().longValue() && this.value == e.getValue().longValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ HashCommon.long2int(this.value);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongFunction, p014it.unimi.dsi.fastutil.longs.Long2LongMap
    public boolean containsKey(long k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
    public long get(long k) {
        Entry e = findKey(k);
        return e == null ? this.defRetValue : e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
    public long firstLongKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
    public long lastLongKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        TreeIterator() {
            this.next = Long2LongRBTreeMap.this.firstEntry;
        }

        TreeIterator(long k) {
            Entry locateKey = Long2LongRBTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Long2LongRBTreeMap.this.compare(this.next.key, k) <= 0) {
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
            Long2LongRBTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$EntryIterator.class */
    public class EntryIterator extends TreeIterator implements ObjectListIterator<Long2LongMap.Entry> {
        EntryIterator() {
            super();
        }

        EntryIterator(long k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Long2LongMap.Entry next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Long2LongMap.Entry previous() {
            return previousEntry();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
    public ObjectSortedSet<Long2LongMap.Entry> long2LongEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Long2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.1
                final Comparator<? super Long2LongMap.Entry> comparator;

                {
                    this.comparator = Long2LongRBTreeMap.this.actualComparator == null ? x, y -> {
                        return Long.compare(x.getLongKey(), y.getLongKey());
                    } : x, y -> {
                        return Long2LongRBTreeMap.this.actualComparator.compare(x.getLongKey(), y.getLongKey());
                    };
                }

                @Override // java.util.SortedSet
                public Comparator<? super Long2LongMap.Entry> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Long2LongMap.Entry> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Long2LongMap.Entry> iterator(Long2LongMap.Entry from) {
                    return new EntryIterator(from.getLongKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Long) && e.getValue() != null && (e.getValue() instanceof Long)) {
                        return e.equals(Long2LongRBTreeMap.this.findKey(((Long) e.getKey()).longValue()));
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
                    if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Long) || (f = Long2LongRBTreeMap.this.findKey(((Long) e.getKey()).longValue())) == null || f.getLongValue() != ((Long) e.getValue()).longValue()) {
                        return false;
                    }
                    Long2LongRBTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Long2LongRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Long2LongRBTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Long2LongMap.Entry first() {
                    return Long2LongRBTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Long2LongMap.Entry last() {
                    return Long2LongRBTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Long2LongMap.Entry> subSet(Long2LongMap.Entry from, Long2LongMap.Entry to) {
                    return Long2LongRBTreeMap.this.subMap(from.getLongKey(), to.getLongKey()).long2LongEntrySet();
                }

                public ObjectSortedSet<Long2LongMap.Entry> headSet(Long2LongMap.Entry to) {
                    return Long2LongRBTreeMap.this.headMap(to.getLongKey()).long2LongEntrySet();
                }

                public ObjectSortedSet<Long2LongMap.Entry> tailSet(Long2LongMap.Entry from) {
                    return Long2LongRBTreeMap.this.tailMap(from.getLongKey()).long2LongEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$KeyIterator.class */
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$KeySet.class */
    public class KeySet extends AbstractLong2LongSortedMap.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    public LongSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$ValueIterator.class */
    public final class ValueIterator extends TreeIterator implements LongListIterator {
        private ValueIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return nextEntry().value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return previousEntry().value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
    public LongCollection values() {
        if (this.values == null) {
            this.values = new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                public LongIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
                public boolean contains(long k) {
                    return Long2LongRBTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Long2LongRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Long2LongRBTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
    public Comparator<? super Long> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
    public Long2LongSortedMap headMap(long to) {
        return new Submap(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
    public Long2LongSortedMap tailMap(long from) {
        return new Submap(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
    public Long2LongSortedMap subMap(long from, long to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$Submap.class */
    public final class Submap extends AbstractLong2LongSortedMap implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        long from;

        /* renamed from: to */
        long f2310to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Long2LongMap.Entry> entries;
        protected transient LongSortedSet keys;
        protected transient LongCollection values;

        public Submap(long from, boolean bottom, long to, boolean top) {
            if (bottom || top || Long2LongRBTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2310to = to;
                this.top = top;
                this.defRetValue = Long2LongRBTreeMap.this.defRetValue;
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
        final boolean m678in(long k) {
            return (this.bottom || Long2LongRBTreeMap.this.compare(k, this.from) >= 0) && (this.top || Long2LongRBTreeMap.this.compare(k, this.f2310to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public ObjectSortedSet<Long2LongMap.Entry> long2LongEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Long2LongMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Long2LongMap.Entry> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Long2LongMap.Entry> iterator(Long2LongMap.Entry from) {
                        return new SubmapEntryIterator(from.getLongKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Long2LongMap.Entry> comparator() {
                        return Long2LongRBTreeMap.this.long2LongEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Long) && e.getValue() != null && (e.getValue() instanceof Long) && (f = Long2LongRBTreeMap.this.findKey(((Long) e.getKey()).longValue())) != null && Submap.this.m678in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Long)) {
                            return false;
                        }
                        Entry f = Long2LongRBTreeMap.this.findKey(((Long) e.getKey()).longValue());
                        if (f != null && Submap.this.m678in(f.key)) {
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
                    public Long2LongMap.Entry first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Long2LongMap.Entry last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Long2LongMap.Entry> subSet(Long2LongMap.Entry from, Long2LongMap.Entry to) {
                        return Submap.this.subMap(from.getLongKey(), to.getLongKey()).long2LongEntrySet();
                    }

                    public ObjectSortedSet<Long2LongMap.Entry> headSet(Long2LongMap.Entry to) {
                        return Submap.this.headMap(to.getLongKey()).long2LongEntrySet();
                    }

                    public ObjectSortedSet<Long2LongMap.Entry> tailSet(Long2LongMap.Entry from) {
                        return Submap.this.tailMap(from.getLongKey()).long2LongEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractLong2LongSortedMap.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.LongSortedSet
            public LongBidirectionalIterator iterator(long from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap, java.util.Map
        public LongCollection values() {
            if (this.values == null) {
                this.values = new AbstractLongCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
                    public LongIterator iterator() {
                        return new SubmapValueIterator();
                    }

                    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, p014it.unimi.dsi.fastutil.longs.LongCollection
                    public boolean contains(long k) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongFunction, p014it.unimi.dsi.fastutil.longs.Long2LongMap
        public boolean containsKey(long k) {
            return m678in(k) && Long2LongRBTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, p014it.unimi.dsi.fastutil.longs.Long2LongMap
        public boolean containsValue(long v) {
            SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
        public long get(long k) {
            Entry e;
            return (!m678in(k) || (e = Long2LongRBTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
        public long put(long k, long v) {
            Long2LongRBTreeMap.this.modified = false;
            if (!m678in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2310to)) + ")");
            }
            return Long2LongRBTreeMap.this.modified ? this.defRetValue : Long2LongRBTreeMap.this.put(k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongFunction
        public long remove(long k) {
            Long2LongRBTreeMap.this.modified = false;
            if (!m678in(k)) {
                return this.defRetValue;
            }
            return Long2LongRBTreeMap.this.modified ? Long2LongRBTreeMap.this.remove(k) : this.defRetValue;
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2LongMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return Long2LongRBTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap headMap(long to) {
            if (!this.top && Long2LongRBTreeMap.this.compare(to, this.f2310to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap tailMap(long from) {
            if (!this.bottom && Long2LongRBTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2310to, this.top);
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
        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public Long2LongSortedMap subMap(long j, long j2) {
            if (this.top && this.bottom) {
                return new Submap(j, false, j2, false);
            }
            long to = j2;
            if (!this.top) {
                to = Long2LongRBTreeMap.this.compare(j2, this.f2310to) < 0 ? j2 : this.f2310to;
            }
            long from = j;
            if (!this.bottom) {
                from = Long2LongRBTreeMap.this.compare(j, this.from) > 0 ? j : this.from;
            }
            if (!this.top && !this.bottom) {
                if ((from == 1 ? 1 : 0) == this.from) {
                    if ((to == 1 ? 1 : 0) == this.f2310to) {
                        return this;
                    }
                }
            }
            return new Submap(from, false, to, false);
        }

        public Entry firstEntry() {
            Entry e;
            if (Long2LongRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Long2LongRBTreeMap.this.firstEntry;
            } else {
                e = Long2LongRBTreeMap.this.locateKey(this.from);
                if (Long2LongRBTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Long2LongRBTreeMap.this.compare(e.key, this.f2310to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (Long2LongRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Long2LongRBTreeMap.this.lastEntry;
            } else {
                e = Long2LongRBTreeMap.this.locateKey(this.f2310to);
                if (Long2LongRBTreeMap.this.compare(e.key, this.f2310to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Long2LongRBTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long firstLongKey() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2LongSortedMap
        public long lastLongKey() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$Submap$SubmapIterator.class */
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
                if (submap.bottom || Long2LongRBTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Long2LongRBTreeMap long2LongRBTreeMap = Long2LongRBTreeMap.this;
                        Entry lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (long2LongRBTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Long2LongRBTreeMap.this.locateKey(k);
                    if (Long2LongRBTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Long2LongRBTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Long2LongRBTreeMap.this.compare(this.next.key, Submap.this.f2310to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends SubmapIterator implements ObjectListIterator<Long2LongMap.Entry> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(long k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Long2LongMap.Entry next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Long2LongMap.Entry previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$Submap$SubmapKeyIterator.class */
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
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2LongRBTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongRBTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends SubmapIterator implements LongListIterator {
            private SubmapValueIterator() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                return nextEntry().value;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
            public long previousLong() {
                return previousEntry().value;
            }
        }
    }

    @Override // java.lang.Object
    public Long2LongRBTreeMap clone() {
        try {
            Long2LongRBTreeMap c = (Long2LongRBTreeMap) clone();
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
                s.writeLong(e.value);
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readLong(), s.readLong());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readLong(), s.readLong());
            top2.black(true);
            top2.right(new Entry(s.readLong(), s.readLong()));
            top2.right.pred(top2);
            top2.pred(pred);
            top2.right.succ(succ);
            return top2;
        } else {
            int rightN = n / 2;
            int leftN = (n - rightN) - 1;
            Entry top3 = new Entry();
            top3.left(readTree(s, leftN, pred, top3));
            top3.key = s.readLong();
            top3.value = s.readLong();
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
