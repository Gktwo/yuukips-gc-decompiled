package com.mongodb.internal.connection;

import com.mongodb.MongoCommandException;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.event.CommandListener;
import java.io.StringWriter;
import java.util.Set;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonReader;
import org.bson.codecs.RawBsonDocumentCodec;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/LoggingCommandEventSender.class */
class LoggingCommandEventSender implements CommandEventSender {
    private static final int MAX_COMMAND_DOCUMENT_LENGTH_TO_LOG = 1000;
    private final Set<String> securitySensitiveCommands;
    private final ConnectionDescription description;
    private final CommandListener commandListener;
    private final Logger logger;
    private final long startTimeNanos = System.nanoTime();
    private final CommandMessage message;
    private final String commandName;
    private volatile BsonDocument commandDocument;

    /* access modifiers changed from: package-private */
    public LoggingCommandEventSender(Set<String> securitySensitiveCommands, ConnectionDescription description, CommandListener commandListener, CommandMessage message, ByteBufferBsonOutput bsonOutput, Logger logger) {
        this.securitySensitiveCommands = securitySensitiveCommands;
        this.description = description;
        this.commandListener = commandListener;
        this.logger = logger;
        this.message = message;
        this.commandDocument = message.getCommandDocument(bsonOutput);
        this.commandName = this.commandDocument.getFirstKey();
    }

    @Override // com.mongodb.internal.connection.CommandEventSender
    public void sendStartedEvent() {
        if (loggingRequired()) {
            this.logger.debug(String.format("Sending command '%s' with request id %d to database %s on connection [%s] to server %s", getTruncatedJsonCommand(), Integer.valueOf(this.message.getId()), this.message.getNamespace().getDatabaseName(), this.description.getConnectionId(), this.description.getServerAddress()));
        }
        if (eventRequired()) {
            ProtocolHelper.sendCommandStartedEvent(this.message, this.message.getNamespace().getDatabaseName(), this.commandName, this.securitySensitiveCommands.contains(this.commandName) ? new BsonDocument() : this.commandDocument, this.description, this.commandListener);
        }
        this.commandDocument = null;
    }

    private String getTruncatedJsonCommand() {
        StringWriter writer = new StringWriter();
        BsonReader bsonReader = this.commandDocument.asBsonReader();
        try {
            JsonWriter jsonWriter = new JsonWriter(writer, JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).maxLength(1000).build());
            jsonWriter.pipe(bsonReader);
            if (jsonWriter.isTruncated()) {
                writer.append((CharSequence) " ...");
            }
            String stringWriter = writer.toString();
            bsonReader.close();
            return stringWriter;
        } catch (Throwable th) {
            bsonReader.close();
            throw th;
        }
    }

    @Override // com.mongodb.internal.connection.CommandEventSender
    public void sendFailedEvent(Throwable t) {
        Throwable commandEventException = t;
        if ((t instanceof MongoCommandException) && this.securitySensitiveCommands.contains(this.commandName)) {
            commandEventException = new MongoCommandException(new BsonDocument(), this.description.getServerAddress());
        }
        long elapsedTimeNanos = System.nanoTime() - this.startTimeNanos;
        if (loggingRequired()) {
            this.logger.debug(String.format("Execution of command with request id %d failed to complete successfully in %s ms on connection [%s] to server %s", Integer.valueOf(this.message.getId()), getElapsedTimeFormattedInMilliseconds(elapsedTimeNanos), this.description.getConnectionId(), this.description.getServerAddress()), commandEventException);
        }
        if (eventRequired()) {
            ProtocolHelper.sendCommandFailedEvent(this.message, this.commandName, this.description, elapsedTimeNanos, commandEventException, this.commandListener);
        }
    }

    @Override // com.mongodb.internal.connection.CommandEventSender
    public void sendSucceededEvent(ResponseBuffers responseBuffers) {
        BsonDocument responseDocumentForEvent;
        long elapsedTimeNanos = System.nanoTime() - this.startTimeNanos;
        if (loggingRequired()) {
            this.logger.debug(String.format("Execution of command with request id %d completed successfully in %s ms on connection [%s] to server %s", Integer.valueOf(this.message.getId()), getElapsedTimeFormattedInMilliseconds(elapsedTimeNanos), this.description.getConnectionId(), this.description.getServerAddress()));
        }
        if (eventRequired()) {
            if (this.securitySensitiveCommands.contains(this.commandName)) {
                responseDocumentForEvent = new BsonDocument();
            } else {
                responseDocumentForEvent = responseBuffers.getResponseDocument(this.message.getId(), new RawBsonDocumentCodec());
            }
            ProtocolHelper.sendCommandSucceededEvent(this.message, this.commandName, responseDocumentForEvent, this.description, elapsedTimeNanos, this.commandListener);
        }
    }

    @Override // com.mongodb.internal.connection.CommandEventSender
    public void sendSucceededEventForOneWayCommand() {
        long elapsedTimeNanos = System.nanoTime() - this.startTimeNanos;
        if (loggingRequired()) {
            this.logger.debug(String.format("Execution of one-way command with request id %d completed successfully in %s ms on connection [%s] to server %s", Integer.valueOf(this.message.getId()), getElapsedTimeFormattedInMilliseconds(elapsedTimeNanos), this.description.getConnectionId(), this.description.getServerAddress()));
        }
        if (eventRequired()) {
            ProtocolHelper.sendCommandSucceededEvent(this.message, this.commandName, new BsonDocument("ok", new BsonInt32(1)), this.description, elapsedTimeNanos, this.commandListener);
        }
    }

    private boolean loggingRequired() {
        return this.logger.isDebugEnabled();
    }

    private boolean eventRequired() {
        return this.commandListener != null;
    }

    private String getElapsedTimeFormattedInMilliseconds(long elapsedTimeNanos) {
        return DecimalFormatHelper.format("#0.00", ((double) elapsedTimeNanos) / 1000000.0d);
    }
}
