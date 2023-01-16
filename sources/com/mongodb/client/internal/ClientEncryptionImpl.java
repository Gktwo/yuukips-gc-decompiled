package com.mongodb.client.internal;

import com.mongodb.ClientEncryptionSettings;
import com.mongodb.DBCollection;
import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.vault.DataKeyOptions;
import com.mongodb.client.model.vault.EncryptOptions;
import com.mongodb.client.vault.ClientEncryption;
import java.io.Closeable;
import org.bson.BsonBinary;
import org.bson.BsonDocument;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/ClientEncryptionImpl.class */
public class ClientEncryptionImpl implements ClientEncryption, Closeable {
    private final Crypt crypt;
    private final ClientEncryptionSettings options;
    private final MongoClient keyVaultClient;

    public ClientEncryptionImpl(ClientEncryptionSettings options) {
        this.keyVaultClient = MongoClients.create(options.getKeyVaultMongoClientSettings());
        this.crypt = Crypts.create(this.keyVaultClient, options);
        this.options = options;
    }

    @Override // com.mongodb.client.vault.ClientEncryption
    public BsonBinary createDataKey(String kmsProvider) {
        return createDataKey(kmsProvider, new DataKeyOptions());
    }

    @Override // com.mongodb.client.vault.ClientEncryption
    public BsonBinary createDataKey(String kmsProvider, DataKeyOptions dataKeyOptions) {
        BsonDocument dataKeyDocument = this.crypt.createDataKey(kmsProvider, dataKeyOptions);
        MongoNamespace namespace = new MongoNamespace(this.options.getKeyVaultNamespace());
        this.keyVaultClient.getDatabase(namespace.getDatabaseName()).getCollection(namespace.getCollectionName(), BsonDocument.class).withWriteConcern(WriteConcern.MAJORITY).insertOne(dataKeyDocument);
        return dataKeyDocument.getBinary(DBCollection.ID_FIELD_NAME);
    }

    @Override // com.mongodb.client.vault.ClientEncryption
    public BsonBinary encrypt(BsonValue value, EncryptOptions options) {
        return this.crypt.encryptExplicitly(value, options);
    }

    @Override // com.mongodb.client.vault.ClientEncryption
    public BsonValue decrypt(BsonBinary value) {
        return this.crypt.decryptExplicitly(value);
    }

    @Override // com.mongodb.client.vault.ClientEncryption, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.crypt.close();
        this.keyVaultClient.close();
    }
}
