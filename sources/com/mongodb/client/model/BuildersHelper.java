package com.mongodb.client.model;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/BuildersHelper.class */
final class BuildersHelper {
    /* access modifiers changed from: package-private */
    public static <TItem> void encodeValue(BsonDocumentWriter writer, TItem value, CodecRegistry codecRegistry) {
        if (value == null) {
            writer.writeNull();
        } else if (value instanceof Bson) {
            codecRegistry.get(BsonDocument.class).encode(writer, ((Bson) value).toBsonDocument(BsonDocument.class, codecRegistry), EncoderContext.builder().build());
        } else {
            codecRegistry.get(value.getClass()).encode(writer, value, EncoderContext.builder().build());
        }
    }

    private BuildersHelper() {
    }
}
