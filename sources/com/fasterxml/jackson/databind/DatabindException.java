package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/DatabindException.class */
public abstract class DatabindException extends JsonProcessingException {
    private static final long serialVersionUID = 3;

    public abstract void prependPath(Object obj, String str);

    public abstract void prependPath(Object obj, int i);

    /* access modifiers changed from: protected */
    public DatabindException(String msg, JsonLocation loc, Throwable rootCause) {
        super(msg, loc, rootCause);
    }

    /* access modifiers changed from: protected */
    public DatabindException(String msg) {
        super(msg);
    }

    /* access modifiers changed from: protected */
    public DatabindException(String msg, JsonLocation loc) {
        this(msg, loc, null);
    }

    /* access modifiers changed from: protected */
    public DatabindException(String msg, Throwable rootCause) {
        this(msg, null, rootCause);
    }
}
