package dev.morphia.mapping.codec;

import java.util.Collection;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaCollectionCodec.class */
class MorphiaCollectionCodec<T> extends CollectionCodec<T> {
    /* access modifiers changed from: package-private */
    public MorphiaCollectionCodec(Codec<T> codec, Class<T> type) {
        super(type, codec);
    }

    @Override // dev.morphia.mapping.codec.CollectionCodec, org.bson.codecs.Decoder
    public Collection<T> decode(BsonReader reader, DecoderContext decoderContext) {
        if (reader.getCurrentBsonType().equals(BsonType.ARRAY)) {
            return decode(reader, decoderContext);
        }
        Collection<T> collection = getInstance();
        collection.add(getCodec().decode(reader, decoderContext));
        return collection;
    }
}
