package dev.morphia.mapping.codec;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/TypedArrayCodec.class */
public class TypedArrayCodec implements Codec {
    private final Class type;
    private Codec codec;
    private final Mapper mapper;

    /* access modifiers changed from: package-private */
    public TypedArrayCodec(Class type, Mapper mapper) {
        this.type = type;
        this.mapper = mapper;
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
                getCodec().encode(writer, element, encoderContext);
            }
        }
        writer.writeEndArray();
    }

    @Override // org.bson.codecs.Encoder
    public Class getEncoderClass() {
        return Array.newInstance(this.type, 0).getClass();
    }

    private Codec getCodec() {
        if (this.codec == null) {
            this.codec = this.mapper.getCodecRegistry().get(this.type);
        }
        return this.codec;
    }

    @Override // org.bson.codecs.Decoder
    public Object decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readStartArray();
        List list = new ArrayList();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            list.add(getCodec().decode(reader, decoderContext));
        }
        reader.readEndArray();
        Object array = Array.newInstance(this.type, list.size());
        for (int i = 0; i < list.size(); i++) {
            Array.set(array, i, list.get(i));
        }
        return array;
    }

    public String toString() {
        return String.format("%s<%s>", getClass().getName(), this.type.getSimpleName());
    }
}
