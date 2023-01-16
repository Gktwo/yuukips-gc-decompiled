package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;

@Immutable
/* loaded from: grasscutter.jar:com/google/common/hash/SipHashFunction.class */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);

    /* renamed from: c */
    private final int f299c;

    /* renamed from: d */
    private final int f300d;

    /* renamed from: k0 */
    private final long f301k0;

    /* renamed from: k1 */
    private final long f302k1;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public SipHashFunction(int c, int d, long k0, long k1) {
        Preconditions.checkArgument(c > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", c);
        Preconditions.checkArgument(d > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", d);
        this.f299c = c;
        this.f300d = d;
        this.f301k0 = k0;
        this.f302k1 = k1;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f299c, this.f300d, this.f301k0, this.f302k1);
    }

    @Override // java.lang.Object
    public String toString() {
        return "Hashing.sipHash" + this.f299c + "" + this.f300d + "(" + this.f301k0 + ", " + this.f302k1 + ")";
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (!(object instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction other = (SipHashFunction) object;
        return this.f299c == other.f299c && this.f300d == other.f300d && this.f301k0 == other.f301k0 && this.f302k1 == other.f302k1;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (int) ((((long) ((getClass().hashCode() ^ this.f299c) ^ this.f300d)) ^ this.f301k0) ^ this.f302k1);
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/SipHashFunction$SipHasher.class */
    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: c */
        private final int f303c;

        /* renamed from: d */
        private final int f304d;

        /* renamed from: v0 */
        private long f305v0 = 8317987319222330741L;

        /* renamed from: v1 */
        private long f306v1 = 7237128888997146477L;

        /* renamed from: v2 */
        private long f307v2 = 7816392313619706465L;

        /* renamed from: v3 */
        private long f308v3 = 8387220255154660723L;

        /* renamed from: b */
        private long f309b = 0;
        private long finalM = 0;

        SipHasher(int c, int d, long k0, long k1) {
            super(8);
            this.f303c = c;
            this.f304d = d;
            this.f305v0 ^= k0;
            this.f306v1 ^= k1;
            this.f307v2 ^= k0;
            this.f308v3 ^= k1;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer buffer) {
            this.f309b += 8;
            processM(buffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer buffer) {
            this.f309b += (long) buffer.remaining();
            int i = 0;
            while (buffer.hasRemaining()) {
                this.finalM ^= (((long) buffer.get()) & 255) << i;
                i += 8;
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            this.finalM ^= this.f309b << 56;
            processM(this.finalM);
            this.f307v2 ^= 255;
            sipRound(this.f304d);
            return HashCode.fromLong(((this.f305v0 ^ this.f306v1) ^ this.f307v2) ^ this.f308v3);
        }

        private void processM(long m) {
            this.f308v3 ^= m;
            sipRound(this.f303c);
            this.f305v0 ^= m;
        }

        private void sipRound(int iterations) {
            for (int i = 0; i < iterations; i++) {
                this.f305v0 += this.f306v1;
                this.f307v2 += this.f308v3;
                this.f306v1 = Long.rotateLeft(this.f306v1, 13);
                this.f308v3 = Long.rotateLeft(this.f308v3, 16);
                this.f306v1 ^= this.f305v0;
                this.f308v3 ^= this.f307v2;
                this.f305v0 = Long.rotateLeft(this.f305v0, 32);
                this.f307v2 += this.f306v1;
                this.f305v0 += this.f308v3;
                this.f306v1 = Long.rotateLeft(this.f306v1, 17);
                this.f308v3 = Long.rotateLeft(this.f308v3, 21);
                this.f306v1 ^= this.f307v2;
                this.f308v3 ^= this.f305v0;
                this.f307v2 = Long.rotateLeft(this.f307v2, 32);
            }
        }
    }
}
