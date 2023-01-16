package org.bson.json;

import org.bson.BsonUndefined;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellUndefinedConverter.class */
public class ShellUndefinedConverter implements Converter<BsonUndefined> {
    public void convert(BsonUndefined value, StrictJsonWriter writer) {
        writer.writeRaw("undefined");
    }
}
