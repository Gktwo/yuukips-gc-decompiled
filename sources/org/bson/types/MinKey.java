package org.bson.types;

import java.io.Serializable;

/* loaded from: grasscutter.jar:org/bson/types/MinKey.class */
public final class MinKey implements Serializable {
    private static final long serialVersionUID = 4075901136671855684L;

    @Override // java.lang.Object
    public boolean equals(Object o) {
        return o instanceof MinKey;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "MinKey";
    }
}
