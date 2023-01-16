package org.jctools.queues;

import org.jctools.util.UnsafeAccess;
import org.jctools.util.UnsafeRefArrayAccess;
import org.jline.builtins.Tmux;

/* loaded from: grasscutter.jar:org/jctools/queues/MpUnboundedXaddChunk.class */
class MpUnboundedXaddChunk<R, E> {
    static final int NOT_USED = -1;
    private static final long PREV_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddChunk.class, Tmux.CMD_PREV);
    private static final long NEXT_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddChunk.class, Tmux.CMD_NEXT);
    private static final long INDEX_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddChunk.class, "index");
    private final boolean pooled;
    private final E[] buffer;
    private volatile R prev;
    private volatile long index;
    private volatile R next;

    /* access modifiers changed from: package-private */
    public MpUnboundedXaddChunk(long index, R prev, int size, boolean pooled) {
        this.buffer = (E[]) UnsafeRefArrayAccess.allocateRefArray(size);
        soPrev(prev);
        spIndex(index);
        this.pooled = pooled;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPooled() {
        return this.pooled;
    }

    /* access modifiers changed from: package-private */
    public final long lvIndex() {
        return this.index;
    }

    /* access modifiers changed from: package-private */
    public final void soIndex(long index) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, INDEX_OFFSET, index);
    }

    final void spIndex(long index) {
        UnsafeAccess.UNSAFE.putLong(this, INDEX_OFFSET, index);
    }

    final R lvNext() {
        return this.next;
    }

    /* access modifiers changed from: package-private */
    public final void soNext(R value) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, NEXT_OFFSET, value);
    }

    /* access modifiers changed from: package-private */
    public final R lvPrev() {
        return this.prev;
    }

    /* access modifiers changed from: package-private */
    public final void soPrev(R value) {
        UnsafeAccess.UNSAFE.putObject(this, PREV_OFFSET, value);
    }

    final void soElement(int index, E e) {
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcRefElementOffset((long) index), e);
    }

    final E lvElement(int index) {
        return (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcRefElementOffset((long) index));
    }

    final E spinForElement(int index, boolean isNull) {
        E e;
        boolean z;
        E[] buffer = this.buffer;
        long offset = UnsafeRefArrayAccess.calcRefElementOffset((long) index);
        do {
            e = (E) UnsafeRefArrayAccess.lvRefElement(buffer, offset);
            if (e == null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
        } while (isNull != z);
        return e;
    }
}
