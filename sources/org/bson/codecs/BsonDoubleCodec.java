package org.bson.codecs;

import org.bson.BsonDouble;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonDoubleCodec.class */
public class BsonDoubleCodec implements Codec<BsonDouble> {
    @Override // org.bson.codecs.Decoder
    public BsonDouble decode(BsonReader reader, DecoderContext decoderContext) {
        return new BsonDouble(reader.readDouble());
    }

    public void encode(BsonWriter writer, BsonDouble value, EncoderContext encoderContext) {
        writer.writeDouble(value.getValue());
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonDouble> getEncoderClass() {
        return BsonDouble.class;
    }
}
