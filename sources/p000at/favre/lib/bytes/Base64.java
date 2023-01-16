package p000at.favre.lib.bytes;

import java.util.Arrays;

/* renamed from: at.favre.lib.bytes.Base64 */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/Base64.class */
final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    private Base64() {
    }

    /* access modifiers changed from: package-private */
    public static byte[] decode(CharSequence in) {
        int bits;
        int limit = in.length();
        while (limit > 0 && ((c = in.charAt(limit - 1)) == '=' || c == '\n' || c == '\r' || c == ' ' || c == '\t')) {
            limit--;
        }
        byte[] out = new byte[(int) ((((long) limit) * 6) / 8)];
        int outCount = 0;
        int inCount = 0;
        int word = 0;
        for (int pos = 0; pos < limit; pos++) {
            char c = in.charAt(pos);
            if (c >= 'A' && c <= 'Z') {
                bits = c - 'A';
            } else if (c >= 'a' && c <= 'z') {
                bits = c - 'G';
            } else if (c >= '0' && c <= '9') {
                bits = c + 4;
            } else if (c == '+' || c == '-') {
                bits = 62;
            } else if (c == '/' || c == '_') {
                bits = 63;
            } else {
                if (!(c == '\n' || c == '\r' || c == ' ' || c == '\t')) {
                    throw new IllegalArgumentException("invalid character to decode: " + c);
                }
            }
            word = (word << 6) | ((byte) bits);
            inCount++;
            if (inCount % 4 == 0) {
                int outCount2 = outCount + 1;
                out[outCount] = (byte) (word >> 16);
                int outCount3 = outCount2 + 1;
                out[outCount2] = (byte) (word >> 8);
                outCount = outCount3 + 1;
                out[outCount3] = (byte) word;
            }
        }
        int lastWordChars = inCount % 4;
        if (lastWordChars == 1) {
            return null;
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
        return outCount == out.length ? out : Arrays.copyOfRange(out, 0, outCount);
    }

    static byte[] encode(byte[] in) {
        return encode(in, false, true);
    }

    /* access modifiers changed from: package-private */
    public static byte[] encode(byte[] in, boolean urlSafe, boolean usePadding) {
        return encode(in, urlSafe ? URL_MAP : MAP, usePadding);
    }

    private static byte[] encode(byte[] in, byte[] map, boolean usePadding) {
        byte[] out = new byte[outLength(in.length, usePadding)];
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
                int index5 = index + 1;
                out[index] = map[(in[end] & 255) >> 2];
                int index6 = index5 + 1;
                out[index5] = map[(in[end] & 3) << 4];
                if (usePadding) {
                    out[index6] = 61;
                    out[index6 + 1] = 61;
                    break;
                }
                break;
            case 2:
                int index7 = index + 1;
                out[index] = map[(in[end] & 255) >> 2];
                int index8 = index7 + 1;
                out[index7] = map[((in[end] & 3) << 4) | ((in[end + 1] & 255) >> 4)];
                int index9 = index8 + 1;
                out[index8] = map[(in[end + 1] & 15) << 2];
                if (usePadding) {
                    out[index9] = 61;
                    break;
                }
                break;
        }
        return out;
    }

    private static int outLength(int srclen, boolean doPadding) {
        int len;
        if (doPadding) {
            len = 4 * ((srclen + 2) / 3);
        } else {
            int n = srclen % 3;
            len = (4 * (srclen / 3)) + (n == 0 ? 0 : n + 1);
        }
        return len;
    }
}
