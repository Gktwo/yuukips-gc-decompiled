package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

@Beta
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/math/Stats.class */
public final class Stats implements Serializable {
    private final long count;
    private final double mean;
    private final double sumOfSquaresOfDeltas;
    private final double min;
    private final double max;
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public Stats(long count, double mean, double sumOfSquaresOfDeltas, double min, double max) {
        this.count = count;
        this.mean = mean;
        this.sumOfSquaresOfDeltas = sumOfSquaresOfDeltas;
        this.min = min;
        this.max = max;
    }

    /* renamed from: of */
    public static Stats m1332of(Iterable<? extends Number> values) {
        StatsAccumulator accumulator = new StatsAccumulator();
        accumulator.addAll(values);
        return accumulator.snapshot();
    }

    /* renamed from: of */
    public static Stats m1331of(Iterator<? extends Number> values) {
        StatsAccumulator accumulator = new StatsAccumulator();
        accumulator.addAll(values);
        return accumulator.snapshot();
    }

    /* renamed from: of */
    public static Stats m1330of(double... values) {
        StatsAccumulator acummulator = new StatsAccumulator();
        acummulator.addAll(values);
        return acummulator.snapshot();
    }

    /* renamed from: of */
    public static Stats m1329of(int... values) {
        StatsAccumulator acummulator = new StatsAccumulator();
        acummulator.addAll(values);
        return acummulator.snapshot();
    }

    /* renamed from: of */
    public static Stats m1328of(long... values) {
        StatsAccumulator acummulator = new StatsAccumulator();
        acummulator.addAll(values);
        return acummulator.snapshot();
    }

    public long count() {
        return this.count;
    }

    public double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public double sum() {
        return this.mean * ((double) this.count);
    }

    public double populationVariance() {
        Preconditions.checkState(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) count());
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) (this.count - 1));
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double min() {
        Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public double max() {
        Preconditions.checkState(this.count != 0);
        return this.max;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Stats other = (Stats) obj;
        return this.count == other.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(other.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(other.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(other.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(other.max);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    @Override // java.lang.Object
    public String toString() {
        if (count() > 0) {
            return MoreObjects.toStringHelper(this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", populationStandardDeviation()).add("min", this.min).add("max", this.max).toString();
        }
        return MoreObjects.toStringHelper(this).add("count", this.count).toString();
    }

    /* access modifiers changed from: package-private */
    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public static double meanOf(Iterable<? extends Number> values) {
        return meanOf(values.iterator());
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    public static double meanOf(Iterator<? extends Number> values) {
        Preconditions.checkArgument(values.hasNext());
        char c = 1;
        double mean = ((Number) values.next()).doubleValue();
        while (values.hasNext()) {
            double value = ((Number) values.next()).doubleValue();
            c++;
            if (!Doubles.isFinite(value) || !Doubles.isFinite(mean)) {
                mean = StatsAccumulator.calculateNewMeanNonFinite(mean, value);
            } else {
                mean += (value - mean) / ((double) c);
            }
        }
        return mean;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0043 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [double] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double meanOf(double... r7) {
        /*
            r0 = r7
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            com.google.common.base.Preconditions.checkArgument(r0)
            r0 = r7
            r1 = 0
            r0 = r0[r1]
            r8 = r0
            r0 = 1
            r10 = r0
        L_0x0013:
            r0 = r10
            r1 = r7
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0049
            r0 = r7
            r1 = r10
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            boolean r0 = com.google.common.primitives.Doubles.isFinite(r0)
            if (r0 == 0) goto L_0x003c
            r0 = r8
            boolean r0 = com.google.common.primitives.Doubles.isFinite(r0)
            if (r0 == 0) goto L_0x003c
            r0 = r8
            r1 = r11
            r2 = r8
            double r1 = r1 - r2
            r2 = r10
            r3 = 1
            int r2 = r2 + r3
            double r2 = (double) r2
            double r1 = r1 / r2
            double r0 = r0 + r1
            r8 = r0
            goto L_0x0043
        L_0x003c:
            r0 = r8
            r1 = r11
            double r0 = com.google.common.math.StatsAccumulator.calculateNewMeanNonFinite(r0, r1)
            r8 = r0
        L_0x0043:
            int r10 = r10 + 1
            goto L_0x0013
        L_0x0049:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.Stats.meanOf(double[]):double");
    }

    public static double meanOf(int... values) {
        Preconditions.checkArgument(values.length > 0);
        double mean = (double) values[0];
        for (int index = 1; index < values.length; index++) {
            double value = (double) values[index];
            if (!Doubles.isFinite(value) || !Doubles.isFinite(mean)) {
                mean = StatsAccumulator.calculateNewMeanNonFinite(mean, value);
            } else {
                mean += (value - mean) / ((double) (index + 1));
            }
        }
        return mean;
    }

    public static double meanOf(long... values) {
        Preconditions.checkArgument(values.length > 0);
        double mean = (double) values[0];
        for (int index = 1; index < values.length; index++) {
            double value = (double) values[index];
            if (!Doubles.isFinite(value) || !Doubles.isFinite(mean)) {
                mean = StatsAccumulator.calculateNewMeanNonFinite(mean, value);
            } else {
                mean += (value - mean) / ((double) (index + 1));
            }
        }
        return mean;
    }

    public byte[] toByteArray() {
        ByteBuffer buff = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(buff);
        return buff.array();
    }

    /* access modifiers changed from: package-private */
    public void writeTo(ByteBuffer buffer) {
        Preconditions.checkNotNull(buffer);
        Preconditions.checkArgument(buffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, buffer.remaining());
        buffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static Stats fromByteArray(byte[] byteArray) {
        Preconditions.checkNotNull(byteArray);
        Preconditions.checkArgument(byteArray.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, byteArray.length);
        return readFrom(ByteBuffer.wrap(byteArray).order(ByteOrder.LITTLE_ENDIAN));
    }

    /* access modifiers changed from: package-private */
    public static Stats readFrom(ByteBuffer buffer) {
        Preconditions.checkNotNull(buffer);
        Preconditions.checkArgument(buffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, buffer.remaining());
        return new Stats(buffer.getLong(), buffer.getDouble(), buffer.getDouble(), buffer.getDouble(), buffer.getDouble());
    }
}
