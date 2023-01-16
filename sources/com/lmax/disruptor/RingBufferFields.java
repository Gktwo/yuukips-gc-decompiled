package com.lmax.disruptor;

/* compiled from: RingBuffer.java */
/* loaded from: grasscutter.jar:com/lmax/disruptor/RingBufferFields.class */
abstract class RingBufferFields<E> extends RingBufferPad {
    private static final int BUFFER_PAD = 32;
    private final long indexMask;
    private final E[] entries;
    protected final int bufferSize;
    protected final Sequencer sequencer;

    /* access modifiers changed from: package-private */
    public RingBufferFields(EventFactory<E> eventFactory, Sequencer sequencer) {
        this.sequencer = sequencer;
        this.bufferSize = sequencer.getBufferSize();
        if (this.bufferSize < 1) {
            throw new IllegalArgumentException("bufferSize must not be less than 1");
        } else if (Integer.bitCount(this.bufferSize) != 1) {
            throw new IllegalArgumentException("bufferSize must be a power of 2");
        } else {
            this.indexMask = (long) (this.bufferSize - 1);
            this.entries = (E[]) new Object[sequencer.getBufferSize() + 64];
            fill(eventFactory);
        }
    }

    private void fill(EventFactory<E> eventFactory) {
        for (int i = 0; i < this.bufferSize; i++) {
            this.entries[32 + i] = eventFactory.newInstance();
        }
    }

    protected final E elementAt(long sequence) {
        return this.entries[32 + ((int) (sequence & this.indexMask))];
    }
}
