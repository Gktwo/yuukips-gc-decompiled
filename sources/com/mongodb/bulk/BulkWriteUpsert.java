package com.mongodb.bulk;

import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/bulk/BulkWriteUpsert.class */
public class BulkWriteUpsert {
    private final int index;

    /* renamed from: id */
    private final BsonValue f440id;

    public BulkWriteUpsert(int index, BsonValue id) {
        this.index = index;
        this.f440id = id;
    }

    public int getIndex() {
        return this.index;
    }

    public BsonValue getId() {
        return this.f440id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BulkWriteUpsert that = (BulkWriteUpsert) o;
        if (this.index == that.index && this.f440id.equals(that.f440id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.index) + this.f440id.hashCode();
    }

    public String toString() {
        return "BulkWriteUpsert{index=" + this.index + ", id=" + this.f440id + '}';
    }
}
