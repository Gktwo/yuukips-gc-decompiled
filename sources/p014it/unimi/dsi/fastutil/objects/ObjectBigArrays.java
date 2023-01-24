package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import p001ch.qos.logback.core.FileAppender;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.Hash;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrays.class */
public final class ObjectBigArrays {
    public static final Object[][] EMPTY_BIG_ARRAY = new Object[0];
    public static final Object[][] DEFAULT_EMPTY_BIG_ARRAY = new Object[0];
    public static final Hash.Strategy HASH_STRATEGY = new BigArrayHashStrategy();
    private static final int QUICKSORT_NO_REC = 7;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int MEDIUM = 40;

    private ObjectBigArrays() {
    }

    @Deprecated
    public static <K> K get(K[][] array, long index) {
        return array[BigArrays.segment(index)][BigArrays.displacement(index)];
    }

    @Deprecated
    public static <K> void set(K[][] array, long index, K value) {
        array[BigArrays.segment(index)][BigArrays.displacement(index)] = value;
    }

    @Deprecated
    public static <K> void swap(K[][] array, long first, long second) {
        K t = array[BigArrays.segment(first)][BigArrays.displacement(first)];
        array[BigArrays.segment(first)][BigArrays.displacement(first)] = array[BigArrays.segment(second)][BigArrays.displacement(second)];
        array[BigArrays.segment(second)][BigArrays.displacement(second)] = t;
    }

    @Deprecated
    public static <K> long length(K[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return BigArrays.start(length - 1) + ((long) array[length - 1].length);
    }

    @Deprecated
    public static <K> void copy(K[][] srcArray, long srcPos, K[][] destArray, long destPos, long length) {
        BigArrays.copy(srcArray, srcPos, destArray, destPos, length);
    }

    @Deprecated
    public static <K> void copyFromBig(K[][] srcArray, long srcPos, K[] destArray, int destPos, int length) {
        BigArrays.copyFromBig(srcArray, srcPos, destArray, destPos, length);
    }

    @Deprecated
    public static <K> void copyToBig(K[] srcArray, int srcPos, K[][] destArray, long destPos, long length) {
        BigArrays.copyToBig(srcArray, srcPos, destArray, destPos, length);
    }

    public static <K> K[][] newBigArray(K[][] prototype, long length) {
        return (K[][]) newBigArray(prototype.getClass().getComponentType(), length);
    }

    public static Object[][] newBigArray(Class<?> componentType, long length) {
        if (length == 0 && componentType == Object[].class) {
            return EMPTY_BIG_ARRAY;
        }
        BigArrays.ensureLength(length);
        int baseLength = (int) ((length + 134217727) >>> 27);
        Object[][] base = (Object[][]) Array.newInstance(componentType, baseLength);
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = 0; i < baseLength - 1; i++) {
                base[i] = (Object[]) Array.newInstance(componentType.getComponentType(), 134217728);
            }
            base[baseLength - 1] = (Object[]) Array.newInstance(componentType.getComponentType(), residual);
        } else {
            for (int i2 = 0; i2 < baseLength; i2++) {
                base[i2] = (Object[]) Array.newInstance(componentType.getComponentType(), 134217728);
            }
        }
        return base;
    }

    public static Object[][] newBigArray(long length) {
        if (length == 0) {
            return EMPTY_BIG_ARRAY;
        }
        BigArrays.ensureLength(length);
        int baseLength = (int) ((length + 134217727) >>> 27);
        Object[][] base = new Object[baseLength];
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = 0; i < baseLength - 1; i++) {
                base[i] = new Object[134217728];
            }
            base[baseLength - 1] = new Object[residual];
        } else {
            for (int i2 = 0; i2 < baseLength; i2++) {
                base[i2] = new Object[134217728];
            }
        }
        return base;
    }

    @Deprecated
    public static <K> K[][] wrap(K[] array) {
        return (K[][]) BigArrays.wrap(array);
    }

    @Deprecated
    public static <K> K[][] ensureCapacity(K[][] array, long length) {
        return (K[][]) ensureCapacity(array, length, length(array));
    }

    @Deprecated
    public static <K> K[][] forceCapacity(K[][] array, long length, long preserve) {
        return (K[][]) BigArrays.forceCapacity(array, length, preserve);
    }

    @Deprecated
    public static <K> K[][] ensureCapacity(K[][] array, long length, long preserve) {
        return length > length(array) ? (K[][]) forceCapacity(array, length, preserve) : array;
    }

    @Deprecated
    public static <K> K[][] grow(K[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? (K[][]) grow(array, length, oldLength) : array;
    }

    @Deprecated
    public static <K> K[][] grow(K[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? (K[][]) ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    @Deprecated
    public static <K> K[][] trim(K[][] array, long length) {
        return (K[][]) BigArrays.trim(array, length);
    }

    @Deprecated
    public static <K> K[][] setLength(K[][] array, long length) {
        return (K[][]) BigArrays.setLength(array, length);
    }

    @Deprecated
    public static <K> K[][] copy(K[][] array, long offset, long length) {
        return (K[][]) BigArrays.copy(array, offset, length);
    }

    @Deprecated
    public static <K> K[][] copy(K[][] array) {
        return (K[][]) BigArrays.copy(array);
    }

    @Deprecated
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

    @Deprecated
    public static <K> void fill(K[][] array, long from, long to, K value) {
        BigArrays.fill(array, from, to, value);
    }

    @Deprecated
    public static <K> boolean equals(K[][] a1, K[][] a2) {
        return BigArrays.equals(a1, a2);
    }

    @Deprecated
    public static <K> String toString(K[][] a) {
        return BigArrays.toString(a);
    }

    @Deprecated
    public static <K> void ensureFromTo(K[][] a, long from, long to) {
        BigArrays.ensureFromTo(length(a), from, to);
    }

    @Deprecated
    public static <K> void ensureOffsetLength(K[][] a, long offset, long length) {
        BigArrays.ensureOffsetLength(length(a), offset, length);
    }

    @Deprecated
    public static <K> void ensureSameLength(K[][] a, K[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrays$BigArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrays$BigArrayHashStrategy.class */
    private static final class BigArrayHashStrategy<K> implements Hash.Strategy<K[][]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private BigArrayHashStrategy() {
        }

        public int hashCode(K[][] o) {
            return Arrays.deepHashCode(o);
        }

        public boolean equals(K[][] a, K[][] b) {
            return ObjectBigArrays.equals(a, b);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    /* access modifiers changed from: private */
    public static <K> void swap(K[][] x, long a, long b, long n) {
        int i = 0;
        while (((long) i) < n) {
            BigArrays.swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: java.util.Comparator<K> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    public static <K> long med3(K[][] x, long a, long b, long c, Comparator<K> comp) {
        int ab = comp.compare(BigArrays.get(x, a), BigArrays.get(x, b));
        int ac = comp.compare(BigArrays.get(x, a), BigArrays.get(x, c));
        int bc = comp.compare(BigArrays.get(x, b), BigArrays.get(x, c));
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Comparator<K>, java.util.Comparator] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <K> void selectionSort(K[][] r7, long r8, long r10, java.util.Comparator<K> r12) {
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
            java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r2 = r7
            r3 = r15
            java.lang.Object r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.selectionSort(java.lang.Object[][], long, long, java.util.Comparator):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00ad */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00e5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0114 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00ad */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [long] */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.util.Comparator<K>, java.util.Comparator] */
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
    public static <K> void quickSort(K[][] r12, long r13, long r15, java.util.Comparator<K> r17) {
        /*
        // Method dump skipped, instructions count: 427
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.quickSort(java.lang.Object[][], long, long, java.util.Comparator):void");
    }

    /* access modifiers changed from: private */
    public static <K> long med3(K[][] x, long a, long b, long c) {
        int ab = ((Comparable) BigArrays.get(x, a)).compareTo(BigArrays.get(x, b));
        int ac = ((Comparable) BigArrays.get(x, a)).compareTo(BigArrays.get(x, c));
        int bc = ((Comparable) BigArrays.get(x, b)).compareTo(BigArrays.get(x, c));
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <K> void selectionSort(K[][] r7, long r8, long r10) {
        /*
            r0 = r8
            r12 = r0
        L_0x0003:
            r0 = r12
            r1 = r10
            r2 = 1
            long r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x005a
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
            if (r0 >= 0) goto L_0x0041
            r0 = r7
            r1 = r16
            java.lang.Object r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r1 = r7
            r2 = r14
            java.lang.Object r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = r0.compareTo(r1)
            if (r0 >= 0) goto L_0x0038
            r0 = r16
            r14 = r0
        L_0x0038:
            r0 = r16
            r1 = 1
            long r0 = r0 + r1
            r16 = r0
            goto L_0x0016
        L_0x0041:
            r0 = r14
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0051
            r0 = r7
            r1 = r12
            r2 = r14
            p014it.unimi.dsi.fastutil.BigArrays.swap(r0, r1, r2)
        L_0x0051:
            r0 = r12
            r1 = 1
            long r0 = r0 + r1
            r12 = r0
            goto L_0x0003
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.selectionSort(java.lang.Object[][], long, long):void");
    }

    public static <K> void quickSort(K[][] x, Comparator<K> comp) {
        quickSort(x, 0, BigArrays.length(x), comp);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00a3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00dc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x010c */
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
    /* JADX WARN: Type inference failed for: r22v1, types: [long, java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r28v2, types: [long, java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r26v2, types: [long] */
    /* JADX WARN: Type inference failed for: r24v2, types: [long] */
    /* JADX WARN: Type inference failed for: r26v3, types: [long] */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r0v45, types: [long] */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r28v4, types: [long] */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r0v54, types: [long] */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r0v59, types: [long] */
    /* JADX WARN: Type inference failed for: r0v63, types: [long] */
    /* JADX WARN: Type inference failed for: r0v67, types: [long] */
    /* JADX WARN: Type inference failed for: r0v69, types: [long] */
    /* JADX WARN: Type inference failed for: r0v71, types: [long] */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K> void quickSort(K[][] r12, long r13, long r15) {
        /*
        // Method dump skipped, instructions count: 415
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.quickSort(java.lang.Object[][], long, long):void");
    }

    public static <K> void quickSort(K[][] x) {
        quickSort(x, 0, BigArrays.length(x));
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort<K> extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final long from;

        /* renamed from: to */
        private final long f2695to;

        /* renamed from: x */
        private final K[][] f2696x;

        public ForkJoinQuickSort(K[][] x, long from, long to) {
            this.from = from;
            this.f2695to = to;
            this.f2696x = x;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x00ad */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x00e6 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0116 */
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
        /* JADX WARN: Type inference failed for: r26v1, types: [long, java.lang.Object[][]] */
        /* JADX WARN: Type inference failed for: r32v2, types: [long, java.lang.Object[][]] */
        /* JADX WARN: Type inference failed for: r30v2, types: [long] */
        /* JADX WARN: Type inference failed for: r28v2, types: [long] */
        /* JADX WARN: Type inference failed for: r30v3, types: [long] */
        /* JADX WARN: Type inference failed for: r32v3 */
        /* JADX WARN: Type inference failed for: r0v70, types: [long] */
        /* JADX WARN: Type inference failed for: r30v4 */
        /* JADX WARN: Type inference failed for: r32v4, types: [long] */
        /* JADX WARN: Type inference failed for: r32v5 */
        /* JADX WARN: Type inference failed for: r30v5 */
        /* JADX WARN: Type inference failed for: r28v3 */
        /* JADX WARN: Type inference failed for: r26v2 */
        /* JADX WARN: Type inference failed for: r26v3 */
        /* JADX WARN: Type inference failed for: r0v79, types: [long] */
        /* JADX WARN: Type inference failed for: r28v4 */
        /* JADX WARN: Type inference failed for: r26v5 */
        /* JADX WARN: Type inference failed for: r26v6 */
        /* JADX WARNING: Unknown variable types count: 4 */
        @Override // java.util.concurrent.RecursiveAction
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void compute() {
            /*
            // Method dump skipped, instructions count: 526
            */
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.ForkJoinQuickSort.compute():void");
        }
    }

    public static <K> void parallelQuickSort(K[][] x, long from, long to) {
        ForkJoinPool pool = getPool();
        if (to - from < FileAppender.DEFAULT_BUFFER_SIZE || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static <K> void parallelQuickSort(K[][] x) {
        parallelQuickSort(x, 0, BigArrays.length(x));
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectBigArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBigArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp<K> extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final long from;

        /* renamed from: to */
        private final long f2697to;

        /* renamed from: x */
        private final K[][] f2698x;
        private final Comparator<K> comp;

        public ForkJoinQuickSortComp(K[][] x, long from, long to, Comparator<K> comp) {
            this.from = from;
            this.f2697to = to;
            this.f2698x = x;
            this.comp = comp;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x00c1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x00fb */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x012c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00c1 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX DEBUG: Type inference failed for r0v65. Raw type applied. Possible types: java.util.Comparator<K>, java.util.Comparator */
        /* JADX DEBUG: Type inference failed for r0v72. Raw type applied. Possible types: java.util.Comparator<K>, java.util.Comparator */
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.ForkJoinQuickSortComp.compute():void");
        }
    }

    public static <K> void parallelQuickSort(K[][] x, long from, long to, Comparator<K> comp) {
        ForkJoinPool pool = getPool();
        if (to - from < FileAppender.DEFAULT_BUFFER_SIZE || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static <K> void parallelQuickSort(K[][] x, Comparator<K> comp) {
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
    public static <K> long binarySearch(K[][] r5, long r6, long r8, K r10) {
        /*
            r0 = r8
            r1 = 1
            long r0 = r0 - r1
            r8 = r0
        L_0x0004:
            r0 = r6
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0047
            r0 = r6
            r1 = r8
            long r0 = r0 + r1
            r1 = 1
            long r0 = r0 >>> r1
            r12 = r0
            r0 = r5
            r1 = r12
            java.lang.Object r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r11 = r0
            r0 = r11
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r1 = r10
            int r0 = r0.compareTo(r1)
            r14 = r0
            r0 = r14
            if (r0 >= 0) goto L_0x0034
            r0 = r12
            r1 = 1
            long r0 = r0 + r1
            r6 = r0
            goto L_0x0044
        L_0x0034:
            r0 = r14
            if (r0 <= 0) goto L_0x0041
            r0 = r12
            r1 = 1
            long r0 = r0 - r1
            r8 = r0
            goto L_0x0044
        L_0x0041:
            r0 = r12
            return r0
        L_0x0044:
            goto L_0x0004
        L_0x0047:
            r0 = r6
            r1 = 1
            long r0 = r0 + r1
            long r0 = -r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.binarySearch(java.lang.Object[][], long, long, java.lang.Object):long");
    }

    public static <K> long binarySearch(K[][] a, Object key) {
        return binarySearch(a, 0, BigArrays.length(a), key);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0004 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0004 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.Comparator<K>, java.util.Comparator] */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [long] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K> long binarySearch(K[][] r5, long r6, long r8, K r10, java.util.Comparator<K> r11) {
        /*
            r0 = r8
            r1 = 1
            long r0 = r0 - r1
            r8 = r0
        L_0x0004:
            r0 = r6
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0046
            r0 = r6
            r1 = r8
            long r0 = r0 + r1
            r1 = 1
            long r0 = r0 >>> r1
            r13 = r0
            r0 = r5
            r1 = r13
            java.lang.Object r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r12 = r0
            r0 = r11
            r1 = r12
            r2 = r10
            int r0 = r0.compare(r1, r2)
            r15 = r0
            r0 = r15
            if (r0 >= 0) goto L_0x0033
            r0 = r13
            r1 = 1
            long r0 = r0 + r1
            r6 = r0
            goto L_0x0043
        L_0x0033:
            r0 = r15
            if (r0 <= 0) goto L_0x0040
            r0 = r13
            r1 = 1
            long r0 = r0 - r1
            r8 = r0
            goto L_0x0043
        L_0x0040:
            r0 = r13
            return r0
        L_0x0043:
            goto L_0x0004
        L_0x0046:
            r0 = r6
            r1 = 1
            long r0 = r0 + r1
            long r0 = -r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.objects.ObjectBigArrays.binarySearch(java.lang.Object[][], long, long, java.lang.Object, java.util.Comparator):long");
    }

    public static <K> long binarySearch(K[][] a, K key, Comparator<K> c) {
        return binarySearch(a, 0, BigArrays.length(a), key, c);
    }

    public static <K> K[][] shuffle(K[][] a, long from, long to, Random random) {
        return (K[][]) BigArrays.shuffle(a, from, to, random);
    }

    public static <K> K[][] shuffle(K[][] a, Random random) {
        return (K[][]) BigArrays.shuffle(a, random);
    }
}
