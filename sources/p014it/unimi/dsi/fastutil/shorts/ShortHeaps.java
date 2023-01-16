package p014it.unimi.dsi.fastutil.shorts;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortHeaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortHeaps.class */
public final class ShortHeaps {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ShortHeaps.class.desiredAssertionStatus();
    }

    private ShortHeaps() {
    }

    public static int downHeap(short[] heap, int size, int i, ShortComparator c) {
        if ($assertionsDisabled || i < size) {
            short e = heap[i];
            if (c != null) {
                while (true) {
                    int i2 = (i << 1) + 1;
                    int child = i2;
                    if (i2 >= size) {
                        break;
                    }
                    short t = heap[child];
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
                    short t2 = heap[child2];
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

    public static int upHeap(short[] heap, int size, int i, ShortComparator c) {
        int parent;
        short t;
        if ($assertionsDisabled || i < size) {
            short e = heap[i];
            if (c == null) {
                while (i != 0 && (t = heap[(parent = (i - 1) >>> 1)]) > e) {
                    heap[i] = t;
                    i = parent;
                }
            } else {
                while (i != 0) {
                    int parent2 = (i - 1) >>> 1;
                    short t2 = heap[parent2];
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

    public static void makeHeap(short[] heap, int size, ShortComparator c) {
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
