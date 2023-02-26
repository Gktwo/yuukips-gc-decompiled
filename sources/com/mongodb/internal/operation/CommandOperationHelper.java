package com.mongodb.internal.operation;

import com.mongodb.Function;
import com.mongodb.MongoClientException;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoNodeIsRecoveringException;
import com.mongodb.MongoNotPrimaryException;
import com.mongodb.MongoSocketException;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.operation.OperationHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import com.mongodb.lang.Nullable;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.FieldNameValidator;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Decoder;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper.class */
public final class CommandOperationHelper {
    private static final List<Integer> RETRYABLE_ERROR_CODES = Arrays.asList(6, 7, 89, 91, 189, Integer.valueOf((int) PacketOpcodes.SceneEntityMoveRsp), Integer.valueOf((int) RetcodeOuterClass.Retcode.RET_REUNION_FINISHED_VALUE), 13436, 13435, 11602, 11600, 10107);
    static final String RETRYABLE_WRITE_ERROR_LABEL = "RetryableWriteError";

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$CommandCreator.class */
    public interface CommandCreator {
        BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$CommandReadTransformer.class */
    public interface CommandReadTransformer<T, R> {
        R apply(T t, ConnectionSource connectionSource, Connection connection);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$CommandReadTransformerAsync.class */
    public interface CommandReadTransformerAsync<T, R> {
        R apply(T t, AsyncConnectionSource asyncConnectionSource, AsyncConnection asyncConnection);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$CommandWriteTransformer.class */
    public interface CommandWriteTransformer<T, R> {
        R apply(T t, Connection connection);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$CommandWriteTransformerAsync.class */
    public interface CommandWriteTransformerAsync<T, R> {
        R apply(T t, AsyncConnection asyncConnection);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$IdentityReadTransformer.class */
    public static class IdentityReadTransformer<T> implements CommandReadTransformer<T, T> {
        IdentityReadTransformer() {
        }

        @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandReadTransformer
        public T apply(T t, ConnectionSource source, Connection connection) {
            return t;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$IdentityWriteTransformer.class */
    public static class IdentityWriteTransformer<T> implements CommandWriteTransformer<T, T> {
        IdentityWriteTransformer() {
        }

        @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandWriteTransformer
        public T apply(T t, Connection connection) {
            return t;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$IdentityWriteTransformerAsync.class */
    public static class IdentityWriteTransformerAsync<T> implements CommandWriteTransformerAsync<T, T> {
        IdentityWriteTransformerAsync() {
        }

        @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandWriteTransformerAsync
        public T apply(T t, AsyncConnection connection) {
            return t;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$IdentityTransformerAsync.class */
    public static class IdentityTransformerAsync<T> implements CommandReadTransformerAsync<T, T> {
        IdentityTransformerAsync() {
        }

        @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandReadTransformerAsync
        public T apply(T t, AsyncConnectionSource source, AsyncConnection connection) {
            return t;
        }
    }

    /* access modifiers changed from: package-private */
    public static CommandWriteTransformer<BsonDocument, Void> writeConcernErrorTransformer() {
        return new CommandWriteTransformer<BsonDocument, Void>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.1
            public Void apply(BsonDocument result, Connection connection) {
                WriteConcernHelper.throwOnWriteConcernError(result, connection.getDescription().getServerAddress(), connection.getDescription().getMaxWireVersion());
                return null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static CommandWriteTransformerAsync<BsonDocument, Void> writeConcernErrorWriteTransformer() {
        return new CommandWriteTransformerAsync<BsonDocument, Void>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.2
            public Void apply(BsonDocument result, AsyncConnection connection) {
                WriteConcernHelper.throwOnWriteConcernError(result, connection.getDescription().getServerAddress(), connection.getDescription().getMaxWireVersion());
                return null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static CommandWriteTransformerAsync<BsonDocument, Void> writeConcernErrorTransformerAsync() {
        return new CommandWriteTransformerAsync<BsonDocument, Void>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.3
            public Void apply(BsonDocument result, AsyncConnection connection) {
                WriteConcernHelper.throwOnWriteConcernError(result, connection.getDescription().getServerAddress(), connection.getDescription().getMaxWireVersion());
                return null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static Function<BsonDocument, BsonDocument> noOpRetryCommandModifier() {
        return new Function<BsonDocument, BsonDocument>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.4
            public BsonDocument apply(BsonDocument command) {
                return command;
            }
        };
    }

    static BsonDocument executeCommand(ReadBinding binding, String database, CommandCreator commandCreator, boolean retryReads) {
        return (BsonDocument) executeCommand(binding, database, commandCreator, new BsonDocumentCodec(), retryReads);
    }

    static <T> T executeCommand(ReadBinding binding, String database, CommandCreator commandCreator, CommandReadTransformer<BsonDocument, T> transformer, boolean retryReads) {
        return (T) executeCommand(binding, database, commandCreator, (Decoder) new BsonDocumentCodec(), (CommandReadTransformer<D, Object>) transformer, retryReads);
    }

    /* access modifiers changed from: package-private */
    public static <T> T executeCommand(ReadBinding binding, String database, CommandCreator commandCreator, Decoder<T> decoder, boolean retryReads) {
        return (T) executeCommand(binding, database, commandCreator, decoder, new IdentityReadTransformer(), retryReads);
    }

    /* access modifiers changed from: package-private */
    public static <D, T> T executeCommand(final ReadBinding binding, final String database, final CommandCreator commandCreator, final Decoder<D> decoder, final CommandReadTransformer<D, T> transformer, final boolean retryReads) {
        return (T) OperationHelper.withReadConnectionSource(binding, new OperationHelper.CallableWithSource<T>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.5
            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithSource
            public T call(ConnectionSource source) {
                return CommandOperationHelper.executeCommandWithConnection(ReadBinding.this, source, database, commandCreator, decoder, transformer, retryReads, source.getConnection());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static <D, T> T executeCommandWithConnection(final ReadBinding binding, ConnectionSource source, final String database, final CommandCreator commandCreator, final Decoder<D> decoder, final CommandReadTransformer<D, T> transformer, boolean retryReads, Connection connection) {
        BsonDocument command = null;
        try {
            try {
                command = commandCreator.create(source.getServerDescription(), connection.getDescription());
                T t = (T) executeCommand(database, command, decoder, source, connection, binding.getReadPreference(), transformer, binding.getSessionContext());
                connection.release();
                return t;
            } catch (MongoException e) {
                if (!shouldAttemptToRetryRead(retryReads, e)) {
                    if (retryReads) {
                        logUnableToRetry(command.getFirstKey(), e);
                    }
                    throw e;
                }
                connection.release();
                return (T) OperationHelper.withReleasableConnection(binding, e, new OperationHelper.CallableWithConnectionAndSource<T>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.6
                    /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnectionAndSource
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public T call(com.mongodb.internal.binding.ConnectionSource r10, com.mongodb.internal.connection.Connection r11) {
                        /*
                            r9 = this;
                            r0 = r10
                            com.mongodb.connection.ServerDescription r0 = r0.getServerDescription()     // Catch: all -> 0x0070
                            r1 = r11
                            com.mongodb.connection.ConnectionDescription r1 = r1.getDescription()     // Catch: all -> 0x0070
                            r2 = r9
                            com.mongodb.internal.binding.ReadBinding r2 = com.mongodb.internal.binding.ReadBinding.this     // Catch: all -> 0x0070
                            com.mongodb.internal.session.SessionContext r2 = r2.getSessionContext()     // Catch: all -> 0x0070
                            boolean r0 = com.mongodb.internal.operation.OperationHelper.canRetryRead(r0, r1, r2)     // Catch: all -> 0x0070
                            if (r0 != 0) goto L_0x0020
                            r0 = r9
                            com.mongodb.MongoException r0 = r21     // Catch: all -> 0x0070
                            throw r0     // Catch: all -> 0x0070
                        L_0x0020:
                            r0 = r9
                            com.mongodb.internal.operation.CommandOperationHelper$CommandCreator r0 = r14     // Catch: all -> 0x0070
                            r1 = r10
                            com.mongodb.connection.ServerDescription r1 = r1.getServerDescription()     // Catch: all -> 0x0070
                            r2 = r11
                            com.mongodb.connection.ConnectionDescription r2 = r2.getDescription()     // Catch: all -> 0x0070
                            org.bson.BsonDocument r0 = r0.create(r1, r2)     // Catch: all -> 0x0070
                            r12 = r0
                            r0 = r12
                            java.lang.String r0 = r0.getFirstKey()     // Catch: all -> 0x0070
                            r1 = r9
                            com.mongodb.MongoException r1 = r21     // Catch: all -> 0x0070
                            com.mongodb.internal.operation.CommandOperationHelper.logRetryExecute(r0, r1)     // Catch: all -> 0x0070
                            r0 = r9
                            java.lang.String r0 = r13     // Catch: all -> 0x0070
                            r1 = r12
                            r2 = r9
                            org.bson.codecs.Decoder r2 = r15     // Catch: all -> 0x0070
                            r3 = r10
                            r4 = r11
                            r5 = r9
                            com.mongodb.internal.binding.ReadBinding r5 = com.mongodb.internal.binding.ReadBinding.this     // Catch: all -> 0x0070
                            com.mongodb.ReadPreference r5 = r5.getReadPreference()     // Catch: all -> 0x0070
                            r6 = r9
                            com.mongodb.internal.operation.CommandOperationHelper$CommandReadTransformer r6 = r16     // Catch: all -> 0x0070
                            r7 = r9
                            com.mongodb.internal.binding.ReadBinding r7 = com.mongodb.internal.binding.ReadBinding.this     // Catch: all -> 0x0070
                            com.mongodb.internal.session.SessionContext r7 = r7.getSessionContext()     // Catch: all -> 0x0070
                            java.lang.Object r0 = com.mongodb.internal.operation.CommandOperationHelper.access$000(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: all -> 0x0070
                            r13 = r0
                            r0 = r11
                            r0.release()
                            r0 = r13
                            return r0
                        L_0x0070:
                            r14 = move-exception
                            r0 = r11
                            r0.release()
                            r0 = r14
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.operation.CommandOperationHelper.C11446.call(com.mongodb.internal.binding.ConnectionSource, com.mongodb.internal.connection.Connection):java.lang.Object");
                    }
                });
            }
        } catch (Throwable th) {
            connection.release();
            throw th;
        }
    }

    static BsonDocument executeCommand(WriteBinding binding, String database, BsonDocument command) {
        return (BsonDocument) executeCommand(binding, database, command, new IdentityWriteTransformer());
    }

    /* access modifiers changed from: package-private */
    public static <T> T executeCommand(WriteBinding binding, String database, BsonDocument command, Decoder<T> decoder) {
        return (T) executeCommand(binding, database, command, decoder, new IdentityWriteTransformer());
    }

    /* access modifiers changed from: package-private */
    public static <T> T executeCommand(WriteBinding binding, String database, BsonDocument command, CommandWriteTransformer<BsonDocument, T> transformer) {
        return (T) executeCommand(binding, database, command, (Decoder) new BsonDocumentCodec(), (CommandWriteTransformer<D, Object>) transformer);
    }

    static <D, T> T executeCommand(WriteBinding binding, String database, BsonDocument command, Decoder<D> decoder, CommandWriteTransformer<D, T> transformer) {
        return (T) executeCommand(binding, database, command, new NoOpFieldNameValidator(), decoder, transformer);
    }

    /* access modifiers changed from: package-private */
    public static <T> T executeCommand(WriteBinding binding, String database, BsonDocument command, Connection connection, CommandWriteTransformer<BsonDocument, T> transformer) {
        return (T) executeCommand(binding, database, command, new BsonDocumentCodec(), connection, transformer);
    }

    static <T> T executeCommand(WriteBinding binding, String database, BsonDocument command, Decoder<BsonDocument> decoder, Connection connection, CommandWriteTransformer<BsonDocument, T> transformer) {
        Assertions.notNull("binding", binding);
        return (T) executeWriteCommand(database, command, decoder, connection, ReadPreference.primary(), transformer, binding.getSessionContext());
    }

    static <T> T executeCommand(WriteBinding binding, String database, BsonDocument command, FieldNameValidator fieldNameValidator, Decoder<BsonDocument> decoder, Connection connection, CommandWriteTransformer<BsonDocument, T> transformer) {
        Assertions.notNull("binding", binding);
        return (T) executeWriteCommand(database, command, fieldNameValidator, decoder, connection, ReadPreference.primary(), transformer, binding.getSessionContext());
    }

    static <D, T> T executeCommand(WriteBinding binding, final String database, final BsonDocument command, final FieldNameValidator fieldNameValidator, final Decoder<D> decoder, final CommandWriteTransformer<D, T> transformer) {
        return (T) OperationHelper.withReleasableConnection(binding, new OperationHelper.CallableWithConnectionAndSource<T>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.7
            /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnectionAndSource
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public T call(com.mongodb.internal.binding.ConnectionSource r10, com.mongodb.internal.connection.Connection r11) {
                /*
                    r9 = this;
                    r0 = r9
                    com.mongodb.internal.operation.CommandOperationHelper$CommandWriteTransformer r0 = com.mongodb.internal.operation.CommandOperationHelper.CommandWriteTransformer.this     // Catch: all -> 0x002b
                    r1 = r9
                    java.lang.String r1 = r10     // Catch: all -> 0x002b
                    r2 = r9
                    org.bson.BsonDocument r2 = r11     // Catch: all -> 0x002b
                    r3 = r9
                    org.bson.FieldNameValidator r3 = r12     // Catch: all -> 0x002b
                    r4 = r9
                    org.bson.codecs.Decoder r4 = r13     // Catch: all -> 0x002b
                    r5 = r10
                    r6 = r11
                    com.mongodb.ReadPreference r7 = com.mongodb.ReadPreference.primary()     // Catch: all -> 0x002b
                    java.lang.Object r1 = com.mongodb.internal.operation.CommandOperationHelper.access$100(r1, r2, r3, r4, r5, r6, r7)     // Catch: all -> 0x002b
                    r2 = r11
                    java.lang.Object r0 = r0.apply(r1, r2)     // Catch: all -> 0x002b
                    r12 = r0
                    r0 = r11
                    r0.release()
                    r0 = r12
                    return r0
                L_0x002b:
                    r13 = move-exception
                    r0 = r11
                    r0.release()
                    r0 = r13
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.operation.CommandOperationHelper.C11457.call(com.mongodb.internal.binding.ConnectionSource, com.mongodb.internal.connection.Connection):java.lang.Object");
            }
        });
    }

    static BsonDocument executeCommand(WriteBinding binding, String database, BsonDocument command, Connection connection) {
        Assertions.notNull("binding", binding);
        return (BsonDocument) executeWriteCommand(database, command, new BsonDocumentCodec(), connection, ReadPreference.primary(), binding.getSessionContext());
    }

    /* access modifiers changed from: private */
    public static <T> T executeCommand(String database, BsonDocument command, FieldNameValidator fieldNameValidator, Decoder<T> decoder, ConnectionSource source, Connection connection, ReadPreference readPreference) {
        return (T) executeCommand(database, command, fieldNameValidator, decoder, source, connection, readPreference, new IdentityReadTransformer(), source.getSessionContext());
    }

    /* access modifiers changed from: private */
    public static <D, T> T executeCommand(String database, BsonDocument command, Decoder<D> decoder, ConnectionSource source, Connection connection, ReadPreference readPreference, CommandReadTransformer<D, T> transformer, SessionContext sessionContext) {
        return (T) executeCommand(database, command, new NoOpFieldNameValidator(), decoder, source, connection, readPreference, transformer, sessionContext);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r16v0, resolved type: com.mongodb.internal.operation.CommandOperationHelper$CommandReadTransformer<D, T> */
    /* JADX WARN: Multi-variable type inference failed */
    private static <D, T> T executeCommand(String database, BsonDocument command, FieldNameValidator fieldNameValidator, Decoder<D> decoder, ConnectionSource source, Connection connection, ReadPreference readPreference, CommandReadTransformer<D, T> transformer, SessionContext sessionContext) {
        return (T) transformer.apply(connection.command(database, command, fieldNameValidator, readPreference, decoder, sessionContext), source, connection);
    }

    private static <T> T executeWriteCommand(String database, BsonDocument command, Decoder<T> decoder, Connection connection, ReadPreference readPreference, SessionContext sessionContext) {
        return (T) executeWriteCommand(database, command, new NoOpFieldNameValidator(), decoder, connection, readPreference, new IdentityWriteTransformer(), sessionContext);
    }

    private static <D, T> T executeWriteCommand(String database, BsonDocument command, Decoder<D> decoder, Connection connection, ReadPreference readPreference, CommandWriteTransformer<D, T> transformer, SessionContext sessionContext) {
        return (T) executeWriteCommand(database, command, new NoOpFieldNameValidator(), decoder, connection, readPreference, transformer, sessionContext);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: com.mongodb.internal.operation.CommandOperationHelper$CommandWriteTransformer<D, T> */
    /* JADX WARN: Multi-variable type inference failed */
    private static <D, T> T executeWriteCommand(String database, BsonDocument command, FieldNameValidator fieldNameValidator, Decoder<D> decoder, Connection connection, ReadPreference readPreference, CommandWriteTransformer<D, T> transformer, SessionContext sessionContext) {
        return (T) transformer.apply(connection.command(database, command, fieldNameValidator, readPreference, decoder, sessionContext), connection);
    }

    static void executeCommandAsync(AsyncReadBinding binding, String database, CommandCreator commandCreator, boolean retryReads, SingleResultCallback<BsonDocument> callback) {
        executeCommandAsync(binding, database, commandCreator, new BsonDocumentCodec(), retryReads, callback);
    }

    /* access modifiers changed from: package-private */
    public static <T> void executeCommandAsync(AsyncReadBinding binding, String database, CommandCreator commandCreator, Decoder<T> decoder, boolean retryReads, SingleResultCallback<T> callback) {
        executeCommandAsync(binding, database, commandCreator, decoder, new IdentityTransformerAsync(), retryReads, callback);
    }

    static <T> void executeCommandAsync(AsyncReadBinding binding, String database, CommandCreator commandCreator, CommandReadTransformerAsync<BsonDocument, T> transformer, boolean retryReads, SingleResultCallback<T> callback) {
        executeCommandAsync(binding, database, commandCreator, new BsonDocumentCodec(), transformer, retryReads, callback);
    }

    /* access modifiers changed from: package-private */
    public static <D, T> void executeCommandAsync(final AsyncReadBinding binding, final String database, final CommandCreator commandCreator, final Decoder<D> decoder, final CommandReadTransformerAsync<D, T> transformer, final boolean retryReads, SingleResultCallback<T> originalCallback) {
        final SingleResultCallback<T> errorHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(originalCallback, OperationHelper.LOGGER);
        OperationHelper.withAsyncReadConnection(binding, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.CommandOperationHelper.8
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
            public void call(AsyncConnectionSource source, AsyncConnection connection, Throwable t) {
                if (t != null) {
                    OperationHelper.releasingCallback(SingleResultCallback.this, source, connection).onResult(null, t);
                } else {
                    CommandOperationHelper.executeCommandAsyncWithConnection(binding, source, database, commandCreator, decoder, transformer, retryReads, connection, SingleResultCallback.this);
                }
            }
        });
    }

    static <D, T> void executeCommandAsync(final AsyncReadBinding binding, final String database, final CommandCreator commandCreator, final Decoder<D> decoder, final CommandReadTransformerAsync<D, T> transformer, final boolean retryReads, final AsyncConnection connection, SingleResultCallback<T> originalCallback) {
        final SingleResultCallback<T> errorHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(originalCallback, OperationHelper.LOGGER);
        binding.getReadConnectionSource(new SingleResultCallback<AsyncConnectionSource>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.9
            public void onResult(AsyncConnectionSource source, Throwable t) {
                CommandOperationHelper.executeCommandAsyncWithConnection(AsyncReadBinding.this, source, database, commandCreator, decoder, transformer, retryReads, connection, errorHandlingCallback);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static <D, T> void executeCommandAsyncWithConnection(AsyncReadBinding binding, AsyncConnectionSource source, String database, CommandCreator commandCreator, Decoder<D> decoder, CommandReadTransformerAsync<D, T> transformer, boolean retryReads, AsyncConnection connection, SingleResultCallback<T> callback) {
        try {
            BsonDocument command = commandCreator.create(source.getServerDescription(), connection.getDescription());
            connection.commandAsync(database, command, new NoOpFieldNameValidator(), binding.getReadPreference(), decoder, binding.getSessionContext(), createCommandCallback(binding, source, connection, database, binding.getReadPreference(), command, commandCreator, new NoOpFieldNameValidator(), decoder, transformer, retryReads, callback));
        } catch (IllegalArgumentException e) {
            connection.release();
            callback.onResult(null, e);
        }
    }

    private static <T, R> SingleResultCallback<T> createCommandCallback(final AsyncReadBinding binding, final AsyncConnectionSource oldSource, final AsyncConnection oldConnection, final String database, final ReadPreference readPreference, final BsonDocument originalCommand, final CommandCreator commandCreator, final FieldNameValidator fieldNameValidator, final Decoder<T> commandResultDecoder, final CommandReadTransformerAsync<T, R> transformer, final boolean retryReads, final SingleResultCallback<R> callback) {
        return new SingleResultCallback<T>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.10
            @Override // com.mongodb.internal.async.SingleResultCallback
            public void onResult(T result, Throwable originalError) {
                SingleResultCallback releasingCallback = OperationHelper.releasingCallback(SingleResultCallback.this, oldSource, oldConnection);
                if (originalError != null) {
                    checkRetryableException(originalError, releasingCallback);
                    return;
                }
                try {
                    releasingCallback.onResult(transformer.apply(result, oldSource, oldConnection), null);
                } catch (Throwable transformError) {
                    checkRetryableException(transformError, releasingCallback);
                }
            }

            private void checkRetryableException(Throwable originalError, SingleResultCallback<R> callback2) {
                if (!CommandOperationHelper.shouldAttemptToRetryRead(retryReads, originalError)) {
                    if (retryReads) {
                        CommandOperationHelper.logUnableToRetry(originalCommand.getFirstKey(), originalError);
                    }
                    callback2.onResult(null, originalError);
                    return;
                }
                oldSource.release();
                oldConnection.release();
                retryableCommand(originalError);
            }

            private void retryableCommand(final Throwable originalError) {
                OperationHelper.withAsyncReadConnection(binding, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.CommandOperationHelper.10.1
                    @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
                    public void call(AsyncConnectionSource source, AsyncConnection connection, Throwable t) {
                        if (t != null) {
                            SingleResultCallback.this.onResult(null, originalError);
                        } else if (!OperationHelper.canRetryRead(source.getServerDescription(), connection.getDescription(), binding.getSessionContext())) {
                            OperationHelper.releasingCallback(SingleResultCallback.this, source, connection).onResult(null, originalError);
                        } else {
                            BsonDocument retryCommand = commandCreator.create(source.getServerDescription(), connection.getDescription());
                            CommandOperationHelper.logRetryExecute(retryCommand.getFirstKey(), originalError);
                            connection.commandAsync(database, retryCommand, fieldNameValidator, readPreference, commandResultDecoder, binding.getSessionContext(), new TransformingReadResultCallback(transformer, source, connection, OperationHelper.releasingCallback(SingleResultCallback.this, source, connection)));
                        }
                    }
                });
            }
        };
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$TransformingReadResultCallback.class */
    static class TransformingReadResultCallback<T, R> implements SingleResultCallback<T> {
        private final CommandReadTransformerAsync<T, R> transformer;
        private final AsyncConnectionSource source;
        private final AsyncConnection connection;
        private final SingleResultCallback<R> callback;

        TransformingReadResultCallback(CommandReadTransformerAsync<T, R> transformer, AsyncConnectionSource source, AsyncConnection connection, SingleResultCallback<R> callback) {
            this.transformer = transformer;
            this.source = source;
            this.connection = connection;
            this.callback = callback;
        }

        @Override // com.mongodb.internal.async.SingleResultCallback
        public void onResult(T result, Throwable t) {
            if (t != null) {
                this.callback.onResult(null, t);
                return;
            }
            try {
                this.callback.onResult(this.transformer.apply(result, this.source, this.connection), null);
            } catch (Throwable transformError) {
                this.callback.onResult(null, transformError);
            }
        }
    }

    static void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, SingleResultCallback<BsonDocument> callback) {
        executeCommandAsync(binding, database, command, new BsonDocumentCodec(), callback);
    }

    /* access modifiers changed from: package-private */
    public static <T> void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, Decoder<T> decoder, SingleResultCallback<T> callback) {
        executeCommandAsync(binding, database, command, decoder, new IdentityWriteTransformerAsync(), callback);
    }

    static <T> void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, CommandWriteTransformerAsync<BsonDocument, T> transformer, SingleResultCallback<T> callback) {
        executeCommandAsync(binding, database, command, new BsonDocumentCodec(), transformer, callback);
    }

    static <D, T> void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, Decoder<D> decoder, CommandWriteTransformerAsync<D, T> transformer, SingleResultCallback<T> callback) {
        executeCommandAsync(binding, database, command, new NoOpFieldNameValidator(), decoder, transformer, callback);
    }

    static <T> void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, Decoder<BsonDocument> decoder, AsyncConnection connection, CommandWriteTransformerAsync<BsonDocument, T> transformer, SingleResultCallback<T> callback) {
        Assertions.notNull("binding", binding);
        executeCommandAsync(database, command, decoder, connection, ReadPreference.primary(), transformer, binding.getSessionContext(), callback);
    }

    static <T> void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, FieldNameValidator fieldNameValidator, Decoder<BsonDocument> decoder, AsyncConnection connection, CommandWriteTransformerAsync<BsonDocument, T> transformer, SingleResultCallback<T> callback) {
        Assertions.notNull("binding", binding);
        executeCommandAsync(database, command, fieldNameValidator, decoder, connection, ReadPreference.primary(), transformer, binding.getSessionContext(), callback);
    }

    static <D, T> void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, FieldNameValidator fieldNameValidator, Decoder<D> decoder, CommandWriteTransformerAsync<D, T> transformer, SingleResultCallback<T> callback) {
        binding.getWriteConnectionSource(new CommandProtocolExecutingCallback(database, command, fieldNameValidator, decoder, ReadPreference.primary(), transformer, binding.getSessionContext(), ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER)));
    }

    static void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, AsyncConnection connection, SingleResultCallback<BsonDocument> callback) {
        executeCommandAsync(binding, database, command, connection, new IdentityWriteTransformerAsync(), callback);
    }

    /* access modifiers changed from: package-private */
    public static <T> void executeCommandAsync(AsyncWriteBinding binding, String database, BsonDocument command, AsyncConnection connection, CommandWriteTransformerAsync<BsonDocument, T> transformer, SingleResultCallback<T> callback) {
        Assertions.notNull("binding", binding);
        executeCommandAsync(database, command, new BsonDocumentCodec(), connection, ReadPreference.primary(), transformer, binding.getSessionContext(), callback);
    }

    private static <D, T> void executeCommandAsync(String database, BsonDocument command, Decoder<D> decoder, final AsyncConnection connection, ReadPreference readPreference, final CommandWriteTransformerAsync<D, T> transformer, SessionContext sessionContext, final SingleResultCallback<T> callback) {
        connection.commandAsync(database, command, new NoOpFieldNameValidator(), readPreference, decoder, sessionContext, new SingleResultCallback<D>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.11
            @Override // com.mongodb.internal.async.SingleResultCallback
            public void onResult(D result, Throwable t) {
                if (t != null) {
                    SingleResultCallback.this.onResult(null, t);
                    return;
                }
                try {
                    SingleResultCallback.this.onResult(transformer.apply(result, connection), null);
                } catch (Exception e) {
                    SingleResultCallback.this.onResult(null, e);
                }
            }
        });
    }

    private static <D, T> void executeCommandAsync(String database, BsonDocument command, FieldNameValidator fieldNameValidator, Decoder<D> decoder, final AsyncConnection connection, ReadPreference readPreference, final CommandWriteTransformerAsync<D, T> transformer, SessionContext sessionContext, final SingleResultCallback<T> callback) {
        connection.commandAsync(database, command, fieldNameValidator, readPreference, decoder, sessionContext, true, null, null, new SingleResultCallback<D>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.12
            @Override // com.mongodb.internal.async.SingleResultCallback
            public void onResult(D result, Throwable t) {
                if (t != null) {
                    SingleResultCallback.this.onResult(null, t);
                    return;
                }
                try {
                    SingleResultCallback.this.onResult(transformer.apply(result, connection), null);
                } catch (Exception e) {
                    SingleResultCallback.this.onResult(null, e);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static <T, R> R executeRetryableCommand(WriteBinding binding, String database, ReadPreference readPreference, FieldNameValidator fieldNameValidator, Decoder<T> commandResultDecoder, CommandCreator commandCreator, CommandWriteTransformer<T, R> transformer) {
        return (R) executeRetryableCommand(binding, database, readPreference, fieldNameValidator, commandResultDecoder, commandCreator, transformer, noOpRetryCommandModifier());
    }

    /* access modifiers changed from: package-private */
    public static <T, R> R executeRetryableCommand(final WriteBinding binding, final String database, final ReadPreference readPreference, final FieldNameValidator fieldNameValidator, final Decoder<T> commandResultDecoder, final CommandCreator commandCreator, final CommandWriteTransformer<T, R> transformer, final Function<BsonDocument, BsonDocument> retryCommandModifier) {
        return (R) OperationHelper.withReleasableConnection(binding, new OperationHelper.CallableWithConnectionAndSource<R>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.13
            /* JADX WARN: Type inference failed for: r0v15, types: [R, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r0v30, types: [R, java.lang.Object] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnectionAndSource
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public R call(com.mongodb.internal.binding.ConnectionSource r10, com.mongodb.internal.connection.Connection r11) {
                /*
                    r9 = this;
                    r0 = 0
                    r12 = r0
                    r0 = r9
                    com.mongodb.internal.operation.CommandOperationHelper$CommandCreator r0 = com.mongodb.internal.operation.CommandOperationHelper.CommandCreator.this     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r1 = r10
                    com.mongodb.connection.ServerDescription r1 = r1.getServerDescription()     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r2 = r11
                    com.mongodb.connection.ConnectionDescription r2 = r2.getDescription()     // Catch: MongoException -> 0x004d, all -> 0x0084
                    org.bson.BsonDocument r0 = r0.create(r1, r2)     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r12 = r0
                    r0 = r9
                    com.mongodb.internal.operation.CommandOperationHelper$CommandWriteTransformer r0 = r18     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r1 = r11
                    r2 = r9
                    java.lang.String r2 = r13     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r3 = r12
                    r4 = r9
                    org.bson.FieldNameValidator r4 = r15     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r5 = r9
                    com.mongodb.ReadPreference r5 = r14     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r6 = r9
                    org.bson.codecs.Decoder r6 = r16     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r7 = r9
                    com.mongodb.internal.binding.WriteBinding r7 = r12     // Catch: MongoException -> 0x004d, all -> 0x0084
                    com.mongodb.internal.session.SessionContext r7 = r7.getSessionContext()     // Catch: MongoException -> 0x004d, all -> 0x0084
                    java.lang.Object r1 = r1.command(r2, r3, r4, r5, r6, r7)     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r2 = r11
                    java.lang.Object r0 = r0.apply(r1, r2)     // Catch: MongoException -> 0x004d, all -> 0x0084
                    r14 = r0
                    r0 = r11
                    r0.release()
                    r0 = r14
                    return r0
                L_0x004d:
                    r14 = move-exception
                    r0 = r14
                    r13 = r0
                    r0 = r12
                    r1 = r14
                    r2 = r11
                    com.mongodb.connection.ConnectionDescription r2 = r2.getDescription()     // Catch: all -> 0x0084
                    int r2 = r2.getMaxWireVersion()     // Catch: all -> 0x0084
                    boolean r0 = com.mongodb.internal.operation.CommandOperationHelper.access$300(r0, r1, r2)     // Catch: all -> 0x0084
                    if (r0 != 0) goto L_0x007b
                    r0 = r12
                    boolean r0 = com.mongodb.internal.operation.CommandOperationHelper.access$400(r0)     // Catch: all -> 0x0084
                    if (r0 == 0) goto L_0x0075
                    r0 = r12
                    java.lang.String r0 = r0.getFirstKey()     // Catch: all -> 0x0084
                    r1 = r14
                    com.mongodb.internal.operation.CommandOperationHelper.logUnableToRetry(r0, r1)     // Catch: all -> 0x0084
                L_0x0075:
                    r0 = r13
                    com.mongodb.MongoException r0 = com.mongodb.internal.operation.CommandOperationHelper.transformWriteException(r0)     // Catch: all -> 0x0084
                    throw r0     // Catch: all -> 0x0084
                L_0x007b:
                    r0 = r11
                    r0.release()
                    goto L_0x008f
                L_0x0084:
                    r15 = move-exception
                    r0 = r11
                    r0.release()
                    r0 = r15
                    throw r0
                L_0x008f:
                    r0 = r9
                    com.mongodb.internal.binding.WriteBinding r0 = r12
                    com.mongodb.internal.session.SessionContext r0 = r0.getSessionContext()
                    boolean r0 = r0.hasActiveTransaction()
                    if (r0 == 0) goto L_0x00ae
                    r0 = r9
                    com.mongodb.internal.binding.WriteBinding r0 = r12
                    com.mongodb.internal.session.SessionContext r0 = r0.getSessionContext()
                    r0.unpinServerAddress()
                L_0x00ae:
                    r0 = r12
                    r14 = r0
                    r0 = r13
                    r15 = r0
                    r0 = r9
                    com.mongodb.internal.binding.WriteBinding r0 = r12
                    r1 = r15
                    com.mongodb.internal.operation.CommandOperationHelper$13$1 r2 = new com.mongodb.internal.operation.CommandOperationHelper$13$1
                    r3 = r2
                    r4 = r9
                    r5 = r15
                    r6 = r14
                    r3.<init>(r5, r6)
                    java.lang.Object r0 = com.mongodb.internal.operation.OperationHelper.withReleasableConnection(r0, r1, r2)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.operation.CommandOperationHelper.C113413.call(com.mongodb.internal.binding.ConnectionSource, com.mongodb.internal.connection.Connection):java.lang.Object");
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static <T, R> void executeRetryableCommand(AsyncWriteBinding binding, String database, ReadPreference readPreference, FieldNameValidator fieldNameValidator, Decoder<T> commandResultDecoder, CommandCreator commandCreator, CommandWriteTransformerAsync<T, R> transformer, SingleResultCallback<R> originalCallback) {
        executeRetryableCommand(binding, database, readPreference, fieldNameValidator, commandResultDecoder, commandCreator, transformer, noOpRetryCommandModifier(), originalCallback);
    }

    /* access modifiers changed from: package-private */
    public static <T, R> void executeRetryableCommand(final AsyncWriteBinding binding, final String database, final ReadPreference readPreference, final FieldNameValidator fieldNameValidator, final Decoder<T> commandResultDecoder, final CommandCreator commandCreator, final CommandWriteTransformerAsync<T, R> transformer, final Function<BsonDocument, BsonDocument> retryCommandModifier, SingleResultCallback<R> originalCallback) {
        final SingleResultCallback<R> errorHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(originalCallback, OperationHelper.LOGGER);
        binding.getWriteConnectionSource(new SingleResultCallback<AsyncConnectionSource>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.14
            public void onResult(final AsyncConnectionSource source, Throwable t) {
                if (t != null) {
                    SingleResultCallback.this.onResult(null, t);
                } else {
                    source.getConnection(new SingleResultCallback<AsyncConnection>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.14.1
                        public void onResult(AsyncConnection connection, Throwable t2) {
                            if (t2 != null) {
                                OperationHelper.releasingCallback(SingleResultCallback.this, source).onResult(null, t2);
                                return;
                            }
                            try {
                                BsonDocument command = commandCreator.create(source.getServerDescription(), connection.getDescription());
                                connection.commandAsync(database, command, fieldNameValidator, readPreference, commandResultDecoder, binding.getSessionContext(), CommandOperationHelper.createCommandCallback(binding, source, connection, database, readPreference, command, fieldNameValidator, commandResultDecoder, transformer, retryCommandModifier, SingleResultCallback.this));
                            } catch (Throwable t1) {
                                OperationHelper.releasingCallback(SingleResultCallback.this, source, connection).onResult(null, t1);
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static <T, R> SingleResultCallback<T> createCommandCallback(final AsyncWriteBinding binding, final AsyncConnectionSource oldSource, final AsyncConnection oldConnection, final String database, final ReadPreference readPreference, final BsonDocument command, final FieldNameValidator fieldNameValidator, final Decoder<T> commandResultDecoder, final CommandWriteTransformerAsync<T, R> transformer, final Function<BsonDocument, BsonDocument> retryCommandModifier, final SingleResultCallback<R> callback) {
        return new SingleResultCallback<T>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.15
            @Override // com.mongodb.internal.async.SingleResultCallback
            public void onResult(T result, Throwable originalError) {
                SingleResultCallback releasingCallback = OperationHelper.releasingCallback(SingleResultCallback.this, oldSource, oldConnection);
                if (originalError != null) {
                    checkRetryableException(originalError, releasingCallback);
                    return;
                }
                try {
                    releasingCallback.onResult(transformer.apply(result, oldConnection), null);
                } catch (Throwable transformError) {
                    checkRetryableException(transformError, releasingCallback);
                }
            }

            private void checkRetryableException(Throwable originalError, SingleResultCallback<R> releasingCallback) {
                if (!CommandOperationHelper.shouldAttemptToRetryWrite(command, originalError, oldConnection.getDescription().getMaxWireVersion())) {
                    if (CommandOperationHelper.isRetryWritesEnabled(command)) {
                        CommandOperationHelper.logUnableToRetry(command.getFirstKey(), originalError);
                    }
                    releasingCallback.onResult(null, originalError instanceof MongoException ? CommandOperationHelper.transformWriteException((MongoException) originalError) : originalError);
                    return;
                }
                oldConnection.release();
                oldSource.release();
                if (binding.getSessionContext().hasActiveTransaction()) {
                    binding.getSessionContext().unpinServerAddress();
                }
                retryableCommand(originalError);
            }

            private void retryableCommand(final Throwable originalError) {
                final BsonDocument retryCommand = (BsonDocument) retryCommandModifier.apply(command);
                CommandOperationHelper.logRetryExecute(retryCommand.getFirstKey(), originalError);
                OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.CommandOperationHelper.15.1
                    @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
                    public void call(AsyncConnectionSource source, AsyncConnection connection, Throwable t) {
                        if (t != null) {
                            SingleResultCallback.this.onResult(null, originalError);
                        } else if (!OperationHelper.canRetryWrite(source.getServerDescription(), connection.getDescription(), binding.getSessionContext())) {
                            OperationHelper.releasingCallback(SingleResultCallback.this, source, connection).onResult(null, originalError);
                        } else {
                            connection.commandAsync(database, retryCommand, fieldNameValidator, readPreference, commandResultDecoder, binding.getSessionContext(), new TransformingWriteResultCallback(transformer, connection, OperationHelper.releasingCallback(SingleResultCallback.this, source, connection)));
                        }
                    }
                });
            }
        };
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$TransformingWriteResultCallback.class */
    static class TransformingWriteResultCallback<T, R> implements SingleResultCallback<T> {
        private final CommandWriteTransformerAsync<T, R> transformer;
        private final AsyncConnection connection;
        private final SingleResultCallback<R> callback;

        TransformingWriteResultCallback(CommandWriteTransformerAsync<T, R> transformer, AsyncConnection connection, SingleResultCallback<R> callback) {
            this.transformer = transformer;
            this.connection = connection;
            this.callback = callback;
        }

        @Override // com.mongodb.internal.async.SingleResultCallback
        public void onResult(T result, Throwable t) {
            if (t != null) {
                if (t instanceof MongoException) {
                    CommandOperationHelper.addRetryableWriteErrorLabel((MongoException) t, this.connection.getDescription().getMaxWireVersion());
                }
                this.callback.onResult(null, t);
                return;
            }
            try {
                this.callback.onResult(this.transformer.apply(result, this.connection), null);
            } catch (Throwable transformError) {
                this.callback.onResult(null, transformError);
            }
        }
    }

    static boolean isRetryableException(Throwable t) {
        if (!(t instanceof MongoException)) {
            return false;
        }
        if ((t instanceof MongoSocketException) || (t instanceof MongoNotPrimaryException) || (t instanceof MongoNodeIsRecoveringException)) {
            return true;
        }
        return RETRYABLE_ERROR_CODES.contains(Integer.valueOf(((MongoException) t).getCode()));
    }

    /* access modifiers changed from: package-private */
    public static void rethrowIfNotNamespaceError(MongoCommandException e) {
        rethrowIfNotNamespaceError(e, null);
    }

    /* access modifiers changed from: package-private */
    public static <T> T rethrowIfNotNamespaceError(MongoCommandException e, T defaultValue) {
        if (isNamespaceError(e)) {
            return defaultValue;
        }
        throw e;
    }

    /* access modifiers changed from: package-private */
    public static boolean isNamespaceError(Throwable t) {
        if (!(t instanceof MongoCommandException)) {
            return false;
        }
        MongoCommandException e = (MongoCommandException) t;
        return e.getErrorMessage().contains("ns not found") || e.getErrorCode() == 26;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandOperationHelper$CommandProtocolExecutingCallback.class */
    public static class CommandProtocolExecutingCallback<D, R> implements SingleResultCallback<AsyncConnectionSource> {
        private final String database;
        private final BsonDocument command;
        private final Decoder<D> decoder;
        private final ReadPreference readPreference;
        private final FieldNameValidator fieldNameValidator;
        private final CommandWriteTransformerAsync<D, R> transformer;
        private final SingleResultCallback<R> callback;
        private final SessionContext sessionContext;

        CommandProtocolExecutingCallback(String database, BsonDocument command, FieldNameValidator fieldNameValidator, Decoder<D> decoder, ReadPreference readPreference, CommandWriteTransformerAsync<D, R> transformer, SessionContext sessionContext, SingleResultCallback<R> callback) {
            this.database = database;
            this.command = command;
            this.fieldNameValidator = fieldNameValidator;
            this.decoder = decoder;
            this.readPreference = readPreference;
            this.transformer = transformer;
            this.sessionContext = sessionContext;
            this.callback = callback;
        }

        public void onResult(final AsyncConnectionSource source, Throwable t) {
            if (t != null) {
                this.callback.onResult(null, t);
            } else {
                source.getConnection(new SingleResultCallback<AsyncConnection>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.CommandProtocolExecutingCallback.1
                    public void onResult(final AsyncConnection connection, Throwable t2) {
                        if (t2 != null) {
                            CommandProtocolExecutingCallback.this.callback.onResult(null, t2);
                            return;
                        }
                        final SingleResultCallback<R> wrappedCallback = OperationHelper.releasingCallback(CommandProtocolExecutingCallback.this.callback, source, connection);
                        connection.commandAsync(CommandProtocolExecutingCallback.this.database, CommandProtocolExecutingCallback.this.command, CommandProtocolExecutingCallback.this.fieldNameValidator, CommandProtocolExecutingCallback.this.readPreference, CommandProtocolExecutingCallback.this.decoder, CommandProtocolExecutingCallback.this.sessionContext, new SingleResultCallback<D>() { // from class: com.mongodb.internal.operation.CommandOperationHelper.CommandProtocolExecutingCallback.1.1
                            @Override // com.mongodb.internal.async.SingleResultCallback
                            public void onResult(D response, Throwable t3) {
                                if (t3 != null) {
                                    wrappedCallback.onResult(null, t3);
                                } else {
                                    wrappedCallback.onResult(CommandProtocolExecutingCallback.this.transformer.apply(response, connection), null);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean shouldAttemptToRetryRead(boolean retryReadsEnabled, Throwable t) {
        return retryReadsEnabled && isRetryableException(t);
    }

    /* access modifiers changed from: private */
    public static boolean shouldAttemptToRetryWrite(@Nullable BsonDocument command, Throwable t, int maxWireVersion) {
        return shouldAttemptToRetryWrite(isRetryWritesEnabled(command), t, maxWireVersion);
    }

    /* access modifiers changed from: private */
    public static boolean isRetryWritesEnabled(@Nullable BsonDocument command) {
        return command != null && (command.containsKey("txnNumber") || command.getFirstKey().equals("commitTransaction") || command.getFirstKey().equals("abortTransaction"));
    }

    /* access modifiers changed from: package-private */
    public static boolean shouldAttemptToRetryWrite(boolean retryWritesEnabled, Throwable t, int maxWireVersion) {
        if (!retryWritesEnabled || !(t instanceof MongoException)) {
            return false;
        }
        MongoException exception = (MongoException) t;
        addRetryableWriteErrorLabel(exception, maxWireVersion);
        return exception.hasErrorLabel(RETRYABLE_WRITE_ERROR_LABEL);
    }

    /* access modifiers changed from: package-private */
    public static void addRetryableWriteErrorLabel(MongoException exception, int maxWireVersion) {
        if (maxWireVersion >= 9 && (exception instanceof MongoSocketException)) {
            exception.addLabel(RETRYABLE_WRITE_ERROR_LABEL);
        } else if (maxWireVersion < 9 && isRetryableException(exception)) {
            exception.addLabel(RETRYABLE_WRITE_ERROR_LABEL);
        }
    }

    /* access modifiers changed from: package-private */
    public static void logRetryExecute(String operation, Throwable originalError) {
        if (OperationHelper.LOGGER.isDebugEnabled()) {
            OperationHelper.LOGGER.debug(String.format("Retrying operation %s due to an error \"%s\"", operation, originalError));
        }
    }

    /* access modifiers changed from: package-private */
    public static void logUnableToRetry(String operation, Throwable originalError) {
        if (OperationHelper.LOGGER.isDebugEnabled()) {
            OperationHelper.LOGGER.debug(String.format("Unable to retry operation %s due to error \"%s\"", operation, originalError));
        }
    }

    /* access modifiers changed from: package-private */
    public static MongoException transformWriteException(MongoException exception) {
        if (exception.getCode() != 20 || !exception.getMessage().contains("Transaction numbers")) {
            return exception;
        }
        MongoException clientException = new MongoClientException("This MongoDB deployment does not support retryable writes. Please add retryWrites=false to your connection string.", exception);
        for (String errorLabel : exception.getErrorLabels()) {
            clientException.addLabel(errorLabel);
        }
        return clientException;
    }

    private CommandOperationHelper() {
    }
}
