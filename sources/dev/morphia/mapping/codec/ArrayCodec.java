package dev.morphia.mapping.codec;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.Mapper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bson.BsonBinarySubType;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/ArrayCodec.class */
class ArrayCodec implements Codec<Object> {
    private final Class type;
    private final Mapper mapper;

    /* access modifiers changed from: package-private */
    public <T> ArrayCodec(Mapper mapper, Class type) {
        this.mapper = mapper;
        this.type = type;
    }

    @Override // org.bson.codecs.Encoder
    public void encode(BsonWriter writer, Object value, EncoderContext encoderContext) {
        writer.writeStartArray();
        int length = Array.getLength(value);
        for (int i = 0; i < length; i++) {
            Object element = Array.get(value, i);
            if (element == null) {
                writer.writeNull();
            } else {
                this.mapper.getCodecRegistry().get(element.getClass()).encode(writer, element, encoderContext);
            }
        }
        writer.writeEndArray();
    }

    @Override // org.bson.codecs.Encoder
    public Class<Object> getEncoderClass() {
        return null;
    }

    @Override // org.bson.codecs.Decoder
    public Object[] decode(BsonReader reader, DecoderContext decoderContext) {
        List<Object> list = new ArrayList<>();
        if (reader.getCurrentBsonType() == BsonType.ARRAY) {
            reader.readStartArray();
            while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                list.add(readValue(reader, decoderContext));
            }
            reader.readEndArray();
        } else {
            list.add(readValue(reader, decoderContext));
        }
        return list.toArray();
    }

    @Nullable
    private Object readValue(BsonReader reader, DecoderContext decoderContext) {
        BsonType bsonType = reader.getCurrentBsonType();
        if (bsonType == BsonType.NULL) {
            reader.readNull();
            return null;
        } else if (bsonType == BsonType.BINARY && BsonBinarySubType.isUuid(reader.peekBinarySubType()) && reader.peekBinarySize() == 16) {
            return this.mapper.getCodecRegistry().get(UUID.class).decode(reader, decoderContext);
        } else {
            return this.mapper.getCodecRegistry().get(this.type.getComponentType()).decode(reader, decoderContext);
        }
    }
}
