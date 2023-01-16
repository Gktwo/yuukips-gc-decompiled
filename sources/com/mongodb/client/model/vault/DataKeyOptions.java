package com.mongodb.client.model.vault;

import java.util.List;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/client/model/vault/DataKeyOptions.class */
public class DataKeyOptions {
    private List<String> keyAltNames;
    private BsonDocument masterKey;

    public DataKeyOptions keyAltNames(List<String> keyAltNames) {
        this.keyAltNames = keyAltNames;
        return this;
    }

    public DataKeyOptions masterKey(BsonDocument masterKey) {
        this.masterKey = masterKey;
        return this;
    }

    public List<String> getKeyAltNames() {
        return this.keyAltNames;
    }

    public BsonDocument getMasterKey() {
        return this.masterKey;
    }

    public String toString() {
        return "DataKeyOptions{keyAltNames=" + this.keyAltNames + ", masterKey=" + this.masterKey + '}';
    }
}
