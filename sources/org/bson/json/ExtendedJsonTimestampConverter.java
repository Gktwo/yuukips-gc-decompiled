package org.bson.json;

import org.bson.BsonTimestamp;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonTimestampConverter.class */
public class ExtendedJsonTimestampConverter implements Converter<BsonTimestamp> {
    public void convert(BsonTimestamp value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeStartObject("$timestamp");
        writer.writeNumber("t", Long.toUnsignedString(Integer.toUnsignedLong(value.getTime())));
        writer.writeNumber(IntegerTokenConverter.CONVERTER_KEY, Long.toUnsignedString(Integer.toUnsignedLong(value.getInc())));
        writer.writeEndObject();
        writer.writeEndObject();
    }
}
