package org.bson;

import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:org/bson/BsonDbPointer.class */
public class BsonDbPointer extends BsonValue {
    private final String namespace;

    /* renamed from: id */
    private final ObjectId f3078id;

    public BsonDbPointer(String namespace, ObjectId id) {
        if (namespace == null) {
            throw new IllegalArgumentException("namespace can not be null");
        } else if (id == null) {
            throw new IllegalArgumentException("id can not be null");
        } else {
            this.namespace = namespace;
            this.f3078id = id;
        }
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.DB_POINTER;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public ObjectId getId() {
        return this.f3078id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BsonDbPointer dbPointer = (BsonDbPointer) o;
        if (this.f3078id.equals(dbPointer.f3078id) && this.namespace.equals(dbPointer.namespace)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.namespace.hashCode()) + this.f3078id.hashCode();
    }

    public String toString() {
        return "BsonDbPointer{namespace='" + this.namespace + "', id=" + this.f3078id + '}';
    }
}
