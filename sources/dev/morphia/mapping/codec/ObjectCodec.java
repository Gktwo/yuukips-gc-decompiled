package dev.morphia.mapping.codec;

import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MappingException;
import org.bson.BsonReader;
import org.bson.BsonReaderMark;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/ObjectCodec.class */
public class ObjectCodec implements Codec<Object> {
    private final Mapper mapper;
    private final BsonTypeClassMap bsonTypeClassMap = new BsonTypeClassMap();

    public ObjectCodec(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override // org.bson.codecs.Decoder
    public Object decode(BsonReader reader, DecoderContext decoderContext) {
        Class<?> clazz;
        BsonType bsonType = reader.getCurrentBsonType();
        if (bsonType == BsonType.DOCUMENT) {
            clazz = Document.class;
            String discriminatorField = this.mapper.getOptions().getDiscriminatorKey();
            BsonReaderMark mark = reader.getMark();
            reader.readStartDocument();
            while (clazz.equals(Document.class) && reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                if (reader.readName().equals(discriminatorField)) {
                    try {
                        clazz = this.mapper.getClass(reader.readString());
                    } catch (CodecConfigurationException e) {
                        throw new MappingException(e.getMessage(), e);
                    }
                } else {
                    reader.skipValue();
                }
            }
            mark.reset();
        } else {
            clazz = this.bsonTypeClassMap.get(bsonType);
        }
        return this.mapper.getCodecRegistry().get(clazz).decode(reader, decoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public void encode(BsonWriter writer, Object value, EncoderContext encoderContext) {
        this.mapper.getCodecRegistry().get(value.getClass()).encode(writer, value, encoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Object> getEncoderClass() {
        return Object.class;
    }
}
