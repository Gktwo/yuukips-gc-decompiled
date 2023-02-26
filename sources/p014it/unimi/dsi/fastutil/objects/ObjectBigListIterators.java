package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigListIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigListIterators.class */
public final class ObjectBigListIterators {
    public static final EmptyBigListIterator EMPTY_BIG_LIST_ITERATOR = new EmptyBigListIterator();

    private ObjectBigListIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$EmptyBigListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigListIterators$EmptyBigListIterator.class */
    public static class EmptyBigListIterator<K> implements ObjectBigListIterator<K>, Serializable, Cloneable {
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

        @Override // java.util.Iterator
        public K next() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
        public long skip(long n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
        public long back(long n) {
            return 0;
        }

        @Override // java.lang.Object
        public Object clone() {
            return ObjectBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
        }

        private Object readResolve() {
            return ObjectBigListIterators.EMPTY_BIG_LIST_ITERATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$SingletonBigListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigListIterators$SingletonBigListIterator.class */
    private static class SingletonBigListIterator<K> implements ObjectBigListIterator<K> {
        private final K element;
        private int curr;

        public SingletonBigListIterator(K element) {
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

        @Override // java.util.Iterator
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

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return (long) this.curr;
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return (long) (this.curr - 1);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
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

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
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

    public static <K> ObjectBigListIterator<K> singleton(K element) {
        return new SingletonBigListIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$UnmodifiableBigListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigListIterators$UnmodifiableBigListIterator.class */
    public static class UnmodifiableBigListIterator<K> implements ObjectBigListIterator<K> {

        /* renamed from: i */
        protected final ObjectBigListIterator<? extends K> f2664i;

        public UnmodifiableBigListIterator(ObjectBigListIterator<? extends K> i) {
            this.f2664i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2664i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2664i.hasPrevious();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) this.f2664i.next();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return (K) this.f2664i.previous();
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return this.f2664i.nextIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return this.f2664i.previousIndex();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            this.f2664i.forEachRemaining(action);
        }
    }

    public static <K> ObjectBigListIterator<K> unmodifiable(ObjectBigListIterator<? extends K> i) {
        return new UnmodifiableBigListIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$BigListIteratorListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigListIterators$BigListIteratorListIterator.class */
    public static class BigListIteratorListIterator<K> implements ObjectBigListIterator<K> {

        /* renamed from: i */
        protected final ObjectListIterator<K> f2663i;

        protected BigListIteratorListIterator(ObjectListIterator<K> i) {
            this.f2663i = i;
        }

        private int intDisplacement(long n) {
            if (n >= -2147483648L && n <= 2147483647L) {
                return (int) n;
            }
            throw new IndexOutOfBoundsException("This big iterator is restricted to 32-bit displacements");
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
        public void set(K ok) {
            this.f2663i.set(ok);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
        public void add(K ok) {
            this.f2663i.add(ok);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return this.f2663i.back(n);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
        public long back(long n) {
            return (long) this.f2663i.back(intDisplacement(n));
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f2663i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return this.f2663i.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
        public long skip(long n) {
            return (long) this.f2663i.skip(intDisplacement(n));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2663i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2663i.hasPrevious();
        }

        @Override // java.util.Iterator
        public K next() {
            return this.f2663i.next();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public K previous() {
            return this.f2663i.previous();
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return (long) this.f2663i.nextIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return (long) this.f2663i.previousIndex();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            this.f2663i.forEachRemaining(action);
        }
    }

    public static <K> ObjectBigListIterator<K> asBigListIterator(ObjectListIterator<K> i) {
        return new BigListIteratorListIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$AbstractIndexBasedBigIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigListIterators$AbstractIndexBasedBigIterator.class */
    public static abstract class AbstractIndexBasedBigIterator<K> extends AbstractObjectIterator<K> {
        protected final long minPos;
        protected long pos;
        protected long lastReturned;

        protected abstract K get(long j);

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

        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$AbstractIndexBasedBigIterator<K> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [long, it.unimi.dsi.fastutil.objects.ObjectBigListIterators$AbstractIndexBasedBigIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // java.util.Iterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public K next() {
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
                java.lang.Object r1 = r1.get(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator.next():java.lang.Object");
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

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$AbstractIndexBasedBigIterator<K> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [long, it.unimi.dsi.fastutil.objects.ObjectBigListIterators$AbstractIndexBasedBigIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // java.util.Iterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void forEachRemaining(java.util.function.Consumer<? super K> r12) {
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
                java.lang.Object r2 = r2.get(r3)
                r1.accept(r2)
                goto L_0x0000
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator.forEachRemaining(java.util.function.Consumer):void");
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigIterator.skip(long):long");
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return SafeMath.safeLongToInt(skip((long) n));
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$AbstractIndexBasedBigListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigListIterators$AbstractIndexBasedBigListIterator.class */
    public static abstract class AbstractIndexBasedBigListIterator<K> extends AbstractIndexBasedBigIterator<K> implements ObjectBigListIterator<K> {
        protected abstract void add(long j, K k);

        protected abstract void set(long j, K k);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedBigListIterator(long minPos, long initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectBigListIterators$AbstractIndexBasedBigListIterator<K> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [long, it.unimi.dsi.fastutil.objects.ObjectBigListIterators$AbstractIndexBasedBigListIterator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public K previous() {
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
                java.lang.Object r1 = r1.get(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator.previous():java.lang.Object");
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long nextIndex() {
            return this.pos;
        }

        @Override // p014it.unimi.dsi.fastutil.BigListIterator
        public long previousIndex() {
            return this.pos - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
        public void add(K k) {
            long j = this.pos;
            this.pos = j + 1;
            add(j, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator, p014it.unimi.dsi.fastutil.BigListIterator
        public void set(K k) {
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
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectBigListIterator
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigListIterators.AbstractIndexBasedBigListIterator.back(long):long");
        }
    }
}
