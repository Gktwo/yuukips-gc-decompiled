package org.bson.json;

import org.bson.BsonTimestamp;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellTimestampConverter.class */
public class ShellTimestampConverter implements Converter<BsonTimestamp> {
    public void convert(BsonTimestamp value, StrictJsonWriter writer) {
        writer.writeRaw(String.format("Timestamp(%d, %d)", Integer.valueOf(value.getTime()), Integer.valueOf(value.getInc())));
    }
}
