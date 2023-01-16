package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* access modifiers changed from: package-private */
@Immutable
/* loaded from: grasscutter.jar:com/google/common/hash/Murmur3_128HashFunction.class */
public final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    private final int seed;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public Murmur3_128HashFunction(int seed) {
        this.seed = seed;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    @Override // java.lang.Object
    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        return (object instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) object).seed;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getClass().hashCode() ^ this.seed;
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/Murmur3_128HashFunction$Murmur3_128Hasher.class */
    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 16;

        /* renamed from: C1 */
        private static final long f292C1 = -8663945395140668459L;

        /* renamed from: C2 */
        private static final long f293C2 = 5545529020109919103L;

        /* renamed from: h1 */
        private long f294h1;

        /* renamed from: h2 */
        private long f295h2;
        private int length = 0;

        Murmur3_128Hasher(int seed) {
            super(16);
            this.f294h1 = (long) seed;
            this.f295h2 = (long) seed;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer bb) {
            bmix64(bb.getLong(), bb.getLong());
            this.length += 16;
        }

        private void bmix64(long k1, long k2) {
            this.f294h1 ^= mixK1(k1);
            this.f294h1 = Long.rotateLeft(this.f294h1, 27);
            this.f294h1 += this.f295h2;
            this.f294h1 = (this.f294h1 * 5) + 1390208809;
            this.f295h2 ^= mixK2(k2);
            this.f295h2 = Long.rotateLeft(this.f295h2, 31);
            this.f295h2 += this.f294h1;
            this.f295h2 = (this.f295h2 * 5) + 944331445;
        }

        /* JADX WARN: Type inference failed for: r0v9, types: [long] */
        /* JADX WARN: Type inference failed for: r0v11, types: [long] */
        /* JADX WARN: Type inference failed for: r0v13, types: [long] */
        /* JADX WARN: Type inference failed for: r0v15, types: [long] */
        /* JADX WARN: Type inference failed for: r0v17, types: [long] */
        /* JADX WARN: Type inference failed for: r0v19, types: [long] */
        /* JADX WARN: Type inference failed for: r0v21, types: [long] */
        /* JADX WARN: Type inference failed for: r0v23, types: [long] */
        /* JADX WARN: Type inference failed for: r0v25, types: [long] */
        /* JADX WARN: Type inference failed for: r0v27, types: [long] */
        /* JADX WARN: Type inference failed for: r0v29, types: [long] */
        /* JADX WARN: Type inference failed for: r0v31, types: [long] */
        /* JADX WARN: Type inference failed for: r0v33, types: [long] */
        /* JADX WARN: Type inference failed for: r0v35, types: [long] */
        /* JADX WARN: Type inference failed for: r0v37, types: [long] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer bb) {
            char c;
            char c2 = 0;
            char c3 = 0;
            this.length += bb.remaining();
            switch (bb.remaining()) {
                case 1:
                    c = c2 ^ ((long) UnsignedBytes.toInt(bb.get(0)));
                    break;
                case 2:
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(1))) << 8;
                    c = c2 ^ ((long) UnsignedBytes.toInt(bb.get(0)));
                    break;
                case 3:
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(2))) << 16;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(1))) << 8;
                    c = c2 ^ ((long) UnsignedBytes.toInt(bb.get(0)));
                    break;
                case 4:
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(3))) << 24;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(2))) << 16;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(1))) << 8;
                    c = c2 ^ ((long) UnsignedBytes.toInt(bb.get(0)));
                    break;
                case 5:
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(4))) << 32;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(3))) << 24;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(2))) << 16;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(1))) << 8;
                    c = c2 ^ ((long) UnsignedBytes.toInt(bb.get(0)));
                    break;
                case 6:
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(5))) << 40;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(4))) << 32;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(3))) << 24;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(2))) << 16;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(1))) << 8;
                    c = c2 ^ ((long) UnsignedBytes.toInt(bb.get(0)));
                    break;
                case 7:
                    c2 = 0 ^ (((long) UnsignedBytes.toInt(bb.get(6))) << 48);
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(5))) << 40;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(4))) << 32;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(3))) << 24;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(2))) << 16;
                    c2 ^= ((long) UnsignedBytes.toInt(bb.get(1))) << 8;
                    c = c2 ^ ((long) UnsignedBytes.toInt(bb.get(0)));
                    break;
                case 8:
                    c = 0 ^ bb.getLong();
                    break;
                case 9:
                    c3 ^= (long) UnsignedBytes.toInt(bb.get(8));
                    c = 0 ^ bb.getLong();
                    break;
                case 10:
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(9))) << 8;
                    c3 ^= (long) UnsignedBytes.toInt(bb.get(8));
                    c = 0 ^ bb.getLong();
                    break;
                case 11:
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(10))) << 16;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(9))) << 8;
                    c3 ^= (long) UnsignedBytes.toInt(bb.get(8));
                    c = 0 ^ bb.getLong();
                    break;
                case 12:
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(11))) << 24;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(10))) << 16;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(9))) << 8;
                    c3 ^= (long) UnsignedBytes.toInt(bb.get(8));
                    c = 0 ^ bb.getLong();
                    break;
                case 13:
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(12))) << 32;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(11))) << 24;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(10))) << 16;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(9))) << 8;
                    c3 ^= (long) UnsignedBytes.toInt(bb.get(8));
                    c = 0 ^ bb.getLong();
                    break;
                case 14:
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(13))) << 40;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(12))) << 32;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(11))) << 24;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(10))) << 16;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(9))) << 8;
                    c3 ^= (long) UnsignedBytes.toInt(bb.get(8));
                    c = 0 ^ bb.getLong();
                    break;
                case 15:
                    c3 = 0 ^ (((long) UnsignedBytes.toInt(bb.get(14))) << 48);
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(13))) << 40;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(12))) << 32;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(11))) << 24;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(10))) << 16;
                    c3 ^= ((long) UnsignedBytes.toInt(bb.get(9))) << 8;
                    c3 ^= (long) UnsignedBytes.toInt(bb.get(8));
                    c = 0 ^ bb.getLong();
                    break;
                default:
                    throw new AssertionError("Should never get here.");
            }
            this.f294h1 ^= mixK1(c);
            this.f295h2 ^= mixK2(c3);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            this.f294h1 ^= (long) this.length;
            this.f295h2 ^= (long) this.length;
            this.f294h1 += this.f295h2;
            this.f295h2 += this.f294h1;
            this.f294h1 = fmix64(this.f294h1);
            this.f295h2 = fmix64(this.f295h2);
            this.f294h1 += this.f295h2;
            this.f295h2 += this.f294h1;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f294h1).putLong(this.f295h2).array());
        }

        private static long fmix64(long k) {
            long k2 = (k ^ (k >>> 33)) * -49064778989728563L;
            long k3 = (k2 ^ (k2 >>> 33)) * -4265267296055464877L;
            return k3 ^ (k3 >>> 33);
        }

        private static long mixK1(long k1) {
            return Long.rotateLeft(k1 * f292C1, 31) * f293C2;
        }

        private static long mixK2(long k2) {
            return Long.rotateLeft(k2 * f293C2, 33) * f292C1;
        }
    }
}
