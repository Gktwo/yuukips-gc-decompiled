package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BooleanCodec.class */
public class BooleanCodec implements Codec<Boolean> {
    public void encode(BsonWriter writer, Boolean value, EncoderContext encoderContext) {
        writer.writeBoolean(value.booleanValue());
    }

    @Override // org.bson.codecs.Decoder
    public Boolean decode(BsonReader reader, DecoderContext decoderContext) {
        return Boolean.valueOf(reader.readBoolean());
    }

    @Override // org.bson.codecs.Encoder
    public Class<Boolean> getEncoderClass() {
        return Boolean.class;
    }
}
