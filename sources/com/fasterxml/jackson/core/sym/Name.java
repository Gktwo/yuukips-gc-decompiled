package com.fasterxml.jackson.core.sym;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/sym/Name.class */
public abstract class Name {
    protected final String _name;
    protected final int _hashCode;

    public abstract boolean equals(int i);

    public abstract boolean equals(int i, int i2);

    public abstract boolean equals(int i, int i2, int i3);

    public abstract boolean equals(int[] iArr, int i);

    /* access modifiers changed from: protected */
    public Name(String name, int hashCode) {
        this._name = name;
        this._hashCode = hashCode;
    }

    public String getName() {
        return this._name;
    }

    public String toString() {
        return this._name;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public boolean equals(Object o) {
        return o == this;
    }
}
