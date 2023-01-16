package org.bson.codecs;

import org.bson.BsonDbPointer;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonDBPointerCodec.class */
public class BsonDBPointerCodec implements Codec<BsonDbPointer> {
    @Override // org.bson.codecs.Decoder
    public BsonDbPointer decode(BsonReader reader, DecoderContext decoderContext) {
        return reader.readDBPointer();
    }

    public void encode(BsonWriter writer, BsonDbPointer value, EncoderContext encoderContext) {
        writer.writeDBPointer(value);
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonDbPointer> getEncoderClass() {
        return BsonDbPointer.class;
    }
}
