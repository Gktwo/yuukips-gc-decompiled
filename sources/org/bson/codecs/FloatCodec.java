package org.bson.codecs;

import org.bson.BsonInvalidOperationException;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/FloatCodec.class */
public class FloatCodec implements Codec<Float> {
    public void encode(BsonWriter writer, Float value, EncoderContext encoderContext) {
        writer.writeDouble((double) value.floatValue());
    }

    @Override // org.bson.codecs.Decoder
    public Float decode(BsonReader reader, DecoderContext decoderContext) {
        double value = NumberCodecHelper.decodeDouble(reader);
        if (value >= -3.4028234663852886E38d && value <= 3.4028234663852886E38d) {
            return Float.valueOf((float) value);
        }
        throw new BsonInvalidOperationException(String.format("%s can not be converted into a Float.", Double.valueOf(value)));
    }

    @Override // org.bson.codecs.Encoder
    public Class<Float> getEncoderClass() {
        return Float.class;
    }
}
