package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonJavaScriptConverter.class */
public class JsonJavaScriptConverter implements Converter<String> {
    public void convert(String value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeString("$code", value);
        writer.writeEndObject();
    }
}
