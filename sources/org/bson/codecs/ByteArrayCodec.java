package org.bson.codecs;

import org.bson.BsonBinary;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/ByteArrayCodec.class */
public class ByteArrayCodec implements Codec<byte[]> {
    public void encode(BsonWriter writer, byte[] value, EncoderContext encoderContext) {
        writer.writeBinaryData(new BsonBinary(value));
    }

    @Override // org.bson.codecs.Decoder
    public byte[] decode(BsonReader reader, DecoderContext decoderContext) {
        return reader.readBinaryData().getData();
    }

    @Override // org.bson.codecs.Encoder
    public Class<byte[]> getEncoderClass() {
        return byte[].class;
    }
}
