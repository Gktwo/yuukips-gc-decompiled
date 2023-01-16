package org.bson.json;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/DateTimeFormatter.class */
public final class DateTimeFormatter {
    private static final int DATE_STRING_LENGTH = "1970-01-01".length();

    /* access modifiers changed from: package-private */
    public static long parse(String dateTimeString) {
        if (dateTimeString.length() == DATE_STRING_LENGTH) {
            return LocalDate.parse(dateTimeString, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        }
        return ((Instant) java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(dateTimeString, new TemporalQuery<Instant>() { // from class: org.bson.json.DateTimeFormatter.1
            @Override // java.time.temporal.TemporalQuery
            public Instant queryFrom(TemporalAccessor temporal) {
                return Instant.from(temporal);
            }
        })).toEpochMilli();
    }

    /* access modifiers changed from: package-private */
    public static String format(long dateTime) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateTime), ZoneId.of("Z")).format(java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    private DateTimeFormatter() {
    }
}
