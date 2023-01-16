package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/RelaxedExtendedJsonInt64Converter.class */
public class RelaxedExtendedJsonInt64Converter implements Converter<Long> {
    public void convert(Long value, StrictJsonWriter writer) {
        writer.writeNumber(Long.toString(value.longValue()));
    }
}
