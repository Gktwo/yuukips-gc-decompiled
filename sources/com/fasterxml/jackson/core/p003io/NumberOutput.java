package com.fasterxml.jackson.core.p003io;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;

/* renamed from: com.fasterxml.jackson.core.io.NumberOutput */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/io/NumberOutput.class */
public final class NumberOutput {
    private static int MILLION = DurationKt.NANOS_IN_MILLIS;
    private static int BILLION = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
    private static long BILLION_L = 1000000000;
    private static long MIN_INT_AS_LONG = -2147483648L;
    private static long MAX_INT_AS_LONG = 2147483647L;
    static final String SMALLEST_INT = String.valueOf(Integer.MIN_VALUE);
    static final String SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    private static final int[] TRIPLET_TO_CHARS = new int[1000];
    private static final String[] sSmallIntStrs;
    private static final String[] sSmallIntStrs2;

    static {
        int fullIx = 0;
        for (int i1 = 0; i1 < 10; i1++) {
            for (int i2 = 0; i2 < 10; i2++) {
                for (int i3 = 0; i3 < 10; i3++) {
                    fullIx++;
                    TRIPLET_TO_CHARS[fullIx] = ((i1 + 48) << 16) | ((i2 + 48) << 8) | (i3 + 48);
                }
            }
        }
        sSmallIntStrs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", C3P0Substitutions.TRACE};
        sSmallIntStrs2 = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int outputInt(int v, char[] b, int off) {
        int off2;
        if (v < 0) {
            if (v == Integer.MIN_VALUE) {
                return _outputSmallestI(b, off);
            }
            off++;
            b[off] = '-';
            v = -v;
        }
        if (v < MILLION) {
            if (v >= 1000) {
                int thousands = v / 1000;
                return _full3(v - (thousands * 1000), b, _leading3(thousands, b, off));
            } else if (v >= 10) {
                return _leading3(v, b, off);
            } else {
                b[off] = (char) (48 + v);
                return off + 1;
            }
        } else if (v >= BILLION) {
            int v2 = v - BILLION;
            if (v2 >= BILLION) {
                v2 -= BILLION;
                off2 = off + 1;
                b[off] = '2';
            } else {
                off2 = off + 1;
                b[off] = '1';
            }
            return _outputFullBillion(v2, b, off2);
        } else {
            int newValue = v / 1000;
            int newValue2 = newValue / 1000;
            return _full3(v - (newValue * 1000), b, _full3(newValue - (newValue2 * 1000), b, _leading3(newValue2, b, off)));
        }
    }

    public static int outputInt(int v, byte[] b, int off) {
        int off2;
        int off3;
        if (v < 0) {
            if (v == Integer.MIN_VALUE) {
                return _outputSmallestI(b, off);
            }
            off++;
            b[off] = 45;
            v = -v;
        }
        if (v < MILLION) {
            if (v >= 1000) {
                int thousands = v / 1000;
                off3 = _full3(v - (thousands * 1000), b, _leading3(thousands, b, off));
            } else if (v < 10) {
                off3 = off + 1;
                b[off] = (byte) (48 + v);
            } else {
                off3 = _leading3(v, b, off);
            }
            return off3;
        } else if (v >= BILLION) {
            int v2 = v - BILLION;
            if (v2 >= BILLION) {
                v2 -= BILLION;
                off2 = off + 1;
                b[off] = 50;
            } else {
                off2 = off + 1;
                b[off] = 49;
            }
            return _outputFullBillion(v2, b, off2);
        } else {
            int newValue = v / 1000;
            int newValue2 = newValue / 1000;
            return _full3(v - (newValue * 1000), b, _full3(newValue - (newValue2 * 1000), b, _leading3(newValue2, b, off)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v35, types: [long] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int outputLong(long r7, char[] r9, int r10) {
        /*
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0032
            r0 = r7
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.MIN_INT_AS_LONG
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0016
            r0 = r7
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = outputInt(r0, r1, r2)
            return r0
        L_0x0016:
            r0 = r7
            r1 = -9223372036854775808
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0024
            r0 = r9
            r1 = r10
            int r0 = _outputSmallestL(r0, r1)
            return r0
        L_0x0024:
            r0 = r9
            r1 = r10
            int r10 = r10 + 1
            r2 = 45
            r0[r1] = r2
            r0 = r7
            long r0 = -r0
            r7 = r0
            goto L_0x0042
        L_0x0032:
            r0 = r7
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.MAX_INT_AS_LONG
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0042
            r0 = r7
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = outputInt(r0, r1, r2)
            return r0
        L_0x0042:
            r0 = r7
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            long r0 = r0 / r1
            r11 = r0
            r0 = r7
            r1 = r11
            long r2 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            long r1 = r1 * r2
            long r0 = r0 - r1
            r7 = r0
            r0 = r11
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0067
            r0 = r11
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = _outputUptoBillion(r0, r1, r2)
            r10 = r0
            goto L_0x008c
        L_0x0067:
            r0 = r11
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            long r0 = r0 / r1
            r13 = r0
            r0 = r11
            r1 = r13
            long r2 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            long r1 = r1 * r2
            long r0 = r0 - r1
            r11 = r0
            r0 = r13
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = _leading3(r0, r1, r2)
            r10 = r0
            r0 = r11
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = _outputFullBillion(r0, r1, r2)
            r10 = r0
        L_0x008c:
            r0 = r7
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = _outputFullBillion(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p003io.NumberOutput.outputLong(long, char[], int):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v35, types: [long] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int outputLong(long r7, byte[] r9, int r10) {
        /*
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0032
            r0 = r7
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.MIN_INT_AS_LONG
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0016
            r0 = r7
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = outputInt(r0, r1, r2)
            return r0
        L_0x0016:
            r0 = r7
            r1 = -9223372036854775808
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0024
            r0 = r9
            r1 = r10
            int r0 = _outputSmallestL(r0, r1)
            return r0
        L_0x0024:
            r0 = r9
            r1 = r10
            int r10 = r10 + 1
            r2 = 45
            r0[r1] = r2
            r0 = r7
            long r0 = -r0
            r7 = r0
            goto L_0x0042
        L_0x0032:
            r0 = r7
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.MAX_INT_AS_LONG
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0042
            r0 = r7
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = outputInt(r0, r1, r2)
            return r0
        L_0x0042:
            r0 = r7
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            long r0 = r0 / r1
            r11 = r0
            r0 = r7
            r1 = r11
            long r2 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            long r1 = r1 * r2
            long r0 = r0 - r1
            r7 = r0
            r0 = r11
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0067
            r0 = r11
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = _outputUptoBillion(r0, r1, r2)
            r10 = r0
            goto L_0x008c
        L_0x0067:
            r0 = r11
            long r1 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            long r0 = r0 / r1
            r13 = r0
            r0 = r11
            r1 = r13
            long r2 = com.fasterxml.jackson.core.p003io.NumberOutput.BILLION_L
            long r1 = r1 * r2
            long r0 = r0 - r1
            r11 = r0
            r0 = r13
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = _leading3(r0, r1, r2)
            r10 = r0
            r0 = r11
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = _outputFullBillion(r0, r1, r2)
            r10 = r0
        L_0x008c:
            r0 = r7
            int r0 = (int) r0
            r1 = r9
            r2 = r10
            int r0 = _outputFullBillion(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p003io.NumberOutput.outputLong(long, byte[], int):int");
    }

    public static String toString(int v) {
        if (v < sSmallIntStrs.length) {
            if (v >= 0) {
                return sSmallIntStrs[v];
            }
            int v2 = (-v) - 1;
            if (v2 < sSmallIntStrs2.length) {
                return sSmallIntStrs2[v2];
            }
        }
        return Integer.toString(v);
    }

    public static String toString(long v) {
        if (v > 2147483647L || v < -2147483648L) {
            return Long.toString(v);
        }
        return toString((int) v);
    }

    public static String toString(double v) {
        return Double.toString(v);
    }

    public static String toString(float v) {
        return Float.toString(v);
    }

    public static boolean notFinite(double value) {
        return Double.isNaN(value) || Double.isInfinite(value);
    }

    public static boolean notFinite(float value) {
        return Float.isNaN(value) || Float.isInfinite(value);
    }

    private static int _outputUptoBillion(int v, char[] b, int off) {
        if (v >= MILLION) {
            int thousands = v / 1000;
            int ones = v - (thousands * 1000);
            int millions = thousands / 1000;
            int thousands2 = thousands - (millions * 1000);
            int off2 = _leading3(millions, b, off);
            int enc = TRIPLET_TO_CHARS[thousands2];
            int off3 = off2 + 1;
            b[off2] = (char) (enc >> 16);
            int off4 = off3 + 1;
            b[off3] = (char) ((enc >> 8) & 127);
            int off5 = off4 + 1;
            b[off4] = (char) (enc & 127);
            int enc2 = TRIPLET_TO_CHARS[ones];
            int off6 = off5 + 1;
            b[off5] = (char) (enc2 >> 16);
            int off7 = off6 + 1;
            b[off6] = (char) ((enc2 >> 8) & 127);
            int off8 = off7 + 1;
            b[off7] = (char) (enc2 & 127);
            return off8;
        } else if (v < 1000) {
            return _leading3(v, b, off);
        } else {
            int thousands3 = v / 1000;
            return _outputUptoMillion(b, off, thousands3, v - (thousands3 * 1000));
        }
    }

    private static int _outputFullBillion(int v, char[] b, int off) {
        int thousands = v / 1000;
        int ones = v - (thousands * 1000);
        int millions = thousands / 1000;
        int enc = TRIPLET_TO_CHARS[millions];
        int off2 = off + 1;
        b[off] = (char) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (char) ((enc >> 8) & 127);
        int off4 = off3 + 1;
        b[off3] = (char) (enc & 127);
        int enc2 = TRIPLET_TO_CHARS[thousands - (millions * 1000)];
        int off5 = off4 + 1;
        b[off4] = (char) (enc2 >> 16);
        int off6 = off5 + 1;
        b[off5] = (char) ((enc2 >> 8) & 127);
        int off7 = off6 + 1;
        b[off6] = (char) (enc2 & 127);
        int enc3 = TRIPLET_TO_CHARS[ones];
        int off8 = off7 + 1;
        b[off7] = (char) (enc3 >> 16);
        int off9 = off8 + 1;
        b[off8] = (char) ((enc3 >> 8) & 127);
        int off10 = off9 + 1;
        b[off9] = (char) (enc3 & 127);
        return off10;
    }

    private static int _outputUptoBillion(int v, byte[] b, int off) {
        if (v >= MILLION) {
            int thousands = v / 1000;
            int ones = v - (thousands * 1000);
            int millions = thousands / 1000;
            int thousands2 = thousands - (millions * 1000);
            int off2 = _leading3(millions, b, off);
            int enc = TRIPLET_TO_CHARS[thousands2];
            int off3 = off2 + 1;
            b[off2] = (byte) (enc >> 16);
            int off4 = off3 + 1;
            b[off3] = (byte) (enc >> 8);
            int off5 = off4 + 1;
            b[off4] = (byte) enc;
            int enc2 = TRIPLET_TO_CHARS[ones];
            int off6 = off5 + 1;
            b[off5] = (byte) (enc2 >> 16);
            int off7 = off6 + 1;
            b[off6] = (byte) (enc2 >> 8);
            int off8 = off7 + 1;
            b[off7] = (byte) enc2;
            return off8;
        } else if (v < 1000) {
            return _leading3(v, b, off);
        } else {
            int thousands3 = v / 1000;
            return _outputUptoMillion(b, off, thousands3, v - (thousands3 * 1000));
        }
    }

    private static int _outputFullBillion(int v, byte[] b, int off) {
        int thousands = v / 1000;
        int ones = v - (thousands * 1000);
        int millions = thousands / 1000;
        int thousands2 = thousands - (millions * 1000);
        int enc = TRIPLET_TO_CHARS[millions];
        int off2 = off + 1;
        b[off] = (byte) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (byte) (enc >> 8);
        int off4 = off3 + 1;
        b[off3] = (byte) enc;
        int enc2 = TRIPLET_TO_CHARS[thousands2];
        int off5 = off4 + 1;
        b[off4] = (byte) (enc2 >> 16);
        int off6 = off5 + 1;
        b[off5] = (byte) (enc2 >> 8);
        int off7 = off6 + 1;
        b[off6] = (byte) enc2;
        int enc3 = TRIPLET_TO_CHARS[ones];
        int off8 = off7 + 1;
        b[off7] = (byte) (enc3 >> 16);
        int off9 = off8 + 1;
        b[off8] = (byte) (enc3 >> 8);
        int off10 = off9 + 1;
        b[off9] = (byte) enc3;
        return off10;
    }

    private static int _outputUptoMillion(char[] b, int off, int thousands, int ones) {
        int enc = TRIPLET_TO_CHARS[thousands];
        if (thousands > 9) {
            if (thousands > 99) {
                off++;
                b[off] = (char) (enc >> 16);
            }
            off++;
            b[off] = (char) ((enc >> 8) & 127);
        }
        int off2 = off + 1;
        b[off] = (char) (enc & 127);
        int enc2 = TRIPLET_TO_CHARS[ones];
        int off3 = off2 + 1;
        b[off2] = (char) (enc2 >> 16);
        int off4 = off3 + 1;
        b[off3] = (char) ((enc2 >> 8) & 127);
        int off5 = off4 + 1;
        b[off4] = (char) (enc2 & 127);
        return off5;
    }

    private static int _outputUptoMillion(byte[] b, int off, int thousands, int ones) {
        int enc = TRIPLET_TO_CHARS[thousands];
        if (thousands > 9) {
            if (thousands > 99) {
                off++;
                b[off] = (byte) (enc >> 16);
            }
            off++;
            b[off] = (byte) (enc >> 8);
        }
        int off2 = off + 1;
        b[off] = (byte) enc;
        int enc2 = TRIPLET_TO_CHARS[ones];
        int off3 = off2 + 1;
        b[off2] = (byte) (enc2 >> 16);
        int off4 = off3 + 1;
        b[off3] = (byte) (enc2 >> 8);
        int off5 = off4 + 1;
        b[off4] = (byte) enc2;
        return off5;
    }

    private static int _leading3(int t, char[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        if (t > 9) {
            if (t > 99) {
                off++;
                b[off] = (char) (enc >> 16);
            }
            off++;
            b[off] = (char) ((enc >> 8) & 127);
        }
        int off2 = off + 1;
        b[off] = (char) (enc & 127);
        return off2;
    }

    private static int _leading3(int t, byte[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        if (t > 9) {
            if (t > 99) {
                off++;
                b[off] = (byte) (enc >> 16);
            }
            off++;
            b[off] = (byte) (enc >> 8);
        }
        int off2 = off + 1;
        b[off] = (byte) enc;
        return off2;
    }

    private static int _full3(int t, char[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        int off2 = off + 1;
        b[off] = (char) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (char) ((enc >> 8) & 127);
        int off4 = off3 + 1;
        b[off3] = (char) (enc & 127);
        return off4;
    }

    private static int _full3(int t, byte[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        int off2 = off + 1;
        b[off] = (byte) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (byte) (enc >> 8);
        int off4 = off3 + 1;
        b[off3] = (byte) enc;
        return off4;
    }

    private static int _outputSmallestL(char[] b, int off) {
        int len = SMALLEST_LONG.length();
        SMALLEST_LONG.getChars(0, len, b, off);
        return off + len;
    }

    private static int _outputSmallestL(byte[] b, int off) {
        int len = SMALLEST_LONG.length();
        for (int i = 0; i < len; i++) {
            off++;
            b[off] = (byte) SMALLEST_LONG.charAt(i);
        }
        return off;
    }

    private static int _outputSmallestI(char[] b, int off) {
        int len = SMALLEST_INT.length();
        SMALLEST_INT.getChars(0, len, b, off);
        return off + len;
    }

    private static int _outputSmallestI(byte[] b, int off) {
        int len = SMALLEST_INT.length();
        for (int i = 0; i < len; i++) {
            off++;
            b[off] = (byte) SMALLEST_INT.charAt(i);
        }
        return off;
    }
}
