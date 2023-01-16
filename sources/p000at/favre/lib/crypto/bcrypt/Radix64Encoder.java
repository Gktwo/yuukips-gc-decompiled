package p000at.favre.lib.crypto.bcrypt;

/* renamed from: at.favre.lib.crypto.bcrypt.Radix64Encoder */
/* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/Radix64Encoder.class */
public interface Radix64Encoder {
    byte[] encode(byte[] bArr);

    byte[] decode(byte[] bArr);

    /* renamed from: at.favre.lib.crypto.bcrypt.Radix64Encoder$Default */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/Radix64Encoder$Default.class */
    public static class Default implements Radix64Encoder {
        private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -1, -1, -1, -2, -1, -1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, -1, -1, -1, -1, -1, -1, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};
        private static final byte[] MAP = {46, 47, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};

        @Override // p000at.favre.lib.crypto.bcrypt.Radix64Encoder
        public byte[] encode(byte[] in) {
            return encode(in, MAP);
        }

        @Override // p000at.favre.lib.crypto.bcrypt.Radix64Encoder
        public byte[] decode(byte[] in) {
            int limit = in.length;
            while (limit > 0 && ((c = in[limit - 1]) == 61 || c == 10 || c == 13 || c == 32 || c == 9)) {
                limit--;
            }
            byte[] out = new byte[(int) ((((long) limit) * 6) / 8)];
            int outCount = 0;
            int inCount = 0;
            int word = 0;
            for (int pos = 0; pos < limit; pos++) {
                byte c = in[pos];
                if (c == 46 || c == 47 || ((c >= 65 && c <= 122) || (c >= 48 && c <= 57))) {
                    word = (word << 6) | ((byte) DECODE_TABLE[c]);
                    inCount++;
                    if (inCount % 4 == 0) {
                        int outCount2 = outCount + 1;
                        out[outCount] = (byte) (word >> 16);
                        int outCount3 = outCount2 + 1;
                        out[outCount2] = (byte) (word >> 8);
                        outCount = outCount3 + 1;
                        out[outCount3] = (byte) word;
                    }
                } else if (!(c == 10 || c == 13 || c == 32 || c == 9)) {
                    throw new IllegalArgumentException("invalid character to decode: " + ((int) c));
                }
            }
            int lastWordChars = inCount % 4;
            if (lastWordChars == 1) {
                return new byte[0];
            }
            if (lastWordChars == 2) {
                outCount++;
                out[outCount] = (byte) ((word << 12) >> 16);
            } else if (lastWordChars == 3) {
                int word2 = word << 6;
                int outCount4 = outCount + 1;
                out[outCount] = (byte) (word2 >> 16);
                outCount = outCount4 + 1;
                out[outCount4] = (byte) (word2 >> 8);
            }
            if (outCount == out.length) {
                return out;
            }
            byte[] prefix = new byte[outCount];
            System.arraycopy(out, 0, prefix, 0, outCount);
            return prefix;
        }

        private static byte[] encode(byte[] in, byte[] map) {
            byte[] out = new byte[(4 * (in.length / 3)) + (in.length % 3 == 0 ? 0 : (in.length % 3) + 1)];
            int index = 0;
            int end = in.length - (in.length % 3);
            for (int i = 0; i < end; i += 3) {
                int index2 = index + 1;
                out[index] = map[(in[i] & 255) >> 2];
                int index3 = index2 + 1;
                out[index2] = map[((in[i] & 3) << 4) | ((in[i + 1] & 255) >> 4)];
                int index4 = index3 + 1;
                out[index3] = map[((in[i + 1] & 15) << 2) | ((in[i + 2] & 255) >> 6)];
                index = index4 + 1;
                out[index4] = map[in[i + 2] & 63];
            }
            switch (in.length % 3) {
                case 1:
                    out[index] = map[(in[end] & 255) >> 2];
                    out[index + 1] = map[(in[end] & 3) << 4];
                    break;
                case 2:
                    int index5 = index + 1;
                    out[index] = map[(in[end] & 255) >> 2];
                    out[index5] = map[((in[end] & 3) << 4) | ((in[end + 1] & 255) >> 4)];
                    out[index5 + 1] = map[(in[end + 1] & 15) << 2];
                    break;
            }
            return out;
        }
    }
}
