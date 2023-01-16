package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventTranslatorThreeArg.class */
public interface EventTranslatorThreeArg<T, A, B, C> {
    void translateTo(T t, long j, A a, B b, C c);
}
