package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectHeaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectHeaps.class */
public final class ObjectHeaps {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ObjectHeaps.class.desiredAssertionStatus();
    }

    private ObjectHeaps() {
    }

    public static <K> int downHeap(K[] heap, int size, int i, Comparator<? super K> c) {
        if ($assertionsDisabled || i < size) {
            K e = heap[i];
            if (c != null) {
                while (true) {
                    int i2 = (i << 1) + 1;
                    int child = i2;
                    if (i2 >= size) {
                        break;
                    }
                    K t = heap[child];
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
                    K t2 = heap[child2];
                    int right2 = child2 + 1;
                    if (right2 < size && ((Comparable) heap[right2]).compareTo(t2) < 0) {
                        child2 = right2;
                        t2 = heap[right2];
                    }
                    if (((Comparable) e).compareTo(t2) <= 0) {
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

    public static <K> int upHeap(K[] heap, int size, int i, Comparator<K> c) {
        if ($assertionsDisabled || i < size) {
            K e = heap[i];
            if (c == null) {
                while (i != 0) {
                    int parent = (i - 1) >>> 1;
                    K t = heap[parent];
                    if (((Comparable) t).compareTo(e) <= 0) {
                        break;
                    }
                    heap[i] = t;
                    i = parent;
                }
            } else {
                while (i != 0) {
                    int parent2 = (i - 1) >>> 1;
                    K t2 = heap[parent2];
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

    public static <K> void makeHeap(K[] heap, int size, Comparator<K> c) {
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
