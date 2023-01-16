package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import p014it.unimi.dsi.fastutil.Arrays;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrays.class */
public final class BooleanArrays {
    private static final int QUICKSORT_NO_REC = 16;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int QUICKSORT_MEDIAN_OF_9 = 128;
    private static final int MERGESORT_NO_REC = 16;
    public static final boolean[] EMPTY_ARRAY = new boolean[0];
    public static final boolean[] DEFAULT_EMPTY_ARRAY = new boolean[0];
    public static final Hash.Strategy<boolean[]> HASH_STRATEGY = new ArrayHashStrategy();

    private BooleanArrays() {
    }

    public static boolean[] forceCapacity(boolean[] array, int length, int preserve) {
        boolean[] t = new boolean[length];
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static boolean[] ensureCapacity(boolean[] array, int length) {
        return ensureCapacity(array, length, array.length);
    }

    public static boolean[] ensureCapacity(boolean[] array, int length, int preserve) {
        return length > array.length ? forceCapacity(array, length, preserve) : array;
    }

    public static boolean[] grow(boolean[] array, int length) {
        return grow(array, length, array.length);
    }

    public static boolean[] grow(boolean[] array, int length, int preserve) {
        if (length <= array.length) {
            return array;
        }
        boolean[] t = new boolean[(int) Math.max(Math.min(((long) array.length) + ((long) (array.length >> 1)), 2147483639L), (long) length)];
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static boolean[] trim(boolean[] array, int length) {
        if (length >= array.length) {
            return array;
        }
        boolean[] t = length == 0 ? EMPTY_ARRAY : new boolean[length];
        System.arraycopy(array, 0, t, 0, length);
        return t;
    }

    public static boolean[] setLength(boolean[] array, int length) {
        return length == array.length ? array : length < array.length ? trim(array, length) : ensureCapacity(array, length);
    }

    public static boolean[] copy(boolean[] array, int offset, int length) {
        ensureOffsetLength(array, offset, length);
        boolean[] a = length == 0 ? EMPTY_ARRAY : new boolean[length];
        System.arraycopy(array, offset, a, 0, length);
        return a;
    }

    public static boolean[] copy(boolean[] array) {
        return (boolean[]) array.clone();
    }

    @Deprecated
    public static void fill(boolean[] array, boolean value) {
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
    public static void fill(boolean[] array, int from, int to, boolean value) {
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
    public static boolean equals(boolean[] a1, boolean[] a2) {
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

    public static void ensureFromTo(boolean[] a, int from, int to) {
        Arrays.ensureFromTo(a.length, from, to);
    }

    public static void ensureOffsetLength(boolean[] a, int offset, int length) {
        Arrays.ensureOffsetLength(a.length, offset, length);
    }

    public static void ensureSameLength(boolean[] a, boolean[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array size mismatch: " + a.length + " != " + b.length);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    public static void swap(boolean[] x, int a, int b) {
        boolean t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void swap(boolean[] x, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* access modifiers changed from: private */
    public static int med3(boolean[] x, int a, int b, int c, BooleanComparator comp) {
        int ab = comp.compare(x[a], x[b]);
        int ac = comp.compare(x[a], x[c]);
        int bc = comp.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void selectionSort(boolean[] a, int from, int to, BooleanComparator comp) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (comp.compare(a[j], a[m]) < 0) {
                    m = j;
                }
            }
            if (m != i) {
                boolean u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static void insertionSort(boolean[] a, int from, int to, BooleanComparator comp) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                boolean t = a[i];
                int j = i;
                boolean u = a[j - 1];
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

    public static void quickSort(boolean[] x, int from, int to, BooleanComparator comp) {
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
        boolean v = x[med3(x, l, m, n, comp)];
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

    public static void quickSort(boolean[] x, BooleanComparator comp) {
        quickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1053to;

        /* renamed from: x */
        private final boolean[] f1054x;
        private final BooleanComparator comp;

        public ForkJoinQuickSortComp(boolean[] x, int from, int to, BooleanComparator comp) {
            this.from = from;
            this.f1053to = to;
            this.f1054x = x;
            this.comp = comp;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            boolean[] x = this.f1054x;
            int len = this.f1053to - this.from;
            if (len < 8192) {
                BooleanArrays.quickSort(x, this.from, this.f1053to, this.comp);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1053to - 1;
            int s = len / 8;
            boolean v = x[BooleanArrays.med3(x, BooleanArrays.med3(x, l, l + s, l + (2 * s), this.comp), BooleanArrays.med3(x, m - s, m, m + s, this.comp), BooleanArrays.med3(x, n - (2 * s), n - s, n, this.comp), this.comp)];
            int a = this.from;
            int b = a;
            int c = this.f1053to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = this.comp.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = this.comp.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            BooleanArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    BooleanArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        BooleanArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            BooleanArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f1053to - d) - 1);
            BooleanArrays.swap(x, b, this.f1053to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp), new ForkJoinQuickSortComp(x, this.f1053to - t, this.f1053to, this.comp));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.f1053to - t, this.f1053to, this.comp)});
            }
        }
    }

    public static void parallelQuickSort(boolean[] x, int from, int to, BooleanComparator comp) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static void parallelQuickSort(boolean[] x, BooleanComparator comp) {
        parallelQuickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: private */
    public static int med3(boolean[] x, int a, int b, int c) {
        int ab = Boolean.compare(x[a], x[b]);
        int ac = Boolean.compare(x[a], x[c]);
        int bc = Boolean.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void selectionSort(boolean[] a, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (!a[j] && a[m]) {
                    m = j;
                }
            }
            if (m != i) {
                boolean u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static void insertionSort(boolean[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                boolean t = a[i];
                int j = i;
                boolean u = a[j - 1];
                while (true) {
                    if (!t && u) {
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

    public static void quickSort(boolean[] x, int from, int to) {
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
        boolean v = x[med3(x, l, m, n)];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = Boolean.compare(x[b], v)) > 0) {
                while (c >= b && (comparison = Boolean.compare(x[c], v)) >= 0) {
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

    public static void quickSort(boolean[] x) {
        quickSort(x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1048to;

        /* renamed from: x */
        private final boolean[] f1049x;

        public ForkJoinQuickSort(boolean[] x, int from, int to) {
            this.from = from;
            this.f1048to = to;
            this.f1049x = x;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            boolean[] x = this.f1049x;
            int len = this.f1048to - this.from;
            if (len < 8192) {
                BooleanArrays.quickSort(x, this.from, this.f1048to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1048to - 1;
            int s = len / 8;
            boolean v = x[BooleanArrays.med3(x, BooleanArrays.med3(x, l, l + s, l + (2 * s)), BooleanArrays.med3(x, m - s, m, m + s), BooleanArrays.med3(x, n - (2 * s), n - s, n))];
            int a = this.from;
            int b = a;
            int c = this.f1048to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = Boolean.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = Boolean.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            BooleanArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    BooleanArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        BooleanArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            BooleanArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f1048to - d) - 1);
            BooleanArrays.swap(x, b, this.f1048to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSort(x, this.from, this.from + s4), new ForkJoinQuickSort(x, this.f1048to - t, this.f1048to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.f1048to - t, this.f1048to)});
            }
        }
    }

    public static void parallelQuickSort(boolean[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static void parallelQuickSort(boolean[] x) {
        parallelQuickSort(x, 0, x.length);
    }

    /* access modifiers changed from: private */
    public static int med3Indirect(int[] perm, boolean[] x, int a, int b, int c) {
        boolean aa = x[perm[a]];
        boolean bb = x[perm[b]];
        boolean cc = x[perm[c]];
        int ab = Boolean.compare(aa, bb);
        int ac = Boolean.compare(aa, cc);
        int bc = Boolean.compare(bb, cc);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static void insertionSortIndirect(int[] perm, boolean[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                int t = perm[i];
                int j = i;
                int u = perm[j - 1];
                while (true) {
                    if (!a[t] && a[u]) {
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

    public static void quickSortIndirect(int[] perm, boolean[] x, int from, int to) {
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
        boolean v = x[perm[med3Indirect(perm, x, l, m, n)]];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = Boolean.compare(x[perm[b]], v)) > 0) {
                while (c >= b && (comparison = Boolean.compare(x[perm[c]], v)) >= 0) {
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

    public static void quickSortIndirect(int[] perm, boolean[] x) {
        quickSortIndirect(perm, x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrays$ForkJoinQuickSortIndirect */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrays$ForkJoinQuickSortIndirect.class */
    public static class ForkJoinQuickSortIndirect extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1055to;
        private final int[] perm;

        /* renamed from: x */
        private final boolean[] f1056x;

        public ForkJoinQuickSortIndirect(int[] perm, boolean[] x, int from, int to) {
            this.from = from;
            this.f1055to = to;
            this.f1056x = x;
            this.perm = perm;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            boolean[] x = this.f1056x;
            int len = this.f1055to - this.from;
            if (len < 8192) {
                BooleanArrays.quickSortIndirect(this.perm, x, this.from, this.f1055to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1055to - 1;
            int s = len / 8;
            boolean v = x[this.perm[BooleanArrays.med3Indirect(this.perm, x, BooleanArrays.med3Indirect(this.perm, x, l, l + s, l + (2 * s)), BooleanArrays.med3Indirect(this.perm, x, m - s, m, m + s), BooleanArrays.med3Indirect(this.perm, x, n - (2 * s), n - s, n))]];
            int a = this.from;
            int b = a;
            int c = this.f1055to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = Boolean.compare(x[this.perm[b]], v)) > 0) {
                    while (c >= b && (comparison = Boolean.compare(x[this.perm[c]], v)) >= 0) {
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
            int s3 = Math.min(d - c, (this.f1055to - d) - 1);
            IntArrays.swap(this.perm, b, this.f1055to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4), new ForkJoinQuickSortIndirect(this.perm, x, this.f1055to - t, this.f1055to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.f1055to - t, this.f1055to)});
            }
        }
    }

    public static void parallelQuickSortIndirect(int[] perm, boolean[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSortIndirect(perm, x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSortIndirect(perm, x, from, to));
        }
    }

    public static void parallelQuickSortIndirect(int[] perm, boolean[] x) {
        parallelQuickSortIndirect(perm, x, 0, x.length);
    }

    public static void stabilize(int[] perm, boolean[] x, int from, int to) {
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

    public static void stabilize(int[] perm, boolean[] x) {
        stabilize(perm, x, 0, perm.length);
    }

    /* access modifiers changed from: private */
    public static int med3(boolean[] x, boolean[] y, int a, int b, int c) {
        int t = Boolean.compare(x[a], x[b]);
        int ab = t == 0 ? Boolean.compare(y[a], y[b]) : t;
        int t2 = Boolean.compare(x[a], x[c]);
        int ac = t2 == 0 ? Boolean.compare(y[a], y[c]) : t2;
        int t3 = Boolean.compare(x[b], x[c]);
        int bc = t3 == 0 ? Boolean.compare(y[b], y[c]) : t3;
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* access modifiers changed from: private */
    public static void swap(boolean[] x, boolean[] y, int a, int b) {
        boolean t = x[a];
        boolean u = y[a];
        x[a] = x[b];
        y[a] = y[b];
        x[b] = t;
        y[b] = u;
    }

    /* access modifiers changed from: private */
    public static void swap(boolean[] x, boolean[] y, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, y, a, b);
            i++;
            a++;
            b++;
        }
    }

    private static void selectionSort(boolean[] a, boolean[] b, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                int u = Boolean.compare(a[j], a[m]);
                if (u < 0 || (u == 0 && !b[j] && b[m])) {
                    m = j;
                }
            }
            if (m != i) {
                boolean t = a[i];
                a[i] = a[m];
                a[m] = t;
                boolean t2 = b[i];
                b[i] = b[m];
                b[m] = t2;
            }
        }
    }

    public static void quickSort(boolean[] x, boolean[] y, int from, int to) {
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
        boolean v = x[m2];
        boolean w = y[m2];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b <= c) {
                int t = Boolean.compare(x[b], v);
                int comparison = t == 0 ? Boolean.compare(y[b], w) : t;
                if (comparison <= 0) {
                    if (comparison == 0) {
                        a++;
                        swap(x, y, a, b);
                    }
                    b++;
                }
            }
            while (c >= b) {
                int t2 = Boolean.compare(x[c], v);
                int comparison2 = t2 == 0 ? Boolean.compare(y[c], w) : t2;
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

    public static void quickSort(boolean[] x, boolean[] y) {
        ensureSameLength(x, y);
        quickSort(x, y, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrays$ForkJoinQuickSort2 */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrays$ForkJoinQuickSort2.class */
    public static class ForkJoinQuickSort2 extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1050to;

        /* renamed from: x */
        private final boolean[] f1051x;

        /* renamed from: y */
        private final boolean[] f1052y;

        public ForkJoinQuickSort2(boolean[] x, boolean[] y, int from, int to) {
            this.from = from;
            this.f1050to = to;
            this.f1051x = x;
            this.f1052y = y;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            boolean[] x = this.f1051x;
            boolean[] y = this.f1052y;
            int len = this.f1050to - this.from;
            if (len < 8192) {
                BooleanArrays.quickSort(x, y, this.from, this.f1050to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1050to - 1;
            int s = len / 8;
            int m2 = BooleanArrays.med3(x, y, BooleanArrays.med3(x, y, l, l + s, l + (2 * s)), BooleanArrays.med3(x, y, m - s, m, m + s), BooleanArrays.med3(x, y, n - (2 * s), n - s, n));
            boolean v = x[m2];
            boolean w = y[m2];
            int a = this.from;
            int b = a;
            int c = this.f1050to - 1;
            int d = c;
            while (true) {
                if (b <= c) {
                    int t = Boolean.compare(x[b], v);
                    int comparison = t == 0 ? Boolean.compare(y[b], w) : t;
                    if (comparison <= 0) {
                        if (comparison == 0) {
                            a++;
                            BooleanArrays.swap(x, y, a, b);
                        }
                        b++;
                    }
                }
                while (c >= b) {
                    int t2 = Boolean.compare(x[c], v);
                    int comparison2 = t2 == 0 ? Boolean.compare(y[c], w) : t2;
                    if (comparison2 < 0) {
                        break;
                    }
                    if (comparison2 == 0) {
                        d--;
                        BooleanArrays.swap(x, y, c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                b++;
                c--;
                BooleanArrays.swap(x, y, b, c);
            }
            int s2 = Math.min(a - this.from, b - a);
            BooleanArrays.swap(x, y, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f1050to - d) - 1);
            BooleanArrays.swap(x, y, b, this.f1050to - s3, s3);
            int s4 = b - a;
            int t3 = d - c;
            if (s4 > 1 && t3 > 1) {
                invokeAll(new ForkJoinQuickSort2(x, y, this.from, this.from + s4), new ForkJoinQuickSort2(x, y, this.f1050to - t3, this.f1050to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.f1050to - t3, this.f1050to)});
            }
        }
    }

    public static void parallelQuickSort(boolean[] x, boolean[] y, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, y, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort2(x, y, from, to));
        }
    }

    public static void parallelQuickSort(boolean[] x, boolean[] y) {
        ensureSameLength(x, y);
        parallelQuickSort(x, y, 0, x.length);
    }

    public static void unstableSort(boolean[] a, int from, int to) {
        quickSort(a, from, to);
    }

    public static void unstableSort(boolean[] a) {
        unstableSort(a, 0, a.length);
    }

    public static void unstableSort(boolean[] a, int from, int to, BooleanComparator comp) {
        quickSort(a, from, to, comp);
    }

    public static void unstableSort(boolean[] a, BooleanComparator comp) {
        unstableSort(a, 0, a.length, comp);
    }

    public static void mergeSort(boolean[] a, int from, int to, boolean[] supp) {
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
        if (!supp[mid - 1] || supp[mid]) {
            System.arraycopy(supp, from, a, from, len);
            return;
        }
        int p = from;
        int q = mid;
        for (int i = from; i < to; i++) {
            if (q >= to || (p < mid && (!supp[p] || supp[q]))) {
                p++;
                a[i] = supp[p];
            } else {
                q++;
                a[i] = supp[q];
            }
        }
    }

    public static void mergeSort(boolean[] a, int from, int to) {
        mergeSort(a, from, to, (boolean[]) null);
    }

    public static void mergeSort(boolean[] a) {
        mergeSort(a, 0, a.length);
    }

    public static void mergeSort(boolean[] a, int from, int to, BooleanComparator comp, boolean[] supp) {
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

    public static void mergeSort(boolean[] a, int from, int to, BooleanComparator comp) {
        mergeSort(a, from, to, comp, null);
    }

    public static void mergeSort(boolean[] a, BooleanComparator comp) {
        mergeSort(a, 0, a.length, comp);
    }

    public static void stableSort(boolean[] a, int from, int to) {
        unstableSort(a, from, to);
    }

    public static void stableSort(boolean[] a) {
        stableSort(a, 0, a.length);
    }

    public static void stableSort(boolean[] a, int from, int to, BooleanComparator comp) {
        mergeSort(a, from, to, comp);
    }

    public static void stableSort(boolean[] a, BooleanComparator comp) {
        stableSort(a, 0, a.length, comp);
    }

    public static boolean[] shuffle(boolean[] a, int from, int to, Random random) {
        int i = to - from;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            boolean t = a[from + i];
            a[from + i] = a[from + p];
            a[from + p] = t;
        }
    }

    public static boolean[] shuffle(boolean[] a, Random random) {
        int i = a.length;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            boolean t = a[i];
            a[i] = a[p];
            a[p] = t;
        }
    }

    public static boolean[] reverse(boolean[] a) {
        int length = a.length;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            boolean t = a[(length - i) - 1];
            a[(length - i) - 1] = a[i];
            a[i] = t;
        }
    }

    public static boolean[] reverse(boolean[] a, int from, int to) {
        int length = to - from;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            boolean t = a[((from + length) - i) - 1];
            a[((from + length) - i) - 1] = a[from + i];
            a[from + i] = t;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanArrays$ArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanArrays$ArrayHashStrategy.class */
    private static final class ArrayHashStrategy implements Hash.Strategy<boolean[]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private ArrayHashStrategy() {
        }

        public int hashCode(boolean[] o) {
            return java.util.Arrays.hashCode(o);
        }

        public boolean equals(boolean[] a, boolean[] b) {
            return java.util.Arrays.equals(a, b);
        }
    }
}
