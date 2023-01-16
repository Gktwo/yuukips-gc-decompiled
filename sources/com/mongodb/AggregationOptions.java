package com.mongodb;

import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/mongodb/AggregationOptions.class */
public class AggregationOptions {
    private final Integer batchSize;
    private final Boolean allowDiskUse;
    private final long maxTimeMS;
    private final Boolean bypassDocumentValidation;
    private final Collation collation;

    AggregationOptions(Builder builder) {
        this.batchSize = builder.batchSize;
        this.allowDiskUse = builder.allowDiskUse;
        this.maxTimeMS = builder.maxTimeMS;
        this.bypassDocumentValidation = builder.bypassDocumentValidation;
        this.collation = builder.collation;
    }

    @Nullable
    public Boolean getAllowDiskUse() {
        return this.allowDiskUse;
    }

    @Nullable
    public Integer getBatchSize() {
        return this.batchSize;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    @Nullable
    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    public String toString() {
        return "AggregationOptions{batchSize=" + this.batchSize + ", allowDiskUse=" + this.allowDiskUse + ", maxTimeMS=" + this.maxTimeMS + ", bypassDocumentValidation=" + this.bypassDocumentValidation + ", collation=" + this.collation + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/AggregationOptions$Builder.class */
    public static class Builder {
        private Integer batchSize;
        private Boolean allowDiskUse;
        private long maxTimeMS;
        private Boolean bypassDocumentValidation;
        private Collation collation;

        private Builder() {
        }

        public Builder batchSize(@Nullable Integer size) {
            this.batchSize = size;
            return this;
        }

        public Builder allowDiskUse(@Nullable Boolean allowDiskUse) {
            this.allowDiskUse = allowDiskUse;
            return this;
        }

        public Builder maxTime(long maxTime, TimeUnit timeUnit) {
            this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
            return this;
        }

        public Builder bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
            this.bypassDocumentValidation = bypassDocumentValidation;
            return this;
        }

        public Builder collation(@Nullable Collation collation) {
            this.collation = collation;
            return this;
        }

        public AggregationOptions build() {
            return new AggregationOptions(this);
        }
    }
}
