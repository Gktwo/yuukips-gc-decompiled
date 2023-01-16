package dev.morphia;

import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.internal.WriteConfigurable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:dev/morphia/ModifyOptions.class */
public class ModifyOptions extends FindOneAndUpdateOptions implements SessionConfigurable<ModifyOptions>, WriteConfigurable<ModifyOptions> {
    private WriteConcern writeConcern;
    private ClientSession clientSession;

    @Override // dev.morphia.internal.SessionConfigurable
    public ModifyOptions clientSession(ClientSession clientSession) {
        this.clientSession = clientSession;
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public ClientSession clientSession() {
        return this.clientSession;
    }

    public ModifyOptions hint(Document hint) {
        hint((Bson) hint);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions projection(@Nullable Bson projection) {
        projection(projection);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions sort(@Nullable Bson sort) {
        sort(sort);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions upsert(boolean upsert) {
        upsert(upsert);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions returnDocument(ReturnDocument returnDocument) {
        returnDocument(returnDocument);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions maxTime(long maxTime, TimeUnit timeUnit) {
        maxTime(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        bypassDocumentValidation(bypassDocumentValidation);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions collation(@Nullable Collation collation) {
        collation(collation);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions arrayFilters(@Nullable List<? extends Bson> arrayFilters) {
        arrayFilters(arrayFilters);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions hint(@Nullable Bson hint) {
        hint(hint);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndUpdateOptions
    public ModifyOptions hintString(@Nullable String hint) {
        hintString(hint);
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    public ModifyOptions writeConcern(@Nullable WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    @Nullable
    public WriteConcern writeConcern() {
        return this.writeConcern;
    }
}
