package com.mongodb.internal.operation;

import com.mongodb.Function;
import com.mongodb.MongoException;
import com.mongodb.MongoExecutionTimeoutException;
import com.mongodb.MongoNodeIsRecoveringException;
import com.mongodb.MongoNotPrimaryException;
import com.mongodb.MongoSocketException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.MongoWriteConcernException;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.lang.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonValue;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommitTransactionOperation.class */
public class CommitTransactionOperation extends TransactionOperation {
    private final boolean alreadyCommitted;
    private BsonDocument recoveryToken;
    private Long maxCommitTimeMS;
    private static final List<Integer> NON_RETRYABLE_WRITE_CONCERN_ERROR_CODES = Arrays.asList(79, 100);

    public CommitTransactionOperation(WriteConcern writeConcern) {
        this(writeConcern, false);
    }

    public CommitTransactionOperation(WriteConcern writeConcern, boolean alreadyCommitted) {
        super(writeConcern);
        this.alreadyCommitted = alreadyCommitted;
    }

    public CommitTransactionOperation recoveryToken(BsonDocument recoveryToken) {
        this.recoveryToken = recoveryToken;
        return this;
    }

    public CommitTransactionOperation maxCommitTime(@Nullable Long maxCommitTime, TimeUnit timeUnit) {
        if (maxCommitTime == null) {
            this.maxCommitTimeMS = null;
        } else {
            Assertions.notNull("timeUnit", timeUnit);
            Assertions.isTrueArgument("maxCommitTime > 0", maxCommitTime.longValue() > 0);
            this.maxCommitTimeMS = Long.valueOf(TimeUnit.MILLISECONDS.convert(maxCommitTime.longValue(), timeUnit));
        }
        return this;
    }

    @Nullable
    public Long getMaxCommitTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        if (this.maxCommitTimeMS == null) {
            return null;
        }
        return Long.valueOf(timeUnit.convert(this.maxCommitTimeMS.longValue(), TimeUnit.MILLISECONDS));
    }

    @Override // com.mongodb.internal.operation.TransactionOperation, com.mongodb.internal.operation.WriteOperation
    public Void execute(WriteBinding binding) {
        try {
            return execute(binding);
        } catch (MongoException e) {
            addErrorLabels(e);
            throw e;
        }
    }

    @Override // com.mongodb.internal.operation.TransactionOperation, com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(AsyncWriteBinding binding, final SingleResultCallback<Void> callback) {
        executeAsync(binding, new SingleResultCallback<Void>() { // from class: com.mongodb.internal.operation.CommitTransactionOperation.1
            public void onResult(Void result, Throwable t) {
                if (t instanceof MongoException) {
                    CommitTransactionOperation.this.addErrorLabels((MongoException) t);
                }
                callback.onResult(result, t);
            }
        });
    }

    /* access modifiers changed from: private */
    public void addErrorLabels(MongoException e) {
        if (shouldAddUnknownTransactionCommitResultLabel(e)) {
            e.addLabel(MongoException.UNKNOWN_TRANSACTION_COMMIT_RESULT_LABEL);
        }
    }

    private static boolean shouldAddUnknownTransactionCommitResultLabel(MongoException e) {
        if ((e instanceof MongoSocketException) || (e instanceof MongoTimeoutException) || (e instanceof MongoNotPrimaryException) || (e instanceof MongoNodeIsRecoveringException) || (e instanceof MongoExecutionTimeoutException) || e.hasErrorLabel("RetryableWriteError")) {
            return true;
        }
        return (e instanceof MongoWriteConcernException) && !NON_RETRYABLE_WRITE_CONCERN_ERROR_CODES.contains(Integer.valueOf(e.getCode()));
    }

    @Override // com.mongodb.internal.operation.TransactionOperation
    protected String getCommandName() {
        return "commitTransaction";
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.internal.operation.TransactionOperation
    public CommandOperationHelper.CommandCreator getCommandCreator() {
        final CommandOperationHelper.CommandCreator creator = new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.CommitTransactionOperation.2
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                BsonValue bsonValue;
                BsonDocument command = CommitTransactionOperation.this.getCommandCreator().create(serverDescription, connectionDescription);
                if (CommitTransactionOperation.this.maxCommitTimeMS != null) {
                    if (CommitTransactionOperation.this.maxCommitTimeMS.longValue() > 2147483647L) {
                        bsonValue = new BsonInt64(CommitTransactionOperation.this.maxCommitTimeMS.longValue());
                    } else {
                        bsonValue = new BsonInt32(CommitTransactionOperation.this.maxCommitTimeMS.intValue());
                    }
                    command.append("maxTimeMS", bsonValue);
                }
                return command;
            }
        };
        if (this.alreadyCommitted) {
            return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.CommitTransactionOperation.3
                @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
                public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                    return CommitTransactionOperation.this.getRetryCommandModifier().apply(creator.create(serverDescription, connectionDescription));
                }
            };
        }
        if (this.recoveryToken != null) {
            return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.CommitTransactionOperation.4
                @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
                public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                    return creator.create(serverDescription, connectionDescription).append("recoveryToken", CommitTransactionOperation.this.recoveryToken);
                }
            };
        }
        return creator;
    }

    @Override // com.mongodb.internal.operation.TransactionOperation
    protected Function<BsonDocument, BsonDocument> getRetryCommandModifier() {
        return new Function<BsonDocument, BsonDocument>() { // from class: com.mongodb.internal.operation.CommitTransactionOperation.5
            public BsonDocument apply(BsonDocument command) {
                WriteConcern retryWriteConcern = CommitTransactionOperation.this.getWriteConcern().withW("majority");
                if (retryWriteConcern.getWTimeout(TimeUnit.MILLISECONDS) == null) {
                    retryWriteConcern = retryWriteConcern.withWTimeout(AbstractComponentTracker.LINGERING_TIMEOUT, TimeUnit.MILLISECONDS);
                }
                command.put("writeConcern", (BsonValue) retryWriteConcern.asDocument());
                if (CommitTransactionOperation.this.recoveryToken != null) {
                    command.put("recoveryToken", (BsonValue) CommitTransactionOperation.this.recoveryToken);
                }
                return command;
            }
        };
    }
}
