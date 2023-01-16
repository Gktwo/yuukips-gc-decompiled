package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventTranslatorOneArg.class */
public interface EventTranslatorOneArg<T, A> {
    void translateTo(T t, long j, A a);
}
