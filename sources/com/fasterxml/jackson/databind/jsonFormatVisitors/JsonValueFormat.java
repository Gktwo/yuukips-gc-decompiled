package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.annotation.JsonValue;
import org.jline.console.Printer;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormat.class */
public enum JsonValueFormat {
    COLOR("color"),
    DATE("date"),
    DATE_TIME("date-time"),
    EMAIL("email"),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE("phone"),
    REGEX("regex"),
    STYLE(Printer.STYLE),
    TIME("time"),
    URI("uri"),
    UTC_MILLISEC("utc-millisec"),
    UUID("uuid");
    
    private final String _desc;

    JsonValueFormat(String desc) {
        this._desc = desc;
    }

    @Override // java.lang.Enum, java.lang.Object
    @JsonValue
    public String toString() {
        return this._desc;
    }
}
