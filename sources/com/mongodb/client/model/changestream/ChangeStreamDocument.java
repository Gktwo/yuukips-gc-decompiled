package com.mongodb.client.model.changestream;

import com.mongodb.MongoNamespace;
import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonTimestamp;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;

/* loaded from: grasscutter.jar:com/mongodb/client/model/changestream/ChangeStreamDocument.class */
public final class ChangeStreamDocument<TDocument> {
    @BsonId
    private final BsonDocument resumeToken;
    private final BsonDocument namespaceDocument;
    private final BsonDocument destinationNamespaceDocument;
    private final TDocument fullDocument;
    private final BsonDocument documentKey;
    private final BsonTimestamp clusterTime;
    private final OperationType operationType;
    private final UpdateDescription updateDescription;
    private final BsonInt64 txnNumber;
    private final BsonDocument lsid;

    @BsonCreator
    public ChangeStreamDocument(@BsonProperty("operationType") OperationType operationType, @BsonProperty("resumeToken") BsonDocument resumeToken, @Nullable @BsonProperty("ns") BsonDocument namespaceDocument, @Nullable @BsonProperty("to") BsonDocument destinationNamespaceDocument, @Nullable @BsonProperty("fullDocument") TDocument fullDocument, @Nullable @BsonProperty("documentKey") BsonDocument documentKey, @Nullable @BsonProperty("clusterTime") BsonTimestamp clusterTime, @Nullable @BsonProperty("updateDescription") UpdateDescription updateDescription, @Nullable @BsonProperty("txnNumber") BsonInt64 txnNumber, @Nullable @BsonProperty("lsid") BsonDocument lsid) {
        this.resumeToken = resumeToken;
        this.namespaceDocument = namespaceDocument;
        this.destinationNamespaceDocument = destinationNamespaceDocument;
        this.documentKey = documentKey;
        this.fullDocument = fullDocument;
        this.clusterTime = clusterTime;
        this.operationType = operationType;
        this.updateDescription = updateDescription;
        this.txnNumber = txnNumber;
        this.lsid = lsid;
    }

    private static BsonDocument namespaceToDocument(MongoNamespace namespace) {
        Assertions.notNull("namespace", namespace);
        return new BsonDocument("db", new BsonString(namespace.getDatabaseName())).append("coll", new BsonString(namespace.getCollectionName()));
    }

    public BsonDocument getResumeToken() {
        return this.resumeToken;
    }

    @Nullable
    @BsonIgnore
    public MongoNamespace getNamespace() {
        if (this.namespaceDocument != null && this.namespaceDocument.containsKey("db") && this.namespaceDocument.containsKey("coll")) {
            return new MongoNamespace(this.namespaceDocument.getString("db").getValue(), this.namespaceDocument.getString("coll").getValue());
        }
        return null;
    }

    @Nullable
    @BsonProperty("ns")
    public BsonDocument getNamespaceDocument() {
        return this.namespaceDocument;
    }

    @Nullable
    @BsonIgnore
    public MongoNamespace getDestinationNamespace() {
        if (this.destinationNamespaceDocument == null) {
            return null;
        }
        return new MongoNamespace(this.destinationNamespaceDocument.getString("db").getValue(), this.destinationNamespaceDocument.getString("coll").getValue());
    }

    @Nullable
    @BsonProperty("to")
    public BsonDocument getDestinationNamespaceDocument() {
        return this.destinationNamespaceDocument;
    }

    @Nullable
    @BsonIgnore
    public String getDatabaseName() {
        if (this.namespaceDocument != null && this.namespaceDocument.containsKey("db")) {
            return this.namespaceDocument.getString("db").getValue();
        }
        return null;
    }

    @Nullable
    public TDocument getFullDocument() {
        return this.fullDocument;
    }

    @Nullable
    public BsonDocument getDocumentKey() {
        return this.documentKey;
    }

    @Nullable
    public BsonTimestamp getClusterTime() {
        return this.clusterTime;
    }

    public OperationType getOperationType() {
        return this.operationType;
    }

    @Nullable
    public UpdateDescription getUpdateDescription() {
        return this.updateDescription;
    }

    @Nullable
    public BsonInt64 getTxnNumber() {
        return this.txnNumber;
    }

    @Nullable
    public BsonDocument getLsid() {
        return this.lsid;
    }

    public static <TFullDocument> Codec<ChangeStreamDocument<TFullDocument>> createCodec(Class<TFullDocument> fullDocumentClass, CodecRegistry codecRegistry) {
        return new ChangeStreamDocumentCodec(fullDocumentClass, codecRegistry);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChangeStreamDocument<?> that = (ChangeStreamDocument) o;
        if (this.resumeToken != null) {
            if (!this.resumeToken.equals(that.resumeToken)) {
                return false;
            }
        } else if (that.resumeToken != null) {
            return false;
        }
        if (this.namespaceDocument != null) {
            if (!this.namespaceDocument.equals(that.namespaceDocument)) {
                return false;
            }
        } else if (that.namespaceDocument != null) {
            return false;
        }
        if (this.destinationNamespaceDocument != null) {
            if (!this.destinationNamespaceDocument.equals(that.destinationNamespaceDocument)) {
                return false;
            }
        } else if (that.destinationNamespaceDocument != null) {
            return false;
        }
        if (this.fullDocument != null) {
            if (!this.fullDocument.equals(that.fullDocument)) {
                return false;
            }
        } else if (that.fullDocument != null) {
            return false;
        }
        if (this.documentKey != null) {
            if (!this.documentKey.equals(that.documentKey)) {
                return false;
            }
        } else if (that.documentKey != null) {
            return false;
        }
        if (this.clusterTime != null) {
            if (!this.clusterTime.equals(that.clusterTime)) {
                return false;
            }
        } else if (that.clusterTime != null) {
            return false;
        }
        if (this.operationType != that.operationType) {
            return false;
        }
        if (this.updateDescription != null) {
            if (!this.updateDescription.equals(that.updateDescription)) {
                return false;
            }
        } else if (that.updateDescription != null) {
            return false;
        }
        if (this.txnNumber != null) {
            if (!this.txnNumber.equals(that.txnNumber)) {
                return false;
            }
        } else if (that.txnNumber != null) {
            return false;
        }
        if (this.lsid != null) {
            if (!this.lsid.equals(that.lsid)) {
                return false;
            }
            return true;
        } else if (that.lsid != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * (this.resumeToken != null ? this.resumeToken.hashCode() : 0)) + (this.namespaceDocument != null ? this.namespaceDocument.hashCode() : 0))) + (this.destinationNamespaceDocument != null ? this.destinationNamespaceDocument.hashCode() : 0))) + (this.fullDocument != null ? this.fullDocument.hashCode() : 0))) + (this.documentKey != null ? this.documentKey.hashCode() : 0))) + (this.clusterTime != null ? this.clusterTime.hashCode() : 0))) + (this.operationType != null ? this.operationType.hashCode() : 0))) + (this.updateDescription != null ? this.updateDescription.hashCode() : 0))) + (this.txnNumber != null ? this.txnNumber.hashCode() : 0))) + (this.lsid != null ? this.lsid.hashCode() : 0);
    }

    public String toString() {
        return "ChangeStreamDocument{ operationType=" + this.operationType + ", resumeToken=" + this.resumeToken + ", namespace=" + getNamespace() + ", destinationNamespace=" + getDestinationNamespace() + ", fullDocument=" + this.fullDocument + ", documentKey=" + this.documentKey + ", clusterTime=" + this.clusterTime + ", updateDescription=" + this.updateDescription + ", txnNumber=" + this.txnNumber + ", lsid=" + this.lsid + "}";
    }
}
