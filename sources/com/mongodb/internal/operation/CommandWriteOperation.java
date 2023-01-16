package com.mongodb.internal.operation;

import com.mongodb.assertions.Assertions;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import org.bson.BsonDocument;
import org.bson.codecs.Decoder;
import org.quartz.jobs.NativeJob;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandWriteOperation.class */
public class CommandWriteOperation<T> implements AsyncWriteOperation<T>, WriteOperation<T> {
    private final String databaseName;
    private final BsonDocument command;
    private final Decoder<T> decoder;

    public CommandWriteOperation(String databaseName, BsonDocument command, Decoder<T> decoder) {
        this.databaseName = (String) Assertions.notNull("databaseName", databaseName);
        this.command = (BsonDocument) Assertions.notNull(NativeJob.PROP_COMMAND, command);
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public T execute(WriteBinding binding) {
        return (T) CommandOperationHelper.executeCommand(binding, this.databaseName, this.command, this.decoder);
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(AsyncWriteBinding binding, SingleResultCallback<T> callback) {
        CommandOperationHelper.executeCommandAsync(binding, this.databaseName, this.command, this.decoder, callback);
    }
}
