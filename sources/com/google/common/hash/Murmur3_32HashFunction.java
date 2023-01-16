package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* access modifiers changed from: package-private */
@Immutable
/* loaded from: grasscutter.jar:com/google/common/hash/Murmur3_32HashFunction.class */
public final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    private static final int CHUNK_SIZE = 4;

    /* renamed from: C1 */
    private static final int f296C1 = -862048943;

    /* renamed from: C2 */
    private static final int f297C2 = 461845907;
    private final int seed;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public Murmur3_32HashFunction(int seed) {
        this.seed = seed;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    @Override // java.lang.Object
    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        return (object instanceof Murmur3_32HashFunction) && this.seed == ((Murmur3_32HashFunction) object).seed;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getClass().hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int input) {
        return fmix(mixH1(this.seed, mixK1(input)), 4);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long input) {
        int high = (int) (input >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) input)), mixK1(high)), 8);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence input) {
        int h1 = this.seed;
        for (int i = 1; i < input.length(); i += 2) {
            h1 = mixH1(h1, mixK1(input.charAt(i - 1) | (input.charAt(i) << 16)));
        }
        if ((input.length() & 1) == 1) {
            h1 ^= mixK1(input.charAt(input.length() - 1));
        }
        return fmix(h1, 2 * input.length());
    }

    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    /* JADX WARN: Type inference failed for: r0v36, types: [long] */
    /* JADX WARN: Type inference failed for: r0v44, types: [long] */
    /* JADX WARN: Type inference failed for: r0v46, types: [long] */
    /* JADX WARN: Type inference failed for: r0v48, types: [long] */
    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence input, Charset charset) {
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(input.toString().getBytes(charset));
        }
        int utf16Length = input.length();
        int h1 = this.seed;
        int i = 0;
        int len = 0;
        while (i + 4 <= utf16Length) {
            char c0 = input.charAt(i);
            char c1 = input.charAt(i + 1);
            char c2 = input.charAt(i + 2);
            char c3 = input.charAt(i + 3);
            if (c0 >= 128 || c1 >= 128 || c2 >= 128 || c3 >= 128) {
                break;
            }
            h1 = mixH1(h1, mixK1(c0 | (c1 << '\b') | (c2 << 16) | (c3 << 24)));
            i += 4;
            len += 4;
        }
        char c = 0;
        int shift = 0;
        while (i < utf16Length) {
            char c4 = input.charAt(i);
            if (c4 < 128) {
                c |= ((long) c4) << shift;
                shift += 8;
                len++;
            } else if (c4 < 2048) {
                c |= charToTwoUtf8Bytes(c4) << shift;
                shift += 16;
                len += 2;
            } else if (c4 < 55296 || c4 > 57343) {
                c |= charToThreeUtf8Bytes(c4) << shift;
                shift += 24;
                len += 3;
            } else {
                int codePoint = Character.codePointAt(input, i);
                if (codePoint == c4) {
                    return hashBytes(input.toString().getBytes(charset));
                }
                i++;
                c |= codePointToFourUtf8Bytes(codePoint) << shift;
                len += 4;
            }
            if (shift >= 32) {
                h1 = mixH1(h1, mixK1((int) c));
                c >>>= ' ';
                shift -= 32;
            }
            i++;
        }
        return fmix(h1 ^ mixK1((int) c), len);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] input, int off, int len) {
        Preconditions.checkPositionIndexes(off, off + len, input.length);
        int h1 = this.seed;
        int i = 0;
        while (i + 4 <= len) {
            h1 = mixH1(h1, mixK1(getIntLittleEndian(input, off + i)));
            i += 4;
        }
        int k1 = 0;
        int shift = 0;
        while (i < len) {
            k1 ^= UnsignedBytes.toInt(input[off + i]) << shift;
            i++;
            shift += 8;
        }
        return fmix(h1 ^ mixK1(k1), len);
    }

    /* access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] input, int offset) {
        return Ints.fromBytes(input[offset + 3], input[offset + 2], input[offset + 1], input[offset]);
    }

    /* access modifiers changed from: private */
    public static int mixK1(int k1) {
        return Integer.rotateLeft(k1 * f296C1, 15) * f297C2;
    }

    /* access modifiers changed from: private */
    public static int mixH1(int h1, int k1) {
        return (Integer.rotateLeft(h1 ^ k1, 13) * 5) - 430675100;
    }

    /* access modifiers changed from: private */
    public static HashCode fmix(int h1, int length) {
        int h12 = h1 ^ length;
        int h13 = (h12 ^ (h12 >>> 16)) * -2048144789;
        int h14 = (h13 ^ (h13 >>> 13)) * -1028477387;
        return HashCode.fromInt(h14 ^ (h14 >>> 16));
    }

    @CanIgnoreReturnValue
    /* loaded from: grasscutter.jar:com/google/common/hash/Murmur3_32HashFunction$Murmur3_32Hasher.class */
    private static final class Murmur3_32Hasher extends AbstractHasher {

        /* renamed from: h1 */
        private int f298h1;
        private long buffer;
        private int shift;
        private int length = 0;
        private boolean isDone = false;

        Murmur3_32Hasher(int seed) {
            this.f298h1 = seed;
        }

        private void update(int nBytes, long update) {
            this.buffer |= (update & 4294967295L) << this.shift;
            this.shift += nBytes * 8;
            this.length += nBytes;
            if (this.shift >= 32) {
                this.f298h1 = Murmur3_32HashFunction.mixH1(this.f298h1, Murmur3_32HashFunction.mixK1((int) this.buffer));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte b) {
            update(1, (long) (b & 255));
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] bytes, int off, int len) {
            Preconditions.checkPositionIndexes(off, off + len, bytes.length);
            int i = 0;
            while (i + 4 <= len) {
                update(4, (long) Murmur3_32HashFunction.getIntLittleEndian(bytes, off + i));
                i += 4;
            }
            while (i < len) {
                putByte(bytes[off + i]);
                i++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer buffer) {
            ByteOrder bo = buffer.order();
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            while (buffer.remaining() >= 4) {
                putInt(buffer.getInt());
            }
            while (buffer.hasRemaining()) {
                putByte(buffer.get());
            }
            buffer.order(bo);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int i) {
            update(4, (long) i);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long l) {
            update(4, (long) ((int) l));
            update(4, l >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char c) {
            update(2, (long) c);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence input, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return putString(input, charset);
            }
            int utf16Length = input.length();
            int i = 0;
            while (i + 4 <= utf16Length) {
                char c0 = input.charAt(i);
                char c1 = input.charAt(i + 1);
                char c2 = input.charAt(i + 2);
                char c3 = input.charAt(i + 3);
                if (c0 >= 128 || c1 >= 128 || c2 >= 128 || c3 >= 128) {
                    break;
                }
                update(4, (long) (c0 | (c1 << '\b') | (c2 << 16) | (c3 << 24)));
                i += 4;
            }
            while (i < utf16Length) {
                char c = input.charAt(i);
                if (c < 128) {
                    update(1, (long) c);
                } else if (c < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(c));
                } else if (c < 55296 || c > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(c));
                } else {
                    int codePoint = Character.codePointAt(input, i);
                    if (codePoint == c) {
                        putBytes(input.subSequence(i, utf16Length).toString().getBytes(charset));
                        return this;
                    }
                    i++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePoint));
                }
                i++;
            }
            return this;
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            this.f298h1 ^= Murmur3_32HashFunction.mixK1((int) this.buffer);
            return Murmur3_32HashFunction.fmix(this.f298h1, this.length);
        }
    }

    /* access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int codePoint) {
        return ((240 | ((long) (codePoint >>> 18))) & 255) | ((128 | ((long) (63 & (codePoint >>> 12)))) << 8) | ((128 | ((long) (63 & (codePoint >>> 6)))) << 16) | ((128 | ((long) (63 & codePoint))) << 24);
    }

    /* access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c) {
        return (long) (((480 | (c >>> '\f')) & 255) | ((128 | (63 & (c >>> 6))) << 8) | ((128 | ('?' & c)) << 16));
    }

    /* access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c) {
        return (long) (((960 | (c >>> 6)) & 255) | ((128 | ('?' & c)) << 8));
    }
}
