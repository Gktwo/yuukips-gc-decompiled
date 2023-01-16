package com.mongodb;

import com.mongodb.annotations.Immutable;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/ReadPreferenceHedgeOptions.class */
public final class ReadPreferenceHedgeOptions {
    private final boolean enabled;

    public boolean isEnabled() {
        return this.enabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public BsonDocument toBsonDocument() {
        return new BsonDocument("enabled", new BsonBoolean(this.enabled));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass() && this.enabled == ((ReadPreferenceHedgeOptions) o).enabled;
    }

    public int hashCode() {
        return this.enabled ? 1 : 0;
    }

    public String toString() {
        return "ReadPreferenceHedgeOptions{enabled=" + this.enabled + '}';
    }

    /* loaded from: grasscutter.jar:com/mongodb/ReadPreferenceHedgeOptions$Builder.class */
    public static final class Builder {
        private boolean enabled;

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public ReadPreferenceHedgeOptions build() {
            return new ReadPreferenceHedgeOptions(this);
        }

        private Builder() {
        }
    }

    private ReadPreferenceHedgeOptions(Builder builder) {
        this.enabled = builder.enabled;
    }
}
