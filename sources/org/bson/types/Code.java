package org.bson.types;

import java.io.Serializable;

/* loaded from: grasscutter.jar:org/bson/types/Code.class */
public class Code implements Serializable {
    private static final long serialVersionUID = 475535263314046697L;
    private final String code;

    public Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.code.equals(((Code) o).code)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "Code{code='" + this.code + "'}";
    }
}
