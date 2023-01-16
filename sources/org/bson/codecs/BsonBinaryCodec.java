package org.bson.codecs;

import org.bson.BsonBinary;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonBinaryCodec.class */
public class BsonBinaryCodec implements Codec<BsonBinary> {
    public void encode(BsonWriter writer, BsonBinary value, EncoderContext encoderContext) {
        writer.writeBinaryData(value);
    }

    @Override // org.bson.codecs.Decoder
    public BsonBinary decode(BsonReader reader, DecoderContext decoderContext) {
        return reader.readBinaryData();
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonBinary> getEncoderClass() {
        return BsonBinary.class;
    }
}
