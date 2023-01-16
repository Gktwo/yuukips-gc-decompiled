package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.stream.Collector;

@Beta
/* loaded from: grasscutter.jar:com/google/common/hash/BloomFilter.class */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final int numHashFunctions;
    private final Funnel<? super T> funnel;
    private final Strategy strategy;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/hash/BloomFilter$Strategy.class */
    public interface Strategy extends Serializable {
        <T> boolean put(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray bits, int numHashFunctions, Funnel<? super T> funnel, Strategy strategy) {
        Preconditions.checkArgument(numHashFunctions > 0, "numHashFunctions (%s) must be > 0", numHashFunctions);
        Preconditions.checkArgument(numHashFunctions <= 255, "numHashFunctions (%s) must be <= 255", numHashFunctions);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(bits);
        this.numHashFunctions = numHashFunctions;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy);
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean mightContain(T object) {
        return this.strategy.mightContain(object, this.funnel, this.numHashFunctions, this.bits);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T input) {
        return mightContain(input);
    }

    @CanIgnoreReturnValue
    public boolean put(T object) {
        return this.strategy.put(object, this.funnel, this.numHashFunctions, this.bits);
    }

    public double expectedFpp() {
        return Math.pow(((double) this.bits.bitCount()) / ((double) bitSize()), (double) this.numHashFunctions);
    }

    public long approximateElementCount() {
        long bitSize = this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(((double) this.bits.bitCount()) / ((double) bitSize)))) * ((double) bitSize)) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    @VisibleForTesting
    long bitSize() {
        return this.bits.bitSize();
    }

    public boolean isCompatible(BloomFilter<T> that) {
        Preconditions.checkNotNull(that);
        return this != that && this.numHashFunctions == that.numHashFunctions && bitSize() == that.bitSize() && this.strategy.equals(that.strategy) && this.funnel.equals(that.funnel);
    }

    public void putAll(BloomFilter<T> that) {
        Preconditions.checkNotNull(that);
        Preconditions.checkArgument(this != that, "Cannot combine a BloomFilter with itself.");
        Preconditions.checkArgument(this.numHashFunctions == that.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, that.numHashFunctions);
        Preconditions.checkArgument(bitSize() == that.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), that.bitSize());
        Preconditions.checkArgument(this.strategy.equals(that.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, that.strategy);
        Preconditions.checkArgument(this.funnel.equals(that.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, that.funnel);
        this.bits.putAll(that.bits);
    }

    @Override // com.google.common.base.Predicate, java.lang.Object
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BloomFilter)) {
            return false;
        }
        BloomFilter<?> that = (BloomFilter) object;
        return this.numHashFunctions == that.numHashFunctions && this.funnel.equals(that.funnel) && this.bits.equals(that.bits) && this.strategy.equals(that.strategy);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> funnel, long expectedInsertions) {
        return toBloomFilter(funnel, expectedInsertions, 0.03d);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> funnel, long expectedInsertions, double fpp) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(expectedInsertions >= 0, "Expected insertions (%s) must be >= 0", expectedInsertions);
        Preconditions.checkArgument(fpp > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(fpp));
        Preconditions.checkArgument(fpp < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(fpp));
        return Collector.of(() -> {
            return create(funnel, expectedInsertions, fpp);
        }, (v0, v1) -> {
            v0.put(v1);
        }, bf1, bf2 -> {
            bf1.putAll(bf2);
            return bf1;
        }, Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int expectedInsertions, double fpp) {
        return create(funnel, (long) expectedInsertions, fpp);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long expectedInsertions, double fpp) {
        return create(funnel, expectedInsertions, fpp, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.common.hash.BloomFilter<T> create(com.google.common.hash.Funnel<? super T> r7, long r8, double r10, com.google.common.hash.BloomFilter.Strategy r12) {
        /*
            r0 = r7
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r1 = "Expected insertions (%s) must be >= 0"
            r2 = r8
            com.google.common.base.Preconditions.checkArgument(r0, r1, r2)
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            java.lang.String r1 = "False positive probability (%s) must be > 0.0"
            r2 = r10
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            com.google.common.base.Preconditions.checkArgument(r0, r1, r2)
            r0 = r10
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            java.lang.String r1 = "False positive probability (%s) must be < 1.0"
            r2 = r10
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            com.google.common.base.Preconditions.checkArgument(r0, r1, r2)
            r0 = r12
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x004c
            r0 = 1
            r8 = r0
        L_0x004c:
            r0 = r8
            r1 = r10
            long r0 = optimalNumOfBits(r0, r1)
            r13 = r0
            r0 = r8
            r1 = r13
            int r0 = optimalNumOfHashFunctions(r0, r1)
            r15 = r0
            com.google.common.hash.BloomFilter r0 = new com.google.common.hash.BloomFilter     // Catch: IllegalArgumentException -> 0x0071
            r1 = r0
            com.google.common.hash.BloomFilterStrategies$LockFreeBitArray r2 = new com.google.common.hash.BloomFilterStrategies$LockFreeBitArray     // Catch: IllegalArgumentException -> 0x0071
            r3 = r2
            r4 = r13
            r3.<init>(r4)     // Catch: IllegalArgumentException -> 0x0071
            r3 = r15
            r4 = r7
            r5 = r12
            r1.<init>(r2, r3, r4, r5)     // Catch: IllegalArgumentException -> 0x0071
            return r0
        L_0x0071:
            r16 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Could not create BloomFilter of "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r13
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " bits"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = r16
            r1.<init>(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.BloomFilter.create(com.google.common.hash.Funnel, long, double, com.google.common.hash.BloomFilter$Strategy):com.google.common.hash.BloomFilter");
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int expectedInsertions) {
        return create(funnel, (long) expectedInsertions);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long expectedInsertions) {
        return create(funnel, expectedInsertions, 0.03d);
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round((((double) m) / ((double) n)) * Math.log(2.0d)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static long optimalNumOfBits(long r7, double r9) {
        /*
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x000a
            r0 = 1
            r9 = r0
        L_0x000a:
            r0 = r7
            long r0 = -r0
            double r0 = (double) r0
            r1 = r9
            double r1 = java.lang.Math.log(r1)
            double r0 = r0 * r1
            r1 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r1 = java.lang.Math.log(r1)
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = java.lang.Math.log(r2)
            double r1 = r1 * r2
            double r0 = r0 / r1
            long r0 = (long) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.BloomFilter.optimalNumOfBits(long, double):long");
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/BloomFilter$SerialForm.class */
    private static class SerialForm<T> implements Serializable {
        final long[] data;
        final int numHashFunctions;
        final Funnel<? super T> funnel;
        final Strategy strategy;
        private static final long serialVersionUID = 1;

        SerialForm(BloomFilter<T> bf) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(((BloomFilter) bf).bits.data);
            this.numHashFunctions = ((BloomFilter) bf).numHashFunctions;
            this.funnel = ((BloomFilter) bf).funnel;
            this.strategy = ((BloomFilter) bf).strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public void writeTo(OutputStream out) throws IOException {
        DataOutputStream dout = new DataOutputStream(out);
        dout.writeByte(SignedBytes.checkedCast((long) this.strategy.ordinal()));
        dout.writeByte(UnsignedBytes.checkedCast((long) this.numHashFunctions));
        dout.writeInt(this.bits.data.length());
        for (int i = 0; i < this.bits.data.length(); i++) {
            dout.writeLong(this.bits.data.get(i));
        }
    }

    public static <T> BloomFilter<T> readFrom(InputStream in, Funnel<? super T> funnel) throws IOException {
        Preconditions.checkNotNull(in, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        int strategyOrdinal = -1;
        int numHashFunctions = -1;
        int dataLength = -1;
        try {
            DataInputStream din = new DataInputStream(in);
            strategyOrdinal = din.readByte();
            numHashFunctions = UnsignedBytes.toInt(din.readByte());
            dataLength = din.readInt();
            Strategy strategy = BloomFilterStrategies.values()[strategyOrdinal];
            long[] data = new long[dataLength];
            for (int i = 0; i < data.length; i++) {
                data[i] = din.readLong();
            }
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(data), numHashFunctions, funnel, strategy);
        } catch (RuntimeException e) {
            throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + strategyOrdinal + " numHashFunctions: " + numHashFunctions + " dataLength: " + dataLength, e);
        }
    }
}
