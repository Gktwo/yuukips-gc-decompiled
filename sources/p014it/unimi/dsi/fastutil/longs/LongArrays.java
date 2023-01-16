package p014it.unimi.dsi.fastutil.longs;

import emu.grasscutter.net.packet.PacketOpcodes;
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

/* renamed from: it.unimi.dsi.fastutil.longs.LongArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrays.class */
public final class LongArrays {
    private static final int QUICKSORT_NO_REC = 16;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int QUICKSORT_MEDIAN_OF_9 = 128;
    private static final int MERGESORT_NO_REC = 16;
    private static final int DIGIT_BITS = 8;
    private static final int DIGIT_MASK = 255;
    private static final int DIGITS_PER_ELEMENT = 8;
    private static final int RADIXSORT_NO_REC = 1024;
    private static final int RADIXSORT_NO_REC_SMALL = 64;
    private static final int PARALLEL_RADIXSORT_NO_FORK = 1024;
    static final int RADIX_SORT_MIN_THRESHOLD = 4000;
    public static final long[] EMPTY_ARRAY = new long[0];
    public static final long[] DEFAULT_EMPTY_ARRAY = new long[0];
    protected static final Segment POISON_PILL = new Segment(-1, -1, -1);
    public static final Hash.Strategy<long[]> HASH_STRATEGY = new ArrayHashStrategy();

    private LongArrays() {
    }

    public static long[] forceCapacity(long[] array, int length, int preserve) {
        long[] t = new long[length];
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static long[] ensureCapacity(long[] array, int length) {
        return ensureCapacity(array, length, array.length);
    }

    public static long[] ensureCapacity(long[] array, int length, int preserve) {
        return length > array.length ? forceCapacity(array, length, preserve) : array;
    }

    public static long[] grow(long[] array, int length) {
        return grow(array, length, array.length);
    }

    public static long[] grow(long[] array, int length, int preserve) {
        if (length <= array.length) {
            return array;
        }
        long[] t = new long[(int) Math.max(Math.min(((long) array.length) + ((long) (array.length >> 1)), 2147483639L), (long) length)];
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static long[] trim(long[] array, int length) {
        if (length >= array.length) {
            return array;
        }
        long[] t = length == 0 ? EMPTY_ARRAY : new long[length];
        System.arraycopy(array, 0, t, 0, length);
        return t;
    }

    public static long[] setLength(long[] array, int length) {
        return length == array.length ? array : length < array.length ? trim(array, length) : ensureCapacity(array, length);
    }

    public static long[] copy(long[] array, int offset, int length) {
        ensureOffsetLength(array, offset, length);
        long[] a = length == 0 ? EMPTY_ARRAY : new long[length];
        System.arraycopy(array, offset, a, 0, length);
        return a;
    }

    public static long[] copy(long[] array) {
        return (long[]) array.clone();
    }

    @Deprecated
    public static void fill(long[] array, long value) {
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
    public static void fill(long[] array, int from, int to, long value) {
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
    public static boolean equals(long[] a1, long[] a2) {
        int i = a1.length;
        if (i != a2.length) {
            return false;
        }
        do {
            i--;
            if (i == 0) {
                return true;
            }
        } while (a1[i] == a2[i]);
        return false;
    }

    public static void ensureFromTo(long[] a, int from, int to) {
        Arrays.ensureFromTo(a.length, from, to);
    }

    public static void ensureOffsetLength(long[] a, int offset, int length) {
        Arrays.ensureOffsetLength(a.length, offset, length);
    }

    public static void ensureSameLength(long[] a, long[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array size mismatch: " + a.length + " != " + b.length);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    public static void swap(long[] x, int a, int b) {
        long t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void swap(long[] x, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* access modifiers changed from: private */
    public static int med3(long[] x, int a, int b, int c, LongComparator comp) {
        int ab = comp.compare(x[a], x[b]);
        int ac = comp.compare(x[a], x[c]);
        int bc = comp.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void selectionSort(long[] a, int from, int to, LongComparator comp) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (comp.compare(a[j], a[m]) < 0) {
                    m = j;
                }
            }
            if (m != i) {
                long u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static void insertionSort(long[] a, int from, int to, LongComparator comp) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                long t = a[i];
                int j = i;
                long u = a[j - 1];
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

    public static void quickSort(long[] x, int from, int to, LongComparator comp) {
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
        long v = x[med3(x, l, m, n, comp)];
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

    public static void quickSort(long[] x, LongComparator comp) {
        quickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f2401to;

        /* renamed from: x */
        private final long[] f2402x;
        private final LongComparator comp;

        public ForkJoinQuickSortComp(long[] x, int from, int to, LongComparator comp) {
            this.from = from;
            this.f2401to = to;
            this.f2402x = x;
            this.comp = comp;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            long[] x = this.f2402x;
            int len = this.f2401to - this.from;
            if (len < 8192) {
                LongArrays.quickSort(x, this.from, this.f2401to, this.comp);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f2401to - 1;
            int s = len / 8;
            long v = x[LongArrays.med3(x, LongArrays.med3(x, l, l + s, l + (2 * s), this.comp), LongArrays.med3(x, m - s, m, m + s, this.comp), LongArrays.med3(x, n - (2 * s), n - s, n, this.comp), this.comp)];
            int a = this.from;
            int b = a;
            int c = this.f2401to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = this.comp.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = this.comp.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            LongArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    LongArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        LongArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            LongArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f2401to - d) - 1);
            LongArrays.swap(x, b, this.f2401to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp), new ForkJoinQuickSortComp(x, this.f2401to - t, this.f2401to, this.comp));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.f2401to - t, this.f2401to, this.comp)});
            }
        }
    }

    public static void parallelQuickSort(long[] x, int from, int to, LongComparator comp) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static void parallelQuickSort(long[] x, LongComparator comp) {
        parallelQuickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: private */
    public static int med3(long[] x, int a, int b, int c) {
        int ab = Long.compare(x[a], x[b]);
        int ac = Long.compare(x[a], x[c]);
        int bc = Long.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void selectionSort(long[] a, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (a[j] < a[m]) {
                    m = j;
                }
            }
            if (m != i) {
                long u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static void insertionSort(long[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                long t = a[i];
                int j = i;
                long u = a[j - 1];
                while (true) {
                    if (t < u) {
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

    public static void quickSort(long[] x, int from, int to) {
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
        long v = x[med3(x, l, m, n)];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = Long.compare(x[b], v)) > 0) {
                while (c >= b && (comparison = Long.compare(x[c], v)) >= 0) {
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

    public static void quickSort(long[] x) {
        quickSort(x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f2396to;

        /* renamed from: x */
        private final long[] f2397x;

        public ForkJoinQuickSort(long[] x, int from, int to) {
            this.from = from;
            this.f2396to = to;
            this.f2397x = x;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            long[] x = this.f2397x;
            int len = this.f2396to - this.from;
            if (len < 8192) {
                LongArrays.quickSort(x, this.from, this.f2396to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f2396to - 1;
            int s = len / 8;
            long v = x[LongArrays.med3(x, LongArrays.med3(x, l, l + s, l + (2 * s)), LongArrays.med3(x, m - s, m, m + s), LongArrays.med3(x, n - (2 * s), n - s, n))];
            int a = this.from;
            int b = a;
            int c = this.f2396to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = Long.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = Long.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            LongArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    LongArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        LongArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            LongArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f2396to - d) - 1);
            LongArrays.swap(x, b, this.f2396to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSort(x, this.from, this.from + s4), new ForkJoinQuickSort(x, this.f2396to - t, this.f2396to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.f2396to - t, this.f2396to)});
            }
        }
    }

    public static void parallelQuickSort(long[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static void parallelQuickSort(long[] x) {
        parallelQuickSort(x, 0, x.length);
    }

    /* access modifiers changed from: private */
    public static int med3Indirect(int[] perm, long[] x, int a, int b, int c) {
        long aa = x[perm[a]];
        long bb = x[perm[b]];
        long cc = x[perm[c]];
        int ab = Long.compare(aa, bb);
        int ac = Long.compare(aa, cc);
        int bc = Long.compare(bb, cc);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void insertionSortIndirect(int[] perm, long[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                int t = perm[i];
                int j = i;
                int u = perm[j - 1];
                while (true) {
                    if (a[t] < a[u]) {
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

    public static void quickSortIndirect(int[] perm, long[] x, int from, int to) {
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
        long v = x[perm[med3Indirect(perm, x, l, m, n)]];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = Long.compare(x[perm[b]], v)) > 0) {
                while (c >= b && (comparison = Long.compare(x[perm[c]], v)) >= 0) {
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

    public static void quickSortIndirect(int[] perm, long[] x) {
        quickSortIndirect(perm, x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongArrays$ForkJoinQuickSortIndirect */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrays$ForkJoinQuickSortIndirect.class */
    public static class ForkJoinQuickSortIndirect extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f2403to;
        private final int[] perm;

        /* renamed from: x */
        private final long[] f2404x;

        public ForkJoinQuickSortIndirect(int[] perm, long[] x, int from, int to) {
            this.from = from;
            this.f2403to = to;
            this.f2404x = x;
            this.perm = perm;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            long[] x = this.f2404x;
            int len = this.f2403to - this.from;
            if (len < 8192) {
                LongArrays.quickSortIndirect(this.perm, x, this.from, this.f2403to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f2403to - 1;
            int s = len / 8;
            long v = x[this.perm[LongArrays.med3Indirect(this.perm, x, LongArrays.med3Indirect(this.perm, x, l, l + s, l + (2 * s)), LongArrays.med3Indirect(this.perm, x, m - s, m, m + s), LongArrays.med3Indirect(this.perm, x, n - (2 * s), n - s, n))]];
            int a = this.from;
            int b = a;
            int c = this.f2403to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = Long.compare(x[this.perm[b]], v)) > 0) {
                    while (c >= b && (comparison = Long.compare(x[this.perm[c]], v)) >= 0) {
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
            int s3 = Math.min(d - c, (this.f2403to - d) - 1);
            IntArrays.swap(this.perm, b, this.f2403to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4), new ForkJoinQuickSortIndirect(this.perm, x, this.f2403to - t, this.f2403to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.f2403to - t, this.f2403to)});
            }
        }
    }

    public static void parallelQuickSortIndirect(int[] perm, long[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSortIndirect(perm, x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSortIndirect(perm, x, from, to));
        }
    }

    public static void parallelQuickSortIndirect(int[] perm, long[] x) {
        parallelQuickSortIndirect(perm, x, 0, x.length);
    }

    public static void stabilize(int[] perm, long[] x, int from, int to) {
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

    public static void stabilize(int[] perm, long[] x) {
        stabilize(perm, x, 0, perm.length);
    }

    /* access modifiers changed from: private */
    public static int med3(long[] x, long[] y, int a, int b, int c) {
        int t = Long.compare(x[a], x[b]);
        int ab = t == 0 ? Long.compare(y[a], y[b]) : t;
        int t2 = Long.compare(x[a], x[c]);
        int ac = t2 == 0 ? Long.compare(y[a], y[c]) : t2;
        int t3 = Long.compare(x[b], x[c]);
        int bc = t3 == 0 ? Long.compare(y[b], y[c]) : t3;
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* access modifiers changed from: private */
    public static void swap(long[] x, long[] y, int a, int b) {
        long t = x[a];
        long u = y[a];
        x[a] = x[b];
        y[a] = y[b];
        x[b] = t;
        y[b] = u;
    }

    /* access modifiers changed from: private */
    public static void swap(long[] x, long[] y, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, y, a, b);
            i++;
            a++;
            b++;
        }
    }

    private static void selectionSort(long[] a, long[] b, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                int u = Long.compare(a[j], a[m]);
                if (u < 0 || (u == 0 && b[j] < b[m])) {
                    m = j;
                }
            }
            if (m != i) {
                long t = a[i];
                a[i] = a[m];
                a[m] = t;
                long t2 = b[i];
                b[i] = b[m];
                b[m] = t2;
            }
        }
    }

    public static void quickSort(long[] x, long[] y, int from, int to) {
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
        long v = x[m2];
        long w = y[m2];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b <= c) {
                int t = Long.compare(x[b], v);
                int comparison = t == 0 ? Long.compare(y[b], w) : t;
                if (comparison <= 0) {
                    if (comparison == 0) {
                        a++;
                        swap(x, y, a, b);
                    }
                    b++;
                }
            }
            while (c >= b) {
                int t2 = Long.compare(x[c], v);
                int comparison2 = t2 == 0 ? Long.compare(y[c], w) : t2;
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

    public static void quickSort(long[] x, long[] y) {
        ensureSameLength(x, y);
        quickSort(x, y, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongArrays$ForkJoinQuickSort2 */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrays$ForkJoinQuickSort2.class */
    public static class ForkJoinQuickSort2 extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f2398to;

        /* renamed from: x */
        private final long[] f2399x;

        /* renamed from: y */
        private final long[] f2400y;

        public ForkJoinQuickSort2(long[] x, long[] y, int from, int to) {
            this.from = from;
            this.f2398to = to;
            this.f2399x = x;
            this.f2400y = y;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            long[] x = this.f2399x;
            long[] y = this.f2400y;
            int len = this.f2398to - this.from;
            if (len < 8192) {
                LongArrays.quickSort(x, y, this.from, this.f2398to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f2398to - 1;
            int s = len / 8;
            int m2 = LongArrays.med3(x, y, LongArrays.med3(x, y, l, l + s, l + (2 * s)), LongArrays.med3(x, y, m - s, m, m + s), LongArrays.med3(x, y, n - (2 * s), n - s, n));
            long v = x[m2];
            long w = y[m2];
            int a = this.from;
            int b = a;
            int c = this.f2398to - 1;
            int d = c;
            while (true) {
                if (b <= c) {
                    int t = Long.compare(x[b], v);
                    int comparison = t == 0 ? Long.compare(y[b], w) : t;
                    if (comparison <= 0) {
                        if (comparison == 0) {
                            a++;
                            LongArrays.swap(x, y, a, b);
                        }
                        b++;
                    }
                }
                while (c >= b) {
                    int t2 = Long.compare(x[c], v);
                    int comparison2 = t2 == 0 ? Long.compare(y[c], w) : t2;
                    if (comparison2 < 0) {
                        break;
                    }
                    if (comparison2 == 0) {
                        d--;
                        LongArrays.swap(x, y, c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                b++;
                c--;
                LongArrays.swap(x, y, b, c);
            }
            int s2 = Math.min(a - this.from, b - a);
            LongArrays.swap(x, y, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f2398to - d) - 1);
            LongArrays.swap(x, y, b, this.f2398to - s3, s3);
            int s4 = b - a;
            int t3 = d - c;
            if (s4 > 1 && t3 > 1) {
                invokeAll(new ForkJoinQuickSort2(x, y, this.from, this.from + s4), new ForkJoinQuickSort2(x, y, this.f2398to - t3, this.f2398to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.f2398to - t3, this.f2398to)});
            }
        }
    }

    public static void parallelQuickSort(long[] x, long[] y, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, y, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort2(x, y, from, to));
        }
    }

    public static void parallelQuickSort(long[] x, long[] y) {
        ensureSameLength(x, y);
        parallelQuickSort(x, y, 0, x.length);
    }

    public static void unstableSort(long[] a, int from, int to) {
        if (to - from >= 4000) {
            radixSort(a, from, to);
        } else {
            quickSort(a, from, to);
        }
    }

    public static void unstableSort(long[] a) {
        unstableSort(a, 0, a.length);
    }

    public static void unstableSort(long[] a, int from, int to, LongComparator comp) {
        quickSort(a, from, to, comp);
    }

    public static void unstableSort(long[] a, LongComparator comp) {
        unstableSort(a, 0, a.length, comp);
    }

    public static void mergeSort(long[] a, int from, int to, long[] supp) {
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
        if (supp[mid - 1] <= supp[mid]) {
            System.arraycopy(supp, from, a, from, len);
            return;
        }
        int p = from;
        int q = mid;
        for (int i = from; i < to; i++) {
            if (q >= to || (p < mid && supp[p] <= supp[q])) {
                p++;
                a[i] = supp[p];
            } else {
                q++;
                a[i] = supp[q];
            }
        }
    }

    public static void mergeSort(long[] a, int from, int to) {
        mergeSort(a, from, to, (long[]) null);
    }

    public static void mergeSort(long[] a) {
        mergeSort(a, 0, a.length);
    }

    public static void mergeSort(long[] a, int from, int to, LongComparator comp, long[] supp) {
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

    public static void mergeSort(long[] a, int from, int to, LongComparator comp) {
        mergeSort(a, from, to, comp, null);
    }

    public static void mergeSort(long[] a, LongComparator comp) {
        mergeSort(a, 0, a.length, comp);
    }

    public static void stableSort(long[] a, int from, int to) {
        unstableSort(a, from, to);
    }

    public static void stableSort(long[] a) {
        stableSort(a, 0, a.length);
    }

    public static void stableSort(long[] a, int from, int to, LongComparator comp) {
        mergeSort(a, from, to, comp);
    }

    public static void stableSort(long[] a, LongComparator comp) {
        stableSort(a, 0, a.length, comp);
    }

    public static int binarySearch(long[] a, int from, int to, long key) {
        int to2 = to - 1;
        while (from <= to2) {
            int mid = (from + to2) >>> 1;
            long midVal = a[mid];
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

    public static int binarySearch(long[] a, long key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(long[] a, int from, int to, long key, LongComparator c) {
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

    public static int binarySearch(long[] a, long key, LongComparator c) {
        return binarySearch(a, 0, a.length, key, c);
    }

    public static void radixSort(long[] a) {
        radixSort(a, 0, a.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void radixSort(long[] r6, int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 450
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongArrays.radixSort(long[], int, int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongArrays$Segment */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrays$Segment.class */
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

    public static void parallelRadixSort(long[] a, int from, int to) {
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
                    int signMask = level % 8 == 0 ? 128 : 0;
                    int shift = (7 - (level % 8)) * 8;
                    int i2 = first + length;
                    while (true) {
                        i2--;
                        if (i2 == first) {
                            break;
                        }
                        int i3 = (int) (((a[i2] >>> shift) & 255) ^ ((long) signMask));
                        count[i3] = count[i3] + 1;
                    }
                    int lastUsed = -1;
                    int p = first;
                    for (int i4 = 0; i4 < 256; i4++) {
                        if (count[i4] != 0) {
                            lastUsed = i4;
                        }
                        int i5 = p + count[i4];
                        p = i5;
                        pos[i4] = i5;
                    }
                    int end = (first + length) - count[lastUsed];
                    int i6 = first;
                    while (i6 <= end) {
                        boolean z = a[i6];
                        int c = (int) ((((z ? 1 : 0) >>> shift) & 255) ^ ((long) signMask));
                        ?? r25 = z;
                        if (i6 < end) {
                            while (true) {
                                int d = pos[c] - 1;
                                pos[c] = d;
                                if (d <= i6) {
                                    break;
                                }
                                boolean z2 = a[d];
                                long t = r25 == true ? 1 : 0;
                                long t2 = r25 == true ? 1 : 0;
                                long t3 = r25 == true ? 1 : 0;
                                a[d] = t;
                                c = (int) ((((z2 ? 1 : 0) >>> shift) & 255) ^ ((long) signMask));
                                r25 = z2;
                            }
                            a[i6] = r25;
                        }
                        if (level < 7 && count[c] > 1) {
                            if (count[c] < 1024) {
                                quickSort(a, i6, i6 + count[c]);
                            } else {
                                queueSize.incrementAndGet();
                                queue.add(new Segment(i6, count[c], level + 1));
                            }
                        }
                        i6 += count[c];
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

    public static void parallelRadixSort(long[] a) {
        parallelRadixSort(a, 0, a.length);
    }

    public static void radixSortIndirect(int[] perm, long[] a, boolean stable) {
        radixSortIndirect(perm, a, 0, perm.length, stable);
    }

    public static void radixSortIndirect(int[] perm, long[] a, int from, int to, boolean stable) {
        if (to - from < 1024) {
            quickSortIndirect(perm, a, from, to);
            if (stable) {
                stabilize(perm, a, from, to);
                return;
            }
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
            int signMask = level % 8 == 0 ? 128 : 0;
            int shift = (7 - (level % 8)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int i2 = (int) (((a[perm[i]] >>> shift) & 255) ^ ((long) signMask));
                count[i2] = count[i2] + 1;
            }
            int lastUsed = -1;
            int p = stable ? 0 : first;
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
                    int i6 = (int) (((a[perm[i5]] >>> shift) & 255) ^ ((long) signMask));
                    int i7 = pos[i6] - 1;
                    pos[i6] = i7;
                    support[i7] = perm[i5];
                }
                System.arraycopy(support, 0, perm, first, length);
                int p2 = first;
                for (int i8 = 0; i8 <= lastUsed; i8++) {
                    if (level < 7 && count[i8] > 1) {
                        if (count[i8] < 1024) {
                            quickSortIndirect(perm, a, p2, p2 + count[i8]);
                            if (stable) {
                                stabilize(perm, a, p2, p2 + count[i8]);
                            }
                        } else {
                            offsetStack[stackPos] = p2;
                            lengthStack[stackPos] = count[i8];
                            stackPos++;
                            levelStack[stackPos] = level + 1;
                        }
                    }
                    p2 += count[i8];
                }
                java.util.Arrays.fill(count, 0);
            } else {
                int end = (first + length) - count[lastUsed];
                int i9 = first;
                while (i9 <= end) {
                    int t = perm[i9];
                    int c = (int) (((a[t] >>> shift) & 255) ^ ((long) signMask));
                    if (i9 < end) {
                        while (true) {
                            int d = pos[c] - 1;
                            pos[c] = d;
                            if (d <= i9) {
                                break;
                            }
                            t = perm[d];
                            perm[d] = t;
                            c = (int) (((a[t] >>> shift) & 255) ^ ((long) signMask));
                        }
                        perm[i9] = t;
                    }
                    if (level < 7 && count[c] > 1) {
                        if (count[c] < 1024) {
                            quickSortIndirect(perm, a, i9, i9 + count[c]);
                            if (stable) {
                                stabilize(perm, a, i9, i9 + count[c]);
                            }
                        } else {
                            offsetStack[stackPos] = i9;
                            lengthStack[stackPos] = count[c];
                            stackPos++;
                            levelStack[stackPos] = level + 1;
                        }
                    }
                    i9 += count[c];
                    count[c] = 0;
                }
            }
        }
    }

    public static void parallelRadixSortIndirect(int[] perm, long[] a, int from, int to, boolean stable) {
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
                    int signMask = level % 8 == 0 ? 128 : 0;
                    int shift = (7 - (level % 8)) * 8;
                    int i2 = first + length;
                    while (true) {
                        i2--;
                        if (i2 == first) {
                            break;
                        }
                        int i3 = (int) (((a[perm[i2]] >>> shift) & 255) ^ ((long) signMask));
                        count[i3] = count[i3] + 1;
                    }
                    int lastUsed = -1;
                    int p = first;
                    for (int i4 = 0; i4 < 256; i4++) {
                        if (count[i4] != 0) {
                            lastUsed = i4;
                        }
                        int i5 = p + count[i4];
                        p = i5;
                        pos[i4] = i5;
                    }
                    if (stable) {
                        int i6 = first + length;
                        while (true) {
                            i6--;
                            if (i6 == first) {
                                break;
                            }
                            int i7 = (int) (((a[perm[i6]] >>> shift) & 255) ^ ((long) signMask));
                            int i8 = pos[i7] - 1;
                            pos[i7] = i8;
                            support[i8] = perm[i6];
                        }
                        System.arraycopy(support, first, perm, first, length);
                        int p2 = first;
                        for (int i9 = 0; i9 <= lastUsed; i9++) {
                            if (level < 7 && count[i9] > 1) {
                                if (count[i9] < 1024) {
                                    radixSortIndirect(perm, a, p2, p2 + count[i9], stable);
                                } else {
                                    queueSize.incrementAndGet();
                                    queue.add(new Segment(p2, count[i9], level + 1));
                                }
                            }
                            p2 += count[i9];
                        }
                        java.util.Arrays.fill(count, 0);
                    } else {
                        int end = (first + length) - count[lastUsed];
                        int i10 = first;
                        while (i10 <= end) {
                            int t = perm[i10];
                            int c = (int) (((a[t] >>> shift) & 255) ^ ((long) signMask));
                            if (i10 < end) {
                                while (true) {
                                    int d = pos[c] - 1;
                                    pos[c] = d;
                                    if (d <= i10) {
                                        break;
                                    }
                                    t = perm[d];
                                    perm[d] = t;
                                    c = (int) (((a[t] >>> shift) & 255) ^ ((long) signMask));
                                }
                                perm[i10] = t;
                            }
                            if (level < 7 && count[c] > 1) {
                                if (count[c] < 1024) {
                                    radixSortIndirect(perm, a, i10, i10 + count[c], stable);
                                } else {
                                    queueSize.incrementAndGet();
                                    queue.add(new Segment(i10, count[c], level + 1));
                                }
                            }
                            i10 += count[c];
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

    public static void parallelRadixSortIndirect(int[] perm, long[] a, boolean stable) {
        parallelRadixSortIndirect(perm, a, 0, a.length, stable);
    }

    public static void radixSort(long[] a, long[] b) {
        ensureSameLength(a, b);
        radixSort(a, b, 0, a.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r33v0 */
    /* JADX WARN: Type inference failed for: r33v1 */
    /* JADX WARN: Type inference failed for: r31v1 */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r33v2 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void radixSort(long[] r7, long[] r8, int r9, int r10) {
        /*
        // Method dump skipped, instructions count: 505
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongArrays.radixSort(long[], long[], int, int):void");
    }

    public static void parallelRadixSort(long[] a, long[] b, int from, int to) {
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
                        int signMask = level % 8 == 0 ? 128 : 0;
                        long[] k = level < 8 ? a : b;
                        int shift = (7 - (level % 8)) * 8;
                        int i2 = first + length;
                        while (true) {
                            i2--;
                            if (i2 == first) {
                                break;
                            }
                            int i3 = (int) (((k[i2] >>> shift) & 255) ^ ((long) signMask));
                            count[i3] = count[i3] + 1;
                        }
                        int lastUsed = -1;
                        int p = first;
                        for (int i4 = 0; i4 < 256; i4++) {
                            if (count[i4] != 0) {
                                lastUsed = i4;
                            }
                            int i5 = p + count[i4];
                            p = i5;
                            pos[i4] = i5;
                        }
                        int end = (first + length) - count[lastUsed];
                        int i6 = first;
                        while (i6 <= end) {
                            ?? r27 = a[i6];
                            ?? r29 = b[i6];
                            int c = (int) (((k[i6] >>> shift) & 255) ^ ((long) signMask));
                            if (i6 < end) {
                                while (true) {
                                    int d = pos[c] - 1;
                                    pos[c] = d;
                                    if (d <= i6) {
                                        break;
                                    }
                                    c = (int) (((k[d] >>> shift) & 255) ^ ((long) signMask));
                                    r27 = a[d];
                                    r29 = b[d];
                                    long t = r27 == true ? 1 : 0;
                                    long t2 = r27 == true ? 1 : 0;
                                    long t3 = r27 == true ? 1 : 0;
                                    a[d] = t;
                                    long u = r29 == true ? 1 : 0;
                                    long u2 = r29 == true ? 1 : 0;
                                    long u3 = r29 == true ? 1 : 0;
                                    b[d] = u;
                                }
                                a[i6] = r27;
                                b[i6] = r29;
                            }
                            if (level < 15 && count[c] > 1) {
                                if (count[c] < 1024) {
                                    quickSort(a, b, i6, i6 + count[c]);
                                } else {
                                    queueSize.incrementAndGet();
                                    queue.add(new Segment(i6, count[c], level + 1));
                                }
                            }
                            i6 += count[c];
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

    public static void parallelRadixSort(long[] a, long[] b) {
        ensureSameLength(a, b);
        parallelRadixSort(a, b, 0, a.length);
    }

    private static void insertionSortIndirect(int[] perm, long[] a, long[] b, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                int t = perm[i];
                int j = i;
                int u = perm[j - 1];
                while (true) {
                    if (a[t] < a[u] || (a[t] == a[u] && b[t] < b[u])) {
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

    public static void radixSortIndirect(int[] perm, long[] a, long[] b, boolean stable) {
        ensureSameLength(a, b);
        radixSortIndirect(perm, a, b, 0, a.length, stable);
    }

    public static void radixSortIndirect(int[] perm, long[] a, long[] b, int from, int to, boolean stable) {
        if (to - from < 64) {
            insertionSortIndirect(perm, a, b, from, to);
            return;
        }
        int[] offsetStack = new int[3826];
        int[] lengthStack = new int[3826];
        int[] levelStack = new int[3826];
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
            int signMask = level % 8 == 0 ? 128 : 0;
            long[] k = level < 8 ? a : b;
            int shift = (7 - (level % 8)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int i2 = (int) (((k[perm[i]] >>> shift) & 255) ^ ((long) signMask));
                count[i2] = count[i2] + 1;
            }
            int lastUsed = -1;
            int p = stable ? 0 : first;
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
                    int i6 = (int) (((k[perm[i5]] >>> shift) & 255) ^ ((long) signMask));
                    int i7 = pos[i6] - 1;
                    pos[i6] = i7;
                    support[i7] = perm[i5];
                }
                System.arraycopy(support, 0, perm, first, length);
                int p2 = first;
                for (int i8 = 0; i8 < 256; i8++) {
                    if (level < 15 && count[i8] > 1) {
                        if (count[i8] < 64) {
                            insertionSortIndirect(perm, a, b, p2, p2 + count[i8]);
                        } else {
                            offsetStack[stackPos] = p2;
                            lengthStack[stackPos] = count[i8];
                            stackPos++;
                            levelStack[stackPos] = level + 1;
                        }
                    }
                    p2 += count[i8];
                }
                java.util.Arrays.fill(count, 0);
            } else {
                int end = (first + length) - count[lastUsed];
                int i9 = first;
                while (i9 <= end) {
                    int t = perm[i9];
                    int c = (int) (((k[t] >>> shift) & 255) ^ ((long) signMask));
                    if (i9 < end) {
                        while (true) {
                            int d = pos[c] - 1;
                            pos[c] = d;
                            if (d <= i9) {
                                break;
                            }
                            t = perm[d];
                            perm[d] = t;
                            c = (int) (((k[t] >>> shift) & 255) ^ ((long) signMask));
                        }
                        perm[i9] = t;
                    }
                    if (level < 15 && count[c] > 1) {
                        if (count[c] < 64) {
                            insertionSortIndirect(perm, a, b, i9, i9 + count[c]);
                        } else {
                            offsetStack[stackPos] = i9;
                            lengthStack[stackPos] = count[c];
                            stackPos++;
                            levelStack[stackPos] = level + 1;
                        }
                    }
                    i9 += count[c];
                    count[c] = 0;
                }
            }
        }
    }

    private static void selectionSort(long[][] a, int from, int to, int level) {
        int layers = a.length;
        int firstLayer = level / 8;
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
                        long u = a[p2][i];
                        a[p2][i] = a[p2][m];
                        a[p2][m] = u;
                    }
                }
            }
        }
    }

    public static void radixSort(long[][] a) {
        radixSort(a, 0, a[0].length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0196, code lost:
        if (r27 < r0) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0199, code lost:
        r2 = r0[r28] - 1;
        r0[r28] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01a8, code lost:
        if (r2 <= r27) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01ab, code lost:
        r28 = (int) (((r0[r2] >>> r0) & 255) ^ ((long) r0));
        r30 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01c1, code lost:
        r30 = r30 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01c6, code lost:
        if (r30 == 0) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c9, code lost:
        r0 = r0[r30];
        r0[r30] = r6[r30][r2];
        r6[r30][r2] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01eb, code lost:
        r30 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01ee, code lost:
        r30 = r30 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01f3, code lost:
        if (r30 == 0) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01f6, code lost:
        r6[r30][r27] = r0[r30];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0209, code lost:
        if (r0 >= r0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0212, code lost:
        if (r0[r28] <= 1) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x021c, code lost:
        if (r0[r28] >= 64) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x021f, code lost:
        selectionSort(r6, r27, r27 + r0[r28], r0 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0234, code lost:
        r0[r12] = r27;
        r0[r12] = r0[r28];
        r12 = r12 + 1;
        r0[r12] = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0251, code lost:
        r27 = r27 + r0[r28];
        r0[r28] = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void radixSort(long[][] r6, int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 616
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongArrays.radixSort(long[][], int, int):void");
    }

    public static long[] shuffle(long[] a, int from, int to, Random random) {
        int i = to - from;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            long t = a[from + i];
            a[from + i] = a[from + p];
            a[from + p] = t;
        }
    }

    public static long[] shuffle(long[] a, Random random) {
        int i = a.length;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            long t = a[i];
            a[i] = a[p];
            a[p] = t;
        }
    }

    public static long[] reverse(long[] a) {
        int length = a.length;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            long t = a[(length - i) - 1];
            a[(length - i) - 1] = a[i];
            a[i] = t;
        }
    }

    public static long[] reverse(long[] a, int from, int to) {
        int length = to - from;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            long t = a[((from + length) - i) - 1];
            a[((from + length) - i) - 1] = a[from + i];
            a[from + i] = t;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongArrays$ArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongArrays$ArrayHashStrategy.class */
    private static final class ArrayHashStrategy implements Hash.Strategy<long[]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private ArrayHashStrategy() {
        }

        public int hashCode(long[] o) {
            return java.util.Arrays.hashCode(o);
        }

        public boolean equals(long[] a, long[] b) {
            return java.util.Arrays.equals(a, b);
        }
    }
}
