package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators.class */
public final class ObjectSpliterators {
    static final int BASE_SPLITERATOR_CHARACTERISTICS = 0;
    public static final int COLLECTION_SPLITERATOR_CHARACTERISTICS = 64;
    public static final int LIST_SPLITERATOR_CHARACTERISTICS = 16464;
    public static final int SET_SPLITERATOR_CHARACTERISTICS = 65;
    private static final int SORTED_CHARACTERISTICS = 20;
    public static final int SORTED_SET_SPLITERATOR_CHARACTERISTICS = 85;
    public static final EmptySpliterator EMPTY_SPLITERATOR = new EmptySpliterator();

    private ObjectSpliterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$EmptySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$EmptySpliterator.class */
    public static class EmptySpliterator<K> implements ObjectSpliterator<K>, Serializable, Cloneable {
        private static final long serialVersionUID = 8379247926738230492L;
        private static final int CHARACTERISTICS = 16448;

        protected EmptySpliterator() {
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return 0;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return CHARACTERISTICS;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return ObjectSpliterators.EMPTY_SPLITERATOR;
        }

        private Object readResolve() {
            return ObjectSpliterators.EMPTY_SPLITERATOR;
        }
    }

    public static <K> ObjectSpliterator<K> emptySpliterator() {
        return EMPTY_SPLITERATOR;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$SingletonSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$SingletonSpliterator.class */
    private static class SingletonSpliterator<K> implements ObjectSpliterator<K> {
        private final K element;
        private final Comparator<? super K> comparator;
        private boolean consumed;
        private static final int CHARACTERISTICS = 17493;

        public SingletonSpliterator(K element) {
            this(element, null);
        }

        public SingletonSpliterator(K element, Comparator<? super K> comparator) {
            this.consumed = false;
            this.element = element;
            this.comparator = comparator;
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: K, ? super K */
        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            Objects.requireNonNull(action);
            if (this.consumed) {
                return false;
            }
            this.consumed = true;
            action.accept((K) this.element);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.consumed ? 0 : 1;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return CHARACTERISTICS | (this.element != null ? 256 : 0);
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: K, ? super K */
        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            Objects.requireNonNull(action);
            if (!this.consumed) {
                this.consumed = true;
                action.accept((K) this.element);
            }
        }

        @Override // java.util.Spliterator
        public Comparator<? super K> getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n == 0 || this.consumed) {
                return 0;
            } else {
                this.consumed = true;
                return 1;
            }
        }
    }

    public static <K> ObjectSpliterator<K> singleton(K element) {
        return new SingletonSpliterator(element);
    }

    public static <K> ObjectSpliterator<K> singleton(K element, Comparator<? super K> comparator) {
        return new SingletonSpliterator(element, comparator);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$ArraySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$ArraySpliterator.class */
    public static class ArraySpliterator<K> implements ObjectSpliterator<K> {
        private static final int BASE_CHARACTERISTICS = 16464;
        final K[] array;
        private final int offset;
        private int length;
        private int curr;
        final int characteristics;

        public ArraySpliterator(K[] array, int offset, int length, int additionalCharacteristics) {
            this.array = array;
            this.offset = offset;
            this.length = length;
            this.characteristics = 16464 | additionalCharacteristics;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.curr >= this.length) {
                return false;
            }
            Objects.requireNonNull(action);
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            action.accept((Object) this.array[i + i2]);
            return true;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (this.length - this.curr);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        protected ArraySpliterator<K> makeForSplit(int newOffset, int newLength) {
            return new ArraySpliterator<>(this.array, newOffset, newLength, this.characteristics);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            int retLength = (this.length - this.curr) >> 1;
            if (retLength <= 1) {
                return null;
            }
            this.curr += retLength;
            return makeForSplit(this.offset + this.curr, retLength);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept((Object) this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.curr >= this.length) {
                return 0;
            } else {
                int remaining = this.length - this.curr;
                if (n < ((long) remaining)) {
                    this.curr = SafeMath.safeLongToInt(((long) this.curr) + n);
                    return n;
                }
                long n2 = (long) remaining;
                this.curr = this.length;
                return n2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$ArraySpliteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$ArraySpliteratorWithComparator.class */
    public static class ArraySpliteratorWithComparator<K> extends ArraySpliterator<K> {
        private final Comparator<? super K> comparator;

        public ArraySpliteratorWithComparator(K[] array, int offset, int length, int additionalCharacteristics, Comparator<? super K> comparator) {
            super(array, offset, length, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.ArraySpliterator
        public ArraySpliteratorWithComparator<K> makeForSplit(int newOffset, int newLength) {
            return new ArraySpliteratorWithComparator<>(this.array, newOffset, newLength, this.characteristics, this.comparator);
        }

        @Override // java.util.Spliterator
        public Comparator<? super K> getComparator() {
            return this.comparator;
        }
    }

    public static <K> ObjectSpliterator<K> wrap(K[] array, int offset, int length) {
        ObjectArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, 0);
    }

    public static <K> ObjectSpliterator<K> wrap(K[] array) {
        return new ArraySpliterator(array, 0, array.length, 0);
    }

    public static <K> ObjectSpliterator<K> wrap(K[] array, int offset, int length, int additionalCharacteristics) {
        ObjectArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, additionalCharacteristics);
    }

    public static <K> ObjectSpliterator<K> wrapPreSorted(K[] array, int offset, int length, int additionalCharacteristics, Comparator<? super K> comparator) {
        ObjectArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliteratorWithComparator(array, offset, length, additionalCharacteristics, comparator);
    }

    public static <K> ObjectSpliterator<K> wrapPreSorted(K[] array, int offset, int length, Comparator<? super K> comparator) {
        return wrapPreSorted(array, offset, length, 0, comparator);
    }

    public static <K> ObjectSpliterator<K> wrapPreSorted(K[] array, Comparator<? super K> comparator) {
        return wrapPreSorted(array, 0, array.length, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$SpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$SpliteratorWrapper.class */
    private static class SpliteratorWrapper<K> implements ObjectSpliterator<K> {

        /* renamed from: i */
        final Spliterator<K> f2730i;

        public SpliteratorWrapper(Spliterator<K> i) {
            this.f2730i = i;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            return this.f2730i.tryAdvance(action);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            this.f2730i.forEachRemaining(action);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f2730i.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f2730i.characteristics();
        }

        @Override // java.util.Spliterator
        public Comparator<? super K> getComparator() {
            return ObjectComparators.asObjectComparator(this.f2730i.getComparator());
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            Spliterator<K> innerSplit = this.f2730i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapper(innerSplit);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$SpliteratorWrapperWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$SpliteratorWrapperWithComparator.class */
    private static class SpliteratorWrapperWithComparator<K> extends SpliteratorWrapper<K> {
        final Comparator<? super K> comparator;

        public SpliteratorWrapperWithComparator(Spliterator<K> i, Comparator<? super K> comparator) {
            super(i);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.SpliteratorWrapper, java.util.Spliterator
        public Comparator<? super K> getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            Spliterator<K> innerSplit = this.f2730i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapperWithComparator(innerSplit, this.comparator);
        }
    }

    public static <K> ObjectSpliterator<K> asObjectSpliterator(Spliterator<K> i) {
        return i instanceof ObjectSpliterator ? (ObjectSpliterator) i : new SpliteratorWrapper(i);
    }

    public static <K> ObjectSpliterator<K> asObjectSpliterator(Spliterator<K> i, Comparator<? super K> comparatorOverride) {
        if (!(i instanceof ObjectSpliterator)) {
            return new SpliteratorWrapperWithComparator(i, comparatorOverride);
        }
        throw new IllegalArgumentException("Cannot override comparator on instance that is already a " + ObjectSpliterator.class.getSimpleName());
    }

    public static <K> void onEachMatching(Spliterator<K> spliterator, Predicate<? super K> predicate, Consumer<? super K> action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);
        spliterator.forEachRemaining(value -> {
            if (predicate.test(value)) {
                action.accept(value);
            }
        });
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$AbstractIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$AbstractIndexBasedSpliterator.class */
    public static abstract class AbstractIndexBasedSpliterator<K> extends AbstractObjectSpliterator<K> {
        protected int pos;

        protected abstract K get(int i);

        protected abstract int getMaxPos();

        protected abstract ObjectSpliterator<K> makeForSplit(int i, int i2);

        protected AbstractIndexBasedSpliterator(int initialPos) {
            this.pos = initialPos;
        }

        protected int computeSplitPoint() {
            return this.pos + ((getMaxPos() - this.pos) / 2);
        }

        private void splitPointCheck(int splitPoint, int observedMax) {
            if (splitPoint < this.pos || splitPoint > observedMax) {
                throw new IndexOutOfBoundsException("splitPoint " + splitPoint + " outside of range of current position " + this.pos + " and range end " + observedMax);
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return ObjectSpliterators.LIST_SPLITERATOR_CHARACTERISTICS;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return ((long) getMaxPos()) - ((long) this.pos);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.pos >= getMaxPos()) {
                return false;
            }
            int i = this.pos;
            this.pos = i + 1;
            action.accept(get(i));
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            int max = getMaxPos();
            while (this.pos < max) {
                action.accept(get(this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int max = getMaxPos();
            if (this.pos >= max) {
                return 0;
            }
            int remaining = max - this.pos;
            if (n < ((long) remaining)) {
                this.pos = SafeMath.safeLongToInt(((long) this.pos) + n);
                return n;
            }
            long n2 = (long) remaining;
            this.pos = max;
            return n2;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            int max = getMaxPos();
            int splitPoint = computeSplitPoint();
            if (splitPoint == this.pos || splitPoint == max) {
                return null;
            }
            splitPointCheck(splitPoint, max);
            ObjectSpliterator<K> maybeSplit = makeForSplit(this.pos, splitPoint);
            if (maybeSplit != null) {
                this.pos = splitPoint;
            }
            return maybeSplit;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$EarlyBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$EarlyBindingSizeIndexBasedSpliterator.class */
    public static abstract class EarlyBindingSizeIndexBasedSpliterator<K> extends AbstractIndexBasedSpliterator<K> {
        protected final int maxPos;

        /* access modifiers changed from: protected */
        public EarlyBindingSizeIndexBasedSpliterator(int initialPos, int maxPos) {
            super(initialPos);
            this.maxPos = maxPos;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPos;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$LateBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$LateBindingSizeIndexBasedSpliterator.class */
    public static abstract class LateBindingSizeIndexBasedSpliterator<K> extends AbstractIndexBasedSpliterator<K> {
        protected int maxPos;
        private boolean maxPosFixed;

        protected abstract int getMaxPosFromBackingStore();

        /* access modifiers changed from: protected */
        public LateBindingSizeIndexBasedSpliterator(int initialPos) {
            super(initialPos);
            this.maxPos = -1;
            this.maxPosFixed = false;
        }

        /* access modifiers changed from: protected */
        public LateBindingSizeIndexBasedSpliterator(int initialPos, int fixedMaxPos) {
            super(initialPos);
            this.maxPos = -1;
            this.maxPos = fixedMaxPos;
            this.maxPosFixed = true;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPosFixed ? this.maxPos : getMaxPosFromBackingStore();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.AbstractIndexBasedSpliterator, p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            ObjectSpliterator<K> maybeSplit = trySplit();
            if (!this.maxPosFixed && maybeSplit != null) {
                this.maxPos = getMaxPosFromBackingStore();
                this.maxPosFixed = true;
            }
            return maybeSplit;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$SpliteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$SpliteratorConcatenator.class */
    public static class SpliteratorConcatenator<K> implements ObjectSpliterator<K> {
        private static final int EMPTY_CHARACTERISTICS = 16448;
        private static final int CHARACTERISTICS_NOT_SUPPORTED_WHILE_MULTIPLE = 5;

        /* renamed from: a */
        final ObjectSpliterator<? extends K>[] f2729a;
        int offset;
        int length;
        long remainingEstimatedExceptCurrent;
        int characteristics;

        public SpliteratorConcatenator(ObjectSpliterator<? extends K>[] a, int offset, int length) {
            this.remainingEstimatedExceptCurrent = LongCompanionObject.MAX_VALUE;
            this.characteristics = 0;
            this.f2729a = a;
            this.offset = offset;
            this.length = length;
            this.remainingEstimatedExceptCurrent = recomputeRemaining();
            this.characteristics = computeCharacteristics();
        }

        /* JADX WARN: Type inference failed for: r0v17, types: [long] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0014  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long recomputeRemaining() {
            /*
                r5 = this;
                r0 = r5
                int r0 = r0.length
                r1 = 1
                int r0 = r0 - r1
                r6 = r0
                r0 = r5
                int r0 = r0.offset
                r1 = 1
                int r0 = r0 + r1
                r7 = r0
                r0 = 0
                r8 = r0
            L_0x0010:
                r0 = r6
                if (r0 <= 0) goto L_0x004e
                r0 = r5
                it.unimi.dsi.fastutil.objects.ObjectSpliterator<? extends K>[] r0 = r0.f2729a
                r1 = r7
                int r7 = r7 + 1
                r0 = r0[r1]
                long r0 = r0.estimateSize()
                r10 = r0
                int r6 = r6 + -1
                r0 = r10
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0034
                r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                return r0
            L_0x0034:
                r0 = r8
                r1 = r10
                long r0 = r0 + r1
                r8 = r0
                r0 = r8
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0047
                r0 = r8
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x004b
            L_0x0047:
                r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                return r0
            L_0x004b:
                goto L_0x0010
            L_0x004e:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.SpliteratorConcatenator.recomputeRemaining():long");
        }

        private int computeCharacteristics() {
            if (this.length <= 0) {
                return EMPTY_CHARACTERISTICS;
            }
            int current = -1;
            int curLength = this.length;
            int curOffset = this.offset;
            if (curLength > 1) {
                current = -1 & -6;
            }
            while (curLength > 0) {
                curOffset++;
                current &= this.f2729a[curOffset].characteristics();
                curLength--;
            }
            return current;
        }

        private void advanceNextSpliterator() {
            if (this.length <= 0) {
                throw new AssertionError("advanceNextSpliterator() called with none remaining");
            }
            this.offset++;
            this.length--;
            this.remainingEstimatedExceptCurrent = recomputeRemaining();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            boolean any = false;
            while (true) {
                if (this.length <= 0) {
                    break;
                } else if (this.f2729a[this.offset].tryAdvance(action)) {
                    any = true;
                    break;
                } else {
                    advanceNextSpliterator();
                }
            }
            return any;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            while (this.length > 0) {
                this.f2729a[this.offset].forEachRemaining(action);
                advanceNextSpliterator();
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.length <= 0) {
                return 0;
            }
            long est = this.f2729a[this.offset].estimateSize() + this.remainingEstimatedExceptCurrent;
            if (est < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
            return est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        /* JADX DEBUG: Type inference failed for r0v9. Raw type applied. Possible types: java.util.Comparator<? super ? extends K>, java.util.Comparator<? super K> */
        @Override // java.util.Spliterator
        public Comparator<? super K> getComparator() {
            if (this.length == 1 && (this.characteristics & 4) != 0) {
                return (Comparator<? super Object>) this.f2729a[this.offset].getComparator();
            }
            throw new IllegalStateException();
        }

        /* JADX DEBUG: Type inference failed for r0v29. Raw type applied. Possible types: it.unimi.dsi.fastutil.objects.ObjectSpliterator<? extends K>, it.unimi.dsi.fastutil.objects.ObjectSpliterator<K> */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            switch (this.length) {
                case 0:
                    return null;
                case 1:
                    ObjectSpliterator objectSpliterator = (ObjectSpliterator<? extends K>) this.f2729a[this.offset].trySplit();
                    this.characteristics = this.f2729a[this.offset].characteristics();
                    return objectSpliterator;
                case 2:
                    int i = this.offset;
                    this.offset = i + 1;
                    ObjectSpliterator<K> split = (ObjectSpliterator<K>) this.f2729a[i];
                    this.length--;
                    this.characteristics = this.f2729a[this.offset].characteristics();
                    this.remainingEstimatedExceptCurrent = 0;
                    return split;
                default:
                    int mid = this.length >> 1;
                    int ret_offset = this.offset;
                    this.offset += mid;
                    this.length -= mid;
                    this.remainingEstimatedExceptCurrent = recomputeRemaining();
                    this.characteristics = computeCharacteristics();
                    return new SpliteratorConcatenator(this.f2729a, ret_offset, mid);
            }
        }

        /* JADX WARN: Type inference failed for: r0v13, types: [long] */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
        public long skip(long n) {
            char c = 0;
            if (this.length <= 0) {
                return 0;
            }
            while (c < n && this.length >= 0) {
                c += this.f2729a[this.offset].skip(n - c);
                if (c < n) {
                    advanceNextSpliterator();
                }
            }
            return c;
        }
    }

    @SafeVarargs
    public static <K> ObjectSpliterator<K> concat(ObjectSpliterator<? extends K>... a) {
        return concat(a, 0, a.length);
    }

    public static <K> ObjectSpliterator<K> concat(ObjectSpliterator<? extends K>[] a, int offset, int length) {
        return new SpliteratorConcatenator(a, offset, length);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$SpliteratorFromIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$SpliteratorFromIterator.class */
    public static class SpliteratorFromIterator<K> implements ObjectSpliterator<K> {
        private static final int BATCH_INCREMENT_SIZE = 1024;
        private static final int BATCH_MAX_SIZE = 33554432;
        private final ObjectIterator<? extends K> iter;
        final int characteristics;
        private final boolean knownSize;
        private long size;
        private int nextBatchSize;
        private ObjectSpliterator<K> delegate;

        SpliteratorFromIterator(ObjectIterator<? extends K> iter, int characteristics) {
            this.size = LongCompanionObject.MAX_VALUE;
            this.nextBatchSize = 1024;
            this.delegate = null;
            this.iter = iter;
            this.characteristics = 0 | characteristics;
            this.knownSize = false;
        }

        SpliteratorFromIterator(ObjectIterator<? extends K> iter, long size, int additionalCharacteristics) {
            this.size = LongCompanionObject.MAX_VALUE;
            this.nextBatchSize = 1024;
            this.delegate = null;
            this.iter = iter;
            this.knownSize = true;
            this.size = size;
            if ((additionalCharacteristics & 4096) != 0) {
                this.characteristics = 0 | additionalCharacteristics;
            } else {
                this.characteristics = 16448 | additionalCharacteristics;
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> action) {
            if (this.delegate != null) {
                boolean hadRemaining = this.delegate.tryAdvance(action);
                if (!hadRemaining) {
                    this.delegate = null;
                }
                return hadRemaining;
            } else if (!this.iter.hasNext()) {
                return false;
            } else {
                this.size--;
                action.accept((Object) this.iter.next());
                return true;
            }
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> action) {
            if (this.delegate != null) {
                this.delegate.forEachRemaining(action);
                this.delegate = null;
            }
            this.iter.forEachRemaining(action);
            this.size = 0;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.delegate != null) {
                return this.delegate.estimateSize();
            }
            if (!this.iter.hasNext()) {
                return 0;
            }
            return (!this.knownSize || this.size < 0) ? LongCompanionObject.MAX_VALUE : this.size;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        protected ObjectSpliterator<K> makeForSplit(K[] batch, int len) {
            return ObjectSpliterators.wrap(batch, 0, len, this.characteristics);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: it.unimi.dsi.fastutil.objects.ObjectSpliterators$SpliteratorFromIterator<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator, java.util.Spliterator
        public ObjectSpliterator<K> trySplit() {
            if (!this.iter.hasNext()) {
                return null;
            }
            int batchSizeEst = (!this.knownSize || this.size <= 0) ? this.nextBatchSize : (int) Math.min((long) this.nextBatchSize, this.size);
            Object[] objArr = new Object[batchSizeEst];
            int actualSeen = 0;
            while (actualSeen < batchSizeEst && this.iter.hasNext()) {
                actualSeen++;
                objArr[actualSeen] = this.iter.next();
                this.size--;
            }
            if (batchSizeEst < this.nextBatchSize && this.iter.hasNext()) {
                objArr = Arrays.copyOf(objArr, this.nextBatchSize);
                while (this.iter.hasNext() && actualSeen < this.nextBatchSize) {
                    actualSeen++;
                    objArr[actualSeen] = this.iter.next();
                    this.size--;
                }
            }
            this.nextBatchSize = Math.min(33554432, this.nextBatchSize + 1024);
            ObjectSpliterator<K> split = makeForSplit(objArr, actualSeen);
            if (this.iter.hasNext()) {
                return split;
            }
            this.delegate = split;
            return split.trySplit();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.iter instanceof ObjectBigListIterator) {
                long skipped = ((ObjectBigListIterator) this.iter).skip(n);
                this.size -= skipped;
                return skipped;
            } else {
                long skippedSoFar = 0;
                while (skippedSoFar < n && this.iter.hasNext()) {
                    int skipped2 = this.iter.skip(SafeMath.safeLongToInt(Math.min(n, 2147483647L)));
                    this.size -= (long) skipped2;
                    skippedSoFar += (long) skipped2;
                }
                return skippedSoFar;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$SpliteratorFromIteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$SpliteratorFromIteratorWithComparator.class */
    public static class SpliteratorFromIteratorWithComparator<K> extends SpliteratorFromIterator<K> {
        private final Comparator<? super K> comparator;

        SpliteratorFromIteratorWithComparator(ObjectIterator<? extends K> iter, int additionalCharacteristics, Comparator<? super K> comparator) {
            super(iter, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        SpliteratorFromIteratorWithComparator(ObjectIterator<? extends K> iter, long size, int additionalCharacteristics, Comparator<? super K> comparator) {
            super(iter, size, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        @Override // java.util.Spliterator
        public Comparator<? super K> getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectSpliterators.SpliteratorFromIterator
        protected ObjectSpliterator<K> makeForSplit(K[] array, int len) {
            return ObjectSpliterators.wrapPreSorted(array, 0, len, this.characteristics, this.comparator);
        }
    }

    public static <K> ObjectSpliterator<K> asSpliterator(ObjectIterator<? extends K> iter, long size, int additionalCharacterisitcs) {
        return new SpliteratorFromIterator(iter, size, additionalCharacterisitcs);
    }

    public static <K> ObjectSpliterator<K> asSpliteratorFromSorted(ObjectIterator<? extends K> iter, long size, int additionalCharacterisitcs, Comparator<? super K> comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, size, additionalCharacterisitcs, comparator);
    }

    public static <K> ObjectSpliterator<K> asSpliteratorUnknownSize(ObjectIterator<? extends K> iter, int characterisitcs) {
        return new SpliteratorFromIterator(iter, characterisitcs);
    }

    public static <K> ObjectSpliterator<K> asSpliteratorFromSortedUnknownSize(ObjectIterator<? extends K> iter, int additionalCharacterisitcs, Comparator<? super K> comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, additionalCharacterisitcs, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterators$IteratorFromSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterators$IteratorFromSpliterator.class */
    private static final class IteratorFromSpliterator<K> implements ObjectIterator<K>, Consumer<K> {
        private final ObjectSpliterator<? extends K> spliterator;
        private K holder = null;
        private boolean hasPeeked = false;

        IteratorFromSpliterator(ObjectSpliterator<? extends K> spliterator) {
            this.spliterator = spliterator;
        }

        @Override // java.util.function.Consumer
        public void accept(K item) {
            this.holder = item;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.hasPeeked) {
                return true;
            }
            if (!this.spliterator.tryAdvance(this)) {
                return false;
            }
            this.hasPeeked = true;
            return true;
        }

        @Override // java.util.Iterator
        public K next() {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                return this.holder;
            } else if (this.spliterator.tryAdvance(this)) {
                return this.holder;
            } else {
                throw new NoSuchElementException();
            }
        }

        /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: K, ? super K */
        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super K> action) {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                action.accept((K) this.holder);
            }
            this.spliterator.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int skipped = 0;
            if (this.hasPeeked) {
                this.hasPeeked = false;
                this.spliterator.skip(1);
                skipped = 0 + 1;
                n--;
            }
            if (n > 0) {
                skipped += SafeMath.safeLongToInt(this.spliterator.skip((long) n));
            }
            return skipped;
        }
    }

    public static <K> ObjectIterator<K> asIterator(ObjectSpliterator<? extends K> spliterator) {
        return new IteratorFromSpliterator(spliterator);
    }
}
