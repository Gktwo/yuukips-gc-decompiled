package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.types.Code;

/* loaded from: grasscutter.jar:org/bson/codecs/CodeCodec.class */
public class CodeCodec implements Codec<Code> {
    public void encode(BsonWriter writer, Code value, EncoderContext encoderContext) {
        writer.writeJavaScript(value.getCode());
    }

    @Override // org.bson.codecs.Decoder
    public Code decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return new Code(bsonReader.readJavaScript());
    }

    @Override // org.bson.codecs.Encoder
    public Class<Code> getEncoderClass() {
        return Code.class;
    }
}
