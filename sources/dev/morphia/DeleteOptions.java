package dev.morphia;

import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.internal.WriteConfigurable;
import org.bson.Document;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:dev/morphia/DeleteOptions.class */
public final class DeleteOptions extends com.mongodb.client.model.DeleteOptions implements SessionConfigurable<DeleteOptions>, WriteConfigurable<DeleteOptions> {
    private boolean multi;
    private WriteConcern writeConcern;
    private ClientSession clientSession;

    public DeleteOptions() {
        this.writeConcern = WriteConcern.ACKNOWLEDGED;
    }

    public DeleteOptions(DeleteOptions that) {
        this.writeConcern = WriteConcern.ACKNOWLEDGED;
        this.multi = that.multi;
        this.writeConcern = that.writeConcern;
        this.clientSession = that.clientSession;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public DeleteOptions clientSession(@Nullable ClientSession clientSession) {
        this.clientSession = clientSession;
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public ClientSession clientSession() {
        return this.clientSession;
    }

    @Override // com.mongodb.client.model.DeleteOptions
    public DeleteOptions collation(@Nullable Collation collation) {
        collation(collation);
        return this;
    }

    @Override // com.mongodb.client.model.DeleteOptions
    public DeleteOptions hint(@Nullable Bson hint) {
        hint(hint);
        return this;
    }

    @Override // com.mongodb.client.model.DeleteOptions
    public DeleteOptions hintString(@Nullable String hint) {
        hintString(hint);
        return this;
    }

    public DeleteOptions hint(Document hint) {
        hint((Bson) hint);
        return this;
    }

    public boolean isMulti() {
        return this.multi;
    }

    public DeleteOptions multi(boolean multi) {
        this.multi = multi;
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    public DeleteOptions writeConcern(@Nullable WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    @Nullable
    public WriteConcern writeConcern() {
        return this.writeConcern;
    }
}
