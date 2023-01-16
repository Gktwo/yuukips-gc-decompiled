package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.validator.MappedFieldNameValidator;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import com.mongodb.internal.validator.UpdateFieldNameValidator;
import com.mongodb.lang.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.FieldNameValidator;
import org.bson.codecs.Decoder;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/FindAndUpdateOperation.class */
public class FindAndUpdateOperation<T> extends BaseFindAndModifyOperation<T> {
    private final BsonDocument update;
    private final List<BsonDocument> updatePipeline;
    private BsonDocument filter;
    private BsonDocument projection;
    private BsonDocument sort;
    private long maxTimeMS;
    private boolean returnOriginal;
    private boolean upsert;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private List<BsonDocument> arrayFilters;
    private Bson hint;
    private String hintString;

    public FindAndUpdateOperation(MongoNamespace namespace, Decoder<T> decoder, BsonDocument update) {
        this(namespace, WriteConcern.ACKNOWLEDGED, false, (Decoder) decoder, update);
    }

    public FindAndUpdateOperation(MongoNamespace namespace, WriteConcern writeConcern, Decoder<T> decoder, BsonDocument update) {
        this(namespace, writeConcern, false, (Decoder) decoder, update);
    }

    public FindAndUpdateOperation(MongoNamespace namespace, WriteConcern writeConcern, boolean retryWrites, Decoder<T> decoder, BsonDocument update) {
        super(namespace, writeConcern, retryWrites, decoder);
        this.returnOriginal = true;
        this.update = (BsonDocument) Assertions.notNull("update", update);
        this.updatePipeline = null;
    }

    public FindAndUpdateOperation(MongoNamespace namespace, WriteConcern writeConcern, boolean retryWrites, Decoder<T> decoder, List<BsonDocument> update) {
        super(namespace, writeConcern, retryWrites, decoder);
        this.returnOriginal = true;
        this.updatePipeline = update;
        this.update = null;
    }

    @Nullable
    public BsonDocument getUpdate() {
        return this.update;
    }

    @Nullable
    public List<BsonDocument> getUpdatePipeline() {
        return this.updatePipeline;
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public FindAndUpdateOperation<T> filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public BsonDocument getProjection() {
        return this.projection;
    }

    public FindAndUpdateOperation<T> projection(BsonDocument projection) {
        this.projection = projection;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public FindAndUpdateOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public BsonDocument getSort() {
        return this.sort;
    }

    public FindAndUpdateOperation<T> sort(BsonDocument sort) {
        this.sort = sort;
        return this;
    }

    public boolean isReturnOriginal() {
        return this.returnOriginal;
    }

    public FindAndUpdateOperation<T> returnOriginal(boolean returnOriginal) {
        this.returnOriginal = returnOriginal;
        return this;
    }

    public boolean isUpsert() {
        return this.upsert;
    }

    public FindAndUpdateOperation<T> upsert(boolean upsert) {
        this.upsert = upsert;
        return this;
    }

    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public FindAndUpdateOperation<T> bypassDocumentValidation(Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public FindAndUpdateOperation<T> collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    public FindAndUpdateOperation<T> arrayFilters(List<BsonDocument> arrayFilters) {
        this.arrayFilters = arrayFilters;
        return this;
    }

    public List<BsonDocument> getArrayFilters() {
        return this.arrayFilters;
    }

    @Nullable
    public Bson getHint() {
        return this.hint;
    }

    public FindAndUpdateOperation<T> hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    @Nullable
    public String getHintString() {
        return this.hintString;
    }

    public FindAndUpdateOperation<T> hintString(@Nullable String hint) {
        this.hintString = hint;
        return this;
    }

    @Override // com.mongodb.internal.operation.BaseFindAndModifyOperation
    protected String getDatabaseName() {
        return getNamespace().getDatabaseName();
    }

    @Override // com.mongodb.internal.operation.BaseFindAndModifyOperation
    protected FieldNameValidator getFieldNameValidator() {
        Map<String, FieldNameValidator> map = new HashMap<>();
        map.put("update", new UpdateFieldNameValidator());
        return new MappedFieldNameValidator(new NoOpFieldNameValidator(), map);
    }

    @Override // com.mongodb.internal.operation.BaseFindAndModifyOperation
    protected CommandOperationHelper.CommandCreator getCommandCreator(final SessionContext sessionContext) {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.FindAndUpdateOperation.1
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                return FindAndUpdateOperation.this.createCommand(sessionContext, serverDescription, connectionDescription);
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument createCommand(SessionContext sessionContext, ServerDescription serverDescription, ConnectionDescription connectionDescription) {
        OperationHelper.validateCollation(connectionDescription, this.collation);
        BsonDocument commandDocument = new BsonDocument("findAndModify", new BsonString(getNamespace().getCollectionName()));
        DocumentHelper.putIfNotNull(commandDocument, "query", getFilter());
        DocumentHelper.putIfNotNull(commandDocument, "fields", getProjection());
        DocumentHelper.putIfNotNull(commandDocument, "sort", getSort());
        commandDocument.put("new", (BsonValue) new BsonBoolean(!isReturnOriginal()));
        DocumentHelper.putIfTrue(commandDocument, "upsert", isUpsert());
        DocumentHelper.putIfNotZero(commandDocument, "maxTimeMS", getMaxTime(TimeUnit.MILLISECONDS));
        if (getUpdatePipeline() != null) {
            commandDocument.put("update", (BsonValue) new BsonArray(getUpdatePipeline()));
        } else {
            DocumentHelper.putIfNotNull(commandDocument, "update", getUpdate());
        }
        if (this.bypassDocumentValidation != null && ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connectionDescription)) {
            commandDocument.put("bypassDocumentValidation", (BsonValue) BsonBoolean.valueOf(this.bypassDocumentValidation.booleanValue()));
        }
        addWriteConcernToCommand(connectionDescription, commandDocument, sessionContext);
        if (this.collation != null) {
            commandDocument.put("collation", (BsonValue) this.collation.asDocument());
        }
        if (this.arrayFilters != null) {
            commandDocument.put("arrayFilters", (BsonValue) new BsonArray(this.arrayFilters));
        }
        if (!(this.hint == null && this.hintString == null)) {
            OperationHelper.validateHint(connectionDescription, getWriteConcern());
            if (this.hint != null) {
                commandDocument.put("hint", (BsonValue) this.hint.toBsonDocument(BsonDocument.class, null));
            } else {
                commandDocument.put("hint", (BsonValue) new BsonString(this.hintString));
            }
        }
        addTxnNumberToCommand(serverDescription, connectionDescription, commandDocument, sessionContext);
        return commandDocument;
    }
}
