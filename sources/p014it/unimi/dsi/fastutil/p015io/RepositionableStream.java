package p014it.unimi.dsi.fastutil.p015io;

import java.io.IOException;

/* renamed from: it.unimi.dsi.fastutil.io.RepositionableStream */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/RepositionableStream.class */
public interface RepositionableStream {
    void position(long j) throws IOException;

    long position() throws IOException;
}
