package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonSymbol.class */
public class BsonSymbol extends BsonValue {
    private final String symbol;

    public BsonSymbol(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        this.symbol = value;
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.SYMBOL;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.symbol.equals(((BsonSymbol) o).symbol)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.symbol.hashCode();
    }

    public String toString() {
        return this.symbol;
    }
}
