package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/Sequenced.class */
public interface Sequenced {
    int getBufferSize();

    boolean hasAvailableCapacity(int i);

    long remainingCapacity();

    long next();

    long next(int i);

    long tryNext() throws InsufficientCapacityException;

    long tryNext(int i) throws InsufficientCapacityException;

    void publish(long j);

    void publish(long j, long j2);
}
