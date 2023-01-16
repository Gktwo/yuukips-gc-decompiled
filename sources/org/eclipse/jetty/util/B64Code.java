package org.eclipse.jetty.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/B64Code.class */
public class B64Code {
    private static final char __pad = '=';
    private static final char[] __rfc1421alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] __rfc1421nibbles = new byte[256];
    private static final char[] __rfc4648urlAlphabet;
    private static final byte[] __rfc4648urlNibbles;

    static {
        for (int i = 0; i < 256; i++) {
            __rfc1421nibbles[i] = -1;
        }
        for (byte b = 0; b < 64; b = (byte) (b + 1)) {
            __rfc1421nibbles[(byte) __rfc1421alphabet[b]] = b;
        }
        __rfc1421nibbles[61] = 0;
        __rfc4648urlAlphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        __rfc4648urlNibbles = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            __rfc4648urlNibbles[i2] = -1;
        }
        for (byte b2 = 0; b2 < 64; b2 = (byte) (b2 + 1)) {
            __rfc4648urlNibbles[(byte) __rfc4648urlAlphabet[b2]] = b2;
        }
        __rfc4648urlNibbles[61] = 0;
    }

    private B64Code() {
    }

    public static String encode(String s) {
        return encode(s, (Charset) null);
    }

    public static String encode(String s, String charEncoding) {
        byte[] bytes;
        if (charEncoding == null) {
            bytes = s.getBytes(StandardCharsets.ISO_8859_1);
        } else {
            bytes = s.getBytes(Charset.forName(charEncoding));
        }
        return new String(encode(bytes));
    }

    public static String encode(String s, Charset charEncoding) {
        return new String(encode(s.getBytes(charEncoding == null ? StandardCharsets.ISO_8859_1 : charEncoding)));
    }

    public static char[] encode(byte[] b) {
        if (b == null) {
            return null;
        }
        int bLen = b.length;
        char[] c = new char[((bLen + 2) / 3) * 4];
        int ci = 0;
        int bi = 0;
        int stop = (bLen / 3) * 3;
        while (bi < stop) {
            int bi2 = bi + 1;
            byte b0 = b[bi];
            int bi3 = bi2 + 1;
            byte b1 = b[bi2];
            bi = bi3 + 1;
            byte b2 = b[bi3];
            int ci2 = ci + 1;
            c[ci] = __rfc1421alphabet[(b0 >>> 2) & 63];
            int ci3 = ci2 + 1;
            c[ci2] = __rfc1421alphabet[((b0 << 4) & 63) | ((b1 >>> 4) & 15)];
            int ci4 = ci3 + 1;
            c[ci3] = __rfc1421alphabet[((b1 << 2) & 63) | ((b2 >>> 6) & 3)];
            ci = ci4 + 1;
            c[ci4] = __rfc1421alphabet[b2 & 63];
        }
        if (bLen != bi) {
            switch (bLen % 3) {
                case 1:
                    int bi4 = bi + 1;
                    byte b02 = b[bi];
                    int ci5 = ci + 1;
                    c[ci] = __rfc1421alphabet[(b02 >>> 2) & 63];
                    int ci6 = ci5 + 1;
                    c[ci5] = __rfc1421alphabet[(b02 << 4) & 63];
                    int ci7 = ci6 + 1;
                    c[ci6] = '=';
                    int ci8 = ci7 + 1;
                    c[ci7] = '=';
                    break;
                case 2:
                    int bi5 = bi + 1;
                    byte b03 = b[bi];
                    int bi6 = bi5 + 1;
                    byte b12 = b[bi5];
                    int ci9 = ci + 1;
                    c[ci] = __rfc1421alphabet[(b03 >>> 2) & 63];
                    int ci10 = ci9 + 1;
                    c[ci9] = __rfc1421alphabet[((b03 << 4) & 63) | ((b12 >>> 4) & 15)];
                    int ci11 = ci10 + 1;
                    c[ci10] = __rfc1421alphabet[(b12 << 2) & 63];
                    int ci12 = ci11 + 1;
                    c[ci11] = '=';
                    break;
            }
        }
        return c;
    }

    public static char[] encode(byte[] b, boolean rfc2045) {
        if (b == null) {
            return null;
        }
        if (!rfc2045) {
            return encode(b);
        }
        int bLen = b.length;
        int cLen = ((bLen + 2) / 3) * 4;
        char[] c = new char[cLen + 2 + (2 * (cLen / 76))];
        int ci = 0;
        int bi = 0;
        int stop = (bLen / 3) * 3;
        int l = 0;
        while (bi < stop) {
            int bi2 = bi + 1;
            byte b0 = b[bi];
            int bi3 = bi2 + 1;
            byte b1 = b[bi2];
            bi = bi3 + 1;
            byte b2 = b[bi3];
            int ci2 = ci + 1;
            c[ci] = __rfc1421alphabet[(b0 >>> 2) & 63];
            int ci3 = ci2 + 1;
            c[ci2] = __rfc1421alphabet[((b0 << 4) & 63) | ((b1 >>> 4) & 15)];
            int ci4 = ci3 + 1;
            c[ci3] = __rfc1421alphabet[((b1 << 2) & 63) | ((b2 >>> 6) & 3)];
            ci = ci4 + 1;
            c[ci4] = __rfc1421alphabet[b2 & 63];
            l += 4;
            if (l % 76 == 0) {
                int ci5 = ci + 1;
                c[ci] = '\r';
                ci = ci5 + 1;
                c[ci5] = '\n';
            }
        }
        if (bLen != bi) {
            switch (bLen % 3) {
                case 1:
                    int bi4 = bi + 1;
                    byte b02 = b[bi];
                    int ci6 = ci + 1;
                    c[ci] = __rfc1421alphabet[(b02 >>> 2) & 63];
                    int ci7 = ci6 + 1;
                    c[ci6] = __rfc1421alphabet[(b02 << 4) & 63];
                    int ci8 = ci7 + 1;
                    c[ci7] = '=';
                    ci = ci8 + 1;
                    c[ci8] = '=';
                    break;
                case 2:
                    int bi5 = bi + 1;
                    byte b03 = b[bi];
                    int bi6 = bi5 + 1;
                    byte b12 = b[bi5];
                    int ci9 = ci + 1;
                    c[ci] = __rfc1421alphabet[(b03 >>> 2) & 63];
                    int ci10 = ci9 + 1;
                    c[ci9] = __rfc1421alphabet[((b03 << 4) & 63) | ((b12 >>> 4) & 15)];
                    int ci11 = ci10 + 1;
                    c[ci10] = __rfc1421alphabet[(b12 << 2) & 63];
                    ci = ci11 + 1;
                    c[ci11] = '=';
                    break;
            }
        }
        int ci12 = ci + 1;
        c[ci] = '\r';
        int ci13 = ci12 + 1;
        c[ci12] = '\n';
        return c;
    }

    public static String decode(String encoded, String charEncoding) {
        byte[] decoded = decode(encoded);
        if (charEncoding == null) {
            return new String(decoded);
        }
        return new String(decoded, Charset.forName(charEncoding));
    }

    public static String decode(String encoded, Charset charEncoding) {
        byte[] decoded = decode(encoded);
        if (charEncoding == null) {
            return new String(decoded);
        }
        return new String(decoded, charEncoding);
    }

    public static byte[] decode(char[] b) {
        if (b == null) {
            return null;
        }
        int bLen = b.length;
        if (bLen % 4 != 0) {
            throw new IllegalArgumentException("Input block size is not 4");
        }
        int li = bLen - 1;
        while (li >= 0 && b[li] == '=') {
            li--;
        }
        if (li < 0) {
            return new byte[0];
        }
        int rLen = ((li + 1) * 3) / 4;
        byte[] r = new byte[rLen];
        int ri = 0;
        int bi = 0;
        int stop = (rLen / 3) * 3;
        while (ri < stop) {
            try {
                int bi2 = bi + 1;
                byte b0 = __rfc1421nibbles[b[bi]];
                int bi3 = bi2 + 1;
                byte b1 = __rfc1421nibbles[b[bi2]];
                int bi4 = bi3 + 1;
                byte b2 = __rfc1421nibbles[b[bi3]];
                bi = bi4 + 1;
                byte b3 = __rfc1421nibbles[b[bi4]];
                if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0) {
                    throw new IllegalArgumentException("Not B64 encoded");
                }
                int ri2 = ri + 1;
                r[ri] = (byte) ((b0 << 2) | (b1 >>> 4));
                int ri3 = ri2 + 1;
                r[ri2] = (byte) ((b1 << 4) | (b2 >>> 2));
                ri = ri3 + 1;
                r[ri3] = (byte) ((b2 << 6) | b3);
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("char " + bi + " was not B64 encoded");
            }
        }
        if (rLen != ri) {
            switch (rLen % 3) {
                case 1:
                    int bi5 = bi + 1;
                    byte b02 = __rfc1421nibbles[b[bi]];
                    int bi6 = bi5 + 1;
                    byte b12 = __rfc1421nibbles[b[bi5]];
                    if (b02 >= 0 && b12 >= 0) {
                        int ri4 = ri + 1;
                        r[ri] = (byte) ((b02 << 2) | (b12 >>> 4));
                        break;
                    } else {
                        throw new IllegalArgumentException("Not B64 encoded");
                    }
                    break;
                case 2:
                    int bi7 = bi + 1;
                    byte b03 = __rfc1421nibbles[b[bi]];
                    int bi8 = bi7 + 1;
                    byte b13 = __rfc1421nibbles[b[bi7]];
                    int bi9 = bi8 + 1;
                    byte b22 = __rfc1421nibbles[b[bi8]];
                    if (b03 >= 0 && b13 >= 0 && b22 >= 0) {
                        int ri5 = ri + 1;
                        r[ri] = (byte) ((b03 << 2) | (b13 >>> 4));
                        int ri6 = ri5 + 1;
                        r[ri5] = (byte) ((b13 << 4) | (b22 >>> 2));
                        break;
                    } else {
                        throw new IllegalArgumentException("Not B64 encoded");
                    }
            }
        }
        return r;
    }

    public static byte[] decode(String encoded) {
        if (encoded == null) {
            return null;
        }
        ByteArrayOutputStream bout = new ByteArrayOutputStream((4 * encoded.length()) / 3);
        decode(encoded, bout);
        return bout.toByteArray();
    }

    public static void decode(String encoded, ByteArrayOutputStream bout) {
        if (encoded != null) {
            if (bout == null) {
                throw new IllegalArgumentException("No outputstream for decoded bytes");
            }
            int ci = 0;
            byte[] nibbles = new byte[4];
            int s = 0;
            while (ci < encoded.length()) {
                ci++;
                char c = encoded.charAt(ci);
                if (c != '=') {
                    if (!Character.isWhitespace(c)) {
                        if (__rfc1421nibbles[c] < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        s++;
                        nibbles[s] = __rfc1421nibbles[c];
                        switch (s) {
                            case 2:
                                bout.write((nibbles[0] << 2) | (nibbles[1] >>> 4));
                                continue;
                            case 3:
                                bout.write((nibbles[1] << 4) | (nibbles[2] >>> 2));
                                continue;
                            case 4:
                                bout.write((nibbles[2] << 6) | nibbles[3]);
                                s = 0;
                                continue;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static byte[] decodeRFC4648URL(String encoded) {
        if (encoded == null) {
            return null;
        }
        ByteArrayOutputStream bout = new ByteArrayOutputStream((4 * encoded.length()) / 3);
        decodeRFC4648URL(encoded, bout);
        return bout.toByteArray();
    }

    public static void decodeRFC4648URL(String encoded, ByteArrayOutputStream bout) {
        if (encoded != null) {
            if (bout == null) {
                throw new IllegalArgumentException("No outputstream for decoded bytes");
            }
            int ci = 0;
            byte[] nibbles = new byte[4];
            int s = 0;
            while (ci < encoded.length()) {
                ci++;
                char c = encoded.charAt(ci);
                if (c != '=') {
                    if (!Character.isWhitespace(c)) {
                        if (__rfc4648urlNibbles[c] < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        s++;
                        nibbles[s] = __rfc4648urlNibbles[c];
                        switch (s) {
                            case 2:
                                bout.write((nibbles[0] << 2) | (nibbles[1] >>> 4));
                                continue;
                            case 3:
                                bout.write((nibbles[1] << 4) | (nibbles[2] >>> 2));
                                continue;
                            case 4:
                                bout.write((nibbles[2] << 6) | nibbles[3]);
                                s = 0;
                                continue;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static void encode(int value, Appendable buf) throws IOException {
        buf.append(__rfc1421alphabet[63 & ((-67108864 & value) >> 26)]);
        buf.append(__rfc1421alphabet[63 & ((66060288 & value) >> 20)]);
        buf.append(__rfc1421alphabet[63 & ((1032192 & value) >> 14)]);
        buf.append(__rfc1421alphabet[63 & ((16128 & value) >> 8)]);
        buf.append(__rfc1421alphabet[63 & ((252 & value) >> 2)]);
        buf.append(__rfc1421alphabet[63 & ((3 & value) << 4)]);
    }

    public static void encode(long lvalue, Appendable buf) throws IOException {
        int value = (int) (-4 & (lvalue >> 32));
        buf.append(__rfc1421alphabet[63 & ((-67108864 & value) >> 26)]);
        buf.append(__rfc1421alphabet[63 & ((66060288 & value) >> 20)]);
        buf.append(__rfc1421alphabet[63 & ((1032192 & value) >> 14)]);
        buf.append(__rfc1421alphabet[63 & ((16128 & value) >> 8)]);
        buf.append(__rfc1421alphabet[63 & ((252 & value) >> 2)]);
        buf.append(__rfc1421alphabet[63 & (((3 & value) << 4) + (15 & ((int) (lvalue >> 28))))]);
        int value2 = 268435455 & ((int) lvalue);
        buf.append(__rfc1421alphabet[63 & ((264241152 & value2) >> 22)]);
        buf.append(__rfc1421alphabet[63 & ((4128768 & value2) >> 16)]);
        buf.append(__rfc1421alphabet[63 & ((64512 & value2) >> 10)]);
        buf.append(__rfc1421alphabet[63 & ((1008 & value2) >> 4)]);
        buf.append(__rfc1421alphabet[63 & ((15 & value2) << 2)]);
    }
}
