package org.bson.json;

import org.bson.BsonMinKey;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonMinKeyConverter.class */
public class ExtendedJsonMinKeyConverter implements Converter<BsonMinKey> {
    public void convert(BsonMinKey value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeNumber("$minKey", "1");
        writer.writeEndObject();
    }
}
