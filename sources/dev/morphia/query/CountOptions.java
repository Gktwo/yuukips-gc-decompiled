package dev.morphia.query;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.client.ClientSession;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.SessionConfigurable;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:dev/morphia/query/CountOptions.class */
public class CountOptions extends com.mongodb.client.model.CountOptions implements SessionConfigurable<CountOptions> {
    private ReadPreference readPreference;
    private ReadConcern readConcern;
    private ClientSession clientSession;

    @Override // dev.morphia.internal.SessionConfigurable
    public CountOptions clientSession(ClientSession clientSession) {
        this.clientSession = clientSession;
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public ClientSession clientSession() {
        return this.clientSession;
    }

    public CountOptions hint(String hint) {
        hint((Bson) new Document(hint, 1));
        return this;
    }

    public CountOptions hint(Document hint) {
        hint((Bson) hint);
        return this;
    }

    @Override // com.mongodb.client.model.CountOptions
    public CountOptions hint(@Nullable Bson hint) {
        hint(hint);
        return this;
    }

    @Override // com.mongodb.client.model.CountOptions
    public CountOptions limit(int limit) {
        limit(limit);
        return this;
    }

    @Override // com.mongodb.client.model.CountOptions
    public CountOptions hintString(@Nullable String hint) {
        hintString(hint);
        return this;
    }

    @Override // com.mongodb.client.model.CountOptions
    public CountOptions skip(int skip) {
        skip(skip);
        return this;
    }

    @Override // com.mongodb.client.model.CountOptions
    public long getMaxTime(TimeUnit timeUnit) {
        return getMaxTime(timeUnit);
    }

    @Override // com.mongodb.client.model.CountOptions
    public CountOptions maxTime(long maxTime, TimeUnit timeUnit) {
        maxTime(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.model.CountOptions
    public CountOptions collation(@Nullable Collation collation) {
        collation(collation);
        return this;
    }

    public ReadConcern readConcern() {
        return this.readConcern;
    }

    public CountOptions readConcern(ReadConcern readConcern) {
        this.readConcern = readConcern;
        return this;
    }

    public ReadPreference readPreference() {
        return this.readPreference;
    }

    public CountOptions readPreference(ReadPreference readPreference) {
        this.readPreference = readPreference;
        return this;
    }
}
