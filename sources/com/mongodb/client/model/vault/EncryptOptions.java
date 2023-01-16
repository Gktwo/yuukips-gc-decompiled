package com.mongodb.client.model.vault;

import com.mongodb.lang.Nullable;
import org.bson.BsonBinary;

/* loaded from: grasscutter.jar:com/mongodb/client/model/vault/EncryptOptions.class */
public class EncryptOptions {
    private BsonBinary keyId;
    private String keyAltName;
    private final String algorithm;

    public EncryptOptions(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    @Nullable
    public BsonBinary getKeyId() {
        return this.keyId;
    }

    @Nullable
    public String getKeyAltName() {
        return this.keyAltName;
    }

    public EncryptOptions keyId(BsonBinary keyId) {
        this.keyId = keyId;
        return this;
    }

    public EncryptOptions keyAltName(String keyAltName) {
        this.keyAltName = keyAltName;
        return this;
    }

    public String toString() {
        return "EncryptOptions{keyId=" + this.keyId + ", keyAltName=" + this.keyAltName + ", algorithm='" + this.algorithm + "'}";
    }
}
