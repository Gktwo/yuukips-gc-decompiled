package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.LongIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators.class */
public final class LongIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private LongIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$EmptyIterator.class */
    public static class EmptyIterator implements LongListIterator, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return LongIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return LongIterators.EMPTY_ITERATOR;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$SingletonIterator.class */
    public static class SingletonIterator implements LongListIterator {
        private final long element;
        private byte curr;

        public SingletonIterator(long element) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static LongListIterator singleton(long element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$ArrayIterator.class */
    private static class ArrayIterator implements LongListIterator {
        private final long[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(long[] array, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            long[] jArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return jArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            long[] jArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return jArr[i + i2];
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

    public static LongListIterator wrap(long[] array, int offset, int length) {
        LongArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static LongListIterator wrap(long[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    public static int unwrap(LongIterator i, long[] array, int offset, int max) {
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
                array[offset] = i.nextLong();
            }
            return (max - j) - 1;
        }
    }

    public static int unwrap(LongIterator i, long[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static long[] unwrap(LongIterator i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        long[] array = new long[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == array.length) {
                array = LongArrays.grow(array, j + 1);
            }
            j++;
            array[j] = i.nextLong();
        }
        return LongArrays.trim(array, j);
    }

    public static long[] unwrap(LongIterator i) {
        return unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static long unwrap(LongIterator i, long[][] array, long offset, long max) {
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
                BigArrays.set(array, (long) array, i.nextLong());
            }
            return (max - c) - 1;
        }
    }

    public static long unwrap(LongIterator i, long[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static int unwrap(LongIterator i, LongCollection c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.nextLong());
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
    public static long[][] unwrapBig(p014it.unimi.dsi.fastutil.longs.LongIterator r8, long r9) {
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
            long[][] r0 = p014it.unimi.dsi.fastutil.longs.LongBigArrays.newBigArray(r0)
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
            long[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            long r2 = r2.nextLong()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            long[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongIterators.unwrapBig(it.unimi.dsi.fastutil.longs.LongIterator, long):long[][]");
    }

    public static long[][] unwrapBig(LongIterator i) {
        return unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static long unwrap(LongIterator i, LongCollection c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.nextLong());
            n++;
        }
        return n;
    }

    public static int pour(LongIterator i, LongCollection s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.nextLong());
        }
        return (max - j) - 1;
    }

    public static int pour(LongIterator i, LongCollection s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static LongList pour(LongIterator i, int max) {
        LongArrayList l = new LongArrayList();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static LongList pour(LongIterator i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$IteratorWrapper.class */
    private static class IteratorWrapper implements LongIterator {

        /* renamed from: i */
        final Iterator<Long> f2383i;

        public IteratorWrapper(Iterator<Long> i) {
            this.f2383i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2383i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f2383i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return this.f2383i.next().longValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator
        public void forEachRemaining(LongConsumer action) {
            this.f2383i.forEachRemaining(action);
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Consumer<? super Long> consumer;
            Objects.requireNonNull(action);
            Iterator<Long> it = this.f2383i;
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
            this.f2383i.forEachRemaining(action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$PrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$PrimitiveIteratorWrapper.class */
    private static class PrimitiveIteratorWrapper implements LongIterator {

        /* renamed from: i */
        final PrimitiveIterator.OfLong f2385i;

        public PrimitiveIteratorWrapper(PrimitiveIterator.OfLong i) {
            this.f2385i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2385i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f2385i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return this.f2385i.nextLong();
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            this.f2385i.forEachRemaining(action);
        }
    }

    public static LongIterator asLongIterator(Iterator i) {
        return i instanceof LongIterator ? (LongIterator) i : i instanceof PrimitiveIterator.OfLong ? new PrimitiveIteratorWrapper((PrimitiveIterator.OfLong) i) : new IteratorWrapper(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper implements LongListIterator {

        /* renamed from: i */
        final ListIterator<Long> f2384i;

        public ListIteratorWrapper(ListIterator<Long> i) {
            this.f2384i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f2384i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2384i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2384i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2384i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
        public void set(long k) {
            this.f2384i.set(Long.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
        public void add(long k) {
            this.f2384i.add(Long.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f2384i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return this.f2384i.next().longValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return this.f2384i.previous().longValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator
        public void forEachRemaining(LongConsumer action) {
            this.f2384i.forEachRemaining(action);
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Consumer<? super Long> consumer;
            Objects.requireNonNull(action);
            ListIterator<Long> listIterator = this.f2384i;
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
            this.f2384i.forEachRemaining(action);
        }
    }

    public static LongListIterator asLongIterator(ListIterator i) {
        return i instanceof LongListIterator ? (LongListIterator) i : new ListIteratorWrapper(i);
    }

    public static boolean any(LongIterator iterator, LongPredicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static boolean all(LongIterator iterator, LongPredicate predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.nextLong())) {
                return false;
            }
        }
        return true;
    }

    public static int indexOf(LongIterator iterator, LongPredicate predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.nextLong())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator extends AbstractLongIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract long get(int i);

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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.longs.LongListIterator, java.util.ListIterator
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

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator extends AbstractIndexBasedIterator implements LongListIterator {
        protected abstract void add(int i, long j);

        protected abstract void set(int i, long j);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
        public void add(long k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongListIterator
        public void set(long k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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
    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$IntervalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$IntervalIterator.class */
    public static class IntervalIterator implements LongBidirectionalIterator {
        private final long from;

        /* renamed from: to */
        private final long f2381to;
        long curr;

        public IntervalIterator(long from, long to) {
            this.curr = from;
            this.from = from;
            this.f2381to = to;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.curr < this.f2381to;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr > this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            long j = this.curr;
            this.curr = j + 1;
            return j;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            long j = this.curr - 1;
            this.curr = j;
            return j;
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.f2381to) {
                action.accept(this.curr);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.curr + ((long) n) <= this.f2381to) {
                this.curr += (long) n;
                return n;
            } else {
                int n2 = (int) (this.f2381to - this.curr);
                this.curr = this.f2381to;
                return n2;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (this.curr - ((long) n) >= this.from) {
                this.curr -= (long) n;
                return n;
            }
            int n2 = (int) (this.curr - this.from);
            this.curr = this.from;
            return n2;
        }
    }

    public static LongBidirectionalIterator fromTo(long from, long to) {
        return new IntervalIterator(from, to);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator implements LongIterator {

        /* renamed from: a */
        final LongIterator[] f2382a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(LongIterator[] a, int offset, int length) {
            this.f2382a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f2382a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            LongIterator[] longIteratorArr = this.f2382a;
            int i = this.offset;
            this.lastOffset = i;
            long next = longIteratorArr[i].nextLong();
            advance();
            return next;
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            while (this.length > 0) {
                LongIterator[] longIteratorArr = this.f2382a;
                int i = this.offset;
                this.lastOffset = i;
                longIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
            while (this.length > 0) {
                LongIterator[] longIteratorArr = this.f2382a;
                int i = this.offset;
                this.lastOffset = i;
                longIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f2382a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f2382a[this.offset].skip(n - skipped);
                if (this.f2382a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    public static LongIterator concat(LongIterator... a) {
        return concat(a, 0, a.length);
    }

    public static LongIterator concat(LongIterator[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator implements LongIterator {

        /* renamed from: i */
        protected final LongIterator f2387i;

        public UnmodifiableIterator(LongIterator i) {
            this.f2387i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2387i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return this.f2387i.nextLong();
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            this.f2387i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
            this.f2387i.forEachRemaining(action);
        }
    }

    public static LongIterator unmodifiable(LongIterator i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator implements LongBidirectionalIterator {

        /* renamed from: i */
        protected final LongBidirectionalIterator f2386i;

        public UnmodifiableBidirectionalIterator(LongBidirectionalIterator i) {
            this.f2386i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2386i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2386i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return this.f2386i.nextLong();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return this.f2386i.previousLong();
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            this.f2386i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
            this.f2386i.forEachRemaining(action);
        }
    }

    public static LongBidirectionalIterator unmodifiable(LongBidirectionalIterator i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator implements LongListIterator {

        /* renamed from: i */
        protected final LongListIterator f2388i;

        public UnmodifiableListIterator(LongListIterator i) {
            this.f2388i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f2388i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2388i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return this.f2388i.nextLong();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator
        public long previousLong() {
            return this.f2388i.previousLong();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2388i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2388i.previousIndex();
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            this.f2388i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
            this.f2388i.forEachRemaining(action);
        }
    }

    public static LongListIterator unmodifiable(LongListIterator i) {
        return new UnmodifiableListIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$ByteIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$ByteIteratorWrapper.class */
    private static final class ByteIteratorWrapper implements LongIterator {
        final ByteIterator iterator;

        public ByteIteratorWrapper(ByteIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public Long next() {
            return Long.valueOf((long) this.iterator.nextByte());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return (long) this.iterator.nextByte();
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static LongIterator wrap(ByteIterator iterator) {
        return new ByteIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$ShortIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$ShortIteratorWrapper.class */
    private static final class ShortIteratorWrapper implements LongIterator {
        final ShortIterator iterator;

        public ShortIteratorWrapper(ShortIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public Long next() {
            return Long.valueOf((long) this.iterator.nextShort());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return (long) this.iterator.nextShort();
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static LongIterator wrap(ShortIterator iterator) {
        return new ShortIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$CharIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$CharIteratorWrapper.class */
    private static final class CharIteratorWrapper implements LongIterator {
        final CharIterator iterator;

        public CharIteratorWrapper(CharIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public Long next() {
            return Long.valueOf((long) this.iterator.nextChar());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return (long) this.iterator.nextChar();
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static LongIterator wrap(CharIterator iterator) {
        return new CharIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongIterators$IntIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIterators$IntIteratorWrapper.class */
    private static final class IntIteratorWrapper implements LongIterator {
        final IntIterator iterator;

        public IntIteratorWrapper(IntIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong, java.util.Iterator
        @Deprecated
        public Long next() {
            return Long.valueOf((long) this.iterator.nextInt());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            return (long) this.iterator.nextInt();
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            IntIterator intIterator = this.iterator;
            Objects.requireNonNull(action);
            intIterator.forEachRemaining((v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static LongIterator wrap(IntIterator iterator) {
        return new IntIteratorWrapper(iterator);
    }
}
