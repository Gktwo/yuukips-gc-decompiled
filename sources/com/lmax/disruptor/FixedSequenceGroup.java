package com.lmax.disruptor;

import com.lmax.disruptor.util.Util;
import java.util.Arrays;

/* loaded from: grasscutter.jar:com/lmax/disruptor/FixedSequenceGroup.class */
public final class FixedSequenceGroup extends Sequence {
    private final Sequence[] sequences;

    public FixedSequenceGroup(Sequence[] sequences) {
        this.sequences = (Sequence[]) Arrays.copyOf(sequences, sequences.length);
    }

    @Override // com.lmax.disruptor.Sequence
    public long get() {
        return Util.getMinimumSequence(this.sequences);
    }

    @Override // com.lmax.disruptor.Sequence
    public String toString() {
        return Arrays.toString(this.sequences);
    }

    @Override // com.lmax.disruptor.Sequence
    public void set(long value) {
        throw new UnsupportedOperationException();
    }

    @Override // com.lmax.disruptor.Sequence
    public boolean compareAndSet(long expectedValue, long newValue) {
        throw new UnsupportedOperationException();
    }

    @Override // com.lmax.disruptor.Sequence
    public long incrementAndGet() {
        throw new UnsupportedOperationException();
    }

    @Override // com.lmax.disruptor.Sequence
    public long addAndGet(long increment) {
        throw new UnsupportedOperationException();
    }
}
