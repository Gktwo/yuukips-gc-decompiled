package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventTranslator.class */
public interface EventTranslator<T> {
    void translateTo(T t, long j);
}
