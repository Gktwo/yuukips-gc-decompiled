package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventTranslatorVararg.class */
public interface EventTranslatorVararg<T> {
    void translateTo(T t, long j, Object... objArr);
}
