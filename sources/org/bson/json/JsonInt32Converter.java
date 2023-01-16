package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonInt32Converter.class */
public class JsonInt32Converter implements Converter<Integer> {
    public void convert(Integer value, StrictJsonWriter writer) {
        writer.writeNumber(Integer.toString(value.intValue()));
    }
}
