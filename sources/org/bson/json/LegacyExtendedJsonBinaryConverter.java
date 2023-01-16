package org.bson.json;

import org.bson.BsonBinary;
import org.bson.internal.Base64;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/LegacyExtendedJsonBinaryConverter.class */
public class LegacyExtendedJsonBinaryConverter implements Converter<BsonBinary> {
    public void convert(BsonBinary value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeString("$binary", Base64.encode(value.getData()));
        writer.writeString("$type", String.format("%02X", Byte.valueOf(value.getType())));
        writer.writeEndObject();
    }
}
