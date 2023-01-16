package com.mchange.util.impl;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* compiled from: CircularList.java */
/* loaded from: grasscutter.jar:com/mchange/util/impl/CircularListEnumeration.class */
class CircularListEnumeration implements Enumeration {
    boolean forward;
    boolean terminated;
    boolean done;
    CircularListRecord startRecord;
    CircularListRecord lastRecord;

    /* access modifiers changed from: package-private */
    public CircularListEnumeration(CircularList circularList, boolean z, boolean z2) {
        if (circularList.firstRecord == null) {
            this.done = true;
            return;
        }
        this.done = false;
        this.forward = z;
        this.terminated = z2;
        this.startRecord = z ? circularList.firstRecord : circularList.firstRecord.prev;
        this.lastRecord = z ? this.startRecord.prev : this.startRecord;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return !this.done;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        if (this.done) {
            throw new NoSuchElementException();
        }
        this.lastRecord = this.forward ? this.lastRecord.next : this.lastRecord.prev;
        if (this.terminated) {
            if (this.lastRecord == (this.forward ? this.startRecord.prev : this.startRecord)) {
                this.done = true;
            }
        }
        return this.lastRecord.object;
    }
}
