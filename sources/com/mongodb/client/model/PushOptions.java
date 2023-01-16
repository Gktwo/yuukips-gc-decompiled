package com.mongodb.client.model;

import com.mongodb.lang.Nullable;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/PushOptions.class */
public class PushOptions {
    private Integer position;
    private Integer slice;
    private Integer sort;
    private Bson sortDocument;

    @Nullable
    public Integer getPosition() {
        return this.position;
    }

    public PushOptions position(@Nullable Integer position) {
        this.position = position;
        return this;
    }

    @Nullable
    public Integer getSlice() {
        return this.slice;
    }

    public PushOptions slice(@Nullable Integer slice) {
        this.slice = slice;
        return this;
    }

    @Nullable
    public Integer getSort() {
        return this.sort;
    }

    public PushOptions sort(@Nullable Integer sort) {
        if (this.sortDocument != null) {
            throw new IllegalStateException("sort can not be set if sortDocument already is");
        }
        this.sort = sort;
        return this;
    }

    @Nullable
    public Bson getSortDocument() {
        return this.sortDocument;
    }

    public PushOptions sortDocument(@Nullable Bson sortDocument) {
        if (this.sort != null) {
            throw new IllegalStateException("sortDocument can not be set if sort already is");
        }
        this.sortDocument = sortDocument;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PushOptions that = (PushOptions) o;
        if (this.position != null) {
            if (!this.position.equals(that.position)) {
                return false;
            }
        } else if (that.position != null) {
            return false;
        }
        if (this.slice != null) {
            if (!this.slice.equals(that.slice)) {
                return false;
            }
        } else if (that.slice != null) {
            return false;
        }
        if (this.sort != null) {
            if (!this.sort.equals(that.sort)) {
                return false;
            }
        } else if (that.sort != null) {
            return false;
        }
        return this.sortDocument != null ? this.sortDocument.equals(that.sortDocument) : that.sortDocument == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * (this.position != null ? this.position.hashCode() : 0)) + (this.slice != null ? this.slice.hashCode() : 0))) + (this.sort != null ? this.sort.hashCode() : 0))) + (this.sortDocument != null ? this.sortDocument.hashCode() : 0);
    }

    public String toString() {
        return "Push Options{position=" + this.position + ", slice=" + this.slice + (this.sort == null ? "" : ", sort=" + this.sort) + (this.sortDocument == null ? "" : ", sortDocument=" + this.sortDocument) + '}';
    }
}
