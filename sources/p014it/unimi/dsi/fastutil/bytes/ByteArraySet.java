package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArraySet.class */
public class ByteArraySet extends AbstractByteSet implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient byte[] f1257a;
    private int size;

    static /* synthetic */ int access$010(ByteArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public ByteArraySet(byte[] a) {
        this.f1257a = a;
        this.size = a.length;
    }

    public ByteArraySet() {
        this.f1257a = ByteArrays.EMPTY_ARRAY;
    }

    public ByteArraySet(int capacity) {
        this.f1257a = new byte[capacity];
    }

    public ByteArraySet(ByteCollection c) {
        this(c.size());
        addAll(c);
    }

    public ByteArraySet(Collection<? extends Byte> c) {
        this(c.size());
        addAll(c);
    }

    public ByteArraySet(ByteSet c) {
        this(c.size());
        int i = 0;
        Iterator<Byte> it = c.iterator();
        while (it.hasNext()) {
            this.f1257a[i] = it.next().byteValue();
            i++;
        }
        this.size = i;
    }

    public ByteArraySet(Set<? extends Byte> c) {
        this(c.size());
        int i = 0;
        for (Byte x : c) {
            this.f1257a[i] = x.byteValue();
            i++;
        }
        this.size = i;
    }

    public ByteArraySet(byte[] a, int size) {
        this.f1257a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static ByteArraySet m1091of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static ByteArraySet m1090of(byte e) {
        return ofUnchecked(e);
    }

    /* renamed from: of */
    public static ByteArraySet m1089of(byte... a) {
        if (a.length == 2) {
            if (a[0] == a[1]) {
                throw new IllegalArgumentException("Duplicate element: " + ((int) a[1]));
            }
        } else if (a.length > 2) {
            ByteOpenHashSet.m1044of(a);
        }
        return ofUnchecked(a);
    }

    public static ByteArraySet ofUnchecked() {
        return new ByteArraySet();
    }

    public static ByteArraySet ofUnchecked(byte... a) {
        return new ByteArraySet(a);
    }

    private int findKey(byte o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (this.f1257a[i] != o);
        return i;
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public Iterator<Byte> iterator() {
        return new ByteIterator() { // from class: it.unimi.dsi.fastutil.bytes.ByteArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < ByteArraySet.this.size;
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
            public byte nextByte() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                byte[] bArr = ByteArraySet.this.f1257a;
                int i = this.next;
                this.next = i + 1;
                return bArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = ByteArraySet.access$010(ByteArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(ByteArraySet.this.f1257a, this.next + 1, ByteArraySet.this.f1257a, this.next, access$010 - i);
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ByteArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = ByteArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteArraySet$Spliterator.class */
    public final class Spliterator implements ByteSpliterator {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ByteArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(ByteArraySet byteArraySet) {
            this(0, byteArraySet.size, false);
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
            return this.hasSplit ? this.max : ByteArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16721;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        public boolean tryAdvance(ByteConsumer action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            byte[] bArr = ByteArraySet.this.f1257a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(bArr[i]);
            return true;
        }

        public void forEachRemaining(ByteConsumer action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(ByteArraySet.this.f1257a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ByteSpliterator trySplit() {
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSpliterator' to match base method */
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public java.util.Spliterator<Byte> spliterator() {
        return new Spliterator(this);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean contains(byte k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteSet, p014it.unimi.dsi.fastutil.bytes.ByteSet
    public boolean remove(byte k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f1257a[pos + i] = this.f1257a[pos + i + 1];
        }
        this.size--;
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean add(byte k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f1257a.length) {
            byte[] b = new byte[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f1257a[i];
            }
            this.f1257a = b;
        }
        byte[] bArr = this.f1257a;
        int i2 = this.size;
        this.size = i2 + 1;
        bArr[i2] = k;
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

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toByteArray() {
        return Arrays.copyOf(this.f1257a, this.size);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toArray(byte[] a) {
        if (a == null || a.length < this.size) {
            a = new byte[this.size];
        }
        System.arraycopy(this.f1257a, 0, a, 0, this.size);
        return a;
    }

    @Override // java.lang.Object
    public ByteArraySet clone() {
        try {
            ByteArraySet c = (ByteArraySet) clone();
            c.f1257a = (byte[]) this.f1257a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeByte(this.f1257a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f1257a = new byte[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f1257a[i] = s.readByte();
        }
    }
}
