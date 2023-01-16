package com.mongodb.client.model;

import com.mongodb.CreateIndexCommitQuorum;
import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/mongodb/client/model/CreateIndexOptions.class */
public class CreateIndexOptions {
    private long maxTimeMS;
    private CreateIndexCommitQuorum commitQuorum;

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public CreateIndexOptions maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    @Nullable
    public CreateIndexCommitQuorum getCommitQuorum() {
        return this.commitQuorum;
    }

    public CreateIndexOptions commitQuorum(CreateIndexCommitQuorum commitQuorum) {
        this.commitQuorum = commitQuorum;
        return this;
    }

    public String toString() {
        return "CreateIndexOptions{maxTimeMS=" + this.maxTimeMS + ", commitQuorum=" + this.commitQuorum + '}';
    }
}
