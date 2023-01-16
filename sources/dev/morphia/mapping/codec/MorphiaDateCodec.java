package dev.morphia.mapping.codec;

import dev.morphia.mapping.Mapper;
import java.time.Instant;
import java.time.LocalDate;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaDateCodec.class */
public class MorphiaDateCodec implements Codec<LocalDate> {
    private final Mapper mapper;

    /* access modifiers changed from: package-private */
    public MorphiaDateCodec(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override // org.bson.codecs.Decoder
    public LocalDate decode(BsonReader reader, DecoderContext decoderContext) {
        return Instant.ofEpochMilli(reader.readDateTime()).atZone(this.mapper.getOptions().getDateStorage().getZone()).toLocalDate();
    }

    public void encode(BsonWriter writer, LocalDate value, EncoderContext encoderContext) {
        writer.writeDateTime(value.atStartOfDay(this.mapper.getOptions().getDateStorage().getZone()).toInstant().toEpochMilli());
    }

    @Override // org.bson.codecs.Encoder
    public Class<LocalDate> getEncoderClass() {
        return LocalDate.class;
    }
}
