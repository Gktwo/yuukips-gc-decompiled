package org.bson.codecs.pojo;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/EnumPropertyCodecProvider.class */
final class EnumPropertyCodecProvider implements PropertyCodecProvider {
    private final CodecRegistry codecRegistry;

    /* access modifiers changed from: package-private */
    public EnumPropertyCodecProvider(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @Override // org.bson.codecs.pojo.PropertyCodecProvider
    public <T> Codec<T> get(TypeWithTypeParameters<T> type, PropertyCodecRegistry propertyCodecRegistry) {
        Class<T> clazz = type.getType();
        if (!Enum.class.isAssignableFrom(clazz)) {
            return null;
        }
        try {
            return this.codecRegistry.get(clazz);
        } catch (CodecConfigurationException e) {
            return new EnumCodec(clazz);
        }
    }

    /* loaded from: grasscutter.jar:org/bson/codecs/pojo/EnumPropertyCodecProvider$EnumCodec.class */
    private static class EnumCodec<T extends Enum<T>> implements Codec<T> {
        private final Class<T> clazz;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: org.bson.codecs.pojo.EnumPropertyCodecProvider$EnumCodec<T extends java.lang.Enum<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.bson.codecs.Encoder
        public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Object obj, EncoderContext encoderContext) {
            encode(bsonWriter, (BsonWriter) ((Enum) obj), encoderContext);
        }

        EnumCodec(Class<T> clazz) {
            this.clazz = clazz;
        }

        public void encode(BsonWriter writer, T value, EncoderContext encoderContext) {
            writer.writeString(value.name());
        }

        @Override // org.bson.codecs.Encoder
        public Class<T> getEncoderClass() {
            return this.clazz;
        }

        @Override // org.bson.codecs.Decoder
        public T decode(BsonReader reader, DecoderContext decoderContext) {
            return (T) Enum.valueOf(this.clazz, reader.readString());
        }
    }
}
