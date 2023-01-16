package org.bson.codecs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.BsonDocument;
import org.bson.BsonElement;
import org.bson.BsonObjectId;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.assertions.Assertions;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonDocumentCodec.class */
public class BsonDocumentCodec implements CollectibleCodec<BsonDocument> {
    private static final String ID_FIELD_NAME = "_id";
    private static final CodecRegistry DEFAULT_REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());
    private static final BsonTypeCodecMap DEFAULT_BSON_TYPE_CODEC_MAP = new BsonTypeCodecMap(BsonValueCodecProvider.getBsonTypeClassMap(), DEFAULT_REGISTRY);
    private final CodecRegistry codecRegistry;
    private final BsonTypeCodecMap bsonTypeCodecMap;

    public BsonDocumentCodec() {
        this(DEFAULT_REGISTRY, DEFAULT_BSON_TYPE_CODEC_MAP);
    }

    public BsonDocumentCodec(CodecRegistry codecRegistry) {
        this(codecRegistry, new BsonTypeCodecMap(BsonValueCodecProvider.getBsonTypeClassMap(), codecRegistry));
    }

    private BsonDocumentCodec(CodecRegistry codecRegistry, BsonTypeCodecMap bsonTypeCodecMap) {
        this.codecRegistry = (CodecRegistry) Assertions.notNull("Codec registry", codecRegistry);
        this.bsonTypeCodecMap = (BsonTypeCodecMap) Assertions.notNull("bsonTypeCodecMap", bsonTypeCodecMap);
    }

    public CodecRegistry getCodecRegistry() {
        return this.codecRegistry;
    }

    @Override // org.bson.codecs.Decoder
    public BsonDocument decode(BsonReader reader, DecoderContext decoderContext) {
        List<BsonElement> keyValuePairs = new ArrayList<>();
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            keyValuePairs.add(new BsonElement(reader.readName(), readValue(reader, decoderContext)));
        }
        reader.readEndDocument();
        return new BsonDocument(keyValuePairs);
    }

    /* access modifiers changed from: protected */
    public BsonValue readValue(BsonReader reader, DecoderContext decoderContext) {
        return (BsonValue) this.bsonTypeCodecMap.get(reader.getCurrentBsonType()).decode(reader, decoderContext);
    }

    public void encode(BsonWriter writer, BsonDocument value, EncoderContext encoderContext) {
        writer.writeStartDocument();
        beforeFields(writer, encoderContext, value);
        for (Map.Entry<String, BsonValue> entry : value.entrySet()) {
            if (!skipField(encoderContext, entry.getKey())) {
                writer.writeName(entry.getKey());
                writeValue(writer, encoderContext, entry.getValue());
            }
        }
        writer.writeEndDocument();
    }

    private void beforeFields(BsonWriter bsonWriter, EncoderContext encoderContext, BsonDocument value) {
        if (encoderContext.isEncodingCollectibleDocument() && value.containsKey("_id")) {
            bsonWriter.writeName("_id");
            writeValue(bsonWriter, encoderContext, value.get("_id"));
        }
    }

    private boolean skipField(EncoderContext encoderContext, String key) {
        return encoderContext.isEncodingCollectibleDocument() && key.equals("_id");
    }

    private void writeValue(BsonWriter writer, EncoderContext encoderContext, BsonValue value) {
        encoderContext.encodeWithChildContext(this.codecRegistry.get(value.getClass()), writer, value);
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonDocument> getEncoderClass() {
        return BsonDocument.class;
    }

    public BsonDocument generateIdIfAbsentFromDocument(BsonDocument document) {
        if (!documentHasId(document)) {
            document.put("_id", (BsonValue) new BsonObjectId(new ObjectId()));
        }
        return document;
    }

    public boolean documentHasId(BsonDocument document) {
        return document.containsKey("_id");
    }

    public BsonValue getDocumentId(BsonDocument document) {
        return document.get("_id");
    }
}
