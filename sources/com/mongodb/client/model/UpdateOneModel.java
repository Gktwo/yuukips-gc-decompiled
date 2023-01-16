package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.List;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/UpdateOneModel.class */
public final class UpdateOneModel<T> extends WriteModel<T> {
    private final Bson filter;
    private final Bson update;
    private final List<? extends Bson> updatePipeline;
    private final UpdateOptions options;

    public UpdateOneModel(Bson filter, Bson update) {
        this(filter, update, new UpdateOptions());
    }

    public UpdateOneModel(Bson filter, Bson update, UpdateOptions options) {
        this.filter = (Bson) Assertions.notNull("filter", filter);
        this.update = (Bson) Assertions.notNull("update", update);
        this.updatePipeline = null;
        this.options = (UpdateOptions) Assertions.notNull("options", options);
    }

    public UpdateOneModel(Bson filter, List<? extends Bson> update) {
        this(filter, update, new UpdateOptions());
    }

    public UpdateOneModel(Bson filter, List<? extends Bson> update, UpdateOptions options) {
        this.filter = (Bson) Assertions.notNull("filter", filter);
        this.update = null;
        this.updatePipeline = update;
        this.options = (UpdateOptions) Assertions.notNull("options", options);
    }

    public Bson getFilter() {
        return this.filter;
    }

    @Nullable
    public Bson getUpdate() {
        return this.update;
    }

    @Nullable
    public List<? extends Bson> getUpdatePipeline() {
        return this.updatePipeline;
    }

    public UpdateOptions getOptions() {
        return this.options;
    }

    public String toString() {
        return "UpdateOneModel{filter=" + this.filter + ", update=" + (this.update != null ? this.update : this.updatePipeline) + ", options=" + this.options + '}';
    }
}
