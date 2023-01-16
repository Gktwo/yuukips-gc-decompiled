package com.mchange.util.impl;

import java.util.Enumeration;

/* loaded from: grasscutter.jar:com/mchange/util/impl/CircularList.class */
public class CircularList implements Cloneable {
    CircularListRecord firstRecord = null;
    int size = 0;

    private void addElement(Object obj, boolean z) {
        if (this.firstRecord == null) {
            this.firstRecord = new CircularListRecord(obj);
        } else {
            CircularListRecord circularListRecord = new CircularListRecord(obj, this.firstRecord.prev, this.firstRecord);
            this.firstRecord.prev.next = circularListRecord;
            this.firstRecord.prev = circularListRecord;
            if (z) {
                this.firstRecord = circularListRecord;
            }
        }
        this.size++;
    }

    private void removeElement(boolean z) {
        if (this.size == 1) {
            this.firstRecord = null;
        } else {
            if (z) {
                this.firstRecord = this.firstRecord.next;
            }
            zap(this.firstRecord.prev);
        }
        this.size--;
    }

    private void zap(CircularListRecord circularListRecord) {
        circularListRecord.next.prev = circularListRecord.prev;
        circularListRecord.prev.next = circularListRecord.next;
    }

    public void appendElement(Object obj) {
        addElement(obj, false);
    }

    public void addElementToFront(Object obj) {
        addElement(obj, true);
    }

    public void removeFirstElement() {
        removeElement(true);
    }

    public void removeLastElement() {
        removeElement(false);
    }

    public void removeFromFront(int i) {
        if (i > this.size) {
            throw new IndexOutOfBoundsException(i + ">" + this.size);
        }
        for (int i2 = 0; i2 < i; i2++) {
            removeElement(true);
        }
    }

    public void removeFromBack(int i) {
        if (i > this.size) {
            throw new IndexOutOfBoundsException(i + ">" + this.size);
        }
        for (int i2 = 0; i2 < i; i2++) {
            removeElement(false);
        }
    }

    public void removeAllElements() {
        this.size = 0;
        this.firstRecord = null;
    }

    public Object getElementFromFront(int i) {
        if (i >= this.size) {
            throw new IndexOutOfBoundsException(i + ">=" + this.size);
        }
        CircularListRecord circularListRecord = this.firstRecord;
        for (int i2 = 0; i2 < i; i2++) {
            circularListRecord = circularListRecord.next;
        }
        return circularListRecord.object;
    }

    public Object getElementFromBack(int i) {
        if (i >= this.size) {
            throw new IndexOutOfBoundsException(i + ">=" + this.size);
        }
        CircularListRecord circularListRecord = this.firstRecord.prev;
        for (int i2 = 0; i2 < i; i2++) {
            circularListRecord = circularListRecord.prev;
        }
        return circularListRecord.object;
    }

    public Object getFirstElement() {
        try {
            return this.firstRecord.object;
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException("CircularList is empty.");
        }
    }

    public Object getLastElement() {
        try {
            return this.firstRecord.prev.object;
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException("CircularList is empty.");
        }
    }

    public Enumeration elements(boolean z, boolean z2) {
        return new CircularListEnumeration(this, z, z2);
    }

    public Enumeration elements(boolean z) {
        return elements(z, true);
    }

    public Enumeration elements() {
        return elements(true, true);
    }

    public int size() {
        return this.size;
    }

    @Override // java.lang.Object
    public Object clone() {
        CircularList circularList = new CircularList();
        int size = size();
        for (int i = 0; i < size; i++) {
            circularList.appendElement(getElementFromFront(i));
        }
        return circularList;
    }

    public static void main(String[] strArr) {
        CircularList circularList = new CircularList();
        circularList.appendElement("Hello");
        circularList.appendElement("There");
        circularList.appendElement("Joe.");
        Enumeration elements = circularList.elements();
        while (elements.hasMoreElements()) {
            System.out.println("x " + elements.nextElement());
        }
    }
}
