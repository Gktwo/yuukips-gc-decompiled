package org.bson.codecs;

import java.util.concurrent.atomic.AtomicLong;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/AtomicLongCodec.class */
public class AtomicLongCodec implements Codec<AtomicLong> {
    public void encode(BsonWriter writer, AtomicLong value, EncoderContext encoderContext) {
        writer.writeInt64(value.longValue());
    }

    @Override // org.bson.codecs.Decoder
    public AtomicLong decode(BsonReader reader, DecoderContext decoderContext) {
        return new AtomicLong(NumberCodecHelper.decodeLong(reader));
    }

    @Override // org.bson.codecs.Encoder
    public Class<AtomicLong> getEncoderClass() {
        return AtomicLong.class;
    }
}
