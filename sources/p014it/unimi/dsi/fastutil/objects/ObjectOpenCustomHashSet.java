package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.HashCommon;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectOpenCustomHashSet.class */
public class ObjectOpenCustomHashSet<K> extends AbstractObjectSet<K> implements Serializable, Cloneable, Hash {
    private static final long serialVersionUID = 0;
    private static final boolean ASSERTS = false;
    protected transient K[] key;
    protected transient int mask;
    protected transient boolean containsNull;
    protected Hash.Strategy<? super K> strategy;

    /* renamed from: n */
    protected transient int f2716n;
    protected transient int maxFill;
    protected final transient int minN;
    protected int size;

    /* renamed from: f */
    protected final float f2717f;

    public ObjectOpenCustomHashSet(int expected, float f, Hash.Strategy<? super K> strategy) {
        this.strategy = strategy;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than 1");
        } else if (expected < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        } else {
            this.f2717f = f;
            int arraySize = HashCommon.arraySize(expected, f);
            this.f2716n = arraySize;
            this.minN = arraySize;
            this.mask = this.f2716n - 1;
            this.maxFill = HashCommon.maxFill(this.f2716n, f);
            this.key = (K[]) new Object[this.f2716n + 1];
        }
    }

    public ObjectOpenCustomHashSet(int expected, Hash.Strategy<? super K> strategy) {
        this(expected, 0.75f, strategy);
    }

    public ObjectOpenCustomHashSet(Hash.Strategy<? super K> strategy) {
        this(16, 0.75f, strategy);
    }

    public ObjectOpenCustomHashSet(Collection<? extends K> c, float f, Hash.Strategy<? super K> strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public ObjectOpenCustomHashSet(Collection<? extends K> c, Hash.Strategy<? super K> strategy) {
        this(c, 0.75f, strategy);
    }

    public ObjectOpenCustomHashSet(ObjectCollection<? extends K> c, float f, Hash.Strategy<? super K> strategy) {
        this(c.size(), f, strategy);
        addAll(c);
    }

    public ObjectOpenCustomHashSet(ObjectCollection<? extends K> c, Hash.Strategy<? super K> strategy) {
        this((ObjectCollection) c, 0.75f, (Hash.Strategy) strategy);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet<K> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectOpenCustomHashSet(Iterator<? extends K> i, float f, Hash.Strategy<? super K> strategy) {
        this(16, f, strategy);
        while (i.hasNext()) {
            add(i.next());
        }
    }

    public ObjectOpenCustomHashSet(Iterator<? extends K> i, Hash.Strategy<? super K> strategy) {
        this(i, 0.75f, strategy);
    }

    public ObjectOpenCustomHashSet(K[] a, int offset, int length, float f, Hash.Strategy<? super K> strategy) {
        this(length < 0 ? 0 : length, f, strategy);
        ObjectArrays.ensureOffsetLength(a, offset, length);
        for (int i = 0; i < length; i++) {
            add(a[offset + i]);
        }
    }

    public ObjectOpenCustomHashSet(K[] a, int offset, int length, Hash.Strategy<? super K> strategy) {
        this(a, offset, length, 0.75f, strategy);
    }

    public ObjectOpenCustomHashSet(K[] a, float f, Hash.Strategy<? super K> strategy) {
        this(a, 0, a.length, f, strategy);
    }

    public ObjectOpenCustomHashSet(K[] a, Hash.Strategy<? super K> strategy) {
        this(a, 0.75f, strategy);
    }

    public Hash.Strategy<? super K> strategy() {
        return this.strategy;
    }

    /* access modifiers changed from: private */
    public int realSize() {
        return this.containsNull ? this.size - 1 : this.size;
    }

    private void ensureCapacity(int capacity) {
        int needed = HashCommon.arraySize(capacity, this.f2717f);
        if (needed > this.f2716n) {
            rehash(needed);
        }
    }

    private void tryCapacity(long capacity) {
        int needed = (int) Math.min((long) FileSize.GB_COEFFICIENT, Math.max(2L, HashCommon.nextPowerOfTwo((long) Math.ceil((double) (((float) capacity) / this.f2717f)))));
        if (needed > this.f2716n) {
            rehash(needed);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends K> c) {
        if (((double) this.f2717f) <= 0.5d) {
            ensureCapacity(c.size());
        } else {
            tryCapacity((long) (size() + c.size()));
        }
        return addAll(c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(K k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (this.strategy.equals(curr2, k)) {
                    return false;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!this.strategy.equals(curr, k));
                return false;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return false;
        } else {
            this.containsNull = true;
            this.key[this.f2716n] = k;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 < this.maxFill) {
            return true;
        }
        rehash(HashCommon.arraySize(this.size + 1, this.f2717f));
        return true;
    }

    public K addOrGet(K k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 != null) {
                if (this.strategy.equals(curr2, k)) {
                    return curr2;
                }
                do {
                    int i = (pos + 1) & this.mask;
                    pos = i;
                    curr = key[i];
                    if (curr != null) {
                    }
                } while (!this.strategy.equals(curr, k));
                return curr;
            }
            key[pos] = k;
        } else if (this.containsNull) {
            return this.key[this.f2716n];
        } else {
            this.containsNull = true;
            this.key[this.f2716n] = k;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 >= this.maxFill) {
            rehash(HashCommon.arraySize(this.size + 1, this.f2717f));
        }
        return k;
    }

    protected final void shiftKeys(int pos) {
        K curr;
        K[] key = this.key;
        while (true) {
            int i = pos + 1;
            int i2 = this.mask;
            while (true) {
                pos = i & i2;
                curr = key[pos];
                if (curr == null) {
                    key[pos] = null;
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
        if (this.f2716n <= this.minN || this.size >= this.maxFill / 4 || this.f2716n <= 16) {
            return true;
        }
        rehash(this.f2716n / 2);
        return true;
    }

    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.f2716n] = null;
        this.size--;
        if (this.f2716n <= this.minN || this.size >= this.maxFill / 4 || this.f2716n <= 16) {
            return true;
        }
        rehash(this.f2716n / 2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object k) {
        K curr;
        if (!this.strategy.equals(k, null)) {
            K[] key = this.key;
            int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
            int pos = mix;
            K curr2 = key[mix];
            if (curr2 == null) {
                return false;
            }
            if (this.strategy.equals(k, curr2)) {
                return removeEntry(pos);
            }
            do {
                int i = (pos + 1) & this.mask;
                pos = i;
                curr = key[i];
                if (curr == null) {
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.containsNull;
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return false;
        }
        if (this.strategy.equals(k, curr2)) {
            return true;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return false;
            }
        } while (!this.strategy.equals(k, curr));
        return true;
    }

    public K get(Object k) {
        K curr;
        if (this.strategy.equals(k, null)) {
            return this.key[this.f2716n];
        }
        K[] key = this.key;
        int mix = HashCommon.mix(this.strategy.hashCode(k)) & this.mask;
        int pos = mix;
        K curr2 = key[mix];
        if (curr2 == null) {
            return null;
        }
        if (this.strategy.equals(k, curr2)) {
            return curr2;
        }
        do {
            int i = (pos + 1) & this.mask;
            pos = i;
            curr = key[i];
            if (curr == null) {
                return null;
            }
        } while (!this.strategy.equals(k, curr));
        return curr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            this.containsNull = false;
            Arrays.fill(this.key, (Object) null);
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
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet$SetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectOpenCustomHashSet$SetIterator.class */
    public final class SetIterator implements ObjectIterator<K> {
        int pos;
        int last;

        /* renamed from: c */
        int f2718c;
        boolean mustReturnNull;
        ObjectArrayList<K> wrapped;

        private SetIterator() {
            this.pos = ObjectOpenCustomHashSet.this.f2716n;
            this.last = -1;
            this.f2718c = ObjectOpenCustomHashSet.this.size;
            this.mustReturnNull = ObjectOpenCustomHashSet.this.containsNull;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2718c != 0;
        }

        @Override // java.util.Iterator
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2718c--;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = ObjectOpenCustomHashSet.this.f2716n;
                return ObjectOpenCustomHashSet.this.key[ObjectOpenCustomHashSet.this.f2716n];
            }
            K[] key = ObjectOpenCustomHashSet.this.key;
            do {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    return this.wrapped.get((-this.pos) - 1);
                }
            } while (key[this.pos] == null);
            int i2 = this.pos;
            this.last = i2;
            return key[i2];
        }

        private final void shiftKeys(int pos) {
            K curr;
            K[] key = ObjectOpenCustomHashSet.this.key;
            while (true) {
                int i = pos + 1;
                int i2 = ObjectOpenCustomHashSet.this.mask;
                while (true) {
                    pos = i & i2;
                    curr = key[pos];
                    if (curr == null) {
                        key[pos] = null;
                        return;
                    }
                    int slot = HashCommon.mix(ObjectOpenCustomHashSet.this.strategy.hashCode(curr)) & ObjectOpenCustomHashSet.this.mask;
                    if (pos <= pos) {
                        if (pos >= slot || slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = ObjectOpenCustomHashSet.this.mask;
                    } else {
                        if (pos >= slot && slot > pos) {
                            break;
                        }
                        i = pos + 1;
                        i2 = ObjectOpenCustomHashSet.this.mask;
                    }
                }
                if (pos < pos) {
                    if (this.wrapped == null) {
                        this.wrapped = new ObjectArrayList<>(2);
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
            if (this.last == ObjectOpenCustomHashSet.this.f2716n) {
                ObjectOpenCustomHashSet.this.containsNull = false;
                ObjectOpenCustomHashSet.this.key[ObjectOpenCustomHashSet.this.f2716n] = null;
            } else if (this.pos >= 0) {
                shiftKeys(this.last);
            } else {
                ObjectOpenCustomHashSet.this.remove(this.wrapped.set((-this.pos) - 1, null));
                this.last = -1;
                return;
            }
            ObjectOpenCustomHashSet.this.size--;
            this.last = -1;
        }

        /* JADX DEBUG: Type inference failed for r1v7. Raw type applied. Possible types: K, ? super K */
        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            K[] key = ObjectOpenCustomHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = ObjectOpenCustomHashSet.this.f2716n;
                action.accept((Object) key[ObjectOpenCustomHashSet.this.f2716n]);
                this.f2718c--;
            }
            while (this.f2718c != 0) {
                int i = this.pos - 1;
                this.pos = i;
                if (i < 0) {
                    this.last = Integer.MIN_VALUE;
                    action.accept((K) this.wrapped.get((-this.pos) - 1));
                    this.f2718c--;
                } else if (key[this.pos] != null) {
                    int i2 = this.pos;
                    this.last = i2;
                    action.accept((Object) key[i2]);
                    this.f2718c--;
                }
            }
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    public ObjectIterator<K> iterator() {
        return new SetIterator();
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet$SetSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectOpenCustomHashSet$SetSpliterator.class */
    public final class SetSpliterator implements ObjectSpliterator<K> {
        private static final int POST_SPLIT_CHARACTERISTICS = 1;
        int pos;
        int max;

        /* renamed from: c */
        int f2719c;
        boolean mustReturnNull;
        boolean hasSplit;

        SetSpliterator() {
            this.pos = 0;
            this.max = ObjectOpenCustomHashSet.this.f2716n;
            this.f2719c = 0;
            this.mustReturnNull = ObjectOpenCustomHashSet.this.containsNull;
            this.hasSplit = false;
        }

        SetSpliterator(int pos, int max, boolean mustReturnNull, boolean hasSplit) {
            this.pos = 0;
            this.max = ObjectOpenCustomHashSet.this.f2716n;
            this.f2719c = 0;
            this.mustReturnNull = ObjectOpenCustomHashSet.this.containsNull;
            this.hasSplit = false;
            this.pos = pos;
            this.max = max;
            this.mustReturnNull = mustReturnNull;
            this.hasSplit = hasSplit;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.f2719c++;
                action.accept((Object) ObjectOpenCustomHashSet.this.key[ObjectOpenCustomHashSet.this.f2716n]);
                return true;
            }
            K[] key = ObjectOpenCustomHashSet.this.key;
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    this.f2719c++;
                    int i = this.pos;
                    this.pos = i + 1;
                    action.accept((Object) key[i]);
                    return true;
                }
                this.pos++;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            K[] key = ObjectOpenCustomHashSet.this.key;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                action.accept((Object) key[ObjectOpenCustomHashSet.this.f2716n]);
                this.f2719c++;
            }
            while (this.pos < this.max) {
                if (key[this.pos] != null) {
                    action.accept((Object) key[this.pos]);
                    this.f2719c++;
                }
                this.pos++;
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.hasSplit ? 1 : 65;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (!this.hasSplit) {
                return (long) (ObjectOpenCustomHashSet.this.size - this.f2719c);
            }
            return Math.min((long) (ObjectOpenCustomHashSet.this.size - this.f2719c), ((long) ((((double) ObjectOpenCustomHashSet.this.realSize()) / ((double) ObjectOpenCustomHashSet.this.f2716n)) * ((double) (this.max - this.pos)))) + ((long) (this.mustReturnNull ? 1 : 0)));
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectOpenCustomHashSet<K>.SetSpliterator trySplit() {
            int retLen;
            if (this.pos >= this.max - 1 || (retLen = (this.max - this.pos) >> 1) <= 1) {
                return null;
            }
            int myNewPos = this.pos + retLen;
            ObjectOpenCustomHashSet<K>.SetSpliterator split = new SetSpliterator(this.pos, myNewPos, this.mustReturnNull, true);
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
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
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
                it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet r0 = p014it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet.this
                K[] r0 = r0.key
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet.SetSpliterator.skip(long):long");
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    public ObjectSpliterator<K> spliterator() {
        return new SetSpliterator();
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super K> action) {
        if (this.containsNull) {
            action.accept((Object) this.key[this.f2716n]);
        }
        K[] key = this.key;
        int pos = this.f2716n;
        while (true) {
            pos--;
            if (pos == 0) {
                return;
            }
            if (key[pos] != null) {
                action.accept((Object) key[pos]);
            }
        }
    }

    public boolean trim() {
        return trim(this.size);
    }

    public boolean trim(int n) {
        int l = HashCommon.nextPowerOfTwo((int) Math.ceil((double) (((float) n) / this.f2717f)));
        if (l >= this.f2716n || this.size > HashCommon.maxFill(l, this.f2717f)) {
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
        K[] key = this.key;
        int mask = newN - 1;
        K[] newKey = (K[]) new Object[newN + 1];
        int i2 = this.f2716n;
        int j = realSize();
        while (true) {
            j--;
            if (j != 0) {
                do {
                    i2--;
                } while (key[i2] == null);
                int mix = HashCommon.mix(this.strategy.hashCode(key[i2])) & mask;
                int pos = mix;
                if (newKey[mix] != null) {
                    do {
                        i = (pos + 1) & mask;
                        pos = i;
                    } while (newKey[i] != null);
                }
                newKey[pos] = key[i2];
            } else {
                this.f2716n = newN;
                this.mask = mask;
                this.maxFill = HashCommon.maxFill(this.f2716n, this.f2717f);
                this.key = newKey;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public ObjectOpenCustomHashSet<K> clone() {
        try {
            ObjectOpenCustomHashSet<K> c = (ObjectOpenCustomHashSet) clone();
            c.key = (K[]) ((Object[]) this.key.clone());
            c.containsNull = this.containsNull;
            c.strategy = this.strategy;
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int h = 0;
        int j = realSize();
        int i = 0;
        while (true) {
            j--;
            if (j == 0) {
                return h;
            }
            while (this.key[i] == null) {
                i++;
            }
            if (this != this.key[i]) {
                h += this.strategy.hashCode((Object) this.key[i]);
            }
            i++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        ObjectIterator<K> i = iterator();
        s.defaultWriteObject();
        int j = this.size;
        while (true) {
            j--;
            if (j != 0) {
                s.writeObject(i.next());
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: K[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        int pos;
        int i;
        s.defaultReadObject();
        this.f2716n = HashCommon.arraySize(this.size, this.f2717f);
        this.maxFill = HashCommon.maxFill(this.f2716n, this.f2717f);
        this.mask = this.f2716n - 1;
        K[] key = (K[]) new Object[this.f2716n + 1];
        this.key = key;
        int i2 = this.size;
        while (true) {
            i2--;
            if (i2 != 0) {
                Object readObject = s.readObject();
                if (this.strategy.equals(readObject, null)) {
                    pos = this.f2716n;
                    this.containsNull = true;
                } else {
                    int mix = HashCommon.mix(this.strategy.hashCode(readObject)) & this.mask;
                    pos = mix;
                    if (key[mix] != 0) {
                        do {
                            i = (pos + 1) & this.mask;
                            pos = i;
                        } while (key[i] != 0);
                    }
                }
                key[pos] = readObject;
            } else {
                return;
            }
        }
    }

    private void checkTable() {
    }
}
