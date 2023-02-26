package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap.class */
public class Char2ReferenceAVLTreeMap<V> extends AbstractChar2ReferenceSortedMap<V> implements Serializable, Cloneable {
    protected transient Entry<V> tree;
    protected int count;
    protected transient Entry<V> firstEntry;
    protected transient Entry<V> lastEntry;
    protected transient ObjectSortedSet<Char2ReferenceMap.Entry<V>> entries;
    protected transient CharSortedSet keys;
    protected transient ReferenceCollection<V> values;
    protected transient boolean modified;
    protected Comparator<? super Character> storedComparator;
    protected transient CharComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353129L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Char2ReferenceAVLTreeMap.class.desiredAssertionStatus();
    }

    public Char2ReferenceAVLTreeMap() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = CharComparators.asCharComparator(this.storedComparator);
    }

    public Char2ReferenceAVLTreeMap(Comparator<? super Character> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public Char2ReferenceAVLTreeMap(Map<? extends Character, ? extends V> m) {
        this();
        putAll(m);
    }

    public Char2ReferenceAVLTreeMap(SortedMap<Character, V> m) {
        this(m.comparator());
        putAll(m);
    }

    public Char2ReferenceAVLTreeMap(Char2ReferenceMap<? extends V> m) {
        this();
        putAll(m);
    }

    public Char2ReferenceAVLTreeMap(Char2ReferenceSortedMap<V> m) {
        this(m.comparator());
        putAll(m);
    }

    public Char2ReferenceAVLTreeMap(char[] k, V[] v, Comparator<? super Character> c) {
        this(c);
        if (k.length != v.length) {
            throw new IllegalArgumentException("The key array and the value array have different lengths (" + k.length + " and " + v.length + ")");
        }
        for (int i = 0; i < k.length; i++) {
            put(k[i], (char) v[i]);
        }
    }

    public Char2ReferenceAVLTreeMap(char[] k, V[] v) {
        this(k, v, null);
    }

    final int compare(char k1, char k2) {
        return this.actualComparator == null ? Character.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    final Entry<V> findKey(char k) {
        int cmp;
        Entry<V> e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

    final Entry<V> locateKey(char k) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction
    public V put(char k, V v) {
        Entry<V> e = add(k);
        V oldValue = (V) e.value;
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
        if (p014it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.$assertionsDisabled != false) goto L_0x01d4;
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
        if (p014it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.$assertionsDisabled != false) goto L_0x02d7;
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
    private p014it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.Entry<V> add(char r9) {
        /*
        // Method dump skipped, instructions count: 923
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.add(char):it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$Entry");
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

    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05c2, code lost:
        r4.modified = true;
        r4.count--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05d5, code lost:
        return (V) r7.value;
     */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V remove(char r5) {
        /*
        // Method dump skipped, instructions count: 1494
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.remove(char):java.lang.Object");
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, java.util.Map
    public boolean containsValue(Object v) {
        Char2ReferenceAVLTreeMap<V>.ValueIterator i = new ValueIterator();
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
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$Entry.class */
    public static final class Entry<V> extends AbstractChar2ReferenceMap.BasicEntry<V> implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        Entry<V> left;
        Entry<V> right;
        int info;

        Entry() {
            super((char) 0, (Object) null);
        }

        Entry(char k, V v) {
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

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap.BasicEntry, java.util.Map.Entry
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

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<Character, V> e = (Map.Entry) o;
            return this.key == e.getKey().charValue() && this.value == e.getValue();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap.BasicEntry, java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.key ^ (this.value == null ? 0 : System.identityHashCode(this.value));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap.BasicEntry, java.lang.Object
        public String toString() {
            return this.key + "=>" + this.value;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap
    public boolean containsKey(char k) {
        return findKey(k) != null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    public int size() {
        return this.count;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, java.util.Map
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction
    public V get(char k) {
        Entry<V> e = findKey(k);
        return e == null ? (V) this.defRetValue : (V) e.value;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
    public char firstCharKey() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
    public char lastCharKey() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$TreeIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$TreeIterator.class */
    private class TreeIterator {
        Entry<V> prev;
        Entry<V> next;
        Entry<V> curr;
        int index = 0;

        TreeIterator() {
            this.next = Char2ReferenceAVLTreeMap.this.firstEntry;
        }

        TreeIterator(char k) {
            Entry<V> locateKey = Char2ReferenceAVLTreeMap.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (Char2ReferenceAVLTreeMap.this.compare(this.next.key, k) <= 0) {
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
            Char2ReferenceAVLTreeMap.this.remove(this.curr.key);
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
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$EntryIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$EntryIterator.class */
    public class EntryIterator extends Char2ReferenceAVLTreeMap<V>.TreeIterator implements ObjectListIterator<Char2ReferenceMap.Entry<V>> {
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            add((Char2ReferenceMap.Entry) ((Char2ReferenceMap.Entry) obj));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            set((Char2ReferenceMap.Entry) ((Char2ReferenceMap.Entry) obj));
        }

        EntryIterator() {
            super();
        }

        EntryIterator(char k) {
            super(k);
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Char2ReferenceMap.Entry<V> next() {
            return nextEntry();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public Char2ReferenceMap.Entry<V> previous() {
            return previousEntry();
        }

        public void set(Char2ReferenceMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }

        public void add(Char2ReferenceMap.Entry<V> ok) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
    public ObjectSortedSet<Char2ReferenceMap.Entry<V>> char2ReferenceEntrySet() {
        if (this.entries == null) {
            this.entries = new AbstractObjectSortedSet<Char2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.1
                final Comparator<? super Char2ReferenceMap.Entry<V>> comparator;

                {
                    this.comparator = Char2ReferenceAVLTreeMap.this.actualComparator == null ? x, y -> {
                        return Character.compare(x.getCharKey(), y.getCharKey());
                    } : x, y -> {
                        return Char2ReferenceAVLTreeMap.this.actualComparator.compare(x.getCharKey(), y.getCharKey());
                    };
                }

                @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                    return iterator((Char2ReferenceMap.Entry) ((Char2ReferenceMap.Entry) obj));
                }

                @Override // java.util.SortedSet
                public Comparator<? super Char2ReferenceMap.Entry<V>> comparator() {
                    return this.comparator;
                }

                @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                public ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> iterator() {
                    return new EntryIterator();
                }

                public ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> iterator(Char2ReferenceMap.Entry<V> from) {
                    return new EntryIterator(from.getCharKey());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object o) {
                    if (o == null || !(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> e = (Map.Entry) o;
                    if (e.getKey() != null && (e.getKey() instanceof Character)) {
                        return e.equals(Char2ReferenceAVLTreeMap.this.findKey(((Character) e.getKey()).charValue()));
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
                    if (e.getKey() == null || e.getKey() == null || !(e.getKey() instanceof Character) || (f = Char2ReferenceAVLTreeMap.this.findKey(((Character) e.getKey()).charValue())) == null || f.getValue() != e.getValue()) {
                        return false;
                    }
                    Char2ReferenceAVLTreeMap.this.remove(f.key);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Char2ReferenceAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    Char2ReferenceAVLTreeMap.this.clear();
                }

                @Override // java.util.SortedSet
                public Char2ReferenceMap.Entry<V> first() {
                    return Char2ReferenceAVLTreeMap.this.firstEntry;
                }

                @Override // java.util.SortedSet
                public Char2ReferenceMap.Entry<V> last() {
                    return Char2ReferenceAVLTreeMap.this.lastEntry;
                }

                public ObjectSortedSet<Char2ReferenceMap.Entry<V>> subSet(Char2ReferenceMap.Entry<V> from, Char2ReferenceMap.Entry<V> to) {
                    return Char2ReferenceAVLTreeMap.this.subMap(from.getCharKey(), to.getCharKey()).char2ReferenceEntrySet();
                }

                public ObjectSortedSet<Char2ReferenceMap.Entry<V>> headSet(Char2ReferenceMap.Entry<V> to) {
                    return Char2ReferenceAVLTreeMap.this.headMap(to.getCharKey()).char2ReferenceEntrySet();
                }

                public ObjectSortedSet<Char2ReferenceMap.Entry<V>> tailSet(Char2ReferenceMap.Entry<V> from) {
                    return Char2ReferenceAVLTreeMap.this.tailMap(from.getCharKey()).char2ReferenceEntrySet();
                }
            };
        }
        return this.entries;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$KeyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$KeyIterator.class */
    public final class KeyIterator extends Char2ReferenceAVLTreeMap<V>.TreeIterator implements CharListIterator {
        public KeyIterator() {
            super();
        }

        public KeyIterator(char k) {
            super(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return previousEntry().key;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$KeySet.class */
    public class KeySet extends AbstractChar2ReferenceSortedMap<V>.KeySet {
        private KeySet() {
            super();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.chars.AbstractCharSortedSet, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharBidirectionalIterator iterator() {
            return new KeyIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.chars.CharSortedSet
        public CharBidirectionalIterator iterator(char from) {
            return new KeyIterator(from);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap, p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    public CharSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$ValueIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$ValueIterator.class */
    public final class ValueIterator extends Char2ReferenceAVLTreeMap<V>.TreeIterator implements ObjectListIterator<V> {
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap, p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    public ReferenceCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.2
                @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object k) {
                    return Char2ReferenceAVLTreeMap.this.containsValue(k);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return Char2ReferenceAVLTreeMap.this.count;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    Char2ReferenceAVLTreeMap.this.clear();
                }
            };
        }
        return this.values;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
    public Comparator<? super Character> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
    public Char2ReferenceSortedMap<V> headMap(char to) {
        return new Submap(0, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
    public Char2ReferenceSortedMap<V> tailMap(char from) {
        return new Submap(from, false, 0, true);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
    public Char2ReferenceSortedMap<V> subMap(char from, char to) {
        return new Submap(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$Submap */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$Submap.class */
    public final class Submap extends AbstractChar2ReferenceSortedMap<V> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        char from;

        /* renamed from: to */
        char f1412to;
        boolean bottom;
        boolean top;
        protected transient ObjectSortedSet<Char2ReferenceMap.Entry<V>> entries;
        protected transient CharSortedSet keys;
        protected transient ReferenceCollection<V> values;

        public Submap(char from, boolean bottom, char to, boolean top) {
            if (bottom || top || Char2ReferenceAVLTreeMap.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f1412to = to;
                this.top = top;
                this.defRetValue = Char2ReferenceAVLTreeMap.this.defRetValue;
                return;
            }
            throw new IllegalArgumentException("Start key (" + from + ") is larger than end key (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            Char2ReferenceAVLTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                i.nextEntry();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m1013in(char k) {
            return (this.bottom || Char2ReferenceAVLTreeMap.this.compare(k, this.from) >= 0) && (this.top || Char2ReferenceAVLTreeMap.this.compare(k, this.f1412to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public ObjectSortedSet<Char2ReferenceMap.Entry<V>> char2ReferenceEntrySet() {
            if (this.entries == null) {
                this.entries = new AbstractObjectSortedSet<Char2ReferenceMap.Entry<V>>() { // from class: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.Submap.1
                    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
                    public /* bridge */ /* synthetic */ ObjectBidirectionalIterator iterator(Object obj) {
                        return iterator((Char2ReferenceMap.Entry) ((Char2ReferenceMap.Entry) obj));
                    }

                    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
                    public ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> iterator() {
                        return new SubmapEntryIterator();
                    }

                    public ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> iterator(Char2ReferenceMap.Entry<V> from) {
                        return new SubmapEntryIterator(from.getCharKey());
                    }

                    @Override // java.util.SortedSet
                    public Comparator<? super Char2ReferenceMap.Entry<V>> comparator() {
                        return Char2ReferenceAVLTreeMap.this.char2ReferenceEntrySet().comparator();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean contains(Object o) {
                        Entry<V> f;
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        return e.getKey() != null && (e.getKey() instanceof Character) && (f = Char2ReferenceAVLTreeMap.this.findKey(((Character) e.getKey()).charValue())) != null && Submap.this.m1013in(f.key) && e.equals(f);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object o) {
                        if (!(o instanceof Map.Entry)) {
                            return false;
                        }
                        Map.Entry<?, ?> e = (Map.Entry) o;
                        if (e.getKey() == null || !(e.getKey() instanceof Character)) {
                            return false;
                        }
                        Entry<V> f = Char2ReferenceAVLTreeMap.this.findKey(((Character) e.getKey()).charValue());
                        if (f != null && Submap.this.m1013in(f.key)) {
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
                    public Char2ReferenceMap.Entry<V> first() {
                        return Submap.this.firstEntry();
                    }

                    @Override // java.util.SortedSet
                    public Char2ReferenceMap.Entry<V> last() {
                        return Submap.this.lastEntry();
                    }

                    public ObjectSortedSet<Char2ReferenceMap.Entry<V>> subSet(Char2ReferenceMap.Entry<V> from, Char2ReferenceMap.Entry<V> to) {
                        return Submap.this.subMap(from.getCharKey(), to.getCharKey()).char2ReferenceEntrySet();
                    }

                    public ObjectSortedSet<Char2ReferenceMap.Entry<V>> headSet(Char2ReferenceMap.Entry<V> to) {
                        return Submap.this.headMap(to.getCharKey()).char2ReferenceEntrySet();
                    }

                    public ObjectSortedSet<Char2ReferenceMap.Entry<V>> tailSet(Char2ReferenceMap.Entry<V> from) {
                        return Submap.this.tailMap(from.getCharKey()).char2ReferenceEntrySet();
                    }
                };
            }
            return this.entries;
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$Submap$KeySet */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$Submap$KeySet.class */
        public class KeySet extends AbstractChar2ReferenceSortedMap<V>.KeySet {
            private KeySet() {
                super();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.chars.AbstractCharSortedSet, p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
            public CharBidirectionalIterator iterator() {
                return new SubmapKeyIterator();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap.KeySet, p014it.unimi.dsi.fastutil.chars.CharSortedSet
            public CharBidirectionalIterator iterator(char from) {
                return new SubmapKeyIterator(from);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap, p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        public CharSortedSet keySet() {
            if (this.keys == null) {
                this.keys = new KeySet();
            }
            return this.keys;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceSortedMap, p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
        public ReferenceCollection<V> values() {
            if (this.values == null) {
                this.values = new AbstractReferenceCollection<V>() { // from class: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.Submap.2
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

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction, p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap
        public boolean containsKey(char k) {
            return m1013in(k) && Char2ReferenceAVLTreeMap.this.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, java.util.Map
        public boolean containsValue(Object v) {
            Char2ReferenceAVLTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            while (i.hasNext()) {
                if (i.nextEntry().value == v) {
                    return true;
                }
            }
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction
        public V get(char k) {
            Entry<V> e;
            return (!m1013in(k) || (e = Char2ReferenceAVLTreeMap.this.findKey(k)) == null) ? (V) this.defRetValue : (V) e.value;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction
        public V put(char k, V v) {
            Char2ReferenceAVLTreeMap.this.modified = false;
            if (!m1013in(k)) {
                throw new IllegalArgumentException("Key (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f1412to)) + ")");
            }
            return Char2ReferenceAVLTreeMap.this.modified ? (V) this.defRetValue : (V) Char2ReferenceAVLTreeMap.this.put(k, (char) v);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction
        public V remove(char k) {
            Char2ReferenceAVLTreeMap.this.modified = false;
            if (!m1013in(k)) {
                return (V) this.defRetValue;
            }
            return Char2ReferenceAVLTreeMap.this.modified ? (V) Char2ReferenceAVLTreeMap.this.remove(k) : (V) this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            Char2ReferenceAVLTreeMap<V>.Submap.SubmapIterator i = new SubmapIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextEntry();
            }
            return n;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2ReferenceMap, java.util.Map
        public boolean isEmpty() {
            return !new SubmapIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap, java.util.SortedMap
        public Comparator<? super Character> comparator() {
            return Char2ReferenceAVLTreeMap.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> headMap(char to) {
            if (!this.top && Char2ReferenceAVLTreeMap.this.compare(to, this.f1412to) >= 0) {
                return this;
            }
            return new Submap(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> tailMap(char from) {
            if (!this.bottom && Char2ReferenceAVLTreeMap.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Submap(from, false, this.f1412to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public Char2ReferenceSortedMap<V> subMap(char from, char to) {
            if (this.top && this.bottom) {
                return new Submap(from, false, to, false);
            }
            if (!this.top) {
                to = Char2ReferenceAVLTreeMap.this.compare(to, this.f1412to) < 0 ? to : this.f1412to;
            }
            if (!this.bottom) {
                from = Char2ReferenceAVLTreeMap.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f1412to) ? new Submap(from, false, to, false) : this;
        }

        public Entry<V> firstEntry() {
            Entry<V> e;
            if (Char2ReferenceAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = Char2ReferenceAVLTreeMap.this.firstEntry;
            } else {
                e = Char2ReferenceAVLTreeMap.this.locateKey(this.from);
                if (Char2ReferenceAVLTreeMap.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || Char2ReferenceAVLTreeMap.this.compare(e.key, this.f1412to) < 0) {
                return e;
            }
            return null;
        }

        public Entry<V> lastEntry() {
            Entry<V> e;
            if (Char2ReferenceAVLTreeMap.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = Char2ReferenceAVLTreeMap.this.lastEntry;
            } else {
                e = Char2ReferenceAVLTreeMap.this.locateKey(this.f1412to);
                if (Char2ReferenceAVLTreeMap.this.compare(e.key, this.f1412to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || Char2ReferenceAVLTreeMap.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char firstCharKey() {
            Entry<V> e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap
        public char lastCharKey() {
            Entry<V> e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$Submap$SubmapIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$Submap$SubmapIterator.class */
        public class SubmapIterator extends Char2ReferenceAVLTreeMap<V>.TreeIterator {
            SubmapIterator() {
                super();
                this.next = Submap.this.firstEntry();
            }

            SubmapIterator(Submap submap, char k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (submap.bottom || Char2ReferenceAVLTreeMap.this.compare(k, this.next.key) >= 0) {
                    if (!submap.top) {
                        Char2ReferenceAVLTreeMap char2ReferenceAVLTreeMap = Char2ReferenceAVLTreeMap.this;
                        Entry<V> lastEntry = submap.lastEntry();
                        this.prev = lastEntry;
                        if (char2ReferenceAVLTreeMap.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = Char2ReferenceAVLTreeMap.this.locateKey(k);
                    if (Char2ReferenceAVLTreeMap.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.TreeIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Submap.this.bottom && this.prev != null && Char2ReferenceAVLTreeMap.this.compare(this.prev.key, Submap.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap.TreeIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Submap.this.top && this.next != null && Char2ReferenceAVLTreeMap.this.compare(this.next.key, Submap.this.f1412to) >= 0) {
                    this.next = null;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$Submap$SubmapEntryIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$Submap$SubmapEntryIterator.class */
        public class SubmapEntryIterator extends Char2ReferenceAVLTreeMap<V>.Submap.SubmapIterator implements ObjectListIterator<Char2ReferenceMap.Entry<V>> {
            SubmapEntryIterator() {
                super();
            }

            SubmapEntryIterator(char k) {
                super(Submap.this, k);
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public Char2ReferenceMap.Entry<V> next() {
                return nextEntry();
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public Char2ReferenceMap.Entry<V> previous() {
                return previousEntry();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$Submap$SubmapKeyIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$Submap$SubmapKeyIterator.class */
        public final class SubmapKeyIterator extends Char2ReferenceAVLTreeMap<V>.Submap.SubmapIterator implements CharListIterator {
            public SubmapKeyIterator() {
                super();
            }

            public SubmapKeyIterator(char from) {
                super(Submap.this, from);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
            public char nextChar() {
                return nextEntry().key;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
            public char previousChar() {
                return previousEntry().key;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceAVLTreeMap$Submap$SubmapValueIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceAVLTreeMap$Submap$SubmapValueIterator.class */
        public final class SubmapValueIterator extends Char2ReferenceAVLTreeMap<V>.Submap.SubmapIterator implements ObjectListIterator<V> {
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
    public Char2ReferenceAVLTreeMap<V> clone() {
        try {
            Char2ReferenceAVLTreeMap<V> c = (Char2ReferenceAVLTreeMap) clone();
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
        Char2ReferenceAVLTreeMap<V>.EntryIterator i = new EntryIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                Entry<V> e = i.nextEntry();
                s.writeChar(e.key);
                s.writeObject(e.value);
            } else {
                return;
            }
        }
    }

    private Entry<V> readTree(ObjectInputStream s, int n, Entry<V> pred, Entry<V> succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry<V> top = new Entry<>(s.readChar(), s.readObject());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry<V> top2 = new Entry<>(s.readChar(), s.readObject());
            top2.right(new Entry<>(s.readChar(), s.readObject()));
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
            top3.key = s.readChar();
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
