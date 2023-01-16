package com.mongodb.client.gridfs.codecs;

import com.mongodb.DBCollection;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.lang.Nullable;
import java.util.Date;
import org.bson.BsonDateTime;
import org.bson.BsonDocument;
import org.bson.BsonDocumentReader;
import org.bson.BsonDocumentWrapper;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:com/mongodb/client/gridfs/codecs/GridFSFileCodec.class */
public final class GridFSFileCodec implements Codec<GridFSFile> {
    private final Codec<Document> documentCodec;
    private final Codec<BsonDocument> bsonDocumentCodec;

    public GridFSFileCodec(CodecRegistry registry) {
        this.documentCodec = (Codec) Assertions.notNull("DocumentCodec", ((CodecRegistry) Assertions.notNull("registry", registry)).get(Document.class));
        this.bsonDocumentCodec = (Codec) Assertions.notNull("BsonDocumentCodec", registry.get(BsonDocument.class));
    }

    @Override // org.bson.codecs.Decoder
    public GridFSFile decode(BsonReader reader, DecoderContext decoderContext) {
        BsonDocument bsonDocument = this.bsonDocumentCodec.decode(reader, decoderContext);
        return new GridFSFile(bsonDocument.get((Object) DBCollection.ID_FIELD_NAME), bsonDocument.get("filename", new BsonString("")).asString().getValue(), bsonDocument.getNumber("length").longValue(), bsonDocument.getNumber("chunkSize").intValue(), new Date(bsonDocument.getDateTime("uploadDate").getValue()), asDocumentOrNull(bsonDocument.getDocument("metadata", new BsonDocument())));
    }

    public void encode(BsonWriter writer, GridFSFile value, EncoderContext encoderContext) {
        BsonDocument bsonDocument = new BsonDocument();
        bsonDocument.put(DBCollection.ID_FIELD_NAME, value.getId());
        bsonDocument.put("filename", (BsonValue) new BsonString(value.getFilename()));
        bsonDocument.put("length", (BsonValue) new BsonInt64(value.getLength()));
        bsonDocument.put("chunkSize", (BsonValue) new BsonInt32(value.getChunkSize()));
        bsonDocument.put("uploadDate", (BsonValue) new BsonDateTime(value.getUploadDate().getTime()));
        Document metadata = value.getMetadata();
        if (metadata != null) {
            bsonDocument.put("metadata", (BsonValue) new BsonDocumentWrapper(metadata, this.documentCodec));
        }
        this.bsonDocumentCodec.encode(writer, bsonDocument, encoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public Class<GridFSFile> getEncoderClass() {
        return GridFSFile.class;
    }

    @Nullable
    private Document asDocumentOrNull(BsonDocument bsonDocument) {
        if (bsonDocument.isEmpty()) {
            return null;
        }
        return this.documentCodec.decode(new BsonDocumentReader(bsonDocument), DecoderContext.builder().build());
    }
}
