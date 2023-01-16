package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.BigArrays;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators.class */
public final class BooleanIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private BooleanIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$EmptyIterator.class */
    public static class EmptyIterator implements BooleanListIterator, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return BooleanIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return BooleanIterators.EMPTY_ITERATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$SingletonIterator.class */
    private static class SingletonIterator implements BooleanListIterator {
        private final boolean element;
        private byte curr;

        public SingletonIterator(boolean element) {
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static BooleanListIterator singleton(boolean element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$ArrayIterator.class */
    private static class ArrayIterator implements BooleanListIterator {
        private final boolean[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(boolean[] array, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            boolean[] zArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return zArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            boolean[] zArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return zArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

    public static BooleanListIterator wrap(boolean[] array, int offset, int length) {
        BooleanArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static BooleanListIterator wrap(boolean[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    public static int unwrap(BooleanIterator i, boolean[] array, int offset, int max) {
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
                array[offset] = i.nextBoolean();
            }
            return (max - j) - 1;
        }
    }

    public static int unwrap(BooleanIterator i, boolean[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static boolean[] unwrap(BooleanIterator i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        boolean[] array = new boolean[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == array.length) {
                array = BooleanArrays.grow(array, j + 1);
            }
            j++;
            array[j] = i.nextBoolean();
        }
        return BooleanArrays.trim(array, j);
    }

    public static boolean[] unwrap(BooleanIterator i) {
        return unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: boolean[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static long unwrap(BooleanIterator i, boolean[][] array, long offset, long max) {
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
                BigArrays.set(array, (long) array, i.nextBoolean());
            }
            return (max - c) - 1;
        }
    }

    public static long unwrap(BooleanIterator i, boolean[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static int unwrap(BooleanIterator i, BooleanCollection c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.nextBoolean());
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
    public static boolean[][] unwrapBig(p014it.unimi.dsi.fastutil.booleans.BooleanIterator r8, long r9) {
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
            boolean[][] r0 = p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays.newBigArray(r0)
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
            boolean[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            boolean r2 = r2.nextBoolean()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            boolean[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanIterators.unwrapBig(it.unimi.dsi.fastutil.booleans.BooleanIterator, long):boolean[][]");
    }

    public static boolean[][] unwrapBig(BooleanIterator i) {
        return unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static long unwrap(BooleanIterator i, BooleanCollection c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.nextBoolean());
            n++;
        }
        return n;
    }

    public static int pour(BooleanIterator i, BooleanCollection s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.nextBoolean());
        }
        return (max - j) - 1;
    }

    public static int pour(BooleanIterator i, BooleanCollection s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static BooleanList pour(BooleanIterator i, int max) {
        BooleanArrayList l = new BooleanArrayList();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static BooleanList pour(BooleanIterator i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$IteratorWrapper.class */
    private static class IteratorWrapper implements BooleanIterator {

        /* renamed from: i */
        final Iterator<Boolean> f1068i;

        public IteratorWrapper(Iterator<Boolean> i) {
            this.f1068i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1068i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1068i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return this.f1068i.next().booleanValue();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            this.f1068i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
            this.f1068i.forEachRemaining(action);
        }
    }

    public static BooleanIterator asBooleanIterator(Iterator i) {
        return i instanceof BooleanIterator ? (BooleanIterator) i : new IteratorWrapper(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper implements BooleanListIterator {

        /* renamed from: i */
        final ListIterator<Boolean> f1069i;

        public ListIteratorWrapper(ListIterator<Boolean> i) {
            this.f1069i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1069i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1069i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1069i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1069i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
        public void set(boolean k) {
            this.f1069i.set(Boolean.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
        public void add(boolean k) {
            this.f1069i.add(Boolean.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f1069i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return this.f1069i.next().booleanValue();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
            return this.f1069i.previous().booleanValue();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            this.f1069i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
            this.f1069i.forEachRemaining(action);
        }
    }

    public static BooleanListIterator asBooleanIterator(ListIterator i) {
        return i instanceof BooleanListIterator ? (BooleanListIterator) i : new ListIteratorWrapper(i);
    }

    public static boolean any(BooleanIterator iterator, BooleanPredicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static boolean all(BooleanIterator iterator, BooleanPredicate predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.nextBoolean())) {
                return false;
            }
        }
        return true;
    }

    public static int indexOf(BooleanIterator iterator, BooleanPredicate predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.nextBoolean())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator extends AbstractBooleanIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract boolean get(int i);

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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.booleans.BooleanListIterator, java.util.ListIterator
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator extends AbstractIndexBasedIterator implements BooleanListIterator {
        protected abstract void add(int i, boolean z);

        protected abstract void set(int i, boolean z);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
        public void add(boolean k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanListIterator
        public void set(boolean k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator implements BooleanIterator {

        /* renamed from: a */
        final BooleanIterator[] f1067a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(BooleanIterator[] a, int offset, int length) {
            this.f1067a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f1067a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BooleanIterator[] booleanIteratorArr = this.f1067a;
            int i = this.offset;
            this.lastOffset = i;
            boolean next = booleanIteratorArr[i].nextBoolean();
            advance();
            return next;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            while (this.length > 0) {
                BooleanIterator[] booleanIteratorArr = this.f1067a;
                int i = this.offset;
                this.lastOffset = i;
                booleanIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
            while (this.length > 0) {
                BooleanIterator[] booleanIteratorArr = this.f1067a;
                int i = this.offset;
                this.lastOffset = i;
                booleanIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f1067a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f1067a[this.offset].skip(n - skipped);
                if (this.f1067a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    public static BooleanIterator concat(BooleanIterator... a) {
        return concat(a, 0, a.length);
    }

    public static BooleanIterator concat(BooleanIterator[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator implements BooleanIterator {

        /* renamed from: i */
        protected final BooleanIterator f1071i;

        public UnmodifiableIterator(BooleanIterator i) {
            this.f1071i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1071i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return this.f1071i.nextBoolean();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            this.f1071i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
            this.f1071i.forEachRemaining(action);
        }
    }

    public static BooleanIterator unmodifiable(BooleanIterator i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator implements BooleanBidirectionalIterator {

        /* renamed from: i */
        protected final BooleanBidirectionalIterator f1070i;

        public UnmodifiableBidirectionalIterator(BooleanBidirectionalIterator i) {
            this.f1070i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1070i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1070i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return this.f1070i.nextBoolean();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
            return this.f1070i.previousBoolean();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            this.f1070i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
            this.f1070i.forEachRemaining(action);
        }
    }

    public static BooleanBidirectionalIterator unmodifiable(BooleanBidirectionalIterator i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator implements BooleanListIterator {

        /* renamed from: i */
        protected final BooleanListIterator f1072i;

        public UnmodifiableListIterator(BooleanListIterator i) {
            this.f1072i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1072i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1072i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return this.f1072i.nextBoolean();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator
        public boolean previousBoolean() {
            return this.f1072i.previousBoolean();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1072i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1072i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            this.f1072i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
            this.f1072i.forEachRemaining(action);
        }
    }

    public static BooleanListIterator unmodifiable(BooleanListIterator i) {
        return new UnmodifiableListIterator(i);
    }
}
