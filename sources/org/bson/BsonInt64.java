package org.bson;

import org.bson.types.Decimal128;

/* loaded from: grasscutter.jar:org/bson/BsonInt64.class */
public final class BsonInt64 extends BsonNumber implements Comparable<BsonInt64> {
    private final long value;

    public BsonInt64(long value) {
        this.value = value;
    }

    public int compareTo(BsonInt64 o) {
        if (this.value < o.value) {
            return -1;
        }
        return this.value == o.value ? 0 : 1;
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.INT64;
    }

    public long getValue() {
        return this.value;
    }

    @Override // org.bson.BsonNumber
    public int intValue() {
        return (int) this.value;
    }

    @Override // org.bson.BsonNumber
    public long longValue() {
        return this.value;
    }

    @Override // org.bson.BsonNumber
    public double doubleValue() {
        return (double) this.value;
    }

    @Override // org.bson.BsonNumber
    public Decimal128 decimal128Value() {
        return new Decimal128(this.value);
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass() && this.value == ((BsonInt64) o).value) {
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
        return "BsonInt64{value=" + this.value + '}';
    }
}
