package org.bson.json;

import org.bson.BsonBinary;
import org.bson.internal.Base64;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellBinaryConverter.class */
public class ShellBinaryConverter implements Converter<BsonBinary> {
    public void convert(BsonBinary value, StrictJsonWriter writer) {
        writer.writeRaw(String.format("new BinData(%s, \"%s\")", Integer.toString(value.getType() & 255), Base64.encode(value.getData())));
    }
}
