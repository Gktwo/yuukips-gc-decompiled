package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap;
import p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortListIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap.class */
public class Byte2ShortAVLTreeMap extends AbstractByte2ShortSortedMap implements Serializable, Cloneable {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected transient ObjectSortedSet<Byte2ShortMap.Entry> entries;
    protected transient ByteSortedSet keys;
    protected transient ShortCollection values;
    protected transient boolean modified;
    protected Comparator<? super Byte> storedComparator;
    protected transient ByteComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Byte2ShortAVLTreeMap.class.desiredAssertionStatus();
    }

    public Byte2ShortAVLTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = ByteComparators.asByteComparator(this.storedComparator);
    }

    public Byte2ShortAVLTreeMap(Comparator<? super Byte> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Byte2ShortAVLTreeMap(Map<? extends Byte, ? extends Short> m) {
        this();
        putAll(m);
    }

    public Byte2ShortAVLTreeMap(SortedMap<Byte, Short> m) {
        this(m.comparator());
        putAll(m);
    }

    public Byte2ShortAVLTreeMap(Byte2ShortMap m) {
        this();
        putAll(m);
    }

    public Byte2ShortAVLTreeMap(Byte2ShortSortedMap m) {
        this(m.comparator());
        putAll(m);
    }

    public Byte2ShortAVLTreeMap(byte[] k, short[] v, Comparator<? super Byte> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }

    public Byte2ShortAVLTreeMap(byte[] k, short[] v) {
        this(k, v, null);
    }

    final int compare(byte k1, byte k2) {
        return this.actualComparator == null ? Byte.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    final Entry findKey(byte k) {
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
        this.dirPath = new boolean[48];
    }

    public short addTo(byte k, short incr) {
        Entry e = add(k);
        short oldValue = e.value;
        e.value = (short) (e.value + incr);
        return oldValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
    public short put(byte k, short v) {
        Entry e = add(k);
        short oldValue = e.value;
        e.value = v;
        return oldValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x035e, code lost:
        r0.pred(r15);
        r15.succ(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x036f, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0372, code lost:
        if (r14 != null) goto L_0x037e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0375, code lost:
        r8.tree = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0385, code lost:
        if (r14.left != r13) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0388, code lost:
        r14.left = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0392, code lost:
        r14.right = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x012b, code lost:
        r11 = r13;
        r17 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0133, code lost:
        if (r11 == r10) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x013d, code lost:
        if (r8.dirPath[r17] == false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0140, code lost:
        r11.incBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0147, code lost:
        r11.decBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014b, code lost:
        r17 = r17 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0155, code lost:
        if (r8.dirPath[r17] == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0158, code lost:
        r0 = r11.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x015f, code lost:
        r0 = r11.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x016e, code lost:
        if (r13.balance() != -2) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0171, code lost:
        r0 = r13.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x017e, code lost:
        if (r0.balance() != -1) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0181, code lost:
        r15 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x018a, code lost:
        if (r0.succ() == false) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x018d, code lost:
        r0.succ(false);
        r13.pred(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x019d, code lost:
        r13.left = r0.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a7, code lost:
        r0.right = r13;
        r0.balance(0);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01c0, code lost:
        if (p014it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.$assertionsDisabled != false) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01c9, code lost:
        if (r0.balance() == 1) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d3, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d4, code lost:
        r15 = r0.right;
        r0.right = r15.left;
        r15.left = r0;
        r13.left = r15.right;
        r15.right = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0203, code lost:
        if (r15.balance() != -1) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0206, code lost:
        r0.balance(0);
        r13.balance(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x021a, code lost:
        if (r15.balance() != 0) goto L_0x022c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x021d, code lost:
        r0.balance(0);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022c, code lost:
        r0.balance(-1);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0238, code lost:
        r15.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0243, code lost:
        if (r15.pred() == false) goto L_0x0253;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0246, code lost:
        r0.succ(r15);
        r15.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0258, code lost:
        if (r15.succ() == false) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x025b, code lost:
        r13.pred(r15);
        r15.succ(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0271, code lost:
        if (r13.balance() != 2) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0274, code lost:
        r0 = r13.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0281, code lost:
        if (r0.balance() != 1) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0284, code lost:
        r15 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x028d, code lost:
        if (r0.pred() == false) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0290, code lost:
        r0.pred(false);
        r13.succ(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02a0, code lost:
        r13.right = r0.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02aa, code lost:
        r0.left = r13;
        r0.balance(0);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02c3, code lost:
        if (p014it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.$assertionsDisabled != false) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02cc, code lost:
        if (r0.balance() == -1) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02d6, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02d7, code lost:
        r15 = r0.left;
        r0.left = r15.right;
        r15.right = r0;
        r13.right = r15.left;
        r15.left = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0306, code lost:
        if (r15.balance() != 1) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0309, code lost:
        r0.balance(0);
        r13.balance(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x031d, code lost:
        if (r15.balance() != 0) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0320, code lost:
        r0.balance(0);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x032f, code lost:
        r0.balance(1);
        r13.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x033b, code lost:
        r15.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0346, code lost:
        if (r15.pred() == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0349, code lost:
        r13.succ(r15);
        r15.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x035b, code lost:
        if (r15.succ() == false) goto L_0x0370;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p014it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.Entry add(byte r9) {
        /*
        // Method dump skipped, instructions count: 923
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.add(byte):it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$Entry");
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

    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05c2, code lost:
        r4.modified = true;
        r4.count--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05d5, code lost:
        return r7.value;
     */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public short remove(byte r5) {
        /*
        // Method dump skipped, instructions count: 1494
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.remove(byte):short");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
    public boolean containsValue(short v) {
        ValueIterator i = new ValueIterator();
        int j = this.count;
        do {
            j--;
            if (j == 0) {
                return false;
            }
        } while (i.nextShort() != v);
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$Entry.class */
    public static final class Entry extends AbstractByte2ShortMap.BasicEntry implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        Entry left;
        Entry right;
        int info;

        Entry() {
            super((byte) 0, (short) 0);
        }

        Entry(byte k, short v) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap.BasicEntry, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap.Entry
        public short setValue(short value) {
            short oldValue = this.value;
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

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Byte, Short> e = (Map.Entry) o;
            return this.key == e.getKey().byteValue() && this.value == e.getValue().shortValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ this.value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap.BasicEntry, java.lang.Object
        public String toString() {
            return ((int) this.key) + "=>" + ((int) this.value);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
    public boolean containsKey(byte k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
    public short get(byte k) {
        Entry e = findKey(k);
        return e == null ? this.defRetValue : e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
    public byte firstByteKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
    public byte lastByteKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        TreeIterator() {
            this.next = Byte2ShortAVLTreeMap.this.firstEntry;
        }

        TreeIterator(byte k) {
            Entry locateKey = Byte2ShortAVLTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Byte2ShortAVLTreeMap.this.compare(this.next.key, k) <= 0) {
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
            Byte2ShortAVLTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$EntryIterator.class */
    public class EntryIterator extends TreeIterator implements ObjectListIterator<Byte2ShortMap.Entry> {
        EntryIterator() {
            super();
        }

        EntryIterator(byte k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Byte2ShortMap.Entry next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Byte2ShortMap.Entry previous() {
            return previousEntry();
        }

        public void set(Byte2ShortMap.Entry ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Byte2ShortMap.Entry ok) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
    public ObjectSortedSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Byte2ShortMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.1
                final Comparator<? super Byte2ShortMap.Entry> comparator;

                {
                    this.comparator = Byte2ShortAVLTreeMap.this.actualComparator == null ? x, y -> {
                        return Byte.compare(x.getByteKey(), y.getByteKey());
                    } : x, y -> {
                        return Byte2ShortAVLTreeMap.this.actualComparator.compare(x.getByteKey(), y.getByteKey());
                    };
                }

                @Override // java.util.SortedSet
                public Comparator<? super Byte2ShortMap.Entry> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Byte2ShortMap.Entry> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Byte2ShortMap.Entry> iterator(Byte2ShortMap.Entry from) {
                    return new EntryIterator(from.getByteKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Byte) && e.getValue() != null && (e.getValue() instanceof Short)) {
                        return e.equals(Byte2ShortAVLTreeMap.this.findKey(((Byte) e.getKey()).byteValue()));
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
                    if (e.getKey() == null || e.getKey() == null || !(e.getKey() instanceof Byte) || !(e.getValue() instanceof Short) || (f = Byte2ShortAVLTreeMap.this.findKey(((Byte) e.getKey()).byteValue())) == null || f.getShortValue() != ((Short) e.getValue()).shortValue()) {
                        return false;
                    }
                    Byte2ShortAVLTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Byte2ShortAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Byte2ShortAVLTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Byte2ShortMap.Entry first() {
                    return Byte2ShortAVLTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Byte2ShortMap.Entry last() {
                    return Byte2ShortAVLTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Byte2ShortMap.Entry> subSet(Byte2ShortMap.Entry from, Byte2ShortMap.Entry to) {
                    return Byte2ShortAVLTreeMap.this.subMap(from.getByteKey(), to.getByteKey()).byte2ShortEntrySet();
                }

                public ObjectSortedSet<Byte2ShortMap.Entry> headSet(Byte2ShortMap.Entry to) {
                    return Byte2ShortAVLTreeMap.this.headMap(to.getByteKey()).byte2ShortEntrySet();
                }

                public ObjectSortedSet<Byte2ShortMap.Entry> tailSet(Byte2ShortMap.Entry from) {
                    return Byte2ShortAVLTreeMap.this.tailMap(from.getByteKey()).byte2ShortEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$KeyIterator.class */
    public final class KeyIterator extends TreeIterator implements ByteListIterator {
        public KeyIterator() {
            super();
        }

        public KeyIterator(byte k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return previousEntry().key;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$KeySet.class */
    public class KeySet extends AbstractByte2ShortSortedMap.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap.KeySet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
        public ByteBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap.KeySet, p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
        public ByteBidirectionalIterator iterator(byte from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap, p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
    public ByteSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$ValueIterator.class */
    public final class ValueIterator extends TreeIterator implements ShortListIterator {
        private ValueIterator() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return nextEntry().value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return previousEntry().value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap, p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
    public ShortCollection values() {
        if (this.values == null) {
            this.values = new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
                public ShortIterator iterator() {
                    return new ValueIterator();
                }

                @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
                public boolean contains(short k) {
                    return Byte2ShortAVLTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Byte2ShortAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Byte2ShortAVLTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
    public Comparator<? super Byte> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
    public Byte2ShortSortedMap headMap(byte to) {
        return new Submap((byte) 0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
    public Byte2ShortSortedMap tailMap(byte from) {
        return new Submap(from, false, (byte) 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
    public Byte2ShortSortedMap subMap(byte from, byte to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$Submap.class */
    public final class Submap extends AbstractByte2ShortSortedMap implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        byte from;

        /* renamed from: to */
        byte f1197to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Byte2ShortMap.Entry> entries;
        protected transient ByteSortedSet keys;
        protected transient ShortCollection values;

        public Submap(byte from, boolean bottom, byte to, boolean top) {
            if (bottom || top || Byte2ShortAVLTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f1197to = to;
                this.top = top;
                this.defRetValue = Byte2ShortAVLTreeMap.this.defRetValue;
                return;
            }
            throw new IllegalArgumentException("Start key (" + ((int) from) + ") is larger than end key (" + ((int) to) + ")");
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
        final boolean m1096in(byte k) {
            return (this.bottom || Byte2ShortAVLTreeMap.this.compare(k, this.from) >= 0) && (this.top || Byte2ShortAVLTreeMap.this.compare(k, this.f1197to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public ObjectSortedSet<Byte2ShortMap.Entry> byte2ShortEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Byte2ShortMap.Entry>() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Byte2ShortMap.Entry> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Byte2ShortMap.Entry> iterator(Byte2ShortMap.Entry from) {
                        return new SubmapEntryIterator(from.getByteKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Byte2ShortMap.Entry> comparator() {
                        return Byte2ShortAVLTreeMap.this.byte2ShortEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Byte) && e.getValue() != null && (e.getValue() instanceof Short) && (f = Byte2ShortAVLTreeMap.this.findKey(((Byte) e.getKey()).byteValue())) != null && Submap.this.m1096in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Byte) || e.getValue() == null || !(e.getValue() instanceof Short)) {
                            return false;
                        }
                        Entry f = Byte2ShortAVLTreeMap.this.findKey(((Byte) e.getKey()).byteValue());
                        if (f != null && Submap.this.m1096in(f.key)) {
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
                    public Byte2ShortMap.Entry first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Byte2ShortMap.Entry last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Byte2ShortMap.Entry> subSet(Byte2ShortMap.Entry from, Byte2ShortMap.Entry to) {
                        return Submap.this.subMap(from.getByteKey(), to.getByteKey()).byte2ShortEntrySet();
                    }

                    public ObjectSortedSet<Byte2ShortMap.Entry> headSet(Byte2ShortMap.Entry to) {
                        return Submap.this.headMap(to.getByteKey()).byte2ShortEntrySet();
                    }

                    public ObjectSortedSet<Byte2ShortMap.Entry> tailSet(Byte2ShortMap.Entry from) {
                        return Submap.this.tailMap(from.getByteKey()).byte2ShortEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractByte2ShortSortedMap.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap.KeySet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSortedSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
            public ByteBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap.KeySet, p014it.unimi.dsi.fastutil.bytes.ByteSortedSet
            public ByteBidirectionalIterator iterator(byte from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap, p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public ByteSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortSortedMap, p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap, java.util.Map
        public ShortCollection values() {
            if (this.values == null) {
                this.values = new AbstractShortCollection() { // from class: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.Submap.2
                    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
                    public ShortIterator iterator() {
                        return new SubmapValueIterator();
                    }

                    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
                    public boolean contains(short k) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean containsKey(byte k) {
            return m1096in(k) && Byte2ShortAVLTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, p014it.unimi.dsi.fastutil.bytes.Byte2ShortMap
        public boolean containsValue(short v) {
            SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        public short get(byte k) {
            Entry e;
            return (!m1096in(k) || (e = Byte2ShortAVLTreeMap.this.findKey(k)) == null) ? this.defRetValue : e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        public short put(byte k, short v) {
            Byte2ShortAVLTreeMap.this.modified = false;
            if (!m1096in(k)) {
                throw new IllegalArgumentException("Key (" + ((int) k) + ") out of range [" + (this.bottom ? "-" : String.valueOf((int) this.from)) + ", " + (this.top ? "-" : String.valueOf((int) this.f1197to)) + ")");
            }
            return Byte2ShortAVLTreeMap.this.modified ? this.defRetValue : Byte2ShortAVLTreeMap.this.put(k, v);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction
        public short remove(byte k) {
            Byte2ShortAVLTreeMap.this.modified = false;
            if (!m1096in(k)) {
                return this.defRetValue;
            }
            return Byte2ShortAVLTreeMap.this.modified ? Byte2ShortAVLTreeMap.this.remove(k) : this.defRetValue;
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

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2ShortMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap, java.util.SortedMap
        public Comparator<? super Byte> comparator() {
            return Byte2ShortAVLTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap headMap(byte to) {
            if (!this.top && Byte2ShortAVLTreeMap.this.compare(to, this.f1197to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap tailMap(byte from) {
            if (!this.bottom && Byte2ShortAVLTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f1197to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public Byte2ShortSortedMap subMap(byte from, byte to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Byte2ShortAVLTreeMap.this.compare(to, this.f1197to) < 0 ? to : this.f1197to;
            }
            if (!this.bottom) {
                from = Byte2ShortAVLTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f1197to) ? new Submap(from, false, to, false) : this;
        }

        public Entry firstEntry() {
            Entry e;
            if (Byte2ShortAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Byte2ShortAVLTreeMap.this.firstEntry;
            } else {
                e = Byte2ShortAVLTreeMap.this.locateKey(this.from);
                if (Byte2ShortAVLTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Byte2ShortAVLTreeMap.this.compare(e.key, this.f1197to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (Byte2ShortAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Byte2ShortAVLTreeMap.this.lastEntry;
            } else {
                e = Byte2ShortAVLTreeMap.this.locateKey(this.f1197to);
                if (Byte2ShortAVLTreeMap.this.compare(e.key, this.f1197to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Byte2ShortAVLTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte firstByteKey() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortSortedMap
        public byte lastByteKey() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            SubmapIterator(Submap submap, byte k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Byte2ShortAVLTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Byte2ShortAVLTreeMap byte2ShortAVLTreeMap = Byte2ShortAVLTreeMap.this;
                        Entry lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (byte2ShortAVLTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Byte2ShortAVLTreeMap.this.locateKey(k);
                    if (Byte2ShortAVLTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Byte2ShortAVLTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Byte2ShortAVLTreeMap.this.compare(this.next.key, Submap.this.f1197to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends SubmapIterator implements ObjectListIterator<Byte2ShortMap.Entry> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(byte k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Byte2ShortMap.Entry next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Byte2ShortMap.Entry previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends SubmapIterator implements ByteListIterator {
            public SubmapKeyIterator() {
                super();
            }

            public SubmapKeyIterator(byte from) {
                super(Submap.this, from);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
            public byte nextByte() {
                return nextEntry().key;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
            public byte previousByte() {
                return previousEntry().key;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ShortAVLTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ShortAVLTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends SubmapIterator implements ShortListIterator {
            private SubmapValueIterator() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
            public short nextShort() {
                return nextEntry().value;
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
            public short previousShort() {
                return previousEntry().value;
            }
        }
    }

    @Override // java.lang.Object
    public Byte2ShortAVLTreeMap clone() {
        try {
            Byte2ShortAVLTreeMap c = (Byte2ShortAVLTreeMap) clone();
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
                s.writeByte(e.key);
                s.writeShort(e.value);
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readByte(), s.readShort());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readByte(), s.readShort());
            top2.right(new Entry(s.readByte(), s.readShort()));
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
            top3.key = s.readByte();
            top3.value = s.readShort();
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
