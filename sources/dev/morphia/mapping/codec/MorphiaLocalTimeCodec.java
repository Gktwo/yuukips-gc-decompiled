package dev.morphia.mapping.codec;

import java.time.LocalTime;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaLocalTimeCodec.class */
public class MorphiaLocalTimeCodec implements Codec<LocalTime> {
    private static final int MILLI_MODULO = 1000000;

    @Override // org.bson.codecs.Decoder
    public LocalTime decode(BsonReader reader, DecoderContext decoderContext) {
        return LocalTime.ofNanoOfDay(reader.readInt64() * 1000000);
    }

    public void encode(BsonWriter writer, LocalTime value, EncoderContext encoderContext) {
        writer.writeInt64(value.toNanoOfDay() / 1000000);
    }

    @Override // org.bson.codecs.Encoder
    public Class<LocalTime> getEncoderClass() {
        return LocalTime.class;
    }
}
