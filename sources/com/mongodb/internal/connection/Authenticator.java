package com.mongodb.internal.connection;

import com.mongodb.MongoCredential;
import com.mongodb.MongoInternalException;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/Authenticator.class */
public abstract class Authenticator {
    private final MongoCredentialWithCache credential;

    /* access modifiers changed from: package-private */
    public abstract void authenticate(InternalConnection internalConnection, ConnectionDescription connectionDescription);

    /* access modifiers changed from: package-private */
    public abstract void authenticateAsync(InternalConnection internalConnection, ConnectionDescription connectionDescription, SingleResultCallback<Void> singleResultCallback);

    /* access modifiers changed from: package-private */
    public Authenticator(@NonNull MongoCredentialWithCache credential) {
        this.credential = credential;
    }

    @NonNull
    MongoCredentialWithCache getMongoCredentialWithCache() {
        return this.credential;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public MongoCredential getMongoCredential() {
        return this.credential.getCredential();
    }

    @NonNull
    String getUserNameNonNull() {
        String userName = this.credential.getCredential().getUserName();
        if (userName != null) {
            return userName;
        }
        throw new MongoInternalException("User name can not be null");
    }

    @NonNull
    char[] getPasswordNonNull() {
        char[] password = this.credential.getCredential().getPassword();
        if (password != null) {
            return password;
        }
        throw new MongoInternalException("Password can not be null");
    }

    @NonNull
    <T> T getNonNullMechanismProperty(String key, @Nullable T defaultValue) {
        T mechanismProperty = (T) this.credential.getCredential().getMechanismProperty(key, defaultValue);
        if (mechanismProperty != null) {
            return mechanismProperty;
        }
        throw new MongoInternalException("Mechanism property can not be null");
    }
}
