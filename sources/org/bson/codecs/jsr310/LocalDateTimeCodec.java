package org.bson.codecs.jsr310;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;

/* loaded from: grasscutter.jar:org/bson/codecs/jsr310/LocalDateTimeCodec.class */
public class LocalDateTimeCodec extends DateTimeBasedCodec<LocalDateTime> {
    @Override // org.bson.codecs.Decoder
    public LocalDateTime decode(BsonReader reader, DecoderContext decoderContext) {
        return Instant.ofEpochMilli(validateAndReadDateTime(reader)).atZone(ZoneOffset.UTC).toLocalDateTime();
    }

    public void encode(BsonWriter writer, LocalDateTime value, EncoderContext encoderContext) {
        try {
            writer.writeDateTime(value.toInstant(ZoneOffset.UTC).toEpochMilli());
        } catch (ArithmeticException e) {
            throw new CodecConfigurationException(String.format("Unsupported LocalDateTime value '%s' could not be converted to milliseconds: %s", value, e.getMessage()), e);
        }
    }

    @Override // org.bson.codecs.Encoder
    public Class<LocalDateTime> getEncoderClass() {
        return LocalDateTime.class;
    }
}
