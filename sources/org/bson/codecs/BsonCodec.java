package org.bson.codecs;

import org.bson.BsonDocument;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonCodec.class */
public class BsonCodec implements Codec<Bson> {
    private static final Codec<BsonDocument> BSON_DOCUMENT_CODEC = new BsonDocumentCodec();
    private final CodecRegistry registry;

    public BsonCodec(CodecRegistry registry) {
        this.registry = registry;
    }

    @Override // org.bson.codecs.Decoder
    public Bson decode(BsonReader reader, DecoderContext decoderContext) {
        throw new UnsupportedOperationException("The BsonCodec can only encode to Bson");
    }

    public void encode(BsonWriter writer, Bson value, EncoderContext encoderContext) {
        try {
            BSON_DOCUMENT_CODEC.encode(writer, value.toBsonDocument(BsonDocument.class, this.registry), encoderContext);
        } catch (Exception e) {
            throw new CodecConfigurationException(String.format("Unable to encode a Bson implementation: %s", value), e);
        }
    }

    @Override // org.bson.codecs.Encoder
    public Class<Bson> getEncoderClass() {
        return Bson.class;
    }
}
