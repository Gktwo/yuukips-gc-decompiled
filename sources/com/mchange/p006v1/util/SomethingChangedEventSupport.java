package com.mchange.p006v1.util;

import java.util.Enumeration;
import java.util.Vector;

/* renamed from: com.mchange.v1.util.SomethingChangedEventSupport */
/* loaded from: grasscutter.jar:com/mchange/v1/util/SomethingChangedEventSupport.class */
public class SomethingChangedEventSupport {
    Object source;
    Vector listeners = new Vector();

    public SomethingChangedEventSupport(Object obj) {
        this.source = obj;
    }

    public synchronized void addSomethingChangedListener(SomethingChangedListener somethingChangedListener) {
        if (!this.listeners.contains(somethingChangedListener)) {
            this.listeners.addElement(somethingChangedListener);
        }
    }

    public synchronized void removeSomethingChangedListener(SomethingChangedListener somethingChangedListener) {
        this.listeners.removeElement(somethingChangedListener);
    }

    public synchronized void fireSomethingChanged() {
        SomethingChangedEvent somethingChangedEvent = new SomethingChangedEvent(this.source);
        Enumeration elements = this.listeners.elements();
        while (elements.hasMoreElements()) {
            ((SomethingChangedListener) elements.nextElement()).somethingChanged(somethingChangedEvent);
        }
    }
}
