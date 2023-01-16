package dev.morphia;

import com.mongodb.QueryOperators;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.internal.WriteConfigurable;
import dev.morphia.query.experimental.filters.Filter;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:dev/morphia/UpdateOptions.class */
public class UpdateOptions extends com.mongodb.client.model.UpdateOptions implements SessionConfigurable<UpdateOptions>, WriteConfigurable<UpdateOptions> {
    private WriteConcern writeConcern;
    private boolean multi;
    private ClientSession clientSession;

    public UpdateOptions arrayFilter(Filter filter) {
        List<Bson> arrayFilters = new ArrayList<>();
        if (getArrayFilters() != null) {
            arrayFilters.addAll(getArrayFilters());
        }
        Document filterDoc = new Document(filter.getName(), filter.getValue());
        if (filter.isNot()) {
            filterDoc = new Document(QueryOperators.NOT, filterDoc);
        }
        arrayFilters.add(new Document(filter.getField(), filterDoc));
        arrayFilters((List<? extends Bson>) arrayFilters);
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public UpdateOptions clientSession(@Nullable ClientSession clientSession) {
        this.clientSession = clientSession;
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    @Nullable
    public ClientSession clientSession() {
        return this.clientSession;
    }

    public UpdateOptions hint(Document hint) {
        hint((Bson) hint);
        return this;
    }

    public boolean isMulti() {
        return this.multi;
    }

    public UpdateOptions multi(boolean multi) {
        this.multi = multi;
        return this;
    }

    @Override // com.mongodb.client.model.UpdateOptions
    public UpdateOptions upsert(boolean upsert) {
        upsert(upsert);
        return this;
    }

    @Override // com.mongodb.client.model.UpdateOptions
    public UpdateOptions bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        bypassDocumentValidation(bypassDocumentValidation);
        return this;
    }

    @Override // com.mongodb.client.model.UpdateOptions
    public UpdateOptions collation(@Nullable Collation collation) {
        collation(collation);
        return this;
    }

    @Override // com.mongodb.client.model.UpdateOptions
    public UpdateOptions arrayFilters(@Nullable List<? extends Bson> arrayFilters) {
        arrayFilters(arrayFilters);
        return this;
    }

    @Override // com.mongodb.client.model.UpdateOptions
    public UpdateOptions hint(@Nullable Bson hint) {
        hint(hint);
        return this;
    }

    @Override // com.mongodb.client.model.UpdateOptions
    public UpdateOptions hintString(@Nullable String hint) {
        hintString(hint);
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    public UpdateOptions writeConcern(@Nullable WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    public WriteConcern writeConcern() {
        return this.writeConcern;
    }
}
