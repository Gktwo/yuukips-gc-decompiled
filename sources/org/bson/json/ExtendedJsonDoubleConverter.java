package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonDoubleConverter.class */
public class ExtendedJsonDoubleConverter implements Converter<Double> {
    public void convert(Double value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeName("$numberDouble");
        writer.writeString(Double.toString(value.doubleValue()));
        writer.writeEndObject();
    }
}
