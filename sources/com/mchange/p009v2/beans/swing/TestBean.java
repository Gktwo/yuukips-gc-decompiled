package com.mchange.p009v2.beans.swing;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/* renamed from: com.mchange.v2.beans.swing.TestBean */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/TestBean.class */
public class TestBean {

    /* renamed from: s */
    String f394s;

    /* renamed from: i */
    int f395i;

    /* renamed from: f */
    float f396f;
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public String getTheString() {
        return this.f394s;
    }

    public int getTheInt() {
        return this.f395i;
    }

    public float getTheFloat() {
        return this.f396f;
    }

    public void setTheString(String str) {
        if (!eqOrBothNull(str, this.f394s)) {
            String str2 = this.f394s;
            this.f394s = str;
            this.pcs.firePropertyChange("theString", str2, this.f394s);
        }
    }

    public void setTheInt(int i) {
        if (i != this.f395i) {
            int i2 = this.f395i;
            this.f395i = i;
            this.pcs.firePropertyChange("theInt", i2, this.f395i);
        }
    }

    public void setTheFloat(float f) {
        if (f != this.f396f) {
            float f2 = this.f396f;
            this.f396f = f;
            this.pcs.firePropertyChange("theFloat", new Float(f2), new Float(this.f396f));
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.pcs.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.pcs.removePropertyChangeListener(propertyChangeListener);
    }

    private boolean eqOrBothNull(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
