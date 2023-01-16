package org.bson.json;

import org.bson.types.Decimal128;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonDecimal128Converter.class */
public class ExtendedJsonDecimal128Converter implements Converter<Decimal128> {
    public void convert(Decimal128 value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeName("$numberDecimal");
        writer.writeString(value.toString());
        writer.writeEndObject();
    }
}
