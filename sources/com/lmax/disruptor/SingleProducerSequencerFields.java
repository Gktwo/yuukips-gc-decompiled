package com.lmax.disruptor;

/* compiled from: SingleProducerSequencer.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/lmax/disruptor/SingleProducerSequencerFields.class */
public abstract class SingleProducerSequencerFields extends SingleProducerSequencerPad {
    long nextValue = -1;
    long cachedValue = -1;

    /* access modifiers changed from: package-private */
    public SingleProducerSequencerFields(int bufferSize, WaitStrategy waitStrategy) {
        super(bufferSize, waitStrategy);
    }
}
