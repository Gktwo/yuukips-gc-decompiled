package com.mongodb.internal.operation;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.operation.CommandOperationHelper;
import org.bson.BsonDocument;
import org.bson.codecs.Decoder;
import org.quartz.jobs.NativeJob;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandReadOperation.class */
public class CommandReadOperation<T> implements AsyncReadOperation<T>, ReadOperation<T> {
    private final String databaseName;
    private final BsonDocument command;
    private final Decoder<T> decoder;

    public CommandReadOperation(String databaseName, BsonDocument command, Decoder<T> decoder) {
        this.databaseName = (String) Assertions.notNull("databaseName", databaseName);
        this.command = (BsonDocument) Assertions.notNull(NativeJob.PROP_COMMAND, command);
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public T execute(ReadBinding binding) {
        return (T) CommandOperationHelper.executeCommand(binding, this.databaseName, getCommandCreator(), (Decoder<Object>) this.decoder, false);
    }

    @Override // com.mongodb.internal.operation.AsyncReadOperation
    public void executeAsync(AsyncReadBinding binding, SingleResultCallback<T> callback) {
        CommandOperationHelper.executeCommandAsync(binding, this.databaseName, getCommandCreator(), (Decoder) this.decoder, false, (SingleResultCallback) callback);
    }

    private CommandOperationHelper.CommandCreator getCommandCreator() {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.CommandReadOperation.1
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                return CommandReadOperation.this.command;
            }
        };
    }
}
