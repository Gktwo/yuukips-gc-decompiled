package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonStringConverter.class */
public class JsonStringConverter implements Converter<String> {
    public void convert(String value, StrictJsonWriter writer) {
        writer.writeString(value);
    }
}
