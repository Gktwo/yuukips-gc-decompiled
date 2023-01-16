package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: grasscutter.jar:com/google/common/hash/BloomFilterStrategies.class */
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 {
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T object, Funnel<? super T> funnel, int numHashFunctions, LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
            int hash1 = (int) hash64;
            int hash2 = (int) (hash64 >>> 32);
            boolean bitsChanged = false;
            for (int i = 1; i <= numHashFunctions; i++) {
                int combinedHash = hash1 + (i * hash2);
                if (combinedHash < 0) {
                    combinedHash ^= -1;
                }
                bitsChanged |= bits.set(((long) combinedHash) % bitSize);
            }
            return bitsChanged;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T object, Funnel<? super T> funnel, int numHashFunctions, LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
            int hash1 = (int) hash64;
            int hash2 = (int) (hash64 >>> 32);
            for (int i = 1; i <= numHashFunctions; i++) {
                int combinedHash = hash1 + (i * hash2);
                if (combinedHash < 0) {
                    combinedHash ^= -1;
                }
                if (!bits.get(((long) combinedHash) % bitSize)) {
                    return false;
                }
            }
            return true;
        }
    },
    MURMUR128_MITZ_64 {
        /* JADX WARN: Type inference failed for: r0v6, types: [long] */
        /* JADX WARN: Type inference failed for: r0v17, types: [long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.common.hash.BloomFilter.Strategy
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> boolean put(T r8, com.google.common.hash.Funnel<? super T> r9, int r10, com.google.common.hash.BloomFilterStrategies.LockFreeBitArray r11) {
            /*
                r7 = this;
                r0 = r11
                long r0 = r0.bitSize()
                r12 = r0
                com.google.common.hash.HashFunction r0 = com.google.common.hash.Hashing.murmur3_128()
                r1 = r8
                r2 = r9
                com.google.common.hash.HashCode r0 = r0.hashObject(r1, r2)
                byte[] r0 = r0.getBytesInternal()
                r14 = r0
                r0 = r7
                r1 = r14
                long r0 = r0.lowerEight(r1)
                r15 = r0
                r0 = r7
                r1 = r14
                long r0 = r0.upperEight(r1)
                r17 = r0
                r0 = 0
                r19 = r0
                r0 = r15
                r20 = r0
                r0 = 0
                r22 = r0
            L_0x0030:
                r0 = r22
                r1 = r10
                if (r0 >= r1) goto L_0x0056
                r0 = r19
                r1 = r11
                r2 = r20
                r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                long r2 = r2 & r3
                r3 = r12
                long r2 = r2 % r3
                boolean r1 = r1.set(r2)
                r0 = r0 | r1
                r19 = r0
                r0 = r20
                r1 = r17
                long r0 = r0 + r1
                r20 = r0
                int r22 = r22 + 1
                goto L_0x0030
            L_0x0056:
                r0 = r19
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.BloomFilterStrategies.C04602.put(java.lang.Object, com.google.common.hash.Funnel, int, com.google.common.hash.BloomFilterStrategies$LockFreeBitArray):boolean");
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [long] */
        /* JADX WARN: Type inference failed for: r0v17, types: [long] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.common.hash.BloomFilter.Strategy
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> boolean mightContain(T r7, com.google.common.hash.Funnel<? super T> r8, int r9, com.google.common.hash.BloomFilterStrategies.LockFreeBitArray r10) {
            /*
                r6 = this;
                r0 = r10
                long r0 = r0.bitSize()
                r11 = r0
                com.google.common.hash.HashFunction r0 = com.google.common.hash.Hashing.murmur3_128()
                r1 = r7
                r2 = r8
                com.google.common.hash.HashCode r0 = r0.hashObject(r1, r2)
                byte[] r0 = r0.getBytesInternal()
                r13 = r0
                r0 = r6
                r1 = r13
                long r0 = r0.lowerEight(r1)
                r14 = r0
                r0 = r6
                r1 = r13
                long r0 = r0.upperEight(r1)
                r16 = r0
                r0 = r14
                r18 = r0
                r0 = 0
                r20 = r0
            L_0x002d:
                r0 = r20
                r1 = r9
                if (r0 >= r1) goto L_0x0053
                r0 = r10
                r1 = r18
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                long r1 = r1 & r2
                r2 = r11
                long r1 = r1 % r2
                boolean r0 = r0.get(r1)
                if (r0 != 0) goto L_0x0046
                r0 = 0
                return r0
            L_0x0046:
                r0 = r18
                r1 = r16
                long r0 = r0 + r1
                r18 = r0
                int r20 = r20 + 1
                goto L_0x002d
            L_0x0053:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.BloomFilterStrategies.C04602.mightContain(java.lang.Object, com.google.common.hash.Funnel, int, com.google.common.hash.BloomFilterStrategies$LockFreeBitArray):boolean");
        }

        private long lowerEight(byte[] bytes) {
            return Longs.fromBytes(bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]);
        }

        private long upperEight(byte[] bytes) {
            return Longs.fromBytes(bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]);
        }
    };

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/hash/BloomFilterStrategies$LockFreeBitArray.class */
    public static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        final AtomicLongArray data;
        private final LongAddable bitCount;

        /* access modifiers changed from: package-private */
        public LockFreeBitArray(long bits) {
            this(new long[Ints.checkedCast(LongMath.divide(bits, 64, RoundingMode.CEILING))]);
        }

        /* JADX WARN: Type inference failed for: r0v17, types: [long] */
        /* access modifiers changed from: package-private */
        public LockFreeBitArray(long[] data) {
            Preconditions.checkArgument(data.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(data);
            this.bitCount = LongAddables.create();
            char c = 0;
            for (long value : data) {
                c += (long) Long.bitCount(value);
            }
            this.bitCount.add(c);
        }

        boolean set(long bitIndex) {
            long oldValue;
            long newValue;
            if (get(bitIndex)) {
                return false;
            }
            int longIndex = (int) (bitIndex >>> 6);
            long mask = 1 << ((int) bitIndex);
            do {
                oldValue = this.data.get(longIndex);
                newValue = oldValue | mask;
                if (oldValue == newValue) {
                    return false;
                }
            } while (!this.data.compareAndSet(longIndex, oldValue, newValue));
            this.bitCount.increment();
            return true;
        }

        boolean get(long bitIndex) {
            return (this.data.get((int) (bitIndex >>> 6)) & (1 << ((int) bitIndex))) != 0;
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            long[] array = new long[atomicLongArray.length()];
            for (int i = 0; i < array.length; i++) {
                array[i] = atomicLongArray.get(i);
            }
            return array;
        }

        /* access modifiers changed from: package-private */
        public long bitSize() {
            return ((long) this.data.length()) * 64;
        }

        /* access modifiers changed from: package-private */
        public long bitCount() {
            return this.bitCount.sum();
        }

        /* access modifiers changed from: package-private */
        public LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        /* access modifiers changed from: package-private */
        public void putAll(LockFreeBitArray other) {
            long ourLongOld;
            long ourLongNew;
            Preconditions.checkArgument(this.data.length() == other.data.length(), "BitArrays must be of equal length (%s != %s)", this.data.length(), other.data.length());
            for (int i = 0; i < this.data.length(); i++) {
                long otherLong = other.data.get(i);
                boolean changedAnyBits = true;
                while (true) {
                    ourLongOld = this.data.get(i);
                    ourLongNew = ourLongOld | otherLong;
                    if (ourLongOld != ourLongNew) {
                        if (this.data.compareAndSet(i, ourLongOld, ourLongNew)) {
                            break;
                        }
                    } else {
                        changedAnyBits = false;
                        break;
                    }
                }
                if (changedAnyBits) {
                    this.bitCount.add((long) (Long.bitCount(ourLongNew) - Long.bitCount(ourLongOld)));
                }
            }
        }

        public boolean equals(Object o) {
            if (o instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) o).data));
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }
    }
}
