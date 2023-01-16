package org.bson.codecs;

import org.bson.BsonJavaScript;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonJavaScriptCodec.class */
public class BsonJavaScriptCodec implements Codec<BsonJavaScript> {
    @Override // org.bson.codecs.Decoder
    public BsonJavaScript decode(BsonReader reader, DecoderContext decoderContext) {
        return new BsonJavaScript(reader.readJavaScript());
    }

    public void encode(BsonWriter writer, BsonJavaScript value, EncoderContext encoderContext) {
        writer.writeJavaScript(value.getCode());
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonJavaScript> getEncoderClass() {
        return BsonJavaScript.class;
    }
}
