package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;

@Beta
/* loaded from: grasscutter.jar:com/google/common/hash/HashCode.class */
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    public abstract int bits();

    public abstract int asInt();

    public abstract long asLong();

    public abstract long padToLong();

    public abstract byte[] asBytes();

    abstract void writeBytesToImpl(byte[] bArr, int i, int i2);

    abstract boolean equalsSameBits(HashCode hashCode);

    HashCode() {
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] dest, int offset, int maxLength) {
        int maxLength2 = Ints.min(maxLength, bits() / 8);
        Preconditions.checkPositionIndexes(offset, offset + maxLength2, dest.length);
        writeBytesToImpl(dest, offset, maxLength2);
        return maxLength2;
    }

    /* access modifiers changed from: package-private */
    public byte[] getBytesInternal() {
        return asBytes();
    }

    public static HashCode fromInt(int hash) {
        return new IntHashCode(hash);
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/HashCode$IntHashCode.class */
    private static final class IntHashCode extends HashCode implements Serializable {
        final int hash;
        private static final long serialVersionUID = 0;

        IntHashCode(int hash) {
            this.hash = hash;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return new byte[]{(byte) this.hash, (byte) (this.hash >> 8), (byte) (this.hash >> 16), (byte) (this.hash >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] dest, int offset, int maxLength) {
            for (int i = 0; i < maxLength; i++) {
                dest[offset + i] = (byte) (this.hash >> (i * 8));
            }
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode that) {
            return this.hash == that.asInt();
        }
    }

    public static HashCode fromLong(long hash) {
        return new LongHashCode(hash);
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/HashCode$LongHashCode.class */
    private static final class LongHashCode extends HashCode implements Serializable {
        final long hash;
        private static final long serialVersionUID = 0;

        LongHashCode(long hash) {
            this.hash = hash;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return new byte[]{(byte) ((int) this.hash), (byte) ((int) (this.hash >> 8)), (byte) ((int) (this.hash >> 16)), (byte) ((int) (this.hash >> 24)), (byte) ((int) (this.hash >> 32)), (byte) ((int) (this.hash >> 40)), (byte) ((int) (this.hash >> 48)), (byte) ((int) (this.hash >> 56))};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] dest, int offset, int maxLength) {
            for (int i = 0; i < maxLength; i++) {
                dest[offset + i] = (byte) ((int) (this.hash >> (i * 8)));
            }
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode that) {
            return this.hash == that.asLong();
        }
    }

    public static HashCode fromBytes(byte[] bytes) {
        Preconditions.checkArgument(bytes.length >= 1, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) bytes.clone());
    }

    /* access modifiers changed from: package-private */
    public static HashCode fromBytesNoCopy(byte[] bytes) {
        return new BytesHashCode(bytes);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/hash/HashCode$BytesHashCode.class */
    public static final class BytesHashCode extends HashCode implements Serializable {
        final byte[] bytes;
        private static final long serialVersionUID = 0;

        BytesHashCode(byte[] bytes) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bytes);
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            Preconditions.checkState(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
            return (this.bytes[0] & 255) | ((this.bytes[1] & 255) << 8) | ((this.bytes[2] & 255) << 16) | ((this.bytes[3] & 255) << 24);
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            Preconditions.checkState(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
            return padToLong();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v1, types: [long] */
        /* JADX WARN: Type inference failed for: r0v9, types: [long] */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.common.hash.HashCode
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long padToLong() {
            /*
                r7 = this;
                r0 = r7
                byte[] r0 = r0.bytes
                r1 = 0
                r0 = r0[r1]
                r1 = 255(0xff, float:3.57E-43)
                r0 = r0 & r1
                long r0 = (long) r0
                r8 = r0
                r0 = 1
                r10 = r0
            L_0x000e:
                r0 = r10
                r1 = r7
                byte[] r1 = r1.bytes
                int r1 = r1.length
                r2 = 8
                int r1 = java.lang.Math.min(r1, r2)
                if (r0 >= r1) goto L_0x0035
                r0 = r8
                r1 = r7
                byte[] r1 = r1.bytes
                r2 = r10
                r1 = r1[r2]
                long r1 = (long) r1
                r2 = 255(0xff, double:1.26E-321)
                long r1 = r1 & r2
                r2 = r10
                r3 = 8
                int r2 = r2 * r3
                long r1 = r1 << r2
                long r0 = r0 | r1
                r8 = r0
                int r10 = r10 + 1
                goto L_0x000e
            L_0x0035:
                r0 = r8
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.HashCode.BytesHashCode.padToLong():long");
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] dest, int offset, int maxLength) {
            System.arraycopy(this.bytes, 0, dest, offset, maxLength);
        }

        @Override // com.google.common.hash.HashCode
        byte[] getBytesInternal() {
            return this.bytes;
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode that) {
            if (this.bytes.length != that.getBytesInternal().length) {
                return false;
            }
            boolean areEqual = true;
            for (int i = 0; i < this.bytes.length; i++) {
                areEqual &= this.bytes[i] == that.getBytesInternal()[i];
            }
            return areEqual;
        }
    }

    public static HashCode fromString(String string) {
        Preconditions.checkArgument(string.length() >= 2, "input string (%s) must have at least 2 characters", string);
        Preconditions.checkArgument(string.length() % 2 == 0, "input string (%s) must have an even number of characters", string);
        byte[] bytes = new byte[string.length() / 2];
        for (int i = 0; i < string.length(); i += 2) {
            bytes[i / 2] = (byte) ((decode(string.charAt(i)) << 4) + decode(string.charAt(i + 1)));
        }
        return fromBytesNoCopy(bytes);
    }

    private static int decode(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        }
        if (ch >= 'a' && ch <= 'f') {
            return (ch - 'a') + 10;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + ch);
    }

    public final boolean equals(Object object) {
        if (!(object instanceof HashCode)) {
            return false;
        }
        HashCode that = (HashCode) object;
        return bits() == that.bits() && equalsSameBits(that);
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] bytes = getBytesInternal();
        int val = bytes[0] & 255;
        for (int i = 1; i < bytes.length; i++) {
            val |= (bytes[i] & 255) << (i * 8);
        }
        return val;
    }

    public final String toString() {
        byte[] bytes = getBytesInternal();
        StringBuilder sb = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            sb.append(hexDigits[(b >> 4) & 15]).append(hexDigits[b & 15]);
        }
        return sb.toString();
    }
}
