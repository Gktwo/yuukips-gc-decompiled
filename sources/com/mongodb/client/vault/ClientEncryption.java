package com.mongodb.client.vault;

import com.mongodb.client.model.vault.DataKeyOptions;
import com.mongodb.client.model.vault.EncryptOptions;
import java.io.Closeable;
import org.bson.BsonBinary;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/client/vault/ClientEncryption.class */
public interface ClientEncryption extends Closeable {
    BsonBinary createDataKey(String str);

    BsonBinary createDataKey(String str, DataKeyOptions dataKeyOptions);

    BsonBinary encrypt(BsonValue bsonValue, EncryptOptions encryptOptions);

    BsonValue decrypt(BsonBinary bsonBinary);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
