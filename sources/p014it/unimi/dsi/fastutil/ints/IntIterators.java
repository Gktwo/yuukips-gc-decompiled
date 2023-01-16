package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.IntIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators.class */
public final class IntIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private IntIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$EmptyIterator.class */
    public static class EmptyIterator implements IntListIterator, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyIterator() {
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return 0;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return IntIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return IntIterators.EMPTY_ITERATOR;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$SingletonIterator.class */
    public static class SingletonIterator implements IntListIterator {
        private final int element;
        private byte curr;

        public SingletonIterator(int element) {
            this.element = element;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.curr == 0;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr == 1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            if (this.curr == 0) {
                action.accept(this.element);
                this.curr = 1;
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.curr;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.curr - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n == 0 || this.curr < 1) {
                return 0;
            } else {
                this.curr = 1;
                return 1;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n == 0 || this.curr > 0) {
                return 0;
            } else {
                this.curr = 0;
                return 1;
            }
        }
    }

    public static IntListIterator singleton(int element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$ArrayIterator.class */
    private static class ArrayIterator implements IntListIterator {
        private final int[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(int[] array, int offset, int length) {
            this.array = array;
            this.offset = offset;
            this.length = length;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.curr < this.length;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int[] iArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return iArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int[] iArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return iArr[i + i2];
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n <= this.length - this.curr) {
                this.curr += n;
                return n;
            } else {
                int n2 = this.length - this.curr;
                this.curr = this.length;
                return n2;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n <= this.curr) {
                this.curr -= n;
                return n;
            } else {
                int n2 = this.curr;
                this.curr = 0;
                return n2;
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.curr;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.curr - 1;
        }
    }

    public static IntListIterator wrap(int[] array, int offset, int length) {
        IntArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static IntListIterator wrap(int[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    public static int unwrap(IntIterator i, int[] array, int offset, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        } else if (offset < 0 || offset + max > array.length) {
            throw new IllegalArgumentException();
        } else {
            int j = max;
            while (true) {
                j--;
                if (j == 0 || !i.hasNext()) {
                    break;
                }
                offset++;
                array[offset] = i.nextInt();
            }
            return (max - j) - 1;
        }
    }

    public static int unwrap(IntIterator i, int[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static int[] unwrap(IntIterator i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int[] array = new int[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == array.length) {
                array = IntArrays.grow(array, j + 1);
            }
            j++;
            array[j] = i.nextInt();
        }
        return IntArrays.trim(array, j);
    }

    public static int[] unwrap(IntIterator i) {
        return unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: int[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static long unwrap(IntIterator i, int[][] array, long offset, long max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        } else if (offset < 0 || offset + max > BigArrays.length(array)) {
            throw new IllegalArgumentException();
        } else {
            char c = max;
            while (true) {
                c--;
                if (c == 0 || !i.hasNext()) {
                    break;
                }
                offset++;
                BigArrays.set(array, (long) array, i.nextInt());
            }
            return (max - c) - 1;
        }
    }

    public static long unwrap(IntIterator i, int[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static int unwrap(IntIterator i, IntCollection c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.nextInt());
        }
        return (max - j) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[][] unwrapBig(p014it.unimi.dsi.fastutil.ints.IntIterator r8, long r9) {
        /*
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0026
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "The maximum number of elements ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r9
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is negative"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0026:
            r0 = 16
            int[][] r0 = p014it.unimi.dsi.fastutil.ints.IntBigArrays.newBigArray(r0)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0030:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x006a
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x006a
            r0 = r12
            r1 = r11
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.length(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0056
            r0 = r11
            r1 = r12
            r2 = 1
            long r1 = r1 + r2
            int[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            int r2 = r2.nextInt()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            int[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.ints.IntIterators.unwrapBig(it.unimi.dsi.fastutil.ints.IntIterator, long):int[][]");
    }

    public static int[][] unwrapBig(IntIterator i) {
        return unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static long unwrap(IntIterator i, IntCollection c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.nextInt());
            n++;
        }
        return n;
    }

    public static int pour(IntIterator i, IntCollection s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.nextInt());
        }
        return (max - j) - 1;
    }

    public static int pour(IntIterator i, IntCollection s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static IntList pour(IntIterator i, int max) {
        IntArrayList l = new IntArrayList();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static IntList pour(IntIterator i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$IteratorWrapper.class */
    public static class IteratorWrapper implements IntIterator {

        /* renamed from: i */
        final Iterator<Integer> f2177i;

        public IteratorWrapper(Iterator<Integer> i) {
            this.f2177i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2177i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f2177i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.f2177i.next().intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator
        public void forEachRemaining(IntConsumer action) {
            this.f2177i.forEachRemaining(action);
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            Consumer<? super Integer> consumer;
            Objects.requireNonNull(action);
            Iterator<Integer> it = this.f2177i;
            if (action instanceof Consumer) {
                consumer = (Consumer) action;
            } else {
                Objects.requireNonNull(action);
                consumer = (v1) -> {
                    r1.accept(v1);
                };
            }
            it.forEachRemaining(consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> action) {
            this.f2177i.forEachRemaining(action);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$PrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$PrimitiveIteratorWrapper.class */
    public static class PrimitiveIteratorWrapper implements IntIterator {

        /* renamed from: i */
        final PrimitiveIterator.OfInt f2179i;

        public PrimitiveIteratorWrapper(PrimitiveIterator.OfInt i) {
            this.f2179i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2179i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f2179i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.f2179i.nextInt();
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            this.f2179i.forEachRemaining(action);
        }
    }

    public static IntIterator asIntIterator(Iterator i) {
        return i instanceof IntIterator ? (IntIterator) i : i instanceof PrimitiveIterator.OfInt ? new PrimitiveIteratorWrapper((PrimitiveIterator.OfInt) i) : new IteratorWrapper(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper implements IntListIterator {

        /* renamed from: i */
        final ListIterator<Integer> f2178i;

        public ListIteratorWrapper(ListIterator<Integer> i) {
            this.f2178i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f2178i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2178i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2178i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2178i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator
        public void set(int k) {
            this.f2178i.set(Integer.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator
        public void add(int k) {
            this.f2178i.add(Integer.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f2178i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.f2178i.next().intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return this.f2178i.previous().intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator
        public void forEachRemaining(IntConsumer action) {
            this.f2178i.forEachRemaining(action);
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            Consumer<? super Integer> consumer;
            Objects.requireNonNull(action);
            ListIterator<Integer> listIterator = this.f2178i;
            if (action instanceof Consumer) {
                consumer = (Consumer) action;
            } else {
                Objects.requireNonNull(action);
                consumer = (v1) -> {
                    r1.accept(v1);
                };
            }
            listIterator.forEachRemaining(consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> action) {
            this.f2178i.forEachRemaining(action);
        }
    }

    public static IntListIterator asIntIterator(ListIterator i) {
        return i instanceof IntListIterator ? (IntListIterator) i : new ListIteratorWrapper(i);
    }

    public static boolean any(IntIterator iterator, IntPredicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static boolean all(IntIterator iterator, IntPredicate predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.nextInt())) {
                return false;
            }
        }
        return true;
    }

    public static int indexOf(IntIterator iterator, IntPredicate predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.nextInt())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator extends AbstractIntIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract int get(int i);

        protected abstract void remove(int i);

        protected abstract int getMaxPos();

        protected AbstractIndexBasedIterator(int minPos, int initialPos) {
            this.minPos = minPos;
            this.pos = initialPos;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos < getMaxPos();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.ints.IntListIterator, java.util.ListIterator
        public void remove() {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            remove(this.lastReturned);
            if (this.lastReturned < this.pos) {
                this.pos--;
            }
            this.lastReturned = -1;
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int max = getMaxPos();
            int remaining = max - this.pos;
            if (n < remaining) {
                this.pos += n;
            } else {
                n = remaining;
                this.pos = max;
            }
            this.lastReturned = this.pos - 1;
            return n;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator extends AbstractIndexBasedIterator implements IntListIterator {
        protected abstract void add(int i, int i2);

        protected abstract void set(int i, int i2);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i = this.pos - 1;
            this.pos = i;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.pos;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.pos - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator
        public void add(int k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntListIterator
        public void set(int k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int remaining = this.pos - this.minPos;
            if (n < remaining) {
                this.pos -= n;
            } else {
                n = remaining;
                this.pos = this.minPos;
            }
            this.lastReturned = this.pos;
            return n;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$IntervalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$IntervalIterator.class */
    public static class IntervalIterator implements IntListIterator {
        private final int from;

        /* renamed from: to */
        private final int f2175to;
        int curr;

        public IntervalIterator(int from, int to) {
            this.curr = from;
            this.from = from;
            this.f2175to = to;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.curr < this.f2175to;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr > this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.curr;
            this.curr = i + 1;
            return i;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i = this.curr - 1;
            this.curr = i;
            return i;
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.f2175to) {
                action.accept(this.curr);
                this.curr++;
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.curr - this.from;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.curr - this.from) - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.curr + n <= this.f2175to) {
                this.curr += n;
                return n;
            } else {
                int n2 = this.f2175to - this.curr;
                this.curr = this.f2175to;
                return n2;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (this.curr - n >= this.from) {
                this.curr -= n;
                return n;
            }
            int n2 = this.curr - this.from;
            this.curr = this.from;
            return n2;
        }
    }

    public static IntListIterator fromTo(int from, int to) {
        return new IntervalIterator(from, to);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator implements IntIterator {

        /* renamed from: a */
        final IntIterator[] f2176a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(IntIterator[] a, int offset, int length) {
            this.f2176a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f2176a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            IntIterator[] intIteratorArr = this.f2176a;
            int i = this.offset;
            this.lastOffset = i;
            int next = intIteratorArr[i].nextInt();
            advance();
            return next;
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            while (this.length > 0) {
                IntIterator[] intIteratorArr = this.f2176a;
                int i = this.offset;
                this.lastOffset = i;
                intIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> action) {
            while (this.length > 0) {
                IntIterator[] intIteratorArr = this.f2176a;
                int i = this.offset;
                this.lastOffset = i;
                intIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f2176a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f2176a[this.offset].skip(n - skipped);
                if (this.f2176a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    public static IntIterator concat(IntIterator... a) {
        return concat(a, 0, a.length);
    }

    public static IntIterator concat(IntIterator[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator implements IntIterator {

        /* renamed from: i */
        protected final IntIterator f2181i;

        public UnmodifiableIterator(IntIterator i) {
            this.f2181i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2181i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.f2181i.nextInt();
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            this.f2181i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> action) {
            this.f2181i.forEachRemaining(action);
        }
    }

    public static IntIterator unmodifiable(IntIterator i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator implements IntBidirectionalIterator {

        /* renamed from: i */
        protected final IntBidirectionalIterator f2180i;

        public UnmodifiableBidirectionalIterator(IntBidirectionalIterator i) {
            this.f2180i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2180i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2180i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.f2180i.nextInt();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return this.f2180i.previousInt();
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            this.f2180i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> action) {
            this.f2180i.forEachRemaining(action);
        }
    }

    public static IntBidirectionalIterator unmodifiable(IntBidirectionalIterator i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator implements IntListIterator {

        /* renamed from: i */
        protected final IntListIterator f2182i;

        public UnmodifiableListIterator(IntListIterator i) {
            this.f2182i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f2182i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2182i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.f2182i.nextInt();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntBidirectionalIterator
        public int previousInt() {
            return this.f2182i.previousInt();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2182i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2182i.previousIndex();
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            this.f2182i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Integer> action) {
            this.f2182i.forEachRemaining(action);
        }
    }

    public static IntListIterator unmodifiable(IntListIterator i) {
        return new UnmodifiableListIterator(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$ByteIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$ByteIteratorWrapper.class */
    public static final class ByteIteratorWrapper implements IntIterator {
        final ByteIterator iterator;

        public ByteIteratorWrapper(ByteIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public Integer next() {
            return Integer.valueOf(this.iterator.nextByte());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.iterator.nextByte();
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            ByteIterator byteIterator = this.iterator;
            Objects.requireNonNull(action);
            byteIterator.forEachRemaining((v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static IntIterator wrap(ByteIterator iterator) {
        return new ByteIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$ShortIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$ShortIteratorWrapper.class */
    private static final class ShortIteratorWrapper implements IntIterator {
        final ShortIterator iterator;

        public ShortIteratorWrapper(ShortIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public Integer next() {
            return Integer.valueOf(this.iterator.nextShort());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.iterator.nextShort();
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            ShortIterator shortIterator = this.iterator;
            Objects.requireNonNull(action);
            shortIterator.forEachRemaining((v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static IntIterator wrap(ShortIterator iterator) {
        return new ShortIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntIterators$CharIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIterators$CharIteratorWrapper.class */
    private static final class CharIteratorWrapper implements IntIterator {
        final CharIterator iterator;

        public CharIteratorWrapper(CharIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt, java.util.Iterator
        @Deprecated
        public Integer next() {
            return Integer.valueOf(this.iterator.nextChar());
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            return this.iterator.nextChar();
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            CharIterator charIterator = this.iterator;
            Objects.requireNonNull(action);
            charIterator.forEachRemaining((v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static IntIterator wrap(CharIterator iterator) {
        return new CharIteratorWrapper(iterator);
    }
}
