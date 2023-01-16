package org.bson.json;

import org.bson.BsonRegularExpression;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellRegularExpressionConverter.class */
public class ShellRegularExpressionConverter implements Converter<BsonRegularExpression> {
    public void convert(BsonRegularExpression value, StrictJsonWriter writer) {
        writer.writeRaw("/" + (value.getPattern().equals("") ? "(?:)" : value.getPattern().replace("/", "\\/")) + "/" + value.getOptions());
    }
}
