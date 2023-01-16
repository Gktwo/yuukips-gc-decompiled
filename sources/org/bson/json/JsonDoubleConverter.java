package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonDoubleConverter.class */
public class JsonDoubleConverter implements Converter<Double> {
    public void convert(Double value, StrictJsonWriter writer) {
        writer.writeNumber(Double.toString(value.doubleValue()));
    }
}
