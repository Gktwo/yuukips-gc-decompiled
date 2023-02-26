package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators.class */
public final class BooleanSpliterators {
    static final int BASE_SPLITERATOR_CHARACTERISTICS = 256;
    public static final int COLLECTION_SPLITERATOR_CHARACTERISTICS = 320;
    public static final int LIST_SPLITERATOR_CHARACTERISTICS = 16720;
    public static final int SET_SPLITERATOR_CHARACTERISTICS = 321;
    private static final int SORTED_CHARACTERISTICS = 20;
    public static final int SORTED_SET_SPLITERATOR_CHARACTERISTICS = 341;
    public static final EmptySpliterator EMPTY_SPLITERATOR = new EmptySpliterator();

    private BooleanSpliterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$EmptySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$EmptySpliterator.class */
    public static class EmptySpliterator implements BooleanSpliterator, Serializable, Cloneable {
        private static final long serialVersionUID = 8379247926738230492L;
        private static final int CHARACTERISTICS = 16448;

        protected EmptySpliterator() {
        }

        public boolean tryAdvance(BooleanConsumer action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        @Deprecated
        public boolean tryAdvance(Consumer<? super Boolean> action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
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

        public void forEachRemaining(BooleanConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return BooleanSpliterators.EMPTY_SPLITERATOR;
        }

        private Object readResolve() {
            return BooleanSpliterators.EMPTY_SPLITERATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$SingletonSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$SingletonSpliterator.class */
    private static class SingletonSpliterator implements BooleanSpliterator {
        private final boolean element;
        private final BooleanComparator comparator;
        private boolean consumed;
        private static final int CHARACTERISTICS = 17749;

        public SingletonSpliterator(boolean element) {
            this(element, null);
        }

        public SingletonSpliterator(boolean element, BooleanComparator comparator) {
            this.consumed = false;
            this.element = element;
            this.comparator = comparator;
        }

        public boolean tryAdvance(BooleanConsumer action) {
            Objects.requireNonNull(action);
            if (this.consumed) {
                return false;
            }
            this.consumed = true;
            action.accept(this.element);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.consumed ? 0 : 1;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return CHARACTERISTICS;
        }

        public void forEachRemaining(BooleanConsumer action) {
            Objects.requireNonNull(action);
            if (!this.consumed) {
                this.consumed = true;
                action.accept(this.element);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        public BooleanComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
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

    public static BooleanSpliterator singleton(boolean element) {
        return new SingletonSpliterator(element);
    }

    public static BooleanSpliterator singleton(boolean element, BooleanComparator comparator) {
        return new SingletonSpliterator(element, comparator);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$ArraySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$ArraySpliterator.class */
    public static class ArraySpliterator implements BooleanSpliterator {
        private static final int BASE_CHARACTERISTICS = 16720;
        final boolean[] array;
        private final int offset;
        private int length;
        private int curr;
        final int characteristics;

        public ArraySpliterator(boolean[] array, int offset, int length, int additionalCharacteristics) {
            this.array = array;
            this.offset = offset;
            this.length = length;
            this.characteristics = 16720 | additionalCharacteristics;
        }

        public boolean tryAdvance(BooleanConsumer action) {
            if (this.curr >= this.length) {
                return false;
            }
            Objects.requireNonNull(action);
            boolean[] zArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            action.accept(zArr[i + i2]);
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

        protected ArraySpliterator makeForSplit(int newOffset, int newLength) {
            return new ArraySpliterator(this.array, newOffset, newLength, this.characteristics);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            int retLength = (this.length - this.curr) >> 1;
            if (retLength <= 1) {
                return null;
            }
            this.curr += retLength;
            return makeForSplit(this.offset + this.curr, retLength);
        }

        public void forEachRemaining(BooleanConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
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
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$ArraySpliteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$ArraySpliteratorWithComparator.class */
    public static class ArraySpliteratorWithComparator extends ArraySpliterator {
        private final BooleanComparator comparator;

        public ArraySpliteratorWithComparator(boolean[] array, int offset, int length, int additionalCharacteristics, BooleanComparator comparator) {
            super(array, offset, length, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.ArraySpliterator
        public ArraySpliteratorWithComparator makeForSplit(int newOffset, int newLength) {
            return new ArraySpliteratorWithComparator(this.array, newOffset, newLength, this.characteristics, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        public BooleanComparator getComparator() {
            return this.comparator;
        }
    }

    public static BooleanSpliterator wrap(boolean[] array, int offset, int length) {
        BooleanArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, 0);
    }

    public static BooleanSpliterator wrap(boolean[] array) {
        return new ArraySpliterator(array, 0, array.length, 0);
    }

    public static BooleanSpliterator wrap(boolean[] array, int offset, int length, int additionalCharacteristics) {
        BooleanArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, additionalCharacteristics);
    }

    public static BooleanSpliterator wrapPreSorted(boolean[] array, int offset, int length, int additionalCharacteristics, BooleanComparator comparator) {
        BooleanArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliteratorWithComparator(array, offset, length, additionalCharacteristics, comparator);
    }

    public static BooleanSpliterator wrapPreSorted(boolean[] array, int offset, int length, BooleanComparator comparator) {
        return wrapPreSorted(array, offset, length, 0, comparator);
    }

    public static BooleanSpliterator wrapPreSorted(boolean[] array, BooleanComparator comparator) {
        return wrapPreSorted(array, 0, array.length, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$SpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$SpliteratorWrapper.class */
    private static class SpliteratorWrapper implements BooleanSpliterator {

        /* renamed from: i */
        final Spliterator<Boolean> f1042i;

        public SpliteratorWrapper(Spliterator<Boolean> i) {
            this.f1042i = i;
        }

        public boolean tryAdvance(BooleanConsumer action) {
            return this.f1042i.tryAdvance(action);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        @Deprecated
        public boolean tryAdvance(Consumer<? super Boolean> action) {
            return this.f1042i.tryAdvance(action);
        }

        public void forEachRemaining(BooleanConsumer action) {
            this.f1042i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
            this.f1042i.forEachRemaining(action);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f1042i.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f1042i.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        public BooleanComparator getComparator() {
            return BooleanComparators.asBooleanComparator(this.f1042i.getComparator());
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            Spliterator<Boolean> innerSplit = this.f1042i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapper(innerSplit);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$SpliteratorWrapperWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$SpliteratorWrapperWithComparator.class */
    private static class SpliteratorWrapperWithComparator extends SpliteratorWrapper {
        final BooleanComparator comparator;

        public SpliteratorWrapperWithComparator(Spliterator<Boolean> i, BooleanComparator comparator) {
            super(i);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        public BooleanComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            Spliterator<Boolean> innerSplit = this.f1042i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapperWithComparator(innerSplit, this.comparator);
        }
    }

    public static BooleanSpliterator asBooleanSpliterator(Spliterator i) {
        return i instanceof BooleanSpliterator ? (BooleanSpliterator) i : new SpliteratorWrapper(i);
    }

    public static BooleanSpliterator asBooleanSpliterator(Spliterator i, BooleanComparator comparatorOverride) {
        if (!(i instanceof BooleanSpliterator)) {
            return new SpliteratorWrapperWithComparator(i, comparatorOverride);
        }
        throw new IllegalArgumentException("Cannot override comparator on instance that is already a " + BooleanSpliterator.class.getSimpleName());
    }

    public static void onEachMatching(BooleanSpliterator spliterator, BooleanPredicate predicate, BooleanConsumer action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);
        spliterator.forEachRemaining((BooleanSpliterator) value -> {
            if (predicate.test(value)) {
                action.accept(value);
            }
        });
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$AbstractIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$AbstractIndexBasedSpliterator.class */
    public static abstract class AbstractIndexBasedSpliterator extends AbstractBooleanSpliterator {
        protected int pos;

        protected abstract boolean get(int i);

        protected abstract int getMaxPos();

        protected abstract BooleanSpliterator makeForSplit(int i, int i2);

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
            return 16720;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return ((long) getMaxPos()) - ((long) this.pos);
        }

        public boolean tryAdvance(BooleanConsumer action) {
            if (this.pos >= getMaxPos()) {
                return false;
            }
            int i = this.pos;
            this.pos = i + 1;
            action.accept(get(i));
            return true;
        }

        public void forEachRemaining(BooleanConsumer action) {
            int max = getMaxPos();
            while (this.pos < max) {
                action.accept(get(this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            int max = getMaxPos();
            int splitPoint = computeSplitPoint();
            if (splitPoint == this.pos || splitPoint == max) {
                return null;
            }
            splitPointCheck(splitPoint, max);
            BooleanSpliterator maybeSplit = makeForSplit(this.pos, splitPoint);
            if (maybeSplit != null) {
                this.pos = splitPoint;
            }
            return maybeSplit;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$EarlyBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$EarlyBindingSizeIndexBasedSpliterator.class */
    public static abstract class EarlyBindingSizeIndexBasedSpliterator extends AbstractIndexBasedSpliterator {
        protected final int maxPos;

        /* access modifiers changed from: protected */
        public EarlyBindingSizeIndexBasedSpliterator(int initialPos, int maxPos) {
            super(initialPos);
            this.maxPos = maxPos;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPos;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$LateBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$LateBindingSizeIndexBasedSpliterator.class */
    public static abstract class LateBindingSizeIndexBasedSpliterator extends AbstractIndexBasedSpliterator {
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

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPosFixed ? this.maxPos : getMaxPosFromBackingStore();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.AbstractIndexBasedSpliterator, p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            BooleanSpliterator maybeSplit = trySplit();
            if (!this.maxPosFixed && maybeSplit != null) {
                this.maxPos = getMaxPosFromBackingStore();
                this.maxPosFixed = true;
            }
            return maybeSplit;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$SpliteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$SpliteratorConcatenator.class */
    public static class SpliteratorConcatenator implements BooleanSpliterator {
        private static final int EMPTY_CHARACTERISTICS = 16448;
        private static final int CHARACTERISTICS_NOT_SUPPORTED_WHILE_MULTIPLE = 5;

        /* renamed from: a */
        final BooleanSpliterator[] f1041a;
        int offset;
        int length;
        long remainingEstimatedExceptCurrent;
        int characteristics;

        public SpliteratorConcatenator(BooleanSpliterator[] a, int offset, int length) {
            this.remainingEstimatedExceptCurrent = LongCompanionObject.MAX_VALUE;
            this.characteristics = 0;
            this.f1041a = a;
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
                it.unimi.dsi.fastutil.booleans.BooleanSpliterator[] r0 = r0.f1041a
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.SpliteratorConcatenator.recomputeRemaining():long");
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
                current &= this.f1041a[curOffset].characteristics();
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

        public boolean tryAdvance(BooleanConsumer action) {
            boolean any = false;
            while (true) {
                if (this.length <= 0) {
                    break;
                } else if (this.f1041a[this.offset].tryAdvance((BooleanSpliterator) action)) {
                    any = true;
                    break;
                } else {
                    advanceNextSpliterator();
                }
            }
            return any;
        }

        public void forEachRemaining(BooleanConsumer action) {
            while (this.length > 0) {
                this.f1041a[this.offset].forEachRemaining((BooleanSpliterator) action);
                advanceNextSpliterator();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Boolean> action) {
            while (this.length > 0) {
                this.f1041a[this.offset].forEachRemaining(action);
                advanceNextSpliterator();
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.length <= 0) {
                return 0;
            }
            long est = this.f1041a[this.offset].estimateSize() + this.remainingEstimatedExceptCurrent;
            if (est < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
            return est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        public BooleanComparator getComparator() {
            if (this.length == 1 && (this.characteristics & 4) != 0) {
                return this.f1041a[this.offset].getComparator();
            }
            throw new IllegalStateException();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            switch (this.length) {
                case 0:
                    return null;
                case 1:
                    BooleanSpliterator split = this.f1041a[this.offset].trySplit();
                    this.characteristics = this.f1041a[this.offset].characteristics();
                    return split;
                case 2:
                    BooleanSpliterator[] booleanSpliteratorArr = this.f1041a;
                    int i = this.offset;
                    this.offset = i + 1;
                    BooleanSpliterator split2 = booleanSpliteratorArr[i];
                    this.length--;
                    this.characteristics = this.f1041a[this.offset].characteristics();
                    this.remainingEstimatedExceptCurrent = 0;
                    return split2;
                default:
                    int mid = this.length >> 1;
                    int ret_offset = this.offset;
                    this.offset += mid;
                    this.length -= mid;
                    this.remainingEstimatedExceptCurrent = recomputeRemaining();
                    this.characteristics = computeCharacteristics();
                    return new SpliteratorConcatenator(this.f1041a, ret_offset, mid);
            }
        }

        /* JADX WARN: Type inference failed for: r0v13, types: [long] */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
        public long skip(long n) {
            char c = 0;
            if (this.length <= 0) {
                return 0;
            }
            while (c < n && this.length >= 0) {
                c += this.f1041a[this.offset].skip(n - c);
                if (c < n) {
                    advanceNextSpliterator();
                }
            }
            return c;
        }
    }

    public static BooleanSpliterator concat(BooleanSpliterator... a) {
        return concat(a, 0, a.length);
    }

    public static BooleanSpliterator concat(BooleanSpliterator[] a, int offset, int length) {
        return new SpliteratorConcatenator(a, offset, length);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$SpliteratorFromIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$SpliteratorFromIterator.class */
    public static class SpliteratorFromIterator implements BooleanSpliterator {
        private static final int BATCH_INCREMENT_SIZE = 1024;
        private static final int BATCH_MAX_SIZE = 33554432;
        private final BooleanIterator iter;
        final int characteristics;
        private final boolean knownSize;
        private long size;
        private int nextBatchSize;
        private BooleanSpliterator delegate;

        SpliteratorFromIterator(BooleanIterator iter, int characteristics) {
            this.size = LongCompanionObject.MAX_VALUE;
            this.nextBatchSize = 1024;
            this.delegate = null;
            this.iter = iter;
            this.characteristics = 256 | characteristics;
            this.knownSize = false;
        }

        SpliteratorFromIterator(BooleanIterator iter, long size, int additionalCharacteristics) {
            this.size = LongCompanionObject.MAX_VALUE;
            this.nextBatchSize = 1024;
            this.delegate = null;
            this.iter = iter;
            this.knownSize = true;
            this.size = size;
            if ((additionalCharacteristics & 4096) != 0) {
                this.characteristics = 256 | additionalCharacteristics;
            } else {
                this.characteristics = 16704 | additionalCharacteristics;
            }
        }

        public boolean tryAdvance(BooleanConsumer action) {
            if (this.delegate != null) {
                boolean hadRemaining = this.delegate.tryAdvance((BooleanSpliterator) action);
                if (!hadRemaining) {
                    this.delegate = null;
                }
                return hadRemaining;
            } else if (!this.iter.hasNext()) {
                return false;
            } else {
                this.size--;
                action.accept(this.iter.nextBoolean());
                return true;
            }
        }

        public void forEachRemaining(BooleanConsumer action) {
            if (this.delegate != null) {
                this.delegate.forEachRemaining((BooleanSpliterator) action);
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

        protected BooleanSpliterator makeForSplit(boolean[] batch, int len) {
            return BooleanSpliterators.wrap(batch, 0, len, this.characteristics);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public BooleanSpliterator trySplit() {
            if (!this.iter.hasNext()) {
                return null;
            }
            int batchSizeEst = (!this.knownSize || this.size <= 0) ? this.nextBatchSize : (int) Math.min((long) this.nextBatchSize, this.size);
            boolean[] batch = new boolean[batchSizeEst];
            int actualSeen = 0;
            while (actualSeen < batchSizeEst && this.iter.hasNext()) {
                actualSeen++;
                batch[actualSeen] = this.iter.nextBoolean();
                this.size--;
            }
            if (batchSizeEst < this.nextBatchSize && this.iter.hasNext()) {
                batch = Arrays.copyOf(batch, this.nextBatchSize);
                while (this.iter.hasNext() && actualSeen < this.nextBatchSize) {
                    actualSeen++;
                    batch[actualSeen] = this.iter.nextBoolean();
                    this.size--;
                }
            }
            this.nextBatchSize = Math.min(33554432, this.nextBatchSize + 1024);
            BooleanSpliterator split = makeForSplit(batch, actualSeen);
            if (this.iter.hasNext()) {
                return split;
            }
            this.delegate = split;
            return split.trySplit();
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.iter instanceof BooleanBigListIterator) {
                long skipped = ((BooleanBigListIterator) this.iter).skip(n);
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

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$SpliteratorFromIteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$SpliteratorFromIteratorWithComparator.class */
    private static class SpliteratorFromIteratorWithComparator extends SpliteratorFromIterator {
        private final BooleanComparator comparator;

        SpliteratorFromIteratorWithComparator(BooleanIterator iter, int additionalCharacteristics, BooleanComparator comparator) {
            super(iter, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        SpliteratorFromIteratorWithComparator(BooleanIterator iter, long size, int additionalCharacteristics, BooleanComparator comparator) {
            super(iter, size, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterator, java.util.Spliterator
        public BooleanComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanSpliterators.SpliteratorFromIterator
        protected BooleanSpliterator makeForSplit(boolean[] array, int len) {
            return BooleanSpliterators.wrapPreSorted(array, 0, len, this.characteristics, this.comparator);
        }
    }

    public static BooleanSpliterator asSpliterator(BooleanIterator iter, long size, int additionalCharacterisitcs) {
        return new SpliteratorFromIterator(iter, size, additionalCharacterisitcs);
    }

    public static BooleanSpliterator asSpliteratorFromSorted(BooleanIterator iter, long size, int additionalCharacterisitcs, BooleanComparator comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, size, additionalCharacterisitcs, comparator);
    }

    public static BooleanSpliterator asSpliteratorUnknownSize(BooleanIterator iter, int characterisitcs) {
        return new SpliteratorFromIterator(iter, characterisitcs);
    }

    public static BooleanSpliterator asSpliteratorFromSortedUnknownSize(BooleanIterator iter, int additionalCharacterisitcs, BooleanComparator comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, additionalCharacterisitcs, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanSpliterators$IteratorFromSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanSpliterators$IteratorFromSpliterator.class */
    private static final class IteratorFromSpliterator implements BooleanIterator, BooleanConsumer {
        private final BooleanSpliterator spliterator;
        private boolean holder = false;
        private boolean hasPeeked = false;

        IteratorFromSpliterator(BooleanSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanConsumer
        public void accept(boolean item) {
            this.holder = item;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.hasPeeked) {
                return true;
            }
            if (!this.spliterator.tryAdvance((BooleanSpliterator) this)) {
                return false;
            }
            this.hasPeeked = true;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                return this.holder;
            } else if (this.spliterator.tryAdvance((BooleanSpliterator) this)) {
                return this.holder;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public void forEachRemaining(BooleanConsumer action) {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                action.accept(this.holder);
            }
            this.spliterator.forEachRemaining((BooleanSpliterator) action);
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static BooleanIterator asIterator(BooleanSpliterator spliterator) {
        return new IteratorFromSpliterator(spliterator);
    }
}
