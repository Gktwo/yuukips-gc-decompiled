package org.bson.codecs;

import org.bson.BsonInvalidOperationException;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/ByteCodec.class */
public class ByteCodec implements Codec<Byte> {
    public void encode(BsonWriter writer, Byte value, EncoderContext encoderContext) {
        writer.writeInt32(value.byteValue());
    }

    @Override // org.bson.codecs.Decoder
    public Byte decode(BsonReader reader, DecoderContext decoderContext) {
        int value = NumberCodecHelper.decodeInt(reader);
        if (value >= -128 && value <= 127) {
            return Byte.valueOf((byte) value);
        }
        throw new BsonInvalidOperationException(String.format("%s can not be converted into a Byte.", Integer.valueOf(value)));
    }

    @Override // org.bson.codecs.Encoder
    public Class<Byte> getEncoderClass() {
        return Byte.class;
    }
}
