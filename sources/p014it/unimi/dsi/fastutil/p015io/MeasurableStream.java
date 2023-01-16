package p014it.unimi.dsi.fastutil.p015io;

import java.io.IOException;

/* renamed from: it.unimi.dsi.fastutil.io.MeasurableStream */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/MeasurableStream.class */
public interface MeasurableStream {
    long length() throws IOException;

    @Override // p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    long position() throws IOException;
}
