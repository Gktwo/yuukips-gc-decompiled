package p000at.favre.lib.bytes;

import java.math.BigInteger;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/* renamed from: at.favre.lib.bytes.BinaryToTextEncoding */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/BinaryToTextEncoding.class */
public interface BinaryToTextEncoding {

    /* renamed from: at.favre.lib.bytes.BinaryToTextEncoding$Decoder */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BinaryToTextEncoding$Decoder.class */
    public interface Decoder {
        byte[] decode(CharSequence charSequence);
    }

    /* renamed from: at.favre.lib.bytes.BinaryToTextEncoding$Encoder */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BinaryToTextEncoding$Encoder.class */
    public interface Encoder {
        String encode(byte[] bArr, ByteOrder byteOrder);
    }

    /* renamed from: at.favre.lib.bytes.BinaryToTextEncoding$EncoderDecoder */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BinaryToTextEncoding$EncoderDecoder.class */
    public interface EncoderDecoder extends Encoder, Decoder {
    }

    /* renamed from: at.favre.lib.bytes.BinaryToTextEncoding$Hex */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BinaryToTextEncoding$Hex.class */
    public static class Hex implements EncoderDecoder {
        private static final char[] LOOKUP_TABLE_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        private static final char[] LOOKUP_TABLE_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        private final boolean upperCase;

        public Hex() {
            this(true);
        }

        public Hex(boolean upperCase) {
            this.upperCase = upperCase;
        }

        @Override // p000at.favre.lib.bytes.BinaryToTextEncoding.Encoder
        public String encode(byte[] byteArray, ByteOrder byteOrder) {
            char[] buffer = new char[byteArray.length * 2];
            char[] lookup = this.upperCase ? LOOKUP_TABLE_UPPER : LOOKUP_TABLE_LOWER;
            for (int i = 0; i < byteArray.length; i++) {
                int index = byteOrder == ByteOrder.BIG_ENDIAN ? i : (byteArray.length - i) - 1;
                buffer[i << 1] = lookup[(byteArray[index] >> 4) & 15];
                buffer[(i << 1) + 1] = lookup[byteArray[index] & 15];
            }
            return new String(buffer);
        }

        @Override // p000at.favre.lib.bytes.BinaryToTextEncoding.Decoder
        public byte[] decode(CharSequence hexString) {
            int start;
            int first4Bits;
            if (((CharSequence) Objects.requireNonNull(hexString)).length() > 2 && hexString.charAt(0) == '0' && hexString.charAt(1) == 'x') {
                start = 2;
            } else {
                start = 0;
            }
            int len = hexString.length();
            boolean isOddLength = len % 2 != 0;
            if (isOddLength) {
                start--;
            }
            byte[] data = new byte[(len - start) / 2];
            for (int i = start; i < len; i += 2) {
                if (i != start || !isOddLength) {
                    first4Bits = Character.digit(hexString.charAt(i), 16);
                } else {
                    first4Bits = 0;
                }
                int second4Bits = Character.digit(hexString.charAt(i + 1), 16);
                if (first4Bits != -1 && second4Bits != -1) {
                    data[(i - start) / 2] = (byte) ((first4Bits << 4) + second4Bits);
                } else if (i != start || !isOddLength) {
                    throw new IllegalArgumentException("'" + hexString.charAt(i) + hexString.charAt(i + 1) + "' at index " + i + " is not hex formatted");
                } else {
                    throw new IllegalArgumentException("'" + hexString.charAt(i + 1) + "' at index " + (i + 1) + " is not hex formatted");
                }
            }
            return data;
        }
    }

    /* renamed from: at.favre.lib.bytes.BinaryToTextEncoding$Base64Encoding */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BinaryToTextEncoding$Base64Encoding.class */
    public static class Base64Encoding implements EncoderDecoder {
        private final boolean urlSafe;
        private final boolean padding;

        /* access modifiers changed from: package-private */
        public Base64Encoding() {
            this(false, true);
        }

        /* access modifiers changed from: package-private */
        public Base64Encoding(boolean urlSafe, boolean padding) {
            this.urlSafe = urlSafe;
            this.padding = padding;
        }

        @Override // p000at.favre.lib.bytes.BinaryToTextEncoding.Encoder
        public String encode(byte[] array, ByteOrder byteOrder) {
            return new String(Base64.encode(byteOrder == ByteOrder.BIG_ENDIAN ? array : Bytes.from(array).reverse().array(), this.urlSafe, this.padding), StandardCharsets.US_ASCII);
        }

        @Override // p000at.favre.lib.bytes.BinaryToTextEncoding.Decoder
        public byte[] decode(CharSequence encoded) {
            return Base64.decode(encoded);
        }
    }

    /* renamed from: at.favre.lib.bytes.BinaryToTextEncoding$BaseRadixNumber */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BinaryToTextEncoding$BaseRadixNumber.class */
    public static class BaseRadixNumber implements EncoderDecoder {
        private final int radix;

        /* access modifiers changed from: package-private */
        public BaseRadixNumber(int radix) {
            if (radix < 2 || radix > 36) {
                throw new IllegalArgumentException("supported radix is between 2 and 36");
            }
            this.radix = radix;
        }

        @Override // p000at.favre.lib.bytes.BinaryToTextEncoding.Encoder
        public String encode(byte[] array, ByteOrder byteOrder) {
            return new BigInteger(1, byteOrder == ByteOrder.BIG_ENDIAN ? array : Bytes.from(array).reverse().array()).toString(this.radix);
        }

        @Override // p000at.favre.lib.bytes.BinaryToTextEncoding.Decoder
        public byte[] decode(CharSequence encoded) {
            byte[] array = new BigInteger(encoded.toString(), this.radix).toByteArray();
            if (array[0] == 0) {
                byte[] tmp = new byte[array.length - 1];
                System.arraycopy(array, 1, tmp, 0, tmp.length);
                array = tmp;
            }
            return array;
        }
    }
}
