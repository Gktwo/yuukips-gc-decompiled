package com.mongodb.client.vault;

import com.mongodb.ClientEncryptionSettings;
import com.mongodb.client.internal.ClientEncryptionImpl;

/* loaded from: grasscutter.jar:com/mongodb/client/vault/ClientEncryptions.class */
public final class ClientEncryptions {
    public static ClientEncryption create(ClientEncryptionSettings options) {
        return new ClientEncryptionImpl(options);
    }

    private ClientEncryptions() {
    }
}
