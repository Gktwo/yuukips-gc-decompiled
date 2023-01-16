package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@JacksonStdImpl
/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ser/std/DateSerializer.class */
public class DateSerializer extends DateTimeSerializerBase<Date> {
    public static final DateSerializer instance = new DateSerializer();

    public DateSerializer() {
        this(null, null);
    }

    public DateSerializer(Boolean useTimestamp, DateFormat customFormat) {
        super(Date.class, useTimestamp, customFormat);
    }

    /* Return type fixed from 'com.fasterxml.jackson.databind.ser.std.DateSerializer' to match base method */
    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    public DateTimeSerializerBase<Date> withFormat(Boolean timestamp, DateFormat customFormat) {
        return new DateSerializer(timestamp, customFormat);
    }

    /* access modifiers changed from: protected */
    public long _timestamp(Date value) {
        if (value == null) {
            return 0;
        }
        return value.getTime();
    }

    public void serialize(Date value, JsonGenerator g, SerializerProvider provider) throws IOException {
        if (_asTimestamp(provider)) {
            g.writeNumber(_timestamp(value));
        } else {
            _serializeAsString(value, g, provider);
        }
    }
}
