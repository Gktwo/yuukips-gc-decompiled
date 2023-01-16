package dev.morphia;

import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.internal.WriteConfigurable;

/* loaded from: grasscutter.jar:dev/morphia/InsertOneOptions.class */
public class InsertOneOptions implements SessionConfigurable<InsertOneOptions>, WriteConfigurable<InsertOneOptions> {
    private com.mongodb.client.model.InsertOneOptions options;
    private WriteConcern writeConcern;
    private ClientSession clientSession;
    private boolean unset;

    public InsertOneOptions() {
        this.options = new com.mongodb.client.model.InsertOneOptions();
        this.writeConcern = WriteConcern.ACKNOWLEDGED;
    }

    public InsertOneOptions(InsertOneOptions that) {
        this.options = new com.mongodb.client.model.InsertOneOptions();
        this.writeConcern = WriteConcern.ACKNOWLEDGED;
        this.options = that.options;
        this.writeConcern = that.writeConcern;
        this.clientSession = that.clientSession;
    }

    public InsertOneOptions bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        this.options.bypassDocumentValidation(bypassDocumentValidation);
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public ClientSession clientSession() {
        return this.clientSession;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public InsertOneOptions clientSession(@Nullable ClientSession clientSession) {
        this.clientSession = clientSession;
        return this;
    }

    @Nullable
    public Boolean getBypassDocumentValidation() {
        return this.options.getBypassDocumentValidation();
    }

    public InsertOneOptions unsetMissing(boolean unset) {
        this.unset = unset;
        return this;
    }

    public boolean unsetMissing() {
        return this.unset;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    public InsertOneOptions writeConcern(@Nullable WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    @Nullable
    public WriteConcern writeConcern() {
        return this.writeConcern;
    }

    public com.mongodb.client.model.InsertOneOptions getOptions() {
        return this.options;
    }
}
