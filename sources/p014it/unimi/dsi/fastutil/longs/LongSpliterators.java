package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.chars.CharSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.shorts.ShortSpliterator;

/* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators.class */
public final class LongSpliterators {
    static final int BASE_SPLITERATOR_CHARACTERISTICS = 256;
    public static final int COLLECTION_SPLITERATOR_CHARACTERISTICS = 320;
    public static final int LIST_SPLITERATOR_CHARACTERISTICS = 16720;
    public static final int SET_SPLITERATOR_CHARACTERISTICS = 321;
    private static final int SORTED_CHARACTERISTICS = 20;
    public static final int SORTED_SET_SPLITERATOR_CHARACTERISTICS = 341;
    public static final EmptySpliterator EMPTY_SPLITERATOR = new EmptySpliterator();

    private LongSpliterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$EmptySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$EmptySpliterator.class */
    public static class EmptySpliterator implements LongSpliterator, Serializable, Cloneable {
        private static final long serialVersionUID = 8379247926738230492L;
        private static final int CHARACTERISTICS = 16448;

        protected EmptySpliterator() {
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator
        @Deprecated
        public boolean tryAdvance(Consumer<? super Long> action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
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

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return LongSpliterators.EMPTY_SPLITERATOR;
        }

        private Object readResolve() {
            return LongSpliterators.EMPTY_SPLITERATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$SingletonSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$SingletonSpliterator.class */
    private static class SingletonSpliterator implements LongSpliterator {
        private final long element;
        private final LongComparator comparator;
        private boolean consumed;
        private static final int CHARACTERISTICS = 17749;

        public SingletonSpliterator(long element) {
            this(element, null);
        }

        public SingletonSpliterator(long element, LongComparator comparator) {
            this.consumed = false;
            this.element = element;
            this.comparator = comparator;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            Objects.requireNonNull(action);
            if (this.consumed) {
                return false;
            }
            this.consumed = true;
            action.accept(this.element);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
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

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            if (!this.consumed) {
                this.consumed = true;
                action.accept(this.element);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
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

    public static LongSpliterator singleton(long element) {
        return new SingletonSpliterator(element);
    }

    public static LongSpliterator singleton(long element, LongComparator comparator) {
        return new SingletonSpliterator(element, comparator);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$ArraySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$ArraySpliterator.class */
    public static class ArraySpliterator implements LongSpliterator {
        private static final int BASE_CHARACTERISTICS = 16720;
        final long[] array;
        private final int offset;
        private int length;
        private int curr;
        final int characteristics;

        public ArraySpliterator(long[] array, int offset, int length, int additionalCharacteristics) {
            this.array = array;
            this.offset = offset;
            this.length = length;
            this.characteristics = 16720 | additionalCharacteristics;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            if (this.curr >= this.length) {
                return false;
            }
            Objects.requireNonNull(action);
            long[] jArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            action.accept(jArr[i + i2]);
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            int retLength = (this.length - this.curr) >> 1;
            if (retLength <= 1) {
                return null;
            }
            this.curr += retLength;
            return makeForSplit(this.offset + this.curr, retLength);
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
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
    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$ArraySpliteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$ArraySpliteratorWithComparator.class */
    public static class ArraySpliteratorWithComparator extends ArraySpliterator {
        private final LongComparator comparator;

        public ArraySpliteratorWithComparator(long[] array, int offset, int length, int additionalCharacteristics, LongComparator comparator) {
            super(array, offset, length, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.ArraySpliterator
        public ArraySpliteratorWithComparator makeForSplit(int newOffset, int newLength) {
            return new ArraySpliteratorWithComparator(this.array, newOffset, newLength, this.characteristics, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            return this.comparator;
        }
    }

    public static LongSpliterator wrap(long[] array, int offset, int length) {
        LongArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, 0);
    }

    public static LongSpliterator wrap(long[] array) {
        return new ArraySpliterator(array, 0, array.length, 0);
    }

    public static LongSpliterator wrap(long[] array, int offset, int length, int additionalCharacteristics) {
        LongArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, additionalCharacteristics);
    }

    public static LongSpliterator wrapPreSorted(long[] array, int offset, int length, int additionalCharacteristics, LongComparator comparator) {
        LongArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliteratorWithComparator(array, offset, length, additionalCharacteristics, comparator);
    }

    public static LongSpliterator wrapPreSorted(long[] array, int offset, int length, LongComparator comparator) {
        return wrapPreSorted(array, offset, length, 0, comparator);
    }

    public static LongSpliterator wrapPreSorted(long[] array, LongComparator comparator) {
        return wrapPreSorted(array, 0, array.length, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$SpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$SpliteratorWrapper.class */
    private static class SpliteratorWrapper implements LongSpliterator {

        /* renamed from: i */
        final Spliterator<Long> f2411i;

        public SpliteratorWrapper(Spliterator<Long> i) {
            this.f2411i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public boolean tryAdvance(LongConsumer action) {
            return this.f2411i.tryAdvance(action);
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            Consumer<? super Long> consumer;
            Objects.requireNonNull(action);
            Spliterator<Long> spliterator = this.f2411i;
            if (action instanceof Consumer) {
                consumer = (Consumer) action;
            } else {
                Objects.requireNonNull(action);
                consumer = (v1) -> {
                    r1.accept(v1);
                };
            }
            return spliterator.tryAdvance(consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator
        @Deprecated
        public boolean tryAdvance(Consumer<? super Long> action) {
            return this.f2411i.tryAdvance(action);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public void forEachRemaining(LongConsumer action) {
            this.f2411i.forEachRemaining(action);
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Consumer<? super Long> consumer;
            Objects.requireNonNull(action);
            Spliterator<Long> spliterator = this.f2411i;
            if (action instanceof Consumer) {
                consumer = (Consumer) action;
            } else {
                Objects.requireNonNull(action);
                consumer = (v1) -> {
                    r1.accept(v1);
                };
            }
            spliterator.forEachRemaining(consumer);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
            this.f2411i.forEachRemaining(action);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f2411i.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f2411i.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            return LongComparators.asLongComparator(this.f2411i.getComparator());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            Spliterator<Long> innerSplit = this.f2411i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapper(innerSplit);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$SpliteratorWrapperWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$SpliteratorWrapperWithComparator.class */
    private static class SpliteratorWrapperWithComparator extends SpliteratorWrapper {
        final LongComparator comparator;

        public SpliteratorWrapperWithComparator(Spliterator<Long> i, LongComparator comparator) {
            super(i);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            Spliterator<Long> innerSplit = this.f2411i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapperWithComparator(innerSplit, this.comparator);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$PrimitiveSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$PrimitiveSpliteratorWrapper.class */
    private static class PrimitiveSpliteratorWrapper implements LongSpliterator {

        /* renamed from: i */
        final Spliterator.OfLong f2409i;

        public PrimitiveSpliteratorWrapper(Spliterator.OfLong i) {
            this.f2409i = i;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            return this.f2409i.tryAdvance(action);
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            this.f2409i.forEachRemaining(action);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f2409i.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f2409i.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            return LongComparators.asLongComparator(this.f2409i.getComparator());
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            Spliterator.OfLong innerSplit = this.f2409i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new PrimitiveSpliteratorWrapper(innerSplit);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$PrimitiveSpliteratorWrapperWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$PrimitiveSpliteratorWrapperWithComparator.class */
    private static class PrimitiveSpliteratorWrapperWithComparator extends PrimitiveSpliteratorWrapper {
        final LongComparator comparator;

        public PrimitiveSpliteratorWrapperWithComparator(Spliterator.OfLong i, LongComparator comparator) {
            super(i);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.PrimitiveSpliteratorWrapper, p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.PrimitiveSpliteratorWrapper, p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            Spliterator.OfLong innerSplit = this.f2409i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new PrimitiveSpliteratorWrapperWithComparator(innerSplit, this.comparator);
        }
    }

    public static LongSpliterator asLongSpliterator(Spliterator i) {
        return i instanceof LongSpliterator ? (LongSpliterator) i : i instanceof Spliterator.OfLong ? new PrimitiveSpliteratorWrapper((Spliterator.OfLong) i) : new SpliteratorWrapper(i);
    }

    public static LongSpliterator asLongSpliterator(Spliterator i, LongComparator comparatorOverride) {
        if (!(i instanceof LongSpliterator)) {
            return i instanceof Spliterator.OfLong ? new PrimitiveSpliteratorWrapperWithComparator((Spliterator.OfLong) i, comparatorOverride) : new SpliteratorWrapperWithComparator(i, comparatorOverride);
        }
        throw new IllegalArgumentException("Cannot override comparator on instance that is already a " + LongSpliterator.class.getSimpleName());
    }

    public static void onEachMatching(LongSpliterator spliterator, LongPredicate predicate, LongConsumer action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);
        spliterator.forEachRemaining(value -> {
            if (predicate.test(value)) {
                action.accept(value);
            }
        });
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$AbstractIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$AbstractIndexBasedSpliterator.class */
    public static abstract class AbstractIndexBasedSpliterator extends AbstractLongSpliterator {
        protected int pos;

        protected abstract long get(int i);

        protected abstract int getMaxPos();

        protected abstract LongSpliterator makeForSplit(int i, int i2);

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

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            if (this.pos >= getMaxPos()) {
                return false;
            }
            int i = this.pos;
            this.pos = i + 1;
            action.accept(get(i));
            return true;
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            int max = getMaxPos();
            while (this.pos < max) {
                action.accept(get(this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            int max = getMaxPos();
            int splitPoint = computeSplitPoint();
            if (splitPoint == this.pos || splitPoint == max) {
                return null;
            }
            splitPointCheck(splitPoint, max);
            LongSpliterator maybeSplit = makeForSplit(this.pos, splitPoint);
            if (maybeSplit != null) {
                this.pos = splitPoint;
            }
            return maybeSplit;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$EarlyBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$EarlyBindingSizeIndexBasedSpliterator.class */
    public static abstract class EarlyBindingSizeIndexBasedSpliterator extends AbstractIndexBasedSpliterator {
        protected final int maxPos;

        /* access modifiers changed from: protected */
        public EarlyBindingSizeIndexBasedSpliterator(int initialPos, int maxPos) {
            super(initialPos);
            this.maxPos = maxPos;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPos;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$LateBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$LateBindingSizeIndexBasedSpliterator.class */
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPosFixed ? this.maxPos : getMaxPosFromBackingStore();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.AbstractIndexBasedSpliterator, p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            LongSpliterator maybeSplit = trySplit();
            if (!this.maxPosFixed && maybeSplit != null) {
                this.maxPos = getMaxPosFromBackingStore();
                this.maxPosFixed = true;
            }
            return maybeSplit;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$IntervalSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$IntervalSpliterator.class */
    private static class IntervalSpliterator implements LongSpliterator {
        private static final int DONT_SPLIT_THRESHOLD = 2;
        private static final long MAX_SPLIT_SIZE = 1073741824;
        private static final int CHARACTERISTICS = 17749;
        private long curr;

        /* renamed from: to */
        private long f2408to;

        public IntervalSpliterator(long from, long to) {
            this.curr = from;
            this.f2408to = to;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            if (this.curr >= this.f2408to) {
                return false;
            }
            long j = this.curr;
            this.curr = j + 1;
            action.accept(j);
            return true;
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.f2408to) {
                action.accept(this.curr);
                this.curr++;
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f2408to - this.curr;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return CHARACTERISTICS;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            long remaining = this.f2408to - this.curr;
            long mid = this.curr + (remaining >> 1);
            if (remaining > 2147483648L || remaining < 0) {
                mid = this.curr + 1073741824;
            }
            if (remaining >= 0 && remaining <= 2) {
                return null;
            }
            long old_curr = this.curr;
            this.curr = mid;
            return new IntervalSpliterator(old_curr, mid);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.curr >= this.f2408to) {
                return 0;
            } else {
                long newCurr = this.curr + n;
                if (newCurr > this.f2408to || newCurr < this.curr) {
                    long n2 = this.f2408to - this.curr;
                    this.curr = this.f2408to;
                    return n2;
                }
                this.curr = newCurr;
                return n;
            }
        }
    }

    public static LongSpliterator fromTo(long from, long to) {
        return new IntervalSpliterator(from, to);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$SpliteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$SpliteratorConcatenator.class */
    public static class SpliteratorConcatenator implements LongSpliterator {
        private static final int EMPTY_CHARACTERISTICS = 16448;
        private static final int CHARACTERISTICS_NOT_SUPPORTED_WHILE_MULTIPLE = 5;

        /* renamed from: a */
        final LongSpliterator[] f2410a;
        int offset;
        int length;
        long remainingEstimatedExceptCurrent;
        int characteristics;

        public SpliteratorConcatenator(LongSpliterator[] a, int offset, int length) {
            this.remainingEstimatedExceptCurrent = LongCompanionObject.MAX_VALUE;
            this.characteristics = 0;
            this.f2410a = a;
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
                it.unimi.dsi.fastutil.longs.LongSpliterator[] r0 = r0.f2410a
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongSpliterators.SpliteratorConcatenator.recomputeRemaining():long");
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
                current &= this.f2410a[curOffset].characteristics();
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

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            boolean any = false;
            while (true) {
                if (this.length <= 0) {
                    break;
                } else if (this.f2410a[this.offset].tryAdvance(action)) {
                    any = true;
                    break;
                } else {
                    advanceNextSpliterator();
                }
            }
            return any;
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            while (this.length > 0) {
                this.f2410a[this.offset].forEachRemaining(action);
                advanceNextSpliterator();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Long> action) {
            while (this.length > 0) {
                this.f2410a[this.offset].forEachRemaining(action);
                advanceNextSpliterator();
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.length <= 0) {
                return 0;
            }
            long est = this.f2410a[this.offset].estimateSize() + this.remainingEstimatedExceptCurrent;
            if (est < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
            return est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            if (this.length == 1 && (this.characteristics & 4) != 0) {
                return this.f2410a[this.offset].getComparator();
            }
            throw new IllegalStateException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            switch (this.length) {
                case 0:
                    return null;
                case 1:
                    LongSpliterator split = this.f2410a[this.offset].trySplit();
                    this.characteristics = this.f2410a[this.offset].characteristics();
                    return split;
                case 2:
                    LongSpliterator[] longSpliteratorArr = this.f2410a;
                    int i = this.offset;
                    this.offset = i + 1;
                    LongSpliterator split2 = longSpliteratorArr[i];
                    this.length--;
                    this.characteristics = this.f2410a[this.offset].characteristics();
                    this.remainingEstimatedExceptCurrent = 0;
                    return split2;
                default:
                    int mid = this.length >> 1;
                    int ret_offset = this.offset;
                    this.offset += mid;
                    this.length -= mid;
                    this.remainingEstimatedExceptCurrent = recomputeRemaining();
                    this.characteristics = computeCharacteristics();
                    return new SpliteratorConcatenator(this.f2410a, ret_offset, mid);
            }
        }

        /* JADX WARN: Type inference failed for: r0v13, types: [long] */
        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public long skip(long n) {
            char c = 0;
            if (this.length <= 0) {
                return 0;
            }
            while (c < n && this.length >= 0) {
                c += this.f2410a[this.offset].skip(n - c);
                if (c < n) {
                    advanceNextSpliterator();
                }
            }
            return c;
        }
    }

    public static LongSpliterator concat(LongSpliterator... a) {
        return concat(a, 0, a.length);
    }

    public static LongSpliterator concat(LongSpliterator[] a, int offset, int length) {
        return new SpliteratorConcatenator(a, offset, length);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$SpliteratorFromIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$SpliteratorFromIterator.class */
    public static class SpliteratorFromIterator implements LongSpliterator {
        private static final int BATCH_INCREMENT_SIZE = 1024;
        private static final int BATCH_MAX_SIZE = 33554432;
        private final LongIterator iter;
        final int characteristics;
        private final boolean knownSize;
        private long size;
        private int nextBatchSize;
        private LongSpliterator delegate;

        SpliteratorFromIterator(LongIterator iter, int characteristics) {
            this.size = LongCompanionObject.MAX_VALUE;
            this.nextBatchSize = 1024;
            this.delegate = null;
            this.iter = iter;
            this.characteristics = 256 | characteristics;
            this.knownSize = false;
        }

        SpliteratorFromIterator(LongIterator iter, long size, int additionalCharacteristics) {
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

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
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
                action.accept(this.iter.nextLong());
                return true;
            }
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
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

        protected LongSpliterator makeForSplit(long[] batch, int len) {
            return LongSpliterators.wrap(batch, 0, len, this.characteristics);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            if (!this.iter.hasNext()) {
                return null;
            }
            int batchSizeEst = (!this.knownSize || this.size <= 0) ? this.nextBatchSize : (int) Math.min((long) this.nextBatchSize, this.size);
            long[] batch = new long[batchSizeEst];
            int actualSeen = 0;
            while (actualSeen < batchSizeEst && this.iter.hasNext()) {
                actualSeen++;
                batch[actualSeen] = this.iter.nextLong();
                this.size--;
            }
            if (batchSizeEst < this.nextBatchSize && this.iter.hasNext()) {
                batch = Arrays.copyOf(batch, this.nextBatchSize);
                while (this.iter.hasNext() && actualSeen < this.nextBatchSize) {
                    actualSeen++;
                    batch[actualSeen] = this.iter.nextLong();
                    this.size--;
                }
            }
            this.nextBatchSize = Math.min(33554432, this.nextBatchSize + 1024);
            LongSpliterator split = makeForSplit(batch, actualSeen);
            if (this.iter.hasNext()) {
                return split;
            }
            this.delegate = split;
            return split.trySplit();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.iter instanceof LongBigListIterator) {
                long skipped = ((LongBigListIterator) this.iter).skip(n);
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

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$SpliteratorFromIteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$SpliteratorFromIteratorWithComparator.class */
    private static class SpliteratorFromIteratorWithComparator extends SpliteratorFromIterator {
        private final LongComparator comparator;

        SpliteratorFromIteratorWithComparator(LongIterator iter, int additionalCharacteristics, LongComparator comparator) {
            super(iter, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        SpliteratorFromIteratorWithComparator(LongIterator iter, long size, int additionalCharacteristics, LongComparator comparator) {
            super(iter, size, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator
        public LongComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterators.SpliteratorFromIterator
        protected LongSpliterator makeForSplit(long[] array, int len) {
            return LongSpliterators.wrapPreSorted(array, 0, len, this.characteristics, this.comparator);
        }
    }

    public static LongSpliterator asSpliterator(LongIterator iter, long size, int additionalCharacterisitcs) {
        return new SpliteratorFromIterator(iter, size, additionalCharacterisitcs);
    }

    public static LongSpliterator asSpliteratorFromSorted(LongIterator iter, long size, int additionalCharacterisitcs, LongComparator comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, size, additionalCharacterisitcs, comparator);
    }

    public static LongSpliterator asSpliteratorUnknownSize(LongIterator iter, int characterisitcs) {
        return new SpliteratorFromIterator(iter, characterisitcs);
    }

    public static LongSpliterator asSpliteratorFromSortedUnknownSize(LongIterator iter, int additionalCharacterisitcs, LongComparator comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, additionalCharacterisitcs, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$IteratorFromSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$IteratorFromSpliterator.class */
    private static final class IteratorFromSpliterator implements LongIterator, LongConsumer {
        private final LongSpliterator spliterator;
        private long holder = 0;
        private boolean hasPeeked = false;

        IteratorFromSpliterator(LongSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override // java.util.function.LongConsumer
        public void accept(long item) {
            this.holder = item;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.hasPeeked) {
                return true;
            }
            if (!this.spliterator.tryAdvance((LongConsumer) this)) {
                return false;
            }
            this.hasPeeked = true;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                return this.holder;
            } else if (this.spliterator.tryAdvance((LongConsumer) this)) {
                return this.holder;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                action.accept(this.holder);
            }
            this.spliterator.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static LongIterator asIterator(LongSpliterator spliterator) {
        return new IteratorFromSpliterator(spliterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$ByteSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$ByteSpliteratorWrapper.class */
    private static final class ByteSpliteratorWrapper implements LongSpliterator {
        final ByteSpliterator spliterator;

        public ByteSpliteratorWrapper(ByteSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            Objects.requireNonNull(action);
            ByteSpliterator byteSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            return byteSpliterator.tryAdvance((ByteSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public long skip(long n) {
            return this.spliterator.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            ByteSpliterator possibleSplit = this.spliterator.trySplit();
            if (possibleSplit == null) {
                return null;
            }
            return new ByteSpliteratorWrapper(possibleSplit);
        }
    }

    public static LongSpliterator wrap(ByteSpliterator spliterator) {
        return new ByteSpliteratorWrapper(spliterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$ShortSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$ShortSpliteratorWrapper.class */
    private static final class ShortSpliteratorWrapper implements LongSpliterator {
        final ShortSpliterator spliterator;

        public ShortSpliteratorWrapper(ShortSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            Objects.requireNonNull(action);
            ShortSpliterator shortSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            return shortSpliterator.tryAdvance((ShortSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public long skip(long n) {
            return this.spliterator.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            ShortSpliterator possibleSplit = this.spliterator.trySplit();
            if (possibleSplit == null) {
                return null;
            }
            return new ShortSpliteratorWrapper(possibleSplit);
        }
    }

    public static LongSpliterator wrap(ShortSpliterator spliterator) {
        return new ShortSpliteratorWrapper(spliterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$CharSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$CharSpliteratorWrapper.class */
    private static final class CharSpliteratorWrapper implements LongSpliterator {
        final CharSpliterator spliterator;

        public CharSpliteratorWrapper(CharSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            Objects.requireNonNull(action);
            CharSpliterator charSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            return charSpliterator.tryAdvance((CharSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public long skip(long n) {
            return this.spliterator.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            CharSpliterator possibleSplit = this.spliterator.trySplit();
            if (possibleSplit == null) {
                return null;
            }
            return new CharSpliteratorWrapper(possibleSplit);
        }
    }

    public static LongSpliterator wrap(CharSpliterator spliterator) {
        return new CharSpliteratorWrapper(spliterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongSpliterators$IntSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongSpliterators$IntSpliteratorWrapper.class */
    private static final class IntSpliteratorWrapper implements LongSpliterator {
        final IntSpliterator spliterator;

        public IntSpliteratorWrapper(IntSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override // java.util.Spliterator.OfLong
        public boolean tryAdvance(LongConsumer action) {
            Objects.requireNonNull(action);
            IntSpliterator intSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            return intSpliterator.tryAdvance((v1) -> {
                r1.accept(v1);
            });
        }

        @Override // java.util.Spliterator.OfLong
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            IntSpliterator intSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            intSpliterator.forEachRemaining((v1) -> {
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

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
        public long skip(long n) {
            return this.spliterator.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public LongSpliterator trySplit() {
            IntSpliterator possibleSplit = this.spliterator.trySplit();
            if (possibleSplit == null) {
                return null;
            }
            return new IntSpliteratorWrapper(possibleSplit);
        }
    }

    public static LongSpliterator wrap(IntSpliterator spliterator) {
        return new IntSpliteratorWrapper(spliterator);
    }
}
