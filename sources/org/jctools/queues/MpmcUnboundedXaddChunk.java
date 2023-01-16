package org.jctools.queues;

import java.util.Arrays;
import org.jctools.util.UnsafeLongArrayAccess;

/* loaded from: grasscutter.jar:org/jctools/queues/MpmcUnboundedXaddChunk.class */
final class MpmcUnboundedXaddChunk<E> extends MpUnboundedXaddChunk<MpmcUnboundedXaddChunk<E>, E> {
    private final long[] sequence;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !MpmcUnboundedXaddChunk.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    public MpmcUnboundedXaddChunk(long index, MpmcUnboundedXaddChunk<E> prev, int size, boolean pooled) {
        super(index, prev, size, pooled);
        if (pooled) {
            this.sequence = UnsafeLongArrayAccess.allocateLongArray(size);
            Arrays.fill(this.sequence, -1L);
            return;
        }
        this.sequence = null;
    }

    /* access modifiers changed from: package-private */
    public void soSequence(int index, long e) {
        if ($assertionsDisabled || isPooled()) {
            UnsafeLongArrayAccess.soLongElement(this.sequence, UnsafeLongArrayAccess.calcLongElementOffset((long) index), e);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public long lvSequence(int index) {
        if ($assertionsDisabled || isPooled()) {
            return UnsafeLongArrayAccess.lvLongElement(this.sequence, UnsafeLongArrayAccess.calcLongElementOffset((long) index));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void spinForSequence(int index, long e) {
        if ($assertionsDisabled || isPooled()) {
            do {
            } while (UnsafeLongArrayAccess.lvLongElement(this.sequence, UnsafeLongArrayAccess.calcLongElementOffset((long) index)) != e);
            return;
        }
        throw new AssertionError();
    }
}
