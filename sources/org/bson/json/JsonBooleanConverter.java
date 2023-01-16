package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonBooleanConverter.class */
public class JsonBooleanConverter implements Converter<Boolean> {
    public void convert(Boolean value, StrictJsonWriter writer) {
        writer.writeBoolean(value.booleanValue());
    }
}
