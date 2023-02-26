package p014it.unimi.dsi.fastutil;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import p014it.unimi.dsi.fastutil.ints.IntComparator;

/* renamed from: it.unimi.dsi.fastutil.Arrays */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/Arrays.class */
public class Arrays {
    public static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MERGESORT_NO_REC = 16;
    private static final int QUICKSORT_NO_REC = 16;
    private static final int PARALLEL_QUICKSORT_NO_FORK = 8192;
    private static final int QUICKSORT_MEDIAN_OF_9 = 128;

    private Arrays() {
    }

    public static void ensureFromTo(int arrayLength, int from, int to) {
        if (from < 0) {
            throw new ArrayIndexOutOfBoundsException("Start index (" + from + ") is negative");
        } else if (from > to) {
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        } else if (to > arrayLength) {
            throw new ArrayIndexOutOfBoundsException("End index (" + to + ") is greater than array length (" + arrayLength + ")");
        }
    }

    public static void ensureOffsetLength(int arrayLength, int offset, int length) {
        if (offset < 0) {
            throw new ArrayIndexOutOfBoundsException("Offset (" + offset + ") is negative");
        } else if (length < 0) {
            throw new IllegalArgumentException("Length (" + length + ") is negative");
        } else if (offset + length > arrayLength) {
            throw new ArrayIndexOutOfBoundsException("Last index (" + (offset + length) + ") is greater than array length (" + arrayLength + ")");
        }
    }

    private static void inPlaceMerge(int from, int mid, int to, IntComparator comp, Swapper swapper) {
        int secondCut;
        int firstCut;
        if (from < mid && mid < to) {
            if (to - from != 2) {
                if (mid - from > to - mid) {
                    firstCut = from + ((mid - from) / 2);
                    secondCut = lowerBound(mid, to, firstCut, comp);
                } else {
                    secondCut = mid + ((to - mid) / 2);
                    firstCut = upperBound(from, mid, secondCut, comp);
                }
                if (mid != firstCut && mid != secondCut) {
                    int first1 = firstCut;
                    int last1 = mid;
                    while (true) {
                        last1--;
                        if (first1 >= last1) {
                            break;
                        }
                        first1++;
                        swapper.swap(first1, last1);
                    }
                    int first12 = mid;
                    int last12 = secondCut;
                    while (true) {
                        last12--;
                        if (first12 >= last12) {
                            break;
                        }
                        first12++;
                        swapper.swap(first12, last12);
                    }
                    int first13 = firstCut;
                    int last13 = secondCut;
                    while (true) {
                        last13--;
                        if (first13 >= last13) {
                            break;
                        }
                        first13++;
                        swapper.swap(first13, last13);
                    }
                }
                int mid2 = firstCut + (secondCut - mid);
                inPlaceMerge(from, firstCut, mid2, comp, swapper);
                inPlaceMerge(mid2, secondCut, to, comp, swapper);
            } else if (comp.compare(mid, from) < 0) {
                swapper.swap(from, mid);
            }
        }
    }

    private static int lowerBound(int from, int to, int pos, IntComparator comp) {
        int len = to - from;
        while (len > 0) {
            int half = len / 2;
            int middle = from + half;
            if (comp.compare(middle, pos) < 0) {
                from = middle + 1;
                len -= half + 1;
            } else {
                len = half;
            }
        }
        return from;
    }

    private static int upperBound(int from, int mid, int pos, IntComparator comp) {
        int len = mid - from;
        while (len > 0) {
            int half = len / 2;
            int middle = from + half;
            if (comp.compare(pos, middle) < 0) {
                len = half;
            } else {
                from = middle + 1;
                len -= half + 1;
            }
        }
        return from;
    }

    /* access modifiers changed from: private */
    public static int med3(int a, int b, int c, IntComparator comp) {
        int ab = comp.compare(a, b);
        int ac = comp.compare(a, c);
        int bc = comp.compare(b, c);
        return ab < 0 ? bc < 0 ? b : ac < 0 ? c : a : bc > 0 ? b : ac > 0 ? c : a;
    }

    private static ForkJoinPool getPool() {
        ForkJoinPool current = ForkJoinTask.getPool();
        return current == null ? ForkJoinPool.commonPool() : current;
    }

    public static void mergeSort(int from, int to, IntComparator c, Swapper swapper) {
        if (to - from < 16) {
            for (int i = from; i < to; i++) {
                int j = i;
                while (j > from && c.compare(j - 1, j) > 0) {
                    swapper.swap(j, j - 1);
                    j--;
                }
            }
            return;
        }
        int mid = (from + to) >>> 1;
        mergeSort(from, mid, c, swapper);
        mergeSort(mid, to, c, swapper);
        if (c.compare(mid - 1, mid) > 0) {
            inPlaceMerge(from, mid, to, c, swapper);
        }
    }

    protected static void swap(Swapper swapper, int a, int b, int n) {
        int i = 0;
        while (i < n) {
            swapper.swap(a, b);
            i++;
            a++;
            b++;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.Arrays$ForkJoinGenericQuickSort */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/Arrays$ForkJoinGenericQuickSort.class */
    protected static class ForkJoinGenericQuickSort extends RecursiveAction {
        private static final long serialVersionUID = 1;
        private final int from;

        /* renamed from: to */
        private final int f1001to;
        private final IntComparator comp;
        private final Swapper swapper;

        public ForkJoinGenericQuickSort(int from, int to, IntComparator comp, Swapper swapper) {
            this.from = from;
            this.f1001to = to;
            this.comp = comp;
            this.swapper = swapper;
        }

        @Override // java.util.concurrent.RecursiveAction
        protected void compute() {
            int comparison;
            int comparison2;
            int len = this.f1001to - this.from;
            if (len < 8192) {
                Arrays.quickSort(this.from, this.f1001to, this.comp, this.swapper);
                return;
            }
            int m = this.from + (len / 2);
            int l = this.from;
            int n = this.f1001to - 1;
            int s = len / 8;
            int m2 = Arrays.med3(Arrays.med3(l, l + s, l + (2 * s), this.comp), Arrays.med3(m - s, m, m + s, this.comp), Arrays.med3(n - (2 * s), n - s, n, this.comp), this.comp);
            int a = this.from;
            int b = a;
            int c = this.f1001to - 1;
            int d = c;
            while (true) {
                if (b > c || (comparison2 = this.comp.compare(b, m2)) > 0) {
                    while (c >= b && (comparison = this.comp.compare(c, m2)) >= 0) {
                        if (comparison == 0) {
                            if (c == m2) {
                                m2 = d;
                            } else if (d == m2) {
                                m2 = c;
                            }
                            d--;
                            this.swapper.swap(c, d);
                        }
                        c--;
                    }
                    if (b > c) {
                        break;
                    }
                    if (b == m2) {
                        m2 = d;
                    } else if (c == m2) {
                        m2 = c;
                    }
                    b++;
                    c--;
                    this.swapper.swap(b, c);
                } else {
                    if (comparison2 == 0) {
                        if (a == m2) {
                            m2 = b;
                        } else if (b == m2) {
                            m2 = a;
                        }
                        a++;
                        this.swapper.swap(a, b);
                    }
                    b++;
                }
            }
            int s2 = Math.min(a - this.from, b - a);
            Arrays.swap(this.swapper, this.from, b - s2, s2);
            int s3 = Math.min(d - c, (this.f1001to - d) - 1);
            Arrays.swap(this.swapper, b, this.f1001to - s3, s3);
            int s4 = b - a;
            int t = d - c;
            if (s4 > 1 && t > 1) {
                invokeAll(new ForkJoinGenericQuickSort(this.from, this.from + s4, this.comp, this.swapper), new ForkJoinGenericQuickSort(this.f1001to - t, this.f1001to, this.comp, this.swapper));
            } else if (s4 > 1) {
                invokeAll(new ForkJoinTask[]{new ForkJoinGenericQuickSort(this.from, this.from + s4, this.comp, this.swapper)});
            } else {
                invokeAll(new ForkJoinTask[]{new ForkJoinGenericQuickSort(this.f1001to - t, this.f1001to, this.comp, this.swapper)});
            }
        }
    }

    public static void parallelQuickSort(int from, int to, IntComparator comp, Swapper swapper) {
        ForkJoinPool pool = getPool();
        if (to - from < 8192 || pool.getParallelism() == 1) {
            quickSort(from, to, comp, swapper);
        } else {
            pool.invoke(new ForkJoinGenericQuickSort(from, to, comp, swapper));
        }
    }

    public static void quickSort(int from, int to, IntComparator comp, Swapper swapper) {
        int comparison;
        int comparison2;
        int len = to - from;
        if (len < 16) {
            for (int i = from; i < to; i++) {
                int j = i;
                while (j > from && comp.compare(j - 1, j) > 0) {
                    swapper.swap(j, j - 1);
                    j--;
                }
            }
            return;
        }
        int m = from + (len / 2);
        int l = from;
        int n = to - 1;
        if (len > 128) {
            int s = len / 8;
            l = med3(l, l + s, l + (2 * s), comp);
            m = med3(m - s, m, m + s, comp);
            n = med3(n - (2 * s), n - s, n, comp);
        }
        int m2 = med3(l, m, n, comp);
        int a = from;
        int b = a;
        int c = to - 1;
        int d = c;
        while (true) {
            if (b > c || (comparison2 = comp.compare(b, m2)) > 0) {
                while (c >= b && (comparison = comp.compare(c, m2)) >= 0) {
                    if (comparison == 0) {
                        if (c == m2) {
                            m2 = d;
                        } else if (d == m2) {
                            m2 = c;
                        }
                        d--;
                        swapper.swap(c, d);
                    }
                    c--;
                }
                if (b > c) {
                    break;
                }
                if (b == m2) {
                    m2 = d;
                } else if (c == m2) {
                    m2 = c;
                }
                b++;
                c--;
                swapper.swap(b, c);
            } else {
                if (comparison2 == 0) {
                    if (a == m2) {
                        m2 = b;
                    } else if (b == m2) {
                        m2 = a;
                    }
                    a++;
                    swapper.swap(a, b);
                }
                b++;
            }
        }
        int s2 = Math.min(a - from, b - a);
        swap(swapper, from, b - s2, s2);
        int s3 = Math.min(d - c, (to - d) - 1);
        swap(swapper, b, to - s3, s3);
        int s4 = b - a;
        if (s4 > 1) {
            quickSort(from, from + s4, comp, swapper);
        }
        int s5 = d - c;
        if (s5 > 1) {
            quickSort(to - s5, to, comp, swapper);
        }
    }
}
