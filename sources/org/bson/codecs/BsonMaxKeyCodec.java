package org.bson.codecs;

import org.bson.BsonMaxKey;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonMaxKeyCodec.class */
public class BsonMaxKeyCodec implements Codec<BsonMaxKey> {
    public void encode(BsonWriter writer, BsonMaxKey value, EncoderContext encoderContext) {
        writer.writeMaxKey();
    }

    @Override // org.bson.codecs.Decoder
    public BsonMaxKey decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readMaxKey();
        return new BsonMaxKey();
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonMaxKey> getEncoderClass() {
        return BsonMaxKey.class;
    }
}
