package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonTimestamp.class */
public final class BsonTimestamp extends BsonValue implements Comparable<BsonTimestamp> {
    private final long value;

    public BsonTimestamp() {
        this.value = 0;
    }

    public BsonTimestamp(long value) {
        this.value = value;
    }

    public BsonTimestamp(int seconds, int increment) {
        this.value = (((long) seconds) << 32) | (((long) increment) & 4294967295L);
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.TIMESTAMP;
    }

    public long getValue() {
        return this.value;
    }

    public int getTime() {
        return (int) (this.value >> 32);
    }

    public int getInc() {
        return (int) this.value;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Timestamp{value=" + getValue() + ", seconds=" + getTime() + ", inc=" + getInc() + '}';
    }

    public int compareTo(BsonTimestamp ts) {
        return Long.compareUnsigned(this.value, ts.value);
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass() && this.value == ((BsonTimestamp) o).value) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (int) (this.value ^ (this.value >>> 32));
    }
}
