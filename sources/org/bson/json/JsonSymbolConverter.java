package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonSymbolConverter.class */
public class JsonSymbolConverter implements Converter<String> {
    public void convert(String value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeString("$symbol", value);
        writer.writeEndObject();
    }
}
