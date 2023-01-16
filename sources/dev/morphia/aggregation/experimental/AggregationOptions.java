package dev.morphia.aggregation.experimental;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.ReadConfigurable;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.internal.WriteConfigurable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/AggregationOptions.class */
public class AggregationOptions implements SessionConfigurable<AggregationOptions>, ReadConfigurable<AggregationOptions>, WriteConfigurable<AggregationOptions> {
    private boolean allowDiskUse;
    private Integer batchSize;
    private boolean bypassDocumentValidation;
    private Collation collation;
    private Long maxTimeMS;
    private ClientSession clientSession;
    private ReadPreference readPreference;
    private ReadConcern readConcern;
    private WriteConcern writeConcern;
    private Document hint;

    public boolean allowDiskUse() {
        return this.allowDiskUse;
    }

    public AggregationOptions allowDiskUse(boolean allowDiskUse) {
        this.allowDiskUse = allowDiskUse;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Class<S> */
    /* JADX WARN: Multi-variable type inference failed */
    public <S, T> AggregateIterable<S> apply(List<Document> documents, MongoCollection<T> collection, Class<S> resultType) {
        MongoCollection<T> bound = collection;
        if (this.readConcern != null) {
            bound = bound.withReadConcern(this.readConcern);
        }
        if (this.readPreference != null) {
            bound = bound.withReadPreference(this.readPreference);
        }
        AggregateIterable<S> aggregate = bound.aggregate(documents, resultType).allowDiskUse(Boolean.valueOf(this.allowDiskUse)).bypassDocumentValidation(Boolean.valueOf(this.bypassDocumentValidation));
        if (this.batchSize != null) {
            aggregate.batchSize(this.batchSize.intValue());
        }
        if (this.collation != null) {
            aggregate.collation(this.collation);
        }
        if (this.maxTimeMS != null) {
            aggregate.maxTime(getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS);
        }
        if (this.hint != null) {
            aggregate.hint(this.hint);
        }
        return aggregate;
    }

    public int batchSize() {
        return this.batchSize.intValue();
    }

    public AggregationOptions batchSize(int batchSize) {
        this.batchSize = Integer.valueOf(batchSize);
        return this;
    }

    public boolean bypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public AggregationOptions bypassDocumentValidation(boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public AggregationOptions clientSession(ClientSession clientSession) {
        this.clientSession = clientSession;
        return this;
    }

    @Override // dev.morphia.internal.SessionConfigurable
    public ClientSession clientSession() {
        return this.clientSession;
    }

    public Collation collation() {
        return this.collation;
    }

    public AggregationOptions collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    public boolean getAllowDiskUse() {
        return this.allowDiskUse;
    }

    public int getBatchSize() {
        return this.batchSize.intValue();
    }

    public boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public long getMaxTime(TimeUnit unit) {
        return unit.convert(this.maxTimeMS.longValue(), TimeUnit.MILLISECONDS);
    }

    public long getMaxTimeMS() {
        return this.maxTimeMS.longValue();
    }

    @Override // dev.morphia.internal.ReadConfigurable
    public ReadConcern getReadConcern() {
        return this.readConcern;
    }

    @Override // dev.morphia.internal.ReadConfigurable
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    public Document hint() {
        return this.hint;
    }

    public AggregationOptions hint(String hint) {
        this.hint = new Document("hint", hint);
        return this;
    }

    @Override // dev.morphia.internal.ReadConfigurable, dev.morphia.internal.WriteConfigurable
    public <C> MongoCollection<C> prepare(MongoCollection<C> collection) {
        MongoCollection<C> updated = collection;
        WriteConcern writeConcern = writeConcern();
        if (writeConcern != null) {
            updated = updated.withWriteConcern(writeConcern);
        }
        ReadConcern readConcern = getReadConcern();
        if (readConcern != null) {
            updated = updated.withReadConcern(readConcern);
        }
        ReadPreference readPreference = getReadPreference();
        if (readPreference != null) {
            updated = updated.withReadPreference(readPreference);
        }
        return updated;
    }

    @Override // dev.morphia.internal.ReadConfigurable
    public AggregationOptions readConcern(ReadConcern readConcern) {
        this.readConcern = readConcern;
        return this;
    }

    @Override // dev.morphia.internal.ReadConfigurable
    public AggregationOptions readPreference(ReadPreference readPreference) {
        this.readPreference = readPreference;
        return this;
    }

    public long maxTimeMS() {
        return this.maxTimeMS.longValue();
    }

    public AggregationOptions maxTimeMS(long maxTimeMS) {
        this.maxTimeMS = Long.valueOf(maxTimeMS);
        return this;
    }

    public ReadConcern readConcern() {
        return this.readConcern;
    }

    public ReadPreference readPreference() {
        return this.readPreference;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    public AggregationOptions writeConcern(@Nullable WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
        return this;
    }

    @Override // dev.morphia.internal.WriteConfigurable
    @Nullable
    public WriteConcern writeConcern() {
        return this.writeConcern;
    }
}
