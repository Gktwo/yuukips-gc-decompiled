package com.mongodb.client.model;

import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/client/model/BucketOptions.class */
public class BucketOptions {
    private Object defaultBucket;
    private List<BsonField> output;

    public BucketOptions defaultBucket(@Nullable Object name) {
        this.defaultBucket = name;
        return this;
    }

    @Nullable
    public Object getDefaultBucket() {
        return this.defaultBucket;
    }

    @Nullable
    public List<BsonField> getOutput() {
        if (this.output == null) {
            return null;
        }
        return new ArrayList(this.output);
    }

    public BucketOptions output(BsonField... output) {
        this.output = Arrays.asList(output);
        return this;
    }

    public BucketOptions output(List<BsonField> output) {
        this.output = output;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BucketOptions that = (BucketOptions) o;
        if (this.defaultBucket != null) {
            if (!this.defaultBucket.equals(that.defaultBucket)) {
                return false;
            }
        } else if (that.defaultBucket != null) {
            return false;
        }
        return this.output != null ? this.output.equals(that.output) : that.output == null;
    }

    public int hashCode() {
        return (31 * (this.defaultBucket != null ? this.defaultBucket.hashCode() : 0)) + (this.output != null ? this.output.hashCode() : 0);
    }

    public String toString() {
        return "BucketOptions{defaultBucket=" + this.defaultBucket + ", output=" + this.output + '}';
    }
}
