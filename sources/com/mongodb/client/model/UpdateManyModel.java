package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.List;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/UpdateManyModel.class */
public final class UpdateManyModel<T> extends WriteModel<T> {
    private final Bson filter;
    private final Bson update;
    private final List<? extends Bson> updatePipeline;
    private final UpdateOptions options;

    public UpdateManyModel(Bson filter, Bson update) {
        this(filter, update, new UpdateOptions());
    }

    public UpdateManyModel(Bson filter, Bson update, UpdateOptions options) {
        this.filter = (Bson) Assertions.notNull("filter", filter);
        this.update = (Bson) Assertions.notNull("update", update);
        this.updatePipeline = null;
        this.options = (UpdateOptions) Assertions.notNull("options", options);
    }

    public UpdateManyModel(Bson filter, List<? extends Bson> update) {
        this(filter, update, new UpdateOptions());
    }

    public UpdateManyModel(Bson filter, List<? extends Bson> update, UpdateOptions options) {
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
        return "UpdateManyModel{filter=" + this.filter + ", update=" + (this.update != null ? this.update : this.updatePipeline) + ", options=" + this.options + '}';
    }
}
