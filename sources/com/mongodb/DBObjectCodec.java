package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.bson.BSONObject;
import org.bson.BsonBinary;
import org.bson.BsonBinarySubType;
import org.bson.BsonDbPointer;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.UuidRepresentation;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.BsonTypeCodecMap;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.IdGenerator;
import org.bson.codecs.ObjectIdGenerator;
import org.bson.codecs.OverridableUuidRepresentationCodec;
import org.bson.codecs.ValueCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.BSONTimestamp;
import org.bson.types.Binary;
import org.bson.types.CodeWScope;
import org.bson.types.Symbol;

/* loaded from: grasscutter.jar:com/mongodb/DBObjectCodec.class */
public class DBObjectCodec implements CollectibleCodec<DBObject>, OverridableUuidRepresentationCodec<DBObject> {
    private static final BsonTypeClassMap DEFAULT_BSON_TYPE_CLASS_MAP = createDefaultBsonTypeClassMap();
    private static final CodecRegistry DEFAULT_REGISTRY = CodecRegistries.fromProviders(Arrays.asList(new ValueCodecProvider(), new BsonValueCodecProvider(), new DBObjectCodecProvider()));
    private static final String ID_FIELD_NAME = "_id";
    private final CodecRegistry codecRegistry;
    private final BsonTypeCodecMap bsonTypeCodecMap;
    private final DBObjectFactory objectFactory;
    private final IdGenerator idGenerator;
    private final UuidRepresentation uuidRepresentation;

    private static BsonTypeClassMap createDefaultBsonTypeClassMap() {
        Map<BsonType, Class<?>> replacements = new HashMap<>();
        replacements.put(BsonType.REGULAR_EXPRESSION, Pattern.class);
        replacements.put(BsonType.SYMBOL, String.class);
        replacements.put(BsonType.TIMESTAMP, BSONTimestamp.class);
        replacements.put(BsonType.JAVASCRIPT_WITH_SCOPE, null);
        replacements.put(BsonType.DOCUMENT, null);
        return new BsonTypeClassMap(replacements);
    }

    /* access modifiers changed from: package-private */
    public static BsonTypeClassMap getDefaultBsonTypeClassMap() {
        return DEFAULT_BSON_TYPE_CLASS_MAP;
    }

    /* access modifiers changed from: package-private */
    public static CodecRegistry getDefaultRegistry() {
        return DEFAULT_REGISTRY;
    }

    public DBObjectCodec() {
        this(DEFAULT_REGISTRY);
    }

    public DBObjectCodec(CodecRegistry codecRegistry) {
        this(codecRegistry, DEFAULT_BSON_TYPE_CLASS_MAP);
    }

    public DBObjectCodec(CodecRegistry codecRegistry, BsonTypeClassMap bsonTypeClassMap) {
        this(codecRegistry, bsonTypeClassMap, new BasicDBObjectFactory());
    }

    public DBObjectCodec(CodecRegistry codecRegistry, BsonTypeClassMap bsonTypeClassMap, DBObjectFactory objectFactory) {
        this(codecRegistry, new BsonTypeCodecMap((BsonTypeClassMap) Assertions.notNull("bsonTypeClassMap", bsonTypeClassMap), codecRegistry), objectFactory, UuidRepresentation.UNSPECIFIED);
    }

    private DBObjectCodec(CodecRegistry codecRegistry, BsonTypeCodecMap bsonTypeCodecMap, DBObjectFactory objectFactory, UuidRepresentation uuidRepresentation) {
        this.idGenerator = new ObjectIdGenerator();
        this.objectFactory = (DBObjectFactory) Assertions.notNull("objectFactory", objectFactory);
        this.codecRegistry = (CodecRegistry) Assertions.notNull("codecRegistry", codecRegistry);
        this.uuidRepresentation = (UuidRepresentation) Assertions.notNull("uuidRepresentation", uuidRepresentation);
        this.bsonTypeCodecMap = bsonTypeCodecMap;
    }

    public void encode(BsonWriter writer, DBObject document, EncoderContext encoderContext) {
        writer.writeStartDocument();
        beforeFields(writer, encoderContext, document);
        for (String key : document.keySet()) {
            if (!skipField(encoderContext, key)) {
                writer.writeName(key);
                writeValue(writer, encoderContext, document.get(key));
            }
        }
        writer.writeEndDocument();
    }

    @Override // org.bson.codecs.Decoder
    public DBObject decode(BsonReader reader, DecoderContext decoderContext) {
        return readDocument(reader, decoderContext, new ArrayList<>(10));
    }

    @Override // org.bson.codecs.Encoder
    public Class<DBObject> getEncoderClass() {
        return DBObject.class;
    }

    public boolean documentHasId(DBObject document) {
        return document.containsField("_id");
    }

    public BsonValue getDocumentId(DBObject document) {
        if (!documentHasId(document)) {
            throw new IllegalStateException("The document does not contain an _id");
        }
        Object id = document.get("_id");
        if (id instanceof BsonValue) {
            return (BsonValue) id;
        }
        BsonDocument idHoldingDocument = new BsonDocument();
        BsonWriter writer = new BsonDocumentWriter(idHoldingDocument);
        writer.writeStartDocument();
        writer.writeName("_id");
        writeValue(writer, EncoderContext.builder().build(), id);
        writer.writeEndDocument();
        return idHoldingDocument.get((Object) "_id");
    }

    public DBObject generateIdIfAbsentFromDocument(DBObject document) {
        if (!documentHasId(document)) {
            document.put("_id", this.idGenerator.generate());
        }
        return document;
    }

    @Override // org.bson.codecs.OverridableUuidRepresentationCodec
    public Codec<DBObject> withUuidRepresentation(UuidRepresentation uuidRepresentation) {
        return new DBObjectCodec(this.codecRegistry, this.bsonTypeCodecMap, this.objectFactory, uuidRepresentation);
    }

    private void beforeFields(BsonWriter bsonWriter, EncoderContext encoderContext, DBObject document) {
        if (encoderContext.isEncodingCollectibleDocument() && document.containsField("_id")) {
            bsonWriter.writeName("_id");
            writeValue(bsonWriter, encoderContext, document.get("_id"));
        }
    }

    private boolean skipField(EncoderContext encoderContext, String key) {
        return encoderContext.isEncodingCollectibleDocument() && key.equals("_id");
    }

    private void writeValue(BsonWriter bsonWriter, EncoderContext encoderContext, @Nullable Object value) {
        if (value == null) {
            bsonWriter.writeNull();
        } else if (value instanceof DBRef) {
            encodeDBRef(bsonWriter, (DBRef) value, encoderContext);
        } else if (value instanceof Map) {
            encodeMap(bsonWriter, (Map) value, encoderContext);
        } else if (value instanceof Iterable) {
            encodeIterable(bsonWriter, (Iterable) value, encoderContext);
        } else if (value instanceof BSONObject) {
            encodeBsonObject(bsonWriter, (BSONObject) value, encoderContext);
        } else if (value instanceof CodeWScope) {
            encodeCodeWScope(bsonWriter, (CodeWScope) value, encoderContext);
        } else if (value instanceof byte[]) {
            encodeByteArray(bsonWriter, (byte[]) value);
        } else if (value.getClass().isArray()) {
            encodeArray(bsonWriter, value, encoderContext);
        } else if (value instanceof Symbol) {
            bsonWriter.writeSymbol(((Symbol) value).getSymbol());
        } else {
            encoderContext.encodeWithChildContext(this.codecRegistry.get(value.getClass()), bsonWriter, value);
        }
    }

    private void encodeMap(BsonWriter bsonWriter, Map<String, Object> document, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        for (Map.Entry<String, Object> entry : document.entrySet()) {
            bsonWriter.writeName(entry.getKey());
            writeValue(bsonWriter, encoderContext.getChildContext(), entry.getValue());
        }
        bsonWriter.writeEndDocument();
    }

    private void encodeBsonObject(BsonWriter bsonWriter, BSONObject document, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        for (String key : document.keySet()) {
            bsonWriter.writeName(key);
            writeValue(bsonWriter, encoderContext.getChildContext(), document.get(key));
        }
        bsonWriter.writeEndDocument();
    }

    private void encodeByteArray(BsonWriter bsonWriter, byte[] value) {
        bsonWriter.writeBinaryData(new BsonBinary(value));
    }

    private void encodeArray(BsonWriter bsonWriter, Object value, EncoderContext encoderContext) {
        bsonWriter.writeStartArray();
        int size = Array.getLength(value);
        for (int i = 0; i < size; i++) {
            writeValue(bsonWriter, encoderContext.getChildContext(), Array.get(value, i));
        }
        bsonWriter.writeEndArray();
    }

    private void encodeDBRef(BsonWriter bsonWriter, DBRef dbRef, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        bsonWriter.writeString("$ref", dbRef.getCollectionName());
        bsonWriter.writeName("$id");
        writeValue(bsonWriter, encoderContext.getChildContext(), dbRef.getId());
        if (dbRef.getDatabaseName() != null) {
            bsonWriter.writeString("$db", dbRef.getDatabaseName());
        }
        bsonWriter.writeEndDocument();
    }

    private void encodeCodeWScope(BsonWriter bsonWriter, CodeWScope value, EncoderContext encoderContext) {
        bsonWriter.writeJavaScriptWithScope(value.getCode());
        encodeBsonObject(bsonWriter, value.getScope(), encoderContext.getChildContext());
    }

    private void encodeIterable(BsonWriter bsonWriter, Iterable iterable, EncoderContext encoderContext) {
        bsonWriter.writeStartArray();
        for (Object cur : iterable) {
            writeValue(bsonWriter, encoderContext.getChildContext(), cur);
        }
        bsonWriter.writeEndArray();
    }

    @Nullable
    private Object readValue(BsonReader reader, DecoderContext decoderContext, @Nullable String fieldName, List<String> path) {
        Object initialRetVal;
        BsonType bsonType = reader.getCurrentBsonType();
        if (bsonType.isContainer() && fieldName != null) {
            path.add(fieldName);
        }
        switch (bsonType) {
            case DOCUMENT:
                initialRetVal = verifyForDBRef(readDocument(reader, decoderContext, path));
                break;
            case ARRAY:
                initialRetVal = readArray(reader, decoderContext, path);
                break;
            case JAVASCRIPT_WITH_SCOPE:
                initialRetVal = readCodeWScope(reader, decoderContext, path);
                break;
            case DB_POINTER:
                BsonDbPointer dbPointer = reader.readDBPointer();
                initialRetVal = new DBRef(dbPointer.getNamespace(), dbPointer.getId());
                break;
            case BINARY:
                initialRetVal = readBinary(reader, decoderContext);
                break;
            case NULL:
                reader.readNull();
                initialRetVal = null;
                break;
            default:
                initialRetVal = this.bsonTypeCodecMap.get(bsonType).decode(reader, decoderContext);
                break;
        }
        if (bsonType.isContainer() && fieldName != null) {
            path.remove(fieldName);
        }
        return initialRetVal;
    }

    private Object readBinary(BsonReader reader, DecoderContext decoderContext) {
        Codec<?> codec;
        byte bsonBinarySubType = reader.peekBinarySubType();
        if (!BsonBinarySubType.isUuid(bsonBinarySubType) || reader.peekBinarySize() != 16) {
            codec = (bsonBinarySubType == BsonBinarySubType.BINARY.getValue() || bsonBinarySubType == BsonBinarySubType.OLD_BINARY.getValue()) ? this.codecRegistry.get(byte[].class) : this.codecRegistry.get(Binary.class);
        } else {
            codec = this.codecRegistry.get(Binary.class);
            switch (bsonBinarySubType) {
                case 3:
                    if (this.uuidRepresentation == UuidRepresentation.JAVA_LEGACY || this.uuidRepresentation == UuidRepresentation.C_SHARP_LEGACY || this.uuidRepresentation == UuidRepresentation.PYTHON_LEGACY) {
                        codec = this.codecRegistry.get(UUID.class);
                        break;
                    }
                    break;
                case 4:
                    if (this.uuidRepresentation == UuidRepresentation.STANDARD) {
                        codec = this.codecRegistry.get(UUID.class);
                        break;
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown UUID binary subtype " + ((int) bsonBinarySubType));
            }
        }
        return codec.decode(reader, decoderContext);
    }

    private List readArray(BsonReader reader, DecoderContext decoderContext, List<String> path) {
        reader.readStartArray();
        BasicDBList list = new BasicDBList();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            list.add(readValue(reader, decoderContext, null, path));
        }
        reader.readEndArray();
        return list;
    }

    private DBObject readDocument(BsonReader reader, DecoderContext decoderContext, List<String> path) {
        DBObject document = this.objectFactory.getInstance(path);
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String fieldName = reader.readName();
            document.put(fieldName, readValue(reader, decoderContext, fieldName, path));
        }
        reader.readEndDocument();
        return document;
    }

    private CodeWScope readCodeWScope(BsonReader reader, DecoderContext decoderContext, List<String> path) {
        return new CodeWScope(reader.readJavaScriptWithScope(), readDocument(reader, decoderContext, path));
    }

    private Object verifyForDBRef(DBObject document) {
        if (!document.containsField("$ref") || !document.containsField("$id")) {
            return document;
        }
        return new DBRef((String) document.get("$db"), (String) document.get("$ref"), document.get("$id"));
    }
}
