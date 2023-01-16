package dev.morphia;

import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.internal.WriteConfigurable;

/* loaded from: grasscutter.jar:dev/morphia/InsertManyOptions.class */
public class InsertManyOptions implements SessionConfigurable<InsertManyOptions>, WriteConfigurable<InsertManyOptions> {
    private com.mongodb.client.model.InsertManyOptions options;
    private WriteConcern writeConcern;
    private ClientSession clientSession;

    public InsertManyOptions() {
        this.options = new com.mongodb.client.model.InsertManyOptions();
        this.writeConcern = WriteConcern.ACKNOWLEDGED;
    }

    public InsertManyOptions(InsertManyOptions that) {
        this.options = new com.mongodb.client.model.InsertManyOptions();
        this.writeConcern = WriteConcern.ACKNOWLEDGED;
        this.options = that.options;
        this.writeConcern = that.writeConcern;
        this.clientSession = that.clientSession;
    }

    public InsertManyOptions bypassDocumentValidation(Boolean bypassDocumentValidation) {
        this.options.bypassDocumentValidation(bypassDocumentValidation);
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public InsertManyOptions clientSession(@Nullable ClientSession clientSession) {
        this.clientSession = clientSession;
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public ClientSession clientSession() {
        return this.clientSession;
    }

    @Nullable
    public Boolean getBypassDocumentValidation() {
        return this.options.getBypassDocumentValidation();
    }

    public com.mongodb.client.model.InsertManyOptions getOptions() {
        return this.options;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    @Deprecated(since = "2.0", forRemoval = true)
    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public boolean isOrdered() {
        return this.options.isOrdered();
    }

    public InsertManyOptions ordered(boolean ordered) {
        this.options.ordered(ordered);
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    public InsertManyOptions writeConcern(@Nullable WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    @Nullable
    public WriteConcern writeConcern() {
        return this.writeConcern;
    }
}
