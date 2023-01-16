package org.bson.json;

import org.bson.types.ObjectId;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonObjectIdConverter.class */
public class ExtendedJsonObjectIdConverter implements Converter<ObjectId> {
    public void convert(ObjectId value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeString("$oid", value.toHexString());
        writer.writeEndObject();
    }
}
