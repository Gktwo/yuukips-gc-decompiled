package org.bson.codecs;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.BsonReader;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonDocumentWrapperCodec.class */
public class BsonDocumentWrapperCodec implements Codec<BsonDocumentWrapper> {
    private final Codec<BsonDocument> bsonDocumentCodec;

    public BsonDocumentWrapperCodec(Codec<BsonDocument> bsonDocumentCodec) {
        this.bsonDocumentCodec = bsonDocumentCodec;
    }

    @Override // org.bson.codecs.Decoder
    public BsonDocumentWrapper decode(BsonReader reader, DecoderContext decoderContext) {
        throw new UnsupportedOperationException("Decoding into a BsonDocumentWrapper is not allowed");
    }

    public void encode(BsonWriter writer, BsonDocumentWrapper value, EncoderContext encoderContext) {
        if (value.isUnwrapped()) {
            this.bsonDocumentCodec.encode(writer, value, encoderContext);
        } else {
            value.getEncoder().encode(writer, value.getWrappedDocument(), encoderContext);
        }
    }

    @Override // org.bson.codecs.Encoder
    public Class<BsonDocumentWrapper> getEncoderClass() {
        return BsonDocumentWrapper.class;
    }
}
