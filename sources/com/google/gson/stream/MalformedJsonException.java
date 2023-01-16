package com.google.gson.stream;

import java.io.IOException;

/* loaded from: grasscutter.jar:com/google/gson/stream/MalformedJsonException.class */
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(String msg) {
        super(msg);
    }

    public MalformedJsonException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public MalformedJsonException(Throwable throwable) {
        super(throwable);
    }
}
