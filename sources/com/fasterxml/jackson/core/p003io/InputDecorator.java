package com.fasterxml.jackson.core.p003io;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/* renamed from: com.fasterxml.jackson.core.io.InputDecorator */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/io/InputDecorator.class */
public abstract class InputDecorator implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract InputStream decorate(IOContext iOContext, InputStream inputStream) throws IOException;

    public abstract InputStream decorate(IOContext iOContext, byte[] bArr, int i, int i2) throws IOException;

    public abstract Reader decorate(IOContext iOContext, Reader reader) throws IOException;

    public DataInput decorate(IOContext ctxt, DataInput input) throws IOException {
        throw new UnsupportedOperationException();
    }
}
