package com.mongodb.client.model;

import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/client/model/BucketAutoOptions.class */
public class BucketAutoOptions {
    private List<BsonField> output;
    private BucketGranularity granularity;

    @Nullable
    public BucketGranularity getGranularity() {
        return this.granularity;
    }

    @Nullable
    public List<BsonField> getOutput() {
        if (this.output == null) {
            return null;
        }
        return new ArrayList(this.output);
    }

    public BucketAutoOptions granularity(@Nullable BucketGranularity granularity) {
        this.granularity = granularity;
        return this;
    }

    public BucketAutoOptions output(BsonField... output) {
        this.output = Arrays.asList(output);
        return this;
    }

    public BucketAutoOptions output(@Nullable List<BsonField> output) {
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
        BucketAutoOptions that = (BucketAutoOptions) o;
        if (this.output != null) {
            if (!this.output.equals(that.output)) {
                return false;
            }
        } else if (that.output != null) {
            return false;
        }
        return this.granularity == that.granularity;
    }

    public int hashCode() {
        return (31 * (this.output != null ? this.output.hashCode() : 0)) + (this.granularity != null ? this.granularity.hashCode() : 0);
    }

    public String toString() {
        return "BucketAutoOptions{output=" + this.output + ", granularity=" + this.granularity + '}';
    }
}
