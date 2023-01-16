package com.mongodb.internal.connection;

import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.MongoInterruptedException;
import com.mongodb.MongoSecurityException;
import com.mongodb.ServerAddress;
import com.mongodb.SubjectProvider;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import java.security.PrivilegedAction;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import org.bson.BsonBinary;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SaslAuthenticator.class */
public abstract class SaslAuthenticator extends Authenticator implements SpeculativeAuthenticator {
    public static final Logger LOGGER = Loggers.getLogger("authenticator");
    private static final String SUBJECT_PROVIDER_CACHE_KEY = "SUBJECT_PROVIDER";

    public abstract String getMechanismName();

    protected abstract SaslClient createSaslClient(ServerAddress serverAddress);

    /* access modifiers changed from: package-private */
    public SaslAuthenticator(MongoCredentialWithCache credential) {
        super(credential);
    }

    @Override // com.mongodb.internal.connection.Authenticator
    public void authenticate(final InternalConnection connection, ConnectionDescription connectionDescription) {
        doAsSubject(new PrivilegedAction<Void>() { // from class: com.mongodb.internal.connection.SaslAuthenticator.1
            @Override // java.security.PrivilegedAction
            public Void run() {
                SaslClient saslClient;
                try {
                    saslClient = SaslAuthenticator.this.createSaslClient(connection.getDescription().getServerAddress());
                    SaslAuthenticator.this.throwIfSaslClientIsNull(saslClient);
                    try {
                        BsonDocument responseDocument = SaslAuthenticator.this.getNextSaslResponse(saslClient, connection);
                        BsonInt32 conversationId = responseDocument.getInt32("conversationId");
                        while (!responseDocument.getBoolean("done").getValue()) {
                            byte[] response = saslClient.evaluateChallenge(responseDocument.getBinary("payload").getData());
                            if (response == null) {
                                throw new MongoSecurityException(SaslAuthenticator.this.getMongoCredential(), "SASL protocol error: no client response to challenge for credential " + SaslAuthenticator.this.getMongoCredential());
                            }
                            responseDocument = SaslAuthenticator.this.sendSaslContinue(conversationId, response, connection);
                        }
                        if (!saslClient.isComplete()) {
                            saslClient.evaluateChallenge(responseDocument.getBinary("payload").getData());
                            if (!saslClient.isComplete()) {
                                throw new MongoSecurityException(SaslAuthenticator.this.getMongoCredential(), "SASL protocol error: server completed challenges before client completed responses " + SaslAuthenticator.this.getMongoCredential());
                            }
                        }
                        return null;
                    } catch (Exception e) {
                        throw SaslAuthenticator.this.wrapException(e);
                    }
                } finally {
                    SaslAuthenticator.this.disposeOfSaslClient(saslClient);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.internal.connection.Authenticator
    public void authenticateAsync(final InternalConnection connection, ConnectionDescription connectionDescription, final SingleResultCallback<Void> callback) {
        try {
            doAsSubject(new PrivilegedAction<Void>() { // from class: com.mongodb.internal.connection.SaslAuthenticator.2
                @Override // java.security.PrivilegedAction
                public Void run() {
                    SaslClient saslClient = SaslAuthenticator.this.createSaslClient(connection.getDescription().getServerAddress());
                    SaslAuthenticator.this.throwIfSaslClientIsNull(saslClient);
                    SaslAuthenticator.this.getNextSaslResponseAsync(saslClient, connection, callback);
                    return null;
                }
            });
        } catch (Throwable t) {
            callback.onResult(null, t);
        }
    }

    protected void appendSaslStartOptions(BsonDocument saslStartCommand) {
    }

    /* access modifiers changed from: private */
    public void throwIfSaslClientIsNull(SaslClient saslClient) {
        if (saslClient == null) {
            throw new MongoSecurityException(getMongoCredential(), String.format("This JDK does not support the %s SASL mechanism", getMechanismName()));
        }
    }

    /* access modifiers changed from: private */
    public BsonDocument getNextSaslResponse(SaslClient saslClient, InternalConnection connection) {
        BsonDocument response = getSpeculativeAuthenticateResponse();
        if (response != null) {
            return response;
        }
        try {
            return sendSaslStart(saslClient.hasInitialResponse() ? saslClient.evaluateChallenge(new byte[0]) : null, connection);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /* access modifiers changed from: private */
    public void getNextSaslResponseAsync(final SaslClient saslClient, final InternalConnection connection, SingleResultCallback<Void> callback) {
        BsonDocument response = getSpeculativeAuthenticateResponse();
        final SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, LOGGER);
        try {
            if (response == null) {
                sendSaslStartAsync(saslClient.hasInitialResponse() ? saslClient.evaluateChallenge(new byte[0]) : null, connection, new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.connection.SaslAuthenticator.3
                    public void onResult(BsonDocument result, Throwable t) {
                        if (t != null) {
                            errHandlingCallback.onResult(null, SaslAuthenticator.this.wrapException(t));
                        } else if (result.getBoolean("done").getValue()) {
                            SaslAuthenticator.this.verifySaslClientComplete(saslClient, result, errHandlingCallback);
                        } else {
                            new Continuator(saslClient, result, connection, errHandlingCallback).start();
                        }
                    }
                });
            } else if (response.getBoolean("done").getValue()) {
                verifySaslClientComplete(saslClient, response, errHandlingCallback);
            } else {
                new Continuator(saslClient, response, connection, errHandlingCallback).start();
            }
        } catch (Exception e) {
            callback.onResult(null, wrapException(e));
        }
    }

    /* access modifiers changed from: private */
    public void verifySaslClientComplete(SaslClient saslClient, BsonDocument result, SingleResultCallback<Void> callback) {
        if (saslClient.isComplete()) {
            callback.onResult(null, null);
            return;
        }
        try {
            saslClient.evaluateChallenge(result.getBinary("payload").getData());
            if (saslClient.isComplete()) {
                callback.onResult(null, null);
            } else {
                callback.onResult(null, new MongoSecurityException(getMongoCredential(), "SASL protocol error: server completed challenges before client completed responses " + getMongoCredential()));
            }
        } catch (SaslException e) {
            callback.onResult(null, wrapException(e));
        }
    }

    @Nullable
    protected Subject getSubject() {
        Subject subject = (Subject) getMongoCredential().getMechanismProperty(MongoCredential.JAVA_SUBJECT_KEY, null);
        if (subject != null) {
            return subject;
        }
        try {
            return getSubjectProvider().getSubject();
        } catch (LoginException e) {
            throw new MongoSecurityException(getMongoCredential(), "Failed to login Subject", e);
        }
    }

    @NonNull
    private SubjectProvider getSubjectProvider() {
        SubjectProvider subjectProvider;
        synchronized (getMongoCredentialWithCache()) {
            subjectProvider = (SubjectProvider) getMongoCredentialWithCache().getFromCache(SUBJECT_PROVIDER_CACHE_KEY, SubjectProvider.class);
            if (subjectProvider == null) {
                subjectProvider = (SubjectProvider) getMongoCredential().getMechanismProperty(MongoCredential.JAVA_SUBJECT_PROVIDER_KEY, null);
                if (subjectProvider == null) {
                    subjectProvider = getDefaultSubjectProvider();
                }
                getMongoCredentialWithCache().putInCache(SUBJECT_PROVIDER_CACHE_KEY, subjectProvider);
            }
        }
        return subjectProvider;
    }

    @NonNull
    protected SubjectProvider getDefaultSubjectProvider() {
        return () -> {
            return null;
        };
    }

    private BsonDocument sendSaslStart(byte[] outToken, InternalConnection connection) {
        BsonDocument startDocument = createSaslStartCommandDocument(outToken);
        appendSaslStartOptions(startDocument);
        return CommandHelper.executeCommand(getMongoCredential().getSource(), startDocument, connection);
    }

    /* access modifiers changed from: private */
    public BsonDocument sendSaslContinue(BsonInt32 conversationId, byte[] outToken, InternalConnection connection) {
        return CommandHelper.executeCommand(getMongoCredential().getSource(), createSaslContinueDocument(conversationId, outToken), connection);
    }

    private void sendSaslStartAsync(byte[] outToken, InternalConnection connection, SingleResultCallback<BsonDocument> callback) {
        BsonDocument startDocument = createSaslStartCommandDocument(outToken);
        appendSaslStartOptions(startDocument);
        CommandHelper.executeCommandAsync(getMongoCredential().getSource(), startDocument, connection, callback);
    }

    /* access modifiers changed from: private */
    public void sendSaslContinueAsync(BsonInt32 conversationId, byte[] outToken, InternalConnection connection, SingleResultCallback<BsonDocument> callback) {
        CommandHelper.executeCommandAsync(getMongoCredential().getSource(), createSaslContinueDocument(conversationId, outToken), connection, callback);
    }

    protected BsonDocument createSaslStartCommandDocument(byte[] outToken) {
        return new BsonDocument("saslStart", new BsonInt32(1)).append("mechanism", new BsonString(getMechanismName())).append("payload", new BsonBinary(outToken != null ? outToken : new byte[0]));
    }

    private BsonDocument createSaslContinueDocument(BsonInt32 conversationId, byte[] outToken) {
        return new BsonDocument("saslContinue", new BsonInt32(1)).append("conversationId", conversationId).append("payload", new BsonBinary(outToken));
    }

    /* access modifiers changed from: private */
    public void disposeOfSaslClient(SaslClient saslClient) {
        try {
            saslClient.dispose();
        } catch (SaslException e) {
        }
    }

    protected MongoException wrapException(Throwable t) {
        if (t instanceof MongoInterruptedException) {
            return (MongoInterruptedException) t;
        }
        if (t instanceof MongoSecurityException) {
            return (MongoSecurityException) t;
        }
        return new MongoSecurityException(getMongoCredential(), "Exception authenticating " + getMongoCredential(), t);
    }

    void doAsSubject(PrivilegedAction<Void> action) {
        Subject subject = getSubject();
        if (subject == null) {
            action.run();
        } else {
            Subject.doAs(subject, action);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/SaslAuthenticator$Continuator.class */
    public final class Continuator implements SingleResultCallback<BsonDocument> {
        private final SaslClient saslClient;
        private final BsonDocument saslStartDocument;
        private final InternalConnection connection;
        private final SingleResultCallback<Void> callback;

        Continuator(SaslClient saslClient, BsonDocument saslStartDocument, InternalConnection connection, SingleResultCallback<Void> callback) {
            this.saslClient = saslClient;
            this.saslStartDocument = saslStartDocument;
            this.connection = connection;
            this.callback = callback;
        }

        public void onResult(BsonDocument result, Throwable t) {
            if (t != null) {
                this.callback.onResult(null, SaslAuthenticator.this.wrapException(t));
                SaslAuthenticator.this.disposeOfSaslClient(this.saslClient);
            } else if (result.getBoolean("done").getValue()) {
                SaslAuthenticator.this.verifySaslClientComplete(this.saslClient, result, this.callback);
                SaslAuthenticator.this.disposeOfSaslClient(this.saslClient);
            } else {
                continueConversation(result);
            }
        }

        public void start() {
            continueConversation(this.saslStartDocument);
        }

        private void continueConversation(final BsonDocument result) {
            try {
                SaslAuthenticator.this.doAsSubject(new PrivilegedAction<Void>() { // from class: com.mongodb.internal.connection.SaslAuthenticator.Continuator.1
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        try {
                            SaslAuthenticator.this.sendSaslContinueAsync(Continuator.this.saslStartDocument.getInt32("conversationId"), Continuator.this.saslClient.evaluateChallenge(result.getBinary("payload").getData()), Continuator.this.connection, Continuator.this);
                            return null;
                        } catch (SaslException e) {
                            throw SaslAuthenticator.this.wrapException(e);
                        }
                    }
                });
            } catch (Throwable t) {
                this.callback.onResult(null, t);
                SaslAuthenticator.this.disposeOfSaslClient(this.saslClient);
            }
        }
    }
}
