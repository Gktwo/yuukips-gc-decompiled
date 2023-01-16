package org.bson.codecs;

import org.bson.BsonInvalidOperationException;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/ShortCodec.class */
public class ShortCodec implements Codec<Short> {
    public void encode(BsonWriter writer, Short value, EncoderContext encoderContext) {
        writer.writeInt32(value.shortValue());
    }

    @Override // org.bson.codecs.Decoder
    public Short decode(BsonReader reader, DecoderContext decoderContext) {
        int value = NumberCodecHelper.decodeInt(reader);
        if (value >= -32768 && value <= 32767) {
            return Short.valueOf((short) value);
        }
        throw new BsonInvalidOperationException(String.format("%s can not be converted into a Short.", Integer.valueOf(value)));
    }

    @Override // org.bson.codecs.Encoder
    public Class<Short> getEncoderClass() {
        return Short.class;
    }
}
