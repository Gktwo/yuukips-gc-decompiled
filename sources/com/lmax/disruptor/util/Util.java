package com.lmax.disruptor.util;

import com.lmax.disruptor.EventProcessor;
import com.lmax.disruptor.Sequence;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: grasscutter.jar:com/lmax/disruptor/util/Util.class */
public final class Util {
    private static final int ONE_MILLISECOND_IN_NANOSECONDS = 1000000;

    public static int ceilingNextPowerOfTwo(int x) {
        return 1 << (32 - Integer.numberOfLeadingZeros(x - 1));
    }

    public static long getMinimumSequence(Sequence[] sequences) {
        return getMinimumSequence(sequences, LongCompanionObject.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    public static long getMinimumSequence(Sequence[] sequences, long minimum) {
        char c = minimum;
        for (Sequence sequence : sequences) {
            c = Math.min((long) c, sequence.get());
        }
        return c;
    }

    public static Sequence[] getSequencesFor(EventProcessor... processors) {
        Sequence[] sequences = new Sequence[processors.length];
        for (int i = 0; i < sequences.length; i++) {
            sequences[i] = processors[i].getSequence();
        }
        return sequences;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int log2(int r5) {
        /*
            r0 = r5
            long r0 = (long) r0
            r6 = r0
            r0 = 0
            r8 = r0
        L_0x0005:
            r0 = r6
            r1 = 1
            long r0 = r0 >> r1
            r1 = r0; r1 = r0; 
            r6 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0015
            int r8 = r8 + 1
            goto L_0x0005
        L_0x0015:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.util.Util.log2(int):int");
    }

    public static long awaitNanos(Object mutex, long timeoutNanos) throws InterruptedException {
        long t0 = System.nanoTime();
        mutex.wait(timeoutNanos / 1000000, (int) (timeoutNanos % 1000000));
        return timeoutNanos - (System.nanoTime() - t0);
    }
}
