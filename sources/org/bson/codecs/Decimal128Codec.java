package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.types.Decimal128;

/* loaded from: grasscutter.jar:org/bson/codecs/Decimal128Codec.class */
public final class Decimal128Codec implements Codec<Decimal128> {
    @Override // org.bson.codecs.Decoder
    public Decimal128 decode(BsonReader reader, DecoderContext decoderContext) {
        return reader.readDecimal128();
    }

    public void encode(BsonWriter writer, Decimal128 value, EncoderContext encoderContext) {
        writer.writeDecimal128(value);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Decimal128> getEncoderClass() {
        return Decimal128.class;
    }
}
