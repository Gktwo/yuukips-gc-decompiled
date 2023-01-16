package org.bson.json;

import org.bson.BsonRegularExpression;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonRegularExpressionConverter.class */
public class ExtendedJsonRegularExpressionConverter implements Converter<BsonRegularExpression> {
    public void convert(BsonRegularExpression value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeStartObject("$regularExpression");
        writer.writeString("pattern", value.getPattern());
        writer.writeString("options", value.getOptions());
        writer.writeEndObject();
        writer.writeEndObject();
    }
}
