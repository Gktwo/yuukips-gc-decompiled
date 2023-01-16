package org.bson.json;

import org.bson.BsonRegularExpression;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/LegacyExtendedJsonRegularExpressionConverter.class */
public class LegacyExtendedJsonRegularExpressionConverter implements Converter<BsonRegularExpression> {
    public void convert(BsonRegularExpression value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeString("$regex", value.getPattern());
        writer.writeString("$options", value.getOptions());
        writer.writeEndObject();
    }
}
