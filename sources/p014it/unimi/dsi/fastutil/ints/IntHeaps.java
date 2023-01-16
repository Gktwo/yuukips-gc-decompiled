package p014it.unimi.dsi.fastutil.ints;

/* renamed from: it.unimi.dsi.fastutil.ints.IntHeaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntHeaps.class */
public final class IntHeaps {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !IntHeaps.class.desiredAssertionStatus();
    }

    private IntHeaps() {
    }

    public static int downHeap(int[] heap, int size, int i, IntComparator c) {
        if ($assertionsDisabled || i < size) {
            int e = heap[i];
            if (c != null) {
                while (true) {
                    int i2 = (i << 1) + 1;
                    int child = i2;
                    if (i2 >= size) {
                        break;
                    }
                    int t = heap[child];
                    int right = child + 1;
                    if (right < size && c.compare(heap[right], t) < 0) {
                        child = right;
                        t = heap[right];
                    }
                    if (c.compare(e, t) <= 0) {
                        break;
                    }
                    heap[i] = t;
                    i = child;
                }
            } else {
                while (true) {
                    int i3 = (i << 1) + 1;
                    int child2 = i3;
                    if (i3 >= size) {
                        break;
                    }
                    int t2 = heap[child2];
                    int right2 = child2 + 1;
                    if (right2 < size && heap[right2] < t2) {
                        child2 = right2;
                        t2 = heap[right2];
                    }
                    if (e <= t2) {
                        break;
                    }
                    heap[i] = t2;
                    i = child2;
                }
            }
            heap[i] = e;
            return i;
        }
        throw new AssertionError();
    }

    public static int upHeap(int[] heap, int size, int i, IntComparator c) {
        int parent;
        int t;
        if ($assertionsDisabled || i < size) {
            int e = heap[i];
            if (c == null) {
                while (i != 0 && (t = heap[(parent = (i - 1) >>> 1)]) > e) {
                    heap[i] = t;
                    i = parent;
                }
            } else {
                while (i != 0) {
                    int parent2 = (i - 1) >>> 1;
                    int t2 = heap[parent2];
                    if (c.compare(t2, e) <= 0) {
                        break;
                    }
                    heap[i] = t2;
                    i = parent2;
                }
            }
            heap[i] = e;
            return i;
        }
        throw new AssertionError();
    }

    public static void makeHeap(int[] heap, int size, IntComparator c) {
        int i = size >>> 1;
        while (true) {
            i--;
            if (i != 0) {
                downHeap(heap, size, i, c);
            } else {
                return;
            }
        }
    }
}
