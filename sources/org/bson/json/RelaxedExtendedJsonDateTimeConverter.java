package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/RelaxedExtendedJsonDateTimeConverter.class */
public class RelaxedExtendedJsonDateTimeConverter implements Converter<Long> {
    private static final Converter<Long> FALLBACK_CONVERTER = new ExtendedJsonDateTimeConverter();
    private static final long LAST_MS_OF_YEAR_9999 = 253402300799999L;

    public void convert(Long value, StrictJsonWriter writer) {
        if (value.longValue() < 0 || value.longValue() > 253402300799999L) {
            FALLBACK_CONVERTER.convert(value, writer);
            return;
        }
        writer.writeStartObject();
        writer.writeString("$date", DateTimeFormatter.format(value.longValue()));
        writer.writeEndObject();
    }
}
