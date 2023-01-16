package com.mongodb;

import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/TransactionOptions.class */
public final class TransactionOptions {
    private final ReadConcern readConcern;
    private final WriteConcern writeConcern;
    private final ReadPreference readPreference;
    private final Long maxCommitTimeMS;

    @Nullable
    public ReadConcern getReadConcern() {
        return this.readConcern;
    }

    @Nullable
    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    @Nullable
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Nullable
    public Long getMaxCommitTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        if (this.maxCommitTimeMS == null) {
            return null;
        }
        return Long.valueOf(timeUnit.convert(this.maxCommitTimeMS.longValue(), TimeUnit.MILLISECONDS));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static TransactionOptions merge(TransactionOptions options, TransactionOptions defaultOptions) {
        Assertions.notNull("options", options);
        Assertions.notNull("defaultOptions", defaultOptions);
        return builder().writeConcern(options.getWriteConcern() == null ? defaultOptions.getWriteConcern() : options.getWriteConcern()).readConcern(options.getReadConcern() == null ? defaultOptions.getReadConcern() : options.getReadConcern()).readPreference(options.getReadPreference() == null ? defaultOptions.getReadPreference() : options.getReadPreference()).maxCommitTime(options.getMaxCommitTime(TimeUnit.MILLISECONDS) == null ? defaultOptions.getMaxCommitTime(TimeUnit.MILLISECONDS) : options.getMaxCommitTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).build();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionOptions that = (TransactionOptions) o;
        if (this.maxCommitTimeMS != null) {
            if (!this.maxCommitTimeMS.equals(that.maxCommitTimeMS)) {
                return false;
            }
        } else if (that.maxCommitTimeMS != null) {
            return false;
        }
        if (this.readConcern != null) {
            if (!this.readConcern.equals(that.readConcern)) {
                return false;
            }
        } else if (that.readConcern != null) {
            return false;
        }
        if (this.writeConcern != null) {
            if (!this.writeConcern.equals(that.writeConcern)) {
                return false;
            }
        } else if (that.writeConcern != null) {
            return false;
        }
        if (this.readPreference != null) {
            if (!this.readPreference.equals(that.readPreference)) {
                return false;
            }
            return true;
        } else if (that.readPreference != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * (this.readConcern != null ? this.readConcern.hashCode() : 0)) + (this.writeConcern != null ? this.writeConcern.hashCode() : 0))) + (this.readPreference != null ? this.readPreference.hashCode() : 0))) + (this.maxCommitTimeMS != null ? this.maxCommitTimeMS.hashCode() : 0);
    }

    public String toString() {
        return "TransactionOptions{readConcern=" + this.readConcern + ", writeConcern=" + this.writeConcern + ", readPreference=" + this.readPreference + ", maxCommitTimeMS" + this.maxCommitTimeMS + '}';
    }

    /* loaded from: grasscutter.jar:com/mongodb/TransactionOptions$Builder.class */
    public static final class Builder {
        private ReadConcern readConcern;
        private WriteConcern writeConcern;
        private ReadPreference readPreference;
        private Long maxCommitTimeMS;

        public Builder readConcern(@Nullable ReadConcern readConcern) {
            this.readConcern = readConcern;
            return this;
        }

        public Builder writeConcern(@Nullable WriteConcern writeConcern) {
            this.writeConcern = writeConcern;
            return this;
        }

        public Builder readPreference(@Nullable ReadPreference readPreference) {
            this.readPreference = readPreference;
            return this;
        }

        public Builder maxCommitTime(@Nullable Long maxCommitTime, TimeUnit timeUnit) {
            if (maxCommitTime == null) {
                this.maxCommitTimeMS = null;
            } else {
                Assertions.notNull("timeUnit", timeUnit);
                Assertions.isTrueArgument("maxCommitTime > 0", maxCommitTime.longValue() > 0);
                this.maxCommitTimeMS = Long.valueOf(TimeUnit.MILLISECONDS.convert(maxCommitTime.longValue(), timeUnit));
            }
            return this;
        }

        public TransactionOptions build() {
            return new TransactionOptions(this);
        }

        private Builder() {
        }
    }

    private TransactionOptions(Builder builder) {
        this.readConcern = builder.readConcern;
        this.writeConcern = builder.writeConcern;
        this.readPreference = builder.readPreference;
        this.maxCommitTimeMS = builder.maxCommitTimeMS;
    }
}
