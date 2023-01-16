package com.mongodb.internal.connection;

import com.mongodb.DuplicateKeyException;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoExecutionTimeoutException;
import com.mongodb.MongoNodeIsRecoveringException;
import com.mongodb.MongoNotPrimaryException;
import com.mongodb.MongoQueryException;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcernException;
import com.mongodb.WriteConcernResult;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.CommandFailedEvent;
import com.mongodb.event.CommandListener;
import com.mongodb.event.CommandStartedEvent;
import com.mongodb.event.CommandSucceededEvent;
import com.mongodb.internal.connection.RequestMessage;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonBinaryReader;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonTimestamp;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.p022io.BsonOutput;
import org.bson.p022io.ByteBufferBsonInput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ProtocolHelper.class */
public final class ProtocolHelper {
    private static final Logger PROTOCOL_EVENT_LOGGER = Loggers.getLogger("protocol.event");
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());
    private static final List<Integer> NOT_MASTER_CODES = Arrays.asList(10107, 13435);
    private static final List<Integer> RECOVERING_CODES = Arrays.asList(11600, 11602, 13436, 189, 91);

    private static WriteConcernResult createWriteResult(BsonDocument result) {
        return WriteConcernResult.acknowledged(result.getNumber("n", new BsonInt32(0)).intValue(), result.getBoolean("updatedExisting", BsonBoolean.FALSE).getValue(), result.get("upserted"));
    }

    /* access modifiers changed from: package-private */
    public static boolean isCommandOk(BsonDocument response) {
        return isCommandOk(response.get("ok"));
    }

    /* access modifiers changed from: package-private */
    public static boolean isCommandOk(BsonReader bsonReader) {
        return isCommandOk(getField(bsonReader, "ok"));
    }

    /* access modifiers changed from: package-private */
    public static boolean isCommandOk(ResponseBuffers responseBuffers) {
        try {
            return isCommandOk(createBsonReader(responseBuffers));
        } finally {
            responseBuffers.reset();
        }
    }

    /* access modifiers changed from: package-private */
    public static MongoException createSpecialWriteConcernException(ResponseBuffers responseBuffers, ServerAddress serverAddress) {
        BsonValue writeConcernError = getField(createBsonReader(responseBuffers), "writeConcernError");
        if (writeConcernError == null) {
            return null;
        }
        return createSpecialException(writeConcernError.asDocument(), serverAddress, "errmsg");
    }

    /* access modifiers changed from: package-private */
    public static BsonTimestamp getOperationTime(ResponseBuffers responseBuffers) {
        try {
            BsonValue operationTime = getField(createBsonReader(responseBuffers), "operationTime");
            if (operationTime == null) {
                return null;
            }
            return operationTime.asTimestamp();
        } finally {
            responseBuffers.reset();
        }
    }

    /* access modifiers changed from: package-private */
    public static BsonDocument getClusterTime(ResponseBuffers responseBuffers) {
        return getFieldDocument(responseBuffers, "$clusterTime");
    }

    static BsonDocument getClusterTime(BsonDocument response) {
        BsonValue clusterTime = response.get("$clusterTime");
        if (clusterTime == null) {
            return null;
        }
        return clusterTime.asDocument();
    }

    /* access modifiers changed from: package-private */
    public static BsonDocument getRecoveryToken(ResponseBuffers responseBuffers) {
        return getFieldDocument(responseBuffers, "recoveryToken");
    }

    private static BsonDocument getFieldDocument(ResponseBuffers responseBuffers, String fieldName) {
        try {
            BsonValue fieldValue = getField(createBsonReader(responseBuffers), fieldName);
            if (fieldValue == null) {
                return null;
            }
            BsonDocument asDocument = fieldValue.asDocument();
            responseBuffers.reset();
            return asDocument;
        } finally {
            responseBuffers.reset();
        }
    }

    private static BsonBinaryReader createBsonReader(ResponseBuffers responseBuffers) {
        return new BsonBinaryReader(new ByteBufferBsonInput(responseBuffers.getBodyByteBuffer()));
    }

    private static BsonValue getField(BsonReader bsonReader, String fieldName) {
        bsonReader.readStartDocument();
        while (bsonReader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            if (bsonReader.readName().equals(fieldName)) {
                return (BsonValue) REGISTRY.get(BsonValueCodecProvider.getClassForBsonType(bsonReader.getCurrentBsonType())).decode(bsonReader, DecoderContext.builder().build());
            }
            bsonReader.skipValue();
        }
        bsonReader.readEndDocument();
        return null;
    }

    private static boolean isCommandOk(BsonValue okValue) {
        if (okValue == null) {
            return false;
        }
        if (okValue.isBoolean()) {
            return okValue.asBoolean().getValue();
        }
        return okValue.isNumber() && okValue.asNumber().intValue() == 1;
    }

    /* access modifiers changed from: package-private */
    public static MongoException getCommandFailureException(BsonDocument response, ServerAddress serverAddress) {
        MongoException specialException = createSpecialException(response, serverAddress, "errmsg");
        if (specialException != null) {
            return specialException;
        }
        return new MongoCommandException(response, serverAddress);
    }

    static int getErrorCode(BsonDocument response) {
        return response.getNumber("code", new BsonInt32(-1)).intValue();
    }

    static String getErrorMessage(BsonDocument response, String errorMessageFieldName) {
        return response.getString(errorMessageFieldName, new BsonString("")).getValue();
    }

    /* access modifiers changed from: package-private */
    public static MongoException getQueryFailureException(BsonDocument errorDocument, ServerAddress serverAddress) {
        MongoException specialException = createSpecialException(errorDocument, serverAddress, "$err");
        if (specialException != null) {
            return specialException;
        }
        return new MongoQueryException(serverAddress, getErrorCode(errorDocument), getErrorMessage(errorDocument, "$err"));
    }

    /* access modifiers changed from: package-private */
    public static MessageSettings getMessageSettings(ConnectionDescription connectionDescription) {
        return MessageSettings.builder().maxDocumentSize(connectionDescription.getMaxDocumentSize()).maxMessageSize(connectionDescription.getMaxMessageSize()).maxBatchCount(connectionDescription.getMaxBatchCount()).maxWireVersion(connectionDescription.getMaxWireVersion()).serverType(connectionDescription.getServerType()).build();
    }

    /* access modifiers changed from: package-private */
    public static void encodeMessage(RequestMessage message, BsonOutput bsonOutput) {
        try {
            message.encode(bsonOutput, NoOpSessionContext.INSTANCE);
        } catch (Error e) {
            bsonOutput.close();
            throw e;
        } catch (RuntimeException e2) {
            bsonOutput.close();
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public static RequestMessage.EncodingMetadata encodeMessageWithMetadata(RequestMessage message, BsonOutput bsonOutput) {
        try {
            message.encode(bsonOutput, NoOpSessionContext.INSTANCE);
            return message.getEncodingMetadata();
        } catch (Error e) {
            bsonOutput.close();
            throw e;
        } catch (RuntimeException e2) {
            bsonOutput.close();
            throw e2;
        }
    }

    public static MongoException createSpecialException(BsonDocument response, ServerAddress serverAddress, String errorMessageFieldName) {
        if (response == null) {
            return null;
        }
        int errorCode = getErrorCode(response);
        String errorMessage = getErrorMessage(response, errorMessageFieldName);
        if (ErrorCategory.fromErrorCode(errorCode) == ErrorCategory.EXECUTION_TIMEOUT) {
            return new MongoExecutionTimeoutException(errorCode, errorMessage, response);
        }
        if (errorMessage.contains("not master or secondary") || errorMessage.contains("node is recovering") || RECOVERING_CODES.contains(Integer.valueOf(errorCode))) {
            return new MongoNodeIsRecoveringException(response, serverAddress);
        }
        if (errorMessage.contains("not master") || NOT_MASTER_CODES.contains(Integer.valueOf(errorCode))) {
            return new MongoNotPrimaryException(response, serverAddress);
        }
        if (response.containsKey("writeConcernError")) {
            return createSpecialException(response.getDocument("writeConcernError"), serverAddress, "errmsg");
        }
        return null;
    }

    private static boolean hasWriteError(BsonDocument response) {
        String err = WriteConcernException.extractErrorMessage(response);
        return err != null && err.length() > 0;
    }

    private static void throwWriteException(BsonDocument result, ServerAddress serverAddress) {
        MongoException specialException = createSpecialException(result, serverAddress, "err");
        if (specialException != null) {
            throw specialException;
        } else if (ErrorCategory.fromErrorCode(WriteConcernException.extractErrorCode(result)) == ErrorCategory.DUPLICATE_KEY) {
            throw new DuplicateKeyException(result, serverAddress, createWriteResult(result));
        } else {
            throw new WriteConcernException(result, serverAddress, createWriteResult(result));
        }
    }

    /* access modifiers changed from: package-private */
    public static void sendCommandStartedEvent(RequestMessage message, String databaseName, String commandName, BsonDocument command, ConnectionDescription connectionDescription, CommandListener commandListener) {
        try {
            commandListener.commandStarted(new CommandStartedEvent(message.getId(), connectionDescription, databaseName, commandName, command));
        } catch (Exception e) {
            if (PROTOCOL_EVENT_LOGGER.isWarnEnabled()) {
                PROTOCOL_EVENT_LOGGER.warn(String.format("Exception thrown raising command started event to listener %s", commandListener), e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void sendCommandSucceededEvent(RequestMessage message, String commandName, BsonDocument response, ConnectionDescription connectionDescription, long elapsedTimeNanos, CommandListener commandListener) {
        try {
            commandListener.commandSucceeded(new CommandSucceededEvent(message.getId(), connectionDescription, commandName, response, elapsedTimeNanos));
        } catch (Exception e) {
            if (PROTOCOL_EVENT_LOGGER.isWarnEnabled()) {
                PROTOCOL_EVENT_LOGGER.warn(String.format("Exception thrown raising command succeeded event to listener %s", commandListener), e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void sendCommandFailedEvent(RequestMessage message, String commandName, ConnectionDescription connectionDescription, long elapsedTimeNanos, Throwable throwable, CommandListener commandListener) {
        try {
            commandListener.commandFailed(new CommandFailedEvent(message.getId(), connectionDescription, commandName, elapsedTimeNanos, throwable));
        } catch (Exception e) {
            if (PROTOCOL_EVENT_LOGGER.isWarnEnabled()) {
                PROTOCOL_EVENT_LOGGER.warn(String.format("Exception thrown raising command failed event to listener %s", commandListener), e);
            }
        }
    }

    private ProtocolHelper() {
    }
}
