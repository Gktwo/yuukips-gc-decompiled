package com.lmax.disruptor;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: grasscutter.jar:com/lmax/disruptor/NoOpEventProcessor.class */
public final class NoOpEventProcessor implements EventProcessor {
    private final SequencerFollowingSequence sequence;
    private final AtomicBoolean running = new AtomicBoolean(false);

    public NoOpEventProcessor(RingBuffer<?> sequencer) {
        this.sequence = new SequencerFollowingSequence(sequencer);
    }

    @Override // com.lmax.disruptor.EventProcessor
    public Sequence getSequence() {
        return this.sequence;
    }

    @Override // com.lmax.disruptor.EventProcessor
    public void halt() {
        this.running.set(false);
    }

    @Override // com.lmax.disruptor.EventProcessor
    public boolean isRunning() {
        return this.running.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.running.compareAndSet(false, true)) {
            throw new IllegalStateException("Thread is already running");
        }
    }

    /* loaded from: grasscutter.jar:com/lmax/disruptor/NoOpEventProcessor$SequencerFollowingSequence.class */
    private static final class SequencerFollowingSequence extends Sequence {
        private final RingBuffer<?> sequencer;

        private SequencerFollowingSequence(RingBuffer<?> sequencer) {
            super(-1);
            this.sequencer = sequencer;
        }

        @Override // com.lmax.disruptor.Sequence
        public long get() {
            return this.sequencer.getCursor();
        }
    }
}
