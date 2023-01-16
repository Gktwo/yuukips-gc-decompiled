package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonTimestamp;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonTimestampCodec.class */
public class BsonTimestampCodec implements Codec<BsonTimestamp> {
    public void encode(BsonWriter writer, BsonTimestamp value, EncoderContext encoderContext) {
        writer.writeTimestamp(value);
    }

    @Override // org.bson.codecs.Decoder
    public BsonTimestamp decode(BsonReader reader, DecoderContext decoderContext) {
        return reader.readTimestamp();
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonTimestamp> getEncoderClass() {
        return BsonTimestamp.class;
    }
}
