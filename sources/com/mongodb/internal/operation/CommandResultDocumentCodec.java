package com.mongodb.internal.operation;

import java.util.Collections;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Codec;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandResultDocumentCodec.class */
public class CommandResultDocumentCodec<T> extends BsonDocumentCodec {
    private final Decoder<T> payloadDecoder;
    private final List<String> fieldsContainingPayload;

    /* access modifiers changed from: package-private */
    public CommandResultDocumentCodec(CodecRegistry registry, Decoder<T> payloadDecoder, List<String> fieldsContainingPayload) {
        super(registry);
        this.payloadDecoder = payloadDecoder;
        this.fieldsContainingPayload = fieldsContainingPayload;
    }

    /* access modifiers changed from: package-private */
    public static <P> Codec<BsonDocument> create(Decoder<P> decoder, String fieldContainingPayload) {
        return create(decoder, Collections.singletonList(fieldContainingPayload));
    }

    /* access modifiers changed from: package-private */
    public static <P> Codec<BsonDocument> create(Decoder<P> decoder, List<String> fieldsContainingPayload) {
        return CodecRegistries.fromProviders(new CommandResultCodecProvider(decoder, fieldsContainingPayload)).get(BsonDocument.class);
    }

    /* access modifiers changed from: protected */
    @Override // org.bson.codecs.BsonDocumentCodec
    public BsonValue readValue(BsonReader reader, DecoderContext decoderContext) {
        if (this.fieldsContainingPayload.contains(reader.getCurrentName())) {
            if (reader.getCurrentBsonType() == BsonType.DOCUMENT) {
                return new BsonDocumentWrapper(this.payloadDecoder.decode(reader, decoderContext), null);
            }
            if (reader.getCurrentBsonType() == BsonType.ARRAY) {
                return new CommandResultArrayCodec(getCodecRegistry(), this.payloadDecoder).decode(reader, decoderContext);
            }
        }
        return readValue(reader, decoderContext);
    }
}
