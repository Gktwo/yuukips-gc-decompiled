package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellInt64Converter.class */
public class ShellInt64Converter implements Converter<Long> {
    public void convert(Long value, StrictJsonWriter writer) {
        if (value.longValue() < -2147483648L || value.longValue() > 2147483647L) {
            writer.writeRaw(String.format("NumberLong(\"%d\")", value));
        } else {
            writer.writeRaw(String.format("NumberLong(%d)", value));
        }
    }
}
