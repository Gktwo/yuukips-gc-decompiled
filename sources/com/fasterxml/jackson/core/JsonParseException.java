package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.util.RequestPayload;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/JsonParseException.class */
public class JsonParseException extends StreamReadException {
    private static final long serialVersionUID = 2;

    @Deprecated
    public JsonParseException(String msg, JsonLocation loc) {
        super(msg, loc, (Throwable) null);
    }

    @Deprecated
    public JsonParseException(String msg, JsonLocation loc, Throwable root) {
        super(msg, loc, root);
    }

    public JsonParseException(JsonParser p, String msg) {
        super(p, msg);
    }

    public JsonParseException(JsonParser p, String msg, Throwable root) {
        super(p, msg, root);
    }

    public JsonParseException(JsonParser p, String msg, JsonLocation loc) {
        super(p, msg, loc);
    }

    public JsonParseException(JsonParser p, String msg, JsonLocation loc, Throwable root) {
        super(msg, loc, root);
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public JsonParseException withParser(JsonParser p) {
        this._processor = p;
        return this;
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public JsonParseException withRequestPayload(RequestPayload payload) {
        this._requestPayload = payload;
        return this;
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException, com.fasterxml.jackson.core.JacksonException
    public JsonParser getProcessor() {
        return getProcessor();
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public RequestPayload getRequestPayload() {
        return getRequestPayload();
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public String getRequestPayloadAsString() {
        return getRequestPayloadAsString();
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return getMessage();
    }
}
