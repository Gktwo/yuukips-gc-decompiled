package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/FindOneAndDeleteOptions.class */
public class FindOneAndDeleteOptions {
    private Bson projection;
    private Bson sort;
    private long maxTimeMS;
    private Collation collation;
    private Bson hint;
    private String hintString;

    @Nullable
    public Bson getProjection() {
        return this.projection;
    }

    public FindOneAndDeleteOptions projection(@Nullable Bson projection) {
        this.projection = projection;
        return this;
    }

    @Nullable
    public Bson getSort() {
        return this.sort;
    }

    public FindOneAndDeleteOptions sort(@Nullable Bson sort) {
        this.sort = sort;
        return this;
    }

    public FindOneAndDeleteOptions maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    public FindOneAndDeleteOptions collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    @Nullable
    public Bson getHint() {
        return this.hint;
    }

    @Nullable
    public String getHintString() {
        return this.hintString;
    }

    public FindOneAndDeleteOptions hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    public FindOneAndDeleteOptions hintString(@Nullable String hint) {
        this.hintString = hint;
        return this;
    }

    public String toString() {
        return "FindOneAndDeleteOptions{projection=" + this.projection + ", sort=" + this.sort + ", maxTimeMS=" + this.maxTimeMS + ", collation=" + this.collation + ", hint=" + this.hint + ", hintString='" + this.hintString + "'}";
    }
}
