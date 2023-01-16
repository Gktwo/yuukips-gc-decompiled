package com.fasterxml.jackson.core;

import java.io.IOException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/JacksonException.class */
public abstract class JacksonException extends IOException {
    private static final long serialVersionUID = 123;

    public abstract JsonLocation getLocation();

    public abstract String getOriginalMessage();

    public abstract Object getProcessor();

    /* access modifiers changed from: protected */
    public JacksonException(String msg) {
        super(msg);
    }

    protected JacksonException(Throwable t) {
        super(t);
    }

    /* access modifiers changed from: protected */
    public JacksonException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }
}
