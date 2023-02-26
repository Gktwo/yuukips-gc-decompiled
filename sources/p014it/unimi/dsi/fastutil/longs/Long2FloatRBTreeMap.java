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
import p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.floats.FloatListIterator;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap;
import p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap;
import p014it.unimi.dsi.fastutil.longs.Long2FloatMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap.class */
public class Long2FloatRBTreeMap extends AbstractLong2FloatSortedMap implements Serializable, Cloneable {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected transient ObjectSortedSet<Long2FloatMap.Entry> entries;
    protected transient LongSortedSet keys;
    protected transient FloatCollection values;
    protected transient boolean modified;
    protected Comparator<? super Long> storedComparator;
    protected transient LongComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    private transient Entry[] nodePath;

    public Long2FloatRBTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = LongComparators.asLongComparator(this.storedComparator);
    }

    public Long2FloatRBTreeMap(Comparator<? super Long> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Long2FloatRBTreeMap(Map<? extends Long, ? extends Float> m) {
        this();
        putAll(m);
    }

    public Long2FloatRBTreeMap(SortedMap<Long, Float> m) {
        this(m.comparator());
        putAll(m);
    }

    public Long2FloatRBTreeMap(Long2FloatMap m) {
        this();
        putAll(m);
    }

    public Long2FloatRBTreeMap(Long2FloatSortedMap m) {
        this(m.comparator());
        putAll(m);
    }

    public Long2FloatRBTreeMap(long[] k, float[] v, Comparator<? super Long> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Long2FloatRBTreeMap(long[] k, float[] v) {
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

    public float addTo(long k, float incr) {
        Entry e = add(k);
        float oldValue = e.value;
        e.value += incr;
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    public float put(long k, float v) {
        Entry e = add(k);
        float oldValue = e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0059, code lost:
        r9.nodePath[r16] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0066, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x012e, code lost:
        r9.modified = true;
        r16 = r16 - 1;
        r12 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x013b, code lost:
        if (r16 <= 0) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0148, code lost:
        if (r9.nodePath[r16].black() != false) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0154, code lost:
        if (r9.dirPath[r16 - 1] != false) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0157, code lost:
        r0 = r9.nodePath[r16 - 1].right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0171, code lost:
        if (r9.nodePath[r16 - 1].succ() != false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0179, code lost:
        if (r0.black() != false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x017c, code lost:
        r9.nodePath[r16].black(true);
        r0.black(true);
        r9.nodePath[r16 - 1].black(false);
        r16 = r16 - 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01a7, code lost:
        if (r9.dirPath[r16] != false) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01aa, code lost:
        r17 = r9.nodePath[r16];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01b6, code lost:
        r0 = r9.nodePath[r16];
        r17 = r0.right;
        r0.right = r17.left;
        r17.left = r0;
        r9.nodePath[r16 - 1].left = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01ea, code lost:
        if (r17.pred() == false) goto L_0x01fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01ed, code lost:
        r17.pred(false);
        r0.succ(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01fa, code lost:
        r0 = r9.nodePath[r16 - 1];
        r0.black(false);
        r17.black(true);
        r0.left = r17.right;
        r17.right = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0225, code lost:
        if (r16 >= 2) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0228, code lost:
        r9.tree = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x023a, code lost:
        if (r9.dirPath[r16 - 2] == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x023d, code lost:
        r9.nodePath[r16 - 2].right = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x024e, code lost:
        r9.nodePath[r16 - 2].left = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0261, code lost:
        if (r17.succ() == false) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0264, code lost:
        r17.succ(false);
        r0.pred(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0277, code lost:
        r0 = r9.nodePath[r16 - 1].left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0291, code lost:
        if (r9.nodePath[r16 - 1].pred() != false) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0299, code lost:
        if (r0.black() != false) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x029c, code lost:
        r9.nodePath[r16].black(true);
        r0.black(true);
        r9.nodePath[r16 - 1].black(false);
        r16 = r16 - 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02c7, code lost:
        if (r9.dirPath[r16] == false) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02ca, code lost:
        r17 = r9.nodePath[r16];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02d6, code lost:
        r0 = r9.nodePath[r16];
        r17 = r0.left;
        r0.left = r17.right;
        r17.right = r0;
        r9.nodePath[r16 - 1].right = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x030a, code lost:
        if (r17.succ() == false) goto L_0x031a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x030d, code lost:
        r17.succ(false);
        r0.pred(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x031a, code lost:
        r0 = r9.nodePath[r16 - 1];
        r0.black(false);
        r17.black(true);
        r0.right = r17.left;
        r17.left = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0345, code lost:
        if (r16 >= 2) goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0348, code lost:
        r9.tree = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x035a, code lost:
        if (r9.dirPath[r16 - 2] == false) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x035d, code lost:
        r9.nodePath[r16 - 2].right = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x036e, code lost:
        r9.nodePath[r16 - 2].left = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0381, code lost:
        if (r17.pred() == false) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0384, code lost:
        r17.pred(false);
        r0.succ(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0051, code lost:
        r16 = r16 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0056, code lost:
        if (r16 == 0) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.Entry add(long r10) {
        /*
        // Method dump skipped, instructions count: 947
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.add(long):it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$Entry");
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
    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float remove(long r7) {
        /*
        // Method dump skipped, instructions count: 1897
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.remove(long):float");
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public boolean containsValue(float v) {
        ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (Float.floatToIntBits(i.nextFloat()) != Float.floatToIntBits(v));
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$Entry.class */
    public static final class Entry extends AbstractLong2FloatMap.BasicEntry implements Cloneable {
        private static final int BLACK_MASK = 1;
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        Entry left;
        Entry right;
        int info;

        Entry() {
            super(0, 0.0f);
        }

        Entry(long k, float v) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap.BasicEntry, p014it.unimi.dsi.fastutil.longs.Long2FloatMap.Entry
        public float setValue(float value) {
            float oldValue = this.value;
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Long, Float> e = (Map.Entry) o;
            return this.key == e.getKey().longValue() && Float.floatToIntBits(this.value) == Float.floatToIntBits(e.getValue().floatValue());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return HashCommon.long2int(this.key) ^ HashCommon.float2int(this.value);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatFunction, p014it.unimi.dsi.fastutil.longs.Long2FloatMap
    public boolean containsKey(long k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    public float get(long k) {
        Entry e = findKey(k);
        return e == null ? this.defRetValue : e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
    public long firstLongKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
    public long lastLongKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        TreeIterator() {
            this.next = Long2FloatRBTreeMap.this.firstEntry;
        }

        TreeIterator(long k) {
            Entry locateKey = Long2FloatRBTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Long2FloatRBTreeMap.this.compare(this.next.key, k) <= 0) {
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
            Long2FloatRBTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$EntryIterator.class */
    public class EntryIterator extends TreeIterator implements ObjectListIterator<Long2FloatMap.Entry> {
        EntryIterator() {
            super();
        }

        EntryIterator(long k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Long2FloatMap.Entry next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Long2FloatMap.Entry previous() {
            return previousEntry();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
    public ObjectSortedSet<Long2FloatMap.Entry> long2FloatEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Long2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.1
                final Comparator<? super Long2FloatMap.Entry> comparator;

                {
                    this.comparator = Long2FloatRBTreeMap.this.actualComparator == null ? x, y -> {
                        return Long.compare(x.getLongKey(), y.getLongKey());
                    } : x, y -> {
                        return Long2FloatRBTreeMap.this.actualComparator.compare(x.getLongKey(), y.getLongKey());
                    };
                }

                @Override // java.util.SortedSet
                public Comparator<? super Long2FloatMap.Entry> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Long2FloatMap.Entry> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Long2FloatMap.Entry> iterator(Long2FloatMap.Entry from) {
                    return new EntryIterator(from.getLongKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Long) && e.getValue() != null && (e.getValue() instanceof Float)) {
                        return e.equals(Long2FloatRBTreeMap.this.findKey(((Long) e.getKey()).longValue()));
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
                    if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Float) || (f = Long2FloatRBTreeMap.this.findKey(((Long) e.getKey()).longValue())) == null || Float.floatToIntBits(f.getFloatValue()) != Float.floatToIntBits(((Float) e.getValue()).floatValue())) {
                        return false;
                    }
                    Long2FloatRBTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Long2FloatRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Long2FloatRBTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Long2FloatMap.Entry first() {
                    return Long2FloatRBTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Long2FloatMap.Entry last() {
                    return Long2FloatRBTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Long2FloatMap.Entry> subSet(Long2FloatMap.Entry from, Long2FloatMap.Entry to) {
                    return Long2FloatRBTreeMap.this.subMap(from.getLongKey(), to.getLongKey()).long2FloatEntrySet();
                }

                public ObjectSortedSet<Long2FloatMap.Entry> headSet(Long2FloatMap.Entry to) {
                    return Long2FloatRBTreeMap.this.headMap(to.getLongKey()).long2FloatEntrySet();
                }

                public ObjectSortedSet<Long2FloatMap.Entry> tailSet(Long2FloatMap.Entry from) {
                    return Long2FloatRBTreeMap.this.tailMap(from.getLongKey()).long2FloatEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$KeyIterator.class */
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
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$KeySet.class */
    public class KeySet extends AbstractLong2FloatSortedMap.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
        public LongBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.LongSortedSet
        public LongBidirectionalIterator iterator(long from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    public LongSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$ValueIterator.class */
    public final class ValueIterator extends TreeIterator implements FloatListIterator {
        private ValueIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return nextEntry().value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return previousEntry().value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
    public FloatCollection values() {
        if (this.values == null) {
            this.values = new AbstractFloatCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
                public FloatIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
                public boolean contains(float k) {
                    return Long2FloatRBTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Long2FloatRBTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Long2FloatRBTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap, java.util.SortedMap
    public Comparator<? super Long> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
    public Long2FloatSortedMap headMap(long to) {
        return new Submap(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
    public Long2FloatSortedMap tailMap(long from) {
        return new Submap(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
    public Long2FloatSortedMap subMap(long from, long to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$Submap.class */
    public final class Submap extends AbstractLong2FloatSortedMap implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        long from;

        /* renamed from: to */
        long f2286to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Long2FloatMap.Entry> entries;
        protected transient LongSortedSet keys;
        protected transient FloatCollection values;

        public Submap(long from, boolean bottom, long to, boolean top) {
            if (bottom || top || Long2FloatRBTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2286to = to;
                this.top = top;
                this.defRetValue = Long2FloatRBTreeMap.this.defRetValue;
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
        final boolean m682in(long k) {
            return (this.bottom || Long2FloatRBTreeMap.this.compare(k, this.from) >= 0) && (this.top || Long2FloatRBTreeMap.this.compare(k, this.f2286to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public ObjectSortedSet<Long2FloatMap.Entry> long2FloatEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Long2FloatMap.Entry>() { // from class: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Long2FloatMap.Entry> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Long2FloatMap.Entry> iterator(Long2FloatMap.Entry from) {
                        return new SubmapEntryIterator(from.getLongKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Long2FloatMap.Entry> comparator() {
                        return Long2FloatRBTreeMap.this.long2FloatEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Long) && e.getValue() != null && (e.getValue() instanceof Float) && (f = Long2FloatRBTreeMap.this.findKey(((Long) e.getKey()).longValue())) != null && Submap.this.m682in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Long) || e.getValue() == null || !(e.getValue() instanceof Float)) {
                            return false;
                        }
                        Entry f = Long2FloatRBTreeMap.this.findKey(((Long) e.getKey()).longValue());
                        if (f != null && Submap.this.m682in(f.key)) {
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
                    public Long2FloatMap.Entry first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Long2FloatMap.Entry last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Long2FloatMap.Entry> subSet(Long2FloatMap.Entry from, Long2FloatMap.Entry to) {
                        return Submap.this.subMap(from.getLongKey(), to.getLongKey()).long2FloatEntrySet();
                    }

                    public ObjectSortedSet<Long2FloatMap.Entry> headSet(Long2FloatMap.Entry to) {
                        return Submap.this.headMap(to.getLongKey()).long2FloatEntrySet();
                    }

                    public ObjectSortedSet<Long2FloatMap.Entry> tailSet(Long2FloatMap.Entry from) {
                        return Submap.this.tailMap(from.getLongKey()).long2FloatEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractLong2FloatSortedMap.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.AbstractLongSortedSet, p014it.unimi.dsi.fastutil.longs.AbstractLongSet, p014it.unimi.dsi.fastutil.longs.AbstractLongCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.longs.LongCollection, p014it.unimi.dsi.fastutil.longs.LongIterable
            public LongBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap.KeySet, p014it.unimi.dsi.fastutil.longs.LongSortedSet
            public LongBidirectionalIterator iterator(long from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public LongSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatSortedMap, p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap, java.util.Map
        public FloatCollection values() {
            if (this.values == null) {
                this.values = new AbstractFloatCollection() { // from class: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
                    public FloatIterator iterator() {
                        return new SubmapValueIterator();
                    }

                    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
                    public boolean contains(float k) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatFunction, p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean containsKey(long k) {
            return m682in(k) && Long2FloatRBTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, p014it.unimi.dsi.fastutil.longs.Long2FloatMap
        public boolean containsValue(float v) {
            SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (Float.floatToIntBits(i.nextEntry().value) == Float.floatToIntBits(v)) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        public float get(long k) {
            Entry e;
            return (!m682in(k) || (e = Long2FloatRBTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        public float put(long k, float v) {
            Long2FloatRBTreeMap.this.modified = false;
            if (!m682in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2286to)) + ")");
            }
            return Long2FloatRBTreeMap.this.modified ? this.defRetValue : Long2FloatRBTreeMap.this.put(k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
        public float remove(long k) {
            Long2FloatRBTreeMap.this.modified = false;
            if (!m682in(k)) {
                return this.defRetValue;
            }
            return Long2FloatRBTreeMap.this.modified ? Long2FloatRBTreeMap.this.remove(k) : this.defRetValue;
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

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2FloatMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap, java.util.SortedMap
        public Comparator<? super Long> comparator() {
            return Long2FloatRBTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public Long2FloatSortedMap headMap(long to) {
            if (!this.top && Long2FloatRBTreeMap.this.compare(to, this.f2286to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public Long2FloatSortedMap tailMap(long from) {
            if (!this.bottom && Long2FloatRBTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f2286to, this.top);
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
        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public Long2FloatSortedMap subMap(long j, long j2) {
            if (this.top && this.bottom) {
                return new Submap(j, false, j2, false);
            }
            long to = j2;
            if (!this.top) {
                to = Long2FloatRBTreeMap.this.compare(j2, this.f2286to) < 0 ? j2 : this.f2286to;
            }
            long from = j;
            if (!this.bottom) {
                from = Long2FloatRBTreeMap.this.compare(j, this.from) > 0 ? j : this.from;
            }
            if (!this.top && !this.bottom) {
                if ((from == 1 ? 1 : 0) == this.from) {
                    if ((to == 1 ? 1 : 0) == this.f2286to) {
                        return this;
                    }
                }
            }
            return new Submap(from, false, to, false);
        }

        public Entry firstEntry() {
            Entry e;
            if (Long2FloatRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Long2FloatRBTreeMap.this.firstEntry;
            } else {
                e = Long2FloatRBTreeMap.this.locateKey(this.from);
                if (Long2FloatRBTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Long2FloatRBTreeMap.this.compare(e.key, this.f2286to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (Long2FloatRBTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Long2FloatRBTreeMap.this.lastEntry;
            } else {
                e = Long2FloatRBTreeMap.this.locateKey(this.f2286to);
                if (Long2FloatRBTreeMap.this.compare(e.key, this.f2286to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Long2FloatRBTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public long firstLongKey() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatSortedMap
        public long lastLongKey() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$Submap$SubmapIterator.class */
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
                if (submap.bottom || Long2FloatRBTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Long2FloatRBTreeMap long2FloatRBTreeMap = Long2FloatRBTreeMap.this;
                        Entry lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (long2FloatRBTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Long2FloatRBTreeMap.this.locateKey(k);
                    if (Long2FloatRBTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Long2FloatRBTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Long2FloatRBTreeMap.this.compare(this.next.key, Submap.this.f2286to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends SubmapIterator implements ObjectListIterator<Long2FloatMap.Entry> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(long k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Long2FloatMap.Entry next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Long2FloatMap.Entry previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$Submap$SubmapKeyIterator.class */
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
        /* renamed from: it.unimi.dsi.fastutil.longs.Long2FloatRBTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2FloatRBTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends SubmapIterator implements FloatListIterator {
            private SubmapValueIterator() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            public float nextFloat() {
                return nextEntry().value;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
            public float previousFloat() {
                return previousEntry().value;
            }
        }
    }

    @Override // java.lang.Object
    public Long2FloatRBTreeMap clone() {
        try {
            Long2FloatRBTreeMap c = (Long2FloatRBTreeMap) clone();
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
                s.writeFloat(e.value);
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readLong(), s.readFloat());
            top.pred(pred);
            top.succ(succ);
            top.black(true);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readLong(), s.readFloat());
            top2.black(true);
            top2.right(new Entry(s.readLong(), s.readFloat()));
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
            top3.value = s.readFloat();
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
