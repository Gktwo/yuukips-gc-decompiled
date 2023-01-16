package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* loaded from: grasscutter.jar:com/google/common/hash/FarmHashFingerprint64.class */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();

    /* renamed from: K0 */
    private static final long f289K0 = -4348849565147123417L;

    /* renamed from: K1 */
    private static final long f290K1 = -5435081209227447693L;

    /* renamed from: K2 */
    private static final long f291K2 = -7286425919675154353L;

    FarmHashFingerprint64() {
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] input, int off, int len) {
        Preconditions.checkPositionIndexes(off, off + len, input.length);
        return HashCode.fromLong(fingerprint(input, off, len));
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }

    @VisibleForTesting
    static long fingerprint(byte[] bytes, int offset, int length) {
        if (length <= 32) {
            if (length <= 16) {
                return hashLength0to16(bytes, offset, length);
            }
            return hashLength17to32(bytes, offset, length);
        } else if (length <= 64) {
            return hashLength33To64(bytes, offset, length);
        } else {
            return hashLength65Plus(bytes, offset, length);
        }
    }

    private static long shiftMix(long val) {
        return val ^ (val >>> 47);
    }

    private static long hashLength16(long u, long v, long mul) {
        long a = (u ^ v) * mul;
        long b = (v ^ (a ^ (a >>> 47))) * mul;
        return (b ^ (b >>> 47)) * mul;
    }

    private static void weakHashLength32WithSeeds(byte[] bytes, int offset, long seedA, long seedB, long[] output) {
        long part1 = LittleEndianByteArray.load64(bytes, offset);
        long part2 = LittleEndianByteArray.load64(bytes, offset + 8);
        long part3 = LittleEndianByteArray.load64(bytes, offset + 16);
        long part4 = LittleEndianByteArray.load64(bytes, offset + 24);
        long seedA2 = seedA + part1;
        long seedB2 = Long.rotateRight(seedB + seedA2 + part4, 21);
        long seedA3 = seedA2 + part2 + part3;
        output[0] = seedA3 + part4;
        output[1] = seedB2 + Long.rotateRight(seedA3, 44) + seedA2;
    }

    private static long hashLength0to16(byte[] bytes, int offset, int length) {
        if (length >= 8) {
            long mul = f291K2 + ((long) (length * 2));
            long a = LittleEndianByteArray.load64(bytes, offset) + f291K2;
            long b = LittleEndianByteArray.load64(bytes, (offset + length) - 8);
            return hashLength16((Long.rotateRight(b, 37) * mul) + a, (Long.rotateRight(a, 25) + b) * mul, mul);
        } else if (length >= 4) {
            return hashLength16(((long) length) + ((((long) LittleEndianByteArray.load32(bytes, offset)) & 4294967295L) << 3), ((long) LittleEndianByteArray.load32(bytes, (offset + length) - 4)) & 4294967295L, f291K2 + ((long) (length * 2)));
        } else if (length <= 0) {
            return f291K2;
        } else {
            byte a2 = bytes[offset];
            byte b2 = bytes[offset + (length >> 1)];
            return shiftMix((((long) ((a2 & 255) + ((b2 & 255) << 8))) * f291K2) ^ (((long) (length + ((bytes[offset + (length - 1)] & 255) << 2))) * f289K0)) * f291K2;
        }
    }

    private static long hashLength17to32(byte[] bytes, int offset, int length) {
        long mul = f291K2 + ((long) (length * 2));
        long a = LittleEndianByteArray.load64(bytes, offset) * f290K1;
        long b = LittleEndianByteArray.load64(bytes, offset + 8);
        long c = LittleEndianByteArray.load64(bytes, (offset + length) - 8) * mul;
        return hashLength16(Long.rotateRight(a + b, 43) + Long.rotateRight(c, 30) + (LittleEndianByteArray.load64(bytes, (offset + length) - 16) * f291K2), a + Long.rotateRight(b + f291K2, 18) + c, mul);
    }

    private static long hashLength33To64(byte[] bytes, int offset, int length) {
        long mul = f291K2 + ((long) (length * 2));
        long a = LittleEndianByteArray.load64(bytes, offset) * f291K2;
        long b = LittleEndianByteArray.load64(bytes, offset + 8);
        long c = LittleEndianByteArray.load64(bytes, (offset + length) - 8) * mul;
        long y = Long.rotateRight(a + b, 43) + Long.rotateRight(c, 30) + (LittleEndianByteArray.load64(bytes, (offset + length) - 16) * f291K2);
        long z = hashLength16(y, a + Long.rotateRight(b + f291K2, 18) + c, mul);
        long e = LittleEndianByteArray.load64(bytes, offset + 16) * mul;
        long f = LittleEndianByteArray.load64(bytes, offset + 24);
        long g = (y + LittleEndianByteArray.load64(bytes, (offset + length) - 32)) * mul;
        return hashLength16(Long.rotateRight(e + f, 43) + Long.rotateRight(g, 30) + ((z + LittleEndianByteArray.load64(bytes, (offset + length) - 24)) * mul), e + Long.rotateRight(f + a, 18) + g, mul);
    }

    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    /* JADX WARN: Type inference failed for: r0v38, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long hashLength65Plus(byte[] r10, int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 513
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.FarmHashFingerprint64.hashLength65Plus(byte[], int, int):long");
    }
}
