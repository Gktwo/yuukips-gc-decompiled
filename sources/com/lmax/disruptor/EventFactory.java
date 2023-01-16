package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventFactory.class */
public interface EventFactory<T> {
    T newInstance();
}
