package org.bson.codecs;

import org.bson.BsonBoolean;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonBooleanCodec.class */
public class BsonBooleanCodec implements Codec<BsonBoolean> {
    @Override // org.bson.codecs.Decoder
    public BsonBoolean decode(BsonReader reader, DecoderContext decoderContext) {
        return BsonBoolean.valueOf(reader.readBoolean());
    }

    public void encode(BsonWriter writer, BsonBoolean value, EncoderContext encoderContext) {
        writer.writeBoolean(value.getValue());
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonBoolean> getEncoderClass() {
        return BsonBoolean.class;
    }
}
