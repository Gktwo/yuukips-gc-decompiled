package p014it.unimi.dsi.fastutil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import okhttp3.HttpUrl;
import p014it.unimi.dsi.fastutil.booleans.BooleanArrays;
import p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays;
import p014it.unimi.dsi.fastutil.bytes.ByteArrays;
import p014it.unimi.dsi.fastutil.bytes.ByteBigArrays;
import p014it.unimi.dsi.fastutil.chars.CharArrays;
import p014it.unimi.dsi.fastutil.chars.CharBigArrays;
import p014it.unimi.dsi.fastutil.doubles.DoubleArrays;
import p014it.unimi.dsi.fastutil.doubles.DoubleBigArrays;
import p014it.unimi.dsi.fastutil.floats.FloatArrays;
import p014it.unimi.dsi.fastutil.floats.FloatBigArrays;
import p014it.unimi.dsi.fastutil.ints.IntArrays;
import p014it.unimi.dsi.fastutil.ints.IntBigArrays;
import p014it.unimi.dsi.fastutil.longs.LongArrays;
import p014it.unimi.dsi.fastutil.longs.LongBigArrays;
import p014it.unimi.dsi.fastutil.longs.LongComparator;
import p014it.unimi.dsi.fastutil.objects.ObjectArrays;
import p014it.unimi.dsi.fastutil.objects.ObjectBigArrays;
import p014it.unimi.dsi.fastutil.shorts.ShortArrays;
import p014it.unimi.dsi.fastutil.shorts.ShortBigArrays;

/* renamed from: it.unimi.dsi.fastutil.BigArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/BigArrays.class */
public class BigArrays {
    public static final int SEGMENT_SHIFT = 27;
    public static final int SEGMENT_SIZE = 134217728;
    public static final int SEGMENT_MASK = 134217727;
    private static final int SMALL = 7;
    private static final int MEDIUM = 40;

    protected BigArrays() {
    }

    public static int segment(long index) {
        return (int) (index >>> 27);
    }

    public static int displacement(long index) {
        return (int) (index & 134217727);
    }

    public static long start(int segment) {
        return ((long) segment) << 27;
    }

    public static long nearestSegmentStart(long index, long min, long max) {
        long lower = start(segment(index));
        long upper = start(segment(index) + 1);
        if (upper < max) {
            if (lower >= min && index <= lower + ((upper - lower) >> 1)) {
                return lower;
            }
            return upper;
        } else if (lower < min) {
            return index;
        } else {
            return lower;
        }
    }

    public static long index(int segment, int displacement) {
        return start(segment) + ((long) displacement);
    }

    public static void ensureFromTo(long bigArrayLength, long from, long to) {
        if (from < 0) {
            throw new ArrayIndexOutOfBoundsException("Start index (" + from + ") is negative");
        } else if (from > to) {
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        } else if (to > bigArrayLength) {
            throw new ArrayIndexOutOfBoundsException("End index (" + to + ") is greater than big-array length (" + bigArrayLength + ")");
        }
    }

    public static void ensureOffsetLength(long bigArrayLength, long offset, long length) {
        if (offset < 0) {
            throw new ArrayIndexOutOfBoundsException("Offset (" + offset + ") is negative");
        } else if (length < 0) {
            throw new IllegalArgumentException("Length (" + length + ") is negative");
        } else if (offset + length > bigArrayLength) {
            throw new ArrayIndexOutOfBoundsException("Last index (" + (offset + length) + ") is greater than big-array length (" + bigArrayLength + ")");
        }
    }

    public static void ensureLength(long bigArrayLength) {
        if (bigArrayLength < 0) {
            throw new IllegalArgumentException("Negative big-array size: " + bigArrayLength);
        } else if (bigArrayLength >= 288230376017494016L) {
            throw new IllegalArgumentException("Big-array size too big: " + bigArrayLength);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long] */
    /* JADX WARN: Type inference failed for: r16v0, types: [long, it.unimi.dsi.fastutil.BigSwapper] */
    /* JADX WARN: Type inference failed for: r27v1, types: [long] */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3, types: [long] */
    /* JADX WARN: Type inference failed for: r1v16, types: [long] */
    /* JADX WARN: Type inference failed for: r27v5, types: [long] */
    /* JADX WARN: Type inference failed for: r1v18, types: [long] */
    /* JADX WARN: Type inference failed for: r0v37, types: [long] */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r0v43, types: [long] */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v14 */
    /* JADX WARN: Type inference failed for: r27v15 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void inPlaceMerge(long r9, long r11, long r13, p014it.unimi.dsi.fastutil.longs.LongComparator r15, p014it.unimi.dsi.fastutil.BigSwapper r16) {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.inPlaceMerge(long, long, long, it.unimi.dsi.fastutil.longs.LongComparator, it.unimi.dsi.fastutil.BigSwapper):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long lowerBound(long r7, long r9, long r11, p014it.unimi.dsi.fastutil.longs.LongComparator r13) {
        /*
            r0 = r9
            r1 = r7
            long r0 = r0 - r1
            r14 = r0
        L_0x0005:
            r0 = r14
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0040
            r0 = r14
            r1 = 2
            long r0 = r0 / r1
            r16 = r0
            r0 = r7
            r1 = r16
            long r0 = r0 + r1
            r18 = r0
            r0 = r13
            r1 = r18
            r2 = r11
            int r0 = r0.compare(r1, r2)
            if (r0 >= 0) goto L_0x0039
            r0 = r18
            r1 = 1
            long r0 = r0 + r1
            r7 = r0
            r0 = r14
            r1 = r16
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 - r1
            r14 = r0
            goto L_0x003d
        L_0x0039:
            r0 = r16
            r14 = r0
        L_0x003d:
            goto L_0x0005
        L_0x0040:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.lowerBound(long, long, long, it.unimi.dsi.fastutil.longs.LongComparator):long");
    }

    private static long med3(long a, long b, long c, LongComparator comp) {
        int ab = comp.compare(a, b);
        int ac = comp.compare(a, c);
        int bc = comp.compare(b, c);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r13v0, types: [it.unimi.dsi.fastutil.longs.LongComparator] */
    /* JADX WARN: Type inference failed for: r14v0, types: [it.unimi.dsi.fastutil.BigSwapper] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void mergeSort(long r9, long r11, p014it.unimi.dsi.fastutil.longs.LongComparator r13, p014it.unimi.dsi.fastutil.BigSwapper r14) {
        /*
            r0 = r11
            r1 = r9
            long r0 = r0 - r1
            r15 = r0
            r0 = r15
            r1 = 7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0053
            r0 = r9
            r17 = r0
        L_0x0011:
            r0 = r17
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0052
            r0 = r17
            r19 = r0
        L_0x001c:
            r0 = r19
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0049
            r0 = r13
            r1 = r19
            r2 = 1
            long r1 = r1 - r2
            r2 = r19
            int r0 = r0.compare(r1, r2)
            if (r0 <= 0) goto L_0x0049
            r0 = r14
            r1 = r19
            r2 = r19
            r3 = 1
            long r2 = r2 - r3
            r0.swap(r1, r2)
            r0 = r19
            r1 = 1
            long r0 = r0 - r1
            r19 = r0
            goto L_0x001c
        L_0x0049:
            r0 = r17
            r1 = 1
            long r0 = r0 + r1
            r17 = r0
            goto L_0x0011
        L_0x0052:
            return
        L_0x0053:
            r0 = r9
            r1 = r11
            long r0 = r0 + r1
            r1 = 1
            long r0 = r0 >>> r1
            r17 = r0
            r0 = r9
            r1 = r17
            r2 = r13
            r3 = r14
            mergeSort(r0, r1, r2, r3)
            r0 = r17
            r1 = r11
            r2 = r13
            r3 = r14
            mergeSort(r0, r1, r2, r3)
            r0 = r13
            r1 = r17
            r2 = 1
            long r1 = r1 - r2
            r2 = r17
            int r0 = r0.compare(r1, r2)
            if (r0 > 0) goto L_0x007f
            return
        L_0x007f:
            r0 = r9
            r1 = r17
            r2 = r11
            r3 = r13
            r4 = r14
            inPlaceMerge(r0, r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.mergeSort(long, long, it.unimi.dsi.fastutil.longs.LongComparator, it.unimi.dsi.fastutil.BigSwapper):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x00dd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x012f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0178 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x00dd */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0, types: [it.unimi.dsi.fastutil.longs.LongComparator] */
    /* JADX WARN: Type inference failed for: r16v0, types: [it.unimi.dsi.fastutil.BigSwapper] */
    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r25v0, types: [long] */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r25v1, types: [long] */
    /* JADX WARN: Type inference failed for: r27v2, types: [long] */
    /* JADX WARN: Type inference failed for: r25v2, types: [long] */
    /* JADX WARN: Type inference failed for: r23v2, types: [long] */
    /* JADX WARN: Type inference failed for: r25v3, types: [long] */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r0v49, types: [long] */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r27v4, types: [long] */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r0v61, types: [long] */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r0v75, types: [long] */
    /* JADX WARN: Type inference failed for: r0v79, types: [long] */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r0v87, types: [long] */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91, types: [long] */
    /* JADX WARN: Type inference failed for: r0v104 */
    /* JADX WARN: Type inference failed for: r0v105 */
    /* JADX WARN: Type inference failed for: r21v12 */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void quickSort(long r11, long r13, p014it.unimi.dsi.fastutil.longs.LongComparator r15, p014it.unimi.dsi.fastutil.BigSwapper r16) {
        /*
        // Method dump skipped, instructions count: 564
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.quickSort(long, long, it.unimi.dsi.fastutil.longs.LongComparator, it.unimi.dsi.fastutil.BigSwapper):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long upperBound(long r7, long r9, long r11, p014it.unimi.dsi.fastutil.longs.LongComparator r13) {
        /*
            r0 = r9
            r1 = r7
            long r0 = r0 - r1
            r14 = r0
        L_0x0005:
            r0 = r14
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0040
            r0 = r14
            r1 = 2
            long r0 = r0 / r1
            r16 = r0
            r0 = r7
            r1 = r16
            long r0 = r0 + r1
            r18 = r0
            r0 = r13
            r1 = r11
            r2 = r18
            int r0 = r0.compare(r1, r2)
            if (r0 >= 0) goto L_0x002f
            r0 = r16
            r14 = r0
            goto L_0x003d
        L_0x002f:
            r0 = r18
            r1 = 1
            long r0 = r0 + r1
            r7 = r0
            r0 = r14
            r1 = r16
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 - r1
            r14 = r0
        L_0x003d:
            goto L_0x0005
        L_0x0040:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.upperBound(long, long, long, it.unimi.dsi.fastutil.longs.LongComparator):long");
    }

    private static void vecSwap(BigSwapper swapper, long from, long l, long s) {
        int i = 0;
        while (((long) i) < s) {
            swapper.swap(from, l);
            i++;
            from++;
            l++;
        }
    }

    public static byte get(byte[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static void set(byte[][] array, long index, byte value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static void swap(byte[][] array, long first, long second) {
        byte t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[][] reverse(byte[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(byte[][]):byte[][]");
    }

    public static void add(byte[][] array, long index, byte incr) {
        byte[] bArr = array[segment(index)];
        int displacement = displacement(index);
        bArr[displacement] = (byte) (bArr[displacement] + incr);
    }

    public static void mul(byte[][] array, long index, byte factor) {
        byte[] bArr = array[segment(index)];
        int displacement = displacement(index);
        bArr[displacement] = (byte) (bArr[displacement] * factor);
    }

    public static void incr(byte[][] array, long index) {
        byte[] bArr = array[segment(index)];
        int displacement = displacement(index);
        bArr[displacement] = (byte) (bArr[displacement] + 1);
    }

    public static void decr(byte[][] array, long index) {
        byte[] bArr = array[segment(index)];
        int displacement = displacement(index);
        bArr[displacement] = (byte) (bArr[displacement] - 1);
    }

    public static long length(byte[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(byte[][] r6, long r7, byte[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(byte[][], long, byte[][], long, long):void");
    }

    public static void copyFromBig(byte[][] srcArray, long srcPos, byte[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToBig(byte[] r6, int r7, byte[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(byte[], int, byte[][], long, long):void");
    }

    public static byte[][] wrap(byte[] array) {
        if (array.length == 0) {
            return ByteBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            return new byte[][]{array};
        }
        byte[][] bigArray = ByteBigArrays.newBigArray((long) array.length);
        for (int i = 0; i < bigArray.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray[i], 0, bigArray[i].length);
        }
        return bigArray;
    }

    public static byte[][] ensureCapacity(byte[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    public static byte[][] forceCapacity(byte[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        byte[][] base = (byte[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = new byte[134217728];
            }
            base[baseLength - 1] = new byte[residual];
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = new byte[134217728];
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static byte[][] ensureCapacity(byte[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    public static byte[][] grow(byte[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    public static byte[][] grow(byte[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    public static byte[][] trim(byte[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        byte[][] base = (byte[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = ByteArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static byte[][] setLength(byte[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? trim(array, length) : ensureCapacity(array, length);
    }

    public static byte[][] copy(byte[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        byte[][] a = ByteBigArrays.newBigArray(length);
        copy(array, offset, a, 0L, length);
        return a;
    }

    public static byte[][] copy(byte[][] array) {
        byte[][] base = (byte[][]) array.clone();
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (byte[]) array[i].clone();
        }
    }

    public static void fill(byte[][] array, byte value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static void fill(byte[][] array, long from, long to, byte value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static boolean equals(byte[][] a1, byte[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            byte[] t = a1[i];
            byte[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (t[j] != u[j]) {
                        return false;
                    }
                }
            }
        }
    }

    public static String toString(byte[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf((int) get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static void ensureFromTo(byte[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static void ensureOffsetLength(byte[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static void ensureSameLength(byte[][] a, byte[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[][] shuffle(byte[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            byte r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            byte r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(byte[][], long, long, java.util.Random):byte[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[][] shuffle(byte[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            byte r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            byte r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(byte[][], java.util.Random):byte[][]");
    }

    public static int get(int[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static void set(int[][] array, long index, int value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static long length(AtomicIntegerArray[] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length());
    }

    public static int get(AtomicIntegerArray[] array, long index) {
        return array[segment(index)].get(displacement(index));
    }

    public static void set(AtomicIntegerArray[] array, long index, int value) {
        array[segment(index)].set(displacement(index), value);
    }

    public static int getAndSet(AtomicIntegerArray[] array, long index, int value) {
        return array[segment(index)].getAndSet(displacement(index), value);
    }

    public static int getAndAdd(AtomicIntegerArray[] array, long index, int value) {
        return array[segment(index)].getAndAdd(displacement(index), value);
    }

    public static int addAndGet(AtomicIntegerArray[] array, long index, int value) {
        return array[segment(index)].addAndGet(displacement(index), value);
    }

    public static int getAndIncrement(AtomicIntegerArray[] array, long index) {
        return array[segment(index)].getAndDecrement(displacement(index));
    }

    public static int incrementAndGet(AtomicIntegerArray[] array, long index) {
        return array[segment(index)].incrementAndGet(displacement(index));
    }

    public static int getAndDecrement(AtomicIntegerArray[] array, long index) {
        return array[segment(index)].getAndDecrement(displacement(index));
    }

    public static int decrementAndGet(AtomicIntegerArray[] array, long index) {
        return array[segment(index)].decrementAndGet(displacement(index));
    }

    public static boolean compareAndSet(AtomicIntegerArray[] array, long index, int expected, int value) {
        return array[segment(index)].compareAndSet(displacement(index), expected, value);
    }

    public static void swap(int[][] array, long first, long second) {
        int t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[][] reverse(int[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(int[][]):int[][]");
    }

    public static void add(int[][] array, long index, int incr) {
        int[] iArr = array[segment(index)];
        int displacement = displacement(index);
        iArr[displacement] = iArr[displacement] + incr;
    }

    public static void mul(int[][] array, long index, int factor) {
        int[] iArr = array[segment(index)];
        int displacement = displacement(index);
        iArr[displacement] = iArr[displacement] * factor;
    }

    public static void incr(int[][] array, long index) {
        int[] iArr = array[segment(index)];
        int displacement = displacement(index);
        iArr[displacement] = iArr[displacement] + 1;
    }

    public static void decr(int[][] array, long index) {
        int[] iArr = array[segment(index)];
        int displacement = displacement(index);
        iArr[displacement] = iArr[displacement] - 1;
    }

    public static long length(int[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(int[][] r6, long r7, int[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(int[][], long, int[][], long, long):void");
    }

    public static void copyFromBig(int[][] srcArray, long srcPos, int[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToBig(int[] r6, int r7, int[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(int[], int, int[][], long, long):void");
    }

    public static int[][] wrap(int[] array) {
        if (array.length == 0) {
            return IntBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            return new int[][]{array};
        }
        int[][] bigArray = IntBigArrays.newBigArray((long) array.length);
        for (int i = 0; i < bigArray.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray[i], 0, bigArray[i].length);
        }
        return bigArray;
    }

    public static int[][] ensureCapacity(int[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    public static int[][] forceCapacity(int[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        int[][] base = (int[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = new int[134217728];
            }
            base[baseLength - 1] = new int[residual];
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = new int[134217728];
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static int[][] ensureCapacity(int[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    public static int[][] grow(int[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    public static int[][] grow(int[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    public static int[][] trim(int[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        int[][] base = (int[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = IntArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static int[][] setLength(int[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? trim(array, length) : ensureCapacity(array, length);
    }

    public static int[][] copy(int[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        int[][] a = IntBigArrays.newBigArray(length);
        copy(array, offset, a, 0L, length);
        return a;
    }

    public static int[][] copy(int[][] array) {
        int[][] base = (int[][]) array.clone();
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (int[]) array[i].clone();
        }
    }

    public static void fill(int[][] array, int value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static void fill(int[][] array, long from, long to, int value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static boolean equals(int[][] a1, int[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            int[] t = a1[i];
            int[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (t[j] != u[j]) {
                        return false;
                    }
                }
            }
        }
    }

    public static String toString(int[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf(get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static void ensureFromTo(int[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static void ensureOffsetLength(int[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static void ensureSameLength(int[][] a, int[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[][] shuffle(int[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            int r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            int r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(int[][], long, long, java.util.Random):int[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[][] shuffle(int[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            int r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            int r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(int[][], java.util.Random):int[][]");
    }

    public static long get(long[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static void set(long[][] array, long index, long value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static long length(AtomicLongArray[] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length());
    }

    public static long get(AtomicLongArray[] array, long index) {
        return array[segment(index)].get(displacement(index));
    }

    public static void set(AtomicLongArray[] array, long index, long value) {
        array[segment(index)].set(displacement(index), value);
    }

    public static long getAndSet(AtomicLongArray[] array, long index, long value) {
        return array[segment(index)].getAndSet(displacement(index), value);
    }

    public static long getAndAdd(AtomicLongArray[] array, long index, long value) {
        return array[segment(index)].getAndAdd(displacement(index), value);
    }

    public static long addAndGet(AtomicLongArray[] array, long index, long value) {
        return array[segment(index)].addAndGet(displacement(index), value);
    }

    public static long getAndIncrement(AtomicLongArray[] array, long index) {
        return array[segment(index)].getAndDecrement(displacement(index));
    }

    public static long incrementAndGet(AtomicLongArray[] array, long index) {
        return array[segment(index)].incrementAndGet(displacement(index));
    }

    public static long getAndDecrement(AtomicLongArray[] array, long index) {
        return array[segment(index)].getAndDecrement(displacement(index));
    }

    public static long decrementAndGet(AtomicLongArray[] array, long index) {
        return array[segment(index)].decrementAndGet(displacement(index));
    }

    public static boolean compareAndSet(AtomicLongArray[] array, long index, long expected, long value) {
        return array[segment(index)].compareAndSet(displacement(index), expected, value);
    }

    public static void swap(long[][] array, long first, long second) {
        long t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long[][] reverse(long[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(long[][]):long[][]");
    }

    public static void add(long[][] array, long index, long incr) {
        long[] jArr = array[segment(index)];
        int displacement = displacement(index);
        jArr[displacement] = jArr[displacement] + incr;
    }

    public static void mul(long[][] array, long index, long factor) {
        long[] jArr = array[segment(index)];
        int displacement = displacement(index);
        jArr[displacement] = jArr[displacement] * factor;
    }

    public static void incr(long[][] array, long index) {
        long[] jArr = array[segment(index)];
        int displacement = displacement(index);
        jArr[displacement] = jArr[displacement] + 1;
    }

    public static void decr(long[][] array, long index) {
        long[] jArr = array[segment(index)];
        int displacement = displacement(index);
        jArr[displacement] = jArr[displacement] - 1;
    }

    public static long length(long[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(long[][] r6, long r7, long[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(long[][], long, long[][], long, long):void");
    }

    public static void copyFromBig(long[][] srcArray, long srcPos, long[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToBig(long[] r6, int r7, long[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(long[], int, long[][], long, long):void");
    }

    public static long[][] wrap(long[] array) {
        if (array.length == 0) {
            return LongBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            return new long[][]{array};
        }
        long[][] bigArray = LongBigArrays.newBigArray((long) array.length);
        for (int i = 0; i < bigArray.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray[i], 0, bigArray[i].length);
        }
        return bigArray;
    }

    public static long[][] ensureCapacity(long[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    public static long[][] forceCapacity(long[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        long[][] base = (long[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = new long[134217728];
            }
            base[baseLength - 1] = new long[residual];
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = new long[134217728];
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static long[][] ensureCapacity(long[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    public static long[][] grow(long[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    public static long[][] grow(long[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    public static long[][] trim(long[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        long[][] base = (long[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = LongArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static long[][] setLength(long[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? trim(array, length) : ensureCapacity(array, length);
    }

    public static long[][] copy(long[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        long[][] a = LongBigArrays.newBigArray(length);
        copy(array, offset, a, 0L, length);
        return a;
    }

    public static long[][] copy(long[][] array) {
        long[][] base = (long[][]) array.clone();
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (long[]) array[i].clone();
        }
    }

    public static void fill(long[][] array, long value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static void fill(long[][] array, long from, long to, long value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static boolean equals(long[][] a1, long[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            long[] t = a1[i];
            long[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (t[j] != u[j]) {
                        return false;
                    }
                }
            }
        }
    }

    public static String toString(long[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf(get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static void ensureFromTo(long[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static void ensureOffsetLength(long[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static void ensureSameLength(long[][] a, long[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long[][] shuffle(long[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            long r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            long r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(long[][], long, long, java.util.Random):long[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long[][] shuffle(long[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            long r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            long r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(long[][], java.util.Random):long[][]");
    }

    public static double get(double[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static void set(double[][] array, long index, double value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static void swap(double[][] array, long first, long second) {
        double t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double[][] reverse(double[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(double[][]):double[][]");
    }

    public static void add(double[][] array, long index, double incr) {
        double[] dArr = array[segment(index)];
        int displacement = displacement(index);
        dArr[displacement] = dArr[displacement] + incr;
    }

    public static void mul(double[][] array, long index, double factor) {
        double[] dArr = array[segment(index)];
        int displacement = displacement(index);
        dArr[displacement] = dArr[displacement] * factor;
    }

    public static void incr(double[][] array, long index) {
        double[] dArr = array[segment(index)];
        int displacement = displacement(index);
        dArr[displacement] = dArr[displacement] + 1.0d;
    }

    public static void decr(double[][] array, long index) {
        double[] dArr = array[segment(index)];
        int displacement = displacement(index);
        dArr[displacement] = dArr[displacement] - 1.0d;
    }

    public static long length(double[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(double[][] r6, long r7, double[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(double[][], long, double[][], long, long):void");
    }

    public static void copyFromBig(double[][] srcArray, long srcPos, double[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToBig(double[] r6, int r7, double[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(double[], int, double[][], long, long):void");
    }

    public static double[][] wrap(double[] array) {
        if (array.length == 0) {
            return DoubleBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            return new double[][]{array};
        }
        double[][] bigArray = DoubleBigArrays.newBigArray((long) array.length);
        for (int i = 0; i < bigArray.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray[i], 0, bigArray[i].length);
        }
        return bigArray;
    }

    public static double[][] ensureCapacity(double[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    public static double[][] forceCapacity(double[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        double[][] base = (double[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = new double[134217728];
            }
            base[baseLength - 1] = new double[residual];
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = new double[134217728];
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static double[][] ensureCapacity(double[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    public static double[][] grow(double[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    public static double[][] grow(double[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    public static double[][] trim(double[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        double[][] base = (double[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = DoubleArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static double[][] setLength(double[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? trim(array, length) : ensureCapacity(array, length);
    }

    public static double[][] copy(double[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        double[][] a = DoubleBigArrays.newBigArray(length);
        copy(array, offset, a, 0, length);
        return a;
    }

    public static double[][] copy(double[][] array) {
        double[][] base = (double[][]) array.clone();
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (double[]) array[i].clone();
        }
    }

    public static void fill(double[][] array, double value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static void fill(double[][] array, long from, long to, double value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static boolean equals(double[][] a1, double[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            double[] t = a1[i];
            double[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (Double.doubleToLongBits(t[j]) != Double.doubleToLongBits(u[j])) {
                        return false;
                    }
                }
            }
        }
    }

    public static String toString(double[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf(get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static void ensureFromTo(double[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static void ensureOffsetLength(double[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static void ensureSameLength(double[][] a, double[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double[][] shuffle(double[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            double r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            double r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(double[][], long, long, java.util.Random):double[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double[][] shuffle(double[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            double r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            double r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(double[][], java.util.Random):double[][]");
    }

    public static boolean get(boolean[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static void set(boolean[][] array, long index, boolean value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static void swap(boolean[][] array, long first, long second) {
        boolean t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean[][] reverse(boolean[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(boolean[][]):boolean[][]");
    }

    public static long length(boolean[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(boolean[][] r6, long r7, boolean[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(boolean[][], long, boolean[][], long, long):void");
    }

    public static void copyFromBig(boolean[][] srcArray, long srcPos, boolean[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToBig(boolean[] r6, int r7, boolean[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(boolean[], int, boolean[][], long, long):void");
    }

    public static boolean[][] wrap(boolean[] array) {
        if (array.length == 0) {
            return BooleanBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            return new boolean[][]{array};
        }
        boolean[][] bigArray = BooleanBigArrays.newBigArray((long) array.length);
        for (int i = 0; i < bigArray.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray[i], 0, bigArray[i].length);
        }
        return bigArray;
    }

    public static boolean[][] ensureCapacity(boolean[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    public static boolean[][] forceCapacity(boolean[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        boolean[][] base = (boolean[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = new boolean[134217728];
            }
            base[baseLength - 1] = new boolean[residual];
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = new boolean[134217728];
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static boolean[][] ensureCapacity(boolean[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    public static boolean[][] grow(boolean[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    public static boolean[][] grow(boolean[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    public static boolean[][] trim(boolean[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        boolean[][] base = (boolean[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = BooleanArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static boolean[][] setLength(boolean[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? trim(array, length) : ensureCapacity(array, length);
    }

    public static boolean[][] copy(boolean[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        boolean[][] a = BooleanBigArrays.newBigArray(length);
        copy(array, offset, a, 0, length);
        return a;
    }

    public static boolean[][] copy(boolean[][] array) {
        boolean[][] base = (boolean[][]) array.clone();
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (boolean[]) array[i].clone();
        }
    }

    public static void fill(boolean[][] array, boolean value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static void fill(boolean[][] array, long from, long to, boolean value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static boolean equals(boolean[][] a1, boolean[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            boolean[] t = a1[i];
            boolean[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (t[j] != u[j]) {
                        return false;
                    }
                }
            }
        }
    }

    public static String toString(boolean[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf(get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static void ensureFromTo(boolean[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static void ensureOffsetLength(boolean[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static void ensureSameLength(boolean[][] a, boolean[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean[][] shuffle(boolean[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            boolean r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            boolean r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(boolean[][], long, long, java.util.Random):boolean[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean[][] shuffle(boolean[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            boolean r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            boolean r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(boolean[][], java.util.Random):boolean[][]");
    }

    public static short get(short[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static void set(short[][] array, long index, short value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static void swap(short[][] array, long first, long second) {
        short t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static short[][] reverse(short[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(short[][]):short[][]");
    }

    public static void add(short[][] array, long index, short incr) {
        short[] sArr = array[segment(index)];
        int displacement = displacement(index);
        sArr[displacement] = (short) (sArr[displacement] + incr);
    }

    public static void mul(short[][] array, long index, short factor) {
        short[] sArr = array[segment(index)];
        int displacement = displacement(index);
        sArr[displacement] = (short) (sArr[displacement] * factor);
    }

    public static void incr(short[][] array, long index) {
        short[] sArr = array[segment(index)];
        int displacement = displacement(index);
        sArr[displacement] = (short) (sArr[displacement] + 1);
    }

    public static void decr(short[][] array, long index) {
        short[] sArr = array[segment(index)];
        int displacement = displacement(index);
        sArr[displacement] = (short) (sArr[displacement] - 1);
    }

    public static long length(short[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(short[][] r6, long r7, short[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(short[][], long, short[][], long, long):void");
    }

    public static void copyFromBig(short[][] srcArray, long srcPos, short[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToBig(short[] r6, int r7, short[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(short[], int, short[][], long, long):void");
    }

    public static short[][] wrap(short[] array) {
        if (array.length == 0) {
            return ShortBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            return new short[][]{array};
        }
        short[][] bigArray = ShortBigArrays.newBigArray((long) array.length);
        for (int i = 0; i < bigArray.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray[i], 0, bigArray[i].length);
        }
        return bigArray;
    }

    public static short[][] ensureCapacity(short[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    public static short[][] forceCapacity(short[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        short[][] base = (short[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = new short[134217728];
            }
            base[baseLength - 1] = new short[residual];
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = new short[134217728];
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static short[][] ensureCapacity(short[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    public static short[][] grow(short[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    public static short[][] grow(short[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    public static short[][] trim(short[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        short[][] base = (short[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = ShortArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static short[][] setLength(short[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? trim(array, length) : ensureCapacity(array, length);
    }

    public static short[][] copy(short[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        short[][] a = ShortBigArrays.newBigArray(length);
        copy(array, offset, a, 0L, length);
        return a;
    }

    public static short[][] copy(short[][] array) {
        short[][] base = (short[][]) array.clone();
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (short[]) array[i].clone();
        }
    }

    public static void fill(short[][] array, short value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static void fill(short[][] array, long from, long to, short value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static boolean equals(short[][] a1, short[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            short[] t = a1[i];
            short[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (t[j] != u[j]) {
                        return false;
                    }
                }
            }
        }
    }

    public static String toString(short[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf((int) get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static void ensureFromTo(short[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static void ensureOffsetLength(short[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static void ensureSameLength(short[][] a, short[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static short[][] shuffle(short[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            short r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            short r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(short[][], long, long, java.util.Random):short[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static short[][] shuffle(short[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            short r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            short r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(short[][], java.util.Random):short[][]");
    }

    public static char get(char[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static void set(char[][] array, long index, char value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static void swap(char[][] array, long first, long second) {
        char t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static char[][] reverse(char[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(char[][]):char[][]");
    }

    public static void add(char[][] array, long index, char incr) {
        char[] cArr = array[segment(index)];
        int displacement = displacement(index);
        cArr[displacement] = (char) (cArr[displacement] + incr);
    }

    public static void mul(char[][] array, long index, char factor) {
        char[] cArr = array[segment(index)];
        int displacement = displacement(index);
        cArr[displacement] = (char) (cArr[displacement] * factor);
    }

    public static void incr(char[][] array, long index) {
        char[] cArr = array[segment(index)];
        int displacement = displacement(index);
        cArr[displacement] = (char) (cArr[displacement] + 1);
    }

    public static void decr(char[][] array, long index) {
        char[] cArr = array[segment(index)];
        int displacement = displacement(index);
        cArr[displacement] = (char) (cArr[displacement] - 1);
    }

    public static long length(char[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(char[][] r6, long r7, char[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(char[][], long, char[][], long, long):void");
    }

    public static void copyFromBig(char[][] srcArray, long srcPos, char[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToBig(char[] r6, int r7, char[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(char[], int, char[][], long, long):void");
    }

    public static char[][] wrap(char[] array) {
        if (array.length == 0) {
            return CharBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            return new char[][]{array};
        }
        char[][] bigArray = CharBigArrays.newBigArray((long) array.length);
        for (int i = 0; i < bigArray.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray[i], 0, bigArray[i].length);
        }
        return bigArray;
    }

    public static char[][] ensureCapacity(char[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    public static char[][] forceCapacity(char[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        char[][] base = (char[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = new char[134217728];
            }
            base[baseLength - 1] = new char[residual];
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = new char[134217728];
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static char[][] ensureCapacity(char[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    public static char[][] grow(char[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    public static char[][] grow(char[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    public static char[][] trim(char[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        char[][] base = (char[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = CharArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static char[][] setLength(char[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? trim(array, length) : ensureCapacity(array, length);
    }

    public static char[][] copy(char[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        char[][] a = CharBigArrays.newBigArray(length);
        copy(array, offset, a, 0L, length);
        return a;
    }

    public static char[][] copy(char[][] array) {
        char[][] base = (char[][]) array.clone();
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (char[]) array[i].clone();
        }
    }

    public static void fill(char[][] array, char value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static void fill(char[][] array, long from, long to, char value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static boolean equals(char[][] a1, char[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            char[] t = a1[i];
            char[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (t[j] != u[j]) {
                        return false;
                    }
                }
            }
        }
    }

    public static String toString(char[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf(get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static void ensureFromTo(char[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static void ensureOffsetLength(char[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static void ensureSameLength(char[][] a, char[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static char[][] shuffle(char[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            char r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            char r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(char[][], long, long, java.util.Random):char[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static char[][] shuffle(char[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            char r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            char r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(char[][], java.util.Random):char[][]");
    }

    public static float get(float[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static void set(float[][] array, long index, float value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static void swap(float[][] array, long first, long second) {
        float t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float[][] reverse(float[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(float[][]):float[][]");
    }

    public static void add(float[][] array, long index, float incr) {
        float[] fArr = array[segment(index)];
        int displacement = displacement(index);
        fArr[displacement] = fArr[displacement] + incr;
    }

    public static void mul(float[][] array, long index, float factor) {
        float[] fArr = array[segment(index)];
        int displacement = displacement(index);
        fArr[displacement] = fArr[displacement] * factor;
    }

    public static void incr(float[][] array, long index) {
        float[] fArr = array[segment(index)];
        int displacement = displacement(index);
        fArr[displacement] = fArr[displacement] + 1.0f;
    }

    public static void decr(float[][] array, long index) {
        float[] fArr = array[segment(index)];
        int displacement = displacement(index);
        fArr[displacement] = fArr[displacement] - 1.0f;
    }

    public static long length(float[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(float[][] r6, long r7, float[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(float[][], long, float[][], long, long):void");
    }

    public static void copyFromBig(float[][] srcArray, long srcPos, float[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToBig(float[] r6, int r7, float[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(float[], int, float[][], long, long):void");
    }

    public static float[][] wrap(float[] array) {
        if (array.length == 0) {
            return FloatBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            return new float[][]{array};
        }
        float[][] bigArray = FloatBigArrays.newBigArray((long) array.length);
        for (int i = 0; i < bigArray.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray[i], 0, bigArray[i].length);
        }
        return bigArray;
    }

    public static float[][] ensureCapacity(float[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    public static float[][] forceCapacity(float[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        float[][] base = (float[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = new float[134217728];
            }
            base[baseLength - 1] = new float[residual];
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = new float[134217728];
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static float[][] ensureCapacity(float[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    public static float[][] grow(float[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    public static float[][] grow(float[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    public static float[][] trim(float[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        float[][] base = (float[][]) Arrays.copyOf(array, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = FloatArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static float[][] setLength(float[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? trim(array, length) : ensureCapacity(array, length);
    }

    public static float[][] copy(float[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        float[][] a = FloatBigArrays.newBigArray(length);
        copy(array, offset, a, 0L, length);
        return a;
    }

    public static float[][] copy(float[][] array) {
        float[][] base = (float[][]) array.clone();
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (float[]) array[i].clone();
        }
    }

    public static void fill(float[][] array, float value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static void fill(float[][] array, long from, long to, float value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static boolean equals(float[][] a1, float[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            float[] t = a1[i];
            float[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (Float.floatToIntBits(t[j]) != Float.floatToIntBits(u[j])) {
                        return false;
                    }
                }
            }
        }
    }

    public static String toString(float[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf(get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static void ensureFromTo(float[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static void ensureOffsetLength(float[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static void ensureSameLength(float[][] a, float[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float[][] shuffle(float[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            float r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            float r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(float[][], long, long, java.util.Random):float[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float[][] shuffle(float[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            float r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            float r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(float[][], java.util.Random):float[][]");
    }

    public static <K> K get(K[][] array, long index) {
        return array[segment(index)][displacement(index)];
    }

    public static <K> void set(K[][] array, long index, K value) {
        array[segment(index)][displacement(index)] = value;
    }

    public static <K> void swap(K[][] array, long first, long second) {
        K t = array[segment(first)][displacement(first)];
        array[segment(first)][displacement(first)] = array[segment(second)][displacement(second)];
        array[segment(second)][displacement(second)] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K> K[][] reverse(K[][] r8) {
        /*
            r0 = r8
            long r0 = length(r0)
            r9 = r0
            r0 = r9
            r1 = 2
            long r0 = r0 / r1
            r11 = r0
        L_0x000b:
            r0 = r11
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r11 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            r0 = r8
            r1 = r11
            r2 = r9
            r3 = r11
            long r2 = r2 - r3
            r3 = 1
            long r2 = r2 - r3
            swap(r0, r1, r2)
            goto L_0x000b
        L_0x0022:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.reverse(java.lang.Object[][]):java.lang.Object[][]");
    }

    public static <K> long length(K[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return start(length - 1) + ((long) array[length - 1].length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K> void copy(K[][] r6, long r7, K[][] r9, long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copy(java.lang.Object[][], long, java.lang.Object[][], long, long):void");
    }

    public static <K> void copyFromBig(K[][] srcArray, long srcPos, K[] destArray, int destPos, int length) {
        int srcSegment = segment(srcPos);
        int srcDispl = displacement(srcPos);
        while (length > 0) {
            int l = Math.min(srcArray[srcSegment].length - srcDispl, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(srcArray[srcSegment], srcDispl, destArray, destPos, l);
            int i = srcDispl + l;
            srcDispl = i;
            if (i == 134217728) {
                srcDispl = 0;
                srcSegment++;
            }
            destPos += l;
            length -= l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K> void copyToBig(K[] r6, int r7, K[][] r8, long r9, long r11) {
        /*
            r0 = r9
            int r0 = segment(r0)
            r13 = r0
            r0 = r9
            int r0 = displacement(r0)
            r14 = r0
        L_0x000c:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r0 = r8
            r1 = r13
            r0 = r0[r1]
            int r0 = r0.length
            r1 = r14
            int r0 = r0 - r1
            long r0 = (long) r0
            r1 = r11
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0031
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0031:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r13
            r2 = r2[r3]
            r3 = r14
            r4 = r15
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)
            r0 = r14
            r1 = r15
            int r0 = r0 + r1
            r1 = r0
            r14 = r1
            r1 = 134217728(0x8000000, float:3.85186E-34)
            if (r0 != r1) goto L_0x0051
            r0 = 0
            r14 = r0
            int r13 = r13 + 1
        L_0x0051:
            r0 = r7
            r1 = r15
            int r0 = r0 + r1
            r7 = r0
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x000c
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.copyToBig(java.lang.Object[], int, java.lang.Object[][], long, long):void");
    }

    public static <K> K[][] wrap(K[] array) {
        if (array.length == 0 && array.getClass() == Object[].class) {
            return (K[][]) ObjectBigArrays.EMPTY_BIG_ARRAY;
        }
        if (array.length <= 134217728) {
            K[][] bigArray = (K[][]) ((Object[][]) Array.newInstance(array.getClass(), 1));
            bigArray[0] = array;
            return bigArray;
        }
        K[][] bigArray2 = (K[][]) ObjectBigArrays.newBigArray(array.getClass(), (long) array.length);
        for (int i = 0; i < bigArray2.length; i++) {
            System.arraycopy(array, (int) start(i), bigArray2[i], 0, bigArray2[i].length);
        }
        return bigArray2;
    }

    public static <K> K[][] ensureCapacity(K[][] array, long length) {
        return (K[][]) ensureCapacity(array, length, length(array));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: K[][] */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K> K[][] forceCapacity(K[][] array, long length, long preserve) {
        ensureLength(length);
        int valid = array.length - ((array.length == 0 || (array.length > 0 && array[array.length - 1].length == 134217728)) ? 0 : 1);
        int baseLength = (int) ((length + 134217727) >>> 27);
        K[][] base = (K[][]) ((Object[][]) Arrays.copyOf(array, baseLength));
        Class<?> componentType = array.getClass().getComponentType();
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = valid; i < baseLength - 1; i++) {
                base[i] = (Object[]) Array.newInstance(componentType.getComponentType(), 134217728);
            }
            base[baseLength - 1] = (Object[]) Array.newInstance(componentType.getComponentType(), residual);
        } else {
            for (int i2 = valid; i2 < baseLength; i2++) {
                base[i2] = (Object[]) Array.newInstance(componentType.getComponentType(), 134217728);
            }
        }
        if (preserve - (((long) valid) * 134217728) > 0) {
            copy(array, ((long) valid) * 134217728, base, ((long) valid) * 134217728, preserve - (((long) valid) * 134217728));
        }
        return base;
    }

    public static <K> K[][] ensureCapacity(K[][] array, long length, long preserve) {
        return length > length(array) ? (K[][]) forceCapacity(array, length, preserve) : array;
    }

    public static <K> K[][] grow(K[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? (K[][]) grow(array, length, oldLength) : array;
    }

    public static <K> K[][] grow(K[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? (K[][]) ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: K[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K> K[][] trim(K[][] array, long length) {
        ensureLength(length);
        if (length >= length(array)) {
            return array;
        }
        int baseLength = (int) ((length + 134217727) >>> 27);
        K[][] base = (K[][]) ((Object[][]) Arrays.copyOf(array, baseLength));
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            base[baseLength - 1] = ObjectArrays.trim(base[baseLength - 1], residual);
        }
        return base;
    }

    public static <K> K[][] setLength(K[][] array, long length) {
        long oldLength = length(array);
        return length == oldLength ? array : length < oldLength ? (K[][]) trim(array, length) : (K[][]) ensureCapacity(array, length);
    }

    public static <K> K[][] copy(K[][] array, long offset, long length) {
        ensureOffsetLength(array, offset, length);
        K[][] a = (K[][]) ObjectBigArrays.newBigArray(array, length);
        copy(array, offset, a, 0, length);
        return a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: K[][] */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K> K[][] copy(K[][] array) {
        K[][] base = (K[][]) ((Object[][]) array.clone());
        int i = base.length;
        while (true) {
            i--;
            if (i == 0) {
                return base;
            }
            base[i] = (Object[]) array[i].clone();
        }
    }

    public static <K> void fill(K[][] array, K value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                Arrays.fill(array[i], value);
            } else {
                return;
            }
        }
    }

    public static <K> void fill(K[][] array, long from, long to, K value) {
        long length = length(array);
        ensureFromTo(length, from, to);
        if (length != 0) {
            int fromSegment = segment(from);
            int toSegment = segment(to);
            int fromDispl = displacement(from);
            int toDispl = displacement(to);
            if (fromSegment == toSegment) {
                Arrays.fill(array[fromSegment], fromDispl, toDispl, value);
                return;
            }
            if (toDispl != 0) {
                Arrays.fill(array[toSegment], 0, toDispl, value);
            }
            while (true) {
                toSegment--;
                if (toSegment > fromSegment) {
                    Arrays.fill(array[toSegment], value);
                } else {
                    Arrays.fill(array[fromSegment], fromDispl, 134217728, value);
                    return;
                }
            }
        }
    }

    public static <K> boolean equals(K[][] a1, K[][] a2) {
        if (length(a1) != length(a2)) {
            return false;
        }
        int i = a1.length;
        while (true) {
            i--;
            if (i == 0) {
                return true;
            }
            K[] t = a1[i];
            K[] u = a2[i];
            int j = t.length;
            while (true) {
                j--;
                if (j != 0) {
                    if (!Objects.equals(t[j], u[j])) {
                        return false;
                    }
                }
            }
        }
    }

    public static <K> String toString(K[][] a) {
        if (a == null) {
            return "null";
        }
        long last = length(a) - 1;
        if (last == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        long i = 0;
        while (true) {
            b.append(String.valueOf(get(a, i)));
            if (i == last) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static <K> void ensureFromTo(K[][] a, long from, long to) {
        ensureFromTo(length(a), from, to);
    }

    public static <K> void ensureOffsetLength(K[][] a, long offset, long length) {
        ensureOffsetLength(length(a), offset, length);
    }

    public static <K> void ensureSameLength(K[][] a, K[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [long] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K> K[][] shuffle(K[][] r9, long r10, long r12, java.util.Random r14) {
        /*
            r0 = r12
            r1 = r10
            long r0 = r0 - r1
            r15 = r0
        L_0x0005:
            r0 = r15
            r1 = r0; r1 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r15 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0048
            r0 = r14
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r15
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r17 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            java.lang.Object r0 = get(r0, r1)
            r19 = r0
            r0 = r9
            r1 = r10
            r2 = r15
            long r1 = r1 + r2
            r2 = r9
            r3 = r10
            r4 = r17
            long r3 = r3 + r4
            java.lang.Object r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r9
            r1 = r10
            r2 = r17
            long r1 = r1 + r2
            r2 = r19
            set(r0, r1, r2)
            goto L_0x0005
        L_0x0048:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(java.lang.Object[][], long, long, java.util.Random):java.lang.Object[][]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K> K[][] shuffle(K[][] r7, java.util.Random r8) {
        /*
            r0 = r7
            long r0 = length(r0)
            r9 = r0
        L_0x0005:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003a
            r0 = r8
            long r0 = r0.nextLong()
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = r0 & r1
            r1 = r9
            r2 = 1
            long r1 = r1 + r2
            long r0 = r0 % r1
            r11 = r0
            r0 = r7
            r1 = r9
            java.lang.Object r0 = get(r0, r1)
            r13 = r0
            r0 = r7
            r1 = r9
            r2 = r7
            r3 = r11
            java.lang.Object r2 = get(r2, r3)
            set(r0, r1, r2)
            r0 = r7
            r1 = r11
            r2 = r13
            set(r0, r1, r2)
            goto L_0x0005
        L_0x003a:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.shuffle(java.lang.Object[][], java.util.Random):java.lang.Object[][]");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x0080 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0102 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r9) {
        /*
        // Method dump skipped, instructions count: 379
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.BigArrays.main(java.lang.String[]):void");
    }
}
