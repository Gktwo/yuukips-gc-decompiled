package com.fasterxml.jackson.core.async;

import java.io.IOException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/async/ByteArrayFeeder.class */
public interface ByteArrayFeeder extends NonBlockingInputFeeder {
    void feedInput(byte[] bArr, int i, int i2) throws IOException;
}
