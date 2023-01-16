package org.bson.json;

import org.bson.BsonMaxKey;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonMaxKeyConverter.class */
public class ExtendedJsonMaxKeyConverter implements Converter<BsonMaxKey> {
    public void convert(BsonMaxKey value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeNumber("$maxKey", "1");
        writer.writeEndObject();
    }
}
