package org.bson.types;

import java.io.Serializable;

/* loaded from: grasscutter.jar:org/bson/types/Symbol.class */
public class Symbol implements Serializable {
    private static final long serialVersionUID = 1326269319883146072L;
    private final String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.symbol.equals(((Symbol) o).symbol)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.symbol.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.symbol;
    }
}
