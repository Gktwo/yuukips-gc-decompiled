package p014it.unimi.dsi.fastutil.chars;

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
import p014it.unimi.dsi.fastutil.chars.CharHash;

/* renamed from: it.unimi.dsi.fastutil.chars.CharOpenCustomHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharOpenCustomHashSet.class */
public class CharOpenCustomHashSet extends AbstractCharSet implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient char[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected CharHash.Strategy strategy;

    /* renamed from: n */
    protected transient int f1483n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f1484f;

    public CharOpenCustomHashSet(int expected, float f, CharHash.Strategy strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f1484f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f1483n = arraySize;
            this.minN = arraySize;
            this.mask = this.f1483n - 1;
            this.maxFill = HashCommon.maxFill(this.f1483n, f);
            this.key = new char[this.f1483n + 1];
        }
    }

    public CharOpenCustomHashSet(int expected, CharHash.Strategy strategy) {
        this(expected, 0.75f, strategy);
    }

    public CharOpenCustomHashSet(CharHash.Strategy strategy) {
        this(16, 0.75f, strategy);
    }

    public CharOpenCustomHashSet(Collection<? extends Character> c, float f, CharHash.Strategy strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public CharOpenCustomHashSet(Collection<? extends Character> c, CharHash.Strategy strategy) {
        this(c, 0.75f, strategy);
    }

    public CharOpenCustomHashSet(CharCollection c, float f, CharHash.Strategy strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public CharOpenCustomHashSet(CharCollection c, CharHash.Strategy strategy) {
        this(c, 0.75f, strategy);
    }

    public CharOpenCustomHashSet(CharIterator i, float f, CharHash.Strategy strategy) {
        this(16, f, strategy);
        while (i.hasNext()) {
            add(i.nextChar());
        }
    }

    public CharOpenCustomHashSet(CharIterator i, CharHash.Strategy strategy) {
        this(i, 0.75f, strategy);
    }

    public CharOpenCustomHashSet(Iterator<?> i, float f, CharHash.Strategy strategy) {
        this(CharIterators.asCharIterator(i), f, strategy);
    }

    public CharOpenCustomHashSet(Iterator<?> i, CharHash.Strategy strategy) {
        this(CharIterators.asCharIterator(i), strategy);
    }

    public CharOpenCustomHashSet(char[] a, int offset, int length, float f, CharHash.Strategy strategy) {
        this(length < 0 ? 0 : length, f, strategy);
        CharArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public CharOpenCustomHashSet(char[] a, int offset, int length, CharHash.Strategy strategy) {
        this(a, offset, length, 0.75f, strategy);
    }

    public CharOpenCustomHashSet(char[] a, float f, CharHash.Strategy strategy) {
        this(a, 0, a.length, f, strategy);
    }

    public CharOpenCustomHashSet(char[] a, CharHash.Strategy strategy) {
        this(a, 0.75f, strategy);
    }

    public CharHash.Strategy strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f1484f);
        if (needed > this.f1483n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f1484f)))));
        if (needed > this.f1483n) {
            rehash(needed);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean addAll(CharCollection c) {
        if (((double) this.f1484f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Character> c) {
        if (((double) this.f1484f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean add(char k) {
        char curr;
        if (!this.strategy.equals(k, 0)) {
            char[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            char curr2 = key[mix];
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
            this.key[this.f1483n] = k;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size + 1, this.f1484f));
        return true;
    }

    protected final void shiftKeys(int pos) {
        char curr;
        char[] key = this.key;
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
        if (this.f1483n <= this.minN || this.size >= this.maxFill / 4 || this.f1483n <= 16) {
            return true;
        }
        rehash(this.f1483n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f1483n] = 0;
        this.size--;
        if (this.f1483n <= this.minN || this.size >= this.maxFill / 4 || this.f1483n <= 16) {
            return true;
        }
        rehash(this.f1483n / 2);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.CharSet
    public boolean remove(char k) {
        char curr;
        if (!this.strategy.equals(k, 0)) {
            char[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            char curr2 = key[mix];
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean contains(char k) {
        char curr;
        if (this.strategy.equals(k, 0)) {
            return this.containsNull;
        }
        char[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        char curr2 = key[mix];
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
            Arrays.fill(this.key, (char) 0);
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
    /* renamed from: it.unimi.dsi.fastutil.chars.CharOpenCustomHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharOpenCustomHashSet$SetIterator.class */
    public final class SetIterator implements CharIterator {
        int pos;
        int last;

        /* renamed from: c */
        int f1485c;
        boolean mustReturnNull;
        CharArrayList wrapped;

        private SetIterator() {
            this.pos = CharOpenCustomHashSet.this.f1483n;
            this.last = -1;
            this.f1485c = CharOpenCustomHashSet.this.size;
            this.mustReturnNull = CharOpenCustomHashSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1485c != 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1485c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = CharOpenCustomHashSet.this.f1483n;
                return CharOpenCustomHashSet.this.key[CharOpenCustomHashSet.this.f1483n];
            }
            char[] key = CharOpenCustomHashSet.this.key;
            do {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    return this.wrapped.getChar((-this.pos) - 1);
                }
            } while (key[this.pos] == 0);
            int i2 = this.pos;
            this.last = i2;
            return key[i2];
        }

        private final void shiftKeys(int pos) {
            char curr;
            char[] key = CharOpenCustomHashSet.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = CharOpenCustomHashSet.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == 0) {
                        key[pos] = 0;
                        return;
                    }
                    int slot = HashCommon.mix(CharOpenCustomHashSet.this.strategy.hashCode(curr)) & CharOpenCustomHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = CharOpenCustomHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = CharOpenCustomHashSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new CharArrayList(2);
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
            if (this.last == CharOpenCustomHashSet.this.f1483n) {
                CharOpenCustomHashSet.this.containsNull = false;
                CharOpenCustomHashSet.this.key[CharOpenCustomHashSet.this.f1483n] = 0;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                CharOpenCustomHashSet.this.remove(this.wrapped.getChar((-this.pos) - 1));
                this.last = -1;
                return;
            }
            CharOpenCustomHashSet.this.size--;
            this.last = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            char[] key = CharOpenCustomHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = CharOpenCustomHashSet.this.f1483n;
                action.accept(key[CharOpenCustomHashSet.this.f1483n]);
                this.f1485c--;
            }
            while (this.f1485c != 0) {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    action.accept(this.wrapped.getChar((-this.pos) - 1));
                    this.f1485c--;
                } else if (key[this.pos] != 0) {
                    int i2 = this.pos;
                    this.last = i2;
                    action.accept(key[i2]);
                    this.f1485c--;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    public CharIterator iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharOpenCustomHashSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharOpenCustomHashSet$SetSpliterator.class */
    public final class SetSpliterator implements CharSpliterator {
        private static final int POST_SPLIT_CHARACTERISTICS = 257;
        int pos;
        int max;

        /* renamed from: c */
        int f1486c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = CharOpenCustomHashSet.this.f1483n;
            this.f1486c = 0;
            this.mustReturnNull = CharOpenCustomHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = CharOpenCustomHashSet.this.f1483n;
            this.f1486c = 0;
            this.mustReturnNull = CharOpenCustomHashSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        public boolean tryAdvance(CharConsumer action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f1486c++;
                action.accept(CharOpenCustomHashSet.this.key[CharOpenCustomHashSet.this.f1483n]);
                return true;
            }
            char[] key = CharOpenCustomHashSet.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    this.f1486c++;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept(key[i]);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        public void forEachRemaining(CharConsumer action) {
            char[] key = CharOpenCustomHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept(key[CharOpenCustomHashSet.this.f1483n]);
                this.f1486c++;
            }
            while (this.pos < this.max) {
                if (key[this.pos] != 0) {
                    action.accept(key[this.pos]);
                    this.f1486c++;
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
                return (long) (CharOpenCustomHashSet.this.size - this.f1486c);
            }
            return Math.min((long) (CharOpenCustomHashSet.this.size - this.f1486c), ((long) ((((double) CharOpenCustomHashSet.this.realSize()) / ((double) CharOpenCustomHashSet.this.f1483n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
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
        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterator
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
                it.unimi.dsi.fastutil.chars.CharOpenCustomHashSet r0 = p014it.unimi.dsi.fastutil.chars.CharOpenCustomHashSet.this
                char[] r0 = r0.key
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
                char r0 = r0[r1]
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharOpenCustomHashSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    public CharSpliterator spliterator() {
        return new SetSpliterator();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
    public void forEach(CharConsumer action) {
        if (this.containsNull) {
            action.accept(this.key[this.f1483n]);
        }
        char[] key = this.key;
        int pos = this.f1483n;
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
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f1484f)));
        if (l >= this.f1483n || this.size > HashCommon.maxFill(l, this.f1484f)) {
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
        char[] key = this.key;
        int mask = newN - 1;
        char[] newKey = new char[newN + 1];
        int i2 = this.f1483n;
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
                this.f1483n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f1483n, this.f1484f);
                this.key = newKey;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public CharOpenCustomHashSet clone() {
        try {
            CharOpenCustomHashSet c = (CharOpenCustomHashSet) clone();
            c.key = (char[]) this.key.clone();
            c.containsNull = this.containsNull;
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharSet, java.util.Collection, java.lang.Object, java.util.Set
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

    private void writeObject(ObjectOutputStream s) throws IOException {
        CharIterator i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeChar(i.nextChar());
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f1483n = HashCommon.arraySize(this.size, this.f1484f);
        this.maxFill = HashCommon.maxFill(this.f1483n, this.f1484f);
        this.mask = this.f1483n - 1;
        char[] key = new char[this.f1483n + 1];
        this.key = key;
        int i2 = this.size;
        while (true) {
            i2--;
            if (i2 != 0) {
                char k = s.readChar();
                if (this.strategy.equals(k, 0)) {
                    pos = this.f1483n;
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
