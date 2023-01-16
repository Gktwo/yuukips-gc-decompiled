package org.bson;

import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.p022io.BsonInputMark;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/RawBsonValueHelper.class */
public final class RawBsonValueHelper {
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());

    /* access modifiers changed from: package-private */
    public static BsonValue decode(byte[] bytes, BsonBinaryReader bsonReader) {
        if (bsonReader.getCurrentBsonType() != BsonType.DOCUMENT && bsonReader.getCurrentBsonType() != BsonType.ARRAY) {
            return (BsonValue) REGISTRY.get(BsonValueCodecProvider.getClassForBsonType(bsonReader.getCurrentBsonType())).decode(bsonReader, DecoderContext.builder().build());
        }
        int position = bsonReader.getBsonInput().getPosition();
        BsonInputMark mark = bsonReader.getBsonInput().getMark(4);
        int size = bsonReader.getBsonInput().readInt32();
        mark.reset();
        bsonReader.skipValue();
        if (bsonReader.getCurrentBsonType() == BsonType.DOCUMENT) {
            return new RawBsonDocument(bytes, position, size);
        }
        return new RawBsonArray(bytes, position, size);
    }

    private RawBsonValueHelper() {
    }
}
