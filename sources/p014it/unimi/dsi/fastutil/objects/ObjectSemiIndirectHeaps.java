package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.ints.IntArrays;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectSemiIndirectHeaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSemiIndirectHeaps.class */
public final class ObjectSemiIndirectHeaps {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ObjectSemiIndirectHeaps.class.desiredAssertionStatus();
    }

    private ObjectSemiIndirectHeaps() {
    }

    public static <K> int downHeap(K[] refArray, int[] heap, int size, int i, Comparator<K> c) {
        if ($assertionsDisabled || i < size) {
            int e = heap[i];
            K E = refArray[e];
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
                    if (right2 < size && ((Comparable) refArray[heap[right2]]).compareTo(refArray[t2]) < 0) {
                        child2 = right2;
                        t2 = heap[right2];
                    }
                    if (((Comparable) E).compareTo(refArray[t2]) <= 0) {
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

    public static <K> int upHeap(K[] refArray, int[] heap, int size, int i, Comparator<K> c) {
        if ($assertionsDisabled || i < size) {
            int e = heap[i];
            K E = refArray[e];
            if (c == null) {
                while (i != 0) {
                    int parent = (i - 1) >>> 1;
                    int t = heap[parent];
                    if (((Comparable) refArray[t]).compareTo(E) <= 0) {
                        break;
                    }
                    heap[i] = t;
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
                    i = parent2;
                }
            }
            heap[i] = e;
            return i;
        }
        throw new AssertionError();
    }

    public static <K> void makeHeap(K[] refArray, int offset, int length, int[] heap, Comparator<K> c) {
        ObjectArrays.ensureOffsetLength(refArray, offset, length);
        if (heap.length < length) {
            throw new IllegalArgumentException("The heap length (" + heap.length + ") is smaller than the number of elements (" + length + ")");
        }
        int i = length;
        while (true) {
            i--;
            if (i == 0) {
                break;
            }
            heap[i] = offset + i;
        }
        int i2 = length >>> 1;
        while (true) {
            i2--;
            if (i2 != 0) {
                downHeap(refArray, heap, length, i2, c);
            } else {
                return;
            }
        }
    }

    public static <K> int[] makeHeap(K[] refArray, int offset, int length, Comparator<K> c) {
        int[] heap = length <= 0 ? IntArrays.EMPTY_ARRAY : new int[length];
        makeHeap(refArray, offset, length, heap, c);
        return heap;
    }

    public static <K> void makeHeap(K[] refArray, int[] heap, int size, Comparator<K> c) {
        int i = size >>> 1;
        while (true) {
            i--;
            if (i != 0) {
                downHeap(refArray, heap, size, i, c);
            } else {
                return;
            }
        }
    }

    public static <K> int front(K[] refArray, int[] heap, int size, int[] a) {
        K top = refArray[heap[0]];
        int j = 0;
        int l = 0;
        int r = 1;
        int f = 0;
        int i = 0;
        while (i < r) {
            if (i == f) {
                if (l >= r) {
                    break;
                }
                f = (f << 1) + 1;
                i = l;
                l = -1;
            }
            if (((Comparable) top).compareTo(refArray[heap[i]]) == 0) {
                j++;
                a[j] = heap[i];
                if (l == -1) {
                    l = (i * 2) + 1;
                }
                r = Math.min(size, (i * 2) + 3);
            }
            i++;
        }
        return j;
    }

    public static <K> int front(K[] refArray, int[] heap, int size, int[] a, Comparator<K> c) {
        K top = refArray[heap[0]];
        int j = 0;
        int l = 0;
        int r = 1;
        int f = 0;
        int i = 0;
        while (i < r) {
            if (i == f) {
                if (l >= r) {
                    break;
                }
                f = (f << 1) + 1;
                i = l;
                l = -1;
            }
            if (c.compare(top, refArray[heap[i]]) == 0) {
                j++;
                a[j] = heap[i];
                if (l == -1) {
                    l = (i * 2) + 1;
                }
                r = Math.min(size, (i * 2) + 3);
            }
            i++;
        }
        return j;
    }
}
