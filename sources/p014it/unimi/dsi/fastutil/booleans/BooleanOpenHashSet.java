package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanOpenHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanOpenHashSet.class */
public class BooleanOpenHashSet extends AbstractBooleanSet implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient boolean[] key;
    protected transient int mask;
    protected transient boolean containsNull;

    /* renamed from: n */
    protected transient int f1073n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1074f;

    public BooleanOpenHashSet(int expected, float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1074f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1073n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1073n - 1;
            this.maxFill = HashCommon.maxFill(this.f1073n, f);
            this.key = new boolean[this.f1073n + 1];
        }
    }

    public BooleanOpenHashSet(int expected) {
        this(expected, 0.75f);
    }

    public BooleanOpenHashSet() {
        this(16, 0.75f);
    }

    public BooleanOpenHashSet(Collection<? extends Boolean> c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public BooleanOpenHashSet(Collection<? extends Boolean> c) {
        this(c, 0.75f);
    }

    public BooleanOpenHashSet(BooleanCollection c, float f) {
        this(c.size(), f);
        addAll(c);
    }

    public BooleanOpenHashSet(BooleanCollection c) {
        this(c, 0.75f);
    }

    public BooleanOpenHashSet(BooleanIterator i, float f) {
        this(16, f);
        while (i.hasNext()) {
            add(i.nextBoolean());
        }
    }

    public BooleanOpenHashSet(BooleanIterator i) {
        this(i, 0.75f);
    }

    public BooleanOpenHashSet(Iterator<?> i, float f) {
        this(BooleanIterators.asBooleanIterator(i), f);
    }

    public BooleanOpenHashSet(Iterator<?> i) {
        this(BooleanIterators.asBooleanIterator(i));
    }

    public BooleanOpenHashSet(boolean[] a, int offset, int length, float f) {
        this(length < 0 ? 0 : length, f);
        BooleanArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public BooleanOpenHashSet(boolean[] a, int offset, int length) {
        this(a, offset, length, 0.75f);
    }

    public BooleanOpenHashSet(boolean[] a, float f) {
        this(a, 0, a.length, f);
    }

    public BooleanOpenHashSet(boolean[] a) {
        this(a, 0.75f);
    }

    /* renamed from: of */
    public static BooleanOpenHashSet m1131of() {
        return new BooleanOpenHashSet();
    }

    /* renamed from: of */
    public static BooleanOpenHashSet m1130of(boolean e) {
        BooleanOpenHashSet result = new BooleanOpenHashSet(1, 0.75f);
        result.add(e);
        return result;
    }

    /* renamed from: of */
    public static BooleanOpenHashSet m1129of(boolean e0, boolean e1) {
        BooleanOpenHashSet result = new BooleanOpenHashSet(2, 0.75f);
        result.add(e0);
        if (result.add(e1)) {
            return result;
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    public static BooleanOpenHashSet m1128of(boolean e0, boolean e1, boolean e2) {
        BooleanOpenHashSet result = new BooleanOpenHashSet(3, 0.75f);
        result.add(e0);
        if (!result.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (result.add(e2)) {
            return result;
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    public static BooleanOpenHashSet m1127of(boolean... a) {
        BooleanOpenHashSet result = new BooleanOpenHashSet(a.length, 0.75f);
        for (boolean element : a) {
            if (!result.add(element)) {
                throw new IllegalArgumentException("Duplicate element " + element);
            }
        }
        return result;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1074f);
        if (needed > this.f1073n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1074f)))));
        if (needed > this.f1073n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean addAll(BooleanCollection c) {
        if (((double) this.f1074f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Boolean> c) {
        if (((double) this.f1074f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean add(boolean k) {
        boolean curr;
        if (k) {
            boolean[] key = this.key;
            int i = (k ? 262886248 : -878682501) & this.mask;
            int pos = i;
            boolean curr2 = key[i];
            if (curr2) {
                if (curr2 == k) {
                    return false;
                }
                do {
                    int i2 = (pos + 1) & this.mask;
                    pos = i2;
                    curr = key[i2];
                    if (curr) {
                    }
                } while (curr != k);
                return false;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            this.containsNull = true;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size + 1, this.f1074f));
        return true;
    }

    protected final void shiftKeys(int pos) {
        boolean curr;
        boolean[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (!curr) {
                    key[pos] = false;
                    return;
                }
                int slot = (curr ? 262886248 : -878682501) & this.mask;
                if (pos > pos) {
                    if (pos >= slot && slot > pos) {
                        break;
                    }
                    i = pos + 1;
                    i2 = this.mask;
                } else if (pos < slot && slot <= pos) {
                    i = pos + 1;
                    i2 = this.mask;
                }
            }
            key[pos] = curr;
        }
    }

    private boolean removeEntry(int pos) {
        this.size--;
        shiftKeys(pos);
        if (this.f1073n <= this.minN || this.size >= this.maxFill / 4 || this.f1073n <= 16) {
            return true;
        }
        rehash(this.f1073n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f1073n] = false;
        this.size--;
        if (this.f1073n <= this.minN || this.size >= this.maxFill / 4 || this.f1073n <= 16) {
            return true;
        }
        rehash(this.f1073n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanSet, p014it.unimi.dsi.fastutil.booleans.BooleanSet
    public boolean remove(boolean k) {
        boolean curr;
        if (k) {
            boolean[] key = this.key;
            int i = (k ? 262886248 : -878682501) & this.mask;
            int pos = i;
            boolean curr2 = key[i];
            if (!curr2) {
                return false;
            }
            if (k == curr2) {
                return removeEntry(pos);
            }
            do {
                int i2 = (pos + 1) & this.mask;
                pos = i2;
                curr = key[i2];
                if (!curr) {
                    return false;
                }
            } while (k != curr);
            return removeEntry(pos);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
    public boolean contains(boolean k) {
        boolean curr;
        if (!k) {
            return this.containsNull;
        }
        boolean[] key = this.key;
        int i = (k ? 262886248 : -878682501) & this.mask;
        int pos = i;
        boolean curr2 = key[i];
        if (!curr2) {
            return false;
        }
        if (k == curr2) {
            return true;
        }
        do {
            int i2 = (pos + 1) & this.mask;
            pos = i2;
            curr = key[i2];
            if (!curr) {
                return false;
            }
        } while (k != curr);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, false);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanOpenHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanOpenHashSet$SetIterator.class */
    public final class SetIterator implements BooleanIterator {
        int pos;
        int last;

        /* renamed from: c */
        int f1075c;
        boolean mustReturnNull;
        BooleanArrayList wrapped;

        private SetIterator() {
            this.pos = BooleanOpenHashSet.this.f1073n;
            this.last = -1;
            this.f1075c = BooleanOpenHashSet.this.size;
            this.mustReturnNull = BooleanOpenHashSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1075c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1075c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = BooleanOpenHashSet.this.f1073n;
                return BooleanOpenHashSet.this.key[BooleanOpenHashSet.this.f1073n];
            }
            boolean[] key = BooleanOpenHashSet.this.key;
            do {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    return this.wrapped.getBoolean((-this.pos) - 1);
                }
            } while (!key[this.pos]);
            int i2 = this.pos;
            this.last = i2;
            return key[i2];
        }

        private final void shiftKeys(int pos) {
            boolean curr;
            boolean[] key = BooleanOpenHashSet.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = BooleanOpenHashSet.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (!curr) {
                        key[pos] = false;
                        return;
                    }
                    int slot = (curr ? 262886248 : -878682501) & BooleanOpenHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = BooleanOpenHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = BooleanOpenHashSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new BooleanArrayList(2);
                    }
                    this.wrapped.add(key[pos]);
                }
                key[pos] = curr;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == BooleanOpenHashSet.this.f1073n) {
                BooleanOpenHashSet.this.containsNull = false;
                BooleanOpenHashSet.this.key[BooleanOpenHashSet.this.f1073n] = false;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                BooleanOpenHashSet.this.remove(this.wrapped.getBoolean((-this.pos) - 1));
                this.last = -1;
                return;
            }
            BooleanOpenHashSet.this.size--;
            this.last = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            boolean[] key = BooleanOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = BooleanOpenHashSet.this.f1073n;
                action.accept(key[BooleanOpenHashSet.this.f1073n]);
                this.f1075c--;
            }
            while (this.f1075c != 0) {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    action.accept(this.wrapped.getBoolean((-this.pos) - 1));
                    this.f1075c--;
                } else if (key[this.pos]) {
                    int i2 = this.pos;
                    this.last = i2;
                    action.accept(key[i2]);
                    this.f1075c--;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanSet, p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public BooleanIterator iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanOpenHashSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanOpenHashSet$SetSpliterator.class */
    public final class SetSpliterator implements BooleanSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        int pos;
        int max;

        /* renamed from: c */
        int f1076c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = BooleanOpenHashSet.this.f1073n;
            this.f1076c = 0;
            this.mustReturnNull = BooleanOpenHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = BooleanOpenHashSet.this.f1073n;
            this.f1076c = 0;
            this.mustReturnNull = BooleanOpenHashSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(BooleanConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1076c++;
                action.accept(BooleanOpenHashSet.this.key[BooleanOpenHashSet.this.f1073n]);
                return true;
            }
            boolean[] key = BooleanOpenHashSet.this.key;
            while (this.pos < this.max) {
                if (key[this.pos]) {
                    this.f1076c++;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(key[i]);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        public void forEachRemaining(BooleanConsumer action) {
            boolean[] key = BooleanOpenHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(key[BooleanOpenHashSet.this.f1073n]);
                this.f1076c++;
            }
            while (this.pos < this.max) {
                if (key[this.pos]) {
                    action.accept(key[this.pos]);
                    this.f1076c++;
                }
                this.pos++;
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 257 : 321;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (BooleanOpenHashSet.this.size - this.f1076c);
            }
            return Math.min((long) (BooleanOpenHashSet.this.size - this.f1076c), ((long) ((((double) BooleanOpenHashSet.this.realSize()) / ((double) BooleanOpenHashSet.this.f1073n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public SetSpliterator trySplit() {
            int retLen;
            if (this.pos >= this.max - 1 || (retLen = (this.max - this.pos) >> 1) <= 1) {
                return null;
            }
            int myNewPos = this.pos + retLen;
            SetSpliterator split = new SetSpliterator(this.pos, myNewPos, this.mustReturnNull, true);
            this.pos = myNewPos;
            this.mustReturnNull = false;
            this.hasSplit = true;
            return split;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0048 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0048 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2, types: [long] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r0v18, types: [long] */
        /* JADX WARN: Type inference failed for: r0v20, types: [long] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r0v23, types: [long] */
        /* JADX WARN: Type inference failed for: r0v25, types: [long] */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long skip(long r7) {
            /*
                r6 = this;
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0021
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r1 = r0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = r2
                r3.<init>()
                java.lang.String r3 = "Argument must be nonnegative: "
                java.lang.StringBuilder r2 = r2.append(r3)
                r3 = r7
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r0
            L_0x0021:
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0029
                r0 = 0
                return r0
            L_0x0029:
                r0 = 0
                r9 = r0
                r0 = r6
                boolean r0 = r0.mustReturnNull
                if (r0 == 0) goto L_0x003f
                r0 = r6
                r1 = 0
                r0.mustReturnNull = r1
                r0 = r9
                r1 = 1
                long r0 = r0 + r1
                r9 = r0
                r0 = r7
                r1 = 1
                long r0 = r0 - r1
                r7 = r0
            L_0x003f:
                r0 = r6
                it.unimi.dsi.fastutil.booleans.BooleanOpenHashSet r0 = p014it.unimi.dsi.fastutil.booleans.BooleanOpenHashSet.this
                boolean[] r0 = r0.key
                r11 = r0
            L_0x0048:
                r0 = r6
                int r0 = r0.pos
                r1 = r6
                int r1 = r1.max
                if (r0 >= r1) goto L_0x0075
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x0075
                r0 = r11
                r1 = r6
                r2 = r1
                int r2 = r2.pos
                r3 = r2; r2 = r1; r1 = r3; 
                r4 = 1
                int r3 = r3 + r4
                r2.pos = r3
                r0 = r0[r1]
                if (r0 == 0) goto L_0x0048
                r0 = r9
                r1 = 1
                long r0 = r0 + r1
                r9 = r0
                r0 = r7
                r1 = 1
                long r0 = r0 - r1
                r7 = r0
                goto L_0x0048
            L_0x0075:
                r0 = r9
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanOpenHashSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
    public BooleanSpliterator spliterator() {
        return new SetSpliterator();
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterable
    public void forEach(BooleanConsumer action) {
        if (this.containsNull) {
            action.accept(this.key[this.f1073n]);
        }
        boolean[] key = this.key;
        int pos = this.f1073n;
        while (true) {
            pos--;
            if (pos == 0) {
                return;
            }
            if (key[pos]) {
                action.accept(key[pos]);
            }
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1074f)));
        if (l >= this.f1073n || this.size > HashCommon.maxFill(l, this.f1074f)) {
            return true;
        }
        try {
            rehash(l);
            return true;
        } catch (OutOfMemoryError e) {
            return false;
        }
    }

    protected void rehash(int newN) {
        int i;
        boolean[] key = this.key;
        int mask = newN - 1;
        boolean[] newKey = new boolean[newN + 1];
        int i2 = this.f1073n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (!key[i2]);
                int i3 = (key[i2] ? 262886248 : -878682501) & mask;
                int pos = i3;
                if (newKey[i3]) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (newKey[i]);
                }
                newKey[pos] = key[i2];
            } else {
                this.f1073n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1073n, this.f1074f);
                this.key = newKey;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public BooleanOpenHashSet clone() {
        try {
            BooleanOpenHashSet c = (BooleanOpenHashSet) clone();
            c.key = (boolean[]) this.key.clone();
            c.containsNull = this.containsNull;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (!this.key[i]) {
                i++;
            }
            h += this.key[i] ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE;
            i++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        BooleanIterator i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeBoolean(i.nextBoolean());
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f1073n = HashCommon.arraySize(this.size, this.f1074f);
        this.maxFill = HashCommon.maxFill(this.f1073n, this.f1074f);
        this.mask = this.f1073n - 1;
        boolean[] key = new boolean[this.f1073n + 1];
        this.key = key;
        int i2 = this.size;
        while (true) {
            i2--;
            if (i2 != 0) {
                boolean k = s.readBoolean();
                if (!k) {
                    pos = this.f1073n;
                    this.containsNull = true;
                } else {
                    int i3 = (k ? 262886248 : -878682501) & this.mask;
                    pos = i3;
                    if (key[i3]) {
                        do {
                            i = (pos + 1) & this.mask;
                            pos = i;
                        } while (key[i]);
                    }
                }
                key[pos] = k;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
