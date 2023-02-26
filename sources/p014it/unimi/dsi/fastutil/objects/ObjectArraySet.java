package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectArraySet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArraySet.class */
public class ObjectArraySet<K> extends AbstractObjectSet<K> implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient Object[] f2648a;
    private int size;

    static /* synthetic */ int access$010(ObjectArraySet x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public ObjectArraySet(Object[] a) {
        this.f2648a = a;
        this.size = a.length;
    }

    public ObjectArraySet() {
        this.f2648a = ObjectArrays.EMPTY_ARRAY;
    }

    public ObjectArraySet(int capacity) {
        this.f2648a = new Object[capacity];
    }

    public ObjectArraySet(ObjectCollection<K> c) {
        this(c.size());
        addAll(c);
    }

    public ObjectArraySet(Collection<? extends K> c) {
        this(c.size());
        addAll(c);
    }

    public ObjectArraySet(ObjectSet<K> c) {
        this(c.size());
        int i = 0;
        ObjectIterator<K> it = c.iterator();
        while (it.hasNext()) {
            this.f2648a[i] = it.next();
            i++;
        }
        this.size = i;
    }

    public ObjectArraySet(Set<? extends K> c) {
        this(c.size());
        int i = 0;
        Iterator<? extends K> it = c.iterator();
        while (it.hasNext()) {
            this.f2648a[i] = it.next();
            i++;
        }
        this.size = i;
    }

    public ObjectArraySet(Object[] a, int size) {
        this.f2648a = a;
        this.size = size;
        if (size > a.length) {
            throw new IllegalArgumentException("The provided size (" + size + ") is larger than or equal to the array size (" + a.length + ")");
        }
    }

    /* renamed from: of */
    public static <K> ObjectArraySet<K> m583of() {
        return ofUnchecked();
    }

    /* renamed from: of */
    public static <K> ObjectArraySet<K> m582of(K e) {
        return ofUnchecked(e);
    }

    @SafeVarargs
    /* renamed from: of */
    public static <K> ObjectArraySet<K> m581of(K... a) {
        if (a.length == 2) {
            if (Objects.equals(a[0], a[1])) {
                throw new IllegalArgumentException("Duplicate element: " + a[1]);
            }
        } else if (a.length > 2) {
            ObjectOpenHashSet.m538of((Object[]) a);
        }
        return ofUnchecked(a);
    }

    public static <K> ObjectArraySet<K> ofUnchecked() {
        return new ObjectArraySet<>();
    }

    @SafeVarargs
    public static <K> ObjectArraySet<K> ofUnchecked(K... a) {
        return new ObjectArraySet<>(a);
    }

    private int findKey(Object o) {
        int i = this.size;
        do {
            i--;
            if (i == 0) {
                return -1;
            }
        } while (!Objects.equals(this.f2648a[i], o));
        return i;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    public ObjectIterator<K> iterator() {
        return new ObjectIterator<K>() { // from class: it.unimi.dsi.fastutil.objects.ObjectArraySet.1
            int next = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next < ObjectArraySet.this.size;
            }

            @Override // java.util.Iterator
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = ObjectArraySet.this.f2648a;
                int i = this.next;
                this.next = i + 1;
                return (K) objArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int access$010 = ObjectArraySet.access$010(ObjectArraySet.this);
                int i = this.next;
                this.next = i - 1;
                System.arraycopy(ObjectArraySet.this.f2648a, this.next + 1, ObjectArraySet.this.f2648a, this.next, access$010 - i);
                ObjectArraySet.this.f2648a[ObjectArraySet.this.size] = null;
            }

            @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int remaining = ObjectArraySet.this.size - this.next;
                if (n < remaining) {
                    this.next += n;
                    return n;
                }
                this.next = ObjectArraySet.this.size;
                return remaining;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArraySet$Spliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArraySet$Spliterator.class */
    public final class Spliterator implements ObjectSpliterator<K> {
        boolean hasSplit;
        int pos;
        int max;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ObjectArraySet.class.desiredAssertionStatus();
        }

        public Spliterator(ObjectArraySet objectArraySet) {
            this(0, objectArraySet.size, false);
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
            return this.hasSplit ? this.max : ObjectArraySet.this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16465;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (getWorkingMax() - this.pos);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.pos >= getWorkingMax()) {
                return false;
            }
            Object[] objArr = ObjectArraySet.this.f2648a;
            int i = this.pos;
            this.pos = i + 1;
            action.accept(objArr[i]);
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            int max = getWorkingMax();
            while (this.pos < max) {
                action.accept(ObjectArraySet.this.f2648a[this.pos]);
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
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

    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    public ObjectSpliterator<K> spliterator() {
        return new Spliterator(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object k) {
        return findKey(k) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object k) {
        int pos = findKey(k);
        if (pos == -1) {
            return false;
        }
        int tail = (this.size - pos) - 1;
        for (int i = 0; i < tail; i++) {
            this.f2648a[pos + i] = this.f2648a[pos + i + 1];
        }
        this.size--;
        this.f2648a[this.size] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(K k) {
        if (findKey(k) != -1) {
            return false;
        }
        if (this.size == this.f2648a.length) {
            Object[] b = new Object[this.size == 0 ? 2 : this.size * 2];
            int i = this.size;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                b[i] = this.f2648a[i];
            }
            this.f2648a = b;
        }
        Object[] objArr = this.f2648a;
        int i2 = this.size;
        this.size = i2 + 1;
        objArr[i2] = k;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Arrays.fill(this.f2648a, 0, this.size, (Object) null);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.f2648a, this.size, Object[].class);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <K> K[] toArray(K[] a) {
        if (a == null) {
            a = (K[]) new Object[this.size];
        } else if (a.length < this.size) {
            a = (K[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), this.size));
        }
        System.arraycopy(this.f2648a, 0, a, 0, this.size);
        if (a.length > this.size) {
            a[this.size] = null;
        }
        return a;
    }

    @Override // java.lang.Object
    public ObjectArraySet<K> clone() {
        try {
            ObjectArraySet<K> c = (ObjectArraySet) clone();
            c.f2648a = (Object[]) this.f2648a.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        for (int i = 0; i < this.size; i++) {
            s.writeObject(this.f2648a[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.f2648a = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.f2648a[i] = s.readObject();
        }
    }
}
