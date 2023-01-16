package com.fasterxml.jackson.databind.type;

import java.io.Serializable;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/type/ClassKey.class */
public final class ClassKey implements Comparable<ClassKey>, Serializable {
    private static final long serialVersionUID = 1;
    private String _className;
    private Class<?> _class;
    private int _hashCode;

    public ClassKey() {
        this._class = null;
        this._className = null;
        this._hashCode = 0;
    }

    public ClassKey(Class<?> clz) {
        this._class = clz;
        this._className = clz.getName();
        this._hashCode = this._className.hashCode();
    }

    public void reset(Class<?> clz) {
        this._class = clz;
        this._className = clz.getName();
        this._hashCode = this._className.hashCode();
    }

    public int compareTo(ClassKey other) {
        return this._className.compareTo(other._className);
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        return o != null && o.getClass() == getClass() && ((ClassKey) o)._class == this._class;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this._hashCode;
    }

    @Override // java.lang.Object
    public String toString() {
        return this._className;
    }
}
