package com.mchange.util;

import java.util.NoSuchElementException;

/* loaded from: grasscutter.jar:com/mchange/util/Queue.class */
public interface Queue extends Cloneable {
    void enqueue(Object obj);

    Object dequeue() throws NoSuchElementException;

    Object peek() throws NoSuchElementException;

    boolean hasMoreElements();

    int size();

    @Override // java.lang.Object
    Object clone();
}
