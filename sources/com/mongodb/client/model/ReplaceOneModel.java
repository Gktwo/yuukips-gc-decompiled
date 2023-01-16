package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/ReplaceOneModel.class */
public final class ReplaceOneModel<T> extends WriteModel<T> {
    private final Bson filter;
    private final T replacement;
    private final ReplaceOptions options;

    public ReplaceOneModel(Bson filter, T replacement) {
        this(filter, replacement, new ReplaceOptions());
    }

    public ReplaceOneModel(Bson filter, T replacement, ReplaceOptions options) {
        this.filter = (Bson) Assertions.notNull("filter", filter);
        this.options = (ReplaceOptions) Assertions.notNull("options", options);
        this.replacement = (T) Assertions.notNull("replacement", replacement);
    }

    public Bson getFilter() {
        return this.filter;
    }

    public T getReplacement() {
        return this.replacement;
    }

    public ReplaceOptions getReplaceOptions() {
        return this.options;
    }

    public String toString() {
        return "ReplaceOneModel{filter=" + this.filter + ", replacement=" + this.replacement + ", options=" + this.options + '}';
    }
}
