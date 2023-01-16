package com.fasterxml.jackson.core.p003io;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.fasterxml.jackson.core.io.DataOutputAsStream */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/io/DataOutputAsStream.class */
public class DataOutputAsStream extends OutputStream {
    protected final DataOutput _output;

    public DataOutputAsStream(DataOutput out) {
        this._output = out;
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this._output.write(b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        this._output.write(b, 0, b.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int offset, int length) throws IOException {
        this._output.write(b, offset, length);
    }
}
