package org.bson.json;

import org.bson.BsonUndefined;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ExtendedJsonUndefinedConverter.class */
public class ExtendedJsonUndefinedConverter implements Converter<BsonUndefined> {
    public void convert(BsonUndefined value, StrictJsonWriter writer) {
        writer.writeStartObject();
        writer.writeBoolean("$undefined", true);
        writer.writeEndObject();
    }
}
