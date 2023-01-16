package p014it.unimi.dsi.fastutil.doubles;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleHeaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleHeaps.class */
public final class DoubleHeaps {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DoubleHeaps.class.desiredAssertionStatus();
    }

    private DoubleHeaps() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [it.unimi.dsi.fastutil.doubles.DoubleComparator] */
    /* JADX WARN: Type inference failed for: r0v2, types: [double] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [double] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v35, types: [double] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int downHeap(double[] r6, int r7, int r8, p014it.unimi.dsi.fastutil.doubles.DoubleComparator r9) {
        /*
        // Method dump skipped, instructions count: 191
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.doubles.DoubleHeaps.downHeap(double[], int, int, it.unimi.dsi.fastutil.doubles.DoubleComparator):int");
    }

    public static int upHeap(double[] heap, int size, int i, DoubleComparator c) {
        if ($assertionsDisabled || i < size) {
            double e = heap[i];
            if (c == null) {
                while (i != 0) {
                    int parent = (i - 1) >>> 1;
                    double t = heap[parent];
                    if (Double.compare(t, e) <= 0) {
                        break;
                    }
                    heap[i] = t;
                    i = parent;
                }
            } else {
                while (i != 0) {
                    int parent2 = (i - 1) >>> 1;
                    double t2 = heap[parent2];
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

    public static void makeHeap(double[] heap, int size, DoubleComparator c) {
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
