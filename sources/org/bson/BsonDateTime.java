package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonDateTime.class */
public class BsonDateTime extends BsonValue implements Comparable<BsonDateTime> {
    private final long value;

    public BsonDateTime(long value) {
        this.value = value;
    }

    public int compareTo(BsonDateTime o) {
        return Long.compare(this.value, o.value);
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.DATE_TIME;
    }

    public long getValue() {
        return this.value;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass() && this.value == ((BsonDateTime) o).value) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (int) (this.value ^ (this.value >>> 32));
    }

    @Override // java.lang.Object
    public String toString() {
        return "BsonDateTime{value=" + this.value + '}';
    }
}
