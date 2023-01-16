package com.fasterxml.jackson.core.p003io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.util.Arrays;

/* renamed from: com.fasterxml.jackson.core.io.JsonStringEncoder */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/io/JsonStringEncoder.class */
public final class JsonStringEncoder {
    private static final int SURR1_FIRST = 55296;
    private static final int SURR1_LAST = 56319;
    private static final int SURR2_FIRST = 56320;
    private static final int SURR2_LAST = 57343;
    static final int MIN_CHAR_BUFFER_SIZE = 16;
    static final int MAX_CHAR_BUFFER_SIZE = 32000;
    static final int MIN_BYTE_BUFFER_SIZE = 24;
    static final int MAX_BYTE_BUFFER_SIZE = 32000;

    /* renamed from: HC */
    private static final char[] f218HC = CharTypes.copyHexChars();

    /* renamed from: HB */
    private static final byte[] f219HB = CharTypes.copyHexBytes();
    private static final JsonStringEncoder instance = new JsonStringEncoder();

    public static JsonStringEncoder getInstance() {
        return instance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (r15 != null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        r15 = _qbuf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        r12 = r12 + 1;
        r0 = r7.charAt(r12);
        r0 = r0[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
        if (r0 >= 0) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0097, code lost:
        r0 = _appendNumeric(r0, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a2, code lost:
        r0 = _appendNamed(r0, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b3, code lost:
        if ((r14 + r0) <= r9.length) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b6, code lost:
        r0 = r9.length - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bf, code lost:
        if (r0 <= 0) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c2, code lost:
        java.lang.System.arraycopy(r15, 0, r9, r14, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cf, code lost:
        if (r13 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d2, code lost:
        r13 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d8, code lost:
        r9 = r13.finishCurrentSegment();
        r0 = r0 - r0;
        java.lang.System.arraycopy(r15, r0, r9, 0, r0);
        r14 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f7, code lost:
        java.lang.System.arraycopy(r15, 0, r9, r14, r0);
        r14 = r14 + r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] quoteAsString(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p003io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008c, code lost:
        if (r15 != null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        r15 = _qbuf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r13 = r13 + 1;
        r0 = r7.charAt(r13);
        r0 = r0[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ab, code lost:
        if (r0 >= 0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ae, code lost:
        r0 = _appendNumeric(r0, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b9, code lost:
        r0 = _appendNamed(r0, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cb, code lost:
        if ((r14 + r0) <= r10.length) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ce, code lost:
        r0 = r10.length - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d8, code lost:
        if (r0 <= 0) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00db, code lost:
        java.lang.System.arraycopy(r15, 0, r10, r14, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e8, code lost:
        if (r8 != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00eb, code lost:
        r8 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f1, code lost:
        r10 = r8.finishCurrentSegment();
        r0 = r0 - r0;
        java.lang.System.arraycopy(r15, r0, r10, 0, r0);
        r14 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0111, code lost:
        java.lang.System.arraycopy(r15, 0, r10, r14, r0);
        r14 = r14 + r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] quoteAsString(java.lang.CharSequence r7) {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p003io.JsonStringEncoder.quoteAsString(java.lang.CharSequence):char[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        if (r12 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        r12 = _qbuf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r10 = r10 + 1;
        r0 = r6.charAt(r10);
        r0 = r0[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006f, code lost:
        if (r0 >= 0) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        r0 = _appendNumeric(r0, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        r0 = _appendNamed(r0, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        r7.append(r12, 0, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void quoteAsString(java.lang.CharSequence r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            int[] r0 = com.fasterxml.jackson.core.p003io.CharTypes.get7BitOutputEscapes()
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r6
            int r0 = r0.length()
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0016:
            r0 = r10
            r1 = r11
            if (r0 >= r1) goto L_0x0094
        L_0x001d:
            r0 = r6
            r1 = r10
            char r0 = r0.charAt(r1)
            r13 = r0
            r0 = r13
            r1 = r9
            if (r0 >= r1) goto L_0x0038
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0038
            goto L_0x004f
        L_0x0038:
            r0 = r7
            r1 = r13
            java.lang.StringBuilder r0 = r0.append(r1)
            int r10 = r10 + 1
            r0 = r10
            r1 = r11
            if (r0 < r1) goto L_0x004c
            goto L_0x0094
        L_0x004c:
            goto L_0x001d
        L_0x004f:
            r0 = r12
            if (r0 != 0) goto L_0x005a
            r0 = r5
            char[] r0 = r0._qbuf()
            r12 = r0
        L_0x005a:
            r0 = r6
            r1 = r10
            int r10 = r10 + 1
            char r0 = r0.charAt(r1)
            r13 = r0
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            r14 = r0
            r0 = r14
            if (r0 >= 0) goto L_0x007d
            r0 = r5
            r1 = r13
            r2 = r12
            int r0 = r0._appendNumeric(r1, r2)
            goto L_0x0085
        L_0x007d:
            r0 = r5
            r1 = r14
            r2 = r12
            int r0 = r0._appendNamed(r1, r2)
        L_0x0085:
            r15 = r0
            r0 = r7
            r1 = r12
            r2 = 0
            r3 = r15
            java.lang.StringBuilder r0 = r0.append(r1, r2, r3)
            goto L_0x0016
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p003io.JsonStringEncoder.quoteAsString(java.lang.CharSequence, java.lang.StringBuilder):void");
    }

    public byte[] quoteAsUTF8(String text) {
        int ch;
        int outputPtr;
        int inputPtr = 0;
        int inputEnd = text.length();
        int outputPtr2 = 0;
        byte[] outputBuffer = new byte[_initialByteBufSize(inputEnd)];
        ByteArrayBuilder bb = null;
        loop0: while (inputPtr < inputEnd) {
            int[] escCodes = CharTypes.get7BitOutputEscapes();
            while (true) {
                int ch2 = text.charAt(inputPtr);
                if (ch2 <= 127 && escCodes[ch2] == 0) {
                    if (outputPtr2 >= outputBuffer.length) {
                        if (bb == null) {
                            bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr2);
                        }
                        outputBuffer = bb.finishCurrentSegment();
                        outputPtr2 = 0;
                    }
                    outputPtr2++;
                    outputBuffer[outputPtr2] = (byte) ch2;
                    inputPtr++;
                    if (inputPtr >= inputEnd) {
                        break loop0;
                    }
                } else {
                    break;
                }
            }
            if (bb == null) {
                bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr2);
            }
            if (outputPtr2 >= outputBuffer.length) {
                outputBuffer = bb.finishCurrentSegment();
                outputPtr2 = 0;
            }
            inputPtr++;
            int ch3 = text.charAt(inputPtr);
            if (ch3 <= 127) {
                outputPtr2 = _appendByte(ch3, escCodes[ch3], bb, outputPtr2);
                outputBuffer = bb.getCurrentSegment();
            } else {
                if (ch3 <= 2047) {
                    outputPtr = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) (192 | (ch3 >> 6));
                    ch = 128 | (ch3 & 63);
                } else if (ch3 < 55296 || ch3 > 57343) {
                    int outputPtr3 = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) (224 | (ch3 >> 12));
                    if (outputPtr3 >= outputBuffer.length) {
                        outputBuffer = bb.finishCurrentSegment();
                        outputPtr3 = 0;
                    }
                    outputPtr = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = (byte) (128 | ((ch3 >> 6) & 63));
                    ch = 128 | (ch3 & 63);
                } else {
                    if (ch3 > 56319) {
                        _illegal(ch3);
                    }
                    if (inputPtr >= inputEnd) {
                        _illegal(ch3);
                    }
                    inputPtr++;
                    int ch4 = _convert(ch3, text.charAt(inputPtr));
                    if (ch4 > 1114111) {
                        _illegal(ch4);
                    }
                    int outputPtr4 = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) (240 | (ch4 >> 18));
                    if (outputPtr4 >= outputBuffer.length) {
                        outputBuffer = bb.finishCurrentSegment();
                        outputPtr4 = 0;
                    }
                    int outputPtr5 = outputPtr4 + 1;
                    outputBuffer[outputPtr4] = (byte) (128 | ((ch4 >> 12) & 63));
                    if (outputPtr5 >= outputBuffer.length) {
                        outputBuffer = bb.finishCurrentSegment();
                        outputPtr5 = 0;
                    }
                    outputPtr = outputPtr5 + 1;
                    outputBuffer[outputPtr5] = (byte) (128 | ((ch4 >> 6) & 63));
                    ch = 128 | (ch4 & 63);
                }
                if (outputPtr >= outputBuffer.length) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputPtr = 0;
                }
                outputPtr2 = outputPtr + 1;
                outputBuffer[outputPtr] = (byte) ch;
            }
        }
        if (bb == null) {
            return Arrays.copyOfRange(outputBuffer, 0, outputPtr2);
        }
        return bb.completeAndCoalesce(outputPtr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] encodeAsUTF8(String text) {
        int outputPtr;
        int inputPtr = 0;
        int inputEnd = text.length();
        int outputPtr2 = 0;
        byte[] outputBuffer = new byte[_initialByteBufSize(inputEnd)];
        int outputEnd = outputBuffer.length;
        ByteArrayBuilder bb = null;
        loop0: while (inputPtr < inputEnd) {
            inputPtr++;
            int c = text.charAt(inputPtr);
            while (c <= 127) {
                if (outputPtr2 >= outputEnd) {
                    if (bb == null) {
                        bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr2);
                    }
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr2 = 0;
                }
                outputPtr2++;
                outputBuffer[outputPtr2] = (byte) c;
                if (inputPtr >= inputEnd) {
                    break loop0;
                }
                inputPtr++;
                c = text.charAt(inputPtr);
            }
            if (bb == null) {
                bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr2);
            }
            if (outputPtr2 >= outputEnd) {
                outputBuffer = bb.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr2 = 0;
            }
            if (c < 2048) {
                outputPtr = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) (192 | (c >> 6));
            } else if (c < 55296 || c > 57343) {
                int outputPtr3 = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) (224 | (c >> 12));
                if (outputPtr3 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr3 = 0;
                }
                outputPtr = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) (128 | ((c >> 6) & 63));
            } else {
                if (c > 56319) {
                    _illegal(c);
                }
                if (inputPtr >= inputEnd) {
                    _illegal(c);
                }
                inputPtr++;
                c = _convert(c, text.charAt(inputPtr));
                if (c > 1114111) {
                    _illegal(c);
                }
                int outputPtr4 = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) (240 | (c >> 18));
                if (outputPtr4 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr4 = 0;
                }
                int outputPtr5 = outputPtr4 + 1;
                outputBuffer[outputPtr4] = (byte) (128 | ((c >> 12) & 63));
                if (outputPtr5 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr5 = 0;
                }
                outputPtr = outputPtr5 + 1;
                outputBuffer[outputPtr5] = (byte) (128 | ((c >> 6) & 63));
            }
            if (outputPtr >= outputEnd) {
                outputBuffer = bb.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr = 0;
            }
            outputPtr2 = outputPtr + 1;
            outputBuffer[outputPtr] = (byte) (128 | (c & 63));
        }
        if (bb == null) {
            return Arrays.copyOfRange(outputBuffer, 0, outputPtr2);
        }
        return bb.completeAndCoalesce(outputPtr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] encodeAsUTF8(CharSequence text) {
        int outputPtr;
        int inputPtr = 0;
        int inputEnd = text.length();
        int outputPtr2 = 0;
        byte[] outputBuffer = new byte[_initialByteBufSize(inputEnd)];
        int outputEnd = outputBuffer.length;
        ByteArrayBuilder bb = null;
        loop0: while (inputPtr < inputEnd) {
            inputPtr++;
            int c = text.charAt(inputPtr);
            while (c <= 127) {
                if (outputPtr2 >= outputEnd) {
                    if (bb == null) {
                        bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr2);
                    }
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr2 = 0;
                }
                outputPtr2++;
                outputBuffer[outputPtr2] = (byte) c;
                if (inputPtr >= inputEnd) {
                    break loop0;
                }
                inputPtr++;
                c = text.charAt(inputPtr);
            }
            if (bb == null) {
                bb = ByteArrayBuilder.fromInitial(outputBuffer, outputPtr2);
            }
            if (outputPtr2 >= outputEnd) {
                outputBuffer = bb.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr2 = 0;
            }
            if (c < 2048) {
                outputPtr = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) (192 | (c >> 6));
            } else if (c < 55296 || c > 57343) {
                int outputPtr3 = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) (224 | (c >> 12));
                if (outputPtr3 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr3 = 0;
                }
                outputPtr = outputPtr3 + 1;
                outputBuffer[outputPtr3] = (byte) (128 | ((c >> 6) & 63));
            } else {
                if (c > 56319) {
                    _illegal(c);
                }
                if (inputPtr >= inputEnd) {
                    _illegal(c);
                }
                inputPtr++;
                c = _convert(c, text.charAt(inputPtr));
                if (c > 1114111) {
                    _illegal(c);
                }
                int outputPtr4 = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) (240 | (c >> 18));
                if (outputPtr4 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr4 = 0;
                }
                int outputPtr5 = outputPtr4 + 1;
                outputBuffer[outputPtr4] = (byte) (128 | ((c >> 12) & 63));
                if (outputPtr5 >= outputEnd) {
                    outputBuffer = bb.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr5 = 0;
                }
                outputPtr = outputPtr5 + 1;
                outputBuffer[outputPtr5] = (byte) (128 | ((c >> 6) & 63));
            }
            if (outputPtr >= outputEnd) {
                outputBuffer = bb.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr = 0;
            }
            outputPtr2 = outputPtr + 1;
            outputBuffer[outputPtr] = (byte) (128 | (c & 63));
        }
        if (bb == null) {
            return Arrays.copyOfRange(outputBuffer, 0, outputPtr2);
        }
        return bb.completeAndCoalesce(outputPtr2);
    }

    private char[] _qbuf() {
        char[] qbuf = new char[6];
        qbuf[0] = '\\';
        qbuf[2] = '0';
        qbuf[3] = '0';
        return qbuf;
    }

    private int _appendNumeric(int value, char[] qbuf) {
        qbuf[1] = 'u';
        qbuf[4] = f218HC[value >> 4];
        qbuf[5] = f218HC[value & 15];
        return 6;
    }

    private int _appendNamed(int esc, char[] qbuf) {
        qbuf[1] = (char) esc;
        return 2;
    }

    private int _appendByte(int ch, int esc, ByteArrayBuilder bb, int ptr) {
        bb.setCurrentSegmentLength(ptr);
        bb.append(92);
        if (esc < 0) {
            bb.append(117);
            if (ch > 255) {
                int hi = ch >> 8;
                bb.append(f219HB[hi >> 4]);
                bb.append(f219HB[hi & 15]);
                ch &= 255;
            } else {
                bb.append(48);
                bb.append(48);
            }
            bb.append(f219HB[ch >> 4]);
            bb.append(f219HB[ch & 15]);
        } else {
            bb.append((byte) esc);
        }
        return bb.getCurrentSegmentLength();
    }

    private static int _convert(int p1, int p2) {
        if (p2 >= 56320 && p2 <= 57343) {
            return 65536 + ((p1 - 55296) << 10) + (p2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(p1) + ", second 0x" + Integer.toHexString(p2) + "; illegal combination");
    }

    private static void _illegal(int c) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(c));
    }

    static int _initialCharBufSize(int strLen) {
        return Math.min(Math.max(16, strLen + Math.min(6 + (strLen >> 3), 1000)), 32000);
    }

    static int _initialByteBufSize(int strLen) {
        return Math.min(Math.max(24, strLen + 6 + (strLen >> 1)), 32000);
    }
}
