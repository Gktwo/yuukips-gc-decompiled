package org.bson;

import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:org/bson/BsonObjectId.class */
public class BsonObjectId extends BsonValue implements Comparable<BsonObjectId> {
    private final ObjectId value;

    public BsonObjectId() {
        this(new ObjectId());
    }

    public BsonObjectId(ObjectId value) {
        if (value == null) {
            throw new IllegalArgumentException("value may not be null");
        }
        this.value = value;
    }

    public ObjectId getValue() {
        return this.value;
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.OBJECT_ID;
    }

    public int compareTo(BsonObjectId o) {
        return this.value.compareTo(o.value);
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.value.equals(((BsonObjectId) o).value)) {
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
        return "BsonObjectId{value=" + this.value.toHexString() + '}';
    }
}
