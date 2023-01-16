package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonInt32Converter.class */
public class ExtendedJsonInt32Converter implements Converter<Integer> {
    public void convert(Integer value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeName("$numberInt");
        writer.writeString(Integer.toString(value.intValue()));
        writer.writeEndObject();
    }
}
