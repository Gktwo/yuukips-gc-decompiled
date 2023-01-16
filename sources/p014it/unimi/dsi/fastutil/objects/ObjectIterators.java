package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.BigArrays;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators.class */
public final class ObjectIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private ObjectIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$EmptyIterator.class */
    public static class EmptyIterator<K> implements ObjectListIterator<K>, Serializable, Cloneable {
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

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return ObjectIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return ObjectIterators.EMPTY_ITERATOR;
        }
    }

    public static <K> ObjectIterator<K> emptyIterator() {
        return EMPTY_ITERATOR;
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$SingletonIterator.class */
    public static class SingletonIterator<K> implements ObjectListIterator<K> {
        private final K element;
        private byte curr;

        public SingletonIterator(K element) {
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

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: K, ? super K */
        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            Objects.requireNonNull(action);
            if (this.curr == 0) {
                action.accept((K) this.element);
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static <K> ObjectListIterator<K> singleton(K element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$ArrayIterator.class */
    private static class ArrayIterator<K> implements ObjectListIterator<K> {
        private final K[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(K[] array, int offset, int length) {
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

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            K[] kArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return kArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            K[] kArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return kArr[i + i2];
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept((Object) this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

    public static <K> ObjectListIterator<K> wrap(K[] array, int offset, int length) {
        ObjectArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static <K> ObjectListIterator<K> wrap(K[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: K[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K> int unwrap(Iterator<? extends K> i, K[] array, int offset, int max) {
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
                array[offset] = i.next();
            }
            return (max - j) - 1;
        }
    }

    public static <K> int unwrap(Iterator<? extends K> i, K[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static <K> K[] unwrap(Iterator<? extends K> i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        Object[] objArr = new Object[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == objArr.length) {
                objArr = ObjectArrays.grow(objArr, j + 1);
            }
            j++;
            objArr[j] = i.next();
        }
        return (K[]) ObjectArrays.trim(objArr, j);
    }

    public static <K> K[] unwrap(Iterator<? extends K> i) {
        return (K[]) unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: K[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static <K> long unwrap(Iterator<? extends K> i, K[][] array, long offset, long max) {
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
                BigArrays.set((Object[][]) array, (long) array, i.next());
            }
            return (max - c) - 1;
        }
    }

    public static <K> long unwrap(Iterator<? extends K> i, K[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static <K> int unwrap(Iterator<K> i, ObjectCollection<? super K> c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.next());
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
    public static <K> K[][] unwrapBig(java.util.Iterator<? extends K> r8, long r9) {
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
            java.lang.Object[][] r0 = p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.newBigArray(r0)
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
            java.lang.Object[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            java.lang.Object r2 = r2.next()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            java.lang.Object[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectIterators.unwrapBig(java.util.Iterator, long):java.lang.Object[][]");
    }

    public static <K> K[][] unwrapBig(Iterator<? extends K> i) {
        return (K[][]) unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static <K> long unwrap(Iterator<K> i, ObjectCollection<? super K> c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.next());
            n++;
        }
        return n;
    }

    public static <K> int pour(Iterator<K> i, ObjectCollection<? super K> s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.next());
        }
        return (max - j) - 1;
    }

    public static <K> int pour(Iterator<K> i, ObjectCollection<? super K> s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static <K> ObjectList<K> pour(Iterator<K> i, int max) {
        ObjectArrayList<K> l = new ObjectArrayList<>();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static <K> ObjectList<K> pour(Iterator<K> i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$IteratorWrapper.class */
    private static class IteratorWrapper<K> implements ObjectIterator<K> {

        /* renamed from: i */
        final Iterator<K> f2707i;

        public IteratorWrapper(Iterator<K> i) {
            this.f2707i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2707i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f2707i.remove();
        }

        @Override // java.util.Iterator
        public K next() {
            return this.f2707i.next();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            this.f2707i.forEachRemaining(action);
        }
    }

    public static <K> ObjectIterator<K> asObjectIterator(Iterator<K> i) {
        return i instanceof ObjectIterator ? (ObjectIterator) i : new IteratorWrapper(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper<K> implements ObjectListIterator<K> {

        /* renamed from: i */
        final ListIterator<K> f2708i;

        public ListIteratorWrapper(ListIterator<K> i) {
            this.f2708i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f2708i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2708i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2708i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2708i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public void set(K k) {
            this.f2708i.set(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public void add(K k) {
            this.f2708i.add(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f2708i.remove();
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return this.f2708i.next();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return this.f2708i.previous();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            this.f2708i.forEachRemaining(action);
        }
    }

    public static <K> ObjectListIterator<K> asObjectIterator(ListIterator<K> i) {
        return i instanceof ObjectListIterator ? (ObjectListIterator) i : new ListIteratorWrapper(i);
    }

    public static <K> boolean any(Iterator<K> iterator, Predicate<? super K> predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static <K> boolean all(Iterator<K> iterator, Predicate<? super K> predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K> int indexOf(Iterator<K> iterator, Predicate<? super K> predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator<K> extends AbstractObjectIterator<K> {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract K get(int i);

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

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
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

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator<K> extends AbstractIndexBasedIterator<K> implements ObjectListIterator<K> {
        protected abstract void add(int i, K k);

        protected abstract void set(int i, K k);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public void add(K k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectListIterator, java.util.ListIterator
        public void set(K k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator<K> implements ObjectIterator<K> {

        /* renamed from: a */
        final ObjectIterator<? extends K>[] f2706a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(ObjectIterator<? extends K>[] a, int offset, int length) {
            this.f2706a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f2706a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // java.util.Iterator
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ObjectIterator<? extends K>[] objectIteratorArr = this.f2706a;
            int i = this.offset;
            this.lastOffset = i;
            K next = (K) objectIteratorArr[i].next();
            advance();
            return next;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            while (this.length > 0) {
                ObjectIterator<? extends K>[] objectIteratorArr = this.f2706a;
                int i = this.offset;
                this.lastOffset = i;
                objectIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f2706a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f2706a[this.offset].skip(n - skipped);
                if (this.f2706a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    @SafeVarargs
    public static <K> ObjectIterator<K> concat(ObjectIterator<? extends K>... a) {
        return concat(a, 0, a.length);
    }

    public static <K> ObjectIterator<K> concat(ObjectIterator<? extends K>[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator<K> implements ObjectIterator<K> {

        /* renamed from: i */
        protected final ObjectIterator<? extends K> f2710i;

        public UnmodifiableIterator(ObjectIterator<? extends K> i) {
            this.f2710i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2710i.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) this.f2710i.next();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            this.f2710i.forEachRemaining(action);
        }
    }

    public static <K> ObjectIterator<K> unmodifiable(ObjectIterator<? extends K> i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator<K> implements ObjectBidirectionalIterator<K> {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<? extends K> f2709i;

        public UnmodifiableBidirectionalIterator(ObjectBidirectionalIterator<? extends K> i) {
            this.f2709i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2709i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2709i.hasPrevious();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) this.f2709i.next();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return (K) this.f2709i.previous();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            this.f2709i.forEachRemaining(action);
        }
    }

    public static <K> ObjectBidirectionalIterator<K> unmodifiable(ObjectBidirectionalIterator<? extends K> i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator<K> implements ObjectListIterator<K> {

        /* renamed from: i */
        protected final ObjectListIterator<? extends K> f2711i;

        public UnmodifiableListIterator(ObjectListIterator<? extends K> i) {
            this.f2711i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f2711i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2711i.hasPrevious();
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public K next() {
            return (K) this.f2711i.next();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return (K) this.f2711i.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2711i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2711i.previousIndex();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            this.f2711i.forEachRemaining(action);
        }
    }

    public static <K> ObjectListIterator<K> unmodifiable(ObjectListIterator<? extends K> i) {
        return new UnmodifiableListIterator(i);
    }
}
