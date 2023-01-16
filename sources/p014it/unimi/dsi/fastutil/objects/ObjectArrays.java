package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import p014it.unimi.dsi.fastutil.Arrays;
import p014it.unimi.dsi.fastutil.Hash;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrays.class */
public final class ObjectArrays {
    private static final int QUICKSORT_NO_REC = 16;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int QUICKSORT_MEDIAN_OF_9 = 128;
    private static final int MERGESORT_NO_REC = 16;
    public static final Object[] EMPTY_ARRAY = new Object[0];
    public static final Object[] DEFAULT_EMPTY_ARRAY = new Object[0];
    public static final Hash.Strategy HASH_STRATEGY = new ArrayHashStrategy();

    private ObjectArrays() {
    }

    private static <K> K[] newArray(K[] prototype, int length) {
        Class<?> klass = prototype.getClass();
        if (klass == Object[].class) {
            return length == 0 ? (K[]) EMPTY_ARRAY : (K[]) new Object[length];
        }
        return (K[]) ((Object[]) Array.newInstance(klass.getComponentType(), length));
    }

    public static <K> K[] forceCapacity(K[] array, int length, int preserve) {
        K[] t = (K[]) newArray(array, length);
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static <K> K[] ensureCapacity(K[] array, int length) {
        return (K[]) ensureCapacity(array, length, array.length);
    }

    public static <K> K[] ensureCapacity(K[] array, int length, int preserve) {
        return length > array.length ? (K[]) forceCapacity(array, length, preserve) : array;
    }

    public static <K> K[] grow(K[] array, int length) {
        return (K[]) grow(array, length, array.length);
    }

    public static <K> K[] grow(K[] array, int length, int preserve) {
        if (length <= array.length) {
            return array;
        }
        K[] t = (K[]) newArray(array, (int) Math.max(Math.min(((long) array.length) + ((long) (array.length >> 1)), 2147483639L), (long) length));
        System.arraycopy(array, 0, t, 0, preserve);
        return t;
    }

    public static <K> K[] trim(K[] array, int length) {
        if (length >= array.length) {
            return array;
        }
        K[] t = (K[]) newArray(array, length);
        System.arraycopy(array, 0, t, 0, length);
        return t;
    }

    public static <K> K[] setLength(K[] array, int length) {
        return length == array.length ? array : length < array.length ? (K[]) trim(array, length) : (K[]) ensureCapacity(array, length);
    }

    public static <K> K[] copy(K[] array, int offset, int length) {
        ensureOffsetLength(array, offset, length);
        K[] a = (K[]) newArray(array, length);
        System.arraycopy(array, offset, a, 0, length);
        return a;
    }

    public static <K> K[] copy(K[] array) {
        return (K[]) ((Object[]) array.clone());
    }

    @Deprecated
    public static <K> void fill(K[] array, K value) {
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
    public static <K> void fill(K[] array, int from, int to, K value) {
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
    public static <K> boolean equals(K[] a1, K[] a2) {
        int i = a1.length;
        if (i != a2.length) {
            return false;
        }
        do {
            i--;
            if (i == 0) {
                return true;
            }
        } while (Objects.equals(a1[i], a2[i]));
        return false;
    }

    public static <K> void ensureFromTo(K[] a, int from, int to) {
        Arrays.ensureFromTo(a.length, from, to);
    }

    public static <K> void ensureOffsetLength(K[] a, int offset, int length) {
        Arrays.ensureOffsetLength(a.length, offset, length);
    }

    public static <K> void ensureSameLength(K[] a, K[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array size mismatch: " + a.length + " != " + b.length);
        }
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    public static <K> void swap(K[] x, int a, int b) {
        K t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static <K> void swap(K[] x, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, a, b);
            i++;
            a++;
            b++;
        }
    }

    /* access modifiers changed from: private */
    public static <K> int med3(K[] x, int a, int b, int c, Comparator<K> comp) {
        int ab = comp.compare(x[a], x[b]);
        int ac = comp.compare(x[a], x[c]);
        int bc = comp.compare(x[b], x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static <K> void selectionSort(K[] a, int from, int to, Comparator<K> comp) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (comp.compare(a[j], a[m]) < 0) {
                    m = j;
                }
            }
            if (m != i) {
                K u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static <K> void insertionSort(K[] a, int from, int to, Comparator<K> comp) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                K t = a[i];
                int j = i;
                K u = a[j - 1];
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

    public static <K> void quickSort(K[] x, int from, int to, Comparator<K> comp) {
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
        K v = x[med3(x, l, m, n, comp)];
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

    public static <K> void quickSort(K[] x, Comparator<K> comp) {
        quickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrays$ForkJoinQuickSortComp */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrays$ForkJoinQuickSortComp.class */
    public static class ForkJoinQuickSortComp<K> extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f2690to;

        /* renamed from: x */
        private final K[] f2691x;
        private final Comparator<K> comp;

        public ForkJoinQuickSortComp(K[] x, int from, int to, Comparator<K> comp) {
            this.from = from;
            this.f2690to = to;
            this.f2691x = x;
            this.comp = comp;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            K[] x = this.f2691x;
            int len = this.f2690to - this.from;
            if (len < 8192) {
                ObjectArrays.quickSort(x, this.from, this.f2690to, this.comp);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f2690to - 1;
            int s = len / 8;
            K v = x[ObjectArrays.med3(x, ObjectArrays.med3(x, l, l + s, l + (2 * s), this.comp), ObjectArrays.med3(x, m - s, m, m + s, this.comp), ObjectArrays.med3(x, n - (2 * s), n - s, n, this.comp), this.comp)];
            int a = this.from;
            int b = a;
            int c = this.f2690to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = this.comp.compare(x[b], v)) > 0) {
                    while (c >= b && (comparison = this.comp.compare(x[c], v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            ObjectArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    ObjectArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        ObjectArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            ObjectArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f2690to - d) - 1);
            ObjectArrays.swap(x, b, this.f2690to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp), new ForkJoinQuickSortComp(x, this.f2690to - t, this.f2690to, this.comp));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.from, this.from + s4, this.comp)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortComp(x, this.f2690to - t, this.f2690to, this.comp)});
            }
        }
    }

    public static <K> void parallelQuickSort(K[] x, int from, int to, Comparator<K> comp) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to, comp);
        } else {
            pool.invoke(new ForkJoinQuickSortComp(x, from, to, comp));
        }
    }

    public static <K> void parallelQuickSort(K[] x, Comparator<K> comp) {
        parallelQuickSort(x, 0, x.length, comp);
    }

    /* access modifiers changed from: private */
    public static <K> int med3(K[] x, int a, int b, int c) {
        int ab = ((Comparable) x[a]).compareTo(x[b]);
        int ac = ((Comparable) x[a]).compareTo(x[c]);
        int bc = ((Comparable) x[b]).compareTo(x[c]);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static <K> void selectionSort(K[] a, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                if (((Comparable) a[j]).compareTo(a[m]) < 0) {
                    m = j;
                }
            }
            if (m != i) {
                K u = a[i];
                a[i] = a[m];
                a[m] = u;
            }
        }
    }

    private static <K> void insertionSort(K[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                K t = a[i];
                int j = i;
                K u = a[j - 1];
                while (true) {
                    if (((Comparable) t).compareTo(u) < 0) {
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

    public static <K> void quickSort(K[] x, int from, int to) {
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
        K v = x[med3(x, l, m, n)];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = ((Comparable) x[b]).compareTo(v)) > 0) {
                while (c >= b && (comparison = ((Comparable) x[c]).compareTo(v)) >= 0) {
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

    public static <K> void quickSort(K[] x) {
        quickSort(x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrays$ForkJoinQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrays$ForkJoinQuickSort.class */
    public static class ForkJoinQuickSort<K> extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f2685to;

        /* renamed from: x */
        private final K[] f2686x;

        public ForkJoinQuickSort(K[] x, int from, int to) {
            this.from = from;
            this.f2685to = to;
            this.f2686x = x;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            K[] x = this.f2686x;
            int len = this.f2685to - this.from;
            if (len < 8192) {
                ObjectArrays.quickSort(x, this.from, this.f2685to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f2685to - 1;
            int s = len / 8;
            K v = x[ObjectArrays.med3(x, ObjectArrays.med3(x, l, l + s, l + (2 * s)), ObjectArrays.med3(x, m - s, m, m + s), ObjectArrays.med3(x, n - (2 * s), n - s, n))];
            int a = this.from;
            int b = a;
            int c = this.f2685to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = ((Comparable) x[b]).compareTo(v)) > 0) {
                    while (c >= b && (comparison = ((Comparable) x[c]).compareTo(v)) >= 0) {
                        if (comparison == 0) {
                            d--;
                            ObjectArrays.swap(x, c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    b++;
                    c--;
                    ObjectArrays.swap(x, b, c);
                } else {
                    if (comparison2 == 0) {
                        a++;
                        ObjectArrays.swap(x, a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            ObjectArrays.swap(x, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f2685to - d) - 1);
            ObjectArrays.swap(x, b, this.f2685to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSort(x, this.from, this.from + s4), new ForkJoinQuickSort(x, this.f2685to - t, this.f2685to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort(x, this.f2685to - t, this.f2685to)});
            }
        }
    }

    public static <K> void parallelQuickSort(K[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort(x, from, to));
        }
    }

    public static <K> void parallelQuickSort(K[] x) {
        parallelQuickSort(x, 0, x.length);
    }

    /* access modifiers changed from: private */
    public static <K> int med3Indirect(int[] perm, K[] x, int a, int b, int c) {
        K aa = x[perm[a]];
        K bb = x[perm[b]];
        K cc = x[perm[c]];
        int ab = ((Comparable) aa).compareTo(bb);
        int ac = ((Comparable) aa).compareTo(cc);
        int bc = ((Comparable) bb).compareTo(cc);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static <K> void insertionSortIndirect(int[] perm, K[] a, int from, int to) {
        int i = from;
        while (true) {
            i++;
            if (i < to) {
                int t = perm[i];
                int j = i;
                int u = perm[j - 1];
                while (true) {
                    if (((Comparable) a[t]).compareTo(a[u]) < 0) {
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

    public static <K> void quickSortIndirect(int[] perm, K[] x, int from, int to) {
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
        K v = x[perm[med3Indirect(perm, x, l, m, n)]];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = ((Comparable) x[perm[b]]).compareTo(v)) > 0) {
                while (c >= b && (comparison = ((Comparable) x[perm[c]]).compareTo(v)) >= 0) {
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

    public static <K> void quickSortIndirect(int[] perm, K[] x) {
        quickSortIndirect(perm, x, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrays$ForkJoinQuickSortIndirect */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrays$ForkJoinQuickSortIndirect.class */
    public static class ForkJoinQuickSortIndirect<K> extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f2692to;
        private final int[] perm;

        /* renamed from: x */
        private final K[] f2693x;

        public ForkJoinQuickSortIndirect(int[] perm, K[] x, int from, int to) {
            this.from = from;
            this.f2692to = to;
            this.f2693x = x;
            this.perm = perm;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            K[] x = this.f2693x;
            int len = this.f2692to - this.from;
            if (len < 8192) {
                ObjectArrays.quickSortIndirect(this.perm, x, this.from, this.f2692to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f2692to - 1;
            int s = len / 8;
            K v = x[this.perm[ObjectArrays.med3Indirect(this.perm, x, ObjectArrays.med3Indirect(this.perm, x, l, l + s, l + (2 * s)), ObjectArrays.med3Indirect(this.perm, x, m - s, m, m + s), ObjectArrays.med3Indirect(this.perm, x, n - (2 * s), n - s, n))]];
            int a = this.from;
            int b = a;
            int c = this.f2692to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = ((Comparable) x[this.perm[b]]).compareTo(v)) > 0) {
                    while (c >= b && (comparison = ((Comparable) x[this.perm[c]]).compareTo(v)) >= 0) {
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
            int s3 = Math.min(d - c, (this.f2692to - d) - 1);
            IntArrays.swap(this.perm, b, this.f2692to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4), new ForkJoinQuickSortIndirect(this.perm, x, this.f2692to - t, this.f2692to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSortIndirect(this.perm, x, this.f2692to - t, this.f2692to)});
            }
        }
    }

    public static <K> void parallelQuickSortIndirect(int[] perm, K[] x, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSortIndirect(perm, x, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSortIndirect(perm, x, from, to));
        }
    }

    public static <K> void parallelQuickSortIndirect(int[] perm, K[] x) {
        parallelQuickSortIndirect(perm, x, 0, x.length);
    }

    public static <K> void stabilize(int[] perm, K[] x, int from, int to) {
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

    public static <K> void stabilize(int[] perm, K[] x) {
        stabilize(perm, x, 0, perm.length);
    }

    /* access modifiers changed from: private */
    public static <K> int med3(K[] x, K[] y, int a, int b, int c) {
        int t = ((Comparable) x[a]).compareTo(x[b]);
        int ab = t == 0 ? ((Comparable) y[a]).compareTo(y[b]) : t;
        int t2 = ((Comparable) x[a]).compareTo(x[c]);
        int ac = t2 == 0 ? ((Comparable) y[a]).compareTo(y[c]) : t2;
        int t3 = ((Comparable) x[b]).compareTo(x[c]);
        int bc = t3 == 0 ? ((Comparable) y[b]).compareTo(y[c]) : t3;
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    /* access modifiers changed from: private */
    public static <K> void swap(K[] x, K[] y, int a, int b) {
        K t = x[a];
        K u = y[a];
        x[a] = x[b];
        y[a] = y[b];
        x[b] = t;
        y[b] = u;
    }

    /* access modifiers changed from: private */
    public static <K> void swap(K[] x, K[] y, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swap(x, y, a, b);
            i++;
            a++;
            b++;
        }
    }

    private static <K> void selectionSort(K[] a, K[] b, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            int m = i;
            for (int j = i + 1; j < to; j++) {
                int u = ((Comparable) a[j]).compareTo(a[m]);
                if (u < 0 || (u == 0 && ((Comparable) b[j]).compareTo(b[m]) < 0)) {
                    m = j;
                }
            }
            if (m != i) {
                K t = a[i];
                a[i] = a[m];
                a[m] = t;
                K t2 = b[i];
                b[i] = b[m];
                b[m] = t2;
            }
        }
    }

    public static <K> void quickSort(K[] x, K[] y, int from, int to) {
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
        K v = x[m2];
        K w = y[m2];
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b <= c) {
                int t = ((Comparable) x[b]).compareTo(v);
                int comparison = t == 0 ? ((Comparable) y[b]).compareTo(w) : t;
                if (comparison <= 0) {
                    if (comparison == 0) {
                        a++;
                        swap(x, y, a, b);
                    }
                    b++;
                }
            }
            while (c >= b) {
                int t2 = ((Comparable) x[c]).compareTo(v);
                int comparison2 = t2 == 0 ? ((Comparable) y[c]).compareTo(w) : t2;
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

    public static <K> void quickSort(K[] x, K[] y) {
        ensureSameLength(x, y);
        quickSort(x, y, 0, x.length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrays$ForkJoinQuickSort2 */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrays$ForkJoinQuickSort2.class */
    public static class ForkJoinQuickSort2<K> extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f2687to;

        /* renamed from: x */
        private final K[] f2688x;

        /* renamed from: y */
        private final K[] f2689y;

        public ForkJoinQuickSort2(K[] x, K[] y, int from, int to) {
            this.from = from;
            this.f2687to = to;
            this.f2688x = x;
            this.f2689y = y;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            K[] x = this.f2688x;
            K[] y = this.f2689y;
            int len = this.f2687to - this.from;
            if (len < 8192) {
                ObjectArrays.quickSort(x, y, this.from, this.f2687to);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f2687to - 1;
            int s = len / 8;
            int m2 = ObjectArrays.med3(x, y, ObjectArrays.med3(x, y, l, l + s, l + (2 * s)), ObjectArrays.med3(x, y, m - s, m, m + s), ObjectArrays.med3(x, y, n - (2 * s), n - s, n));
            K v = x[m2];
            K w = y[m2];
            int a = this.from;
            int b = a;
            int c = this.f2687to - 1;
            int d = c;
            while (true) {
                if (b <= c) {
                    int t = ((Comparable) x[b]).compareTo(v);
                    int comparison = t == 0 ? ((Comparable) y[b]).compareTo(w) : t;
                    if (comparison <= 0) {
                        if (comparison == 0) {
                            a++;
                            ObjectArrays.swap(x, y, a, b);
                        }
                        b++;
                    }
                }
                while (c >= b) {
                    int t2 = ((Comparable) x[c]).compareTo(v);
                    int comparison2 = t2 == 0 ? ((Comparable) y[c]).compareTo(w) : t2;
                    if (comparison2 < 0) {
                        break;
                    }
                    if (comparison2 == 0) {
                        d--;
                        ObjectArrays.swap(x, y, c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                b++;
                c--;
                ObjectArrays.swap(x, y, b, c);
            }
            int s2 = Math.min(a - this.from, b - a);
            ObjectArrays.swap(x, y, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f2687to - d) - 1);
            ObjectArrays.swap(x, y, b, this.f2687to - s3, s3);
            int s4 = b - a;
            int t3 = d - c;
            if (s4 > 1 && t3 > 1) {
                invokeAll(new ForkJoinQuickSort2(x, y, this.from, this.from + s4), new ForkJoinQuickSort2(x, y, this.f2687to - t3, this.f2687to));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.from, this.from + s4)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinQuickSort2(x, y, this.f2687to - t3, this.f2687to)});
            }
        }
    }

    public static <K> void parallelQuickSort(K[] x, K[] y, int from, int to) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(x, y, from, to);
        } else {
            pool.invoke(new ForkJoinQuickSort2(x, y, from, to));
        }
    }

    public static <K> void parallelQuickSort(K[] x, K[] y) {
        ensureSameLength(x, y);
        parallelQuickSort(x, y, 0, x.length);
    }

    public static <K> void unstableSort(K[] a, int from, int to) {
        quickSort(a, from, to);
    }

    public static <K> void unstableSort(K[] a) {
        unstableSort(a, 0, a.length);
    }

    public static <K> void unstableSort(K[] a, int from, int to, Comparator<K> comp) {
        quickSort(a, from, to, comp);
    }

    public static <K> void unstableSort(K[] a, Comparator<K> comp) {
        unstableSort(a, 0, a.length, comp);
    }

    public static <K> void mergeSort(K[] a, int from, int to, K[] supp) {
        int len = to - from;
        if (len < 16) {
            insertionSort(a, from, to);
            return;
        }
        if (supp == null) {
            supp = (K[]) java.util.Arrays.copyOf(a, to);
        }
        int mid = (from + to) >>> 1;
        mergeSort(supp, from, mid, a);
        mergeSort(supp, mid, to, a);
        if (((Comparable) supp[mid - 1]).compareTo(supp[mid]) <= 0) {
            System.arraycopy(supp, from, a, from, len);
            return;
        }
        int p = from;
        int q = mid;
        for (int i = from; i < to; i++) {
            if (q >= to || (p < mid && ((Comparable) supp[p]).compareTo(supp[q]) <= 0)) {
                p++;
                a[i] = supp[p];
            } else {
                q++;
                a[i] = supp[q];
            }
        }
    }

    public static <K> void mergeSort(K[] a, int from, int to) {
        mergeSort(a, from, to, (Object[]) null);
    }

    public static <K> void mergeSort(K[] a) {
        mergeSort(a, 0, a.length);
    }

    public static <K> void mergeSort(K[] a, int from, int to, Comparator<K> comp, K[] supp) {
        int len = to - from;
        if (len < 16) {
            insertionSort(a, from, to, comp);
            return;
        }
        if (supp == null) {
            supp = (K[]) java.util.Arrays.copyOf(a, to);
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

    public static <K> void mergeSort(K[] a, int from, int to, Comparator<K> comp) {
        mergeSort(a, from, to, comp, null);
    }

    public static <K> void mergeSort(K[] a, Comparator<K> comp) {
        mergeSort(a, 0, a.length, comp);
    }

    public static <K> void stableSort(K[] a, int from, int to) {
        java.util.Arrays.sort(a, from, to);
    }

    public static <K> void stableSort(K[] a) {
        stableSort(a, 0, a.length);
    }

    public static <K> void stableSort(K[] a, int from, int to, Comparator<K> comp) {
        java.util.Arrays.sort(a, from, to, comp);
    }

    public static <K> void stableSort(K[] a, Comparator<K> comp) {
        stableSort(a, 0, a.length, comp);
    }

    public static <K> int binarySearch(K[] a, int from, int to, K key) {
        int to2 = to - 1;
        while (from <= to2) {
            int mid = (from + to2) >>> 1;
            int cmp = ((Comparable) a[mid]).compareTo(key);
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

    public static <K> int binarySearch(K[] a, K key) {
        return binarySearch(a, 0, a.length, key);
    }

    public static <K> int binarySearch(K[] a, int from, int to, K key, Comparator<K> c) {
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

    public static <K> int binarySearch(K[] a, K key, Comparator<K> c) {
        return binarySearch(a, 0, a.length, key, c);
    }

    public static <K> K[] shuffle(K[] a, int from, int to, Random random) {
        int i = to - from;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            K t = a[from + i];
            a[from + i] = a[from + p];
            a[from + p] = t;
        }
    }

    public static <K> K[] shuffle(K[] a, Random random) {
        int i = a.length;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            int p = random.nextInt(i + 1);
            K t = a[i];
            a[i] = a[p];
            a[p] = t;
        }
    }

    public static <K> K[] reverse(K[] a) {
        int length = a.length;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            K t = a[(length - i) - 1];
            a[(length - i) - 1] = a[i];
            a[i] = t;
        }
    }

    public static <K> K[] reverse(K[] a, int from, int to) {
        int length = to - from;
        int i = length / 2;
        while (true) {
            i--;
            if (i == 0) {
                return a;
            }
            K t = a[((from + length) - i) - 1];
            a[((from + length) - i) - 1] = a[from + i];
            a[from + i] = t;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.ObjectArrays$ArrayHashStrategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectArrays$ArrayHashStrategy.class */
    private static final class ArrayHashStrategy<K> implements Hash.Strategy<K[]>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        private ArrayHashStrategy() {
        }

        public int hashCode(K[] o) {
            return java.util.Arrays.hashCode(o);
        }

        public boolean equals(K[] a, K[] b) {
            return java.util.Arrays.equals(a, b);
        }
    }
}
