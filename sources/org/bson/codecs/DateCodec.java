package org.bson.codecs;

import java.util.Date;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/DateCodec.class */
public class DateCodec implements Codec<Date> {
    public void encode(BsonWriter writer, Date value, EncoderContext encoderContext) {
        writer.writeDateTime(value.getTime());
    }

    @Override // org.bson.codecs.Decoder
    public Date decode(BsonReader reader, DecoderContext decoderContext) {
        return new Date(reader.readDateTime());
    }

    @Override // org.bson.codecs.Encoder
    public Class<Date> getEncoderClass() {
        return Date.class;
    }
}
