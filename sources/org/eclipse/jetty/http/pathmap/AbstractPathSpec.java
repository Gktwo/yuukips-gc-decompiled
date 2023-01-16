package org.eclipse.jetty.http.pathmap;

import java.util.Objects;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/AbstractPathSpec.class */
public abstract class AbstractPathSpec implements PathSpec {
    public int compareTo(PathSpec other) {
        int diff = getGroup().ordinal() - other.getGroup().ordinal();
        if (diff != 0) {
            return diff;
        }
        int diff2 = other.getSpecLength() - getSpecLength();
        if (diff2 != 0) {
            return diff2;
        }
        int diff3 = getDeclaration().compareTo(other.getDeclaration());
        if (diff3 != 0) {
            return diff3;
        }
        return getClass().getName().compareTo(other.getClass().getName());
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && compareTo((PathSpec) ((AbstractPathSpec) obj)) == 0;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Objects.hash(Integer.valueOf(getGroup().ordinal()), Integer.valueOf(getSpecLength()), getDeclaration(), getClass().getName());
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("%s@%s{%s}", getClass().getSimpleName(), Integer.toHexString(hashCode()), getDeclaration());
    }
}
