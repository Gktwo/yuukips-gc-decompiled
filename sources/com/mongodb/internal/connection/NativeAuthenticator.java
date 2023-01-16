package com.mongodb.internal.connection;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoSecurityException;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.authentication.NativeAuthenticationHelper;
import org.bson.BsonDocument;
import org.bson.BsonString;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/NativeAuthenticator.class */
public class NativeAuthenticator extends Authenticator {
    public static final Logger LOGGER = Loggers.getLogger("authenticator");

    /* access modifiers changed from: package-private */
    public NativeAuthenticator(MongoCredentialWithCache credential) {
        super(credential);
    }

    @Override // com.mongodb.internal.connection.Authenticator
    public void authenticate(InternalConnection connection, ConnectionDescription connectionDescription) {
        try {
            CommandHelper.executeCommand(getMongoCredential().getSource(), NativeAuthenticationHelper.getAuthCommand(getUserNameNonNull(), getPasswordNonNull(), ((BsonString) CommandHelper.executeCommand(getMongoCredential().getSource(), NativeAuthenticationHelper.getNonceCommand(), connection).get((Object) "nonce")).getValue()), connection);
        } catch (MongoCommandException e) {
            throw new MongoSecurityException(getMongoCredential(), "Exception authenticating", e);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.internal.connection.Authenticator
    public void authenticateAsync(final InternalConnection connection, ConnectionDescription connectionDescription, SingleResultCallback<Void> callback) {
        final SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, LOGGER);
        CommandHelper.executeCommandAsync(getMongoCredential().getSource(), NativeAuthenticationHelper.getNonceCommand(), connection, new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.connection.NativeAuthenticator.1
            public void onResult(BsonDocument nonceResult, Throwable t) {
                if (t != null) {
                    errHandlingCallback.onResult(null, NativeAuthenticator.this.translateThrowable(t));
                } else {
                    CommandHelper.executeCommandAsync(NativeAuthenticator.this.getMongoCredential().getSource(), NativeAuthenticationHelper.getAuthCommand(NativeAuthenticator.this.getUserNameNonNull(), NativeAuthenticator.this.getPasswordNonNull(), ((BsonString) nonceResult.get("nonce")).getValue()), connection, new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.connection.NativeAuthenticator.1.1
                        public void onResult(BsonDocument result, Throwable t2) {
                            if (t2 != null) {
                                errHandlingCallback.onResult(null, NativeAuthenticator.this.translateThrowable(t2));
                            } else {
                                errHandlingCallback.onResult(null, null);
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public Throwable translateThrowable(Throwable t) {
        if (t instanceof MongoCommandException) {
            return new MongoSecurityException(getMongoCredential(), "Exception authenticating", t);
        }
        return t;
    }
}
