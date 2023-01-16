package org.bson.json;

import org.bson.BsonNull;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonNullConverter.class */
public class JsonNullConverter implements Converter<BsonNull> {
    public void convert(BsonNull value, StrictJsonWriter writer) {
        writer.writeNull();
    }
}
