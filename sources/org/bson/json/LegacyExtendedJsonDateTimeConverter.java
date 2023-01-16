package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/LegacyExtendedJsonDateTimeConverter.class */
public class LegacyExtendedJsonDateTimeConverter implements Converter<Long> {
    public void convert(Long value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeNumber("$date", Long.toString(value.longValue()));
        writer.writeEndObject();
    }
}
