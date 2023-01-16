package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonMinKey.class */
public final class BsonMinKey extends BsonValue {
    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.MIN_KEY;
    }

    public boolean equals(Object o) {
        return o instanceof BsonMinKey;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "BsonMinKey";
    }
}
