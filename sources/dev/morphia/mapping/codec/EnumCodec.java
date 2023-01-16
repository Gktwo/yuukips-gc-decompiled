package dev.morphia.mapping.codec;

import java.lang.Enum;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/EnumCodec.class */
public class EnumCodec<T extends Enum<T>> implements Codec<T> {
    private final Class<T> type;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: dev.morphia.mapping.codec.EnumCodec<T extends java.lang.Enum<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Object obj, EncoderContext encoderContext) {
        encode(bsonWriter, (BsonWriter) ((Enum) obj), encoderContext);
    }

    public EnumCodec(Class<T> type) {
        this.type = type;
    }

    public void encode(BsonWriter writer, T value, EncoderContext encoderContext) {
        writer.writeString(value.name());
    }

    @Override // org.bson.codecs.Decoder
    public T decode(BsonReader reader, DecoderContext decoderContext) {
        return (T) Enum.valueOf(this.type, reader.readString());
    }

    @Override // org.bson.codecs.Encoder
    public Class<T> getEncoderClass() {
        return this.type;
    }
}
