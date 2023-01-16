package org.jctools.queues;

/* loaded from: grasscutter.jar:org/jctools/queues/MpscUnboundedXaddChunk.class */
final class MpscUnboundedXaddChunk<E> extends MpUnboundedXaddChunk<MpscUnboundedXaddChunk<E>, E> {
    /* access modifiers changed from: package-private */
    public MpscUnboundedXaddChunk(long index, MpscUnboundedXaddChunk<E> prev, int size, boolean pooled) {
        super(index, prev, size, pooled);
    }
}
