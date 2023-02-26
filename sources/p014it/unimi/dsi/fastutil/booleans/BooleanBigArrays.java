package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import p001ch.qos.logback.core.FileAppender;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.Hash;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrays.class */
public final class BooleanBigArrays {
    public static final boolean[][] EMPTY_BIG_ARRAY = new boolean[0];
    public static final boolean[][] DEFAULT_EMPTY_BIG_ARRAY = new boolean[0];
    public static final Hash.Strategy HASH_STRATEGY = new BigArrayHashStrategy();
    private static final int QUICKSORT_NO_REC = 7;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int MEDIUM = 40;

    private BooleanBigArrays() {
    }

    @Deprecated
    public static boolean get(boolean[][] array, long index) {
        return array[BigArrays.segment(index)][BigArrays.displacement(index)];
    }

    @Deprecated
    public static void set(boolean[][] array, long index, boolean value) {
        array[BigArrays.segment(index)][BigArrays.displacement(index)] = value;
    }

    @Deprecated
    public static void swap(boolean[][] array, long first, long second) {
        boolean t = array[BigArrays.segment(first)][BigArrays.displacement(first)];
        array[BigArrays.segment(first)][BigArrays.displacement(first)] = array[BigArrays.segment(second)][BigArrays.displacement(second)];
        array[BigArrays.segment(second)][BigArrays.displacement(second)] = t;
    }

    @Deprecated
    public static long length(boolean[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return BigArrays.start(length - 1) + ((long) array[length - 1].length);
    }

    @Deprecated
    public static void copy(boolean[][] srcArray, long srcPos, boolean[][] destArray, long destPos, long length) {
        BigArrays.copy(srcArray, srcPos, destArray, destPos, length);
    }

    @Deprecated
    public static void copyFromBig(boolean[][] srcArray, long srcPos, boolean[] destArray, int destPos, int length) {
        BigArrays.copyFromBig(srcArray, srcPos, destArray, destPos, length);
    }

    @Deprecated
    public static void copyToBig(boolean[] srcArray, int srcPos, boolean[][] destArray, long destPos, long length) {
        BigArrays.copyToBig(srcArray, srcPos, destArray, destPos, length);
    }

    public static boolean[][] newBigArray(long length) {
        if (length == 0) {
            return EMPTY_BIG_ARRAY;
        }
        BigArrays.ensureLength(length);
        int baseLength = (int) ((length + 134217727) >>> 27);
        boolean[][] base = new boolean[baseLength];
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = 0; i < baseLength - 1; i++) {
                base[i] = new boolean[134217728];
            }
            base[baseLength - 1] = new boolean[residual];
        } else {
            for (int i2 = 0; i2 < baseLength; i2++) {
                base[i2] = new boolean[134217728];
            }
        }
        return base;
    }

    @Deprecated
    public static boolean[][] wrap(boolean[] array) {
        return BigArrays.wrap(array);
    }

    @Deprecated
    public static boolean[][] ensureCapacity(boolean[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    @Deprecated
    public static boolean[][] forceCapacity(boolean[][] array, long length, long preserve) {
        return BigArrays.forceCapacity(array, length, preserve);
    }

    @Deprecated
    public static boolean[][] ensureCapacity(boolean[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    @Deprecated
    public static boolean[][] grow(boolean[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    @Deprecated
    public static boolean[][] grow(boolean[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    @Deprecated
    public static boolean[][] trim(boolean[][] array, long length) {
        BigArrays.ensureLength(length);
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

    @Deprecated
    public static boolean[][] setLength(boolean[][] array, long length) {
        return BigArrays.setLength(array, length);
    }

    @Deprecated
    public static boolean[][] copy(boolean[][] array, long offset, long length) {
        return BigArrays.copy(array, offset, length);
    }

    @Deprecated
    public static boolean[][] copy(boolean[][] array) {
        return BigArrays.copy(array);
    }

    @Deprecated
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

    @Deprecated
    public static void fill(boolean[][] array, long from, long to, boolean value) {
        BigArrays.fill(array, from, to, value);
    }

    @Deprecated
    public static boolean equals(boolean[][] a1, boolean[][] a2) {
        return BigArrays.equals(a1, a2);
    }

    @Deprecated
    public static String toString(boolean[][] a) {
        return BigArrays.toString(a);
    }

    @Deprecated
    public static void ensureFromTo(boolean[][] a, long from, long to) {
        BigArrays.ensureFromTo(length(a), from, to);
    }

    @Deprecated
    public static void ensureOffsetLength(boolean[][] a, long offset, long length) {
        BigArrays.ensureOffsetLength(length(a), offset, length);
    }

    @Deprecated
    public static void ensureSameLength(boolean[][] a, boolean[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrays$BigArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrays$BigArrayHashStrategy.class */
    private static final class BigArrayHashStrategy implements Hash.Strategy<boolean[][]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private BigArrayHashStrategy() {
        }

        public int hashCode(boolean[][] o) {
            return Arrays.deepHashCode(o);
        }

        public boolean equals(boolean[][] a, boolean[][] b) {
            return BooleanBigArrays.equals(a, b);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    /* access modifiers changed from: private */
    public static void swap(boolean[][] x, long a, long b, long n) {
        int i = 0;
        while (((long) i) < n) {
            BigArrays.swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* access modifiers changed from: private */
    public static long med3(boolean[][] x, long a, long b, long c, BooleanComparator comp) {
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
    private static void selectionSort(boolean[][] r7, long r8, long r10, p014it.unimi.dsi.fastutil.booleans.BooleanComparator r12) {
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
            boolean r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r2 = r7
            r3 = r15
            boolean r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays.selectionSort(boolean[][], long, long, it.unimi.dsi.fastutil.booleans.BooleanComparator):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00ad */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00e5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0114 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00ad */
    /* JADX WARN: Multi-variable type inference failed */
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
    /* JADX WARN: Type inference failed for: r0v43, types: [long] */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r0v49, types: [long] */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r0v53, types: [long] */
    /* JADX WARN: Type inference failed for: r0v57, types: [long] */
    /* JADX WARN: Type inference failed for: r0v61, types: [long] */
    /* JADX WARN: Type inference failed for: r0v63, types: [long] */
    /* JADX WARN: Type inference failed for: r0v65, types: [long] */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void quickSort(boolean[][] r12, long r13, long r15, p014it.unimi.dsi.fastutil.booleans.BooleanComparator r17) {
        /*
        // Method dump skipped, instructions count: 427
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays.quickSort(boolean[][], long, long, it.unimi.dsi.fastutil.booleans.BooleanComparator):void");
    }

    /* access modifiers changed from: private */
    public static long med3(boolean[][] x, long a, long b, long c) {
        int ab = Boolean.compare(BigArrays.get(x, a), BigArrays.get(x, b));
        int ac = Boolean.compare(BigArrays.get(x, a), BigArrays.get(x, c));
        int bc = Boolean.compare(BigArrays.get(x, b), BigArrays.get(x, c));
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0033 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void selectionSort(boolean[][] r7, long r8, long r10) {
        /*
            r0 = r8
            r12 = r0
        L_0x0003:
            r0 = r12
            r1 = r10
            r2 = 1
            long r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0055
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
            if (r0 >= 0) goto L_0x003c
            r0 = r7
            r1 = r16
            boolean r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            if (r0 != 0) goto L_0x0033
            r0 = r7
            r1 = r14
            boolean r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            if (r0 == 0) goto L_0x0033
            r0 = r16
            r14 = r0
        L_0x0033:
            r0 = r16
            r1 = 1
            long r0 = r0 + r1
            r16 = r0
            goto L_0x0016
        L_0x003c:
            r0 = r14
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x004c
            r0 = r7
            r1 = r12
            r2 = r14
            p014it.unimi.dsi.fastutil.BigArrays.swap(r0, r1, r2)
        L_0x004c:
            r0 = r12
            r1 = 1
            long r0 = r0 + r1
            r12 = r0
            goto L_0x0003
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays.selectionSort(boolean[][], long, long):void");
    }

    public static void quickSort(boolean[][] x, BooleanComparator comp) {
        quickSort(x, 0, BigArrays.length(x), comp);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00a3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00d7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0102 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00a3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r26v0, types: [long] */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r26v1, types: [long] */
    /* JADX WARN: Type inference failed for: r24v1, types: [long] */
    /* JADX WARN: Type inference failed for: r22v1, types: [long, boolean[][]] */
    /* JADX WARN: Type inference failed for: r28v2, types: [long, boolean[][]] */
    /* JADX WARN: Type inference failed for: r26v2, types: [long] */
    /* JADX WARN: Type inference failed for: r24v2, types: [long] */
    /* JADX WARN: Type inference failed for: r26v3, types: [long] */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r0v44, types: [long] */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r28v4, types: [long] */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r0v52, types: [long] */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r0v57, types: [long] */
    /* JADX WARN: Type inference failed for: r0v61, types: [long] */
    /* JADX WARN: Type inference failed for: r0v65, types: [long] */
    /* JADX WARN: Type inference failed for: r0v67, types: [long] */
    /* JADX WARN: Type inference failed for: r0v69, types: [long] */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void quickSort(boolean[][] r12, long r13, long r15) {
        /*
        // Method dump skipped, instructions count: 405
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays.quickSort(boolean[][], long, long):void");
    }

    public static void quickSort(boolean[][] x) {
        quickSort(x, 0, BigArrays.length(x));
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final long from;

        /* renamed from: to */
        private final long f1022to;

        /* renamed from: x */
        private final boolean[][] f1023x;

        public ForkJoinQuickSort(boolean[][] x, long from, long to) {
            this.from = from;
            this.f1022to = to;
            this.f1023x = x;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x00ad */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x00e1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x010c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00ad */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r26v0 */
        /* JADX WARN: Type inference failed for: r28v0 */
        /* JADX WARN: Type inference failed for: r30v0, types: [long] */
        /* JADX WARN: Type inference failed for: r32v0 */
        /* JADX WARN: Type inference failed for: r32v1 */
        /* JADX WARN: Type inference failed for: r30v1, types: [long] */
        /* JADX WARN: Type inference failed for: r28v1, types: [long] */
        /* JADX WARN: Type inference failed for: r26v1, types: [long, boolean[][]] */
        /* JADX WARN: Type inference failed for: r32v2, types: [long, boolean[][]] */
        /* JADX WARN: Type inference failed for: r30v2, types: [long] */
        /* JADX WARN: Type inference failed for: r28v2, types: [long] */
        /* JADX WARN: Type inference failed for: r30v3, types: [long] */
        /* JADX WARN: Type inference failed for: r32v3 */
        /* JADX WARN: Type inference failed for: r0v69, types: [long] */
        /* JADX WARN: Type inference failed for: r30v4 */
        /* JADX WARN: Type inference failed for: r32v4, types: [long] */
        /* JADX WARN: Type inference failed for: r32v5 */
        /* JADX WARN: Type inference failed for: r30v5 */
        /* JADX WARN: Type inference failed for: r28v3 */
        /* JADX WARN: Type inference failed for: r26v2 */
        /* JADX WARN: Type inference failed for: r26v3 */
        /* JADX WARN: Type inference failed for: r0v77, types: [long] */
        /* JADX WARN: Type inference failed for: r28v4 */
        /* JADX WARN: Type inference failed for: r26v5 */
        /* JADX WARN: Type inference failed for: r26v6 */
        /* JADX WARNING: Unknown variable types count: 4 */
        @Override // java.util.concurrent.RecursiveAction
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void compute() {
            /*
            // Method dump skipped, instructions count: 516
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays.ForkJoinQuickSort.compute():void");
        }
    }

    public static void parallelQuickSort(boolean[][] x, long from, long to) {
        ForkJoinPool pool = getPool();
        if (to - from < FileAppender.DEFAULT_BUFFER_SIZE || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static void parallelQuickSort(boolean[][] x) {
        parallelQuickSort(x, 0, BigArrays.length(x));
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final long from;

        /* renamed from: to */
        private final long f1024to;

        /* renamed from: x */
        private final boolean[][] f1025x;
        private final BooleanComparator comp;

        public ForkJoinQuickSortComp(boolean[][] x, long from, long to, BooleanComparator comp) {
            this.from = from;
            this.f1024to = to;
            this.f1025x = x;
            this.comp = comp;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x00c1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x00fb */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x012c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00c1 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r30v0, types: [long] */
        /* JADX WARN: Type inference failed for: r32v0 */
        /* JADX WARN: Type inference failed for: r32v1 */
        /* JADX WARN: Type inference failed for: r30v1, types: [long] */
        /* JADX WARN: Type inference failed for: r32v2, types: [long] */
        /* JADX WARN: Type inference failed for: r30v2, types: [long] */
        /* JADX WARN: Type inference failed for: r28v2, types: [long] */
        /* JADX WARN: Type inference failed for: r30v3, types: [long] */
        /* JADX WARN: Type inference failed for: r32v3 */
        /* JADX WARN: Type inference failed for: r0v69, types: [long] */
        /* JADX WARN: Type inference failed for: r30v4 */
        /* JADX WARN: Type inference failed for: r32v5 */
        /* JADX WARN: Type inference failed for: r30v5 */
        /* JADX WARN: Type inference failed for: r28v3 */
        /* JADX WARN: Type inference failed for: r0v76, types: [long] */
        /* JADX WARN: Type inference failed for: r28v4 */
        /* JADX WARN: Type inference failed for: r26v8 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // java.util.concurrent.RecursiveAction
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void compute() {
            /*
            // Method dump skipped, instructions count: 564
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays.ForkJoinQuickSortComp.compute():void");
        }
    }

    public static void parallelQuickSort(boolean[][] x, long from, long to, BooleanComparator comp) {
        ForkJoinPool pool = getPool();
        if (to - from < FileAppender.DEFAULT_BUFFER_SIZE || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static void parallelQuickSort(boolean[][] x, BooleanComparator comp) {
        parallelQuickSort(x, 0, BigArrays.length(x), comp);
    }

    public static boolean[][] shuffle(boolean[][] a, long from, long to, Random random) {
        return BigArrays.shuffle(a, from, to, random);
    }

    public static boolean[][] shuffle(boolean[][] a, Random random) {
        return BigArrays.shuffle(a, random);
    }
}
