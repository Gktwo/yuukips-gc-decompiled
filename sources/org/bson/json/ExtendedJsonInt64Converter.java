package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonInt64Converter.class */
public class ExtendedJsonInt64Converter implements Converter<Long> {
    public void convert(Long value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeName("$numberLong");
        writer.writeString(Long.toString(value.longValue()));
        writer.writeEndObject();
    }
}
