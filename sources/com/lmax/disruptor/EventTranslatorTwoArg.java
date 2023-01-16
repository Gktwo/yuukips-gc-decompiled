package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventTranslatorTwoArg.class */
public interface EventTranslatorTwoArg<T, A, B> {
    void translateTo(T t, long j, A a, B b);
}
