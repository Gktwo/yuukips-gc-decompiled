package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import p001ch.qos.logback.core.FileAppender;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.Hash;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays.class */
public final class FloatBigArrays {
    public static final float[][] EMPTY_BIG_ARRAY = new float[0];
    public static final float[][] DEFAULT_EMPTY_BIG_ARRAY = new float[0];
    public static final Hash.Strategy HASH_STRATEGY = new BigArrayHashStrategy();
    private static final int QUICKSORT_NO_REC = 7;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int MEDIUM = 40;
    private static final int DIGIT_BITS = 8;
    private static final int DIGIT_MASK = 255;
    private static final int DIGITS_PER_ELEMENT = 4;
    private static final int RADIXSORT_NO_REC = 1024;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSort(float[][], long, long):void, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays.class
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
    public static void radixSort(float[][] r0, long r1, long r3) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSort(float[][], long, long):void, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSort(float[][], long, long):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSort(float[][], float[][], long, long):void, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays.class
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
    public static void radixSort(float[][] r0, float[][] r1, long r2, long r4) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSort(float[][], float[][], long, long):void, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSort(float[][], float[][], long, long):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSortIndirect(long[][], float[][], float[][], long, long, boolean):void, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays.class
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
    public static void radixSortIndirect(long[][] r0, float[][] r1, float[][] r2, long r3, long r5, boolean r7) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSortIndirect(long[][], float[][], float[][], long, long, boolean):void, file: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays.class
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.radixSortIndirect(long[][], float[][], float[][], long, long, boolean):void");
    }

    private FloatBigArrays() {
    }

    @Deprecated
    public static float get(float[][] array, long index) {
        return array[BigArrays.segment(index)][BigArrays.displacement(index)];
    }

    @Deprecated
    public static void set(float[][] array, long index, float value) {
        array[BigArrays.segment(index)][BigArrays.displacement(index)] = value;
    }

    @Deprecated
    public static void swap(float[][] array, long first, long second) {
        float t = array[BigArrays.segment(first)][BigArrays.displacement(first)];
        array[BigArrays.segment(first)][BigArrays.displacement(first)] = array[BigArrays.segment(second)][BigArrays.displacement(second)];
        array[BigArrays.segment(second)][BigArrays.displacement(second)] = t;
    }

    @Deprecated
    public static void add(float[][] array, long index, float incr) {
        float[] fArr = array[BigArrays.segment(index)];
        int displacement = BigArrays.displacement(index);
        fArr[displacement] = fArr[displacement] + incr;
    }

    @Deprecated
    public static void mul(float[][] array, long index, float factor) {
        float[] fArr = array[BigArrays.segment(index)];
        int displacement = BigArrays.displacement(index);
        fArr[displacement] = fArr[displacement] * factor;
    }

    @Deprecated
    public static void incr(float[][] array, long index) {
        float[] fArr = array[BigArrays.segment(index)];
        int displacement = BigArrays.displacement(index);
        fArr[displacement] = fArr[displacement] + 1.0f;
    }

    @Deprecated
    public static void decr(float[][] array, long index) {
        float[] fArr = array[BigArrays.segment(index)];
        int displacement = BigArrays.displacement(index);
        fArr[displacement] = fArr[displacement] - 1.0f;
    }

    @Deprecated
    public static long length(float[][] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        return BigArrays.start(length - 1) + ((long) array[length - 1].length);
    }

    @Deprecated
    public static void copy(float[][] srcArray, long srcPos, float[][] destArray, long destPos, long length) {
        BigArrays.copy(srcArray, srcPos, destArray, destPos, length);
    }

    @Deprecated
    public static void copyFromBig(float[][] srcArray, long srcPos, float[] destArray, int destPos, int length) {
        BigArrays.copyFromBig(srcArray, srcPos, destArray, destPos, length);
    }

    @Deprecated
    public static void copyToBig(float[] srcArray, int srcPos, float[][] destArray, long destPos, long length) {
        BigArrays.copyToBig(srcArray, srcPos, destArray, destPos, length);
    }

    public static float[][] newBigArray(long length) {
        if (length == 0) {
            return EMPTY_BIG_ARRAY;
        }
        BigArrays.ensureLength(length);
        int baseLength = (int) ((length + 134217727) >>> 27);
        float[][] base = new float[baseLength];
        int residual = (int) (length & 134217727);
        if (residual != 0) {
            for (int i = 0; i < baseLength - 1; i++) {
                base[i] = new float[134217728];
            }
            base[baseLength - 1] = new float[residual];
        } else {
            for (int i2 = 0; i2 < baseLength; i2++) {
                base[i2] = new float[134217728];
            }
        }
        return base;
    }

    @Deprecated
    public static float[][] wrap(float[] array) {
        return BigArrays.wrap(array);
    }

    @Deprecated
    public static float[][] ensureCapacity(float[][] array, long length) {
        return ensureCapacity(array, length, length(array));
    }

    @Deprecated
    public static float[][] forceCapacity(float[][] array, long length, long preserve) {
        return BigArrays.forceCapacity(array, length, preserve);
    }

    @Deprecated
    public static float[][] ensureCapacity(float[][] array, long length, long preserve) {
        return length > length(array) ? forceCapacity(array, length, preserve) : array;
    }

    @Deprecated
    public static float[][] grow(float[][] array, long length) {
        long oldLength = length(array);
        return length > oldLength ? grow(array, length, oldLength) : array;
    }

    @Deprecated
    public static float[][] grow(float[][] array, long length, long preserve) {
        long oldLength = length(array);
        return length > oldLength ? ensureCapacity(array, Math.max(oldLength + (oldLength >> 1), length), preserve) : array;
    }

    @Deprecated
    public static float[][] trim(float[][] array, long length) {
        BigArrays.ensureLength(length);
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

    @Deprecated
    public static float[][] setLength(float[][] array, long length) {
        return BigArrays.setLength(array, length);
    }

    @Deprecated
    public static float[][] copy(float[][] array, long offset, long length) {
        return BigArrays.copy(array, offset, length);
    }

    @Deprecated
    public static float[][] copy(float[][] array) {
        return BigArrays.copy(array);
    }

    @Deprecated
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

    @Deprecated
    public static void fill(float[][] array, long from, long to, float value) {
        BigArrays.fill(array, from, to, value);
    }

    @Deprecated
    public static boolean equals(float[][] a1, float[][] a2) {
        return BigArrays.equals(a1, a2);
    }

    @Deprecated
    public static String toString(float[][] a) {
        return BigArrays.toString(a);
    }

    @Deprecated
    public static void ensureFromTo(float[][] a, long from, long to) {
        BigArrays.ensureFromTo(length(a), from, to);
    }

    @Deprecated
    public static void ensureOffsetLength(float[][] a, long offset, long length) {
        BigArrays.ensureOffsetLength(length(a), offset, length);
    }

    @Deprecated
    public static void ensureSameLength(float[][] a, float[][] b) {
        if (length(a) != length(b)) {
            throw new IllegalArgumentException("Array size mismatch: " + length(a) + " != " + length(b));
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrays$BigArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays$BigArrayHashStrategy.class */
    private static final class BigArrayHashStrategy implements Hash.Strategy<float[][]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private BigArrayHashStrategy() {
        }

        public int hashCode(float[][] o) {
            return Arrays.deepHashCode(o);
        }

        public boolean equals(float[][] a, float[][] b) {
            return FloatBigArrays.equals(a, b);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    /* access modifiers changed from: private */
    public static void swap(float[][] x, long a, long b, long n) {
        int i = 0;
        while (((long) i) < n) {
            BigArrays.swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* access modifiers changed from: private */
    public static long med3(float[][] x, long a, long b, long c, FloatComparator comp) {
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
    private static void selectionSort(float[][] r7, long r8, long r10, p014it.unimi.dsi.fastutil.floats.FloatComparator r12) {
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
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            r2 = r7
            r3 = r15
            float r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.selectionSort(float[][], long, long, it.unimi.dsi.fastutil.floats.FloatComparator):void");
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
    public static void quickSort(float[][] r12, long r13, long r15, p014it.unimi.dsi.fastutil.floats.FloatComparator r17) {
        /*
        // Method dump skipped, instructions count: 427
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.quickSort(float[][], long, long, it.unimi.dsi.fastutil.floats.FloatComparator):void");
    }

    /* access modifiers changed from: private */
    public static long med3(float[][] x, long a, long b, long c) {
        int ab = Float.compare(BigArrays.get(x, a), BigArrays.get(x, b));
        int ac = Float.compare(BigArrays.get(x, a), BigArrays.get(x, c));
        int bc = Float.compare(BigArrays.get(x, b), BigArrays.get(x, c));
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0033 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void selectionSort(float[][] r7, long r8, long r10) {
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
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r7
            r2 = r14
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 >= 0) goto L_0x0033
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.selectionSort(float[][], long, long):void");
    }

    public static void quickSort(float[][] x, FloatComparator comp) {
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
    /* JADX WARN: Type inference failed for: r22v1, types: [float[][], long] */
    /* JADX WARN: Type inference failed for: r28v2, types: [float[][], long] */
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
    public static void quickSort(float[][] r12, long r13, long r15) {
        /*
        // Method dump skipped, instructions count: 405
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.quickSort(float[][], long, long):void");
    }

    public static void quickSort(float[][] x) {
        quickSort(x, 0, BigArrays.length(x));
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final long from;

        /* renamed from: to */
        private final long f1935to;

        /* renamed from: x */
        private final float[][] f1936x;

        public ForkJoinQuickSort(float[][] x, long from, long to) {
            this.from = from;
            this.f1935to = to;
            this.f1936x = x;
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
        /* JADX WARN: Type inference failed for: r26v1, types: [float[][], long] */
        /* JADX WARN: Type inference failed for: r32v2, types: [float[][], long] */
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.ForkJoinQuickSort.compute():void");
        }
    }

    public static void parallelQuickSort(float[][] x, long from, long to) {
        ForkJoinPool pool = getPool();
        if (to - from < FileAppender.DEFAULT_BUFFER_SIZE || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static void parallelQuickSort(float[][] x) {
        parallelQuickSort(x, 0, BigArrays.length(x));
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatBigArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final long from;

        /* renamed from: to */
        private final long f1937to;

        /* renamed from: x */
        private final float[][] f1938x;
        private final FloatComparator comp;

        public ForkJoinQuickSortComp(float[][] x, long from, long to, FloatComparator comp) {
            this.from = from;
            this.f1937to = to;
            this.f1938x = x;
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
            throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.ForkJoinQuickSortComp.compute():void");
        }
    }

    public static void parallelQuickSort(float[][] x, long from, long to, FloatComparator comp) {
        ForkJoinPool pool = getPool();
        if (to - from < FileAppender.DEFAULT_BUFFER_SIZE || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static void parallelQuickSort(float[][] x, FloatComparator comp) {
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
    public static long binarySearch(float[][] r5, long r6, long r8, float r10) {
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
            r12 = r0
            r0 = r5
            r1 = r12
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r11 = r0
            r0 = r11
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0029
            r0 = r12
            r1 = 1
            long r0 = r0 + r1
            r6 = r0
            goto L_0x003c
        L_0x0029:
            r0 = r11
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            r0 = r12
            r1 = 1
            long r0 = r0 - r1
            r8 = r0
            goto L_0x003c
        L_0x0039:
            r0 = r12
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.binarySearch(float[][], long, long, float):long");
    }

    public static long binarySearch(float[][] a, float key) {
        return binarySearch(a, 0, BigArrays.length(a), key);
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
    public static long binarySearch(float[][] r5, long r6, long r8, float r10, p014it.unimi.dsi.fastutil.floats.FloatComparator r11) {
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
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
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
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.binarySearch(float[][], long, long, float, it.unimi.dsi.fastutil.floats.FloatComparator):long");
    }

    public static long binarySearch(float[][] a, float key, FloatComparator c) {
        return binarySearch(a, 0, BigArrays.length(a), key, c);
    }

    private static final int fixFloat(float f) {
        int i = Float.floatToRawIntBits(f);
        return i >= 0 ? i : i ^ Integer.MAX_VALUE;
    }

    public static void radixSort(float[][] a) {
        radixSort(a, 0, BigArrays.length(a));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0059 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void selectionSort(float[][] r7, float[][] r8, long r9, long r11) {
        /*
            r0 = r9
            r13 = r0
        L_0x0003:
            r0 = r13
            r1 = r11
            r2 = 1
            long r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ab
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
            if (r0 >= 0) goto L_0x0062
            r0 = r7
            r1 = r17
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r7
            r2 = r15
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 < 0) goto L_0x0055
            r0 = r7
            r1 = r17
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r7
            r2 = r15
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0059
            r0 = r8
            r1 = r17
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r8
            r2 = r15
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 >= 0) goto L_0x0059
        L_0x0055:
            r0 = r17
            r15 = r0
        L_0x0059:
            r0 = r17
            r1 = 1
            long r0 = r0 + r1
            r17 = r0
            goto L_0x0017
        L_0x0062:
            r0 = r15
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00a2
            r0 = r7
            r1 = r13
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r17 = r0
            r0 = r7
            r1 = r13
            r2 = r7
            r3 = r15
            float r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            r0 = r7
            r1 = r15
            r2 = r17
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            r0 = r8
            r1 = r13
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r17 = r0
            r0 = r8
            r1 = r13
            r2 = r8
            r3 = r15
            float r2 = p014it.unimi.dsi.fastutil.BigArrays.get(r2, r3)
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            r0 = r8
            r1 = r15
            r2 = r17
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
        L_0x00a2:
            r0 = r13
            r1 = 1
            long r0 = r0 + r1
            r13 = r0
            goto L_0x0003
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.selectionSort(float[][], float[][], long, long):void");
    }

    public static void radixSort(float[][] a, float[][] b) {
        radixSort(a, b, 0, BigArrays.length(a));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    /* JADX WARN: Type inference failed for: r1v16, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void insertionSortIndirect(long[][] r7, float[][] r8, float[][] r9, long r10, long r12) {
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
            if (r0 >= 0) goto L_0x0093
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
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r8
            r2 = r20
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 < 0) goto L_0x005c
            r0 = r8
            r1 = r16
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r8
            r2 = r20
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0088
            r0 = r9
            r1 = r16
            float r0 = p014it.unimi.dsi.fastutil.BigArrays.get(r0, r1)
            r1 = r9
            r2 = r20
            float r1 = p014it.unimi.dsi.fastutil.BigArrays.get(r1, r2)
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 >= 0) goto L_0x0088
        L_0x005c:
            r0 = r7
            r1 = r18
            r2 = r20
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            r0 = r10
            r1 = r18
            r2 = 1
            long r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0076
            r0 = r18
            r1 = 1
            long r0 = r0 - r1
            r18 = r0
            goto L_0x0088
        L_0x0076:
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
        L_0x0088:
            r0 = r7
            r1 = r18
            r2 = r16
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0003
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatBigArrays.insertionSortIndirect(long[][], float[][], float[][], long, long):void");
    }

    public static void radixSortIndirect(long[][] perm, float[][] a, float[][] b, boolean stable) {
        ensureSameLength(a, b);
        radixSortIndirect(perm, a, b, 0, BigArrays.length(a), stable);
    }

    public static float[][] shuffle(float[][] a, long from, long to, Random random) {
        return BigArrays.shuffle(a, from, to, random);
    }

    public static float[][] shuffle(float[][] a, Random random) {
        return BigArrays.shuffle(a, random);
    }
}
