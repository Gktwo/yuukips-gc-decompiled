package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.DoubleConsumer;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigSpliterators.class */
public final class DoubleBigSpliterators {

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators$AbstractIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigSpliterators$AbstractIndexBasedSpliterator.class */
    public static abstract class AbstractIndexBasedSpliterator extends AbstractDoubleSpliterator {
        protected long pos;

        protected abstract double get(long j);

        protected abstract long getMaxPos();

        protected abstract DoubleSpliterator makeForSplit(long j, long j2);

        protected AbstractIndexBasedSpliterator(long initialPos) {
            this.pos = initialPos;
        }

        protected long computeSplitPoint() {
            return this.pos + ((getMaxPos() - this.pos) / 2);
        }

        private void splitPointCheck(long splitPoint, long observedMax) {
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
            return getMaxPos() - this.pos;
        }

        @Override // java.util.Spliterator.OfDouble
        public boolean tryAdvance(DoubleConsumer action) {
            if (this.pos >= getMaxPos()) {
                return false;
            }
            long j = this.pos;
            this.pos = j + 1;
            action.accept(get(j));
            return true;
        }

        @Override // java.util.Spliterator.OfDouble
        public void forEachRemaining(DoubleConsumer action) {
            long max = getMaxPos();
            while (this.pos < max) {
                action.accept(get(this.pos));
                this.pos++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator
        public long skip(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            long max = getMaxPos();
            if (this.pos >= max) {
                return 0;
            }
            long remaining = max - this.pos;
            if (n < remaining) {
                this.pos += n;
                return n;
            }
            this.pos = max;
            return remaining;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public DoubleSpliterator trySplit() {
            long max = getMaxPos();
            long splitPoint = computeSplitPoint();
            if (splitPoint == this.pos || splitPoint == max) {
                return null;
            }
            splitPointCheck(splitPoint, max);
            DoubleSpliterator maybeSplit = makeForSplit(this.pos, splitPoint);
            if (maybeSplit != null) {
                this.pos = splitPoint;
            }
            return maybeSplit;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators$EarlyBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigSpliterators$EarlyBindingSizeIndexBasedSpliterator.class */
    public static abstract class EarlyBindingSizeIndexBasedSpliterator extends AbstractIndexBasedSpliterator {
        protected final long maxPos;

        protected EarlyBindingSizeIndexBasedSpliterator(long initialPos, long maxPos) {
            super(initialPos);
            this.maxPos = maxPos;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators.AbstractIndexBasedSpliterator
        protected final long getMaxPos() {
            return this.maxPos;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators$LateBindingSizeIndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigSpliterators$LateBindingSizeIndexBasedSpliterator.class */
    public static abstract class LateBindingSizeIndexBasedSpliterator extends AbstractIndexBasedSpliterator {
        protected long maxPos;
        private boolean maxPosFixed;

        protected abstract long getMaxPosFromBackingStore();

        /* access modifiers changed from: protected */
        public LateBindingSizeIndexBasedSpliterator(long initialPos) {
            super(initialPos);
            this.maxPos = -1;
            this.maxPosFixed = false;
        }

        /* access modifiers changed from: protected */
        public LateBindingSizeIndexBasedSpliterator(long initialPos, long fixedMaxPos) {
            super(initialPos);
            this.maxPos = -1;
            this.maxPos = fixedMaxPos;
            this.maxPosFixed = true;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators.AbstractIndexBasedSpliterator
        protected final long getMaxPos() {
            return this.maxPosFixed ? this.maxPos : getMaxPosFromBackingStore();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigSpliterators.AbstractIndexBasedSpliterator, p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public DoubleSpliterator trySplit() {
            DoubleSpliterator maybeSplit = trySplit();
            if (!this.maxPosFixed && maybeSplit != null) {
                this.maxPos = getMaxPosFromBackingStore();
                this.maxPosFixed = true;
            }
            return maybeSplit;
        }
    }
}
