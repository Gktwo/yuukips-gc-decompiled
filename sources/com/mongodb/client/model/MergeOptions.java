package com.mongodb.client.model;

import java.util.Collections;
import java.util.List;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/MergeOptions.class */
public final class MergeOptions {
    private List<String> uniqueIdentifier;
    private WhenMatched whenMatched;
    private List<Variable<?>> variables;
    private List<Bson> whenMatchedPipeline;
    private WhenNotMatched whenNotMatched;

    /* loaded from: grasscutter.jar:com/mongodb/client/model/MergeOptions$WhenMatched.class */
    public enum WhenMatched {
        REPLACE,
        KEEP_EXISTING,
        MERGE,
        PIPELINE,
        FAIL
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/MergeOptions$WhenNotMatched.class */
    public enum WhenNotMatched {
        INSERT,
        DISCARD,
        FAIL
    }

    public List<String> getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    public MergeOptions uniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = Collections.singletonList(uniqueIdentifier);
        return this;
    }

    public MergeOptions uniqueIdentifier(List<String> uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        return this;
    }

    public WhenMatched getWhenMatched() {
        return this.whenMatched;
    }

    public MergeOptions whenMatched(WhenMatched whenMatched) {
        this.whenMatched = whenMatched;
        return this;
    }

    public List<Variable<?>> getVariables() {
        return this.variables;
    }

    public MergeOptions variables(List<Variable<?>> variables) {
        this.variables = variables;
        return this;
    }

    public List<Bson> getWhenMatchedPipeline() {
        return this.whenMatchedPipeline;
    }

    public MergeOptions whenMatchedPipeline(List<Bson> whenMatchedPipeline) {
        this.whenMatchedPipeline = whenMatchedPipeline;
        return this;
    }

    public WhenNotMatched getWhenNotMatched() {
        return this.whenNotMatched;
    }

    public MergeOptions whenNotMatched(WhenNotMatched whenNotMatched) {
        this.whenNotMatched = whenNotMatched;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MergeOptions that = (MergeOptions) o;
        if (this.uniqueIdentifier != null) {
            if (!this.uniqueIdentifier.equals(that.uniqueIdentifier)) {
                return false;
            }
        } else if (that.uniqueIdentifier != null) {
            return false;
        }
        if (this.whenMatched != that.whenMatched) {
            return false;
        }
        if (this.variables != null) {
            if (!this.variables.equals(that.variables)) {
                return false;
            }
        } else if (that.variables != null) {
            return false;
        }
        if (this.whenMatchedPipeline != null) {
            if (!this.whenMatchedPipeline.equals(that.whenMatchedPipeline)) {
                return false;
            }
        } else if (that.whenMatchedPipeline != null) {
            return false;
        }
        if (this.whenNotMatched != that.whenNotMatched) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * (this.uniqueIdentifier != null ? this.uniqueIdentifier.hashCode() : 0)) + (this.whenMatched != null ? this.whenMatched.hashCode() : 0))) + (this.variables != null ? this.variables.hashCode() : 0))) + (this.whenMatchedPipeline != null ? this.whenMatchedPipeline.hashCode() : 0))) + (this.whenNotMatched != null ? this.whenNotMatched.hashCode() : 0);
    }

    public String toString() {
        return "MergeOptions{uniqueIdentifier=" + this.uniqueIdentifier + ", whenMatched=" + this.whenMatched + ", variables=" + this.variables + ", whenMatchedPipeline=" + this.whenMatchedPipeline + ", whenNotMatched=" + this.whenNotMatched + '}';
    }
}
