package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.ByteSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterator;
import p014it.unimi.dsi.fastutil.ints.IntSpliterators;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators.class */
public final class ShortSpliterators {
    static final int BASE_SPLITERATOR_CHARACTERISTICS = 256;
    public static final int COLLECTION_SPLITERATOR_CHARACTERISTICS = 320;
    public static final int LIST_SPLITERATOR_CHARACTERISTICS = 16720;
    public static final int SET_SPLITERATOR_CHARACTERISTICS = 321;
    private static final int SORTED_CHARACTERISTICS = 20;
    public static final int SORTED_SET_SPLITERATOR_CHARACTERISTICS = 341;
    public static final EmptySpliterator EMPTY_SPLITERATOR = new EmptySpliterator();

    private ShortSpliterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$EmptySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$EmptySpliterator.class */
    public static class EmptySpliterator implements ShortSpliterator, Serializable, Cloneable {
        private static final long serialVersionUID = 8379247926738230492L;
        private static final int CHARACTERISTICS = 16448;

        protected EmptySpliterator() {
        }

        public boolean tryAdvance(ShortConsumer action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        @Deprecated
        public boolean tryAdvance(Consumer<? super Short> action) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
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

        public void forEachRemaining(ShortConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return ShortSpliterators.EMPTY_SPLITERATOR;
        }

        private Object readResolve() {
            return ShortSpliterators.EMPTY_SPLITERATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$SingletonSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$SingletonSpliterator.class */
    private static class SingletonSpliterator implements ShortSpliterator {
        private final short element;
        private final ShortComparator comparator;
        private boolean consumed;
        private static final int CHARACTERISTICS = 17749;

        public SingletonSpliterator(short element) {
            this(element, null);
        }

        public SingletonSpliterator(short element, ShortComparator comparator) {
            this.consumed = false;
            this.element = element;
            this.comparator = comparator;
        }

        public boolean tryAdvance(ShortConsumer action) {
            Objects.requireNonNull(action);
            if (this.consumed) {
                return false;
            }
            this.consumed = true;
            action.accept(this.element);
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
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

        public void forEachRemaining(ShortConsumer action) {
            Objects.requireNonNull(action);
            if (!this.consumed) {
                this.consumed = true;
                action.accept(this.element);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
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

    public static ShortSpliterator singleton(short element) {
        return new SingletonSpliterator(element);
    }

    public static ShortSpliterator singleton(short element, ShortComparator comparator) {
        return new SingletonSpliterator(element, comparator);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$ArraySpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$ArraySpliterator.class */
    public static class ArraySpliterator implements ShortSpliterator {
        private static final int BASE_CHARACTERISTICS = 16720;
        final short[] array;
        private final int offset;
        private int length;
        private int curr;
        final int characteristics;

        public ArraySpliterator(short[] array, int offset, int length, int additionalCharacteristics) {
            this.array = array;
            this.offset = offset;
            this.length = length;
            this.characteristics = 16720 | additionalCharacteristics;
        }

        public boolean tryAdvance(ShortConsumer action) {
            if (this.curr >= this.length) {
                return false;
            }
            Objects.requireNonNull(action);
            short[] sArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            action.accept(sArr[i + i2]);
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            int retLength = (this.length - this.curr) >> 1;
            if (retLength <= 1) {
                return null;
            }
            this.curr += retLength;
            return makeForSplit(this.offset + this.curr, retLength);
        }

        public void forEachRemaining(ShortConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
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
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$ArraySpliteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$ArraySpliteratorWithComparator.class */
    public static class ArraySpliteratorWithComparator extends ArraySpliterator {
        private final ShortComparator comparator;

        public ArraySpliteratorWithComparator(short[] array, int offset, int length, int additionalCharacteristics, ShortComparator comparator) {
            super(array, offset, length, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.ArraySpliterator
        public ArraySpliteratorWithComparator makeForSplit(int newOffset, int newLength) {
            return new ArraySpliteratorWithComparator(this.array, newOffset, newLength, this.characteristics, this.comparator);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            return this.comparator;
        }
    }

    public static ShortSpliterator wrap(short[] array, int offset, int length) {
        ShortArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, 0);
    }

    public static ShortSpliterator wrap(short[] array) {
        return new ArraySpliterator(array, 0, array.length, 0);
    }

    public static ShortSpliterator wrap(short[] array, int offset, int length, int additionalCharacteristics) {
        ShortArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliterator(array, offset, length, additionalCharacteristics);
    }

    public static ShortSpliterator wrapPreSorted(short[] array, int offset, int length, int additionalCharacteristics, ShortComparator comparator) {
        ShortArrays.ensureOffsetLength(array, offset, length);
        return new ArraySpliteratorWithComparator(array, offset, length, additionalCharacteristics, comparator);
    }

    public static ShortSpliterator wrapPreSorted(short[] array, int offset, int length, ShortComparator comparator) {
        return wrapPreSorted(array, offset, length, 0, comparator);
    }

    public static ShortSpliterator wrapPreSorted(short[] array, ShortComparator comparator) {
        return wrapPreSorted(array, 0, array.length, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$SpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$SpliteratorWrapper.class */
    private static class SpliteratorWrapper implements ShortSpliterator {

        /* renamed from: i */
        final Spliterator<Short> f3037i;

        public SpliteratorWrapper(Spliterator<Short> i) {
            this.f3037i = i;
        }

        public boolean tryAdvance(ShortConsumer action) {
            return this.f3037i.tryAdvance(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        @Deprecated
        public boolean tryAdvance(Consumer<? super Short> action) {
            return this.f3037i.tryAdvance(action);
        }

        public void forEachRemaining(ShortConsumer action) {
            this.f3037i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            this.f3037i.forEachRemaining(action);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f3037i.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f3037i.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            return ShortComparators.asShortComparator(this.f3037i.getComparator());
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            Spliterator<Short> innerSplit = this.f3037i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapper(innerSplit);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$SpliteratorWrapperWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$SpliteratorWrapperWithComparator.class */
    private static class SpliteratorWrapperWithComparator extends SpliteratorWrapper {
        final ShortComparator comparator;

        public SpliteratorWrapperWithComparator(Spliterator<Short> i, ShortComparator comparator) {
            super(i);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.SpliteratorWrapper, p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            Spliterator<Short> innerSplit = this.f3037i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new SpliteratorWrapperWithComparator(innerSplit, this.comparator);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$PrimitiveSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$PrimitiveSpliteratorWrapper.class */
    private static class PrimitiveSpliteratorWrapper implements ShortSpliterator {

        /* renamed from: i */
        final Spliterator.OfInt f3035i;

        public PrimitiveSpliteratorWrapper(Spliterator.OfInt i) {
            this.f3035i = i;
        }

        public boolean tryAdvance(ShortConsumer action) {
            return this.f3035i.tryAdvance((IntConsumer) action);
        }

        public void forEachRemaining(ShortConsumer action) {
            this.f3035i.forEachRemaining((IntConsumer) action);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f3035i.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f3035i.characteristics();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            Comparator<? super Integer> comp = this.f3035i.getComparator();
            return left, right -> {
                return comp.compare(Integer.valueOf(left), Integer.valueOf(right));
            };
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            Spliterator.OfInt innerSplit = this.f3035i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new PrimitiveSpliteratorWrapper(innerSplit);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$PrimitiveSpliteratorWrapperWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$PrimitiveSpliteratorWrapperWithComparator.class */
    private static class PrimitiveSpliteratorWrapperWithComparator extends PrimitiveSpliteratorWrapper {
        final ShortComparator comparator;

        public PrimitiveSpliteratorWrapperWithComparator(Spliterator.OfInt i, ShortComparator comparator) {
            super(i);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.PrimitiveSpliteratorWrapper, p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.PrimitiveSpliteratorWrapper, p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            Spliterator.OfInt innerSplit = this.f3035i.trySplit();
            if (innerSplit == null) {
                return null;
            }
            return new PrimitiveSpliteratorWrapperWithComparator(innerSplit, this.comparator);
        }
    }

    public static ShortSpliterator asShortSpliterator(Spliterator i) {
        return i instanceof ShortSpliterator ? (ShortSpliterator) i : new SpliteratorWrapper(i);
    }

    public static ShortSpliterator asShortSpliterator(Spliterator i, ShortComparator comparatorOverride) {
        if (!(i instanceof ShortSpliterator)) {
            return i instanceof Spliterator.OfInt ? new PrimitiveSpliteratorWrapperWithComparator((Spliterator.OfInt) i, comparatorOverride) : new SpliteratorWrapperWithComparator(i, comparatorOverride);
        }
        throw new IllegalArgumentException("Cannot override comparator on instance that is already a " + ShortSpliterator.class.getSimpleName());
    }

    public static ShortSpliterator narrow(Spliterator.OfInt i) {
        return new PrimitiveSpliteratorWrapper(i);
    }

    public static IntSpliterator widen(ShortSpliterator i) {
        return IntSpliterators.wrap(i);
    }

    public static void onEachMatching(ShortSpliterator spliterator, ShortPredicate predicate, ShortConsumer action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);
        spliterator.forEachRemaining((ShortSpliterator) value -> {
            if (predicate.test(value)) {
                action.accept(value);
            }
        });
    }

    public static void onEachMatching(ShortSpliterator spliterator, IntPredicate predicate, IntConsumer action) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(action);
        spliterator.forEachRemaining((ShortSpliterator) value -> {
            if (predicate.test(value)) {
                action.accept(value);
            }
        });
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$AbstractIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$AbstractIndexBasedSpliterator.class */
    public static abstract class AbstractIndexBasedSpliterator extends AbstractShortSpliterator {
        protected int pos;

        protected abstract short get(int i);

        protected abstract int getMaxPos();

        protected abstract ShortSpliterator makeForSplit(int i, int i2);

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

        public boolean tryAdvance(ShortConsumer action) {
            if (this.pos >= getMaxPos()) {
                return false;
            }
            int i = this.pos;
            this.pos = i + 1;
            action.accept(get(i));
            return true;
        }

        public void forEachRemaining(ShortConsumer action) {
            int max = getMaxPos();
            while (this.pos < max) {
                action.accept(get(this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            int max = getMaxPos();
            int splitPoint = computeSplitPoint();
            if (splitPoint == this.pos || splitPoint == max) {
                return null;
            }
            splitPointCheck(splitPoint, max);
            ShortSpliterator maybeSplit = makeForSplit(this.pos, splitPoint);
            if (maybeSplit != null) {
                this.pos = splitPoint;
            }
            return maybeSplit;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$EarlyBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$EarlyBindingSizeIndexBasedSpliterator.class */
    public static abstract class EarlyBindingSizeIndexBasedSpliterator extends AbstractIndexBasedSpliterator {
        protected final int maxPos;

        /* access modifiers changed from: protected */
        public EarlyBindingSizeIndexBasedSpliterator(int initialPos, int maxPos) {
            super(initialPos);
            this.maxPos = maxPos;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPos;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$LateBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$LateBindingSizeIndexBasedSpliterator.class */
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator
        protected final int getMaxPos() {
            return this.maxPosFixed ? this.maxPos : getMaxPosFromBackingStore();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.AbstractIndexBasedSpliterator, p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            ShortSpliterator maybeSplit = trySplit();
            if (!this.maxPosFixed && maybeSplit != null) {
                this.maxPos = getMaxPosFromBackingStore();
                this.maxPosFixed = true;
            }
            return maybeSplit;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$IntervalSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$IntervalSpliterator.class */
    private static class IntervalSpliterator implements ShortSpliterator {
        private static final int DONT_SPLIT_THRESHOLD = 2;
        private static final int CHARACTERISTICS = 17749;
        private short curr;

        /* renamed from: to */
        private short f3034to;

        public IntervalSpliterator(short from, short to) {
            this.curr = from;
            this.f3034to = to;
        }

        public boolean tryAdvance(ShortConsumer action) {
            if (this.curr >= this.f3034to) {
                return false;
            }
            short s = this.curr;
            this.curr = (short) (s + 1);
            action.accept(s);
            return true;
        }

        public void forEachRemaining(ShortConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.f3034to) {
                action.accept(this.curr);
                this.curr = (short) (this.curr + 1);
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (long) (this.f3034to - this.curr);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return CHARACTERISTICS;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            int remaining = this.f3034to - this.curr;
            short mid = (short) (this.curr + (remaining >> 1));
            if (remaining >= 0 && remaining <= 2) {
                return null;
            }
            short old_curr = this.curr;
            this.curr = mid;
            return new IntervalSpliterator(old_curr, mid);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.curr >= this.f3034to) {
                return 0;
            } else {
                long newCurr = ((long) this.curr) + n;
                if (newCurr > ((long) this.f3034to) || newCurr < ((long) this.curr)) {
                    long n2 = (long) (this.f3034to - this.curr);
                    this.curr = this.f3034to;
                    return n2;
                }
                this.curr = SafeMath.safeLongToShort(newCurr);
                return n;
            }
        }
    }

    public static ShortSpliterator fromTo(short from, short to) {
        return new IntervalSpliterator(from, to);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$SpliteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$SpliteratorConcatenator.class */
    public static class SpliteratorConcatenator implements ShortSpliterator {
        private static final int EMPTY_CHARACTERISTICS = 16448;
        private static final int CHARACTERISTICS_NOT_SUPPORTED_WHILE_MULTIPLE = 5;

        /* renamed from: a */
        final ShortSpliterator[] f3036a;
        int offset;
        int length;
        long remainingEstimatedExceptCurrent;
        int characteristics;

        public SpliteratorConcatenator(ShortSpliterator[] a, int offset, int length) {
            this.remainingEstimatedExceptCurrent = LongCompanionObject.MAX_VALUE;
            this.characteristics = 0;
            this.f3036a = a;
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
                it.unimi.dsi.fastutil.shorts.ShortSpliterator[] r0 = r0.f3036a
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.SpliteratorConcatenator.recomputeRemaining():long");
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
                current &= this.f3036a[curOffset].characteristics();
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

        public boolean tryAdvance(ShortConsumer action) {
            boolean any = false;
            while (true) {
                if (this.length <= 0) {
                    break;
                } else if (this.f3036a[this.offset].tryAdvance((ShortSpliterator) action)) {
                    any = true;
                    break;
                } else {
                    advanceNextSpliterator();
                }
            }
            return any;
        }

        public void forEachRemaining(ShortConsumer action) {
            while (this.length > 0) {
                this.f3036a[this.offset].forEachRemaining((ShortSpliterator) action);
                advanceNextSpliterator();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Short> action) {
            while (this.length > 0) {
                this.f3036a[this.offset].forEachRemaining(action);
                advanceNextSpliterator();
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.length <= 0) {
                return 0;
            }
            long est = this.f3036a[this.offset].estimateSize() + this.remainingEstimatedExceptCurrent;
            if (est < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
            return est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            if (this.length == 1 && (this.characteristics & 4) != 0) {
                return this.f3036a[this.offset].getComparator();
            }
            throw new IllegalStateException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            switch (this.length) {
                case 0:
                    return null;
                case 1:
                    ShortSpliterator split = this.f3036a[this.offset].trySplit();
                    this.characteristics = this.f3036a[this.offset].characteristics();
                    return split;
                case 2:
                    ShortSpliterator[] shortSpliteratorArr = this.f3036a;
                    int i = this.offset;
                    this.offset = i + 1;
                    ShortSpliterator split2 = shortSpliteratorArr[i];
                    this.length--;
                    this.characteristics = this.f3036a[this.offset].characteristics();
                    this.remainingEstimatedExceptCurrent = 0;
                    return split2;
                default:
                    int mid = this.length >> 1;
                    int ret_offset = this.offset;
                    this.offset += mid;
                    this.length -= mid;
                    this.remainingEstimatedExceptCurrent = recomputeRemaining();
                    this.characteristics = computeCharacteristics();
                    return new SpliteratorConcatenator(this.f3036a, ret_offset, mid);
            }
        }

        /* JADX WARN: Type inference failed for: r0v13, types: [long] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
        public long skip(long n) {
            char c = 0;
            if (this.length <= 0) {
                return 0;
            }
            while (c < n && this.length >= 0) {
                c += this.f3036a[this.offset].skip(n - c);
                if (c < n) {
                    advanceNextSpliterator();
                }
            }
            return c;
        }
    }

    public static ShortSpliterator concat(ShortSpliterator... a) {
        return concat(a, 0, a.length);
    }

    public static ShortSpliterator concat(ShortSpliterator[] a, int offset, int length) {
        return new SpliteratorConcatenator(a, offset, length);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$SpliteratorFromIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$SpliteratorFromIterator.class */
    public static class SpliteratorFromIterator implements ShortSpliterator {
        private static final int BATCH_INCREMENT_SIZE = 1024;
        private static final int BATCH_MAX_SIZE = 33554432;
        private final ShortIterator iter;
        final int characteristics;
        private final boolean knownSize;
        private long size;
        private int nextBatchSize;
        private ShortSpliterator delegate;

        SpliteratorFromIterator(ShortIterator iter, int characteristics) {
            this.size = LongCompanionObject.MAX_VALUE;
            this.nextBatchSize = 1024;
            this.delegate = null;
            this.iter = iter;
            this.characteristics = 256 | characteristics;
            this.knownSize = false;
        }

        SpliteratorFromIterator(ShortIterator iter, long size, int additionalCharacteristics) {
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

        public boolean tryAdvance(ShortConsumer action) {
            if (this.delegate != null) {
                boolean hadRemaining = this.delegate.tryAdvance((ShortSpliterator) action);
                if (!hadRemaining) {
                    this.delegate = null;
                }
                return hadRemaining;
            } else if (!this.iter.hasNext()) {
                return false;
            } else {
                this.size--;
                action.accept(this.iter.nextShort());
                return true;
            }
        }

        public void forEachRemaining(ShortConsumer action) {
            if (this.delegate != null) {
                this.delegate.forEachRemaining((ShortSpliterator) action);
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

        protected ShortSpliterator makeForSplit(short[] batch, int len) {
            return ShortSpliterators.wrap(batch, 0, len, this.characteristics);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            if (!this.iter.hasNext()) {
                return null;
            }
            int batchSizeEst = (!this.knownSize || this.size <= 0) ? this.nextBatchSize : (int) Math.min((long) this.nextBatchSize, this.size);
            short[] batch = new short[batchSizeEst];
            int actualSeen = 0;
            while (actualSeen < batchSizeEst && this.iter.hasNext()) {
                actualSeen++;
                batch[actualSeen] = this.iter.nextShort();
                this.size--;
            }
            if (batchSizeEst < this.nextBatchSize && this.iter.hasNext()) {
                batch = Arrays.copyOf(batch, this.nextBatchSize);
                while (this.iter.hasNext() && actualSeen < this.nextBatchSize) {
                    actualSeen++;
                    batch[actualSeen] = this.iter.nextShort();
                    this.size--;
                }
            }
            this.nextBatchSize = Math.min(33554432, this.nextBatchSize + 1024);
            ShortSpliterator split = makeForSplit(batch, actualSeen);
            if (this.iter.hasNext()) {
                return split;
            }
            this.delegate = split;
            return split.trySplit();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.iter instanceof ShortBigListIterator) {
                long skipped = ((ShortBigListIterator) this.iter).skip(n);
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

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$SpliteratorFromIteratorWithComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$SpliteratorFromIteratorWithComparator.class */
    private static class SpliteratorFromIteratorWithComparator extends SpliteratorFromIterator {
        private final ShortComparator comparator;

        SpliteratorFromIteratorWithComparator(ShortIterator iter, int additionalCharacteristics, ShortComparator comparator) {
            super(iter, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        SpliteratorFromIteratorWithComparator(ShortIterator iter, long size, int additionalCharacteristics, ShortComparator comparator) {
            super(iter, size, additionalCharacteristics | 20);
            this.comparator = comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator
        public ShortComparator getComparator() {
            return this.comparator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterators.SpliteratorFromIterator
        protected ShortSpliterator makeForSplit(short[] array, int len) {
            return ShortSpliterators.wrapPreSorted(array, 0, len, this.characteristics, this.comparator);
        }
    }

    public static ShortSpliterator asSpliterator(ShortIterator iter, long size, int additionalCharacterisitcs) {
        return new SpliteratorFromIterator(iter, size, additionalCharacterisitcs);
    }

    public static ShortSpliterator asSpliteratorFromSorted(ShortIterator iter, long size, int additionalCharacterisitcs, ShortComparator comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, size, additionalCharacterisitcs, comparator);
    }

    public static ShortSpliterator asSpliteratorUnknownSize(ShortIterator iter, int characterisitcs) {
        return new SpliteratorFromIterator(iter, characterisitcs);
    }

    public static ShortSpliterator asSpliteratorFromSortedUnknownSize(ShortIterator iter, int additionalCharacterisitcs, ShortComparator comparator) {
        return new SpliteratorFromIteratorWithComparator(iter, additionalCharacterisitcs, comparator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$IteratorFromSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$IteratorFromSpliterator.class */
    private static final class IteratorFromSpliterator implements ShortIterator, ShortConsumer {
        private final ShortSpliterator spliterator;
        private short holder = 0;
        private boolean hasPeeked = false;

        IteratorFromSpliterator(ShortSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortConsumer
        public void accept(short item) {
            this.holder = item;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.hasPeeked) {
                return true;
            }
            if (!this.spliterator.tryAdvance((ShortSpliterator) this)) {
                return false;
            }
            this.hasPeeked = true;
            return true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                return this.holder;
            } else if (this.spliterator.tryAdvance((ShortSpliterator) this)) {
                return this.holder;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public void forEachRemaining(ShortConsumer action) {
            if (this.hasPeeked) {
                this.hasPeeked = false;
                action.accept(this.holder);
            }
            this.spliterator.forEachRemaining((ShortSpliterator) action);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
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

    public static ShortIterator asIterator(ShortSpliterator spliterator) {
        return new IteratorFromSpliterator(spliterator);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortSpliterators$ByteSpliteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortSpliterators$ByteSpliteratorWrapper.class */
    private static final class ByteSpliteratorWrapper implements ShortSpliterator {
        final ByteSpliterator spliterator;

        public ByteSpliteratorWrapper(ByteSpliterator spliterator) {
            this.spliterator = spliterator;
        }

        public boolean tryAdvance(ShortConsumer action) {
            Objects.requireNonNull(action);
            ByteSpliterator byteSpliterator = this.spliterator;
            Objects.requireNonNull(action);
            return byteSpliterator.tryAdvance((ByteSpliterator) (v1) -> {
                r1.accept(v1);
            });
        }

        public void forEachRemaining(ShortConsumer action) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator
        public long skip(long n) {
            return this.spliterator.skip(n);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public ShortSpliterator trySplit() {
            ByteSpliterator possibleSplit = this.spliterator.trySplit();
            if (possibleSplit == null) {
                return null;
            }
            return new ByteSpliteratorWrapper(possibleSplit);
        }
    }

    public static ShortSpliterator wrap(ByteSpliterator spliterator) {
        return new ByteSpliteratorWrapper(spliterator);
    }
}
