package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.bytes.ByteHash;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteOpenCustomHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteOpenCustomHashSet.class */
public class ByteOpenCustomHashSet extends AbstractByteSet implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient byte[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected ByteHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f1256n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1257f;

    public ByteOpenCustomHashSet(int expected, float f, ByteHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1257f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1256n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1256n - 1;
            this.maxFill = HashCommon.maxFill(this.f1256n, f);
            this.key = new byte[this.f1256n + 1];
        }
    }

    public ByteOpenCustomHashSet(int expected, ByteHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public ByteOpenCustomHashSet(ByteHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public ByteOpenCustomHashSet(Collection<? extends Byte> c, float f, ByteHash.Strategy strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public ByteOpenCustomHashSet(Collection<? extends Byte> c, ByteHash.Strategy strategy) {
        this(c, 0.75f, strategy);
    }

    public ByteOpenCustomHashSet(ByteCollection c, float f, ByteHash.Strategy strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public ByteOpenCustomHashSet(ByteCollection c, ByteHash.Strategy strategy) {
        this(c, 0.75f, strategy);
    }

    public ByteOpenCustomHashSet(ByteIterator i, float f, ByteHash.Strategy strategy) {
        this(16, f, strategy);
        while (i.hasNext()) {
            add(i.nextByte());
        }
    }

    public ByteOpenCustomHashSet(ByteIterator i, ByteHash.Strategy strategy) {
        this(i, 0.75f, strategy);
    }

    public ByteOpenCustomHashSet(Iterator<?> i, float f, ByteHash.Strategy strategy) {
        this(ByteIterators.asByteIterator(i), f, strategy);
    }

    public ByteOpenCustomHashSet(Iterator<?> i, ByteHash.Strategy strategy) {
        this(ByteIterators.asByteIterator(i), strategy);
    }

    public ByteOpenCustomHashSet(byte[] a, int offset, int length, float f, ByteHash.Strategy strategy) {
        this(length < 0 ? 0 : length, f, strategy);
        ByteArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ByteOpenCustomHashSet(byte[] a, int offset, int length, ByteHash.Strategy strategy) {
        this(a, offset, length, 0.75f, strategy);
    }

    public ByteOpenCustomHashSet(byte[] a, float f, ByteHash.Strategy strategy) {
        this(a, 0, a.length, f, strategy);
    }

    public ByteOpenCustomHashSet(byte[] a, ByteHash.Strategy strategy) {
        this(a, 0.75f, strategy);
    }

    public ByteHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1257f);
        if (needed > this.f1256n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1257f)))));
        if (needed > this.f1256n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean addAll(ByteCollection c) {
        if (((double) this.f1257f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Byte> c) {
        if (((double) this.f1257f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean add(byte k) {
        byte curr;
        if (!this.strategy.equals(k, (byte) 0)) {
            byte[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            byte curr2 = key[mix];
            if (curr2 != 0) {
                if (this.strategy.equals(curr2, k)) {
                    return false;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != 0) {
                    }
                } while (!this.strategy.equals(curr, k));
                return false;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            this.containsNull = true;
            this.key[this.f1256n] = k;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size + 1, this.f1257f));
        return true;
    }

    protected final void shiftKeys(int pos) {
        byte curr;
        byte[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (curr == 0) {
                    key[pos] = 0;
                    return;
                }
                int slot = HashCommon.mix(this.strategy.hashCode(curr)) & this.mask;
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
        if (this.f1256n <= this.minN || this.size >= this.maxFill / 4 || this.f1256n <= 16) {
            return true;
        }
        rehash(this.f1256n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f1256n] = 0;
        this.size--;
        if (this.f1256n <= this.minN || this.size >= this.maxFill / 4 || this.f1256n <= 16) {
            return true;
        }
        rehash(this.f1256n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
    public boolean remove(byte k) {
        byte curr;
        if (!this.strategy.equals(k, (byte) 0)) {
            byte[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            byte curr2 = key[mix];
            if (curr2 == 0) {
                return false;
            }
            if (this.strategy.equals(k, curr2)) {
                return removeEntry(pos);
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == 0) {
                    return false;
                }
            } while (!this.strategy.equals(k, curr));
            return removeEntry(pos);
        } else if (this.containsNull) {
            return removeNullEntry();
        } else {
            return false;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean contains(byte k) {
        byte curr;
        if (this.strategy.equals(k, (byte) 0)) {
            return this.containsNull;
        }
        byte[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        byte curr2 = key[mix];
        if (curr2 == 0) {
            return false;
        }
        if (this.strategy.equals(k, curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == 0) {
                return false;
            }
        } while (!this.strategy.equals(k, curr));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, (byte) 0);
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
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteOpenCustomHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteOpenCustomHashSet$SetIterator.class */
    public final class SetIterator implements ByteIterator {
        int pos;
        int last;

        /* renamed from: c */
        int f1258c;
        boolean mustReturnNull;
        ByteArrayList wrapped;

        private SetIterator() {
            this.pos = ByteOpenCustomHashSet.this.f1256n;
            this.last = -1;
            this.f1258c = ByteOpenCustomHashSet.this.size;
            this.mustReturnNull = ByteOpenCustomHashSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1258c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1258c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = ByteOpenCustomHashSet.this.f1256n;
                return ByteOpenCustomHashSet.this.key[ByteOpenCustomHashSet.this.f1256n];
            }
            byte[] key = ByteOpenCustomHashSet.this.key;
            do {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    return this.wrapped.getByte((-this.pos) - 1);
                }
            } while (key[this.pos] == 0);
            int i2 = this.pos;
            this.last = i2;
            return key[i2];
        }

        private final void shiftKeys(int pos) {
            byte curr;
            byte[] key = ByteOpenCustomHashSet.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = ByteOpenCustomHashSet.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(ByteOpenCustomHashSet.this.strategy.hashCode(curr)) & ByteOpenCustomHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = ByteOpenCustomHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = ByteOpenCustomHashSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ByteArrayList(2);
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
            if (this.last == ByteOpenCustomHashSet.this.f1256n) {
                ByteOpenCustomHashSet.this.containsNull = false;
                ByteOpenCustomHashSet.this.key[ByteOpenCustomHashSet.this.f1256n] = 0;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                ByteOpenCustomHashSet.this.remove(this.wrapped.getByte((-this.pos) - 1));
                this.last = -1;
                return;
            }
            ByteOpenCustomHashSet.this.size--;
            this.last = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            byte[] key = ByteOpenCustomHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = ByteOpenCustomHashSet.this.f1256n;
                action.accept(key[ByteOpenCustomHashSet.this.f1256n]);
                this.f1258c--;
            }
            while (this.f1258c != 0) {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    action.accept(this.wrapped.getByte((-this.pos) - 1));
                    this.f1258c--;
                } else if (key[this.pos] != 0) {
                    int i2 = this.pos;
                    this.last = i2;
                    action.accept(key[i2]);
                    this.f1258c--;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public Iterator<Byte> iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteOpenCustomHashSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteOpenCustomHashSet$SetSpliterator.class */
    public final class SetSpliterator implements ByteSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        int pos;
        int max;

        /* renamed from: c */
        int f1259c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = ByteOpenCustomHashSet.this.f1256n;
            this.f1259c = 0;
            this.mustReturnNull = ByteOpenCustomHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = ByteOpenCustomHashSet.this.f1256n;
            this.f1259c = 0;
            this.mustReturnNull = ByteOpenCustomHashSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(ByteConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1259c++;
                action.accept(ByteOpenCustomHashSet.this.key[ByteOpenCustomHashSet.this.f1256n]);
                return true;
            }
            byte[] key = ByteOpenCustomHashSet.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f1259c++;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(key[i]);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        public void forEachRemaining(ByteConsumer action) {
            byte[] key = ByteOpenCustomHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(key[ByteOpenCustomHashSet.this.f1256n]);
                this.f1259c++;
            }
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    action.accept(key[this.pos]);
                    this.f1259c++;
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
                return (long) (ByteOpenCustomHashSet.this.size - this.f1259c);
            }
            return Math.min((long) (ByteOpenCustomHashSet.this.size - this.f1259c), ((long) ((((double) ByteOpenCustomHashSet.this.realSize()) / ((double) ByteOpenCustomHashSet.this.f1256n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
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
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterator
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
                it.unimi.dsi.fastutil.bytes.ByteOpenCustomHashSet r0 = p014it.unimi.dsi.fastutil.bytes.ByteOpenCustomHashSet.this
                byte[] r0 = r0.key
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteOpenCustomHashSet.SetSpliterator.skip(long):long");
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public Spliterator<Byte> spliterator() {
        return new SetSpliterator();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterable
    public void forEach(ByteConsumer action) {
        if (this.containsNull) {
            action.accept(this.key[this.f1256n]);
        }
        byte[] key = this.key;
        int pos = this.f1256n;
        while (true) {
            pos--;
            if (pos == 0) {
                return;
            }
            if (key[pos] != 0) {
                action.accept(key[pos]);
            }
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1257f)));
        if (l >= this.f1256n || this.size > HashCommon.maxFill(l, this.f1257f)) {
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
        byte[] key = this.key;
        int mask = newN - 1;
        byte[] newKey = new byte[newN + 1];
        int i2 = this.f1256n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == 0);
                int mix = HashCommon.mix(this.strategy.hashCode(key[i2])) & mask;
                int pos = mix;
                if (newKey[mix] != 0) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (newKey[i] != 0);
                }
                newKey[pos] = key[i2];
            } else {
                this.f1256n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1256n, this.f1257f);
                this.key = newKey;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public ByteOpenCustomHashSet clone() {
        try {
            ByteOpenCustomHashSet c = (ByteOpenCustomHashSet) clone();
            c.key = (byte[]) this.key.clone();
            c.containsNull = this.containsNull;
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (this.key[i] == 0) {
                i++;
            }
            h += this.strategy.hashCode(this.key[i]);
            i++;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.bytes.ByteIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeObject(java.io.ObjectOutputStream r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = r3
            it.unimi.dsi.fastutil.bytes.ByteIterator r0 = r0.iterator()
            r5 = r0
            r0 = r4
            r0.defaultWriteObject()
            r0 = r3
            int r0 = r0.size
            r6 = r0
        L_0x000e:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0022
            r0 = r4
            r1 = r5
            byte r1 = r1.nextByte()
            r0.writeByte(r1)
            goto L_0x000e
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteOpenCustomHashSet.writeObject(java.io.ObjectOutputStream):void");
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f1256n = HashCommon.arraySize(this.size, this.f1257f);
        this.maxFill = HashCommon.maxFill(this.f1256n, this.f1257f);
        this.mask = this.f1256n - 1;
        byte[] key = new byte[this.f1256n + 1];
        this.key = key;
        int i2 = this.size;
        while (true) {
            i2--;
            if (i2 != 0) {
                byte k = s.readByte();
                if (this.strategy.equals(k, (byte) 0)) {
                    pos = this.f1256n;
                    this.containsNull = true;
                } else {
                    int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
                    pos = mix;
                    if (key[mix] != 0) {
                        do {
                            i = (pos + 1) & this.mask;
                            pos = i;
                        } while (key[i] != 0);
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
