package com.mongodb.internal.connection;

import com.mongodb.AuthenticationMechanism;
import com.mongodb.MongoException;
import com.mongodb.MongoSecurityException;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.operation.ServerVersionHelper;
import org.bson.BsonDocument;
import org.bson.BsonString;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultAuthenticator.class */
class DefaultAuthenticator extends Authenticator implements SpeculativeAuthenticator {
    static final int USER_NOT_FOUND_CODE = 11;
    private static final BsonString DEFAULT_MECHANISM_NAME = new BsonString(AuthenticationMechanism.SCRAM_SHA_256.getMechanismName());
    private Authenticator delegate;

    /* access modifiers changed from: package-private */
    public DefaultAuthenticator(MongoCredentialWithCache credential) {
        super(credential);
        Assertions.isTrueArgument("unspecified authentication mechanism", credential.getAuthenticationMechanism() == null);
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.internal.connection.Authenticator
    public void authenticate(InternalConnection connection, ConnectionDescription connectionDescription) {
        if (ServerVersionHelper.serverIsLessThanVersionFourDotZero(connectionDescription)) {
            getLegacyDefaultAuthenticator(connectionDescription).authenticate(connection, connectionDescription);
            return;
        }
        try {
            setDelegate(connectionDescription);
            this.delegate.authenticate(connection, connectionDescription);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.internal.connection.Authenticator
    public void authenticateAsync(InternalConnection connection, ConnectionDescription connectionDescription, SingleResultCallback<Void> callback) {
        if (ServerVersionHelper.serverIsLessThanVersionFourDotZero(connectionDescription)) {
            getLegacyDefaultAuthenticator(connectionDescription).authenticateAsync(connection, connectionDescription, callback);
            return;
        }
        setDelegate(connectionDescription);
        this.delegate.authenticateAsync(connection, connectionDescription, callback);
    }

    @Override // com.mongodb.internal.connection.SpeculativeAuthenticator
    public BsonDocument createSpeculativeAuthenticateCommand(InternalConnection connection) {
        this.delegate = getAuthenticatorForIsMaster();
        return ((SpeculativeAuthenticator) this.delegate).createSpeculativeAuthenticateCommand(connection);
    }

    @Override // com.mongodb.internal.connection.SpeculativeAuthenticator
    public BsonDocument getSpeculativeAuthenticateResponse() {
        if (this.delegate != null) {
            return ((SpeculativeAuthenticator) this.delegate).getSpeculativeAuthenticateResponse();
        }
        return null;
    }

    @Override // com.mongodb.internal.connection.SpeculativeAuthenticator
    public void setSpeculativeAuthenticateResponse(BsonDocument response) {
        ((SpeculativeAuthenticator) this.delegate).setSpeculativeAuthenticateResponse(response);
    }

    private Authenticator getLegacyDefaultAuthenticator(ConnectionDescription connectionDescription) {
        if (ServerVersionHelper.serverIsAtLeastVersionThreeDotZero(connectionDescription)) {
            return new ScramShaAuthenticator(getMongoCredentialWithCache().withMechanism(AuthenticationMechanism.SCRAM_SHA_1));
        }
        return new NativeAuthenticator(getMongoCredentialWithCache());
    }

    Authenticator getAuthenticatorForIsMaster() {
        return new ScramShaAuthenticator(getMongoCredentialWithCache().withMechanism(AuthenticationMechanism.SCRAM_SHA_256));
    }

    private void setDelegate(ConnectionDescription connectionDescription) {
        if (this.delegate != null && ((SpeculativeAuthenticator) this.delegate).getSpeculativeAuthenticateResponse() != null) {
            return;
        }
        if (connectionDescription.getSaslSupportedMechanisms() != null) {
            this.delegate = new ScramShaAuthenticator(getMongoCredentialWithCache().withMechanism(connectionDescription.getSaslSupportedMechanisms().contains(DEFAULT_MECHANISM_NAME) ? AuthenticationMechanism.SCRAM_SHA_256 : AuthenticationMechanism.SCRAM_SHA_1));
        } else {
            this.delegate = getLegacyDefaultAuthenticator(connectionDescription);
        }
    }

    private MongoException wrapException(Throwable t) {
        if (t instanceof MongoSecurityException) {
            return (MongoSecurityException) t;
        }
        if (!(t instanceof MongoException) || ((MongoException) t).getCode() != 11) {
            return MongoException.fromThrowable(t);
        }
        return new MongoSecurityException(getMongoCredential(), String.format("Exception authenticating %s", getMongoCredential()), t);
    }
}
