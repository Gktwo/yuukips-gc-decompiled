package com.mongodb.client.model;

import com.mongodb.lang.Nullable;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/GraphLookupOptions.class */
public final class GraphLookupOptions {
    private Integer maxDepth;
    private String depthField;
    private Bson restrictSearchWithMatch;

    public GraphLookupOptions depthField(@Nullable String field) {
        this.depthField = field;
        return this;
    }

    @Nullable
    public String getDepthField() {
        return this.depthField;
    }

    public GraphLookupOptions maxDepth(@Nullable Integer max) {
        this.maxDepth = max;
        return this;
    }

    @Nullable
    public Integer getMaxDepth() {
        return this.maxDepth;
    }

    public GraphLookupOptions restrictSearchWithMatch(@Nullable Bson filter) {
        this.restrictSearchWithMatch = filter;
        return this;
    }

    @Nullable
    public Bson getRestrictSearchWithMatch() {
        return this.restrictSearchWithMatch;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GraphLookupOptions that = (GraphLookupOptions) o;
        if (this.maxDepth != null) {
            if (!this.maxDepth.equals(that.maxDepth)) {
                return false;
            }
        } else if (that.maxDepth != null) {
            return false;
        }
        if (this.depthField != null) {
            if (!this.depthField.equals(that.depthField)) {
                return false;
            }
        } else if (that.depthField != null) {
            return false;
        }
        return this.restrictSearchWithMatch != null ? this.restrictSearchWithMatch.equals(that.restrictSearchWithMatch) : that.restrictSearchWithMatch == null;
    }

    public int hashCode() {
        return (31 * ((31 * (this.maxDepth != null ? this.maxDepth.hashCode() : 0)) + (this.depthField != null ? this.depthField.hashCode() : 0))) + (this.restrictSearchWithMatch != null ? this.restrictSearchWithMatch.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("GraphLookupOptions{");
        if (this.depthField != null) {
            stringBuilder.append("depthField='").append(this.depthField).append('\'');
            if (this.maxDepth != null) {
                stringBuilder.append(", ");
            }
        }
        if (this.maxDepth != null) {
            stringBuilder.append("maxDepth=").append(this.maxDepth);
            if (this.restrictSearchWithMatch != null) {
                stringBuilder.append(", ");
            }
        }
        if (this.restrictSearchWithMatch != null) {
            stringBuilder.append("restrictSearchWithMatch=").append(this.restrictSearchWithMatch);
        }
        return stringBuilder.append('}').toString();
    }
}
