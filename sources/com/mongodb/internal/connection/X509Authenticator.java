package com.mongodb.internal.connection;

import com.mongodb.AuthenticationMechanism;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoSecurityException;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.operation.ServerVersionHelper;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/X509Authenticator.class */
public class X509Authenticator extends Authenticator implements SpeculativeAuthenticator {
    public static final Logger LOGGER = Loggers.getLogger("authenticator");
    private BsonDocument speculativeAuthenticateResponse;

    /* access modifiers changed from: package-private */
    public X509Authenticator(MongoCredentialWithCache credential) {
        super(credential);
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.internal.connection.Authenticator
    public void authenticate(InternalConnection connection, ConnectionDescription connectionDescription) {
        if (this.speculativeAuthenticateResponse == null) {
            try {
                validateUserName(connectionDescription);
                CommandHelper.executeCommand(getMongoCredential().getSource(), getAuthCommand(getMongoCredential().getUserName()), connection);
            } catch (MongoCommandException e) {
                throw new MongoSecurityException(getMongoCredential(), "Exception authenticating", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.internal.connection.Authenticator
    public void authenticateAsync(InternalConnection connection, ConnectionDescription connectionDescription, SingleResultCallback<Void> callback) {
        if (this.speculativeAuthenticateResponse != null) {
            callback.onResult(null, null);
            return;
        }
        final SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, LOGGER);
        try {
            validateUserName(connectionDescription);
            CommandHelper.executeCommandAsync(getMongoCredential().getSource(), getAuthCommand(getMongoCredential().getUserName()), connection, new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.connection.X509Authenticator.1
                public void onResult(BsonDocument nonceResult, Throwable t) {
                    if (t != null) {
                        errHandlingCallback.onResult(null, X509Authenticator.this.translateThrowable(t));
                    } else {
                        errHandlingCallback.onResult(null, null);
                    }
                }
            });
        } catch (Throwable t) {
            errHandlingCallback.onResult(null, t);
        }
    }

    @Override // com.mongodb.internal.connection.SpeculativeAuthenticator
    public BsonDocument createSpeculativeAuthenticateCommand(InternalConnection connection) {
        return getAuthCommand(getMongoCredential().getUserName()).append("db", new BsonString("$external"));
    }

    @Override // com.mongodb.internal.connection.SpeculativeAuthenticator
    public void setSpeculativeAuthenticateResponse(BsonDocument response) {
        this.speculativeAuthenticateResponse = response;
    }

    @Override // com.mongodb.internal.connection.SpeculativeAuthenticator
    public BsonDocument getSpeculativeAuthenticateResponse() {
        return this.speculativeAuthenticateResponse;
    }

    private BsonDocument getAuthCommand(String userName) {
        BsonDocument cmd = new BsonDocument();
        cmd.put("authenticate", (BsonValue) new BsonInt32(1));
        if (userName != null) {
            cmd.put("user", (BsonValue) new BsonString(userName));
        }
        cmd.put("mechanism", (BsonValue) new BsonString(AuthenticationMechanism.MONGODB_X509.getMechanismName()));
        return cmd;
    }

    /* access modifiers changed from: private */
    public Throwable translateThrowable(Throwable t) {
        if (t instanceof MongoCommandException) {
            return new MongoSecurityException(getMongoCredential(), "Exception authenticating", t);
        }
        return t;
    }

    private void validateUserName(ConnectionDescription connectionDescription) {
        if (getMongoCredential().getUserName() == null && ServerVersionHelper.serverIsLessThanVersionThreeDotFour(connectionDescription)) {
            throw new MongoSecurityException(getMongoCredential(), "User name is required for the MONGODB-X509 authentication mechanism on server versions less than 3.4");
        }
    }
}
