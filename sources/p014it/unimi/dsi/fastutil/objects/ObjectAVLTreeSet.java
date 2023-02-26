package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectAVLTreeSet.class */
public class ObjectAVLTreeSet<K> extends AbstractObjectSortedSet<K> implements Serializable, Cloneable, ObjectSortedSet<K> {
    protected transient Entry<K> tree;
    protected int count;
    protected transient Entry<K> firstEntry;
    protected transient Entry<K> lastEntry;
    protected Comparator<? super K> storedComparator;
    protected transient Comparator<? super K> actualComparator;
    private static final long serialVersionUID = -7046029254386353130L;
    private transient boolean[] dirPath;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ObjectAVLTreeSet.class.desiredAssertionStatus();
    }

    public ObjectAVLTreeSet() {
        allocatePaths();
        this.tree = null;
        this.count = 0;
    }

    private void setActualComparator() {
        this.actualComparator = this.storedComparator;
    }

    public ObjectAVLTreeSet(Comparator<? super K> c) {
        this();
        this.storedComparator = c;
        setActualComparator();
    }

    public ObjectAVLTreeSet(Collection<? extends K> c) {
        this();
        addAll(c);
    }

    public ObjectAVLTreeSet(SortedSet<K> s) {
        this(s.comparator());
        addAll(s);
    }

    public ObjectAVLTreeSet(ObjectCollection<? extends K> c) {
        this();
        addAll(c);
    }

    public ObjectAVLTreeSet(ObjectSortedSet<K> s) {
        this(s.comparator());
        addAll(s);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectAVLTreeSet(Iterator<? extends K> i) {
        allocatePaths();
        while (i.hasNext()) {
            add(i.next());
        }
    }

    public ObjectAVLTreeSet(K[] a, int offset, int length, Comparator<? super K> c) {
        this(c);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ObjectAVLTreeSet(K[] a, int offset, int length) {
        this(a, offset, length, null);
    }

    public ObjectAVLTreeSet(K[] a) {
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

    public ObjectAVLTreeSet(K[] a, Comparator<? super K> c) {
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

    final int compare(K k1, K k2) {
        return this.actualComparator == null ? ((Comparable) k1).compareTo(k2) : this.actualComparator.compare(k1, k2);
    }

    private Entry<K> findKey(K k) {
        int cmp;
        Entry<K> e = this.tree;
        while (e != null && (cmp = compare(k, e.key)) != 0) {
            e = cmp < 0 ? e.left() : e.right();
        }
        return e;
    }

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

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0359, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x035d, code lost:
        if (r12 != null) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0360, code lost:
        r7.tree = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0370, code lost:
        if (r12.left != r11) goto L_0x037d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0373, code lost:
        r12.left = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x037d, code lost:
        r12.right = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0384, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0115, code lost:
        r9 = r11;
        r16 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x011e, code lost:
        if (r9 == r13) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0128, code lost:
        if (r7.dirPath[r16] == false) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x012b, code lost:
        r9.incBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0132, code lost:
        r9.decBalance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0136, code lost:
        r16 = r16 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0140, code lost:
        if (r7.dirPath[r16] == false) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0143, code lost:
        r0 = r9.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014a, code lost:
        r0 = r9.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0159, code lost:
        if (r11.balance() != -2) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015c, code lost:
        r0 = r11.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0169, code lost:
        if (r0.balance() != -1) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016c, code lost:
        r14 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0175, code lost:
        if (r0.succ() == false) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0178, code lost:
        r0.succ(false);
        r11.pred(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0188, code lost:
        r11.left = r0.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0192, code lost:
        r0.right = r11;
        r0.balance(0);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01ab, code lost:
        if (p014it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet.$assertionsDisabled != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b4, code lost:
        if (r0.balance() == 1) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01be, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01bf, code lost:
        r14 = r0.right;
        r0.right = r14.left;
        r14.left = r0;
        r11.left = r14.right;
        r14.right = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01ee, code lost:
        if (r14.balance() != -1) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f1, code lost:
        r0.balance(0);
        r11.balance(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0205, code lost:
        if (r14.balance() != 0) goto L_0x0217;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0208, code lost:
        r0.balance(0);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0217, code lost:
        r0.balance(-1);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0223, code lost:
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x022e, code lost:
        if (r14.pred() == false) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0231, code lost:
        r0.succ(r14);
        r14.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0243, code lost:
        if (r14.succ() == false) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0246, code lost:
        r11.pred(r14);
        r14.succ(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x025c, code lost:
        if (r11.balance() != 2) goto L_0x0359;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025f, code lost:
        r0 = r11.right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x026c, code lost:
        if (r0.balance() != 1) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x026f, code lost:
        r14 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0278, code lost:
        if (r0.pred() == false) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027b, code lost:
        r0.pred(false);
        r11.succ(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x028b, code lost:
        r11.right = r0.left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0295, code lost:
        r0.left = r11;
        r0.balance(0);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02ae, code lost:
        if (p014it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet.$assertionsDisabled != false) goto L_0x02c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b7, code lost:
        if (r0.balance() == -1) goto L_0x02c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c1, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c2, code lost:
        r14 = r0.left;
        r0.left = r14.right;
        r14.right = r0;
        r11.right = r14.left;
        r14.left = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02f1, code lost:
        if (r14.balance() != 1) goto L_0x0303;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02f4, code lost:
        r0.balance(0);
        r11.balance(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0308, code lost:
        if (r14.balance() != 0) goto L_0x031a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x030b, code lost:
        r0.balance(0);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x031a, code lost:
        r0.balance(1);
        r11.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0326, code lost:
        r14.balance(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0331, code lost:
        if (r14.pred() == false) goto L_0x0341;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0334, code lost:
        r11.succ(r14);
        r14.pred(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0346, code lost:
        if (r14.succ() == false) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0349, code lost:
        r0.pred(r14);
        r14.succ(false);
     */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(K r8) {
        /*
        // Method dump skipped, instructions count: 902
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet.add(java.lang.Object):boolean");
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

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object k) {
        Entry<K> s;
        if (this.tree == null) {
            return false;
        }
        Entry<K> p = this.tree;
        Entry<K> q = null;
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
                    Entry<K> r = p.right;
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
                            Entry<K> x = q.left;
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
                                Entry<K> w = x.right;
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
                            Entry<K> x2 = q.right;
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
                                Entry<K> w2 = x2.left;
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
                Entry<K> right = p.right();
                p = right;
                if (right == null) {
                    return false;
                }
            } else {
                q = p;
                Entry<K> left = p.left();
                p = left;
                if (left == null) {
                    return false;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object k) {
        return findKey(k) != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public K get(Object k) {
        Entry<K> entry = findKey(k);
        if (entry == null) {
            return null;
        }
        return entry.key;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.count = 0;
        this.tree = null;
        this.lastEntry = null;
        this.firstEntry = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectAVLTreeSet$Entry.class */
    public static final class Entry<K> implements Cloneable {
        private static final int SUCC_MASK = Integer.MIN_VALUE;
        private static final int PRED_MASK = 1073741824;
        private static final int BALANCE_MASK = 255;
        K key;
        Entry<K> left;
        Entry<K> right;
        int info;

        Entry() {
        }

        Entry(K k) {
            this.key = k;
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

        @Override // java.lang.Object
        public Entry<K> clone() {
            try {
                Entry<K> c = (Entry) clone();
                c.key = this.key;
                c.info = this.info;
                return c;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            return Objects.equals(this.key, ((Entry) o).key);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.key.hashCode();
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

    @Override // java.util.SortedSet
    public K first() {
        if (this.tree != null) {
            return this.firstEntry.key;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public K last() {
        if (this.tree != null) {
            return this.lastEntry.key;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectAVLTreeSet$SetIterator.class */
    public class SetIterator implements ObjectListIterator<K> {
        Entry<K> prev;
        Entry<K> next;
        Entry<K> curr;
        int index = 0;

        SetIterator() {
            this.next = ObjectAVLTreeSet.this.firstEntry;
        }

        SetIterator(K k) {
            Entry<K> locateKey = ObjectAVLTreeSet.this.locateKey(k);
            this.next = locateKey;
            if (locateKey == null) {
                return;
            }
            if (ObjectAVLTreeSet.this.compare(this.next.key, k) <= 0) {
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

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return nextEntry().key;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return previousEntry().key;
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

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
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
            ObjectAVLTreeSet.this.remove(this.curr.key);
            this.curr = null;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    public ObjectBidirectionalIterator<K> iterator() {
        return new SetIterator();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
    public ObjectBidirectionalIterator<K> iterator(K from) {
        return new SetIterator(from);
    }

    @Override // java.util.SortedSet
    public Comparator<? super K> comparator() {
        return this.actualComparator;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
    public ObjectSortedSet<K> headSet(K to) {
        return new Subset(null, true, to, false);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
    public ObjectSortedSet<K> tailSet(K from) {
        return new Subset(from, false, null, true);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
    public ObjectSortedSet<K> subSet(K from, K to) {
        return new Subset(from, false, to, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet$Subset */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectAVLTreeSet$Subset.class */
    public final class Subset extends AbstractObjectSortedSet<K> implements Serializable, ObjectSortedSet<K> {
        private static final long serialVersionUID = -7046029254386353129L;
        K from;

        /* renamed from: to */
        K f2644to;
        boolean bottom;
        boolean top;

        public Subset(K from, boolean bottom, K to, boolean top) {
            if (bottom || top || ObjectAVLTreeSet.this.compare(from, to) <= 0) {
                this.from = from;
                this.bottom = bottom;
                this.f2644to = to;
                this.top = top;
                return;
            }
            throw new IllegalArgumentException("Start element (" + from + ") is larger than end element (" + to + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ObjectAVLTreeSet<K>.Subset.SubsetIterator i = new SubsetIterator();
            while (i.hasNext()) {
                i.next();
                i.remove();
            }
        }

        /* renamed from: in */
        final boolean m586in(K k) {
            return (this.bottom || ObjectAVLTreeSet.this.compare(k, this.from) >= 0) && (this.top || ObjectAVLTreeSet.this.compare(k, this.f2644to) < 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object k) {
            return m586in(k) && ObjectAVLTreeSet.this.contains(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(K k) {
            if (m586in(k)) {
                return ObjectAVLTreeSet.this.add(k);
            }
            throw new IllegalArgumentException("Element (" + k + ") out of range [" + (this.bottom ? "-" : String.valueOf(this.from)) + ", " + (this.top ? "-" : String.valueOf(this.f2644to)) + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object k) {
            if (!m586in(k)) {
                return false;
            }
            return ObjectAVLTreeSet.this.remove(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            ObjectAVLTreeSet<K>.Subset.SubsetIterator i = new SubsetIterator();
            int n = 0;
            while (i.hasNext()) {
                n++;
                i.next();
            }
            return n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !new SubsetIterator().hasNext();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return ObjectAVLTreeSet.this.actualComparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
        public ObjectBidirectionalIterator<K> iterator() {
            return new SubsetIterator();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet
        public ObjectBidirectionalIterator<K> iterator(K from) {
            return new SubsetIterator(this, from);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> headSet(K to) {
            if (!this.top && ObjectAVLTreeSet.this.compare(to, this.f2644to) >= 0) {
                return this;
            }
            return new Subset(this.from, this.bottom, to, false);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> tailSet(K from) {
            if (!this.bottom && ObjectAVLTreeSet.this.compare(from, this.from) <= 0) {
                return this;
            }
            return new Subset(from, false, this.f2644to, this.top);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSortedSet, java.util.SortedSet
        public ObjectSortedSet<K> subSet(K from, K to) {
            if (this.top && this.bottom) {
                return new Subset(from, false, to, false);
            }
            if (!this.top) {
                to = ObjectAVLTreeSet.this.compare(to, this.f2644to) < 0 ? to : this.f2644to;
            }
            if (!this.bottom) {
                from = ObjectAVLTreeSet.this.compare(from, this.from) > 0 ? from : this.from;
            }
            return (this.top || this.bottom || from != this.from || to != this.f2644to) ? new Subset(from, false, to, false) : this;
        }

        public Entry<K> firstEntry() {
            Entry<K> e;
            if (ObjectAVLTreeSet.this.tree == null) {
                return null;
            }
            if (this.bottom) {
                e = ObjectAVLTreeSet.this.firstEntry;
            } else {
                e = ObjectAVLTreeSet.this.locateKey(this.from);
                if (ObjectAVLTreeSet.this.compare(e.key, this.from) < 0) {
                    e = e.next();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.top || ObjectAVLTreeSet.this.compare(e.key, this.f2644to) < 0) {
                return e;
            }
            return null;
        }

        public Entry<K> lastEntry() {
            Entry<K> e;
            if (ObjectAVLTreeSet.this.tree == null) {
                return null;
            }
            if (this.top) {
                e = ObjectAVLTreeSet.this.lastEntry;
            } else {
                e = ObjectAVLTreeSet.this.locateKey(this.f2644to);
                if (ObjectAVLTreeSet.this.compare(e.key, this.f2644to) >= 0) {
                    e = e.prev();
                }
            }
            if (e == null) {
                return null;
            }
            if (this.bottom || ObjectAVLTreeSet.this.compare(e.key, this.from) >= 0) {
                return e;
            }
            return null;
        }

        @Override // java.util.SortedSet
        public K first() {
            Entry<K> e = firstEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedSet
        public K last() {
            Entry<K> e = lastEntry();
            if (e != null) {
                return e.key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet$Subset$SubsetIterator */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectAVLTreeSet$Subset$SubsetIterator.class */
        public final class SubsetIterator extends ObjectAVLTreeSet<K>.SetIterator {
            SubsetIterator() {
                super();
                this.next = Subset.this.firstEntry();
            }

            SubsetIterator(Subset subset, K k) {
                this();
                if (this.next == null) {
                    return;
                }
                if (subset.bottom || ObjectAVLTreeSet.this.compare(k, this.next.key) >= 0) {
                    if (!subset.top) {
                        ObjectAVLTreeSet objectAVLTreeSet = ObjectAVLTreeSet.this;
                        Entry<K> lastEntry = subset.lastEntry();
                        this.prev = lastEntry;
                        if (objectAVLTreeSet.compare(k, lastEntry.key) >= 0) {
                            this.next = null;
                            return;
                        }
                    }
                    this.next = ObjectAVLTreeSet.this.locateKey(k);
                    if (ObjectAVLTreeSet.this.compare(this.next.key, k) <= 0) {
                        this.prev = this.next;
                        this.next = this.next.next();
                        return;
                    }
                    this.prev = this.next.prev();
                    return;
                }
                this.prev = null;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet.SetIterator
            void updatePrevious() {
                this.prev = this.prev.prev();
                if (!Subset.this.bottom && this.prev != null && ObjectAVLTreeSet.this.compare(this.prev.key, Subset.this.from) < 0) {
                    this.prev = null;
                }
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet.SetIterator
            void updateNext() {
                this.next = this.next.next();
                if (!Subset.this.top && this.next != null && ObjectAVLTreeSet.this.compare(this.next.key, Subset.this.f2644to) >= 0) {
                    this.next = null;
                }
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            ObjectAVLTreeSet<K> c = (ObjectAVLTreeSet) clone();
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
        ObjectAVLTreeSet<K>.SetIterator i = new SetIterator();
        s.defaultWriteObject();
        while (true) {
            n--;
            if (n != 0) {
                s.writeObject(i.next());
            } else {
                return;
            }
        }
    }

    private Entry<K> readTree(ObjectInputStream s, int n, Entry<K> pred, Entry<K> succ) throws IOException, ClassNotFoundException {
        if (n == 1) {
            Entry<K> top = new Entry<>(s.readObject());
            top.pred(pred);
            top.succ(succ);
            return top;
        } else if (n == 2) {
            Entry<K> top2 = new Entry<>(s.readObject());
            top2.right(new Entry<>(s.readObject()));
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
            top3.key = (K) s.readObject();
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
