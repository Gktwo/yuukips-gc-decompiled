package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonBoolean.class */
public final class BsonBoolean extends BsonValue implements Comparable<BsonBoolean> {
    private final boolean value;
    public static final BsonBoolean TRUE = new BsonBoolean(true);
    public static final BsonBoolean FALSE = new BsonBoolean(false);

    public static BsonBoolean valueOf(boolean value) {
        return value ? TRUE : FALSE;
    }

    public BsonBoolean(boolean value) {
        this.value = value;
    }

    public int compareTo(BsonBoolean o) {
        return Boolean.valueOf(this.value).compareTo(Boolean.valueOf(o.value));
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.BOOLEAN;
    }

    public boolean getValue() {
        return this.value;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass() && this.value == ((BsonBoolean) o).value) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.value ? 1 : 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "BsonBoolean{value=" + this.value + '}';
    }
}
