package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators.class */
public final class DoubleIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private DoubleIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$EmptyIterator.class */
    public static class EmptyIterator implements DoubleListIterator, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Double> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return DoubleIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return DoubleIterators.EMPTY_ITERATOR;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$SingletonIterator.class */
    public static class SingletonIterator implements DoubleListIterator {
        private final double element;
        private byte curr;

        public SingletonIterator(double element) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static DoubleListIterator singleton(double element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$ArrayIterator.class */
    private static class ArrayIterator implements DoubleListIterator {
        private final double[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(double[] array, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            double[] dArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return dArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            double[] dArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return dArr[i + i2];
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

    public static DoubleListIterator wrap(double[] array, int offset, int length) {
        DoubleArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static DoubleListIterator wrap(double[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    public static int unwrap(DoubleIterator i, double[] array, int offset, int max) {
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
                array[offset] = i.nextDouble();
            }
            return (max - j) - 1;
        }
    }

    public static int unwrap(DoubleIterator i, double[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static double[] unwrap(DoubleIterator i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        double[] array = new double[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == array.length) {
                array = DoubleArrays.grow(array, j + 1);
            }
            j++;
            array[j] = i.nextDouble();
        }
        return DoubleArrays.trim(array, j);
    }

    public static double[] unwrap(DoubleIterator i) {
        return unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: double[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static long unwrap(DoubleIterator i, double[][] array, long offset, long max) {
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
                BigArrays.set(array, (long) array, i.nextDouble());
            }
            return (max - c) - 1;
        }
    }

    public static long unwrap(DoubleIterator i, double[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static int unwrap(DoubleIterator i, DoubleCollection c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.nextDouble());
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
    public static double[][] unwrapBig(p014it.unimi.dsi.fastutil.doubles.DoubleIterator r8, long r9) {
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
            double[][] r0 = p014it.unimi.dsi.fastutil.doubles.DoubleBigArrays.newBigArray(r0)
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
            double[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            double r2 = r2.nextDouble()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            double[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleIterators.unwrapBig(it.unimi.dsi.fastutil.doubles.DoubleIterator, long):double[][]");
    }

    public static double[][] unwrapBig(DoubleIterator i) {
        return unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static long unwrap(DoubleIterator i, DoubleCollection c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.nextDouble());
            n++;
        }
        return n;
    }

    public static int pour(DoubleIterator i, DoubleCollection s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.nextDouble());
        }
        return (max - j) - 1;
    }

    public static int pour(DoubleIterator i, DoubleCollection s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static DoubleList pour(DoubleIterator i, int max) {
        DoubleArrayList l = new DoubleArrayList();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static DoubleList pour(DoubleIterator i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$IteratorWrapper.class */
    private static class IteratorWrapper implements DoubleIterator {

        /* renamed from: i */
        final Iterator<Double> f1726i;

        public IteratorWrapper(Iterator<Double> i) {
            this.f1726i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1726i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1726i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return this.f1726i.next().doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator
        public void forEachRemaining(DoubleConsumer action) {
            this.f1726i.forEachRemaining(action);
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            Consumer<? super Double> consumer;
            Objects.requireNonNull(action);
            Iterator<Double> it = this.f1726i;
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Double> action) {
            this.f1726i.forEachRemaining(action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$PrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$PrimitiveIteratorWrapper.class */
    private static class PrimitiveIteratorWrapper implements DoubleIterator {

        /* renamed from: i */
        final PrimitiveIterator.OfDouble f1728i;

        public PrimitiveIteratorWrapper(PrimitiveIterator.OfDouble i) {
            this.f1728i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1728i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1728i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return this.f1728i.nextDouble();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            this.f1728i.forEachRemaining(action);
        }
    }

    public static DoubleIterator asDoubleIterator(Iterator i) {
        return i instanceof DoubleIterator ? (DoubleIterator) i : i instanceof PrimitiveIterator.OfDouble ? new PrimitiveIteratorWrapper((PrimitiveIterator.OfDouble) i) : new IteratorWrapper(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper implements DoubleListIterator {

        /* renamed from: i */
        final ListIterator<Double> f1727i;

        public ListIteratorWrapper(ListIterator<Double> i) {
            this.f1727i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1727i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1727i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1727i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1727i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
        public void set(double k) {
            this.f1727i.set(Double.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
        public void add(double k) {
            this.f1727i.add(Double.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f1727i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return this.f1727i.next().doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return this.f1727i.previous().doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator
        public void forEachRemaining(DoubleConsumer action) {
            this.f1727i.forEachRemaining(action);
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            Consumer<? super Double> consumer;
            Objects.requireNonNull(action);
            ListIterator<Double> listIterator = this.f1727i;
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Double> action) {
            this.f1727i.forEachRemaining(action);
        }
    }

    public static DoubleListIterator asDoubleIterator(ListIterator i) {
        return i instanceof DoubleListIterator ? (DoubleListIterator) i : new ListIteratorWrapper(i);
    }

    public static boolean any(DoubleIterator iterator, DoublePredicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static boolean all(DoubleIterator iterator, DoublePredicate predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.nextDouble())) {
                return false;
            }
        }
        return true;
    }

    public static int indexOf(DoubleIterator iterator, DoublePredicate predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.nextDouble())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator extends AbstractDoubleIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract double get(int i);

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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.doubles.DoubleListIterator, java.util.ListIterator
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

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator extends AbstractIndexBasedIterator implements DoubleListIterator {
        protected abstract void add(int i, double d);

        protected abstract void set(int i, double d);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
        public void add(double k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleListIterator
        public void set(double k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator implements DoubleIterator {

        /* renamed from: a */
        final DoubleIterator[] f1725a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(DoubleIterator[] a, int offset, int length) {
            this.f1725a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f1725a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            DoubleIterator[] doubleIteratorArr = this.f1725a;
            int i = this.offset;
            this.lastOffset = i;
            double next = doubleIteratorArr[i].nextDouble();
            advance();
            return next;
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            while (this.length > 0) {
                DoubleIterator[] doubleIteratorArr = this.f1725a;
                int i = this.offset;
                this.lastOffset = i;
                doubleIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Double> action) {
            while (this.length > 0) {
                DoubleIterator[] doubleIteratorArr = this.f1725a;
                int i = this.offset;
                this.lastOffset = i;
                doubleIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f1725a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f1725a[this.offset].skip(n - skipped);
                if (this.f1725a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    public static DoubleIterator concat(DoubleIterator... a) {
        return concat(a, 0, a.length);
    }

    public static DoubleIterator concat(DoubleIterator[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator implements DoubleIterator {

        /* renamed from: i */
        protected final DoubleIterator f1730i;

        public UnmodifiableIterator(DoubleIterator i) {
            this.f1730i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1730i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return this.f1730i.nextDouble();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            this.f1730i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Double> action) {
            this.f1730i.forEachRemaining(action);
        }
    }

    public static DoubleIterator unmodifiable(DoubleIterator i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator implements DoubleBidirectionalIterator {

        /* renamed from: i */
        protected final DoubleBidirectionalIterator f1729i;

        public UnmodifiableBidirectionalIterator(DoubleBidirectionalIterator i) {
            this.f1729i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1729i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1729i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return this.f1729i.nextDouble();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return this.f1729i.previousDouble();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            this.f1729i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Double> action) {
            this.f1729i.forEachRemaining(action);
        }
    }

    public static DoubleBidirectionalIterator unmodifiable(DoubleBidirectionalIterator i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator implements DoubleListIterator {

        /* renamed from: i */
        protected final DoubleListIterator f1731i;

        public UnmodifiableListIterator(DoubleListIterator i) {
            this.f1731i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1731i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1731i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return this.f1731i.nextDouble();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator
        public double previousDouble() {
            return this.f1731i.previousDouble();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1731i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1731i.previousIndex();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            this.f1731i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Double> action) {
            this.f1731i.forEachRemaining(action);
        }
    }

    public static DoubleListIterator unmodifiable(DoubleListIterator i) {
        return new UnmodifiableListIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$ByteIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$ByteIteratorWrapper.class */
    private static final class ByteIteratorWrapper implements DoubleIterator {
        final ByteIterator iterator;

        public ByteIteratorWrapper(ByteIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public Double next() {
            return Double.valueOf((double) this.iterator.nextByte());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return (double) this.iterator.nextByte();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static DoubleIterator wrap(ByteIterator iterator) {
        return new ByteIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$ShortIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$ShortIteratorWrapper.class */
    private static final class ShortIteratorWrapper implements DoubleIterator {
        final ShortIterator iterator;

        public ShortIteratorWrapper(ShortIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public Double next() {
            return Double.valueOf((double) this.iterator.nextShort());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return (double) this.iterator.nextShort();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static DoubleIterator wrap(ShortIterator iterator) {
        return new ShortIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$CharIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$CharIteratorWrapper.class */
    private static final class CharIteratorWrapper implements DoubleIterator {
        final CharIterator iterator;

        public CharIteratorWrapper(CharIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public Double next() {
            return Double.valueOf((double) this.iterator.nextChar());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return (double) this.iterator.nextChar();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static DoubleIterator wrap(CharIterator iterator) {
        return new CharIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$IntIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$IntIteratorWrapper.class */
    private static final class IntIteratorWrapper implements DoubleIterator {
        final IntIterator iterator;

        public IntIteratorWrapper(IntIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public Double next() {
            return Double.valueOf((double) this.iterator.nextInt());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return (double) this.iterator.nextInt();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static DoubleIterator wrap(IntIterator iterator) {
        return new IntIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIterators$FloatIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIterators$FloatIteratorWrapper.class */
    private static final class FloatIteratorWrapper implements DoubleIterator {
        final FloatIterator iterator;

        public FloatIteratorWrapper(FloatIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
        @Deprecated
        public Double next() {
            return Double.valueOf((double) this.iterator.nextFloat());
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            return (double) this.iterator.nextFloat();
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            Objects.requireNonNull(action);
            FloatIterator floatIterator = this.iterator;
            Objects.requireNonNull(action);
            floatIterator.forEachRemaining((v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static DoubleIterator wrap(FloatIterator iterator) {
        return new FloatIteratorWrapper(iterator);
    }
}
