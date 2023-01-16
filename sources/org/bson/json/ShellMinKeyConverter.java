package org.bson.json;

import org.bson.BsonMinKey;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellMinKeyConverter.class */
public class ShellMinKeyConverter implements Converter<BsonMinKey> {
    public void convert(BsonMinKey value, StrictJsonWriter writer) {
        writer.writeRaw("MinKey");
    }
}
