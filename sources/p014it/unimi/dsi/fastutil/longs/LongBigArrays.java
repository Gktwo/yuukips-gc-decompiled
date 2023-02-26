package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicLongArray;
import p001ch.qos.logback.core.FileAppender;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.Hash;

/* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays.class */
public final class LongBigArrays {
    public static final long[][] EMPTY_BIG_ARRAY = new long[0];
    public static final long[][] DEFAULT_EMPTY_BIG_ARRAY = new long[0];
    public static final AtomicLongArray[] EMPTY_BIG_ATOMIC_ARRAY = new AtomicLongArray[0];
    public static final Hash.Strategy HASH_STRATEGY = new BigArrayHashStrategy();
    private static final int QUICKSORT_NO_REC = 7;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int MEDIUM = 40;
    private static final int DIGIT_BITS = 8;
    private static final int DIGIT_MASK = 255;
    private static final int DIGITS_PER_ELEMENT = 8;
    private static final int RADIXSORT_NO_REC = 1024;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.LongBigArrays.radixSort(long[][], long, long):void, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays.class
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:204)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.plugins.input.java.utils.JavaClassParseException: Unknown opcode: 0x5e
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:71)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	... 5 more
        */
    public static void radixSort(long[][] r0, long r1, long r3) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.LongBigArrays.radixSort(long[][], long, long):void, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.radixSort(long[][], long, long):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.LongBigArrays.radixSort(long[][], long[][], long, long):void, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays.class
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:204)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.plugins.input.java.utils.JavaClassParseException: Unknown opcode: 0x5e
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:71)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	... 5 more
        */
    public static void radixSort(long[][] r0, long[][] r1, long r2, long r4) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.LongBigArrays.radixSort(long[][], long[][], long, long):void, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.radixSort(long[][], long[][], long, long):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.LongBigArrays.radixSortIndirect(long[][], long[][], long[][], long, long, boolean):void, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays.class
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:204)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.plugins.input.java.utils.JavaClassParseException: Unknown opcode: 0x5e
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:71)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	... 5 more
        */
    public static void radixSortIndirect(long[][] r0, long[][] r1, long[][] r2, long r3, long r5, boolean r7) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.longs.LongBigArrays.radixSortIndirect(long[][], long[][], long[][], long, long, boolean):void, file: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.radixSortIndirect(long[][], long[][], long[][], long, long, boolean):void");
    }

    private LongBigArrays() {
    }

    @Deprecated
    public static long get(long[][] array, long index) {
        return array[BigArrays.segment(index)][BigArrays.displacement(index)];
    }

    @Deprecated
    public static void set(long[][] array, long index, long value) {
        array[BigArrays.segment(index)][BigArrays.displacement(index)] = value;
    }

    @Deprecated
    public static void swap(long[][] array, long first, long second) {
        long t = array[BigArrays.segment(first)][BigArrays.displacement(first)];
        array[BigArrays.segment(first)][BigArrays.displacement(first)] = array[BigArrays.segment(second)][BigArrays.displacement(second)];
        array[BigArrays.segment(second)][BigArrays.displacement(second)] = t;
    }

    @Deprecated
    public static void add(long[][] array, long index, long incr) {
        long[] jArr = array[BigArrays.segment(index)];
        int displacement = BigArrays.displacement(index);
        jArr[displacement] = jArr[displacement] + incr;
    }

    @Deprecated
    public static void mul(long[][] array, long index, long factor) {
        long[] jArr = array[BigArrays.segment(index)];
        int displacement = BigArrays.displacement(index);
        jArr[displacement] = jArr[displacement] * factor;
    }

    @Deprecated
    public static void incr(long[][] array, long index) {
        long[] jArr = array[BigArrays.segment(index)];
        int displacement = BigArrays.displacement(index);
        jArr[displacement] = jArr[displacement] + 1;
    }

    @Deprecated
    public static void decr(long[][] array, long index) {
        long[] jArr = array[BigArrays.segment(index)];
        int displacement = BigArrays.displacement(index);
        jArr[displacement] = jArr[displacement] - 1;
    }

    @Deprecated
    public static long length(long[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return BigArrays.start(length - 1) + ((long) array[length - 1].length);
    }

    @Deprecated
    public static void copy(long[][] srcArray, long srcPos, long[][] destArray, long destPos, long length) {
        BigArrays.copy(srcArray, srcPos, destArray, destPos, length);
    }

    @Deprecated
    public static void copyFromBig(long[][] srcArray, long srcPos, long[] destArray, int destPos, int length) {
        BigArrays.copyFromBig(srcArray, srcPos, destArray, destPos, length);
    }

    @Deprecated
    public static void copyToBig(long[] srcArray, int srcPos, long[][] destArray, long destPos, long length) {
        BigArrays.copyToBig(srcArray, srcPos, destArray, destPos, length);
    }

    public static long[][] newBigArray(long length) {
        if (length == 0) {
            return EMPTY_BIG_ARRAY;
        }
        BigArrays.ensureLength(length);
        int baseLength = (int) ((length + 134217727) >>> 27);
        long[][] base = new long[baseLength];
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = 0; i < baseLength - 1; i++) {
                base[i] = new long[134217728];
            }
            base[baseLength - 1] = new long[residual];
        } else {
            for (int i2 = 0; i2 < baseLength; i2++) {
                base[i2] = new long[134217728];
            }
        }
        return base;
    }

    public static AtomicLongArray[] newBigAtomicArray(long length) {
        if (length == 0) {
            return EMPTY_BIG_ATOMIC_ARRAY;
        }
        BigArrays.ensureLength(length);
        int baseLength = (int) ((length + 134217727) >>> 27);
        AtomicLongArray[] base = new AtomicLongArray[baseLength];
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = 0; i < baseLength - 1; i++) {
                base[i] = new AtomicLongArray(134217728);
            }
            base[baseLength - 1] = new AtomicLongArray(residual);
        } else {
            for (int i2 = 0; i2 < baseLength; i2++) {
                base[i2] = new AtomicLongArray(134217728);
            }
        }
        return base;
    }

    @Deprecated
    public static long[][] wrap(long[] array) {
        return BigArrays.wrap(array);
    }

    @Deprecated
    public static long[][] ensureCapacity(long[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    @Deprecated
    public static long[][] forceCapacity(long[][] array, long length, long preserve) {
        return BigArrays.forceCapacity(array, length, preserve);
    }

    @Deprecated
    public static long[][] ensureCapacity(long[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    @Deprecated
    public static long[][] grow(long[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    @Deprecated
    public static long[][] grow(long[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    @Deprecated
    public static long[][] trim(long[][] array, long length) {
        BigArrays.ensureLength(length);
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

    @Deprecated
    public static long[][] setLength(long[][] array, long length) {
        return BigArrays.setLength(array, length);
    }

    @Deprecated
    public static long[][] copy(long[][] array, long offset, long length) {
        return BigArrays.copy(array, offset, length);
    }

    @Deprecated
    public static long[][] copy(long[][] array) {
        return BigArrays.copy(array);
    }

    @Deprecated
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

    @Deprecated
    public static void fill(long[][] array, long from, long to, long value) {
        BigArrays.fill(array, from, to, value);
    }

    @Deprecated
    public static boolean equals(long[][] a1, long[][] a2) {
        return BigArrays.equals(a1, a2);
    }

    @Deprecated
    public static String toString(long[][] a) {
        return BigArrays.toString(a);
    }

    @Deprecated
    public static void ensureFromTo(long[][] a, long from, long to) {
        BigArrays.ensureFromTo(length(a), from, to);
    }

    @Deprecated
    public static void ensureOffsetLength(long[][] a, long offset, long length) {
        BigArrays.ensureOffsetLength(length(a), offset, length);
    }

    @Deprecated
    public static void ensureSameLength(long[][] a, long[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrays$BigArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays$BigArrayHashStrategy.class */
    private static final class BigArrayHashStrategy implements Hash.Strategy<long[][]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private BigArrayHashStrategy() {
        }

        public int hashCode(long[][] o) {
            return Arrays.deepHashCode(o);
        }

        public boolean equals(long[][] a, long[][] b) {
            return LongBigArrays.equals(a, b);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    /* access modifiers changed from: private */
    public static void swap(long[][] x, long a, long b, long n) {
        int i = 0;
        while (((long) i) < n) {
            BigArrays.swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* access modifiers changed from: private */
    public static long med3(long[][] x, long a, long b, long c, LongComparator comp) {
        int ab = comp.compare(BigArrays.get(x, a), BigArrays.get(x, b));
        int ac = comp.compare(BigArrays.get(x, a), BigArrays.get(x, c));
        int bc = comp.compare(BigArrays.get(x, b), BigArrays.get(x, c));
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void selectionSort(long[][] r7, long r8, long r10, p014it.unimi.dsi.fastutil.longs.LongComparator r12) {
        /*
            r0 = r8
            r13 = r0
        L_0x0003:
            r0 = r13
            r1 = r10
            r2 = 1
            long r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0059
            r0 = r13
            r15 = r0
            r0 = r13
            r1 = 1
            long r0 = r0 + r1
            r17 = r0
        L_0x0016:
            r0 = r17
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0040
            r0 = r12
            r1 = r7
            r2 = r17
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r2 = r7
            r3 = r15
            long r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            int r0 = r0.compare(r1, r2)
            if (r0 >= 0) goto L_0x0037
            r0 = r17
            r15 = r0
        L_0x0037:
            r0 = r17
            r1 = 1
            long r0 = r0 + r1
            r17 = r0
            goto L_0x0016
        L_0x0040:
            r0 = r15
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0050
            r0 = r7
            r1 = r13
            r2 = r15
            p014it.unimi.dsi.fastutil.BigArrays.swap(r0, r1, r2)
        L_0x0050:
            r0 = r13
            r1 = 1
            long r0 = r0 + r1
            r13 = r0
            goto L_0x0003
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.selectionSort(long[][], long, long, it.unimi.dsi.fastutil.longs.LongComparator):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00ad */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00e5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0114 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00ad */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r28v0, types: [long] */
    /* JADX WARN: Type inference failed for: r30v0 */
    /* JADX WARN: Type inference failed for: r30v1 */
    /* JADX WARN: Type inference failed for: r28v1, types: [long] */
    /* JADX WARN: Type inference failed for: r26v1, types: [long] */
    /* JADX WARN: Type inference failed for: r24v1, types: [long, long[][]] */
    /* JADX WARN: Type inference failed for: r30v2, types: [long, long[][]] */
    /* JADX WARN: Type inference failed for: r28v2, types: [long] */
    /* JADX WARN: Type inference failed for: r26v2, types: [long] */
    /* JADX WARN: Type inference failed for: r28v3, types: [long] */
    /* JADX WARN: Type inference failed for: r30v3 */
    /* JADX WARN: Type inference failed for: r0v43, types: [long] */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r30v4, types: [long] */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r0v50, types: [long] */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r0v59, types: [long] */
    /* JADX WARN: Type inference failed for: r0v63, types: [long] */
    /* JADX WARN: Type inference failed for: r0v65, types: [long] */
    /* JADX WARN: Type inference failed for: r0v67, types: [long] */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void quickSort(long[][] r12, long r13, long r15, p014it.unimi.dsi.fastutil.longs.LongComparator r17) {
        /*
        // Method dump skipped, instructions count: 427
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.quickSort(long[][], long, long, it.unimi.dsi.fastutil.longs.LongComparator):void");
    }

    /* access modifiers changed from: private */
    public static long med3(long[][] x, long a, long b, long c) {
        int ab = Long.compare(BigArrays.get(x, a), BigArrays.get(x, b));
        int ac = Long.compare(BigArrays.get(x, a), BigArrays.get(x, c));
        int bc = Long.compare(BigArrays.get(x, b), BigArrays.get(x, c));
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0031 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void selectionSort(long[][] r7, long r8, long r10) {
        /*
            r0 = r8
            r12 = r0
        L_0x0003:
            r0 = r12
            r1 = r10
            r2 = 1
            long r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0053
            r0 = r12
            r14 = r0
            r0 = r12
            r1 = 1
            long r0 = r0 + r1
            r16 = r0
        L_0x0016:
            r0 = r16
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x003a
            r0 = r7
            r1 = r16
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r7
            r2 = r14
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0031
            r0 = r16
            r14 = r0
        L_0x0031:
            r0 = r16
            r1 = 1
            long r0 = r0 + r1
            r16 = r0
            goto L_0x0016
        L_0x003a:
            r0 = r14
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x004a
            r0 = r7
            r1 = r12
            r2 = r14
            p014it.unimi.dsi.fastutil.BigArrays.swap(r0, r1, r2)
        L_0x004a:
            r0 = r12
            r1 = 1
            long r0 = r0 + r1
            r12 = r0
            goto L_0x0003
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.selectionSort(long[][], long, long):void");
    }

    public static void quickSort(long[][] x, LongComparator comp) {
        quickSort(x, 0, BigArrays.length(x), comp);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00a3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00d7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0102 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00a3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [long[][], long] */
    /* JADX WARN: Type inference failed for: r13v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r27v0, types: [long] */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r27v1, types: [long] */
    /* JADX WARN: Type inference failed for: r29v2, types: [long] */
    /* JADX WARN: Type inference failed for: r27v2, types: [long] */
    /* JADX WARN: Type inference failed for: r25v2, types: [long] */
    /* JADX WARN: Type inference failed for: r27v3, types: [long] */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r0v44, types: [long] */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r29v4, types: [long] */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r0v51, types: [long] */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    /* JADX WARN: Type inference failed for: r0v59, types: [long] */
    /* JADX WARN: Type inference failed for: r0v63, types: [long] */
    /* JADX WARN: Type inference failed for: r0v65, types: [long] */
    /* JADX WARN: Type inference failed for: r0v67, types: [long] */
    /* JADX WARN: Type inference failed for: r23v12 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void quickSort(long[][] r12, long r13, long r15) {
        /*
        // Method dump skipped, instructions count: 405
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.quickSort(long[][], long, long):void");
    }

    public static void quickSort(long[][] x) {
        quickSort(x, 0, BigArrays.length(x));
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final long from;

        /* renamed from: to */
        private final long f2370to;

        /* renamed from: x */
        private final long[][] f2371x;

        public ForkJoinQuickSort(long[][] x, long from, long to) {
            this.from = from;
            this.f2370to = to;
            this.f2371x = x;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x00ad */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x00e1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x010c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00ad */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [long[][], long] */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r31v0, types: [long] */
        /* JADX WARN: Type inference failed for: r33v0 */
        /* JADX WARN: Type inference failed for: r33v1 */
        /* JADX WARN: Type inference failed for: r31v1, types: [long] */
        /* JADX WARN: Type inference failed for: r33v2, types: [long] */
        /* JADX WARN: Type inference failed for: r31v2, types: [long] */
        /* JADX WARN: Type inference failed for: r29v2, types: [long] */
        /* JADX WARN: Type inference failed for: r31v3, types: [long] */
        /* JADX WARN: Type inference failed for: r33v3 */
        /* JADX WARN: Type inference failed for: r0v69, types: [long] */
        /* JADX WARN: Type inference failed for: r31v4 */
        /* JADX WARN: Type inference failed for: r33v4, types: [long] */
        /* JADX WARN: Type inference failed for: r33v5 */
        /* JADX WARN: Type inference failed for: r31v5 */
        /* JADX WARN: Type inference failed for: r29v3 */
        /* JADX WARN: Type inference failed for: r0v76, types: [long] */
        /* JADX WARN: Type inference failed for: r29v4 */
        /* JADX WARN: Type inference failed for: r27v8 */
        /* JADX WARNING: Unknown variable types count: 3 */
        @Override // java.util.concurrent.RecursiveAction
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void compute() {
            /*
            // Method dump skipped, instructions count: 516
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.ForkJoinQuickSort.compute():void");
        }
    }

    public static void parallelQuickSort(long[][] x, long from, long to) {
        ForkJoinPool pool = getPool();
        if (to - from < FileAppender.DEFAULT_BUFFER_SIZE || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static void parallelQuickSort(long[][] x) {
        parallelQuickSort(x, 0, BigArrays.length(x));
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongBigArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final long from;

        /* renamed from: to */
        private final long f2372to;

        /* renamed from: x */
        private final long[][] f2373x;
        private final LongComparator comp;

        public ForkJoinQuickSortComp(long[][] x, long from, long to, LongComparator comp) {
            this.from = from;
            this.f2372to = to;
            this.f2373x = x;
            this.comp = comp;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x00c1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x00fb */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x012c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00c1 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r27v0 */
        /* JADX WARN: Type inference failed for: r29v0 */
        /* JADX WARN: Type inference failed for: r31v0, types: [long] */
        /* JADX WARN: Type inference failed for: r33v0 */
        /* JADX WARN: Type inference failed for: r33v1 */
        /* JADX WARN: Type inference failed for: r31v1, types: [long] */
        /* JADX WARN: Type inference failed for: r29v1, types: [long] */
        /* JADX WARN: Type inference failed for: r27v1, types: [long, long[][]] */
        /* JADX WARN: Type inference failed for: r33v2, types: [long, long[][]] */
        /* JADX WARN: Type inference failed for: r31v2, types: [long] */
        /* JADX WARN: Type inference failed for: r29v2, types: [long] */
        /* JADX WARN: Type inference failed for: r31v3, types: [long] */
        /* JADX WARN: Type inference failed for: r33v3 */
        /* JADX WARN: Type inference failed for: r0v69, types: [long] */
        /* JADX WARN: Type inference failed for: r31v4 */
        /* JADX WARN: Type inference failed for: r33v4, types: [long] */
        /* JADX WARN: Type inference failed for: r33v5 */
        /* JADX WARN: Type inference failed for: r31v5 */
        /* JADX WARN: Type inference failed for: r29v3 */
        /* JADX WARN: Type inference failed for: r27v2 */
        /* JADX WARN: Type inference failed for: r27v3 */
        /* JADX WARN: Type inference failed for: r0v77, types: [long] */
        /* JADX WARN: Type inference failed for: r29v4 */
        /* JADX WARN: Type inference failed for: r27v5 */
        /* JADX WARN: Type inference failed for: r27v6 */
        /* JADX WARNING: Unknown variable types count: 4 */
        @Override // java.util.concurrent.RecursiveAction
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void compute() {
            /*
            // Method dump skipped, instructions count: 564
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.ForkJoinQuickSortComp.compute():void");
        }
    }

    public static void parallelQuickSort(long[][] x, long from, long to, LongComparator comp) {
        ForkJoinPool pool = getPool();
        if (to - from < FileAppender.DEFAULT_BUFFER_SIZE || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static void parallelQuickSort(long[][] x, LongComparator comp) {
        parallelQuickSort(x, 0, BigArrays.length(x), comp);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0004 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0004 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [long] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long binarySearch(long[][] r5, long r6, long r8, long r10) {
        /*
            r0 = r8
            r1 = 1
            long r0 = r0 - r1
            r8 = r0
        L_0x0004:
            r0 = r6
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x003f
            r0 = r6
            r1 = r8
            long r0 = r0 + r1
            r1 = 1
            long r0 = r0 >>> r1
            r14 = r0
            r0 = r5
            r1 = r14
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r12 = r0
            r0 = r12
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0029
            r0 = r14
            r1 = 1
            long r0 = r0 + r1
            r6 = r0
            goto L_0x003c
        L_0x0029:
            r0 = r12
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            r0 = r14
            r1 = 1
            long r0 = r0 - r1
            r8 = r0
            goto L_0x003c
        L_0x0039:
            r0 = r14
            return r0
        L_0x003c:
            goto L_0x0004
        L_0x003f:
            r0 = r6
            r1 = 1
            long r0 = r0 + r1
            long r0 = -r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.binarySearch(long[][], long, long, long):long");
    }

    public static long binarySearch(long[][] a, long key) {
        return binarySearch(a, 0, BigArrays.length(a), key);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0004 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0004 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [long] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long binarySearch(long[][] r6, long r7, long r9, long r11, p014it.unimi.dsi.fastutil.longs.LongComparator r13) {
        /*
            r0 = r9
            r1 = 1
            long r0 = r0 - r1
            r9 = r0
        L_0x0004:
            r0 = r7
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0046
            r0 = r7
            r1 = r9
            long r0 = r0 + r1
            r1 = 1
            long r0 = r0 >>> r1
            r16 = r0
            r0 = r6
            r1 = r16
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r14 = r0
            r0 = r13
            r1 = r14
            r2 = r11
            int r0 = r0.compare(r1, r2)
            r18 = r0
            r0 = r18
            if (r0 >= 0) goto L_0x0033
            r0 = r16
            r1 = 1
            long r0 = r0 + r1
            r7 = r0
            goto L_0x0043
        L_0x0033:
            r0 = r18
            if (r0 <= 0) goto L_0x0040
            r0 = r16
            r1 = 1
            long r0 = r0 - r1
            r9 = r0
            goto L_0x0043
        L_0x0040:
            r0 = r16
            return r0
        L_0x0043:
            goto L_0x0004
        L_0x0046:
            r0 = r7
            r1 = 1
            long r0 = r0 + r1
            long r0 = -r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.binarySearch(long[][], long, long, long, it.unimi.dsi.fastutil.longs.LongComparator):long");
    }

    public static long binarySearch(long[][] a, long key, LongComparator c) {
        return binarySearch(a, 0, BigArrays.length(a), key, c);
    }

    public static void radixSort(long[][] a) {
        radixSort(a, 0, BigArrays.length(a));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0053 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void selectionSort(long[][] r7, long[][] r8, long r9, long r11) {
        /*
            r0 = r9
            r13 = r0
        L_0x0003:
            r0 = r13
            r1 = r11
            r2 = 1
            long r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a5
            r0 = r13
            r15 = r0
            r0 = r13
            r1 = 1
            long r0 = r0 + r1
            r17 = r0
        L_0x0017:
            r0 = r17
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x005c
            r0 = r7
            r1 = r17
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r7
            r2 = r15
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x004f
            r0 = r7
            r1 = r17
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r7
            r2 = r15
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0053
            r0 = r8
            r1 = r17
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r8
            r2 = r15
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0053
        L_0x004f:
            r0 = r17
            r15 = r0
        L_0x0053:
            r0 = r17
            r1 = 1
            long r0 = r0 + r1
            r17 = r0
            goto L_0x0017
        L_0x005c:
            r0 = r15
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x009c
            r0 = r7
            r1 = r13
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r17 = r0
            r0 = r7
            r1 = r13
            r2 = r7
            r3 = r15
            long r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            r0 = r7
            r1 = r15
            r2 = r17
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            r0 = r8
            r1 = r13
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r17 = r0
            r0 = r8
            r1 = r13
            r2 = r8
            r3 = r15
            long r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            r0 = r8
            r1 = r15
            r2 = r17
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
        L_0x009c:
            r0 = r13
            r1 = 1
            long r0 = r0 + r1
            r13 = r0
            goto L_0x0003
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.selectionSort(long[][], long[][], long, long):void");
    }

    public static void radixSort(long[][] a, long[][] b) {
        radixSort(a, b, 0, BigArrays.length(a));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    /* JADX WARN: Type inference failed for: r1v16, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void insertionSortIndirect(long[][] r7, long[][] r8, long[][] r9, long r10, long r12) {
        /*
            r0 = r10
            r14 = r0
        L_0x0003:
            r0 = r14
            r1 = 1
            long r0 = r0 + r1
            r1 = r0; r1 = r0; 
            r14 = r1
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x008d
            r0 = r7
            r1 = r14
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r16 = r0
            r0 = r14
            r18 = r0
            r0 = r7
            r1 = r18
            r2 = 1
            long r1 = r1 - r2
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r20 = r0
        L_0x0026:
            r0 = r8
            r1 = r16
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r8
            r2 = r20
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0056
            r0 = r8
            r1 = r16
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r8
            r2 = r20
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0082
            r0 = r9
            r1 = r16
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r9
            r2 = r20
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0082
        L_0x0056:
            r0 = r7
            r1 = r18
            r2 = r20
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            r0 = r10
            r1 = r18
            r2 = 1
            long r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0070
            r0 = r18
            r1 = 1
            long r0 = r0 - r1
            r18 = r0
            goto L_0x0082
        L_0x0070:
            r0 = r7
            r1 = r18
            r2 = 1
            long r1 = r1 - r2
            r2 = r1; r2 = r2; 
            r18 = r2
            r2 = 1
            long r1 = r1 - r2
            long r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r20 = r0
            goto L_0x0026
        L_0x0082:
            r0 = r7
            r1 = r18
            r2 = r16
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0003
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongBigArrays.insertionSortIndirect(long[][], long[][], long[][], long, long):void");
    }

    public static void radixSortIndirect(long[][] perm, long[][] a, long[][] b, boolean stable) {
        ensureSameLength(a, b);
        radixSortIndirect(perm, a, b, 0, BigArrays.length(a), stable);
    }

    public static long[][] shuffle(long[][] a, long from, long to, Random random) {
        return BigArrays.shuffle(a, from, to, random);
    }

    public static long[][] shuffle(long[][] a, Random random) {
        return BigArrays.shuffle(a, random);
    }
}
