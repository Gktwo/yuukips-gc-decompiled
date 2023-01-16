package p014it.unimi.dsi.fastutil.longs;

/* renamed from: it.unimi.dsi.fastutil.longs.LongHeaps */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongHeaps.class */
public final class LongHeaps {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LongHeaps.class.desiredAssertionStatus();
    }

    private LongHeaps() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [it.unimi.dsi.fastutil.longs.LongComparator] */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v35, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int downHeap(long[] r6, int r7, int r8, p014it.unimi.dsi.fastutil.longs.LongComparator r9) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.longs.LongHeaps.downHeap(long[], int, int, it.unimi.dsi.fastutil.longs.LongComparator):int");
    }

    public static int upHeap(long[] heap, int size, int i, LongComparator c) {
        if ($assertionsDisabled || i < size) {
            long e = heap[i];
            if (c == null) {
                while (i != 0) {
                    int parent = (i - 1) >>> 1;
                    long t = heap[parent];
                    if (t <= e) {
                        break;
                    }
                    heap[i] = t;
                    i = parent;
                }
            } else {
                while (i != 0) {
                    int parent2 = (i - 1) >>> 1;
                    long t2 = heap[parent2];
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

    public static void makeHeap(long[] heap, int size, LongComparator c) {
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
