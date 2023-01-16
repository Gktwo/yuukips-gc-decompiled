package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonStringCodec.class */
public class BsonStringCodec implements Codec<BsonString> {
    @Override // org.bson.codecs.Decoder
    public BsonString decode(BsonReader reader, DecoderContext decoderContext) {
        return new BsonString(reader.readString());
    }

    public void encode(BsonWriter writer, BsonString value, EncoderContext encoderContext) {
        writer.writeString(value.getValue());
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonString> getEncoderClass() {
        return BsonString.class;
    }
}
