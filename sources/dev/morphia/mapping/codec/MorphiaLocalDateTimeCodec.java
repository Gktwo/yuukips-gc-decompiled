package dev.morphia.mapping.codec;

import dev.morphia.mapping.Mapper;
import java.time.Instant;
import java.time.LocalDateTime;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaLocalDateTimeCodec.class */
public class MorphiaLocalDateTimeCodec implements Codec<LocalDateTime> {
    private final Mapper mapper;

    /* access modifiers changed from: package-private */
    public MorphiaLocalDateTimeCodec(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override // org.bson.codecs.Decoder
    public LocalDateTime decode(BsonReader reader, DecoderContext decoderContext) {
        if (reader.getCurrentBsonType().equals(BsonType.INT64)) {
            return Instant.ofEpochMilli(reader.readInt64()).atZone(this.mapper.getOptions().getDateStorage().getZone()).toLocalDateTime();
        }
        return Instant.ofEpochMilli(reader.readDateTime()).atZone(this.mapper.getOptions().getDateStorage().getZone()).toLocalDateTime();
    }

    public void encode(BsonWriter writer, LocalDateTime value, EncoderContext encoderContext) {
        writer.writeDateTime(value.atZone(this.mapper.getOptions().getDateStorage().getZone()).toInstant().toEpochMilli());
    }

    @Override // org.bson.codecs.Encoder
    public Class<LocalDateTime> getEncoderClass() {
        return LocalDateTime.class;
    }
}
