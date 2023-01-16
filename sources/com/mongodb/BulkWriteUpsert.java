package com.mongodb;

/* loaded from: grasscutter.jar:com/mongodb/BulkWriteUpsert.class */
public class BulkWriteUpsert {
    private final int index;

    /* renamed from: id */
    private final Object f425id;

    public BulkWriteUpsert(int index, Object id) {
        this.index = index;
        this.f425id = id;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getId() {
        return this.f425id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BulkWriteUpsert that = (BulkWriteUpsert) o;
        if (this.index == that.index && this.f425id.equals(that.f425id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.index) + this.f425id.hashCode();
    }

    public String toString() {
        return "BulkWriteUpsert{index=" + this.index + ", id=" + this.f425id + '}';
    }
}
