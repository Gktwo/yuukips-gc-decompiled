package org.bson.json;

import org.bson.BsonMaxKey;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellMaxKeyConverter.class */
public class ShellMaxKeyConverter implements Converter<BsonMaxKey> {
    public void convert(BsonMaxKey value, StrictJsonWriter writer) {
        writer.writeRaw("MaxKey");
    }
}
