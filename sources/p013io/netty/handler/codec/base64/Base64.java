package p013io.netty.handler.codec.base64;

import java.nio.ByteOrder;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.util.ByteProcessor;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.codec.base64.Base64 */
/* loaded from: grasscutter.jar:io/netty/handler/codec/base64/Base64.class */
public final class Base64 {
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte EQUALS_SIGN = 61;
    private static final byte NEW_LINE = 10;
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte EQUALS_SIGN_ENC = -1;

    private static byte[] alphabet(Base64Dialect dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(dialect, "dialect")).alphabet;
    }

    /* access modifiers changed from: private */
    public static byte[] decodabet(Base64Dialect dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(dialect, "dialect")).decodabet;
    }

    private static boolean breakLines(Base64Dialect dialect) {
        return ((Base64Dialect) ObjectUtil.checkNotNull(dialect, "dialect")).breakLinesByDefault;
    }

    public static ByteBuf encode(ByteBuf src) {
        return encode(src, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf src, Base64Dialect dialect) {
        return encode(src, breakLines(dialect), dialect);
    }

    public static ByteBuf encode(ByteBuf src, boolean breakLines) {
        return encode(src, breakLines, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf src, boolean breakLines, Base64Dialect dialect) {
        ObjectUtil.checkNotNull(src, "src");
        ByteBuf dest = encode(src, src.readerIndex(), src.readableBytes(), breakLines, dialect);
        src.readerIndex(src.writerIndex());
        return dest;
    }

    public static ByteBuf encode(ByteBuf src, int off, int len) {
        return encode(src, off, len, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf src, int off, int len, Base64Dialect dialect) {
        return encode(src, off, len, breakLines(dialect), dialect);
    }

    public static ByteBuf encode(ByteBuf src, int off, int len, boolean breakLines) {
        return encode(src, off, len, breakLines, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf src, int off, int len, boolean breakLines, Base64Dialect dialect) {
        return encode(src, off, len, breakLines, dialect, src.alloc());
    }

    public static ByteBuf encode(ByteBuf src, int off, int len, boolean breakLines, Base64Dialect dialect, ByteBufAllocator allocator) {
        ObjectUtil.checkNotNull(src, "src");
        ObjectUtil.checkNotNull(dialect, "dialect");
        ByteBuf dest = allocator.buffer(encodedBufferSize(len, breakLines)).order(src.order());
        byte[] alphabet = alphabet(dialect);
        int d = 0;
        int e = 0;
        int len2 = len - 2;
        int lineLength = 0;
        while (d < len2) {
            encode3to4(src, d + off, 3, dest, e, alphabet);
            lineLength += 4;
            if (breakLines && lineLength == 76) {
                dest.setByte(e + 4, 10);
                e++;
                lineLength = 0;
            }
            d += 3;
            e += 4;
        }
        if (d < len) {
            encode3to4(src, d + off, len - d, dest, e, alphabet);
            e += 4;
        }
        if (e > 1 && dest.getByte(e - 1) == 10) {
            e--;
        }
        return dest.slice(0, e);
    }

    private static void encode3to4(ByteBuf src, int srcOffset, int numSigBytes, ByteBuf dest, int destOffset, byte[] alphabet) {
        int inBuff;
        int inBuff2;
        if (src.order() == ByteOrder.BIG_ENDIAN) {
            switch (numSigBytes) {
                case 1:
                    inBuff2 = toInt(src.getByte(srcOffset));
                    break;
                case 2:
                    inBuff2 = toIntBE(src.getShort(srcOffset));
                    break;
                default:
                    inBuff2 = numSigBytes <= 0 ? 0 : toIntBE(src.getMedium(srcOffset));
                    break;
            }
            encode3to4BigEndian(inBuff2, numSigBytes, dest, destOffset, alphabet);
            return;
        }
        switch (numSigBytes) {
            case 1:
                inBuff = toInt(src.getByte(srcOffset));
                break;
            case 2:
                inBuff = toIntLE(src.getShort(srcOffset));
                break;
            default:
                inBuff = numSigBytes <= 0 ? 0 : toIntLE(src.getMedium(srcOffset));
                break;
        }
        encode3to4LittleEndian(inBuff, numSigBytes, dest, destOffset, alphabet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int encodedBufferSize(int r7, boolean r8) {
        /*
            r0 = r7
            long r0 = (long) r0
            r1 = 2
            long r0 = r0 << r1
            r1 = 3
            long r0 = r0 / r1
            r9 = r0
            r0 = r9
            r1 = 3
            long r0 = r0 + r1
            r1 = -4
            long r0 = r0 & r1
            r11 = r0
            r0 = r8
            if (r0 == 0) goto L_0x0022
            r0 = r11
            r1 = r9
            r2 = 76
            long r1 = r1 / r2
            long r0 = r0 + r1
            r11 = r0
        L_0x0022:
            r0 = r11
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0031
            r0 = r11
            int r0 = (int) r0
            goto L_0x0033
        L_0x0031:
            r0 = 2147483647(0x7fffffff, float:NaN)
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.base64.Base64.encodedBufferSize(int, boolean):int");
    }

    private static int toInt(byte value) {
        return (value & 255) << 16;
    }

    private static int toIntBE(short value) {
        return ((value & 65280) << 8) | ((value & 255) << 8);
    }

    private static int toIntLE(short value) {
        return ((value & 255) << 16) | (value & 65280);
    }

    private static int toIntBE(int mediumValue) {
        return (mediumValue & 16711680) | (mediumValue & 65280) | (mediumValue & 255);
    }

    private static int toIntLE(int mediumValue) {
        return ((mediumValue & 255) << 16) | (mediumValue & 65280) | ((mediumValue & 16711680) >>> 16);
    }

    private static void encode3to4BigEndian(int inBuff, int numSigBytes, ByteBuf dest, int destOffset, byte[] alphabet) {
        switch (numSigBytes) {
            case 1:
                dest.setInt(destOffset, (alphabet[inBuff >>> 18] << 24) | (alphabet[(inBuff >>> 12) & 63] << 16) | 15616 | 61);
                return;
            case 2:
                dest.setInt(destOffset, (alphabet[inBuff >>> 18] << 24) | (alphabet[(inBuff >>> 12) & 63] << 16) | (alphabet[(inBuff >>> 6) & 63] << 8) | 61);
                return;
            case 3:
                dest.setInt(destOffset, (alphabet[inBuff >>> 18] << 24) | (alphabet[(inBuff >>> 12) & 63] << 16) | (alphabet[(inBuff >>> 6) & 63] << 8) | alphabet[inBuff & 63]);
                return;
            default:
                return;
        }
    }

    private static void encode3to4LittleEndian(int inBuff, int numSigBytes, ByteBuf dest, int destOffset, byte[] alphabet) {
        switch (numSigBytes) {
            case 1:
                dest.setInt(destOffset, alphabet[inBuff >>> 18] | (alphabet[(inBuff >>> 12) & 63] << 8) | 3997696 | 1023410176);
                return;
            case 2:
                dest.setInt(destOffset, alphabet[inBuff >>> 18] | (alphabet[(inBuff >>> 12) & 63] << 8) | (alphabet[(inBuff >>> 6) & 63] << 16) | 1023410176);
                return;
            case 3:
                dest.setInt(destOffset, alphabet[inBuff >>> 18] | (alphabet[(inBuff >>> 12) & 63] << 8) | (alphabet[(inBuff >>> 6) & 63] << 16) | (alphabet[inBuff & 63] << 24));
                return;
            default:
                return;
        }
    }

    public static ByteBuf decode(ByteBuf src) {
        return decode(src, Base64Dialect.STANDARD);
    }

    public static ByteBuf decode(ByteBuf src, Base64Dialect dialect) {
        ObjectUtil.checkNotNull(src, "src");
        ByteBuf dest = decode(src, src.readerIndex(), src.readableBytes(), dialect);
        src.readerIndex(src.writerIndex());
        return dest;
    }

    public static ByteBuf decode(ByteBuf src, int off, int len) {
        return decode(src, off, len, Base64Dialect.STANDARD);
    }

    public static ByteBuf decode(ByteBuf src, int off, int len, Base64Dialect dialect) {
        return decode(src, off, len, dialect, src.alloc());
    }

    public static ByteBuf decode(ByteBuf src, int off, int len, Base64Dialect dialect, ByteBufAllocator allocator) {
        ObjectUtil.checkNotNull(src, "src");
        ObjectUtil.checkNotNull(dialect, "dialect");
        return new Decoder().decode(src, off, len, allocator, dialect);
    }

    static int decodedBufferSize(int len) {
        return len - (len >>> 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.codec.base64.Base64$Decoder */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/base64/Base64$Decoder.class */
    public static final class Decoder implements ByteProcessor {

        /* renamed from: b4 */
        private final byte[] f996b4;
        private int b4Posn;
        private byte[] decodabet;
        private int outBuffPosn;
        private ByteBuf dest;

        private Decoder() {
            this.f996b4 = new byte[4];
        }

        ByteBuf decode(ByteBuf src, int off, int len, ByteBufAllocator allocator, Base64Dialect dialect) {
            this.dest = allocator.buffer(Base64.decodedBufferSize(len)).order(src.order());
            this.decodabet = Base64.decodabet(dialect);
            try {
                src.forEachByte(off, len, this);
                return this.dest.slice(0, this.outBuffPosn);
            } catch (Throwable cause) {
                this.dest.release();
                PlatformDependent.throwException(cause);
                return null;
            }
        }

        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            byte sbiDecode;
            if (value <= 0 || (sbiDecode = this.decodabet[value]) < Base64.WHITE_SPACE_ENC) {
                throw new IllegalArgumentException("invalid Base64 input character: " + ((int) ((short) (value & 255))) + " (decimal)");
            } else if (sbiDecode < -1) {
                return true;
            } else {
                byte[] bArr = this.f996b4;
                int i = this.b4Posn;
                this.b4Posn = i + 1;
                bArr[i] = value;
                if (this.b4Posn <= 3) {
                    return true;
                }
                this.outBuffPosn += decode4to3(this.f996b4, this.dest, this.outBuffPosn, this.decodabet);
                this.b4Posn = 0;
                return value != 61;
            }
        }

        private static int decode4to3(byte[] src, ByteBuf dest, int destOffset, byte[] decodabet) {
            int decodedValue;
            int decodedValue2;
            byte src0 = src[0];
            byte src1 = src[1];
            byte src2 = src[2];
            if (src2 == 61) {
                try {
                    dest.setByte(destOffset, ((decodabet[src0] & 255) << 2) | ((decodabet[src1] & 255) >>> 4));
                    return 1;
                } catch (IndexOutOfBoundsException e) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            } else {
                byte src3 = src[3];
                if (src3 == 61) {
                    byte b1 = decodabet[src1];
                    try {
                        if (dest.order() == ByteOrder.BIG_ENDIAN) {
                            decodedValue2 = ((((decodabet[src0] & 63) << 2) | ((b1 & 240) >> 4)) << 8) | ((b1 & 15) << 4) | ((decodabet[src2] & 252) >>> 2);
                        } else {
                            decodedValue2 = ((decodabet[src0] & 63) << 2) | ((b1 & 240) >> 4) | ((((b1 & 15) << 4) | ((decodabet[src2] & 252) >>> 2)) << 8);
                        }
                        dest.setShort(destOffset, decodedValue2);
                        return 2;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new IllegalArgumentException("not encoded in Base64");
                    }
                } else {
                    try {
                        if (dest.order() == ByteOrder.BIG_ENDIAN) {
                            decodedValue = ((decodabet[src0] & 63) << 18) | ((decodabet[src1] & 255) << 12) | ((decodabet[src2] & 255) << 6) | (decodabet[src3] & 255);
                        } else {
                            byte b12 = decodabet[src1];
                            byte b2 = decodabet[src2];
                            decodedValue = ((decodabet[src0] & 63) << 2) | ((b12 & 15) << 12) | ((b12 & 240) >>> 4) | ((b2 & 3) << 22) | ((b2 & 252) << 6) | ((decodabet[src3] & 255) << 16);
                        }
                        dest.setMedium(destOffset, decodedValue);
                        return 3;
                    } catch (IndexOutOfBoundsException e3) {
                        throw new IllegalArgumentException("not encoded in Base64");
                    }
                }
            }
        }
    }

    private Base64() {
    }
}
