package org.bson.codecs;

import org.bson.BsonMinKey;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonMinKeyCodec.class */
public class BsonMinKeyCodec implements Codec<BsonMinKey> {
    public void encode(BsonWriter writer, BsonMinKey value, EncoderContext encoderContext) {
        writer.writeMinKey();
    }

    @Override // org.bson.codecs.Decoder
    public BsonMinKey decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readMinKey();
        return new BsonMinKey();
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonMinKey> getEncoderClass() {
        return BsonMinKey.class;
    }
}
