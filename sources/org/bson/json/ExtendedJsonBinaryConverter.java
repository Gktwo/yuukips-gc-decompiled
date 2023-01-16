package org.bson.json;

import org.bson.BsonBinary;
import org.bson.internal.Base64;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonBinaryConverter.class */
public class ExtendedJsonBinaryConverter implements Converter<BsonBinary> {
    public void convert(BsonBinary value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeStartObject("$binary");
        writer.writeString("base64", Base64.encode(value.getData()));
        writer.writeString("subType", String.format("%02X", Byte.valueOf(value.getType())));
        writer.writeEndObject();
        writer.writeEndObject();
    }
}
