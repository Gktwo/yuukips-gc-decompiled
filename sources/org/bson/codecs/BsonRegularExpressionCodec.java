package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonRegularExpression;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonRegularExpressionCodec.class */
public class BsonRegularExpressionCodec implements Codec<BsonRegularExpression> {
    @Override // org.bson.codecs.Decoder
    public BsonRegularExpression decode(BsonReader reader, DecoderContext decoderContext) {
        return reader.readRegularExpression();
    }

    public void encode(BsonWriter writer, BsonRegularExpression value, EncoderContext encoderContext) {
        writer.writeRegularExpression(value);
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonRegularExpression> getEncoderClass() {
        return BsonRegularExpression.class;
    }
}
