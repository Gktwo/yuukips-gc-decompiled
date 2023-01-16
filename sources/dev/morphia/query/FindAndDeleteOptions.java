package dev.morphia.query;

import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.FindOneAndDeleteOptions;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.internal.WriteConfigurable;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:dev/morphia/query/FindAndDeleteOptions.class */
public class FindAndDeleteOptions extends FindOneAndDeleteOptions implements SessionConfigurable<FindAndDeleteOptions>, WriteConfigurable<FindAndDeleteOptions> {
    private WriteConcern writeConcern = WriteConcern.ACKNOWLEDGED;
    private ClientSession clientSession;

    @Override // dev.morphia.internal.SessionConfigurable
    public FindAndDeleteOptions clientSession(ClientSession clientSession) {
        this.clientSession = clientSession;
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public ClientSession clientSession() {
        return this.clientSession;
    }

    public FindAndDeleteOptions hint(Document hint) {
        hint((Bson) hint);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndDeleteOptions
    public FindAndDeleteOptions projection(@Nullable Bson projection) {
        projection(projection);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndDeleteOptions
    public FindAndDeleteOptions sort(@Nullable Bson sort) {
        sort(sort);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndDeleteOptions
    public FindAndDeleteOptions maxTime(long maxTime, TimeUnit timeUnit) {
        maxTime(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndDeleteOptions
    public FindAndDeleteOptions collation(@Nullable Collation collation) {
        collation(collation);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndDeleteOptions
    public FindAndDeleteOptions hint(@Nullable Bson hint) {
        hint(hint);
        return this;
    }

    @Override // com.mongodb.client.model.FindOneAndDeleteOptions
    public FindAndDeleteOptions hintString(@Nullable String hint) {
        hintString(hint);
        return this;
    }

    public FindAndDeleteOptions sort(Document sort) {
        sort((Bson) sort);
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    public FindAndDeleteOptions writeConcern(@Nullable WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    @Nullable
    public WriteConcern writeConcern() {
        return this.writeConcern;
    }
}
