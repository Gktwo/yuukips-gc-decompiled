package com.mongodb.bulk;

import java.util.Objects;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/bulk/BulkWriteInsert.class */
public class BulkWriteInsert {
    private final int index;

    /* renamed from: id */
    private final BsonValue f439id;

    public BulkWriteInsert(int index, BsonValue id) {
        this.index = index;
        this.f439id = id;
    }

    public int getIndex() {
        return this.index;
    }

    public BsonValue getId() {
        return this.f439id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BulkWriteInsert that = (BulkWriteInsert) o;
        return this.index == that.index && Objects.equals(this.f439id, that.f439id);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.index), this.f439id);
    }

    public String toString() {
        return "BulkWriteInsert{index=" + this.index + ", id=" + this.f439id + '}';
    }
}
