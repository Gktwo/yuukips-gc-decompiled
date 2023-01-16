package p000at.favre.lib.bytes;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Objects;
import p000at.favre.lib.bytes.BinaryToTextEncoding;

/* renamed from: at.favre.lib.bytes.BaseEncoding */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/BaseEncoding.class */
final class BaseEncoding implements BinaryToTextEncoding.EncoderDecoder {
    private static final char ASCII_MAX = 127;
    static final Alphabet BASE32_RFC4848 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".toCharArray());
    static final char BASE32_RFC4848_PADDING = '=';
    private final Alphabet alphabet;
    private final Character paddingChar;

    public BaseEncoding(Alphabet alphabet, Character paddingChar) {
        this.alphabet = (Alphabet) Objects.requireNonNull(alphabet);
        this.paddingChar = paddingChar;
    }

    private int maxEncodedSize(int bytes) {
        return this.alphabet.charsPerChunk * divide(bytes, this.alphabet.bytesPerChunk);
    }

    @Override // p000at.favre.lib.bytes.BinaryToTextEncoding.Encoder
    public String encode(byte[] array, ByteOrder byteOrder) {
        return encode(array, 0, array.length);
    }

    private String encode(byte[] bytes, int off, int len) {
        StringBuilder result = new StringBuilder(maxEncodedSize(len));
        try {
            encodeTo(result, bytes, off, len);
            return result.toString();
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }

    private void encodeTo(Appendable target, byte[] bytes, int off, int len) throws IOException {
        Objects.requireNonNull(target);
        int i = 0;
        while (i < len) {
            encodeChunkTo(target, bytes, off + i, Math.min(this.alphabet.bytesPerChunk, len - i));
            i += this.alphabet.bytesPerChunk;
        }
    }

    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    private void encodeChunkTo(Appendable target, byte[] bytes, int off, int len) throws IOException {
        Objects.requireNonNull(target);
        int i = 0;
        for (int i2 = 0; i2 < len; i2++) {
            i = (i | ((long) (bytes[off + i2] & 255))) << 8;
        }
        int bitOffset = ((len + 1) * 8) - this.alphabet.bitsPerChar;
        int bitsProcessed = 0;
        while (bitsProcessed < len * 8) {
            target.append(this.alphabet.encode(((int) (i >>> (bitOffset - bitsProcessed))) & this.alphabet.mask));
            bitsProcessed += this.alphabet.bitsPerChar;
        }
        if (this.paddingChar != null) {
            while (bitsProcessed < this.alphabet.bytesPerChunk * 8) {
                target.append(this.paddingChar.charValue());
                bitsProcessed += this.alphabet.bitsPerChar;
            }
        }
    }

    private int maxDecodedSize(int chars) {
        return (int) (((((long) this.alphabet.bitsPerChar) * ((long) chars)) + 7) / 8);
    }

    private String trimTrailingPadding(CharSequence chars) {
        Objects.requireNonNull(chars);
        if (this.paddingChar == null) {
            return chars.toString();
        }
        int l = chars.length() - 1;
        while (l >= 0 && chars.charAt(l) == this.paddingChar.charValue()) {
            l--;
        }
        return chars.subSequence(0, l + 1).toString();
    }

    @Override // p000at.favre.lib.bytes.BinaryToTextEncoding.Decoder
    public byte[] decode(CharSequence encoded) {
        CharSequence encoded2 = trimTrailingPadding(encoded);
        byte[] tmp = new byte[maxDecodedSize(encoded2.length())];
        return extract(tmp, decodeTo(tmp, encoded2));
    }

    private static byte[] extract(byte[] result, int length) {
        if (length == result.length) {
            return result;
        }
        byte[] trunc = new byte[length];
        System.arraycopy(result, 0, trunc, 0, length);
        return trunc;
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [long] */
    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    private int decodeTo(byte[] target, CharSequence chars) {
        Objects.requireNonNull(target);
        CharSequence chars2 = trimTrailingPadding(chars);
        int bytesWritten = 0;
        int charIdx = 0;
        while (charIdx < chars2.length()) {
            int i = 0;
            int charsProcessed = 0;
            for (int i2 = 0; i2 < this.alphabet.charsPerChunk; i2++) {
                i <<= this.alphabet.bitsPerChar;
                if (charIdx + i2 < chars2.length()) {
                    charsProcessed++;
                    i |= (long) this.alphabet.decode(chars2.charAt(charIdx + charsProcessed));
                }
            }
            int minOffset = (this.alphabet.bytesPerChunk * 8) - (charsProcessed * this.alphabet.bitsPerChar);
            for (int offset = (this.alphabet.bytesPerChunk - 1) * 8; offset >= minOffset; offset -= 8) {
                bytesWritten++;
                target[bytesWritten] = (byte) ((int) ((i >>> offset) & 255));
            }
            charIdx += this.alphabet.charsPerChunk;
        }
        return bytesWritten;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: at.favre.lib.bytes.BaseEncoding$Alphabet */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BaseEncoding$Alphabet.class */
    public static final class Alphabet {
        private final char[] chars;
        final int mask;
        final int bitsPerChar;
        final int charsPerChunk;
        final int bytesPerChunk;
        private final byte[] decodabet;

        Alphabet(char[] chars) {
            this.chars = (char[]) Objects.requireNonNull(chars);
            this.bitsPerChar = BaseEncoding.log2(chars.length);
            int gcd = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
            this.charsPerChunk = 8 / gcd;
            this.bytesPerChunk = this.bitsPerChar / gcd;
            this.mask = chars.length - 1;
            byte[] decodabet = new byte[128];
            Arrays.fill(decodabet, (byte) -1);
            for (int i = 0; i < chars.length; i++) {
                decodabet[chars[i]] = (byte) i;
            }
            this.decodabet = decodabet;
        }

        char encode(int bits) {
            return this.chars[bits];
        }

        int decode(char ch) {
            return this.decodabet[ch];
        }
    }

    private static int divide(int p, int q) {
        int div = p / q;
        if (p - (q * div) == 0) {
            return div;
        }
        int signum = 1 | ((p ^ q) >> 31);
        return signum > 0 ? div + signum : div;
    }

    /* access modifiers changed from: private */
    public static int log2(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }
}
