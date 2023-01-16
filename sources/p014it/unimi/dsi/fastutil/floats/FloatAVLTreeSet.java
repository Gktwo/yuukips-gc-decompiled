package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.HashCommon;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatAVLTreeSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatAVLTreeSet.class */
public class FloatAVLTreeSet extends AbstractFloatSortedSet implements Serializable, Cloneable, FloatSortedSet {
    protected transient Entry tree;
    protected int count;
    protected transient Entry firstEntry;
    protected transient Entry lastEntry;
    protected Comparator<? super Float> storedComparator;
    protected transient FloatComparator actualComparator;
    private static final long serialVersionUID = -7046029254386353130L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !FloatAVLTreeSet.class.desiredAssertionStatus();
    }

    public FloatAVLTreeSet() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = FloatComparators.asFloatComparator(this.storedComparator);
    }

    public FloatAVLTreeSet(Comparator<? super Float> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public FloatAVLTreeSet(Collection<? extends Float> c) {
        this();
        addAll(c);
    }

    public FloatAVLTreeSet(SortedSet<Float> s) {
        this(s.comparator());
        addAll(s);
    }

    public FloatAVLTreeSet(FloatCollection c) {
        this();
        addAll(c);
    }

    public FloatAVLTreeSet(FloatSortedSet s) {
        this(s.comparator());
        addAll((FloatCollection) s);
    }

    public FloatAVLTreeSet(FloatIterator i) {
        allocatePaths();
        while (i.hasNext()) {
            add(i.nextFloat());
        }
    }

    public FloatAVLTreeSet(Iterator<?> i) {
        this(FloatIterators.asFloatIterator(i));
    }

    public FloatAVLTreeSet(float[] a, int offset, int length, Comparator<? super Float> c) {
        this(c);
        FloatArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public FloatAVLTreeSet(float[] a, int offset, int length) {
        this(a, offset, length, null);
    }

    public FloatAVLTreeSet(float[] a) {
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

    public FloatAVLTreeSet(float[] a, Comparator<? super Float> c) {
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

    final int compare(float k1, float k2) {
        return this.actualComparator == null ? Float.compare(k1, k2) : this.actualComparator.compare(k1, k2);
    }

    private Entry findKey(float k) {
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
        this.dirPath = new boolean[48];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0354, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0358, code lost:
        if (r12 != null) goto L_0x0364;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x035b, code lost:
        r7.tree = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x036b, code lost:
        if (r12.left != r11) goto L_0x0378;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x036e, code lost:
        r12.left = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0378, code lost:
        r12.right = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x037f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0110, code lost:
        r9 = r11;
        r16 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0119, code lost:
        if (r9 == r13) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0123, code lost:
        if (r7.dirPath[r16] == false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0126, code lost:
        r9.incBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x012d, code lost:
        r9.decBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0131, code lost:
        r16 = r16 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x013b, code lost:
        if (r7.dirPath[r16] == false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x013e, code lost:
        r0 = r9.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0145, code lost:
        r0 = r9.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0154, code lost:
        if (r11.balance() != -2) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0157, code lost:
        r0 = r11.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0164, code lost:
        if (r0.balance() != -1) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0167, code lost:
        r14 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0170, code lost:
        if (r0.succ() == false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0173, code lost:
        r0.succ(false);
        r11.pred(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0183, code lost:
        r11.left = r0.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x018d, code lost:
        r0.right = r11;
        r0.balance(0);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a6, code lost:
        if (p014it.unimi.dsi.fastutil.floats.FloatAVLTreeSet.$assertionsDisabled != false) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01af, code lost:
        if (r0.balance() == 1) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b9, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ba, code lost:
        r14 = r0.right;
        r0.right = r14.left;
        r14.left = r0;
        r11.left = r14.right;
        r14.right = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e9, code lost:
        if (r14.balance() != -1) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ec, code lost:
        r0.balance(0);
        r11.balance(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0200, code lost:
        if (r14.balance() != 0) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0203, code lost:
        r0.balance(0);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0212, code lost:
        r0.balance(-1);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x021e, code lost:
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0229, code lost:
        if (r14.pred() == false) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x022c, code lost:
        r0.succ(r14);
        r14.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x023e, code lost:
        if (r14.succ() == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0241, code lost:
        r11.pred(r14);
        r14.succ(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0257, code lost:
        if (r11.balance() != 2) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025a, code lost:
        r0 = r11.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0267, code lost:
        if (r0.balance() != 1) goto L_0x02a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x026a, code lost:
        r14 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0273, code lost:
        if (r0.pred() == false) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0276, code lost:
        r0.pred(false);
        r11.succ(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0286, code lost:
        r11.right = r0.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0290, code lost:
        r0.left = r11;
        r0.balance(0);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02a9, code lost:
        if (p014it.unimi.dsi.fastutil.floats.FloatAVLTreeSet.$assertionsDisabled != false) goto L_0x02bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b2, code lost:
        if (r0.balance() == -1) goto L_0x02bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02bc, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02bd, code lost:
        r14 = r0.left;
        r0.left = r14.right;
        r14.right = r0;
        r11.right = r14.left;
        r14.left = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02ec, code lost:
        if (r14.balance() != 1) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02ef, code lost:
        r0.balance(0);
        r11.balance(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0303, code lost:
        if (r14.balance() != 0) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0306, code lost:
        r0.balance(0);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0315, code lost:
        r0.balance(1);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0321, code lost:
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x032c, code lost:
        if (r14.pred() == false) goto L_0x033c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x032f, code lost:
        r11.succ(r14);
        r14.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0341, code lost:
        if (r14.succ() == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0344, code lost:
        r0.pred(r14);
        r14.succ(false);
     */
    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(float r8) {
        /*
        // Method dump skipped, instructions count: 897
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatAVLTreeSet.add(float):boolean");
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
    public boolean remove(float k) {
        Entry s;
        if (this.tree == null) {
            return false;
        }
        Entry p = this.tree;
        Entry q = null;
        boolean dir = false;
        while (true) {
            int cmp = compare(k, p.key);
            if (cmp == 0) {
                if (p.left == null) {
                    this.firstEntry = p.next();
                }
                if (p.right == null) {
                    this.lastEntry = p.prev();
                }
                if (!p.succ()) {
                    Entry r = p.right;
                    if (r.pred()) {
                        r.left = p.left;
                        r.pred(p.pred());
                        if (!r.pred()) {
                            r.prev().right = r;
                        }
                        if (q == null) {
                            this.tree = r;
                        } else if (dir) {
                            q.right = r;
                        } else {
                            q.left = r;
                        }
                        r.balance(p.balance());
                        q = r;
                        dir = true;
                    } else {
                        while (true) {
                            s = r.left;
                            if (s.pred()) {
                                break;
                            }
                            r = s;
                        }
                        if (s.succ()) {
                            r.pred(s);
                        } else {
                            r.left = s.right;
                        }
                        s.left = p.left;
                        if (!p.pred()) {
                            p.prev().right = s;
                            s.pred(false);
                        }
                        s.right = p.right;
                        s.succ(false);
                        if (q == null) {
                            this.tree = s;
                        } else if (dir) {
                            q.right = s;
                        } else {
                            q.left = s;
                        }
                        s.balance(p.balance());
                        q = r;
                        dir = false;
                    }
                } else if (!p.pred()) {
                    p.prev().right = p.right;
                    if (q == null) {
                        this.tree = p.left;
                    } else if (dir) {
                        q.right = p.left;
                    } else {
                        q.left = p.left;
                    }
                } else if (q == null) {
                    this.tree = dir ? p.right : p.left;
                } else if (dir) {
                    q.succ(p.right);
                } else {
                    q.pred(p.left);
                }
                while (true) {
                    if (q == null) {
                        break;
                    }
                    q = parent(q);
                    if (dir) {
                        dir = (q == null || q.left == q) ? false : true;
                        q.decBalance();
                        if (q.balance() == -1) {
                            break;
                        } else if (q.balance() == -2) {
                            Entry x = q.left;
                            if (!$assertionsDisabled && x == null) {
                                throw new AssertionError();
                            } else if (x.balance() != 1) {
                                if (q == null) {
                                    this.tree = x;
                                } else if (dir) {
                                    q.right = x;
                                } else {
                                    q.left = x;
                                }
                                if (x.balance() == 0) {
                                    q.left = x.right;
                                    x.right = q;
                                    x.balance(1);
                                    q.balance(-1);
                                    break;
                                } else if ($assertionsDisabled || x.balance() == -1) {
                                    if (x.succ()) {
                                        q.pred(true);
                                        x.succ(false);
                                    } else {
                                        q.left = x.right;
                                    }
                                    x.right = q;
                                    q.balance(0);
                                    x.balance(0);
                                } else {
                                    throw new AssertionError();
                                }
                            } else if ($assertionsDisabled || x.balance() == 1) {
                                Entry w = x.right;
                                x.right = w.left;
                                w.left = x;
                                q.left = w.right;
                                w.right = q;
                                if (w.balance() == -1) {
                                    x.balance(0);
                                    q.balance(1);
                                } else if (w.balance() == 0) {
                                    x.balance(0);
                                    q.balance(0);
                                } else if ($assertionsDisabled || w.balance() == 1) {
                                    x.balance(-1);
                                    q.balance(0);
                                } else {
                                    throw new AssertionError();
                                }
                                w.balance(0);
                                if (w.pred()) {
                                    x.succ(w);
                                    w.pred(false);
                                }
                                if (w.succ()) {
                                    q.pred(w);
                                    w.succ(false);
                                }
                                if (q == null) {
                                    this.tree = w;
                                } else if (dir) {
                                    q.right = w;
                                } else {
                                    q.left = w;
                                }
                            } else {
                                throw new AssertionError();
                            }
                        } else {
                            continue;
                        }
                    } else {
                        dir = (q == null || q.left == q) ? false : true;
                        q.incBalance();
                        if (q.balance() == 1) {
                            break;
                        } else if (q.balance() == 2) {
                            Entry x2 = q.right;
                            if (!$assertionsDisabled && x2 == null) {
                                throw new AssertionError();
                            } else if (x2.balance() != -1) {
                                if (q == null) {
                                    this.tree = x2;
                                } else if (dir) {
                                    q.right = x2;
                                } else {
                                    q.left = x2;
                                }
                                if (x2.balance() == 0) {
                                    q.right = x2.left;
                                    x2.left = q;
                                    x2.balance(-1);
                                    q.balance(1);
                                    break;
                                } else if ($assertionsDisabled || x2.balance() == 1) {
                                    if (x2.pred()) {
                                        q.succ(true);
                                        x2.pred(false);
                                    } else {
                                        q.right = x2.left;
                                    }
                                    x2.left = q;
                                    q.balance(0);
                                    x2.balance(0);
                                } else {
                                    throw new AssertionError();
                                }
                            } else if ($assertionsDisabled || x2.balance() == -1) {
                                Entry w2 = x2.left;
                                x2.left = w2.right;
                                w2.right = x2;
                                q.right = w2.left;
                                w2.left = q;
                                if (w2.balance() == 1) {
                                    x2.balance(0);
                                    q.balance(-1);
                                } else if (w2.balance() == 0) {
                                    x2.balance(0);
                                    q.balance(0);
                                } else if ($assertionsDisabled || w2.balance() == -1) {
                                    x2.balance(1);
                                    q.balance(0);
                                } else {
                                    throw new AssertionError();
                                }
                                w2.balance(0);
                                if (w2.pred()) {
                                    q.succ(w2);
                                    w2.pred(false);
                                }
                                if (w2.succ()) {
                                    x2.pred(w2);
                                    w2.succ(false);
                                }
                                if (q == null) {
                                    this.tree = w2;
                                } else if (dir) {
                                    q.right = w2;
                                } else {
                                    q.left = w2;
                                }
                            } else {
                                throw new AssertionError();
                            }
                        } else {
                            continue;
                        }
                    }
                }
                this.count--;
                return true;
            }
            boolean z = cmp > 0;
            dir = z;
            if (z) {
                q = p;
                Entry right = p.right();
                p = right;
                if (right == null) {
                    return false;
                }
            } else {
                q = p;
                Entry left = p.left();
                p = left;
                if (left == null) {
                    return false;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean contains(float k) {
        return findKey(k) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.count = 0;
        this.tree = null;
        this.lastEntry = null;
        this.firstEntry = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatAVLTreeSet$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatAVLTreeSet$Entry.class */
    public static final class Entry implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        float key;
        Entry left;
        Entry right;
        int info;

        Entry() {
        }

        Entry(float k) {
            this.key = k;
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

        @Override // java.lang.Object
        public Entry clone() {
            try {
                Entry c = (Entry) clone();
                c.key = this.key;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Entry) && Float.floatToIntBits(this.key) == Float.floatToIntBits(((Entry) o).key);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return HashCommon.float2int(this.key);
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

    @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
    public float firstFloat() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
    public float lastFloat() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatAVLTreeSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatAVLTreeSet$SetIterator.class */
    public class SetIterator implements FloatListIterator {
        Entry prev;
        Entry next;
        Entry curr;
        int index = 0;

        SetIterator() {
            this.next = FloatAVLTreeSet.this.firstEntry;
        }

        SetIterator(float k) {
            Entry locateKey = FloatAVLTreeSet.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (FloatAVLTreeSet.this.compare(this.next.key, k) <= 0) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return previousEntry().key;
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

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator, java.util.Iterator, java.util.ListIterator
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
            FloatAVLTreeSet.this.remove(this.curr.key);
            this.curr = null;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatBidirectionalIterator iterator() {
        return new SetIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
    public FloatBidirectionalIterator iterator(float from) {
        return new SetIterator(from);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
    public Comparator<? super Float> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
    public FloatSortedSet headSet(float to) {
        return new Subset(0.0f, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
    public FloatSortedSet tailSet(float from) {
        return new Subset(from, false, 0.0f, true);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
    public FloatSortedSet subSet(float from, float to) {
        return new Subset(from, false, to, false);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatAVLTreeSet$Subset */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatAVLTreeSet$Subset.class */
    private final class Subset extends AbstractFloatSortedSet implements Serializable, FloatSortedSet {
        private static final long serialVersionUID = -7046029254386353129L;
        float from;

        /* renamed from: to */
        float f1920to;
        boolean bottom;
        boolean top;

        public Subset(float from, boolean bottom, float to, boolean top) {
            if (bottom || top || FloatAVLTreeSet.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f1920to = to;
                this.top = top;
                return;
            }
            throw new IllegalArgumentException("Start element (" + from + ") is larger than end element (" + to + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SubsetIterator i = new SubsetIterator();
            while (i.hasNext()) {
                i.nextFloat();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m840in(float k) {
            return (this.bottom || FloatAVLTreeSet.this.compare(k, this.from) >= 0) && (this.top || FloatAVLTreeSet.this.compare(k, this.f1920to) < 0);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean contains(float k) {
            return m840in(k) && FloatAVLTreeSet.this.contains(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
        public boolean add(float k) {
            if (m840in(k)) {
                return FloatAVLTreeSet.this.add(k);
            }
            throw new IllegalArgumentException("Element (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f1920to)) + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
        public boolean remove(float k) {
            if (!m840in(k)) {
                return false;
            }
            return FloatAVLTreeSet.this.remove(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            SubsetIterator i = new SubsetIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.nextFloat();
            }
            return n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !new SubsetIterator().hasNext();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet, java.util.SortedSet
        public Comparator<? super Float> comparator() {
            return FloatAVLTreeSet.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSortedSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
        public FloatBidirectionalIterator iterator() {
            return new SubsetIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatBidirectionalIterator iterator(float from) {
            return new SubsetIterator(this, from);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet headSet(float to) {
            if (!this.top && FloatAVLTreeSet.this.compare(to, this.f1920to) >= 0) {
                return this;
            }
            return new Subset(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet tailSet(float from) {
            if (!this.bottom && FloatAVLTreeSet.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Subset(from, false, this.f1920to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public FloatSortedSet subSet(float from, float to) {
            if (this.top && this.bottom) {
                return new Subset(from, false, to, false);
            }
            if (!this.top) {
                to = FloatAVLTreeSet.this.compare(to, this.f1920to) < 0 ? to : this.f1920to;
            }
            if (!this.bottom) {
                from = FloatAVLTreeSet.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f1920to) ? new Subset(from, false, to, false) : this;
        }

        public Entry firstEntry() {
            Entry e;
            if (FloatAVLTreeSet.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = FloatAVLTreeSet.this.firstEntry;
            } else {
                e = FloatAVLTreeSet.this.locateKey(this.from);
                if (FloatAVLTreeSet.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || FloatAVLTreeSet.this.compare(e.key, this.f1920to) < 0) {
                return e;
            }
            return null;
        }

        public Entry lastEntry() {
            Entry e;
            if (FloatAVLTreeSet.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = FloatAVLTreeSet.this.lastEntry;
            } else {
                e = FloatAVLTreeSet.this.locateKey(this.f1920to);
                if (FloatAVLTreeSet.this.compare(e.key, this.f1920to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || FloatAVLTreeSet.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float firstFloat() {
            Entry e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSortedSet
        public float lastFloat() {
            Entry e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.floats.FloatAVLTreeSet$Subset$SubsetIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatAVLTreeSet$Subset$SubsetIterator.class */
        public final class SubsetIterator extends SetIterator {
            SubsetIterator() {
                super();
                this.next = Subset.this.firstEntry();
            }

            SubsetIterator(Subset subset, float k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (subset.bottom || FloatAVLTreeSet.this.compare(k, this.next.key) >= 0) {
                    if (!subset.top) {
                        FloatAVLTreeSet floatAVLTreeSet = FloatAVLTreeSet.this;
                        Entry lastEntry = subset.lastEntry();
                        this.prev = lastEntry;
                        if (floatAVLTreeSet.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = FloatAVLTreeSet.this.locateKey(k);
                    if (FloatAVLTreeSet.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatAVLTreeSet.SetIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Subset.this.bottom && this.prev != null && FloatAVLTreeSet.this.compare(this.prev.key, Subset.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatAVLTreeSet.SetIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Subset.this.top && this.next != null && FloatAVLTreeSet.this.compare(this.next.key, Subset.this.f1920to) >= 0) {
                    this.next = null;
                }
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            FloatAVLTreeSet c = (FloatAVLTreeSet) clone();
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
        SetIterator i = new SetIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                s.writeFloat(i.nextFloat());
            } else {
                return;
            }
        }
    }

    private Entry readTree(ObjectInputStream s, int n, Entry pred, Entry succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry top = new Entry(s.readFloat());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry top2 = new Entry(s.readFloat());
            top2.right(new Entry(s.readFloat()));
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
            top3.key = s.readFloat();
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
