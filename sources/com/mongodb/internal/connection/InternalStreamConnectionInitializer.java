package com.mongodb.internal.connection;

import com.mongodb.MongoCompressor;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.MongoSecurityException;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ConnectionId;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerType;
import com.mongodb.internal.async.SingleResultCallback;
import dev.morphia.mapping.Mapper;
import java.util.List;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalStreamConnectionInitializer.class */
public class InternalStreamConnectionInitializer implements InternalConnectionInitializer {
    private Authenticator authenticator;
    private final BsonDocument clientMetadataDocument;
    private final List<MongoCompressor> requestedCompressors;
    private final boolean checkSaslSupportedMechs;

    public InternalStreamConnectionInitializer(Authenticator authenticator, BsonDocument clientMetadataDocument, List<MongoCompressor> requestedCompressors) {
        this.authenticator = authenticator;
        this.clientMetadataDocument = clientMetadataDocument;
        this.requestedCompressors = (List) Assertions.notNull("requestedCompressors", requestedCompressors);
        this.checkSaslSupportedMechs = authenticator instanceof DefaultAuthenticator;
    }

    @Override // com.mongodb.internal.connection.InternalConnectionInitializer
    public InternalConnectionInitializationDescription initialize(InternalConnection internalConnection) {
        Assertions.notNull("internalConnection", internalConnection);
        InternalConnectionInitializationDescription description = initializeConnectionDescription(internalConnection);
        authenticate(internalConnection, description.getConnectionDescription());
        return completeConnectionDescriptionInitialization(internalConnection, description);
    }

    @Override // com.mongodb.internal.connection.InternalConnectionInitializer
    public void initializeAsync(InternalConnection internalConnection, SingleResultCallback<InternalConnectionInitializationDescription> callback) {
        initializeConnectionDescriptionAsync(internalConnection, createConnectionDescriptionCallback(internalConnection, callback));
    }

    private SingleResultCallback<InternalConnectionInitializationDescription> createConnectionDescriptionCallback(final InternalConnection internalConnection, final SingleResultCallback<InternalConnectionInitializationDescription> callback) {
        return new SingleResultCallback<InternalConnectionInitializationDescription>() { // from class: com.mongodb.internal.connection.InternalStreamConnectionInitializer.1
            public void onResult(final InternalConnectionInitializationDescription description, Throwable t) {
                if (t != null) {
                    callback.onResult(null, t);
                } else if (InternalStreamConnectionInitializer.this.authenticator == null || description.getConnectionDescription().getServerType() == ServerType.REPLICA_SET_ARBITER) {
                    InternalStreamConnectionInitializer.this.completeConnectionDescriptionInitializationAsync(internalConnection, description, callback);
                } else {
                    InternalStreamConnectionInitializer.this.authenticator.authenticateAsync(internalConnection, description.getConnectionDescription(), new SingleResultCallback<Void>() { // from class: com.mongodb.internal.connection.InternalStreamConnectionInitializer.1.1
                        public void onResult(Void result1, Throwable t1) {
                            if (t1 != null) {
                                callback.onResult(null, t1);
                            } else {
                                InternalStreamConnectionInitializer.this.completeConnectionDescriptionInitializationAsync(internalConnection, description, callback);
                            }
                        }
                    });
                }
            }
        };
    }

    private InternalConnectionInitializationDescription initializeConnectionDescription(InternalConnection internalConnection) {
        BsonDocument isMasterCommandDocument = createIsMasterCommand(this.authenticator, internalConnection);
        long start = System.nanoTime();
        try {
            BsonDocument isMasterResult = CommandHelper.executeCommand("admin", isMasterCommandDocument, internalConnection);
            long elapsedTime = System.nanoTime() - start;
            ConnectionDescription connectionDescription = DescriptionHelper.createConnectionDescription(internalConnection.getDescription().getConnectionId(), isMasterResult);
            ServerDescription serverDescription = DescriptionHelper.createServerDescription(internalConnection.getDescription().getServerAddress(), isMasterResult, elapsedTime);
            setSpeculativeAuthenticateResponse(isMasterResult);
            return new InternalConnectionInitializationDescription(connectionDescription, serverDescription);
        } catch (MongoException e) {
            if (!this.checkSaslSupportedMechs || e.getCode() != 11) {
                throw e;
            }
            MongoCredential credential = this.authenticator.getMongoCredential();
            throw new MongoSecurityException(credential, String.format("Exception authenticating %s", credential), e);
        }
    }

    private BsonDocument createIsMasterCommand(Authenticator authenticator, InternalConnection connection) {
        BsonDocument speculativeAuthenticateDocument;
        BsonDocument isMasterCommandDocument = new BsonDocument("ismaster", new BsonInt32(1));
        if (this.clientMetadataDocument != null) {
            isMasterCommandDocument.append("client", this.clientMetadataDocument);
        }
        if (!this.requestedCompressors.isEmpty()) {
            BsonArray compressors = new BsonArray();
            for (MongoCompressor cur : this.requestedCompressors) {
                compressors.add((BsonValue) new BsonString(cur.getName()));
            }
            isMasterCommandDocument.append("compression", compressors);
        }
        if (this.checkSaslSupportedMechs) {
            MongoCredential credential = authenticator.getMongoCredential();
            isMasterCommandDocument.append("saslSupportedMechs", new BsonString(credential.getSource() + Mapper.IGNORED_FIELDNAME + credential.getUserName()));
        }
        if ((authenticator instanceof SpeculativeAuthenticator) && (speculativeAuthenticateDocument = ((SpeculativeAuthenticator) authenticator).createSpeculativeAuthenticateCommand(connection)) != null) {
            isMasterCommandDocument.append("speculativeAuthenticate", speculativeAuthenticateDocument);
        }
        return isMasterCommandDocument;
    }

    private InternalConnectionInitializationDescription completeConnectionDescriptionInitialization(InternalConnection internalConnection, InternalConnectionInitializationDescription description) {
        if (description.getConnectionDescription().getConnectionId().getServerValue() != null) {
            return description;
        }
        return applyGetLastErrorResult(CommandHelper.executeCommandWithoutCheckingForFailure("admin", new BsonDocument("getlasterror", new BsonInt32(1)), internalConnection), description);
    }

    private void authenticate(InternalConnection internalConnection, ConnectionDescription connectionDescription) {
        if (this.authenticator != null && connectionDescription.getServerType() != ServerType.REPLICA_SET_ARBITER) {
            this.authenticator.authenticate(internalConnection, connectionDescription);
        }
    }

    private void initializeConnectionDescriptionAsync(final InternalConnection internalConnection, final SingleResultCallback<InternalConnectionInitializationDescription> callback) {
        final long startTime = System.nanoTime();
        CommandHelper.executeCommandAsync("admin", createIsMasterCommand(this.authenticator, internalConnection), internalConnection, new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.connection.InternalStreamConnectionInitializer.2
            public void onResult(BsonDocument isMasterResult, Throwable t) {
                if (t == null) {
                    ConnectionDescription connectionDescription = DescriptionHelper.createConnectionDescription(internalConnection.getDescription().getConnectionId(), isMasterResult);
                    ServerDescription serverDescription = DescriptionHelper.createServerDescription(internalConnection.getDescription().getServerAddress(), isMasterResult, System.nanoTime() - startTime);
                    InternalStreamConnectionInitializer.this.setSpeculativeAuthenticateResponse(isMasterResult);
                    callback.onResult(new InternalConnectionInitializationDescription(connectionDescription, serverDescription), null);
                } else if (!InternalStreamConnectionInitializer.this.checkSaslSupportedMechs || !(t instanceof MongoException) || ((MongoException) t).getCode() != 11) {
                    callback.onResult(null, t);
                } else {
                    MongoCredential credential = InternalStreamConnectionInitializer.this.authenticator.getMongoCredential();
                    callback.onResult(null, new MongoSecurityException(credential, String.format("Exception authenticating %s", credential), t));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setSpeculativeAuthenticateResponse(BsonDocument isMasterResult) {
        if (this.authenticator instanceof SpeculativeAuthenticator) {
            ((SpeculativeAuthenticator) this.authenticator).setSpeculativeAuthenticateResponse(isMasterResult.getDocument("speculativeAuthenticate", null));
        }
    }

    /* access modifiers changed from: private */
    public void completeConnectionDescriptionInitializationAsync(InternalConnection internalConnection, final InternalConnectionInitializationDescription description, final SingleResultCallback<InternalConnectionInitializationDescription> callback) {
        if (description.getConnectionDescription().getConnectionId().getServerValue() != null) {
            callback.onResult(description, null);
        } else {
            CommandHelper.executeCommandAsync("admin", new BsonDocument("getlasterror", new BsonInt32(1)), internalConnection, new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.connection.InternalStreamConnectionInitializer.3
                public void onResult(BsonDocument result, Throwable t) {
                    if (t != null) {
                        callback.onResult(description, null);
                    } else {
                        callback.onResult(InternalStreamConnectionInitializer.this.applyGetLastErrorResult(result, description), null);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public InternalConnectionInitializationDescription applyGetLastErrorResult(BsonDocument getLastErrorResult, InternalConnectionInitializationDescription description) {
        ConnectionId connectionId;
        ConnectionDescription connectionDescription = description.getConnectionDescription();
        if (getLastErrorResult.containsKey("connectionId")) {
            connectionId = connectionDescription.getConnectionId().withServerValue(getLastErrorResult.getNumber("connectionId").intValue());
        } else {
            connectionId = connectionDescription.getConnectionId();
        }
        return description.withConnectionDescription(connectionDescription.withConnectionId(connectionId));
    }
}
