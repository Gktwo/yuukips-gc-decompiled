package com.mongodb.client.internal;

import com.mongodb.AutoEncryptionSettings;
import com.mongodb.ClientEncryptionSettings;
import com.mongodb.MongoClientException;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoNamespace;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.crypt.capi.MongoCrypts;
import com.mongodb.internal.capi.MongoCryptHelper;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/Crypts.class */
public final class Crypts {
    public static Crypt createCrypt(MongoClientImpl client, AutoEncryptionSettings options) {
        MongoClient internalClient = null;
        MongoClientSettings keyVaultMongoClientSettings = options.getKeyVaultMongoClientSettings();
        if (keyVaultMongoClientSettings == null || !options.isBypassAutoEncryption()) {
            internalClient = MongoClients.create(MongoClientSettings.builder(client.getSettings()).applyToConnectionPoolSettings(builder -> {
                builder.minSize(0);
            }).autoEncryptionSettings(null).build());
        }
        return new Crypt(MongoCrypts.create(MongoCryptHelper.createMongoCryptOptions(options.getKmsProviders(), options.getSchemaMap())), options.isBypassAutoEncryption() ? null : new CollectionInfoRetriever(internalClient), new CommandMarker(options.isBypassAutoEncryption(), options.getExtraOptions()), new KeyRetriever(keyVaultMongoClientSettings == null ? internalClient : MongoClients.create(keyVaultMongoClientSettings), new MongoNamespace(options.getKeyVaultNamespace())), createKeyManagementService(), options.isBypassAutoEncryption(), internalClient);
    }

    /* access modifiers changed from: package-private */
    public static Crypt create(MongoClient keyVaultClient, ClientEncryptionSettings options) {
        return new Crypt(MongoCrypts.create(MongoCryptHelper.createMongoCryptOptions(options.getKmsProviders(), null)), createKeyRetriever(keyVaultClient, options.getKeyVaultNamespace()), createKeyManagementService());
    }

    private static KeyRetriever createKeyRetriever(MongoClient keyVaultClient, String keyVaultNamespaceString) {
        return new KeyRetriever(keyVaultClient, new MongoNamespace(keyVaultNamespaceString));
    }

    private static KeyManagementService createKeyManagementService() {
        return new KeyManagementService(getSslContext(), PacketOpcodes.PersonalLineAllDataRsp, 10000);
    }

    private static SSLContext getSslContext() {
        try {
            return SSLContext.getDefault();
        } catch (NoSuchAlgorithmException e) {
            throw new MongoClientException("Unable to create default SSLContext", e);
        }
    }

    private Crypts() {
    }
}
