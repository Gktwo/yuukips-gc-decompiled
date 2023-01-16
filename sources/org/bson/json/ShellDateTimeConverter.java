package org.bson.json;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/ShellDateTimeConverter.class */
public class ShellDateTimeConverter implements Converter<Long> {
    public void convert(Long value, StrictJsonWriter writer) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (value.longValue() < -59014396800000L || value.longValue() > 253399536000000L) {
            writer.writeRaw(String.format("new Date(%d)", value));
        } else {
            writer.writeRaw(String.format("ISODate(\"%s\")", dateFormat.format(new Date(value.longValue()))));
        }
    }
}
