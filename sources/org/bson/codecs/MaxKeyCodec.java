package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.types.MaxKey;

/* loaded from: grasscutter.jar:org/bson/codecs/MaxKeyCodec.class */
public class MaxKeyCodec implements Codec<MaxKey> {
    public void encode(BsonWriter writer, MaxKey value, EncoderContext encoderContext) {
        writer.writeMaxKey();
    }

    @Override // org.bson.codecs.Decoder
    public MaxKey decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readMaxKey();
        return new MaxKey();
    }

    @Override // org.bson.codecs.Encoder
    public Class<MaxKey> getEncoderClass() {
        return MaxKey.class;
    }
}
