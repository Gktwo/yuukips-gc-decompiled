package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonString.class */
public class BsonString extends BsonValue implements Comparable<BsonString> {
    private final String value;

    public BsonString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        this.value = value;
    }

    public int compareTo(BsonString o) {
        return this.value.compareTo(o.value);
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.STRING;
    }

    public String getValue() {
        return this.value;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.value.equals(((BsonString) o).value)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "BsonString{value='" + this.value + "'}";
    }
}
