package com.mongodb.internal.connection;

import com.mongodb.assertions.Assertions;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import com.mongodb.internal.bulk.WriteRequestWithIndex;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.Codec;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SplittablePayload.class */
public final class SplittablePayload {
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());
    private final Type payloadType;
    private final List<WriteRequestWithIndex> writeRequestWithIndexes;
    private final WriteRequestEncoder writeRequestEncoder = new WriteRequestEncoder();
    private final Map<Integer, BsonValue> insertedIds = new HashMap();
    private int position = 0;

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/SplittablePayload$Type.class */
    public enum Type {
        INSERT,
        UPDATE,
        REPLACE,
        DELETE
    }

    public SplittablePayload(Type payloadType, List<WriteRequestWithIndex> writeRequestWithIndexes) {
        this.payloadType = (Type) Assertions.notNull("batchType", payloadType);
        this.writeRequestWithIndexes = (List) Assertions.notNull("writeRequests", writeRequestWithIndexes);
    }

    public Type getPayloadType() {
        return this.payloadType;
    }

    public String getPayloadName() {
        if (this.payloadType == Type.INSERT) {
            return "documents";
        }
        if (this.payloadType == Type.UPDATE || this.payloadType == Type.REPLACE) {
            return "updates";
        }
        return "deletes";
    }

    /* access modifiers changed from: package-private */
    public boolean hasPayload() {
        return this.writeRequestWithIndexes.size() > 0;
    }

    public int size() {
        return this.writeRequestWithIndexes.size();
    }

    public Map<Integer, BsonValue> getInsertedIds() {
        return this.insertedIds;
    }

    public List<BsonDocument> getPayload() {
        return (List) this.writeRequestWithIndexes.stream().map(wri -> {
            return new BsonDocumentWrapper(wri, this.writeRequestEncoder);
        }).collect(Collectors.toList());
    }

    public List<WriteRequestWithIndex> getWriteRequestWithIndexes() {
        return this.writeRequestWithIndexes;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean hasAnotherSplit() {
        return this.writeRequestWithIndexes.size() > this.position;
    }

    public SplittablePayload getNextSplit() {
        Assertions.isTrue("hasAnotherSplit", hasAnotherSplit());
        return new SplittablePayload(this.payloadType, this.writeRequestWithIndexes.subList(this.position, this.writeRequestWithIndexes.size()));
    }

    public boolean isEmpty() {
        return this.writeRequestWithIndexes.isEmpty();
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/SplittablePayload$WriteRequestEncoder.class */
    class WriteRequestEncoder implements Encoder<WriteRequestWithIndex> {
        WriteRequestEncoder() {
        }

        public void encode(BsonWriter writer, WriteRequestWithIndex writeRequestWithIndex, EncoderContext encoderContext) {
            if (writeRequestWithIndex.getType() == WriteRequest.Type.INSERT) {
                BsonDocument document = ((InsertRequest) writeRequestWithIndex.getWriteRequest()).getDocument();
                IdHoldingBsonWriter idHoldingBsonWriter = new IdHoldingBsonWriter(writer);
                SplittablePayload.getCodec(document).encode(idHoldingBsonWriter, document, EncoderContext.builder().isEncodingCollectibleDocument(true).build());
                SplittablePayload.this.insertedIds.put(Integer.valueOf(writeRequestWithIndex.getIndex()), idHoldingBsonWriter.getId());
            } else if (writeRequestWithIndex.getType() == WriteRequest.Type.UPDATE || writeRequestWithIndex.getType() == WriteRequest.Type.REPLACE) {
                UpdateRequest update = (UpdateRequest) writeRequestWithIndex.getWriteRequest();
                writer.writeStartDocument();
                writer.writeName("q");
                SplittablePayload.getCodec(update.getFilter()).encode(writer, update.getFilter(), EncoderContext.builder().build());
                BsonValue updateValue = update.getUpdateValue();
                if (!updateValue.isDocument() && !updateValue.isArray()) {
                    throw new IllegalArgumentException("Invalid BSON value for an update.");
                } else if (!updateValue.isArray() || !updateValue.asArray().isEmpty()) {
                    writer.writeName("u");
                    if (updateValue.isDocument()) {
                        FieldTrackingBsonWriter fieldTrackingBsonWriter = new FieldTrackingBsonWriter(writer);
                        SplittablePayload.getCodec(updateValue.asDocument()).encode(fieldTrackingBsonWriter, updateValue.asDocument(), EncoderContext.builder().build());
                        if (writeRequestWithIndex.getType() == WriteRequest.Type.UPDATE && !fieldTrackingBsonWriter.hasWrittenField()) {
                            throw new IllegalArgumentException("Invalid BSON document for an update. The document may not be empty.");
                        }
                    } else if (update.getType() == WriteRequest.Type.UPDATE && updateValue.isArray()) {
                        writer.writeStartArray();
                        Iterator<BsonValue> it = updateValue.asArray().iterator();
                        while (it.hasNext()) {
                            BsonValue cur = it.next();
                            SplittablePayload.getCodec(cur.asDocument()).encode(writer, cur.asDocument(), EncoderContext.builder().build());
                        }
                        writer.writeEndArray();
                    }
                    if (update.isMulti()) {
                        writer.writeBoolean("multi", update.isMulti());
                    }
                    if (update.isUpsert()) {
                        writer.writeBoolean("upsert", update.isUpsert());
                    }
                    if (update.getCollation() != null) {
                        writer.writeName("collation");
                        BsonDocument collation = update.getCollation().asDocument();
                        SplittablePayload.getCodec(collation).encode(writer, collation, EncoderContext.builder().build());
                    }
                    if (update.getArrayFilters() != null) {
                        writer.writeStartArray("arrayFilters");
                        for (BsonDocument cur2 : update.getArrayFilters()) {
                            SplittablePayload.getCodec(cur2).encode(writer, cur2, EncoderContext.builder().build());
                        }
                        writer.writeEndArray();
                    }
                    if (update.getHint() != null) {
                        writer.writeName("hint");
                        BsonDocument hint = update.getHint().toBsonDocument(BsonDocument.class, null);
                        SplittablePayload.getCodec(hint).encode(writer, hint, EncoderContext.builder().build());
                    } else if (update.getHintString() != null) {
                        writer.writeString("hint", update.getHintString());
                    }
                    writer.writeEndDocument();
                } else {
                    throw new IllegalArgumentException("Invalid pipeline for an update. The pipeline may not be empty.");
                }
            } else {
                DeleteRequest deleteRequest = (DeleteRequest) writeRequestWithIndex.getWriteRequest();
                writer.writeStartDocument();
                writer.writeName("q");
                SplittablePayload.getCodec(deleteRequest.getFilter()).encode(writer, deleteRequest.getFilter(), EncoderContext.builder().build());
                writer.writeInt32("limit", deleteRequest.isMulti() ? 0 : 1);
                if (deleteRequest.getCollation() != null) {
                    writer.writeName("collation");
                    BsonDocument collation2 = deleteRequest.getCollation().asDocument();
                    SplittablePayload.getCodec(collation2).encode(writer, collation2, EncoderContext.builder().build());
                }
                if (deleteRequest.getHint() != null) {
                    writer.writeName("hint");
                    BsonDocument hint2 = deleteRequest.getHint().toBsonDocument(BsonDocument.class, null);
                    SplittablePayload.getCodec(hint2).encode(writer, hint2, EncoderContext.builder().build());
                } else if (deleteRequest.getHintString() != null) {
                    writer.writeString("hint", deleteRequest.getHintString());
                }
                writer.writeEndDocument();
            }
        }

        @Override // org.bson.codecs.Encoder
        public Class<WriteRequestWithIndex> getEncoderClass() {
            return WriteRequestWithIndex.class;
        }
    }

    /* access modifiers changed from: private */
    public static Codec<BsonDocument> getCodec(BsonDocument document) {
        return REGISTRY.get(document.getClass());
    }
}
