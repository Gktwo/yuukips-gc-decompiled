package p014it.unimi.dsi.fastutil.shorts;

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
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators.class */
public final class ShortIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private ShortIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$EmptyIterator.class */
    public static class EmptyIterator implements ShortListIterator, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return ShortIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return ShortIterators.EMPTY_ITERATOR;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$SingletonIterator.class */
    public static class SingletonIterator implements ShortListIterator {
        private final short element;
        private byte curr;

        public SingletonIterator(short element) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static ShortListIterator singleton(short element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$ArrayIterator.class */
    private static class ArrayIterator implements ShortListIterator {
        private final short[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(short[] array, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            short[] sArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return sArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            short[] sArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return sArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

    public static ShortListIterator wrap(short[] array, int offset, int length) {
        ShortArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static ShortListIterator wrap(short[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    public static int unwrap(ShortIterator i, short[] array, int offset, int max) {
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
                array[offset] = i.nextShort();
            }
            return (max - j) - 1;
        }
    }

    public static int unwrap(ShortIterator i, short[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static short[] unwrap(ShortIterator i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        short[] array = new short[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == array.length) {
                array = ShortArrays.grow(array, j + 1);
            }
            j++;
            array[j] = i.nextShort();
        }
        return ShortArrays.trim(array, j);
    }

    public static short[] unwrap(ShortIterator i) {
        return unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: short[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static long unwrap(ShortIterator i, short[][] array, long offset, long max) {
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
                BigArrays.set(array, (long) array, i.nextShort());
            }
            return (max - c) - 1;
        }
    }

    public static long unwrap(ShortIterator i, short[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static int unwrap(ShortIterator i, ShortCollection c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.nextShort());
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
    public static short[][] unwrapBig(p014it.unimi.dsi.fastutil.shorts.ShortIterator r8, long r9) {
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
            short[][] r0 = p014it.unimi.dsi.fastutil.shorts.ShortBigArrays.newBigArray(r0)
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
            short[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            short r2 = r2.nextShort()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            short[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortIterators.unwrapBig(it.unimi.dsi.fastutil.shorts.ShortIterator, long):short[][]");
    }

    public static short[][] unwrapBig(ShortIterator i) {
        return unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static long unwrap(ShortIterator i, ShortCollection c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.nextShort());
            n++;
        }
        return n;
    }

    public static int pour(ShortIterator i, ShortCollection s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.nextShort());
        }
        return (max - j) - 1;
    }

    public static int pour(ShortIterator i, ShortCollection s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static ShortList pour(ShortIterator i, int max) {
        ShortArrayList l = new ShortArrayList();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static ShortList pour(ShortIterator i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$IteratorWrapper.class */
    private static class IteratorWrapper implements ShortIterator {

        /* renamed from: i */
        final Iterator<Short> f3049i;

        public IteratorWrapper(Iterator<Short> i) {
            this.f3049i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3049i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f3049i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return this.f3049i.next().shortValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3049i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            this.f3049i.forEachRemaining(action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$PrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$PrimitiveIteratorWrapper.class */
    private static class PrimitiveIteratorWrapper implements ShortIterator {

        /* renamed from: i */
        final PrimitiveIterator.OfInt f3051i;

        public PrimitiveIteratorWrapper(PrimitiveIterator.OfInt i) {
            this.f3051i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3051i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f3051i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return (short) this.f3051i.nextInt();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3051i.forEachRemaining((IntConsumer) action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$CheckedPrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$CheckedPrimitiveIteratorWrapper.class */
    private static class CheckedPrimitiveIteratorWrapper extends PrimitiveIteratorWrapper {
        public CheckedPrimitiveIteratorWrapper(PrimitiveIterator.OfInt i) {
            super(i);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.PrimitiveIteratorWrapper, p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return SafeMath.safeIntToShort(this.f3051i.nextInt());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterators.PrimitiveIteratorWrapper, p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3051i.forEachRemaining(value -> {
                action.accept(SafeMath.safeIntToShort(value));
            });
        }
    }

    public static ShortIterator asShortIterator(Iterator i) {
        return i instanceof ShortIterator ? (ShortIterator) i : new IteratorWrapper(i);
    }

    public static ShortIterator narrow(PrimitiveIterator.OfInt i) {
        return new CheckedPrimitiveIteratorWrapper(i);
    }

    public static ShortIterator uncheckedNarrow(PrimitiveIterator.OfInt i) {
        return new PrimitiveIteratorWrapper(i);
    }

    public static IntIterator widen(ShortIterator i) {
        return IntIterators.wrap(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper implements ShortListIterator {

        /* renamed from: i */
        final ListIterator<Short> f3050i;

        public ListIteratorWrapper(ListIterator<Short> i) {
            this.f3050i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f3050i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f3050i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f3050i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f3050i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
        public void set(short k) {
            this.f3050i.set(Short.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
        public void add(short k) {
            this.f3050i.add(Short.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f3050i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return this.f3050i.next().shortValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f3050i.previous().shortValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3050i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            this.f3050i.forEachRemaining(action);
        }
    }

    public static ShortListIterator asShortIterator(ListIterator i) {
        return i instanceof ShortListIterator ? (ShortListIterator) i : new ListIteratorWrapper(i);
    }

    public static boolean any(ShortIterator iterator, ShortPredicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static boolean any(ShortIterator iterator, IntPredicate predicate) {
        ShortPredicate shortPredicate;
        if (predicate instanceof ShortPredicate) {
            shortPredicate = (ShortPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            shortPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return any(iterator, shortPredicate);
    }

    public static boolean all(ShortIterator iterator, ShortPredicate predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.nextShort())) {
                return false;
            }
        }
        return true;
    }

    public static boolean all(ShortIterator iterator, IntPredicate predicate) {
        ShortPredicate shortPredicate;
        if (predicate instanceof ShortPredicate) {
            shortPredicate = (ShortPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            shortPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return all(iterator, shortPredicate);
    }

    public static int indexOf(ShortIterator iterator, ShortPredicate predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.nextShort())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(ShortIterator iterator, IntPredicate predicate) {
        ShortPredicate shortPredicate;
        if (predicate instanceof ShortPredicate) {
            shortPredicate = (ShortPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            shortPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return indexOf(iterator, shortPredicate);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator extends AbstractShortIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract short get(int i);

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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.shorts.ShortListIterator, java.util.ListIterator
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator extends AbstractIndexBasedIterator implements ShortListIterator {
        protected abstract void add(int i, short s);

        protected abstract void set(int i, short s);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
        public void add(short k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortListIterator
        public void set(short k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$IntervalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$IntervalIterator.class */
    public static class IntervalIterator implements ShortListIterator {
        private final short from;

        /* renamed from: to */
        private final short f3047to;
        short curr;

        public IntervalIterator(short from, short to) {
            this.curr = from;
            this.from = from;
            this.f3047to = to;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.curr < this.f3047to;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr > this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            short s = this.curr;
            this.curr = (short) (s + 1);
            return s;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            short s = (short) (this.curr - 1);
            this.curr = s;
            return s;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.f3047to) {
                action.accept(this.curr);
                this.curr = (short) (this.curr + 1);
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.curr + n <= this.f3047to) {
                this.curr = (short) (this.curr + n);
                return n;
            } else {
                int n2 = this.f3047to - this.curr;
                this.curr = this.f3047to;
                return n2;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (this.curr - n >= this.from) {
                this.curr = (short) (this.curr - n);
                return n;
            }
            int n2 = this.curr - this.from;
            this.curr = this.from;
            return n2;
        }
    }

    public static ShortListIterator fromTo(short from, short to) {
        return new IntervalIterator(from, to);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator implements ShortIterator {

        /* renamed from: a */
        final ShortIterator[] f3048a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(ShortIterator[] a, int offset, int length) {
            this.f3048a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f3048a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ShortIterator[] shortIteratorArr = this.f3048a;
            int i = this.offset;
            this.lastOffset = i;
            short next = shortIteratorArr[i].nextShort();
            advance();
            return next;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            while (this.length > 0) {
                ShortIterator[] shortIteratorArr = this.f3048a;
                int i = this.offset;
                this.lastOffset = i;
                shortIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            while (this.length > 0) {
                ShortIterator[] shortIteratorArr = this.f3048a;
                int i = this.offset;
                this.lastOffset = i;
                shortIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f3048a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f3048a[this.offset].skip(n - skipped);
                if (this.f3048a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    public static ShortIterator concat(ShortIterator... a) {
        return concat(a, 0, a.length);
    }

    public static ShortIterator concat(ShortIterator[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator implements ShortIterator {

        /* renamed from: i */
        protected final ShortIterator f3053i;

        public UnmodifiableIterator(ShortIterator i) {
            this.f3053i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3053i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return this.f3053i.nextShort();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3053i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            this.f3053i.forEachRemaining(action);
        }
    }

    public static ShortIterator unmodifiable(ShortIterator i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator implements ShortBidirectionalIterator {

        /* renamed from: i */
        protected final ShortBidirectionalIterator f3052i;

        public UnmodifiableBidirectionalIterator(ShortBidirectionalIterator i) {
            this.f3052i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3052i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f3052i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return this.f3052i.nextShort();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f3052i.previousShort();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3052i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            this.f3052i.forEachRemaining(action);
        }
    }

    public static ShortBidirectionalIterator unmodifiable(ShortBidirectionalIterator i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator implements ShortListIterator {

        /* renamed from: i */
        protected final ShortListIterator f3054i;

        public UnmodifiableListIterator(ShortListIterator i) {
            this.f3054i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f3054i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f3054i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return this.f3054i.nextShort();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f3054i.previousShort();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f3054i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f3054i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3054i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            this.f3054i.forEachRemaining(action);
        }
    }

    public static ShortListIterator unmodifiable(ShortListIterator i) {
        return new UnmodifiableListIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortIterators$ByteIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIterators$ByteIteratorWrapper.class */
    private static final class ByteIteratorWrapper implements ShortIterator {
        final ByteIterator iterator;

        public ByteIteratorWrapper(ByteIterator iterator) {
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public Short next() {
            return Short.valueOf((short) this.iterator.nextByte());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return (short) this.iterator.nextByte();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.iterator.skip(n);
        }
    }

    public static ShortIterator wrap(ByteIterator iterator) {
        return new ByteIteratorWrapper(iterator);
    }
}
