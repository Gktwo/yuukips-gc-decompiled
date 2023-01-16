package com.fasterxml.jackson.core.async;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/async/NonBlockingInputFeeder.class */
public interface NonBlockingInputFeeder {
    boolean needMoreInput();

    void endOfInput();
}
