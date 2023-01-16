package p014it.unimi.dsi.fastutil.floats;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;
import p014it.unimi.dsi.fastutil.Arrays;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrays.class */
public final class FloatArrays {
    private static final int QUICKSORT_NO_REC = 16;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int QUICKSORT_MEDIAN_OF_9 = 128;
    private static final int MERGESORT_NO_REC = 16;
    private static final int DIGIT_BITS = 8;
    private static final int DIGIT_MASK = 255;
    private static final int DIGITS_PER_ELEMENT = 4;
    private static final int RADIXSORT_NO_REC = 1024;
    private static final int RADIXSORT_NO_REC_SMALL = 64;
    private static final int PARALLEL_RADIXSORT_NO_FORK = 1024;
    static final int RADIX_SORT_MIN_THRESHOLD = 2000;
    public static final float[] EMPTY_ARRAY = new float[0];
    public static final float[] DEFAULT_EMPTY_ARRAY = new float[0];
    protected static final Segment POISON_PILL = new Segment(-1, -1, -1);
    public static final Hash.Strategy<float[]> HASH_STRATEGY = new ArrayHashStrategy();

    private FloatArrays() {
    }

    public static float[] forceCapacity(float[] array, int length, int preserve) {
        float[] t = new float[length];
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static float[] ensureCapacity(float[] array, int length) {
        return ensureCapacity(array, length, array.length);
    }

    public static float[] ensureCapacity(float[] array, int length, int preserve) {
        return length > array.length ? forceCapacity(array, length, preserve) : array;
    }

    public static float[] grow(float[] array, int length) {
        return grow(array, length, array.length);
    }

    public static float[] grow(float[] array, int length, int preserve) {
        if (length <= array.length) {
            return array;
        }
        float[] t = new float[(int) Math.max(Math.min(((long) array.length) + ((long) (array.length >> 1)), 2147483639L), (long) length)];
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static float[] trim(float[] array, int length) {
        if (length >= array.length) {
            return array;
        }
        float[] t = length == 0 ? EMPTY_ARRAY : new float[length];
        System.arraycopy(array, 0, t, 0, length);
        return t;
    }

    public static float[] setLength(float[] array, int length) {
        return length == array.length ? array : length < array.length ? trim(array, length) : ensureCapacity(array, length);
    }

    public static float[] copy(float[] array, int offset, int length) {
        ensureOffsetLength(array, offset, length);
        float[] a = length == 0 ? EMPTY_ARRAY : new float[length];
        System.arraycopy(array, offset, a, 0, length);
        return a;
    }

    public static float[] copy(float[] array) {
        return (float[]) array.clone();
    }

    @Deprecated
    public static void fill(float[] array, float value) {
        int i = array.length;
        while (true) {
            i--;
            if (i != 0) {
                array[i] = value;
            } else {
                return;
            }
        }
    }

    @Deprecated
    public static void fill(float[] array, int from, int to, float value) {
        ensureFromTo(array, from, to);
        if (from == 0) {
            while (true) {
                to--;
                if (to != 0) {
                    array[to] = value;
                } else {
                    return;
                }
            }
        } else {
            for (int i = from; i < to; i++) {
                array[i] = value;
            }
        }
    }

    @Deprecated
    public static boolean equals(float[] a1, float[] a2) {
        int i = a1.length;
        if (i != a2.length) {
            return false;
        }
        do {
            i--;
            if (i == 0) {
                return true;
            }
        } while (Float.floatToIntBits(a1[i]) == Float.floatToIntBits(a2[i]));
        return false;
    }

    public static void ensureFromTo(float[] a, int from, int to) {
        Arrays.ensureFromTo(a.length, from, to);
    }

    public static void ensureOffsetLength(float[] a, int offset, int length) {
        Arrays.ensureOffsetLength(a.length, offset, length);
    }

    public static void ensureSameLength(float[] a, float[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array size mismatch: " + a.length + " != " + b.length);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    public static void swap(float[] x, int a, int b) {
        float t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void swap(float[] x, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* access modifiers changed from: private */
    public static int med3(float[] x, int a, int b, int c, FloatComparator comp) {
        int ab = comp.compare(x[a], x[b]);
        int ac = comp.compare(x[a], x[c]);
        int bc = comp.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void selectionSort(float[] a, int from, int to, FloatComparator comp) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (comp.compare(a[j], a[m]) < 0) {
                    m = j;
                }
            }
            if (m != i) {
                float u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static void insertionSort(float[] a, int from, int to, FloatComparator comp) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                float t = a[i];
                int j = i;
                float u = a[j - 1];
                while (true) {
                    if (comp.compare(t, u) < 0) {
                        a[j] = u;
                        if (from == j - 1) {
                            j--;
                            break;
                        } else {
                            j--;
                            u = a[j - 1];
                        }
                    }
                }
                a[j] = t;
            } else {
                return;
            }
        }
    }

    public static void quickSort(float[] x, int from, int to, FloatComparator comp) {
        int comparison;
        int comparison2;
        int len = to - from;
        if (len < 16) {
            selectionSort(x, from, to, comp);
            return;
        }
        int m = from + (len / 2);
        int l = from;
        int n = to - 1;
        if (len > 128) {
            int s = len / 8;
            l = med3(x, l, l + s, l + (2 * s), comp);
            m = med3(x, m - s, m, m + s, comp);
            n = med3(x, n - (2 * s), n - s, n, comp);
        }
        float v = x[med3(x, l, m, n, comp)];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = comp.compare(x[b], v)) > 0) {
                while (c >= b && (comparison = comp.compare(x[c], v)) >= 0) {
                    if (comparison == 0) {
                        d--;
                        swap(x, c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                b++;
                c--;
                swap(x, b, c);
            } else {
                if (comparison2 == 0) {
                    a++;
                    swap(x, a, b);
                }
                b++;
            }
        }
        int s2 = Math.min(a - from, b - a);
        swap(x, from, b - s2, s2);
        int s3 = Math.min(d - c, (to - d) - 1);
        swap(x, b, to - s3, s3);
        int s4 = b - a;
        if (s4 > 1) {
            quickSort(x, from, from + s4, comp);
        }
        int s5 = d - c;
        if (s5 > 1) {
            quickSort(x, to - s5, to, comp);
        }
    }

    public static void quickSort(float[] x, FloatComparator comp) {
        quickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1930to;

        /* renamed from: x */
        private final float[] f1931x;
        private final FloatComparator comp;

        public ForkJoinQuickSortComp(float[] x, int from, int to, FloatComparator comp) {
            this.from = from;
            this.f1930to = to;
            this.f1931x = x;
            this.comp = comp;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            float[] x = this.f1931x;
            int len = this.f1930to - this.from;
            if (len < 8192) {
                FloatArrays.quickSort(x, this.from, this.f1930to, this.comp);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1930to - 1;
            int s = len / 8;
            float v = x[FloatArrays.med3(x, FloatArrays.med3(x, l, l + s, l + (2 * s), this.comp), FloatArrays.med3(x, m - s, m, m + s, this.comp), FloatArrays.med3(x, n - (2 * s), n - s, n, this.comp), this.comp)];
            int a = this.from;
            int b = a;
            int c = this.f1930to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = this.comp.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = this.comp.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            FloatArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    FloatArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        FloatArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            FloatArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f1930to - d) - 1);
            FloatArrays.swap(x, b, this.f1930to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp), new ForkJoinQuickSortComp(x, this.f1930to - t, this.f1930to, this.comp));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.f1930to - t, this.f1930to, this.comp)});
            }
        }
    }

    public static void parallelQuickSort(float[] x, int from, int to, FloatComparator comp) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static void parallelQuickSort(float[] x, FloatComparator comp) {
        parallelQuickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: private */
    public static int med3(float[] x, int a, int b, int c) {
        int ab = Float.compare(x[a], x[b]);
        int ac = Float.compare(x[a], x[c]);
        int bc = Float.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void selectionSort(float[] a, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (Float.compare(a[j], a[m]) < 0) {
                    m = j;
                }
            }
            if (m != i) {
                float u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static void insertionSort(float[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                float t = a[i];
                int j = i;
                float u = a[j - 1];
                while (true) {
                    if (Float.compare(t, u) < 0) {
                        a[j] = u;
                        if (from == j - 1) {
                            j--;
                            break;
                        } else {
                            j--;
                            u = a[j - 1];
                        }
                    }
                }
                a[j] = t;
            } else {
                return;
            }
        }
    }

    public static void quickSort(float[] x, int from, int to) {
        int comparison;
        int comparison2;
        int len = to - from;
        if (len < 16) {
            selectionSort(x, from, to);
            return;
        }
        int m = from + (len / 2);
        int l = from;
        int n = to - 1;
        if (len > 128) {
            int s = len / 8;
            l = med3(x, l, l + s, l + (2 * s));
            m = med3(x, m - s, m, m + s);
            n = med3(x, n - (2 * s), n - s, n);
        }
        float v = x[med3(x, l, m, n)];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = Float.compare(x[b], v)) > 0) {
                while (c >= b && (comparison = Float.compare(x[c], v)) >= 0) {
                    if (comparison == 0) {
                        d--;
                        swap(x, c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                b++;
                c--;
                swap(x, b, c);
            } else {
                if (comparison2 == 0) {
                    a++;
                    swap(x, a, b);
                }
                b++;
            }
        }
        int s2 = Math.min(a - from, b - a);
        swap(x, from, b - s2, s2);
        int s3 = Math.min(d - c, (to - d) - 1);
        swap(x, b, to - s3, s3);
        int s4 = b - a;
        if (s4 > 1) {
            quickSort(x, from, from + s4);
        }
        int s5 = d - c;
        if (s5 > 1) {
            quickSort(x, to - s5, to);
        }
    }

    public static void quickSort(float[] x) {
        quickSort(x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1925to;

        /* renamed from: x */
        private final float[] f1926x;

        public ForkJoinQuickSort(float[] x, int from, int to) {
            this.from = from;
            this.f1925to = to;
            this.f1926x = x;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            float[] x = this.f1926x;
            int len = this.f1925to - this.from;
            if (len < 8192) {
                FloatArrays.quickSort(x, this.from, this.f1925to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1925to - 1;
            int s = len / 8;
            float v = x[FloatArrays.med3(x, FloatArrays.med3(x, l, l + s, l + (2 * s)), FloatArrays.med3(x, m - s, m, m + s), FloatArrays.med3(x, n - (2 * s), n - s, n))];
            int a = this.from;
            int b = a;
            int c = this.f1925to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = Float.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = Float.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            FloatArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    FloatArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        FloatArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            FloatArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f1925to - d) - 1);
            FloatArrays.swap(x, b, this.f1925to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSort(x, this.from, this.from + s4), new ForkJoinQuickSort(x, this.f1925to - t, this.f1925to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.f1925to - t, this.f1925to)});
            }
        }
    }

    public static void parallelQuickSort(float[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static void parallelQuickSort(float[] x) {
        parallelQuickSort(x, 0, x.length);
    }

    /* access modifiers changed from: private */
    public static int med3Indirect(int[] perm, float[] x, int a, int b, int c) {
        float aa = x[perm[a]];
        float bb = x[perm[b]];
        float cc = x[perm[c]];
        int ab = Float.compare(aa, bb);
        int ac = Float.compare(aa, cc);
        int bc = Float.compare(bb, cc);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void insertionSortIndirect(int[] perm, float[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                int t = perm[i];
                int j = i;
                int u = perm[j - 1];
                while (true) {
                    if (Float.compare(a[t], a[u]) < 0) {
                        perm[j] = u;
                        if (from == j - 1) {
                            j--;
                            break;
                        } else {
                            j--;
                            u = perm[j - 1];
                        }
                    }
                }
                perm[j] = t;
            } else {
                return;
            }
        }
    }

    public static void quickSortIndirect(int[] perm, float[] x, int from, int to) {
        int comparison;
        int comparison2;
        int len = to - from;
        if (len < 16) {
            insertionSortIndirect(perm, x, from, to);
            return;
        }
        int m = from + (len / 2);
        int l = from;
        int n = to - 1;
        if (len > 128) {
            int s = len / 8;
            l = med3Indirect(perm, x, l, l + s, l + (2 * s));
            m = med3Indirect(perm, x, m - s, m, m + s);
            n = med3Indirect(perm, x, n - (2 * s), n - s, n);
        }
        float v = x[perm[med3Indirect(perm, x, l, m, n)]];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = Float.compare(x[perm[b]], v)) > 0) {
                while (c >= b && (comparison = Float.compare(x[perm[c]], v)) >= 0) {
                    if (comparison == 0) {
                        d--;
                        IntArrays.swap(perm, c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                b++;
                c--;
                IntArrays.swap(perm, b, c);
            } else {
                if (comparison2 == 0) {
                    a++;
                    IntArrays.swap(perm, a, b);
                }
                b++;
            }
        }
        int s2 = Math.min(a - from, b - a);
        IntArrays.swap(perm, from, b - s2, s2);
        int s3 = Math.min(d - c, (to - d) - 1);
        IntArrays.swap(perm, b, to - s3, s3);
        int s4 = b - a;
        if (s4 > 1) {
            quickSortIndirect(perm, x, from, from + s4);
        }
        int s5 = d - c;
        if (s5 > 1) {
            quickSortIndirect(perm, x, to - s5, to);
        }
    }

    public static void quickSortIndirect(int[] perm, float[] x) {
        quickSortIndirect(perm, x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrays$ForkJoinQuickSortIndirect */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrays$ForkJoinQuickSortIndirect.class */
    public static class ForkJoinQuickSortIndirect extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1932to;
        private final int[] perm;

        /* renamed from: x */
        private final float[] f1933x;

        public ForkJoinQuickSortIndirect(int[] perm, float[] x, int from, int to) {
            this.from = from;
            this.f1932to = to;
            this.f1933x = x;
            this.perm = perm;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            float[] x = this.f1933x;
            int len = this.f1932to - this.from;
            if (len < 8192) {
                FloatArrays.quickSortIndirect(this.perm, x, this.from, this.f1932to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1932to - 1;
            int s = len / 8;
            float v = x[this.perm[FloatArrays.med3Indirect(this.perm, x, FloatArrays.med3Indirect(this.perm, x, l, l + s, l + (2 * s)), FloatArrays.med3Indirect(this.perm, x, m - s, m, m + s), FloatArrays.med3Indirect(this.perm, x, n - (2 * s), n - s, n))]];
            int a = this.from;
            int b = a;
            int c = this.f1932to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = Float.compare(x[this.perm[b]], v)) > 0) {
                    while (c >= b && (comparison = Float.compare(x[this.perm[c]], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            IntArrays.swap(this.perm, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    IntArrays.swap(this.perm, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        IntArrays.swap(this.perm, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            IntArrays.swap(this.perm, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f1932to - d) - 1);
            IntArrays.swap(this.perm, b, this.f1932to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4), new ForkJoinQuickSortIndirect(this.perm, x, this.f1932to - t, this.f1932to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.f1932to - t, this.f1932to)});
            }
        }
    }

    public static void parallelQuickSortIndirect(int[] perm, float[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSortIndirect(perm, x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSortIndirect(perm, x, from, to));
        }
    }

    public static void parallelQuickSortIndirect(int[] perm, float[] x) {
        parallelQuickSortIndirect(perm, x, 0, x.length);
    }

    public static void stabilize(int[] perm, float[] x, int from, int to) {
        int curr = from;
        for (int i = from + 1; i < to; i++) {
            if (x[perm[i]] != x[perm[curr]]) {
                if (i - curr > 1) {
                    IntArrays.parallelQuickSort(perm, curr, i);
                }
                curr = i;
            }
        }
        if (to - curr > 1) {
            IntArrays.parallelQuickSort(perm, curr, to);
        }
    }

    public static void stabilize(int[] perm, float[] x) {
        stabilize(perm, x, 0, perm.length);
    }

    /* access modifiers changed from: private */
    public static int med3(float[] x, float[] y, int a, int b, int c) {
        int t = Float.compare(x[a], x[b]);
        int ab = t == 0 ? Float.compare(y[a], y[b]) : t;
        int t2 = Float.compare(x[a], x[c]);
        int ac = t2 == 0 ? Float.compare(y[a], y[c]) : t2;
        int t3 = Float.compare(x[b], x[c]);
        int bc = t3 == 0 ? Float.compare(y[b], y[c]) : t3;
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* access modifiers changed from: private */
    public static void swap(float[] x, float[] y, int a, int b) {
        float t = x[a];
        float u = y[a];
        x[a] = x[b];
        y[a] = y[b];
        x[b] = t;
        y[b] = u;
    }

    /* access modifiers changed from: private */
    public static void swap(float[] x, float[] y, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, y, a, b);
            i++;
            a++;
            b++;
        }
    }

    private static void selectionSort(float[] a, float[] b, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                int u = Float.compare(a[j], a[m]);
                if (u < 0 || (u == 0 && Float.compare(b[j], b[m]) < 0)) {
                    m = j;
                }
            }
            if (m != i) {
                float t = a[i];
                a[i] = a[m];
                a[m] = t;
                float t2 = b[i];
                b[i] = b[m];
                b[m] = t2;
            }
        }
    }

    public static void quickSort(float[] x, float[] y, int from, int to) {
        int len = to - from;
        if (len < 16) {
            selectionSort(x, y, from, to);
            return;
        }
        int m = from + (len / 2);
        int l = from;
        int n = to - 1;
        if (len > 128) {
            int s = len / 8;
            l = med3(x, y, l, l + s, l + (2 * s));
            m = med3(x, y, m - s, m, m + s);
            n = med3(x, y, n - (2 * s), n - s, n);
        }
        int m2 = med3(x, y, l, m, n);
        float v = x[m2];
        float w = y[m2];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b <= c) {
                int t = Float.compare(x[b], v);
                int comparison = t == 0 ? Float.compare(y[b], w) : t;
                if (comparison <= 0) {
                    if (comparison == 0) {
                        a++;
                        swap(x, y, a, b);
                    }
                    b++;
                }
            }
            while (c >= b) {
                int t2 = Float.compare(x[c], v);
                int comparison2 = t2 == 0 ? Float.compare(y[c], w) : t2;
                if (comparison2 < 0) {
                    break;
                }
                if (comparison2 == 0) {
                    d--;
                    swap(x, y, c, d);
                }
                c--;
            }
            if (b > c) {
                break;
            }
            b++;
            c--;
            swap(x, y, b, c);
        }
        int s2 = Math.min(a - from, b - a);
        swap(x, y, from, b - s2, s2);
        int s3 = Math.min(d - c, (to - d) - 1);
        swap(x, y, b, to - s3, s3);
        int s4 = b - a;
        if (s4 > 1) {
            quickSort(x, y, from, from + s4);
        }
        int s5 = d - c;
        if (s5 > 1) {
            quickSort(x, y, to - s5, to);
        }
    }

    public static void quickSort(float[] x, float[] y) {
        ensureSameLength(x, y);
        quickSort(x, y, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrays$ForkJoinQuickSort2 */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrays$ForkJoinQuickSort2.class */
    public static class ForkJoinQuickSort2 extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1927to;

        /* renamed from: x */
        private final float[] f1928x;

        /* renamed from: y */
        private final float[] f1929y;

        public ForkJoinQuickSort2(float[] x, float[] y, int from, int to) {
            this.from = from;
            this.f1927to = to;
            this.f1928x = x;
            this.f1929y = y;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            float[] x = this.f1928x;
            float[] y = this.f1929y;
            int len = this.f1927to - this.from;
            if (len < 8192) {
                FloatArrays.quickSort(x, y, this.from, this.f1927to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1927to - 1;
            int s = len / 8;
            int m2 = FloatArrays.med3(x, y, FloatArrays.med3(x, y, l, l + s, l + (2 * s)), FloatArrays.med3(x, y, m - s, m, m + s), FloatArrays.med3(x, y, n - (2 * s), n - s, n));
            float v = x[m2];
            float w = y[m2];
            int a = this.from;
            int b = a;
            int c = this.f1927to - 1;
            int d = c;
            while (true) {
                if (b <= c) {
                    int t = Float.compare(x[b], v);
                    int comparison = t == 0 ? Float.compare(y[b], w) : t;
                    if (comparison <= 0) {
                        if (comparison == 0) {
                            a++;
                            FloatArrays.swap(x, y, a, b);
                        }
                        b++;
                    }
                }
                while (c >= b) {
                    int t2 = Float.compare(x[c], v);
                    int comparison2 = t2 == 0 ? Float.compare(y[c], w) : t2;
                    if (comparison2 < 0) {
                        break;
                    }
                    if (comparison2 == 0) {
                        d--;
                        FloatArrays.swap(x, y, c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                b++;
                c--;
                FloatArrays.swap(x, y, b, c);
            }
            int s2 = Math.min(a - this.from, b - a);
            FloatArrays.swap(x, y, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f1927to - d) - 1);
            FloatArrays.swap(x, y, b, this.f1927to - s3, s3);
            int s4 = b - a;
            int t3 = d - c;
            if (s4 > 1 && t3 > 1) {
                invokeAll(new ForkJoinQuickSort2(x, y, this.from, this.from + s4), new ForkJoinQuickSort2(x, y, this.f1927to - t3, this.f1927to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.f1927to - t3, this.f1927to)});
            }
        }
    }

    public static void parallelQuickSort(float[] x, float[] y, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, y, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort2(x, y, from, to));
        }
    }

    public static void parallelQuickSort(float[] x, float[] y) {
        ensureSameLength(x, y);
        parallelQuickSort(x, y, 0, x.length);
    }

    public static void unstableSort(float[] a, int from, int to) {
        if (to - from >= 2000) {
            radixSort(a, from, to);
        } else {
            quickSort(a, from, to);
        }
    }

    public static void unstableSort(float[] a) {
        unstableSort(a, 0, a.length);
    }

    public static void unstableSort(float[] a, int from, int to, FloatComparator comp) {
        quickSort(a, from, to, comp);
    }

    public static void unstableSort(float[] a, FloatComparator comp) {
        unstableSort(a, 0, a.length, comp);
    }

    public static void mergeSort(float[] a, int from, int to, float[] supp) {
        int len = to - from;
        if (len < 16) {
            insertionSort(a, from, to);
            return;
        }
        if (supp == null) {
            supp = java.util.Arrays.copyOf(a, to);
        }
        int mid = (from + to) >>> 1;
        mergeSort(supp, from, mid, a);
        mergeSort(supp, mid, to, a);
        if (Float.compare(supp[mid - 1], supp[mid]) <= 0) {
            System.arraycopy(supp, from, a, from, len);
            return;
        }
        int p = from;
        int q = mid;
        for (int i = from; i < to; i++) {
            if (q >= to || (p < mid && Float.compare(supp[p], supp[q]) <= 0)) {
                p++;
                a[i] = supp[p];
            } else {
                q++;
                a[i] = supp[q];
            }
        }
    }

    public static void mergeSort(float[] a, int from, int to) {
        mergeSort(a, from, to, (float[]) null);
    }

    public static void mergeSort(float[] a) {
        mergeSort(a, 0, a.length);
    }

    public static void mergeSort(float[] a, int from, int to, FloatComparator comp, float[] supp) {
        int len = to - from;
        if (len < 16) {
            insertionSort(a, from, to, comp);
            return;
        }
        if (supp == null) {
            supp = java.util.Arrays.copyOf(a, to);
        }
        int mid = (from + to) >>> 1;
        mergeSort(supp, from, mid, comp, a);
        mergeSort(supp, mid, to, comp, a);
        if (comp.compare(supp[mid - 1], supp[mid]) <= 0) {
            System.arraycopy(supp, from, a, from, len);
            return;
        }
        int p = from;
        int q = mid;
        for (int i = from; i < to; i++) {
            if (q >= to || (p < mid && comp.compare(supp[p], supp[q]) <= 0)) {
                p++;
                a[i] = supp[p];
            } else {
                q++;
                a[i] = supp[q];
            }
        }
    }

    public static void mergeSort(float[] a, int from, int to, FloatComparator comp) {
        mergeSort(a, from, to, comp, null);
    }

    public static void mergeSort(float[] a, FloatComparator comp) {
        mergeSort(a, 0, a.length, comp);
    }

    public static void stableSort(float[] a, int from, int to) {
        mergeSort(a, from, to);
    }

    public static void stableSort(float[] a) {
        stableSort(a, 0, a.length);
    }

    public static void stableSort(float[] a, int from, int to, FloatComparator comp) {
        mergeSort(a, from, to, comp);
    }

    public static void stableSort(float[] a, FloatComparator comp) {
        stableSort(a, 0, a.length, comp);
    }

    public static int binarySearch(float[] a, int from, int to, float key) {
        int to2 = to - 1;
        while (from <= to2) {
            int mid = (from + to2) >>> 1;
            float midVal = a[mid];
            if (midVal < key) {
                from = mid + 1;
            } else if (midVal <= key) {
                return mid;
            } else {
                to2 = mid - 1;
            }
        }
        return -(from + 1);
    }

    public static int binarySearch(float[] a, float key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(float[] a, int from, int to, float key, FloatComparator c) {
        int to2 = to - 1;
        while (from <= to2) {
            int mid = (from + to2) >>> 1;
            int cmp = c.compare(a[mid], key);
            if (cmp < 0) {
                from = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                to2 = mid - 1;
            }
        }
        return -(from + 1);
    }

    public static int binarySearch(float[] a, float key, FloatComparator c) {
        return binarySearch(a, 0, a.length, key, c);
    }

    private static final int fixFloat(float f) {
        int i = Float.floatToIntBits(f);
        return i >= 0 ? i : i ^ Integer.MAX_VALUE;
    }

    public static void radixSort(float[] a) {
        radixSort(a, 0, a.length);
    }

    public static void radixSort(float[] a, int from, int to) {
        if (to - from < 1024) {
            quickSort(a, from, to);
            return;
        }
        int[] offsetStack = new int[ActivityInfoOuterClass.ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER];
        int[] lengthStack = new int[ActivityInfoOuterClass.ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER];
        int[] levelStack = new int[ActivityInfoOuterClass.ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER];
        offsetStack[0] = from;
        lengthStack[0] = to - from;
        int stackPos = 0 + 1;
        levelStack[0] = 0;
        int[] count = new int[256];
        int[] pos = new int[256];
        while (stackPos > 0) {
            stackPos--;
            int first = offsetStack[stackPos];
            int length = lengthStack[stackPos];
            int level = levelStack[stackPos];
            int signMask = level % 4 == 0 ? 128 : 0;
            int shift = (3 - (level % 4)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int fixFloat = ((fixFloat(a[i]) >>> shift) & 255) ^ signMask;
                count[fixFloat] = count[fixFloat] + 1;
            }
            int lastUsed = -1;
            int p = first;
            for (int i2 = 0; i2 < 256; i2++) {
                if (count[i2] != 0) {
                    lastUsed = i2;
                }
                int i3 = p + count[i2];
                p = i3;
                pos[i2] = i3;
            }
            int end = (first + length) - count[lastUsed];
            int i4 = first;
            while (i4 <= end) {
                float t = a[i4];
                int c = ((fixFloat(t) >>> shift) & 255) ^ signMask;
                if (i4 < end) {
                    while (true) {
                        int d = pos[c] - 1;
                        pos[c] = d;
                        if (d <= i4) {
                            break;
                        }
                        t = a[d];
                        a[d] = t;
                        c = ((fixFloat(t) >>> shift) & 255) ^ signMask;
                    }
                    a[i4] = t;
                }
                if (level < 3 && count[c] > 1) {
                    if (count[c] < 1024) {
                        quickSort(a, i4, i4 + count[c]);
                    } else {
                        offsetStack[stackPos] = i4;
                        lengthStack[stackPos] = count[c];
                        stackPos++;
                        levelStack[stackPos] = level + 1;
                    }
                }
                i4 += count[c];
                count[c] = 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrays$Segment */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrays$Segment.class */
    public static final class Segment {
        protected final int offset;
        protected final int length;
        protected final int level;

        protected Segment(int offset, int length, int level) {
            this.offset = offset;
            this.length = length;
            this.level = level;
        }

        public String toString() {
            return "Segment [offset=" + this.offset + ", length=" + this.length + ", level=" + this.level + "]";
        }
    }

    public static void parallelRadixSort(float[] a, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 1024 || pool.getParallelism() == 1) {
            quickSort(a, from, to);
            return;
        }
        LinkedBlockingQueue<Segment> queue = new LinkedBlockingQueue<>();
        queue.add(new Segment(from, to - from, 0));
        AtomicInteger queueSize = new AtomicInteger(1);
        int numberOfThreads = pool.getParallelism();
        ExecutorCompletionService<Void> executorCompletionService = new ExecutorCompletionService<>(pool);
        int j = numberOfThreads;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            executorCompletionService.submit(() -> {
                int[] count = new int[256];
                int[] pos = new int[256];
                while (true) {
                    if (queueSize.get() == 0) {
                        int i = numberOfThreads;
                        while (true) {
                            i--;
                            if (i == 0) {
                                break;
                            }
                            queue.add(POISON_PILL);
                        }
                    }
                    Segment segment = (Segment) queue.take();
                    if (segment == POISON_PILL) {
                        return null;
                    }
                    int first = segment.offset;
                    int length = segment.length;
                    int level = segment.level;
                    int signMask = level % 4 == 0 ? 128 : 0;
                    int shift = (3 - (level % 4)) * 8;
                    int i2 = first + length;
                    while (true) {
                        i2--;
                        if (i2 == first) {
                            break;
                        }
                        int fixFloat = ((fixFloat(a[i2]) >>> shift) & 255) ^ signMask;
                        count[fixFloat] = count[fixFloat] + 1;
                    }
                    int lastUsed = -1;
                    int p = first;
                    for (int i3 = 0; i3 < 256; i3++) {
                        if (count[i3] != 0) {
                            lastUsed = i3;
                        }
                        int i4 = p + count[i3];
                        p = i4;
                        pos[i3] = i4;
                    }
                    int end = (first + length) - count[lastUsed];
                    int i5 = first;
                    while (i5 <= end) {
                        float t = a[i5];
                        int c = ((fixFloat(t) >>> shift) & 255) ^ signMask;
                        if (i5 < end) {
                            while (true) {
                                int d = pos[c] - 1;
                                pos[c] = d;
                                if (d <= i5) {
                                    break;
                                }
                                t = a[d];
                                a[d] = t;
                                c = ((fixFloat(t) >>> shift) & 255) ^ signMask;
                            }
                            a[i5] = t;
                        }
                        if (level < 3 && count[c] > 1) {
                            if (count[c] < 1024) {
                                quickSort(a, i5, i5 + count[c]);
                            } else {
                                queueSize.incrementAndGet();
                                queue.add(new Segment(i5, count[c], level + 1));
                            }
                        }
                        i5 += count[c];
                        count[c] = 0;
                    }
                    queueSize.decrementAndGet();
                }
            });
        }
        Throwable problem = null;
        int i = numberOfThreads;
        while (true) {
            i--;
            if (i == 0) {
                break;
            }
            try {
                executorCompletionService.take().get();
            } catch (Exception e) {
                problem = e.getCause();
            }
        }
        if (problem == null) {
            return;
        }
        if (!(problem instanceof RuntimeException)) {
            throw new RuntimeException(problem);
        }
    }

    public static void parallelRadixSort(float[] a) {
        parallelRadixSort(a, 0, a.length);
    }

    public static void radixSortIndirect(int[] perm, float[] a, boolean stable) {
        radixSortIndirect(perm, a, 0, perm.length, stable);
    }

    public static void radixSortIndirect(int[] perm, float[] a, int from, int to, boolean stable) {
        if (to - from < 1024) {
            quickSortIndirect(perm, a, from, to);
            if (stable) {
                stabilize(perm, a, from, to);
                return;
            }
            return;
        }
        int[] offsetStack = new int[ActivityInfoOuterClass.ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER];
        int[] lengthStack = new int[ActivityInfoOuterClass.ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER];
        int[] levelStack = new int[ActivityInfoOuterClass.ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER];
        offsetStack[0] = from;
        lengthStack[0] = to - from;
        int stackPos = 0 + 1;
        levelStack[0] = 0;
        int[] count = new int[256];
        int[] pos = new int[256];
        int[] support = stable ? new int[perm.length] : null;
        while (stackPos > 0) {
            stackPos--;
            int first = offsetStack[stackPos];
            int length = lengthStack[stackPos];
            int level = levelStack[stackPos];
            int signMask = level % 4 == 0 ? 128 : 0;
            int shift = (3 - (level % 4)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int fixFloat = ((fixFloat(a[perm[i]]) >>> shift) & 255) ^ signMask;
                count[fixFloat] = count[fixFloat] + 1;
            }
            int lastUsed = -1;
            int p = stable ? 0 : first;
            for (int i2 = 0; i2 < 256; i2++) {
                if (count[i2] != 0) {
                    lastUsed = i2;
                }
                int i3 = p + count[i2];
                p = i3;
                pos[i2] = i3;
            }
            if (stable) {
                int i4 = first + length;
                while (true) {
                    i4--;
                    if (i4 == first) {
                        break;
                    }
                    int fixFloat2 = ((fixFloat(a[perm[i4]]) >>> shift) & 255) ^ signMask;
                    int i5 = pos[fixFloat2] - 1;
                    pos[fixFloat2] = i5;
                    support[i5] = perm[i4];
                }
                System.arraycopy(support, 0, perm, first, length);
                int p2 = first;
                for (int i6 = 0; i6 <= lastUsed; i6++) {
                    if (level < 3 && count[i6] > 1) {
                        if (count[i6] < 1024) {
                            quickSortIndirect(perm, a, p2, p2 + count[i6]);
                            if (stable) {
                                stabilize(perm, a, p2, p2 + count[i6]);
                            }
                        } else {
                            offsetStack[stackPos] = p2;
                            lengthStack[stackPos] = count[i6];
                            stackPos++;
                            levelStack[stackPos] = level + 1;
                        }
                    }
                    p2 += count[i6];
                }
                java.util.Arrays.fill(count, 0);
            } else {
                int end = (first + length) - count[lastUsed];
                int i7 = first;
                while (i7 <= end) {
                    int t = perm[i7];
                    int c = ((fixFloat(a[t]) >>> shift) & 255) ^ signMask;
                    if (i7 < end) {
                        while (true) {
                            int d = pos[c] - 1;
                            pos[c] = d;
                            if (d <= i7) {
                                break;
                            }
                            t = perm[d];
                            perm[d] = t;
                            c = ((fixFloat(a[t]) >>> shift) & 255) ^ signMask;
                        }
                        perm[i7] = t;
                    }
                    if (level < 3 && count[c] > 1) {
                        if (count[c] < 1024) {
                            quickSortIndirect(perm, a, i7, i7 + count[c]);
                            if (stable) {
                                stabilize(perm, a, i7, i7 + count[c]);
                            }
                        } else {
                            offsetStack[stackPos] = i7;
                            lengthStack[stackPos] = count[c];
                            stackPos++;
                            levelStack[stackPos] = level + 1;
                        }
                    }
                    i7 += count[c];
                    count[c] = 0;
                }
            }
        }
    }

    public static void parallelRadixSortIndirect(int[] perm, float[] a, int from, int to, boolean stable) {
        ForkJoinPool pool = getPool();
        if (to - from < 1024 || pool.getParallelism() == 1) {
            radixSortIndirect(perm, a, from, to, stable);
            return;
        }
        LinkedBlockingQueue<Segment> queue = new LinkedBlockingQueue<>();
        queue.add(new Segment(from, to - from, 0));
        AtomicInteger queueSize = new AtomicInteger(1);
        int numberOfThreads = pool.getParallelism();
        ExecutorCompletionService<Void> executorCompletionService = new ExecutorCompletionService<>(pool);
        int[] support = stable ? new int[perm.length] : null;
        int j = numberOfThreads;
        while (true) {
            j--;
            if (j == 0) {
                break;
            }
            executorCompletionService.submit(() -> {
                int[] count = new int[256];
                int[] pos = new int[256];
                while (true) {
                    if (queueSize.get() == 0) {
                        int i = numberOfThreads;
                        while (true) {
                            i--;
                            if (i == 0) {
                                break;
                            }
                            queue.add(POISON_PILL);
                        }
                    }
                    Segment segment = (Segment) queue.take();
                    if (segment == POISON_PILL) {
                        return null;
                    }
                    int first = segment.offset;
                    int length = segment.length;
                    int level = segment.level;
                    int signMask = level % 4 == 0 ? 128 : 0;
                    int shift = (3 - (level % 4)) * 8;
                    int i2 = first + length;
                    while (true) {
                        i2--;
                        if (i2 == first) {
                            break;
                        }
                        int fixFloat = ((fixFloat(a[perm[i2]]) >>> shift) & 255) ^ signMask;
                        count[fixFloat] = count[fixFloat] + 1;
                    }
                    int lastUsed = -1;
                    int p = first;
                    for (int i3 = 0; i3 < 256; i3++) {
                        if (count[i3] != 0) {
                            lastUsed = i3;
                        }
                        int i4 = p + count[i3];
                        p = i4;
                        pos[i3] = i4;
                    }
                    if (stable) {
                        int i5 = first + length;
                        while (true) {
                            i5--;
                            if (i5 == first) {
                                break;
                            }
                            int fixFloat2 = ((fixFloat(a[perm[i5]]) >>> shift) & 255) ^ signMask;
                            int i6 = pos[fixFloat2] - 1;
                            pos[fixFloat2] = i6;
                            support[i6] = perm[i5];
                        }
                        System.arraycopy(support, first, perm, first, length);
                        int p2 = first;
                        for (int i7 = 0; i7 <= lastUsed; i7++) {
                            if (level < 3 && count[i7] > 1) {
                                if (count[i7] < 1024) {
                                    radixSortIndirect(perm, a, p2, p2 + count[i7], stable);
                                } else {
                                    queueSize.incrementAndGet();
                                    queue.add(new Segment(p2, count[i7], level + 1));
                                }
                            }
                            p2 += count[i7];
                        }
                        java.util.Arrays.fill(count, 0);
                    } else {
                        int end = (first + length) - count[lastUsed];
                        int i8 = first;
                        while (i8 <= end) {
                            int t = perm[i8];
                            int c = ((fixFloat(a[t]) >>> shift) & 255) ^ signMask;
                            if (i8 < end) {
                                while (true) {
                                    int d = pos[c] - 1;
                                    pos[c] = d;
                                    if (d <= i8) {
                                        break;
                                    }
                                    t = perm[d];
                                    perm[d] = t;
                                    c = ((fixFloat(a[t]) >>> shift) & 255) ^ signMask;
                                }
                                perm[i8] = t;
                            }
                            if (level < 3 && count[c] > 1) {
                                if (count[c] < 1024) {
                                    radixSortIndirect(perm, a, i8, i8 + count[c], stable);
                                } else {
                                    queueSize.incrementAndGet();
                                    queue.add(new Segment(i8, count[c], level + 1));
                                }
                            }
                            i8 += count[c];
                            count[c] = 0;
                        }
                    }
                    queueSize.decrementAndGet();
                }
            });
        }
        Throwable problem = null;
        int i = numberOfThreads;
        while (true) {
            i--;
            if (i == 0) {
                break;
            }
            try {
                executorCompletionService.take().get();
            } catch (Exception e) {
                problem = e.getCause();
            }
        }
        if (problem == null) {
            return;
        }
        if (!(problem instanceof RuntimeException)) {
            throw new RuntimeException(problem);
        }
    }

    public static void parallelRadixSortIndirect(int[] perm, float[] a, boolean stable) {
        parallelRadixSortIndirect(perm, a, 0, a.length, stable);
    }

    public static void radixSort(float[] a, float[] b) {
        ensureSameLength(a, b);
        radixSort(a, b, 0, a.length);
    }

    public static void radixSort(float[] a, float[] b, int from, int to) {
        if (to - from < 1024) {
            quickSort(a, b, from, to);
            return;
        }
        int[] offsetStack = new int[PacketOpcodes.FocusAvatarRsp];
        int[] lengthStack = new int[PacketOpcodes.FocusAvatarRsp];
        int[] levelStack = new int[PacketOpcodes.FocusAvatarRsp];
        offsetStack[0] = from;
        lengthStack[0] = to - from;
        int stackPos = 0 + 1;
        levelStack[0] = 0;
        int[] count = new int[256];
        int[] pos = new int[256];
        while (stackPos > 0) {
            stackPos--;
            int first = offsetStack[stackPos];
            int length = lengthStack[stackPos];
            int level = levelStack[stackPos];
            int signMask = level % 4 == 0 ? 128 : 0;
            float[] k = level < 4 ? a : b;
            int shift = (3 - (level % 4)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int fixFloat = ((fixFloat(k[i]) >>> shift) & 255) ^ signMask;
                count[fixFloat] = count[fixFloat] + 1;
            }
            int lastUsed = -1;
            int p = first;
            for (int i2 = 0; i2 < 256; i2++) {
                if (count[i2] != 0) {
                    lastUsed = i2;
                }
                int i3 = p + count[i2];
                p = i3;
                pos[i2] = i3;
            }
            int end = (first + length) - count[lastUsed];
            int i4 = first;
            while (i4 <= end) {
                float t = a[i4];
                float u = b[i4];
                int c = ((fixFloat(k[i4]) >>> shift) & 255) ^ signMask;
                if (i4 < end) {
                    while (true) {
                        int d = pos[c] - 1;
                        pos[c] = d;
                        if (d <= i4) {
                            break;
                        }
                        c = ((fixFloat(k[d]) >>> shift) & 255) ^ signMask;
                        t = a[d];
                        a[d] = t;
                        u = b[d];
                        b[d] = u;
                    }
                    a[i4] = t;
                    b[i4] = u;
                }
                if (level < 7 && count[c] > 1) {
                    if (count[c] < 1024) {
                        quickSort(a, b, i4, i4 + count[c]);
                    } else {
                        offsetStack[stackPos] = i4;
                        lengthStack[stackPos] = count[c];
                        stackPos++;
                        levelStack[stackPos] = level + 1;
                    }
                }
                i4 += count[c];
                count[c] = 0;
            }
        }
    }

    public static void parallelRadixSort(float[] a, float[] b, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 1024 || pool.getParallelism() == 1) {
            quickSort(a, b, from, to);
        } else if (a.length != b.length) {
            throw new IllegalArgumentException("Array size mismatch.");
        } else {
            LinkedBlockingQueue<Segment> queue = new LinkedBlockingQueue<>();
            queue.add(new Segment(from, to - from, 0));
            AtomicInteger queueSize = new AtomicInteger(1);
            int numberOfThreads = pool.getParallelism();
            ExecutorCompletionService<Void> executorCompletionService = new ExecutorCompletionService<>(pool);
            int j = numberOfThreads;
            while (true) {
                j--;
                if (j == 0) {
                    break;
                }
                executorCompletionService.submit(() -> {
                    int[] count = new int[256];
                    int[] pos = new int[256];
                    while (true) {
                        if (queueSize.get() == 0) {
                            int i = numberOfThreads;
                            while (true) {
                                i--;
                                if (i == 0) {
                                    break;
                                }
                                queue.add(POISON_PILL);
                            }
                        }
                        Segment segment = (Segment) queue.take();
                        if (segment == POISON_PILL) {
                            return null;
                        }
                        int first = segment.offset;
                        int length = segment.length;
                        int level = segment.level;
                        int signMask = level % 4 == 0 ? 128 : 0;
                        float[] k = level < 4 ? a : b;
                        int shift = (3 - (level % 4)) * 8;
                        int i2 = first + length;
                        while (true) {
                            i2--;
                            if (i2 == first) {
                                break;
                            }
                            int fixFloat = ((fixFloat(k[i2]) >>> shift) & 255) ^ signMask;
                            count[fixFloat] = count[fixFloat] + 1;
                        }
                        int lastUsed = -1;
                        int p = first;
                        for (int i3 = 0; i3 < 256; i3++) {
                            if (count[i3] != 0) {
                                lastUsed = i3;
                            }
                            int i4 = p + count[i3];
                            p = i4;
                            pos[i3] = i4;
                        }
                        int end = (first + length) - count[lastUsed];
                        int i5 = first;
                        while (i5 <= end) {
                            float t = a[i5];
                            float u = b[i5];
                            int c = ((fixFloat(k[i5]) >>> shift) & 255) ^ signMask;
                            if (i5 < end) {
                                while (true) {
                                    int d = pos[c] - 1;
                                    pos[c] = d;
                                    if (d <= i5) {
                                        break;
                                    }
                                    c = ((fixFloat(k[d]) >>> shift) & 255) ^ signMask;
                                    t = a[d];
                                    u = b[d];
                                    a[d] = t;
                                    b[d] = u;
                                }
                                a[i5] = t;
                                b[i5] = u;
                            }
                            if (level < 7 && count[c] > 1) {
                                if (count[c] < 1024) {
                                    quickSort(a, b, i5, i5 + count[c]);
                                } else {
                                    queueSize.incrementAndGet();
                                    queue.add(new Segment(i5, count[c], level + 1));
                                }
                            }
                            i5 += count[c];
                            count[c] = 0;
                        }
                        queueSize.decrementAndGet();
                    }
                });
            }
            Throwable problem = null;
            int i = numberOfThreads;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                try {
                    executorCompletionService.take().get();
                } catch (Exception e) {
                    problem = e.getCause();
                }
            }
            if (problem == null) {
                return;
            }
            if (!(problem instanceof RuntimeException)) {
                throw new RuntimeException(problem);
            }
        }
    }

    public static void parallelRadixSort(float[] a, float[] b) {
        ensureSameLength(a, b);
        parallelRadixSort(a, b, 0, a.length);
    }

    private static void insertionSortIndirect(int[] perm, float[] a, float[] b, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                int t = perm[i];
                int j = i;
                int u = perm[j - 1];
                while (true) {
                    if (Float.compare(a[t], a[u]) < 0 || (Float.compare(a[t], a[u]) == 0 && Float.compare(b[t], b[u]) < 0)) {
                        perm[j] = u;
                        if (from == j - 1) {
                            j--;
                            break;
                        } else {
                            j--;
                            u = perm[j - 1];
                        }
                    }
                }
                perm[j] = t;
            } else {
                return;
            }
        }
    }

    public static void radixSortIndirect(int[] perm, float[] a, float[] b, boolean stable) {
        ensureSameLength(a, b);
        radixSortIndirect(perm, a, b, 0, a.length, stable);
    }

    public static void radixSortIndirect(int[] perm, float[] a, float[] b, int from, int to, boolean stable) {
        if (to - from < 64) {
            insertionSortIndirect(perm, a, b, from, to);
            return;
        }
        int[] offsetStack = new int[PacketOpcodes.FocusAvatarRsp];
        int[] lengthStack = new int[PacketOpcodes.FocusAvatarRsp];
        int[] levelStack = new int[PacketOpcodes.FocusAvatarRsp];
        offsetStack[0] = from;
        lengthStack[0] = to - from;
        int stackPos = 0 + 1;
        levelStack[0] = 0;
        int[] count = new int[256];
        int[] pos = new int[256];
        int[] support = stable ? new int[perm.length] : null;
        while (stackPos > 0) {
            stackPos--;
            int first = offsetStack[stackPos];
            int length = lengthStack[stackPos];
            int level = levelStack[stackPos];
            int signMask = level % 4 == 0 ? 128 : 0;
            float[] k = level < 4 ? a : b;
            int shift = (3 - (level % 4)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int fixFloat = ((fixFloat(k[perm[i]]) >>> shift) & 255) ^ signMask;
                count[fixFloat] = count[fixFloat] + 1;
            }
            int lastUsed = -1;
            int p = stable ? 0 : first;
            for (int i2 = 0; i2 < 256; i2++) {
                if (count[i2] != 0) {
                    lastUsed = i2;
                }
                int i3 = p + count[i2];
                p = i3;
                pos[i2] = i3;
            }
            if (stable) {
                int i4 = first + length;
                while (true) {
                    i4--;
                    if (i4 == first) {
                        break;
                    }
                    int fixFloat2 = ((fixFloat(k[perm[i4]]) >>> shift) & 255) ^ signMask;
                    int i5 = pos[fixFloat2] - 1;
                    pos[fixFloat2] = i5;
                    support[i5] = perm[i4];
                }
                System.arraycopy(support, 0, perm, first, length);
                int p2 = first;
                for (int i6 = 0; i6 < 256; i6++) {
                    if (level < 7 && count[i6] > 1) {
                        if (count[i6] < 64) {
                            insertionSortIndirect(perm, a, b, p2, p2 + count[i6]);
                        } else {
                            offsetStack[stackPos] = p2;
                            lengthStack[stackPos] = count[i6];
                            stackPos++;
                            levelStack[stackPos] = level + 1;
                        }
                    }
                    p2 += count[i6];
                }
                java.util.Arrays.fill(count, 0);
            } else {
                int end = (first + length) - count[lastUsed];
                int i7 = first;
                while (i7 <= end) {
                    int t = perm[i7];
                    int c = ((fixFloat(k[t]) >>> shift) & 255) ^ signMask;
                    if (i7 < end) {
                        while (true) {
                            int d = pos[c] - 1;
                            pos[c] = d;
                            if (d <= i7) {
                                break;
                            }
                            t = perm[d];
                            perm[d] = t;
                            c = ((fixFloat(k[t]) >>> shift) & 255) ^ signMask;
                        }
                        perm[i7] = t;
                    }
                    if (level < 7 && count[c] > 1) {
                        if (count[c] < 64) {
                            insertionSortIndirect(perm, a, b, i7, i7 + count[c]);
                        } else {
                            offsetStack[stackPos] = i7;
                            lengthStack[stackPos] = count[c];
                            stackPos++;
                            levelStack[stackPos] = level + 1;
                        }
                    }
                    i7 += count[c];
                    count[c] = 0;
                }
            }
        }
    }

    private static void selectionSort(float[][] a, int from, int to, int level) {
        int layers = a.length;
        int firstLayer = level / 4;
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                int p = firstLayer;
                while (true) {
                    if (p >= layers) {
                        break;
                    } else if (a[p][j] < a[p][m]) {
                        m = j;
                        break;
                    } else if (a[p][j] > a[p][m]) {
                        break;
                    } else {
                        p++;
                    }
                }
            }
            if (m != i) {
                int p2 = layers;
                while (true) {
                    p2--;
                    if (p2 != 0) {
                        float u = a[p2][i];
                        a[p2][i] = a[p2][m];
                        a[p2][m] = u;
                    }
                }
            }
        }
    }

    public static void radixSort(float[][] a) {
        radixSort(a, 0, a[0].length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0192, code lost:
        if (r27 < r0) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0195, code lost:
        r2 = r0[r28] - 1;
        r0[r28] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01a4, code lost:
        if (r2 <= r27) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a7, code lost:
        r28 = ((fixFloat(r0[r2]) >>> r0) & 255) ^ r0;
        r30 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01be, code lost:
        r30 = r30 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01c3, code lost:
        if (r30 == 0) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c6, code lost:
        r0 = r0[r30];
        r0[r30] = r6[r30][r2];
        r6[r30][r2] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01e8, code lost:
        r30 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01eb, code lost:
        r30 = r30 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01f0, code lost:
        if (r30 == 0) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01f3, code lost:
        r6[r30][r27] = r0[r30];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0206, code lost:
        if (r0 >= r0) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x020f, code lost:
        if (r0[r28] <= 1) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0219, code lost:
        if (r0[r28] >= 64) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x021c, code lost:
        selectionSort(r6, r27, r27 + r0[r28], r0 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0231, code lost:
        r0[r12] = r27;
        r0[r12] = r0[r28];
        r12 = r12 + 1;
        r0[r12] = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x024e, code lost:
        r27 = r27 + r0[r28];
        r0[r28] = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void radixSort(float[][] r6, int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 613
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatArrays.radixSort(float[][], int, int):void");
    }

    public static float[] shuffle(float[] a, int from, int to, Random random) {
        int i = to - from;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            float t = a[from + i];
            a[from + i] = a[from + p];
            a[from + p] = t;
        }
    }

    public static float[] shuffle(float[] a, Random random) {
        int i = a.length;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            float t = a[i];
            a[i] = a[p];
            a[p] = t;
        }
    }

    public static float[] reverse(float[] a) {
        int length = a.length;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            float t = a[(length - i) - 1];
            a[(length - i) - 1] = a[i];
            a[i] = t;
        }
    }

    public static float[] reverse(float[] a, int from, int to) {
        int length = to - from;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            float t = a[((from + length) - i) - 1];
            a[((from + length) - i) - 1] = a[from + i];
            a[from + i] = t;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatArrays$ArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatArrays$ArrayHashStrategy.class */
    private static final class ArrayHashStrategy implements Hash.Strategy<float[]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private ArrayHashStrategy() {
        }

        public int hashCode(float[] o) {
            return java.util.Arrays.hashCode(o);
        }

        public boolean equals(float[] a, float[] b) {
            return java.util.Arrays.equals(a, b);
        }
    }
}
