package org.bson.codecs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.Transformer;
import org.bson.UuidRepresentation;
import org.bson.assertions.Assertions;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/codecs/IterableCodec.class */
public class IterableCodec implements Codec<Iterable>, OverridableUuidRepresentationCodec<Iterable> {
    private final CodecRegistry registry;
    private final BsonTypeCodecMap bsonTypeCodecMap;
    private final Transformer valueTransformer;
    private final UuidRepresentation uuidRepresentation;

    public IterableCodec(CodecRegistry registry, BsonTypeClassMap bsonTypeClassMap) {
        this(registry, bsonTypeClassMap, null);
    }

    public IterableCodec(CodecRegistry registry, BsonTypeClassMap bsonTypeClassMap, Transformer valueTransformer) {
        this(registry, new BsonTypeCodecMap((BsonTypeClassMap) Assertions.notNull("bsonTypeClassMap", bsonTypeClassMap), registry), valueTransformer, UuidRepresentation.UNSPECIFIED);
    }

    private IterableCodec(CodecRegistry registry, BsonTypeCodecMap bsonTypeCodecMap, Transformer valueTransformer, UuidRepresentation uuidRepresentation) {
        this.registry = (CodecRegistry) Assertions.notNull("registry", registry);
        this.bsonTypeCodecMap = bsonTypeCodecMap;
        this.valueTransformer = valueTransformer != null ? valueTransformer : new Transformer() { // from class: org.bson.codecs.IterableCodec.1
            @Override // org.bson.Transformer
            public Object transform(Object objectToTransform) {
                return objectToTransform;
            }
        };
        this.uuidRepresentation = uuidRepresentation;
    }

    @Override // org.bson.codecs.OverridableUuidRepresentationCodec
    public Codec<Iterable> withUuidRepresentation(UuidRepresentation uuidRepresentation) {
        return new IterableCodec(this.registry, this.bsonTypeCodecMap, this.valueTransformer, uuidRepresentation);
    }

    @Override // org.bson.codecs.Decoder
    public Iterable decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readStartArray();
        List<Object> list = new ArrayList<>();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            list.add(readValue(reader, decoderContext));
        }
        reader.readEndArray();
        return list;
    }

    public void encode(BsonWriter writer, Iterable value, EncoderContext encoderContext) {
        writer.writeStartArray();
        for (Object cur : value) {
            writeValue(writer, encoderContext, cur);
        }
        writer.writeEndArray();
    }

    @Override // org.bson.codecs.Encoder
    public Class<Iterable> getEncoderClass() {
        return Iterable.class;
    }

    private void writeValue(BsonWriter writer, EncoderContext encoderContext, Object value) {
        if (value == null) {
            writer.writeNull();
        } else {
            encoderContext.encodeWithChildContext(this.registry.get(value.getClass()), writer, value);
        }
    }

    private Object readValue(BsonReader reader, DecoderContext decoderContext) {
        BsonType bsonType = reader.getCurrentBsonType();
        if (bsonType == BsonType.NULL) {
            reader.readNull();
            return null;
        }
        Codec<?> codec = this.bsonTypeCodecMap.get(bsonType);
        if (bsonType == BsonType.BINARY && reader.peekBinarySize() == 16) {
            switch (reader.peekBinarySubType()) {
                case 3:
                    if (this.uuidRepresentation == UuidRepresentation.JAVA_LEGACY || this.uuidRepresentation == UuidRepresentation.C_SHARP_LEGACY || this.uuidRepresentation == UuidRepresentation.PYTHON_LEGACY) {
                        codec = this.registry.get(UUID.class);
                        break;
                    }
                    break;
                case 4:
                    if (this.uuidRepresentation == UuidRepresentation.STANDARD) {
                        codec = this.registry.get(UUID.class);
                        break;
                    }
                    break;
            }
        }
        return this.valueTransformer.transform(codec.decode(reader, decoderContext));
    }
}
