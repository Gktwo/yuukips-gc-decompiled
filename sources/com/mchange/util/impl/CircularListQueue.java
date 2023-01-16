package com.mchange.util.impl;

import com.mchange.util.Queue;

/* loaded from: grasscutter.jar:com/mchange/util/impl/CircularListQueue.class */
public class CircularListQueue implements Queue, Cloneable {
    CircularList list;

    @Override // com.mchange.util.Queue
    public int size() {
        return this.list.size();
    }

    @Override // com.mchange.util.Queue
    public boolean hasMoreElements() {
        return this.list.size() > 0;
    }

    @Override // com.mchange.util.Queue
    public void enqueue(Object obj) {
        this.list.appendElement(obj);
    }

    @Override // com.mchange.util.Queue
    public Object peek() {
        return this.list.getFirstElement();
    }

    @Override // com.mchange.util.Queue
    public Object dequeue() {
        Object firstElement = this.list.getFirstElement();
        this.list.removeFirstElement();
        return firstElement;
    }

    @Override // com.mchange.util.Queue, java.lang.Object
    public Object clone() {
        return new CircularListQueue((CircularList) this.list.clone());
    }

    public CircularListQueue() {
        this.list = new CircularList();
    }

    private CircularListQueue(CircularList circularList) {
        this.list = circularList;
    }
}
