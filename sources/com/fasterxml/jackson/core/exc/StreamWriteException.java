package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/exc/StreamWriteException.class */
public abstract class StreamWriteException extends JsonProcessingException {
    private static final long serialVersionUID = 2;
    protected transient JsonGenerator _processor;

    public abstract StreamWriteException withGenerator(JsonGenerator jsonGenerator);

    /* access modifiers changed from: protected */
    public StreamWriteException(Throwable rootCause, JsonGenerator g) {
        super(rootCause);
        this._processor = g;
    }

    /* access modifiers changed from: protected */
    public StreamWriteException(String msg, JsonGenerator g) {
        super(msg, (JsonLocation) null);
        this._processor = g;
    }

    /* access modifiers changed from: protected */
    public StreamWriteException(String msg, Throwable rootCause, JsonGenerator g) {
        super(msg, null, rootCause);
        this._processor = g;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, com.fasterxml.jackson.core.JacksonException
    public JsonGenerator getProcessor() {
        return this._processor;
    }
}
