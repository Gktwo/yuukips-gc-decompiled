package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleSpliterators;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators.class */
public final class FloatSpliterators {
    static final int BASE_SPLITERATOR_CHARACTERISTICS = 256;
    public static final int COLLECTION_SPLITERATOR_CHARACTERISTICS = 320;
    public static final int LIST_SPLITERATOR_CHARACTERISTICS = 16720;
    public static final int SET_SPLITERATOR_CHARACTERISTICS = 321;
    private static final int SORTED_CHARACTERISTICS = 20;
    public static final int SORTED_SET_SPLITERATOR_CHARACTERISTICS = 341;
    public static final EmptySpliterator EMPTY_SPLITERATOR = new EmptySpliterator();

    private FloatSpliterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$EmptySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$EmptySpliterator.class */
    public static class EmptySpliterator implements FloatSpliterator, Serializable, Cloneable {
        private static final long serialVersionUID = 8379247926738230492L;
        private static final int CHARACTERISTICS = 16448;

        protected EmptySpliterator() {
        }

        public boolean tryAdvance(FloatConsumer action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        @Deprecated
        public boolean tryAdvance(Consumer<? super Float> action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
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

        public void forEachRemaining(FloatConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return FloatSpliterators.EMPTY_SPLITERATOR;
        }

        private Object readResolve() {
            return FloatSpliterators.EMPTY_SPLITERATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$SingletonSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$SingletonSpliterator.class */
    private static class SingletonSpliterator implements FloatSpliterator {
        private final float element;
        private final FloatComparator comparator;
        private boolean consumed;
        private static final int CHARACTERISTICS = 17749;

        public SingletonSpliterator(float element) {
            this(element, null);
        }

        public SingletonSpliterator(float element, FloatComparator comparator) {
            this.consumed = false;
            this.element = element;
            this.comparator = comparator;
        }

        public boolean tryAdvance(FloatConsumer action) {
            Objects.requireNonNull(action);
            if (this.consumed) {
                return false;
            }
            this.consumed = true;
            action.accept(this.element);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
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

        public void forEachRemaining(FloatConsumer action) {
            Objects.requireNonNull(action);
            if (!this.consumed) {
                this.consumed = true;
                action.accept(this.element);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        public FloatComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
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

    public static FloatSpliterator singleton(float element) {
        return new SingletonSpliterator(element);
    }

    public static FloatSpliterator singleton(float element, FloatComparator comparator) {
        return new SingletonSpliterator(element, comparator);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$ArraySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$ArraySpliterator.class */
    public static class ArraySpliterator implements FloatSpliterator {
        private static final int BASE_CHARACTERISTICS = 16720;
        final float[] array;
        private final int offset;
        private int length;
        private int curr;
        final int characteristics;

        public ArraySpliterator(float[] array, int offset, int length, int additionalCharacteristics) {
            this.array = array;
            this.offset = offset;
            this.length = length;
            this.characteristics = 16720 | additionalCharacteristics;
        }

        public boolean tryAdvance(FloatConsumer action) {
            if (this.curr >= this.length) {
                return false;
            }
            Objects.requireNonNull(action);
            float[] fArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            action.accept(fArr[i + i2]);
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            int retLength = (this.length - this.curr) >> 1;
            if (retLength <= 1) {
                return null;
            }
            this.curr += retLength;
            return makeForSplit(this.offset + this.curr, retLength);
        }

        public void forEachRemaining(FloatConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
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
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$ArraySpliteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$ArraySpliteratorWithComparator.class */
    public static class ArraySpliteratorWithComparator extends ArraySpliterator {
        private final FloatComparator comparator;

        public ArraySpliteratorWithComparator(float[] array, int offset, int length, int additionalCharacteristics, FloatComparator comparator) {
            super(array, offset, length, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.ArraySpliterator
        public ArraySpliteratorWithComparator makeForSplit(int newOffset, int newLength) {
            return new ArraySpliteratorWithComparator(this.array, newOffset, newLength, this.characteristics, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        public FloatComparator getComparator() {
            return this.comparator;
        }
    }

    public static FloatSpliterator wrap(float[] array, int offset, int length) {
        FloatArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, 0);
    }

    public static FloatSpliterator wrap(float[] array) {
        return new ArraySpliterator(array, 0, array.length, 0);
    }

    public static FloatSpliterator wrap(float[] array, int offset, int length, int additionalCharacteristics) {
        FloatArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, additionalCharacteristics);
    }

    public static FloatSpliterator wrapPreSorted(float[] array, int offset, int length, int additionalCharacteristics, FloatComparator comparator) {
        FloatArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliteratorWithComparator(array, offset, length, additionalCharacteristics, comparator);
    }

    public static FloatSpliterator wrapPreSorted(float[] array, int offset, int length, FloatComparator comparator) {
        return wrapPreSorted(array, offset, length, 0, comparator);
    }

    public static FloatSpliterator wrapPreSorted(float[] array, FloatComparator comparator) {
        return wrapPreSorted(array, 0, array.length, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$SpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$SpliteratorWrapper.class */
    private static class SpliteratorWrapper implements FloatSpliterator {

        /* renamed from: i */
        final Spliterator<Float> f1938i;

        public SpliteratorWrapper(Spliterator<Float> i) {
            this.f1938i = i;
        }

        public boolean tryAdvance(FloatConsumer action) {
            return this.f1938i.tryAdvance(action);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        @Deprecated
        public boolean tryAdvance(Consumer<? super Float> action) {
            return this.f1938i.tryAdvance(action);
        }

        public void forEachRemaining(FloatConsumer action) {
            this.f1938i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
            this.f1938i.forEachRemaining(action);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f1938i.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f1938i.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        public FloatComparator getComparator() {
            return FloatComparators.asFloatComparator(this.f1938i.getComparator());
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            Spliterator<Float> innerSplit = this.f1938i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapper(innerSplit);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$SpliteratorWrapperWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$SpliteratorWrapperWithComparator.class */
    private static class SpliteratorWrapperWithComparator extends SpliteratorWrapper {
        final FloatComparator comparator;

        public SpliteratorWrapperWithComparator(Spliterator<Float> i, FloatComparator comparator) {
            super(i);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        public FloatComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            Spliterator<Float> innerSplit = this.f1938i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapperWithComparator(innerSplit, this.comparator);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$PrimitiveSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$PrimitiveSpliteratorWrapper.class */
    private static class PrimitiveSpliteratorWrapper implements FloatSpliterator {

        /* renamed from: i */
        final Spliterator.OfDouble f1936i;

        public PrimitiveSpliteratorWrapper(Spliterator.OfDouble i) {
            this.f1936i = i;
        }

        public boolean tryAdvance(FloatConsumer action) {
            return this.f1936i.tryAdvance((DoubleConsumer) action);
        }

        public void forEachRemaining(FloatConsumer action) {
            this.f1936i.forEachRemaining((DoubleConsumer) action);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f1936i.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f1936i.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        public FloatComparator getComparator() {
            Comparator<? super Double> comp = this.f1936i.getComparator();
            return left, right -> {
                return comp.compare(Double.valueOf((double) left), Double.valueOf((double) right));
            };
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            Spliterator.OfDouble innerSplit = this.f1936i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new PrimitiveSpliteratorWrapper(innerSplit);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$PrimitiveSpliteratorWrapperWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$PrimitiveSpliteratorWrapperWithComparator.class */
    private static class PrimitiveSpliteratorWrapperWithComparator extends PrimitiveSpliteratorWrapper {
        final FloatComparator comparator;

        public PrimitiveSpliteratorWrapperWithComparator(Spliterator.OfDouble i, FloatComparator comparator) {
            super(i);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.PrimitiveSpliteratorWrapper, p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        public FloatComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.PrimitiveSpliteratorWrapper, p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            Spliterator.OfDouble innerSplit = this.f1936i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new PrimitiveSpliteratorWrapperWithComparator(innerSplit, this.comparator);
        }
    }

    public static FloatSpliterator asFloatSpliterator(Spliterator i) {
        return i instanceof FloatSpliterator ? (FloatSpliterator) i : new SpliteratorWrapper(i);
    }

    public static FloatSpliterator asFloatSpliterator(Spliterator i, FloatComparator comparatorOverride) {
        if (!(i instanceof FloatSpliterator)) {
            return i instanceof Spliterator.OfDouble ? new PrimitiveSpliteratorWrapperWithComparator((Spliterator.OfDouble) i, comparatorOverride) : new SpliteratorWrapperWithComparator(i, comparatorOverride);
        }
        throw new IllegalArgumentException("Cannot override comparator on instance that is already a " + FloatSpliterator.class.getSimpleName());
    }

    public static FloatSpliterator narrow(Spliterator.OfDouble i) {
        return new PrimitiveSpliteratorWrapper(i);
    }

    public static DoubleSpliterator widen(FloatSpliterator i) {
        return DoubleSpliterators.wrap(i);
    }

    public static void onEachMatching(FloatSpliterator spliterator, FloatPredicate predicate, FloatConsumer action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);
        spliterator.forEachRemaining((FloatSpliterator) value -> {
            if (predicate.test(value)) {
                action.accept(value);
            }
        });
    }

    public static void onEachMatching(FloatSpliterator spliterator, DoublePredicate predicate, DoubleConsumer action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);
        spliterator.forEachRemaining((FloatSpliterator) value -> {
            if (predicate.test((double) value)) {
                action.accept((double) value);
            }
        });
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$AbstractIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$AbstractIndexBasedSpliterator.class */
    public static abstract class AbstractIndexBasedSpliterator extends AbstractFloatSpliterator {
        protected int pos;

        protected abstract float get(int i);

        protected abstract int getMaxPos();

        protected abstract FloatSpliterator makeForSplit(int i, int i2);

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

        public boolean tryAdvance(FloatConsumer action) {
            if (this.pos >= getMaxPos()) {
                return false;
            }
            int i = this.pos;
            this.pos = i + 1;
            action.accept(get(i));
            return true;
        }

        public void forEachRemaining(FloatConsumer action) {
            int max = getMaxPos();
            while (this.pos < max) {
                action.accept(get(this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            int max = getMaxPos();
            int splitPoint = computeSplitPoint();
            if (splitPoint == this.pos || splitPoint == max) {
                return null;
            }
            splitPointCheck(splitPoint, max);
            FloatSpliterator maybeSplit = makeForSplit(this.pos, splitPoint);
            if (maybeSplit != null) {
                this.pos = splitPoint;
            }
            return maybeSplit;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$EarlyBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$EarlyBindingSizeIndexBasedSpliterator.class */
    public static abstract class EarlyBindingSizeIndexBasedSpliterator extends AbstractIndexBasedSpliterator {
        protected final int maxPos;

        /* access modifiers changed from: protected */
        public EarlyBindingSizeIndexBasedSpliterator(int initialPos, int maxPos) {
            super(initialPos);
            this.maxPos = maxPos;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPos;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$LateBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$LateBindingSizeIndexBasedSpliterator.class */
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

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPosFixed ? this.maxPos : getMaxPosFromBackingStore();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.AbstractIndexBasedSpliterator, p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            FloatSpliterator maybeSplit = trySplit();
            if (!this.maxPosFixed && maybeSplit != null) {
                this.maxPos = getMaxPosFromBackingStore();
                this.maxPosFixed = true;
            }
            return maybeSplit;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$SpliteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$SpliteratorConcatenator.class */
    public static class SpliteratorConcatenator implements FloatSpliterator {
        private static final int EMPTY_CHARACTERISTICS = 16448;
        private static final int CHARACTERISTICS_NOT_SUPPORTED_WHILE_MULTIPLE = 5;

        /* renamed from: a */
        final FloatSpliterator[] f1937a;
        int offset;
        int length;
        long remainingEstimatedExceptCurrent;
        int characteristics;

        public SpliteratorConcatenator(FloatSpliterator[] a, int offset, int length) {
            this.remainingEstimatedExceptCurrent = LongCompanionObject.MAX_VALUE;
            this.characteristics = 0;
            this.f1937a = a;
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
                it.unimi.dsi.fastutil.floats.FloatSpliterator[] r0 = r0.f1937a
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatSpliterators.SpliteratorConcatenator.recomputeRemaining():long");
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
                current &= this.f1937a[curOffset].characteristics();
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

        public boolean tryAdvance(FloatConsumer action) {
            boolean any = false;
            while (true) {
                if (this.length <= 0) {
                    break;
                } else if (this.f1937a[this.offset].tryAdvance((FloatSpliterator) action)) {
                    any = true;
                    break;
                } else {
                    advanceNextSpliterator();
                }
            }
            return any;
        }

        public void forEachRemaining(FloatConsumer action) {
            while (this.length > 0) {
                this.f1937a[this.offset].forEachRemaining((FloatSpliterator) action);
                advanceNextSpliterator();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Float> action) {
            while (this.length > 0) {
                this.f1937a[this.offset].forEachRemaining(action);
                advanceNextSpliterator();
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.length <= 0) {
                return 0;
            }
            long est = this.f1937a[this.offset].estimateSize() + this.remainingEstimatedExceptCurrent;
            if (est < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
            return est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        public FloatComparator getComparator() {
            if (this.length == 1 && (this.characteristics & 4) != 0) {
                return this.f1937a[this.offset].getComparator();
            }
            throw new IllegalStateException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            switch (this.length) {
                case 0:
                    return null;
                case 1:
                    FloatSpliterator split = this.f1937a[this.offset].trySplit();
                    this.characteristics = this.f1937a[this.offset].characteristics();
                    return split;
                case 2:
                    FloatSpliterator[] floatSpliteratorArr = this.f1937a;
                    int i = this.offset;
                    this.offset = i + 1;
                    FloatSpliterator split2 = floatSpliteratorArr[i];
                    this.length--;
                    this.characteristics = this.f1937a[this.offset].characteristics();
                    this.remainingEstimatedExceptCurrent = 0;
                    return split2;
                default:
                    int mid = this.length >> 1;
                    int ret_offset = this.offset;
                    this.offset += mid;
                    this.length -= mid;
                    this.remainingEstimatedExceptCurrent = recomputeRemaining();
                    this.characteristics = computeCharacteristics();
                    return new SpliteratorConcatenator(this.f1937a, ret_offset, mid);
            }
        }

        /* JADX WARN: Type inference failed for: r0v13, types: [long] */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
        public long skip(long n) {
            char c = 0;
            if (this.length <= 0) {
                return 0;
            }
            while (c < n && this.length >= 0) {
                c += this.f1937a[this.offset].skip(n - c);
                if (c < n) {
                    advanceNextSpliterator();
                }
            }
            return c;
        }
    }

    public static FloatSpliterator concat(FloatSpliterator... a) {
        return concat(a, 0, a.length);
    }

    public static FloatSpliterator concat(FloatSpliterator[] a, int offset, int length) {
        return new SpliteratorConcatenator(a, offset, length);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$SpliteratorFromIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$SpliteratorFromIterator.class */
    public static class SpliteratorFromIterator implements FloatSpliterator {
        private static final int BATCH_INCREMENT_SIZE = 1024;
        private static final int BATCH_MAX_SIZE = 33554432;
        private final FloatIterator iter;
        final int characteristics;
        private final boolean knownSize;
        private long size;
        private int nextBatchSize;
        private FloatSpliterator delegate;

        SpliteratorFromIterator(FloatIterator iter, int characteristics) {
            this.size = LongCompanionObject.MAX_VALUE;
            this.nextBatchSize = 1024;
            this.delegate = null;
            this.iter = iter;
            this.characteristics = 256 | characteristics;
            this.knownSize = false;
        }

        SpliteratorFromIterator(FloatIterator iter, long size, int additionalCharacteristics) {
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

        public boolean tryAdvance(FloatConsumer action) {
            if (this.delegate != null) {
                boolean hadRemaining = this.delegate.tryAdvance((FloatSpliterator) action);
                if (!hadRemaining) {
                    this.delegate = null;
                }
                return hadRemaining;
            } else if (!this.iter.hasNext()) {
                return false;
            } else {
                this.size--;
                action.accept(this.iter.nextFloat());
                return true;
            }
        }

        public void forEachRemaining(FloatConsumer action) {
            if (this.delegate != null) {
                this.delegate.forEachRemaining((FloatSpliterator) action);
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

        protected FloatSpliterator makeForSplit(float[] batch, int len) {
            return FloatSpliterators.wrap(batch, 0, len, this.characteristics);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            if (!this.iter.hasNext()) {
                return null;
            }
            int batchSizeEst = (!this.knownSize || this.size <= 0) ? this.nextBatchSize : (int) Math.min((long) this.nextBatchSize, this.size);
            float[] batch = new float[batchSizeEst];
            int actualSeen = 0;
            while (actualSeen < batchSizeEst && this.iter.hasNext()) {
                actualSeen++;
                batch[actualSeen] = this.iter.nextFloat();
                this.size--;
            }
            if (batchSizeEst < this.nextBatchSize && this.iter.hasNext()) {
                batch = Arrays.copyOf(batch, this.nextBatchSize);
                while (this.iter.hasNext() && actualSeen < this.nextBatchSize) {
                    actualSeen++;
                    batch[actualSeen] = this.iter.nextFloat();
                    this.size--;
                }
            }
            this.nextBatchSize = Math.min(33554432, this.nextBatchSize + 1024);
            FloatSpliterator split = makeForSplit(batch, actualSeen);
            if (this.iter.hasNext()) {
                return split;
            }
            this.delegate = split;
            return split.trySplit();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.iter instanceof FloatBigListIterator) {
                long skipped = ((FloatBigListIterator) this.iter).skip(n);
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

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$SpliteratorFromIteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$SpliteratorFromIteratorWithComparator.class */
    private static class SpliteratorFromIteratorWithComparator extends SpliteratorFromIterator {
        private final FloatComparator comparator;

        SpliteratorFromIteratorWithComparator(FloatIterator iter, int additionalCharacteristics, FloatComparator comparator) {
            super(iter, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        SpliteratorFromIteratorWithComparator(FloatIterator iter, long size, int additionalCharacteristics, FloatComparator comparator) {
            super(iter, size, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator
        public FloatComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterators.SpliteratorFromIterator
        protected FloatSpliterator makeForSplit(float[] array, int len) {
            return FloatSpliterators.wrapPreSorted(array, 0, len, this.characteristics, this.comparator);
        }
    }

    public static FloatSpliterator asSpliterator(FloatIterator iter, long size, int additionalCharacterisitcs) {
        return new SpliteratorFromIterator(iter, size, additionalCharacterisitcs);
    }

    public static FloatSpliterator asSpliteratorFromSorted(FloatIterator iter, long size, int additionalCharacterisitcs, FloatComparator comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, size, additionalCharacterisitcs, comparator);
    }

    public static FloatSpliterator asSpliteratorUnknownSize(FloatIterator iter, int characterisitcs) {
        return new SpliteratorFromIterator(iter, characterisitcs);
    }

    public static FloatSpliterator asSpliteratorFromSortedUnknownSize(FloatIterator iter, int additionalCharacterisitcs, FloatComparator comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, additionalCharacterisitcs, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$IteratorFromSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$IteratorFromSpliterator.class */
    private static final class IteratorFromSpliterator implements FloatIterator, FloatConsumer {
        private final FloatSpliterator spliterator;
        private float holder = 0.0f;
        private boolean hasPeeked = false;

        IteratorFromSpliterator(FloatSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatConsumer
        public void accept(float item) {
            this.holder = item;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.hasPeeked) {
                return true;
            }
            if (!this.spliterator.tryAdvance((FloatSpliterator) this)) {
                return false;
            }
            this.hasPeeked = true;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                return this.holder;
            } else if (this.spliterator.tryAdvance((FloatSpliterator) this)) {
                return this.holder;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public void forEachRemaining(FloatConsumer action) {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                action.accept(this.holder);
            }
            this.spliterator.forEachRemaining((FloatSpliterator) action);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static FloatIterator asIterator(FloatSpliterator spliterator) {
        return new IteratorFromSpliterator(spliterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$ByteSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$ByteSpliteratorWrapper.class */
    private static final class ByteSpliteratorWrapper implements FloatSpliterator {
        final ByteSpliterator spliterator;

        public ByteSpliteratorWrapper(ByteSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        public boolean tryAdvance(FloatConsumer action) {
            Objects.requireNonNull(action);
            ByteSpliterator byteSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            return byteSpliterator.tryAdvance((ByteSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        public void forEachRemaining(FloatConsumer action) {
            Objects.requireNonNull(action);
            ByteSpliterator byteSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            byteSpliterator.forEachRemaining((ByteSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.spliterator.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.spliterator.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
        public long skip(long n) {
            return this.spliterator.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            ByteSpliterator possibleSplit = this.spliterator.trySplit();
            if (possibleSplit == null) {
                return null;
            }
            return new ByteSpliteratorWrapper(possibleSplit);
        }
    }

    public static FloatSpliterator wrap(ByteSpliterator spliterator) {
        return new ByteSpliteratorWrapper(spliterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$ShortSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$ShortSpliteratorWrapper.class */
    private static final class ShortSpliteratorWrapper implements FloatSpliterator {
        final ShortSpliterator spliterator;

        public ShortSpliteratorWrapper(ShortSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        public boolean tryAdvance(FloatConsumer action) {
            Objects.requireNonNull(action);
            ShortSpliterator shortSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            return shortSpliterator.tryAdvance((ShortSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        public void forEachRemaining(FloatConsumer action) {
            Objects.requireNonNull(action);
            ShortSpliterator shortSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            shortSpliterator.forEachRemaining((ShortSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.spliterator.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.spliterator.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
        public long skip(long n) {
            return this.spliterator.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            ShortSpliterator possibleSplit = this.spliterator.trySplit();
            if (possibleSplit == null) {
                return null;
            }
            return new ShortSpliteratorWrapper(possibleSplit);
        }
    }

    public static FloatSpliterator wrap(ShortSpliterator spliterator) {
        return new ShortSpliteratorWrapper(spliterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatSpliterators$CharSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatSpliterators$CharSpliteratorWrapper.class */
    private static final class CharSpliteratorWrapper implements FloatSpliterator {
        final CharSpliterator spliterator;

        public CharSpliteratorWrapper(CharSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        public boolean tryAdvance(FloatConsumer action) {
            Objects.requireNonNull(action);
            CharSpliterator charSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            return charSpliterator.tryAdvance((CharSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        public void forEachRemaining(FloatConsumer action) {
            Objects.requireNonNull(action);
            CharSpliterator charSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            charSpliterator.forEachRemaining((CharSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.spliterator.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.spliterator.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator
        public long skip(long n) {
            return this.spliterator.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public FloatSpliterator trySplit() {
            CharSpliterator possibleSplit = this.spliterator.trySplit();
            if (possibleSplit == null) {
                return null;
            }
            return new CharSpliteratorWrapper(possibleSplit);
        }
    }

    public static FloatSpliterator wrap(CharSpliterator spliterator) {
        return new CharSpliteratorWrapper(spliterator);
    }
}
