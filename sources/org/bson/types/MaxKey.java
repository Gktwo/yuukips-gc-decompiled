package org.bson.types;

import java.io.Serializable;

/* loaded from: grasscutter.jar:org/bson/types/MaxKey.class */
public final class MaxKey implements Serializable {
    private static final long serialVersionUID = 5123414776151687185L;

    @Override // java.lang.Object
    public boolean equals(Object o) {
        return o instanceof MaxKey;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "MaxKey";
    }
}
