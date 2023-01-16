package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonDateTimeConverter.class */
public class ExtendedJsonDateTimeConverter implements Converter<Long> {
    public void convert(Long value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeStartObject("$date");
        writer.writeString("$numberLong", Long.toString(value.longValue()));
        writer.writeEndObject();
        writer.writeEndObject();
    }
}
