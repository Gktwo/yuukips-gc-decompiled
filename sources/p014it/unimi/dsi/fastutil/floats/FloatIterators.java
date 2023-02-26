package p014it.unimi.dsi.fastutil.floats;

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
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterators;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators.class */
public final class FloatIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private FloatIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$EmptyIterator.class */
    public static class EmptyIterator implements FloatListIterator, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return FloatIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return FloatIterators.EMPTY_ITERATOR;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$SingletonIterator.class */
    public static class SingletonIterator implements FloatListIterator {
        private final float element;
        private byte curr;

        public SingletonIterator(float element) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static FloatListIterator singleton(float element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$ArrayIterator.class */
    private static class ArrayIterator implements FloatListIterator {
        private final float[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(float[] array, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            float[] fArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return fArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            float[] fArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return fArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

    public static FloatListIterator wrap(float[] array, int offset, int length) {
        FloatArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static FloatListIterator wrap(float[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    public static int unwrap(FloatIterator i, float[] array, int offset, int max) {
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
                array[offset] = i.nextFloat();
            }
            return (max - j) - 1;
        }
    }

    public static int unwrap(FloatIterator i, float[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static float[] unwrap(FloatIterator i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        float[] array = new float[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == array.length) {
                array = FloatArrays.grow(array, j + 1);
            }
            j++;
            array[j] = i.nextFloat();
        }
        return FloatArrays.trim(array, j);
    }

    public static float[] unwrap(FloatIterator i) {
        return unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: float[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static long unwrap(FloatIterator i, float[][] array, long offset, long max) {
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
                BigArrays.set(array, (long) array, i.nextFloat());
            }
            return (max - c) - 1;
        }
    }

    public static long unwrap(FloatIterator i, float[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static int unwrap(FloatIterator i, FloatCollection c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.nextFloat());
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
    public static float[][] unwrapBig(p014it.unimi.dsi.fastutil.floats.FloatIterator r8, long r9) {
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
            float[][] r0 = p014it.unimi.dsi.fastutil.floats.FloatBigArrays.newBigArray(r0)
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
            float[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            float r2 = r2.nextFloat()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            float[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatIterators.unwrapBig(it.unimi.dsi.fastutil.floats.FloatIterator, long):float[][]");
    }

    public static float[][] unwrapBig(FloatIterator i) {
        return unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static long unwrap(FloatIterator i, FloatCollection c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.nextFloat());
            n++;
        }
        return n;
    }

    public static int pour(FloatIterator i, FloatCollection s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.nextFloat());
        }
        return (max - j) - 1;
    }

    public static int pour(FloatIterator i, FloatCollection s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static FloatList pour(FloatIterator i, int max) {
        FloatArrayList l = new FloatArrayList();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static FloatList pour(FloatIterator i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$IteratorWrapper.class */
    public static class IteratorWrapper implements FloatIterator {

        /* renamed from: i */
        final Iterator<Float> f1911i;

        public IteratorWrapper(Iterator<Float> i) {
            this.f1911i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1911i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1911i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return this.f1911i.next().floatValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            this.f1911i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
            this.f1911i.forEachRemaining(action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$PrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$PrimitiveIteratorWrapper.class */
    private static class PrimitiveIteratorWrapper implements FloatIterator {

        /* renamed from: i */
        final PrimitiveIterator.OfDouble f1913i;

        public PrimitiveIteratorWrapper(PrimitiveIterator.OfDouble i) {
            this.f1913i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1913i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1913i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return (float) this.f1913i.nextDouble();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            this.f1913i.forEachRemaining((DoubleConsumer) action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$CheckedPrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$CheckedPrimitiveIteratorWrapper.class */
    private static class CheckedPrimitiveIteratorWrapper extends PrimitiveIteratorWrapper {
        public CheckedPrimitiveIteratorWrapper(PrimitiveIterator.OfDouble i) {
            super(i);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.PrimitiveIteratorWrapper, p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return SafeMath.safeDoubleToFloat(this.f1913i.nextDouble());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterators.PrimitiveIteratorWrapper, p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            this.f1913i.forEachRemaining(value -> {
                action.accept(SafeMath.safeDoubleToFloat(value));
            });
        }
    }

    public static FloatIterator asFloatIterator(Iterator i) {
        return i instanceof FloatIterator ? (FloatIterator) i : new IteratorWrapper(i);
    }

    public static FloatIterator narrow(PrimitiveIterator.OfDouble i) {
        return new CheckedPrimitiveIteratorWrapper(i);
    }

    public static FloatIterator uncheckedNarrow(PrimitiveIterator.OfDouble i) {
        return new PrimitiveIteratorWrapper(i);
    }

    public static DoubleIterator widen(FloatIterator i) {
        return DoubleIterators.wrap(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper implements FloatListIterator {

        /* renamed from: i */
        final ListIterator<Float> f1912i;

        public ListIteratorWrapper(ListIterator<Float> i) {
            this.f1912i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1912i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1912i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1912i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1912i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
        public void set(float k) {
            this.f1912i.set(Float.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
        public void add(float k) {
            this.f1912i.add(Float.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f1912i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return this.f1912i.next().floatValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return this.f1912i.previous().floatValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            this.f1912i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
            this.f1912i.forEachRemaining(action);
        }
    }

    public static FloatListIterator asFloatIterator(ListIterator i) {
        return i instanceof FloatListIterator ? (FloatListIterator) i : new ListIteratorWrapper(i);
    }

    public static boolean any(FloatIterator iterator, FloatPredicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static boolean any(FloatIterator iterator, DoublePredicate predicate) {
        FloatPredicate floatPredicate;
        if (predicate instanceof FloatPredicate) {
            floatPredicate = (FloatPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            floatPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return any(iterator, floatPredicate);
    }

    public static boolean all(FloatIterator iterator, FloatPredicate predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.nextFloat())) {
                return false;
            }
        }
        return true;
    }

    public static boolean all(FloatIterator iterator, DoublePredicate predicate) {
        FloatPredicate floatPredicate;
        if (predicate instanceof FloatPredicate) {
            floatPredicate = (FloatPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            floatPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return all(iterator, floatPredicate);
    }

    public static int indexOf(FloatIterator iterator, FloatPredicate predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.nextFloat())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(FloatIterator iterator, DoublePredicate predicate) {
        FloatPredicate floatPredicate;
        if (predicate instanceof FloatPredicate) {
            floatPredicate = (FloatPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            floatPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return indexOf(iterator, floatPredicate);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator extends AbstractFloatIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract float get(int i);

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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.floats.FloatListIterator, java.util.ListIterator
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator extends AbstractIndexBasedIterator implements FloatListIterator {
        protected abstract void add(int i, float f);

        protected abstract void set(int i, float f);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
        public void add(float k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatListIterator
        public void set(float k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator implements FloatIterator {

        /* renamed from: a */
        final FloatIterator[] f1910a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(FloatIterator[] a, int offset, int length) {
            this.f1910a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f1910a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            FloatIterator[] floatIteratorArr = this.f1910a;
            int i = this.offset;
            this.lastOffset = i;
            float next = floatIteratorArr[i].nextFloat();
            advance();
            return next;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            while (this.length > 0) {
                FloatIterator[] floatIteratorArr = this.f1910a;
                int i = this.offset;
                this.lastOffset = i;
                floatIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
            while (this.length > 0) {
                FloatIterator[] floatIteratorArr = this.f1910a;
                int i = this.offset;
                this.lastOffset = i;
                floatIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f1910a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f1910a[this.offset].skip(n - skipped);
                if (this.f1910a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    public static FloatIterator concat(FloatIterator... a) {
        return concat(a, 0, a.length);
    }

    public static FloatIterator concat(FloatIterator[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator implements FloatIterator {

        /* renamed from: i */
        protected final FloatIterator f1915i;

        public UnmodifiableIterator(FloatIterator i) {
            this.f1915i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1915i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return this.f1915i.nextFloat();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            this.f1915i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
            this.f1915i.forEachRemaining(action);
        }
    }

    public static FloatIterator unmodifiable(FloatIterator i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator implements FloatBidirectionalIterator {

        /* renamed from: i */
        protected final FloatBidirectionalIterator f1914i;

        public UnmodifiableBidirectionalIterator(FloatBidirectionalIterator i) {
            this.f1914i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1914i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1914i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return this.f1914i.nextFloat();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return this.f1914i.previousFloat();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            this.f1914i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
            this.f1914i.forEachRemaining(action);
        }
    }

    public static FloatBidirectionalIterator unmodifiable(FloatBidirectionalIterator i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator implements FloatListIterator {

        /* renamed from: i */
        protected final FloatListIterator f1916i;

        public UnmodifiableListIterator(FloatListIterator i) {
            this.f1916i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1916i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1916i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return this.f1916i.nextFloat();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator
        public float previousFloat() {
            return this.f1916i.previousFloat();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1916i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1916i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            this.f1916i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
            this.f1916i.forEachRemaining(action);
        }
    }

    public static FloatListIterator unmodifiable(FloatListIterator i) {
        return new UnmodifiableListIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$ByteIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$ByteIteratorWrapper.class */
    private static final class ByteIteratorWrapper implements FloatIterator {
        final ByteIterator iterator;

        public ByteIteratorWrapper(ByteIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public Float next() {
            return Float.valueOf((float) this.iterator.nextByte());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return (float) this.iterator.nextByte();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static FloatIterator wrap(ByteIterator iterator) {
        return new ByteIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$ShortIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$ShortIteratorWrapper.class */
    private static final class ShortIteratorWrapper implements FloatIterator {
        final ShortIterator iterator;

        public ShortIteratorWrapper(ShortIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public Float next() {
            return Float.valueOf((float) this.iterator.nextShort());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return (float) this.iterator.nextShort();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static FloatIterator wrap(ShortIterator iterator) {
        return new ShortIteratorWrapper(iterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatIterators$CharIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIterators$CharIteratorWrapper.class */
    private static final class CharIteratorWrapper implements FloatIterator {
        final CharIterator iterator;

        public CharIteratorWrapper(CharIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, java.util.Iterator
        @Deprecated
        public Float next() {
            return Float.valueOf((float) this.iterator.nextChar());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            return (float) this.iterator.nextChar();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static FloatIterator wrap(CharIterator iterator) {
        return new CharIteratorWrapper(iterator);
    }
}
