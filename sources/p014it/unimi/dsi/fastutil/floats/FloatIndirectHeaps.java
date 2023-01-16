package p014it.unimi.dsi.fastutil.floats;

import java.util.Arrays;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatIndirectHeaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIndirectHeaps.class */
public final class FloatIndirectHeaps {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !FloatIndirectHeaps.class.desiredAssertionStatus();
    }

    private FloatIndirectHeaps() {
    }

    public static int downHeap(float[] refArray, int[] heap, int[] inv, int size, int i, FloatComparator c) {
        if ($assertionsDisabled || i < size) {
            int e = heap[i];
            float E = refArray[e];
            if (c != null) {
                while (true) {
                    int i2 = (i << 1) + 1;
                    int child = i2;
                    if (i2 >= size) {
                        break;
                    }
                    int t = heap[child];
                    int right = child + 1;
                    if (right < size && c.compare(refArray[heap[right]], refArray[t]) < 0) {
                        child = right;
                        t = heap[right];
                    }
                    if (c.compare(E, refArray[t]) <= 0) {
                        break;
                    }
                    heap[i] = t;
                    inv[heap[i]] = i;
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
                    if (right2 < size && Float.compare(refArray[heap[right2]], refArray[t2]) < 0) {
                        child2 = right2;
                        t2 = heap[right2];
                    }
                    if (Float.compare(E, refArray[t2]) <= 0) {
                        break;
                    }
                    heap[i] = t2;
                    inv[heap[i]] = i;
                    i = child2;
                }
            }
            heap[i] = e;
            inv[e] = i;
            return i;
        }
        throw new AssertionError();
    }

    public static int upHeap(float[] refArray, int[] heap, int[] inv, int size, int i, FloatComparator c) {
        if ($assertionsDisabled || i < size) {
            int e = heap[i];
            float E = refArray[e];
            if (c == null) {
                while (i != 0) {
                    int parent = (i - 1) >>> 1;
                    int t = heap[parent];
                    if (Float.compare(refArray[t], E) <= 0) {
                        break;
                    }
                    heap[i] = t;
                    inv[heap[i]] = i;
                    i = parent;
                }
            } else {
                while (i != 0) {
                    int parent2 = (i - 1) >>> 1;
                    int t2 = heap[parent2];
                    if (c.compare(refArray[t2], E) <= 0) {
                        break;
                    }
                    heap[i] = t2;
                    inv[heap[i]] = i;
                    i = parent2;
                }
            }
            heap[i] = e;
            inv[e] = i;
            return i;
        }
        throw new AssertionError();
    }

    public static void makeHeap(float[] refArray, int offset, int length, int[] heap, int[] inv, FloatComparator c) {
        FloatArrays.ensureOffsetLength(refArray, offset, length);
        if (heap.length < length) {
            throw new IllegalArgumentException("The heap length (" + heap.length + ") is smaller than the number of elements (" + length + ")");
        } else if (inv.length < refArray.length) {
            throw new IllegalArgumentException("The inversion array length (" + heap.length + ") is smaller than the length of the reference array (" + refArray.length + ")");
        } else {
            Arrays.fill(inv, 0, refArray.length, -1);
            int i = length;
            while (true) {
                i--;
                if (i == 0) {
                    break;
                }
                int i2 = offset + i;
                heap[i] = i2;
                inv[i2] = i;
            }
            int i3 = length >>> 1;
            while (true) {
                i3--;
                if (i3 != 0) {
                    downHeap(refArray, heap, inv, length, i3, c);
                } else {
                    return;
                }
            }
        }
    }

    public static void makeHeap(float[] refArray, int[] heap, int[] inv, int size, FloatComparator c) {
        int i = size >>> 1;
        while (true) {
            i--;
            if (i != 0) {
                downHeap(refArray, heap, inv, size, i, c);
            } else {
                return;
            }
        }
    }
}
