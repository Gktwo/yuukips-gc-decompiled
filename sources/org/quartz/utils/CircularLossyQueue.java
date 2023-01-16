package org.quartz.utils;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: grasscutter.jar:org/quartz/utils/CircularLossyQueue.class */
public class CircularLossyQueue<T> {
    private final AtomicReference<T>[] circularArray;
    private final int maxSize;
    private final AtomicLong currentIndex = new AtomicLong(-1);

    public CircularLossyQueue(int size) {
        this.circularArray = new AtomicReference[size];
        for (int i = 0; i < size; i++) {
            this.circularArray[i] = new AtomicReference<>();
        }
        this.maxSize = size;
    }

    public void push(T newVal) {
        this.circularArray[(int) (this.currentIndex.incrementAndGet() % ((long) this.maxSize))].set(newVal);
    }

    public T[] toArray(T[] type) {
        System.getProperties();
        if (type.length > this.maxSize) {
            throw new IllegalArgumentException("Size of array passed in cannot be greater than " + this.maxSize);
        }
        int curIndex = getCurrentIndex();
        for (int k = 0; k < type.length; k++) {
            type[k] = this.circularArray[getIndex(curIndex - k)].get();
        }
        return type;
    }

    private int getIndex(int index) {
        return index < 0 ? index + this.maxSize : index;
    }

    public T peek() {
        if (depth() == 0) {
            return null;
        }
        return this.circularArray[getIndex(getCurrentIndex())].get();
    }

    public boolean isEmtpy() {
        return depth() == 0;
    }

    private int getCurrentIndex() {
        return (int) (this.currentIndex.get() % ((long) this.maxSize));
    }

    public int depth() {
        long currInd = this.currentIndex.get() + 1;
        return currInd >= ((long) this.maxSize) ? this.maxSize : (int) currInd;
    }
}
