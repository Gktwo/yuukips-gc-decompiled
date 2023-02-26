package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArraySet.class */
public class FloatArraySet extends AbstractFloatSet implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient float[] f1888a;
    private int size;

    static /* synthetic */ int access$010(FloatArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public FloatArraySet(float[] a) {
        this.f1888a = a;
        this.size = a.length;
    }

    public FloatArraySet() {
        this.f1888a = FloatArrays.EMPTY_ARRAY;
    }

    public FloatArraySet(int capacity) {
        this.f1888a = new float[capacity];
    }

    public FloatArraySet(FloatCollection c) {
        this(c.size());
        addAll(c);
    }

    public FloatArraySet(Collection<? extends Float> c) {
        this(c.size());
        addAll(c);
    }

    public FloatArraySet(FloatSet c) {
        this(c.size());
        int i = 0;
        FloatIterator it = c.iterator();
        while (it.hasNext()) {
            this.f1888a[i] = it.next().floatValue();
            i++;
        }
        this.size = i;
    }

    public FloatArraySet(Set<? extends Float> c) {
        this(c.size());
        int i = 0;
        for (Float x : c) {
            this.f1888a[i] = x.floatValue();
            i++;
        }
        this.size = i;
    }

    public FloatArraySet(float[] a, int size) {
        this.f1888a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static FloatArraySet m837of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static FloatArraySet m836of(float e) {
        return ofUnchecked(e);
    }

    /* renamed from: of */
    public static FloatArraySet m835of(float... a) {
        if (a.length == 2) {
            if (Float.floatToIntBits(a[0]) == Float.floatToIntBits(a[1])) {
                throw new IllegalArgumentException("Duplicate element: " + a[1]);
            }
        } else if (a.length > 2) {
            FloatOpenHashSet.m790of(a);
        }
        return ofUnchecked(a);
    }

    public static FloatArraySet ofUnchecked() {
        return new FloatArraySet();
    }

    public static FloatArraySet ofUnchecked(float... a) {
        return new FloatArraySet(a);
    }

    private int findKey(float o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (Float.floatToIntBits(this.f1888a[i]) != Float.floatToIntBits(o));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatIterator iterator() {
        return new FloatIterator() { // from class: it.unimi.dsi.fastutil.floats.FloatArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < FloatArraySet.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
            public float nextFloat() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                float[] fArr = FloatArraySet.this.f1888a;
                int i = this.next;
                this.next = i + 1;
                return fArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = FloatArraySet.access$010(FloatArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(FloatArraySet.this.f1888a, this.next + 1, FloatArraySet.this.f1888a, this.next, access$010 - i);
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = FloatArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = FloatArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArraySet$Spliterator.class */
    public final class Spliterator implements FloatSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !FloatArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(FloatArraySet floatArraySet) {
            this(0, floatArraySet.size, false);
        }

        private Spliterator(int pos, int max, boolean hasSplit) {
            this.hasSplit = false;
            if ($assertionsDisabled || pos <= max) {
                this.pos = pos;
                this.max = max;
                this.hasSplit = hasSplit;
                return;
            }
            throw new AssertionError("pos " + pos + " must be <= max " + max);
        }

        private int getWorkingMax() {
            return this.hasSplit ? this.max : FloatArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16721;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(FloatConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            float[] fArr = FloatArraySet.this.f1888a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(fArr[i]);
            return true;
        }

        public void forEachRemaining(FloatConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(FloatArraySet.this.f1888a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int max = getWorkingMax();
            if (this.pos >= max) {
                return 0;
            }
            int remaining = max - this.pos;
            if (n < ((long) remaining)) {
                this.pos = SafeMath.safeLongToInt(((long) this.pos) + n);
                return n;
            }
            long n2 = (long) remaining;
            this.pos = max;
            return n2;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            int max = getWorkingMax();
            int retLen = (max - this.pos) >> 1;
            if (retLen <= 1) {
                return null;
            }
            this.max = max;
            int myNewPos = this.pos + retLen;
            int oldPos = this.pos;
            this.pos = myNewPos;
            this.hasSplit = true;
            return new Spliterator(oldPos, myNewPos, true);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.floats.FloatCollection, p014it.unimi.dsi.fastutil.floats.FloatIterable
    public FloatSpliterator spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean contains(float k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatSet, p014it.unimi.dsi.fastutil.floats.FloatSet
    public boolean remove(float k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f1888a[pos + i] = this.f1888a[pos + i + 1];
        }
        this.size--;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public boolean add(float k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f1888a.length) {
            float[] b = new float[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f1888a[i];
            }
            this.f1888a = b;
        }
        float[] fArr = this.f1888a;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr[i2] = k;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toFloatArray() {
        return Arrays.copyOf(this.f1888a, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatCollection, p014it.unimi.dsi.fastutil.floats.FloatCollection
    public float[] toArray(float[] a) {
        if (a == null || a.length < this.size) {
            a = new float[this.size];
        }
        System.arraycopy(this.f1888a, 0, a, 0, this.size);
        return a;
    }

    @Override // java.lang.Object
    public FloatArraySet clone() {
        try {
            FloatArraySet c = (FloatArraySet) clone();
            c.f1888a = (float[]) this.f1888a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeFloat(this.f1888a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1888a = new float[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1888a[i] = s.readFloat();
        }
    }
}
