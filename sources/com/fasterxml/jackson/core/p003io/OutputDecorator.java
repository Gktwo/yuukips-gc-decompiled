package com.fasterxml.jackson.core.p003io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* renamed from: com.fasterxml.jackson.core.io.OutputDecorator */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/io/OutputDecorator.class */
public abstract class OutputDecorator implements Serializable {
    public abstract OutputStream decorate(IOContext iOContext, OutputStream outputStream) throws IOException;

    public abstract Writer decorate(IOContext iOContext, Writer writer) throws IOException;
}
