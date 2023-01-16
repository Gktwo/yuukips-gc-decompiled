package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonUndefined;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonUndefinedCodec.class */
public class BsonUndefinedCodec implements Codec<BsonUndefined> {
    @Override // org.bson.codecs.Decoder
    public BsonUndefined decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readUndefined();
        return new BsonUndefined();
    }

    public void encode(BsonWriter writer, BsonUndefined value, EncoderContext encoderContext) {
        writer.writeUndefined();
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonUndefined> getEncoderClass() {
        return BsonUndefined.class;
    }
}
