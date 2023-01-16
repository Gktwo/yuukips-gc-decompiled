package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigListIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigListIterators.class */
public final class ShortBigListIterators {
    public static final EmptyBigListIterator EMPTY_BIG_LIST_ITERATOR = new EmptyBigListIterator();

    private ShortBigListIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$EmptyBigListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigListIterators$EmptyBigListIterator.class */
    public static class EmptyBigListIterator implements ShortBigListIterator, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyBigListIterator() {
        }

        @Override // java.util.Iterator
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

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public long skip(long n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public long back(long n) {
            return 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return ShortBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
        }

        private Object readResolve() {
            return ShortBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$SingletonBigListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigListIterators$SingletonBigListIterator.class */
    private static class SingletonBigListIterator implements ShortBigListIterator {
        private final short element;
        private int curr;

        public SingletonBigListIterator(short element) {
            this.element = element;
        }

        @Override // java.util.Iterator
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

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return (long) this.curr;
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return (long) (this.curr - 1);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public long back(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n == 0 || this.curr < 1) {
                return 0;
            } else {
                this.curr = 1;
                return 1;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public long skip(long n) {
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

    public static ShortBigListIterator singleton(short element) {
        return new SingletonBigListIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$UnmodifiableBigListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigListIterators$UnmodifiableBigListIterator.class */
    public static class UnmodifiableBigListIterator implements ShortBigListIterator {

        /* renamed from: i */
        protected final ShortBigListIterator f3041i;

        public UnmodifiableBigListIterator(ShortBigListIterator i) {
            this.f3041i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3041i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f3041i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return this.f3041i.nextShort();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f3041i.previousShort();
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return this.f3041i.nextIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return this.f3041i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3041i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            this.f3041i.forEachRemaining(action);
        }
    }

    public static ShortBigListIterator unmodifiable(ShortBigListIterator i) {
        return new UnmodifiableBigListIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$BigListIteratorListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigListIterators$BigListIteratorListIterator.class */
    public static class BigListIteratorListIterator implements ShortBigListIterator {

        /* renamed from: i */
        protected final ShortListIterator f3040i;

        protected BigListIteratorListIterator(ShortListIterator i) {
            this.f3040i = i;
        }

        private int intDisplacement(long n) {
            if (n >= -2147483648L && n <= 2147483647L) {
                return (int) n;
            }
            throw new IndexOutOfBoundsException("This big iterator is restricted to 32-bit displacements");
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public void set(short ok) {
            this.f3040i.set(ok);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public void add(short ok) {
            this.f3040i.add(ok);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return this.f3040i.back(n);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public long back(long n) {
            return (long) this.f3040i.back(intDisplacement(n));
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f3040i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator, p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.f3040i.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public long skip(long n) {
            return (long) this.f3040i.skip(intDisplacement(n));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3040i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f3040i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return this.f3040i.nextShort();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f3040i.previousShort();
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return (long) this.f3040i.nextIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return (long) this.f3040i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            this.f3040i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            this.f3040i.forEachRemaining(action);
        }
    }

    public static ShortBigListIterator asBigListIterator(ShortListIterator i) {
        return new BigListIteratorListIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$AbstractIndexBasedBigIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigListIterators$AbstractIndexBasedBigIterator.class */
    public static abstract class AbstractIndexBasedBigIterator extends AbstractShortIterator {
        protected final long minPos;
        protected long pos;
        protected long lastReturned;

        protected abstract short get(long j);

        protected abstract void remove(long j);

        protected abstract long getMaxPos();

        protected AbstractIndexBasedBigIterator(long minPos, long initialPos) {
            this.minPos = minPos;
            this.pos = initialPos;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos < getMaxPos();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$AbstractIndexBasedBigIterator */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterators$AbstractIndexBasedBigIterator, long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public short nextShort() {
            /*
                r10 = this;
                r0 = r10
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L_0x000f
                java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
                r1 = r0
                r1.<init>()
                throw r0
            L_0x000f:
                r0 = r10
                r1 = r10
                r2 = r10
                r3 = r2
                long r3 = r3.pos
                r4 = r3; r3 = r2; r2 = r4; 
                r5 = 1
                long r4 = r4 + r5
                r3.pos = r4
                r3 = r1; r4 = r2; r2 = r0; r1 = r4; r0 = r3; 
                r3.lastReturned = r4
                short r1 = r1.get(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator.nextShort():short");
        }

        @Override // java.util.Iterator
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

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$AbstractIndexBasedBigIterator */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [it.unimi.dsi.fastutil.shorts.ShortBigListIterators$AbstractIndexBasedBigIterator, long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void forEachRemaining(p014it.unimi.dsi.fastutil.shorts.ShortConsumer r12) {
            /*
                r11 = this;
            L_0x0000:
                r0 = r11
                long r0 = r0.pos
                r1 = r11
                long r1 = r1.getMaxPos()
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0029
                r0 = r12
                r1 = r11
                r2 = r11
                r3 = r11
                r4 = r3
                long r4 = r4.pos
                r5 = r4; r4 = r3; r3 = r5; 
                r6 = 1
                long r5 = r5 + r6
                r4.pos = r5
                r4 = r2; r5 = r3; r3 = r1; r2 = r5; r1 = r4; 
                r4.lastReturned = r5
                short r2 = r2.get(r3)
                r1.accept(r2)
                goto L_0x0000
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator.forEachRemaining(it.unimi.dsi.fastutil.shorts.ShortConsumer):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [long] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long skip(long r7) {
            /*
                r6 = this;
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0021
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r1 = r0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = r2
                r3.<init>()
                java.lang.String r3 = "Argument must be nonnegative: "
                java.lang.StringBuilder r2 = r2.append(r3)
                r3 = r7
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r0
            L_0x0021:
                r0 = r6
                long r0 = r0.getMaxPos()
                r9 = r0
                r0 = r9
                r1 = r6
                long r1 = r1.pos
                long r0 = r0 - r1
                r11 = r0
                r0 = r7
                r1 = r11
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0042
                r0 = r6
                r1 = r0
                long r1 = r1.pos
                r2 = r7
                long r1 = r1 + r2
                r0.pos = r1
                goto L_0x004a
            L_0x0042:
                r0 = r11
                r7 = r0
                r0 = r6
                r1 = r9
                r0.pos = r1
            L_0x004a:
                r0 = r6
                r1 = r6
                long r1 = r1.pos
                r2 = 1
                long r1 = r1 - r2
                r0.lastReturned = r1
                r0 = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigIterator.skip(long):long");
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return SafeMath.safeLongToInt(skip((long) n));
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$AbstractIndexBasedBigListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigListIterators$AbstractIndexBasedBigListIterator.class */
    public static abstract class AbstractIndexBasedBigListIterator extends AbstractIndexBasedBigIterator implements ShortBigListIterator {
        protected abstract void add(long j, short s);

        protected abstract void set(long j, short s);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedBigListIterator(long minPos, long initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: it.unimi.dsi.fastutil.shorts.ShortBigListIterators$AbstractIndexBasedBigListIterator */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [long, it.unimi.dsi.fastutil.shorts.ShortBigListIterators$AbstractIndexBasedBigListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public short previousShort() {
            /*
                r8 = this;
                r0 = r8
                boolean r0 = r0.hasPrevious()
                if (r0 != 0) goto L_0x000f
                java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
                r1 = r0
                r1.<init>()
                throw r0
            L_0x000f:
                r0 = r8
                r1 = r8
                r2 = r8
                r3 = r2
                long r3 = r3.pos
                r4 = 1
                long r3 = r3 - r4
                r4 = r3; r3 = r2; r2 = r4; 
                r3.pos = r4
                r3 = r1; r4 = r2; r2 = r0; r1 = r4; r0 = r3; 
                r3.lastReturned = r4
                short r1 = r1.get(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator.previousShort():short");
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return this.pos;
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return this.pos - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public void add(short k) {
            long j = this.pos;
            this.pos = j + 1;
            add(j, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        public void set(short k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [long] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARNING: Unknown variable types count: 2 */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigListIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long back(long r7) {
            /*
                r6 = this;
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0021
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r1 = r0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = r2
                r3.<init>()
                java.lang.String r3 = "Argument must be nonnegative: "
                java.lang.StringBuilder r2 = r2.append(r3)
                r3 = r7
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r0
            L_0x0021:
                r0 = r6
                long r0 = r0.pos
                r1 = r6
                long r1 = r1.minPos
                long r0 = r0 - r1
                r9 = r0
                r0 = r7
                r1 = r9
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x003e
                r0 = r6
                r1 = r0
                long r1 = r1.pos
                r2 = r7
                long r1 = r1 - r2
                r0.pos = r1
                goto L_0x0048
            L_0x003e:
                r0 = r9
                r7 = r0
                r0 = r6
                r1 = r6
                long r1 = r1.minPos
                r0.pos = r1
            L_0x0048:
                r0 = r6
                r1 = r6
                long r1 = r1.pos
                r0.lastReturned = r1
                r0 = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortBigListIterators.AbstractIndexBasedBigListIterator.back(long):long");
        }
    }
}
