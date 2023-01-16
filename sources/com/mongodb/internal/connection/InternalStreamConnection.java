package com.mongodb.internal.connection;

import com.mongodb.MongoClientException;
import com.mongodb.MongoCompressor;
import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.MongoInterruptedException;
import com.mongodb.MongoSocketClosedException;
import com.mongodb.MongoSocketReadException;
import com.mongodb.MongoSocketReadTimeoutException;
import com.mongodb.MongoSocketWriteException;
import com.mongodb.ServerAddress;
import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.AsyncCompletionHandler;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ConnectionId;
import com.mongodb.connection.ServerConnectionState;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerId;
import com.mongodb.connection.ServerType;
import com.mongodb.connection.Stream;
import com.mongodb.connection.StreamFactory;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.CommandListener;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.nio.channels.ClosedByInterruptException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bson.BsonBinaryReader;
import org.bson.BsonDocument;
import org.bson.ByteBuf;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Decoder;
import org.bson.p022io.ByteBufferBsonInput;

@NotThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalStreamConnection.class */
public class InternalStreamConnection implements InternalConnection {
    private final ServerId serverId;
    private final StreamFactory streamFactory;
    private final InternalConnectionInitializer connectionInitializer;
    private volatile ConnectionDescription description;
    private volatile ServerDescription initialServerDescription;
    private volatile Stream stream;
    private final AtomicBoolean isClosed = new AtomicBoolean();
    private final AtomicBoolean opened = new AtomicBoolean();
    private final List<MongoCompressor> compressorList;
    private final CommandListener commandListener;
    private volatile Compressor sendCompressor;
    private volatile Map<Byte, Compressor> compressorMap;
    private volatile boolean hasMoreToCome;
    private volatile int responseTo;
    private static final Set<String> SECURITY_SENSITIVE_COMMANDS = new HashSet(Arrays.asList("authenticate", "saslStart", "saslContinue", "getnonce", "createUser", "updateUser", "copydbgetnonce", "copydbsaslstart", "copydb"));
    private static final Logger LOGGER = Loggers.getLogger("connection");
    private static final Logger COMMAND_PROTOCOL_LOGGER = Loggers.getLogger("protocol.command");

    public InternalStreamConnection(ServerId serverId, StreamFactory streamFactory, List<MongoCompressor> compressorList, CommandListener commandListener, InternalConnectionInitializer connectionInitializer) {
        this.serverId = (ServerId) Assertions.notNull("serverId", serverId);
        this.streamFactory = (StreamFactory) Assertions.notNull("streamFactory", streamFactory);
        this.compressorList = (List) Assertions.notNull("compressorList", compressorList);
        this.compressorMap = createCompressorMap(compressorList);
        this.commandListener = commandListener;
        this.connectionInitializer = (InternalConnectionInitializer) Assertions.notNull("connectionInitializer", connectionInitializer);
        this.description = new ConnectionDescription(serverId);
        this.initialServerDescription = ServerDescription.builder().address(serverId.getAddress()).type(ServerType.UNKNOWN).state(ServerConnectionState.CONNECTING).build();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public ConnectionDescription getDescription() {
        return this.description;
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public ServerDescription getInitialServerDescription() {
        return this.initialServerDescription;
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void open() {
        Assertions.isTrue("Open already called", this.stream == null);
        this.stream = this.streamFactory.create(this.serverId.getAddress());
        try {
            this.stream.open();
            InternalConnectionInitializationDescription initializationDescription = this.connectionInitializer.initialize(this);
            this.description = initializationDescription.getConnectionDescription();
            this.initialServerDescription = initializationDescription.getServerDescription();
            this.opened.set(true);
            this.sendCompressor = findSendCompressor(this.description);
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(String.format("Opened connection [%s] to %s", getId(), this.serverId.getAddress()));
            }
        } catch (Throwable t) {
            close();
            if (t instanceof MongoException) {
                throw ((MongoException) t);
            }
            throw new MongoException(t.toString(), t);
        }
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void openAsync(final SingleResultCallback<Void> callback) {
        Assertions.isTrue("Open already called", this.stream == null, callback);
        try {
            this.stream = this.streamFactory.create(this.serverId.getAddress());
            this.stream.openAsync(new AsyncCompletionHandler<Void>() { // from class: com.mongodb.internal.connection.InternalStreamConnection.1
                public void completed(Void aVoid) {
                    InternalStreamConnection.this.connectionInitializer.initializeAsync(InternalStreamConnection.this, new SingleResultCallback<InternalConnectionInitializationDescription>() { // from class: com.mongodb.internal.connection.InternalStreamConnection.1.1
                        public void onResult(InternalConnectionInitializationDescription result, Throwable t) {
                            if (t != null) {
                                InternalStreamConnection.this.close();
                                callback.onResult(null, t);
                                return;
                            }
                            InternalStreamConnection.this.description = result.getConnectionDescription();
                            InternalStreamConnection.this.initialServerDescription = result.getServerDescription();
                            InternalStreamConnection.this.opened.set(true);
                            InternalStreamConnection.this.sendCompressor = InternalStreamConnection.this.findSendCompressor(InternalStreamConnection.this.description);
                            if (InternalStreamConnection.LOGGER.isInfoEnabled()) {
                                InternalStreamConnection.LOGGER.info(String.format("Opened connection [%s] to %s", InternalStreamConnection.this.getId(), InternalStreamConnection.this.serverId.getAddress()));
                            }
                            callback.onResult(null, null);
                        }
                    });
                }

                @Override // com.mongodb.connection.AsyncCompletionHandler
                public void failed(Throwable t) {
                    callback.onResult(null, t);
                }
            });
        } catch (Throwable t) {
            callback.onResult(null, t);
        }
    }

    private Map<Byte, Compressor> createCompressorMap(List<MongoCompressor> compressorList) {
        Map<Byte, Compressor> compressorMap = new HashMap<>(this.compressorList.size());
        for (MongoCompressor mongoCompressor : compressorList) {
            Compressor compressor = createCompressor(mongoCompressor);
            compressorMap.put(Byte.valueOf(compressor.getId()), compressor);
        }
        return compressorMap;
    }

    /* access modifiers changed from: private */
    public Compressor findSendCompressor(ConnectionDescription description) {
        if (description.getCompressors().isEmpty()) {
            return null;
        }
        String firstCompressorName = description.getCompressors().get(0);
        for (Compressor compressor : this.compressorMap.values()) {
            if (compressor.getName().equals(firstCompressorName)) {
                return compressor;
            }
        }
        throw new MongoInternalException("Unexpected compressor negotiated: " + firstCompressorName);
    }

    private Compressor createCompressor(MongoCompressor mongoCompressor) {
        if (mongoCompressor.getName().equals("zlib")) {
            return new ZlibCompressor(mongoCompressor);
        }
        if (mongoCompressor.getName().equals("snappy")) {
            return new SnappyCompressor();
        }
        if (mongoCompressor.getName().equals("zstd")) {
            return new ZstdCompressor();
        }
        throw new MongoClientException("Unsupported compressor " + mongoCompressor.getName());
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void close() {
        if (!this.isClosed.getAndSet(true)) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format("Closing connection %s", getId()));
            }
            if (this.stream != null) {
                this.stream.close();
            }
        }
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public boolean opened() {
        return this.opened.get();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public boolean isClosed() {
        return this.isClosed.get();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> T sendAndReceive(CommandMessage message, Decoder<T> decoder, SessionContext sessionContext) {
        ByteBufferBsonOutput bsonOutput = new ByteBufferBsonOutput(this);
        try {
            message.encode(bsonOutput, sessionContext);
            CommandEventSender commandEventSender = createCommandEventSender(message, bsonOutput);
            commandEventSender.sendStartedEvent();
            try {
                sendCommandMessage(message, bsonOutput, sessionContext);
                if (message.isResponseExpected()) {
                    return (T) receiveCommandMessageResponse(decoder, commandEventSender, sessionContext, 0);
                }
                commandEventSender.sendSucceededEventForOneWayCommand();
                return null;
            } catch (RuntimeException e) {
                commandEventSender.sendFailedEvent(e);
                throw e;
            }
        } catch (RuntimeException e2) {
            bsonOutput.close();
            throw e2;
        }
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> void send(CommandMessage message, Decoder<T> decoder, SessionContext sessionContext) {
        ByteBufferBsonOutput bsonOutput = new ByteBufferBsonOutput(this);
        try {
            message.encode(bsonOutput, sessionContext);
            sendCommandMessage(message, bsonOutput, sessionContext);
            if (message.isResponseExpected()) {
                this.hasMoreToCome = true;
            }
            bsonOutput.close();
        } catch (Throwable th) {
            try {
                bsonOutput.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> T receive(Decoder<T> decoder, SessionContext sessionContext) {
        Assertions.isTrue("Response is expected", this.hasMoreToCome);
        return (T) receiveCommandMessageResponse(decoder, null, sessionContext, 0);
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public boolean supportsAdditionalTimeout() {
        return this.stream.supportsAdditionalTimeout();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> T receive(Decoder<T> decoder, SessionContext sessionContext, int additionalTimeout) {
        Assertions.isTrue("Response is expected", this.hasMoreToCome);
        return (T) receiveCommandMessageResponse(decoder, null, sessionContext, additionalTimeout);
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public boolean hasMoreToCome() {
        return this.hasMoreToCome;
    }

    private void sendCommandMessage(CommandMessage message, ByteBufferBsonOutput compressedBsonOutput, SessionContext sessionContext) {
        ByteBufferBsonOutput compressedBsonOutput;
        if (this.sendCompressor == null || SECURITY_SENSITIVE_COMMANDS.contains(message.getCommandDocument(compressedBsonOutput).getFirstKey())) {
            try {
                sendMessage(compressedBsonOutput.getByteBuffers(), message.getId());
                compressedBsonOutput.close();
            } finally {
            }
        } else {
            List<ByteBuf> byteBuffers = compressedBsonOutput.getByteBuffers();
            try {
                CompressedMessage compressedMessage = new CompressedMessage(message.getOpCode(), byteBuffers, this.sendCompressor, ProtocolHelper.getMessageSettings(this.description));
                compressedBsonOutput = new ByteBufferBsonOutput(this);
                compressedMessage.encode(compressedBsonOutput, sessionContext);
                releaseAllBuffers(byteBuffers);
                compressedBsonOutput.close();
                try {
                    sendMessage(compressedBsonOutput.getByteBuffers(), message.getId());
                    compressedBsonOutput.close();
                } finally {
                }
            } catch (Throwable th) {
                releaseAllBuffers(byteBuffers);
                compressedBsonOutput.close();
                throw th;
            }
        }
        this.responseTo = message.getId();
    }

    private <T> T receiveCommandMessageResponse(Decoder<T> decoder, CommandEventSender commandEventSender, SessionContext sessionContext, int additionalTimeout) {
        ResponseBuffers responseBuffers = receiveMessageWithAdditionalTimeout(additionalTimeout);
        try {
            updateSessionContext(sessionContext, responseBuffers);
            if (!ProtocolHelper.isCommandOk(responseBuffers)) {
                throw ProtocolHelper.getCommandFailureException(responseBuffers.getResponseDocument(this.responseTo, new BsonDocumentCodec()), this.description.getServerAddress());
            }
            if (commandEventSender != null) {
                commandEventSender.sendSucceededEvent(responseBuffers);
            }
            T commandResult = (T) getCommandResult(decoder, responseBuffers, this.responseTo);
            this.hasMoreToCome = responseBuffers.getReplyHeader().hasMoreToCome();
            if (this.hasMoreToCome) {
                this.responseTo = responseBuffers.getReplyHeader().getRequestId();
            } else {
                this.responseTo = 0;
            }
            if (responseBuffers != null) {
                responseBuffers.close();
            }
            return commandResult;
        } catch (Throwable th) {
            if (responseBuffers != null) {
                try {
                    responseBuffers.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x00bd
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> void sendAndReceiveAsync(com.mongodb.internal.connection.CommandMessage r10, org.bson.codecs.Decoder<T> r11, com.mongodb.internal.session.SessionContext r12, com.mongodb.internal.async.SingleResultCallback<T> r13) {
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.InternalStreamConnection.sendAndReceiveAsync(com.mongodb.internal.connection.CommandMessage, org.bson.codecs.Decoder, com.mongodb.internal.session.SessionContext, com.mongodb.internal.async.SingleResultCallback):void");
    }

    private void releaseAllBuffers(List<ByteBuf> byteBuffers) {
        for (ByteBuf cur : byteBuffers) {
            cur.release();
        }
    }

    private <T> void sendCommandMessageAsync(final int messageId, final Decoder<T> decoder, final SessionContext sessionContext, final SingleResultCallback<T> callback, final ByteBufferBsonOutput bsonOutput, final CommandEventSender commandEventSender, final boolean responseExpected) {
        sendMessageAsync(bsonOutput.getByteBuffers(), messageId, new SingleResultCallback<Void>() { // from class: com.mongodb.internal.connection.InternalStreamConnection.2
            public void onResult(Void result, Throwable t) {
                bsonOutput.close();
                if (t != null) {
                    commandEventSender.sendFailedEvent(t);
                    callback.onResult(null, t);
                } else if (!responseExpected) {
                    commandEventSender.sendSucceededEventForOneWayCommand();
                    callback.onResult(null, null);
                } else {
                    InternalStreamConnection.this.readAsync(16, new MessageHeaderCallback(new SingleResultCallback<ResponseBuffers>() { // from class: com.mongodb.internal.connection.InternalStreamConnection.2.1
                        public void onResult(ResponseBuffers responseBuffers, Throwable t2) {
                            if (t2 != null) {
                                commandEventSender.sendFailedEvent(t2);
                                callback.onResult(null, t2);
                                return;
                            }
                            try {
                                InternalStreamConnection.this.updateSessionContext(sessionContext, responseBuffers);
                                boolean commandOk = ProtocolHelper.isCommandOk(new BsonBinaryReader(new ByteBufferBsonInput(responseBuffers.getBodyByteBuffer())));
                                responseBuffers.reset();
                                if (!commandOk) {
                                    MongoException commandFailureException = ProtocolHelper.getCommandFailureException(responseBuffers.getResponseDocument(messageId, new BsonDocumentCodec()), InternalStreamConnection.this.description.getServerAddress());
                                    commandEventSender.sendFailedEvent(commandFailureException);
                                    throw commandFailureException;
                                }
                                commandEventSender.sendSucceededEvent(responseBuffers);
                                callback.onResult(InternalStreamConnection.this.getCommandResult(decoder, responseBuffers, messageId), null);
                                responseBuffers.close();
                            } catch (Throwable th) {
                                responseBuffers.close();
                                throw th;
                            }
                        }
                    }));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public <T> T getCommandResult(Decoder<T> decoder, ResponseBuffers responseBuffers, int messageId) {
        T result = new ReplyMessage(responseBuffers, decoder, (long) messageId).getDocuments().get(0);
        MongoException writeConcernBasedError = ProtocolHelper.createSpecialWriteConcernException(responseBuffers, this.description.getServerAddress());
        if (writeConcernBasedError == null) {
            return result;
        }
        throw new MongoWriteConcernWithResponseException(writeConcernBasedError, result);
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void sendMessage(List<ByteBuf> byteBuffers, int lastRequestId) {
        Assertions.notNull("stream is open", this.stream);
        if (isClosed()) {
            throw new MongoSocketClosedException("Cannot write to a closed stream", getServerAddress());
        }
        try {
            this.stream.write(byteBuffers);
        } catch (Exception e) {
            close();
            throw translateWriteException(e);
        }
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public ResponseBuffers receiveMessage(int responseTo) {
        Assertions.notNull("stream is open", this.stream);
        if (!isClosed()) {
            return receiveMessageWithAdditionalTimeout(0);
        }
        throw new MongoSocketClosedException("Cannot read from a closed stream", getServerAddress());
    }

    private ResponseBuffers receiveMessageWithAdditionalTimeout(int additionalTimeout) {
        try {
            return receiveResponseBuffers(additionalTimeout);
        } catch (Throwable t) {
            close();
            throw translateReadException(t);
        }
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void sendMessageAsync(List<ByteBuf> byteBuffers, int lastRequestId, SingleResultCallback<Void> callback) {
        Assertions.notNull("stream is open", this.stream, callback);
        if (isClosed()) {
            callback.onResult(null, new MongoSocketClosedException("Can not read from a closed socket", getServerAddress()));
        } else {
            writeAsync(byteBuffers, ErrorHandlingResultCallback.errorHandlingCallback(callback, LOGGER));
        }
    }

    private void writeAsync(List<ByteBuf> byteBuffers, final SingleResultCallback<Void> callback) {
        this.stream.writeAsync(byteBuffers, new AsyncCompletionHandler<Void>() { // from class: com.mongodb.internal.connection.InternalStreamConnection.3
            public void completed(Void v) {
                callback.onResult(null, null);
            }

            @Override // com.mongodb.connection.AsyncCompletionHandler
            public void failed(Throwable t) {
                InternalStreamConnection.this.close();
                callback.onResult(null, InternalStreamConnection.this.translateWriteException(t));
            }
        });
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void receiveMessageAsync(int responseTo, final SingleResultCallback<ResponseBuffers> callback) {
        Assertions.isTrue("stream is open", this.stream != null, callback);
        if (isClosed()) {
            callback.onResult(null, new MongoSocketClosedException("Can not read from a closed socket", getServerAddress()));
            return;
        }
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(String.format("Start receiving response on %s", getId()));
        }
        readAsync(16, new MessageHeaderCallback(new SingleResultCallback<ResponseBuffers>() { // from class: com.mongodb.internal.connection.InternalStreamConnection.4
            public void onResult(ResponseBuffers result, Throwable t) {
                if (t != null) {
                    InternalStreamConnection.this.close();
                    callback.onResult(null, t);
                    return;
                }
                callback.onResult(result, null);
            }
        }));
    }

    /* access modifiers changed from: private */
    public void readAsync(int numBytes, final SingleResultCallback<ByteBuf> callback) {
        if (isClosed()) {
            callback.onResult(null, new MongoSocketClosedException("Cannot read from a closed stream", getServerAddress()));
            return;
        }
        try {
            this.stream.readAsync(numBytes, new AsyncCompletionHandler<ByteBuf>() { // from class: com.mongodb.internal.connection.InternalStreamConnection.5
                public void completed(ByteBuf buffer) {
                    callback.onResult(buffer, null);
                }

                @Override // com.mongodb.connection.AsyncCompletionHandler
                public void failed(Throwable t) {
                    InternalStreamConnection.this.close();
                    callback.onResult(null, InternalStreamConnection.this.translateReadException(t));
                }
            });
        } catch (Exception e) {
            callback.onResult(null, translateReadException(e));
        }
    }

    /* access modifiers changed from: private */
    public ConnectionId getId() {
        return this.description.getConnectionId();
    }

    private ServerAddress getServerAddress() {
        return this.description.getServerAddress();
    }

    /* access modifiers changed from: private */
    public void updateSessionContext(SessionContext sessionContext, ResponseBuffers responseBuffers) {
        BsonDocument recoveryToken;
        sessionContext.advanceOperationTime(ProtocolHelper.getOperationTime(responseBuffers));
        sessionContext.advanceClusterTime(ProtocolHelper.getClusterTime(responseBuffers));
        if (sessionContext.hasActiveTransaction() && (recoveryToken = ProtocolHelper.getRecoveryToken(responseBuffers)) != null) {
            sessionContext.setRecoveryToken(recoveryToken);
        }
    }

    /* access modifiers changed from: private */
    public MongoException translateWriteException(Throwable e) {
        if (e instanceof MongoException) {
            return (MongoException) e;
        }
        if (e instanceof IOException) {
            return new MongoSocketWriteException("Exception sending message", getServerAddress(), e);
        }
        if (e instanceof InterruptedException) {
            return new MongoInternalException("Thread interrupted exception", e);
        }
        return new MongoInternalException("Unexpected exception", e);
    }

    /* access modifiers changed from: private */
    public MongoException translateReadException(Throwable e) {
        if (e instanceof MongoException) {
            return (MongoException) e;
        }
        if (e instanceof SocketTimeoutException) {
            return new MongoSocketReadTimeoutException("Timeout while receiving message", getServerAddress(), e);
        }
        if (e instanceof InterruptedIOException) {
            return new MongoInterruptedException("Interrupted while receiving message", (InterruptedIOException) e);
        }
        if (e instanceof ClosedByInterruptException) {
            return new MongoInterruptedException("Interrupted while receiving message", (ClosedByInterruptException) e);
        }
        if (e instanceof IOException) {
            return new MongoSocketReadException("Exception receiving message", getServerAddress(), e);
        }
        if (e instanceof RuntimeException) {
            return new MongoInternalException("Unexpected runtime exception", e);
        }
        if (e instanceof InterruptedException) {
            return new MongoInternalException("Interrupted exception", e);
        }
        return new MongoInternalException("Unexpected exception", e);
    }

    private ResponseBuffers receiveResponseBuffers(int additionalTimeout) throws IOException {
        ByteBuf messageHeaderBuffer = this.stream.read(16, additionalTimeout);
        try {
            MessageHeader messageHeader = new MessageHeader(messageHeaderBuffer, this.description.getMaxMessageSize());
            messageHeaderBuffer.release();
            ByteBuf messageBuffer = this.stream.read(messageHeader.getMessageLength() - 16, additionalTimeout);
            if (messageHeader.getOpCode() != OpCode.OP_COMPRESSED.getValue()) {
                return new ResponseBuffers(new ReplyHeader(messageBuffer, messageHeader), messageBuffer);
            }
            CompressedHeader compressedHeader = new CompressedHeader(messageBuffer, messageHeader);
            Compressor compressor = getCompressor(compressedHeader);
            ByteBuf buffer = getBuffer(compressedHeader.getUncompressedSize());
            compressor.uncompress(messageBuffer, buffer);
            buffer.flip();
            return new ResponseBuffers(new ReplyHeader(buffer, compressedHeader), buffer);
        } catch (Throwable th) {
            messageHeaderBuffer.release();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public Compressor getCompressor(CompressedHeader compressedHeader) {
        Compressor compressor = this.compressorMap.get(Byte.valueOf(compressedHeader.getCompressorId()));
        if (compressor != null) {
            return compressor;
        }
        throw new MongoClientException("Unsupported compressor with identifier " + ((int) compressedHeader.getCompressorId()));
    }

    @Override // com.mongodb.connection.BufferProvider
    public ByteBuf getBuffer(int size) {
        Assertions.notNull("open", this.stream);
        return this.stream.getBuffer(size);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalStreamConnection$MessageHeaderCallback.class */
    public class MessageHeaderCallback implements SingleResultCallback<ByteBuf> {
        private final SingleResultCallback<ResponseBuffers> callback;

        MessageHeaderCallback(SingleResultCallback<ResponseBuffers> callback) {
            this.callback = callback;
        }

        public void onResult(ByteBuf result, Throwable t) {
            if (t != null) {
                this.callback.onResult(null, t);
                return;
            }
            try {
                MessageHeader messageHeader = new MessageHeader(result, InternalStreamConnection.this.description.getMaxMessageSize());
                InternalStreamConnection.this.readAsync(messageHeader.getMessageLength() - 16, new MessageCallback(messageHeader));
                if (result != null) {
                    result.release();
                }
            } catch (Throwable th) {
                if (result != null) {
                    result.release();
                }
                throw th;
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalStreamConnection$MessageHeaderCallback$MessageCallback.class */
        public class MessageCallback implements SingleResultCallback<ByteBuf> {
            private final MessageHeader messageHeader;

            MessageCallback(MessageHeader messageHeader) {
                this.messageHeader = messageHeader;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0079
                	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                */
            public void onResult(org.bson.ByteBuf r7, java.lang.Throwable r8) {
                /*
                    r6 = this;
                    r0 = r8
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback r0 = com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.this
                    com.mongodb.internal.async.SingleResultCallback r0 = com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.access$1400(r0)
                    r1 = 0
                    r2 = r8
                    r0.onResult(r1, r2)
                    return
                L_0x0013:
                    r0 = r6
                    com.mongodb.internal.connection.MessageHeader r0 = r0.messageHeader     // Catch: Throwable -> 0x00b1
                    int r0 = r0.getOpCode()     // Catch: Throwable -> 0x00b1
                    com.mongodb.internal.connection.OpCode r1 = com.mongodb.internal.connection.OpCode.OP_COMPRESSED     // Catch: Throwable -> 0x00b1
                    int r1 = r1.getValue()     // Catch: Throwable -> 0x00b1
                    if (r0 != r1) goto L_0x0087
                    com.mongodb.internal.connection.CompressedHeader r0 = new com.mongodb.internal.connection.CompressedHeader     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r1 = r0
                    r2 = r7
                    r3 = r6
                    com.mongodb.internal.connection.MessageHeader r3 = r3.messageHeader     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r1.<init>(r2, r3)     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r11 = r0
                    r0 = r6
                    com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback r0 = com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.this     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    com.mongodb.internal.connection.InternalStreamConnection r0 = com.mongodb.internal.connection.InternalStreamConnection.this     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r1 = r11
                    com.mongodb.internal.connection.Compressor r0 = com.mongodb.internal.connection.InternalStreamConnection.access$1500(r0, r1)     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r12 = r0
                    r0 = r6
                    com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback r0 = com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.this     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    com.mongodb.internal.connection.InternalStreamConnection r0 = com.mongodb.internal.connection.InternalStreamConnection.this     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r1 = r11
                    int r1 = r1.getUncompressedSize()     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    org.bson.ByteBuf r0 = r0.getBuffer(r1)     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r13 = r0
                    r0 = r12
                    r1 = r7
                    r2 = r13
                    r0.uncompress(r1, r2)     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r0 = r13
                    org.bson.ByteBuf r0 = r0.flip()     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    com.mongodb.internal.connection.ReplyHeader r0 = new com.mongodb.internal.connection.ReplyHeader     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r1 = r0
                    r2 = r13
                    r3 = r11
                    r1.<init>(r2, r3)     // Catch: Throwable -> 0x00b1, all -> 0x0079
                    r9 = r0
                    r0 = r13
                    r10 = r0
                    r0 = r7
                    r0.release()     // Catch: Throwable -> 0x00b1
                    goto L_0x0084
                L_0x0079:
                    r14 = move-exception
                    r0 = r7
                    r0.release()     // Catch: Throwable -> 0x00b1
                    r0 = r14
                    throw r0     // Catch: Throwable -> 0x00b1
                L_0x0084:
                    goto L_0x0097
                L_0x0087:
                    com.mongodb.internal.connection.ReplyHeader r0 = new com.mongodb.internal.connection.ReplyHeader     // Catch: Throwable -> 0x00b1
                    r1 = r0
                    r2 = r7
                    r3 = r6
                    com.mongodb.internal.connection.MessageHeader r3 = r3.messageHeader     // Catch: Throwable -> 0x00b1
                    r1.<init>(r2, r3)     // Catch: Throwable -> 0x00b1
                    r9 = r0
                    r0 = r7
                    r10 = r0
                L_0x0097:
                    r0 = r6
                    com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback r0 = com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.this     // Catch: Throwable -> 0x00b1
                    com.mongodb.internal.async.SingleResultCallback r0 = com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.access$1400(r0)     // Catch: Throwable -> 0x00b1
                    com.mongodb.internal.connection.ResponseBuffers r1 = new com.mongodb.internal.connection.ResponseBuffers     // Catch: Throwable -> 0x00b1
                    r2 = r1
                    r3 = r9
                    r4 = r10
                    r2.<init>(r3, r4)     // Catch: Throwable -> 0x00b1
                    r2 = 0
                    r0.onResult(r1, r2)     // Catch: Throwable -> 0x00b1
                    goto L_0x00c0
                L_0x00b1:
                    r9 = move-exception
                    r0 = r6
                    com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback r0 = com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.this
                    com.mongodb.internal.async.SingleResultCallback r0 = com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.access$1400(r0)
                    r1 = 0
                    r2 = r9
                    r0.onResult(r1, r2)
                L_0x00c0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.InternalStreamConnection.MessageHeaderCallback.MessageCallback.onResult(org.bson.ByteBuf, java.lang.Throwable):void");
            }
        }
    }

    private CommandEventSender createCommandEventSender(CommandMessage message, ByteBufferBsonOutput bsonOutput) {
        if (!opened() || (this.commandListener == null && !COMMAND_PROTOCOL_LOGGER.isDebugEnabled())) {
            return new NoOpCommandEventSender();
        }
        return new LoggingCommandEventSender(SECURITY_SENSITIVE_COMMANDS, this.description, this.commandListener, message, bsonOutput, COMMAND_PROTOCOL_LOGGER);
    }
}
