package p014it.unimi.dsi.fastutil.shorts;

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

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrays.class */
public final class ShortArrays {
    private static final int QUICKSORT_NO_REC = 16;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int QUICKSORT_MEDIAN_OF_9 = 128;
    private static final int MERGESORT_NO_REC = 16;
    private static final int DIGIT_BITS = 8;
    private static final int DIGIT_MASK = 255;
    private static final int DIGITS_PER_ELEMENT = 2;
    private static final int RADIXSORT_NO_REC = 1024;
    private static final int RADIXSORT_NO_REC_SMALL = 64;
    private static final int PARALLEL_RADIXSORT_NO_FORK = 1024;
    static final int RADIX_SORT_MIN_THRESHOLD = 1000;
    public static final short[] EMPTY_ARRAY = new short[0];
    public static final short[] DEFAULT_EMPTY_ARRAY = new short[0];
    protected static final Segment POISON_PILL = new Segment(-1, -1, -1);
    public static final Hash.Strategy<short[]> HASH_STRATEGY = new ArrayHashStrategy();

    private ShortArrays() {
    }

    public static short[] forceCapacity(short[] array, int length, int preserve) {
        short[] t = new short[length];
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static short[] ensureCapacity(short[] array, int length) {
        return ensureCapacity(array, length, array.length);
    }

    public static short[] ensureCapacity(short[] array, int length, int preserve) {
        return length > array.length ? forceCapacity(array, length, preserve) : array;
    }

    public static short[] grow(short[] array, int length) {
        return grow(array, length, array.length);
    }

    public static short[] grow(short[] array, int length, int preserve) {
        if (length <= array.length) {
            return array;
        }
        short[] t = new short[(int) Math.max(Math.min(((long) array.length) + ((long) (array.length >> 1)), 2147483639L), (long) length)];
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static short[] trim(short[] array, int length) {
        if (length >= array.length) {
            return array;
        }
        short[] t = length == 0 ? EMPTY_ARRAY : new short[length];
        System.arraycopy(array, 0, t, 0, length);
        return t;
    }

    public static short[] setLength(short[] array, int length) {
        return length == array.length ? array : length < array.length ? trim(array, length) : ensureCapacity(array, length);
    }

    public static short[] copy(short[] array, int offset, int length) {
        ensureOffsetLength(array, offset, length);
        short[] a = length == 0 ? EMPTY_ARRAY : new short[length];
        System.arraycopy(array, offset, a, 0, length);
        return a;
    }

    public static short[] copy(short[] array) {
        return (short[]) array.clone();
    }

    @Deprecated
    public static void fill(short[] array, short value) {
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
    public static void fill(short[] array, int from, int to, short value) {
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
    public static boolean equals(short[] a1, short[] a2) {
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

    public static void ensureFromTo(short[] a, int from, int to) {
        Arrays.ensureFromTo(a.length, from, to);
    }

    public static void ensureOffsetLength(short[] a, int offset, int length) {
        Arrays.ensureOffsetLength(a.length, offset, length);
    }

    public static void ensureSameLength(short[] a, short[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array size mismatch: " + a.length + " != " + b.length);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    public static void swap(short[] x, int a, int b) {
        short t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void swap(short[] x, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* access modifiers changed from: private */
    public static int med3(short[] x, int a, int b, int c, ShortComparator comp) {
        int ab = comp.compare(x[a], x[b]);
        int ac = comp.compare(x[a], x[c]);
        int bc = comp.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void selectionSort(short[] a, int from, int to, ShortComparator comp) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (comp.compare(a[j], a[m]) < 0) {
                    m = j;
                }
            }
            if (m != i) {
                short u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static void insertionSort(short[] a, int from, int to, ShortComparator comp) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                short t = a[i];
                int j = i;
                short u = a[j - 1];
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

    public static void quickSort(short[] x, int from, int to, ShortComparator comp) {
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
        short v = x[med3(x, l, m, n, comp)];
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

    public static void quickSort(short[] x, ShortComparator comp) {
        quickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f3031to;

        /* renamed from: x */
        private final short[] f3032x;
        private final ShortComparator comp;

        public ForkJoinQuickSortComp(short[] x, int from, int to, ShortComparator comp) {
            this.from = from;
            this.f3031to = to;
            this.f3032x = x;
            this.comp = comp;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            short[] x = this.f3032x;
            int len = this.f3031to - this.from;
            if (len < 8192) {
                ShortArrays.quickSort(x, this.from, this.f3031to, this.comp);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f3031to - 1;
            int s = len / 8;
            short v = x[ShortArrays.med3(x, ShortArrays.med3(x, l, l + s, l + (2 * s), this.comp), ShortArrays.med3(x, m - s, m, m + s, this.comp), ShortArrays.med3(x, n - (2 * s), n - s, n, this.comp), this.comp)];
            int a = this.from;
            int b = a;
            int c = this.f3031to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = this.comp.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = this.comp.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            ShortArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    ShortArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        ShortArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            ShortArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f3031to - d) - 1);
            ShortArrays.swap(x, b, this.f3031to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp), new ForkJoinQuickSortComp(x, this.f3031to - t, this.f3031to, this.comp));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.f3031to - t, this.f3031to, this.comp)});
            }
        }
    }

    public static void parallelQuickSort(short[] x, int from, int to, ShortComparator comp) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static void parallelQuickSort(short[] x, ShortComparator comp) {
        parallelQuickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: private */
    public static int med3(short[] x, int a, int b, int c) {
        int ab = Short.compare(x[a], x[b]);
        int ac = Short.compare(x[a], x[c]);
        int bc = Short.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void selectionSort(short[] a, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (a[j] < a[m]) {
                    m = j;
                }
            }
            if (m != i) {
                short u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static void insertionSort(short[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                short t = a[i];
                int j = i;
                short u = a[j - 1];
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

    public static void quickSort(short[] x, int from, int to) {
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
        short v = x[med3(x, l, m, n)];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = Short.compare(x[b], v)) > 0) {
                while (c >= b && (comparison = Short.compare(x[c], v)) >= 0) {
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

    public static void quickSort(short[] x) {
        quickSort(x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f3026to;

        /* renamed from: x */
        private final short[] f3027x;

        public ForkJoinQuickSort(short[] x, int from, int to) {
            this.from = from;
            this.f3026to = to;
            this.f3027x = x;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            short[] x = this.f3027x;
            int len = this.f3026to - this.from;
            if (len < 8192) {
                ShortArrays.quickSort(x, this.from, this.f3026to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f3026to - 1;
            int s = len / 8;
            short v = x[ShortArrays.med3(x, ShortArrays.med3(x, l, l + s, l + (2 * s)), ShortArrays.med3(x, m - s, m, m + s), ShortArrays.med3(x, n - (2 * s), n - s, n))];
            int a = this.from;
            int b = a;
            int c = this.f3026to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = Short.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = Short.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            ShortArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    ShortArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        ShortArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            ShortArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f3026to - d) - 1);
            ShortArrays.swap(x, b, this.f3026to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSort(x, this.from, this.from + s4), new ForkJoinQuickSort(x, this.f3026to - t, this.f3026to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.f3026to - t, this.f3026to)});
            }
        }
    }

    public static void parallelQuickSort(short[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static void parallelQuickSort(short[] x) {
        parallelQuickSort(x, 0, x.length);
    }

    /* access modifiers changed from: private */
    public static int med3Indirect(int[] perm, short[] x, int a, int b, int c) {
        short aa = x[perm[a]];
        short bb = x[perm[b]];
        short cc = x[perm[c]];
        int ab = Short.compare(aa, bb);
        int ac = Short.compare(aa, cc);
        int bc = Short.compare(bb, cc);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void insertionSortIndirect(int[] perm, short[] a, int from, int to) {
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

    public static void quickSortIndirect(int[] perm, short[] x, int from, int to) {
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
        short v = x[perm[med3Indirect(perm, x, l, m, n)]];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = Short.compare(x[perm[b]], v)) > 0) {
                while (c >= b && (comparison = Short.compare(x[perm[c]], v)) >= 0) {
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

    public static void quickSortIndirect(int[] perm, short[] x) {
        quickSortIndirect(perm, x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrays$ForkJoinQuickSortIndirect */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrays$ForkJoinQuickSortIndirect.class */
    public static class ForkJoinQuickSortIndirect extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f3033to;
        private final int[] perm;

        /* renamed from: x */
        private final short[] f3034x;

        public ForkJoinQuickSortIndirect(int[] perm, short[] x, int from, int to) {
            this.from = from;
            this.f3033to = to;
            this.f3034x = x;
            this.perm = perm;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            short[] x = this.f3034x;
            int len = this.f3033to - this.from;
            if (len < 8192) {
                ShortArrays.quickSortIndirect(this.perm, x, this.from, this.f3033to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f3033to - 1;
            int s = len / 8;
            short v = x[this.perm[ShortArrays.med3Indirect(this.perm, x, ShortArrays.med3Indirect(this.perm, x, l, l + s, l + (2 * s)), ShortArrays.med3Indirect(this.perm, x, m - s, m, m + s), ShortArrays.med3Indirect(this.perm, x, n - (2 * s), n - s, n))]];
            int a = this.from;
            int b = a;
            int c = this.f3033to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = Short.compare(x[this.perm[b]], v)) > 0) {
                    while (c >= b && (comparison = Short.compare(x[this.perm[c]], v)) >= 0) {
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
            int s3 = Math.min(d - c, (this.f3033to - d) - 1);
            IntArrays.swap(this.perm, b, this.f3033to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4), new ForkJoinQuickSortIndirect(this.perm, x, this.f3033to - t, this.f3033to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.f3033to - t, this.f3033to)});
            }
        }
    }

    public static void parallelQuickSortIndirect(int[] perm, short[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSortIndirect(perm, x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSortIndirect(perm, x, from, to));
        }
    }

    public static void parallelQuickSortIndirect(int[] perm, short[] x) {
        parallelQuickSortIndirect(perm, x, 0, x.length);
    }

    public static void stabilize(int[] perm, short[] x, int from, int to) {
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

    public static void stabilize(int[] perm, short[] x) {
        stabilize(perm, x, 0, perm.length);
    }

    /* access modifiers changed from: private */
    public static int med3(short[] x, short[] y, int a, int b, int c) {
        int t = Short.compare(x[a], x[b]);
        int ab = t == 0 ? Short.compare(y[a], y[b]) : t;
        int t2 = Short.compare(x[a], x[c]);
        int ac = t2 == 0 ? Short.compare(y[a], y[c]) : t2;
        int t3 = Short.compare(x[b], x[c]);
        int bc = t3 == 0 ? Short.compare(y[b], y[c]) : t3;
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* access modifiers changed from: private */
    public static void swap(short[] x, short[] y, int a, int b) {
        short t = x[a];
        short u = y[a];
        x[a] = x[b];
        y[a] = y[b];
        x[b] = t;
        y[b] = u;
    }

    /* access modifiers changed from: private */
    public static void swap(short[] x, short[] y, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, y, a, b);
            i++;
            a++;
            b++;
        }
    }

    private static void selectionSort(short[] a, short[] b, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                int u = Short.compare(a[j], a[m]);
                if (u < 0 || (u == 0 && b[j] < b[m])) {
                    m = j;
                }
            }
            if (m != i) {
                short t = a[i];
                a[i] = a[m];
                a[m] = t;
                short t2 = b[i];
                b[i] = b[m];
                b[m] = t2;
            }
        }
    }

    public static void quickSort(short[] x, short[] y, int from, int to) {
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
        short v = x[m2];
        short w = y[m2];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b <= c) {
                int t = Short.compare(x[b], v);
                int comparison = t == 0 ? Short.compare(y[b], w) : t;
                if (comparison <= 0) {
                    if (comparison == 0) {
                        a++;
                        swap(x, y, a, b);
                    }
                    b++;
                }
            }
            while (c >= b) {
                int t2 = Short.compare(x[c], v);
                int comparison2 = t2 == 0 ? Short.compare(y[c], w) : t2;
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

    public static void quickSort(short[] x, short[] y) {
        ensureSameLength(x, y);
        quickSort(x, y, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrays$ForkJoinQuickSort2 */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrays$ForkJoinQuickSort2.class */
    public static class ForkJoinQuickSort2 extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f3028to;

        /* renamed from: x */
        private final short[] f3029x;

        /* renamed from: y */
        private final short[] f3030y;

        public ForkJoinQuickSort2(short[] x, short[] y, int from, int to) {
            this.from = from;
            this.f3028to = to;
            this.f3029x = x;
            this.f3030y = y;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            short[] x = this.f3029x;
            short[] y = this.f3030y;
            int len = this.f3028to - this.from;
            if (len < 8192) {
                ShortArrays.quickSort(x, y, this.from, this.f3028to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f3028to - 1;
            int s = len / 8;
            int m2 = ShortArrays.med3(x, y, ShortArrays.med3(x, y, l, l + s, l + (2 * s)), ShortArrays.med3(x, y, m - s, m, m + s), ShortArrays.med3(x, y, n - (2 * s), n - s, n));
            short v = x[m2];
            short w = y[m2];
            int a = this.from;
            int b = a;
            int c = this.f3028to - 1;
            int d = c;
            while (true) {
                if (b <= c) {
                    int t = Short.compare(x[b], v);
                    int comparison = t == 0 ? Short.compare(y[b], w) : t;
                    if (comparison <= 0) {
                        if (comparison == 0) {
                            a++;
                            ShortArrays.swap(x, y, a, b);
                        }
                        b++;
                    }
                }
                while (c >= b) {
                    int t2 = Short.compare(x[c], v);
                    int comparison2 = t2 == 0 ? Short.compare(y[c], w) : t2;
                    if (comparison2 < 0) {
                        break;
                    }
                    if (comparison2 == 0) {
                        d--;
                        ShortArrays.swap(x, y, c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                b++;
                c--;
                ShortArrays.swap(x, y, b, c);
            }
            int s2 = Math.min(a - this.from, b - a);
            ShortArrays.swap(x, y, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f3028to - d) - 1);
            ShortArrays.swap(x, y, b, this.f3028to - s3, s3);
            int s4 = b - a;
            int t3 = d - c;
            if (s4 > 1 && t3 > 1) {
                invokeAll(new ForkJoinQuickSort2(x, y, this.from, this.from + s4), new ForkJoinQuickSort2(x, y, this.f3028to - t3, this.f3028to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.f3028to - t3, this.f3028to)});
            }
        }
    }

    public static void parallelQuickSort(short[] x, short[] y, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, y, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort2(x, y, from, to));
        }
    }

    public static void parallelQuickSort(short[] x, short[] y) {
        ensureSameLength(x, y);
        parallelQuickSort(x, y, 0, x.length);
    }

    public static void unstableSort(short[] a, int from, int to) {
        if (to - from >= 1000) {
            radixSort(a, from, to);
        } else {
            quickSort(a, from, to);
        }
    }

    public static void unstableSort(short[] a) {
        unstableSort(a, 0, a.length);
    }

    public static void unstableSort(short[] a, int from, int to, ShortComparator comp) {
        quickSort(a, from, to, comp);
    }

    public static void unstableSort(short[] a, ShortComparator comp) {
        unstableSort(a, 0, a.length, comp);
    }

    public static void mergeSort(short[] a, int from, int to, short[] supp) {
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

    public static void mergeSort(short[] a, int from, int to) {
        mergeSort(a, from, to, (short[]) null);
    }

    public static void mergeSort(short[] a) {
        mergeSort(a, 0, a.length);
    }

    public static void mergeSort(short[] a, int from, int to, ShortComparator comp, short[] supp) {
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

    public static void mergeSort(short[] a, int from, int to, ShortComparator comp) {
        mergeSort(a, from, to, comp, null);
    }

    public static void mergeSort(short[] a, ShortComparator comp) {
        mergeSort(a, 0, a.length, comp);
    }

    public static void stableSort(short[] a, int from, int to) {
        unstableSort(a, from, to);
    }

    public static void stableSort(short[] a) {
        stableSort(a, 0, a.length);
    }

    public static void stableSort(short[] a, int from, int to, ShortComparator comp) {
        mergeSort(a, from, to, comp);
    }

    public static void stableSort(short[] a, ShortComparator comp) {
        stableSort(a, 0, a.length, comp);
    }

    public static int binarySearch(short[] a, int from, int to, short key) {
        int to2 = to - 1;
        while (from <= to2) {
            int mid = (from + to2) >>> 1;
            short midVal = a[mid];
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

    public static int binarySearch(short[] a, short key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static int binarySearch(short[] a, int from, int to, short key, ShortComparator c) {
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

    public static int binarySearch(short[] a, short key, ShortComparator c) {
        return binarySearch(a, 0, a.length, key, c);
    }

    public static void radixSort(short[] a) {
        radixSort(a, 0, a.length);
    }

    public static void radixSort(short[] a, int from, int to) {
        if (to - from < 1024) {
            quickSort(a, from, to);
            return;
        }
        int[] offsetStack = new int[256];
        int[] lengthStack = new int[256];
        int[] levelStack = new int[256];
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
            int signMask = level % 2 == 0 ? 128 : 0;
            int shift = (1 - (level % 2)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int i2 = ((a[i] >>> shift) & 255) ^ signMask;
                count[i2] = count[i2] + 1;
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
                short t = a[i5];
                int c = ((t >>> shift) & 255) ^ signMask;
                if (i5 < end) {
                    while (true) {
                        int d = pos[c] - 1;
                        pos[c] = d;
                        if (d <= i5) {
                            break;
                        }
                        t = a[d];
                        a[d] = t;
                        c = ((t >>> shift) & 255) ^ signMask;
                    }
                    a[i5] = t;
                }
                if (level < 1 && count[c] > 1) {
                    if (count[c] < 1024) {
                        quickSort(a, i5, i5 + count[c]);
                    } else {
                        offsetStack[stackPos] = i5;
                        lengthStack[stackPos] = count[c];
                        stackPos++;
                        levelStack[stackPos] = level + 1;
                    }
                }
                i5 += count[c];
                count[c] = 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrays$Segment */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrays$Segment.class */
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

    public static void parallelRadixSort(short[] a, int from, int to) {
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
                    int signMask = level % 2 == 0 ? 128 : 0;
                    int shift = (1 - (level % 2)) * 8;
                    int i2 = first + length;
                    while (true) {
                        i2--;
                        if (i2 == first) {
                            break;
                        }
                        int i3 = ((a[i2] >>> shift) & 255) ^ signMask;
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
                        short t = a[i6];
                        int c = ((t >>> shift) & 255) ^ signMask;
                        if (i6 < end) {
                            while (true) {
                                int d = pos[c] - 1;
                                pos[c] = d;
                                if (d <= i6) {
                                    break;
                                }
                                t = a[d];
                                a[d] = t;
                                c = ((t >>> shift) & 255) ^ signMask;
                            }
                            a[i6] = t;
                        }
                        if (level < 1 && count[c] > 1) {
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

    public static void parallelRadixSort(short[] a) {
        parallelRadixSort(a, 0, a.length);
    }

    public static void radixSortIndirect(int[] perm, short[] a, boolean stable) {
        radixSortIndirect(perm, a, 0, perm.length, stable);
    }

    public static void radixSortIndirect(int[] perm, short[] a, int from, int to, boolean stable) {
        if (to - from < 1024) {
            quickSortIndirect(perm, a, from, to);
            if (stable) {
                stabilize(perm, a, from, to);
                return;
            }
            return;
        }
        int[] offsetStack = new int[256];
        int[] lengthStack = new int[256];
        int[] levelStack = new int[256];
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
            int signMask = level % 2 == 0 ? 128 : 0;
            int shift = (1 - (level % 2)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int i2 = ((a[perm[i]] >>> shift) & 255) ^ signMask;
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
                    int i6 = ((a[perm[i5]] >>> shift) & 255) ^ signMask;
                    int i7 = pos[i6] - 1;
                    pos[i6] = i7;
                    support[i7] = perm[i5];
                }
                System.arraycopy(support, 0, perm, first, length);
                int p2 = first;
                for (int i8 = 0; i8 <= lastUsed; i8++) {
                    if (level < 1 && count[i8] > 1) {
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
                    int c = ((a[t] >>> shift) & 255) ^ signMask;
                    if (i9 < end) {
                        while (true) {
                            int d = pos[c] - 1;
                            pos[c] = d;
                            if (d <= i9) {
                                break;
                            }
                            t = perm[d];
                            perm[d] = t;
                            c = ((a[t] >>> shift) & 255) ^ signMask;
                        }
                        perm[i9] = t;
                    }
                    if (level < 1 && count[c] > 1) {
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

    public static void parallelRadixSortIndirect(int[] perm, short[] a, int from, int to, boolean stable) {
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
                    int signMask = level % 2 == 0 ? 128 : 0;
                    int shift = (1 - (level % 2)) * 8;
                    int i2 = first + length;
                    while (true) {
                        i2--;
                        if (i2 == first) {
                            break;
                        }
                        int i3 = ((a[perm[i2]] >>> shift) & 255) ^ signMask;
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
                            int i7 = ((a[perm[i6]] >>> shift) & 255) ^ signMask;
                            int i8 = pos[i7] - 1;
                            pos[i7] = i8;
                            support[i8] = perm[i6];
                        }
                        System.arraycopy(support, first, perm, first, length);
                        int p2 = first;
                        for (int i9 = 0; i9 <= lastUsed; i9++) {
                            if (level < 1 && count[i9] > 1) {
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
                            int c = ((a[t] >>> shift) & 255) ^ signMask;
                            if (i10 < end) {
                                while (true) {
                                    int d = pos[c] - 1;
                                    pos[c] = d;
                                    if (d <= i10) {
                                        break;
                                    }
                                    t = perm[d];
                                    perm[d] = t;
                                    c = ((a[t] >>> shift) & 255) ^ signMask;
                                }
                                perm[i10] = t;
                            }
                            if (level < 1 && count[c] > 1) {
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

    public static void parallelRadixSortIndirect(int[] perm, short[] a, boolean stable) {
        parallelRadixSortIndirect(perm, a, 0, a.length, stable);
    }

    public static void radixSort(short[] a, short[] b) {
        ensureSameLength(a, b);
        radixSort(a, b, 0, a.length);
    }

    public static void radixSort(short[] a, short[] b, int from, int to) {
        if (to - from < 1024) {
            quickSort(a, b, from, to);
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
            int signMask = level % 2 == 0 ? 128 : 0;
            short[] k = level < 2 ? a : b;
            int shift = (1 - (level % 2)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int i2 = ((k[i] >>> shift) & 255) ^ signMask;
                count[i2] = count[i2] + 1;
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
                short t = a[i5];
                short u = b[i5];
                int c = ((k[i5] >>> shift) & 255) ^ signMask;
                if (i5 < end) {
                    while (true) {
                        int d = pos[c] - 1;
                        pos[c] = d;
                        if (d <= i5) {
                            break;
                        }
                        c = ((k[d] >>> shift) & 255) ^ signMask;
                        t = a[d];
                        a[d] = t;
                        u = b[d];
                        b[d] = u;
                    }
                    a[i5] = t;
                    b[i5] = u;
                }
                if (level < 3 && count[c] > 1) {
                    if (count[c] < 1024) {
                        quickSort(a, b, i5, i5 + count[c]);
                    } else {
                        offsetStack[stackPos] = i5;
                        lengthStack[stackPos] = count[c];
                        stackPos++;
                        levelStack[stackPos] = level + 1;
                    }
                }
                i5 += count[c];
                count[c] = 0;
            }
        }
    }

    public static void parallelRadixSort(short[] a, short[] b, int from, int to) {
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
                        int signMask = level % 2 == 0 ? 128 : 0;
                        short[] k = level < 2 ? a : b;
                        int shift = (1 - (level % 2)) * 8;
                        int i2 = first + length;
                        while (true) {
                            i2--;
                            if (i2 == first) {
                                break;
                            }
                            int i3 = ((k[i2] >>> shift) & 255) ^ signMask;
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
                            short t = a[i6];
                            short u = b[i6];
                            int c = ((k[i6] >>> shift) & 255) ^ signMask;
                            if (i6 < end) {
                                while (true) {
                                    int d = pos[c] - 1;
                                    pos[c] = d;
                                    if (d <= i6) {
                                        break;
                                    }
                                    c = ((k[d] >>> shift) & 255) ^ signMask;
                                    t = a[d];
                                    u = b[d];
                                    a[d] = t;
                                    b[d] = u;
                                }
                                a[i6] = t;
                                b[i6] = u;
                            }
                            if (level < 3 && count[c] > 1) {
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

    public static void parallelRadixSort(short[] a, short[] b) {
        ensureSameLength(a, b);
        parallelRadixSort(a, b, 0, a.length);
    }

    private static void insertionSortIndirect(int[] perm, short[] a, short[] b, int from, int to) {
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

    public static void radixSortIndirect(int[] perm, short[] a, short[] b, boolean stable) {
        ensureSameLength(a, b);
        radixSortIndirect(perm, a, b, 0, a.length, stable);
    }

    public static void radixSortIndirect(int[] perm, short[] a, short[] b, int from, int to, boolean stable) {
        if (to - from < 64) {
            insertionSortIndirect(perm, a, b, from, to);
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
            int signMask = level % 2 == 0 ? 128 : 0;
            short[] k = level < 2 ? a : b;
            int shift = (1 - (level % 2)) * 8;
            int i = first + length;
            while (true) {
                i--;
                if (i == first) {
                    break;
                }
                int i2 = ((k[perm[i]] >>> shift) & 255) ^ signMask;
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
                    int i6 = ((k[perm[i5]] >>> shift) & 255) ^ signMask;
                    int i7 = pos[i6] - 1;
                    pos[i6] = i7;
                    support[i7] = perm[i5];
                }
                System.arraycopy(support, 0, perm, first, length);
                int p2 = first;
                for (int i8 = 0; i8 < 256; i8++) {
                    if (level < 3 && count[i8] > 1) {
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
                    int c = ((k[t] >>> shift) & 255) ^ signMask;
                    if (i9 < end) {
                        while (true) {
                            int d = pos[c] - 1;
                            pos[c] = d;
                            if (d <= i9) {
                                break;
                            }
                            t = perm[d];
                            perm[d] = t;
                            c = ((k[t] >>> shift) & 255) ^ signMask;
                        }
                        perm[i9] = t;
                    }
                    if (level < 3 && count[c] > 1) {
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

    private static void selectionSort(short[][] a, int from, int to, int level) {
        int layers = a.length;
        int firstLayer = level / 2;
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
                        short u = a[p2][i];
                        a[p2][i] = a[p2][m];
                        a[p2][m] = u;
                    }
                }
            }
        }
    }

    public static void radixSort(short[][] a) {
        radixSort(a, 0, a[0].length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x018c, code lost:
        if (r27 < r0) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x018f, code lost:
        r2 = r0[r28] - 1;
        r0[r28] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x019e, code lost:
        if (r2 <= r27) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a1, code lost:
        r28 = ((r0[r2] >>> r0) & 255) ^ r0;
        r30 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01b5, code lost:
        r30 = r30 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01ba, code lost:
        if (r30 == 0) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01bd, code lost:
        r0 = r0[r30];
        r0[r30] = r6[r30][r2];
        r6[r30][r2] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01df, code lost:
        r30 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01e2, code lost:
        r30 = r30 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01e7, code lost:
        if (r30 == 0) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01ea, code lost:
        r6[r30][r27] = r0[r30];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01fd, code lost:
        if (r0 >= r0) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0206, code lost:
        if (r0[r28] <= 1) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0210, code lost:
        if (r0[r28] >= 64) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0213, code lost:
        selectionSort(r6, r27, r27 + r0[r28], r0 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0228, code lost:
        r0[r12] = r27;
        r0[r12] = r0[r28];
        r12 = r12 + 1;
        r0[r12] = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0245, code lost:
        r27 = r27 + r0[r28];
        r0[r28] = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void radixSort(short[][] r6, int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 604
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.shorts.ShortArrays.radixSort(short[][], int, int):void");
    }

    public static short[] shuffle(short[] a, int from, int to, Random random) {
        int i = to - from;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            short t = a[from + i];
            a[from + i] = a[from + p];
            a[from + p] = t;
        }
    }

    public static short[] shuffle(short[] a, Random random) {
        int i = a.length;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            short t = a[i];
            a[i] = a[p];
            a[p] = t;
        }
    }

    public static short[] reverse(short[] a) {
        int length = a.length;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            short t = a[(length - i) - 1];
            a[(length - i) - 1] = a[i];
            a[i] = t;
        }
    }

    public static short[] reverse(short[] a, int from, int to) {
        int length = to - from;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            short t = a[((from + length) - i) - 1];
            a[((from + length) - i) - 1] = a[from + i];
            a[from + i] = t;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortArrays$ArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortArrays$ArrayHashStrategy.class */
    private static final class ArrayHashStrategy implements Hash.Strategy<short[]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private ArrayHashStrategy() {
        }

        public int hashCode(short[] o) {
            return java.util.Arrays.hashCode(o);
        }

        public boolean equals(short[] a, short[] b) {
            return java.util.Arrays.equals(a, b);
        }
    }
}
