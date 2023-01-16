package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/Sequencer.class */
public interface Sequencer extends Cursored, Sequenced {
    public static final long INITIAL_CURSOR_VALUE = -1;

    void claim(long j);

    boolean isAvailable(long j);

    void addGatingSequences(Sequence... sequenceArr);

    boolean removeGatingSequence(Sequence sequence);

    SequenceBarrier newBarrier(Sequence... sequenceArr);

    long getMinimumSequence();

    long getHighestPublishedSequence(long j, long j2);

    <T> EventPoller<T> newPoller(DataProvider<T> dataProvider, Sequence... sequenceArr);
}
