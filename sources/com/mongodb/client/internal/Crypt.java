package com.mongodb.client.internal;

import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.vault.DataKeyOptions;
import com.mongodb.crypt.capi.MongoCrypt;
import com.mongodb.crypt.capi.MongoCryptContext;
import com.mongodb.crypt.capi.MongoCryptException;
import com.mongodb.crypt.capi.MongoDataKeyOptions;
import com.mongodb.crypt.capi.MongoKeyDecryptor;
import com.mongodb.lang.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.bson.BsonDocument;
import org.bson.RawBsonDocument;
import org.quartz.jobs.NativeJob;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/Crypt.class */
public class Crypt implements Closeable {
    private final MongoCrypt mongoCrypt;
    private final CollectionInfoRetriever collectionInfoRetriever;
    private final CommandMarker commandMarker;
    private final KeyRetriever keyRetriever;
    private final KeyManagementService keyManagementService;
    private final boolean bypassAutoEncryption;
    private final MongoClient internalClient;

    /* access modifiers changed from: package-private */
    public Crypt(MongoCrypt mongoCrypt, KeyRetriever keyRetriever, KeyManagementService keyManagementService) {
        this(mongoCrypt, null, null, keyRetriever, keyManagementService, false, null);
    }

    /* access modifiers changed from: package-private */
    public Crypt(MongoCrypt mongoCrypt, @Nullable CollectionInfoRetriever collectionInfoRetriever, @Nullable CommandMarker commandMarker, KeyRetriever keyRetriever, KeyManagementService keyManagementService, boolean bypassAutoEncryption, @Nullable MongoClient internalClient) {
        this.mongoCrypt = mongoCrypt;
        this.collectionInfoRetriever = collectionInfoRetriever;
        this.commandMarker = commandMarker;
        this.keyRetriever = keyRetriever;
        this.keyManagementService = keyManagementService;
        this.bypassAutoEncryption = bypassAutoEncryption;
        this.internalClient = internalClient;
    }

    public RawBsonDocument encrypt(String databaseName, RawBsonDocument command) {
        Assertions.notNull("databaseName", databaseName);
        Assertions.notNull(NativeJob.PROP_COMMAND, command);
        if (this.bypassAutoEncryption) {
            return command;
        }
        try {
            MongoCryptContext encryptionContext = this.mongoCrypt.createEncryptionContext(databaseName, command);
            RawBsonDocument executeStateMachine = executeStateMachine(encryptionContext, databaseName);
            encryptionContext.close();
            return executeStateMachine;
        } catch (MongoCryptException e) {
            throw wrapInClientException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public RawBsonDocument decrypt(RawBsonDocument commandResponse) {
        Assertions.notNull("commandResponse", commandResponse);
        try {
            MongoCryptContext decryptionContext = this.mongoCrypt.createDecryptionContext(commandResponse);
            RawBsonDocument executeStateMachine = executeStateMachine(decryptionContext, null);
            decryptionContext.close();
            return executeStateMachine;
        } catch (MongoCryptException e) {
            throw wrapInClientException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public BsonDocument createDataKey(String kmsProvider, DataKeyOptions options) {
        Assertions.notNull("kmsProvider", kmsProvider);
        Assertions.notNull("options", options);
        try {
            MongoCryptContext dataKeyCreationContext = this.mongoCrypt.createDataKeyContext(kmsProvider, MongoDataKeyOptions.builder().keyAltNames(options.getKeyAltNames()).masterKey(options.getMasterKey()).build());
            RawBsonDocument executeStateMachine = executeStateMachine(dataKeyCreationContext, null);
            dataKeyCreationContext.close();
            return executeStateMachine;
        } catch (MongoCryptException e) {
            throw wrapInClientException(e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x006a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    org.bson.BsonBinary encryptExplicitly(org.bson.BsonValue r7, com.mongodb.client.model.vault.EncryptOptions r8) {
        /*
            r6 = this;
            java.lang.String r0 = "value"
            r1 = r7
            java.lang.Object r0 = com.mongodb.assertions.Assertions.notNull(r0, r1)
            java.lang.String r0 = "options"
            r1 = r8
            java.lang.Object r0 = com.mongodb.assertions.Assertions.notNull(r0, r1)
            com.mongodb.crypt.capi.MongoExplicitEncryptOptions$Builder r0 = com.mongodb.crypt.capi.MongoExplicitEncryptOptions.builder()     // Catch: MongoCryptException -> 0x0076
            r1 = r8
            java.lang.String r1 = r1.getAlgorithm()     // Catch: MongoCryptException -> 0x0076
            com.mongodb.crypt.capi.MongoExplicitEncryptOptions$Builder r0 = r0.algorithm(r1)     // Catch: MongoCryptException -> 0x0076
            r9 = r0
            r0 = r8
            org.bson.BsonBinary r0 = r0.getKeyId()     // Catch: MongoCryptException -> 0x0076
            if (r0 == 0) goto L_0x0029
            r0 = r9
            r1 = r8
            org.bson.BsonBinary r1 = r1.getKeyId()     // Catch: MongoCryptException -> 0x0076
            com.mongodb.crypt.capi.MongoExplicitEncryptOptions$Builder r0 = r0.keyId(r1)     // Catch: MongoCryptException -> 0x0076
        L_0x0029:
            r0 = r8
            java.lang.String r0 = r0.getKeyAltName()     // Catch: MongoCryptException -> 0x0076
            if (r0 == 0) goto L_0x0039
            r0 = r9
            r1 = r8
            java.lang.String r1 = r1.getKeyAltName()     // Catch: MongoCryptException -> 0x0076
            com.mongodb.crypt.capi.MongoExplicitEncryptOptions$Builder r0 = r0.keyAltName(r1)     // Catch: MongoCryptException -> 0x0076
        L_0x0039:
            r0 = r6
            com.mongodb.crypt.capi.MongoCrypt r0 = r0.mongoCrypt     // Catch: MongoCryptException -> 0x0076
            org.bson.BsonDocument r1 = new org.bson.BsonDocument     // Catch: MongoCryptException -> 0x0076
            r2 = r1
            java.lang.String r3 = "v"
            r4 = r7
            r2.<init>(r3, r4)     // Catch: MongoCryptException -> 0x0076
            r2 = r9
            com.mongodb.crypt.capi.MongoExplicitEncryptOptions r2 = r2.build()     // Catch: MongoCryptException -> 0x0076
            com.mongodb.crypt.capi.MongoCryptContext r0 = r0.createExplicitEncryptionContext(r1, r2)     // Catch: MongoCryptException -> 0x0076
            r10 = r0
            r0 = r6
            r1 = r10
            r2 = 0
            org.bson.RawBsonDocument r0 = r0.executeStateMachine(r1, r2)     // Catch: all -> 0x006a, MongoCryptException -> 0x0076
            java.lang.String r1 = "v"
            org.bson.BsonBinary r0 = r0.getBinary(r1)     // Catch: all -> 0x006a, MongoCryptException -> 0x0076
            r11 = r0
            r0 = r10
            r0.close()     // Catch: MongoCryptException -> 0x0076
            r0 = r11
            return r0
        L_0x006a:
            r12 = move-exception
            r0 = r10
            r0.close()     // Catch: MongoCryptException -> 0x0076
            r0 = r12
            throw r0     // Catch: MongoCryptException -> 0x0076
        L_0x0076:
            r9 = move-exception
            r0 = r6
            r1 = r9
            com.mongodb.MongoClientException r0 = r0.wrapInClientException(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.client.internal.Crypt.encryptExplicitly(org.bson.BsonValue, com.mongodb.client.model.vault.EncryptOptions):org.bson.BsonBinary");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x002f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    org.bson.BsonValue decryptExplicitly(org.bson.BsonBinary r7) {
        /*
            r6 = this;
            java.lang.String r0 = "value"
            r1 = r7
            java.lang.Object r0 = com.mongodb.assertions.Assertions.notNull(r0, r1)
            r0 = r6
            com.mongodb.crypt.capi.MongoCrypt r0 = r0.mongoCrypt     // Catch: MongoCryptException -> 0x003a
            org.bson.BsonDocument r1 = new org.bson.BsonDocument     // Catch: MongoCryptException -> 0x003a
            r2 = r1
            java.lang.String r3 = "v"
            r4 = r7
            r2.<init>(r3, r4)     // Catch: MongoCryptException -> 0x003a
            com.mongodb.crypt.capi.MongoCryptContext r0 = r0.createExplicitDecryptionContext(r1)     // Catch: MongoCryptException -> 0x003a
            r8 = r0
            r0 = r6
            r1 = r8
            r2 = 0
            org.bson.RawBsonDocument r0 = r0.executeStateMachine(r1, r2)     // Catch: all -> 0x002f, MongoCryptException -> 0x003a
            java.lang.String r1 = "v"
            org.bson.BsonValue r0 = r0.get(r1)     // Catch: all -> 0x002f, MongoCryptException -> 0x003a
            r9 = r0
            r0 = r8
            r0.close()     // Catch: MongoCryptException -> 0x003a
            r0 = r9
            return r0
        L_0x002f:
            r10 = move-exception
            r0 = r8
            r0.close()     // Catch: MongoCryptException -> 0x003a
            r0 = r10
            throw r0     // Catch: MongoCryptException -> 0x003a
        L_0x003a:
            r8 = move-exception
            r0 = r6
            r1 = r8
            com.mongodb.MongoClientException r0 = r0.wrapInClientException(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.client.internal.Crypt.decryptExplicitly(org.bson.BsonBinary):org.bson.BsonValue");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MongoCrypt mongoCrypt = this.mongoCrypt;
        try {
            CommandMarker commandMarker = this.commandMarker;
            MongoClient internalClient = this.internalClient;
            if (internalClient != null) {
                internalClient.close();
            }
            if (commandMarker != null) {
                commandMarker.close();
            }
            if (mongoCrypt != null) {
                mongoCrypt.close();
            }
        } catch (Throwable th) {
            if (mongoCrypt != null) {
                try {
                    mongoCrypt.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mongodb.client.internal.Crypt$1 */
    /* loaded from: grasscutter.jar:com/mongodb/client/internal/Crypt$1.class */
    public static /* synthetic */ class C09881 {
        static final /* synthetic */ int[] $SwitchMap$com$mongodb$crypt$capi$MongoCryptContext$State = new int[MongoCryptContext.State.values().length];

        static {
            try {
                $SwitchMap$com$mongodb$crypt$capi$MongoCryptContext$State[MongoCryptContext.State.NEED_MONGO_COLLINFO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mongodb$crypt$capi$MongoCryptContext$State[MongoCryptContext.State.NEED_MONGO_MARKINGS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mongodb$crypt$capi$MongoCryptContext$State[MongoCryptContext.State.NEED_MONGO_KEYS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mongodb$crypt$capi$MongoCryptContext$State[MongoCryptContext.State.NEED_KMS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mongodb$crypt$capi$MongoCryptContext$State[MongoCryptContext.State.READY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private RawBsonDocument executeStateMachine(MongoCryptContext cryptContext, String databaseName) {
        while (true) {
            MongoCryptContext.State state = cryptContext.getState();
            switch (C09881.$SwitchMap$com$mongodb$crypt$capi$MongoCryptContext$State[state.ordinal()]) {
                case 1:
                    collInfo(cryptContext, databaseName);
                    break;
                case 2:
                    mark(cryptContext, databaseName);
                    break;
                case 3:
                    fetchKeys(cryptContext);
                    break;
                case 4:
                    decryptKeys(cryptContext);
                    break;
                case 5:
                    return cryptContext.finish();
                default:
                    throw new MongoInternalException("Unsupported encryptor state + " + state);
            }
        }
    }

    private void collInfo(MongoCryptContext cryptContext, String databaseName) {
        try {
            BsonDocument collectionInfo = this.collectionInfoRetriever.filter(databaseName, cryptContext.getMongoOperation());
            if (collectionInfo != null) {
                cryptContext.addMongoOperationResult(collectionInfo);
            }
            cryptContext.completeMongoOperation();
        } catch (Throwable t) {
            throw MongoException.fromThrowableNonNull(t);
        }
    }

    private void mark(MongoCryptContext cryptContext, String databaseName) {
        try {
            cryptContext.addMongoOperationResult(this.commandMarker.mark(databaseName, cryptContext.getMongoOperation()));
            cryptContext.completeMongoOperation();
        } catch (Throwable t) {
            throw wrapInClientException(t);
        }
    }

    private void fetchKeys(MongoCryptContext keyBroker) {
        try {
            for (BsonDocument bsonDocument : this.keyRetriever.find(keyBroker.getMongoOperation())) {
                keyBroker.addMongoOperationResult(bsonDocument);
            }
            keyBroker.completeMongoOperation();
        } catch (Throwable t) {
            throw MongoException.fromThrowableNonNull(t);
        }
    }

    private void decryptKeys(MongoCryptContext cryptContext) {
        try {
            MongoKeyDecryptor keyDecryptor = cryptContext.nextKeyDecryptor();
            while (keyDecryptor != null) {
                decryptKey(keyDecryptor);
                keyDecryptor = cryptContext.nextKeyDecryptor();
            }
            cryptContext.completeKeyDecryptors();
        } catch (Throwable t) {
            throw wrapInClientException(t);
        }
    }

    private void decryptKey(MongoKeyDecryptor keyDecryptor) throws IOException {
        InputStream inputStream = this.keyManagementService.stream(keyDecryptor.getHostName(), keyDecryptor.getMessage());
        try {
            int bytesNeeded = keyDecryptor.bytesNeeded();
            while (bytesNeeded > 0) {
                byte[] bytes = new byte[bytesNeeded];
                keyDecryptor.feed(ByteBuffer.wrap(bytes, 0, inputStream.read(bytes, 0, bytes.length)));
                bytesNeeded = keyDecryptor.bytesNeeded();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e2) {
            }
            throw th;
        }
    }

    private MongoClientException wrapInClientException(Throwable t) {
        return new MongoClientException("Exception in encryption library: " + t.getMessage(), t);
    }
}
