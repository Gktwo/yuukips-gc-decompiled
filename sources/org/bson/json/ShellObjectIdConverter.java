package org.bson.json;

import org.bson.types.ObjectId;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellObjectIdConverter.class */
public class ShellObjectIdConverter implements Converter<ObjectId> {
    public void convert(ObjectId value, StrictJsonWriter writer) {
        writer.writeRaw(String.format("ObjectId(\"%s\")", value.toHexString()));
    }
}
