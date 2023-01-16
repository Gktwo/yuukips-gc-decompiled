package com.lmax.disruptor.dsl;

import com.lmax.disruptor.EventProcessor;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.Sequence;

/* loaded from: grasscutter.jar:com/lmax/disruptor/dsl/EventProcessorFactory.class */
public interface EventProcessorFactory<T> {
    EventProcessor createEventProcessor(RingBuffer<T> ringBuffer, Sequence[] sequenceArr);
}
