package p014it.unimi.dsi.fastutil.bytes;

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
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators.class */
public final class ByteIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private ByteIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$EmptyIterator.class */
    public static class EmptyIterator implements ByteListIterator, Serializable, Cloneable {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Byte> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return ByteIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return ByteIterators.EMPTY_ITERATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$SingletonIterator.class */
    private static class SingletonIterator implements ByteListIterator {
        private final byte element;
        private byte curr;

        public SingletonIterator(byte element) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static ByteListIterator singleton(byte element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$ArrayIterator.class */
    private static class ArrayIterator implements ByteListIterator {
        private final byte[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(byte[] array, int offset, int length) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            byte[] bArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return bArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            byte[] bArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return bArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

    public static ByteListIterator wrap(byte[] array, int offset, int length) {
        ByteArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static ByteListIterator wrap(byte[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    public static int unwrap(ByteIterator i, byte[] array, int offset, int max) {
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
                array[offset] = i.nextByte();
            }
            return (max - j) - 1;
        }
    }

    public static int unwrap(ByteIterator i, byte[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static byte[] unwrap(ByteIterator i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        byte[] array = new byte[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == array.length) {
                array = ByteArrays.grow(array, j + 1);
            }
            j++;
            array[j] = i.nextByte();
        }
        return ByteArrays.trim(array, j);
    }

    public static byte[] unwrap(ByteIterator i) {
        return unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: byte[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static long unwrap(ByteIterator i, byte[][] array, long offset, long max) {
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
                BigArrays.set(array, (long) array, i.nextByte());
            }
            return (max - c) - 1;
        }
    }

    public static long unwrap(ByteIterator i, byte[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static int unwrap(ByteIterator i, ByteCollection c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.nextByte());
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
    public static byte[][] unwrapBig(p014it.unimi.dsi.fastutil.bytes.ByteIterator r8, long r9) {
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
            byte[][] r0 = p014it.unimi.dsi.fastutil.bytes.ByteBigArrays.newBigArray(r0)
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
            byte[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            byte r2 = r2.nextByte()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            byte[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.ByteIterators.unwrapBig(it.unimi.dsi.fastutil.bytes.ByteIterator, long):byte[][]");
    }

    public static byte[][] unwrapBig(ByteIterator i) {
        return unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static long unwrap(ByteIterator i, ByteCollection c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.nextByte());
            n++;
        }
        return n;
    }

    public static int pour(ByteIterator i, ByteCollection s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.nextByte());
        }
        return (max - j) - 1;
    }

    public static int pour(ByteIterator i, ByteCollection s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static ByteList pour(ByteIterator i, int max) {
        ByteArrayList l = new ByteArrayList();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static ByteList pour(ByteIterator i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$IteratorWrapper.class */
    private static class IteratorWrapper implements ByteIterator {

        /* renamed from: i */
        final Iterator<Byte> f1245i;

        public IteratorWrapper(Iterator<Byte> i) {
            this.f1245i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1245i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1245i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return this.f1245i.next().byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            this.f1245i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Byte> action) {
            this.f1245i.forEachRemaining(action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$PrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$PrimitiveIteratorWrapper.class */
    private static class PrimitiveIteratorWrapper implements ByteIterator {

        /* renamed from: i */
        final PrimitiveIterator.OfInt f1247i;

        public PrimitiveIteratorWrapper(PrimitiveIterator.OfInt i) {
            this.f1247i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1247i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1247i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return (byte) this.f1247i.nextInt();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            this.f1247i.forEachRemaining((IntConsumer) action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$CheckedPrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$CheckedPrimitiveIteratorWrapper.class */
    private static class CheckedPrimitiveIteratorWrapper extends PrimitiveIteratorWrapper {
        public CheckedPrimitiveIteratorWrapper(PrimitiveIterator.OfInt i) {
            super(i);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.PrimitiveIteratorWrapper, p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return SafeMath.safeIntToByte(this.f1247i.nextInt());
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterators.PrimitiveIteratorWrapper, p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            this.f1247i.forEachRemaining(value -> {
                action.accept(SafeMath.safeIntToByte(value));
            });
        }
    }

    public static ByteIterator asByteIterator(Iterator i) {
        return i instanceof ByteIterator ? (ByteIterator) i : new IteratorWrapper(i);
    }

    public static ByteIterator narrow(PrimitiveIterator.OfInt i) {
        return new CheckedPrimitiveIteratorWrapper(i);
    }

    public static ByteIterator uncheckedNarrow(PrimitiveIterator.OfInt i) {
        return new PrimitiveIteratorWrapper(i);
    }

    public static IntIterator widen(ByteIterator i) {
        return IntIterators.wrap(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper implements ByteListIterator {

        /* renamed from: i */
        final ListIterator<Byte> f1246i;

        public ListIteratorWrapper(ListIterator<Byte> i) {
            this.f1246i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1246i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1246i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1246i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1246i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
        public void set(byte k) {
            this.f1246i.set(Byte.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
        public void add(byte k) {
            this.f1246i.add(Byte.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f1246i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return this.f1246i.next().byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return this.f1246i.previous().byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            this.f1246i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Byte> action) {
            this.f1246i.forEachRemaining(action);
        }
    }

    public static ByteListIterator asByteIterator(ListIterator i) {
        return i instanceof ByteListIterator ? (ByteListIterator) i : new ListIteratorWrapper(i);
    }

    public static boolean any(ByteIterator iterator, BytePredicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static boolean any(ByteIterator iterator, IntPredicate predicate) {
        BytePredicate bytePredicate;
        if (predicate instanceof BytePredicate) {
            bytePredicate = (BytePredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            bytePredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return any(iterator, bytePredicate);
    }

    public static boolean all(ByteIterator iterator, BytePredicate predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.nextByte())) {
                return false;
            }
        }
        return true;
    }

    public static boolean all(ByteIterator iterator, IntPredicate predicate) {
        BytePredicate bytePredicate;
        if (predicate instanceof BytePredicate) {
            bytePredicate = (BytePredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            bytePredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return all(iterator, bytePredicate);
    }

    public static int indexOf(ByteIterator iterator, BytePredicate predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.nextByte())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(ByteIterator iterator, IntPredicate predicate) {
        BytePredicate bytePredicate;
        if (predicate instanceof BytePredicate) {
            bytePredicate = (BytePredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            bytePredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return indexOf(iterator, bytePredicate);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator extends AbstractByteIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract byte get(int i);

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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.bytes.ByteListIterator, java.util.ListIterator
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator extends AbstractIndexBasedIterator implements ByteListIterator {
        protected abstract void add(int i, byte b);

        protected abstract void set(int i, byte b);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
        public void add(byte k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteListIterator
        public void set(byte k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
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

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$IntervalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$IntervalIterator.class */
    private static class IntervalIterator implements ByteListIterator {
        private final byte from;

        /* renamed from: to */
        private final byte f1243to;
        byte curr;

        public IntervalIterator(byte from, byte to) {
            this.curr = from;
            this.from = from;
            this.f1243to = to;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.curr < this.f1243to;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr > this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            byte b = this.curr;
            this.curr = (byte) (b + 1);
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            byte b = (byte) (this.curr - 1);
            this.curr = b;
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.f1243to) {
                action.accept(this.curr);
                this.curr = (byte) (this.curr + 1);
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

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.curr + n <= this.f1243to) {
                this.curr = (byte) (this.curr + n);
                return n;
            } else {
                int n2 = this.f1243to - this.curr;
                this.curr = this.f1243to;
                return n2;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (this.curr - n >= this.from) {
                this.curr = (byte) (this.curr - n);
                return n;
            }
            int n2 = this.curr - this.from;
            this.curr = this.from;
            return n2;
        }
    }

    public static ByteListIterator fromTo(byte from, byte to) {
        return new IntervalIterator(from, to);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator implements ByteIterator {

        /* renamed from: a */
        final ByteIterator[] f1244a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(ByteIterator[] a, int offset, int length) {
            this.f1244a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f1244a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ByteIterator[] byteIteratorArr = this.f1244a;
            int i = this.offset;
            this.lastOffset = i;
            byte next = byteIteratorArr[i].nextByte();
            advance();
            return next;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            while (this.length > 0) {
                ByteIterator[] byteIteratorArr = this.f1244a;
                int i = this.offset;
                this.lastOffset = i;
                byteIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Byte> action) {
            while (this.length > 0) {
                ByteIterator[] byteIteratorArr = this.f1244a;
                int i = this.offset;
                this.lastOffset = i;
                byteIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f1244a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f1244a[this.offset].skip(n - skipped);
                if (this.f1244a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    public static ByteIterator concat(ByteIterator... a) {
        return concat(a, 0, a.length);
    }

    public static ByteIterator concat(ByteIterator[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator implements ByteIterator {

        /* renamed from: i */
        protected final ByteIterator f1249i;

        public UnmodifiableIterator(ByteIterator i) {
            this.f1249i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1249i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return this.f1249i.nextByte();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            this.f1249i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Byte> action) {
            this.f1249i.forEachRemaining(action);
        }
    }

    public static ByteIterator unmodifiable(ByteIterator i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator implements ByteBidirectionalIterator {

        /* renamed from: i */
        protected final ByteBidirectionalIterator f1248i;

        public UnmodifiableBidirectionalIterator(ByteBidirectionalIterator i) {
            this.f1248i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1248i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1248i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return this.f1248i.nextByte();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return this.f1248i.previousByte();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            this.f1248i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Byte> action) {
            this.f1248i.forEachRemaining(action);
        }
    }

    public static ByteBidirectionalIterator unmodifiable(ByteBidirectionalIterator i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator implements ByteListIterator {

        /* renamed from: i */
        protected final ByteListIterator f1250i;

        public UnmodifiableListIterator(ByteListIterator i) {
            this.f1250i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1250i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1250i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            return this.f1250i.nextByte();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator
        public byte previousByte() {
            return this.f1250i.previousByte();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1250i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1250i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public void forEachRemaining(ByteConsumer action) {
            this.f1250i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Byte> action) {
            this.f1250i.forEachRemaining(action);
        }
    }

    public static ByteListIterator unmodifiable(ByteListIterator i) {
        return new UnmodifiableListIterator(i);
    }
}
