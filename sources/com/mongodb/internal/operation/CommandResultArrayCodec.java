package com.mongodb.internal.operation;

import java.util.ArrayList;
import java.util.List;
import org.bson.BsonArray;
import org.bson.BsonDocumentWrapper;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.codecs.BsonArrayCodec;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CommandResultArrayCodec.class */
class CommandResultArrayCodec<T> extends BsonArrayCodec {
    private final Decoder<T> decoder;

    /* access modifiers changed from: package-private */
    public CommandResultArrayCodec(CodecRegistry registry, Decoder<T> decoder) {
        super(registry);
        this.decoder = decoder;
    }

    @Override // org.bson.codecs.BsonArrayCodec, org.bson.codecs.Decoder
    public BsonArray decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readStartArray();
        List<T> list = new ArrayList<>();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            if (reader.getCurrentBsonType() == BsonType.NULL) {
                reader.readNull();
                list.add(null);
            } else {
                list.add(this.decoder.decode(reader, decoderContext));
            }
        }
        reader.readEndArray();
        return new BsonArrayWrapper(list);
    }

    /* access modifiers changed from: protected */
    @Override // org.bson.codecs.BsonArrayCodec
    public BsonValue readValue(BsonReader reader, DecoderContext decoderContext) {
        if (reader.getCurrentBsonType() == BsonType.DOCUMENT) {
            return new BsonDocumentWrapper(this.decoder.decode(reader, decoderContext), null);
        }
        return readValue(reader, decoderContext);
    }
}
