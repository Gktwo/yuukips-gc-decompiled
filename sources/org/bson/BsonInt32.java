package org.bson;

import org.bson.types.Decimal128;

/* loaded from: grasscutter.jar:org/bson/BsonInt32.class */
public final class BsonInt32 extends BsonNumber implements Comparable<BsonInt32> {
    private final int value;

    public BsonInt32(int value) {
        this.value = value;
    }

    public int compareTo(BsonInt32 o) {
        if (this.value < o.value) {
            return -1;
        }
        return this.value == o.value ? 0 : 1;
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.INT32;
    }

    public int getValue() {
        return this.value;
    }

    @Override // org.bson.BsonNumber
    public int intValue() {
        return this.value;
    }

    @Override // org.bson.BsonNumber
    public long longValue() {
        return (long) this.value;
    }

    @Override // org.bson.BsonNumber
    public Decimal128 decimal128Value() {
        return new Decimal128((long) this.value);
    }

    @Override // org.bson.BsonNumber
    public double doubleValue() {
        return (double) this.value;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass() && this.value == ((BsonInt32) o).value) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Object
    public String toString() {
        return "BsonInt32{value=" + this.value + '}';
    }
}
