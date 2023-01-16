package p014it.unimi.dsi.fastutil.floats;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatHeaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatHeaps.class */
public final class FloatHeaps {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !FloatHeaps.class.desiredAssertionStatus();
    }

    private FloatHeaps() {
    }

    public static int downHeap(float[] heap, int size, int i, FloatComparator c) {
        if ($assertionsDisabled || i < size) {
            float e = heap[i];
            if (c != null) {
                while (true) {
                    int i2 = (i << 1) + 1;
                    int child = i2;
                    if (i2 >= size) {
                        break;
                    }
                    float t = heap[child];
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
                    float t2 = heap[child2];
                    int right2 = child2 + 1;
                    if (right2 < size && Float.compare(heap[right2], t2) < 0) {
                        child2 = right2;
                        t2 = heap[right2];
                    }
                    if (Float.compare(e, t2) <= 0) {
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

    public static int upHeap(float[] heap, int size, int i, FloatComparator c) {
        if ($assertionsDisabled || i < size) {
            float e = heap[i];
            if (c == null) {
                while (i != 0) {
                    int parent = (i - 1) >>> 1;
                    float t = heap[parent];
                    if (Float.compare(t, e) <= 0) {
                        break;
                    }
                    heap[i] = t;
                    i = parent;
                }
            } else {
                while (i != 0) {
                    int parent2 = (i - 1) >>> 1;
                    float t2 = heap[parent2];
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

    public static void makeHeap(float[] heap, int size, FloatComparator c) {
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
